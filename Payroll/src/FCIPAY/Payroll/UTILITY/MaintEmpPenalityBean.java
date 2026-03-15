package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintEmpPenalityBean extends PayrollBaseHeaderBean implements Serializable  
{
  private String txtPenaltyId;  
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
  private String txtCurtBasic;
  private String txtPrvPromDate;
  private String txtPayType;
  private String txtPersPaySFNAmt;  
  private String txtPerPayHighQual;
  private String txtPerPayAdvIncr;
  private String txtStagInc;
  private String perPayFutureIncr;
  private String txtGradePay; 
  private String txtPayScaleType;
  private String newPayScaleCode;  
  private String newGradePay; 
  //private String txtDsgnId;
  private String penalityType;
  private String newDsgn;  
  private String newDsgnDesc;
  private String newBasic;  
  private String newCateg;  
  private String newCategDesc;  
  private String payScaleCode;
  private String payScaleCodeDesc;
  private String hdnStartBasic;
  private String hdnEndBasic; 
  private String remarks;  
  private String balAmt;
  private String recvYYMM;
  private String fstInstamntAmt;
  private String noOfInstalmnt;
  private String instalmntAmt;
  private String recvdAmt;
  private String penaType;
  private String newPenaEffDate;
  private String txtWaiveAmt;
  private String txtPenaEffDateTo;
  private String txtWaiveFlg;
  private String txtIncrType;
  private String balInstalmnt;
  private String txtIncrReinstFlg;
  private String txtWaiveAmtPrt;
  private String txtWaiveDt;
  private String txtWaiveAmtRmn;
  private String incrWaveFrm;
  private String incrWaveTo;
  private String txtReinstateDt;
  private String txtReinstRsn;
  
  public MaintEmpPenalityBean()
  {
  }

  public String getTxtWaiveAmt()
  {
    return txtWaiveAmt;
  }

  public void setTxtWaiveAmt(String newTxtWaiveAmt)
  {
    txtWaiveAmt = newTxtWaiveAmt;
  }

  public String getTxtPenaltyId()
  {
    return txtPenaltyId;
  }

  public void setTxtPenaltyId(String newTxtPenaltyId)
  {
    txtPenaltyId = newTxtPenaltyId;
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
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
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
  
  public String getTxtCurtBasic()
  {
    return txtCurtBasic;
  }

  public void setTxtCurtBasic(String newTxtCurtBasic)
  {
    txtCurtBasic = newTxtCurtBasic;
  }
  
  public String getTxtPrvPromDate()
  {
    return txtPrvPromDate;
  }

  public void setTxtPrvPromDate(String newTxtPrvPromDate)
  {
    txtPrvPromDate = newTxtPrvPromDate;
  }
  
   public String getTxtPayType()
  {

    return txtPayType;
  }

  public void setTxtPayType(String newTxtPayType)
  {
    txtPayType = newTxtPayType;
  }
  
  public String getTxtPersPaySFNAmt()
  {
    return txtPersPaySFNAmt;
  }

  public void setTxtPersPaySFNAmt(String newTxtPersPaySFNAmt)
  {
    txtPersPaySFNAmt = newTxtPersPaySFNAmt;
  } 
  
  public String getTxtPerPayHighQual()
  {
    return txtPerPayHighQual;
  }

  public void setTxtPerPayHighQual(String newTxtPerPayHighQual)
  {
    txtPerPayHighQual = newTxtPerPayHighQual;
  }
  
   public String getTxtPerPayAdvIncr()
  {
    return txtPerPayAdvIncr;
  }

  public void setTxtPerPayAdvIncr(String newTxtPerPayAdvIncr)
  {
    txtPerPayAdvIncr = newTxtPerPayAdvIncr;
  } 
  
  public String getTxtStagInc()
  {
    return txtStagInc;
  }

  public void setTxtStagInc(String newTxtStagInc)
  {
    txtStagInc = newTxtStagInc;
  }
  
  public String getPerPayFutureIncr()
  {
    return perPayFutureIncr;
  }

  public void setPerPayFutureIncr(String newPerPayFutureIncr)
  {
    perPayFutureIncr = newPerPayFutureIncr;
  }


  public String getPenalityType()
  {
    return penalityType;
  }

  public void setPenalityType(String newPenalityType)
  {
    penalityType = newPenalityType;
  }
 
 public String getNewDsgn()
  {
    return newDsgn;
  }
  public void setNewDsgn(String newNewDsgn)
  {
    newDsgn = newNewDsgn;
  }
  
  public String getNewDsgnDesc()
  {
    return newDsgnDesc;
  }
  
  public void setNewDsgnDesc(String newNewDsgnDesc)
  {
    newDsgnDesc = newNewDsgnDesc;
  }
  
  public String getNewBasic()
  {
    return newBasic;
  }

  public void setNewBasic(String newNewBasic)
  {
    newBasic = newNewBasic;
  }
  
  public String getRemarks()
  {
    return remarks;
  }

  public void setRemarks(String newRemarks)
  {
    remarks = newRemarks;
  }
  
  public String getNewCateg()
  {
    return newCateg;
  }

  public void setNewCateg(String newNewCateg)
  {
    newCateg = newNewCateg;
  }
  
  public String getNewCategDesc()
  {
    return newCategDesc;
  }

  public void setNewCategDesc(String newNewCategDesc)
  {
    newCategDesc = newNewCategDesc;
  }
  
  public String getPayScaleCode()
  {
    return payScaleCode;
  }

  public void setPayScaleCode(String newPayScaleCode)
  {
    payScaleCode = newPayScaleCode;
  }
  
  public String getPayScaleCodeDesc()
  {
    return payScaleCodeDesc;
  }

  public void setPayScaleCodeDesc(String newPayScaleCodeDesc)
  {
    payScaleCodeDesc = newPayScaleCodeDesc;
  }
  
  public String getHdnStartBasic()
  {
    return hdnStartBasic;
  }

  public void setHdnStartBasic(String newHdnStartBasic)
  {
    hdnStartBasic = newHdnStartBasic;
  }
  
  public String getHdnEndBasic()
  {
    return hdnEndBasic;
  }

  public void setHdnEndBasic(String newHdnEndBasic)
  {
    hdnEndBasic = newHdnEndBasic;
  }
  
  
  
    //added by sonia on 08-04-2011
  public String getTxtGradePay()
  {
    return txtGradePay;
  }

  public void setTxtGradePay(String newTxtGradePay)
  {
    txtGradePay = newTxtGradePay;
  }
 
  public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
  
   public String getNewPayScaleCode()
  {
    return newPayScaleCode;
  }

  public void setNewPayScaleCode(String newPayScaleCode1)
  {
    newPayScaleCode = newPayScaleCode1;
  }
   public String getNewGradePay()
  {
    return newGradePay;
  }

  public void setNewGradePay(String newGradePay1)
  {
    newGradePay = newGradePay1;
  }
  
  public String getBalAmt()
  {
    return balAmt;
  }

  public void setBalAmt(String newBalAmt)
  {
    balAmt = newBalAmt;
  }

   public String getRecvYYMM()
  {
    return recvYYMM;
  }

  public void setRecvYYMM(String newRecvYYMM)
  {
    recvYYMM = newRecvYYMM;
  }

   public String getFstInstamntAmt()
  {
    return fstInstamntAmt;
  }

  public void setFstInstamntAmt(String newFstInstamntAmt)
  {
    fstInstamntAmt = newFstInstamntAmt;
  }

   public String getNoOfInstalmnt()
  {
    return noOfInstalmnt;
  }

  public void setNoOfInstalmnt(String newNoOfInstalmnt)
  {
    noOfInstalmnt = newNoOfInstalmnt;
  }

   public String getInstalmntAmt()
  {
    return instalmntAmt;
  }

  public void setInstalmntAmt(String newInstalmntAmt)
  {
    instalmntAmt = newInstalmntAmt;
  }

   public String getRecvdAmt()
  {
    return recvdAmt;
  }

  public void setRecvdAmt(String newRecvdAmt)
  {
    recvdAmt = newRecvdAmt;
  }
  
  public String getPenaType()
  {
    return penaType;
  }

  public void setPenaType(String newPenaType)
  {
    penaType = newPenaType;
  }
  public String getNewPenaEffDate()
  {
    return newPenaEffDate;
  }

  public void setNewPenaEffDate(String newNewPenaEffDate)
  {
    newPenaEffDate = newNewPenaEffDate;
  }

  public String getTxtPenaEffDateTo()
  {
    return txtPenaEffDateTo;
  }

  public void setTxtPenaEffDateTo(String newTxtPenaEffDateTo)
  {
    txtPenaEffDateTo = newTxtPenaEffDateTo;
  }
  
  public String getTxtWaiveFlg()
  {
    return txtWaiveFlg;
  }

  public void setTxtWaiveFlg(String newTxtWaiveFlg)
  {
    txtWaiveFlg = newTxtWaiveFlg;
  }
  
  public String getTxtIncrType()
  {
    return txtIncrType;
  }

  public void setTxtIncrType(String newTxtIncrType)
  {
    txtIncrType = newTxtIncrType;
  }
  public String getBalInstalmnt()
  {
    return balInstalmnt;
  }
  
  public void setBalInstalmnt(String newBalInstalmnt)
  {
    balInstalmnt = newBalInstalmnt;
  }
  public String getTxtIncrReinstFlg()
  {
    return txtIncrReinstFlg;
  }
  public void setTxtIncrReinstFlg(String newTxtIncrReinstFlg)
  {
    txtIncrReinstFlg = newTxtIncrReinstFlg;
  }
  public String getTxtWaiveAmtPrt()
  {
    return txtWaiveAmtPrt;
  }
  public void setTxtWaiveAmtPrt(String newTxtWaiveAmtPrt)
  {
    txtWaiveAmtPrt = newTxtWaiveAmtPrt;
  }
  public String getTxtWaiveDt()
  {
    return txtWaiveDt;
  }
  public void setTxtWaiveDt(String newTxtWaiveDt)
  {
    txtWaiveDt = newTxtWaiveDt;
  }
  public String getTxtWaiveAmtRmn()
  {
    return txtWaiveAmtRmn;
  }
  public void setTxtWaiveAmtRmn(String newTxtWaiveAmtRmn)
  {
    txtWaiveAmtRmn = newTxtWaiveAmtRmn;
  }
    public String getIncrWaveFrm() {
        return incrWaveFrm;
    }
    public void setIncrWaveFrm(String incrWaveFrm) {
        this.incrWaveFrm = incrWaveFrm;
    }
    public String getIncrWaveTo() {
        return incrWaveTo;
    }
    public void setIncrWaveTo(String incrWaveTo) {
        this.incrWaveTo = incrWaveTo;
    }
  public String getTxtReinstateDt()
  {
    return txtReinstateDt;
  }
  public void setTxtReinstateDt(String newTxtReinstateDt)
  {
    txtReinstateDt = newTxtReinstateDt;
  }
  public String getTxtReinstRsn()
  {
    return txtReinstRsn;
  }
  public void setTxtReinstRsn(String newTxtReinstRsn)
  {
    txtReinstRsn = newTxtReinstRsn;
  }
}