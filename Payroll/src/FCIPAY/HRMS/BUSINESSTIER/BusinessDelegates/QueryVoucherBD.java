/* 
 * Module:        QueryVoucherBD.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This class acts as a mediator between QueryVoucherAction and QueryVoucherDAO.
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates;

import java.sql.SQLException;
import java.util.ArrayList;

import FCIPAY.HRMS.DATAACCESSTIER.DAO.QueryVoucherDAO;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;


public class QueryVoucherBD 
{

   private QueryVoucherDAO oQueryVoucherDAO=null;

   /**
    *  Method        Constructor
    *  Description   Creates objects of QueryVoucherDAO
    */
   public QueryVoucherBD()
   {
      oQueryVoucherDAO=new QueryVoucherDAO();
   }

   /**
    *  Method        Calls getQueryResults_DAO
    *  @Exception    throws IBAFatalException,IBABusinessException,SQLException,Exception
    *  @param1       Employee No
    *  @param2       Location Id
    *  @param3       ArrayList To Store The Result
    *  @return       No of Rows Affected
    */
   public int getQueryResults_BD(long empNo,long locId,String qry,ArrayList searchList) throws IBAFatalException,IBABusinessException,SQLException,Exception
   {
      int retVal=0;
      retVal=oQueryVoucherDAO.getQueryResults_DAO(empNo,locId,qry,searchList);
      return retVal;
   }
}