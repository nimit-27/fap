package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class ExtSavQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo1;
  private String txtSavCode1;

  public ExtSavQueryVO()
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

  public String getTxtSavCode1()
  {
    return txtSavCode1;
  }

  public void setTxtSavCode1(String newTxtSavCode1)
  {
    txtSavCode1 = newTxtSavCode1;
  }
}