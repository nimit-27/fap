package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;


public class MaintTransportSubsideBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtMonth;
  private String txtYYMM;
  private String txtAmt;

  public MaintTransportSubsideBean()
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

  public String getTxtMonth()
  {
    return txtMonth;
  }

  public void setTxtMonth(String newTxtMonth)
  {
    txtMonth = newTxtMonth;
  }
  
  public String getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }
}