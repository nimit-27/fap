package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class DPSWageRepForm extends PayrollBaseForm
{
  private String txtYYMM;  
  private String location;
  private String txtEmp;
  private String txtEmpName;
  private String hdnGangId;
  private String txtGangName;    
  private String hdnMou;
  private String txtLbrType;
  private String txtCpfCode;  // added by dushyant on 17-01-2011
  

  public DPSWageRepForm()
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
  public String getHdnGangId()
    {
      return hdnGangId;
    }
    
    public void setHdnGangId(String newHdnGangId)
    {
      hdnGangId=newHdnGangId;
    }
    
    public String getTxtGangName()
    {
      return txtGangName;
    }
    
    public void setTxtGangName(String newTxtGangName)
    {
      txtGangName=newTxtGangName;
    }
    
    public String getHdnMou()
    {
      return hdnMou;
    }
    
    public void setHdnMou(String newHdnMou)
    {
      hdnMou=newHdnMou;
    }
    
    public String getTxtLbrType()
    {
      return txtLbrType;
    }
    
    public void setTxtLbrType(String newTxtLbrType)
    {
      txtLbrType=newTxtLbrType;
    }
 //  added by dushyant 21 feb2011
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  
  
  //end by dushyant on 21 feb 2011
}