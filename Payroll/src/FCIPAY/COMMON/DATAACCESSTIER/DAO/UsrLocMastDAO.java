/*
 * Program Name : UsrLocMastDAO.java
 * Author       : Jegan.V
 * Date Written : 29/07/2004
 * Description  : This DAO has all the database relaated things
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import java.util.*;
import java.sql.*;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UsrLocMastSQLQueries;
import FCIPAY.COMMON.DATAACCESSTIER.VO.UsrLocMastVO;
import FCIPAY.COMMON.UTILITY.comboBean;
import FCIPAY.COMMON.UTILITY.UsrLocationBean;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class UsrLocMastDAO extends BaseDAO
{
    public UsrLocMastDAO()
    {
        super("Common");
    }

    /**
     * This is the Onload function whihc gets executed on the Load of the pages
     * @return UsrLocMastVO which has all the Employees and the list of Locations that are to be assigned
     */
    public UsrLocMastVO getOnLoadDtls() throws IBAFatalException
    {
        UsrLocMastVO oUsrLocVO=new UsrLocMastVO();
        ArrayList templist=null;
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
            //For Getting the Employee Number
            templist=new ArrayList();
            oOutArray = oBean.executeQuery(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UsrLocMastSQLQueries.sql_GetEmpNo);
            oIt = oOutArray.iterator();
            System.out.println(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UsrLocMastSQLQueries.sql_GetEmpNo);
            while(oIt.hasNext()) 
            {
                oRow = (QueryRow)oIt.next();
                templist.add(new comboBean(Long.parseLong(oRow.get("EMP_NO").getString()),oRow.get("EMP_NAME").getString()));
            }
           
            oUsrLocVO.setEmpList(templist);

            templist=null;

            //For getting the Location Code
            templist=new ArrayList();
            oOutArray = oBean.executeQuery(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UsrLocMastSQLQueries.sql_GetLocation);
            oIt = oOutArray.iterator();
            while(oIt.hasNext()) 
            {
                oRow = (QueryRow)oIt.next();
                templist.add(new comboBean(Long.parseLong(oRow.get("LOC_ID").getString()),oRow.get("LOC_DESC").getString()));
            }
            
            oUsrLocVO.setLocList(templist);
            
        }
        catch(Exception e) 
        {
            //e.printStackTrace();    
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return oUsrLocVO;
    }


    /**
     * This is the function to retrive all the previosuly assigned locations to the employee
     * @param emp_no The employee number which is selected
     * @return arraylist which has all the details which are retrived.
     */
    public ArrayList getEmpLocDtls(long empNo) throws IBAFatalException
    {
        ArrayList templist=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
            //For Getting the Employee Number
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UsrLocMastSQLQueries.sql_GetUsrLocDtls);
            oIt = oOutArray.iterator();
            while(oIt.hasNext()) 
            {
                oRow = (QueryRow)oIt.next();
                templist.add(new UsrLocationBean(Long.parseLong(oRow.get("EMP_NO").getString()),oRow.get("EMP_NAME").getString(),Long.parseLong(oRow.get("LOC_ID").getString()),oRow.get("LOC_SDESC").getString(),oRow.get("LOC_STAT_FLG").getString(),Long.parseLong(oRow.get("USERLOC_ID").getString())));
            }
        }
        catch(Exception e) 
        {
            //e.printStackTrace();    
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return templist;
    }

    /**
     * This function is to save the employee and location mapped details
     * @param usrLocMasterVO The value Object which has all the inputs
     * @return arraylist which includes the recent details which are saved also.
     */
    public ArrayList saveUsrLocDtls(UsrLocMastVO oUsrLocVO) throws IBAFatalException
    {
        ArrayList templist=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int retSave=0;
        try
        {
            //For Getting the Employee Number
           
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getLstLocation())));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getLstEmpNo())));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getLstLocation())));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oUsrLocVO.getLstStatus()));
            oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getUserEmpNo())));
            oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getUserLocId())));
            
            retSave = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UsrLocMastSQLQueries.sql_InsertUsrLocDtls);
            if(retSave>0)
            {
               templist=getEmpLocDtls(oUsrLocVO.getLstEmpNo());
            }
            
        }
        catch(Exception e) 
        {
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return templist;
    }


    /**
     * This function is to Update the status of the employee and location mapped details
     * @param usrLocMasterVO The value Object which has all the inputs
     * @return arraylist which includes the recent details which are saved also.
     */
    public ArrayList updateUsrLocDtls(UsrLocMastVO oUsrLocVO) throws IBAFatalException
    {
        ArrayList templist=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int retSave=0;
        try
        {
            //For Getting the Employee Number
           
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oUsrLocVO.getLstStatus()));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getUserEmpNo())));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getUserLocId())));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oUsrLocVO.getHdnUsrLocId())));
            retSave = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.UsrLocMastSQLQueries.sql_UpdateUsrLocDtls);
            if(retSave>0)
            {
                templist=getEmpLocDtls(oUsrLocVO.getLstEmpNo());
            }
            
        }
        catch(Exception e) 
        {
            //e.printStackTrace();    
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return templist;
    }
}