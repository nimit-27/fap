/*
 * Module:        HolidayMasterDAO.java
 * Author:        Prem K. Barai
 * Date Written:  02/06/2004
 * Description:   DAO for the Holiday Master
 * Revision Log  (mm/dd/yy initials description)
 * --------------------------------------------------------
 * mm/dd/yy xxx  What you changed
 */


package FCIPAY.HRMS.DATAACCESSTIER.DAO;

import java.util.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import FCIPAY.HRMS.DATAACCESSTIER.VO.HolidayMasterVO;
import FCIPAY.HRMS.DATAACCESSTIER.VO.HolidayMaster_MasterPaneVO;
import FCIPAY.HRMS.DATAACCESSTIER.SQLQueries.HolidayMasterSQLQueries;
import FCIPAY.COMMON.UTILITY.DSConnect;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;
import FCIPAY.COMMON.UTILITY.MsgLogger;
import FCIPAY.HRMS.UTILITY.QualfnList;
import FCIPAY.HRMS.UTILITY.UnitList;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class HolidayMasterDAO extends BaseDAO
{
   private String sQueryString = null;  
   MsgLogger oMsgLogger = (MsgLogger) MsgLogger.getLogger(this);
   
   public HolidayMasterDAO()
   {
      super("HRMS");   
   }

    /** Function to save the information in <HRM_HOLIDAY_MAST, HRM_HOLIDAY_DTL>.
     * @param       :   char, Value Object, ArrayList. 
     * @exception   :   IBAFatalException, SQLException.
     * @return      :   boolean.
     */
   public boolean setHrmHolidayMastDetails(char flag, HolidayMaster_MasterPaneVO oHolidayMaster_MasterPaneVO, ArrayList oHolidayMasterVOs) throws IBAFatalException, SQLException
   {
        long lHolidayMastId=0;
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray=new ArrayList();
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int iInsFlg=0;
      try {
         if(flag == 'i')
         {
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMaster_MasterPaneVO.getLSiteId())));
            oOutArray = oBean.executeQuery(oParameters,HolidayMasterSQLQueries.SELECT_HRM_HOLIDAY_MAST_ID);
            oIt = oOutArray.iterator();
            while(oIt.hasNext()) 
            {
              oRow = (QueryRow)oIt.next();
              lHolidayMastId = Long.parseLong(oRow.get("LHOLIDAYMASTID").getString());
            }
           

            sQueryString = HolidayMasterSQLQueries.INSERT_HRM_HOLIDAY_MAST;
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(lHolidayMastId)));
            System.out.println(Long.parseLong(oHolidayMaster_MasterPaneVO.getTxtLocation()));
            System.out.println(oHolidayMaster_MasterPaneVO.getTxtLocation());
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oHolidayMaster_MasterPaneVO.getTxtLocation()))));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMaster_MasterPaneVO.getTxtWeeklyOff1()));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMaster_MasterPaneVO.getTxtWeeklyOff2()));
            oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMaster_MasterPaneVO.getTxtYear()));
            oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMaster_MasterPaneVO.getLUserId())));
            oParameters.add(new InputDBObject(7,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMaster_MasterPaneVO.getLSiteId())));
            iInsFlg=oBean.executeUpsert(oParameters,HolidayMasterSQLQueries.INSERT_HRM_HOLIDAY_MAST);
            System.out.println("iInsFlg="+iInsFlg);
            if(iInsFlg>0)
            {  
               sQueryString = HolidayMasterSQLQueries.INSERT_HRM_HOLIDAY_DTL;
               for(int i=0; i < oHolidayMasterVOs.size(); i++)
               {  
                  HolidayMasterVO oHolidayMasterVO = (HolidayMasterVO) oHolidayMasterVOs.get(i);
//                  pStmt.setLong(1, Long.parseLong(oHolidayMaster_MasterPaneVO.getTxtLocation()));
                  oParameters = new ArrayList();
                  oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMasterVO.getLSiteId())));
                  oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(lHolidayMastId)));
                  oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getHoliday_Date()));
                  oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getHoliday_Name()));
                  oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMasterVO.getLUserId())));
                  oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMasterVO.getLSiteId())));
                  oParameters.add(new InputDBObject(7,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getScheck()));
                  oBean.executeUpsert(oParameters,HolidayMasterSQLQueries.INSERT_HRM_HOLIDAY_DTL);
               } 
              /* if(iInsFlg == oHolidayMasterVOs.size())
               {
                  oMsgLogger.logDEBUG("Transaction Commited in Insert Mode");
               }
               else
              {     
                 oMsgLogger.logDEBUG("Transaction Rolled Back in Insert Mode");
              }*/
            }
            else
            {      
               oMsgLogger.logDEBUG("Transaction Rolled Back in Insert Mode");  
            }  
         }
         else if(flag == 'e')
         {
            sQueryString = HolidayMasterSQLQueries.UPDATE_MASTER_PANE;
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oHolidayMaster_MasterPaneVO.getTxtLocation()))));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMaster_MasterPaneVO.getTxtWeeklyOff1()));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMaster_MasterPaneVO.getTxtWeeklyOff2()));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMaster_MasterPaneVO.getLUserId())));
            oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMaster_MasterPaneVO.getLSiteId())));
            oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oHolidayMaster_MasterPaneVO.getHolidayId()))));
            iInsFlg=oBean.executeUpsert(oParameters,sQueryString);     

            if(iInsFlg>0)
            {
               sQueryString = HolidayMasterSQLQueries.UPDATE_DETAIL_PANE;
               for(int i=0; i < oHolidayMasterVOs.size(); i++)
               {
                  HolidayMasterVO oHolidayMasterVO = (HolidayMasterVO) oHolidayMasterVOs.get(i);
                  oParameters = new ArrayList();
                  oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getHoliday_Date()));
                  oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getHoliday_Name()));
                  oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMasterVO.getLUserId())));
                  oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMasterVO.getLSiteId())));
                  oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getScheck()));
                  oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oHolidayMasterVO.getSholidayDetailId()))));
                  oParameters.add(new InputDBObject(7,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oHolidayMasterVO.getSholidayMasterId()))));
                  
                  oBean.executeUpsert(oParameters,sQueryString);               
                }
              /* if(pStmt.executeBatch().length == oHolidayMasterVOs.size())
               {
                 oConn.commit();
                 oMsgLogger.logDEBUG("Transaction Commited in Edit Mode");                                  
                 oConn.setAutoCommit(true);
                 oDsConn.closeConn(oConn);            
                 oDsConn=null;
               }
               else
              {
                 oConn.rollback();        
                 oMsgLogger.logDEBUG("Transaction Rolled Back in Edit Mode");                                                   
                 pStmt.close();
                 oDsConn.closeConn(oConn);
                 oDsConn = null;
              }*/
            }
            else
            {     
               oMsgLogger.logDEBUG("Transaction Rolled Back in Edit Mode");  
            }
         }
         else if(flag == 'u')
         {
            sQueryString = HolidayMasterSQLQueries.INSERT_HRM_HOLIDAY_DTL;
            for(int i=0; i < oHolidayMasterVOs.size(); i++)
            {
               HolidayMasterVO oHolidayMasterVO = (HolidayMasterVO) oHolidayMasterVOs.get(i);
               oParameters = new ArrayList();
               oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oHolidayMaster_MasterPaneVO.getTxtLocation()))));
               oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oHolidayMasterVO.getSholidayMasterId()))));
               oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getHoliday_Date()));
               oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getHoliday_Name()));
               oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMasterVO.getLUserId())));
               oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oHolidayMasterVO.getLSiteId())));
               oParameters.add(new InputDBObject(7,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oHolidayMasterVO.getScheck()));
               oBean.executeUpsert(oParameters,sQueryString);
            }
           /* if(pStmt.executeBatch().length == oHolidayMasterVOs.size())
            {
              oMsgLogger.logDEBUG("Transaction Commited in Add Insert Mode");
            }
            else
            {       
              oMsgLogger.logDEBUG("Transaction Rolled Back in Add Insert Mode");
            }      */      
         }
         else
         {      
            oMsgLogger.logDEBUG("Transaction Rolled Back in Add Insert Mode"); 
         }
      } catch(Exception e) {
            e.printStackTrace();
            throw new IBAFatalException("HRMS.DBError.General");
      }
      return true;
   }

    /** Function to get the information from <COM_LOC_MST, HRM_HOLIDAY_MAST>.
     * @param       :   ArrayList. 
     * @exception   :   IBAFatalException.
     */
  public void setYearAndLocation(ArrayList oHolidayMasterVOs) throws IBAFatalException
  {
      HolidayMaster_MasterPaneVO oHolidayMaster_MasterPaneVO = new HolidayMaster_MasterPaneVO();
      
      Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray=new ArrayList();
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
      try {
         oOutArray=oBean.executeQuery(HolidayMasterSQLQueries.SELECT_HRM_YEAR_AND_LOCATION);
         oIt = oOutArray.iterator();
         while(oIt.hasNext())
         {
           oRow = (QueryRow)oIt.next();
           oHolidayMaster_MasterPaneVO=new HolidayMaster_MasterPaneVO(); 
           oHolidayMaster_MasterPaneVO.setTxtYear(oRow.get("CALENDAR_YEAR").getString());
           oHolidayMaster_MasterPaneVO.setTxtYearAndLocation(oRow.get("LOC_SDESC").getString() + "-" + oRow.get("CALENDAR_YEAR").getString());
           oHolidayMaster_MasterPaneVO.setHolidayId(oRow.get("HOLIDAY_ID").getString());
           oHolidayMaster_MasterPaneVO.setTxtWeeklyOff1(oRow.get("WEEKLY_OFF_1").getString());
           oHolidayMaster_MasterPaneVO.setTxtWeeklyOff2(oRow.get("WEEKLY_OFF_2").getString());
           oHolidayMaster_MasterPaneVO.setTxtLocationCode(oRow.get("LOC_CODE").getString());
           oHolidayMasterVOs.add(oHolidayMaster_MasterPaneVO);
         }

      } catch(Exception e) {
            oMsgLogger.logERROR(e.getMessage());
            e.printStackTrace();
            throw new IBAFatalException("HRMS.DBError.General");
      }
  }

    /** Function to get the information from <HRM_HOLIDAY_DTL>.
     * @return       :   ArrayList. 
     * @exception   :   IBAFatalException.
     */  
  public ArrayList getRecord() throws IBAFatalException
  {
     HolidayMasterVO oHolidayMasterVO = null;
     ArrayList oHolidayMasterVOs = new ArrayList();
     
      Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray=new ArrayList();
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
      try {
         oOutArray = oBean.executeQuery(HolidayMasterSQLQueries.SELECT_DETAIL_PANE);
          
         oIt = oOutArray.iterator();
         while(oIt.hasNext()) 
         {
           oRow = (QueryRow)oIt.next();
           oHolidayMasterVO=new HolidayMasterVO(); 
           oHolidayMasterVO.setSholidayDetailId(oRow.get("HOLIDAY_DTL_ID").getString());
           oHolidayMasterVO.setSholidayMasterId(oRow.get("HOLIDAY_MAST_ID").getString());
           oHolidayMasterVO.setHoliday_Date(oRow.get("HOLIDAY_DATE").getString());
           oHolidayMasterVO.setHoliday_Name(oRow.get("HOLIDAY_CODE_GBL").getString());
           oHolidayMasterVO.setScheck(oRow.get("HOLIDAY_STATUS_FLG").getString());
           oHolidayMasterVOs.add(oHolidayMasterVO);
         }

       } catch(Exception e) {
            oMsgLogger.logERROR(e.getMessage());
            e.printStackTrace();
            throw new IBAFatalException("HRMS.DBError.General");
       }         
     return oHolidayMasterVOs;
  }

  public ArrayList getHolidays(HolidayMasterVO tempVO) throws IBAFatalException
  {
     HolidayMasterVO oHolidayMasterVO = null;
     ArrayList oHolidayMasterVOs = new ArrayList();
     Iterator oIt = null;
     QueryRow oRow = null;      
     ArrayList oOutArray=new ArrayList();
     ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
      try {
         oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(tempVO.getLSiteId())));
         oOutArray = oBean.executeQuery(oParameters,HolidayMasterSQLQueries.SELECT_HOLIDAYS);
         oIt = oOutArray.iterator();
         while(oIt.hasNext()) 
         {
            oRow = (QueryRow)oIt.next();
           oHolidayMasterVO=new HolidayMasterVO(); 
           oHolidayMasterVO.setHoliday_Date(oRow.get("HOLIDAY_DATE").getString());
           oHolidayMasterVO.setHoliday_Name(oRow.get("CODE_DESC").getString());
           oHolidayMasterVOs.add(oHolidayMasterVO);
         }
       } catch(Exception e) {
            oMsgLogger.logERROR(e.getMessage());
            e.printStackTrace();
            throw new IBAFatalException("HRMS.DBError.General");
       }         
     return oHolidayMasterVOs;
  }
  
    /**
    * Retrieves details for specified global code
    * @plGblCode Global Code.
    * @ibafatalexception thrown    
    * @Arraylist of value objects containing global data   
    */
    public ArrayList getGblCodeDetails(int piTypeflag,String psGblCode)throws IBAFatalException
    {
        ArrayList oQualfication_List=null;
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray=new ArrayList();
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try{
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,psGblCode));
            if (piTypeflag ==0){
                oOutArray = oBean.executeQuery(oParameters,HolidayMasterSQLQueries.GET_GBLDTLS_FOR_CODE);
            }
                oQualfication_List=new ArrayList();
                oIt = oOutArray.iterator();
                while(oIt.hasNext()) 
                {
                    oRow = (QueryRow)oIt.next();
                    oQualfication_List.add(new QualfnList(0,oRow.get("GCODE").getString(),oRow.get("GDESC").getString(),0));          
                }
        }catch (Exception ee){
            oMsgLogger.logERROR("getGblCodeDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oQualfication_List;                
          
   }

public ArrayList getUnitDetails()throws IBAFatalException  
{
    String sUnitDesc=null;
    long lUnitID=0;
    String sUnitTyp;
    ArrayList oUnitMastVos=new ArrayList();
   // String sQuery="SELECT DISTINCT LOC_ID, L.LOC_DESC LOC_SDESC,l.loc_type_gbl FROM  COM_LOC_MST L ORDER BY L.LOC_DESC";
    
    Iterator oIt = null;
    QueryRow oRow = null;      
    ArrayList oOutArray;     
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    try
    {
        oOutArray = oBean.executeQuery(HolidayMasterSQLQueries.GET_UNIT_DETAILS);
        oIt = oOutArray.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            lUnitID=Long.parseLong(oRow.get("LOC_ID").getString());
            sUnitDesc=oRow.get("LOC_SDESC").getString();
            sUnitTyp=oRow.get("loc_type_gbl").getString();
            oUnitMastVos.add(new UnitList(lUnitID,sUnitDesc,sUnitTyp));
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
}