package FCIPAY.Payroll.DATAACCESSTIER.VO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import java.io.Serializable;

public class MaintTrblAreaAllowDetailInfo extends BaseDetailInfo implements Serializable
{

  private String txtPayScaleTyp;
  private String txtEffDt;

  public MaintTrblAreaAllowDetailInfo()
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