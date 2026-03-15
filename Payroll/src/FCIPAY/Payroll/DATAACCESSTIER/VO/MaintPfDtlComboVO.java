package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class MaintPfDtlComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList adjPfHdrList;
  private ArrayList adjPfDtlList;

  public MaintPfDtlComboVO()
  {
  }

  public ArrayList getAdjPfHdrList()
  {
    return adjPfHdrList;
  }

  public void setAdjPfHdrList(ArrayList newAdjPfHdrList)
  {
    adjPfHdrList = newAdjPfHdrList;
  }
  
  public ArrayList getAdjPfDtlList()
  {
    return adjPfDtlList;
  }

  public void setAdjPfDtlList(ArrayList newAdjPfDtlList)
  {
    adjPfDtlList = newAdjPfDtlList;
  }
}