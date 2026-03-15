package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class PFSlipReportForm extends PayrollBaseForm
{
  private String txtEmp;
  private String txtEmpName;
  private String optSelect;
  private String txtYYMM;
  private String txtAllEmpFlag;
  private String txtFrmYear;
  private String txtToYear;

  public PFSlipReportForm()
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

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }

  public String getTxtFrmYear()
  {
    return txtFrmYear;
  }

  public void setTxtFrmYear(String newTxtFrmYear)
  {
    txtFrmYear = newTxtFrmYear;
  }

  public String getTxtToYear()
  {
    return txtToYear;
  }

  public void setTxtToYear(String newTxtToYear)
  {
    txtToYear = newTxtToYear;
  }
}