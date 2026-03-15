package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;



public class GenerateCanteenSubsidyReportForm extends PayrollBaseForm
{
  private String optSelect;
  private String txtYYMM;
  private String txtEmp;
  private String txtAllEmpFlag;

  public GenerateCanteenSubsidyReportForm()
  {
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
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

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }
}