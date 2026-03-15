/*
 * Module       : CommonSearchScreenBD.java
 * Author       : S.MUTHU SUBRAMANIAM
 * Date Written : 04/11/2003
 * Description  : This class is used by CommonSearchScreenAction.java
 * Revision Log :   /  /2003
 *-------------------------------------------------------
*/
package FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates;

import java.sql.SQLException;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.CommonSearchScreenDAO;

public class CommonSearchScreenBD 
{
   private CommonSearchScreenDAO oCommonSearchScreenDAO=null;
   
   public CommonSearchScreenBD() throws IBAFatalException
   {
      oCommonSearchScreenDAO=new CommonSearchScreenDAO();
   }
   
   /**
    * This Method Calls the SearchRecords_DAO method of CommonSearchScreenDAO 
    * @param       : String Id                  First Column Name  (In the query that is being constructed)
    * @param       : String Desc                Second Column Name (In the query that is being constructed)
    * @param       : String TableName           Table Name
    * @param       : String IdValue             First Column Value
    * @param       : String DescValue           Second Column Value
    * @param       : ArrayList lstSearchResult  ArrayList to hold the Search Results
    * @exception   : throws IBAFatalException,IBABusinessException,SQLException,Exception
    * @return      : return the Total number (Count) of search rows.
   */
   
   public int SearchRecords_BD(String Id,String Desc,String TableName,String IdValue,String DescValue,String AddCond,ArrayList lstSearchResult) throws IBAFatalException, IBABusinessException, SQLException, Exception  
   {
      String sQuery="";
      sQuery="SELECT " + Id + ", " + Desc + " FROM " + TableName;
//      System.out.println("In BD Query="+sQuery+ "  ADD COND=" + AddCond);
      int retVal=oCommonSearchScreenDAO.SearchRecords_DAO(sQuery,Id,Desc,IdValue,DescValue,AddCond,lstSearchResult);
      return retVal;      
   }
}

