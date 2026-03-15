package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class PaymentHistoryBean extends PayrollBaseDetailBean implements Serializable 
{
  private String txtPayAmt;
  private String txtPayDate;
  private String txtRemark;
  private String txtSerialNo;

  public PaymentHistoryBean()
  {
  }

  public String getTxtPayAmt()
  {
    return txtPayAmt;
  }

  public void setTxtPayAmt(String newTxtPayAmt)
  {
    txtPayAmt = newTxtPayAmt;
  }

  public String getTxtPayDate()
  {
    return txtPayDate;
  }

  public void setTxtPayDate(String newTxtPayDate)
  {
    txtPayDate = newTxtPayDate;
  }

  public String getTxtRemark()
  {
    return txtRemark;
  }

  public void setTxtRemark(String newTxtRemark)
  {
    txtRemark = newTxtRemark;
  }

  public String getTxtSerialNo()
  {
    return txtSerialNo;
  }

  public void setTxtSerialNo(String newTxtSerialNo)
  {
    txtSerialNo = newTxtSerialNo;
  }
}