package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class CPFFinalPaymentForm extends PayrollBaseForm
{
  private String txtEmpNo;  
  private String txtEmpName;  
  private String txtDsgn;    
  private String txtCateg; 
  private String txtEmpType;
  private String txtCpfCode; 
  private String txtStaffCode; 
  private String txtPresentPOP;  
  private String txtEmpStatus; 
  private String hdnAction;
  private String possDate;
  //added by himanshu on 10-jan-2015
  private String txtappscancel;
  
  private String empContri;
  private String emplyrContri;
  private String vpfContri;
  private String sancOrderNo;  
  private String sancDate;  
  private String remarks; 
  private String hdnSancType;
  private String sancAmount;
  private String txtInvID;  
  private String txtReason;
  private String txtApplAmt;
  private String cancelStatus;
  
//Fields for Final Payment
  private String intrstEmpContri;
  private String intrstEmplyrContri;
  private String intrstVpfContri;
  private String intrstIntrvngPrd;
  private String partFinalWid;  
  private String cpfAdvIntRcvry;
  private String tdsIntIntrvngPrd;
  private String netAmntPayble;  
  private String withdrEmpContri;
  private String withdrEmplyrContri;
  private String withdrVpfContri;
  
//Fields for CPF Advance  
  private String installAmt;
  private String noInstallAmt;
  private String firstInstall;
  private String recoveryYYMM;
  private String noIntInstall;
  private String intInstall;
  private String hdnRecYYMM;
//Fields for CPF Part Final Payment Screen  
  private String txtDedIT;

//Fields for CPF Payment Screen  
  private String [] txtEmpNoDtl;  
  private String [] txtEmpNameDtl;   
  private String [] sancOrderNoDtl;  
  private String [] sancDateDtl;
  private String [] sancAmountDtl; 
  private String [] dedITDtl;
  private String [] flgDedITDtl;
  private String [] txtRecYYYYMM;
  private String [] txtsancReason;
  private String [] txtEmployeeCntr;
  private String [] txtEmployerCntr;
  private String [] txtInvoiceNo;
  private ArrayList lstInstrDtls=new ArrayList();
  
//Fields for CPF Int Calc Screen
  private String txtYr;
  private String txtEmpLbrFlag;
  private String txtSysSantionNum;// added by gagan on 01-07-2013 to add new sanction num
  private String claimReqId;
  public CPFFinalPaymentForm()
  {
  }
//-------------------------------------------------------
// added by gagan on 01-07-2013 to add new sanction num
public String getTxtSysSantionNum()
  {
    return txtSysSantionNum;
  }

  public void setTxtSysSantionNum(String newTxtSysSantionNum)
  {
    txtSysSantionNum = newTxtSysSantionNum;
  }
//--------------------------------------------------------
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
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
   public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }  
 
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }

  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  }
  
  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
  
  public String getEmpContri()
  {
    return empContri;
  }

  public void setEmpContri(String newEmpContri)
  {
    empContri = newEmpContri;
  }
  
  public String getEmplyrContri()
  {
    return emplyrContri;
  }

  public void setEmplyrContri(String newEmplyrContri)
  {
    emplyrContri = newEmplyrContri;
  }
  
  public String getVpfContri()
  {
    return vpfContri;
  }

  public void setVpfContri(String newVpfContri)
  {
    vpfContri = newVpfContri;
  }
  
  public String getIntrstEmpContri()
  {
    return intrstEmpContri;
  }

  public void setIntrstEmpContri(String newIntrstEmpContri)
  {
    intrstEmpContri = newIntrstEmpContri;
  }
  
  public String getIntrstEmplyrContri()
  {
    return intrstEmplyrContri;
  }

  public void setIntrstEmplyrContri(String newIntrstEmplyrContri)
  {
    intrstEmplyrContri = newIntrstEmplyrContri;
  }

  public String getIntrstVpfContri()
  {
    return intrstVpfContri;
  }

  public void setIntrstVpfContri(String newIntrstVpfContri)
  {
    intrstVpfContri = newIntrstVpfContri;
  }
  
  public String getIntrstIntrvngPrd()
  {
    return intrstIntrvngPrd;
  }

  public void setIntrstIntrvngPrd(String newIntrstIntrvngPrd)
  {
    intrstIntrvngPrd = newIntrstIntrvngPrd;
  }
  
  public String getPartFinalWid()
  {
    return partFinalWid;
  }

  public void setPartFinalWid(String newPartFinalWid)
  {
    partFinalWid = newPartFinalWid;
  }
  
  public String getCpfAdvIntRcvry()
  {
    return cpfAdvIntRcvry;
  }

  public void setCpfAdvIntRcvry(String newCpfAdvIntRcvry)
  {
    cpfAdvIntRcvry = newCpfAdvIntRcvry;
  }
  
  public String getTdsIntIntrvngPrd()
  {
    return tdsIntIntrvngPrd;
  }

  public void setTdsIntIntrvngPrd(String newTdsIntIntrvngPrd)
  {
    tdsIntIntrvngPrd = newTdsIntIntrvngPrd;
  }
  
  public String getSancAmount()
  {
    return sancAmount;
  }

  public void setSancAmount(String newSancAmount)
  {
    sancAmount = newSancAmount;
  }
  
  public String getNetAmntPayble()
  {
    return netAmntPayble;
  }

  public void setNetAmntPayble(String newNetAmntPayble)
  {
    netAmntPayble = newNetAmntPayble;
  }
  
  public String getSancOrderNo()
  {
    return sancOrderNo;
  }

  public void setSancOrderNo(String newSancOrderNo)
  {
    sancOrderNo = newSancOrderNo;
  }
  
  public String getSancDate()
  {
    return sancDate;
  }

  public void setSancDate(String newSancDate)
  {
    sancDate = newSancDate;
  } 
  
  public String getRemarks()
  {
    return remarks;
  }

  public void setRemarks(String newRemarks)
  {
    remarks = newRemarks;
  } 
  
  public String getTxtInvID()
  {
    return txtInvID;
  }

  public void setTxtInvID(String newTxtInvID)
  {
    txtInvID = newTxtInvID;
  } 

  public String getTxtReason()
  {
    return txtReason;
  }

  public void setTxtReason(String newTxtReason)
  {
    txtReason = newTxtReason;
  }

  public String getTxtApplAmt()
  {
    return txtApplAmt;
  }

  public void setTxtApplAmt(String newTxtApplAmt)
  {
    txtApplAmt = newTxtApplAmt;
  }
  
  public String getHdnSancType()
  {
    return hdnSancType;
  }

  public void setHdnSancType(String newHdnSancType)
  {
    hdnSancType = newHdnSancType;
  } 
  
  public String getFirstInstall()
  {
    return firstInstall;
  }

  public void setFirstInstall(String newFirstInstall)
  {
    firstInstall = newFirstInstall;
  } 
  
  public String getRecoveryYYMM()
  {
    return recoveryYYMM;
  }

  public void setRecoveryYYMM(String newRecoveryYYMM)
  {
    recoveryYYMM = newRecoveryYYMM;
  } 
  
  
  public String getNoInstallAmt()
  {
    return noInstallAmt;
  }

  public void setNoInstallAmt(String newNoInstallAmt)
  {
    noInstallAmt = newNoInstallAmt;
  } 
  
  public String getInstallAmt()
  {
    return installAmt;
  }

  public void setInstallAmt(String newInstallAmt)
  {
    installAmt = newInstallAmt;
  } 

  public String getNoIntInstall()
  {
    return noIntInstall;
  }

  public void setNoIntInstall(String newNoIntInstall)
  {
    noIntInstall = newNoIntInstall;
  } 
  
  public String getIntInstall()
  {
    return intInstall;
  }

  public void setIntInstall(String newIntInstall)
  {
    intInstall = newIntInstall;
  } 
  
  public String getWithdrEmpContri()
  {
    return withdrEmpContri;
  }

  public void setWithdrEmpContri(String newWithdrEmpContri)
  {
    withdrEmpContri = newWithdrEmpContri;
  }
  
  public String getWithdrEmplyrContri()
  {
    return withdrEmplyrContri;
  }

  public void setWithdrEmplyrContri(String newWithdrEmplyrContri)
  {
    withdrEmplyrContri = newWithdrEmplyrContri;
  }

  public String getWithdrVpfContri()
  {
    return withdrVpfContri;
  }

  public void setWithdrVpfContri(String newWithdrVpfContri)
  {
    withdrVpfContri = newWithdrVpfContri;
  }

  public String [] getTxtEmpNoDtl()
  {
    return txtEmpNoDtl;
  }

  public void setTxtEmpNoDtl(String [] newTxtEmpNoDtl)
  {
    txtEmpNoDtl = newTxtEmpNoDtl;
  }
  
  
  public String [] getTxtInvoiceNo()
  {
    return txtInvoiceNo;
  }

  public void setTxtInvoiceNo(String [] newTxtInvoiceNo)
  {
    txtInvoiceNo = newTxtInvoiceNo;
  }
  
  public String [] getTxtEmpNameDtl()
  {
    return txtEmpNameDtl;
  }

  public void setTxtEmpNameDtl(String [] newTxtEmpNameDtl)
  {
    txtEmpNameDtl = newTxtEmpNameDtl;
  }
  
  public String [] getSancAmountDtl()
  {
    return sancAmountDtl;
  }

  public void setSancAmountDtl(String [] newSancAmountDtl)
  {
    sancAmountDtl = newSancAmountDtl;
  }
  
  public String [] getSancOrderNoDtl()
  {
    return sancOrderNoDtl;
  }

  public void setSancOrderNo(String [] newSancOrderNoDtl)
  {
    sancOrderNoDtl = newSancOrderNoDtl;
  }
  
  public String [] getSancDateDtl()
  {
    return sancDateDtl;
  }

  public void setSancDateDtl(String [] newSancDateDtl)
  {
    sancDateDtl = newSancDateDtl;
  } 

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  } 
  
  public String getHdnAction()
  {
    return hdnAction;
  }
  
  public void setHdnAction(String newHdnAction)
  {
    hdnAction=newHdnAction;
  }
  
   public String getHdnRecYYMM()
  {
    return hdnRecYYMM;
  }
  
  public void setHdnRecYYMM(String newHdnRecYYMM)
  {
    hdnRecYYMM=newHdnRecYYMM;
  }
  

  public String getTxtYr()
  {
    return txtYr;
  }
  
  public void setTxtYr(String newTxtYr)
  {
    txtYr=newTxtYr;
  }

  public String getTxtEmpLbrFlag()
  {
    return txtEmpLbrFlag;
  }
  
  public void setTxtEmpLbrFlag(String newTxtEmpLbrFlag)
  {
    txtEmpLbrFlag=newTxtEmpLbrFlag;
  }
  
  public String getCancelStatus()
  {
    return cancelStatus;
  }
  
  public void setCancelStatus(String newCancelStatus)
  {
    cancelStatus=newCancelStatus;
  }

  public String getTxtDedIT()
  {
    return txtDedIT;
  }
  
  public void setTxtDedIT(String newTxtDedIT)
  {
    txtDedIT=newTxtDedIT;
  }
  
  public String [] getDedITDtl()
  {
    return dedITDtl;
  }
  
  public void setDedITDtl(String [] newDedITDtl)
  {
    dedITDtl=newDedITDtl;
  }
  
  public String [] getFlgDedITDtl()
  {
    return flgDedITDtl;
  }
  
  public void setFlgDedITDtl(String [] newFlgDedITDtl)
  {
    flgDedITDtl=newFlgDedITDtl;
  }  
  
   public String [] getTxtRecYYYYMM()
  {
    return txtRecYYYYMM;
  }

  public void setTxtRecYYYYMM(String [] newTxtRecYYYYMM)
  {
    txtRecYYYYMM = newTxtRecYYYYMM;
  }
  
  
  public String [] getTxtsancReason()
  {
    return txtsancReason;
  }

  public void setTxtsancReason(String [] newTxtsancReason)
  {
    txtsancReason = newTxtsancReason;
  }
  
   public String [] getTxtEmployeeCntr()
  {
    return txtEmployeeCntr;
  }

  public void setTxtEmployeeCntr(String [] newTxtEmployeeCntr)
  {
    txtEmployeeCntr = newTxtEmployeeCntr;
  }
  
   public String [] getTxtEmployerCntr()
  {
    return txtEmployerCntr;
  }

  public void setTxtEmployerCntr(String [] newTxtEmployerCntr)
  {
    txtEmployerCntr = newTxtEmployerCntr;
  }

//added by himanshu on 10-jan-2015;

    public void setTxtappscancel(String newTxtappscancel)
  {
    txtappscancel = newTxtappscancel;
  }
 
   public String getTxtappscancel()
  {
    return txtappscancel;
  }

    public void setClaimReqId(String claimReqId) {
        this.claimReqId = claimReqId;
    }

    public String getClaimReqId() {
        return claimReqId;
    }


    public void setPossDate(String possDate) {
        this.possDate = possDate;
    }

    public String getPossDate() {
        return possDate;
    }
}
