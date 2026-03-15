package FCIPAY.Payroll.common.utility;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.EJB.common.session.UserSessionHome;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.utility.UserInfo;
import java.util.Locale;
import FCIPAY.Payroll.common.utility.ServiceLocator;

public class EnrgiseListener implements HttpSessionListener
{

  public EnrgiseListener()
  {
  }
  
  
  public void sessionCreated(HttpSessionEvent sEvent)
  {
    try
    {
      HttpSession session = sEvent.getSession();
      UserSession oUser = (UserSession)session.getAttribute(FCIPAY.Payroll.common.utility.ParamUtil.getSessionBeanName());
      if(oUser == null)
      {
        UserSessionHome oUserHome = (UserSessionHome)ServiceLocator.getLocator().getService("UserSession");
        oUser = oUserHome.create();
        UserInfo oUserInfo = new UserInfo();
        //oUserInfo.setSite_id("200");
        //oUserInfo.setUser_id("420");
        //oUserInfo.setCurrentYear("2008");
        oUser.setUserInfo(oUserInfo);
        Locale oLocale = (Locale)session.getAttribute("locale");
        oUser.setUserLocale((Locale)session.getAttribute("locale"));
        session.setAttribute(FCIPAY.Payroll.common.utility.ParamUtil.getSessionBeanName(),oUser);
        
      }
    }
    catch(RemoteException oRmt)
    {
    }
    catch(CreateException oCrt)
    {
    }
    catch(Exception oExCc)
    {
    }

  }
  
  public void sessionDestroyed(HttpSessionEvent sEvent)
  {
    try
    {
      HttpSession session = sEvent.getSession();
      if(session != null)
      {
        UserSession oUser = (UserSession)session.getAttribute(FCIPAY.Payroll.common.utility.ParamUtil.getSessionBeanName());
        oUser.remove();
      }
      
    }
    catch(RemoveException oEx)
    {
      
    }
    catch(RemoteException oExc)
    {
      
    }
  }
}