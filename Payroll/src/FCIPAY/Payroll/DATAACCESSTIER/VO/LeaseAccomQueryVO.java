package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class LeaseAccomQueryVO extends PayrollBaseQueryVO implements Serializable 
{
  private String txtEmpNo;

  public LeaseAccomQueryVO()
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
}