package FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates;

/*
* Module:        LeaveMastBD.java
* Author:        Moon Nag Sarkar
* Date Written:  14/09/2003
* Description:    This class calls corresponding to Data Access objects to send and retrieve value objects to the database.  
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/

import FCIPAY.HRMS.DATAACCESSTIER.VO.LeaveMastVO;
import FCIPAY.HRMS.DATAACCESSTIER.DAO.LeaveMastDAO;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.*;


public class LeaveMastBD 
{
        public LeaveMastBD()
        {
        }


    /**
        * Method inserts/updates details.
        * @piProcessFlag flag to determine whether it's update or insert mode.
        * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown    
        * @true -on success   
        * @false -on failure
        */

      LeaveMastDAO oLeaveMastDAO;

        ArrayList oLeaveMastVOs=null;

  
      public boolean setDetails(LeaveMastVO poLeaveMastVO,int piProcessFlag) throws IBAException,IBABusinessException,IBAFatalException
      {
      
          oLeaveMastDAO=new LeaveMastDAO();    
          if(oLeaveMastDAO.setVO(poLeaveMastVO,piProcessFlag))
            {  
              return true;
            } 
          else
            {
              return false;
            }

      }

    /**
        * Calls the DAO to Retrieve the directorate details for specific directorate type.
        * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown.    
        * @Arraylist of object.   
        */


    
    public ArrayList getLeaveDetails()
    {


       try
      {
        oLeaveMastDAO=new LeaveMastDAO();
        oLeaveMastVOs=oLeaveMastDAO.getLeaveDetails();
        
        return oLeaveMastVOs;
      }
      catch(Exception e)
      {
        e.printStackTrace();
         return oLeaveMastVOs;
    
      }

  
    }
    /**
        * Calls the DAO to Retrieve the  details.
        * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown.    
        * @Arraylist of object.   
        */



    public ArrayList getDetails()throws IBAException,IBABusinessException,IBAFatalException
    {
      ArrayList oLeaveMastVOs=null;
      try
      {
        oLeaveMastDAO=new LeaveMastDAO();
        oLeaveMastVOs=oLeaveMastDAO.getDetails();
     
        return oLeaveMastVOs;
      }
      catch(Exception e)
      {
        e.printStackTrace();
         return oLeaveMastVOs;
    
      }
    }




}