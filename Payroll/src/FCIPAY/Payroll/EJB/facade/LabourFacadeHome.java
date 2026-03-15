package FCIPAY.Payroll.EJB.facade;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface LabourFacadeHome extends EJBHome
{
  LabourFacade create() throws RemoteException, CreateException;
}