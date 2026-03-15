package FCIPAY.Payroll.EJB.common.utility;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
public class PositionResolver 
{
  public PositionResolver()
  {
  }
  
  public static long getStartPosition(BaseQueryVO oBaseQueryVO,long lTotalCount)
  {
    long lStartPosition;
    int iMaxHeaderSize = oBaseQueryVO.getMaxHeaderSize();
    long lPositionRequested = oBaseQueryVO.getPositionRequested();
    
    if(lPositionRequested != 0)
    {
      return (lStartPosition = lPositionRequested);
    }
    else
    {//Last record requested
      int iStep = (int)(lTotalCount / iMaxHeaderSize);
      return (lStartPosition = iStep*iMaxHeaderSize + 1);
    }
    
  }
  
  public static long getLastPosition(BaseQueryVO oBaseQueryVO,long lTotalCount)
  {
    long lLastPosition;
    int iMaxHeaderSize = oBaseQueryVO.getMaxHeaderSize();
    long lPositionRequested = oBaseQueryVO.getPositionRequested();
    
    if(lPositionRequested != 0)
    {
      if(lPositionRequested + iMaxHeaderSize -1 < lTotalCount)
      {
        lLastPosition = lPositionRequested + iMaxHeaderSize -1 ;
      }
      else
      {
        lLastPosition = lTotalCount;
      }
    }
    else
    {//Last record requested
      lLastPosition = lTotalCount;
    }
    
    
    return lLastPosition;
  }
  
  public static long getDetailFirstPosition(int iStartPage,long lTotalDetailRecord,DetailSizeValues oDetailSizeValues)
  {
    int iDetailRecordPerPage = oDetailSizeValues.getDetailRecordPerPage();
    int iMaxPage = oDetailSizeValues.getMaxPages();
    
    if(lTotalDetailRecord > (iStartPage -1)*iDetailRecordPerPage)
    {
      return (iStartPage -1)*iDetailRecordPerPage + 1;
    }
    else
    {
      return 1;
    }
  }
  public static long getDetailLastPosition(int iStartPage,long lTotalDetailRecord,DetailSizeValues oDetailSizeValues)
  {
    int iDetailRecordPerPage = oDetailSizeValues.getDetailRecordPerPage();
    int iMaxPage = oDetailSizeValues.getMaxPages();
    
    if(lTotalDetailRecord > (iStartPage+iMaxPage -1)*iDetailRecordPerPage)
    {
      return (iStartPage+iMaxPage -1)*iDetailRecordPerPage;
    }
    else
    {
      return lTotalDetailRecord;
    }
  }
}