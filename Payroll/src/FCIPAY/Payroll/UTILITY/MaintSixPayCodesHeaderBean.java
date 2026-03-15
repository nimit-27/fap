package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintSixPayCodesHeaderBean  extends PayrollBaseHeaderBean implements Serializable  
{
  private String txtPayCode1;
  private String txtDescription;
  


  public MaintSixPayCodesHeaderBean()
  {
  }


  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

 
}