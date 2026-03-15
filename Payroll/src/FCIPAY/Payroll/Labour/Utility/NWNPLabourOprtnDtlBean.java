package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class NWNPLabourOprtnDtlBean extends PayrollBaseDetailBean implements Serializable  
{
  private String txtOperation;
   
  //private String txtEffDate;
  
  
  public NWNPLabourOprtnDtlBean()
  {
  }
  
  public String getTxtOperation()
  {
    return txtOperation;
  }

  public void setTxtOperation(String newTxtOperation)
  {
    txtOperation = newTxtOperation;
  } 
  
 
  /*public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }*/  
  
}