package FCIPAY.Payroll.EJB.common.helper;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import java.util.HashMap;
import java.io.Serializable;
public class ScreenWrapper   implements Serializable 
{
  private BaseHeaderVO oBaseHeaderVO = null;
  private BaseQueryVO oBaseQueryVO = null;
  private HashMap oScreenMap = null;
  public ScreenWrapper()
  {
    oScreenMap = new HashMap();
  }

  public BaseHeaderVO getOBaseHeaderVO()
  {
    return oBaseHeaderVO;
  }

  public void setOBaseHeaderVO(BaseHeaderVO newOBaseHeaderVO)
  {
    oBaseHeaderVO = newOBaseHeaderVO;
  }

  public BaseQueryVO getOBaseQueryVO()
  {
    return oBaseQueryVO;
  }

  public void setOBaseQueryVO(BaseQueryVO newOBaseQueryVO)
  {
    oBaseQueryVO = newOBaseQueryVO;
  }

  public HashMap getOScreenMap()
  {
    return oScreenMap;
  }

  public void setOScreenMap(HashMap newOScreenMap)
  {
    oScreenMap = newOScreenMap;
  }
}