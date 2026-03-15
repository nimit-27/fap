package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class GenerateSalStatementForm extends PayrollBaseForm
{
  private String txtYYMM;
  private String select_option;
  private String txtOptType;

  public GenerateSalStatementForm()
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

  public String getSelect_option()
  {
    return select_option;
  }

  public void setSelect_option(String newSelect_option)
  {
    select_option = newSelect_option;
  }

  public String getTxtOptType()
  {
    return txtOptType;
  }

  public void setTxtOptType(String newTxtOptType)
  {
    txtOptType = newTxtOptType;
  }
}