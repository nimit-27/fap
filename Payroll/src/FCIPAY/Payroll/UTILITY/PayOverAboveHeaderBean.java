package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class PayOverAboveHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{  
  private String txtEmpNo;
  private String txtEmpName;
  private String txtDsgn;  
  private String txtDsgnDesc;
  private String txtCateg;  
  private String txtCategDesc; 
  private String txtEmpType;
  private String txtCpfCode;
  private String txtPresentPOP;
  private String txtPresentPOPDesc;
  private String txtDOJSite;
  private String txtEmpStatus;
  private String txtCurrBas;
  private String txtPayScaleType;
  
  private String txtApplnDt;
  private String txtSnctnDt;
  private String txtSnctnAmnt;  
  private String txtCpfEmpCntrb;
  private String txtCpfEmplyrCntrb;
  private String txtDedIT;  
  private String txtNetAmt;
  private String txtPayCode;  
  private String txtPayCodeDesc;  
  private String payCodeTaxInd;
  private String txtInvoceId;    
  private String hdnCpfDed;
  private String chkCpfDed;
  private String txtAgencyCode;
  private String txtAgencyCodeDesc;
  private String txtAgencySiteCode;
  private String txtAgencySiteCodeDesc;
  public PayOverAboveHeaderBean()
  {
  }
  
  
  public String getTxtAgencyCode()
  {
    return txtAgencyCode;
  }
  
  public void setTxtAgencyCode(String newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }  
  
  
  public String getTxtAgencyCodeDesc()
  {
    return txtAgencyCodeDesc;
  }
  
  public void setTxtAgencyCodeDesc(String newTxtAgencyCodeDesc)
  {
    txtAgencyCodeDesc = newTxtAgencyCodeDesc;
  }  
  
  
   public String getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }
  
  public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  }  

  
  public String getTxtAgencySiteCodeDesc()
  {
    return txtAgencySiteCodeDesc;
  }
  
  public void setTxtAgencySiteCodeDesc(String newTxtAgencySiteCodeDesc)
  {
    txtAgencySiteCodeDesc = newTxtAgencySiteCodeDesc;
  }  
  
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }
  
  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }  

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }

  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }
  
  public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }  

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  

  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtPresentPOPDesc()
  {
    return txtPresentPOPDesc;
  }

  public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc)
  {
    txtPresentPOPDesc = newTxtPresentPOPDesc;
  }

  public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  }

  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }

  public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
  
  public String getTxtApplnDt()
  {
    return txtApplnDt;
  }

  public void setTxtApplnDt(String newTxtApplnDt)
  {
    txtApplnDt = newTxtApplnDt;
  }  

  public String getTxtSnctnDt()
  {
    return txtSnctnDt;
  }

  public void setTxtSnctnDt(String newTxtSnctnDt)
  {
    txtSnctnDt = newTxtSnctnDt;
  } 

  public String getTxtSnctnAmnt()
  {
    return txtSnctnAmnt;
  }

  public void setTxtSnctnAmnt(String newTxtSnctnAmnt)
  {
    txtSnctnAmnt = newTxtSnctnAmnt;
  }  

  public String getTxtCpfEmpCntrb()
  {
    return txtCpfEmpCntrb;
  }

  public void setTxtCpfEmpCntrb(String newTxtCpfEmpCntrb)
  {
    txtCpfEmpCntrb = newTxtCpfEmpCntrb;
  }  

  public String getTxtCpfEmplyrCntrb()
  {
    return txtCpfEmplyrCntrb;
  }

  public void setTxtCpfEmplyrCntrb(String newTxtCpfEmplyrCntrb)
  {
    txtCpfEmplyrCntrb = newTxtCpfEmplyrCntrb;
  }  

  public String getTxtDedIT()
  {
    return txtDedIT;
  }

  public void setTxtDedIT(String newTxtDedIT)
  {
    txtDedIT = newTxtDedIT;
  } 

  public String getTxtNetAmt()
  {
    return txtNetAmt;
  }

  public void setTxtNetAmt(String newTxtNetAmt)
  {
    txtNetAmt = newTxtNetAmt;
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  } 
  
  public String getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  } 
  
  public String getPayCodeTaxInd()
  {
    return payCodeTaxInd;
  }

  public void setPayCodeTaxInd(String newPayCodeTaxInd)
  {
    payCodeTaxInd = newPayCodeTaxInd;
  } 
  
  public String getTxtInvoceId()
  {
    return txtInvoceId;
  }

  public void setTxtInvoceId(String newTxtInvoceId)
  {
    txtInvoceId = newTxtInvoceId;
  } 
  
  public String getChkCpfDed()
  {
    return chkCpfDed;
  }

  public void setChkCpfDed(String newChkCpfDed)
  {
    chkCpfDed = newChkCpfDed;
  }
  
  public String getHdnCpfDed()
  {
    return hdnCpfDed;
  }

  public void setHdnCpfDed(String newHdnCpfDed)
  {
    hdnCpfDed = newHdnCpfDed;
  }

  public String getTxtCurrBas()
  {
    return txtCurrBas;
  }

  public void setTxtCurrBas(String newTxtCurrBas)
  {
    txtCurrBas = newTxtCurrBas;
  }  

}