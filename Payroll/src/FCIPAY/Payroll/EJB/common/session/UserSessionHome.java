package FCIPAY.Payroll.EJB.common.session;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface UserSessionHome extends EJBHome 
{
  UserSession create() throws RemoteException, CreateException;
}