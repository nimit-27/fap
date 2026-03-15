package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class CalcDpsWrkDoneHeaderBean extends PayrollBaseHeaderBean 
{
  private String txtGangName;
  private String txtGangId;
  private String txtLoc;
  private String txtLocId;
  private String txtLbrTyp;
  private String txtFrom;
  private String txtTo;
  private String screenFlag;
  private String txtInvType;
  
  public CalcDpsWrkDoneHeaderBean()
  {
  }

  public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
  }

  public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }

  public String getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String newTxtLoc)
  {
    txtLoc = newTxtLoc;
  }

  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }

  public String getTxtLbrTyp()
  {
    return txtLbrTyp;
  }

  public void setTxtLbrTyp(String newTxtLbrTyp)
  {
    txtLbrTyp = newTxtLbrTyp;
  }

  public String getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String newTxtFrom)
  {
    txtFrom = newTxtFrom;
  }

  public String getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String newTxtTo)
  {
    txtTo = newTxtTo;
  }

  public String getScreenFlag()
  {
    return screenFlag;
  }

  public void setScreenFlag(String newScreenFlag)
  {
    screenFlag = newScreenFlag;
  }
  
  public String getTxtInvType()
  {
    return txtInvType;
  }

  public void setTxtInvType(String newTxtInvType)
  {
    txtInvType = newTxtInvType;
  } 
}