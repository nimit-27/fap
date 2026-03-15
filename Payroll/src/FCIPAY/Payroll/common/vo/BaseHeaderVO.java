package FCIPAY.Payroll.common.vo;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.sql.Timestamp;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseVO;
public class BaseHeaderVO extends BaseVO implements Serializable 
{
  private ArrayList oHeaderVOTable = new ArrayList();
  private long positionRequested = 0;
  private long currentSlot = 0;
  private long totalCount = 0;
  private long maxHeaderSize = 0;
  private Timestamp oWhenPicked = null;
  
  public BaseHeaderVO()
  {
    super();
  }

  public ArrayList getOHeaderVOTable()
  {
    return oHeaderVOTable;
  }
  
  public long getHeaderStartPosition() throws EnrgiseApplicationException
  {
    
    int iSlot = getSlot();
    return (iSlot - 1)*maxHeaderSize + 1;
  }

  public long getHeaderLastPosition() throws EnrgiseApplicationException
  {
    int iSlot = getSlot();
    return (iSlot*maxHeaderSize < totalCount)?(iSlot*maxHeaderSize):totalCount; 
  }
  
  public int getSlot() throws EnrgiseApplicationException
  {
    if(positionRequested < 0 || positionRequested > totalCount)
    {
      throw new EnrgiseApplicationException("IBA.Payroll.common.navigation",FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR);
    }

    return ((int)(positionRequested % maxHeaderSize) != 0)?(int)(((int)positionRequested / maxHeaderSize) + 1):(int)((int)(positionRequested / maxHeaderSize));
  }

  public void setOHeaderVOTable(ArrayList newOHeaderVOTable)
  {
    oHeaderVOTable = newOHeaderVOTable;
  }
  
  // This function is called when user presses the execute query button
  // so we are going to return the first record in the list
  /*
  public BaseHeaderBean getCurrentHeaderRecord() throws EnrgiseApplicationException
  {
    if(oHeaderVOTable == null)
    {
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    else
    {
      if(oHeaderVOTable.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      else
      {
        return (BaseHeaderBean)oHeaderVOTable.get((positionRequested -1);
      }
    }
    
    
    
  }
  */
  
  public BaseHeaderBean getHeaderRecord(int iPosition) throws EnrgiseApplicationException
  {
    if(oHeaderVOTable == null)
    {
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
    }
    else
    {
      if(oHeaderVOTable.size() == 0 || oHeaderVOTable.size() < iPosition)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      else
      {
      /*
        int nextCount = (int)currentCount % EnrgiseConstants.HEADER_SIZE;
        
        if(nextCount == 0)
        {          
          return (BaseHeaderBean)oHeaderVOTable.get(EnrgiseConstants.HEADER_SIZE - 1);
        }
        
        return (BaseHeaderBean)oHeaderVOTable.get(nextCount - 1);
        
      */
      
        return (BaseHeaderBean)oHeaderVOTable.get(iPosition - 1);
      }
      
    }
    
    
    
  }




  public long getPositionRequested()
  {
    return positionRequested;
  }

  public void setPositionRequested(long newPositionRequested)
  {
    positionRequested = newPositionRequested;
  }

  public long getCurrentSlot()
  {
    return currentSlot;
  }

  public void setCurrentSlot(long newCurrentSlot)
  {
    currentSlot = newCurrentSlot;
  }

  public long getTotalCount()
  {
    return totalCount;
  }

  public void setTotalCount(long newTotalCount)
  {
    totalCount = newTotalCount;
  }

  public long getMaxHeaderSize()
  {
    return maxHeaderSize;
  }

  public void setMaxHeaderSize(long newMaxHeaderSize)
  {
    maxHeaderSize = newMaxHeaderSize;
  }
}