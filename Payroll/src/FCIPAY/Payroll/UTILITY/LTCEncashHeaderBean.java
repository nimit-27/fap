package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class LTCEncashHeaderBean extends PayrollBaseHeaderBean implements Serializable 
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
  
  private String txtSnctnDt;
  private String txtApplnDt;
  private String txtEncshAmt="";
  private String txtDedIT;
  private String txtDedOthr;
  private String txtRmrks;
  private String txtNetAmt;
  private String txtYYYY;
  private String txtLTCType;
  private String txtPayModeType;
  private String txtInvId;
  
  public LTCEncashHeaderBean()
  {
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

  public String getTxtSnctnDt()
  {
    return txtSnctnDt;
  }

  public void setTxtSnctnDt(String newTxtSnctnDt)
  {
    txtSnctnDt = newTxtSnctnDt;
  }  

  public String getTxtEncshAmt()
  {
    return txtEncshAmt;
  }

  public void setTxtEncshAmt(String newTxtEncshAmt)
  {
    txtEncshAmt = newTxtEncshAmt;
  }  

  public String getTxtDedIT()
  {
    return txtDedIT;
  }

  public void setTxtDedIT(String newTxtDedIT)
  {
    txtDedIT = newTxtDedIT;
  }  

  public String getTxtDedOthr()
  {
    return txtDedOthr;
  }

  public void setTxtDedOthr(String newTxtDedOthr)
  {
    txtDedOthr = newTxtDedOthr;
  }  

  public String getTxtRmrks()
  {
    return txtRmrks;
  }

  public void setTxtRmrks(String newTxtRmrks)
  {
    txtRmrks = newTxtRmrks;
  }

  public String getTxtNetAmt()
  {
    return txtNetAmt;
  }

  public void setTxtNetAmt(String newTxtNetAmt)
  {
    txtNetAmt = newTxtNetAmt;
  }

  public String getTxtLTCType()
  {
    return txtLTCType;
  }

  public void setTxtLTCType(String newTxtLTCType)
  {
    txtLTCType = newTxtLTCType;
  }

  public String getTxtYYYY()
  {
    return txtYYYY;
  }

  public void setTxtYYYY(String newTxtYYYY)
  {
    txtYYYY = newTxtYYYY;
  }
  
  public String getTxtCurrBas()
  {
    return txtCurrBas;
  }

  public void setTxtCurrBas(String newTxtCurrBas)
  {
    txtCurrBas = newTxtCurrBas;
  }

  public String getTxtPayModeType()
  {
    return txtPayModeType;
  }

  public void setTxtPayModeType(String newTxtPayModeType)
  {
    txtPayModeType = newTxtPayModeType;
  }
  
  public String getTxtApplnDt()
  {
    return txtApplnDt;
  }

  public void setTxtApplnDt(String newTxtApplnDt)
  {
    txtApplnDt = newTxtApplnDt;
  }  

  public String getTxtInvId()
  {
    return txtInvId;
  }

  public void setTxtInvId(String newTxtInvId)
  {
    txtInvId = newTxtInvId;
  }
}