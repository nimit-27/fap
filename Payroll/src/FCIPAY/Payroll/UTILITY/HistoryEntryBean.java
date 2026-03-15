package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class HistoryEntryBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtPayCode;
  private String txtDescription;
  private String txtPayMode;
  private String txtAmount;
  private String txtPaymentDate;
  private String txtUnitID;
  private String hdnSrlNo;

  public HistoryEntryBean()
  {
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }

 public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }

  public String getTxtPaymentDate()
  {
    return txtPaymentDate;
  }

  public void setTxtPaymentDate(String newTxtPaymentDate)
  {
    txtPaymentDate = newTxtPaymentDate;
  }

  public String getTxtUnitID()
  {
    return txtUnitID;
  }

  public void setTxtUnitID(String newTxtUnitID)
  {
    txtUnitID = newTxtUnitID;
  }

  public String getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }
}