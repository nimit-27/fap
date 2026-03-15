package FCIPAY.Payroll.common.bean;
import java.io.Serializable;
import FCIPAY.Payroll.common.bean.BaseBean;
public class BaseDetailBean extends BaseBean implements Serializable
{
  String detailId = null;
  String status = null;
  //boolean checked = false;
  String itemChecked = "N";
  
  public BaseDetailBean()
  {
  }

  public String getDetailId()
  {
    return detailId;
  }

  public void setDetailId(String newDetailId)
  {
    detailId = newDetailId;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String newStatus)
  {
    status = newStatus;
  }

/*
  public boolean isChecked()
  {
    return checked;
  }

  public void setChecked(boolean newChecked)
  {
    checked = newChecked;
  }
*/
  public String getItemChecked()
  {
    return itemChecked;
  }

  public void setItemChecked(String newItemChecked)
  {
    itemChecked = newItemChecked;
  }
}