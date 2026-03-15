package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintInterestRateQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtDateFrom;
  String txtDateTo;
  private String memberType;

  public MaintInterestRateQueryVO()
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
