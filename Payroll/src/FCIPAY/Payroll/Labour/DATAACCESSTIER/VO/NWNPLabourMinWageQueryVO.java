package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class NWNPLabourMinWageQueryVO extends PayrollBaseQueryVO implements Serializable
{
   private String txtEffDate;
  

  public NWNPLabourMinWageQueryVO()
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