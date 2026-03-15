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
import FCIPAY.Payroll.UTILITY.MaintAdhocPayBean;
import FCIPAY.Payroll.UTILITY.AdhocPayHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayDetailInfo;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayComboVO;
import javax.servlet.http.HttpServletRequest;

public class MaintAdhocPayBD  extends PayrollBaseBD 
{
  public MaintAdhocPayBD()
  {
     super();
  }

public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,AdhocPayDetailInfo oAdhocPayDetailInfo,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oAdhocPayFacade = oHome.create();
      if(sScreenName.equals("AdhocPayScreen"))
      {
        return oAdhocPayFacade.getAdhocPayDetailMetaInfo(sPrimaryKey,oAdhocPayDetailInfo);
      }
      
     
      return  null;
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

  public String adhocPayTrans(String procs,String payCode, String payMode, String payYYMM,long lUserId,long lSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oAdhocPayFacade = oHome.create();
      return oAdhocPayFacade.adhocPayTrans(procs,payCode,payMode,payYYMM,lUserId,lSiteId);
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
  public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO,boolean bForce,UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException

  {
    ArrayList oDetailList = null;
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oAdhocPayFacade = oHome.create();
      
      if(sScreenName.equals("AdhocPayScreen"))
      {
          if(oBaseDetailVO == null || bForce)
          {
            //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
            oBaseDetailVO = new BaseDetailVO();
            oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
            oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
            // Get the total number of record and set it into VO
            RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(AdhocPayDetailInfo)oBaseDetailInfo,sScreenName);
            oBaseDetailVO.setTotalDetailRecord(oRecordMetaInfo.getRecordCount());
            oBaseDetailVO.setOWhenPicked(oRecordMetaInfo.getOWhenPicked());
            if(oRecordMetaInfo.getRecordCount() == 0)
            {
              return oBaseDetailVO;
            }
          }
      
      
           long lSlotRequested = oBaseDetailVO.getSlot(lPageRequested);
      
          // The page displayed is requested again
          if(oBaseDetailVO.getCurrentPage() == lPageRequested)
          {
            return oBaseDetailVO;
          }
          else if(lSlotRequested == oBaseDetailVO.getCurrentSlot())
          {
              // The page is already in the slot so we do not need to go to the database
              int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
              int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
              FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
          
              //oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
          }
          //If triggered from add row where the slot is already filled up
          else if((oBaseDetailVO.getTotalDetailRecord() % (oDetailSizeValues.getMaxPages() * oDetailSizeValues.getDetailRecordPerPage()) == 0 ) && oBaseDetailVO.getRowAdded() == 1)
         {
           oBaseDetailVO.setOAllPageData(new ArrayList());
           oBaseDetailVO.setOThisPageData(new ArrayList());
         }
         //The requested page is in another slot
          else
          {
            oBaseDetailVO.setCurrentSlot(lSlotRequested);



            oDetailList = oAdhocPayFacade.getAdhocPayDetail(sPrimaryKey,oBaseDetailVO.getSlotStartPosition(),oBaseDetailVO.getSlotLastPosition(),(AdhocPayDetailInfo)oBaseDetailInfo);

            oBaseDetailVO.setOAllPageData(oDetailList); 
            int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
            int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
            FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
      
          }
      
          oBaseDetailVO.setCurrentPage(lPageRequested);
          oBaseDetailVO.setCurrentSlot(lSlotRequested);
          oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      
          return oBaseDetailVO;
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oAdhocPayFacade = oHome.create();
      return oAdhocPayFacade.saveAdhocPay((AdhocPayHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      PayrollFacade oAdhocPayFacade = oHome.create();
//      return oMtrRdgFacade.saveMtrRdgHeader((MaintElecMtrRdgHeaderBean)oBaseHeaderBean);
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
      PayrollFacade oAdhocPayFacade = oHome.create();
      return oAdhocPayFacade.getAdhocPayHeaderMetaInfo((AdhocPayQueryVO)oQueryVO);
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
      PayrollFacade oAdhocPayFacade = oHome.create();
      
      ArrayList oHeaderList = oAdhocPayFacade.getAdhocPayHeader((AdhocPayQueryVO)oQueryVO,lStartPosition,lLastPosition);
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
  
 public void getDetailComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComboFacade = oHome.create();
      
      AdhocPayComboVO oAdhocPayComboVO = oComboFacade.getAdhocPayComboDetails();
      request.getSession().setAttribute("Pay",oAdhocPayComboVO);
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