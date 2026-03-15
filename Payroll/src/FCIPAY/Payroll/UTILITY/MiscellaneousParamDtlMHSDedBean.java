package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MiscellaneousParamDtlMHSDedBean  extends PayrollBaseDetailBean implements Serializable
{
  private String txtCtgry;
  private String txtAllow;
  private String txtStartDt;
  private String txtEndDt;
  
  public MiscellaneousParamDtlMHSDedBean()
  {
    
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

   public String getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }

     public String getTxtEndDt()
  {
    return txtEndDt;
  }

  public void setTxtEndDt(String newTxtEndDt)
  {
    txtEndDt = newTxtEndDt;
  }

}