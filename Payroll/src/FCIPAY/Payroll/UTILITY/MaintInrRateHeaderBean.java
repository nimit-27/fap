package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintInrRateHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtDateFrom;
  private String txtDateTo;
  private String memberType;

  public MaintInrRateHeaderBean()
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
