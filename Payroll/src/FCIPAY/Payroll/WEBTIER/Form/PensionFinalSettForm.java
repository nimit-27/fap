package FCIPAY.Payroll.WEBTIER.Form;

import java.util.ArrayList;

public class PensionFinalSettForm extends PayrollBaseForm{

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
    private String txtappscancel;
    private String txtPensionId;
    private String txtDOB;  
    private String txtRetirementDt;

    private String txtAnnuityProv;
    private String txtAnnuSubDt;
    private String txtVPFCont;
    private String txtPensionType;
    private String txtTotalInt;
    private String txtAnnuityStartDt;
    private String txtAnnuityNum;
    private String txtActualSettPrinc;
    private String txtSettlAmount;
    private String txtPurchagePric;
    private String txtFM;
    private String txtAnnuityFreq;
    private String txtAnnuityAmount;
    private String txtDateOfExit;
    private String hdnBoardFlag;
        
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
    private String saveAnnuityFlag;
    private String finAnnuityFlag;
    private String saveAnnu;
    private String cancelSanc;
    
//    private String intrstEmpContri;
//    private String intrstEmplyrContri;
//    private String intrstVpfContri;
//    private String intrstIntrvngPrd;
//    private String partFinalWid;  
//    private String cpfAdvIntRcvry;
//    private String tdsIntIntrvngPrd;
//    private String netAmntPayble;  
//    private String withdrEmpContri;
//    private String withdrEmplyrContri;
//    private String withdrVpfContri;
//    
//    
//    private String installAmt;
//    private String noInstallAmt;
//    private String firstInstall;
//    private String recoveryYYMM;
//    private String noIntInstall;
//    private String intInstall;
//    private String hdnRecYYMM;
//    
//    private String txtDedIT;
//
//    
//    private String [] txtEmpNoDtl;  
//    private String [] txtEmpNameDtl;   
//    private String [] sancOrderNoDtl;  
//    private String [] sancDateDtl;
//    private String [] sancAmountDtl; 
//    private String [] dedITDtl;
//    private String [] flgDedITDtl;
//    private String [] txtRecYYYYMM;
//    private String [] txtsancReason;
//    private String [] txtEmployeeCntr;
//    private String [] txtEmployerCntr;
//    private String [] txtInvoiceNo;
    private ArrayList lstInstrDtls=new ArrayList();
    
    private String txtYr;
    private String txtEmpLbrFlag;
    private String txtSysSantionNum;

