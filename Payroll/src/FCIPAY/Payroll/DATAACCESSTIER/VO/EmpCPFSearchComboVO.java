package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpCPFSearchComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueCadreArrayList;     
  

  public EmpCPFSearchComboVO()
  {
  }
  
  public ArrayList getValueCadreArrayList()
  {
    return valueCadreArrayList;
  }

  public void setValueCadreArrayList(ArrayList newValueCadreArrayList)
  {
    valueCadreArrayList = newValueCadreArrayList;
  }
  
 
 
}