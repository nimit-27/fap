package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class Form16RepForm extends PayrollBaseForm
{
  private String txtYYMM;  
  private String location;
  private String txtEmp;
  private String txtEmpName;
  private String txtCpfCode;
  private String txtAuthName;
  private String txtAuthFatherName;
  private String txtAuthDesig;

  public Form16RepForm()
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
  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
                                   //added by dushyant 0n 18-aug 2010
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
                                  //end by dushyant 0n 18-aug 2010
  
  //added by Vibhuti on 13-06-2014
  
  public String getTxtAuthName()
  {
    return txtAuthName;
  }

  public void setTxtAuthName(String newTxtAuthName)
  {
    txtAuthName = newTxtAuthName;
  }
  
  public String getTxtAuthFatherName()
  {
    return txtAuthFatherName;
  }

  public void setTxtAuthFatherName(String newTxtAuthFatherName)
  {
    txtAuthFatherName = newTxtAuthFatherName;
  }
  
  public String getTxtAuthDesig()
  {
    return txtAuthDesig;
  }

  public void setTxtAuthDesig(String newTxtAuthDesig)
  {
    txtAuthDesig = newTxtAuthDesig;
  }
  
  //addition by Vibhuti ends
    
}