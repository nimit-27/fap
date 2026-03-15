/* * 
 * @ Modified by Balpreet Kaur
 * @ Modification date 4 Dec 2007
 * */

package FCIPAY.Payroll.common.businessdelegate;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.naming.NamingException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.common.utility.UserInfo;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import java.sql.Timestamp;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import javax.servlet.http.HttpServletRequest;

public abstract class BaseBD 
{
  
  //protected Timestamp oWhenPicked = null; // When the header records picked
  protected Timestamp oWhenDetailPicked = null; //When the detail records picked
  protected long lTotalRecordCount = 0;
  protected long lStartPosition = 0;
  protected long lLastPosition = 0;;
  protected long lDetailFirstPosition = 0;
  protected long lDetailLastPosition = 0;
  protected long lTotalDetailRecordCount = 0;
  
  public BaseBD()
  {
  }
  

  public long getLTotalRecordCount()
  {
    return lTotalRecordCount;
  }

  public void setLTotalRecordCount(long newLTotalRecordCount)
  {
    lTotalRecordCount = newLTotalRecordCount;
  }
/*
  public Timestamp getOWhenPicked()
  {
    return oWhenPicked;
  }

  public void setOWhenPicked(Timestamp newOWhenPicked)
  {
    oWhenPicked = newOWhenPicked;
  }
*/

