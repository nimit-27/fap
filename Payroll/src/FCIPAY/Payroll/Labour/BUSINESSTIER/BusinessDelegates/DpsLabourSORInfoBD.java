package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORDtlBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORDtlInfo;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;

public class DpsLabourSORInfoBD extends PayrollBaseBD
{
  public DpsLabourSORInfoBD()
  {
      super();  
  }

  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      


      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();   
      
      if(sScreenName.equalsIgnoreCase("MaintDpsLbrSORDtlScreen"))  
      {
          return oLabourFacade.getDpsLbrSORDetailMetaInfo(sPrimaryKey,sScreenName,(DpsLabourSORDtlInfo)oBaseDetailInfo);
      }
      return null;
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
  
  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
//      FixedParametersFacadeLocalHome oHome = (FixedParametersFacadeLocalHome)ServiceLocator.getLocator().getService("FixedParametersFacade");
//      FixedParametersFacadeLocal oFixedFacadeLocal = oHome.create();

      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();    
     
      if(sScreenName.equalsIgnoreCase("MaintDpsLbrSORDtlScreen"))  
      {
          //return oLabourFacade.getDpsLbrSORDetailMetaInfo(sPrimaryKey,sScreenName);
      }
      return null;
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
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();  

      if(sScreenName.equalsIgnoreCase("MaintDpsLbrSORDtlScreen"))  
      {
          return oLabourFacade.getDpsLbrSORDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(DpsLabourSORDtlInfo)oBaseDetailInfo);     
      }
      return null;
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
  
  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    /*try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();  

      if(sScreenName.equalsIgnoreCase("MaintMiscRatesScreen"))  
      {
          return oLabourFacade.getDpsLbrSORDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,oDpsLabourSORDtlBean);     
      }
      return null;
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }*/
    return null;
    
  }

   public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayFacade = oHome.create();
      return oPayFacade.saveDpsLbrSORInfo((DpsLabourSORHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);      
      //return null;
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
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayFacade = oHome.create();
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
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      return oLabourFacade.getDpsLbrSORHeaderMetaInfo((DpsLabourSORQueryVO)oQueryVO);
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

      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();      
      
      ArrayList oHeaderList = oLabourFacade.getDpsLbrSORHeader((DpsLabourSORQueryVO)oQueryVO,lStartPosition,lLastPosition);
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

/*  
  public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oDpsLabourSORFacade = oHome.create();
      
      DpsLabourSORComboVO oDpsLabourSORComboVO = oDpsLabourSORFacade.getDpsLbrSORComboDetails();
      request.getSession().setAttribute("DpsLabourSORList",oDpsLabourSORComboVO);
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
  */
}