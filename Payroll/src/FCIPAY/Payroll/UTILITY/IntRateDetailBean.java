package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class IntRateDetailBean extends PayrollBaseDetailBean implements Serializable
{
  private String startField;
  private String endField;
  private String txtIntRate;
  private String txtSerialNo;
  private String txtPenalty;
  private String txtConcession;
  private String txtYearMonth;
  

  
  public IntRateDetailBean()
  {
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

  public String getTxtIntRate()
  {
    return txtIntRate;
  }

  public void setTxtIntRate(String newTxtIntRate)
  {
    txtIntRate = newTxtIntRate;
  }

  public String getTxtSerialNo()
  {
    return txtSerialNo;
  }

  public void setTxtSerialNo(String newTxtSerialNo)
  {
    txtSerialNo = newTxtSerialNo;
  }

  public String getTxtPenalty()
  {
    return txtPenalty;
  }

  public void setTxtPenalty(String newTxtPenalty)
  {
    txtPenalty = newTxtPenalty;
  }

  public String getTxtConcession()
  {
    return txtConcession;
  }

  public void setTxtConcession(String newTxtConcession)
  {
    txtConcession = newTxtConcession;
  }
  
  public String getTxtYearMonth()
  {
    return txtYearMonth;
  }

  public void setTxtYearMonth(String newTxtYearMonth)
  {
    txtYearMonth = newTxtYearMonth;
  }
     
}