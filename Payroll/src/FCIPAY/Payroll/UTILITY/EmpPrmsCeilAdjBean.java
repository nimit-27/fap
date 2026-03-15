package FCIPAY.Payroll.UTILITY;

public class EmpPrmsCeilAdjBean extends PayrollBaseDetailBean{
   
    private String txtFinY; 
    private String txtOpeningBal;
    private String txtAdjustBal;
    private String txtAdjustMode;
    private String txtClaimAmout;
    //private String txtCloseBal;
    private String txtAdjustDate;
    private String txtUserId;

    public void setTxtFinY(String txtFinY) {
        this.txtFinY = txtFinY;
    }

    public String getTxtFinY() {
        return txtFinY;
    }

    public void setTxtOpeningBal(String txtOpeningBal) {
        this.txtOpeningBal = txtOpeningBal;
    }

    public String getTxtOpeningBal() {
        return txtOpeningBal;
    }

    public void setTxtAdjustBal(String txtAdjustBal) {
        this.txtAdjustBal = txtAdjustBal;
    }

    public String getTxtAdjustBal() {
        return txtAdjustBal;
    }

    public void setTxtAdjustMode(String txtAdjustMode) {
        this.txtAdjustMode = txtAdjustMode;
    }

    public String getTxtAdjustMode() {
        return txtAdjustMode;
    }

    public void setTxtClaimAmout(String txtClaimAmout) {
        this.txtClaimAmout = txtClaimAmout;
    }

    public String getTxtClaimAmout() {
        return txtClaimAmout;
    }

//    public void setTxtCloseBal(String txtCloseBal) {
//        this.txtCloseBal = txtCloseBal;
//    }
//
//    public String getTxtCloseBal() {
//        return txtCloseBal;
//    }

    public void setTxtAdjustDate(String txtAdjustDate) {
        this.txtAdjustDate = txtAdjustDate;
    }

    public String getTxtAdjustDate() {
        return txtAdjustDate;
    }

    public void setTxtUserId(String txtUserId) {
        this.txtUserId = txtUserId;
    }

    public String getTxtUserId() {
        return txtUserId;
    }
}
