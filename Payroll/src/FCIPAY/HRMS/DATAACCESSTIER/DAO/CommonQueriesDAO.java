package FCIPAY.HRMS.DATAACCESSTIER.DAO;
import FCIPAY.HRMS.DATAACCESSTIER.SQLQueries.CommonSQLQueries;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.*;
import java.util.List;
import java.util.StringTokenizer;
import java.sql.SQLException;
import FCIPAY.COMMON.UTILITY.DSConnect;
import FCIPAY.COMMON.UTILITY.BaseDAO;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.MsgLogger;
import FCIPAY.HRMS.UTILITY.QualfnList;
import FCIPAY.HRMS.UTILITY.UnitList;
import FCIPAY.HRMS.UTILITY.DrcrtList;
import FCIPAY.HRMS.UTILITY.EmpListBean;
import FCIPAY.HRMS.UTILITY.EmpBean;
import FCIPAY.HRMS.DATAACCESSTIER.VO.DrcrtMastVo;
import FCIPAY.HRMS.DATAACCESSTIER.VO.CommonApprvDtlsVO;
import FCIPAY.HRMS.DATAACCESSTIER.VO.ZocVO;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class CommonQueriesDAO extends BaseDAO
{

    public CommonQueriesDAO()
    {
        super("HRMS");       
    }
    
    private DSConnect oDsConn=null;
    private Connection oConn=null;
    private String sQueryString=null;
    private PreparedStatement pStmt=null;
    private MsgLogger msLogger = (MsgLogger) MsgLogger.getLogger(this);    
    public String getPayScaleForGrade(int piTypeflag,long plGradeid) throws IBABusinessException,IBAFatalException,IBAException,SQLException{
        ResultSet res=null ;
        String sPayScale=null;
        String sPayScaleCd=null;
        try{
            sQueryString=CommonSQLQueries.PAYSCALE_DETAILS;
            doPrepareStatement(CommonSQLQueries.PAYSCALE_DETAILS);
//            System.out.println(sQueryString);
            setLONGPRIMITIVE(plGradeid);
//            pStmt.setLong(1,plGradeid);
            res=doExecuteQuery(false);
            while (res.next())
            {
                sPayScaleCd=res.getString("PSCALE_CODE");
                sPayScale=res.getString("PSCALE_INITPAY")+ "/" + res.getString("PSCALE_INCR1")+ "/" + res.getString("PSCALE_TOPAY1") +"/" ;
                sPayScale+=res.getString("PSCALE_INCR2")+ "/" + res.getString("PSCALE_TOPAY2")+ "/";
                sPayScale+=res.getString("PSCALE_INCR3")+ "/" +res.getString("PSCALE_TOPAY3") +"/";
                sPayScale+=res.getString("PSCALE_INCR4")+ "/" +res.getString("PSCALE_TOPAY4") +"/";
                sPayScale+=res.getString("PSCALE_INCR5")+ "/" +res.getString("PSCALE_TOPAY5") +"/";                
            }        
            res.close();
            closePreparedStatement();
            closeConnection();
            //System.out.println(sPayScale);
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getPayScaleForGrade Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getPayScaleForGrade Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return sPayScale;
        
    }

    // Check weekly off
    public boolean isWeeklyOff(String sInpDate,long lLocationId) throws IBAFatalException,IBABusinessException,IBAException
    {
        
        ResultSet res=null ;
        boolean bHolFlag = true;
        String sTemp = "";
        String sInputYear = "";
        String sWeeklyOff1 = "";
        String sWeeklyOff2 = "";        
      
        try
        {
            StringTokenizer stInpDateTokens=new StringTokenizer(sInpDate,"/");

            if(stInpDateTokens.countTokens() >0)
            {
                while (stInpDateTokens.hasMoreTokens() )
                {
                    sTemp=stInpDateTokens.nextToken();
                }
                sInputYear=sTemp;
            }

            oDsConn=new DSConnect();
            oConn = oDsConn.getDBConnection();
            if(oConn == null) System.out.println("fail");
            sQueryString=CommonSQLQueries.IS_WEEK_OFF;
            pStmt = oConn.prepareStatement(sQueryString);
            pStmt.setLong(1,lLocationId);            
            pStmt.setObject(2,sInputYear,Types.VARCHAR);
            res=pStmt.executeQuery();

            while (res.next())
            {
                sWeeklyOff1=res.getString("WEEKLY_OFF_1");
                sWeeklyOff2=res.getString("WEEKLY_OFF_2");                
            } 
            oDsConn.closeConn(oConn);

            // Check the day of the input date
            String sDay = getDay(sInpDate);

            if (sWeeklyOff1.trim().equalsIgnoreCase(sDay.trim()))
            {
                bHolFlag = true;
            }
            else
            {
                if ((sWeeklyOff2==null?"":sWeeklyOff2.trim()).equalsIgnoreCase(sDay.trim()))              
                    bHolFlag = true;
                else
                    bHolFlag = false;
            }

        } 
        catch (Exception ex)
        {
            oDsConn.closeConn(oConn);
            ex.printStackTrace();
        }

        return bHolFlag;
        
    }        
    
    // Check holiday
    public boolean isHoliday(String sInpDate,long lLocationId) throws IBAFatalException,IBABusinessException,IBAException
    {
        ResultSet res=null ;
        boolean bHolFlag = true;
        long lHolCnt = 0;
        
        try
        {
            oDsConn=new DSConnect();
            oConn = oDsConn.getDBConnection();
            if(oConn == null) System.out.println("fail");
            sQueryString=CommonSQLQueries.IS_HOLIDAY;
            pStmt = oConn.prepareStatement(sQueryString);
            pStmt.setLong(1,lLocationId);            
            pStmt.setObject(2,sInpDate,Types.VARCHAR);
            res=pStmt.executeQuery();

            while (res.next())
            {
                lHolCnt=res.getLong("HOLIDAY_CNT");
            } 
            
            if (lHolCnt > 0)
              bHolFlag = true;
            else
              bHolFlag = false;

            oDsConn.closeConn(oConn);
        } 
        catch (Exception ex)
        {
            oDsConn.closeConn(oConn);
            ex.printStackTrace();
        }

        return bHolFlag;
        
    }    

    // Check Day
    public String getDay(String sInpDate) throws IBAFatalException,IBABusinessException,IBAException
    {
        ResultSet res=null ;
        String strDay="";

        try
        {
            oDsConn=new DSConnect();
            oConn = oDsConn.getDBConnection();
            if(oConn == null) System.out.println("fail");
            sQueryString=CommonSQLQueries.GET_DAY;
            pStmt = oConn.prepareStatement(sQueryString);
            pStmt.setObject(1,sInpDate,Types.VARCHAR);
            res=pStmt.executeQuery();

            while (res.next())
            {
                strDay=res.getString("WEEKDAY");
            } 
            
            oDsConn.closeConn(oConn);
        } 
        catch (Exception ex)
        {
            oDsConn.closeConn(oConn);
            ex.printStackTrace();
        }

        return strDay;
        
    } 

    // Get next date
    public String getNextDate(String sInpDate) throws IBAFatalException,IBABusinessException,IBAException
    {
        ResultSet res=null ;
        String strNextDate="";

        try
        {
            oDsConn=new DSConnect();
            oConn = oDsConn.getDBConnection();
            if(oConn == null) System.out.println("fail");
            sQueryString=CommonSQLQueries.GET_NEXT_DATE;
            pStmt = oConn.prepareStatement(sQueryString);
            pStmt.setObject(1,sInpDate,Types.VARCHAR);
            res=pStmt.executeQuery();

            while (res.next())
            {
                strNextDate=res.getString("NEXT_DATE");
            } 
            
            oDsConn.closeConn(oConn);
        } 
        catch (Exception ex)
        {
            oDsConn.closeConn(oConn);
            ex.printStackTrace();
        }

        return strNextDate;
        
    }    
     /**
    * Constructs PayScale String .
    * @sPayscale / separated string.
    * @spayscale string is returned   
    */            
    public String getPayScale(String psPayScale){
        String sTemp="";
        String sPayScale="";
        StringTokenizer stPayTokens=null;
        if (psPayScale!=null || psPayScale.length() > 0){
            stPayTokens=new StringTokenizer(psPayScale,"/");
        }
        else
            return sPayScale;

//        System.out.println(stPayTokens.countTokens());
        if(stPayTokens.countTokens() >0)
        while (stPayTokens.hasMoreTokens() ){
            sTemp=stPayTokens.nextToken();
            if(!sTemp.equals("0")){
                sPayScale+=sTemp +"-";
            }
        }
//        System.out.println(sPayScale);        
        return sPayScale.substring(0,sPayScale.length()-1);
    }

    /**
    * Retrieve Employee grade and other details from database
    * @piTypeflag flag for selection of appropriate query
    * @plEmpno employee no
    * @ibafatalexception,@ibabusinessexception,@ibaexception thrown    
    * @String list of - separated Values   
    */    
    public String getEmpOtherDetails(int piTypeflag,long plEmpno)throws IBABusinessException,IBAFatalException,IBAException{
        ResultSet res=null ;
        String sEmpDetails=null;
        try{
            oDsConn=new DSConnect();
            oConn = oDsConn.getDBConnection();
            if (piTypeflag ==0){
                sQueryString=CommonSQLQueries.EMPLOYEE_DETAILS;
                pStmt=oConn.prepareStatement(sQueryString);
                pStmt.setLong(1,plEmpno);
                res=pStmt.executeQuery();
                while(res.next()){
                    sEmpDetails=res.getString("GRADE_DESC") + "!" + res.getString("ENAME") + "!" + res.getString("DOA") ;
                }
                res.close();
                pStmt.close();
                oDsConn.closeConn(oConn);
                oDsConn=null;
            }
        }catch(SQLException ee){
            oDsConn.closeConn(oConn);
            oDsConn=null;
            msLogger.logERROR("getEmpOtherDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch(Exception ee){
            oDsConn.closeConn(oConn);
            oDsConn=null;
            msLogger.logERROR("getEmpOtherDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return sEmpDetails;
   }
    /**
    * Retrieves Section Details from the master .
    * @ibafatalexception,@ibabusinessexception,@ibaexception thrown
    * @ArrayList of Section detail objects
    */
    public ArrayList getSectionDetails()throws IBABusinessException,IBAFatalException,IBAException{
        ResultSet res=null ;
        QualfnList oSectionBean=null;
        ArrayList oSectionList=null;
        try{
            oDsConn=new DSConnect();
            oConn = oDsConn.getDBConnection();
            sQueryString=CommonSQLQueries.SECTION_DETAILS ;
            pStmt=oConn.prepareStatement(sQueryString);
            res=pStmt.executeQuery();
            oSectionList=new ArrayList();
                while(res.next()){
                    oSectionList.add(new QualfnList(res.getLong("SECT_ID"),res.getString("SECT_NAME")));
//                    System.out.println(res.getLong("SECT_ID"));
                }
                res.close();
                pStmt.close();
                oDsConn.closeConn(oConn);
        }catch(SQLException sqex){
            oDsConn.closeConn(oConn);
            sqex.printStackTrace();
        }
        return oSectionList;
    }   

    /**
    * Retrieves the highest qualificaiton of the employee.
    * @plEmpno employee no
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @ArrayList of qualification details   
    */
    public ArrayList getHighestQualification_ForEmployee(long plEmpno) throws IBABusinessException,IBAFatalException,IBAException,SQLException{
        ArrayList oQualfication_List=null;
        ResultSet res=null;
        try{
            doPrepareStatement(CommonSQLQueries.GET_HIGHEST_QUALFN_FOR_EMPLOYEE);
            setLONGPRIMITIVE(plEmpno);
            setLONGPRIMITIVE(plEmpno);
            setLONGPRIMITIVE(plEmpno);
            res=doExecuteQuery(false);
            oQualfication_List=new ArrayList();
            while(res.next()){
                oQualfication_List.add(new QualfnList(res.getLong("QID"),res.getString("QCODE"),res.getString("QTYPE"),res.getLong("QLEVEL")));          
            }
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getHighestQualification_ForEmployee Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getHighestQualification_ForEmployee Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oQualfication_List;                
    }
    /**
    * Retrieves details for specified global code
    * @plGblCode Global Code.
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value objects containing global data   
    */
    public ArrayList getGblCodeDetails(int piTypeflag,String psGblCode)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oQualfication_List=null;
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray=new ArrayList();
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try{
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,psGblCode));
            if (piTypeflag ==0){
                oOutArray = oBean.executeQuery(oParameters,CommonSQLQueries.GET_GBLDTLS_FOR_CODE);
            }
            else if(piTypeflag ==1){ //For SEVERANCE ORDER
                String sTempQuery=CommonSQLQueries.GET_GBLDTLS_FOR_CODE;
                sTempQuery =sTempQuery + " AND DT.CODE_SDESC NOT IN('PROMPROB','CONF','NEW','PERM','SUSP','TEMP','PROB')" ;
                oOutArray = oBean.executeQuery(oParameters,sTempQuery);
            }
                oQualfication_List=new ArrayList();
                oIt = oOutArray.iterator();
                while(oIt.hasNext()) 
                {
                    oRow = (QueryRow)oIt.next();
                    oQualfication_List.add(new QualfnList(0,oRow.get("GCODE").getString(),oRow.get("GDESC").getString(),0));          
                }
        }catch (Exception ee){
            msLogger.logERROR("getGblCodeDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oQualfication_List;                
          
   }

    /**
    * Retrieves grade details based on the value of the flag details for specified global code
    * @piTypeflag 0-All grades/1-Grades corresponding to category /5-Grade corresponding payscale of passed grade
    * @plCategid Category Id
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value objects containing global data   
    */
    public ArrayList getGradeDetails(int piTypeFlag,long plCategid)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oGrade_List=null;
        ResultSet res=null;
        try{
            if (piTypeFlag==0){
                doPrepareStatement(CommonSQLQueries.GET_ALL_GRADE_DETAILS);
            }
            else if (piTypeFlag ==1){
                doPrepareStatement(CommonSQLQueries.GET_GRADE_FOR_CATEGORY);
                setLONGPRIMITIVE(plCategid);
            }       
            else if (piTypeFlag ==2){ //Get Grade details along with Crucial Dates
                doPrepareStatement(CommonSQLQueries.GET_CRDATES_FOR_GRADE);
                setLONGPRIMITIVE(plCategid);
            }
            else if (piTypeFlag == 4){
                doPrepareStatement(CommonSQLQueries.GET_NONTECHNICAL_GRADE_DETAILS);
            }
            else if (piTypeFlag ==5){ //Promtion interview result entry
               doPrepareStatement(CommonSQLQueries.GET_ALL_GRADES_FOR_GRADE_PAYSCALE);
                setLONGPRIMITIVE(plCategid); //Grade id
            }
            res=doExecuteQuery(false);
            oGrade_List=new ArrayList();
            while(res.next()){
                if (piTypeFlag ==2){
                    oGrade_List.add(new EmpListBean(3,res.getLong("GID"),res.getString("GDESC"),res.getString("CRDT1"),res.getString("CRDT2")));
                }
                else
                    oGrade_List.add(new EmpListBean(3,res.getLong("CID"),res.getString("GID"),res.getString("PSCALE"),res.getString("GDESC")));
            }
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGradeDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGradeDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oGrade_List;                
          
   }

   /**
    * Retrieves all unit details
    * @piTypeflag 
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value objects containing global data   
    */
    public ArrayList getUnitDetails(int piTypeFlag)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oUnit_List=null;
        ResultSet res=null;
        try{
            if (piTypeFlag==0){
                doPrepareStatement(CommonSQLQueries.GET_ALL_UNIT_DETAILS);
            }
            res=doExecuteQuery(false);
            oUnit_List=new ArrayList();
            while(res.next()){
                    oUnit_List.add(new UnitList(res.getLong("UNID"),res.getString("UDESC"),res.getString("UTYPE")));
            }
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getUnitDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getUnitDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oUnit_List;                
          
   }

   /**
    * Retrieves all Pay Scales corresponding to the Grade-ID
    * @piTypeflag 
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value objects containing global data   
    */
    public ArrayList getPay_Scales(int piTypeFlag)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oUnit_List=null;
        ZocVO oVO=new ZocVO();
        ResultSet res=null;
        try{
            if (piTypeFlag==0){
                doPrepareStatement(CommonSQLQueries.PAY_FUTURE);
            }
            res=doExecuteQuery(false);
            oUnit_List=new ArrayList();
            while(res.next()){
                    oUnit_List.add(new UnitList(res.getLong("pay"),res.getString("grade_id")));
            }
            oVO.setLstPay_Future(oUnit_List);
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getUnitDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getUnitDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oVO.getLstPay_Future();                
          
   }

   /**
    * Retrieves all unit details
    * @piTypeflag typeflag
    * @piEmployeeNo Employee Number
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value object containing general employee data    
    */
    public ArrayList getGeneralEmployeeDetails(int piTypeFlag,long plEmpno)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oEmp_List=null;
        ZocVO oVO=new ZocVO();
        ResultSet res=null;
        try{
            if (piTypeFlag==0){
                doPrepareStatement(CommonSQLQueries.GET_EMPLOYEE_DETAILS);
                setLONGPRIMITIVE(plEmpno);
            }
            else if (piTypeFlag ==1){
                doPrepareStatement(CommonSQLQueries.GET_GENERAL_EMPLOYEE_DETAILS);
                setLONGPRIMITIVE(plEmpno);
            }
            res=doExecuteQuery(false);
            oEmp_List=new ArrayList();
            while(res.next()){
                    if (piTypeFlag ==0){
                        oEmp_List.add(new EmpBean(0,res.getLong("EMPNO"),res.getString("ENAME"),res.getString("DOB"),res.getString("UNID"),res.getString("UDESC"),res.getString("DOJ"),res.getString("PRGRDT"),res.getString("GID"),res.getString("GDESC"),res.getString("RESCATE"),res.getString("RESDESC"),res.getString("ETYPE"),res.getString("ETDESC"),res.getString("CID"),res.getString("CDESC"),res.getString("DRID"),res.getString("FRMGRP")));
                    }
                    else if (piTypeFlag ==1){
                        //EmpBean(int piTypeflag,long plEmpno,String psEname,String psDob,String psUnitid,String psUnitDesc,String psDOJ,String psPrgrDt,String psGid,String psGDesc,String psResCateg,String psResDesc,String psEtypeId,String psEtypeDesc,String psCategId,String psCategDesc,String psDrcrtId,String psGrp)                    
                        oEmp_List.add(new EmpBean(0,plEmpno,res.getString("ENAME"),res.getString("DOB"),res.getString("UNID"),res.getString("UDESC"),res.getString("DOJ"),res.getString("OPTEX"),res.getString("GID"),res.getString("GDESC"),res.getString("GRP"),res.getString("SECTID"),res.getString("SNAME"),res.getString("DRID"),res.getString("DRDESC"),res.getString("CID"),res.getString("CDESC"),""));
                    }
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGeneralEmployeeDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGeneralEmployeeDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oEmp_List;                
          
   }  

   /**
    * Retrieves all unit details
    * @piTypeflag typeflag
    * @piEmployeeNo Employee Number
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value object containing general employee data    
    */
    public String getEmp_Pay(long plEmpno)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ZocVO oVO=new ZocVO();
        ResultSet res=null;
        try
        {
            doPrepareStatement(CommonSQLQueries.PAY_PRESENT);
            setLONGPRIMITIVE(plEmpno);
            res=doExecuteQuery(false);
            while(res.next())
            {
                oVO.setHdnPay_Present(res.getString("pay"));
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }
        catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGeneralEmployeeDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGeneralEmployeeDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oVO.getHdnPay_Present();
    }
        

    /**
    * Retrieves Group detail for the respective grade
    * @piTypeflag 
    * @plGradeid Grade id
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @String Group    
    */
    public String getGroupDetails(int piTypeFlag,long plGradeid)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        String SEmp_Grp="";
        ResultSet res=null;
        try{
            if (piTypeFlag==0){
                doPrepareStatement(CommonSQLQueries.GET_OTHER_GRADE_DETAILS);
                System.out.println(CommonSQLQueries.GET_OTHER_GRADE_DETAILS);
            }
            setLONGPRIMITIVE(plGradeid);
            res=doExecuteQuery(false);
            while(res.next()){
                SEmp_Grp=res.getString("TOGRP") + "~" + res.getString("CDESC") +"~" + res.getString("CID") +"~" + res.getString("DSGNID") ;
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGroupDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGroupDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return SEmp_Grp;                
          
   }

     /**
    * Retrieve Employee Designation Details
    * @piTypeflag flag for selection of appropriate query
    * @plEmpno employee no
    * @ibafatalexception,@ibabusinessexception,@ibaexception thrown    
    * @String list of - separated Values   
    */    
    public String getDesignationDetails(int piTypeflag,long plEmpno)throws IBABusinessException,IBAFatalException,IBAException{
        ResultSet res=null ;
        String sDesgnDetails=null;
        try{
//            oDsConn=new DSConnect();
//            oConn = oDsConn.getDBConnection();
            if (piTypeflag ==0){
                doPrepareStatement(CommonSQLQueries.GET_DESIGNATION_DETAILS_FOR_EMPLOYEE);
                System.out.println(CommonSQLQueries.GET_DESIGNATION_DETAILS_FOR_EMPLOYEE);
                setLONGPRIMITIVE(plEmpno);
                res=doExecuteQuery(false);
                while(res.next()){
                    sDesgnDetails=res.getString("DSGNID") + "!" + res.getString("DSGNDESC");
                }
                res.close();
                closePreparedStatement();
                closeConnection();
            }
        }catch(SQLException ee){
            closePreparedStatement();
            closeConnection();
            ee.printStackTrace();
            msLogger.logERROR("getDesignationDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            throw new IBABusinessException("HRMS.DBError.General");
        }catch(Exception ee){
            closePreparedStatement();
            closeConnection();
            ee.printStackTrace();
            msLogger.logERROR("getDesignationDetails Error Message" + ee.getMessage() );            
            throw new IBABusinessException("HRMS.DBError.General");
        }
        return sDesgnDetails;
   }
    /**
    * Retrieves all unit details
    * @piTypeflag typeflag
    * @plEmployeeNo Employee Number
    * @plUnitId Location id
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value object containing general employee data    
    */
    public ArrayList getGeneralEmployeeDetailsForLocation(int piTypeFlag,long plEmpno,long plUnitId)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oEmp_List=null;
        ResultSet res=null;
        try{
            if (piTypeFlag==0){
                doPrepareStatement(CommonSQLQueries.GET_EMPLOYEE_DETAILS);
                setLONGPRIMITIVE(plEmpno);
            }
            else if (piTypeFlag ==1){
                doPrepareStatement(CommonSQLQueries.GET_GENERAL_EMPLOYEE_DETAILS);
                System.out.println(CommonSQLQueries.GET_GENERAL_EMPLOYEE_DETAILS);
                setLONGPRIMITIVE(plEmpno);
                setLONGPRIMITIVE(plUnitId);
            }
            res=doExecuteQuery(false);
            oEmp_List=new ArrayList();
            while(res.next()){
                    if (piTypeFlag ==0){
                        oEmp_List.add(new EmpBean(0,res.getLong("EMPNO"),res.getString("ENAME"),res.getString("DOB"),res.getString("UNID"),res.getString("UDESC"),res.getString("DOJ"),res.getString("PRGRDT"),res.getString("GID"),res.getString("GDESC"),res.getString("RESCATE"),res.getString("RESDESC"),res.getString("ETYPE"),res.getString("ETDESC"),res.getString("CID"),res.getString("CDESC"),res.getString("DRID"),res.getString("FRMGRP")));
                    }
                    else if (piTypeFlag ==1){
                        //EmpBean(int piTypeflag,long plEmpno,String psEname,String psDob,String psUnitid,String psUnitDesc,String psDOJ,String psPrgrDt,String psGid,String psGDesc,String psResCateg,String psResDesc,String psEtypeId,String psEtypeDesc,String psCategId,String psCategDesc,String psDrcrtId,String psGrp)                    
                        oEmp_List.add(new EmpBean(0,plEmpno,res.getString("ENAME"),res.getString("DOB"),res.getString("UNID"),res.getString("UDESC"),res.getString("DOJ"),res.getString("OPTEX"),res.getString("GID"),res.getString("GDESC"),res.getString("GRP"),res.getString("SECTID"),res.getString("SNAME"),res.getString("DRID"),res.getString("DRDESC"),res.getString("CID"),res.getString("CDESC"),res.getString("GRPID")));
                    }
            }
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGeneralEmployeeDetailsForLocation Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGeneralEmployeeDetailsForLocation Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oEmp_List;                
          
   }   

    /**
    * Retrieves all Directorate  details for the location
    * @piTypeflag typeflag
    * @plUnitId Location id
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value object containing general directorate details    
    */
    public ArrayList getDirectorateDetailsForLocation(int piTypeFlag,long plUnitId)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oDrcrtMastVos=null;
        DrcrtMastVo oDrcrtMastVo=null;
        ResultSet res=null;
        try{
             if (piTypeFlag ==1){
                doPrepareStatement(CommonSQLQueries.GET_DIRECTORATES_FOR_UNIT);
                System.out.println(CommonSQLQueries.GET_DIRECTORATES_FOR_UNIT);
                setLONGPRIMITIVE(plUnitId);
            }
            res=doExecuteQuery(false);
            oDrcrtMastVos=new ArrayList();
            while(res.next()){
                if (piTypeFlag ==1){
                    oDrcrtMastVos.add(new DrcrtList(res.getLong("DRCRT_ID"),res.getString("DRCRT_NAME")));
                }
            }
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getDirectorateDetailsForLocation Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch(Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getDirectorateDetailsForLocation Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oDrcrtMastVos;                
          
   }   

    /**
    * Retrieves all Group  details for that directorate
    * @piTypeflag typeflag
    * @plDrcrtId Directorate id
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value object containing general directorate details    
    */
    public ArrayList getGrpDetailsForDirectorate(int piTypeFlag,long plDrcrtId)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oDrcrtMastVos=null;
        DrcrtMastVo oDrcrtMastVo=null;
        ResultSet res=null;
        try{
             if (piTypeFlag ==1){
                doPrepareStatement(CommonSQLQueries.GET_GRPS_FOR_DIRECTORATES);
                System.out.println(CommonSQLQueries.GET_GRPS_FOR_DIRECTORATES);
                setLONGPRIMITIVE(plDrcrtId);
            }
            res=doExecuteQuery(false);
            oDrcrtMastVos=new ArrayList();
            while(res.next()){
                if (piTypeFlag ==1){
                    oDrcrtMastVos.add(new EmpListBean(0,res.getLong("GRP_ID"),res.getString("GRP_NAME"),res.getLong("GRP_HEAD")));
                }
            }
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGrpDetailsForDirectorate Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch (Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getGrpDetailsForDirectorate Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oDrcrtMastVos;                
          
   }   

    /**
    * Retrieves all  unit,Directorate,grp,section  details for locatiion
    * @piTypeflag typeflag
    * @plUnitId Location id
    * @ibabusinessexception,@ibafatalexception,@ibaexception thrown    
    * @Arraylist of value object containing general directorate details    
    */
    public ArrayList getAllDetails(int piTypeFlag,long plUnitId)throws IBABusinessException,IBAException,IBAFatalException,SQLException{
        ArrayList oTempAllDetails=null;
        ArrayList oDrcrtMastVos=null;
        DrcrtMastVo oDrcrtMastVo=null;
        ResultSet res=null;
        try{
             if (piTypeFlag ==0){ //Unit Details
                doPrepareStatement(CommonSQLQueries.GET_ALL_UNIT_DETAILS);
                System.out.println(CommonSQLQueries.GET_ALL_UNIT_DETAILS);
//                setLONGPRIMITIVE(plUnitId);
            }
            else if (piTypeFlag ==1){ //Directorate Details
                doPrepareStatement(CommonSQLQueries.GET_ALL_DRCRT_DETAILS);
                System.out.println(CommonSQLQueries.GET_ALL_DRCRT_DETAILS);
//                setLONGPRIMITIVE(plUnitId);
            }
            else if (piTypeFlag ==2){ //Directorate Details
                doPrepareStatement(CommonSQLQueries.GET_ALL_GRP_DETAILS);
                System.out.println(CommonSQLQueries.GET_ALL_GRP_DETAILS);
//                setLONGPRIMITIVE(plUnitId);
            }
            else if (piTypeFlag ==3){ //Directorate Details
                doPrepareStatement(CommonSQLQueries.GET_ALL_SECTION_DETAILS);
                System.out.println(CommonSQLQueries.GET_ALL_SECTION_DETAILS);
//                setLONGPRIMITIVE(plUnitId);
            }

            res=doExecuteQuery(false);
            oDrcrtMastVos=new ArrayList();
            while(res.next()){
                if (piTypeFlag ==0){
                    oDrcrtMastVos.add(new DrcrtList(res.getLong("UNID"),res.getString("UDESC")));
                }
                else if (piTypeFlag ==1){
                    oDrcrtMastVos.add(new DrcrtList(res.getLong("DRID"),res.getString("DRNAME")));
                }
                else if (piTypeFlag ==2){
                    oDrcrtMastVos.add(new DrcrtList(res.getLong("GRPID"),res.getString("GRPNAME")));
                }
                else if (piTypeFlag ==3){
                    oDrcrtMastVos.add(new DrcrtList(res.getLong("SECID"),res.getString("SNAME")));
                }
                
            }
            closePreparedStatement();
            closeConnection();
        }catch (SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getAllDetails Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }catch(Exception ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getAllDetails Error Message" + ee.getMessage() );            
            ee.printStackTrace();
        }
        return oDrcrtMastVos;                
          
   }   

/**
     * This method retrieves ACCT_STATUS,CTRL_ACCT,CHG_FLG,CC_FLG from FIN_ACCT_MST Table 
     * @param String sAcctId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getAcctDtls(int piTypeflag,String sAcctId) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstAcctDtls = new ArrayList();
        ResultSet rs=null;
        try
        {      
            if (piTypeflag ==0){
                doPrepareStatement(CommonSQLQueries.GET_ACCT_DTL);
                System.out.println(CommonSQLQueries.GET_ACCT_DTL);
                setSTRING(sAcctId);
            }                    
            rs=doExecuteQuery(true);
            if(rs.next()) 
            {
                lstAcctDtls.add(rs.getString("ACCT_STATUS"));
                lstAcctDtls.add(rs.getString("CTRL_ACCT"));
                lstAcctDtls.add(rs.getString("CHG_FLG"));
                lstAcctDtls.add(rs.getString("CC_FLG"));                
            }            
            rs.close();
            closePreparedStatement();
            closeConnection();
        }       
        catch(SQLException ee){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getAcctDtls Error Code:" + ee.getErrorCode() + "Error Message" + ee.getMessage() );            
            ee.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(Exception e){
            closePreparedStatement();
            closeConnection();
            msLogger.logERROR("getAcctDtls Error Message" + e.getMessage() );            
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }
        return lstAcctDtls;
    }        
    public static String wrapText(String toWrap,int len) {
//        return toWrap;
        if(toWrap==null || toWrap.equals("")) {
            String emptyStr="";
            return emptyStr;
        }
        StringBuffer strBuf=new StringBuffer(toWrap);
        int strLen=toWrap.length();
        int i=0;
        int wrapAt=0;
        while(i<(strLen/len)) {
            wrapAt=wrapAt+len;
            strBuf.insert(wrapAt,"\n");
            i++;
        }
      //System.out.println("WrapText Ouput="+strBuf.toString());
        return strBuf.toString();
    }

    /**
    * Retrives the category details from the master. 
    * @piTypeflag flag used to decide whether to populate details into value objects or bean for dropdown.
    * @ibfatalexception,@ibabusinessexception,@ibaexception being thrown    
    * @ArrayList of category objects   
    */
    public ArrayList getCategoryDetails(int piTypeFlag) throws IBAException,IBABusinessException,IBAFatalException{
        String sCateDesc=null;
        long lCateId=0;
        ResultSet res=null ;
        ArrayList oCategoryVos=new ArrayList();
        try{
            if (piTypeFlag==0){
                doPrepareStatement(CommonSQLQueries.SELECT_CATEGORY_TECHNICAL);
            }
            else if (piTypeFlag ==1){
                doPrepareStatement(CommonSQLQueries.SELECT_CATEGORY_NONTECHNICAL);
            }
            res=doExecuteQuery(false);
            while (res.next())
            {
                lCateId=res.getLong("CATEG_ID");
                sCateDesc=(res.getString("CATEG_DESC"));
                //System.out.println(lCateId + " "+sCateDesc);
                oCategoryVos.add(new EmpListBean(1,lCateId,sCateDesc));
            }
            res.close();
            closePreparedStatement();
            closeConnection();            
            return oCategoryVos; 
        }catch(SQLException ee){
            closePreparedStatement();
            closeConnection();            
            ee.printStackTrace();
            IBABusinessException iba=new IBABusinessException();
            iba.setsMessage(ee.getMessage());
            throw iba;
        }catch(Exception e){
            closePreparedStatement();
            closeConnection();            
            System.out.println(e.getMessage()+"Exception thrown");
        }
        return oCategoryVos;          
    }


    /**
     * This method is role and role Level of the Employee
     * @param1= lEmployee  a employee no 
     * @paran2= sModuleType a Module Type
     * @returns String Array containing the Role and RoleLevel
     * @throws ibafatalexception ,ibabusinessexception ,sqlexception
     */
    public String[] getEmpRole(String sModuleType ,long lEmployee) throws IBAFatalException,IBABusinessException,SQLException
    {
        String[] sRole =new String[2];
        ResultSet res=null;
        String sFlag="N";
        doPrepareStatement(CommonSQLQueries.GETEMPROLE);
        setSTRING(sModuleType);
        try
        {
            setLONGPRIMITIVE(lEmployee);
            res=doExecuteQuery(true);
            while(res.next())
            {
                sRole[0] =res.getString("ROLE_ID_GBL");
                sRole[1]=res.getString("ROLE_LVL");
                sFlag="Y";
            }

            if(sFlag.equals("N"))
            {
                IBABusinessException ibabe =new IBABusinessException("HRMS.ROLE.NOTDEFINED");
                ibabe.setsMessage(" No Role has not been assigned to you for this screen !!");
                throw ibabe;
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }
        catch(SQLException sqlex)
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            sqlex.printStackTrace();
            IBAFatalException ibafe =new IBAFatalException("HRMS.DB.Administrator");
            ibafe.setsMessage(sqlex.getMessage());
            ibafe.setiErrCode(sqlex.getErrorCode());
            throw ibafe;
        }
        return sRole;
    }

//-------------function to insert the Approval Details ----------------------------

//---------------Please Note this method does not close AND COMMIT the Connection--------------
    /**
     * This method is used to insert Approval Details 
     * @param=sRole role of the Employee
     * @paran=sRoleLevel Role Level of Employee 
     * @param=oConn Connection to the database
     * @throws ibafatalexception,ibabusinessexception,sqlexception
     */
    public void insertApprvDtls(CommonApprvDtlsVO oCommonApprvVO,Connection oConn )throws IBAFatalException,SQLException
    {
        PreparedStatement pStmt =null;
        try
        {
            if(oConn == null)
            {
                IBAFatalException ibafe =new IBAFatalException("HRMS.DB.Administrator");
                ibafe.setsMessage("Connection failed !!");
                throw ibafe;
            }

            pStmt=oConn.prepareStatement(CommonSQLQueries.INSERTAPPRVDTLS);
            pStmt.setLong(1,oCommonApprvVO.getLLoginSiteId());
            pStmt.setString(2,oCommonApprvVO.getStrRequestType());
            pStmt.setString(3,oCommonApprvVO.getStrRequestNo());
            pStmt.setLong(4,oCommonApprvVO.getLLocId());
            pStmt.setString(5,oCommonApprvVO.getStrApprEmpNo());
            pStmt.setString(6,oCommonApprvVO.getStrApprEmpName());
            pStmt.setString(7,oCommonApprvVO.getStrApprEmpDsgn());
            pStmt.setString(8,oCommonApprvVO.getStrApprDate());
            pStmt.setString(9,oCommonApprvVO.getStrReviewStatus());
            pStmt.setString(10,oCommonApprvVO.getStrApprvCmnts());
            pStmt.setLong(11,oCommonApprvVO.getLLoginId());
            pStmt.setLong(12,oCommonApprvVO.getLLoginSiteId());
            if(pStmt.executeUpdate() <=0)
            {
                oConn.rollback();
                pStmt.close();
                IBAFatalException ibafe =new IBAFatalException("Common.ApprvDtls.NotSaved");
                ibafe.setsMessage("Failed to save Approval Details ");
                throw ibafe;
            }
            pStmt.close();
            
            /*if((oCommonApprvVO.getStrRequestType().equals("LOANPAY$PROCPAY")||(oCommonApprvVO.getStrRequestType().equals("LOANPAY$HBASUBSPAY")))&&oCommonApprvVO.getStrReviewStatus().equals("GBLROLES$A"))
            {
                 pStmt=oConn.prepareStatement(CommonSQLQueries.UPDATEAPPRVDTLS);
                 pStmt.setString(1,oCommonApprvVO.getStrRequestNo());
                 pStmt.setLong(2,oCommonApprvVO.getLLoginId());
                 pStmt.setLong(3,oCommonApprvVO.getLLoginSiteId());
                 pStmt.setString(4,oCommonApprvVO.getStrRequestType());
                 pStmt.setString(5,oCommonApprvVO.getStrOldRequestNo());
                 pStmt.executeUpdate();
                 
            }*/
        }
        catch(SQLException sqlex)
        {
            oConn.rollback();
            pStmt.close();
            sqlex.printStackTrace();
            IBAFatalException ibafe =new IBAFatalException("Common.ApprvDtls.NotSaved");
            ibafe.setiErrCode(sqlex.getErrorCode());
            ibafe.setsMessage(sqlex.getMessage());
            throw ibafe;
        }
        catch(Exception e)
        {
            oConn.rollback();
            pStmt.close();
            e.printStackTrace();
            IBAFatalException ibafe =new IBAFatalException("Common.ApprvDtls.NotSaved");
            ibafe.setsMessage(e.getMessage());
            throw ibafe;
        }
        
    }


//--------------------Function to get the Approval Details ----------------------
    /**
     * This method is used to get the Approval Details 
     *@param= sModuleType a Module Type
     * @param1=sRequestNo a Request Number 
     * @returns ArrayList of CommonApprvDtlsVO containing Approval Details for that Request No
     * @throws ibafatalexception , ibabusinessexception,sqlexception
     */
    public ArrayList getApprvDtls(String sModuleType ,String sRequestNo)throws IBAFatalException,IBABusinessException,SQLException
    {
        ResultSet res=null;
        ArrayList arLstApprvDtls =new ArrayList();
        
        CommonApprvDtlsVO oCommonApprvDtlsVO =null;
        doPrepareStatement(CommonSQLQueries.sql_getApprvDtls);
        setSTRING(sModuleType);
        setSTRING(sRequestNo);
        res=doExecuteQuery(true);
        while(res.next())
        {
            oCommonApprvDtlsVO= new CommonApprvDtlsVO();
            oCommonApprvDtlsVO.setStrApprEmpNo(res.getString("APPR_EMP_NO"));
            oCommonApprvDtlsVO.setStrApprEmpName(res.getString("APPR_NAME"));
            oCommonApprvDtlsVO.setStrApprEmpDsgn(res.getString("APPR_DSGN"));
            oCommonApprvDtlsVO.setStrApprDate(res.getString("APPR_DATE"));
            oCommonApprvDtlsVO.setStrApprvCmnts(res.getString("APPRV_REVIEW_CMNTS"));
            oCommonApprvDtlsVO.setStrReviewStatus(res.getString("REVIEW_STATUS"));
            oCommonApprvDtlsVO.setStrRole(res.getString("ROLE_DESC"));
            oCommonApprvDtlsVO.setStrRoleLevel(res.getString("ROLE_LVL"));
            arLstApprvDtls.add(oCommonApprvDtlsVO);
        }
        res.close();
        closePreparedStatement();
        closeConnection();
        
        return arLstApprvDtls;          
    }

    //-------------function to insert the Approval Details ----------------------------

//---------------Please Note this method does not close AND COMMIT the Connection--------------
    /**
     * This method is used to insert Approval Details 
     * @param=sRole role of the Employee
     * @paran=sRoleLevel Role Level of Employee 
     * @param=oConn Connection to the database
     * @throws ibafatalexception,ibabusinessexception,sqlexception
     */
    public void insertApprvDtls(CommonApprvDtlsVO oCommonApprvVO )throws IBAFatalException,SQLException
    {
        PreparedStatement pStmt =null;
        DSConnect oDsConn = new DSConnect();
        Connection oConn =oDsConn.getDBConnection();
        try
        {
            if(oConn == null)
            {
                IBAFatalException ibafe =new IBAFatalException("HRMS.DB.Administrator");
                ibafe.setsMessage("Connection failed !!");
                throw ibafe;
            }

            pStmt=oConn.prepareStatement(CommonSQLQueries.INSERTAPPRVDTLS);
            pStmt.setLong(1,oCommonApprvVO.getLLoginSiteId());
            pStmt.setString(2,oCommonApprvVO.getStrRequestType());
            pStmt.setString(3,oCommonApprvVO.getStrRequestNo());
            pStmt.setLong(4,oCommonApprvVO.getLLocId());
            pStmt.setString(5,oCommonApprvVO.getStrApprEmpNo());
            pStmt.setString(6,oCommonApprvVO.getStrApprEmpName());
            pStmt.setString(7,oCommonApprvVO.getStrApprEmpDsgn());
            pStmt.setString(8,oCommonApprvVO.getStrApprDate());
            pStmt.setString(9,oCommonApprvVO.getStrReviewStatus());
            pStmt.setString(10,oCommonApprvVO.getStrApprvCmnts());
            pStmt.setLong(11,oCommonApprvVO.getLLoginId());
            pStmt.setLong(12,oCommonApprvVO.getLLoginSiteId());
            if(pStmt.executeUpdate() <=0)
            {
                oConn.rollback();
                pStmt.close();
                oConn.close();
                IBAFatalException ibafe =new IBAFatalException("Common.ApprvDtls.NotSaved");
                ibafe.setsMessage("Failed to save Approval Details ");
                throw ibafe;
            }
            pStmt.close();
            oConn.close();
        }
        catch(SQLException sqlex)
        {
            oConn.rollback();
            pStmt.close();
            sqlex.printStackTrace();
            IBAFatalException ibafe =new IBAFatalException("Common.ApprvDtls.NotSaved");
            ibafe.setiErrCode(sqlex.getErrorCode());
            ibafe.setsMessage(sqlex.getMessage());
            throw ibafe;
        }
        catch(Exception e)
        {
            oConn.rollback();
            pStmt.close();
            e.printStackTrace();
            IBAFatalException ibafe =new IBAFatalException("Common.ApprvDtls.NotSaved");
            ibafe.setsMessage(e.getMessage());
            throw ibafe;
        }
        
    }    


    
}

