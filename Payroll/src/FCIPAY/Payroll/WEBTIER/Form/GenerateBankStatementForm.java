package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class GenerateBankStatementForm extends PayrollBaseForm
{
  private String optSelect;
  private String txtBankCode;
  private String txtAllBankFlag;
  private String butTxtBankCode;
  private String disabbutTxtBankCode;
  private String txtYYMM;
  private String txtBranchCode;
  private String txtBranchName;
  private String txtPayableDate;
  private String txtPayModeType;
  private String optReportType;
  private String txtBankName;

  public GenerateBankStatementForm()
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

  public String getTxtBankCode()
  {
    return txtBankCode;
  }

  public void setTxtBankCode(String newTxtBankCode)
  {
    txtBankCode = newTxtBankCode;
  }

  public String getTxtAllBankFlag()
  {
    return txtAllBankFlag;
  }

  public void setTxtAllBankFlag(String newTxtAllBankFlag)
  {
    txtAllBankFlag = newTxtAllBankFlag;
  }

  public String getButTxtBankCode()
  {
    return butTxtBankCode;
  }

  public void setButTxtBankCode(String newButTxtBankCode)
  {
    butTxtBankCode = newButTxtBankCode;
  }

  public String getDisabbutTxtBankCode()
  {
    return disabbutTxtBankCode;
  }

  public void setDisabbutTxtBankCode(String newDisabbutTxtBankCode)
  {
    disabbutTxtBankCode = newDisabbutTxtBankCode;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }



  public String getTxtBranchCode()
  {
    return txtBranchCode;
  }

  public void setTxtBranchCode(String newTxtBranchCode)
  {
    txtBranchCode = newTxtBranchCode;
  }

  public String getTxtBranchName()
  {
    return txtBranchName;
  }

  public void setTxtBranchName(String newTxtBranchName)
  {
    txtBranchName = newTxtBranchName;
  }

  public String getTxtPayableDate()
  {
    return txtPayableDate;
  }

  public void setTxtPayableDate(String newTxtPayableDate)
  {
    txtPayableDate = newTxtPayableDate;
  }

  public String getTxtPayModeType()
  {
    return txtPayModeType;
  }

  public void setTxtPayModeType(String newTxtPayModeType)
  {
    txtPayModeType = newTxtPayModeType;
  }

  public String getOptReportType()
  {
    return optReportType;
  }

  public void setOptReportType(String newOptReportType)
  {
    optReportType = newOptReportType;
  }

  public String getTxtBankName()
  {
    return txtBankName;
  }

  public void setTxtBankName(String newTxtBankName)
  {
    txtBankName = newTxtBankName;
  }
}