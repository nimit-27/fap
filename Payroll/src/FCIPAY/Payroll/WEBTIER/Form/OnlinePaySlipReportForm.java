package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class OnlinePaySlipReportForm extends PayrollBaseForm
{
  private String txtYYMM;
  private String optSelect;
  private String hdnPayUser;
  private String hdnLoginUserId;
  private String hdnLoginUserName;
  private String PaySlipLocationForm;
  private String txtAllEmpFlag;
  private String txtEmpNo;
  private String txtEmpName;
  private String txtCpfCode;  
  private String hdnMaxYYMM;
  private String txtCPFDDYYMM; 
  private String txtSiteCode;  
  private String txtSiteDesc;
  private String txtUserFlag; 
  
  private String txtFrYYYY;  //added by geetika sharma Dt 09/07/2013
  private String txtToYYYY; 
  private String location;
  private String txtReport;
  private String txtEmpType;
  
  public OnlinePaySlipReportForm()
  {
  }

 public String getTxtCPFDDYYMM()
  {
    return txtCPFDDYYMM;
  }

  public void setTxtCPFDDYYMM(String TxtCPFDDYYMM)
  {
    txtCPFDDYYMM = TxtCPFDDYYMM;
  }
  public String getTxtSiteCode()
  {
    return txtSiteCode;
  }

  public void setTxtSiteCode(String TxtSiteCode)
  {
    txtSiteCode = TxtSiteCode;
  }
  public String getTxtSiteDesc()
  {
    return txtSiteDesc;
  }

  public void setTxtSiteDesc(String TxtSiteDesc)
  {
    txtSiteDesc = TxtSiteDesc;
  }
  
   public String getTxtUserFlag()
  {
    return txtUserFlag;
  }

  public void setTxtUserFlag(String txtUserFlag)
  {
    txtUserFlag = txtUserFlag;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }





  public String getHdnPayUser()
  {
    return hdnPayUser;
  }

  public void setHdnPayUser(String newHdnPayUser)
  {
    hdnPayUser = newHdnPayUser;
  }

  public String getHdnLoginUserId()
  {
    return hdnLoginUserId;
  }

  public void setHdnLoginUserId(String newHdnLoginUserId)
  {
    hdnLoginUserId = newHdnLoginUserId;
  }

  public String getHdnLoginUserName()
  {
    return hdnLoginUserName;
  }

  public void setHdnLoginUserName(String newHdnLoginUserName)
  {
    hdnLoginUserName = newHdnLoginUserName;
  }

  public String getPaySlipLocationForm()
  {
    return PaySlipLocationForm;
  }

  public void setPaySlipLocationForm(String newPaySlipLocationForm)
  {
    PaySlipLocationForm = newPaySlipLocationForm;
  }

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmp)
  {
    txtEmpNo = newTxtEmp;
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

  public String getHdnMaxYYMM()
  {
    return hdnMaxYYMM;
  }

  public void setHdnMaxYYMM(String newHdnMaxYYMM)
  {
    hdnMaxYYMM = newHdnMaxYYMM;
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

  public String getTxtReport()
  {
    return txtReport;
  }

  public void setTxtReport(String newTxtReport)
  {
    txtReport = newTxtReport;
  } 
  public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  } 
  
  
}