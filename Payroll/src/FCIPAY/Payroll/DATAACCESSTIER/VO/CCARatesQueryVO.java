package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class CCARatesQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEffDt;
  private String payScaleType;
  private String txtCityType;

  public CCARatesQueryVO()
  {
  }

  public String getTxtEffDt()
  {
    return txtEffDt;
  }

  public void setTxtEffDt(String newTxtEffDt)
  {
    txtEffDt = newTxtEffDt;
  }

  public String getPayScaleType()
  {
    return payScaleType;
  }

  public void setPayScaleType(String newPayScaleType)
  {
    payScaleType = newPayScaleType;
  }

  public String getTxtCityType()
  {
    return txtCityType;
  }

  public void setTxtCityType(String newTxtCityType)
  {
    txtCityType = newTxtCityType;
  }

}