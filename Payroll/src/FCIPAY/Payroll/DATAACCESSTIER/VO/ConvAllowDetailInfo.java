package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class ConvAllowDetailInfo extends BaseDetailInfo implements Serializable
{
  private String headerPrimaryKey;
  private String txtEffectDate;
  private String payScaleType;

  public ConvAllowDetailInfo()
  {
  }

  public String getHeaderPrimaryKey()
  {
    return headerPrimaryKey;
  }

  public void setHeaderPrimaryKey(String newHeaderPrimaryKey)
  {
    headerPrimaryKey = newHeaderPrimaryKey;
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