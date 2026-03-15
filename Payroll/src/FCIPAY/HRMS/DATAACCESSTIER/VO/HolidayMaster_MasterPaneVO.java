/*
 * Module:        HolidayMaster_MasterPaneVO.java
 * Author:        Prem K. Barai
 * Date Written:  02/06/2004
 * Description:   Value Object for the Master Pane of the Holiday Master
 * Revision Log  (mm/dd/yy initials description)
 * --------------------------------------------------------
 * mm/dd/yy xxx  What you changed
 */


package FCIPAY.HRMS.DATAACCESSTIER.VO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolidayMaster_MasterPaneVO 
{
   private String txtLocation;
   private String txtWeeklyOff1;
   private String txtWeeklyOff2;
   private String txtYear;
   private long lSiteId;
   private long lUserId;
   private String txtLocationDesc;
   private String holidayId;
   private String txtYearAndLocation;
   private String txtLocationCode;

   public HolidayMaster_MasterPaneVO()
   {
   }

   public String getTxtLocation()
   {
      return txtLocation;
   }

   public void setTxtLocation(String newTxtLocation)
   {
      txtLocation = newTxtLocation;
   }

   public String getTxtWeeklyOff1()
   {
      return txtWeeklyOff1;
   }

   public void setTxtWeeklyOff1(String newTxtWeeklyOff1)
   {
      txtWeeklyOff1 = newTxtWeeklyOff1;
   }

   public String getTxtWeeklyOff2()
   {
      return txtWeeklyOff2;
   }

   public void setTxtWeeklyOff2(String newTxtWeeklyOff2)
   {
      txtWeeklyOff2 = newTxtWeeklyOff2;
   }

   public String getTxtYear()
   {
      return txtYear;
   }

   public void setTxtYear(String newTxtYear)
   {
      txtYear = newTxtYear;
   }

   public long getLSiteId()
   {
      return lSiteId;
   }

   public void setLSiteId(long newLSiteId)
   {
      lSiteId = newLSiteId;
   }

   public long getLUserId()
   {
      return lUserId;
   }

   public void setLUserId(long newLUserId)
   {
      lUserId = newLUserId;
   }

   public String getTxtLocationDesc()
   {
      return txtLocationDesc;
   }

   public void setTxtLocationDesc(String newTxtLocationDesc)
   {
      txtLocationDesc = newTxtLocationDesc;
   }

   public String getHolidayId()
   {
      return holidayId;
   }

   public void setHolidayId(String newHolidayId)
   {
      holidayId = newHolidayId;
   }

   public String getTxtYearAndLocation()
   {
      return txtYearAndLocation;
   }

   public void setTxtYearAndLocation(String newTxtYearAndLocation)
   {
      txtYearAndLocation = newTxtYearAndLocation;
   }

   public String getTxtLocationCode()
   {
      return txtLocationCode;
   }

   public void setTxtLocationCode(String newTxtLocationCode)
   {
      txtLocationCode = newTxtLocationCode;
   }
}