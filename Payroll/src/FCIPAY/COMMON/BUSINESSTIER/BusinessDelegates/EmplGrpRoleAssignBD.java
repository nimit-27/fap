package FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates;

import java.util.ArrayList;

import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.EmplGrpRoleAssignDAO;
import FCIPAY.COMMON.DATAACCESSTIER.VO.EmplGrpRoleAssignVO;

public class EmplGrpRoleAssignBD  {
    private EmplGrpRoleAssignDAO oEmplGrpRoleAssignDAO=null;
    
    public EmplGrpRoleAssignBD() {
        oEmplGrpRoleAssignDAO=new EmplGrpRoleAssignDAO();
    }

    public ArrayList getEmpUserLocIdDetailsBD(long empNo,long locId) throws IBAFatalException, IBABusinessException {
        ArrayList lstReturn=oEmplGrpRoleAssignDAO.getEmpUserLocIdDetailsDAO(empNo,locId);
        if(lstReturn.size()<=0)
            throw new IBABusinessException("COMMON.EMPLGRPROLEASSIGN.NOSUCHUSER");
        ArrayList lstModule=(ArrayList)lstReturn.get(2);
        ArrayList lstRole=(ArrayList)lstReturn.get(3);
        if(lstModule.size()<=0)
            throw new IBABusinessException("COMMON.EMPLGRPROLEASSIGN.NOMODULESIDEN");
        else if(lstRole.size()<=0)
            throw new IBABusinessException("COMMON.EMPLGRPROLEASSIGN.NOROLESIDEN");
        return lstReturn;
    }

    public ArrayList getEmpGroupDetailsBD(long empNo,long locId,String modId) throws IBAFatalException, IBABusinessException {
        ArrayList lstReturn=oEmplGrpRoleAssignDAO.getEmpGroupDetailsDAO(empNo,locId,modId);
        return lstReturn;
    }

    public ArrayList getEmpRoleRowDetailsBD(long userLocId,String roleId,String modId) throws IBAFatalException, IBABusinessException {
        ArrayList lstReturn=oEmplGrpRoleAssignDAO.getEmpRoleRowDetailsDAO(userLocId,roleId,modId);
        return lstReturn;
    }

    public void SaveBD(EmplGrpRoleAssignVO oEmplGrpRoleAssignVO) throws IBAFatalException, IBABusinessException {
        oEmplGrpRoleAssignDAO.SaveDAO(oEmplGrpRoleAssignVO);
    }
}