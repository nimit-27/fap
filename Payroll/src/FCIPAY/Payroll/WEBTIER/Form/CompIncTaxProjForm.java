package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class CompIncTaxProjForm extends PayrollBaseForm
{
  private String txtEmp = "";
  private String txtEmpName;
  private String optSelectAllEmp = "";
  private String optSelectBasedOn;
  private String butAction;
  private String incomeTaxPComputedFlag = "";
  private String incomeTaxAComputedFlag = "";
  private String basedOnFlag = "";
  private String hdnMaxRebFlag = "";
  private String chkConsMaxReb = "";
  private String hdnAction;
  private String txtYYMM;
  private String hdnCurYYMM;
  
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

  public String getOptSelectAllEmp()
  {
    return optSelectAllEmp;
  }

  public void setOptSelectAllEmp(String newOptSelectAllEmp)
  {
    optSelectAllEmp = newOptSelectAllEmp;
  }



  public String getOptSelectBasedOn()
  {
    return optSelectBasedOn;
  }

  public void setOptSelectBasedOn(String newOptSelectBasedOn)
  {
    optSelectBasedOn = newOptSelectBasedOn;
  }



  public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
  }

  public String getIncomeTaxPComputedFlag()
  {
    return incomeTaxPComputedFlag;
  }

  public void setIncomeTaxPComputedFlag(String newIncomeTaxPComputedFlag)
  {
    incomeTaxPComputedFlag = newIncomeTaxPComputedFlag;
  }

  public String getIncomeTaxAComputedFlag()
  {
    return incomeTaxAComputedFlag;
  }

  public void setIncomeTaxAComputedFlag(String newIncomeTaxAComputedFlag)
  {
    incomeTaxAComputedFlag = newIncomeTaxAComputedFlag;
  }

  public String getBasedOnFlag()
  {
    return basedOnFlag;
  }

  public void setBasedOnFlag(String newBasedOnFlag)
  {
    basedOnFlag = newBasedOnFlag;
  }

  public String getHdnMaxRebFlag()
  {
    return hdnMaxRebFlag;
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

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getHdnCurYYMM()
  {
    return hdnCurYYMM;
  }

  public void setHdnCurYYMM(String newHdnCurYYMM)
  {
    hdnCurYYMM = newHdnCurYYMM;
  }


}