package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class IncomeTaxRegimeBean extends PayrollBaseDetailBean implements Serializable{
    
    private int txtSrlNo;
    private String txtFinYear="";
    private String txtITRegime="";
    private String txtFinalFlag="";
    private String txtFreeze="";
        
    
    public IncomeTaxRegimeBean() {
    
    }

    public void setTxtSrlNo(int txtSrlNo) {
        this.txtSrlNo = txtSrlNo;
    }

    public int getTxtSrlNo() {
        return txtSrlNo;
    }
    
    public void setTxtFinYear(String txtFinYear) {
        this.txtFinYear = txtFinYear;
    }

    public String getTxtFinYear() {
        return txtFinYear;
    }

    public void setTxtITRegime(String txtITRegime) {
        this.txtITRegime = txtITRegime;
    }

    public String getTxtITRegime() {
        return txtITRegime;
    }

    public void setTxtFinalFlag(String txtFinalFlag) {
        this.txtFinalFlag = txtFinalFlag;
    }

    public String getTxtFinalFlag() {
        return txtFinalFlag;
    }

    public void setTxtFreeze(String txtFreeze) {
        this.txtFreeze = txtFreeze;
    }

    public String getTxtFreeze() {
        return txtFreeze;
    }
}
