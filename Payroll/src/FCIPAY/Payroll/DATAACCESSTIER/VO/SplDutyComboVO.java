package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class SplDutyComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList ctgryList;
  private ArrayList areaTypList;

  public SplDutyComboVO()
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
  
  public ArrayList getAreaTypList()
  {
    return areaTypList;
  }

  public void setAreaTypList(ArrayList newAreaTypList)
  {
    areaTypList = newAreaTypList;
  }

}