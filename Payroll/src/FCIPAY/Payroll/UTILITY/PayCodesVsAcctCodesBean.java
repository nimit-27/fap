package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class PayCodesVsAcctCodesBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtPayCode="";
  private String txtPayCodeDesc="";
  private String txtAgencyCode="";
  private String txtDRCR="";
  private String txtAcctCode="";
  private String hdnAcctDesc="";
  private String hdnAgencyName="";

 public PayCodesVsAcctCodesBean()
  {
  }

  public PayCodesVsAcctCodesBean(String paycode,String paycodedsc,String agencycode,String drcr,String acctcode)
  {
      txtPayCode=paycode;
      txtPayCodeDesc=paycodedsc;
      txtAgencyCode=agencycode;
      txtDRCR=drcr;
      txtAcctCode=acctcode;
      
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }



  public String getTxtAgencyCode()
  {
    return txtAgencyCode;
  }

  public void setTxtAgencyCode(String newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }



  public String getTxtDRCR()
  {
    return txtDRCR;
  }

  public void setTxtDRCR(String newTxtDRCR)
  {
    txtDRCR = newTxtDRCR;
  }

  public String getTxtAcctCode()
  {
    return txtAcctCode;
  }

  public void setTxtAcctCode(String newTxtAcctCode)
  {
    txtAcctCode = newTxtAcctCode;
  }

  public String getHdnAcctDesc()
  {
    return hdnAcctDesc;
  }

  public void setHdnAcctDesc(String newHdnAcctDesc)
  {
    hdnAcctDesc = newHdnAcctDesc;
  }

  public String getHdnAgencyName()
  {
    return hdnAgencyName;
  }

  public void setHdnAgencyName(String newHdnAgencyName)
  {
    hdnAgencyName = newHdnAgencyName;
  }





}