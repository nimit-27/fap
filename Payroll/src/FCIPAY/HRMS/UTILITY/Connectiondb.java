package FCIPAY.HRMS.UTILITY;
import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.sql.*;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.*;


public class Connectiondb extends BaseDAO
{
    Connection con;
    int eCode=0;
    
    public Connectiondb()
    {
        super("HRMS");       
    }
    
    /**
    * Establishes connection to database and executes query.
    * @psQuery QueryString.
    * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown    
    * @true -on success   
    * @false -on failure
    */
    public boolean InsertRecord(String psQuery) throws IBAException,IBABusinessException,IBAFatalException
    {
        try
        {
            System.out.println("Connect  " + psQuery );
//          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//          con = (Connection) DriverManager.getConnection("jdbc:odbc:npcil","npcil","npcil");            
            con = getConnection();
            if(con == null)
            System.out.println("fail");
            con.setAutoCommit(false);                
            Statement st = con.createStatement();
            System.out.println(st.executeUpdate(psQuery));
            con.commit();
            con.setAutoCommit(true);
            con.close();
//            closeConnection();            
            return true;
        }catch(SQLException SQLEx){   
            con = null;
            closeConnection();            
            eCode = SQLEx.getErrorCode();
            if ( eCode == 1 ){
                System.out.println("The error code is IBA Fatal Exception");                   
                throw new IBAFatalException("HRMS.Master.PK");
            }                
            if ( eCode == 925 ){
                System.out.println("The error code is IBA Fatal Exception");
                throw new IBAFatalException("common.fatalexception");
            }   
            else{
                throw new IBAFatalException("HRMS.Master.General");
            }
        }catch(Exception e){
            con = null;
            closeConnection();                        
            System.out.println("An Exception has occurred"+ e.getMessage());                
            e.printStackTrace();
        }
        return false;
    }
    /**
    * Retrieve record count and return it
    * @psQuery QueryString.
    * @exception being thrown
    * @long record count 
    */
    public long getMaxId(String psQuery)
    {
        ResultSet res=null;
        long lRowcount=0;
        try
        {
            System.out.println("Connect MaxId " +psQuery);
//          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//          con=(Connection) DriverManager.getConnection("jdbc:odbc:ibanpcil","npcil","npcil");
            con = getConnection();
            if (con==null)System.out.println("Connection Failure");
            Statement st=con.createStatement();
            res=st.executeQuery(psQuery);
            if (res!=null) 
            {
                while (res.next()){
                    lRowcount=res.getLong(1);
                    System.out.println(lRowcount);
                } 
            con.close(); 
//            closeConnection();            
                return lRowcount;
            }
        }
        catch(Exception e)
        {
          con = null;
          closeConnection();                      
          e.printStackTrace();}
          return 0;        
        }
    /**
    * Checks the existence of a record.
    * @psQuery QueryString.
    * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown    
    * @true -on success   
    * @false -on failure
    */
        
    public boolean getRecords(String sQuery) throws IBABusinessException, IBAFatalException, IBAException
    {
        ResultSet rs=null ;
        Statement st = null;    
        Connection oConn= null;  
        try
        {
            System.out.println(sQuery);
//          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//          oConn = (Connection) DriverManager.getConnection("jdbc:odbc:xyz","npcil","npcil");
            oConn = getConnection();
            if(oConn != null)
            {         
                st = oConn.createStatement();                    
                rs=st.executeQuery(sQuery);  
                String strFlag="N";
                while (rs.next())
                {
                    System.out.println("Entered");
                    strFlag="Y";
                }
                System.out.println("The value of Result Set" + rs);
                if(strFlag.equalsIgnoreCase("N"))
                {
                    oConn = null;
                    closeConnection();            
                    return false;
                    
             //       throw new IBABusinessException("HRMS.Emp.Exists");
                }
                else          
                {
                    closeConnection();            
                    return true;           
                }            
            }         
        }catch(SQLException SQLEx){                
            oConn = null;        
            closeConnection();                        
            eCode = SQLEx.getErrorCode();
            if ( eCode == 1 ){
                System.out.println("The error code is IBA Fatal Exception");                   
                throw new IBAFatalException("HRMS.Master.PK");
            }                
            if ( eCode == 925 ){
                System.out.println("The error code is IBA Fatal Exception");
                throw new IBAFatalException("common.fatalexception");
            }   
            else{
                throw new IBAFatalException("HRMS.Master.General");
            }
        }catch(Exception e){
            oConn = null;        
            closeConnection();                        
            // System.out.println("An Exception has occurred"+ e.getMessage());                
            e.printStackTrace();       
        }
        return true;
    }
}        
   
       
