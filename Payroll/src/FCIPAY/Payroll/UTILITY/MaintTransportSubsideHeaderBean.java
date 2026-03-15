package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintTransportSubsideHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  public MaintTransportSubsideHeaderBean()
  {
  }
  
  private String txtEmpNo;
  private String txtEmpName;
  private String txtCPFCode;
  private String txtAmtHdr;
  private String txtFinYear;
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }
  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }
  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtCPFCode()
  {
    return txtCPFCode;
  }
  public void setTxtCPFCode(String newTxtCPFCode)
  {
    txtCPFCode = newTxtCPFCode;
  }

  public String getTxtAmtHdr()
  {
    return txtAmtHdr;
  }
  public void setTxtAmtHdr(String newTxtAmtHdr)
  {
    txtAmtHdr = newTxtAmtHdr;
  }
  
  public String getTxtFinYear()
  {
    return txtFinYear;
  }
  public void setTxtFinYear(String newTxtFinYear)
  {
    txtFinYear = newTxtFinYear;
  }
}