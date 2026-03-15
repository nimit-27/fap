package FCIPAY.Payroll.EJB.common.utility;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OraclePreparedStatement;
import javax.naming.InitialContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.sql.BatchUpdateException;
import javax.naming.NamingException;
import java.sql.ResultSetMetaData;
//import com.evermind.sql.OrclCMTConnection;
//import com.evermind.sql.OrionCMTDataSource;
//import com.evermind.sql.OrclPreparedStatement;
//import com.evermind.sql.OrclCallableStatement;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;

public class DBUtilitiesBean
{
  private String sDbName = FCIPAY.Payroll.common.utility.EnrgiseConstants.DATABASE_NAME;
  private ArrayList oOutParameters = null;
  private Connection oCon;
  private ResultSet oRs;
  private Connection oConn = null;
  private DataSource oDataSource = null;
  private PreparedStatement oDynamicBatchCall = null;
  private CallableStatement oBatchCall = null;
  private Connection oBatchCon = null;
  private Connection oPreParameterCon = null;
  private PreparedStatement oPreParameter = null;
  private Connection oPreUpsertCon = null;
  private PreparedStatement oPreUpsert = null;
  private boolean bDynamic = false;
  
  public DBUtilitiesBean()
  {
    
  }
  
  public DBUtilitiesBean(boolean bDynamic)
  {
    this.bDynamic = bDynamic;
  }
  
