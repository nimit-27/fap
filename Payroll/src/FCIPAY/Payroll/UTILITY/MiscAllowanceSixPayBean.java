package FCIPAY.Payroll.UTILITY;

public class MiscAllowanceSixPayBean  extends PayrollBaseDetailBean
{
    private String txtPayBand;
    private String txtGrade;
    private String txtRate;
    private String cboCatg;
    
    public MiscAllowanceSixPayBean()
    {
    }
    
    public String getTxtPayBand()
    {
        return txtPayBand;
    }
    
    public void setTxtPayBand(String newTxtPayBand)
    {
        txtPayBand=newTxtPayBand;
    }
    
    public String getTxtGrade()
    {
        return txtGrade;
    }
    public void setTxtGrade(String newTxtGrade)
    {
        txtGrade=newTxtGrade;
    }
    
    public String getTxtRate()
    {
        return txtRate;
    }
    public void setTxtRate(String newTxtRate)
    {
        txtRate=newTxtRate;
    }

    public String getCboCatg()
    {
        return cboCatg;
    }
    public void setCboCatg(String newCboCatg)
    {
        cboCatg = newCboCatg;
    }
    
}