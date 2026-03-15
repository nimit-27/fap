package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class CreatePayrollForm extends PayrollBaseForm 
{
  private String txtPayYYMM;
  private String txtStYYMM;
  private String txtEndYYMM;
  private String txtDAType;
  private String hdrGoto;
  private String optSelect;
  private String txtEmp;
  private String hdnAction;
  private String hdnString;

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

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }

  public String getTxtStYYMM()
  {
    return txtStYYMM;
  }

  public void setTxtStYYMM(String newTxtStYYMM)
  {
    txtStYYMM = newTxtStYYMM;
  }

  public String getTxtEndYYMM()
  {
    return txtEndYYMM;
  }

  public void setTxtEndYYMM(String newTxtEndYYMM)
  {
    txtEndYYMM = newTxtEndYYMM;
  }

  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }

  public String getHdrGoto()
  {
    return hdrGoto;
  }

  public void setHdrGoto(String newHdrGoto)
  {
    hdrGoto = newHdrGoto;
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

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

  public String getHdnString()
  {
    return hdnString;
  }

  public void setHdnString(String newHdnString)
  {
    hdnString = newHdnString;
  }
  
}
