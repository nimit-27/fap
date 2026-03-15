package FCIPAY.Payroll.Labour.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class NWNPLabourOTACompRepForm extends PayrollBaseForm
{
  
  
  private String txtEmp;
  private String txtCpfCode;    // added by dushaynt on 03-03-2011
  private String txtEmpName;
  private String txtWrkSlipDt; 
  private String txtWrkSlipDtTo; // added by Swapnendu Dt 24 Aug 2011

  public NWNPLabourOTACompRepForm()
  {
  }

 public String getTxtWrkSlipDt()
  {
    return txtWrkSlipDt;
  }

  public void setTxtWrkSlipDt(String newTxtWrkSlipDt)
  {
    txtWrkSlipDt = newTxtWrkSlipDt;
  }  
  
  public String getTxtWrkSlipDtTo()
  {
    return txtWrkSlipDtTo;
  }

  public void setTxtWrkSlipDtTo(String newTxtWrkSlipDtTo)
  {
    txtWrkSlipDtTo = newTxtWrkSlipDtTo;
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

// added by dushaynt on 03-03-2011      txtCpfCode

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }
  
  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }

// adde by dushyant on 03-03-2011
}