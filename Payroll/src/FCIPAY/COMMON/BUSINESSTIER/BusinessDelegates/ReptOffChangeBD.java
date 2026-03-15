package FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import java.sql.SQLException;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.ReptOffChangeDAO;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ReptOffChangeVO;

public class ReptOffChangeBD 
{
    public ReptOffChangeBD()
    {
    }

    ReptOffChangeDAO oReptDAO = null;
    ReptOffChangeVO oVO = null;

    public String getEmpName(ReptOffChangeVO tempVO) throws IBAFatalException, SQLException
    {
        oReptDAO = new ReptOffChangeDAO();
        return oReptDAO.getEmpName(tempVO);
    }

    public ArrayList getEmpInfo(ReptOffChangeVO tempVO) throws IBAFatalException, SQLException
    {
        oReptDAO = new ReptOffChangeDAO();
        return oReptDAO.getEmpInfo(tempVO);
    }
    
    public boolean update_ReptOff(ReptOffChangeVO oVO) throws IBAFatalException,SQLException,Exception
    {
        oReptDAO = new ReptOffChangeDAO();
        return oReptDAO.update_ReptOff(oVO);
    }
}