package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class AdhocPayHeaderBean extends PayrollBaseHeaderBean implements Serializable
{
  private String txtPayYYMM;
  private String txtPayCode;
  private String txtPayMode;
  private String txtPayCodeDesc;
  private String headerMode;
  private String hdnPayrollFlag;

  public AdhocPayHeaderBean()
  {
  }

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }

  public String getHeaderMode()
  {
    return headerMode;
  }

  public void setHeaderMode(String newHeaderMode)
  {
    headerMode = newHeaderMode;
  }

  public String getHdnPayrollFlag()
  {
    return hdnPayrollFlag;
  }

  public void setHdnPayrollFlag(String newHdnPayrollFlag)
  {
    hdnPayrollFlag = newHdnPayrollFlag;
  }
}