/* 
 * Module:        CommonVoucherDAO.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This class Connects to The Database and retrieves records.
 *                Its is called from CommonVoucherBD.
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.DATAACCESSTIER.DAO;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import oracle.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.driver.*;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.HRMS.UTILITY.PeriodBean;
import java.util.Date;
import java.util.Calendar;

import FCIPAY.HRMS.DATAACCESSTIER.SQLQueries.CommonVoucherQueries;
import FCIPAY.HRMS.DATAACCESSTIER.VO.CommonVoucherVo;
import FCIPAY.HRMS.UTILITY.VoucherBean;
import FCIPAY.COMMON.UTILITY.MsgLogger;

public final class CommonVoucherDAO 
{
   private Connection conn=null;
   private DSConnect dsConn=null;
   private ResultSet rSet=null;
   private PreparedStatement pSt=null;
   private MsgLogger msLogger = (MsgLogger) MsgLogger.getLogger(this);
   private CommonVoucherQueries oCommonVoucherQueries =null;

   /**
    *  Method        Constructor
    *  Description   Creates objects of CommonVoucherQueries and Current Date in 
    *                Different Format(dd/mm/yyyy,mm/dd/yyyy)
    */
   public CommonVoucherDAO()
   {  try {
      dsConn=new DSConnect();
      oCommonVoucherQueries=new CommonVoucherQueries();
      }
      catch(Exception e) {}
   }

   /**
   * Method      Finds whether the Location is a valid Accounting Location or not
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Location Id of the user
   * @return     true if Valid Accounting Location else false
   */
   public boolean compareLocId_DAO(long LocId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      boolean retVal=false;
      try {
         conn=dsConn.getDBConnection();   
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_compLocId);
         pSt.setLong(1,LocId);
         rSet=pSt.executeQuery();
         rSet.next();
         if(rSet.getInt("TOTAL")!=0) 
            retVal=true;     
      }
      catch(SQLException sExcept) 
      {
         System.out.println("Method1 SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("Method1 Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }
   public String[] getNewAdvId_DAO(long LocId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception  {
      String[] retVal=new String[2];
      try {
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getNewAdvId);
         pSt.setLong(1,LocId);
         rSet=pSt.executeQuery();
         if(rSet.next()) {
            retVal[0]=String.valueOf(rSet.getLong(1));
            retVal[1]=String.valueOf(rSet.getLong(2));
         }               
      }
      catch(SQLException sExcept) 
      {
         System.out.println("SaveNewVoucherNo_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("SaveNewVoucherNo_DAO Exception");     
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();
      return retVal;
   }

   /**
   * Method      Collects all active periods and Stores it in the ArrayList.
   *             also stores the Start and End Date of all active periods for future use.
   *             Compares current date with the period date and returns the period id if exists.
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   * @param1     Location Id of the user
   * @param2     ArrayList to display the Periods in DropDown
   * @param3     ArrayList to Store the Start and End Date of the Periods
   * @return     Returns the current period number if found else -1
   */
   public String selectPeriod_DAO(long LocId,ArrayList objRowList,ArrayList objDateList) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      String retVal="";
      String PeriodId="";
      Date startDate=null;
      Date endDate=null;
      String sDate="";
      String eDate="";
      Calendar today=Calendar.getInstance();
      String todaysDate=today.get(today.DATE) + "/" + (today.get(today.MONTH)+1) + "/" + today.get(today.YEAR);
      String todaysDateChgFmt=(today.get(today.MONTH)+1) + "/" + today.get(today.DATE) + "/" + today.get(today.YEAR); 
      Date todDate=new Date(todaysDateChgFmt);
//      System.out.println(todDate.getDate() + "/" +  todDate.getMonth() + "/" + todDate.getYear());
      try {
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getPeriod);
         pSt.setLong(1,LocId);
         rSet=pSt.executeQuery();
         while(rSet.next()) 
         {
            PeriodId=Long.toString(rSet.getLong("PRD_ID"));
            objRowList.add(new PeriodBean(PeriodId,rSet.getString("PRD_DESC")));
            sDate=rSet.getString("START_DT");
            eDate=rSet.getString("END_DT");
            startDate=new Date(sDate);
            endDate=new Date(eDate);
            objDateList.add(new PeriodBean(PeriodId,sDate,eDate));
            if((todDate.getTime()>=startDate.getTime()) && (todDate.getTime()<=endDate.getTime())) {
               retVal=PeriodId;
//               System.out.println("Selected Period Id is ="+PeriodId+ "startand end date is" + startDate + "____"+endDate);
            }
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("Method2 SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());               
      }
      catch(Exception Except) 
      {
         System.out.println("Method2 Exception");
         freeResource();
         ExceptionHandling(2,0,Except.getMessage());        
      }
      if(objRowList.size()<=0)
         retVal="-1";
      freeResource();
      return retVal;
   }

   public String selectPeriodBankCash_DAO(long LocId,ArrayList objRowList,ArrayList objDateList) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      String retVal="";
      String PeriodId="";
      Date startDate=null;
      Date endDate=null;
      String sDate="";
      String eDate="";
      Calendar today=Calendar.getInstance();
      String todaysDate=today.get(today.DATE) + "/" + (today.get(today.MONTH)+1) + "/" + today.get(today.YEAR);
      String todaysDateChgFmt=(today.get(today.MONTH)+1) + "/" + today.get(today.DATE) + "/" + today.get(today.YEAR); 
      Date todDate=new Date(todaysDateChgFmt);
//      System.out.println(todDate.getDate() + "/" +  todDate.getMonth() + "/" + todDate.getYear());
      try {
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getPeriodBankCash);
         pSt.setLong(1,LocId);
         rSet=pSt.executeQuery();
         while(rSet.next()) 
         {
            PeriodId=Long.toString(rSet.getLong("PRD_ID"));
            objRowList.add(new PeriodBean(PeriodId,rSet.getString("PRD_DESC")));
            sDate=rSet.getString("START_DT");
            eDate=rSet.getString("END_DT");
            startDate=new Date(sDate);
            endDate=new Date(eDate);
            objDateList.add(new PeriodBean(PeriodId,sDate,eDate));
            if((todDate.getTime()>=startDate.getTime()) && (todDate.getTime()<=endDate.getTime())) {
               retVal=PeriodId;
//               System.out.println("Selected Period Id is ="+PeriodId+ "startand end date is" + startDate + "____"+endDate);
            }
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("Method2 SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());               
      }
      catch(Exception Except) 
      {
         System.out.println("Method2 Exception");
         freeResource();
         ExceptionHandling(2,0,Except.getMessage());        
      }
      if(objRowList.size()<=0)
         retVal="-1";
      freeResource();
      return retVal;
   }

   /**
   * Method      Selects the document location for the particular Loaction Id
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Location Id of the user
   * @return     Returns The Document Location.
   */ 
   public String selectDocumentLoc_DAO(long LocId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      String retVal="";
      try {
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getDocLoc);
         pSt.setLong(1,LocId);
         rSet=pSt.executeQuery();
         rSet.next();
         retVal=rSet.getString("LOC_SDESC"); 
      }
      catch(SQLException sExcept) 
      {
         System.out.println("Method3 SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());               
      }
      catch(Exception Except) 
      {
         System.out.println("Method3 Exception");
         freeResource();
         ExceptionHandling(2,0,Except.getMessage());        
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Checks for the particular Account Id and if found verifies whether it is a 
   *             CTRL_ACCT,CHG_FLG,CC_FLG,USI_FLG and returns Y or N in the same order
   *             and -1 if Account Id not found
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Account Id
   * @param2     Voucher Type
   * @return     Returns a String Which Indicates the type of Account
   *             (Control A/c,Charge code A/c,CostCenter A/c,USI A/c)
   *             (Format - Y if its the type else N)
   *             If Account Id not found then returns -1
   */
   public String checkAcctId_DAO(String Id,String VouchType) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      String retVal="";
      String Temp="";
//      System.out.println(sQuery);
      try {
         conn=dsConn.getDBConnection(); 
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         if((VouchType.equals("VOUCHTYPE$NJV")) || (VouchType.equals("VOUCHTYPE$SJV"))) {
             pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkAcctId);
//             System.out.println(oCommonVoucherQueries.sql_checkAcctId);
         }
         else if((VouchType.equals("VOUCHTYPE$BRV")) || (VouchType.equals("VOUCHTYPE$CRV")) || (VouchType.equals("VOUCHTYPE$BPV"))) {
             pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkAcctId_Receipt);
//             System.out.println(oCommonVoucherQueries.sql_checkAcctId_Receipt);
         }
         else if(VouchType.equals("VOUCHTYPE$CPV")) {
             pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkAcctId_CashPayAdvice);
         }
         else if(VouchType.equals("VOUCHTYPE$IAV")) {
             pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkAcctId_IAV);
         }
         else
             pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkAcctId_OJV);
         pSt.setLong(1,Long.parseLong(Id));
         rSet=pSt.executeQuery();
         if(rSet.next())  {
            Temp=rSet.getString("CTRL_ACCT");
//            System.out.println("CTRL_ACCT"+Temp);
            if(Temp.equals("N"))
               retVal="N"+"|";
            else
               retVal=Temp+"|";
               
            Temp="";
            Temp=rSet.getString("CHG_FLG");
//            System.out.println("CHG_FLG"+Temp+"-"+retVal);            
            if(Temp.equals("N"))
               retVal=retVal+"N"+"|";
            else
               retVal=retVal+Temp+"|";
               
            Temp="";               
            Temp=rSet.getString("CC_FLG");
//            System.out.println("CC_FLG"+Temp+"-"+retVal);            
            if(Temp.equals("N"))
              retVal=retVal+"N"+"|";
            else
               retVal=retVal+Temp+"|";
               
            Temp="";               
            Temp=rSet.getString("USI_FLG");
//            System.out.println("USI_FLG"+Temp+"-"+retVal);            
            if(Temp.equals("N"))
               retVal=retVal+"N"+"|";
            else
               retVal=retVal+Temp+"|";
//            System.out.println(retVal+"In DAO"+"-"+retVal);
            Temp="";               
            Temp=rSet.getString("CTRL_TYPE");
//            System.out.println("USI_FLG"+Temp+"-"+retVal);            
            if(Temp.equals("Z"))
               retVal=retVal+"Z";
            else
               retVal=retVal+Temp;
         }
         else
            retVal="-1";
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkAcctId_DAO SQLException");
         freeResource();
         sExcept.printStackTrace();         
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkAcctId_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Checks for the particular Account Id and if found verifies whether it is a 
   *             CHG_FLG and returns Y or N and -1 if Account Id not found
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Account Id
   * @param2     Voucher Type
   * @return     Returns a String Which Indicates the type of Account
   *             (Charge code A/c)
   *             (Format - Y if its the type else N)
   */
   public String checkAcctId_CJV_DAO(String Id) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      String retVal="N";
      int totResults=0;
      try {
         conn=dsConn.getDBConnection(); 
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkAcctId_CJV);
         pSt.setLong(1,Long.parseLong(Id));
         rSet=pSt.executeQuery();
         if(rSet.next()) 
            retVal=rSet.getString("CHG_FLG");
         else
            retVal="-1";
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkAcctId_CJV_DAO SQLException");
         freeResource();
         sExcept.printStackTrace();         
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkAcctId_CJV_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Checks for the particular PO or WO Id.
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Query
   * @param2     WO/PO Id
   * @param3     Indicates Order Type(WO_ID OR PO_ID)
   * @return     Returns a String Array Which Has The Order Id,Vendor Id,Vendor Code 
   *             in the same above mentioned order
   */
   public String[] checkOrderId_DAO(String sQuery,String Id,String IdName) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      long wo_id=0;
      long ven_id=0;
      String ven_code="";
      String[] retVal=new String[3];
      try {
         conn=dsConn.getDBConnection();  
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(sQuery);
         pSt.setString(1,Id);
         rSet=pSt.executeQuery();
         if(rSet.next()) {
            wo_id=rSet.getLong(IdName);
            ven_id=rSet.getLong("VEN_ID");
            ven_code=rSet.getString("VEN_CODE");
         }
         retVal[0]=Long.toString(wo_id);
         retVal[1]=Long.toString(ven_id);
         retVal[2]=ven_code;
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkOrderId_DAO SQLException");
         retVal=null;
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkOrderId_DAO Exception");
         retVal=null;
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Checks for the particular PO or WO Id.
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Query
   * @param2     WO/PO Id
   * @param3     Indicates Order Type(WO_ID OR PO_ID)
   * @param4     Location Id of the User
   * @return     Returns a String Array Which Has The Order Id,Vendor Id,Vendor Code 
   *             in the same above mentioned order
   */
   public String[] checkOrderId_DAO(String sQuery,String Id,String IdName,long locId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      long wo_id=0;
      long ven_id=0;
      String ven_code="";
      String[] retVal=new String[3];
      try {
         conn=dsConn.getDBConnection();  
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(sQuery);
         pSt.setString(1,Id.trim().toLowerCase());
         pSt.setLong(2,locId);
         rSet=pSt.executeQuery();
         if(rSet.next()) {
            wo_id=rSet.getLong(IdName);
            ven_id=rSet.getLong("VEN_ID");
            ven_code=rSet.getString("VEN_CODE");
         }
         retVal[0]=Long.toString(wo_id);
         retVal[1]=Long.toString(ven_id);
         retVal[2]=ven_code;
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkOrderId_DAO SQLException");
         retVal=null;
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkOrderId_DAO Exception");
         retVal=null;
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      According to the SubLedger Type Retrieves the Id of the Particular Code(EMPL or VEN)
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Query
   * @param2     Creditor/Debtor/Employee Id
   * @param3     Indicates SubLedger Type(VENCAT$DR OR VENCAT$CR OR EMPL)
   * @return     Returns the Id of the Particular Code(Ven_Id)
   *             For EMPL its the same Employee Code
   */
   public long checkSubLedgerId_DAO(String sQuery,String Id,String Type) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      long retVal=0;
      try {
         conn=dsConn.getDBConnection(); 
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(sQuery);
         if(Type.equals("VENCAT$DR") || Type.equals("VENCAT$CR")) {
            pSt.setString(1,Id.trim().toLowerCase());
            pSt.setString(2,Type.trim());
         }
         else if(Type.equals("EMP"))
            pSt.setLong(1,Long.parseLong(Id));
         rSet=pSt.executeQuery();
         if(Type.equals("VENCAT$DR") || Type.equals("VENCAT$CR")) {         
            if(rSet.next())
               retVal=rSet.getLong("VEN_ID");
         }
         else if(Type.equals("EMP")) {
            if(rSet.next())
               retVal=rSet.getLong("EMP_NO");        
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkSubLedgerId_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkSubLedgerId_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Method Checks if the given ChargeCode id Exists or Not
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Charge Code Id
   */
   public boolean checkChargeId_DAO(String Id) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      boolean retVal=false;
      try {
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkChargeId);
         pSt.setLong(1,Long.parseLong(Id.trim()));
         rSet=pSt.executeQuery();
         rSet.next();
         if(rSet.getInt("TOTAL")>0) 
            retVal=true;     
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkChargeId_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkChargeId_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Method Checks if the given ChargeCode id Exists and selects the corresponding Id
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     CostCenter Id
   * @return     Returns the Id of the Particular Code(CCSGRP_ID)
   */
   public long checkCostCenterId_DAO(String Id) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      long retVal=0;
      try {
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkCostCenterId);
         pSt.setLong(1,Long.parseLong(Id.trim()));
         rSet=pSt.executeQuery();
         if(rSet.next()) 
            retVal=rSet.getLong("CCSGRP_ID");
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkCostCenterId_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkCostCenterId_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Method Checks if the given USI id Exists in the Corresponding Location and 
   *             selects the corresponding USI Id
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     USI Id
   * @param2     Location Id Of the User
   * @return     Returns the Id of the Particular Code(USIID)
   */
   public long checkUSIId_DAO(String Id,long locId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      long retVal=0;
      try {
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_checkUSI_Code);
//         System.out.println(oCommonVoucherQueries.sql_checkUSI_Code+"----"+Id+"----"+locId);
         pSt.setDouble(1,Double.parseDouble(Id.trim()));
         pSt.setLong(2,locId);
         rSet=pSt.executeQuery();
         if(rSet.next()) 
            retVal=rSet.getLong("USI_NO");
      }
      catch(SQLException sExcept) 
      {
         System.out.println("checkUSIId_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("checkUSIId_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Method Retrieves the next no from the sequence(FIN_VOUCHER_HDR_SEQ)
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Location Id Of the User
   * @return     Returns the next no in the sequence(FIN_VOUCHER_HDR_SEQ)
   */
   public long getNewVoucherId_DAO(long LocId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   {
      long retVal=0;
      try {
//         System.out.println(sQuery+"-"+LocId);
         conn=dsConn.getDBConnection();
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getNewVoucherId);
         pSt.setLong(1,LocId);
         rSet=pSt.executeQuery();
         if(rSet.next())
            retVal=rSet.getLong("NEXTID");
      }
      catch(SQLException sExcept) 
      {
         System.out.println("getNewVoucherId_DAO SQLException");
         freeResource();
         msLogger.logDEBUG("getNewVoucherId_DAO SQLException ="+sExcept.getErrorCode()+"---"+sExcept.getMessage());
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("getNewVoucherId_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         msLogger.logDEBUG("getNewVoucherId_DAO Exception ="+Except.getMessage());
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;
   }

   /**
   * Method      Method Retrieves the next no from the sequence(FIN_VOUCHER_PARAMS_VHNO_SEQ)
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Voucher Type 
   * @param2     Location Id Of the User
   * @return     Returns the next no in the sequence(FIN_VOUCHER_PARAMS_VHNO_SEQ)
   */
   public long getNewVoucherNo_DAO(String VouchType,long LocId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      long retVal=0;
      try {
//         System.out.println(sQuery+"-"+LocId+"-"+VouchType);
         conn=dsConn.getDBConnection();   
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         conn.setAutoCommit(false);
/*         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getNewVoucherNo);
         pSt.setLong(1,LocId);
         pSt.setString(2,VouchType);
         rSet=pSt.executeQuery();
         if(rSet.next())
            retVal=rSet.getLong("PARAM_VOUCHER_NO");
         if(retVal!=0) {
            pSt.close();
            pSt=conn.prepareStatement(oCommonVoucherQueries.sql_UpdateParamVoucherNo);
            pSt.setLong(1,(retVal+1));
            pSt.setLong(2,LocId);
            pSt.setString(3,VouchType);
            if(pSt.executeUpdate()>0)   
                conn.commit();
         }*/
//         CallableStatement procout = conn.prepareCall ("{call get_voucherno(?, ?)}");
          CallableStatement procout = conn.prepareCall ("begin gl_accounting.get_voucherno(?,?); end;");
          procout.registerOutParameter(1,Types.INTEGER);
          procout.setInt(1,Integer.parseInt(String.valueOf(LocId)));
          procout.setString(2,VouchType);
          procout.executeUpdate();
          System.out.println(procout.getInt(1));
          retVal=procout.getInt(1);
          procout.close();
          if(retVal!=0)
            conn.commit();
          else
            conn.rollback();
      }
      catch(SQLException sExcept) 
      {
         System.out.println("getNewVoucherNo_DAO SQLException");
         conn.rollback();
         freeResource();
         msLogger.logDEBUG("getNewVoucherNo_DAO SQLException ="+sExcept.getErrorCode()+"---"+sExcept.getMessage());
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("getNewVoucherNo_DAO Exception");
         conn.rollback();
         freeResource();   
         Except.printStackTrace();
         msLogger.logDEBUG("getNewVoucherNo_DAO Exception ="+Except.getMessage());
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;      
   }

   /**
   * Method      Method Retrieves the financial year of the calendar
   * @Exception  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception
   * @param1     Voucher Type 
   * @param2     Location Id Of the User
   * @return     Returns the next no in the sequence(FIN_VOUCHER_PARAMS_VHNO_SEQ)
   */
   public String getCurrentFinYear_DAO(long LocId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      String retVal=null;
      try {
//         System.out.println(sQuery+"-"+LocId+"-"+VouchType);
         conn=dsConn.getDBConnection();   
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         conn.setAutoCommit(false);
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getFinancialYear);
         pSt.setLong(1,LocId);
         rSet=pSt.executeQuery();
         if(rSet.next())
            retVal=rSet.getString(1);
      }
      catch(SQLException sExcept) 
      {
         System.out.println("getCurrentFinYear_DAO SQLException");
         conn.rollback();
         freeResource();
         msLogger.logDEBUG("getCurrentFinYear_DAO SQLException ="+sExcept.getErrorCode()+"---"+sExcept.getMessage());
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("getCurrentFinYear_DAO Exception");
         conn.rollback();
         freeResource();   
         Except.printStackTrace();
         msLogger.logDEBUG("getCurrentFinYear_DAO Exception ="+Except.getMessage());
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;      
   }
   
   /**
   * Method      Specific for IAV Voucher and will be called onload of the Screen
   * @Exception  throws IBABusinessException,IBAFatalException,SQLException,Exception 
   * @param1     CommonVoucherVo object
   */ 
   public void onLoad_IAV_DAO(CommonVoucherVo oCommonVoucherVo) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception  {
      String empNo="";
      String empDesc="";
      try {
//         System.out.println(sQuery+"-"+LocId+"-"+VouchType);
         conn=dsConn.getDBConnection();   
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getFinTrType);
         rSet=pSt.executeQuery();
         while(rSet.next()) {
            PeriodBean pBean=new PeriodBean(Long.toString(rSet.getLong("TR_ID")),rSet.getString("TR_SDESC"));
            oCommonVoucherVo.getlstTrType().add(pBean);
         }
         rSet.close();
         pSt.close();
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getEmployee);
         pSt.setLong(1,oCommonVoucherVo.gettxtHidLocId());
         rSet=pSt.executeQuery();
         while(rSet.next()) {
            empNo=Long.toString(rSet.getLong("EMP_NO"));
            empDesc=rSet.getString("EMP_FST_NAME") + " " + rSet.getString("EMP_MDL_NAME") + " " + rSet.getString("EMP_LST_NAME");
            PeriodBean pBean=new PeriodBean(empNo,empNo+"-"+empDesc);
            oCommonVoucherVo.getlstEmp().add(pBean);
         }
         rSet.close();
         pSt.close();
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_GetSponsorGbltypes);
         rSet=pSt.executeQuery();
         while(rSet.next()) {
            PeriodBean pBean=new PeriodBean(rSet.getString("GBL_CODE"),rSet.getString("CODE_DESC"));
            oCommonVoucherVo.getlstSponsorGbl().add(pBean);
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("onLoad_IAV_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("onLoad_IAV_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();
   }

   /**
    * This method validates the date against the max date of the posted vouchers in the same location
    * @param String sLocId, String sDate
    * @exception IBAFatalException, IBABusinessException
    * @return void
    */
    public void validateVoucherDate(String sLocId, String sDate) throws IBAFatalException, IBABusinessException
    {          
        ResultSet rs = null;    
        Connection conn = null;
        PreparedStatement pStmt = null;                        
   
        try
        {
            // Get the connection
            conn = dsConn.getDBConnection();
            if (conn == null)
            {
                throw new IBAFatalException("Finance.DB.Administrator");
            }        

            // Pls add this query in ur sql queries
            pStmt = conn.prepareStatement(FCIPAY.HRMS.DATAACCESSTIER.SQLQueries.CommonVoucherQueries.VALIDATE_VH_DATE);
            pStmt.setObject(1, sDate, Types.VARCHAR);            
            pStmt.setObject(2, sDate, Types.VARCHAR);                        
            pStmt.setObject(3, sLocId, Types.VARCHAR);                        
            rs = pStmt.executeQuery();
            
            if (!rs.next())
            {
                // Pls define the following error key in the ApplicationResources file 
                // before you use this function
                //Finance.Voucher.DateError=Invalid Voucher Date! Vouchers for this date have already been posted!
                throw new IBABusinessException("Finance.Voucher.DateError");
            }                              

            if(rs != null)
                rs.close();                
            if(pStmt != null)
                pStmt.close();                             
              
            // Close the conn
            dsConn.closeConn(conn);
        }
        catch(IBABusinessException be)
        {
            // Close the conn
            dsConn.closeConn(conn);
            
            // To track the businness exception in the action class
//            be.setiErrCode(-90);
            
//            System.out.println("An Exception has occurred " + be.getMessage());
            throw be;
        }                        
        catch(IBAFatalException fe)
        {
            // Close the conn
            dsConn.closeConn(conn);
        
//            System.out.println("An Exception has occurred " + fe.getMessage());
            throw fe;
        }                
        catch(SQLException e)
        {
            // Close the conn
            dsConn.closeConn(conn);              
        
//            System.out.println("An Exception has occurred"+ e.getMessage());
//            System.out.println("error code is"+e.getErrorCode());
            IBAFatalException iba = new IBAFatalException("Finance.DB.Administrator");
            iba.setiErrCode(e.getErrorCode());
            iba.setsMessage(e.getMessage());
            e.printStackTrace();
            throw iba;                          
        }
        return;
    }

   public long getAcctId_ForTRId_DAO(long TrId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      long retVal=0;
      try {
//         System.out.println(sQuery+"-"+LocId+"-"+VouchType);
         conn=dsConn.getDBConnection();   
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_getAcctId_ForTrId_IAV);
         pSt.setLong(1,TrId);
         rSet=pSt.executeQuery();
         if(rSet.next())
            retVal=rSet.getLong("ACCT_ID");
      }
      catch(SQLException sExcept) 
      {
         System.out.println("getAcctId_ForTRId_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("getAcctId_ForTRId_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
      return retVal;      
   }

   public void deleteVoucherDAO(String VoucherId)  throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception  {
         try {
//         System.out.println(sQuery+"-"+LocId+"-"+VouchType);
         conn=dsConn.getDBConnection();   
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_Delete_Voucher);
         pSt.setLong(1,Long.parseLong(VoucherId));
         pSt.executeUpdate();
      }
      catch(SQLException sExcept) 
      {
         System.out.println("deleteVoucherDAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("deleteVoucherDAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();                       
   }

   /**
    * Method    Charge Code Id Search is performed and matching Id's are stored in ArrayList
    * @Exception  throws IBAFatalException,SQLException,Exception 
    * @param1   Location Id
    * @param2   ArrayList to Store the result
    * @param3   Query
    * @return   No of Rows Affected
    */
   public void SearchRecords_CH_NJVSJV_DAO(String LocId,ArrayList objList) throws IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      try {
         conn=dsConn.getDBConnection(); 
         if(conn==null)
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
//         System.out.println("Query="+sQuery);
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_CH_Search_NJV);
         long Id=Long.parseLong(LocId);
         pSt.setLong(1,Id);
         rSet=pSt.executeQuery();
         while(rSet.next()) 
         {
            objList.add(new PeriodBean(rSet.getString(2),rSet.getString(2)+"-"+rSet.getString(3)));
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("Method2 SQLException");
         sExcept.printStackTrace();
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("Method2Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
   }

   public void getTransactionModeForBPV(ArrayList objList,ArrayList acctIdList) throws IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      try {
         conn=dsConn.getDBConnection(); 
         if(conn==null)
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_SelectTransactionMode_BPV);
         rSet=pSt.executeQuery();
         String gblCode="";
         PeriodBean p=null;
         boolean found=false;
         while(rSet.next()) 
         {
            gblCode=rSet.getString(1);
            if(gblCode.startsWith("VHFOR$TPP")) {
                for(int i=0;i<acctIdList.size();i++) {
                    p=(PeriodBean)acctIdList.get(i);
                    if(gblCode.equals(p.getpId())) {
                        gblCode=gblCode+"-"+p.getpDesc();
                        found=true;
                    }
                }
            }
            if(gblCode.startsWith("VHFOR$TPP")) {
                if(found)
                    objList.add(new PeriodBean(gblCode,rSet.getString(2)));
            }
            else
                objList.add(new PeriodBean(gblCode,rSet.getString(2)));
            found=false;
         }
/*         PeriodBean p1=null;
         for(int i=0;i<objList.size();i++) {
             p1=(PeriodBean)objList.get(i);
             System.out.println(p1.getpId()+"*****"+p1.getpDesc());
         }*/
      }
      catch(SQLException sExcept) 
      {
         System.out.println("Method2 SQLException");
         sExcept.printStackTrace();
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("Method2Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
   }

   public void getTransactionAcctIdsBPV(ArrayList objList) throws IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      try {
         conn=dsConn.getDBConnection(); 
         if(conn==null)
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_SelectTransactionAcctId_BPV);
         rSet=pSt.executeQuery();
         String prevTransMode="";
         StringBuffer AcctId=new StringBuffer("");
         if(rSet.next()) {
            prevTransMode=rSet.getString(1);
            AcctId.append(String.valueOf(rSet.getLong(2)));
            AcctId.append(",");
         }
         String curTransMode="";
         boolean progress=false;
         while(rSet.next()) 
         {
            curTransMode=rSet.getString(1);
            if(prevTransMode.equals(curTransMode)) {
                AcctId.append(String.valueOf(rSet.getLong(2)));
                AcctId.append(",");
                progress=true;
            }
            else {
                objList.add(new PeriodBean(prevTransMode,AcctId.toString()));
                prevTransMode=curTransMode;
                AcctId.delete(0,(AcctId.length()-1));
                AcctId.append(String.valueOf(rSet.getLong(2)));
                AcctId.append(",");
                progress=false;
            }
         }
         if(progress) {
            objList.add(new PeriodBean(prevTransMode,AcctId.toString()));
         }
/*         PeriodBean p=null;
         for(int i=0;i<objList.size();i++) {
             p=(PeriodBean)objList.get(i);
             System.out.println(p.getpId()+"*****"+p.getpDesc());
         }*/
      }
      catch(SQLException sExcept) 
      {
         System.out.println("Method2 SQLException");
         sExcept.printStackTrace();
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("Method2Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();      
   }

   public void retrieveRecordsForEditCompare_DAO(CommonVoucherVo oCommonVoucherVo,String VoucherId) throws IBAException,IBAFatalException,IBABusinessException,SQLException,Exception 
   {
      ResultSet tSet=null;
      try {
//         System.out.println("Head Query="+qryHdr);
         conn=dsConn.getDBConnection(); 
         if(conn==null) 
         {
            System.out.println("Finance.Voucher.ConnectionFailure");
            throw new IBAFatalException("Finance.Voucher.ConnectionFailure");
         }
         pSt=conn.prepareStatement(oCommonVoucherQueries.sql_RetrieveRecordsForEdit_Dtl_IDS);
         pSt.setLong(1,Long.parseLong(VoucherId));         
         rSet=pSt.executeQuery();   
         while(rSet.next()) 
         {
            VoucherBean sBean=new VoucherBean(Long.toString(rSet.getLong("VOUCHER_DTL_ID")),String.valueOf(rSet.getLong("VOUCHER_TXN_NO")),"","","","","","","","","","","","","","","","");            
            oCommonVoucherVo.getlstRetainOriginalRows().add(sBean);
         }
      }
      catch(SQLException sExcept) 
      {
         System.out.println("retrieveRecordsForEdit_DAO SQLException");
         freeResource();
         ExceptionHandling(1,sExcept.getErrorCode(),sExcept.getMessage());                
      }
      catch(Exception Except) 
      {
         System.out.println("retrieveRecordsForEdit_DAO Exception");
         freeResource();   
         Except.printStackTrace();
         ExceptionHandling(2,0,Except.getMessage());
      }
      freeResource();           
   }

   /**
   * Method      Common Method for the CommonVoucherDAO
   * @Exception  throws IBAFatalException,SQLException,Exception 
   * @param1     Type(SQLException,General Exception)
   * @param2     SQL Error Code
   * @param3     SQL Error Message
   */
   private void ExceptionHandling(int Type,int key,String Message) throws SQLException,Exception,IBAFatalException
   {
      if(Type==1) 
      {
         System.out.println("SQL ErrCode="+key+" Message="+Message);
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
   * Method      Common Method for the CommonVoucherDAO to realese the Resource(ResultSet,PreparedStatement,Connection)
   * @Exception  throws SQLException,Exception 
   */
   private void freeResource() throws SQLException,Exception 
   {
      if(rSet!=null) {
         rSet.close();
         rSet=null;
      }
      if(pSt!=null) {
         pSt.close();
         pSt=null;
      }
      if(conn!=null) {
//         System.out.println("Free Resource CommonVoucherDAO="+conn);
         conn.close();
         conn=null;
      }
   }

   /**
   * Method      Common Method for the CommonVoucherDAO to realese the Resource(ResultSet,PreparedStatement,Connection)
   * @Exception  throws SQLException,Exception
   * @param1     ResultSet
   * @param2     PreparedStatement
   */
   private void freeResource(ResultSet tSet,PreparedStatement pStmt) throws SQLException,Exception 
   {
      if(tSet!=null) 
      {
         tSet.close();
         tSet=null;
      }
      if(pStmt!=null) 
      {
         pStmt.close();
         pStmt=null;
      }
   }

   
}