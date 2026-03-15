package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class ConvAllowQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEffectDate;
  private String payScaleType;

  public ConvAllowQueryVO()
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