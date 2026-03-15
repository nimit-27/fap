package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PSRepForm extends PayrollBaseForm
{
  private String txtYYMM;    
 // private String hdnLocTyp;
  private String txtEmpNo;

  public PSRepForm()
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
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo= newTxtEmpNo;
  }  

/*  public String getHdnLocTyp()
  {
    return hdnLocTyp;
  }

  public void setHdnLocTyp(String newHdnLocTyp)
  {
    hdnLocTyp= newHdnLocTyp;
  }  */
 
}