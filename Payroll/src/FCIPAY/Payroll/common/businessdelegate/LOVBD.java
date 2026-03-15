package FCIPAY.Payroll.common.businessdelegate;
import FCIPAY.Payroll.common.xml.vo.*;
import java.util.ArrayList;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.xml.vo.LOVInfo;
import FCIPAY.Payroll.common.vo.LovVO;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;
import FCIPAY.Payroll.common.vo.LovQueryVO;

public class LOVBD
{
  public LOVBD()
  {
  }
 
 public LovVO getLOVData(LOVInfo oLOVInfo, LovQueryVO oLOVQueryVO) throws EnrgiseSystemException
  {
    try
    {      
      String sFacadeName=oLOVInfo.getFacadeName();
      System.out.println(sFacadeName);
      Object obj = FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sFacadeName);
      Method oMethod = obj.getClass().getDeclaredMethod("create",null);
      Object oFacadeObj = oMethod.invoke(obj,null);
      Class[] oCls={oLOVQueryVO.getClass()};
      Method oFnMethod = oFacadeObj.getClass().getDeclaredMethod(oLOVInfo.getFunctionName(),oCls); 
      Object[] oParams={oLOVQueryVO};
      LovVO oLovVO=(LovVO)oFnMethod.invoke(oFacadeObj, oParams);
      return oLovVO;
    }
    catch(InvocationTargetException oInv)
    {
      throw new EnrgiseSystemException(oInv);      
    }
    catch(IllegalAccessException oIll)
    {
      throw new EnrgiseSystemException(oIll);      
    }
    catch(NoSuchMethodException oMet)
    {
      throw new EnrgiseSystemException(oMet);      
    }
  }
}
