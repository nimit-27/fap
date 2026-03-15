package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class PLIPayCanHeaderBean extends PayrollBaseHeaderBean implements Serializable
{
    
    private String txtEmpNo;
    private String txtEmpName;    
    private String txtPLIYear;    
    private String txtLocId;
    private String txtInvoice;
    
    public PLIPayCanHeaderBean() 
    {
        //super();
    }

    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
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
}
