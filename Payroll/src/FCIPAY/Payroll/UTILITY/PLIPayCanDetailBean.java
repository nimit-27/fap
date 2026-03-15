package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class PLIPayCanDetailBean extends PayrollBaseDetailBean implements Serializable
{
    private String txtEmpNo;
    private String txtEmpName;
    private String txtInvoice;    
    private String txtPLIAmnt;    
    private String txtLocId;
    private String screenName;
    
    public PLIPayCanDetailBean() 
    {       
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

    public void setTxtInvoice(String txtInvoice) {
        this.txtInvoice = txtInvoice;
    }

    public String getTxtInvoice() {
        return txtInvoice;
    }

    public void setTxtPLIAmnt(String txtPLIAmnt) {
        this.txtPLIAmnt = txtPLIAmnt;
    }

    public String getTxtPLIAmnt() {
        return txtPLIAmnt;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }
    
    public String getScreenName()
    {
      return screenName;
    }

    public void setscreenName(String newScreenName)
    {
      screenName = newScreenName;
    }
}
