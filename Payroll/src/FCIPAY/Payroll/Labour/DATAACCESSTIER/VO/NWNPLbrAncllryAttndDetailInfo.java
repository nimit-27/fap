package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;

import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import java.io.Serializable;

public class NWNPLbrAncllryAttndDetailInfo  extends BaseDetailInfo implements Serializable{
    
    private String txtYYMM;
    private String txtGangId;
    private String txtGangName;
    private String txtDAType; 
    private String txtLocId;
    private String lstLabourType;
    private String screenModeFlag;
    
    public NWNPLbrAncllryAttndDetailInfo() {
        
    }

    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
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

    public void setTxtDAType(String txtDAType) {
        this.txtDAType = txtDAType;
    }

    public String getTxtDAType() {
        return txtDAType;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setLstLabourType(String lstLabourType) {
        this.lstLabourType = lstLabourType;
    }

    public String getLstLabourType() {
        return lstLabourType;
    }

    public void setScreenModeFlag(String screenModeFlag) {
        this.screenModeFlag = screenModeFlag;
    }

    public String getScreenModeFlag() {
        return screenModeFlag;
    }
}
