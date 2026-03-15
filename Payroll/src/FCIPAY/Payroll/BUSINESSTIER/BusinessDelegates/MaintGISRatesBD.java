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
import FCIPAY.Payroll.UTILITY.MaintGISRatesBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
//import IBA.Payroll.DATAACCESSTIER.VO.DummyQuaryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GISComboVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
//import IBA.Payroll.EJB.facade.FixedParametersFacadeLocal;
//import IBA.Payroll.EJB.facade.FixedParametersFacadeLocalHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import javax.servlet.http.HttpServletRequest;


public class MaintGISRatesBD  extends PayrollBaseBD
{
  public MaintGISRatesBD ()
  {
    super();  
  }

  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
//      FixedParametersFacadeLocalHome oHome = (FixedParametersFacadeLocalHome)ServiceLocator.getLocator().getService("FixedParametersFacade");
//      FixedParametersFacadeLocal oFixedFacadeLocal = oHome.create();

      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayrollFacade = oHome.create();


    
     
    if(sScreenName.equalsIgnoreCase("MaintGISRatesScreen"))  
        {
         return oPayrollFacade.getGISRatesDetailMetaInfo(sPrimaryKey);
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
      PayrollFacade oPayrollFacade = oHome.create();  

  if(sScreenName.equalsIgnoreCase("MaintGISRatesScreen"))  
        {
         return oPayrollFacade.getGISRatesDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd);     
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
      PayrollFacade oPayFacade = oHome.create();
     return oPayFacade.saveGISRates((DummyHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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


public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
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
   /* try
    {      
      FixedParametersFacadeLocalHome oHome = (FixedParametersFacadeLocalHome)ServiceLocator.getLocator().getService("FixedParametersFacadeLocal");
      FixedParametersFacadeLocal oFixedFacadeLocal = oHome.create();
//      return oSysFacade.getGlobalCodeHeaderMetaInfo((GlobalCodeQueryVO)oQueryVO);
      return new RecordMetaInfo();
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


  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
//    try
//    {      
//      FixedParametersFacadeLocalHome oHome = (FixedParametersFacadeLocalHome)ServiceLocator.getLocator().getService("PayrollFacade");
//      FixedParametersFacadeLocal oPayrollFacade = oHome.create();

//      FixedParametersFacadeLocalHome oHome = (FixedParametersFacadeLocalHome)ServiceLocator.getLocator().getService("PayrollFacade");
//      FixedParametersFacadeLocal oPayrollFacade = oHome.create();

//       PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
//       PayrollFacade oPayrollFacade = oHome.create();
      
//      ArrayList oHeaderList = oSysFacade.getGlobalCodeHeader((GlobalCodeQueryVO)oQueryVO,lStartPosition,lLastPosition);

      return new ArrayList();

//    }
  }


 public void getDetailComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      GISComboVO oGISComboVO = oPayFacade.getDetailGISComboDetails();
      request.getSession().setAttribute("GISCombo",oGISComboVO);
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