package FCIPAY.Payroll.common.vo;
import java.util.ArrayList;
import java.io.Serializable;

public class LovVO implements Serializable
{
  private ArrayList detailList;
  private ArrayList headerList;
  private ArrayList visibilityList;

  public LovVO()
  {
  }

  public ArrayList getDetailList()
  {
    return detailList;
  }

  public void setDetailList(ArrayList newDetailList)
  {
    detailList = newDetailList;
  }


  public ArrayList getHeaderList()
  {
    return headerList;
  }

  public void setHeaderList(ArrayList newHeaderList)
  {
    headerList = newHeaderList;
  }

  public ArrayList getVisibilityList()
  {
    return visibilityList;
  }

  public void setVisibilityList(ArrayList newVisibilityList)
  {
    visibilityList = newVisibilityList;
  }
}
