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
import FCIPAY.Payroll.UTILITY.IntRateDetailBean;
import FCIPAY.Payroll.UTILITY.IntRateHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateDetailInfo;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.MasterFacade;
import FCIPAY.Payroll.EJB.facade.MasterFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class MaintIntRateBD extends PayrollBaseBD
{
  public MaintIntRateBD()
  {
   super();  
  }
 
  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oInterestFacade = oHome.create();
      if(sScreenName.equals("IntRateScreen"))
      {
        return oInterestFacade.getIntRateDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
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

  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {     
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oInterestFacade = oHome.create();
      if(sScreenName.equals("IntRateScreen"))
      {
        return oInterestFacade.getIntRateDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,oBaseDetailInfo);
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
    return null;
  }

  public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oInterestFacade = oHome.create();
      return oInterestFacade.saveIntRate((IntRateHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oInterestFacade = oHome.create();
//      return oDAFacade.saveDARateHeader((MaintDARatesHeaderBean)oBaseHeaderBean);
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
      MasterFacade oInterestFacade = oHome.create();
      return oInterestFacade.getIntRateHeaderMetaInfo((IntRateQueryVO)oQueryVO);

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


  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oInterestFacade = oHome.create();
      
      ArrayList oHeaderList = oInterestFacade.getIntRateHeader((IntRateQueryVO)oQueryVO,lStartPosition,lLastPosition);
      return oHeaderList;
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
  
}
