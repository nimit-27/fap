package FCIPAY.Payroll.common.exception;
import java.util.ArrayList;
import java.io.Serializable;
public class BaseException extends Exception implements Serializable
{
  private String sKey;
  
  public BaseException()
  {
    
  }


  public BaseException(String sKey)
  {
    this.sKey = sKey;
  }
  
  public String getKey()
  {
    return sKey;
  }

  public void setKey(String sMessageKey)
  {
    sKey = sMessageKey;
  }

}