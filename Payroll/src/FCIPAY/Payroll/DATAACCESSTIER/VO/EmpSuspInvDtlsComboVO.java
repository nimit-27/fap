package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpSuspInvDtlsComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueInvDtlsList;

  public EmpSuspInvDtlsComboVO()
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