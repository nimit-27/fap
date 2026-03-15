package FCIPAY.Payroll.EJB.facade;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface PayrollFacadeHome extends EJBHome 
{
  PayrollFacade create() throws RemoteException, CreateException;
}