package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class GISComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList ctgryArr;

  public GISComboVO()
  {
  }

  public ArrayList getCtgryArr()
  {
    return ctgryArr;
  }

  public void setCtgryArr(ArrayList newCtgryArr)
  {
    ctgryArr = newCtgryArr;
  }
}