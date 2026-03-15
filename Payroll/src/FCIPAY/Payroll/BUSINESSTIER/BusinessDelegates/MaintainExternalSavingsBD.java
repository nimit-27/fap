     /*
    * Module:        MaintainExternalSavingsBD.java
    * Author:        
    * Date Written:  December 2007
    * Description:   Business Delegate for FE Release Details
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.UTILITY.MaintainExternalSavingsBean;
import FCIPAY.Payroll.UTILITY.ExtSavHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.WEBTIER.Form.MaintainExternalSavingsForm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ExtSavDetailInfo;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class MaintainExternalSavingsBD extends PayrollBaseBD
{    
   public MaintainExternalSavingsBD()
  {
    super();  
  }  
 public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,ExtSavDetailInfo oExtSavDetailInfo,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oExtFacade = oHome.create();
     if(sScreenName.equals("ExternalScreen"))
      {
        return oExtFacade.getExtSavDetailMetaInfo(sPrimaryKey,oExtSavDetailInfo);
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


/*public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO,UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oDetailList = null;
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oExtFacade = oHome.create();
      
      if(sScreenName.equals("ExternalScreen"))
      {
      if(oBaseDetailVO == null)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
        RecordMetaInfo oExtSavDetailInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(ExtSavDetailInfo)oBaseDetailInfo,sScreenName);
        if(null == oExtSavDetailInfo)
        {
          throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",EnrgiseConstants.MESSAGE);          
        }
        oBaseDetailVO.setTotalDetailRecord(oExtSavDetailInfo.getRecordCount());
        oBaseDetailVO.setOWhenPicked(oExtSavDetailInfo.getOWhenPicked());
        if(oExtSavDetailInfo.getRecordCount() == 0)
        {
          return oBaseDetailVO;
        }
      }
      
      // The page displayed is requested again
      if(oBaseDetailVO.getCurrentPage() == lPageRequested)
      {
        return oBaseDetailVO;
      }
      else
      {
        
        long lSlotRequested = oBaseDetailVO.getSlot(lPageRequested);
        if(lSlotRequested == oBaseDetailVO.getCurrentSlot())
        {
          // The page is already in the slot so we do not need to go to the database
          int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
          int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
          oBaseDetailVO.setCurrentPage(lPageRequested);
          ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
          oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
          return oBaseDetailVO;
        }
      }
      
      
      long lAbsoluteStart = oBaseDetailVO.getAbsoluteStart(lPageRequested);
      long lAbsoluteEnd = oBaseDetailVO.getAbsoluteEnd(lPageRequested);
//      oDetailList = getDetailRecordImpl(sPrimaryKey,sScreenName,lAbsoluteStart,lAbsoluteEnd);
      oDetailList = oExtFacade.getExtSavDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(ExtSavDetailInfo)oBaseDetailInfo);
      if(oDetailList == null)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",EnrgiseConstants.MESSAGE);
      }
      if(oDetailList.size() == 0)
      {
        throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",EnrgiseConstants.MESSAGE);        
      }
      oBaseDetailVO.setOAllPageData(oDetailList); 
      int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
      int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
      ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
      oBaseDetailVO.setCurrentPage(lPageRequested);
      oBaseDetailVO.setCurrentSlot(oBaseDetailVO.getSlot(lPageRequested));
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
    
  }*/
//  public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO,boolean bForse,UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO, boolean bForse, UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
//  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    ArrayList oDetailList = null;
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oExtFacade = oHome.create();
      
      if(sScreenName.equals("ExternalScreen"))
      {
      if(oBaseDetailVO == null)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
//        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(ElecMtrRdgDetailInfo)oBaseDetailInfo,sScreenName);
        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(ExtSavDetailInfo)oBaseDetailInfo,sScreenName);
        if(null == oRecordMetaInfo)
        {
          throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);          
        }
        oBaseDetailVO.setTotalDetailRecord(oRecordMetaInfo.getRecordCount());
        oBaseDetailVO.setOWhenPicked(oRecordMetaInfo.getOWhenPicked());
        if(oRecordMetaInfo.getRecordCount() == 0)
        {
          return oBaseDetailVO;
        }
      }
      
      // The page displayed is requested again
      if(oBaseDetailVO.getCurrentPage() == lPageRequested)
      {
        return oBaseDetailVO;
      }
      else
      {
        
        long lSlotRequested = oBaseDetailVO.getSlot(lPageRequested);
        if(lSlotRequested == oBaseDetailVO.getCurrentSlot())
        {
          // The page is already in the slot so we do not need to go to the database
          int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
          int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
          oBaseDetailVO.setCurrentPage(lPageRequested);
          FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
          oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
          return oBaseDetailVO;
        }
      }
      
      
      long lAbsoluteStart = oBaseDetailVO.getAbsoluteStart(lPageRequested);
      long lAbsoluteEnd = oBaseDetailVO.getAbsoluteEnd(lPageRequested);
//      oDetailList = getDetailRecordImpl(sPrimaryKey,sScreenName,lAbsoluteStart,lAbsoluteEnd);
//      oDetailList = oMtrRdgFacade.getMtrRdgDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(ElecMtrRdgDetailInfo)oBaseDetailInfo);
      oDetailList = oExtFacade.getExtSavDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(ExtSavDetailInfo)oBaseDetailInfo);

      if(oDetailList == null)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      if(oDetailList.size() == 0)
      {
        throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }
      oBaseDetailVO.setOAllPageData(oDetailList); 
      int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
      int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
      FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
      oBaseDetailVO.setCurrentPage(lPageRequested);
      oBaseDetailVO.setCurrentSlot(oBaseDetailVO.getSlot(lPageRequested));
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
      PayrollFacade oExtFacade = oHome.create();
      return oExtFacade.saveExtSav((ExtSavHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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

public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oExtFacade = oHome.create();
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
      PayrollFacade oExtFacade = oHome.create();
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
    }
    
  }


  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oExtFacade = oHome.create();
      
//      ArrayList oHeaderList = oSysFacade.getGlobalCodeHeader((GlobalCodeQueryVO)oQueryVO,lStartPosition,lLastPosition);

      return new ArrayList();

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


  public String sGetEmpName(String sEmpNum, long lUserId) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.sGetExtSavEmpName(sEmpNum, lUserId); 
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


  public String sGetPayCodeName(String sPayCode) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.sGetExtPayCodeName(sPayCode); 
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
   /* try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oExtFacade = oHome.create();
      
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
      }
      String sFinYear = oExtFacade.sGetFinYear(obUserInfo.getLLocationCode());
      request.getSession().setAttribute("hdnFinYear",sFinYear);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
    */
 }

  public String sGetExtSavAcc(long sLoginUserId) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.sGetExtSavAcc(sLoginUserId); 
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

 public String getFinalYear(long locCode,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oExtFacade = oHome.create();
      String sFinYear = oExtFacade.sGetFinYear(locCode,hdnEmpLbrFlag);
      return sFinYear;
//      request.getSession().setAttribute("hdnFinYear",sFinYear);
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