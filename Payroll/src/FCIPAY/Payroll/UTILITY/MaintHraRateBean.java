package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;


public class MaintHraRateBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtHRAAmt;
  private String txtTypeofCity;
   private String txtType;
  private String txtEffDate;
  //private String txtSrlNo;

  public MaintHraRateBean()
  {
  }
   public MaintHraRateBean(String sType, String sHRAAmt,String sCityType)
  {
     txtType=sType;
     txtHRAAmt=sHRAAmt;
     txtTypeofCity=sCityType;
     //txtSrlNo=sSrlNo;
   }

 
  public String getTxtHRAAmt()
  {
    return txtHRAAmt;
  }

  public void setTxtHRAAmt(String newTxtHRAAmt)
  {
    txtHRAAmt = newTxtHRAAmt;
  }

 public String getTxtTypeofCity()
  {
    return txtTypeofCity;
  }

  public void setTxtTypeofCity(String newTxtTypeofCity)
  {
    txtTypeofCity = newTxtTypeofCity;
  }
 
  
  public String getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String newTxtType)
  {
    txtType = newTxtType;
  }

  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }

 
}