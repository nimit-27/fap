package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class PayrollBaseForm extends BaseForm 
{

  private String selectAll;
  private String status;
  private String deailID;
  private String hdnStatus;
  private String [] startField = null;
  private String [] endField = null;
  private String buttonFlag;
  private String txtSiteID;
  private String txtUserID;
  private String hdnLoginDate;
  private String hdnEmpLbrFlag;

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

  public String getSelectAll()
  {
    return selectAll;
  }

  public void setSelectAll(String newSelectAll)
  {
    selectAll = newSelectAll;
  }

  public void setStatus(String newStatus)
  {
    status = newStatus;
  }

  public String getDeailID()
  {
    return deailID;
  }

  public void setDeailID(String newDeailID)
  {
    deailID = newDeailID;
  }

  public String getHdnStatus()
  {
    return hdnStatus;
  }

  public void setHdnStatus(String newHdnStatus)
  {
    hdnStatus = newHdnStatus;
  }

  public String[] getStartField()
  {
    return startField;
  }

  public void setStartField(String[] newStartField)
  {
    startField = newStartField;
  }

  public String[] getEndField()
  {
    return endField;
  }

  public void setEndField(String[] newEndField)
  {
    endField = newEndField;
  }

  public String getButtonFlag()
  {
    return buttonFlag;
  }

  public void setButtonFlag(String newButtonFlag)
  {
    buttonFlag = newButtonFlag;
  }

  public String getTxtSiteID()
  {
    return txtSiteID;
  }

  public void setTxtSiteID(String newTxtSiteID)
  {
    txtSiteID = newTxtSiteID;
  }

  public String getTxtUserID()
  {
    return txtUserID;
  }

  public void setTxtUserID(String newTxtUserID)
  {
    txtUserID = newTxtUserID;
  }

  public String getHdnLoginDate()
  {
    return hdnLoginDate;
  }

  public void setHdnLoginDate(String newHdnLoginDate)
  {
    hdnLoginDate = newHdnLoginDate;
  }

  public String getHdnEmpLbrFlag()
  {
    return hdnEmpLbrFlag;
  }

  public void setHdnEmpLbrFlag(String newHdnEmpLbrFlag)
  {
    hdnEmpLbrFlag = newHdnEmpLbrFlag;
  }


}