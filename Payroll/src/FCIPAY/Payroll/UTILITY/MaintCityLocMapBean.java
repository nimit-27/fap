package FCIPAY.Payroll.UTILITY;

public class MaintCityLocMapBean extends PayrollBaseDetailBean 
{
  
  private String txtLoc;
  private String txtLocId;
  private String txtCityTyp;
  private String txtAreaTyp;
  private String txtTranCityTyp;  //added by Swapnendu Dt 27 -Aug 2010.
  private String txtMgwCityTyp;
  private String txtPopTyp;
  private String txtFrom;
  private String txtTo="";
  
  public MaintCityLocMapBean()
  {
  }
  
  public String getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String newTxtLoc)
  {
    txtLoc=newTxtLoc;
  }

  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId=newTxtLocId;
  }

  public String getTxtCityTyp()
  {
    return txtCityTyp;
  }

  public void setTxtCityTyp(String newTxtCityTyp)
  {
    txtCityTyp=newTxtCityTyp;
  }

  public String getTxtAreaTyp()
  {
    return txtAreaTyp;
  }

  public void setTxtAreaTyp(String newTxtAreaTyp)
  {
    txtAreaTyp=newTxtAreaTyp;
  }

  public String getTxtTranCityTyp()
  {
    return txtTranCityTyp;
  }

  public void setTxtTranCityTyp(String newTxtTranCityTyp)
  {
    txtTranCityTyp=newTxtTranCityTyp;
  }

  public String getTxtMgwCityTyp()
  {
    return txtMgwCityTyp;
  }

  public void setTxtMgwCityTyp(String newTxtMgwCityTyp)
  {
    txtMgwCityTyp=newTxtMgwCityTyp;
  }
  public String getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String newTxtFrom)
  {
    txtFrom=newTxtFrom;
  }

  public String getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String newTxtTo)
  {
    txtTo=newTxtTo;
  }
  
  
  public String getTxtPopTyp()
  {
    return txtPopTyp;
  }

  public void setTxtPopTyp(String newTxtPopTyp)
  {
    txtPopTyp=newTxtPopTyp;
  }
}