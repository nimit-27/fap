
package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintGISRatesBean;

public class MaintGISRatesForm  extends PayrollBaseForm 
{
  private String txtGroup[]=null;
  private String txtRate[]=null;
  private String txtEffDate[]=null;
  private ArrayList lstIdaInstrDtls= new ArrayList();

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

  public String[] getTxtGroup()
  {
    return txtGroup;
  }

  public void setTxtGroup(String[] newTxtGroup)
  {
    txtGroup = newTxtGroup;
  }

  public String[] getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String[] newTxtRate)
  {
    txtRate = newTxtRate;
  }

  public String[] getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String[] newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }

  public ArrayList getLstIdaInstrDtls()
  {
    return lstIdaInstrDtls;
  }

  public void setLstIdaInstrDtls(ArrayList newLstIdaInstrDtls)
  {
    lstIdaInstrDtls = newLstIdaInstrDtls;
  }
}