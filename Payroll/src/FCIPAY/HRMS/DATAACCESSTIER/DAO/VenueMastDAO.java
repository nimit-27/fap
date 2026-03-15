package FCIPAY.HRMS.DATAACCESSTIER.DAO;
/*
 * Module:        VenueMastDAO.java
 * Author:        Moon Nag Sarkar
 * Date Written:  04/09/2003
* Description:  This class is used to connect to database and retrieve and insert values into it.
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
import FCIPAY.HRMS.UTILITY.Connectiondb;
import FCIPAY.HRMS.DATAACCESSTIER.VO.VenueMastVo;
import FCIPAY.HRMS.UTILITY.UnitList;
import FCIPAY.HRMS.UTILITY.VenueList;
import java.util.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.lang.*;
import java.sql.SQLException;
import FCIPAY.COMMON.UTILITY.*;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class VenueMastDAO extends BaseDAO
{
    Connectiondb oconn;
    int eCode=0;

    public VenueMastDAO()
    {
        super("HRMS");       
    }
    
    public boolean setVo(VenueMastVo oCvo,int piProcessFlag)throws IBAException,IBABusinessException,IBAFatalException
    {
        String sQuery=null;
        long lVenId=0;  
        long lSiteid=1,lUserid=1;
   
      System.out.print("Dao:setDetails--into");
      oconn=new Connectiondb();
      if(piProcessFlag==0)
      {
        sQuery="insert into hrm_venue_mast values(" + oCvo.gettxtUnitId() + ",get_id(" + oCvo.getLLocCode()  + ",'hrm_venue_mast'),'" + oCvo.gettxtNearRailStn()+ "','"
        + oCvo.gettxtBusFrom() + "'," + oCvo.gettxtBusNo() + ",'" 
        + oCvo.gettxtBusStop() + "',"+oCvo.getLEmpno()+","+oCvo.getLLocCode()+",sysdate,'','','')";
      }
      else
      {
        if(piProcessFlag==1)
        {
            sQuery="update hrm_venue_mast set  VENUE_UNIT_ID=" + oCvo.gettxtUnitId() + ", VENUE_NRST_RLWY_STN='" + oCvo.gettxtNearRailStn() + "',VENUE_BUS_FROM='" + oCvo.gettxtBusFrom() + "',VENUE_BUS_NO='" + oCvo.gettxtBusNo() +"',VENUE_BUS_STOP='" + oCvo.gettxtBusStop() + "',MODIFIED_USER_ID=" + oCvo.getLEmpno() + ",MODIFIED_SITE_ID=" + oCvo.getLLocCode() + ", MODIFIED_TIME_STMP=sysdate where VENUE_ID=" + oCvo.getlstVenue();        
        }
      }
      if(oconn.InsertRecord(sQuery))
      {
        return true;
      }
return false;
}     
public ArrayList getUnitDetails()throws IBABusinessException,IBAFatalException,IBAException  
{
    String sUnitDesc=null;
    long lUnitID=0;    
    ArrayList oUnitMastVos=new ArrayList();
    String sQuery="SELECT DISTINCT LOC_ID, L.LOC_DESC LOC_SDESC,l.loc_type_gbl FROM  COM_LOC_MST L ORDER BY L.LOC_DESC";
    
    Iterator oIt = null;
    QueryRow oRow = null;      
    ArrayList oOutArray;     
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    try
    {
        oOutArray = oBean.executeQuery(sQuery);
        oIt = oOutArray.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            lUnitID=Long.parseLong(oRow.get("LOC_ID").getString());
            sUnitDesc=(oRow.get("LOC_SDESC").getString());
            oUnitMastVos.add(new UnitList(lUnitID,sUnitDesc));
        }
//        closeConnection();
        return oUnitMastVos; 
        }
        catch(Exception e)
        {
            oUnitMastVos=null;           
        }
    return oUnitMastVos;          
}




 public ArrayList getVenueDetails()throws IBABusinessException,IBAFatalException,IBAException {
long sN,sI;    
    ResultSet rs=null ;

    ArrayList oVenueVos=new ArrayList();
    
    String sQuery="select Venue_Id from HRM_VENUE_MAST ORDER BY Venue_Id";
    Connection oConn ;  
    try{
          oConn = getConnection();
          if(oConn == null)
              System.out.println("fail");
          Statement st = oConn.createStatement();
          rs=st.executeQuery(sQuery);
         
          while (rs.next())
          {
            sN=rs.getLong("VENUE_ID");
            sI=sN;
            oVenueVos.add(new VenueList(sI,sN));
            System.out.println(sN);
          }
           System.out.println(oVenueVos.size()); 
           oConn.close();           
//            closeConnection();
           return oVenueVos;
         
          }catch(Exception e){
            oVenueVos=null;
            oConn=null;
  //          closeConnection();            
          }
               return oVenueVos;          
  }




 

public ArrayList getDetails()throws IBABusinessException,IBAFatalException,IBAException
{
  long lVenId=0,lVenUid=0;
  
  String sRly=null;
  String sBusStop=null;
  String sBusFrom=null;
  int iBusNo=0;
  ResultSet rs=null;
  VenueMastVo oVenueMastVo;//=new VenueMastVo();
  String sQuery="select VENUE_UNIT_ID,VENUE_ID,VENUE_NRST_RLWY_STN,VENUE_BUS_FROM,VENUE_BUS_NO,VENUE_BUS_STOP from HRM_VENUE_MAST "; //where VENUE_ID="+oVenueMastVo.gettxtVenueId();
  ArrayList oVenueMastVos = new ArrayList();
  Connection oConn;
  try
  {
            oConn = getConnection();
            if(oConn == null)
                System.out.println("fail");
            Statement st = oConn.createStatement();
            System.out.println(sQuery);
            rs=st.executeQuery(sQuery);
             if (rs!=null){
               System.out.println("DAO:Executed Query");
             }
            while(rs.next())
            {
              oVenueMastVo = new VenueMastVo();
              lVenId=rs.getLong("VENUE_ID");
               System.out.println("DAO:VenueId="+lVenId);
              lVenUid=rs.getLong("VENUE_UNIT_ID");
              sRly=rs.getString("VENUE_NRST_RLWY_STN");
              sBusFrom=rs.getString("VENUE_BUS_FROM");
              iBusNo=rs.getInt("VENUE_BUS_NO");
              sBusStop=rs.getString("VENUE_BUS_STOP");
              oVenueMastVo.setlstVenue(lVenId);
              oVenueMastVo.settxtUnitId(lVenUid);
              oVenueMastVo.settxtNearRailStn(sRly);
              oVenueMastVo.settxtBusFrom(sBusFrom);
              oVenueMastVo.settxtBusNo(iBusNo);
              oVenueMastVo.settxtBusStop(sBusStop);
               System.out.println(oVenueMastVo.gettxtBusNo());
              oVenueMastVos.add(oVenueMastVo);
            }
            System.out.println(oVenueMastVos.size());
            oConn.close();
//            closeConnection();
            return oVenueMastVos;
  }
            catch(SQLException SQLEx){                
            eCode = SQLEx.getErrorCode();
            System.out.println("The error code is IBA Fatal Exception");
            oConn=null;
            closeConnection();            
            throw new IBAFatalException("HRMS.Master.RecordNotFound");
          }catch(Exception e){
            oConn=null;
            closeConnection();            
            System.out.println("An Exception has occurred"+ e.getMessage());                
            e.printStackTrace();
        }
      return oVenueMastVos;
}


  
}


