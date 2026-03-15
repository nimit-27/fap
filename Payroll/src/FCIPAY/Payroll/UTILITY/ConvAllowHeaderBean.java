package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ConvAllowHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtEffectDate;
  private String payScaleType;

  public ConvAllowHeaderBean()
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

  public String getPayScaleType()
  {
    return payScaleType;
  }

  public void setPayScaleType(String newPayScaleType)
  {
    payScaleType = newPayScaleType;
  }
}