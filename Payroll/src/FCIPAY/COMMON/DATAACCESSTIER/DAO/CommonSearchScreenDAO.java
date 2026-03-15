/*
 * Module       : CommonSearchScreenDAO.java
 * Author       : S.MUTHU SUBRAMANIAM
 * Date Written : 04/11/2003
 * Description  : This class is used by CommonSearchScreenBD.java
 * Revision Log :   /  /2003
 *-------------------------------------------------------
*/
package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import oracle.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.driver.*;

import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.DSConnect;
import FCIPAY.COMMON.UTILITY.CommonSearchBean;

public class CommonSearchScreenDAO 
{
   private Connection conn=null;
   private DSConnect dsConn=null;
   private ResultSet rSet=null;
   private PreparedStatement pSt=null;
   private ResultSetMetaData rSetMtData=null;
   
   public CommonSearchScreenDAO() throws IBAFatalException
   {
      dsConn=new DSConnect();
   }

   /**
    * This Method retrieves the records from the Table(Table Name) and stores it in the ArrayList(lstSearchResult)
    * @param       : String Id                  First Column Name  (In the query that is being constructed)
    * @param       : String Desc                Second Column Name (In the query that is being constructed)
    * @param       : String TableName           Table Name
    * @param       : String IdValue             First Column Value
    * @param       : String DescValue           Second Column Value
    * @param       : ArrayList lstSearchResult  ArrayList to hold the Search Results
    * @exception   : throws IBAFatalException,IBABusinessException,SQLException,Exception
    * @return      : return the Total number (Count) of search rows.
   */
   
   public int SearchRecords_DAO(String tempQuery,String Id,String Desc,String IdValue,String DescValue,String AddCond,ArrayList lstSearchResult) throws IBAFatalException, IBABusinessException, SQLException, Exception 
   {
      int retVal=0;
      int colType=0;
      String sQuery="";
      String retId="";
      String retCode="";
      String retDesc="";
      String orgQuery=tempQuery;
      boolean whereAdded=false;
      try {
         conn=dsConn.getDBConnection();
         System.out.println("Add Cond======"+AddCond);
         if(!(AddCond.equals(""))) {
            whereAdded=true;
            orgQuery=orgQuery + " WHERE " + AddCond;
         }
         if(!(IdValue.trim().equals("") && DescValue.trim().equals(""))) {
            if(whereAdded) {
                orgQuery=orgQuery + " AND " + ConstructQuery(tempQuery,IdValue,DescValue,Id,Desc);
            }
            else {
                orgQuery=orgQuery + " WHERE " + ConstructQuery(tempQuery,IdValue,DescValue,Id,Desc);
            }
         } 
         orgQuery=orgQuery + " ORDER BY " + Id;
         System.out.println("Original Query "+orgQuery+"-"+IdValue+"-"+DescValue);         
         PreparedStatement pSt=conn.prepareStatement(orgQuery);
//         setValuesForQuery(pSt,IdValue,DescValue);
         rSet=pSt.executeQuery();
         rSetMtData=rSet.getMetaData();
         colType=rSetMtData.getColumnType(1);
         if(colType==2) {
//            System.out.println("Inside 2");
            while(rSet.next()) 
            {
               retId=Long.toString(rSet.getLong(Id));
               retDesc=rSet.getString(Desc);
               CommonSearchBean oCommonSearchBean=new CommonSearchBean(retId,retDesc);
               lstSearchResult.add(oCommonSearchBean);
               retVal++;            
            }
         }
         else if(colType==12){
//            System.out.println("Inside 12");
            while(rSet.next()) 
            {
               retId=rSet.getString(Id);
               retDesc=rSet.getString(Desc);
               CommonSearchBean oCommonSearchBean=new CommonSearchBean(retId,retDesc);
               lstSearchResult.add(oCommonSearchBean);
               retVal++;            
            }            
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("SearchRecords_DAO SQLException");
         sExcept.printStackTrace();
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("SearchRecords_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;      
   }
   
   /**
    * This Method Throws an IBAFatalException Based on the Type.
    * @param       : int Type             The Type (Whether SQLException OR Exception)     
    * @param       : int key              The SQL Error Code     
    * @param       : String Message       The Exception Message
    * @exception   : throws SQLException,Exception
    * @return      : void
   */
   
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

   /**
    * This Method Closes all the System Resources that are open and set it to null
    * @param       : int Type             The Type (Whether SQLException OR Exception)     
    * @param       : int key              The SQL Error Code     
    * @param       : String Message       The Exception Message
    * @exception   : throws SQLException,Exception
    * @return      : void
   */
   
   private void freeResource() throws SQLException,Exception 
   {
      if(rSet!=null) {
         rSet.close();
         rSet=null;
      }
      if(rSetMtData!=null) {
         rSetMtData=null;
      }
      if(pSt!=null) {
         pSt.close();
         pSt=null;
      }
      if(conn!=null) {
         conn.close();
         conn=null;
      }
   }
   
   /**
    * This Method Constructs the Query.
    * @param       : String sTempQuery     Initial part of the Query 
    * @param       : String Id             The Id Value
    * @param       : String Desc           The Description Value
    * @param       : String IdName         The Column Name of The Id in Table
    * @param       : String DescName       The Column Name of The Desc in Table
    * @return      : returns the combination of the initial part of the query and the dynamically constructed query.
   */
   
   private String ConstructQuery(String sTempQuery,String Id,String Desc,String IdName,String DescName) 
   {
      String retStr="";
//      System.out.println("Construct Query "+Id+"-"+Desc);
      if(!Id.equals("") && !Desc.equals("")) {
         retStr="lower(" + IdName + ") LIKE '%" +Id.toLowerCase()+ "%' AND lower(" + DescName + ") LIKE '%"+Desc.toLowerCase()+"%'";
         return retStr;
      }
      if(!Id.equals("")) 
      {
         retStr="lower(" + IdName + ") LIKE '%" +Id.toLowerCase()+ "%'";
         return retStr;
      }
      if(!Desc.equals("")) 
      {
         retStr="lower(" + DescName + ") LIKE '%"+Desc.toLowerCase()+"%'";
         return retStr;
      }
      return retStr;      
   }

   /**
    * This Method Constructs set the values for the Query.
    * @param       : PreparedStatement pSt     The PreparedStatement Object to which the values will be set. 
    * @param       : String Id                 The Id Value
    * @param       : String Desc               The Description Value
    * @exception   : throws SQLException
    * @return      : void
   */
   
   private void setValuesForQuery(PreparedStatement pSt,String Id,String Desc) throws SQLException 
   {
//      System.out.println("Setvaluesforquery "+Id);
      if(!Id.equals("") && !Desc.equals("")) {
         pSt.setString(1,"%"+Id.toLowerCase()+"%");
         pSt.setString(2,"%"+Desc.toLowerCase()+"%");
      }
      if(!Id.equals("")) 
      {
         pSt.setString(1,"%"+Id.toLowerCase()+"%");
      }
      if(!Desc.equals("")) 
      {
         pSt.setString(1,"%"+Desc.toLowerCase()+"%");
      }   
   }
}