package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class OTATypeComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList otaTypList;

  public OTATypeComboVO()
  {
  }

  public ArrayList getOtaTypList()
  {
    return otaTypList;
  }

  public void setOtaTypList(ArrayList newOtaTypList)
  {
    otaTypList = newOtaTypList;
  }
}