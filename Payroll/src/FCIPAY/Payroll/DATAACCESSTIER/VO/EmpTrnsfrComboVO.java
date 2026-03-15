package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpTrnsfrComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList trnsfrReasonList;
  
  public EmpTrnsfrComboVO()
  {
  }
  
  public ArrayList getTrnsfrReasonList()
  {
    return trnsfrReasonList;
  }
  
  public void setTrnsfrReasonList(ArrayList newTrnsfrReasonList)
  {
    trnsfrReasonList=newTrnsfrReasonList;
  }
}