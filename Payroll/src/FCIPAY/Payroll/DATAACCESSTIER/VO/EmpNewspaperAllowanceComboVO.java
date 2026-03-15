package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpNewspaperAllowanceComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList payCodeList;
  
  public EmpNewspaperAllowanceComboVO()
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