package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class PensionAdjustHistoryBean  extends PayrollBaseDetailBean implements Serializable
{
    private String txtAdjHdrId;
    private String txtAdjTypeHdr1;
    private String txtPayMode1;
    private String txtAdjAmtHdr1;
    private String txtRmrkHdr1;
    private String txtModDtHdr;
    private String txtQuarterHdrl;

    public PensionAdjustHistoryBean()
    {
    }

    public String getTxtAdjHdrId()
    {
        return txtAdjHdrId;
    }
    public void setTxtAdjHdrId(String newTxtAdjHdrId)
    {
        txtAdjHdrId = newTxtAdjHdrId;
    }

    public String getTxtAdjAmtHdr1()
    {
        return txtAdjAmtHdr1;
    }
    public void setTxtAdjAmtHdr1(String newTxtAdjAmtHdr1)
    {
        txtAdjAmtHdr1 = newTxtAdjAmtHdr1;
    }
    
    public String getTxtPayMode1()
    {
        return txtPayMode1;
    }
    public void setTxtPayMode1(String newTxtPayMode1)
    {
        txtPayMode1 = newTxtPayMode1;
    }
    
    public String getTxtRmrkHdr1()
    {
        return txtRmrkHdr1;
    }
    public void setTxtRmrkHdr1(String newTxtRmrkHdr1)
    {
        txtRmrkHdr1 = newTxtRmrkHdr1;
    }
    
    public String getTxtModDtHdr()
    {
        return txtModDtHdr;
    }
    public void setTxtModDtHdr(String newTxtModDtHdr)
    {
        txtModDtHdr = newTxtModDtHdr;
    }

    public void setTxtQuarterHdrl(String txtQuarterHdrl) {
        this.txtQuarterHdrl = txtQuarterHdrl;
    }

    public String getTxtQuarterHdrl() {
        return txtQuarterHdrl;
    }

    public void setTxtAdjTypeHdr1(String txtAdjTypeHdr1) {
        this.txtAdjTypeHdr1 = txtAdjTypeHdr1;
    }

    public String getTxtAdjTypeHdr1() {
        return txtAdjTypeHdr1;
    }
}
