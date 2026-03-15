package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class BasicHistoryEventHeaderBean extends PayrollBaseHeaderBean implements Serializable {
    
    private String txtEmpId;
    private String txtEmpName;
    private String txtSiteName;
    
    public BasicHistoryEventHeaderBean() {
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

    public void setTxtSiteName(String txtSiteName) {
        this.txtSiteName = txtSiteName;
    }

    public String getTxtSiteName() {
        return txtSiteName;
    }
}
