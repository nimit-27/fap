package FCIPAY.Payroll.UTILITY;
import java.sql.Timestamp;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class BasicArrearHeaderBean extends PayrollBaseHeaderBean implements Serializable
{
  private String txtpayYYMM;
  private String screenModePay1;
  private String hdnPayrollFlag;
  private String hdnCurYYMM;
  private String hdnPayStatus;
  
  public BasicArrearHeaderBean()
  {
  }

  public String getTxtpayYYMM()
  {
    return txtpayYYMM;
  }

  public void setTxtpayYYMM(String newTxtpayYYMM)
  {
    txtpayYYMM = newTxtpayYYMM;
  }

  public String getScreenModePay1()
  {
    return screenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    screenModePay1 = newScreenModePay1;
  }

  public String getHdnPayrollFlag()
  {
    return hdnPayrollFlag;
  }

  public void setHdnPayrollFlag(String newHdnPayrollFlag)
  {
    hdnPayrollFlag = newHdnPayrollFlag;
  }

  public String getHdnCurYYMM()
  {
    return hdnCurYYMM;
  }

  public void setHdnCurYYMM(String newHdnCurYYMM)
  {
    hdnCurYYMM = newHdnCurYYMM;
  }

  public String getHdnPayStatus()
  {
    return hdnPayStatus;
  }

  public void setHdnPayStatus(String newHdnPayStatus)
  {
    hdnPayStatus = newHdnPayStatus;
  }

 
}