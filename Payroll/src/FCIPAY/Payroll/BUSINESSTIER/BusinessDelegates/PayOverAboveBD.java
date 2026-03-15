package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.UTILITY.PayOverAboveHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayOverAboveQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeBean;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;

public class PayOverAboveBD extends BaseBD 
{
  public PayOverAboveBD()
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

  public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      return oEmpFinInfoFacade.savePayOverAbvInfo((PayOverAboveHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    //  return null;
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
      PayrollFacade oEmpFinInfoFacade = oHome.create();
//      return oEmpFinInfoFacade.saveAnnIncHeader((MaintAnnIncHeaderBean)oBaseHeaderBean);
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
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      return oEmpFinInfoFacade.getPayOverAbvHeaderMetaInfo((PayOverAboveQueryVO)oQueryVO);
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
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      
      ArrayList oHeaderList = oEmpFinInfoFacade.getPayOverAbvHeader((PayOverAboveQueryVO)oQueryVO,lStartPosition,lLastPosition);
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
  
  public String sendInv(String sPayOverAboveId,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      
      return oEmpFinInfoFacade.sendPayOvrAbvInv(sPayOverAboveId,hdnEmpLbrFlag,lUserID,lSiteID);
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
 
/*  public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      
      EmpTrnsfrComboVO oEmpTrnsfrComboVO = oEmpFinInfoFacade.getEmpTrnsfrComboDetails();
      request.getSession().setAttribute("EmpTrnsfrCombo",oEmpTrnsfrComboVO);
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
  
 /* public ArrayList getPayInfo(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      
      ArrayList oPayInfo = oEmpFinInfoFacade.getLeaveEncashPayInfo((PayOverAboveQueryVO)oQueryVO);
      return oPayInfo;
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
  }*/
  
  public ArrayList getITDed(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      
      ArrayList oPayInfo = oEmpFinInfoFacade.getPayOverAboveITDed((PayOverAboveQueryVO)oQueryVO);
      return oPayInfo;
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

  public String  deletePayOverAbovePymnt(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
      PayrollNewFacade oEmpFinInfoFacade = oHome.create();
      
      String oLeaveInfo = oEmpFinInfoFacade.deletePayOverAbovePymnt((PayOverAboveQueryVO)oQueryVO);
      return oLeaveInfo;
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