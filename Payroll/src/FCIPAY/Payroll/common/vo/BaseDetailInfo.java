package FCIPAY.Payroll.common.vo;
import java.io.Serializable;
public class BaseDetailInfo implements Serializable
{
  private long userId;
  private long siteId;
  private long loginLocCode = 0;
  private String hdnEmpLbrFlag;

  public BaseDetailInfo()
  {
  }

  public long getUserId()
  {
    return userId;
  }

  public void setUserId(long newUserId)
  {
    userId = newUserId;
  }

  public long getSiteId()
  {
    return siteId;
  }

  public void setSiteId(long newSiteId)
  {
    siteId = newSiteId;
  }
  
  public long getLoginLocCode()
  {
    return loginLocCode;
  }

  public void setLoginLocCode(long newLoginLocCode)
  {
    loginLocCode = newLoginLocCode;
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