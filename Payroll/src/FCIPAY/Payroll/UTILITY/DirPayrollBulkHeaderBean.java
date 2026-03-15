package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class DirPayrollBulkHeaderBean extends PayrollBaseHeaderBean implements Serializable
{
    private String txtPayCode1;
    private String txtPayCodeName;
    private String payTxnHdrId;
    private String txtPayMode = null;
    private String txtPayType = null;
    private String txtNoofDays = null;
    private String txtValidUpto = null;
    private String txtValidFrom = null;
    private String txtAmount = null;    
    private String txtInstAmount = null;
    private String txtNoInst = null;
    private String txtAgencyName = null;
    private String txtAdvBalance = null;
    private String txtTxnCateg = null;
    private String txtAgency = null;
    private String txtAgencySite = null;
    private String txtAgencySiteCode = null;
    private String hdnPayCodeSrlNo;
    private String txtPayrollFlag;
    private String txtDepoCode;  // Added by dushaynt on 20-Aug-2013
    private String txtGangId;    // Added by dushaynt on 20-Aug-2013
    private String txtDepoName;   // Added by dushaynt on 20-Aug-2013
    private String txtGangName;    // Added by dushaynt on 20-Aug-2013
    
    

  public DirPayrollBulkHeaderBean()
  {
  }

  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }

  public String getTxtPayCodeName()
  {
    return txtPayCodeName;
  }

  public void setTxtPayCodeName(String newTxtPayCodeName)
  {
    txtPayCodeName = newTxtPayCodeName;
  }
  
  public String getPayTxnHdrId()
  {
    return payTxnHdrId;
  }

  public void setPayTxnHdrId(String newPayTxnHdrId)
  {
    payTxnHdrId = newPayTxnHdrId;
  }
  
  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }
  
  public String getTxtPayType()
  {
    return txtPayType;
  }

  public void setTxtPayType(String newTxtPayType)
  {
    txtPayType = newTxtPayType;
  }
  
   public String getTxtNoofDays()
  {
    return txtNoofDays;
  }

  public void setTxtNoofDays(String newTxtNoofDays)
  {
    txtNoofDays = newTxtNoofDays;
  }

  public String getTxtValidUpto()
  {
    return txtValidUpto;
  }

  public void setTxtValidUpto(String newTxtValidUpto)
  {
    txtValidUpto = newTxtValidUpto;
  }

  public String getTxtValidFrom()
  {
    return txtValidFrom;
  }

  public void setTxtValidFrom(String newTxtValidFrom)
  {
    txtValidFrom = newTxtValidFrom;
  }
  

  public String getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }
  
  public String getTxtInstAmount()
  {
    return txtInstAmount;
  }

  public void setTxtInstAmount(String newTxtInstAmount)
  {
    txtInstAmount = newTxtInstAmount;
  }

  public String getTxtNoInst()
  {
    return txtNoInst;
  }

  public void setTxtNoInst(String newTxtNoInst)
  {
    txtNoInst = newTxtNoInst;
  }

  public String getTxtAgencyName()
  {
    return txtAgencyName;
  }

  public void setTxtAgencyName(String newTxtAgencyName)
  {
    txtAgencyName = newTxtAgencyName;
  }
  
  public String getTxtAdvBalance()
  {
    return txtAdvBalance;
  }

  public void setTxtAdvBalance(String newTxtAdvBalance)
  {
    txtAdvBalance = newTxtAdvBalance;
  }

  public String getTxtTxnCateg()
  {
    return txtTxnCateg;
  }

  public void setTxtTxnCateg(String newTxtTxnCateg)
  {
    txtTxnCateg = newTxtTxnCateg;
  }

  public String getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }

  public String getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }

  public String getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }

  public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  }
  
 // Added by dushaynt on 20-Aug-2013
   public String getTxtDepoCode()
  {
    return txtDepoCode;
  }

  public void setTxtDepoCode(String newTxtDepoCode)
  {
    txtDepoCode = newTxtDepoCode;
  }

 public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  } 
  
  public String getTxtDepoName()
  {
    return txtDepoName;
  }

  public void setTxtDepoName(String newTxtDepoName)
  {
    txtDepoName = newTxtDepoName;
  }
  
   public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
  }
// end by dushaynt 
  
}