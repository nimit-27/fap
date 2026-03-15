package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpTrnsfrSalRlsComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList valueSalRlsYrMnthList;
  private ArrayList incentiveRlsYrMnthList; //added by swapnendu Dt 20-06-2012.

  public EmpTrnsfrSalRlsComboVO()
  {
  }  
  
  public ArrayList getValueSalRlsYrMnthList()
  {
    return valueSalRlsYrMnthList;
  }

  public void setValueSalRlsYrMnthList(ArrayList newValueSalRlsYrMnthList)
  {
    valueSalRlsYrMnthList = newValueSalRlsYrMnthList;
  }

  public ArrayList getIncentiveRlsYrMnthList()
  {
    return incentiveRlsYrMnthList;
  }

  public void setIncentiveRlsYrMnthList(ArrayList newIncentiveRlsYrMnthList)
  {
    incentiveRlsYrMnthList = newIncentiveRlsYrMnthList;
  }
}