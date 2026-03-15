package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class TaxParamOtherForm extends PayrollBaseForm 
{
  private String txtRebLimitAmt;
  private String txtMediClaimLimit;
  private String txtFemAddl;
  private String txtAddlLimit;
  private String txtOtherYYMM;
  private String screenType;
  

  public String getTxtRebLimitAmt()
  {
    return txtRebLimitAmt;
  }

  public void setTxtRebLimitAmt(String newTxtRebLimitAmt)
  {
    txtRebLimitAmt = newTxtRebLimitAmt;
  }


 public String getTxtMediClaimLimit()
  {
    return txtMediClaimLimit;
  }

  public void setTxtMediClaimLimit(String newTxtMediClaimLimit)
  {
    txtMediClaimLimit = newTxtMediClaimLimit;
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

  public String getTxtOtherYYMM()
  {
    return txtOtherYYMM;
  }

  public void setTxtOtherYYMM(String newTxtOtherYYMM)
  {
    txtOtherYYMM = newTxtOtherYYMM;
  }

  public String getScreenType()
  {
    return screenType;
  }

  public void setScreenType(String newScreenType)
  {
    screenType = newScreenType;
  }
}