    public PensionFinalSettForm() {
    
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

    public void setTxtCateg(String txtCateg) {
        this.txtCateg = txtCateg;
    }

    public String getTxtCateg() {
        return txtCateg;
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

    public void setTxtStaffCode(String txtStaffCode) {
        this.txtStaffCode = txtStaffCode;
    }

    public String getTxtStaffCode() {
        return txtStaffCode;
    }

    public void setTxtPresentPOP(String txtPresentPOP) {
        this.txtPresentPOP = txtPresentPOP;
    }

    public String getTxtPresentPOP() {
        return txtPresentPOP;
    }

    public void setTxtEmpStatus(String txtEmpStatus) {
        this.txtEmpStatus = txtEmpStatus;
    }

    public String getTxtEmpStatus() {
        return txtEmpStatus;
    }

    public void setHdnAction(String hdnAction) {
        this.hdnAction = hdnAction;
    }

    public String getHdnAction() {
        return hdnAction;
    }

    public void setTxtappscancel(String txtappscancel) {
        this.txtappscancel = txtappscancel;
    }

    public String getTxtappscancel() {
        return txtappscancel;
    }

    public void setEmpContri(String empContri) {
        this.empContri = empContri;
    }

    public String getEmpContri() {
        return empContri;
    }

    public void setEmplyrContri(String emplyrContri) {
        this.emplyrContri = emplyrContri;
    }

    public String getEmplyrContri() {
        return emplyrContri;
    }

    public void setVpfContri(String vpfContri) {
        this.vpfContri = vpfContri;
    }

    public String getVpfContri() {
        return vpfContri;
    }

    public void setSancOrderNo(String sancOrderNo) {
        this.sancOrderNo = sancOrderNo;
    }

    public String getSancOrderNo() {
        return sancOrderNo;
    }

    public void setSancDate(String sancDate) {
        this.sancDate = sancDate;
    }

    public String getSancDate() {
        return sancDate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setHdnSancType(String hdnSancType) {
        this.hdnSancType = hdnSancType;
    }

    public String getHdnSancType() {
        return hdnSancType;
    }

    public void setSancAmount(String sancAmount) {
        this.sancAmount = sancAmount;
    }

    public String getSancAmount() {
        return sancAmount;
    }

    public void setTxtInvID(String txtInvID) {
        this.txtInvID = txtInvID;
    }

    public String getTxtInvID() {
        return txtInvID;
    }

    public void setTxtReason(String txtReason) {
        this.txtReason = txtReason;
    }

    public String getTxtReason() {
        return txtReason;
    }

    public void setTxtApplAmt(String txtApplAmt) {
        this.txtApplAmt = txtApplAmt;
    }

    public String getTxtApplAmt() {
        return txtApplAmt;
    }

    public void setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getCancelStatus() {
        return cancelStatus;
    }

    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setTxtYr(String txtYr) {
        this.txtYr = txtYr;
    }

    public String getTxtYr() {
        return txtYr;
    }

    public void setTxtEmpLbrFlag(String txtEmpLbrFlag) {
        this.txtEmpLbrFlag = txtEmpLbrFlag;
    }

    public String getTxtEmpLbrFlag() {
        return txtEmpLbrFlag;
    }

    public void setTxtSysSantionNum(String txtSysSantionNum) {
        this.txtSysSantionNum = txtSysSantionNum;
    }

    public String getTxtSysSantionNum() {
        return txtSysSantionNum;
    }

    public void setTxtPensionId(String txtPensionId) {
        this.txtPensionId = txtPensionId;
    }

    public String getTxtPensionId() {
        return txtPensionId;
    }

    public void setTxtDOB(String txtDOB) {
        this.txtDOB = txtDOB;
    }

    public String getTxtDOB() {
        return txtDOB;
    }

    public void setTxtAnnuityProv(String txtAnnuityProv) {
        this.txtAnnuityProv = txtAnnuityProv;
    }

    public String getTxtAnnuityProv() {
        return txtAnnuityProv;
    }

    public void setTxtAnnuSubDt(String txtAnnuSubDt) {
        this.txtAnnuSubDt = txtAnnuSubDt;
    }

    public String getTxtAnnuSubDt() {
        return txtAnnuSubDt;
    }

    public void setTxtVPFCont(String txtVPFCont) {
        this.txtVPFCont = txtVPFCont;
    }

    public String getTxtVPFCont() {
        return txtVPFCont;
    }

    public void setTxtPensionType(String txtPensionType) {
        this.txtPensionType = txtPensionType;
    }

    public String getTxtPensionType() {
        return txtPensionType;
    }

    public void setTxtTotalInt(String txtTotalInt) {
        this.txtTotalInt = txtTotalInt;
    }

    public String getTxtTotalInt() {
        return txtTotalInt;
    }

    public void setTxtAnnuityStartDt(String txtAnnuityStartDt) {
        this.txtAnnuityStartDt = txtAnnuityStartDt;
    }

    public String getTxtAnnuityStartDt() {
        return txtAnnuityStartDt;
    }

    public void setTxtAnnuityNum(String txtAnnuityNum) {
        this.txtAnnuityNum = txtAnnuityNum;
    }

    public String getTxtAnnuityNum() {
        return txtAnnuityNum;
    }

    public void setTxtActualSettPrinc(String txtActualSettPrinc) {
        this.txtActualSettPrinc = txtActualSettPrinc;
    }

    public String getTxtActualSettPrinc() {
        return txtActualSettPrinc;
    }

    public void setTxtSettlAmount(String txtSettlAmount) {
        this.txtSettlAmount = txtSettlAmount;
    }

    public String getTxtSettlAmount() {
        return txtSettlAmount;
    }

    public void setTxtPurchagePric(String txtPurchagePric) {
        this.txtPurchagePric = txtPurchagePric;
    }

    public String getTxtPurchagePric() {
        return txtPurchagePric;
    }

    public void setTxtAnnuityFreq(String txtAnnuityFreq) {
        this.txtAnnuityFreq = txtAnnuityFreq;
    }

    public String getTxtAnnuityFreq() {
        return txtAnnuityFreq;
    }

    public void setTxtAnnuityAmount(String txtAnnuityAmount) {
        this.txtAnnuityAmount = txtAnnuityAmount;
    }

    public String getTxtAnnuityAmount() {
        return txtAnnuityAmount;
    }

    public void setTxtDateOfExit(String txtDateOfExit) {
        this.txtDateOfExit = txtDateOfExit;
    }

    public String getTxtDateOfExit() {
        return txtDateOfExit;
    }

    public void setTxtFM(String txtFM) {
        this.txtFM = txtFM;
    }

    public String getTxtFM() {
        return txtFM;
    }

    public void setHdnBoardFlag(String hdnBoardFlag) {
        this.hdnBoardFlag = hdnBoardFlag;
    }

    public String getHdnBoardFlag() {
        return hdnBoardFlag;
    }

    public void setSaveAnnuityFlag(String saveAnnuityFlag) {
        this.saveAnnuityFlag = saveAnnuityFlag;
    }

    public String getSaveAnnuityFlag() {
        return saveAnnuityFlag;
    }

    public void setFinAnnuityFlag(String finAnnuityFlag) {
        this.finAnnuityFlag = finAnnuityFlag;
    }

    public String getFinAnnuityFlag() {
        return finAnnuityFlag;
    }

    public void setSaveAnnu(String saveAnnu) {
        this.saveAnnu = saveAnnu;
    }

    public String getSaveAnnu() {
        return saveAnnu;
    }

    public void setCancelSanc(String cancelSanc) {
        this.cancelSanc = cancelSanc;
    }

    public String getCancelSanc() {
        return cancelSanc;
    }

    public void setTxtRetirementDt(String txtRetirementDt) {
        this.txtRetirementDt = txtRetirementDt;
    }

    public String getTxtRetirementDt() {
        return txtRetirementDt;
    }
}
