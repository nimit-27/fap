package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class LeaveTravelConcessionQueryVO extends PayrollBaseQueryVO{
    
    
    private String txtEmpNo;
    private String screenName;
    private String txtApplnDt;
    private String txtTicketAmount;
    private String txtYYYY;
    private String txtInvId;
    
    public LeaveTravelConcessionQueryVO() {
    }


    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setTxtApplnDt(String txtApplnDt) {
        this.txtApplnDt = txtApplnDt;
    }

    public String getTxtApplnDt() {
        return txtApplnDt;
    }

    public void setTxtYYYY(String txtYYYY) {
        this.txtYYYY = txtYYYY;
    }

    public String getTxtYYYY() {
        return txtYYYY;
    }

    public void setTxtInvId(String txtInvId) {
        this.txtInvId = txtInvId;
    }

    public String getTxtInvId() {
        return txtInvId;
    }

    public void setTxtTicketAmount(String txtTicketAmount) {
        this.txtTicketAmount = txtTicketAmount;
    }

    public String getTxtTicketAmount() {
        return txtTicketAmount;
    }
}
