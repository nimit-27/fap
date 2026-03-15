package FCIPAY.Payroll.DATAACCESSTIER.VO;

import java.io.Serializable;

public class BasicHistoryEventQueryVO extends PayrollBaseQueryVO implements Serializable  {
    
    private String txtSiteId;
    private String txtSiteName;
    private String hdnEmpLbrFlag;
    private String txtEmpId;
    private String txtEmpName;
    
    public BasicHistoryEventQueryVO() {

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

    public void setHdnEmpLbrFlag(String hdnEmpLbrFlag) {
        this.hdnEmpLbrFlag = hdnEmpLbrFlag;
    }

    public String getHdnEmpLbrFlag() {
        return hdnEmpLbrFlag;
    }

    public void setTxtEmpId(String txtEmpId) {
        this.txtEmpId = txtEmpId;
    }

    public String getTxtEmpId() {
        return txtEmpId;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
    }
}
