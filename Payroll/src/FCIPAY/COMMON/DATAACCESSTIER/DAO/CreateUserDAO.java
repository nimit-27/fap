/*
 * Program Name : ChangePwdDAO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Data Access Object File which access the 
 *                  Database and resets the password
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.*;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ResetPwdVO;
import FCIPAY.COMMON.DATAACCESSTIER.VO.NewLovVO;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries;
import FCIPAY.Payroll.common.bean.LOVBean;
import java.sql.*;
import java.util.*;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;


import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
public class CreateUserDAO extends BaseDAO
{
    public CreateUserDAO() 
    {
        super("Common");
    }

    /**
     * This function is to Get the Employee Details of the given Employee
     * @param: Employee Number
     * @returns : ResettPwdVo which has all the Employee Details
     * @Tables-Accessed: hrm_employee,hrm_dsgn,hrm_sect_mst
     */
    public ResetPwdVO getEmpDetails(long empNo) throws IBAFatalException,SQLException 
    {
        ResetPwdVO oResetPwdVO=new ResetPwdVO();
        int isRecordExists=0;
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
        
          oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
          oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UserMastQueries.sql_GetEmpDtls);
           oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                isRecordExists=1;
                oRow = (QueryRow)oIt.next();
                oResetPwdVO.setHdnEmpName(oRow.get("EMP_NAME").getString());
                oResetPwdVO.setHdnEmpDept(oRow.get("loc_desc").getString());
                oResetPwdVO.setHdnEmpDesig(oRow.get("dsgn_desc").getString());
            }
                
       /*     doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_GetEmpDtls);
         //   setLONGPRIMITIVE(empNo);
            resEmpDtls=doExecuteQuery(false);

            while(resEmpDtls.next()) 
            {
                isRecordExists=1;
                oResetPwdVO.setHdnEmpName(resEmpDtls.getString("EMP_NAME"));
                oResetPwdVO.setHdnEmpDept(resEmpDtls.getString("SECT_NAME"));
                oResetPwdVO.setHdnEmpDesig(resEmpDtls.getString("DSGN"));
            }*/
            oResetPwdVO.setHdnEmpDtls(isRecordExists);
        }
        catch(Exception e) 
        {
            closeConnection();
            e.printStackTrace();    
        }
        return oResetPwdVO;
    }


    /**
     * This function is to Create User
     * @param: Employee Number
     * @returns : boolean true if reseted
     * @Tables-Accessed: sysadmin_user_mst
     */
    public boolean insertUsr(long empNo,long userEmpNo,long userLocCode) throws IBAFatalException,SQLException
    {
        boolean retType=false;
        
        Iterator oIt = null;
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int iRetType=0;
        String strPwd="";
        try
        {
          //  doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_ResetPwd);
           //strPwd=Encryption.encodePassword(String.valueOf(empNo),"MD5");
           strPwd=Encryption.encodePassword(new String("payroll1"),"MD5");           
           
           oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
           oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,strPwd));
           oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new Long(userEmpNo)));
           oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new Long(userLocCode)));
           
           iRetType = oBean.executeUpsert(oParameters,UserMastQueries.sql_InsertUser);
           
            
            if(iRetType>0)
            {
                retType=true;
            }
        }
        catch(Exception e) 
        {
           e.printStackTrace();    
        }
        return retType;
    }
    
     //added by neeraj gupta 0n 5 oct 2010 starts here
  public LovVO getQueryEmpInfoLOVData(NewLovVO oNewLovVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    //arylstHeaderNames.add("Middle Name");  //Commented by Neeraj on 20Oct 2010  
    //arylstHeaderNames.add("Last Name");    //Commented by Neeraj on 20Oct 2010
    arylstHeaderNames.add("CPF Code");  // added by devendra
   arylstHeaderNames.add("Site Code"); 
   arylstHeaderNames.add("Site Name"); 
   arylstHeaderNames.add("User"); 
   arylstHeaderNames.add("Emp_type"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE); // added by devendra
    arylstVisibility.add(EnrgiseConstants.VISIBLE); //added by neeraj
    arylstVisibility.add(EnrgiseConstants.HIDDEN); 
    
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    LovQueryVO oLovQueryVO=new  LovQueryVO();
    //NewLovVO oNewLovVO=new NewLovVO();
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    //oParameters = new ArrayList();
   
  //  System.out.println("TXTSITEID-->"+ oLovQueryVO.getProperty("txtSiteID"));
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getProperty("txtSiteID"))));
   // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getProperty("txtSiteID"))));
   //System.out.println("First Input String---->"+new String(oNewLovVO.getSearchField1()));
  /* oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
   oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
   oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
   oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
    oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
     oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
      oParameters.add(new InputDBObject(7,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
       //oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
*/
    

   
           //oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,strPwd));
   

  // System.out.println("1-->"+oNewLovVO.getSearchField1());
   
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField2())));      
    //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getProperty("hdnEmpLbrFlag")))); // added by swapnendu Dt 24 Aug 2011.
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField3())));  
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField4())));  // added by devendra on 16th aug 2010
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField5())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField6())));
   // oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField7())));
    //oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField8()))); //middle name addition
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));    
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    
    //System.out.println("Parameters are--->"+oParameters);
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpFinLOV_new(?,?,?,?,?,?,?)");  commented by devendra on 16th aug 2010
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.PROC_QUERYEMPLOV_NEW(?,?,?,?,?,?,?,?)");  //added by neeraj on 5 oct 2010
    
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    QueryRow oRow=null; 
    Iterator iter = oList.iterator();
    while(iter.hasNext())
    {
      if(count == 0)
      {
         oList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)iter.next();
      oLOVBean = new LOVBean();
      //System.out.println("I am here");
        oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        //oLOVBean.setDetailField3(oRow.get("EMP_MIDDLE_NAME").getString());   //Commented by Neeraj on 20Oct 2010         
        //oLOVBean.setDetailField4(oRow.get("EMP_LAST_NAME").getString());      //Commented by Neeraj On 20 Oct 2010
        oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());   // added  by devendra on 16th aug 2010
       oLOVBean.setDetailField4(oRow.get("SITE_CODE").getString()); //added by neeraj
       oLOVBean.setDetailField5(oRow.get("SITE_DESC").getString()); //added by neeraj
       oLOVBean.setDetailField6(oRow.get("USR").getString()); //added by neeraj
       oLOVBean.setDetailField7(oRow.get("Emp_lbr").getString()); 
      oList.add(oLOVBean);
      oLOVBean = null;
      oRow = null;
    }
    oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

