package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class BadClmtQueryVOSixPay extends PayrollBaseQueryVO implements Serializable
{

  private String txtPayScaleTyp;
  private String txtEffDt;

  public BadClmtQueryVOSixPay()
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