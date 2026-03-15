package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpSuspensionComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueRevokTypeList;     
  

  public EmpSuspensionComboVO()
  {
  }
  
  public ArrayList getValueRevokTypeList()
  {
    return valueRevokTypeList;
  }

  public void setValueRevokTypeList(ArrayList newValueRevokTypeList)
  {
    valueRevokTypeList = newValueRevokTypeList;
  }
  
 
 
}