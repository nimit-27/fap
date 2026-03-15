package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class HraComboVO extends PayrollBaseQueryVO implements Serializable
{
 private ArrayList cityList;
  public HraComboVO()
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
}