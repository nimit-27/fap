package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class SiteTypeComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList locTypList;

  public SiteTypeComboVO()
  {
  }

  public ArrayList getLocTypList()
  {
    return locTypList;
  }

  public void setLocTypList(ArrayList newLocTypList)
  {
    locTypList = newLocTypList;
  }
}