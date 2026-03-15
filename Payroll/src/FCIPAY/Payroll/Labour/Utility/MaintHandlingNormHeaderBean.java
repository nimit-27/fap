package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintHandlingNormHeaderBean extends PayrollBaseHeaderBean 
{
    private String txtEffDate;
    private String txtMou;
  
  public MaintHandlingNormHeaderBean()
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

  public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  } 

}