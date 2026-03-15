package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class CPFDednRepForm extends PayrollBaseForm
{
     
  private String location;
  private String txtEmp;
  private String txtEmpName;
  private String txtFrYYMM; 
  private String txtToYYMM;

  

  public CPFDednRepForm()
  {
  }

 
  
  public String getLocation()
  {
    return location;
  }

  public void setLocation(String newLocation)
  {
    location= newLocation;
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
  
  public String getTxtFrYYMM()
  {
    return txtFrYYMM;
  }
  public void setTxtFrYYMM(String newTxtFrYYMM)
  {
    txtFrYYMM = newTxtFrYYMM;
  }
  public String getTxtToYYMM()
  {
    return txtToYYMM;
  }

  public void setTxtToYYMM(String newTxtToYYMM)
  {
    txtToYYMM = newTxtToYYMM;
  } 
 

}