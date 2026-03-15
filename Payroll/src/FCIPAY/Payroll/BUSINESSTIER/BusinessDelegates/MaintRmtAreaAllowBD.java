package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaComboVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaAllowQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.UTILITY.RmtAreaAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintRmtAreaAllowDetailInfo;

public class MaintRmtAreaAllowBD extends PayrollBaseBD
{
  public MaintRmtAreaAllowBD()
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();

      String sPayScaleType = "";
      if(sScreenName.equalsIgnoreCase("RmtAreaCdaScreen"))
      {
        sPayScaleType = "CDA";
        return oPayrollFacade.getRmtAreaDetailMetaInfo(sPayScaleType,(MaintRmtAreaAllowDetailInfo)oBaseDetailInfo);
      }
      else
      {
        sPayScaleType = "IDA";
        return oPayrollFacade.getRmtAreaDetailMetaInfo(sPayScaleType,(MaintRmtAreaAllowDetailInfo)oBaseDetailInfo);
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();

      String sPayScaleType = "";
      if(sScreenName.equalsIgnoreCase("RmtAreaCdaScreen"))
      {
        sPayScaleType = "CDA" ;
      }
      else
      {
        sPayScaleType = "IDA";
      }
      return oPayrollFacade.getRmtAreaDetail(sPayScaleType,lAbsoluteStart,lAbsoluteEnd,(MaintRmtAreaAllowDetailInfo)oBaseDetailInfo);
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.saveRmtAreaDetail((RmtAreaAllowHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.getRmtAreaHeaderMetaImpl((RmtAreaAllowQueryVO)oQueryVO);   
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.getRmtAreaHeaderRecord((RmtAreaAllowQueryVO)oQueryVO,lStartPosition,lLastPosition);
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      RmtAreaComboVO oRmtAreaComboVO = oPayFacade.getRmtAreaComboDetails();
      if(request.getSession().getAttribute("EmpCtgry")!=null)
      {
        request.getSession().removeAttribute("EmpCtgry");
      }
      request.getSession().setAttribute("EmpCtgry",oRmtAreaComboVO);
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