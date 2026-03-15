package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class LeaseAccomHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  private String txtEmpNo;
  private String txtEmpName;

  public LeaseAccomHeaderBean()
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

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

}