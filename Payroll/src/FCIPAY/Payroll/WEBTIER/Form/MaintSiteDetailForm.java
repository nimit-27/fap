package FCIPAY.Payroll.WEBTIER.Form;

import java.util.ArrayList;

public class MaintSiteDetailForm extends PayrollBaseForm 
{
  private String txtParentLoc=null;
  private String txtParentLocDesc=null;
  private String txtLocTyp=null;
  private String txtSiteName[]=null;
  private String txtDesc[]=null;
  private String txtAddr[]=null;
  private String txtState[]=null;
  private String hdnStateCode[]=null;
  private String txtPh[]=null;
  private String txtEMail[]=null;
  private String txtFax[]=null;
  private String txtSiteId[]=null;
  private String txtPin[]=null;
  private String txtPan[]=null;
  private String txtTan[]=null;
  private ArrayList lstInstrDtls=new ArrayList();
  
  
  public MaintSiteDetailForm()
  {
  }
  
  public String getTxtParentLoc()
  {
    return txtParentLoc;
  }

  public void setTxtParentLoc(String newTxtParentLoc)
  {
    txtParentLoc=newTxtParentLoc;
  }

  public String getTxtParentLocDesc()
  {
    return txtParentLocDesc;
  }

  public void setTxtParentLocDesc(String newTxtParentLocDesc)
  {
    txtParentLocDesc=newTxtParentLocDesc;
  }
  
   public String getTxtLocTyp()
  {
    return txtLocTyp;
  }

  public void setTxtLocTyp(String newTxtLocTyp)
  {
    txtLocTyp=newTxtLocTyp;
  }
  
   public String[] getTxtSiteId()
  {
    return txtSiteId;
  }

  public void setTxtSiteId(String[] newTxtSiteId)
  {
    txtSiteId=newTxtSiteId;
  }
  
   public String[] getTxtSiteName()
  {
    return txtSiteName;
  }

  public void setTxtSiteName(String[] newTxtSiteName)
  {
    txtSiteName=newTxtSiteName;
  }
  
  public String[] getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String[] newTxtDesc)
  {
    txtDesc=newTxtDesc;
  }
  public String[] getTxtAddr()
  {
    return txtAddr;
  }

  public void setTxtAddr(String[] newTxtAddr)
  {
    txtAddr=newTxtAddr;
  }
  public String[] getTxtPh()
  {
    return txtPh;
  }

  public void setTxtPh(String[] newTxtPh)
  {
    txtPh=newTxtPh;
  }
  public String[] getTxtEMail()
  {
    return txtEMail;
  }

  public void setTxtEMail(String[] newTxtEMail)
  {
    txtEMail=newTxtEMail;
  }

  public String[] getTxtFax()
  {
    return txtFax;
  }

  public void setTxtFax(String[] newTxtFax)
  {
    txtFax=newTxtFax;
  }

  public String[] getTxtState()
  {
    return txtState;
  }

  public void setTxtState(String[] newTxtState)
  {
    txtState=newTxtState;
  }

  public String[] getHdnStateCode()
  {
    return hdnStateCode;
  }

  public void setHdnStateCode(String[] newHdnStateCode)
  {
    hdnStateCode=newHdnStateCode;
  }

  
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
  public String[] getTxtPin()
  {
    return txtPin;
  }

  public void setTxtPin(String[] newTxtPin)
  {
    txtPin=newTxtPin;
  }

  public String[] getTxtPan()
  {
    return txtPan;
  }

  public void setTxtPan(String[] newTxtPan)
  {
    txtPan=newTxtPan;
  }

  public String[] getTxtTan()
  {
    return txtTan;
  }

  public void setTxtTan(String[] newTxtTan)
  {
    txtTan=newTxtTan;
  }

}