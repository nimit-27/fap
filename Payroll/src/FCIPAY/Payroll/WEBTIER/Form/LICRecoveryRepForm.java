package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class LICRecoveryRepForm extends PayrollBaseForm
{
  private String txtFrYYMM;  
  private String txtToYYMM;  
  private String location;
  private String txtEmp;
  private String txtEmpName;
  private String txtCpfCode;
  private String txtAgency = null;
  private String txtAgencyCode;
  private String txtAgencySiteCode = null;
  private String txtAgencySite = null;

  public LICRecoveryRepForm()
  {
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

//added by nand on 01-feb-2013

//for agency 
  public String getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }


// for agency code
  public String getTxtAgencyCode()
  {
    return txtAgencyCode;
  }

  public void setTxtAgencyCode(String newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }

//for agency site code
  public String getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }

  public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  }

//for agency site
  public String getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }
//end by nand on 01-feb-2013
  
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
                                    //added by dushyant on 19-aug-2010

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
                               //ended by dushyant on 19-aug-2010

}