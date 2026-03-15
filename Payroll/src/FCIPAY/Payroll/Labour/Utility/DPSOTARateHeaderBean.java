package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class DPSOTARateHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  public String txtYYMM;
  private String txtLocId="";
  private String txtLocDesc="";

  public String getTxtLocId()
  {
    return txtLocId;
  }
  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }
  
  public String getTxtYYMM()
  {
    return txtYYMM;
  }
  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }
  public String getTxtLocDesc()
  {
    return txtLocDesc;
  }
  public void setTxtLocDesc(String newTxtLocDesc)
  {
    txtLocDesc = newTxtLocDesc;
  }
  
}