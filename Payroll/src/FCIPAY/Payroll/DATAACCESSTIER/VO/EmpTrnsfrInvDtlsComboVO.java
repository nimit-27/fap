package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpTrnsfrInvDtlsComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueInvDtlsList;

  public EmpTrnsfrInvDtlsComboVO()
  {
  }  
  public ArrayList getValueInvDtlsList()
  {
    return valueInvDtlsList;
  }

  public void setValueInvDtlsList(ArrayList newValueInvDtlsList)
  {
    valueInvDtlsList = newValueInvDtlsList;
  }
 
}