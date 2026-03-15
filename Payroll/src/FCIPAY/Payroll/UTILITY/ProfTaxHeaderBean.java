package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ProfTaxHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtProfTaxYYMM;
  private String txtStateCode;
  private String txtPeriodicity;
  private String screenModeProf;
  private String txtStateDesc;

  public ProfTaxHeaderBean()
  {
  }

  public String getTxtProfTaxYYMM()
  {
    return txtProfTaxYYMM;
  }

  public void setTxtProfTaxYYMM(String newTxtProfTaxYYMM)
  {
    txtProfTaxYYMM = newTxtProfTaxYYMM;
  }

  public String getTxtStateCode()
  {
    return txtStateCode;
  }

  public void setTxtStateCode(String newTxtStateCode)
  {
    txtStateCode = newTxtStateCode;
  }

  public String getTxtPeriodicity()
  {
    return txtPeriodicity;
  }

  public void setTxtPeriodicity(String newTxtPeriodicity)
  {
    txtPeriodicity = newTxtPeriodicity;
  }

  public String getScreenModeProf()
  {
    return screenModeProf;
  }

  public void setScreenModeProf(String newScreenModeProf)
  {
    screenModeProf = newScreenModeProf;
  }

  public String getTxtStateDesc()
  {
    return txtStateDesc;
  }

  public void setTxtStateDesc(String newTxtStateDesc)
  {
    txtStateDesc = newTxtStateDesc;
  }
}