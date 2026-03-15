package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MiscellaneousParamDtlOtherBean  extends PayrollBaseDetailBean implements Serializable 
{

  private String hdnAllowTyp;
  private String hdnAllowDtl;
  private String txtAllow;
  private String txtStartDt;
  private String txtPayCode;

  public MiscellaneousParamDtlOtherBean()
  {
  }
  
  public String getHdnAllowTyp()
  {
    return hdnAllowTyp;
  }

  public void setHdnAllowTyp(String newHdnAllowTyp)
  {
    hdnAllowTyp = newHdnAllowTyp;
  }
   
  public String getHdnAllowDtl()
  {
    return hdnAllowDtl;
  }

  public void setHdnAllowDtl(String newHdnAllowDtl)
  {
    hdnAllowDtl = newHdnAllowDtl;
  }
  
  public String getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }
  
  public String getTxtStartDt()
  {
    return txtStartDt;
  }

  public void setTxtStartDt(String newTxtStartDt)
  {
    txtStartDt = newTxtStartDt;
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

}