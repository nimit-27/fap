package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;


public class ProfTaxBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtPtAmount = "";
  private String hdnProfTaxSrlNo = "";
  private String startField;
  private String endField;
  //private String hdnCheck3 = "";
  //private boolean chkDel3;  

  public ProfTaxBean()
  {
    
  }

  
  public ProfTaxBean( String sPtAmtFrom, String  sPtAmtTo, String sPtAmount, String sSrlNo)
  {
    startField = sPtAmtFrom;
    endField = sPtAmtTo;
    txtPtAmount = sPtAmount;
    hdnProfTaxSrlNo = sSrlNo;
    //hdnCheck3 = sCheck;
  }  





  public String getTxtPtAmount()
  {
    return txtPtAmount;
  }

  public void setTxtPtAmount(String newTxtPtAmount)
  {
    txtPtAmount = newTxtPtAmount;
  }

  public String getHdnProfTaxSrlNo()
  {
    return hdnProfTaxSrlNo;
  }

  public void setHdnProfTaxSrlNo(String newHdnProfTaxSrlNo)
  {
    hdnProfTaxSrlNo = newHdnProfTaxSrlNo;
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

 
 
  
}