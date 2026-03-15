package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class AdhocPayComboVO  extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList groupList;
  private ArrayList categList;

  public AdhocPayComboVO()
  {
  }

  public ArrayList getGroupList()
  {
    return groupList;
  }

  public void setGroupList(ArrayList newGroupList)
  {
    groupList = newGroupList;
  }

  public ArrayList getCategList()
  {
    return categList;
  }

  public void setCategList(ArrayList newCategList)
  {
    categList = newCategList;
  }
}