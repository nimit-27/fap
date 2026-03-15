package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class SalaryInvoiceReportForm extends PayrollBaseForm
{
  private String txtYYMM;  
  private String location;
  private String txtPayCode;
  private String txtDescription;
  private  String txtLocId;
   private  String txtLocation;
    private  String txtGangName;
    private  String txtGangId;
  

  public SalaryInvoiceReportForm()
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

  
  public String getLocation()
  {
    return location;
  }

  public void setLocation(String newLocation)
  {
    location= newLocation;
  }  
///added by sonia on 06-08-2011
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode= newTxtPayCode;
  }  

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription= newTxtDescription;
  }  
  ///added by sonia on 06-08-2011
  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtYYMM)
  {
    txtLocId = newTxtYYMM;
  }
  
    public String getTxtLocation()
  {
    return txtLocation;
  }

  public void setTxtLocation(String newTxtYYMM)
  {
    txtLocation = newTxtYYMM;
  }
  
     public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtYYMM)
  {
    txtGangName = newTxtYYMM;
  }
  
   public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtYYMM)
  {
    txtGangId = newTxtYYMM;
  }
}