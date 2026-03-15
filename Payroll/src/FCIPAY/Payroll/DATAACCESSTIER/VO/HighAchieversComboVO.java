package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class HighAchieversComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList dateList;
  public HighAchieversComboVO()
  {
  }
   public ArrayList getDateList()
    {
      return dateList;
    }
  
    public void setDateList(ArrayList newDateList)
    {
      dateList = newDateList;
    } 
}