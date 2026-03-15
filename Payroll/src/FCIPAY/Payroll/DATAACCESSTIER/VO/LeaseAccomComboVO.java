package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class LeaseAccomComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList accomTypList;
  private ArrayList accomPerList;
  
  public LeaseAccomComboVO()
  {
  }

  public ArrayList getAccomTypList()
  {
    return accomTypList;
  }

  public void setAccomTypList(ArrayList newAccomTypList)
  {
    accomTypList = newAccomTypList;
  }
  public ArrayList getAccomPerList()
  {
    return accomPerList;
  }

  public void setAccomPerList(ArrayList newAccomPerList)
  {
    accomPerList = newAccomPerList;
  }
}