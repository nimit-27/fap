package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintBankMastHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtBankCode;
  private String txtBankName;
  private String ScreenModePay1;

  public MaintBankMastHeaderBean()
  {
  }

  public String getTxtBankCode()
  {
    return txtBankCode;
  }

  public void setTxtBankCode(String newTxtBankCode)
  {
    txtBankCode = newTxtBankCode;
  }

  public String getTxtBankName()
  {
    return txtBankName;
  }

  public void setTxtBankName(String newTxtBankName)
  {
    txtBankName = newTxtBankName;
  }

  public String getScreenModePay1()
  {
    return ScreenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    ScreenModePay1 = newScreenModePay1;
  }
  
}