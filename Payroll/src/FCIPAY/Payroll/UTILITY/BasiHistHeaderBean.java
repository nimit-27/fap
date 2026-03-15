package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class BasiHistHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
    public BasiHistHeaderBean() {
        super();
    }
    private String txtEmpNo;
    private String txtYYMMFrom;
    private String txtYYMMTo;

    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtYYMMFrom(String txtYYMMFrom) {
        this.txtYYMMFrom = txtYYMMFrom;
    }

    public String getTxtYYMMFrom() {
        return txtYYMMFrom;
    }

    public void setTxtYYMMTo(String txtYYMMTo) {
        this.txtYYMMTo = txtYYMMTo;
    }

    public String getTxtYYMMTo() {
        return txtYYMMTo;
    }
}
