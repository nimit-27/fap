    /*
    * Module:        MaintPayCodesForm.java
    * Author:        Surajeet Chakraborty
    * Date Written:  December 2004
    * Description:   Action Form for FE Release Details
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintPayCodesBean;

public class MaintPayCodesForm extends PayrollBaseForm 
{
    private String txtSrlNo[] = null;
    private String txtPayCode[] = null;
    private String txtPayCodeDesc[] = null;
    private String lstTaxableIndicator[] = null;
    private String lstSavingsRebate[] = null;
    private String txtRebateLimit[] = null;
    private String txtAdjPriority[] = null;
    private String hdnCheck[] = null;
    private ArrayList lstInstrDtls = new ArrayList();
    private long txtTest = 0;
    private String action = "";
    private String lstProfTaxFlag[] = null;
    private String optVal;
    private String txtFromPayCode;
    private String txtToPayCode;
    
    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
        this.txtTest = 0;
   }
  
    public String[] gettxtSrlNo()
    {
        return txtSrlNo;
    }

    public void settxtSrlNo(String[] newtxtSrlNo)
    {
        txtSrlNo = newtxtSrlNo;
    }

    public String[] gettxtPayCode()
    {
        return txtPayCode;
    }

    public void settxtPayCode(String[] newtxtPayCode)
    {
        txtPayCode = newtxtPayCode;
    }

    public String[] gettxtPayCodeDesc()
    {
        return txtPayCodeDesc;
    }

    public void settxtPayCodeDesc(String[] newtxtPayCodeDesc)
    {
        txtPayCodeDesc = newtxtPayCodeDesc;
    }

    public String[] getlstTaxableIndicator()
    {
        return lstTaxableIndicator;
    }

    public void setlstTaxableIndicator(String[] newLstTaxableIndicator)
    {
        lstTaxableIndicator = newLstTaxableIndicator;
    }
   
    public String[] getlstSavingsRebate()
    {
        return lstSavingsRebate;
    }

    public void setlstSavingsRebate(String[] newLstSavingsRebate)
    {
        lstSavingsRebate = newLstSavingsRebate;
    }
   
    public String[] gettxtRebateLimit()
    {
        return txtRebateLimit;
    }

    public void settxtRebateLimit(String[] newtxtRebateLimit)
    {
        txtRebateLimit = newtxtRebateLimit;
    }

    public String[] gettxtAdjPriority()
    {
        return txtAdjPriority;
    }

    public void settxtAdjPriority(String[] newtxtAdjPriority)
    {
        txtAdjPriority = newtxtAdjPriority;
    }

    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

    public long getTxtTest()
    {
        return txtTest;
    }

    public void setTxtTest(long newTxtTest)
    {
        txtTest = newTxtTest;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String newAction)
    {
        action = newAction;
    }
   
    public String[] getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }

  public String[] getLstProfTaxFlag()
  {
    return lstProfTaxFlag;
  }

  public void setLstProfTaxFlag(String[] newLstProfTaxFlag)
  {
    lstProfTaxFlag = newLstProfTaxFlag;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String getTxtFromPayCode()
  {
    return txtFromPayCode;
  }

  public void setTxtFromPayCode(String newTxtFromPayCode)
  {
    txtFromPayCode = newTxtFromPayCode;
  }
  
  public String getTxtToPayCode()
  {
    return txtToPayCode;
  }

  public void setTxtToPayCode(String newTxtToPayCode)
  {
    txtToPayCode = newTxtToPayCode;
  }
    
}