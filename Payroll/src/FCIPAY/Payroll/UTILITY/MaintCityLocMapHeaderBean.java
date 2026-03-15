package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintCityLocMapHeaderBean  extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtLocidSrch;
  private String txtLocSrch;

  public MaintCityLocMapHeaderBean()
  {
  }

  public String getTxtLocidSrch()
  {
    return txtLocidSrch;
  }

  public void setTxtLocidSrch(String newTxtLocidSrch)
  {
    txtLocidSrch = newTxtLocidSrch;
  }
  
  public String getTxtLocSrch()
  {
    return txtLocSrch;
  }

  public void setTxtLocSrch(String newTxtLocSrch)
  {
    txtLocSrch = newTxtLocSrch;
  }
}