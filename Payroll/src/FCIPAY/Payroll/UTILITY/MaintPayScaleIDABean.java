    /*
    * Module:        MaintPayCodesBean.java
    * Author:        Surajeet Chakraborty
    * Date Written:  December 2004
    * Description:   Bean Class for Maintaining the Pay Codes
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.UTILITY;
public class MaintPayScaleIDABean 
{
    private String txtSrlNo = "";
    private String txtPayCode = "";    
    private String txtPayCodeDesc = "";    
    private String lstTaxableIndicator = "";
    private String lstSavingsRebate = "";
    private String txtRebateLimit = "";    
    private String txtAdjPriority = "";    
        
    private String hdnCheck = "";
    private boolean chkDel;

    public MaintPayScaleIDABean()
    {
    }

    public MaintPayScaleIDABean(String sPayCode,String sPayCodeDesc,String sTaxableIndicator,String sSavingRebate,String sRebateLimit, String sAdjPriority,String sCheck)
    {
        txtPayCode = sPayCode;
        txtPayCodeDesc = sPayCodeDesc;
        lstTaxableIndicator = sTaxableIndicator;
        lstSavingsRebate = sSavingRebate;
        txtRebateLimit = sRebateLimit;
        txtAdjPriority = sAdjPriority;
        hdnCheck = sCheck;
    }

    public String gettxtSrlNo()
    {
        return txtSrlNo;
    }

    public void settxtSrlNo(String newtxtSrlNo)
    {
        txtSrlNo = newtxtSrlNo;
    }
    
    public String gettxtPayCode()
    {
        return txtPayCode;
    }

    public void settxtPayCode(String newtxtPayCode)
    {
        txtPayCode = newtxtPayCode;
    }

    public String gettxtPayCodeDesc()
    {
        return txtPayCodeDesc;
    }

    public void settxtPayCodeDesc(String newtxtPayCodeDesc)
    {
        txtPayCodeDesc = newtxtPayCodeDesc;
    }    

    public String getlstTaxableIndicator()
    {
        return lstTaxableIndicator;
    }

    public void setlstTaxableIndicator(String newlstTaxableIndicator)
    {
        lstTaxableIndicator = newlstTaxableIndicator;
    }    

    public String getlstSavingsRebate()
    {
        return lstSavingsRebate;
    }

    public void setlstSavingsRebate(String newlstSavingsRebate)
    {
        lstSavingsRebate = newlstSavingsRebate;
    }    

    public String gettxtRebateLimit()
    {
        return txtRebateLimit;
    }

    public void settxtRebateLimit(String newtxtRebateLimit)
    {
        txtRebateLimit = newtxtRebateLimit;
    }

    public String gettxtAdjPriority()
    {
        return txtAdjPriority;
    }

    public void settxtAdjPriority(String newtxtAdjPriority)
    {
        txtAdjPriority = newtxtAdjPriority;
    }
      
    public String getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }

    public boolean isChkDel()
    {
        return chkDel;
    }

    public void setChkDel(boolean newChkDel)
    {
        chkDel = newChkDel;
    }



}