package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class MiscComboVO  extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList categList;
  private ArrayList cadreList;
  private ArrayList payScaleList;

  public MiscComboVO()
  {
  }

  public ArrayList getCategList()
  {
    return categList;
  }

  public void setCategList(ArrayList newCategList)
  {
    categList = newCategList;
  }

  public ArrayList getCadreList()
  {
    return cadreList;
  }

  public void setCadreList(ArrayList newCadreList)
  {
    cadreList = newCadreList;
  }

  public ArrayList getPayScaleList()
  {
    return payScaleList;
  }

  public void setPayScaleList(ArrayList newPayScaleList)
  {
    payScaleList = newPayScaleList;
  }
  
}