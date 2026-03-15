package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpPromotionComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueCategArrayList;    
  private ArrayList valueEmpStatArrayList;   
  private ArrayList valuePromTypeArrayList;  
  private ArrayList valueDPSPromTypeArrayList;
  

  public EmpPromotionComboVO()
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
  
   public ArrayList getValuePromTypeArrayList()
  {
    return valuePromTypeArrayList;
  }

  public void setValuePromTypeArrayList(ArrayList newValuePromTypeArrayList)
  {
    valuePromTypeArrayList = newValuePromTypeArrayList;
  }
  
  public ArrayList getValueDPSPromTypeArrayList()
  {
    return valueDPSPromTypeArrayList;
  }

  public void setValueDPSPromTypeArrayList(ArrayList newValueDPSPromTypeArrayList)
  {
    valueDPSPromTypeArrayList = newValueDPSPromTypeArrayList;
  }
 
}