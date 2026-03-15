package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class CalcDeptOTAHeaderBean extends PayrollBaseHeaderBean 
{
  private String txtGangName;
  private String txtGangId;
  private String txtLoc;
  private String txtLocId;
  
  public CalcDeptOTAHeaderBean()
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
 
}