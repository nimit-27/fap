package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class DpsLabourSORHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  private String txtRegCode;  
  private String txtRegName;  
  private String effStartDate;
  private String txtEndDate;
  private String screenModeSOR1;
  
  public DpsLabourSORHeaderBean()
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
  
  public String getTxtRegCode()
  {
    return txtRegCode;
  }

  public void setTxtRegCode(String newTxtRegCode)
  {
    txtRegCode = newTxtRegCode;
  } 
  
  public String getTxtRegName()
  {
    return txtRegName;
  }

  public void setTxtRegName(String newTxtRegName)
  {
    txtRegName = newTxtRegName;
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