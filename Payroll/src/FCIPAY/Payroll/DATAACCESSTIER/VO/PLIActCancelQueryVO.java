package FCIPAY.Payroll.DATAACCESSTIER.VO;

import java.io.Serializable;

public class PLIActCancelQueryVO extends PayrollBaseQueryVO implements Serializable
{
    private String txtEmpNo;    
    private String txtPLIYear;
    private String txtLocId;
    private String txtInvoice;
    private String loginEmployeeNo;  
    private String screenName;
    
    public PLIActCancelQueryVO() 
    {        
    }

    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtPLIYear(String txtPLIYear) {
        this.txtPLIYear = txtPLIYear;
    }

    public String getTxtPLIYear() {
        return txtPLIYear;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }


    public void setTxtInvoice(String txtInvoice) {
        this.txtInvoice = txtInvoice;
    }

    public String getTxtInvoice() {
        return txtInvoice;
    }

    public void setLoginEmployeeNo(String loginEmployeeNo) {
        this.loginEmployeeNo = loginEmployeeNo;
    }

    public String getLoginEmployeeNo() {
        return loginEmployeeNo;
    }


    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }
}
