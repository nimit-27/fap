/*
 * Module:        HolidayMasterAction.java
 * Author:        Prem K. Barai
 * Date Written:  02/06/2004
 * Description:   Action Class for Holiday Master
 * Revision Log  (mm/dd/yy initials description)
 * --------------------------------------------------------
 * mm/dd/yy xxx  What you changed
 */




package FCIPAY.HRMS.WEBTIER.Action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import FCIPAY.HRMS.WEBTIER.Form.HolidayMasterForm;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.VenueMastBD;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.HolidayMasterBD;
import FCIPAY.HRMS.DATAACCESSTIER.VO.HolidayMasterVO;
import FCIPAY.HRMS.DATAACCESSTIER.VO.HolidayMaster_MasterPaneVO;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.COMMON.UTILITY.MsgLogger;


public class HolidayMasterAction extends Action 
{
   /**
    * This is the main action called from the Struts framework.
    * @param mapping The ActionMapping used to select this instance.
    * @param form The optional ActionForm bean for this request.
    * @param request The HTTP Request we are processing.
    * @param response The HTTP Response we are processing.
    */
    private ActionErrors oclActionErrors=new ActionErrors();
    private HttpServletRequest orequest=null;
    
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
      HttpSession session = request.getSession(false);
      UserInfoBean oUserInfo = new UserInfoBean();
      MsgLogger oMsgLogger = (MsgLogger) MsgLogger.getLogger(this);
      try{
         if(session!=null) 
         {
            if(session.getAttribute("USERINFO") == null)
               return mapping.findForward("ErrorPage");
            else
               oUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
         }
         else 
            return mapping.findForward("ErrorPage");
      }catch(NullPointerException ne){
         ne.printStackTrace();
         oMsgLogger.logERROR(ne.getMessage());
         oclActionErrors.clear();
         oclActionErrors.add("General",new ActionError("HRMS.DB.Administrator"));
      }catch(Exception e){
         oMsgLogger.logERROR(e.getMessage());
         e.printStackTrace();
         oclActionErrors.clear();
         oclActionErrors.add("General",new ActionError("HRMS.DB.Administrator"));
      }       

