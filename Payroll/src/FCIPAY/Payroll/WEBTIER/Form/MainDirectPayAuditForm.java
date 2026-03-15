package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MainDirectPayAuditForm extends PayrollBaseForm
{
  private String txtEmp;
  private String location;
  private String txtFromDate;
  private String txtToDate;
  private String txtEmpName;
  private String txtCpfCode;
  
  public MainDirectPayAuditForm()
  {
  }
  
 public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  } 

  public String getTxtFromDate()
  {
    return txtFromDate;
  }

  public void setTxtFromDate(String newTxtFromDate)
  {
    txtFromDate = newTxtFromDate;
  }
  
   public String getTxtToDate()
  {
    return txtToDate;
  }

  public void setTxtToDate(String newtxtToDate)
  {
    txtToDate = newtxtToDate;
  }
  
  public String getLocation()
  {
    return location;
  }

  public void setLocation(String newLocation)
  {
    location= newLocation;
  }
   public String getTxtEmpName()
  {
    return txtEmpName;
  }
  public void setTxtEmpName(String newTxtEmpName)
  {
   txtEmpName = newTxtEmpName;
  }
  
  public String getTxtCpfCode()
  {
   return txtCpfCode;
  }
  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  
}