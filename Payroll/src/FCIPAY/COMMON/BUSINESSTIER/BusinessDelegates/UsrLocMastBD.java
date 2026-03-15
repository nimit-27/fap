package FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates;

import FCIPAY.COMMON.DATAACCESSTIER.DAO.UsrLocMastDAO;
import FCIPAY.COMMON.DATAACCESSTIER.VO.UsrLocMastVO;
import FCIPAY.COMMON.UTILITY.*;

import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.IBAFatalException;

public class UsrLocMastBD 
{
    /**
     * This is the Onload function whihc gets executed on the Load of the pages
     * @return UsrLocMastVO which has all the Employees and the list of Locations that are to be assigned
     */
    public UsrLocMastVO getOnLoadDtls() throws IBAFatalException
    {
        UsrLocMastDAO oUsrLocDAO=new UsrLocMastDAO();
        return(oUsrLocDAO.getOnLoadDtls());
    }

    /**
     * This is the function whihc retrives all the prevously assigned dtls of the employee
     * @param emp_No The location id from the user info bean
     * @return ArrayList which has all the assigned location for that employees
     */
    public ArrayList getUsrLocDtls(long empNo) throws IBAFatalException
    {
        UsrLocMastDAO oUsrLocDAO=new UsrLocMastDAO();
        return(oUsrLocDAO.getEmpLocDtls(empNo));
    }

    /**
     * This is the function which saves the User Location mapping Details
     * @param usrlocMasterVO the Value Object which is having all the values
     * @return Arraylist which has the new list which has the recently saved record also
     */
    public ArrayList saveUsrLocDtls(UsrLocMastVO oUsrLocVO) throws IBAFatalException
    {
        UsrLocMastDAO oUsrLocDAO=new UsrLocMastDAO();
        return(oUsrLocDAO.saveUsrLocDtls(oUsrLocVO));
    }

    /**
     * This is the function which Updates the status of the User Location mapping
     * @param usrlocMasterVO the Value Object which is having all the values
     * @return Arraylist which has the new list which has the recently saved record also
     */
    public ArrayList updateUsrLocDtls(UsrLocMastVO oUsrLocVO) throws IBAFatalException
    {
        UsrLocMastDAO oUsrLocDAO=new UsrLocMastDAO();
        return(oUsrLocDAO.updateUsrLocDtls(oUsrLocVO));
    }
    
}