package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class CCAComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList cityList;
  private ArrayList ctgryList;

  public CCAComboVO()
  {
  }

  public ArrayList getCityList()
  {
    return cityList;
  }
  
  public void setCityList(ArrayList newCityList)
  {
    cityList = newCityList;
  }
  
  public void setCtgryList(ArrayList newCtgryList)
  {
    ctgryList = newCtgryList;
  }
  
    public ArrayList getCtgryList()
  {
    return ctgryList;
  }



}