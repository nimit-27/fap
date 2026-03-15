package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class HndlingNormComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList mouList;
    private ArrayList normUnitList;
    
    public HndlingNormComboVO()
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

    public ArrayList getNormUnitList()
    {
      return normUnitList;
    }
  
    public void setNormUnitList(ArrayList newNormUnitList)
    {
      normUnitList = newNormUnitList;
    }

}