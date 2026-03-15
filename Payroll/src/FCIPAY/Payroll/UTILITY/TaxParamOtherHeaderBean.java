package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class TaxParamOtherHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtOtherYYMM;
  private String txtRebLimitAmt;
  private String txtFemAddl;
  private String txtAddlLimit;
  private String txtMediClaimLimit;

  public TaxParamOtherHeaderBean()
  {
  }

  public String getTxtOtherYYMM()
  {
    return txtOtherYYMM;
  }

  public void setTxtOtherYYMM(String newTxtOtherYYMM)
  {
    txtOtherYYMM = newTxtOtherYYMM;
  }

  public String getTxtRebLimitAmt()
  {
    return txtRebLimitAmt;
  }

  public void setTxtRebLimitAmt(String newTxtRebLimitAmt)
  {
    txtRebLimitAmt = newTxtRebLimitAmt;
  }

  public String getTxtFemAddl()
  {
    return txtFemAddl;
  }

  public void setTxtFemAddl(String newTxtFemAddl)
  {
    txtFemAddl = newTxtFemAddl;
  }

  public String getTxtAddlLimit()
  {
    return txtAddlLimit;
  }

  public void setTxtAddlLimit(String newTxtAddlLimit)
  {
    txtAddlLimit = newTxtAddlLimit;
  }
  
  
   public String getTxtMediClaimLimit()
  {
    return txtMediClaimLimit;
  }

  public void setTxtMediClaimLimit(String newTxtMediClaimLimit)
  {
    txtMediClaimLimit = newTxtMediClaimLimit;
  }

}