package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PLIPayRepForm extends PayrollBaseForm
{
  private String txtYYMM;  
  private String location;
  private String txtEmp;
  private String txtEmpName;
  private String txtCtgry;
  private String txtPLIType;

  public PLIPayRepForm()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtFrYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
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
  
  public String getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }  

  public String getTxtPLIType()
  {
    return txtPLIType;
  }

  public void setTxtPLIType(String newTxtPLIType)
  {
    txtPLIType = newTxtPLIType;
  }  
}