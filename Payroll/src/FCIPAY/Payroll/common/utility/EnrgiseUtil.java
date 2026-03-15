package FCIPAY.Payroll.common.utility;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
import java.sql.Timestamp;
public class EnrgiseUtil 
{

  public EnrgiseUtil()
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
    {
      return;
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
  public static boolean checkString(String oInputString)
  {
    if(oInputString == null)
    {
      return false;
    }
    
    String oString = new String(oInputString);
    
    oString = oString.trim();
    
    if(oString.equals(""))
    {
      return false;
    }
    else
    {
      return true;
    }
  }
 public static int compareDates(DateFormat dateFormat, String sOrigDate,String sRefDate) throws EnrgiseSystemException
 {
   //if( sOrigDate || null == sRefDate)
   //changed by balesh
   if(!FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(sOrigDate) || !FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(sRefDate))
   {
     return EnrgiseConstants.DATE_ERROR;
   }

   if(null == dateFormat)
   {
    dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);     
    dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
   }
   
   try
   {
    Date origDate = dateFormat.parse(sOrigDate);
    Date refDate  = dateFormat.parse(sRefDate);
    return compareDates(origDate,refDate);
   }
   catch(ParseException oParEx)
   {
     throw new EnrgiseSystemException();
   }
   
   
     
   
      
 }
 
 
 public static int compareDates(Date origDate,Date refDate)
 {
      if(null == origDate || null == refDate)
      {
        return EnrgiseConstants.DATE_ERROR;
      }
   
      if (origDate.equals(refDate))
      {
        return EnrgiseConstants.EQUAL_DATE;
      }
      else if (origDate.before(refDate))
      {
        return EnrgiseConstants.BEFORE_DATE;
      }
      else
      {
        return EnrgiseConstants.AFTER_DATE;
      }
 
  
      
 }
 
 public static int compareWithSysdate(Date origDate) throws EnrgiseSystemException
 {
   return compareDates(origDate,getSysDate());
 }

 public static int compareWithSysdate(DateFormat dateFormat,String sOrigDate) throws EnrgiseSystemException
 {
 
 // if(null == sOrigDate)  // chaged by balesh
   if(!FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(sOrigDate))
  {
    return EnrgiseConstants.DATE_ERROR;
  }
  
   if(null == dateFormat)
   {
    //dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);     
    dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
   }
   
   
   try
   {
    Date origDate = dateFormat.parse(sOrigDate);
    return compareDates(origDate,getSysDate());
   }
   catch(ParseException oParEx)
   {
     throw new EnrgiseSystemException();
   }
 }

  public static Date getSysDate() throws EnrgiseSystemException
  {
    Date sysDate = null;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
    ArrayList oList = oBean.executeQuery("SELECT sysdate FROM dual");
    
    if(null != oList)
    {
      QueryRow oRow = (QueryRow)oList.get(0);
      QueryValue oValue = oRow.get("sysDate");
      return oValue.getDate();
    }
    else
    {
      return null;
    }
    
  }
 
  public static Object getFieldValue(Object obj, String sItem) throws EnrgiseSystemException
  {
    try
    {
      Class oClass = obj.getClass();
      String sGetterMethod = getGetterMethodName(sItem);
      Method oMethod = oClass.getMethod(sGetterMethod,null);
      return oMethod.invoke(obj,null);
      
    }
    catch(NoSuchMethodException oNsEx)
    {
      throw new EnrgiseSystemException(oNsEx);
    }
    catch(IllegalAccessException oIlEx)
    {
      throw new EnrgiseSystemException(oIlEx);      
    }
    catch(InvocationTargetException oInEx)
    {
      throw new EnrgiseSystemException(oInEx);      
    }
  }
  
  public static String getGetterMethodName(String sItem)
  {
    String sFirstString = sItem.substring(0,1);
    String sRestString = sItem.substring(1);
    String sFirst = sFirstString.toUpperCase();
    return "get" + sFirst + sRestString;
    
  }
  
