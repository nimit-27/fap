package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class DpsLabourSORViewQryVO extends PayrollBaseQueryVO implements Serializable
{
   private String effStartDate;   

  public DpsLabourSORViewQryVO()
  {
  }

 public String getEffStartDate()
  {
    return effStartDate;
  }

  public void setEffStartDate(String newEffStartDate)
  {
    effStartDate = newEffStartDate;
  }  
  
}