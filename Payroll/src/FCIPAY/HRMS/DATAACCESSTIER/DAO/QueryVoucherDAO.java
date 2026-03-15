/* 
 * Module:        QueryVoucherDAO.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This class connects to the database and gets called from QueryVoucherBD.
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.DATAACCESSTIER.DAO;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import oracle.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.driver.*;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.HRMS.UTILITY.QueryBean;
import FCIPAY.HRMS.DATAACCESSTIER.SQLQueries.CommonVoucherQueries;

public class QueryVoucherDAO 
{
   private Connection conn=null;
   private DSConnect dsConn=null;
   private ResultSet rSet=null;
   private PreparedStatement pSt=null;
   private CommonVoucherQueries  oCommonVoucherQueries=null;

   /**
    *  Method        Constructor
    *  Description   Creates objects of DSConnect and CommonVoucherQueries
    */
   public QueryVoucherDAO()
   { try {
      dsConn=new DSConnect();       }
      catch(Exception e) {}
      oCommonVoucherQueries=new CommonVoucherQueries();
   }

   /**
    *  Method        Retrieves all the records according to the query
    *  @Exception    throws IBAFatalException,IBABusinessException,SQLException,Exception
    *  @param1       Employee No
    *  @param2       Location Id
    *  @param3       Query
    *  @param4       ArrayList To Store The Result
    *  @return       No of Rows Affected
    */
   public int getQueryResults_DAO(long empNo,long locId,String qry,ArrayList searchList) throws IBAFatalException,IBABusinessException,SQLException,Exception  
   {
      int retVal=0;
      String sQuery=oCommonVoucherQueries.sql_getVoucherDetails_type1 + qry;
      try {
         conn=dsConn.getDBConnection();
         if(conn==null)
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
//         System.out.println(sQuery+"------"+empNo+"------"+locId);
         pSt=conn.prepareStatement(sQuery);
         pSt.setLong(1,empNo);
         pSt.setLong(2,locId);
         rSet=pSt.executeQuery();
         while(rSet.next()) 
         {
            QueryBean qBean=new QueryBean(Long.toString(rSet.getLong("V_ID")),rSet.getString("V_NO"),rSet.getString("V_DT"),wrapText(rSet.getString("D_REF"),10),wrapText(rSet.getString("D_REM"),12),rSet.getString("TXN_STATUS"),wrapText(rSet.getString("AUTH_CMNT"),15));
            searchList.add(qBean);
            retVal++;
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("QueryDAO SQLException");
         sExcept.printStackTrace();
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("QueryDAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }
   private void ExceptionHandling(int Type,int key,String Message) throws SQLException,Exception  
   {
      if(Type==1) 
      {
         IBAFatalException ibaFatal=new IBAFatalException();
         ibaFatal.setiErrCode(key);
         ibaFatal.setsMessage(Message);
         throw ibaFatal;
      }
      else if(Type==2) 
      {
         throw new IBAFatalException(Message);
      }
   }
   private void freeResource() throws SQLException,Exception 
   {
      if(rSet!=null)
         rSet.close();
      if(pSt!=null)
         pSt.close();
      if(conn!=null)      
         conn.close();
   }
   private String wrapText(String toWrap,int len) {
        if(toWrap==null || toWrap.equals("")) {
            String emptyStr="";
            return emptyStr;
        }
        StringBuffer strBuf=new StringBuffer(toWrap);
        int strLen=toWrap.length();
        int i=0;
        int wrapAt=0;
        while(i<=(strLen/len)) {
            wrapAt=wrapAt+len;
            try {
            strBuf.insert(wrapAt,"\n");
            }
            catch(StringIndexOutOfBoundsException e) {
                   
            }
            i++;
        }
//        System.out.println("WrapText Ouput="+strBuf.toString());
        return strBuf.toString();
    }
}