package FCIPAY.HRMS.DATAACCESSTIER.VO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Module:        HolidayMasterVO.java
 * Author:        Prem K. Barai
 * Date Written:  02/06/2004
 * Description:   Value Object for the Detail Pane of the Holiday Master
 * Revision Log  (mm/dd/yy initials description)
 * --------------------------------------------------------
 * mm/dd/yy xxx  What you changed
 */


import java.util.ArrayList;

public class HolidayMasterVO 
{
   private String holiday_Name;
   private String holiday_Date;
   private long lSiteId;
   private long lUserId;
   private String sholidayDetailId;
   private String sholidayMasterId;
   private boolean chkDeleteRow;
   private String scheck;

   public HolidayMasterVO()
   {
   }

   public String getHoliday_Name()
   {
      return holiday_Name;
   }

   public void setHoliday_Name(String newHoliday_Name)
   {
      holiday_Name = newHoliday_Name;
   }

   public String getHoliday_Date()
   {
      return holiday_Date;
   }

   public void setHoliday_Date(String newHoliday_Date)
   {
      holiday_Date = newHoliday_Date;
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

   public String getSholidayDetailId()
   {
      return sholidayDetailId;
   }

   public void setSholidayDetailId(String newSholidayDetailId)
   {
      sholidayDetailId = newSholidayDetailId;
   }

   public String getSholidayMasterId()
   {
      return sholidayMasterId;
   }

   public void setSholidayMasterId(String newSholidayMasterId)
   {
      sholidayMasterId = newSholidayMasterId;
   }

   public boolean isChkDeleteRow()
   {
      return chkDeleteRow;
   }

   public void setChkDeleteRow(boolean newChkDeleteRow)
   {
      chkDeleteRow = newChkDeleteRow;
   }

   public String getScheck()
   {
      return scheck;
   }

   public void setScheck(String newScheck)
   {
      scheck = newScheck;
   }
}