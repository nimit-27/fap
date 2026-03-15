package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintCityLocMapForm extends PayrollBaseForm 
{
  private ArrayList lstInstrDtls=new ArrayList();
//Added by Swapnendu Dt 20 -Aug 2010
  private String txtLocLov;
  private String txtLocidSrch, txtLocSrch;
  
  private String imgTxtTo;
  private String addBtnFlag="";
  private String exeBtnFlag="";
//Added by Swapnendu Dt 20 -Aug 2010

  private String [] txtLoc;
  private String [] txtLocId;
  private String [] txtCityTyp;
  private String [] txtAreaTyp;
  private String [] txtTranCityTyp;  //Added by Swapnendu Dt 27 -Aug 2010
  private String [] txtMgwCityTyp;   //Added by Swapnendu Dt 26 -Apr 2011
  private String [] txtPopTyp;
  private String [] txtFrom;
  private String [] txtTo;
  
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls=newLstInstrDtls;
  }

  public String [] getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String [] newTxtLoc)
  {
    txtLoc=newTxtLoc;
  }

  public String [] getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String [] newTxtLocId)
  {
    txtLocId=newTxtLocId;
  }

  public String [] getTxtCityTyp()
  {
    return txtCityTyp;
  }

  public void setTxtCityTyp(String [] newTxtCityTyp)
  {
    txtCityTyp=newTxtCityTyp;
  }

  public String [] getTxtAreaTyp()
  {
    return txtAreaTyp;
  }

  public void setTxtAreaTyp(String [] newTxtAreaTyp)
  {
    txtAreaTyp=newTxtAreaTyp;
  }

  public String [] getTxtTranCityTyp()
  {
    return txtTranCityTyp;
  }

  public void setTxtTranCityTyp(String [] newTxtTranCityTyp)
  {
    txtTranCityTyp=newTxtTranCityTyp;
  }

  public String [] getTxtMgwCityTyp()
  {
    return txtMgwCityTyp;
  }

  public void setTxtMgwCityTyp(String [] newTxtMgwCityTyp)
  {
    txtMgwCityTyp=newTxtMgwCityTyp;
  }

  public String [] getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String [] newTxtFrom)
  {
    txtFrom=newTxtFrom;
  }

  public String [] getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String [] newTxtTo)
  {
    txtTo=newTxtTo;
  }
  
   public String [] getTxtPopTyp()
  {
    return txtPopTyp;
  }

  public void setTxtPopTyp(String [] newTxtPopTyp)
  {
    txtPopTyp=newTxtPopTyp;
  }

  public String getTxtLocLov()
  {
    return txtLocLov;
  }
  
  public void setTxtLocLov(String newTxtLocLov)
  {
    txtLocLov=newTxtLocLov;
  }
  
  public String getTxtLocidSrch()
  {
    return txtLocidSrch;
  }
  
  public void setTxtLocidSrch(String newTxtLocidSrch)
  {
    txtLocidSrch=newTxtLocidSrch;
  }

  public String getTxtLocSrch()
  {
    return txtLocSrch;
  }
  
  public void setTxtLocSrch(String newTxtLocSrch)
  {
    txtLocSrch=newTxtLocSrch;
  }
  
 
  public String getImgTxtTo()
  {
    return imgTxtTo;
  }
  
  public void setImgTxtTo(String newImgTxtTo)
  {
    imgTxtTo=newImgTxtTo;
  }
  
  public String getAddBtnFlag()
  {
    return addBtnFlag;
  }
  
  public void setAddBtnFlag(String newAddBtnFlag)
  {
    addBtnFlag=newAddBtnFlag;
  }

  public String getExeBtnFlag()
  {
    return exeBtnFlag;
  }
  
  public void setExeBtnFlag(String newExeBtnFlag)
  {
    exeBtnFlag=newExeBtnFlag;
  }

}