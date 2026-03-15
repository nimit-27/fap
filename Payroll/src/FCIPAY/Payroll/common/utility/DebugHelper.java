package FCIPAY.Payroll.common.utility;
import FCIPAY.Payroll.common.utility.ParamUtil;
import javax.servlet.http.HttpSession;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.EJB.common.session.UserSessionHome;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.xml.vo.*;
import java.rmi.RemoteException;
public class DebugHelper 
{
  public DebugHelper()
  {
  }
  
  public static void createUserEjb(HttpSession session) throws EnrgiseSystemException
  {
    try
    {
      UserSession oUser = (UserSession)session.getAttribute(FCIPAY.Payroll.common.utility.ParamUtil.getSessionBeanName());
      if(oUser == null)
      {
        UserSessionHome oUserHome = (UserSessionHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("UserSession");
        oUser = oUserHome.create();
        session.setAttribute(FCIPAY.Payroll.common.utility.ParamUtil.getSessionBeanName(),oUser);
        
      }
    }
    catch(RemoteException oRmt)
    {      
      throw new EnrgiseSystemException();
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException();
    }
    catch(Exception oExCc)
    {
      oExCc.printStackTrace();
      throw new EnrgiseSystemException();
    }
  }
}