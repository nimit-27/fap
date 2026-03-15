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
import FCIPAY.COMMON.DATAACCESSTIER.VO.SysadminEmpGrpVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.SysadminEmpGrpDAO;
import java.util.StringTokenizer;
import java.util.*;
import java.sql.*;
import FCIPAY.COMMON.UTILITY.*;

public class SysadminEmpGrpBD 
{
    SysadminEmpGrpDAO oSPMDAO=new SysadminEmpGrpDAO();
    //SysadminEmpGrpVO  oSPMVO= new SysadminEmpGrpVO();

    /**
     * This method retrieves CODE_DESC from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL Tables
     * @param String iLCCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

      /**
     * This method retrieves CODE_DESC from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL Tables
     * @param String iLCCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

    public List getValues(long lLocCode) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
        //System.out.println("before DAO IN BD");
        List cList;
        cList = oSPMDAO.getValues(lLocCode);
        return cList;
    }

    public SysadminEmpGrpVO displayDesc(SysadminEmpGrpVO oSPMVO) throws IBAException,IBABusinessException, IBAFatalException,NullPointerException,SQLException

    {
        
        oSPMVO = oSPMDAO.displayDesc(oSPMVO);
        return oSPMVO;
    }

        
    public List getValues3(String query) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
        List cList;
        cList = oSPMDAO.getValues3(query);
        return cList;
    }

        public boolean saveDetails(SysadminEmpGrpVO oSPMVO,String iLCCode,String iLCCode1) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {

        //System.out.println("It is in SAVE in BD");
        //System.out.println("value ="+iLCCode);
        //System.out.println("value ="+iLCCode1);
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
}