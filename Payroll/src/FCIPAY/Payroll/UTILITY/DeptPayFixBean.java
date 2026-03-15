package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class DeptPayFixBean extends PayrollBaseHeaderBean implements Serializable  {
    
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
    
    private String promType;
    private String newDsgn;  
    private String newDsgnDesc;
    private String newBasic;  
    private String newCateg;  
    private String newCategDesc;  
    private String payScaleCode;
    private String payScaleCodeDesc;
    private String hdnStartBasic;
    private String hdnEndBasic;  
    private String newPerPayHighQual;
    private String newPerPayFutIncr;
    private String newStagInc;
    private String newPromEffDate;  
    private String adhcPromEndDate; 
    private String remarks;
    
    private String gradePay;
    private String payBand;
    private String cancelStatus;
    private String txtFixationFlag;
    private String newGradePay;
    private String newBasic1;
    private String newPromEffDate1; 
    public DeptPayFixBean() {
       
    }


    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtDsgn(String txtDsgn) {
        this.txtDsgn = txtDsgn;
    }

    public String getTxtDsgn() {
        return txtDsgn;
    }

    public void setTxtDsgnDesc(String txtDsgnDesc) {
        this.txtDsgnDesc = txtDsgnDesc;
    }

    public String getTxtDsgnDesc() {
        return txtDsgnDesc;
    }

    public void setTxtCateg(String txtCateg) {
        this.txtCateg = txtCateg;
    }

    public String getTxtCateg() {
        return txtCateg;
    }

    public void setTxtCategDesc(String txtCategDesc) {
        this.txtCategDesc = txtCategDesc;
    }

    public String getTxtCategDesc() {
        return txtCategDesc;
    }

    public void setTxtEmpType(String txtEmpType) {
        this.txtEmpType = txtEmpType;
    }

    public String getTxtEmpType() {
        return txtEmpType;
    }

    public void setTxtCpfCode(String txtCpfCode) {
        this.txtCpfCode = txtCpfCode;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
    }

    public void setTxtPresentPOP(String txtPresentPOP) {
        this.txtPresentPOP = txtPresentPOP;
    }

    public String getTxtPresentPOP() {
        return txtPresentPOP;
    }

    public void setTxtPresentPOPDesc(String txtPresentPOPDesc) {
        this.txtPresentPOPDesc = txtPresentPOPDesc;
    }

    public String getTxtPresentPOPDesc() {
        return txtPresentPOPDesc;
    }

    public void setTxtDOJSite(String txtDOJSite) {
        this.txtDOJSite = txtDOJSite;
    }

    public String getTxtDOJSite() {
        return txtDOJSite;
    }

    public void setTxtEmpStatus(String txtEmpStatus) {
        this.txtEmpStatus = txtEmpStatus;
    }

    public String getTxtEmpStatus() {
        return txtEmpStatus;
    }

    public void setTxtCurtBasic(String txtCurtBasic) {
        this.txtCurtBasic = txtCurtBasic;
    }

    public String getTxtCurtBasic() {
        return txtCurtBasic;
    }

    public void setTxtPrvPromDate(String txtPrvPromDate) {
        this.txtPrvPromDate = txtPrvPromDate;
    }

    public String getTxtPrvPromDate() {
        return txtPrvPromDate;
    }

    public void setTxtPayType(String txtPayType) {
        this.txtPayType = txtPayType;
    }

    public String getTxtPayType() {
        return txtPayType;
    }

    public void setTxtPersPaySFNAmt(String txtPersPaySFNAmt) {
        this.txtPersPaySFNAmt = txtPersPaySFNAmt;
    }

    public String getTxtPersPaySFNAmt() {
        return txtPersPaySFNAmt;
    }

    public void setTxtPerPayHighQual(String txtPerPayHighQual) {
        this.txtPerPayHighQual = txtPerPayHighQual;
    }

    public String getTxtPerPayHighQual() {
        return txtPerPayHighQual;
    }

    public void setTxtPerPayAdvIncr(String txtPerPayAdvIncr) {
        this.txtPerPayAdvIncr = txtPerPayAdvIncr;
    }

    public String getTxtPerPayAdvIncr() {
        return txtPerPayAdvIncr;
    }

    public void setTxtStagInc(String txtStagInc) {
        this.txtStagInc = txtStagInc;
    }

    public String getTxtStagInc() {
        return txtStagInc;
    }

    public void setPerPayFutureIncr(String perPayFutureIncr) {
        this.perPayFutureIncr = perPayFutureIncr;
    }

    public String getPerPayFutureIncr() {
        return perPayFutureIncr;
    }

    public void setPromType(String promType) {
        this.promType = promType;
    }

    public String getPromType() {
        return promType;
    }

    public void setNewDsgn(String newDsgn) {
        this.newDsgn = newDsgn;
    }

    public String getNewDsgn() {
        return newDsgn;
    }

    public void setNewDsgnDesc(String newDsgnDesc) {
        this.newDsgnDesc = newDsgnDesc;
    }

    public String getNewDsgnDesc() {
        return newDsgnDesc;
    }

    public void setNewBasic(String newBasic) {
        this.newBasic = newBasic;
    }

    public String getNewBasic() {
        return newBasic;
    }

    public void setNewCateg(String newCateg) {
        this.newCateg = newCateg;
    }

    public String getNewCateg() {
        return newCateg;
    }

    public void setNewCategDesc(String newCategDesc) {
        this.newCategDesc = newCategDesc;
    }

    public String getNewCategDesc() {
        return newCategDesc;
    }

    public void setPayScaleCode(String payScaleCode) {
        this.payScaleCode = payScaleCode;
    }

    public String getPayScaleCode() {
        return payScaleCode;
    }

    public void setPayScaleCodeDesc(String payScaleCodeDesc) {
        this.payScaleCodeDesc = payScaleCodeDesc;
    }

    public String getPayScaleCodeDesc() {
        return payScaleCodeDesc;
    }

    public void setHdnStartBasic(String hdnStartBasic) {
        this.hdnStartBasic = hdnStartBasic;
    }

    public String getHdnStartBasic() {
        return hdnStartBasic;
    }

    public void setHdnEndBasic(String hdnEndBasic) {
        this.hdnEndBasic = hdnEndBasic;
    }

    public String getHdnEndBasic() {
        return hdnEndBasic;
    }

    public void setNewPerPayHighQual(String newPerPayHighQual) {
        this.newPerPayHighQual = newPerPayHighQual;
    }

    public String getNewPerPayHighQual() {
        return newPerPayHighQual;
    }

    public void setNewPerPayFutIncr(String newPerPayFutIncr) {
        this.newPerPayFutIncr = newPerPayFutIncr;
    }

    public String getNewPerPayFutIncr() {
        return newPerPayFutIncr;
    }

    public void setNewStagInc(String newStagInc) {
        this.newStagInc = newStagInc;
    }

    public String getNewStagInc() {
        return newStagInc;
    }

    public void setNewPromEffDate(String newPromEffDate) {
        this.newPromEffDate = newPromEffDate;
    }

    public String getNewPromEffDate() {
        return newPromEffDate;
    }

    public void setAdhcPromEndDate(String adhcPromEndDate) {
        this.adhcPromEndDate = adhcPromEndDate;
    }

    public String getAdhcPromEndDate() {
        return adhcPromEndDate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setGradePay(String gradePay) {
        this.gradePay = gradePay;
    }

    public String getGradePay() {
        return gradePay;
    }

    public void setPayBand(String payBand) {
        this.payBand = payBand;
    }

    public String getPayBand() {
        return payBand;
    }

    public void setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getCancelStatus() {
        return cancelStatus;
    }

    public void setTxtFixationFlag(String txtFixationFlag) {
        this.txtFixationFlag = txtFixationFlag;
    }

    public String getTxtFixationFlag() {
        return txtFixationFlag;
    }

    public void setNewGradePay(String newGradePay) {
        this.newGradePay = newGradePay;
    }

    public String getNewGradePay() {
        return newGradePay;
    }

    public void setNewBasic1(String newBasic1) {
        this.newBasic1 = newBasic1;
    }

    public String getNewBasic1() {
        return newBasic1;
    }

    public void setNewPromEffDate1(String newPromEffDate1) {
        this.newPromEffDate1 = newPromEffDate1;
    }

    public String getNewPromEffDate1() {
        return newPromEffDate1;
    }
}


