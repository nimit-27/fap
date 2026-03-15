package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class PayReportComboVO  extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList categList;

  public PayReportComboVO()
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

}