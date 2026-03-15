package FCIPAY.Payroll.common.vo;
import java.sql.Timestamp;
import java.io.Serializable;
public class BaseVO implements Serializable 
{
  private Timestamp oWhenPicked = null;
  private long firstPosition = 0; //First position
  private long lastPosition = 0; //Last position
  
 public BaseVO()
  {
  }

  public Timestamp getOWhenPicked()
  {
    return oWhenPicked;
  }

  public void setOWhenPicked(Timestamp newOWhenPicked)
  {
    oWhenPicked = newOWhenPicked;
  }

  public long getFirstPosition()
  {
    return firstPosition;
  }

  public void setFirstPosition(long newFirstPosition)
  {
    firstPosition = newFirstPosition;
  }

  public long getLastPosition()
  {
    return lastPosition;
  }

  public void setLastPosition(long newLastPosition)
  {
    lastPosition = newLastPosition;
  }
}