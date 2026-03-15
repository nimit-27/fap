package FCIPAY.Payroll.EJB.common.facade;
import java.rmi.RemoteException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import java.util.ArrayList;
import FCIPAY.Payroll.common.xml.vo.LOV;
import javax.ejb.EJBObject;


public interface CommonFacade extends EJBObject 
{
  ArrayList getLOVData(LOV oLOV,String sSearchCondition) throws RemoteException, EnrgiseSystemException;
}