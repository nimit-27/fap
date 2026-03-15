package FCIPAY.Payroll.EJB.facade;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface PayrollNewFacadeHome extends EJBHome 
{
  PayrollNewFacade create() throws RemoteException, CreateException;
}