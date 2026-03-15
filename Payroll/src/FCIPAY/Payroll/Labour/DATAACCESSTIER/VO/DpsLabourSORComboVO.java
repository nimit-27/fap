package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class DpsLabourSORComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueServiceList;  

  public DpsLabourSORComboVO()
  {
  }

  public ArrayList getValueServiceList()
  {
    return valueServiceList;
  }

  public void setValueServiceList(ArrayList newValueServiceList)
  {
    valueServiceList = newValueServiceList;
  }
  
}