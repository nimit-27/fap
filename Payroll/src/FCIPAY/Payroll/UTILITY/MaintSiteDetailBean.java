package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class MaintSiteDetailBean extends PayrollBaseDetailBean  implements Serializable
{
  private String txtSiteName="";
  private String txtAddr="";
  private String txtState="";
  private String hdnStateCode="";
  private String txtPh="";
  private String txtEMail="";
  private String txtFax="";
  private String txtSiteId="";
  private String txtPin="";
  private String txtPan="";
  private String txtTan="";

  public MaintSiteDetailBean()
  {
    
  }

  public String getTxtSiteId()
  {
    return txtSiteId;
  }

  public void setTxtSiteId(String newTxtSiteId)
  {
    txtSiteId=newTxtSiteId;
  }
  
  public String getTxtSiteName()
  {
    return txtSiteName;
  }

  public void setTxtSiteName(String newTxtSiteName)
  {
    txtSiteName=newTxtSiteName;
  }
  
  public String getTxtAddr()
  {
    return txtAddr;
  }

  public void setTxtAddr(String newTxtAddr)
  {
    txtAddr=newTxtAddr;
  }
  
  public String getTxtPh()
  {
    return txtPh;
  }

  public void setTxtPh(String newTxtPh)
  {
    txtPh=newTxtPh;
  }
  
  public String getTxtEMail()
  {
    return txtEMail;
  }

  public void setTxtEMail(String newTxtEMail)
  {
    txtEMail=newTxtEMail;
  }
  
  public String getTxtFax()
  {
    return txtFax;
  }

  public void setTxtFax(String newTxtFax)
  {
    txtFax=newTxtFax;
  }
  
  public String getTxtState()
  {
    return txtState;
  }

  public void setTxtState(String newTxtState)
  {
    txtState=newTxtState;
  }

  public String getHdnStateCode()
  {
    return hdnStateCode;
  }

  public void setHdnStateCode(String newHdnStateCode)
  {
    hdnStateCode=newHdnStateCode;
  }

  public String getTxtPin()
  {
    return txtPin;
  }

  public void setTxtPin(String newTxtPin)
  {
    txtPin=newTxtPin;
  }

  public String getTxtPan()
  {
    return txtPan;
  }

  public void setTxtPan(String newTxtPan)
  {
    txtPan=newTxtPan;
  }

  public String getTxtTan()
  {
    return txtTan;
  }

  public void setTxtTan(String newTxtTan)
  {
    txtTan=newTxtTan;
  }

}