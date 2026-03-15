package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
public class MaintCityTypeBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtCityType="";
  private String txtDesc="";
  private String txtCities="";

  public MaintCityTypeBean()
  {
  }
 public MaintCityTypeBean( String sCityType,String sDesc,String sCities)
  {
  txtCityType=sCityType;
  txtDesc=sDesc;
  txtCities=sCities;
  }
  public String getTxtCityType()
  {
    return txtCityType;
  }

  public void setTxtCityType(String newTxtCityType)
  {
    txtCityType = newTxtCityType;
  }

  public String getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String newTxtDesc)
  {
    txtDesc = newTxtDesc;
  }

  public String getTxtCities()
  {
    return txtCities;
  }

  public void setTxtCities(String newTxtCities)
  {
    txtCities = newTxtCities;
  }
}