    /*
     * Module       :   UploadBD.java
     * Author       :   V.Jegan
     * Date Written :   30th Sept 2003
     * Description  :   The Buisness Delegate for the form which has the 
     *                  buisness logic in it.
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */


package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.Payroll.DATAACCESSTIER.DAO.UploadDAO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UploadVO;
import java.util.ArrayList;
import java.sql.SQLException;
import org.apache.struts.upload.FormFile;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ErrorMessageVO;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;

public class UploadBD 
{
   
    /**
    * This is the setDetails() method called from the 
    *       action class (uploadAction.java)
    * @param the VO (uploadVO.java) from the action class.
    * @returns true when exectued correctly
    * @returns false when not executed.
    */
    public ErrorMessageVO setDetails(UploadVO oUploadVO,FormFile sFile) throws IBAException,IBAFatalException,IBABusinessException, Exception
    {
        UploadDAO oUploadDAO=new UploadDAO();
/*        if(oUploadDAO.setValues(oUploadVO,sFile))
            return true;
        return false; */
        return oUploadDAO.setValues(oUploadVO,sFile);
    }

    public String uploadFinal(UploadVO oUploadVO) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
        UploadDAO oUploadDAO=new UploadDAO();
        return oUploadDAO.uploadFinal(oUploadVO);
    }
    

    /**
    * This is the getLocCode() method called from the 
    *       action class (uploadAction.java)
    * This methos is for retriving the Location Code from the database.
    * @returns arraylist which has the location code in it.
    */
/*    public ArrayList getLocCode() throws IBAException,IBAFatalException,IBABusinessException
    {
        ArrayList locationlst=new ArrayList();
/*        UploadDAO oUploadDAO=new UploadDAO();
        locationlst=oUploadDAO.getLocCodeDtls();
        if(locationlst.isEmpty())
        throw new IBABusinessException("Finance.LocCode.NotFound");
        else
        return(locationlst);
    }*/

    /**
    * This is the getAccCode() method called from the 
    *       action class (uploadAction.java)
    * This methos is for retriving the Account Code from the database.
    * @returns arraylist which has the account code in it.
    */
    public boolean getAccCode(UploadVO oUploadVO) throws IBAException,IBAFatalException,IBABusinessException,SQLException
    {
        UploadDAO oUploadDAO=new UploadDAO();
        if(oUploadDAO.getAccCodeDtls(oUploadVO))
            return true;
        return false;
    }
}