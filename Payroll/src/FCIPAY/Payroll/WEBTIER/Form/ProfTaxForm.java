package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class ProfTaxForm extends PayrollBaseForm
{
  private String txtPtAmtFrom[];
  private String txtPtAmtTo[];
  private String txtPtAmount[];
  private String hdnProfTaxSrlNo[];
  private String txtProfTaxYYMM;
  private String txtStateCode;
  private String txtPeriodicity;
  private String txtStateDesc;
  private ArrayList lstProfTax = new ArrayList();
  private String screenTypeProf;
  private String screenType;
  private String screenModeProf;
  private String screenModeProf1;

  

 public String getTxtPeriodicity()
  {
    return txtPeriodicity;
  }

  public void setTxtPeriodicity(String newTxtPeriodicity)
  {
    txtPeriodicity = newTxtPeriodicity;
  }

 public String[] getTxtPtAmtFrom()
  {
    return txtPtAmtFrom;
  }

  public void setTxtPtAmtFrom(String[] newTxtPtAmtFrom)
  {
    txtPtAmtFrom = newTxtPtAmtFrom;
  }

  public String[] getTxtPtAmtTo()
  {
    return txtPtAmtTo;
  }

  public void setTxtPtAmtTo(String[] newTxtPtAmtTo)
  {
    txtPtAmtTo = newTxtPtAmtTo;
  }

  public String[] getTxtPtAmount()
  {
    return txtPtAmount;
  }

  public void setTxtPtAmount(String[] newTxtPtAmount)
  {
    txtPtAmount = newTxtPtAmount;
  }

  public String[] getHdnProfTaxSrlNo()
  {
    return hdnProfTaxSrlNo;
  }

  public void setHdnProfTaxSrlNo(String[] newHdnProfTaxSrlNo)
  {
    hdnProfTaxSrlNo = newHdnProfTaxSrlNo;
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

  public String getTxtStateDesc()
  {
    return txtStateDesc;
  }

  public void setTxtStateDesc(String newTxtStateDesc)
  {
    txtStateDesc = newTxtStateDesc;
  }
  public ArrayList getLstProfTax()
  {
        return lstProfTax;
  }

  public void setLstProfTax(ArrayList newlstProfTax)
  {
        lstProfTax = newlstProfTax;
   }

  public String getScreenTypeProf()
  {
    return screenTypeProf;
  }

  public void setScreenTypeProf(String newScreenTypeProf)
  {
    screenTypeProf = newScreenTypeProf;
  }

  public String getScreenType()
  {
    return screenType;
  }

  public void setScreenType(String newScreenType)
  {
    screenType = newScreenType;
  }



  public String getScreenModeProf()
  {
    return screenModeProf;
  }

  public void setScreenModeProf(String newScreenModeProf)
  {
    screenModeProf = newScreenModeProf;
  }

  public String getScreenModeProf1()
  {
    return screenModeProf1;
  }

  public void setScreenModeProf1(String newScreenModeProf1)
  {
    screenModeProf1 = newScreenModeProf1;
  }



 



}