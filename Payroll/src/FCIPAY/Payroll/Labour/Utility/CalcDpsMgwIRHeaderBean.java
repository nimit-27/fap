package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class CalcDpsMgwIRHeaderBean extends PayrollBaseHeaderBean 
{
  private String txtGangName;
  private String txtGangId;
  private String txtLoc;
  private String txtLocId;
  private String hdnMaxRebFlag;
  public CalcDpsMgwIRHeaderBean()
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
  
  public String getHdnMaxRebFlag()
  {
    return hdnMaxRebFlag;
  }
 
  public void setHdnMaxRebFlag(String newHdnMaxRebFlag)
  {
    hdnMaxRebFlag = newHdnMaxRebFlag;
  }
}