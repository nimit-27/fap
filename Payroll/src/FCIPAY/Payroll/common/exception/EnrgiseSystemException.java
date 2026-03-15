package FCIPAY.Payroll.common.exception;
import java.io.Serializable;
import FCIPAY.Payroll.common.exception.BaseException;
public class EnrgiseSystemException extends BaseException implements Serializable
{
  private Exception oRootCause; // Root Cause such as SQLException


  public EnrgiseSystemException()
  {
    super();    
  }
  public EnrgiseSystemException(Exception oExcp)
  {
    this.oRootCause = oExcp;
  }

  public EnrgiseSystemException(String sKey, Exception oExcp)
  {
    super(sKey);
    this.oRootCause = oExcp;    
  }

}