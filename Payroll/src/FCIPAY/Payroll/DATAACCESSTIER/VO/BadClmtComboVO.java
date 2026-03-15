package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class BadClmtComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList ctgryList;

  public BadClmtComboVO()
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