package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
public class ElectReimbQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEffectDate;

  public ElectReimbQueryVO()
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