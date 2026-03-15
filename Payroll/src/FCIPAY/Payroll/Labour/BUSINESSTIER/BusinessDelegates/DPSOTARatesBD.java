package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.Labour.Utility.DPSOTARateHeaderBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSOTARatesQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSOTARatesDetailInfo;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;


public class DPSOTARatesBD extends PayrollBaseBD 
{
  public DPSOTARatesBD()
  {
    super();
  }
  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {          
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      return oLabourFacade.getDPSOTARateHeaderMetaInfo((DPSOTARatesQueryVO)oQueryVO);
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
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      
      ArrayList oHeaderList = oLabourFacade.getDPSOTARateHeader((DPSOTARatesQueryVO)oQueryVO,lStartPosition,lLastPosition);

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
//  public RecordMetaInfo getTotalDetailRecordCountImpl(String sRevYear, String sPayScaleCode, String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
 /* public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      
//      long lRevYear = 200412;
//      String sRevYear = "200412"; 
//      String sPayScaleCode = "E1";      

      String  sRevYear;
      String sPayScaleCode;
      sRevYear=sPrimaryKey.substring(0,6);
      sPayScaleCode=sPrimaryKey.substring(7,9);    

      if(sScreenName.equals("PayScaleIDA"))
      {
      return oLabourFacade.getPayScaleDetailMetaInfo(sRevYear, sPayScaleCode, "IDA");
      }
      
      if(sScreenName.equals("PayScaleCDA"))
      {
          return oLabourFacade.getPayScaleDetailMetaInfo(sRevYear, sPayScaleCode, "CDA");
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


   public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo ) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayScaleFacade = oHome.create();
      
      return oPayScaleFacade.getDPSOTARateDetailMetaInfo(sPrimaryKey,(DPSOTARatesDetailInfo)oBaseDetailInfo);
       
     
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
// added by sakshi starts 26.12.2008
 public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oPayFacade = oHome.create();
        //PayScaleVO oPayScaleVO = oPayFacade.getPayScaleComboDetails();
        //request.getSession().setAttribute("PayScaleVO",oPayScaleVO);
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
// added by sakshi ends 26.12.2008
  
 /* public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
//      String sRevYear = "200412"; 
//      String sPayScaleCode = "E1";          

      String  sRevYear;
      String sPayScaleCode;
      sRevYear=sPrimaryKey.substring(0,6);
      sPayScaleCode=sPrimaryKey.substring(7,9);    

      LabourFacadeHome oHome = (LabourFacadeHome)ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      if(sScreenName.equals("PayScaleIDA"))
      {
        return oLabourFacade.getPayScaleDetail(sRevYear, sPayScaleCode, "IDA", lAbsoluteStart,lAbsoluteEnd);
      }          
      if(sScreenName.equals("PayScaleCDA"))
      {
        return oLabourFacade.getPayScaleDetail(sRevYear, sPayScaleCode, "CDA", lAbsoluteStart,lAbsoluteEnd);
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


 public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
{
    return null;  
}



   //public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO, boolean bForce, UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    ArrayList oDetailList = null;
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayScaleFacade = oHome.create();
      return oPayScaleFacade.getDPSOTARateDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,(DPSOTARatesDetailInfo)oBaseDetailInfo);
      
      /*if(sScreenName.equals("PayScaleIDA"))
      {
      if(oBaseDetailVO == null)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
//        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(ElecMtrRdgDetailInfo)oBaseDetailInfo,sScreenName);
        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl("IDA",(DPSOTARatesDetailInfo)oBaseDetailInfo,sScreenName);
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
      if((oBaseDetailVO.getCurrentPage() == lPageRequested)   && (!bForce))
      {
        return oBaseDetailVO;
      }
      else 
      {
        
        long lSlotRequested = oBaseDetailVO.getSlot(lPageRequested);
        if((lSlotRequested == oBaseDetailVO.getCurrentSlot())  && (!bForce))
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
      oDetailList = oPayScaleFacade.getPayScaleDetail("IDA",lAbsoluteStart,lAbsoluteEnd,(DPSOTARatesDetailInfo)oBaseDetailInfo);

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


       if(sScreenName.equals("PayScaleCDA"))
      {
      if(oBaseDetailVO == null)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
//        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(ElecMtrRdgDetailInfo)oBaseDetailInfo,sScreenName);
        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl("CDA",(DPSOTARatesDetailInfo)oBaseDetailInfo,sScreenName);
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
      oDetailList = oPayScaleFacade.getPayScaleDetail("CDA",lAbsoluteStart,lAbsoluteEnd,(DPSOTARatesDetailInfo)oBaseDetailInfo);

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
          
      return null;*/
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
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      return oLabourFacade.saveDPSOTARate((DPSOTARateHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oLabourFacade = oHome.create();
      //return oLabourFacade.saveDPSOTARateHeader((DPSInfoHeaderBean)oBaseHeaderBean);
      return false;
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




 /*public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      LabourFacadeHome oHome = (LabourFacadeHome)ServiceLocator.getLocator().getService("LabourFacade");
      LabourFacade oPayScaleFacade = oHome.create();
      PayScaleComboVO oPayScaleComboVO = oPayScaleFacade.getPayScaleComboDetails();
      request.getSession().setAttribute("PayScaleCode",oPayScaleComboVO);
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