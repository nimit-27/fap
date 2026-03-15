package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class ComputeFSCForm extends PayrollBaseForm 
{
  private String txtFinYear;
  private String hdnAction;

  public ComputeFSCForm()
  {
  }

  public String getTxtFinYear()
  {
    return txtFinYear;
  }

  public void setTxtFinYear(String newTxtFinYear)
  {
    txtFinYear = newTxtFinYear;
  }

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }
}