  /*Added By Arunava*/
  public void getDetailComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }

  public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }
  /*Added By Arunava*/


  public String getMaxPayYear(long locCode,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }


  public long getLDetailFirstPosition()
  {
    return lDetailFirstPosition;
  }

  public void setLDetailFirstPosition(long newLDetailFirstPosition)
  {
    lDetailFirstPosition = newLDetailFirstPosition;
  }

  public long getLDetailLastPosition()
  {
    return lDetailLastPosition;
  }

  public void setLDetailLastPosition(long newLDetailLastPosition)
  {
    lDetailLastPosition = newLDetailLastPosition;
  }

  public long getLTotalDetailRecordCount()
  {
    return lTotalDetailRecordCount;
  }

  public void setLTotalDetailRecordCount(long newLTotalDetailRecordCount)
  {
    lTotalDetailRecordCount = newLTotalDetailRecordCount;
  }
  
  public BaseHeaderVO getHeaderRecord(BaseQueryVO oQueryVO,String sFormName, UserSession oUser) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    //oQueryVO.setPositionRequested(1); //No particular position requested
    
    try
    {
        RecordMetaInfo oHeaderMetaInfo = getHeaderMetaImpl(oQueryVO);        
      
      if(oHeaderMetaInfo != null)
      {        
        oBaseHeaderVO.setOWhenPicked(oHeaderMetaInfo.getOWhenPicked());
        oBaseHeaderVO.setTotalCount(oHeaderMetaInfo.getRecordCount());        
      }
      else
      {
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }

      oBaseHeaderVO.setMaxHeaderSize(oQueryVO.getMaxHeaderSize());
      if(oHeaderMetaInfo.getRecordCount() == 0)
      {
          throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
//        return oBaseHeaderVO;
      }
      
      
      oBaseHeaderVO.setPositionRequested(1);
      
      oBaseHeaderVO.setCurrentSlot(oBaseHeaderVO.getSlot());
      ArrayList oHeaderList = getHeaderRecordImpl(oQueryVO,oBaseHeaderVO.getHeaderStartPosition(),oBaseHeaderVO.getHeaderLastPosition());
      
      if(oHeaderList == null)
      {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      
      if(oUser == null)
      {
        throw new EnrgiseApplicationException("wenrgise.common.sessiontimedout",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }
      oBaseHeaderVO.setOHeaderVOTable(oHeaderList);
      oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);
      oUser.putBaseQueryVO(sFormName,oQueryVO);
      
    }
    catch(RemoteException oEx)
    {
      throw new EnrgiseSystemException();
    }
    
    return oBaseHeaderVO;
  }
  
  
  public BaseHeaderVO getNextHeaderRecord(BaseQueryVO oQueryVO,long lPositionRequested, String sFormName, boolean bForce, UserSession oUser) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  try
  {
    BaseHeaderVO oBaseHeaderVO = oUser.getBaseHeaderVO(sFormName);
    oBaseHeaderVO.setPositionRequested(lPositionRequested);
    if((oBaseHeaderVO.getCurrentSlot() == oBaseHeaderVO.getSlot()) && !bForce)
    {
      return oBaseHeaderVO;
    }
    else
    {
      ArrayList oHeaderList = getHeaderRecordImpl(oQueryVO,oBaseHeaderVO.getHeaderStartPosition(),oBaseHeaderVO.getHeaderLastPosition());
      oBaseHeaderVO.setCurrentSlot(oBaseHeaderVO.getSlot());
      oBaseHeaderVO.setOHeaderVOTable(oHeaderList);
      oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);
      return oBaseHeaderVO;
    }
  }
  catch(RemoteException oEx)
  {
    throw new EnrgiseSystemException();
  }
   //return null;
  }
  
  
  public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO, boolean bForce, UserSession oUser) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oDetailList = null;

    try
    {      
      if(oBaseDetailVO == null || bForce)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,sScreenName);
        oBaseDetailVO.setTotalDetailRecord(oRecordMetaInfo.getRecordCount());
        oBaseDetailVO.setOWhenPicked(oRecordMetaInfo.getOWhenPicked());
        if(oRecordMetaInfo.getRecordCount() == 0)
        {
          return oBaseDetailVO;
        }
      }
      
      
       long lSlotRequested = oBaseDetailVO.getSlot(lPageRequested);
      
      // The page displayed is requested again
      if((oBaseDetailVO.getCurrentPage() == lPageRequested) && (!bForce))
      {
        return oBaseDetailVO;
      }
      else if((lSlotRequested == oBaseDetailVO.getCurrentSlot()) &&(!bForce))
      {
          // The page is already in the slot so we do not need to go to the database
          int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
          int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
          FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
          
          //oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      }
      //If triggered from add row where the slot is already filled up
      else if((oBaseDetailVO.getTotalDetailRecord() % (oDetailSizeValues.getMaxPages() * oDetailSizeValues.getDetailRecordPerPage()) == 0 ) && oBaseDetailVO.getRowAdded() == 1 && (!bForce))
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
        oDetailList = getDetailRecordImpl(sPrimaryKey,sScreenName,oBaseDetailVO.getSlotStartPosition(),oBaseDetailVO.getSlotLastPosition());        
        oBaseDetailVO.setOAllPageData(oDetailList); 
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

/*
 *  Updated by Balpreet Kaur
 *  Dt 4 Dec 2007
 *  For Updating the common code to fetch the Login Site Id.
 * 
*/
  
  public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO,boolean bForse,UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       ArrayList oDetailList = null;

    try
    {      
      if(oBaseDetailVO == null)
      {
        //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        // Get the total number of record and set it into VO
        RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,sScreenName,oBaseDetailInfo);
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
    }
    catch(RemoteException oEx)
    {
      throw new EnrgiseSystemException();
    }

  }

  public String saveRecord(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return saveImpl(oBaseHeaderBean, oWhenPicked, sScreenName, sScreenMode,bHeaderDataChanged,oDetailBeanArray,bDetailDataChanged,oDetailPicked);
    //return true;    
  }
  public abstract ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO, long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
  public abstract RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException;

  public abstract RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException;
  
  public abstract ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public abstract boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public abstract String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
//  public abstract String getInsertDataImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/*
 *  Added by Balpreet Kaur
 *  Dt 4 Dec 2007
 *  For Updating the common code to fetch the Login Site Id.
 * 
*/
  public  RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }

/*
 *  Added by Balpreet Kaur
 *  Dt 4 Dec 2007
 *  For Updating the common code to fetch the Login Site Id.
 * 
*/  
  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    return null;
  }

  /*
   * @author Balpreet Kaur
   * To Delete the Header Record.
   * Added on 7 September 2007.
   * 
   */
  public void deleteHeaderRecordImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    
  }
  
  public long getLStartPosition()
  {
    return lStartPosition;
  }

  public void setLStartPosition(long newLStartPosition)
  {
    lStartPosition = newLStartPosition;
  }

  public long getLLastPosition()
  {
    return lLastPosition;
  }

  public void setLLastPosition(long newLLastPosition)
  {
    lLastPosition = newLLastPosition;
  }

}
