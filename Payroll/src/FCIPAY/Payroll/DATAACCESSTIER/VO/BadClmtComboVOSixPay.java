package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class BadClmtComboVOSixPay extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList ctgryList;
  private ArrayList allowTypeList;
  private ArrayList areaType;

  public BadClmtComboVOSixPay()
  {
  }

  public ArrayList getCtgryList()
  {
    return ctgryList;
  }

  public void setCtgryList(ArrayList newCtgryList)
  {
    ctgryList = newCtgryList;
  }
  
  public ArrayList getAllowTypeList()
  {
    return allowTypeList;
  }

  public void setAllowTypeList(ArrayList newAllowType)
  {
    allowTypeList = newAllowType;
  }
  
  public ArrayList getAreaType()
  {
    return areaType;
  }

  public void setAreaType(ArrayList newAreaType)
  {
    areaType = newAreaType;
  }
}