/*
 * Module:        HolidayMasterForm.java
 * Author:        Prem K. Barai
 * Date Written:  02/06/2004
 * Description:   Action Form for Holiday Master
 * Revision Log  (mm/dd/yy initials description)
 * --------------------------------------------------------
 * mm/dd/yy xxx  What you changed
 */


package FCIPAY.HRMS.WEBTIER.Form;

import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class HolidayMasterForm extends PayrollBaseForm 
{
   private String Weekly_Off_1 = null;
   private String Weekly_Off_2 = null;
   private String lstYear = null;
   private String[] holiday_Name = null;
   private String[] holiday_Date = null;
   private String[] holiday_type = null;
   private ArrayList unitList= new ArrayList(1);
   private String lstUnitName = null;
   private String sload = null;
   private String saction = null;
   private String tempYear = null;
   private ArrayList txtYearAndLocation = new ArrayList(1);
   private String smode = null;
   private ArrayList lstHolidayName= new ArrayList(1);
   private ArrayList lstDetailPane = new ArrayList(1);
   private int irecordCount;
   private boolean[] chkDeleteRow = null;
   private boolean queryFlag;
   private String[] scheck = null;
    private int iaddRowLen = 0;

   /**
    * Reset all properties to their default values.
    * @param mapping The ActionMapping used to select this instance.
    * @param request The HTTP Request we are processing.
    */
   public void reset(ActionMapping mapping, HttpServletRequest request)
   {
      this.holiday_Name = null;
      this.lstUnitName = null;
      this.Weekly_Off_1 = null;
      this.Weekly_Off_2 = null;
      this.lstYear = null;
      super.reset(mapping, request);
   }

   /**
    * Validate all properties to their default values.
    * @param mapping The ActionMapping used to select this instance.
    * @param request The HTTP Request we are processing.
    * @return ActionErrors A list of all errors found.
    */
   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
   {
      return super.validate(mapping, request);
   }



   public String getWeekly_Off_1()
   {
      return Weekly_Off_1;
   }

   public void setWeekly_Off_1(String newWeekly_Off_1)
   {
      Weekly_Off_1 = newWeekly_Off_1;
   }

   public String getWeekly_Off_2()
   {
      return Weekly_Off_2;
   }

   public void setWeekly_Off_2(String newWeekly_Off_2)
   {
      Weekly_Off_2 = newWeekly_Off_2;
   }

   public String[] getHoliday_Name()
   {
      return holiday_Name;
   }

   public void setHoliday_Name(String[] newHoliday_Name)
   {
      holiday_Name = newHoliday_Name;
   }

   public String[] getHoliday_Date()
   {
      return holiday_Date;
   }

   public void setHoliday_Date(String[] newHoliday_Date)
   {
      holiday_Date = newHoliday_Date;
   }
   
   public String[] getHoliday_type()
   {
      return holiday_type;
   }

   public void setHoliday_type(String[] newHoliday_type)
   {
      holiday_type = newHoliday_type;
   }

   public ArrayList getUnitList()
   {
      return unitList;
   }

   public void setUnitList(ArrayList newUnitList)
   {
      unitList = newUnitList;
   }

   public String getSaction()
   {
      return saction;
   }

   public void setSaction(String newSaction)
   {
      saction = newSaction;
   }

   public String getSload()
   {
      return sload;
   }

   public void setSload(String newSload)
   {
      sload = newSload;
   }

   public String getTempYear()
   {
      return tempYear;
   }

   public void setTempYear(String newTempYear)
   {
      tempYear = newTempYear;
   }

   public String getLstYear()
   {
      return lstYear;
   }

   public void setLstYear(String newLstYear)
   {
      lstYear = newLstYear;
   }

   public String getLstUnitName()
   {
      return lstUnitName;
   }

   public void setLstUnitName(String newLstUnitName)
   {
      lstUnitName = newLstUnitName;
   }

   public ArrayList getTxtYearAndLocation()
   {
      return txtYearAndLocation;
   }

   public void setTxtYearAndLocation(ArrayList newTxtYearAndLocation)
   {
      txtYearAndLocation = newTxtYearAndLocation;
   }

   public String getSmode()
   {
      return smode;
   }

   public void setSmode(String newSmode)
   {
      smode = newSmode;
   }

   public ArrayList getLstHolidayName()
   {
      return lstHolidayName;
   }

   public void setLstHolidayName(ArrayList newLstHolidayName)
   {
      lstHolidayName = newLstHolidayName;
   }



   public ArrayList getLstDetailPane()
   {
      return lstDetailPane;
   }

   public void setLstDetailPane(ArrayList newLstDetailPane)
   {
      lstDetailPane = newLstDetailPane;
   }

   public int getIrecordCount()
   {
      return irecordCount;
   }

   public void setIrecordCount(int newIrecordCount)
   {
      irecordCount = newIrecordCount;
   }



   public boolean[] getChkDeleteRow()
   {
      return chkDeleteRow;
   }

   public void setChkDeleteRow(boolean[] newChkDeleteRow)
   {
      chkDeleteRow = newChkDeleteRow;
   }

   public boolean isQueryFlag()
   {
      return queryFlag;
   }

   public void setQueryFlag(boolean newQueryFlag)
   {
      queryFlag = newQueryFlag;
   }

   public String[] getScheck()
   {
      return scheck;
   }

   public void setScheck(String[] newScheck)
   {
      scheck = newScheck;
   }

    public int getIaddRowLen()
    {
        return iaddRowLen;
    }

    public void setIaddRowLen(int newIaddRowLen)
    {
        iaddRowLen = newIaddRowLen;
    }
}