//added by swapnendu Dt 26 Aug 2011 Start........
  public LovVO getQueryEmpInfoLOVDataNew(NewLovVO oNewLovVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code");
    arylstHeaderNames.add("Site Code"); 
    arylstHeaderNames.add("Site Name"); 
    arylstHeaderNames.add("User"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    
    oLovVO.setVisibilityList(arylstVisibility);
    LOVBean oLOVBean;
    int count;
    count = 0;
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    LovQueryVO oLovQueryVO=new  LovQueryVO();
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField2())));      
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("E")));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField3())));  
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField4())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField5())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNewLovVO.getSearchField6())));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));    
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.PROC_QUERYEMPLOV_NEW(?,?,?,?,?,?,?,?,?)");
    
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    QueryRow oRow=null; 
    Iterator iter = oList.iterator();
    while(iter.hasNext())
    {
      if(count == 0)
      {
         oList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)iter.next();
      oLOVBean = new LOVBean();
      oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
      oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField4(oRow.get("SITE_CODE").getString());
      oLOVBean.setDetailField5(oRow.get("SITE_DESC").getString());
      oLOVBean.setDetailField6(oRow.get("USR").getString());
      oList.add(oLOVBean);
      oLOVBean = null;
      oRow = null;
    }
    oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }
 //added by swapnendu on 26 Aug 2011 end 
    
        /**
     * This function is to Check whether the uSer already exists or not
     * @param: Employee Number
     * @returns : Count
     */
    public int chkUser(long empNo) throws IBAFatalException,SQLException 
    {
        int isRecordExists=0;
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
        
          oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
          oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UserMastQueries.sql_GetUserDtls);
           oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                isRecordExists=Integer.parseInt(oRow.get("reccount").getString());
            }
                
       /*     doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_GetEmpDtls);
         //   setLONGPRIMITIVE(empNo);
            resEmpDtls=doExecuteQuery(false);

            while(resEmpDtls.next()) 
            {
                isRecordExists=1;
                oResetPwdVO.setHdnEmpName(resEmpDtls.getString("EMP_NAME"));
                oResetPwdVO.setHdnEmpDept(resEmpDtls.getString("SECT_NAME"));
                oResetPwdVO.setHdnEmpDesig(resEmpDtls.getString("DSGN"));
            }*/
        }
        catch(Exception e) 
        {
            closeConnection();
            e.printStackTrace();    
        }
        return isRecordExists;
    }
     /**
     * This function is added by swapnendu Dt 09 Oct 2012
     * to Check whether the User is Active or Inactive now.
     */
    public String chkUserStatus(long empNo) throws IBAFatalException,SQLException 
    {
        String userSts = "";
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
          oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
          oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UserMastQueries.sql_GetUserSts);
          oIt = oOutArray.iterator();
          while(oIt.hasNext())
          {
            oRow = (QueryRow)oIt.next();
            userSts = oRow.get("emp_stat_flg").getString();
          }
        }
        catch(Exception e) 
        {
            closeConnection();
            e.printStackTrace();    
        }
        return userSts;
    }
     /**
     * This function is added by swapnendu Dt 09 Oct 2012
     * to make the User Active.
     */

    public boolean makeUserActive(long empNo, long userid, long userLocCode) throws IBAFatalException,SQLException 
    {
        boolean retType=false;
        Iterator oIt = null;
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int iRetType=0;
        try
        {
           oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new Long(userid)));
           oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new Long(userLocCode)));
           oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
           iRetType = oBean.executeUpsert(oParameters,UserMastQueries.sql_MakeUserActive);
           if(iRetType>0)
           {
               retType=true;
           }
        }
        catch(Exception e) 
        {
            closeConnection();
            e.printStackTrace();    
        }
        return retType;
    }
    
     /**
     * This function is added by swapnendu Dt 16 Oct 2012
     * to Check if the The site trying to activate the user is Headquarter or not. Only HQ can activate an inactive user.
     */

    public int chkIfHeadQuarter(long siteId) throws IBAFatalException,SQLException 
    {
        int isRecordExists=0;
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(siteId)));
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UserMastQueries.sql_ChkIfHQ);
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                isRecordExists=Integer.parseInt(oRow.get("reccount").getString());
            }
        }
        catch(Exception e) 
        {
            closeConnection();
            e.printStackTrace();    
        }
        return isRecordExists;
    }
}