package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;

import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import java.io.Serializable;

public class NWNPLbrHndlngAttndDetailInfo  extends BaseDetailInfo implements Serializable{
    private String txtYYMM;
    private String lstLabourType;
    private String txtGangId;
    private String txtGangName;
    private String txtDAType; 
    private String screenModeFlag;
    private String txtLocId;
    private String yrMonth;

    public NWNPLbrHndlngAttndDetailInfo(){
    }

    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
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

    public void setTxtDAType(String txtDAType) {
        this.txtDAType = txtDAType;
    }

    public String getTxtDAType() {
        return txtDAType;
    }

    public void setScreenModeFlag(String screenModeFlag) {
        this.screenModeFlag = screenModeFlag;
    }

    public String getScreenModeFlag() {
        return screenModeFlag;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setYrMonth(String yrMonth) {
        this.yrMonth = yrMonth;
    }

    public String getYrMonth() {
        return yrMonth;
    }
}
