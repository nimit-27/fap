package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PensionDetailRepForm extends PayrollBaseForm
{
    
  private String txtFrYYYY;  
  private String txtToYYYY;  
  private String location;
  private String txtEmp;
  private String txtEmpName;
  private String txtCPFDDYYMM;
  private String txtYYMM;
  private String txtCpfCode;
  private String txtSiteCode;
  private String txtSiteDesc;
  private String txtUserFlag;
  private String txtEmpType;
  private String txtReport;
  private String txtResult;

  public PensionDetailRepForm()
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

    public void setTxtCPFDDYYMM(String txtCPFDDYYMM) {
        this.txtCPFDDYYMM = txtCPFDDYYMM;
    }

    public String getTxtCPFDDYYMM() {
        return txtCPFDDYYMM;
    }

    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public void setTxtCpfCode(String txtCpfCode) {
        this.txtCpfCode = txtCpfCode;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
    }

    public void setTxtSiteCode(String txtSiteCode) {
        this.txtSiteCode = txtSiteCode;
    }

    public String getTxtSiteCode() {
        return txtSiteCode;
    }

    public void setTxtSiteDesc(String txtSiteDesc) {
        this.txtSiteDesc = txtSiteDesc;
    }

    public String getTxtSiteDesc() {
        return txtSiteDesc;
    }

    public void setTxtUserFlag(String txtUserFlag) {
        this.txtUserFlag = txtUserFlag;
    }

    public String getTxtUserFlag() {
        return txtUserFlag;
    }

    public void setTxtEmpType(String txtEmpType) {
        this.txtEmpType = txtEmpType;
    }

    public String getTxtEmpType() {
        return txtEmpType;
    }

    public void setTxtReport(String txtReport) {
        this.txtReport = txtReport;
    }

    public String getTxtReport() {
        return txtReport;
    }

    public void setTxtResult(String txtResult) {
        this.txtResult = txtResult;
    }

    public String getTxtResult() {
        return txtResult;
    }
}
