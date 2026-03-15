package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class ECSDataFileForm extends PayrollBaseForm 
{
  private String txtYYMM;
  private String txtECSTranCode;
  private String txtUserNumber;
  private String txtUserName;
  private String txtECSTapeInputNo;
  private String txtSponBkBrSortCode;
  private String txtUserBankAccNo;
  private String txtLedgerFolioNo;
  private String txtUserDefLimit;
  private String txtSettlementDate;
  private String txtCreditTranCode;
  private String txtCreditDestAccType;
  String hdnAction;
  private String hdnDataLoad;
  private String hdnMessage;
  private String hdnOption;

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getTxtECSTranCode()
  {
    return txtECSTranCode;
  }

  public void setTxtECSTranCode(String newTxtECSTranCode)
  {
    txtECSTranCode = newTxtECSTranCode;
  }

  public String getTxtUserNumber()
  {
    return txtUserNumber;
  }

  public void setTxtUserNumber(String newTxtUserNumber)
  {
    txtUserNumber = newTxtUserNumber;
  }

  public String getTxtUserName()
  {
    return txtUserName;
  }

  public void setTxtUserName(String newTxtUserName)
  {
    txtUserName = newTxtUserName;
  }

  public String getTxtECSTapeInputNo()
  {
    return txtECSTapeInputNo;
  }

  public void setTxtECSTapeInputNo(String newTxtECSTapeInputNo)
  {
    txtECSTapeInputNo = newTxtECSTapeInputNo;
  }

  public String getTxtSponBkBrSortCode()
  {
    return txtSponBkBrSortCode;
  }

  public void setTxtSponBkBrSortCode(String newTxtSponBkBrSortCode)
  {
    txtSponBkBrSortCode = newTxtSponBkBrSortCode;
  }

  public String getTxtUserBankAccNo()
  {
    return txtUserBankAccNo;
  }

  public void setTxtUserBankAccNo(String newTxtUserBankAccNo)
  {
    txtUserBankAccNo = newTxtUserBankAccNo;
  }

  public String getTxtLedgerFolioNo()
  {
    return txtLedgerFolioNo;
  }

  public void setTxtLedgerFolioNo(String newTxtLedgerFolioNo)
  {
    txtLedgerFolioNo = newTxtLedgerFolioNo;
  }

  public String getTxtUserDefLimit()
  {
    return txtUserDefLimit;
  }

  public void setTxtUserDefLimit(String newTxtUserDefLimit)
  {
    txtUserDefLimit = newTxtUserDefLimit;
  }

  public String getTxtSettlementDate()
  {
    return txtSettlementDate;
  }

  public void setTxtSettlementDate(String newTxtSettlementDate)
  {
    txtSettlementDate = newTxtSettlementDate;
  }

  public String getTxtCreditTranCode()
  {
    return txtCreditTranCode;
  }

  public void setTxtCreditTranCode(String newTxtCreditTranCode)
  {
    txtCreditTranCode = newTxtCreditTranCode;
  }

  public String getTxtCreditDestAccType()
  {
    return txtCreditDestAccType;
  }

  public void setTxtCreditDestAccType(String newTxtCreditDestAccType)
  {
    txtCreditDestAccType = newTxtCreditDestAccType;
  }

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

  public String getHdnDataLoad()
  {
    return hdnDataLoad;
  }

  public void setHdnDataLoad(String newHdnDataLoad)
  {
    hdnDataLoad = newHdnDataLoad;
  }

  public String getHdnMessage()
  {
    return hdnMessage;
  }

  public void setHdnMessage(String newHdnMessage)
  {
    hdnMessage = newHdnMessage;
  }

  public String getHdnOption()
  {
    return hdnOption;
  }

  public void setHdnOption(String newHdnOption)
  {
    hdnOption = newHdnOption;
  }

}