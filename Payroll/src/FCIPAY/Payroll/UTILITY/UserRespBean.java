package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class UserRespBean extends PayrollBaseDetailBean implements Serializable  
{
    public UserRespBean()
    {
    }
    private String txtRespId;
    private String txtRespEndDt;

    public String getTxtRespId() {
        return txtRespId;
    }
    public void setTxtRespId(String txtRespId) {
        this.txtRespId = txtRespId;
    }
    public String getTxtRespEndDt() {
        return txtRespEndDt;
    }
    public void setTxtRespEndDt(String txtRespEndDt) {
        this.txtRespEndDt = txtRespEndDt;
    }
}