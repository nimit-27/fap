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
import FCIPAY.Payroll.UTILITY.PayCodesVsAcctCodesBean;
//import IBA.Payroll.DATAACCESSTIER.VO.MaintPayCodesVO;

public class PayCodesVsAcctCodesForm extends PayrollBaseForm 
{
    private String txtPayCode[] = null;
    private String txtPayCodeDesc[] = null;
    private String hdnCheck[] = null;
    private ArrayList lstInstrDtls = new ArrayList();
    private long txtTest = 0;
    private String action = "";
  private String txtAgencyCode[]=null;
  private String txtDRCR[]=null;
  private String txtAcctCode[]=null;
  private String hdnAcctDesc[]=null;
  private String hdnAgencyName[]=null;
    //MaintPayCodesVO fedoVO = new MaintPayCodesVO();
    
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

  public String[] getTxtAgencyCode()
  {
    return txtAgencyCode;
  }

  public void setTxtAgencyCode(String[] newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }

  public String[] getTxtDRCR()
  {
    return txtDRCR;
  }

  public void setTxtDRCR(String[] newTxtDRCR)
  {
    txtDRCR = newTxtDRCR;
  }

  public String[] getTxtAcctCode()
  {
    return txtAcctCode;
  }

  public void setTxtAcctCode(String[] newTxtAcctCode)
  {
    txtAcctCode = newTxtAcctCode;
  }

  public String[] getHdnAcctDesc()
  {
    return hdnAcctDesc;
  }

  public void setHdnAcctDesc(String[] newHdnAcctDesc)
  {
    hdnAcctDesc = newHdnAcctDesc;
  }

  public String[] getHdnAgencyName()
  {
    return hdnAgencyName;
  }

  public void setHdnAgencyName(String[] newHdnAgencyName)
  {
    hdnAgencyName = newHdnAgencyName;
  }
    
    /*public void setVO()
    {       
        fedoVO.setLstInstrDtls(this.lstInstrDtls);

    }*/

    /*public MaintPayCodesVO getVO()
    {
        return fedoVO;
    }*/    

}