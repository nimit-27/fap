package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpPenalityComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueCategArrayList;    
  private ArrayList valueEmpStatArrayList;   
  private ArrayList valuePenaTypeArrayList;   
  private ArrayList incrTypeArraylist;

  public EmpPenalityComboVO()
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
  
  public ArrayList getValueEmpStatArrayList()
  {
    return valueEmpStatArrayList;
  }

  public void setValueEmpStatArrayList(ArrayList newValueEmpStatArrayList)
  {
    valueEmpStatArrayList = newValueEmpStatArrayList;
  }
  
  public ArrayList getValuePenaTypeArrayList()
  {
    return valuePenaTypeArrayList;
  }

  public void setValuePenaTypeArrayList(ArrayList newValuePenaTypeArrayList)
  {
    valuePenaTypeArrayList = newValuePenaTypeArrayList;
  }
  
  public ArrayList getIncrTypeArraylist()
  {
    return incrTypeArraylist;
  }

  public void setIncrTypeArraylist(ArrayList newIncrTypeArraylist)
  {
    incrTypeArraylist = newIncrTypeArraylist;
  }
}