package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class ProjectComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList ctgryList;

  public ProjectComboVO()
  {
  }

  public ArrayList getCtgryList()
  {
    return ctgryList;
  }

  public void setCtgryList(ArrayList newCtgryList)
  {
    ctgryList = newCtgryList;
  }
}