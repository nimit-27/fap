package FCIPAY.Payroll.UTILITY;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.io.Serializable;

public class PayrollBaseHeaderBean extends BaseHeaderBean implements Serializable
{
  private String txtUserID;
  private String txtSiteID;
  private String hdnEmpLbrFlag;

  public PayrollBaseHeaderBean()
  {
  }

  public String getTxtUserID()
  {
    return txtUserID;
  }

  public void setTxtUserID(String newTxtUserID)
  {
    txtUserID = newTxtUserID;
  }

  public String getTxtSiteID()
  {
    return txtSiteID;
  }

  public void setTxtSiteID(String newTxtSiteID)
  {
    txtSiteID = newTxtSiteID;
  }

  public String getHdnEmpLbrFlag()
  {
    return hdnEmpLbrFlag;
  }

  public void setHdnEmpLbrFlag(String newHdnEmpLbrFlag)
  {
    hdnEmpLbrFlag = newHdnEmpLbrFlag;
  }
}