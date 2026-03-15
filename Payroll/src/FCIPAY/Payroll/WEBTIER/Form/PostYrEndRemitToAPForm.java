package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class PostYrEndRemitToAPForm extends PayrollBaseForm 
{
  private String hdnAction;
  private String txtInvDt;
  private String formFlag="First";
  private String btnFlag;
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
 
  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

  public String getTxtInvDt()
  {
      return txtInvDt ;
  }
  public void setTxtInvDt(String newTxtInvDt)
  {
    txtInvDt=newTxtInvDt;
  }
  
  public String getFormFlag()
  {
     return formFlag;
  }
  
  public void setFormFlag(String newFormFlag)
  {
     formFlag=newFormFlag;
  }

  public String getBtnFlag()
  {
     return btnFlag;
  }
  
  public void setBtnFlag(String newBtnFlag)
  {
     btnFlag = newBtnFlag;
  }
}
