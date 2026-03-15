package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtComboVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.UTILITY.MaintCCARatesBean;
import FCIPAY.Payroll.UTILITY.MaintCCARatesCdaBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
//import IBA.Payroll.DATAACCESSTIER.VO.DummyQuaryVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.EJB.facade.MasterFacade;
import FCIPAY.Payroll.EJB.facade.MasterFacadeHome;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintBadClmtAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintBadClmtAllowDetailInfo;

public class MaintBadClmtAllowBD extends PayrollBaseBD
{
  public MaintBadClmtAllowBD()
  {
  }

   public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
     return null;
  }


  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
      return null;
  }

   public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oMasterFacade = oHome.create();

      String sPayScaleType = "";

      if(sScreenName.equalsIgnoreCase("BadClmtCdaScreen"))
      {
        sPayScaleType = "CDA";
        return oMasterFacade.getBadClmtDetailMetaInfo(sPayScaleType,(MaintBadClmtAllowDetailInfo)oBaseDetailInfo);
      }
      else
      {
        sPayScaleType = "IDA";
        return oMasterFacade.getBadClmtDetailMetaInfo(sPayScaleType,(MaintBadClmtAllowDetailInfo)oBaseDetailInfo);
      }
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);
    }
  }


  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oMasterFacade = oHome.create();
      String sPayScaleType = "";

      if(sScreenName.equalsIgnoreCase("BadClmtCdaScreen"))
      {
        sPayScaleType = "CDA" ;
      }
      else
      {
        sPayScaleType = "IDA";
      }
     return oMasterFacade.getBadClmtDetail(sPayScaleType,lAbsoluteStart,lAbsoluteEnd,(MaintBadClmtAllowDetailInfo)oBaseDetailInfo);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);
    }
  }


   public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      return oPayFacade.saveBadClmtDetail((MaintBadClmtAllowHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
//      return null;
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);
    }

  }


  public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
//      return oSysFacade.saveGlobalCodeHeader((GlobalCodeHeaderBean)oBaseHeaderBean);
      return true;
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);
    }
  }


  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      return oPayFacade.getBadClmtHeaderMetaImpl((BadClmtQueryVO)oQueryVO);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);
    }
  }


  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      return oPayFacade.getBadClmtHeaderRecord((BadClmtQueryVO)oQueryVO,lStartPosition,lLastPosition);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);
    }
  }



  public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      BadClmtComboVO oBadClmtComboVO = oPayFacade.getBadClmtComboDetails();
      if(request.getSession().getAttribute("EmpCtgry")!=null)
      {
        request.getSession().removeAttribute("EmpCtgry");
      }
      request.getSession().setAttribute("EmpCtgry",oBadClmtComboVO);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);
    }
  }
}