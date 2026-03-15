package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class NWNPLabourOprtnHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  private String effStartDate;
  private String txtEndDate;
  private String screenModeSOR1;
  
  public NWNPLabourOprtnHeaderBean()
  {
  }
  
  public String getScreenModeSOR1()
  {
    return screenModeSOR1;
  }

  public void setScreenModeSOR1(String newScreenModeSOR1)
  {
    screenModeSOR1 = newScreenModeSOR1;
  }
  
  public String getEffStartDate()
  {
    return effStartDate;
  }

  public void setEffStartDate(String newEffStartDate)
  {
    effStartDate = newEffStartDate;
  }
  
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  }   
  
}