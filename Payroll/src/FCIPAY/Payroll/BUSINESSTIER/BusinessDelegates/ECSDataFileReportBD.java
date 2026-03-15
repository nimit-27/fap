package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.ThisPageVO;
import java.util.Map;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.UTILITY.*;

import java.util.HashMap;
import FCIPAY.Payroll.UTILITY.ECSDataFileHdrBean;

public class ECSDataFileReportBD extends BaseBD
{
  public ECSDataFileReportBD()
  {
  }
/* public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return null;    
  }   */
  
/*  public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return true;
  } */
  
  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }
  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return null;  
  }
/*  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return null;
  } */

/*  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  } */


  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oECSDataPayFacade = oHome.create();
      return oECSDataPayFacade.getEcsHeaderMetaInfo();
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


  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
    
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oECSDataPayFacade = oHome.create();
      
      ArrayList oHeaderList = oECSDataPayFacade.getECSHeader(lStartPosition,lLastPosition);
      return oHeaderList;
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


  public String GenEcsData(ECSDataFileHdrBean oECSDataFileHdrBean,long lUserId,long lSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oECSDataPayFacade = oHome.create();
      return oECSDataPayFacade.GenerateECSDataFile(oECSDataFileHdrBean);
      
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

 public String GenSBIData(ECSDataFileHdrBean oECSDataFileHdrBean,long lUserId,long lSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oECSDataPayFacade = oHome.create();
      return oECSDataPayFacade.GenerateSBIDataFile(oECSDataFileHdrBean);
      
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
      PayrollFacade oECSDataPayFacade = oHome.create();
      return oECSDataPayFacade.saveEcsData((ECSDataFileHdrBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      PayrollFacade oAnnIncFacade = oHome.create();
//      return oAnnIncFacade.saveAnnIncHeader((MaintAnnIncHeaderBean)oBaseHeaderBean);
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


  public String submitImpl(String sButtonName,BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
   return null;
  }
  public String getInsertDataImpl(BaseQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return null;
  }

  public Map getDisabledFieldsImpl(ThisPageVO oThisPageVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {

     HashMap oHashMap=new HashMap();
     ArrayList oDisableList=new ArrayList();
     ArrayList oEnableList=new ArrayList();
   /**
    * Disabling butDelRow in any Mode
    */
      oDisableList.add("butDelete");  
      oDisableList.add("butExecute");  
      oDisableList.add("butQuery");  
      oDisableList.add("butInsert"); 
      oDisableList.add("butSave");  
      oDisableList.add("butRefresh"); 
      oDisableList.add("butPrint");
      
     
      return oHashMap;


  } 


}