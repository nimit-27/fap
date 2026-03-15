package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintMiscellaneousParamForm extends PayrollBaseForm 
{

  private boolean flagOTA = false;
  private boolean flagMedReimb = false;
  private boolean flagMHSDedn = false;
  private boolean flagOther = false;
  

  //Fields For Misc Param Tab(new Logic Dt 25 Oct 2007.
  private String [] hdnAllowTyp;
  private String [] hdnAllowDtl;
  private String [] txtPayCode;
  
  // Fields for Medical Health Deduction Scheme Tab.
  private String [] txtCtgry;
  
  private String [] txtAllow;
  private String [] txtStartDt;
  private String [] txtEndDt;
  private ArrayList lstMHSDtls;
  private ArrayList lstOtherDtls;

 
  public boolean isFlagOTA()
  {
    return flagOTA;
  }

  public void setFlagOTA(boolean newFlagOTA)
  {
    flagOTA = newFlagOTA;
  }

  public boolean isFlagMedReimb()
  {
    return flagMedReimb;
  }

  public void setFlagMedReimb(boolean newFlagMedReimb)
  {
    flagMedReimb = newFlagMedReimb;
  }

  public boolean isFlagMHSDedn()
  {
    return flagMHSDedn;
  }

  public void setFlagMHSDedn(boolean newFlagMHSDedn)
  {
    flagMHSDedn = newFlagMHSDedn;
  }

  public boolean isFlagOther()
  {
    return flagOther;
  }

  public void setFlagOther(boolean newFlagOther)
  {
    flagOther = newFlagOther;
  }
  

  public ArrayList getLstMHSDtls()
  {
    return lstMHSDtls;
  }

  public void setLstMHSDtls(ArrayList newLstMHSDtls)
  {
    lstMHSDtls = newLstMHSDtls;
  }

  public ArrayList getLstOtherDtls()
  {
    return lstOtherDtls;
  }

  public void setLstOtherDtls(ArrayList newLstOtherDtls)
  {
    lstOtherDtls = newLstOtherDtls;
  }
  
  public String [] getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String [] newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }
   public String [] getTxtStartDt()
  {
    return txtStartDt;
  }

  public void setTxtStartDt(String [] newTxtStartDt)
  {
    txtStartDt = newTxtStartDt;
  }

   public String [] getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String [] newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }

  public String [] getTxtEndDt()
  {
    return txtEndDt;
  }

  public void setTxtEndDt(String [] newTxtEndDt)
  {
    txtEndDt = newTxtEndDt;
  }

  public String [] getHdnAllowTyp()
  {
    return hdnAllowTyp;
  }

  public void setHdnAllowTyp(String [] newHdnAllowTyp)
  {
    hdnAllowTyp = newHdnAllowTyp;
  }

  public String [] getHdnAllowDtl()
  {
    return hdnAllowDtl;
  }

  public void setHdnAllowDtl(String [] newHdnAllowDtl)
  {
    hdnAllowDtl = newHdnAllowDtl;
  }
  
  public String [] getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String [] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

}