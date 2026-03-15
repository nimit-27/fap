package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class MaintPFDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEmpNo;
  private String txtFromYear;

  public MaintPFDetailInfo()
  {
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtFromYear()
  {
    return txtFromYear;
  }

  public void setTxtFromYear(String newTxtFromYear)
  {
    txtFromYear = newTxtFromYear;
  }
}