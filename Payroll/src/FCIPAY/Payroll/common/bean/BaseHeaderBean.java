package FCIPAY.Payroll.common.bean;
import java.io.Serializable;
import FCIPAY.Payroll.common.bean.BaseBean;
public class BaseHeaderBean extends BaseBean implements Serializable
{
  private String headerPrimaryKey = null;
  public BaseHeaderBean()
  {
  }

  public String getHeaderPrimaryKey()
  {
    return headerPrimaryKey;
  }

  public void setHeaderPrimaryKey(String newHeaderPrimaryKey)
  {
    headerPrimaryKey = newHeaderPrimaryKey;
  }
}