package FCIPAY.Payroll.DATAACCESSTIER.VO;

import java.io.Serializable;

public class PensionFinalSettQueryVO  extends PayrollBaseQueryVO implements Serializable{
    
    private String txtEmpNo;
    private String screenName;
    private String hdnSancType;
    private String sancDate;
    private String txtReason;
    private String sancAmount;
    private String vpfContri;
    private String empContri;
    private String emplyrContri;
    private String noInstallAmt;
    private String txtSysSantionNum;
    private String txtInvID;
    private String SancOrderNo;
    private String loginEmployeeNo;
    private String txtPensionId;
    private String txtDOB;
    private String txtEmpName;
    private String txtCpfCode;
    private String txtAnnuSubDt;
    private String txtRetirementDt;
    
    public PensionFinalSettQueryVO() {
        
    }


    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setHdnSancType(String hdnSancType) {
        this.hdnSancType = hdnSancType;
    }

    public String getHdnSancType() {
        return hdnSancType;
    }

    public void setSancDate(String sancDate) {
        this.sancDate = sancDate;
    }

    public String getSancDate() {
        return sancDate;
    }

    public void setTxtReason(String txtReason) {
        this.txtReason = txtReason;
    }

    public String getTxtReason() {
        return txtReason;
    }

    public void setSancAmount(String sancAmount) {
        this.sancAmount = sancAmount;
    }

    public String getSancAmount() {
        return sancAmount;
    }

    public void setVpfContri(String vpfContri) {
        this.vpfContri = vpfContri;
    }

    public String getVpfContri() {
        return vpfContri;
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

    public void setNoInstallAmt(String noInstallAmt) {
        this.noInstallAmt = noInstallAmt;
    }

    public String getNoInstallAmt() {
        return noInstallAmt;
    }

    public void setTxtSysSantionNum(String txtSysSantionNum) {
        this.txtSysSantionNum = txtSysSantionNum;
    }

    public String getTxtSysSantionNum() {
        return txtSysSantionNum;
    }

    public void setTxtInvID(String txtInvID) {
        this.txtInvID = txtInvID;
    }

    public String getTxtInvID() {
        return txtInvID;
    }

    public void setSancOrderNo(String SancOrderNo) {
        this.SancOrderNo = SancOrderNo;
    }

    public String getSancOrderNo() {
        return SancOrderNo;
    }

    public void setLoginEmployeeNo(String loginEmployeeNo) {
        this.loginEmployeeNo = loginEmployeeNo;
    }

    public String getLoginEmployeeNo() {
        return loginEmployeeNo;
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

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtCpfCode(String txtCpfCode) {
        this.txtCpfCode = txtCpfCode;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
    }

    public void setTxtAnnuSubDt(String txtAnnuSubDt) {
        this.txtAnnuSubDt = txtAnnuSubDt;
    }

    public String getTxtAnnuSubDt() {
        return txtAnnuSubDt;
    }

    public void setTxtRetirementDt(String txtRetirementDt) {
        this.txtRetirementDt = txtRetirementDt;
    }

    public String getTxtRetirementDt() {
        return txtRetirementDt;
    }
}
