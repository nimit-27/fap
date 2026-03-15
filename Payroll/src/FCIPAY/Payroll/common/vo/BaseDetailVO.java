package FCIPAY.Payroll.common.vo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseVO;
public class BaseDetailVO extends BaseVO implements Serializable 
{
  private int recordsPerPage = 0;
  private int maxPage = 0;
  private long currentPage = 0;
  private long currentSlot = 0;
  private long totalDetailRecord = 0;
  private ArrayList oThisPageData = null;
  private ArrayList oAllPageData = null;
  //long pageRequested = 0;
  int rowAdded = 0;
  int rowDeleted = 0;
  
  public BaseDetailVO()
  {
    super();
    oThisPageData = new ArrayList();
    oAllPageData = new ArrayList();
    //pageRequested = 0;
    currentSlot = 0;
  }

  public void reset()
  {
    currentPage = 0;
    currentSlot = 0;
    oThisPageData = new ArrayList();
    oAllPageData = new ArrayList();
    
  }




  public ArrayList getOAllPageData()
  {
    return oAllPageData;
  }

  public void setOAllPageData(ArrayList newOAllPageData)
  {
    oAllPageData = newOAllPageData;
  }

  public ArrayList getOThisPageData()
  {
    return oThisPageData;
  }

  public void setOThisPageData(ArrayList newOThisPageData)
  {
    oThisPageData = newOThisPageData;
  }

  public long getTotalDetailRecord()
  {
    return totalDetailRecord;
  }

  public void setTotalDetailRecord(long newTotalDetailRecord)
  {
    totalDetailRecord = newTotalDetailRecord;
  }

  public int getRowAdded()
  {
    return rowAdded;
  }

  public void setRowAdded(int newRowAdded)
  {
    rowAdded = newRowAdded;
  }

  public int getRowDeleted()
  {
    return rowDeleted;
  }

  public void setRowDeleted(int newRowDeleted)
  {
    rowDeleted = newRowDeleted;
  }

  public long getCurrentPage()
  {
    return currentPage;
  }

  public void setCurrentPage(long newCurrentPage)
  {
    currentPage = newCurrentPage;
  }

  public long getCurrentSlot()
  {
    return currentSlot;
  }

  public void setCurrentSlot(long newCurrentSlot)
  {
    currentSlot = newCurrentSlot;
  }

  public int getMaxPage()
  {
    return maxPage;
  }

  public void setMaxPage(int newMaxPage)
  {
    maxPage = newMaxPage;
  }

  public int getRecordsPerPage()
  {
    return recordsPerPage;
  }

  public void setRecordsPerPage(int newRecordsPerPage)
  {
    recordsPerPage = newRecordsPerPage;
  }
  
  public long getSlot(long lPageRequested)
  {
    return (lPageRequested % maxPage != 0)?(lPageRequested/maxPage + 1):(lPageRequested/maxPage);
  }
  
  public int getRelativeStart(long lPageRequested)
  {
    long lAbsoluteIndex = (lPageRequested -1)*recordsPerPage +1;
    return (int)(lAbsoluteIndex % (recordsPerPage*maxPage)) -1;
  }
  
  public int getRelativeEnd(long lPageRequested)
  {
    long lAbsoluteIndexStart = (lPageRequested -1)*recordsPerPage;
    long lAbsoluteEnd = (lAbsoluteIndexStart + recordsPerPage < totalDetailRecord)?lAbsoluteIndexStart + recordsPerPage:totalDetailRecord;
    int iMod = (int)(lAbsoluteEnd % (recordsPerPage*maxPage));
    if(iMod != 0)
    {
      return iMod - 1;
    }
    else
    {
      return (int)recordsPerPage*maxPage - 1;
    }
  }
  
  public long getAbsoluteStart(long lPageRequested)
  {
    return (lPageRequested-1)*recordsPerPage +1;
  }
  public long getAbsoluteEnd(long lPageRequested)
  {
    long lStart = (lPageRequested-1)*recordsPerPage;
    return (lStart + recordsPerPage*maxPage < totalDetailRecord)?(lStart + recordsPerPage*maxPage):totalDetailRecord;
  }
/*
  public long getPageRequested()
  {
    return pageRequested;
  }

  public void setPageRequested(long newPageRequested)
  {
    pageRequested = newPageRequested;
  }
  */
  public long getSlotStartPosition()
  {
    return ( (currentSlot - 1)*recordsPerPage*maxPage + 1);
  }
  
  public long getSlotLastPosition()
  {
    return (currentSlot*recordsPerPage*maxPage < totalDetailRecord?currentSlot*recordsPerPage*maxPage:totalDetailRecord);
  }


}