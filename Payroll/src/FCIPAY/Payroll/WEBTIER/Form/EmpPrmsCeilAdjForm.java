package FCIPAY.Payroll.WEBTIER.Form;

import java.util.ArrayList;

public class EmpPrmsCeilAdjForm extends PayrollBaseForm 
{
    private ArrayList lstInstrDtls=new ArrayList();
    private String txtEmpNum;    
    private String txtEmpName;
    private String txtFinYear;
    private String txtCpfCode;
    private String txtEmpCat;
    private String txtEmpDsgn;
    private String txtSepDate;
    private String txtSepType;
    private String txtAdjType;
    private String txtPayMode;
    private String txtAdjAmt;
    private String txtRemarks;
    private String txtOpenBal;
    private String txtClaimAmt;
    private String txtAvailableBal;
    private String hdnITFlag;
	
    private String [] txtFinY; 
    private String [] txtOpeningBal;
    private String [] txtAdjustBal;
    private String [] txtAdjustMode;
    private String [] txtClaimAmout;
    private String [] txtCloseBal;
    private String [] txtAdjustDate;
    private String [] txtUserId;

    public void setTxtEmpNum(String txtEmpNum) {
        this.txtEmpNum = txtEmpNum;
    }

    public String getTxtEmpNum() {
        return txtEmpNum;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtFinYear(String txtFinYear) {
        this.txtFinYear = txtFinYear;
    }

    public String getTxtFinYear() {
        return txtFinYear;
    }

    public void setTxtCpfCode(String txtCpfCode) {
        this.txtCpfCode = txtCpfCode;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
    }

    public void setTxtEmpCat(String txtEmpCat) {
        this.txtEmpCat = txtEmpCat;
    }

    public String getTxtEmpCat() {
        return txtEmpCat;
    }

    public void setTxtEmpDsgn(String txtEmpDsgn) {
        this.txtEmpDsgn = txtEmpDsgn;
    }

    public String getTxtEmpDsgn() {
        return txtEmpDsgn;
    }

    public void setTxtSepDate(String txtSepDate) {
        this.txtSepDate = txtSepDate;
    }

    public String getTxtSepDate() {
        return txtSepDate;
    }

    public void setTxtSepType(String txtSepType) {
        this.txtSepType = txtSepType;
    }

    public String getTxtSepType() {
        return txtSepType;
    }

    public void setTxtAdjType(String txtAdjType) {
        this.txtAdjType = txtAdjType;
    }

    public String getTxtAdjType() {
        return txtAdjType;
    }

    public void setTxtPayMode(String txtPayMode) {
        this.txtPayMode = txtPayMode;
    }

    public String getTxtPayMode() {
        return txtPayMode;
    }

    public void setTxtAdjAmt(String txtAdjAmt) {
        this.txtAdjAmt = txtAdjAmt;
    }

    public String getTxtAdjAmt() {
        return txtAdjAmt;
    }

    public void setTxtRemarks(String txtRemarks) {
        this.txtRemarks = txtRemarks;
    }

    public String getTxtRemarks() {
        return txtRemarks;
    }

    public void setTxtOpenBal(String txtOpenBal) {
        this.txtOpenBal = txtOpenBal;
    }

    public String getTxtOpenBal() {
        return txtOpenBal;
    }

    public void setTxtClaimAmt(String txtClaimAmt) {
        this.txtClaimAmt = txtClaimAmt;
    }

    public String getTxtClaimAmt() {
        return txtClaimAmt;
    }

    public void setTxtAvailableBal(String txtAvailableBal) {
        this.txtAvailableBal = txtAvailableBal;
    }

    public String getTxtAvailableBal() {
        return txtAvailableBal;
    }

    public void setHdnITFlag(String hdnITFlag) {
        this.hdnITFlag = hdnITFlag;
    }

    public String getHdnITFlag() {
        return hdnITFlag;
    }

    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setTxtFinY(String[] txtFinY) {
        this.txtFinY = txtFinY;
    }

    public String[] getTxtFinY() {
        return txtFinY;
    }

    public void setTxtOpeningBal(String[] txtOpeningBal) {
        this.txtOpeningBal = txtOpeningBal;
    }

    public String[] getTxtOpeningBal() {
        return txtOpeningBal;
    }

    public void setTxtAdjustBal(String[] txtAdjustBal) {
        this.txtAdjustBal = txtAdjustBal;
    }

    public String[] getTxtAdjustBal() {
        return txtAdjustBal;
    }

    public void setTxtAdjustMode(String[] txtAdjustMode) {
        this.txtAdjustMode = txtAdjustMode;
    }

    public String[] getTxtAdjustMode() {
        return txtAdjustMode;
    }

    public void setTxtClaimAmout(String[] txtClaimAmout) {
        this.txtClaimAmout = txtClaimAmout;
    }

    public String[] getTxtClaimAmout() {
        return txtClaimAmout;
    }

    public void setTxtCloseBal(String[] txtCloseBal) {
        this.txtCloseBal = txtCloseBal;
    }

    public String[] getTxtCloseBal() {
        return txtCloseBal;
    }

    public void setTxtAdjustDate(String[] txtAdjustDate) {
        this.txtAdjustDate = txtAdjustDate;
    }

    public String[] getTxtAdjustDate() {
        return txtAdjustDate;
    }

    public void setTxtUserId(String[] txtUserId) {
        this.txtUserId = txtUserId;
    }

    public String[] getTxtUserId() {
        return txtUserId;
    }
}
