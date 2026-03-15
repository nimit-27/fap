package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintDARatesHeaderBean  extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtYYMM;
  private String txtDAType;
  private String headerMode;

  public MaintDARatesHeaderBean()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }



  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }

  public String getHeaderMode()
  {
    return headerMode;
  }

  public void setHeaderMode(String newHeaderMode)
  {
    headerMode = newHeaderMode;
  }



}