package FCIPAY.Payroll.EJB.common.facade;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.EJB.common.facade.CommonFacade;

public interface CommonFacadeHome extends EJBHome 
{
  CommonFacade create() throws RemoteException, CreateException;
}