package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class PfAdjustHistoryBean  extends PayrollBaseDetailBean implements Serializable
{
    private String txtAdjHdrId;
    private String txtAdjTypeHdr1;
    private String txtPayMode1;
    private String txtAdjAmtHdr1;
    private String txtRmrkHdr1;
    private String txtModDtHdr;

    public PfAdjustHistoryBean()
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

    public String getTxtAdjTypeHdr1()
    {
        return txtAdjTypeHdr1;
    }
    public void setTxtAdjTypeHdr1(String newTxtAdjTypeHdr1)
    {
        txtAdjTypeHdr1 = newTxtAdjTypeHdr1;
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
}