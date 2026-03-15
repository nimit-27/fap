/**
*  Program Name : DSConnect.java
*  Author       : Paresh
*  Date Written : 12/10/2003
*  Description  : Creates a database connection pool object using JDBC 2.0. 
*  Please substitute the database connection parameters with appropriate values.
*  Revision History :
*  Modified by Dhruv on 03-11-2003 for Exception Handling
*  Modified by Dhruv/Salini on 21-12-2003 for handling changes in Transaction screens
*  Modified by Balram on 19/10/2004 for adding the urls for tarapur and kakrapar.
**/  

package FCIPAY.COMMON.UTILITY;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;

import oracle.jdbc.driver.*;
import oracle.jdbc.pool.*;

import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.InitialPlugIn;

public class DSConnect
{
	 OracleConnectionPoolDataSource ConnectionPoolDS = null;
     PooledConnection plc = null;
     
	 OracleConnectionCache ConnCache = null;
   	 public static int MAX_CONN_LIMIT = 50;
     private DSConnect dsc = null;

     public DSConnect() throws IBAFatalException
     {
         dsc = InitialPlugIn.getInstance();
         this.ConnCache = dsc.ConnCache;        
     }

     /**
      *  This method is used to create the DataSource Connection Pool 
      *  @param 
      *  @exception 
      *  @return 
     **/ 

	 public DSConnect(String str) throws IBAFatalException
	 {
	  	 try 
		 {
      	     ConnectionPoolDS =   new OracleConnectionPoolDataSource();
			 // Set connection parameters
             // at tcs, maker towers
			// String url = "jdbc:oracle:thin:@TCS032642:1521:npcil";
            // At TCS Kolkata 
//            String url = "jdbc:oracle:thin:@TCS039576:1521:ENRGISE1";
        // jbm    String url = "jdbc:oracle:thin:@tcs034909:1521:WENRGISE";
            //  dev data base, NPCIL
             String url = "jdbc:oracle:thin:@10.10.2.23:1521:ibadbhq";

            //  production data base, NPCIL
            // String url = "jdbc:oracle:thin:@10.10.2.81:1521:ibahq";

            //  url for tarapur
            // String url = "jdbc:oracle:thin:@10.22.2.20:1521:ibatap12"; 

            //  url for kakrapar
            // String url = "jdbc:oracle:thin:@10.30.2.22:1521:ibakaps"; 
             
		     // Sets the connection URL
		     ConnectionPoolDS.setURL(url);
             
	    	 // Sets the user name
	      	 ConnectionPoolDS.setUser("npcilhq");

             // Sets the user name for tarapur
	      	 //ConnectionPoolDS.setUser("tapp12");

             // Sets the user name for kakrapar
	      	 //ConnectionPoolDS.setUser("kaps");
             
        	 // Sets the password
             // at tcs, maker towers
	      	 ConnectionPoolDS.setPassword("npchq123");

            //  developement / production data base, NPCIL
	      	 // ConnectionPoolDS.setPassword("npc123");

             // Sets the password at tarapur
	      	 //ConnectionPoolDS.setPassword("tapp12");
             
             // Sets the password at kakrapar
	      	 //ConnectionPoolDS.setPassword("kaps");
			
			 //Old code
		     // plc = ConnectionPoolDS.getPooledConnection();

             // with Coonection Cache
			 //ConnCache = new OracleConnectionCacheImpl(ConnectionPoolDS);			
			 //ConnCache.setMaxLimit (MAX_CONN_LIMIT);
			 //ConnCache.setCacheScheme(OracleConnectionCacheImpl.FIXED_WAIT_SCHEME);
    	 } 
		 catch(SQLException ex) 
		 { 
             throw new IBAFatalException("Common.DB.Administrator");            
			 // Catch SQL errors
        	 // System.out.println("Error while instantiating DSConnect");
		 } 
 	 }    

    /**
    *  This method is used to get the connection 
    *  @param 
    *  @exception 
    *  @return Connection
    **/
    
	public Connection getDBConnection() throws IBAFatalException
	{
        Connection connection =null;
	    try
        {
		    //oLD CODE
	        //connection = plc.getConnection();
    	    // with Coonection Cache
		    connection = ConnCache.getConnection();
            
            if (connection == null)
            {                
                System.out.println("NULL CONNECTION In DSConnect");
                throw new IBAFatalException("Common.DB.Administrator");  
            }

	    }
        catch(SQLException ex) 
		{ 
			// Catch SQL errors
            throw new IBAFatalException("Common.DB.Administrator");            
		}         
	    return connection;
	} 

    /**
    *  This method is used to close the connection 
    *  @param 
    *  @exception 
    *  @return Connection
    **/
    public Connection closeConn(Connection connection) throws IBAFatalException
    {
        if (connection != null) 
    	{
            try
            {             
                connection.close(); // close the pooled connection.
		        connection = null;
  	        }     		
	        catch (SQLException e) 
	        {			
                throw new IBAFatalException("Common.DB.Administrator");              
	        }
        }
        return connection;
    }    

    /**
    *  This method is used to close the pooled connection
    *  @param 
    *  @exception 
    *  @return 
    **/
    public void finalClose () throws IBAFatalException
    {
        try
        {
            //Old code
            //plc.close();
            //plc = null;

            // With connection cache
            ConnCache.close();
            ConnCache = null;
        }
        catch (SQLException SQLEx) 
	    {			
            //System.out.println("In SQL Exception in Final Close Connection");
            throw new IBAFatalException("Common.DB.Administrator");            
	    }    
    }         
} 