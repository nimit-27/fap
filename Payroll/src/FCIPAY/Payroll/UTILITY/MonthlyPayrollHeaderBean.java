package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MonthlyPayrollHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String optSelect;
  private String txtEmp;
  private String hdnMaxRebFlag;
  public MonthlyPayrollHeaderBean()
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
  
   public String getHdnMaxRebFlag()
  {
    return hdnMaxRebFlag;
  }

  public void setHdnMaxRebFlag(String newHdnMaxRebFlag)
  {
    hdnMaxRebFlag = newHdnMaxRebFlag;
  }
}