      HolidayMasterForm oForm = (HolidayMasterForm) form;
      VenueMastBD oVenueMstBD = null;   
      ArrayList oTempList = null;
      ArrayList oTemporaryList = null;
      ArrayList oHolidayMasterVOs = null;
      String[] oholiday_Name=oForm.getHoliday_Name();
      String[] oholiday_Date=oForm.getHoliday_Date();
      String[] oscheck = oForm.getScheck();
      try {
         if(oForm.getSaction().equals("PreLoad_Check"))
         {
            HolidayMasterBD oHolidayMasterBD = new HolidayMasterBD();
            oTemporaryList = oHolidayMasterBD.getHolidayDetails(0, "HOLCODES"); // Getting the Holiday Names from the database.
            oForm.setLstHolidayName(oTemporaryList);                              
            oTempList = oHolidayMasterBD.getUnitDetails();
            oForm.setUnitList(oTempList);
            oForm.setSload("Loaded");
         }
         if(oForm.getSaction().equals("Reset"))
         {
            oForm.reset(mapping, request); // Calling the reset function to reset the form.
            oForm.getTxtYearAndLocation().clear();
            oForm.getLstDetailPane().clear(); 
            oForm.setIrecordCount(0); // Setting the irecordCount to zero to load the logic match section of the Holiday Name and the Holiday Date fields on the form.
            oForm.setSmode("");
            oForm.setSload("");   // Clearing sload for the reinitialization of the form and get the fresh data from the database.         
         }
         if(oForm.getSaction().equals("Query"))
         {
            HolidayMasterBD oHolidayMasterBD = new HolidayMasterBD();
            oHolidayMasterVOs = new ArrayList();
            oHolidayMasterBD.setYearAndLocation(oHolidayMasterVOs);
            oForm.setTxtYearAndLocation(oHolidayMasterVOs);
            if(oHolidayMasterVOs.size() == 0)
            {
              oclActionErrors.clear();
              oclActionErrors.add("No Records", new ActionError("HRMS.HOLIDAYQUERY.ZERO"));
              saveErrors(request,oclActionErrors);
            }
            oForm.getLstDetailPane().clear();  // Clearing the ArrayList, for the page to get loaded without any Holiday Details that would have resulted from the previous data fetch.
            oForm.reset(mapping, request);
            oForm.setIrecordCount(1); // Setting the irecordCount to one to skip the logic match section of the Holiday Name and the Holiday Date fields on the form from loading.
            oForm.setQueryFlag(true);
            oForm.setSmode("getRecord"); // Setting the smode to "getRecord"
         }
         if(oForm.getSaction().equals("addZerothRow"))
         {
            oForm.setIrecordCount(0);   // Setting the irecordCount to zero to load the logic match section of the Holiday Name
                                        // and the Holiday Date fields on the form, if there are no Details Pane record for a query
                                        // in the Query mode and Add Row button is clicked to add a row.
            oForm.setIaddRowLen(1);
            oForm.setSaction("Query");  // Setting the saction back to the Query mode.
         }
         if(oForm.getSaction().equals("getRecord"))
         {
            HolidayMaster_MasterPaneVO oHolidayMaster_MasterPaneVO = new HolidayMaster_MasterPaneVO();
            HolidayMasterVO oHolidayMasterVO = new HolidayMasterVO();
            HolidayMasterBD oHolidayMasterBD = new HolidayMasterBD();
            oHolidayMasterVOs = new ArrayList();
            ArrayList tempArrayList = new ArrayList();
            oForm.setIrecordCount(1);   // Setting the irecordCount to one to skip the logic match section of the Holiday Name and the Holiday Date fields on the form from loading.

            if(!(oForm.getLstYear().equals("")))
            {
                for(int i=0; i<oForm.getTxtYearAndLocation().size(); i++)
                {
                   oHolidayMaster_MasterPaneVO = (HolidayMaster_MasterPaneVO) oForm.getTxtYearAndLocation().get(i);
                   if(oHolidayMaster_MasterPaneVO.getHolidayId().equals(oForm.getLstYear()))
                   {
                      oForm.setWeekly_Off_1(oHolidayMaster_MasterPaneVO.getTxtWeeklyOff1());
                      oForm.setWeekly_Off_2(oHolidayMaster_MasterPaneVO.getTxtWeeklyOff2());
                      oForm.setLstUnitName(oHolidayMaster_MasterPaneVO.getTxtLocationCode());
                   }
                }
            
                oHolidayMasterVOs = oHolidayMasterBD.getRecord();
                for(int i=0; i< oHolidayMasterVOs.size(); i++)
                {
                   oHolidayMasterVO = (HolidayMasterVO) oHolidayMasterVOs.get(i);
                   if(oHolidayMasterVO.getSholidayMasterId().equals(oForm.getLstYear()) && oHolidayMasterVO.getScheck().equals("A"))
                      tempArrayList.add(oHolidayMasterVO);
                }
                oForm.setLstDetailPane(tempArrayList);
                oForm.setSaction("Query");   // Setting the saction back to the Query mode.
            
                if(oForm.getLstDetailPane().size() == 0)
                {
                  oclActionErrors.clear();
                  oclActionErrors.add("Zero Records", new ActionError("HRMS.HOLIDAYGETRECORD.ZERO"));
                  saveErrors(request,oclActionErrors);
                }
            }
            else
            {
                oForm.setLstUnitName("");
                oForm.setWeekly_Off_1("");
                oForm.setWeekly_Off_2("");
                oForm.getLstDetailPane().clear();  // Clearing the ArrayList, for the page to get loaded without any Holiday Details that would have resulted from the previous data fetch.
                oForm.setSaction("Query");       // Setting the saction back to the Query mode.            
            }
         }
         if(oForm.getSaction().equals("Edit"))
         {
            char flag = 'e';
            HolidayMasterBD oHolidayMasterBD = new HolidayMasterBD();
            HolidayMaster_MasterPaneVO oHolidayMaster_MasterPaneVO = new HolidayMaster_MasterPaneVO();
            oHolidayMasterVOs = new ArrayList();

            oHolidayMaster_MasterPaneVO.setTxtLocation(oForm.getLstUnitName());
            oHolidayMaster_MasterPaneVO.setTxtWeeklyOff1(oForm.getWeekly_Off_1());
            oHolidayMaster_MasterPaneVO.setTxtWeeklyOff2(oForm.getWeekly_Off_2());
            oHolidayMaster_MasterPaneVO.setHolidayId(oForm.getLstYear());
            oHolidayMaster_MasterPaneVO.setLSiteId(oUserInfo.getLLocationCode());
            oHolidayMaster_MasterPaneVO.setLUserId(oUserInfo.getLEmployeeNo());

            for(int i=0 ;i < oForm.getLstDetailPane().size() ;i++ )    // Loop to save the changes made, into the database.
            {
               HolidayMasterVO oHolidayMasterVO = new HolidayMasterVO();
               HolidayMasterVO tempList = (HolidayMasterVO) oForm.getLstDetailPane().get(i);
               oHolidayMasterVO.setHoliday_Name(oholiday_Name[i]);
               oHolidayMasterVO.setHoliday_Date(oholiday_Date[i]);
               oHolidayMasterVO.setScheck(oForm.getScheck()[i]);
               oHolidayMasterVO.setLSiteId(oUserInfo.getLLocationCode());
               oHolidayMasterVO.setLUserId(oUserInfo.getLEmployeeNo());
               oHolidayMasterVO.setSholidayDetailId(tempList.getSholidayDetailId());
               oHolidayMasterVO.setSholidayMasterId(tempList.getSholidayMasterId());
               oHolidayMasterVOs.add(oHolidayMasterVO);
            }
            oForm.setLstDetailPane(oHolidayMasterVOs);
            oForm.setSaction("Query");  // Setting the saction back to the Query mode.
            oForm.setQueryFlag(true);   // Setting the queryFlag to true.
            
            if(oHolidayMasterBD.setMasterPaneAndDetailPane(flag, oHolidayMaster_MasterPaneVO, oHolidayMasterVOs))
            {
              oclActionErrors.clear();
              oclActionErrors.add("Edit Success", new ActionError("HRMS.HOLIDAYEDIT.SUCCESS"));
              saveErrors(request,oclActionErrors);
            }
            else
            {
              oclActionErrors.clear();
              oclActionErrors.add("Edit Failure", new ActionError("HRMS.HOLIDAYEDIT.FAILURE"));
              saveErrors(request,oclActionErrors);
            }
            
            if(oholiday_Name.length > oForm.getLstDetailPane().size())   // To save the newly added Detail Pane into the database.
            {
              flag = 'u';
              oHolidayMasterVOs = new ArrayList();

              for(int i = oForm.getLstDetailPane().size(); i < oholiday_Name.length; i++)
              {
                if(oForm.getScheck()[i].equals("A"))
                {
                  HolidayMasterVO oHolidayMasterVO = new HolidayMasterVO();
                  oHolidayMasterVO.setHoliday_Name(oholiday_Name[i]);
                  oHolidayMasterVO.setHoliday_Date(oholiday_Date[i]);
                  oHolidayMasterVO.setScheck(oForm.getScheck()[i]);
                  oHolidayMasterVO.setLSiteId(oUserInfo.getLLocationCode());
                  oHolidayMasterVO.setLUserId(oUserInfo.getLEmployeeNo());
                  oHolidayMasterVO.setSholidayMasterId(oForm.getLstYear());
                  oHolidayMasterVOs.add(oHolidayMasterVO);
                  oForm.getLstDetailPane().add(oHolidayMasterVO);
                }
              }

              oForm.setIrecordCount(1);
              
              if(oHolidayMasterBD.setMasterPaneAndDetailPane(flag, oHolidayMaster_MasterPaneVO, oHolidayMasterVOs))
              {
                oclActionErrors.clear();
                oclActionErrors.add("Edit Success", new ActionError("HRMS.HOLIDAYEDIT.SUCCESS"));
                saveErrors(request,oclActionErrors);
              }
              else
              {
                oclActionErrors.clear();
                oclActionErrors.add("Edit Failure", new ActionError("HRMS.HOLIDAYEDIT.FAILURE"));
                saveErrors(request,oclActionErrors);
              }
            }
         }
         if(oForm.getSaction().equals("Insert"))
         { 
            char flag = 'i';
            HolidayMasterBD oHolidayMasterBD = new HolidayMasterBD();
            HolidayMaster_MasterPaneVO oHolidayMaster_MasterPaneVO = new HolidayMaster_MasterPaneVO();
            oHolidayMasterVOs = new ArrayList();
            oHolidayMaster_MasterPaneVO.setTxtLocation(oForm.getLstUnitName());
            oHolidayMaster_MasterPaneVO.setTxtWeeklyOff1(oForm.getWeekly_Off_1());
            oHolidayMaster_MasterPaneVO.setTxtWeeklyOff2(oForm.getWeekly_Off_2());
            oHolidayMaster_MasterPaneVO.setTxtYear(oForm.getLstYear()); 
            oHolidayMaster_MasterPaneVO.setLSiteId(oUserInfo.getLLocationCode());
            oHolidayMaster_MasterPaneVO.setLUserId(oUserInfo.getLEmployeeNo());

            for (int i=0 ;i < oholiday_Name.length ;i++ ) 
            { 
              if(oscheck[i].equals("A"))
              {
                HolidayMasterVO oHolidayMasterVO = new HolidayMasterVO();
                oHolidayMasterVO.setHoliday_Name(oholiday_Name[i]);
                oHolidayMasterVO.setHoliday_Date(oholiday_Date[i]);
                oHolidayMasterVO.setLSiteId(oUserInfo.getLLocationCode());
                oHolidayMasterVO.setLUserId(oUserInfo.getLEmployeeNo());
                oHolidayMasterVO.setScheck(oscheck[i]);
                oHolidayMasterVOs.add(oHolidayMasterVO);
                oForm.getLstDetailPane().add(oHolidayMasterVO);
              }
            }

            oForm.setIrecordCount(1);

            if(oHolidayMasterBD.setMasterPaneAndDetailPane(flag, oHolidayMaster_MasterPaneVO, oHolidayMasterVOs))
            {
               oclActionErrors.clear();
               oclActionErrors.add("Insert Success", new ActionError("HRMS.HOLIDAYINSERT.SUCCESS"));
               saveErrors(request,oclActionErrors);
            }
            else
            {
              oclActionErrors.clear();
              oclActionErrors.add("Insert Failure", new ActionError("HRMS.HOLIDAYINSERT.FAILURE"));
              saveErrors(request,oclActionErrors);
            }
         }
      } catch(IBABusinessException ibae){
          if(ibae.getErrorKey().equalsIgnoreCase("HRMS.HOLIDAYDETAILS.NOTDEFINED")) 
          {
            oMsgLogger.logERROR("Holiday Names not defined");
            oclActionErrors.clear();
            oclActionErrors.add("No Holiday Names", new ActionError("HRMS.HOLIDAYDETAILS.NOTDEFINED"));
            saveErrors(request,oclActionErrors);
          }
      } catch(IBAFatalException ifae){
//            if((ifae.getiErrCode() == 1) && (ifae.getsMessage().substring(0, 9).equals("ORA-00001")))
//            if((ifae.getiErrCode() == 1) && (ifae.getsMessage().substring((ifae.getsMessage().lastIndexOf("_")+1), (ifae.getsMessage().lastIndexOf("_")+3)).equalsIgnoreCase("UK")))
            if((ifae.getiErrCode() == 1) && (ifae.getsMessage().lastIndexOf("UK") != -1))
            {
                oclActionErrors.clear();
                oclActionErrors.add("Insert Failure",new ActionError("HRMS.HolidayMaster.UniqueKeyConstraint"));
                saveErrors(request,oclActionErrors);
            }
            else
            {
                oclActionErrors.clear();
                oclActionErrors.add("Insert Failure",new ActionError(ifae.getErrorKey()));
                saveErrors(request,oclActionErrors);
            }
      } catch(IBAException ie){
          oclActionErrors.clear();
          oclActionErrors.add("Insert Failure",new ActionError(ie.getErrorKey()));
          saveErrors(request,oclActionErrors);
      } catch (Exception e){
          oMsgLogger.logERROR(e.getMessage());
          e.printStackTrace();
          oclActionErrors.clear();
          oclActionErrors.add("General Exception",new ActionError("HRMS.DBError.General"));
          saveErrors(request,oclActionErrors);           
      }
      return mapping.findForward("success");
   }
}