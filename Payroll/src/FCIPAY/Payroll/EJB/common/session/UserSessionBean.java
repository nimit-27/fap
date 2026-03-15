package FCIPAY.Payroll.EJB.common.session;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.HashMap;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.utility.UserInfo;
import FCIPAY.Payroll.EJB.common.helper.ScreenWrapper;
import java.util.Locale;
import java.text.DateFormat;

	public class UserSessionBean implements SessionBean 
{
  private SessionContext context;
  private UserInfo userInfo;
  private HashMap oFormMap = new HashMap();
  private Locale oUserLocale;
  private Locale oDefaultLocale = Locale.getDefault();
  
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
    this.context = ctx;
  }
  public void removeAllIfExists(String sFormName, String sScreenName)
  {
    HashMap oScreenMap = (HashMap)oFormMap.get(sFormName);
    if(oScreenMap == null)
    {
      return;
    }
    oFormMap.remove(sFormName);
  }
  private ScreenWrapper getScreenWrapper(String sFormName)
  {    
    ScreenWrapper oScreenWrapper = (ScreenWrapper)oFormMap.get(sFormName);
    if(oScreenWrapper == null)
    {
      oScreenWrapper = new ScreenWrapper();
      oFormMap.put(sFormName,oScreenWrapper);
    }
    
    return oScreenWrapper;
  }
  
  private HashMap getScreenMap(String sFormName)
  {
    ScreenWrapper oScreenWrapper = getScreenWrapper(sFormName);
    HashMap oScreenMap = oScreenWrapper.getOScreenMap();
    if(oScreenMap == null)
    {
      oScreenMap = new HashMap();
      oScreenWrapper.setOScreenMap(oScreenMap);
    }
    return oScreenMap;
  }
  public void putBaseHeaderVO(String sFormName, BaseHeaderVO oBaseHeaderVO)
  {
    getScreenWrapper(sFormName).setOBaseHeaderVO(oBaseHeaderVO);
  }
  public void putBaseQueryVO(String sFormName, BaseQueryVO oBaseQueryVO)
  {
    getScreenWrapper(sFormName).setOBaseQueryVO(oBaseQueryVO);
  }
  public void putBaseDetailVO(String sFormName, String sScreenName,BaseDetailVO oBaseDetailVO)
  {
    getScreenMap(sFormName).put(sScreenName,oBaseDetailVO);
  }
  public BaseHeaderVO getBaseHeaderVO(String sFormName)
  {
    ScreenWrapper oScreenWrapper = (ScreenWrapper)oFormMap.get(sFormName);
    if(oScreenWrapper == null)
    {
      return null;
    }
    
    return (BaseHeaderVO)oScreenWrapper.getOBaseHeaderVO();
    
  }
  public BaseQueryVO getBaseQueryVO(String  sFormName)
  {
    ScreenWrapper oScreenWrapper = (ScreenWrapper)oFormMap.get(sFormName);
    if(oScreenWrapper == null)
    {
      return null;
    }
    
    return (BaseQueryVO)oScreenWrapper.getOBaseQueryVO();
    
  }
  public BaseDetailVO getBaseDetailVO(String sFormName, String sScreenName)
  {
    ScreenWrapper oScreenWrapper = (ScreenWrapper)oFormMap.get(sFormName);
    if(oScreenWrapper == null)
    {
      return null;
    }
    
    
    return (BaseDetailVO)oScreenWrapper.getOScreenMap().get(sScreenName);
    
  }

  public UserInfo getUserInfo()
  {
    return userInfo;
  }

  public void setUserInfo(UserInfo newUserInfo)
  {
    userInfo = newUserInfo;
  }
  public Locale getUserLocale()
  {
    return oUserLocale;
  }
  public void setUserLocale(Locale oUserLocale)
  {
    if(oUserLocale == null)
    {
      oUserLocale = oDefaultLocale;
    }
  }
  public Locale getDefaultLocale()
  {
    return oDefaultLocale;  
  }

  public DateFormat getUserDateFormat()
  {
    if(oUserLocale != null)
    {
      return DateFormat.getDateInstance(DateFormat.MEDIUM,oUserLocale);
    }
    else
    {
      return DateFormat.getDateInstance();
    }
  }
  public DateFormat getDefaultDateFormat()
  {
    if(oDefaultLocale != null)
    {
      return DateFormat.getDateInstance(DateFormat.MEDIUM,oDefaultLocale);
    }
    else
    {
      return DateFormat.getDateInstance();
    }
    
  }
}