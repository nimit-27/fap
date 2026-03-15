package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class EOLHPLRecReportForm extends PayrollBaseForm
{
  private String optSelect;
  private String txtEmp;
  private String txtYYMM;
  private String butTxtEmpNo;
  private String disabbutTxtEmpNo;
  private String txtAllEmpFlag;

  public EOLHPLRecReportForm()
  {
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getButTxtEmpNo()
  {
    return butTxtEmpNo;
  }

  public void setButTxtEmpNo(String newButTxtEmpNo)
  {
    butTxtEmpNo = newButTxtEmpNo;
  }

  public String getDisabbutTxtEmpNo()
  {
    return disabbutTxtEmpNo;
  }

  public void setDisabbutTxtEmpNo(String newDisabbutTxtEmpNo)
  {
    disabbutTxtEmpNo = newDisabbutTxtEmpNo;
  }

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }
}