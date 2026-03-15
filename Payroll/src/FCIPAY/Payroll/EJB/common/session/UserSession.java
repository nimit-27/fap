package FCIPAY.Payroll.EJB.common.session;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.utility.UserInfo;
import java.util.Locale;
import java.text.DateFormat;


public interface UserSession extends EJBObject 
{
  public void removeAllIfExists(String sFormName, String sScreenName) throws RemoteException;
  public void putBaseHeaderVO(String sFormName, BaseHeaderVO oBaseHeaderVO) throws RemoteException;
  public void putBaseQueryVO(String sFormName, BaseQueryVO oBaseQueryVO) throws RemoteException;
  public void putBaseDetailVO(String sFormName, String sScreenName,BaseDetailVO oBaseDetailVO) throws RemoteException;
  public BaseHeaderVO getBaseHeaderVO(String sFormName) throws RemoteException;
  public BaseQueryVO getBaseQueryVO(String  sFormName) throws  RemoteException;
  public BaseDetailVO getBaseDetailVO(String sFormName, String sScreenName) throws RemoteException;
  public UserInfo getUserInfo() throws RemoteException;
  public void setUserInfo(UserInfo newUserInfo) throws RemoteException;
  public Locale getUserLocale() throws RemoteException;
  public void setUserLocale(Locale oUserLocale) throws RemoteException;
  public Locale getDefaultLocale() throws RemoteException;
  public DateFormat getUserDateFormat() throws RemoteException;
  public DateFormat getDefaultDateFormat() throws RemoteException;
}