package FCIPAY.HRMS.DATAACCESSTIER.DAO;
/*
 * Module:        LeaveMastDAO.java
 * Author:        Moon Nag Sarkar
 * Date Written:  04/09/2003
* Description:  This class is used to connect to database and retrieve and insert values into it.
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
import FCIPAY.HRMS.UTILITY.Connectiondb;
import FCIPAY.HRMS.DATAACCESSTIER.VO.LeaveMastVO;

import FCIPAY.HRMS.UTILITY.DrcrtList;
import java.util.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.lang.*;
import FCIPAY.COMMON.UTILITY.*;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class LeaveMastDAO extends BaseDAO
{
 
  Connectiondb oconn;
  int eCode=0;
  private long lID=0;
  private String sName=null; 
  private long sHead=0;
  private String sLeave=null;

  public LeaveMastDAO()
  {
      super("HRMS");       
  }
    
  public boolean setVO(LeaveMastVO oCvo,int piProcessFlag) throws IBAException,IBABusinessException,IBAFatalException
  {
    String sQuery=null; 
    String iQuery=null; 
    String uQuery=null;
    int iInsFlg=0;
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    try{
      if(piProcessFlag==0)
      {
       
        iQuery="insert into hrm_leave_mast(LEAVE_ID,LEAVE_SDESC,LEAVE_LDESC,MAX_LIMIT_1,MAX_LIMIT_2,MAX_LIMIT_3,MAX_LIMIT_FREQ,MIN_EXP_REQ,applicable_to,DISPLAY_FLG,USER_ID_CREATED,CREATED_SITE_ID,CREATED_TIME_STMP) values(get_id(" + oCvo.getLocCode() + ",'hrm_leave_mast'),'" + oCvo.getSLEAVE_SDESC() + "','" 
          + oCvo.getSLEAVE_LDESC() + "'," + oCvo.getSMAX_LIMIT_1() + "," + oCvo.getSMAX_LIMIT_2() + "," + oCvo.getSMAX_LIMIT_3() + ",'" + oCvo.getMAX_LIMIT_FREQ() + "','" + oCvo.getSMIN_EXP_REQ() + "','" + oCvo.getlstApply() + "','" + oCvo.getSDISPLAY_FLG() + "'," + oCvo.getEmpno()+"," + oCvo.getLocCode() + ",sysdate)";
        iInsFlg=oBean.executeUpsert(iQuery);
 
        if(iInsFlg>0)
            return true;
        else
            return false;
     }
     else
     {       
          uQuery = "update hrm_leave_mast set  LEAVE_SDESC = '" + oCvo.getSLEAVE_SDESC() + "',LEAVE_LDESC= '" + oCvo.getSLEAVE_LDESC() + "', MAX_LIMIT_1 = " + oCvo.getSMAX_LIMIT_1() + ",MAX_LIMIT_2 = " + oCvo.getSMAX_LIMIT_2() + ",MAX_LIMIT_3 = " + oCvo.getSMAX_LIMIT_3() + ",MAX_LIMIT_FREQ='" + oCvo.getMAX_LIMIT_FREQ() + "',MIN_EXP_REQ=" + oCvo.getSMIN_EXP_REQ() + ",applicable_to='" + oCvo.getlstApply() + "',DISPLAY_FLG='" + oCvo.getSDISPLAY_FLG() + "',USER_ID_MODIFIED=" + oCvo.getEmpno() + ",MODIFIED_SITE_ID=" + oCvo.getLocCode() + ", MODIFIED_TIME_STMP=sysdate where LEAVE_ID = " + oCvo.getSLEAVE_ID();   
         iInsFlg=oBean.executeUpsert(uQuery);
         if(iInsFlg>0)
              return true;
         else
              return false;
     } 
    }catch (Exception e ) 
    {
      e.printStackTrace();
     }
    return false;  
 }

 
public ArrayList getLeaveDetails() {
        String sN=null;
        long sI=0;
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray=new ArrayList();
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oLeaveVOs=new ArrayList();
    
    String sQuery="select LEAVE_SDESC,LEAVE_ID from HRM_LEAVE_MAST ORDER BY LEAVE_SDESC";
    try{
         
          oOutArray=oBean.executeQuery(sQuery);
          oIt = oOutArray.iterator();
          while(oIt.hasNext()) 
          {

            oRow = (QueryRow)oIt.next();
            sI=Long.parseLong(oRow.get("LEAVE_ID").getString());
            sN=oRow.get("LEAVE_SDESC").getString();
            oLeaveVOs.add(new DrcrtList(sI,sN));
          }

           return oLeaveVOs;
         
          }catch(Exception e){
            oLeaveVOs=null;           
          }
               return oLeaveVOs;          
  }


public ArrayList getDetails()throws IBABusinessException,IBAFatalException,IBAException
{
  

  LeaveMastVO oLeaveMastVO;
  String sQuery="select LEAVE_ID,LEAVE_SDESC,LEAVE_LDESC,NVL(MAX_LIMIT_1,0) as MAX_LIMIT_1,NVL(MAX_LIMIT_2,0) as MAX_LIMIT_2,NVL(MAX_LIMIT_3,0)as MAX_LIMIT_3,NVL(MAX_LIMIT_FREQ,' ') as MAX_LIMIT_FREQ,NVL(MIN_EXP_REQ,0) as MIN_EXP_REQ,DISPLAY_FLG ,NVL(applicable_to,' ') as applicable_to from HRM_LEAVE_MAST "; //where VENUE_ID="+oLeaveMastVO.gettxtLeaveID();
  ArrayList oLeaveMastVOs = new ArrayList();
  Iterator oIt = null;
  QueryRow oRow = null;      
  ArrayList oOutArray=new ArrayList();
  ArrayList oParameters = new ArrayList(); //Input Parameters
  DBUtilitiesBean oBean = new DBUtilitiesBean();
  try
  {
            oOutArray=oBean.executeQuery(sQuery);
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              oLeaveMastVO = new LeaveMastVO();
              
              oLeaveMastVO.setMAX_LIMIT_FREQ(oRow.get("MAX_LIMIT_FREQ").getString());
              oLeaveMastVO.setSLEAVE_ID(Long.parseLong(oRow.get("LEAVE_ID").getString()));             
              oLeaveMastVO.setSLEAVE_LDESC(oRow.get("LEAVE_LDESC").getString()); 
              oLeaveMastVO.setSLEAVE_SDESC(oRow.get("LEAVE_SDESC").getString()); 
              oLeaveMastVO.setSMAX_LIMIT_1(Long.parseLong(oRow.get("MAX_LIMIT_1").getString()));
              oLeaveMastVO.setSMAX_LIMIT_2(Long.parseLong(oRow.get("MAX_LIMIT_2").getString()));
              oLeaveMastVO.setSMAX_LIMIT_3(Long.parseLong(oRow.get("MAX_LIMIT_3").getString()));
              oLeaveMastVO.setSMIN_EXP_REQ(Long.parseLong(oRow.get("MIN_EXP_REQ").getString()));
              oLeaveMastVO.setMAX_LIMIT_FREQ(oRow.get("MAX_LIMIT_FREQ").getString());
              oLeaveMastVO.setSDISPLAY_FLG(oRow.get("DISPLAY_FLG").getString());
              oLeaveMastVO.setlstApply(oRow.get("applicable_to").getString());
              oLeaveMastVOs.add(oLeaveMastVO);
            }
       

      
  }catch(Exception e){           
            
            e.printStackTrace();
        }
      return oLeaveMastVOs;
}


  
}

