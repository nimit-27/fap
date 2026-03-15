package FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates;

/*
* Module:        VenueMastBD.java
* Author:        Moon Nag Sarkar
* Date Written:  14/09/2003
* Description:    This class calls corresponding to Data Access objects to send and retrieve value objects to the database.  
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
import FCIPAY.HRMS.DATAACCESSTIER.VO.VenueMastVo;
import FCIPAY.HRMS.DATAACCESSTIER.DAO.VenueMastDAO;
import java.util.ArrayList;
import java.util.HashMap;
import FCIPAY.COMMON.UTILITY.*;


public class VenueMastBD 
{
 /**
    * Method inserts/updates details.
    * @piProcessFlag flag to determine whether it's update or insert mode.
    * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown    
    * @true -on success   
    * @false -on failure
    */

  VenueMastDAO oVenueMastDao;
   ArrayList oVenueMastVos=null;
  
  public boolean setDetails(VenueMastVo poVenueMastVo,int piProcessFlag)throws IBAException,IBABusinessException,IBAFatalException
  {
  
      oVenueMastDao=new VenueMastDAO();    
      if(oVenueMastDao.setVo(poVenueMastVo,piProcessFlag))
        {  
          return true;
        } 
      else
        {
          return false;
        }
    
   
  }



public ArrayList getVenueDetails()
{


   try
  {
    oVenueMastDao=new VenueMastDAO();
    oVenueMastVos=oVenueMastDao.getVenueDetails();
  
    return oVenueMastVos;
  }
  catch(Exception e)
  {
    e.printStackTrace();
     return oVenueMastVos;
    
  }

  
}








public ArrayList getUnitDetails()
{System.out.print("BDget");
  ArrayList oVenueMastVos=null;
   try
  {
    oVenueMastDao=new VenueMastDAO();
    oVenueMastVos=oVenueMastDao.getUnitDetails();
    System.out.println(oVenueMastVos.size()+"Business"); 
    return oVenueMastVos;
  }
  catch(Exception e)
  {
    e.printStackTrace();
     return oVenueMastVos;
    
  }

  
}
/**
    * Calls the DAO to Retrieve the  details.
    * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown.    
    * @Arraylist of object.   
    */
public ArrayList getDetails()throws IBAException,IBABusinessException,IBAFatalException
{
  System.out.print("BDget");
  ArrayList oVenueMastVos=null;
  try
  {
    oVenueMastDao=new VenueMastDAO();
    oVenueMastVos=oVenueMastDao.getDetails();
    System.out.println(oVenueMastVos.size()+"Business"); 
    return oVenueMastVos;
  }
  catch(Exception e)
  {
    e.printStackTrace();
     return oVenueMastVos;
    
  }
}
  
}