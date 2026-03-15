package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
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
import FCIPAY.Payroll.UTILITY.LoanDtlsAllDetailBean;
import FCIPAY.Payroll.UTILITY.MediReimbursDtlsAllHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MediReimbursDtlsAllQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllDetailInfo;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
//import IBA.Payroll.DATAACCESSTIER.VO.DummyQuaryVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MediReimbDtlsAllDetailInfo; // added by devendra on 3rd sept 2010


public class MediReimbursDtlsAllBD extends PayrollBaseBD
{
     public MediReimbursDtlsAllBD()
    {
      super();  
    }
    
    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {          
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();
      return oPayrollFacade.getMediReimbursDtlsAllHeaderMetaInfo((MediReimbursDtlsAllQueryVO)oQueryVO);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
    //return null;
    
  }
  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();
      
      ArrayList oHeaderList = oPayrollFacade.getMediReimbursDtlsAllHeader((MediReimbursDtlsAllQueryVO)oQueryVO,lStartPosition,lLastPosition);

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
    //return null;
  }
  
  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey, String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create(); 

      if(sScreenName.equals("MediReimbursAllScreen"))
      {
          return oPayrollFacade.getMediReimbursDtlsAllDetailMetaInfo(sPrimaryKey,(MediReimbDtlsAllDetailInfo)oBaseDetailInfo);
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
    //return null;
  }  
 
//Newly added lines
   public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
      return null;  
  }

   public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();
      return oPayrollFacade.getMediReimbursDtlsAllDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(MediReimbDtlsAllDetailInfo)oBaseDetailInfo);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
    //return null;
  }

 public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   	return null;
  }


  public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();
      return oPayrollFacade.saveMediReimbursDtlsAll((MediReimbursDtlsAllHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
    //return null;
    
  }

  
  public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    /*try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();
//      return oPayrollFacade.saveDARAteHeader((LbrHndlngAttndHeaderBean)oBaseHeaderBean);
      return true;
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }*/
    return true;
  }
  
    public String sendInv(String empLbr, String quarter, String finYear, String medicalDate, long lUserID, long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
        try
        {      
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayrollNewFacade = oHome.create();
            return oPayrollNewFacade.sendInv(empLbr, quarter, finYear, medicalDate, lUserID, lSiteID);
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
    
     public String sendInvBulk(String empLbr,String finYear,String txtPayCode,long lUserID, long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
        try
        {      
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayrollNewFacade = oHome.create();
            return oPayrollNewFacade.sendInvBulk(empLbr,finYear,txtPayCode,lUserID, lSiteID);
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
    //added by priyanka
    public String getMaxPayYear(long locCode,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oInitFacade = oHome.create();
      
       return oInitFacade.getInitMaxPayYear(locCode,hdnEmpLbrFlag);
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