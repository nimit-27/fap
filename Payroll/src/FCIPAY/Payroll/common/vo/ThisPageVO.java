package FCIPAY.Payroll.common.vo;
import java.io.Serializable;

import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.BaseVO;
public class ThisPageVO extends BaseVO implements Serializable 
{
  private BaseHeaderBean oHeaderBean;
  private ArrayList oDetailList;
  //Added by Balesh//
  private String screenMode;
  private String screenName;
  private int actionName;
   //Added by Balesh//
  public ThisPageVO()
  {
  }

  public BaseHeaderBean getOHeaderBean()
  {
    return oHeaderBean;
  }

  public void setOHeaderBean(BaseHeaderBean newOHeaderBean)
  {
    oHeaderBean = newOHeaderBean;
  }

  public ArrayList getODetailList()
  {
    return oDetailList;
  }

  public void setODetailList(ArrayList newODetailList)
  {
    oDetailList = newODetailList;
  }

  public String getScreenMode()
  {
    return screenMode;
  }

  public void setScreenMode(String newScreenMode)
  {
    screenMode = newScreenMode;
  }

  public String getScreenName()
  {
    return screenName;
  }

  public void setScreenName(String newScreenName)
  {
    screenName = newScreenName;
  }

  public int getActionName()
  {
    return actionName;
  }

  public void setActionName(int newActionName)
  {
    actionName = newActionName;
  }
  
}
