package FCIPAY.Payroll.common.utility;
import java.sql.Timestamp;
import java.io.Serializable;
public class RecordMetaInfo implements Serializable
{
  private Timestamp oWhenPicked = null;
  private long recordCount = 0;
  
  public RecordMetaInfo()
  {
  }

  public long getRecordCount()
  {
    return recordCount;
  }

  public void setRecordCount(long newRecordCount)
  {
    recordCount = newRecordCount;
  }

  public Timestamp getOWhenPicked()
  {
    return oWhenPicked;
  }

  public void setOWhenPicked(Timestamp newOWhenPicked)
  {
    oWhenPicked = newOWhenPicked;
  }
}