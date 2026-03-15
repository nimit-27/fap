package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class EmplyrTaxForm extends PayrollBaseForm
{
  private String txtEmpNo;
  private String txtEmpName;
  private String txtTaxAmt;
  private String txtRecYYMM;
  private String txtInstallAmt;
  private String txtNoInstall;
  private String txtFinYr;

  public EmplyrTaxForm()
  {
    
  }

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

  public String getTxtTaxAmt()
  {
    return txtTaxAmt;
  }

  public void setTxtTaxAmt(String newTxtTaxAmt)
  {
    txtTaxAmt = newTxtTaxAmt;
  }

  public String getTxtRecYYMM()
  {
    return txtRecYYMM;
  }

  public void setTxtRecYYMM(String newTxtRecYYMM)
  {
    txtRecYYMM = newTxtRecYYMM;
  }

  public String getTxtInstallAmt()
  {
    return txtInstallAmt;
  }

  public void setTxtInstallAmt(String newTxtInstallAmt)
  {
    txtInstallAmt = newTxtInstallAmt;
  }

  public String getTxtNoInstall()
  {
    return txtNoInstall;
  }

  public void setTxtNoInstall(String newTxtNoInstall)
  {
    txtNoInstall = newTxtNoInstall;
  }

  public String getTxtFinYr()
  {
    return txtFinYr;
  }

  public void setTxtFinYr(String newTxtFinYr)
  {
    txtFinYr = newTxtFinYr;
  }

}