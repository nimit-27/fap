package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintPFDeductMstForm extends PayrollBaseForm 
{
  private String txtAmtFrom[];
  private String txtAmtTo[];
  private String txtSubscripAmt[];
  private String txtDudnSrl[];
  private ArrayList lstDudnDetails = new ArrayList();

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

  public String[] getTxtAmtFrom()
  {
    return txtAmtFrom;
  }

  public void setTxtAmtFrom(String[] newTxtAmtFrom)
  {
    txtAmtFrom = newTxtAmtFrom;
  }

  public String[] getTxtAmtTo()
  {
    return txtAmtTo;
  }

  public void setTxtAmtTo(String[] newTxtAmtTo)
  {
    txtAmtTo = newTxtAmtTo;
  }

  public String[] getTxtSubscripAmt()
  {
    return txtSubscripAmt;
  }

  public void setTxtSubscripAmt(String[] newTxtSubscripAmt)
  {
    txtSubscripAmt = newTxtSubscripAmt;
  }

  public String[] getTxtDudnSrl()
  {
    return txtDudnSrl;
  }

  public void setTxtDudnSrl(String[] newTxtDudnSrl)
  {
    txtDudnSrl = newTxtDudnSrl;
  }

  public ArrayList getLstDudnDetails()
  {
    return lstDudnDetails;
  }

  public void setLstDudnDetails(ArrayList newLstDudnDetails)
  {
    lstDudnDetails = newLstDudnDetails;
  }
}