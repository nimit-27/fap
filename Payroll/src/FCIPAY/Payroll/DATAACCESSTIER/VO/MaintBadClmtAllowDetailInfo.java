package FCIPAY.Payroll.DATAACCESSTIER.VO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import java.io.Serializable;

public class MaintBadClmtAllowDetailInfo extends BaseDetailInfo implements Serializable
{

  private String txtPayScaleTyp;
  private String txtEffDt;

  public MaintBadClmtAllowDetailInfo()
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