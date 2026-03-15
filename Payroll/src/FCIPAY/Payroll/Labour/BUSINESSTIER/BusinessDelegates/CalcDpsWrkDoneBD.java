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
import FCIPAY.Payroll.Labour.Utility.CalcDpsWrkDoneHeaderBean;

public class CalcDpsWrkDoneBD extends BaseBD
{
  public CalcDpsWrkDoneBD()
  {
  }
 public String calcDpsWrkDone (long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      
       return oLabourFacade.calcDpsWrkDone(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
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

 public String undoDpsWrkDone (long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      
       return oLabourFacade.undoDpsWrkDone(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
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

 public String PostInvToAP (long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      
       return oLabourFacade.PostInvToAP(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
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

 public String monthEnd (long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      
       return oLabourFacade.monthEnd(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
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
    return null;    
  }  
  public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return true;
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
    return null;
  }
  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }

  public String getMaxPayYear(long locCode,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oInitFacade = oHome.create();
      return oInitFacade.getCalcDpsWrkDonePayYear(locCode,hdnEmpLbrFlag);
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