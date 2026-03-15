package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class DpsLabourASORQueryVO extends PayrollBaseQueryVO implements Serializable
{
   private String txtEffDate;
  

  public DpsLabourASORQueryVO()
  {
  }

 public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  } 
  
}