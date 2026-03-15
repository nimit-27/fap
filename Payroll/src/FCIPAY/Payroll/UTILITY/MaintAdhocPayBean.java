package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintAdhocPayBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtSrlNo="";
  private String txtOptCode="";
  private String txtGroupCode="";
  private String txtCategCode="";
  private String txtDesigCode="";
  private String txtAmount="";

  public MaintAdhocPayBean(String sSrlNo,String sOptCode,String sGroupCode,String sCategCode,String sDesigCode,String sAmount )
  {
    txtSrlNo=sSrlNo;
    txtOptCode=sOptCode;
    txtGroupCode=sGroupCode;
    txtCategCode=sCategCode;
    txtDesigCode=sDesigCode;
    txtAmount=sAmount;
  }
  
  public MaintAdhocPayBean()
  {
  
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getTxtOptCode()
  {
    return txtOptCode;
  }

  public void setTxtOptCode(String newTxtOptCode)
  {
    txtOptCode = newTxtOptCode;
  }

  public String getTxtGroupCode()
  {
    return txtGroupCode;
  }

  public void setTxtGroupCode(String newTxtGroupCode)
  {
    txtGroupCode = newTxtGroupCode;
  }

  public String getTxtCategCode()
  {
    return txtCategCode;
  }

  public void setTxtCategCode(String newTxtCategCode)
  {
    txtCategCode = newTxtCategCode;
  }

  public String getTxtDesigCode()
  {
    return txtDesigCode;
  }

  public void setTxtDesigCode(String newTxtDesigCode)
  {
    txtDesigCode = newTxtDesigCode;
  }

  public String getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }
}