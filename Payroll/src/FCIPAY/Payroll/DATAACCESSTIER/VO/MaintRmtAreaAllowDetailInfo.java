package FCIPAY.Payroll.DATAACCESSTIER.VO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import java.io.Serializable;

public class MaintRmtAreaAllowDetailInfo extends BaseDetailInfo implements Serializable
{

  private String txtPayScaleTyp;
  private String txtEffDt;

  public MaintRmtAreaAllowDetailInfo()
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