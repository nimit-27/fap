package FCIPAY.Payroll.UTILITY;
import java.sql.Timestamp;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class PayScaleHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  public String txtRevYYMM;
  public String lstPayScale;
  private String screenModePay1;
  private String txtPayScaleType;
  public PayScaleHeaderBean()
  {
  }


 //added by sakshi starts 26.12.2008

   public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
// added by sakshi ends 26.12.2008
  public String getTxtRevYYMM()
  {
    return txtRevYYMM;
  }

  public void setTxtRevYYMM(String newTxtRevYYMM)
  {
    txtRevYYMM = newTxtRevYYMM;
  }

  public String getLstPayScale()
  {
    return lstPayScale;
  }

  public void setLstPayScale(String newLstPayScale)
  {
    lstPayScale = newLstPayScale;
  }

  public String getScreenModePay1()
  {
    return screenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    screenModePay1 = newScreenModePay1;
  }
}