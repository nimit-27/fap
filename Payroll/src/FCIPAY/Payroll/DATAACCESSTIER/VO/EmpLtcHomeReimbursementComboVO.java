package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpLtcHomeReimbursementComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList payCodeList;
  
  public EmpLtcHomeReimbursementComboVO()
  {
  }
  
  public ArrayList getPayCodeList()
  {
    return payCodeList;
  }
  
  public void setPayCodeList(ArrayList newPayCodeList)
  {
    payCodeList=newPayCodeList;
  }
}