package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpReinstateComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList intervPrdList;     
  

  public EmpReinstateComboVO()
  {
  }
  
  public ArrayList getIntervPrdList()
  {
    return intervPrdList;
  }

  public void setIntervPrdList(ArrayList newIntervPrdList)
  {
    intervPrdList = newIntervPrdList;
  }  
 
}