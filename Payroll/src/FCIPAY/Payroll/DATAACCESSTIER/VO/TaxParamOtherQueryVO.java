package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class TaxParamOtherQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtOtherYYMM;

  public TaxParamOtherQueryVO()
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
}