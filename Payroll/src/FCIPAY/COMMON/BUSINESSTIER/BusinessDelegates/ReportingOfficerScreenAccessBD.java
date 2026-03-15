package FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.ReportingOfficerScreenAccessDAO;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.IBAException;
import java.util.ArrayList;
import java.sql.SQLException;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ReportingOfficerScreenAccessVO;

public class ReportingOfficerScreenAccessBD 
{
    public ReportingOfficerScreenAccessBD()
    {
    }

    public ArrayList getLevels(String query,String exisEmpNo,String ReptEmpNo,long locID,long newLocID) throws IBAException,IBABusinessException, IBAFatalException,SQLException
     {
         ReportingOfficerScreenAccessDAO oDAO=new ReportingOfficerScreenAccessDAO();
         return oDAO.getLevels(query,exisEmpNo,ReptEmpNo,locID,newLocID);
     }

     public ArrayList getEmpName(ReportingOfficerScreenAccessVO tempVO) throws IBAFatalException, SQLException
    {
        ReportingOfficerScreenAccessDAO oDAO = new ReportingOfficerScreenAccessDAO();
        return oDAO.getEmpName(tempVO);
    }

     public boolean updateList(ReportingOfficerScreenAccessVO oVO) throws IBAException,IBABusinessException, IBAFatalException,SQLException
     {
         ReportingOfficerScreenAccessDAO oDAO=new ReportingOfficerScreenAccessDAO();
         return oDAO.updateList(oVO);
     }
}