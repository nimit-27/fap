package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PostSalaryInvToAPForm extends PayrollBaseForm 
{
  private String hdnAction; // added by devendra on 29th sept 2010
  private String txtInvDt; //added by  neeraj 
  private String formFlag="First"; //added by  neeraj 
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
  
  // added by devendra on 29 sept 2010 start
  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }
  // added by devendra on 29 sept 2010 end
  
  //added by neeraj on 16 oct 2010 starts
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
    System.out.println("Set Function"+formFlag);
  }
  //added by neeraj on 16 oct 2010 ends
}