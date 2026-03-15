package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class OnlineDummyHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
   private String txtYYMM;
   private String txtEmp;
   private String txtCPFDDYYMM; 
   private String txtSiteCode;
  
  public OnlineDummyHeaderBean()
  {
  }
  
  public String getTxtCPFDDYYMM()
  {
    return txtCPFDDYYMM;
  }

  public void setTxtCPFDDYYMM(String TxtCPFDDYYMM)
  {
    txtCPFDDYYMM = TxtCPFDDYYMM;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }
   public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }
  
   public String getTxtSiteCode()
  {
    return txtSiteCode;
  }

  public void setTxtSiteCode(String txtSiteCode)
  {
    txtSiteCode = txtSiteCode;
  }
 
}