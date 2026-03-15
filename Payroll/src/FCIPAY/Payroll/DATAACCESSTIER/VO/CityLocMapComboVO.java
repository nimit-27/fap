package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class CityLocMapComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList cityTypList;
    private ArrayList areaTypList;
    private ArrayList popTypList;
    private ArrayList tranCityTypList;  //added by Swapnendu Dt 27 -Aug 2010.
    private ArrayList mgwCityTypList;  //added by Swapnendu Dt 26 Apr 2011.
    
    public CityLocMapComboVO()
    {
    }
    
    public ArrayList getCityTypList()
    {
      return cityTypList;
    }
  
    public void setCityTypList(ArrayList newCityTypList)
    {
      cityTypList = newCityTypList;
    }

    public ArrayList getAreaTypList()
    {
      return areaTypList;
    }
  
    public void setAreaTypList(ArrayList newAreaTypList)
    {
      areaTypList = newAreaTypList;
    }
    
    public ArrayList getPopTypList()
    {
      return popTypList;
    }
  
    public void setPopTypList(ArrayList newPopTypList)
    {
      popTypList = newPopTypList;
    }
    
    public ArrayList getTranCityTypList()
    {
      return tranCityTypList;
    }
  
    public void setTranCityTypList(ArrayList newTranCityTypList)
    {
      tranCityTypList = newTranCityTypList;
    }
    
    public ArrayList getMgwCityTypList()
    {
      return mgwCityTypList;
    }
  
    public void setMgwCityTypList(ArrayList newMgwCityTypList)
    {
      mgwCityTypList = newMgwCityTypList;
    }
  
}