package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class IncomeTaxParamForm extends PayrollBaseForm 
{
  private String txtItAmtFrom[];
  private String txtItAmtTo[];
  private String txtItTaxPer[];
  private String txtItRebPer[];
  private String txtItSurPer[];
  private ArrayList lstInstrDtls = new ArrayList();  
  private String txtIncTaxYYMM;
  private String hdnIncTaxSrlNo[] = null;
  private String screenType;
  private String txtItFemAmtTo[] = null;
  private String txtItEdnCess[] = null;
  private String txtItFemAmtFrom[] = null;

  public IncomeTaxParamForm()
  {
  }

  public String[] getTxtItAmtFrom()
  {
    return txtItAmtFrom;
  }

  public void setTxtItAmtFrom(String[] newTxtItAmtFrom)
  {
    txtItAmtFrom = newTxtItAmtFrom;
  }

  public String[] getTxtItAmtTo()
  {
    return txtItAmtTo;
  }

  public void setTxtItAmtTo(String[] newTxtItAmtTo)
  {
    txtItAmtTo = newTxtItAmtTo;
  }

  public String[] getTxtItTaxPer()
  {
    return txtItTaxPer;
  }

  public void setTxtItTaxPer(String[] newTxtItTaxPer)
  {
    txtItTaxPer = newTxtItTaxPer;
  }

  public String[] getTxtItRebPer()
  {
    return txtItRebPer;
  }

  public void setTxtItRebPer(String[] newTxtItRebPer)
  {
    txtItRebPer = newTxtItRebPer;
  }

  public String[] getTxtItSurPer()
  {
    return txtItSurPer;
  }

  public void setTxtItSurPer(String[] newTxtItSurPer)
  {
    txtItSurPer = newTxtItSurPer;
  }

   public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }    

  public String getTxtIncTaxYYMM()
  {
    return txtIncTaxYYMM;
  }

  public void setTxtIncTaxYYMM(String newTxtIncTaxYYMM)
  {
    txtIncTaxYYMM = newTxtIncTaxYYMM;
  }

  public String[] getHdnIncTaxSrlNo()
  {
    return hdnIncTaxSrlNo;
  }

  public void setHdnIncTaxSrlNo(String[] newHdnIncTaxSrlNo)
  {
    hdnIncTaxSrlNo = newHdnIncTaxSrlNo;
  }

  public String getScreenType()
  {
    return screenType;
  }

  public void setScreenType(String newScreenType)
  {
    screenType = newScreenType;
  }

  public String[] getTxtItFemAmtTo()
  {
    return txtItFemAmtTo;
  }

  public void setTxtItFemAmtTo(String[] newTxtItFemAmtTo)
  {
    txtItFemAmtTo = newTxtItFemAmtTo;
  }

  public String[] getTxtItEdnCess()
  {
    return txtItEdnCess;
  }

  public void setTxtItEdnCess(String[] newTxtItEdnCess)
  {
    txtItEdnCess = newTxtItEdnCess;
  }

  public String[] getTxtItFemAmtFrom()
  {
    return txtItFemAmtFrom;
  }

  public void setTxtItFemAmtFrom(String[] newTxtItFemAmtFrom)
  {
    txtItFemAmtFrom = newTxtItFemAmtFrom;
  }
}