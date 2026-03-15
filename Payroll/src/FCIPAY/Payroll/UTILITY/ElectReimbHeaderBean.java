package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ElectReimbHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtEffectDate;

  public ElectReimbHeaderBean()
  {
  }

  public String getTxtEffectDate()
  {
    return txtEffectDate;
  }

  public void setTxtEffectDate(String newTxtEffectDate)
  {
    txtEffectDate = newTxtEffectDate;
  }
}