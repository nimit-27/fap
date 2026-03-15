package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class ProfTaxDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtProfTaxYYMM;
  private String txtStateCode;
  private String txtPeriodicity;

  public ProfTaxDetailInfo()
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
}