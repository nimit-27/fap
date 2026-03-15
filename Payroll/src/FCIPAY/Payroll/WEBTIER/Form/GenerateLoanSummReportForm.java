package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class GenerateLoanSummReportForm extends PayrollBaseForm
{
  private String txtYYMM;
  private String txtLoanCode;
  private String txtEmp;
  private String txtEmpName;
  private String txtAgencyCode;
  private String optSelect;
  private String agencyDesc;
  private String loanDesc;
  private String txtAllEmpFlag;  

  public GenerateLoanSummReportForm()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getTxtLoanCode()
  {
    return txtLoanCode;
  }

  public void setTxtLoanCode(String newTxtLoanCode)
  {
    txtLoanCode = newTxtLoanCode;
  }

  public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtAgencyCode()
  {
    return txtAgencyCode;
  }

  public void setTxtAgencyCode(String newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getAgencyDesc()
  {
    return agencyDesc;
  }

  public void setAgencyDesc(String newAgencyDesc)
  {
    agencyDesc = newAgencyDesc;
  }

  public String getLoanDesc()
  {
    return loanDesc;
  }

  public void setLoanDesc(String newLoanDesc)
  {
    loanDesc = newLoanDesc;
  }

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }
  
}