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
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
import java.io.Serializable;
public class MaintPayCodesBean  extends PayrollBaseDetailBean implements Serializable
{
    private String txtSrlNo = "";
    private String txtPayCode = "";    
    private String txtPayCodeDesc = "";    
    private String lstTaxableIndicator = "";
    private String lstSavingsRebate = "";
    private String txtRebateLimit = "";    
    private String txtAdjPriority = "";    
    private String lstProfTaxFlag = "";
        

    public MaintPayCodesBean()
    {
    }

    public MaintPayCodesBean(String sPayCode,String sPayCodeDesc,String sTaxableIndicator,String sSavingRebate,String sRebateLimit, String sAdjPriority, String sProfTax )
    {
        txtPayCode = sPayCode;
        txtPayCodeDesc = sPayCodeDesc;
        lstTaxableIndicator = sTaxableIndicator;
        lstSavingsRebate = sSavingRebate;
        txtRebateLimit = sRebateLimit;
        txtAdjPriority = sAdjPriority;
        lstProfTaxFlag = sProfTax;
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

  public String getLstProfTaxFlag()
  {
    return lstProfTaxFlag;
  }

  public void setLstProfTaxFlag(String newLstProfTaxFlag)
  {
    lstProfTaxFlag = newLstProfTaxFlag;
  }
}