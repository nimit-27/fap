package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class InrRateDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtDateFrom;
  private String txtDateTo;
  private String memberType;

  public InrRateDetailInfo()
  {
  }

  public String getTxtDateFrom()
  {
    return txtDateFrom;
  }

  public void setTxtDateFrom(String newTxtDateFrom)
  {
    txtDateFrom = newTxtDateFrom;
  }

  public String getTxtDateTo()
  {
    return txtDateTo;
  }

  public void setTxtDateTo(String newTxtDateTo)
  {
    txtDateTo = newTxtDateTo;
  }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }
}
