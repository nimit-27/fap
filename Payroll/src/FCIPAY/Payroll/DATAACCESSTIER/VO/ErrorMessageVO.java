package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class ErrorMessageVO  implements Serializable
{
  private boolean bErrorFlag;
  private String errorCode;

  public ErrorMessageVO()
  {
  }

  public boolean isBErrorFlag()
  {
    return bErrorFlag;
  }

  public void setBErrorFlag(boolean newBErrorFlag)
  {
    bErrorFlag = newBErrorFlag;
  }

  public String getErrorCode()
  {
    return errorCode;
  }

  public void setErrorCode(String newErrorCode)
  {
    errorCode = newErrorCode;
  }
}