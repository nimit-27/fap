package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class IncomeTaxBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtItRebPer = "";
  private String txtItSurPer = "";
  private String txtItTaxPer = ""; 
  private String hdnIncTaxSrlNo = "";
  private String startField;
  private String endField;
  private String txtItFemAmtTo = "";
  private String txtItEdnCess = "";
  private String txtItFemAmtFrom = "";

  public IncomeTaxBean()
  {
    
  }
  
  public IncomeTaxBean( String sItAmtFrom, String sItAmtTo, String sItRebPer, String sItSurPer, String sItTaxPer, String sFemAmtTo, String  sEdnCess, String sSrlNo)
  {
    startField = sItAmtFrom;
    endField = sItAmtTo;
    txtItRebPer = sItRebPer;
    txtItSurPer = sItSurPer;
    txtItTaxPer = sItTaxPer;
    txtItFemAmtTo = sFemAmtTo;
    txtItEdnCess = sEdnCess;
    hdnIncTaxSrlNo= sSrlNo;
  }

 

  public String getTxtItRebPer()
  {
    return txtItRebPer;
  }

  public void setTxtItRebPer(String newTxtItRebPer)
  {
    txtItRebPer = newTxtItRebPer;
  }

  public String getTxtItSurPer()
  {
    return txtItSurPer;
  }

  public void setTxtItSurPer(String newTxtItSurPer)
  {
    txtItSurPer = newTxtItSurPer;
  }

  public String getTxtItTaxPer()
  {
    return txtItTaxPer;
  }

  public void setTxtItTaxPer(String newTxtItTaxPer)
  {
    txtItTaxPer = newTxtItTaxPer;
  }

  public String getHdnIncTaxSrlNo()
  {
    return hdnIncTaxSrlNo;
  }

  public void setHdnIncTaxSrlNo(String newHdnIncTaxSrlNo)
  {
    hdnIncTaxSrlNo = newHdnIncTaxSrlNo;
  } 

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }

  public String getTxtItFemAmtTo()
  {
    return txtItFemAmtTo;
  }

  public void setTxtItFemAmtTo(String newTxtItFemAmtTo)
  {
    txtItFemAmtTo = newTxtItFemAmtTo;
  }

  public String getTxtItEdnCess()
  {
    return txtItEdnCess;
  }

  public void setTxtItEdnCess(String newTxtItEdnCess)
  {
    txtItEdnCess = newTxtItEdnCess;
  }

  public String getTxtItFemAmtFrom()
  {
    return txtItFemAmtFrom;
  }

  public void setTxtItFemAmtFrom(String newTxtItFemAmtFrom)
  {
    txtItFemAmtFrom = newTxtItFemAmtFrom;
  }





}