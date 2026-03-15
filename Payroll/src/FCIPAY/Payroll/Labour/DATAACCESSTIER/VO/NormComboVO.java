package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class NormComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList mouList;
    private ArrayList normTypList;
    
    public NormComboVO()
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

    public ArrayList getNormTypList()
    {
      return normTypList;
    }
  
    public void setNormTypList(ArrayList newNormTypList)
    {
      normTypList = newNormTypList;
    }

}