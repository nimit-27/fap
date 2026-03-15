package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class TaxParamQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtIncTaxYYMM;

  public TaxParamQueryVO()
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