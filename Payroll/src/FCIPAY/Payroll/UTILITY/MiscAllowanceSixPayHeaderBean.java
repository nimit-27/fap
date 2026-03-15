package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MiscAllowanceSixPayHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
    public MiscAllowanceSixPayHeaderBean()
    {
    }
    private String cboAllowType;
    private String cboAreaType;
    private String txtEffFrmDt;
    private String txtEffToDt;
    private String txtPayCode;
    public String getCboAllowType()
    {
        return cboAllowType;
    }
    public void setCboAllowType(String newCboAllowType)
    {
        cboAllowType = newCboAllowType;
    }
    
    public String getCboAreaType()
    {
        return cboAreaType;
    }
    public void setCboAreaType(String newCboAreaType)
    {
        cboAreaType = newCboAreaType;
    }

    public String getTxtEffFrmDt()
    {
        return txtEffFrmDt;
    }
    public void setTxtEffFrmDt(String newTxtEffFrmDt)
    {
        txtEffFrmDt = newTxtEffFrmDt;
    }
    
    public String getTxtEffToDt()
    {
        return txtEffToDt;
    }
    public void setTxtEffToDt(String newTxtEffToDt)
    {
        txtEffToDt = newTxtEffToDt;
    }

    public String getTxtPayCode()
    {
        return txtPayCode;
    }
    public void setTxtPayCode(String  newTxtPayCode)
    {
        txtPayCode = newTxtPayCode;
    }
}