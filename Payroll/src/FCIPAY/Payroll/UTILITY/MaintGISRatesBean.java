package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintGISRatesBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtGroup="";
  private String txtRate="";
  private String txtEffDate="";

  public MaintGISRatesBean()
  {
  }

  public MaintGISRatesBean(String group,String rate,String effDate)
  {
    
      txtGroup=group;
      txtRate=rate;
      txtEffDate=effDate;
      
  }

  public String getTxtGroup()
  {
    return txtGroup;
  }

  public void setTxtGroup(String newTxtGroup)
  {
    txtGroup = newTxtGroup;
  }

  public String getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String newTxtRate)
  {
    txtRate = newTxtRate;
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