
/*
 * Program Name : ProblemReportDAO.java
 * Author       : Jegan.V
 * Date Written : 24/05/2004
 * Description  : This is the Data Access Object File which access the 
 *                  Database and updates the Screens assigned to the User
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import java.sql.*;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ProblemDescQueries;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ProblemReportVO;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;

public class ProblemReportDAO extends BaseDAO
{
    public ProblemReportDAO()
    {
        super("COMMON");
    }

    /**
     * This function is to save the Problem Details
     * @param : ProblemReportVO
     * @returns : true if saved correctly
     *            false if any error
     * @Tables-Accessed: Retrived from sysadmin_problem_report
     */
     
    public boolean saveDtls(ProblemReportVO oProblemVO) throws IBAFatalException
    {   
        ResultSet res=null;
        boolean retType=false;
        try
        {
            doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ProblemDescQueries.sql_SaveProblemDtls);
            setLONGPRIMITIVE(oProblemVO.getUserLoc());
            setVARCHAR(oProblemVO.getTxtScreenName());
            setVARCHAR(oProblemVO.getTxtArProblemDesc());
            setVARCHAR(oProblemVO.getTxtArCause());
            setLONGPRIMITIVE(oProblemVO.getUserEmpNo());
            setLONGPRIMITIVE(oProblemVO.getUserLoc());

            if(doExecuteUpdate()>0)
            {
                retType=true;
                commit();
            }
            closePreparedStatement();
            closeConnection();
        }
        catch(IBAFatalException ibafe)
        {
            closePreparedStatement();
            closeConnection();
            ibafe.printStackTrace();
        }
        catch(Exception e)
        {
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
        }
        return retType;
    }
}