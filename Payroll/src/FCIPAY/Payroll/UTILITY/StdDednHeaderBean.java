package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class StdDednHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtStdDednYYMM;
  private String screenModeStd;

  public StdDednHeaderBean()
  {
  }

  public String getTxtStdDednYYMM()
  {
    return txtStdDednYYMM;
  }

  public void setTxtStdDednYYMM(String newTxtStdDednYYMM)
  {
    txtStdDednYYMM = newTxtStdDednYYMM;
  }

  public String getScreenModeStd()
  {
    return screenModeStd;
  }

  public void setScreenModeStd(String newScreenModeStd)
  {
    screenModeStd = newScreenModeStd;
  }

}