package FCIPAY.Payroll.Labour.Utility;

import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

import java.io.Serializable;

public class NWNPLbrAncllryAttndHeaderBean extends PayrollBaseHeaderBean implements Serializable {
    
    private String txtYYMM;
    private String txtDAType;
    private String headerMode;
    private String lstLabourType;
    private String txtGangId;
    private String txtGangName;
    private String txtLocation;  
    private String txtLocId;
    //private String screenMode;
    //private String screenModeFlag;
    
    public NWNPLbrAncllryAttndHeaderBean() {
       
    }

    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
    }

    public void setTxtDAType(String txtDAType) {
        this.txtDAType = txtDAType;
    }

    public String getTxtDAType() {
        return txtDAType;
    }

    public void setHeaderMode(String headerMode) {
        this.headerMode = headerMode;
    }

    public String getHeaderMode() {
        return headerMode;
    }

    public void setLstLabourType(String lstLabourType) {
        this.lstLabourType = lstLabourType;
    }

    public String getLstLabourType() {
        return lstLabourType;
    }

    public void setTxtGangId(String txtGangId) {
        this.txtGangId = txtGangId;
    }

    public String getTxtGangId() {
        return txtGangId;
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

   /* public void setScreenMode(String screenMode) {
        this.screenMode = screenMode;
    }

    public String getScreenMode() {
        return screenMode;
    }

    public void setScreenModeFlag(String screenModeFlag) {
        this.screenModeFlag = screenModeFlag;
    }

    public String getScreenModeFlag() {
        return screenModeFlag;
    }*/
}
