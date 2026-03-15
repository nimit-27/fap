package FCIPAY.Payroll.Labour.WEBTIER.Form;

import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

import java.util.ArrayList;

public class NWNPMaintWrkSlipForm  extends PayrollBaseForm{
    
    private ArrayList lstInstrDtls=new ArrayList();
    private String hdnWrkSlipId;
    private String txtSiteId;
    private String txtSiteName;
    private String hdnGangId;
    private String txtGangName;
    private String txtLocation; 
    private String txtLocId;
    private String txtSite;    // added by dushyant on 10-03-2011
    private String txtWrkSlipDt;
    private String hdnMou;
    private String txtYYMM;
    private String [] txtNormTyp;
    private String [] txtHndlngNorm;
    private String [] hdnHndlngNormId;
    private String [] txtBags;
    private String [] hdnWrkSlipDtlId;
    private String [] txtSlab;
    private String [] txtOTHrs;
    private String [] txtBagTyp;
    private String [] hdnSlabId;
    private String [] txtEmpList;
    private String [] txtEmpNameList;
    private String [] txtStartHrs;
    private String [] txtStartMin;
    private String [] txtEndHrs;
    private String [] txtEndMin;
    private String [] hdnHndlngNormUnit;
    private boolean [] chkContWork;
    private String [] hdnContWork;
    private String [] txtGoDownTyp;

    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setHdnWrkSlipId(String hdnWrkSlipId) {
        this.hdnWrkSlipId = hdnWrkSlipId;
    }

    public String getHdnWrkSlipId() {
        return hdnWrkSlipId;
    }

    public void setTxtSiteId(String txtSiteId) {
        this.txtSiteId = txtSiteId;
    }

    public String getTxtSiteId() {
        return txtSiteId;
    }

    public void setTxtSiteName(String txtSiteName) {
        this.txtSiteName = txtSiteName;
    }

    public String getTxtSiteName() {
        return txtSiteName;
    }

    public void setHdnGangId(String hdnGangId) {
        this.hdnGangId = hdnGangId;
    }

    public String getHdnGangId() {
        return hdnGangId;
    }
        
    public void setTxtGangName(String txtGangName) {
        this.txtGangName = txtGangName;
    }

    public String getTxtGangName() {
        return txtGangName;
    }

    public void setTxtLocation(String txtLocation) {
        this.txtLocation = txtLocation;
    }

    public String getTxtLocation() {
        return txtLocation;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }
    public void setTxtSite(String txtSite) {
        this.txtSite = txtSite;
    }

    public String getTxtSite() {
        return txtSite;
    }

    public void setTxtWrkSlipDt(String txtWrkSlipDt) {
        this.txtWrkSlipDt = txtWrkSlipDt;
    }

    public String getTxtWrkSlipDt() {
        return txtWrkSlipDt;
    }

    public void setHdnMou(String hdnMou) {
        this.hdnMou = hdnMou;
    }

    public String getHdnMou() {
        return hdnMou;
    }

    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
    }

    public void setTxtNormTyp(String[] txtNormTyp) {
        this.txtNormTyp = txtNormTyp;
    }

    public String[] getTxtNormTyp() {
        return txtNormTyp;
    }

    public void setTxtHndlngNorm(String[] txtHndlngNorm) {
        this.txtHndlngNorm = txtHndlngNorm;
    }

    public String[] getTxtHndlngNorm() {
        return txtHndlngNorm;
    }

    public void setHdnHndlngNormId(String[] hdnHndlngNormId) {
        this.hdnHndlngNormId = hdnHndlngNormId;
    }

    public String[] getHdnHndlngNormId() {
        return hdnHndlngNormId;
    }

    public void setTxtBags(String[] txtBags) {
        this.txtBags = txtBags;
    }

    public String[] getTxtBags() {
        return txtBags;
    }

    public void setHdnWrkSlipDtlId(String[] hdnWrkSlipDtlId) {
        this.hdnWrkSlipDtlId = hdnWrkSlipDtlId;
    }

    public String[] getHdnWrkSlipDtlId() {
        return hdnWrkSlipDtlId;
    }

    public void setTxtSlab(String[] txtSlab) {
        this.txtSlab = txtSlab;
    }

    public String[] getTxtSlab() {
        return txtSlab;
    }

    public void setTxtOTHrs(String[] txtOTHrs) {
        this.txtOTHrs = txtOTHrs;
    }

    public String[] getTxtOTHrs() {
        return txtOTHrs;
    }

    public void setTxtBagTyp(String[] txtBagTyp) {
        this.txtBagTyp = txtBagTyp;
    }

    public String[] getTxtBagTyp() {
        return txtBagTyp;
    }

    public void setHdnSlabId(String[] hdnSlabId) {
        this.hdnSlabId = hdnSlabId;
    }

    public String[] getHdnSlabId() {
        return hdnSlabId;
    }

    public void setTxtEmpList(String[] txtEmpList) {
        this.txtEmpList = txtEmpList;
    }

    public String[] getTxtEmpList() {
        return txtEmpList;
    }

    public void setTxtEmpNameList(String[] txtEmpNameList) {
        this.txtEmpNameList = txtEmpNameList;
    }

    public String[] getTxtEmpNameList() {
        return txtEmpNameList;
    }

    public void setTxtStartHrs(String[] txtStartHrs) {
        this.txtStartHrs = txtStartHrs;
    }

    public String[] getTxtStartHrs() {
        return txtStartHrs;
    }

    public void setTxtStartMin(String[] txtStartMin) {
        this.txtStartMin = txtStartMin;
    }

    public String[] getTxtStartMin() {
        return txtStartMin;
    }

    public void setTxtEndHrs(String[] txtEndHrs) {
        this.txtEndHrs = txtEndHrs;
    }

    public String[] getTxtEndHrs() {
        return txtEndHrs;
    }

    public void setTxtEndMin(String[] txtEndMin) {
        this.txtEndMin = txtEndMin;
    }

    public String[] getTxtEndMin() {
        return txtEndMin;
    }

    public void setHdnHndlngNormUnit(String[] hdnHndlngNormUnit) {
        this.hdnHndlngNormUnit = hdnHndlngNormUnit;
    }

    public String[] getHdnHndlngNormUnit() {
        return hdnHndlngNormUnit;
    }

    public void setChkContWork(boolean[] chkContWork) {
        this.chkContWork = chkContWork;
    }

    public boolean[] getChkContWork() {
        return chkContWork;
    }

    public void setHdnContWork(String[] hdnContWork) {
        this.hdnContWork = hdnContWork;
    }

    public String[] getHdnContWork() {
        return hdnContWork;
    }

    public void setTxtGoDownTyp(String[] txtGoDownTyp) {
        this.txtGoDownTyp = txtGoDownTyp;
    }

    public String[] getTxtGoDownTyp() {
        return txtGoDownTyp;
    }
}
