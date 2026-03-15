package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class EmpTrnsfrHeaderBean extends PayrollBaseHeaderBean implements Serializable 
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
  
  private String txtTrnsfrTo;
  private String txtTrnsfrToDesc;
  private String txtTrnsfrFrom;
  private String txtTrnsfrReason;
  private String txtTrnsfrDt;
  private String txtRlvngDt;
  private String txtRlvngTime;
  private String txtJoiningDt;
  private String txtJoiningTime;
  private String hdnActionFlag;
  private String txtCreatedDt;
  private String txtModifiedDt;
//  private String txtSalary;    // Added by dushyant 
  private String txtIncentive;  // Added by dushyant on 15-dec-2011
  private String txtYYMM;
  
  public EmpTrnsfrHeaderBean()
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
  
  public String getTxtTrnsfrTo()
  {
    return txtTrnsfrTo;
  }

  public void setTxtTrnsfrTo(String newTxtTrnsfrTo)
  {
    txtTrnsfrTo = newTxtTrnsfrTo;
  }  

  public String getTxtTrnsfrToDesc()
  {
    return txtTrnsfrToDesc;
  }

  public void setTxtTrnsfrToDesc(String newTxtTrnsfrToDesc)
  {
    txtTrnsfrToDesc = newTxtTrnsfrToDesc;
  }  

  public String getTxtTrnsfrFrom()
  {
    return txtTrnsfrFrom;
  }

  public void setTxtTrnsfrFrom(String newTxtTrnsfrFrom)
  {
    txtTrnsfrFrom = newTxtTrnsfrFrom;
  }  

  public String getTxtTrnsfrReason()
  {
    return txtTrnsfrReason;
  }

  public void setTxtTrnsfrReason(String newTxtTrnsfrReason)
  {
    txtTrnsfrReason = newTxtTrnsfrReason;
  }  

  public String getTxtTrnsfrDt()
  {
    return txtTrnsfrDt;
  }

  public void setTxtTrnsfrDt(String newTxtTrnsfrDt)
  {
    txtTrnsfrDt = newTxtTrnsfrDt;
  }  

  public String getTxtRlvngDt()
  {
    return txtRlvngDt;
  }

  public void setTxtRlvngDt(String newTxtRlvngDt)
  {
    txtRlvngDt = newTxtRlvngDt;
  }  

  public String getTxtRlvngTime()
  {
    return txtRlvngTime;
  }

  public void setTxtRlvngTime(String newTxtRlvngTime)
  {
    txtRlvngTime = newTxtRlvngTime;
  }  

  public String getTxtJoiningDt()
  {
    return txtJoiningDt;
  }

  public void setTxtJoiningDt(String newTxtJoiningDt)
  {
    txtJoiningDt = newTxtJoiningDt;
  }  

  public String getTxtJoiningTime()
  {
    return txtJoiningTime;
  }

  public void setTxtJoiningTime(String newTxtJoiningTime)
  {
    txtJoiningTime = newTxtJoiningTime;
  }
  
  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  } 

  public String getHdnActionFlag()
  {
    return hdnActionFlag;
  }

  public void setHdnActionFlag(String newHdnActionFlag)
  {
    hdnActionFlag = newHdnActionFlag;
  } 
  ///added by sonia on 08-11-2011    setTxtModifiedDt
  public String getTxtCreatedDt()
  {
    return txtCreatedDt;
  }

  public void setTxtCreatedDt(String newTxtCreatedDt)
  {
    txtCreatedDt = newTxtCreatedDt;
  }
  
   public String getTxtModifiedDt()
  {
    return txtModifiedDt;
  }

  public void setTxtModifiedDt(String newTxtModifiedDt)
  {
    txtModifiedDt = newTxtModifiedDt;
  }
  ///end by sonia on 08-11-2011
 // Added by dushyant on 14-Dec-2011
 /*  public String getTxtSalary()    //   txtSalary  TxtSalary
  {
    return txtSalary;
  }

  public void setTxtSalary(String newTxtSalary)
  {
    txtSalary = newTxtSalary;
  } 
  */
   public String getTxtIncentive()    //   txtSalary  TxtSalary  txtIncentive  TxtIncentive
  {
    return txtIncentive;
  }

  public void setTxtIncentive(String newTxtIncentive)
  {
    txtIncentive = newTxtIncentive;
  } 
  // end by dushyant
}