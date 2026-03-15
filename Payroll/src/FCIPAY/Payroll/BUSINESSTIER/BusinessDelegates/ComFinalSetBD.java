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
import FCIPAY.Payroll.UTILITY.ComFinalDetailBean;
import FCIPAY.Payroll.UTILITY.ComFinalHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetDetailInfo;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetComboVO;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;
public class ComFinalSetBD extends PayrollBaseBD
{
  public ComFinalSetBD()
  {
   super();  
  }
 public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComFinal = oHome.create();
      if(sScreenName.equals("ComFinalSetScreen"))
      {
        return oComFinal.getComFinalDetailMetaInfo(sPrimaryKey,(ComFinalSetDetailInfo)oBaseDetailInfo);
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

  public String compute(String procs, ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {   
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComFinal = oHome.create();
      return oComFinal.compute(procs,oComFinalSetQueryVO);
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
  
  
  public String computeITDetails(ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {   
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComFinal = oHome.create();
      return oComFinal.computeITDetails(oComFinalSetQueryVO);
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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComFinalFacade = oHome.create();
      return oComFinalFacade.getComFinalDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(ComFinalSetDetailInfo)oBaseDetailInfo);
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
      PayrollFacade oComFinalFacade = oHome.create();
      return oComFinalFacade.saveComFinal((ComFinalHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
  {/*
    try
    {     
      PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oInterestFacade = oHome.create();
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
    }*/
    return true;
  }

  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComFinal = oHome.create();
      return oComFinal.getComFinalHeaderMetaInfo((ComFinalSetQueryVO)oQueryVO);

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
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComFinal = oHome.create();
      
      ArrayList oHeaderList = oComFinal.getComFinalHeader((ComFinalSetQueryVO)oQueryVO,lStartPosition,lLastPosition);
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

  public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      ComFinalSetComboVO oComFinalSetComboVO = oPayFacade.getComFinalSetComboDetails();
      if(request.getSession().getAttribute("ComFinalSetCombo")!=null)
      {
        request.getSession().removeAttribute("ComFinalSetCombo");
      }
      request.getSession().setAttribute("ComFinalSetCombo",oComFinalSetComboVO);
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

  public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO,boolean bForse,UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oDetailList = null;

    try
    {      
      if(oBaseDetailVO == null )
      {
      
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
       /* RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,sScreenName);
        oBaseDetailVO.setTotalDetailRecord(oRecordMetaInfo.getRecordCount());
        oBaseDetailVO.setOWhenPicked(oRecordMetaInfo.getOWhenPicked());
        if(oRecordMetaInfo.getRecordCount() == 0)
        {
          return oBaseDetailVO;
        }*/
      }
      
      
       long lSlotRequested = oBaseDetailVO.getSlot(lPageRequested);
      
      // The page displayed is requested again
      if((oBaseDetailVO.getCurrentPage() == lPageRequested) )
      {
        return oBaseDetailVO;
      }
      else if((lSlotRequested == oBaseDetailVO.getCurrentSlot()))
      {
          // The page is already in the slot so we do not need to go to the database
          int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
          int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
          FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
          
          //oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      }
      //If triggered from add row where the slot is already filled up
      else if((oBaseDetailVO.getTotalDetailRecord() % (oDetailSizeValues.getMaxPages() * oDetailSizeValues.getDetailRecordPerPage()) == 0 ) && oBaseDetailVO.getRowAdded() == 1 )
       {
       oBaseDetailVO.setOAllPageData(new ArrayList());
       oBaseDetailVO.setOThisPageData(new ArrayList());
      }
     //The requested page is in another slot
      else
      {
        //long lAbsoluteStart = oBaseDetailVO.getAbsoluteStart(lPageRequested);
        //long lAbsoluteEnd = oBaseDetailVO.getAbsoluteEnd(lPageRequested);
        //oDetailList = getDetailRecordImpl(sPrimaryKey,sScreenName,lAbsoluteStart,lAbsoluteEnd);        
        oBaseDetailVO.setCurrentSlot(lSlotRequested);
        oDetailList = getDetailRecordImpl(sPrimaryKey,sScreenName,oBaseDetailVO.getSlotStartPosition(),oBaseDetailVO.getSlotLastPosition(),oBaseDetailInfo);        
        oBaseDetailVO.setOAllPageData(oDetailList); 
        oBaseDetailVO.setTotalDetailRecord(oDetailList.size());
        int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
        int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
        FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
        //oBaseDetailVO.setCurrentPage(lPageRequested);
        //oBaseDetailVO.setCurrentSlot(oBaseDetailVO.getSlot(lPageRequested));
        //oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      
      }
      
      oBaseDetailVO.setCurrentPage(lPageRequested);
      oBaseDetailVO.setCurrentSlot(lSlotRequested);
      oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      
      return oBaseDetailVO;
      
      
/*
      if(oDetailList == null)
      {        
        throw new EnrgiseApplicationException("wenrgise.common.nodetailrecord",EnrgiseConstants.MESSAGE);
      }
      if(oDetailList.size() == 0)
      {
        throw new EnrgiseApplicationException("wenrgise.common.nodetailrecord",EnrgiseConstants.MESSAGE);        
      }
*/
     
    }
    catch(RemoteException oEx)
    {
      throw new EnrgiseSystemException();
    }
    
  }
  public String deleteComSepEntry(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
       PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
      PayrollNewFacade oComFinalFacade = oHome.create();
      return oComFinalFacade.deleteComFinalEntry(oBaseHeaderBean);

     
      
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

public String deleteSepDtls(BaseHeaderBean oBaseHeaderBean,String buttonType) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
       PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
      PayrollNewFacade oComFinalFacade = oHome.create();
      return oComFinalFacade.deleteSepDtls(oBaseHeaderBean,buttonType);

     
      
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



/* public String editSepEntry(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
       PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oComFinalFacade = oHome.create();
      return oComFinalFacade.editComFinalEntry(oBaseHeaderBean);

     
      
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
}
