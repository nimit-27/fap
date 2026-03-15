package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MonthlyPayrollQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String optSelect;
  private String txtEmp;

  public MonthlyPayrollQueryVO()
  {
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }
}