 public static void checkDuplicate(ArrayList oList,String sItem, String sFieldLabel, ArrayList oExceptionList, boolean bCheckStatus) throws EnrgiseSystemException
 {
 
    int index=0;
    Object oItemArray [] = null;
    String oStatusArray [] = null; // Array of detail statuses to check if the row is already deleted

    if(null == oList)
    {
      return;
    }
    
    int iSize = oList.size();
    
    if(null != sItem)
    {
      oItemArray = (Object [])Array.newInstance(sItem.getClass(),iSize);
      if(bCheckStatus)
      {
        oStatusArray = (String [])Array.newInstance(sItem.getClass(),iSize);        
      }
    }
    else
    {
      oItemArray = (Object [])Array.newInstance(oList.get(0).getClass(),iSize);      
    }
    
    
    // Pack the values inside an array
    // Use to save the overhead out of reflection
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        Object obj = oIt.next();
        if(null != sItem)
        {
          oItemArray[index] = (String)FCIPAY.Payroll.common.utility.EnrgiseUtil.getFieldValue(obj,sItem);
          oStatusArray[index++] = (String)FCIPAY.Payroll.common.utility.EnrgiseUtil.getFieldValue(obj,EnrgiseConstants.STATUS);
        }
        else
        {
          // No particular item mentioned the object itself is compared
          oItemArray[index++] = obj;                            
        }
    }

    for(int iSource = 0; iSource < iSize; ++iSource)
    {
      //Check if null
      if(null == oItemArray[iSource])
      {
        continue;
      }
      
      if(null != oStatusArray[iSource] && oStatusArray[iSource].equals(EnrgiseConstants.DELETE_MODE))
      {
        continue;
      }
      
      for(int iTarget = iSource + 1; iTarget < iSize; ++iTarget)
      {
          if(null != oItemArray[iTarget])
          {
            if(null != oStatusArray && oStatusArray[iTarget].equals(EnrgiseConstants.DELETE_MODE))
            {
              // Detail Field is compared, so compare status
              continue;
            }
            if(compareObject(oItemArray[iSource],oItemArray[iTarget]))
            {
              ArrayList oArgList = new ArrayList();
              Integer oRow = new Integer(iSource+1);
              // Check if field label passed
              if(null != sFieldLabel)
              {
                oArgList.add(sFieldLabel);
                oArgList.add(oRow);
                oExceptionList.add(new EnrgiseApplicationException("wenrgise.common.field.duplicatefound",oArgList));
              }
              else
              {
                oArgList.add(oRow);
                oExceptionList.add(new EnrgiseApplicationException("wenrgise.common.duplicatefound",oArgList));                
              }
            }
          }
      }
    }
  }
        
private static boolean compareObject(Object oSource, Object oTarget)
{
  // Check if string
  if(oSource.getClass().getName().equals("java.lang.String"))
  {
    // String requires special treatment
    String sSource = ((String)oSource).trim();
    String sTarget = ((String)oTarget).trim();
    
    if(sSource.equalsIgnoreCase(sTarget))
    {
      return true;
    }
  }
  else
  {
    // Another object
    if(oSource.equals(oTarget))
    {
      return true;
    }
  }
  
    return false;
 }
 
  public static Timestamp convertToSqlDate(String sDate) throws EnrgiseSystemException
  {
  
    //if(null == sDate)  //Changed by balesh
    if(!FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(sDate))
    {
      return null;
    }
    
    //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    
    try
    {
      Date oDate = dateFormat.parse(sDate);
      return new Timestamp(oDate.getTime());
    }
   catch(ParseException oParEx)
   {
     throw new EnrgiseSystemException();
   }
  }
  
  public static String convertToString(Date oDate)
  {
    return (null != oDate)?(new SimpleDateFormat("dd-MMM-yyyy")).format(oDate):null;
  }

  public static String changeDateFormat(String strFormat1,String strFormat2,String sDate) throws EnrgiseSystemException
  {
    if(!FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(sDate))
    {
      return null;
    }
    
    //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    DateFormat dateFormat1 = new SimpleDateFormat(strFormat1);
    DateFormat dateFormat2 = new SimpleDateFormat(strFormat2);
    
    try
    {
      Date oDate = dateFormat1.parse(sDate);
      return dateFormat2.format(oDate);
    }
   catch(ParseException oParEx)
   {
     throw new EnrgiseSystemException();
   }
    
  }

}