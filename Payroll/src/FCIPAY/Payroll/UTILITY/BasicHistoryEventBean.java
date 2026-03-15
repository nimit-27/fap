package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

public class BasicHistoryEventBean extends PayrollBaseDetailBean implements Serializable {

    private int txtSrlNo;
    private String txtEventEffDate="";
    private String txtIncrementType="";
    private String txtEventType="";
    private String txtAmount="";
    private String txtEventFlag="";
    private String txtFreezeFlag="";
    
    
    public BasicHistoryEventBean() {
        
    }

    public void setTxtSrlNo(int txtSrlNo) {
        this.txtSrlNo = txtSrlNo;
    }

    public int getTxtSrlNo() {
        return txtSrlNo;
    }

    public void setTxtEventEffDate(String txtEventEffDate) {
        this.txtEventEffDate = txtEventEffDate;
    }

    public String getTxtEventEffDate() {
        return txtEventEffDate;
    }

    public void setTxtIncrementType(String txtIncrementType) {
        this.txtIncrementType = txtIncrementType;
    }

    public String getTxtIncrementType() {
        return txtIncrementType;
    }

    public void setTxtEventType(String txtEventType) {
        this.txtEventType = txtEventType;
    }

    public String getTxtEventType() {
        return txtEventType;
    }

    public void setTxtAmount(String txtAmount) {
        this.txtAmount = txtAmount;
    }

    public String getTxtAmount() {
        return txtAmount;
    }

    public void setTxtEventFlag(String txtEventFlag) {
        this.txtEventFlag = txtEventFlag;
    }

    public String getTxtEventFlag() {
        return txtEventFlag;
    }

    public void setTxtFreezeFlag(String txtFreezeFlag) {
        this.txtFreezeFlag = txtFreezeFlag;
    }

    public String getTxtFreezeFlag() {
        return txtFreezeFlag;
    }
}
