package FCIPAY.Payroll.UTILITY;

public class EmpBasicHistBean extends PayrollBaseDetailBean
{
    private String  txtStartDt;
    private String  txtEndDt;
    private String  txtBasic;
    private String  txtOldPayscale;
    private String  txtGradePay;
    private String  txtEvent;

    public void setTxtStartDt(String txtStartDt) {
        this.txtStartDt = txtStartDt;
    }

    public String getTxtStartDt() {
        return txtStartDt;
    }

    public void setTxtEndDt(String txtEndDt) {
        this.txtEndDt = txtEndDt;
    }

    public String getTxtEndDt() {
        return txtEndDt;
    }

    public void setTxtBasic(String txtBasic) {
        this.txtBasic = txtBasic;
    }

    public String getTxtBasic() {
        return txtBasic;
    }

    public void setTxtOldPayscale(String txtOldPayscale) {
        this.txtOldPayscale = txtOldPayscale;
    }

    public String getTxtOldPayscale() {
        return txtOldPayscale;
    }

    public void setTxtGradePay(String txtGradePay) {
        this.txtGradePay = txtGradePay;
    }

    public String getTxtGradePay() {
        return txtGradePay;
    }

    public void setTxtEvent(String txtEvent) {
        this.txtEvent = txtEvent;
    }

    public String getTxtEvent() {
        return txtEvent;
    }
}
