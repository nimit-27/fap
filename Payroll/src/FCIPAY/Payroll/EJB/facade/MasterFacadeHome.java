package FCIPAY.Payroll.EJB.facade;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MasterFacadeHome extends EJBHome 
{
  MasterFacade create() throws RemoteException, CreateException;
}