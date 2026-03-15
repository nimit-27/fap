package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;

public class InterestRateQueryVO implements Serializable 
{
  private String txtDateFrom;
  private String memberType;

  public String getTxtDateFrom()
  {
    return txtDateFrom;
  }

  public void setTxtDateFrom(String newTxtDateFrom)
  {
    txtDateFrom = newTxtDateFrom;
  }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }
}
