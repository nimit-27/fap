package FCIPAY.Payroll.common.utility;
import java.util.ArrayList;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import java.lang.reflect.Field;
public class ArrayListUtil 
{
  public ArrayListUtil()
  {
  }
  
  public static void pageArrayCopier(ArrayList oSource,ArrayList oDest,int iSourcePos, int iLength) throws EnrgiseSystemException
  {
      
    if(oSource == null)
    {
      throw new EnrgiseSystemException();
    }
    
    if(oDest == null)
    {
      throw new EnrgiseSystemException();
    }
    
    if(iLength < 0)
    {      
      return;
    }
    
    if(oSource.size() < iSourcePos + iLength)
    {iLength=oSource.size();
     // return;
    }
    
    oDest.clear();
    for(int iIndex = iSourcePos; iIndex < iSourcePos + iLength;++iIndex)
    {
      oDest.add(oSource.get(iIndex));
    }
  }
  
  public static ArrayList addToList(ArrayList oList, Object [] obj)
  {
    for(int i = 0; i < obj.length; ++i)
    {
      oList.add(obj[i]);
    }
    
    return oList;
  }
}