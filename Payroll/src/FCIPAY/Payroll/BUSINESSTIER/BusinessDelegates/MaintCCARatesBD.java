package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCAComboVO;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCARatesQueryVO;
import FCIPAY.Payroll.UTILITY.CCARatesHeaderBean;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class MaintCCARatesBD extends PayrollBaseBD
{
  public MaintCCARatesBD()
  {
    super();  
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
     
       if(sScreenName.equalsIgnoreCase("CCARateCDAScreen"))
       {
        sPayScaleType = "CDA," +sPrimaryKey;
        return oMasterFacade.getCCARateAllDetailMetaInfo(sPayScaleType,oBaseDetailInfo);
       }
       else 
       {
          sPayScaleType = "IDA," +sPrimaryKey;
          return oMasterFacade.getCCARateAllDetailMetaInfo(sPayScaleType,oBaseDetailInfo);
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
     

     if(sScreenName.equalsIgnoreCase("CCARateCDAScreen"))
     {
        sPayScaleType = "CDA," + sPrimaryKey;
     }
    else 
     {
        sPayScaleType = "IDA," + sPrimaryKey;
     }

     return oMasterFacade.getCCARateAllDetail(sPayScaleType,lAbsoluteStart,lAbsoluteEnd,oBaseDetailInfo);     

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
      return oPayFacade.saveCCARate((CCARatesHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      return oPayFacade.getCCARateHeaderMetaInfo((CCARatesQueryVO)oQueryVO);
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
      return oPayFacade.getCCARateHeader((CCARatesQueryVO)oQueryVO,lStartPosition,lLastPosition);
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
      CCAComboVO oCCAComboVO = oPayFacade.getCCARateComboDetails();
      if(request.getSession().getAttribute("CCACities")!=null)
      {
        request.getSession().removeAttribute("CCACities");
      }
      request.getSession().setAttribute("CCACities",oCCAComboVO);
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