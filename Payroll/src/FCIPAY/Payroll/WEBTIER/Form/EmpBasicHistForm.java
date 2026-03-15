package FCIPAY.Payroll.WEBTIER.Form;

import java.util.ArrayList;

public class EmpBasicHistForm extends PayrollBaseForm
{
    private ArrayList lstInstrDtls=new ArrayList();
    private String txtEmpNo;
    private String txtYYMMFrom;
    private String txtYYMMTo;
    private String txtCategory;
    private String txtPayScale;
    private String txtEmpName;
    private String txtCpfCode;
    private String txtSiteCode;
    private String txtSiteDesc;
    private String txtUserFlag;
    private String hdnAction;
    private String txtDesig;
    private String txtDob;
    private String txtPayRev;
    private String txtStaffCode;  
    
    private String [] txtStartDt;
    private String [] txtEndDt;
    private String [] txtBasic;
    private String [] txtOldPayscale;
    private String [] txtGradePay;
    private String [] txtEvent;


    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtYYMMFrom(String txtYYMMFrom) {
        this.txtYYMMFrom = txtYYMMFrom;
    }

    public String getTxtYYMMFrom() {
        return txtYYMMFrom;
    }

    public void setTxtYYMMTo(String txtYYMMTo) {
        this.txtYYMMTo = txtYYMMTo;
    }

    public String getTxtYYMMTo() {
        return txtYYMMTo;
    }

    public void setTxtCategory(String txtCategory) {
        this.txtCategory = txtCategory;
    }

    public String getTxtCategory() {
        return txtCategory;
    }

    public void setTxtPayScale(String txtPayScale) {
        this.txtPayScale = txtPayScale;
    }

    public String getTxtPayScale() {
        return txtPayScale;
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

    public void setTxtSiteCode(String txtSiteCode) {
        this.txtSiteCode = txtSiteCode;
    }

    public String getTxtSiteCode() {
        return txtSiteCode;
    }

    public void setTxtSiteDesc(String txtSiteDesc) {
        this.txtSiteDesc = txtSiteDesc;
    }

    public String getTxtSiteDesc() {
        return txtSiteDesc;
    }

    public void setTxtUserFlag(String txtUserFlag) {
        this.txtUserFlag = txtUserFlag;
    }

    public String getTxtUserFlag() {
        return txtUserFlag;
    }

    public void setHdnAction(String hdnAction) {
        this.hdnAction = hdnAction;
    }

    public String getHdnAction() {
        return hdnAction;
    }

    public void setTxtDesig(String txtDesig) {
        this.txtDesig = txtDesig;
    }

    public String getTxtDesig() {
        return txtDesig;
    }

    public void setTxtDob(String txtDob) {
        this.txtDob = txtDob;
    }

    public String getTxtDob() {
        return txtDob;
    }

    public void setTxtPayRev(String txtPayRev) {
        this.txtPayRev = txtPayRev;
    }

    public String getTxtPayRev() {
        return txtPayRev;
    }

    public void setTxtStaffCode(String txtStaffCode) {
        this.txtStaffCode = txtStaffCode;
    }

    public String getTxtStaffCode() {
        return txtStaffCode;
    }

    public void setTxtStartDt(String[] txtStartDt) {
        this.txtStartDt = txtStartDt;
    }

    public String[] getTxtStartDt() {
        return txtStartDt;
    }

    public void setTxtEndDt(String[] txtEndDt) {
        this.txtEndDt = txtEndDt;
    }

    public String[] getTxtEndDt() {
        return txtEndDt;
    }

    public void setTxtBasic(String[] txtBasic) {
        this.txtBasic = txtBasic;
    }

    public String[] getTxtBasic() {
        return txtBasic;
    }

    public void setTxtOldPayscale(String[] txtOldPayscale) {
        this.txtOldPayscale = txtOldPayscale;
    }

    public String[] getTxtOldPayscale() {
        return txtOldPayscale;
    }

    public void setTxtGradePay(String[] txtGradePay) {
        this.txtGradePay = txtGradePay;
    }

    public String[] getTxtGradePay() {
        return txtGradePay;
    }

    public void setTxtEvent(String[] txtEvent) {
        this.txtEvent = txtEvent;
    }

    public String[] getTxtEvent() {
        return txtEvent;
    }
}
