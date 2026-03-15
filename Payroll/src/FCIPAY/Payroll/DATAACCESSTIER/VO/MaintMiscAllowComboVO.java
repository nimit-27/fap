package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class MaintMiscAllowComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueCategArrayList;

  public MaintMiscAllowComboVO()
  {
  }
  
  
  public ArrayList getValueCategArrayList()
  {
    return valueCategArrayList;
  }

  public void setValueCategArrayList(ArrayList newValueCategArrayList)
  {
    valueCategArrayList = newValueCategArrayList;
  }
}