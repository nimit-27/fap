package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class DpsLabourSORDtlBean extends PayrollBaseDetailBean implements Serializable  
{
  //private String txtRegCode=""; 
  private String txtOperation;
  private String txtBagRateAbv65;
  private String txtBagRateBlw65;  
  //private String txtEffDate;
  
  
  public DpsLabourSORDtlBean()
  {
  }
  
   /*public String getTxtRegCode()
  {
    return txtRegCode;
  }

  public void setTxtRegCode(String newTxtRegCode)
  {
    txtRegCode = newTxtRegCode;
  } */
  
  public String getTxtOperation()
  {
    return txtOperation;
  }

  public void setTxtOperation(String newTxtOperation)
  {
    txtOperation = newTxtOperation;
  } 
  
  public String getTxtBagRateAbv65()
  {
    return txtBagRateAbv65;
  }

  public void setTxtBagRateAbv65(String newTxtBagRateAbv65)
  {
    txtBagRateAbv65 = newTxtBagRateAbv65;
  }
  
  public String getTxtBagRateBlw65()
  {
    return txtBagRateBlw65;
  }

  public void setTxtBagRateBlw65(String newTxtBagRateBlw65)
  {
    txtBagRateBlw65 = newTxtBagRateBlw65;
  }  
  
  /*public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }*/  
  
}