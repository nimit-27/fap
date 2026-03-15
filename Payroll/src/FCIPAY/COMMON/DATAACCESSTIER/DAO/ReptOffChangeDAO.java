package FCIPAY.COMMON.DATAACCESSTIER.DAO;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.BaseDAO;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import java.sql.SQLException;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ReptOffChangeVO;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ReptOffChangeSQLQueries;
import java.sql.ResultSet;
import FCIPAY.COMMON.UTILITY.DSConnect;
import java.sql.PreparedStatement;
import java.sql.Connection;
import FCIPAY.COMMON.UTILITY.DynamicMenuBean;


public class ReptOffChangeDAO extends BaseDAO 
{
    public ReptOffChangeDAO()
    {
        super("HRMS");
    }

    private DSConnect oDsConn = null;
    private ResultSet res=null;
    private PreparedStatement pStmt = null;  
    private Connection oConn=null;

    public String getEmpName(ReptOffChangeVO oVO) throws IBAFatalException, SQLException
    {
        String empName = null;
        try
        {
            doPrepareStatement(ReptOffChangeSQLQueries.GET_EMPNAME);
            setLONGPRIMITIVE(Long.parseLong(oVO.getTxtExisEmployeeNo()));
            setLONGPRIMITIVE(oVO.getLSiteID());
            res = doExecuteQuery(false);
            if(res.next())
                empName = res.getString("EMPLOYEE");
            res.close();
            closePreparedStatement();
            if("A".equals(oVO.getHdnFlag()))
            {
                doPrepareStatement(ReptOffChangeSQLQueries.GET_COUNT);
                setLONGPRIMITIVE(Long.parseLong(oVO.getTxtExisEmployeeNo()));
                res = doExecuteQuery(false);
                while(res.next())
                {
                    oVO.setHdnCount(res.getInt("numb"));
                    oVO.setHdnFlag("");
                }
                res.close();
                closePreparedStatement();
            }
            closeConnection();
        }
        catch(SQLException sqle)
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            throw new IBAFatalException("HRMS.DBError.General");
        }
        catch(Exception e)
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            throw new IBAFatalException("HRMS.DBError.General");
        }
        return empName;
    }

    public ArrayList getEmpInfo(ReptOffChangeVO oVO) throws IBAFatalException, SQLException
    {
        try
        {
            doPrepareStatement(ReptOffChangeSQLQueries.GET_EMP_INFO);
            setLONGPRIMITIVE(Long.parseLong(oVO.getTxtExisEmployeeNo()));
            res = doExecuteQuery(false);
            DynamicMenuBean oBean=null;
            while(res.next())
            {
                oBean=new DynamicMenuBean(res.getLong("emp_no"),res.getString("emp_name"),res.getString("grade_desc"),res.getString("sect_name"),res.getString("emp_grp"));
                oVO.getMenuList().add(oBean);
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }
        catch(SQLException sqle)
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            throw new IBAFatalException("HRMS.DBError.General");
        }
        catch(Exception e)
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            throw new IBAFatalException("HRMS.DBError.General");
        }
        return oVO.getMenuList();
    }
    
    public boolean update_ReptOff(ReptOffChangeVO oVO) throws IBAFatalException,SQLException,Exception
    {
        res=null;   
        pStmt=null;
        oDsConn = new DSConnect();
        oConn =oDsConn.getDBConnection();
        oConn.setAutoCommit(false);
        boolean ret=false;
        try
        {
            pStmt=oConn.prepareStatement(ReptOffChangeSQLQueries.UPDATE_REPTOFF);
            pStmt.setLong(1,Long.parseLong(oVO.getTxtReptEmployeeNo()));
            pStmt.setLong(2,oVO.getLUserID());
            pStmt.setLong(3,oVO.getLSiteID());
            pStmt.setLong(4,Long.parseLong(oVO.getTxtExisEmployeeNo()));
            pStmt.setLong(5,Long.parseLong(oVO.getTxtReptEmployeeNo()));
            pStmt.executeUpdate();
        }
        catch(SQLException sqlex)
        {
            oConn.rollback();
            pStmt.close();
            oConn.close();
            IBAFatalException ibafe = new IBAFatalException("Common.DB.Administrator");
            ibafe.setsMessage(sqlex.getMessage());
            ibafe.setiErrCode(sqlex.getErrorCode());
            throw ibafe;
        }
        catch(Exception e)
        {
            oConn.rollback();
            pStmt.close();
            oConn.close();
            e.printStackTrace();
            IBAFatalException ibafe = new IBAFatalException("HRMS.DB.Administrator");
            ibafe.setsMessage(e.getMessage());
            throw ibafe;
        }
        finally
        {
            pStmt.close();
            oConn.commit();
            oConn.close();
        }
        return ret=true;
    }
}