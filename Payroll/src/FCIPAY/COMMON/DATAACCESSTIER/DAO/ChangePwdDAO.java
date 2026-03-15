/*
 * Program Name : ChangePwdDAO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Data Access Object File which access the 
 *                  Database and updates the password
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import java.sql.*;

import FCIPAY.COMMON.DATAACCESSTIER.VO.ChangePwdVO;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;


import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import java.util.ArrayList;
import java.util.Iterator;

public class ChangePwdDAO extends BaseDAO
{
    public ChangePwdDAO() 
    {
        super("Common");
    }


    /**
     * This function is to set the Changed Password
     * @param ChangePwdVO which contains the old and new password
     * @return boolean ture= if success else false
     * @tables-Accessed are sysadmin_user_mst
     */
    public boolean setPwd(ChangePwdVO oChangePwdVO) throws IBAFatalException
    {
        
        boolean retType=false;
        try
        {
            int count=0;
            ArrayList oParameters = new ArrayList(); //Input Parameters      
            DBUtilitiesBean oBean = new DBUtilitiesBean();
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oChangePwdVO.getEncryptPwd()));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oChangePwdVO.getUserEmpNo())));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oChangePwdVO.getUserSiteId())));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oChangePwdVO.getUserEmpNo())));
            oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oChangePwdVO.getTxtOldPwd()));
            count = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_ChangePwd);
 
            if(count > 0)
            {
                retType=true;
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
            throw new IBAFatalException("Common.Database.Error");
        }
        return retType;
    }
}