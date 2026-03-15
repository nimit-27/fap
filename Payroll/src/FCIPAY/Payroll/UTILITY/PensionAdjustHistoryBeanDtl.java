package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class PensionAdjustHistoryBeanDtl  extends PayrollBaseDetailBean implements Serializable
{
    private String txtAdjTypeDtl1;
    private String txtPayModeDtl1;
    private String txtAdjAmtDtl1;
    private String txtRmrkDtl1;
    private String txtModDtDtl;

    public PensionAdjustHistoryBeanDtl()
    {
    }
    
    public String getTxtAdjTypeDtl1()
    {
        return txtAdjTypeDtl1;
    }
    public void setTxtAdjTypeDtl1(String newTxtAdjTypeDtl1)
    {
        txtAdjTypeDtl1 = newTxtAdjTypeDtl1;
    }
    public String getTxtPayModeDtl1()
    {
        return txtPayModeDtl1;
    }
    public void setTxtPayModeDtl1(String newTxtPayModeDtl1)
    {
        txtPayModeDtl1 = newTxtPayModeDtl1;
    }
    public String getTxtAdjAmtDtl1()
    {
        return txtAdjAmtDtl1;
    }
    public void setTxtAdjAmtDtl1(String newTxtAdjAmtDtl1)
    {
        txtAdjAmtDtl1 = newTxtAdjAmtDtl1;
    }
    public String getTxtRmrkDtl1()
    {
        return txtRmrkDtl1;
    }
    public void setTxtRmrkDtl1(String newTxtRmrkDtl1)
    {
        txtRmrkDtl1 = newTxtRmrkDtl1;
    }
    
    public String getTxtModDtDtl()
    {
        return txtModDtDtl;
    }
    public void setTxtModDtDtl(String newTxtModDtDtl)
    {
        txtModDtDtl = newTxtModDtDtl;
    }
}