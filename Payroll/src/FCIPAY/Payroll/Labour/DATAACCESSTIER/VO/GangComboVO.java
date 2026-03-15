package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class GangComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList mouList;
    public GangComboVO()
    {
    }
    public ArrayList getMouList()
    {
      return mouList;
    }
  
    public void setMouList(ArrayList newMouList)
    {
      mouList = newMouList;
    }
}