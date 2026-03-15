package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpMediBillsComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList payCodeList;
  
  public EmpMediBillsComboVO()
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