     /*
    * Module:        MaintainInternalSavingsBD.java
    * Author:        
    * Date Written:  December 2004
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
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.UTILITY.MaintainInternalSavingsBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.IntSavHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.WEBTIER.Form.MaintainInternalSavingsForm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntSavDetailInfo;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;


public class MaintainInternalSavingsBD extends PayrollBaseBD
{    
    public MaintainInternalSavingsBD()
  {
    super();  
  }

 public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,IntSavDetailInfo oIntSavDetailInfo,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oIntFacade = oHome.create();
     if(sScreenName.equals("InternalScreen"))
      {
        return oIntFacade.getIntSavDetailMetaInfo(sPrimaryKey,oIntSavDetailInfo);
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
   // start added by sonia on 10-02-2011///////////
     public ArrayList getInternalsavingPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
      PayrollNewFacade payrollNewFacade = oHome.create();      
      return payrollNewFacade.getInternalsavingPayCodes();
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
  
  // start added by sonia on 10-02-2011///////////
  
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
      PayrollFacade oIntFacade = oHome.create();
      
      if(sScreenName.equals("InternalScreen"))
      {
      if(oBaseDetailVO == null)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
        RecordMetaInfo oIntSavDetailInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(IntSavDetailInfo)oBaseDetailInfo,sScreenName);
        if(null == oIntSavDetailInfo)
        {
          throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",EnrgiseConstants.MESSAGE);          
        }
        oBaseDetailVO.setTotalDetailRecord(oIntSavDetailInfo.getRecordCount());
        oBaseDetailVO.setOWhenPicked(oIntSavDetailInfo.getOWhenPicked());
        if(oIntSavDetailInfo.getRecordCount() == 0)
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
      oDetailList = oIntFacade.getIntSavDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(IntSavDetailInfo)oBaseDetailInfo);
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
    public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO, boolean bForse, UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
//  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    ArrayList oDetailList = null;
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oIntFacade = oHome.create();
      System.out.println("Inside get detail record for internal savings");
      
      if(sScreenName.equals("InternalScreen"))
      {
      if(oBaseDetailVO == null)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
//        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(ElecMtrRdgDetailInfo)oBaseDetailInfo,sScreenName);
        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(IntSavDetailInfo)oBaseDetailInfo,sScreenName);
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
      oDetailList = oIntFacade.getIntSavDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(IntSavDetailInfo)oBaseDetailInfo);

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
      PayrollFacade oIntFacade = oHome.create();
      System.out.println("Inside Internal Savings BD::before ejb call");
      return oIntFacade.saveIntSav((IntSavHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      PayrollFacade oIntFacade = oHome.create();
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
      PayrollFacade oIntFacade = oHome.create();
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
      PayrollFacade oIntFacade = oHome.create();
      
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

  public String sGetEmpName(String sEmpNum) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oPayFacade = oHome.create();
      return oPayFacade.sGetEmpName(sEmpNum); 
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
      return oPayFacade.sGetIntPayCodeName(sPayCode); 
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