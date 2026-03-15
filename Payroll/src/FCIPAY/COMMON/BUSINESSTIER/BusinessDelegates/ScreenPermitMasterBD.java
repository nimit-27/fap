/* 
    * Module:        ScreenPermitMasterBD.java 
    * Author:        Gaurav Arora   
    * Date Written:  11/2004    
    * Description:   Business Delegate class for Permit Master Screen
    * Revision Log   (mm/dd/yy initials description) 
    * -------------------------------------------------------- 
    * mm/dd/yy xxx  What you changed … 
*/ 

package FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ScreenPermitMasterVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.ScreenPermitMasterDAO;
import java.util.StringTokenizer;
import java.util.*;
import java.sql.*;
import FCIPAY.COMMON.UTILITY.*;

public class ScreenPermitMasterBD 
{
    ScreenPermitMasterDAO oSPMDAO=new ScreenPermitMasterDAO();

    /**
     * This method retrieves CODE_DESC from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL Tables
     * @param String iLCCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

    public List getValues() throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
        System.out.println("before DAO IN BD");
        List cList;
        cList = oSPMDAO.getValues();
        return cList;
    }

    /**
     * This method retrieves screenaccess_id,screen names from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL Tables
     * @param String iLCCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */
    public List displayDesc(String iLCCode) throws IBAException,IBABusinessException, IBAFatalException,NullPointerException,SQLException

    {
        
        List cList1;
        cList1 = oSPMDAO.displayDesc(iLCCode);
        return cList1;
    }

    /**
     * This method retrieves EMP_NO from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL,SYSADMIN_USER_LOC Tables
     * @param String iLCCode,String iLCCode1,long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

    
    public List getValues3(String query) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
        List cList;
        cList = oSPMDAO.getValues3(query);
        return cList;
    }

    

    /**
     * This method insert and delete record into sysadmin_emp_screen_map Table
     * @param MeterMasterVO oSPMVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return true,false
     */
    public boolean saveDetails(ScreenPermitMasterVO oSPMVO,String iLCCode,String iLCCode1) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {

        System.out.println("It is in SAVE in BD");
        System.out.println("value ="+iLCCode);
        System.out.println("value ="+iLCCode1);
        String sSelValues=oSPMVO.getSAction1();
        List cList= new ArrayList();
        StringTokenizer st = new StringTokenizer(sSelValues,",");
        while(st.hasMoreTokens())
        {
            String sTrial= st.nextToken();
            cList.add(sTrial);
        }
        oSPMVO.setLstMapValues(cList);

        if(oSPMDAO.setDetails(oSPMVO,iLCCode,iLCCode1))
            return true;
        else
            return false;
    }

     public ArrayList getLevels(String query,String module,String header) throws IBAException,IBABusinessException, IBAFatalException,SQLException
     {
         return oSPMDAO.getLevels(query,module,header);
     }


}



 