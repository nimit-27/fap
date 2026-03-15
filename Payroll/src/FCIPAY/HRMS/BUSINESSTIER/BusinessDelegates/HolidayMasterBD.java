/*
 * Module:        HolidayMasterBD.java
 * Author:        Prem K. Barai
 * Date Written:  02/06/2004
 * Description:   Business Delegate for the Holiday Master
 * Revision Log  (mm/dd/yy initials description)
 * --------------------------------------------------------
 * mm/dd/yy xxx  What you changed
 */


package FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates;

import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.MsgLogger;
import java.util.ArrayList;
import FCIPAY.HRMS.DATAACCESSTIER.DAO.CommonQueriesDAO;
import FCIPAY.HRMS.DATAACCESSTIER.DAO.HolidayMasterDAO;
import FCIPAY.HRMS.DATAACCESSTIER.VO.HolidayMaster_MasterPaneVO;
import FCIPAY.HRMS.DATAACCESSTIER.VO.HolidayMasterVO;
import java.sql.SQLException;


public class HolidayMasterBD 
{
   private MsgLogger msLogger = (MsgLogger) MsgLogger.getLogger(this);
   HolidayMasterDAO oHolidayMasterDAO = new HolidayMasterDAO();
   
   public HolidayMasterBD()
   {
   }

    /** Function to save the information in <HRM_HOLIDAY_MAST, HRM_HOLIDAY_DTL>.
     * @param       :   char, Value Object, ArrayList. 
     * @exception   :   IBAFatalException,SQLException.
     * @return      :   boolean.
     */
   public boolean setMasterPaneAndDetailPane(char flag, HolidayMaster_MasterPaneVO oHolidayMaster_MasterPaneVO, ArrayList oHolidayMasterVOs) throws IBAFatalException, SQLException
   {
      if(oHolidayMasterDAO.setHrmHolidayMastDetails(flag, oHolidayMaster_MasterPaneVO, oHolidayMasterVOs))
         return true;
      else
         return false;
   }

    /** Function to get the information from <COM_LOC_MST, HRM_HOLIDAY_MAST>.
     * @param       :   ArrayList. 
     * @exception   :   IBAFatalException
     */
   public void setYearAndLocation(ArrayList oHolidayMasterVOs) throws IBAFatalException
   {
      oHolidayMasterDAO.setYearAndLocation(oHolidayMasterVOs);
   }

    /** Function to get the information from <HRM_HOLIDAY_DTL>.
     * @return       :   ArrayList. 
     * @exception    :   IBAFatalException
     */     
   public ArrayList getRecord() throws IBAFatalException
   {
      ArrayList oHolidayMasterVOs = new ArrayList();
      oHolidayMasterVOs = oHolidayMasterDAO.getRecord();
      return oHolidayMasterVOs;
   }
   
   public ArrayList getHolidayDetails(int itemp, String psGblCode) throws IBABusinessException, IBAException, IBAFatalException, SQLException
   {
      msLogger.logDEBUG("'In Holiday Master DAO-getHolidayDetails(int, String)' itemp = " + itemp + ", " + "psGblCode" + psGblCode);
      ArrayList oQlfnTypeList=oHolidayMasterDAO.getGblCodeDetails(itemp, psGblCode);

      if (oQlfnTypeList==null || oQlfnTypeList.isEmpty() || oQlfnTypeList.size() <=0)
      {
         throw new IBABusinessException("HRMS.HOLIDAYDETAILS.NOTDEFINED");
      }
      else
         return oQlfnTypeList; 
   }

  public ArrayList getHolidays(HolidayMasterVO tempVO) throws IBAFatalException
  {
      return oHolidayMasterDAO.getHolidays(tempVO);
  }
  
  public ArrayList getUnitDetails()
  {
    ArrayList oVenueMastVos=null;
    try
    {
      oVenueMastVos=oHolidayMasterDAO.getUnitDetails();
      return oVenueMastVos;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      return oVenueMastVos;
    }
  }
}