package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class PensionFinalSettBean  extends PayrollBaseHeaderBean implements Serializable {
   
    private String txtEmpNo;  
    private String txtEmpName;  
    private String txtDsgn;    
    private String txtCateg; 
    private String txtEmpType;
    private String txtCpfCode; 
    private String txtStaffCode; 
    private String txtPresentPOP;  
    private String txtEmpStatus;
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
    
    
    private String empContri;
    private String emplyrContri;
    private String vpfContri;
    private String sancOrderNo;  
    private String sancDate;  
    private String remarks; 
    private String hdnSancType;
    private String sancAmount;
    private String txtInvID;  
    private String hdnAction;
    private String txtReason;
    private String txtApplAmt;
    private String cancelStatus;
    private String saveAnnuityFlag;
    private String finAnnuityFlag;
    
    private String txtappscancel;

    private String txtDedIT;  

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

    private String installAmt;
    private String noInstallAmt;
    private String firstInstall; 
    private String recoveryYYMM;
    private String noIntInstall;
    private String intInstall;

    private String txtEmpLbrFlag;
    private String txtYr;
    
    private String txtRecYYYYMM;
    private String hdnRecYYMM;
    private String txtSysSantionNum;
   
    public PensionFinalSettBean() {
    
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

    public void setHdnAction(String hdnAction) {
        this.hdnAction = hdnAction;
    }

    public String getHdnAction() {
        return hdnAction;
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

    public void setTxtappscancel(String txtappscancel) {
        this.txtappscancel = txtappscancel;
    }

    public String getTxtappscancel() {
        return txtappscancel;
    }

    public void setTxtDedIT(String txtDedIT) {
        this.txtDedIT = txtDedIT;
    }

    public String getTxtDedIT() {
        return txtDedIT;
    }

    public void setIntrstEmpContri(String intrstEmpContri) {
        this.intrstEmpContri = intrstEmpContri;
    }

    public String getIntrstEmpContri() {
        return intrstEmpContri;
    }

    public void setIntrstEmplyrContri(String intrstEmplyrContri) {
        this.intrstEmplyrContri = intrstEmplyrContri;
    }

    public String getIntrstEmplyrContri() {
        return intrstEmplyrContri;
    }

    public void setIntrstVpfContri(String intrstVpfContri) {
        this.intrstVpfContri = intrstVpfContri;
    }

    public String getIntrstVpfContri() {
        return intrstVpfContri;
    }

    public void setIntrstIntrvngPrd(String intrstIntrvngPrd) {
        this.intrstIntrvngPrd = intrstIntrvngPrd;
    }

    public String getIntrstIntrvngPrd() {
        return intrstIntrvngPrd;
    }

    public void setPartFinalWid(String partFinalWid) {
        this.partFinalWid = partFinalWid;
    }

    public String getPartFinalWid() {
        return partFinalWid;
    }

    public void setCpfAdvIntRcvry(String cpfAdvIntRcvry) {
        this.cpfAdvIntRcvry = cpfAdvIntRcvry;
    }

    public String getCpfAdvIntRcvry() {
        return cpfAdvIntRcvry;
    }

    public void setTdsIntIntrvngPrd(String tdsIntIntrvngPrd) {
        this.tdsIntIntrvngPrd = tdsIntIntrvngPrd;
    }

    public String getTdsIntIntrvngPrd() {
        return tdsIntIntrvngPrd;
    }

    public void setNetAmntPayble(String netAmntPayble) {
        this.netAmntPayble = netAmntPayble;
    }

    public String getNetAmntPayble() {
        return netAmntPayble;
    }

    public void setWithdrEmpContri(String withdrEmpContri) {
        this.withdrEmpContri = withdrEmpContri;
    }

    public String getWithdrEmpContri() {
        return withdrEmpContri;
    }

    public void setWithdrEmplyrContri(String withdrEmplyrContri) {
        this.withdrEmplyrContri = withdrEmplyrContri;
    }

    public String getWithdrEmplyrContri() {
        return withdrEmplyrContri;
    }

    public void setWithdrVpfContri(String withdrVpfContri) {
        this.withdrVpfContri = withdrVpfContri;
    }

    public String getWithdrVpfContri() {
        return withdrVpfContri;
    }

    public void setInstallAmt(String installAmt) {
        this.installAmt = installAmt;
    }

    public String getInstallAmt() {
        return installAmt;
    }

    public void setNoInstallAmt(String noInstallAmt) {
        this.noInstallAmt = noInstallAmt;
    }

    public String getNoInstallAmt() {
        return noInstallAmt;
    }

    public void setFirstInstall(String firstInstall) {
        this.firstInstall = firstInstall;
    }

    public String getFirstInstall() {
        return firstInstall;
    }

    public void setRecoveryYYMM(String recoveryYYMM) {
        this.recoveryYYMM = recoveryYYMM;
    }

    public String getRecoveryYYMM() {
        return recoveryYYMM;
    }

    public void setNoIntInstall(String noIntInstall) {
        this.noIntInstall = noIntInstall;
    }

    public String getNoIntInstall() {
        return noIntInstall;
    }

    public void setIntInstall(String intInstall) {
        this.intInstall = intInstall;
    }

    public String getIntInstall() {
        return intInstall;
    }

    public void setTxtEmpLbrFlag(String txtEmpLbrFlag) {
        this.txtEmpLbrFlag = txtEmpLbrFlag;
    }

    public String getTxtEmpLbrFlag() {
        return txtEmpLbrFlag;
    }

    public void setTxtYr(String txtYr) {
        this.txtYr = txtYr;
    }

    public String getTxtYr() {
        return txtYr;
    }

    public void setTxtRecYYYYMM(String txtRecYYYYMM) {
        this.txtRecYYYYMM = txtRecYYYYMM;
    }

    public String getTxtRecYYYYMM() {
        return txtRecYYYYMM;
    }

    public void setHdnRecYYMM(String hdnRecYYMM) {
        this.hdnRecYYMM = hdnRecYYMM;
    }

    public String getHdnRecYYMM() {
        return hdnRecYYMM;
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

    public void setTxtRetirementDt(String txtRetirementDt) {
        this.txtRetirementDt = txtRetirementDt;
    }

    public String getTxtRetirementDt() {
        return txtRetirementDt;
    }
}
