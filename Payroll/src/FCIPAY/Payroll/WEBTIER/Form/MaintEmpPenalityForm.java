package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintEmpPenalityForm extends PayrollBaseForm
{
  private String hdnAction;
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
  private String txtGradePay; 
  private String txtPayScaleType;  
  private String newPayScaleCode; 
  private String newGradePay;   
  private String penaType;
  private String newDsgn;  
  private String newDsgnDesc;
  private String newBasic;  
  private String newCateg;  
  private String newCategDesc;  
  private String payScaleCode;  
  private String payScaleCodeDesc;
  private String remarks;  
  private String balAmt;
  private String recvYYMM;
  private String fstInstamntAmt;
  private String noOfInstalmnt;
  private String instalmntAmt;
  private String recvdAmt;
  private String txtPerPayHighQual;
  private String txtPerPayAdvIncr;
  private String hdnStartBasic;
  private String hdnEndBasic;
  private String txtPayType;
  private String newPerPayHighQual;
  private String newPerPayFutIncr;
  private String newStagInc;
  private String txtPersPaySFNAmt;
  private String txtStagInc;
  private String perPayFutureIncr;
  private String adhcPromEndDate;
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
  private String txtReinstateDt;
  private String txtReinstRsn;
  private String incrWaveFrm;
  private String incrWaveTo;
  
  public MaintEmpPenalityForm()
  {
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
  public String getTxtPayType()
  {
    return txtPayType;
  }
  public void setTxtPayType(String newTxtPayType)
  {
    txtPayType = newTxtPayType;
  }
  public String getPenaType()
  {
    return penaType;
  }
  public void setPenaType(String newPenaType)
  {
    penaType = newPenaType;
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
  public String getNewPenaEffDate()
  {
    return newPenaEffDate;
  }
  public void setNewPenaEffDate(String newNewPenaEffDate)
  {
    newPenaEffDate = newNewPenaEffDate;
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
  public String getNewPerPayHighQual()
  {
    return newPerPayHighQual;
  }
  public void setNewPerPayHighQual(String newNewPerPayHighQual)
  {
    newPerPayHighQual = newNewPerPayHighQual;
  }
  public String getNewPerPayFutIncr()
  {
    return newPerPayFutIncr;
  }
  public void setNewPerPayFutIncr(String newNewPerPayFutIncr)
  {
    newPerPayFutIncr = newNewPerPayFutIncr;
  }
  public String getNewStagInc()
  {
    return newStagInc;
  }
  public void setNewStagInc(String newNewStagInc)
  {
    newStagInc = newNewStagInc;
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
  public String getTxtGradePay()
  {
    return txtGradePay;
  }
  public void setTxtGradePay(String newGradePay)
  {
    txtGradePay = newGradePay;
  }
  public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }
  public void setTxtPayScaleType(String newPayScaleType)
  {
    txtPayScaleType = newPayScaleType;
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
  public String getRecvdAmt()
  {
    return recvdAmt;
  }
  public void setRecvdAmt(String newRecvdAmt)
  {
    recvdAmt = newRecvdAmt;
  }
  public String getInstalmntAmt()
  {
    return instalmntAmt;
  }
  public void setInstalmntAmt(String newInstalmntAmt)
  {
    instalmntAmt = newInstalmntAmt;
  }
  public String getNoOfInstalmnt()
  {
    return noOfInstalmnt;
  }
  public void setNoOfInstalmnt(String newNoOfInstalmnt)
  {
    noOfInstalmnt = newNoOfInstalmnt;
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
  public String getTxtWaiveAmt()
  {
    return txtWaiveAmt;
  }
  public void setTxtWaiveAmt(String newTxtWaiveAmt)
  {
    txtWaiveAmt = newTxtWaiveAmt;
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
  public String getHdnAction()
  {
    return hdnAction;
  }
  public void setHdnAction(String newHdnAction)
  {
    hdnAction=newHdnAction;
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