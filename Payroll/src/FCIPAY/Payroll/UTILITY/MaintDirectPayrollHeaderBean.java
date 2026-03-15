package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintDirectPayrollHeaderBean extends PayrollBaseHeaderBean implements Serializable
{
  private String txtPayCode1;
  private String txtPayCodeName;
  private String txtEmpNo1;
  private String txtName1;

  public MaintDirectPayrollHeaderBean()
  {
  }

  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }

  public String getTxtPayCodeName()
  {
    return txtPayCodeName;
  }

  public void setTxtPayCodeName(String newTxtPayCodeName)
  {
    txtPayCodeName = newTxtPayCodeName;
  }

  public String getTxtEmpNo1()
  {
    return txtEmpNo1;
  }

  public void setTxtEmpNo1(String newTxtEmpNo1)
  {
    txtEmpNo1 = newTxtEmpNo1;
  }

  public String getTxtName1()
  {
    return txtName1;
  }

  public void setTxtName1(String newTxtName1)
  {
    txtName1 = newTxtName1;
  }  
  
}