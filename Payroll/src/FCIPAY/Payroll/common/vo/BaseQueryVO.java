package FCIPAY.Payroll.common.vo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.io.Serializable;
public class BaseQueryVO implements Serializable 
{
  private long positionRequested = 0;
  private String headerPrimaryKey = null;
  private int maxHeaderSize = 0;
  private long userId;
  private long siteId;
  private long loginLocCode = 0;
  private String hdnEmpLbrFlag;
  private String txtLocId;
  
  public BaseQueryVO()
  {
  }

  public long getPositionRequested()
  {
    return positionRequested;
  }

  public void setPositionRequested(long newPositionRequested)
  {
    positionRequested = newPositionRequested;
  }

  public String getHeaderPrimaryKey()
  {
    return headerPrimaryKey;
  }

  public void setHeaderPrimaryKey(String newHeaderPrimaryKey)
  {
    headerPrimaryKey = newHeaderPrimaryKey;
  }

  public int getMaxHeaderSize()
  {
    return maxHeaderSize;
  }

  public void setMaxHeaderSize(int newMaxHeaderSize)
  {
    maxHeaderSize = newMaxHeaderSize;
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

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }
    
    public String getTxtLocId() {
        return txtLocId;
    }
}