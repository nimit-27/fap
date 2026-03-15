/*
 * Program Name : BaseDAO.java
 * Author       : Dhruv Ratna Singh
 * Date Written : 12/10/2003
 * Description  : This is the Base Class for the DAO's of the application.                
 *
 * History : Change made by Dhruv/Jegan to point before the first record on 29/10/2003
 * History : Changes made by Balram to add else cases, and errorkey wherever not given,
 *              method for adding and executing a batch is added
 * History : "setDOUBLEPRIMITIVE"  method added by tanmay on 11/08/2004
*/

package FCIPAY.COMMON.UTILITY;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import java.lang.*;

import oracle.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.InitialPlugIn;
import FCIPAY.COMMON.UTILITY.DSConnect;
import FCIPAY.COMMON.UTILITY.IBAFatalException;


public class BaseDAO 
{
    private PreparedStatement pstmt = null;
    private CallableStatement cstmt = null;
 	private int variableCount=1;
    private Connection conn = null;
    private DSConnect dsc = null;
   
    public ResultSet rSet;

    private String mName;

    /**
     * This method which is the constructor has the module name of the application
     * passed as a parameter
     * @param int  String mName, String ShortDesc, CostCenterVO oCostCenterVO
     * @exception IBABusinessException
     * @return CostCenterVO
    **/
    public BaseDAO(String mName)
    {
        dsc = InitialPlugIn.getInstance();        
    }

    public Connection getConnection()
    {
        try
        {
            System.out.println("In get Connection method");
            conn = dsc.getDBConnection();
        }
        catch ( Exception e )
        {
            conn = null;
            e.printStackTrace();
        }        
        return conn;
    }
    /**
     * This method is used to close the Connection obtained from the connection pool
     * @param 
     * @exception Exception
     * @return 
    **/
	protected void closeConnection()
	{
        try
        {
            if (conn!=null)
            {
                conn = dsc.closeConn(conn);        
            }
        }
        catch ( Exception e )
        {
            conn = null;
            e.printStackTrace();
        }        
	}

     /**
     * This method is used to close the Prepared Statement which is passed as an argument
     * @param PreparedStatement pstmt
     * @exception Exception
     * @return 
     **/ 
    protected void closePreparedStatement(PreparedStatement pstmt ) throws  IBAFatalException
	{
        try
        {
            if (pstmt!= null)
            {
                pstmt.close(); 
            }
        }
        catch ( Exception e )
        {
            pstmt = null;
            throw new IBAFatalException("Common.DB.Administrator");            
        }
	}

     /**
     * This method is used to close the Prepared Statement of the Base DAO 
     * @param 
     * @exception Exception
     * @return 
     **/ 

    protected void closePreparedStatement( ) throws  IBAFatalException
	{
        try
        {
            if (pstmt!= null)
            {
                pstmt.close(); 
            }
        }
        catch ( Exception e )
        {
            pstmt = null;
            throw new IBAFatalException("Common.DB.Administrator");
        }
	}

    /**
     * This method is used to close the Callable Statement of the Base DAO 
     * @param 
     * @exception Exception
     * @return 
     **/ 

    protected void closeCallableStatement( )
	{
        try
        {
            if (cstmt!= null)
            {
                cstmt.close(); 
            }
        }
        catch ( Exception e )
        {
            cstmt = null;
        }
	}
    
    /**
     * This method is used to commit the transaction
     * @param 
     * @exception Exception
     * @return 
     **/
    protected void commit() throws  IBAFatalException
	{
        try
        {        
            conn.commit();    
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }                
	}

    /**
    * This method is used to close the Prepared Statement of the Base DAO 
    * @param 
    * @exception Exception
    * @return 
    **/
    
