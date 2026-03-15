package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class MaintBadClmtAllowHeaderBeanSixPay extends PayrollBaseHeaderBean implements Serializable
{

  private String txtPayScaleTyp;
  private String txtEffDt;

  public MaintBadClmtAllowHeaderBeanSixPay()
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