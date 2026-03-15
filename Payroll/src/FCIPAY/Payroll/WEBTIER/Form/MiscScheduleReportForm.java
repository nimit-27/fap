package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class MiscScheduleReportForm extends PayrollBaseForm
{
  private String txtYYMM;  
  private String location;
  private String txtAgencyCode;
 //  private String txtPayCode;   
  private String txtPayCode1=null;
  private String txtFromYYMM;
  private String txtToYYMM;

   private String txtPayCode2=null;
  private String txtPayCodeName = null;
  private String txtAgency = null;
private String txtAgencyName = null;
private String txtAgencySiteCode = null;
private String txtAgencySite = null;
  

  public MiscScheduleReportForm()
  {
  }
   public String getTxtPayCode2()
  {
    return txtPayCode2;
  }

  public void setTxtPayCode2(String  newTxtPayCode2)
  {
    txtPayCode2 = newTxtPayCode2;
  }
  public String getTxtFromYYMM()
  {
    return txtFromYYMM;
  }

  public void setTxtFromYYMM(String newFromYYMM)
  {
    txtFromYYMM = newFromYYMM;
  }

 public String getTxtToYYMM()
  {
    return txtToYYMM;
  }

  public void setTxtToYYMM(String newToYYMM)
  {
    txtToYYMM = newToYYMM;
  }
  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
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
  
  public String getLocation()
  {
    return location;
  }

  public void setLocation(String newLocation)
  {
    location= newLocation;
  }  
  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String  newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }

public String getTxtPayCodeName()
  {
    return txtPayCodeName;
  }

  public void setTxtPayCodeName(String newTxtPayCodeName)
  {
    txtPayCodeName = newTxtPayCodeName;
  }
             /*
   public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String  newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }
             */
   
   public String getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }

public String getTxtAgencyName()
  {
    return txtAgencyName;
  }

  public void setTxtAgencyName(String newTxtAgencyName)
  {
    txtAgencyName = newTxtAgencyName;
  }

public String getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }

  public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  }

public String getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }
          
}