  public void createBatch(String sProcName) throws EnrgiseSystemException
  {
    String sParam = "{ call " + sProcName + "}";
   
    try
    {
    
        oDataSource = (DataSource) FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sDbName);
        oBatchCon = oDataSource.getConnection();
        //oBatchCon.setAutoCommit(true);
      
        if(!bDynamic)
        {
          if(oBatchCall != null)
          {
            oBatchCall.close();
            oBatchCall = null;
          }
          oBatchCall = (CallableStatement)oBatchCon.prepareCall(sParam);
        }
        else
        {
          if(oDynamicBatchCall != null)
          {
            oDynamicBatchCall.close();
            oDynamicBatchCall = null;
          }
          oDynamicBatchCall = (PreparedStatement)oBatchCon.prepareStatement(sParam);
        }
    }
    catch(SQLException oExc)
    {
      System.out.println("Inside Catch "+oExc);
      throw new EnrgiseSystemException(oExc);      
    }
    /*finally
    {
      try
      {
        if(oBatchCon != null)
        {
          if(!oBatchCon.isClosed())
          {
            oBatchCon.close();            
          }
          oBatchCon = null;
        }
      }
      catch(SQLException oSqlEx)
      {
      }
    }*/
  }
  
  public void addToBatch(ArrayList oParameters) throws EnrgiseSystemException
  {
    if(!bDynamic)
    {
      addToProcBatch(oParameters);
    }
    else
    {
      addToDynamicBatch(oParameters);
    }
  }
  private void addToDynamicBatch(ArrayList oParameters) throws EnrgiseSystemException
  {
    try
    {
       Iterator oIter = oParameters.iterator();
        while(oIter.hasNext())
        {
          InputDBObject oObject = (InputDBObject)oIter.next();
          inspectExecuteParameter(oObject,oDynamicBatchCall);
        }
        oBatchCall.addBatch();
        
    }
    catch(SQLException oSqlEx)
    {
        System.out.println("Inside Catch "+oSqlEx);
        throw new EnrgiseSystemException(oSqlEx);        
      
    }
    finally
    {
      try
      {
        if(oBatchCon != null)
        {
          if(!oBatchCon.isClosed())
          {
            oBatchCon.close();            
          }
          
         
          
          oBatchCon = null;
        }
        
      }
      catch(SQLException oSqlEx)
      {
          oSqlEx.printStackTrace();
      }
    }
     
    
  }
  
  private void addToProcBatch(ArrayList oParameters) throws EnrgiseSystemException
  {
    try
    {
        Iterator oIter = oParameters.iterator();
        while(oIter.hasNext())
        {
          DBObject oObject = (DBObject)oIter.next();
          inspectParameter(oObject,oBatchCall);
        }
        oBatchCall.addBatch();
    }
    catch(SQLException oSqlEx)
    {
        oSqlEx.printStackTrace();    
        try
        {
          if(oBatchCon != null)
          {
            if(!oBatchCon.isClosed())
            {
              oBatchCon.close();   
            }
          }  
          oBatchCon = null;
        }
        catch(SQLException oSqlExc)
        {
            System.out.println(oSqlExc.getMessage());
        }
        
        throw new EnrgiseSystemException(oSqlEx);        
    }
    /*finally
    {
      try
      {
        if(oBatchCon != null)
        {
          if(!oBatchCon.isClosed())
          {
            oBatchCon.close();            
          }
          oBatchCon = null;
        }
      }
      catch(SQLException oSqlEx)
      {
          System.out.println(oSqlEx.getMessage());
      }
    }*/
  }
  
  public void executeBatch() throws EnrgiseSystemException
  {
    try
    {
      if(!bDynamic)
      {
        oBatchCall.executeBatch();
      }
      else
      {
        oDynamicBatchCall.executeBatch();
      }
      oBatchCon.commit();
    }
    catch(BatchUpdateException oBatchEx)
    {
      System.out.println("Inside Catch "+oBatchEx);
      throw new EnrgiseSystemException(oBatchEx);                    
    }
    catch(SQLException oSqlEx)
    {
        throw new EnrgiseSystemException(oSqlEx);        
    }
    finally
    {
      try
      {
        
        if(oBatchCon != null)
        {
          if(!oBatchCon.isClosed())
          {
            oBatchCon.close();     
            oBatchCon=null;
          }
        }

      }
      catch(SQLException oSqlEx)
      {
        throw new EnrgiseSystemException(oSqlEx);
      }
    }
  }


  public int executeUpsert(ArrayList oParameters,String sQuery) throws EnrgiseSystemException
  {
  
    int iCount = 0;
    
    try
    {
    
        oDataSource = (DataSource) FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sDbName);
        
        
        if(oPreUpsert != null)
        {
          oPreUpsert.close();
          oPreUpsert = null;
        }

        if (oPreUpsertCon != null)
        {
          oPreUpsertCon.close();
          oPreUpsertCon = null;
        }
        

        
        oPreUpsertCon = oDataSource.getConnection();
      
        oPreUpsert = (PreparedStatement)oPreUpsertCon.prepareStatement(sQuery);
        Iterator oIter = oParameters.iterator();
        while(oIter.hasNext())
        {
          InputDBObject oObject = (InputDBObject)oIter.next();
          inspectExecuteParameter(oObject,oPreUpsert);
        }
      
        iCount = oPreUpsert.executeUpdate();          
      
    }
    catch(Exception oExc)
    {
    
     // log.severe(oExc.getMessage());
      oExc.printStackTrace();
      throw new EnrgiseSystemException(oExc);
      
    }
    finally
    {
      try
      {
        if(oPreUpsert != null)
        {
          oPreUpsert.close();
        }
        if(oPreUpsertCon != null)
        {
          if(!oPreUpsertCon.isClosed())
          {
            oPreUpsertCon.close();       
          }
        }
          oPreUpsertCon = null;
          oPreUpsert=null;
        
      }
      catch(SQLException oSqlEx)
      {
       // log.severe(oSqlEx.getMessage());
        throw new EnrgiseSystemException(oSqlEx);
      }
      
      return iCount;
    }

  }
  public ArrayList executeQuery(ArrayList oParameters,String sQuery) throws EnrgiseSystemException
  {
    ResultSet oRs = null;
    ArrayList oResult = null;
          
    
    try
    {
    
        oDataSource = (DataSource) FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sDbName);
        
       
         if(oRs != null)
        {
          oRs.close();
          oRs = null;
        }

        if(oPreParameter != null)
        {
          oPreParameter.close();
          oPreParameter = null;
        }

        if (oPreParameterCon != null)
        {
          oPreParameterCon.close();
          oPreParameterCon = null;
        }
        

        
        oPreParameterCon = oDataSource.getConnection();
      
        oPreParameter = (PreparedStatement)oPreParameterCon.prepareStatement(sQuery);
        Iterator oIter = oParameters.iterator();
        while(oIter.hasNext())
        {
          InputDBObject oObject = (InputDBObject)oIter.next();
          inspectExecuteParameter(oObject,oPreParameter);
        }
      
        oRs = oPreParameter.executeQuery();
        
        if(oRs == null)
        {
          throw new EnrgiseSystemException();
        }
        
        oResult = convertToList(oRs);

      
    }
    catch(Exception oExc)
    {
    
      //log.severe(oExc.getMessage());
      oExc.printStackTrace();
      throw new EnrgiseSystemException(oExc);
      
    }
    finally
    {
      try
      {
        if(oPreParameterCon != null)
        {
          if(!oPreParameterCon.isClosed())
          {
            oPreParameterCon.close();     
            oPreParameterCon=null;
          }
        }
        
         //added by sonia on 10-03-2011
          if(oRs != null)
        {
          oRs.close();
          oRs = null;
        }
        
         if(oPreParameter != null)
        {
          oPreParameter.close();
          oPreParameter=null;
        }

          if (oPreParameterCon != null)
        {
          oPreParameterCon.close();
          oPreParameterCon = null;
        }
        
        //end by sonia on 10-03-2011
        
      }
      catch(SQLException oSqlEx)
      {
       // log.severe(oSqlEx.getMessage());
        throw new EnrgiseSystemException(oSqlEx);
          }
      
      return oResult;
    }

  }
  
  public ArrayList callProc(ArrayList oParameters,String sProcName) throws EnrgiseSystemException
  {
    CallableStatement oCall = null; 
    
    if(oOutParameters == null)
    {      
      oOutParameters = new ArrayList();
    }
    else
    {
      oOutParameters.clear();
    }
    
    try
    {
    
        oDataSource = (DataSource) FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sDbName);
        oCon = oDataSource.getConnection();
        oCon.setAutoCommit(false);
      //oCon = DriverManager.getConnection("jdbc:oracle:thin:@TCS039576:1521:enrgise1", "tempuser", "tempuser");
      
        if(oCall != null)
        {
          oCall.close();
        }
        String sParam = "{ call " + sProcName + "}";
        
        oCall = (CallableStatement)oCon.prepareCall(sParam);
        
		sParam = null;
        
		Iterator oIter = oParameters.iterator();
        while(oIter.hasNext())
        {
          DBObject oObject = (DBObject)oIter.next();
          inspectParameter(oObject,oCall);
		  oObject = null;
        }
        
        oCall.execute();

        Iterator oOutIter = oOutParameters.iterator();
        while(oOutIter.hasNext())
        {
          getOutParameters((DBObject)oOutIter.next(),oCall);
        }
        
        if(oCall != null)
        {
          oCall.close();
        }
        
      DBObject oErr = (DBObject)oOutParameters.get(oOutParameters.size() - 1);
      if( ! oErr.getObject().equals(new Integer(0)))
      {
        oCon.rollback();
        throw new EnrgiseSystemException();
      }
      else
      {
        oCon.commit();
      }
      return oOutParameters;
      
    }
    catch(Exception oExc)
    {    
      System.out.println("Inside Catch "+oExc);
      oExc.printStackTrace();
      throw new EnrgiseSystemException(oExc);
    }
    finally
    {
      try
      {
        if(oCall != null)
        {
          oCall.close();  
          oCall=null;
        }
        if(oCon != null)
        {
          if(!oCon.isClosed())
          {
            oCon.close();  
            oCon = null;
          }
          
        }
      }
      catch(SQLException oSQLExc)
      {
         System.out.println("Connection is still open : HIGH RISK ");
      }
    }

  }

  public ArrayList callProc(ArrayList oParameters,String sProcName,boolean msgFlag,boolean comitFlag) throws EnrgiseSystemException
  {
    CallableStatement oCall = null; 
    
    if(oOutParameters == null)
    {      
      oOutParameters = new ArrayList();
    }
    else
    {
      oOutParameters.clear();
    }
    
    try
    {
        oDataSource = (DataSource) FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sDbName);
        oCon = oDataSource.getConnection();
        oCon.setAutoCommit(false);
      
        if(oCall != null)
        {
          oCall.close();
        }
      
        String sParam = "{ call " + sProcName + "}";
        
        oCall = (CallableStatement)oCon.prepareCall(sParam);
        
        Iterator oIter = oParameters.iterator();
        while(oIter.hasNext())
        {
          DBObject oObject = (DBObject)oIter.next();
          inspectParameter(oObject,oCall);
        }
        
        boolean flag=oCall.execute();
        Iterator oOutIter = oOutParameters.iterator();
        while(oOutIter.hasNext())
        {
          getOutParameters((DBObject)oOutIter.next(),oCall);
        }
        if(oCall != null)
        {
          oCall.close();
        }
        
      DBObject oErr = (DBObject)oOutParameters.get(oOutParameters.size() - 1);
      if( ! oErr.getObject().equals(new Integer(0)))
      {
        oCon.rollback();
        if(msgFlag==false)
          throw new EnrgiseSystemException();
      }
      else
      {
        if(comitFlag)
          oCon.commit();
      }
      return oOutParameters;
    }
    catch(SQLException oExc)
    {    
      System.out.println("Inside Catch "+oExc);
      oExc.printStackTrace();
      throw new EnrgiseSystemException(oExc);
    }
    catch(Exception oExc)
    {    
      System.out.println("Inside Catch "+oExc);
      oExc.printStackTrace();
      throw new EnrgiseSystemException(oExc);
      
    }
    finally
    {
      try
      {
        if(oCall != null)
        {
          oCall.close();  
          oCall=null;
        }
        if(oCon != null)
        {
          if(!oCon.isClosed())
          {
            oCon.close();  
            oCon = null;
          }
         
        }
      }
      catch(SQLException oSQLExc)
      {
         System.out.println("Connection is still open : HIGH RISK");
      }
    }
  }


  public ArrayList executeQuery(String sQuery) throws EnrgiseSystemException
  {
    
    PreparedStatement oPre = null;
    ArrayList oResult = null;

    try
    {
        oDataSource = (DataSource) FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sDbName);
        
        if(oRs != null)
        {
          oRs.close();
          oRs = null;
        }

        if(oPre != null)
        {
          oPre.close();
        }

        if (oConn != null)
        {
          oConn.close();
          oConn = null;
        }
        
        oConn = oDataSource.getConnection();
        //oConn = DriverManager.getConnection("jdbc:oracle:thin:@TCS039576:1521:enrgise1", "tempuser", "tempuser");
       // log.severe("basu2");
      
      //oPre = (OraclePreparedStatement)oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
   //   log.severe(sQuery);
      
      oPre = (PreparedStatement)oConn.prepareStatement(sQuery);
      //log.severe("basu3");

      oRs = oPre.executeQuery();
      
      oResult = convertToList(oRs);

    }
    catch(SQLException oExc)
    {
     // log.severe("From DBUtility " + oExc.getClass().getName() + " " + oExc.getMessage());
      throw new EnrgiseSystemException(oExc);
    }
    finally
    {
      try
      {
        if(oRs != null)
        {
          oRs.close();
          oRs = null;
        }

        if(oPre != null)
        {
          oPre.close();
          oPre=null;
        }

        if (oConn != null)
        {
          oConn.close();
          oConn = null;
        }
      }
      catch(SQLException oSqEx)
      {
        throw new EnrgiseSystemException(oSqEx);
      }
      return oResult;
    }
  }
  
  public int executeUpsert(String sQuery) throws EnrgiseSystemException
  {
    
    PreparedStatement oPre = null;
    Connection oPreCon = null;
    int iCount = 0;

    try
    {
  
    
        oDataSource = (DataSource) FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService(sDbName);
        
        
        if(oPre != null)
        {
          oPre.close();
        }

        oPreCon = oDataSource.getConnection();
        //oConn = DriverManager.getConnection("jdbc:oracle:thin:@TCS039576:1521:enrgise1", "tempuser", "tempuser");
      
      oPre = (PreparedStatement)oPreCon.prepareStatement(sQuery);

      iCount = oPre.executeUpdate();

    }
    catch(SQLException oExc)
    {
     // log.severe("From DBUtility " + oExc.getClass().getName() + " " + oExc.getMessage());

      throw new EnrgiseSystemException(oExc);
      
    }
    finally
    {
      try
      {
        if(oPreCon != null)
        {
          if(!oPreCon.isClosed())
          {
          
          
            oPreCon.close();
            oPreCon=null;
            
          }
        }
        if(oPre != null)
        {
         
          
          
            oPre.close();
            oPre=null;
            
         
        }
        
      }
      catch(SQLException oSqEx)
      {
        throw new EnrgiseSystemException(oSqEx);
      }
      return iCount;
    }

  }

  private void inspectParameter(DBObject oDBObject,CallableStatement oCall) throws SQLException
  {
    Object oObject;
    int iPosition = oDBObject.getPosition();
    int iDirection = oDBObject.getDirection();
    int iDataType = oDBObject.getDataType();

      if((iDirection == FCIPAY.Payroll.EJB.common.helper.DBObject.IN) || (iDirection == FCIPAY.Payroll.EJB.common.helper.DBObject.INOUT))
      {
        oObject = oDBObject.getObject();
        switch(iDataType)
        {
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR:
            if(oObject != null)
            {
              oCall.setString(iPosition,oObject.toString());              
            }
            else
            {
              oCall.setString(iPosition,null);                            
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER:
            if(oObject != null)
            {              
              oCall.setInt(iPosition,Integer.parseInt(oObject.toString()));
            }
            else
            {
              oCall.setInt(iPosition,0);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DOUBLE:
            if(oObject != null)
            {              
              oCall.setDouble(iPosition,Double.parseDouble(oObject.toString()));
            }
            else
            {
              oCall.setDouble(iPosition,0);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT:
            if(oObject != null)
            {
              oCall.setLong(iPosition,((Long)oObject).longValue());              
            }
            else
            {
              oCall.setLong(iPosition,0);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DATE:
            if(oObject != null)
            {
              oCall.setDate(iPosition,(Date)oObject);              
            }
            else
            {
              oCall.setDate(iPosition,null);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.TIMESTAMP:
            if(oObject != null)
            {
              oCall.setTimestamp(iPosition,(Timestamp)oObject);              
            }
            else
            {
              oCall.setTimestamp(iPosition,null);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.JAVA_OBJECT:
            if(oObject != null)
            {
              oCall.setObject(iPosition,oObject);              
            }
            else
            {
              oCall.setObject(iPosition,null);
            }
            break;
        }
			oObject = null;   
	  }
      
      if((iDirection == FCIPAY.Payroll.EJB.common.helper.DBObject.OUT) || (iDirection == FCIPAY.Payroll.EJB.common.helper.DBObject.INOUT))
      {
        oCall.registerOutParameter(iPosition,iDataType);
        DBObject oTestDBObject=new DBObject(iPosition,iDataType);
        oOutParameters.add(oTestDBObject);
        oTestDBObject = null;
      }
    
  }

  private void inspectExecuteParameter(InputDBObject oDBObject,PreparedStatement oCall) throws SQLException
  {
    Object oObject;
    int iPosition = oDBObject.getPosition();
    int iDataType = oDBObject.getDataType();

  
        oObject = oDBObject.getObject();
        switch(iDataType)
        {
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR:
            if(oObject != null)
            {
              oCall.setString(iPosition,oObject.toString());              
            }
            else
            {
              oCall.setString(iPosition,null);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CHAR:
            if(oObject != null)
            {
              oCall.setString(iPosition,oObject.toString());              
            }
            else
            {
              oCall.setString(iPosition,null);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER:
            if(oObject != null)
            {
              oCall.setInt(iPosition,Integer.parseInt(oObject.toString()));              
            }
            else
            {
              oCall.setInt(iPosition,0);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DOUBLE:
            if(oObject != null)
            {
              oCall.setDouble(iPosition,Double.parseDouble(oObject.toString()));              
            }
            else
            {
              oCall.setDouble(iPosition,0);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT:
            if(oObject != null)
            {
              oCall.setLong(iPosition,((Long)oObject).longValue());              
            }
            else
            {
              oCall.setLong(iPosition,0);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DATE:
            if(oObject != null)
            {
              oCall.setDate(iPosition,(Date)oObject);              
            }
            else
            {
              oCall.setDate(iPosition,null);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.TIMESTAMP:
            if(oObject != null)
            {
              oCall.setTimestamp(iPosition,(Timestamp)oObject);              
            }
            else
            {
              oCall.setTimestamp(iPosition,null);
            }
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.JAVA_OBJECT:
            oCall.setObject(iPosition,oObject);
            break;
        }
    }
    
  private void getOutParameters(DBObject oOutDBObject,CallableStatement oCall) throws SQLException,EnrgiseSystemException
  {
   int iPosition = oOutDBObject.getPosition();
   int iDataType = oOutDBObject.getDataType();
   
        switch(iDataType)
        {
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR:
            oOutDBObject.setObject(oCall.getString(iPosition));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CHAR:
            oOutDBObject.setObject(oCall.getString(iPosition));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER:
            oOutDBObject.setObject(new Integer(oCall.getInt(iPosition)));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT:
            oOutDBObject.setObject(new Long(oCall.getLong(iPosition)));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DOUBLE:
            oOutDBObject.setObject(new Double(oCall.getDouble(iPosition)));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DATE:
            oOutDBObject.setObject(oCall.getDate(iPosition));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.TIMESTAMP:
            oOutDBObject.setObject(oCall.getTimestamp(iPosition));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.JAVA_OBJECT:
            oOutDBObject.setObject(oCall.getObject(iPosition));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR:
            oOutDBObject.setObject(convertToList((ResultSet)oCall.getObject(iPosition)));
        }
  }
  
  private ArrayList convertToList(ResultSet oRs2) throws SQLException,EnrgiseSystemException
  {
 
    if(null == oRs2)
    {
      return null;
    }
    ResultSetMetaData oRsMt = oRs2.getMetaData();
    ArrayList oList = new ArrayList();
     try{
    int iColumnCount = oRsMt.getColumnCount();
    int iIndex = 0;
    

		String [] sColumnName = new String[iColumnCount];
		int [] iColumnType = new int[iColumnCount];
    
		for (iIndex = 0; iIndex < iColumnCount; ++iIndex)
    {
			sColumnName[iIndex] = oRsMt.getColumnName(iIndex + 1);
			iColumnType[iIndex] = oRsMt.getColumnType(iIndex + 1);
		}
    
    while(oRs2.next())
    {
      QueryRow oRow = new QueryRow(iColumnCount);
      for(iIndex = 0; iIndex < iColumnCount; ++iIndex)
      {
        QueryValue oValue = new QueryValue();
        setValue(sColumnName[iIndex],iColumnType[iIndex],oValue,oRs2);
       // System.out.println(oValue);
        oRow.getRow().put(sColumnName[iIndex].toUpperCase(),oValue);
      }
      oList.add(oRow);
    }
     }
      catch(SQLException oExc)
    {    

      throw new EnrgiseSystemException(oExc);
      
    }
    
    
    finally
    {
      try
      {
        if(oRs2 != null)
        {
            oRs2.close();
            oRs2=null;
            
       }
        
         if(oRsMt != null)
        {
           
            oRsMt=null;
        }
      
        
      }
      catch(SQLException oSqEx)
      {
        throw new EnrgiseSystemException(oSqEx);
      }
    
    }
    
   return oList; 
  }
  
  private void setValue(String sColumnName,int iColumnType,QueryValue oValue,ResultSet oRs2) throws SQLException
  {
    switch(iColumnType)
    {
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.NUMBER:
            oValue.setString(oRs2.getString(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR:
            oValue.setString(oRs2.getString(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CHAR:
            oValue.setString(oRs2.getString(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER:
            oValue.setInt(oRs2.getInt(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT:
            oValue.setLong(oRs2.getLong(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DOUBLE:
            oValue.setDouble(oRs2.getDouble(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.DATE:
            oValue.setDate(oRs2.getDate(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.TIMESTAMP:
            oValue.setTimestamp(oRs2.getTimestamp(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BLOB:
            oValue.setBlob(oRs2.getBlob(sColumnName));
            break;
          case FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CLOB:
            oValue.setClob(oRs2.getClob(sColumnName));
            break;
        }
      
    }
    

    protected void finalize()
    {
      try
      {
        close();        
      }
      catch(SQLException oSqlEx)
      {
        
      }
    }
    
    private void close() throws SQLException
    {
      if(oCon != null)
      {
        if(!oCon.isClosed())
        {
          oCon.close();
        }
        
        oCon = null;
      }
      
      if(oConn != null)
      {
        if(!oConn.isClosed())
        {
          oConn.close();
        }
        
        oConn = null;
      }
    }
  
}