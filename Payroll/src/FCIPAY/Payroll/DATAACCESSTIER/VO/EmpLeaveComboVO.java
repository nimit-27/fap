package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpLeaveComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList lvTypList;
    private ArrayList lvDepTypList;
    public EmpLeaveComboVO()
    {
    }
    public ArrayList getLvTypList()
    {
      return lvTypList;
    }
  
    public void setLvTypList(ArrayList newLvTypList)
    {
      lvTypList = newLvTypList;
    }
    
     public ArrayList getLvDepTypList()
    {
      return lvDepTypList;
    }
  
    public void setLvDepTypList(ArrayList newLvDepTypList)
    {
      lvDepTypList = newLvDepTypList;
    }
  
}