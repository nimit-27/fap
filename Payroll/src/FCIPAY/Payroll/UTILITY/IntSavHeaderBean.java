package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class IntSavHeaderBean extends PayrollBaseHeaderBean implements Serializable
{
  private String txtEmpNo1;
  private String txtEmpName1;
  private String txtSavCode1;
  private String txtSavCodeName;

  public IntSavHeaderBean()
  {
  }

  public String getTxtEmpNo1()
  {
    return txtEmpNo1;
  }

  public void setTxtEmpNo1(String newTxtEmpNo1)
  {
    txtEmpNo1 = newTxtEmpNo1;
  }

  public String getTxtEmpName1()
  {
    return txtEmpName1;
  }

  public void setTxtEmpName1(String newTxtEmpName1)
  {
    txtEmpName1 = newTxtEmpName1;
  }

  public String getTxtSavCode1()
  {
    return txtSavCode1;
  }

  public void setTxtSavCode1(String newTxtSavCode1)
  {
    txtSavCode1 = newTxtSavCode1;
  }

  public String getTxtSavCodeName()
  {
    return txtSavCodeName;
  }

  public void setTxtSavCodeName(String newTxtSavCodeName)
  {
    txtSavCodeName = newTxtSavCodeName;
  }
}