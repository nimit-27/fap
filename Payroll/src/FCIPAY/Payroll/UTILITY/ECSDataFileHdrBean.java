package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ECSDataFileHdrBean extends PayrollBaseHeaderBean implements Serializable 
{

 private String txtYYMM;
  private String txtUserNumber;
  private String txtUserName;
  private String txtECSTapeInputNo;
  private String txtUserBankAccNo;
  private String txtLedgerFolioNo;
  private String txtUserDefLimit;  
  private String txtECSTranCode;
  private String txtCreditDestAccType;
  private String txtSettlementDate;
  private String txtCreditTranCode;
  private String TxtSponBkBrSortCode;


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

  public String getTxtSponBkBrSortCode()
  {
    return TxtSponBkBrSortCode;
  }

  public void setTxtSponBkBrSortCode(String newTxtSponBkBrSortCode)
  {
    TxtSponBkBrSortCode = newTxtSponBkBrSortCode;
  }

}