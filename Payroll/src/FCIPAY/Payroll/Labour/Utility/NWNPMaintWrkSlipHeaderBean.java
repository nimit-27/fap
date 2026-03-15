package FCIPAY.Payroll.Labour.Utility;

import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class NWNPMaintWrkSlipHeaderBean  extends PayrollBaseHeaderBean{
    private String hdnWrkSlipId;
    private String txtSiteId;
    private String txtSiteName;
    private String txtSite;        // added by dushyant on 10-03-2011
    private String hdnGangId;
    private String txtGangName;
    private String txtLocation; 
    private String txtLocId;     
    private String txtWrkSlipDt;
    private String hdnMou;
    private String txtYYMM;


    public NWNPMaintWrkSlipHeaderBean(){
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

    public void setTxtSite(String txtSite) {
        this.txtSite = txtSite;
    }

    public String getTxtSite() {
        return txtSite;
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
}
