package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class TaxParamHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtIncTaxYYMM;

  public TaxParamHeaderBean()
  {
  }

  public String getTxtIncTaxYYMM()
  {
    return txtIncTaxYYMM;
  }

  public void setTxtIncTaxYYMM(String newTxtIncTaxYYMM)
  {
    txtIncTaxYYMM = newTxtIncTaxYYMM;
  }
}