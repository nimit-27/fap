package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpSuspSlryRlsComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueSalRlsYrMnthList;

  public EmpSuspSlryRlsComboVO()
  {
  }  
  public ArrayList getValueSalRlsYrMnthList()
  {
    return valueSalRlsYrMnthList;
  }

  public void setValueSalRlsYrMnthList(ArrayList newValueSalRlsYrMnthList)
  {
    valueSalRlsYrMnthList = newValueSalRlsYrMnthList;
  }
 
}