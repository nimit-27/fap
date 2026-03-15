package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

import java.io.Serializable;

public class NWNPMaintWrkSlipQueryVO  extends PayrollBaseQueryVO implements Serializable {
       
    private String hdnWrkSlipId;
    private String txtSiteId;
    private String txtSiteName;
    private String hdnGangId;
    private String txtGangName;
    private String txtWrkSlipDt;
    private String txtYYMM;


    public NWNPMaintWrkSlipQueryVO() {
      
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

    public void setTxtWrkSlipDt(String txtWrkSlipDt) {
        this.txtWrkSlipDt = txtWrkSlipDt;
    }

    public String getTxtWrkSlipDt() {
        return txtWrkSlipDt;
    }

    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
    }
}
