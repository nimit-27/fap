package FCIPAY.Payroll.DATAACCESSTIER.VO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import java.io.Serializable;

public class CCARatesDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtCityType;
  private String txtEffDt;
  private String payScaleType;

  public CCARatesDetailInfo()
  {
  }

  public String getTxtCityType()
  {
    return txtCityType;
  }

  public void setTxtCityType(String newTxtCityType)
  {
    txtCityType = newTxtCityType;
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
}