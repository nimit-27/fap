package FCIPAY.Payroll.Labour.WEBTIER.Form;

import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

import java.util.ArrayList;

public class NWNPAreaClassiFicationMappingForm extends PayrollBaseForm  {
    
    private ArrayList lstInstrDtls=new ArrayList();
    private String txtLocLov;
    private String txtLocidSrch, txtLocSrch;
    private String txtROLocidSrch, txtROLocSrch;
    private String txtDOLocidSrch, txtDOLocSrch;
    private String txtDPLocidSrch, txtDPLocSrch;
    
    
    private String imgTxtTo;
    private String addBtnFlag="";
    private String exeBtnFlag="";
    
    private String [] txtLoc;
    private String [] txtLocId;
    private String [] txtCityTyp;
    private String [] txtAreaTyp;
    private String [] txtTranCityTyp;
    private String [] txtMgwCityTyp;
    private String [] txtPopTyp;
    private String [] txtFrom;
    private String [] txtTo;
    
    private String [] txtCityTypId;
//    private String depotName;
//    private String areaTypeCat;
//    private String effStartDate;


//    public void setDepotName(String depotName) {
//        this.depotName = depotName;
//    }
//
//    public String getDepotName() {
//        return depotName;
//    }
//
//    public void setAreaTypeCat(String areaTypeCat) {
//        this.areaTypeCat = areaTypeCat;
//    }
//
//    public String getAreaTypeCat() {
//        return areaTypeCat;
//    }
//
//    public void setEffStartDate(String effStartDate) {
//        this.effStartDate = effStartDate;
//    }
//
//    public String getEffStartDate() {
//        return effStartDate;
//    }

    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setTxtLocLov(String txtLocLov) {
        this.txtLocLov = txtLocLov;
    }

    public String getTxtLocLov() {
        return txtLocLov;
    }

    public void setTxtLocidSrch(String txtLocidSrch) {
        this.txtLocidSrch = txtLocidSrch;
    }

    public String getTxtLocidSrch() {
        return txtLocidSrch;
    }

    public void setTxtLocSrch(String txtLocSrch) {
        this.txtLocSrch = txtLocSrch;
    }

    public String getTxtLocSrch() {
        return txtLocSrch;
    }

    public void setImgTxtTo(String imgTxtTo) {
        this.imgTxtTo = imgTxtTo;
    }

    public String getImgTxtTo() {
        return imgTxtTo;
    }

    public void setAddBtnFlag(String addBtnFlag) {
        this.addBtnFlag = addBtnFlag;
    }

    public String getAddBtnFlag() {
        return addBtnFlag;
    }

    public void setExeBtnFlag(String exeBtnFlag) {
        this.exeBtnFlag = exeBtnFlag;
    }

    public String getExeBtnFlag() {
        return exeBtnFlag;
    }

    public void setTxtLoc(String[] txtLoc) {
        this.txtLoc = txtLoc;
    }

    public String[] getTxtLoc() {
        return txtLoc;
    }

    public void setTxtLocId(String[] txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String[] getTxtLocId() {
        return txtLocId;
    }

    public void setTxtCityTyp(String[] txtCityTyp) {
        this.txtCityTyp = txtCityTyp;
    }

    public String[] getTxtCityTyp() {
        return txtCityTyp;
    }

    public void setTxtAreaTyp(String[] txtAreaTyp) {
        this.txtAreaTyp = txtAreaTyp;
    }

    public String[] getTxtAreaTyp() {
        return txtAreaTyp;
    }

    public void setTxtTranCityTyp(String[] txtTranCityTyp) {
        this.txtTranCityTyp = txtTranCityTyp;
    }

    public String[] getTxtTranCityTyp() {
        return txtTranCityTyp;
    }

    public void setTxtMgwCityTyp(String[] txtMgwCityTyp) {
        this.txtMgwCityTyp = txtMgwCityTyp;
    }

    public String[] getTxtMgwCityTyp() {
        return txtMgwCityTyp;
    }

    public void setTxtPopTyp(String[] txtPopTyp) {
        this.txtPopTyp = txtPopTyp;
    }

    public String[] getTxtPopTyp() {
        return txtPopTyp;
    }

    public void setTxtFrom(String[] txtFrom) {
        this.txtFrom = txtFrom;
    }

    public String[] getTxtFrom() {
        return txtFrom;
    }

    public void setTxtTo(String[] txtTo) {
        this.txtTo = txtTo;
    }

    public String[] getTxtTo() {
        return txtTo;
    }

    public void setTxtDOLocidSrch(String txtDOLocidSrch) {
        this.txtDOLocidSrch = txtDOLocidSrch;
    }

    public String getTxtDOLocidSrch() {
        return txtDOLocidSrch;
    }

    public void setTxtDOLocSrch(String txtDOLocSrch) {
        this.txtDOLocSrch = txtDOLocSrch;
    }

    public String getTxtDOLocSrch() {
        return txtDOLocSrch;
    }

    public void setTxtDPLocidSrch(String txtDPLocidSrch) {
        this.txtDPLocidSrch = txtDPLocidSrch;
    }

    public String getTxtDPLocidSrch() {
        return txtDPLocidSrch;
    }

    public void setTxtDPLocSrch(String txtDPLocSrch) {
        this.txtDPLocSrch = txtDPLocSrch;
    }

    public String getTxtDPLocSrch() {
        return txtDPLocSrch;
    }

    public void setTxtROLocidSrch(String txtROLocidSrch) {
        this.txtROLocidSrch = txtROLocidSrch;
    }

    public String getTxtROLocidSrch() {
        return txtROLocidSrch;
    }

    public void setTxtROLocSrch(String txtROLocSrch) {
        this.txtROLocSrch = txtROLocSrch;
    }

    public String getTxtROLocSrch() {
        return txtROLocSrch;
    }


    public void setTxtCityTypId(String[] txtCityTypId) {
        this.txtCityTypId = txtCityTypId;
    }

    public String[] getTxtCityTypId() {
        return txtCityTypId;
    }
}
