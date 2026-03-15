package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class TrblAreaAllowHeaderBean extends PayrollBaseHeaderBean implements Serializable
{

  private String txtPayScaleTyp;
  private String txtEffDt;

  public TrblAreaAllowHeaderBean()
  {
  }

  public String getTxtPayScaleTyp()
  {
    return txtPayScaleTyp;
  }

  public void setTxtPayScaleTyp(String newTxtPayScaleTyp)
  {
    txtPayScaleTyp = newTxtPayScaleTyp;
  }

  public String getTxtEffDt()
  {
    return txtEffDt;
  }

  public void setTxtEffDt(String newTxtEffDt)
  {
    txtEffDt = newTxtEffDt;
  }

}