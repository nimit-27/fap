package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class MonthlyPayrollForm extends PayrollBaseForm 
{
  private String optSelect;
  private String txtEmp;
  private String butAction;
  private String hdnAction;
   private String hdnMaxRebFlag = "";
private String chkConsMaxReb = "";
  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }

  public String getHdnMaxRebFlag()
  {
    return  hdnMaxRebFlag;
  }

  public void setHdnMaxRebFlag(String newHdnMaxRebFlag)
  {
     hdnMaxRebFlag = newHdnMaxRebFlag;
  }

 public String getChkConsMaxReb()
  {
    return chkConsMaxReb;
  }

  public void setChkConsMaxReb(String newChkConsMaxReb)
  {
    chkConsMaxReb = newChkConsMaxReb;
  }








  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }

  public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
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
