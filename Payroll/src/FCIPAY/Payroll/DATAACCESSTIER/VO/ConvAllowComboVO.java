package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;


public class ConvAllowComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList cityList;
  private ArrayList payScaleList;
  private ArrayList categoryList;

  public ConvAllowComboVO()
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

  public ArrayList getPayScaleList()
  {
    return payScaleList;
  }

  public void setPayScaleList(ArrayList newPayScaleList)
  {
    payScaleList = newPayScaleList;
  }
  
  public ArrayList getCategoryList()
  {
    return categoryList;
  }

  public void setCategoryList(ArrayList newCategoryList)
  {
    categoryList = newCategoryList;
  }
}