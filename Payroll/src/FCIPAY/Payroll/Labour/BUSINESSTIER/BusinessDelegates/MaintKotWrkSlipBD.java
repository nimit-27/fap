package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import java.util.ArrayList;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipBean;
import FCIPAY.Payroll.Labour.EJB.business.KotWrkSlipBusinessObject;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
public class MaintKotWrkSlipBD extends PayrollBaseBD 
{

   public MaintKotWrkSlipBD()
    {
      super();
    }
    
    public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oPayFacade = oHome.create();
        WrkSlipComboVO oWrkSlipComboVO = oPayFacade.getKotWrkSlipComboDetails();
        request.getSession().setAttribute("NormTyp",oWrkSlipComboVO);
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
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        return oLabourFacade.saveKotWrkSlip((MaintKotWrkSlipHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
    
    
    
   public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        if(sScreenName.equalsIgnoreCase("LabourWrkSlipScreen"))
          return oLabourFacade.getKotWrkSlipLbrDetail(sPrimaryKey,oBaseDetailInfo,lAbsoluteStart,lAbsoluteEnd);
        else
          return oLabourFacade.getKotWrkSlipDetail(sPrimaryKey,oBaseDetailInfo,lAbsoluteStart,lAbsoluteEnd);
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
    
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        if(sScreenName.equalsIgnoreCase("LabourWrkSlipScreen"))         
            return oLabourFacade.getKotWrkSlipLbrDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
        else
            return oLabourFacade.getKotWrkSlipDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);        
       // return null;
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
          LabourFacade oPayFacade = oHome.create();
          return oPayFacade.getKotWrkSlipHeaderMetaImpl(oQueryVO);
      
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
          LabourFacade oPayFacade = oHome.create();
          return oPayFacade.getKotWrkSlipHeaderRecord(oQueryVO,lStartPosition,lLastPosition);      
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
    
    public void deleteHeaderRecordImpl(String sPrimaryKey,String sScreenName)throws EnrgiseSystemException, EnrgiseApplicationException
    {
       try
      {
          LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
          LabourFacade oPayFacade = oHome.create();
          oPayFacade.deleteKotWrkSlipHeaderRecord(sPrimaryKey,sScreenName);      
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

    public ArrayList calcIncentive(BaseHeaderBean oBaseHeaderBean, String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        return oLabourFacade.wrkslipCalcIncentive((MaintKotWrkSlipHeaderBean)oBaseHeaderBean ,  sScreenName, oDetailBeanArray);
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
     
     
      return null;
   
  }
  
  public ArrayList getKotLabourDetail(String sKotId, String fldName,long loginLocId, String depotId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        return oLabourFacade.getKotLabourDetail(sKotId, fldName, loginLocId, depotId);
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
   return null;
   }
   }
