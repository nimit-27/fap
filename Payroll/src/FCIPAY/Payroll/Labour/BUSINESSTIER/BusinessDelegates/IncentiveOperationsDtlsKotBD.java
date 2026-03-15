package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.Labour.Utility.CalcDeptIncentiveHeaderBean;
import FCIPAY.Payroll.Labour.Utility.MaintIncentiveOperationsKotBean;
import FCIPAY.Payroll.Labour.EJB.business.IncentiveOperationsBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.IncentiveOperationsKotDtBusinessObjectl;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsDtlKotBean;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsHdrKotBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotLbrOprDetailsVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotwalLbrMasterDetailsVO;
public class IncentiveOperationsDtlsKotBD extends BaseBD
{
  public IncentiveOperationsDtlsKotBD()
  {
  }
  public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
   try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayFacade = oHome.create();
     return oPayFacade.saveLabourOperationsDtlsDetails((IncentiveOperationsHdrKotBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
    return true;
  }
  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayFacade = oHome.create();
      if(sScreenName.equals("IncentiveOperationsDtlMap"))
      {
        return oPayFacade.getLabourOperationsDtlsDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
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
      LabourFacade oPayFacade = oHome.create();
      if(sScreenName.equals("IncentiveOperationsDtlMap"))
      {
        return oPayFacade.getLabourOperationsDtlsDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,oBaseDetailInfo);
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
     
     
      return null;
   
  }
  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
   
      return null;
   
  }
  
  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    { 
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayFacade = oHome.create();
      return oPayFacade.getKotLbrOperationsDtlsHeader((KotLbrOprDetailsVO)oQueryVO,lStartPosition,lLastPosition);
      
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    } // return null;
  }
  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    { 
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayFacade = oHome.create();
      return oPayFacade.getKotLbrOperationsDtlsMetaInfo((KotLbrOprDetailsVO)oQueryVO);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
   // return null;
  }

 /* public String getMaxPayYear(long locCode,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oInitFacade = oHome.create();
      return oInitFacade.getCalcDeptIncentivePayYear(locCode,hdnEmpLbrFlag);
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

 private void chkKotLbrOprEffDate(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
{
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oEmpFinInfoFacade = oHome.create();
      
       oEmpFinInfoFacade.chkKotLbrOprEffDate(oBaseHeaderBean,sScreenMode,oList);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
    
  } */
}