    protected void rollBack() throws  IBAFatalException
	{
        try
        {
            if(conn != null)
            {
                conn.rollback();    
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }                
	}


	// query methods could return a resultSet. Otherwise may not be necessary to return anything
    /**
    * This method is used when inserting records in the database
    * @param 
    * @exception IBABusinessException, IBAFatalException
    * @return 
    **/
    
    protected int doExecuteUpdate() throws IBABusinessException, IBAFatalException
    {
        int resultCode=0;
        try 
        {            
            resultCode = pstmt.executeUpdate();            
            variableCount = 1;            
        }
        catch ( SQLException SQLEx)
        {            
            int eCode = SQLEx.getErrorCode();                 
            String eMessage = SQLEx.getMessage();

            // This condition is added by Kiran Kumar Tripurari, Dt.10/11/2003            
            if ( eCode == 1 || eCode == 2291 || eCode == 925 )
            {                
                closePreparedStatement();
                rollBack();
                closeConnection();
                IBAFatalException ibafe = new IBAFatalException("Common.Database.Error");
                ibafe.setiErrCode(eCode);
                throw ibafe;
            }
            else
            {
                closePreparedStatement();
                rollBack();
                closeConnection();
                throw new IBAFatalException("Common.Database.Error");
            }
            
            /** if ( eCode == TechnicalErrorMessages.DUPLICATE )
            {
                throw new IBABusinessException("common.duplicatekey");
            }
            **/
            
            // log ....                                    
        }
        catch (Exception e)
        {            
            closePreparedStatement();
            rollBack();
            closeConnection();
        }                   
        return resultCode;
    }

    /**
    * This method is used when inserting records in the database
    * @param 
    * @exception IBABusinessException, IBAFatalException
    * @return 
    **/

    
    
    protected int doExecuteUpdateCallable() throws IBABusinessException, IBAFatalException
    {
        int resultCode = -1;
        try 
        {            
            resultCode = cstmt.executeUpdate();            
            variableCount = 1;            
            return resultCode;
        }
        catch ( SQLException SQLEx)
        {            
            int    eCode = SQLEx.getErrorCode();                 
            String eMessage = SQLEx.getMessage();
            
            if ( eCode == 925 )
            {                
                closeCallableStatement();
                closeConnection();
                throw new IBAFatalException("Common.Database.Error");
            }

            else
            {                
                closeCallableStatement();
                closeConnection();
                throw new IBAFatalException("Common.Database.Error");
            }
            
            /** if ( eCode == TechnicalErrorMessages.DUPLICATE )
            {
                throw new IBABusinessException("common.duplicatekey");
            }
            **/
            
            // log ....                                    
        }
        catch (Exception e)
        {            
            closeCallableStatement();
            closeConnection();
        }  
         return resultCode;
    }

    protected boolean doExecuteCallable() throws IBABusinessException, IBAFatalException
    {
        boolean resultCode = false;
        try 
        {            
            resultCode = cstmt.execute();            
            variableCount = 1;            
            return resultCode;
        }
        catch ( SQLException SQLEx)
        {            
            int    eCode = SQLEx.getErrorCode();                 
            String eMessage = SQLEx.getMessage();
            System.out.println("eCode="+eCode+" eMessage="+eMessage);
            if ( eCode == 925 )
            {                
                closeCallableStatement();
                closeConnection();
                throw new IBAFatalException("Common.Database.Error");
            }

            else
            {                
                closeCallableStatement();
                closeConnection();
                throw new IBAFatalException("Common.Database.Error");
            }
            
            /** if ( eCode == TechnicalErrorMessages.DUPLICATE )
            {
                throw new IBABusinessException("common.duplicatekey");
            }
            **/
            
            // log ....                                    
        }
        catch (Exception e)
        {            
            closeCallableStatement();
            closeConnection();
        }  
         return resultCode;
    }
  
    /**
    * This method is used when inserting records in the database
    * It also provides the facility to specific eror messages to the
    * user
    * @param 
    * @exception IBABusinessException, IBAFatalException
    * @return 
    **/
    
    protected void doExecuteUpdateErrorMessage() throws IBABusinessException, IBAFatalException
    {
        try 
        {            
            pstmt.executeUpdate();            
            variableCount = 1;            
        }
        catch ( SQLException SQLEx)
        {            
            int    eCode = SQLEx.getErrorCode();                 
            String eMessage = SQLEx.getMessage();
            IBAFatalException ibafe = new IBAFatalException();
            ibafe.setiErrCode(eCode);
            ibafe.setsMessage(eMessage);
            closePreparedStatement();
            closeConnection();
            throw ibafe;
        }
        catch (Exception e)
        {            
            closePreparedStatement();
            closeConnection();
        }                   
    }


    /**
    * This method is used when retrieving records in the database
    * If no records are returned exception is thrown and a message 
    * is to the User
    * @param 
    * @exception IBABusinessException, IBAFatalException 
    * @return ResultSet
    **/
    protected ResultSet doExecuteQuery(boolean errorRequired) throws IBABusinessException, IBAFatalException 
    {
        try 
        {   
            rSet = pstmt.executeQuery();               
            return rSet;              
        }   
        catch ( SQLException SQLEx)
        {                      
            SQLEx.printStackTrace();
            IBAFatalException ibafe = new IBAFatalException("Common.Database.Error");
            if (errorRequired)
            {
                ibafe.setsMessage(SQLEx.getMessage());
                ibafe.setiErrCode(SQLEx.getErrorCode());
            }
            throw ibafe;
        }
    }
   


    /**
    * This method is used when retrieving records in the database
    * If no records are returned and if the error is required then
    * exception is thrown and a message is sent to the user. If rows
    * are returned or if no rows are returned and an error messsage 
    * is not needed to be thrown then an Array List is retuened. This
    * Array List contains the Result Set and a String (which indicates 
    * if rows were returned or not )
    * @param 
    * @exception IBABusinessException, IBAFatalException 
    * @return ResultSet
    **/

    protected ArrayList doExecuteQuery(String queryString, boolean errorRequired) throws IBABusinessException, IBAFatalException 
    {
        PreparedStatement pstmtTemp;        
        ResultSet rSetTemp;
        ArrayList queryResult = new ArrayList();        
        String rowsReturned;     
        try 
        {                          
            rSet = pstmt.executeQuery();  

            pstmtTemp = conn.prepareStatement(queryString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);           
            
            rSetTemp = pstmtTemp.executeQuery();
            
            if (!rSetTemp.next())                
            {
                if (errorRequired)
                {
                    throw new IBABusinessException("Common.Records.NotFound");    
                }
                rowsReturned = "false";                    
            }
            else
            {
                rowsReturned = "true";
            }                                
            pstmtTemp.close();            
            
            queryResult.add(1,rSet);
            queryResult.add(2,rowsReturned);                                                
            
            return queryResult;             
        }   
        catch ( SQLException SQLEx)
        {                      
            SQLEx.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
    }

       
    /**
    * This method is used when retrieving records in the database using the prepared statement 
    * which is passed as a parameter
    * @param PreparedStatement pstmt
    * @exception IBABusinessException, IBAFatalException 
    * @return ResultSet
    **/
    
	protected ResultSet doExecuteQuery(PreparedStatement pstmt) throws IBABusinessException, IBAFatalException 
    {
        try 
        {
            rSet = pstmt.executeQuery();           
            return rSet;              
        }
        catch ( SQLException SQLEx)
        {                   
            SQLEx.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
    }

    /**
    * This method is used for the prepared Statement for VARCHAR types     
    * @param String str
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setVARCHAR(String str) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setObject(variableCount++,str,Types.VARCHAR);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
	}

    

    /**
    * This method is used for the prepared Statement for DATE types     
    * @param String str
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setDATE(String str) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setObject(variableCount++,str,Types.VARCHAR);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
	}
    

    /**
    protected PreparedStatement setVARCHAR(String str, PreparedStatement pstmt) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setObject(variableCount++,str,Types.VARCHAR);
            return pstmt;
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException();
        }
	}
    **/ 

    /**
    * This method is used for the prepared Statement for LONG types     
    * @param Long lng
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setLONG(Long lng) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setObject(variableCount++,lng,Types.NUMERIC);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}

    /**
    * This method is used for the prepared Statement for DOUBLE types     
    * @param Double dbl
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setDOUBLE(Double dbl) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setObject(variableCount++,dbl,Types.DOUBLE);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}

    /**
    * This method is used for the prepared Statement for LONG types     
    * @param Float fl
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setFLOAT(Float fl) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setObject(variableCount++,fl,Types.FLOAT);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}


    /**
    * This method is used for the prepared Statement for String types     
    * @param String str
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setSTRING(String str) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setString(variableCount++,str);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
	}

    /**
    * This method is used for the prepared Statement for long (primitive) types     
    * @param LONG lng
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setLONGPRIMITIVE(long lng) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setLong(variableCount++,lng);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}

    /**
    * This method is used for the prepared Statement for long (primitive) types     
    * @param LONG lng
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setINT(int integer) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setInt(variableCount++,integer);            
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}

    /**
    * This method is used for the prepared Statement for long (primitive) types     
    * @param FLOAT fl
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setFLOATPRIMITIVE(float fl) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setFloat(variableCount++,fl);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}

    /**
    * This method is used for the prepared Statement for Double (primitive) types     
    * @param DOUBLE db
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setDOUBLEPRIMITIVE(double db) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            pstmt.setDouble(variableCount++,db);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}



//	 Similar setXXXX methods for all the PLSQL types	
	/**
    * This method is used to make the prepare Statement from the query in the Database     
    * @param String queryString 
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void doPrepareStatement(String queryString)  throws IBABusinessException, IBAFatalException
    {
        try 
        {
            if (conn == null)
            {
                conn = dsc.getDBConnection(); 
            }            
            conn.setAutoCommit(false);

            queryString = queryString.trim();
            if ((queryString.startsWith("SELECT")) || (queryString.startsWith("select")) || (queryString.startsWith("Select")))  
            {            
                pstmt = conn.prepareStatement(queryString);     
            }
            else 
            {
                pstmt = conn.prepareStatement(queryString);         
            }
            variableCount=1;          
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
    }

  	/**
    * This method is used to make the prepare Statement from the query in the Database     
    * @param String queryString 
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void doPrepareCall(String queryString)  throws IBABusinessException, IBAFatalException
    {
        try 
        {
            if ( conn == null )
            {
                conn = dsc.getDBConnection();
            }
            conn.setAutoCommit(false);

            cstmt = conn.prepareCall(queryString);            

            variableCount=1;          
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
    }


    /**
 	protected PreparedStatement doPreparedStatement(String queryString)  throws IBABusinessException, IBAFatalException
	{
        try 
        {
            conn = dsc.getDBConnection();  
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(queryString);         
            
			return pstmt;
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException();
        }
	}
    **/

    /**
    * This method is used for the Callable Statement for LONG types     
    * @param Long lng
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setLONGforCallable(Long lng) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            cstmt.setObject(variableCount++,lng,Types.NUMERIC);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}

    /**
    * This method is used for the Callable Statement for String types     
    * @param String str
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setVARCHARforCallable(String str) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            cstmt.setObject(variableCount++,str,Types.VARCHAR);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	}

    /**
    * This method is used for the Callable Statement for Date types     
    * @param String str
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setDATEforCallable(String str) throws IBABusinessException, IBAFatalException
	{
	    try 
        {
            cstmt.setObject(variableCount++,str,Types.VARCHAR);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
	} 

    protected void registerOutParameterLong() throws IBABusinessException, IBAFatalException {
        try 
        {
            cstmt.registerOutParameter(variableCount++,Types.NUMERIC);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
    }

    protected void registerOutParameterString() throws IBABusinessException, IBAFatalException {
        try 
        {
            cstmt.registerOutParameter(variableCount++,Types.VARCHAR);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
    }

    protected long getLongCallable(int i) throws IBABusinessException, IBAFatalException {
        long retVal=-999;
        try 
        {
            retVal=cstmt.getLong(i);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
        return retVal;
    }
    protected String getStringCallable(int i) throws IBABusinessException, IBAFatalException {
        String retVal="";
        try 
        {
            retVal=cstmt.getString(i);
        }
        catch ( Exception e)
        {            
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error"); 
        }
        return retVal;
    }


    /**
    * This method is used to add to a Batch 
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setAddBatch() throws IBABusinessException, IBAFatalException
    {
        try
        {
            pstmt.addBatch();
            
        }
        catch( Exception e)        
        {
            throw new IBAFatalException("Common.Database.Error");            
        }
    }    

    /**
    * This method is used to execute a Batch 
    * @exception IBABusinessException, IBAFatalException 
    * @return int
    **/
    protected int doExecuteBatch() throws IBABusinessException, IBAFatalException
    {
        try
        {
            int[] count;
            count = pstmt.executeBatch();
            return count.length;
            
        }
        catch( Exception e)        
        {
            throw new IBAFatalException("Common.Database.Error");            
        }
    }    
    

    /**
    * This method is used to set the Batch size which indicates the no of rows inserted in one shot     
    * @param int batchSize
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void setExecuteBatch(int batchSize) throws IBABusinessException, IBAFatalException
    {
        try
        {
            ((OraclePreparedStatement)pstmt).setExecuteBatch(batchSize);
            
        }
        catch( Exception e)        
        {
            throw new IBAFatalException("Common.Database.Error");            
        }
    }    

    /**
    * This method is used to perform inserts on the reamining rows after multiples
    * of batch size are consumed
    * @param int batchSize
    * @exception IBABusinessException, IBAFatalException 
    * @return 
    **/
    protected void sendBatch() throws IBABusinessException, IBAFatalException
    {
        doExecuteUpdate();
    }
}
