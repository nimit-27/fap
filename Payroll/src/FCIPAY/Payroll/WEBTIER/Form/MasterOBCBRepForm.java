package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class MasterOBCBRepForm extends PayrollBaseForm
{
  private String txtFrYYYY;  
  private String txtToYYYY;  
  private String location;
  private String txtEmp;
  private String txtEmpName;
  private String txtCPFCode;
  

  public MasterOBCBRepForm()
  {
  }

  public String getTxtFrYYYY()
  {
    return txtFrYYYY;
  }

  public void setTxtFrYYYY(String newTxtFrYYYY)
  {
    txtFrYYYY = newTxtFrYYYY;
  }
  
  public String getTxtToYYYY()
  {
    return txtToYYYY;
  }

  public void setTxtToYYYY(String newTxtToYYYY)
  {
    txtToYYYY = newTxtToYYYY;
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

  public void setTxtCPFCode(String newTxtCPFCode)
  {
    txtCPFCode = newTxtCPFCode;
  }

  public String getTxtCPFCode()
  {
    return txtCPFCode;
  }
}