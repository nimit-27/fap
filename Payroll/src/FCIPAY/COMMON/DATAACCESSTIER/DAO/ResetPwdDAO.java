/*
 * Program Name : ChangePwdDAO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Data Access Object File which access the 
 *                  Database and resets the password
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ResetPwdVO;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries;

import java.sql.*;
import java.util.*;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;


import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class ResetPwdDAO extends BaseDAO
{
    public ResetPwdDAO() 
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
        //  oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_GetEmpDtls);
        oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_GetUserDtls);
           oIt = oOutArray.iterator();
            if(oIt.hasNext())
            {
                isRecordExists=1;
                oRow = (QueryRow)oIt.next();
                oResetPwdVO.setHdnEmpName(oRow.get("EMP_NAME").getString());
                oResetPwdVO.setHdnEmpDept(oRow.get("loc_desc").getString());
                oResetPwdVO.setHdnEmpDesig(oRow.get("dsgn_desc").getString());
                /*
                oResetPwdVO.setHdnEmpName("");
                oResetPwdVO.setHdnEmpDept("");
                oResetPwdVO.setHdnEmpDesig("");*/
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
     * This function is to Reset the Password of the Employee
     * @param: Employee Number
     * @returns : boolean true if reseted
     * @Tables-Accessed: sysadmin_user_mst
     */
    public boolean resetPwd(long empNo) throws IBAFatalException,SQLException
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
           oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,strPwd));
           oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
           iRetType = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_ResetPwd);
           
            
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
}