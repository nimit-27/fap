package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class NWNPLabourOprtnQueryVO extends PayrollBaseQueryVO implements Serializable
{
   private String effStartDate;   

  public NWNPLabourOprtnQueryVO()
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
