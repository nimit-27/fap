package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class PFTranCodeBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtCode;
  private String txtDesc;

  public PFTranCodeBean()
  {
  }

  public String getTxtCode()
  {
    return txtCode;
  }

  public void setTxtCode(String newTxtCode)
  {
    txtCode = newTxtCode;
  }

  public String getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String newTxtDesc)
  {
    txtDesc = newTxtDesc;
  }
}