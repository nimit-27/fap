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
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.UTILITY.EmpDepndntBean;
import FCIPAY.Payroll.UTILITY.EmpDpndntNomHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;        // added by dushyant on 13-10-2010
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;    // added by dushyant on 13-10-2010


public class EmpNomineeBD extends PayrollBaseBD
{
  public EmpNomineeBD()
  {
   super();
  }

public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollNewFacadeHome oHome1 = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");  // added by dushyant on 13-10-2010
      PayrollFacade oPayrollFacade = oHome.create();
      PayrollNewFacade oPayrollNewFacade= oHome1.create();     // added by dushyant 0n 13-10-2010
     if(sScreenName.equals("EmpDependentScreen"))
      {
        return oPayrollFacade.getEmpDepndntDetailMetaInfo(sPrimaryKey);
      }   
      
     if(sScreenName.equals("EmpNomineeScreen"))
      {
        return oPayrollFacade.getEmpNomineeDetailMetaInfo(sPrimaryKey);
      }  
      
      if(sScreenName.equals("EmpGratuityScreen"))                                       // added by dushyant on 13-10-2010
      {
        return oPayrollNewFacade.getEmpGratuityDetailMetaInfo(sPrimaryKey);
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
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollNewFacadeHome oHome1 = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");  // added by dushyant on 13-10-2010
      PayrollFacade oPayrollFacade = oHome.create();
      PayrollNewFacade oPayrollNewFacade= oHome1.create();     // added by dushyant 0n 13-10-2010
      if(sScreenName.equals("EmpDependentScreen"))
      {
        return oPayrollFacade.getEmpDepndntDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd);
      }
      if(sScreenName.equals("EmpNomineeScreen"))
      {
        return oPayrollFacade.getEmpNomineeDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd);
      }  
      
      if(sScreenName.equals("EmpGratuityScreen"))
      {
        return oPayrollNewFacade.getEmpGratuityDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd);
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


public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollNewFacadeHome oHome1 = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");  // added by dushyant on 13-10-2010
      PayrollFacade oPayrollFacade = oHome.create();
      PayrollNewFacade oPayrollNewFacade= oHome1.create();     // added by dushyant 0n 13-10-2010
      if(sScreenName.equals("EmpDependentScreen"))
      {
          return oPayrollFacade.saveEmpDependentDetail((EmpDpndntNomHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);     
      }
      if(sScreenName.equals("EmpNomineeScreen"))
      {
          return oPayrollFacade.saveEmpNomineeDetail((EmpDpndntNomHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);     
      }
      
      if(sScreenName.equals("EmpGratuityScreen"))                               // added by dushyant on 13-10-2010
      {
          return oPayrollNewFacade.saveGratuityDetail((EmpDpndntNomHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);       
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

public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oCityFacade = oHome.create();
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.getDpndntNomineeHeaderMetaInfo((DummyQueryVO)oQueryVO);
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
      return oPayFacade.getDpndntNomineeHeader((DummyQueryVO)oQueryVO,lStartPosition,lLastPosition);
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