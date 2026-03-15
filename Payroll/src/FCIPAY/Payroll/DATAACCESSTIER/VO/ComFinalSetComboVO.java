package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class ComFinalSetComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList sepTypList;

  public ComFinalSetComboVO()
  {
  }

  public ArrayList getSepTypList()
  {
    return sepTypList;
  }
  
  public void setSepTypList(ArrayList newSepTypList)
  {
    sepTypList = newSepTypList;
  }

}