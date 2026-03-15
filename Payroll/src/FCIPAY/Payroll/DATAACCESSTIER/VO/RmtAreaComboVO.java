package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class RmtAreaComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList ctgryList;
  private ArrayList rmtAreaList;

  public RmtAreaComboVO()
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

  public ArrayList getRmtAreaList()
  {
    return rmtAreaList;
  }

  public void setRmtAreaList(ArrayList newRmtAreaList)
  {
    rmtAreaList = newRmtAreaList;
  }
}