package FCIPAY.COMMON.WEBTIER.Action;
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
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import javax.servlet.http.HttpSession;
import FCIPAY.COMMON.WEBTIER.Form.ReportingOfficerScreenAccessForm;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.ReptOffChangeBD;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ReptOffChangeVO;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.ReportingOfficerScreenAccessBD;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.SA_ScreenEmpMapDAO;
import FCIPAY.COMMON.DATAACCESSTIER.VO.SA_ScreenEmpMapVO;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.ScreenPermitMasterBD;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ReportingOfficerScreenAccessVO;

public class ReportingOfficerScreenAccessAction extends Action 
{
    private ActionErrors errors =null;
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        errors = new ActionErrors();
        ReportingOfficerScreenAccessForm oForm=(ReportingOfficerScreenAccessForm) form;
        ReptOffChangeBD oBD1 = null;
        ReportingOfficerScreenAccessVO oVO1 = null;
        SA_ScreenEmpMapDAO osaDAO=new SA_ScreenEmpMapDAO();
        SA_ScreenEmpMapVO osaVO=new SA_ScreenEmpMapVO();
        ScreenPermitMasterBD oSPMBD=new ScreenPermitMasterBD();
        ReportingOfficerScreenAccessBD oBD=new ReportingOfficerScreenAccessBD();
        ReportingOfficerScreenAccessVO oVO=new ReportingOfficerScreenAccessVO();
         //===============For checking the userInfobean is expired or not================
        
        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;
        if(session!=null) 
        {
            //session.setAttribute("USERINFO",obUserInfo);
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("ErrorPage");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else 
            return mapping.findForward("ErrorPage"); 
            oForm.setLSiteID(obUserInfo.getLLocationCode());
            oForm.setLUserID(obUserInfo.getLEmployeeNo());
//------------------------------------------------------------------------------

        if("Load".equals(oForm.getSAction()))
           {          
            
                oForm.setHdnValue("txtExisEmployeeNo");
                
                /*osaVO=osaDAO.getOnLoadDtls(obUserInfo.getLLocationCode());
                oForm.setModuleList(osaVO.getModuleList());*/
            
           }
        
        if("chk1".equals(oForm.getSAction()))
        {
            oVO1=new ReportingOfficerScreenAccessVO();
            oBD1=new ReptOffChangeBD();
            try
            {
                oVO.setLSiteID(oForm.getLSiteID());
                oVO.setTxtExisEmployeeNo(oForm.getTxtExisEmployeeNo());
                //oVO.setHdnFlag("A");
                oForm.setLocList(oBD.getEmpName(oVO));
                if(oForm.getTxtExisEmployeeName() == null)
                {
                    oForm.setHdnValue("txtExisEmployeeNo");
                    errors.clear();
                    errors.add("Employee does not exist", new ActionError("HRMS.Emp.Exists"));
                    saveErrors(request, errors);
                }
                else
                {
                    /*if(oVO1.getHdnCount()==0)
                    {
                        oForm.setHdnValue("txtExisEmployeeNo");
                        oForm.setSAction("Fail");
                        errors.clear();
                        errors.add("error", new ActionError("HRMS.ReptOfficer.Failure"));
                        saveErrors(request, errors);
                    }
                    else*/
                    {
                        oForm.setHdnValue("txtReptEmployeeNo");
                        oForm.setSAction("a");
                    }
                }
            }
            catch(IBAFatalException ibafe)
            {
                ExceptionHandling(ibafe.getErrorKey(),request);
                ibafe.printStackTrace();
            }
            catch(Exception e)
            {
                ExceptionHandling("HRMS.DBError.General",request);
                e.printStackTrace();
            }
        }

        if("chk".equals(oForm.getSAction()))
        {
            oVO1=new ReportingOfficerScreenAccessVO();
            oBD1=new ReptOffChangeBD();
            try
            {
                oVO1.setLSiteID(oForm.getLSiteID());
                oVO1.setTxtExisEmployeeNo(oForm.getTxtReptEmployeeNo());
                oForm.setNewLocList(oBD.getEmpName(oVO1));
                if(oForm.getTxtReptEmployeeName() == null)
                {
                    oForm.setHdnValue("txtReptEmployeeNo");
                    errors.clear();
                    errors.add("Employee does not exist", new ActionError("HRMS.Emp.Exists"));
                    saveErrors(request, errors);
                }
                else
                {
                    oForm.setSAction("GetLevels");
                    oForm.setHdnValue("");
                }
            }
            catch(Exception e)
            {
                ExceptionHandling("HRMS.DBError.General",request);
                e.printStackTrace();
            }
        }

        if(oForm.getSAction().equals("Display"))
        {
             ArrayList headList=new ArrayList();
            //oSPMForm.getAssignedList().clear();
            oForm.getMenuList().clear();
            try 
            {
                headList=osaDAO.getHeaderDtls(oForm.getLstModule());
                oForm.setHeaderList(headList);
                //osaMapForm.setHdnFocus("lstHeader");
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
            saveErrors(request,errors);
            return mapping.findForward("success"); 

        }
      
       if((oForm.getSAction().equals("GetLevels")))
       {
            ArrayList levelList=new ArrayList();
            try 
            {
               String sQuery= " SELECT T1.SCREENACCESS_ID, T1.LEVEL1, T1.LEVEL2, T1.LEVEL3 "
                                  +" FROM SYSADMIN_SCREENACCESS_MST T1 "
                                  +"WHERE T1.SCREENACCESS_ID IN "
                                +"(SELECT T.SCREEN_ID FROM SYSADMIN_EMP_SCREEN_MAP T "
                                +"WHERE T.EMP_NO=? AND T.LOC_ID=? AND T1.module_name in('M$PAYROLL','M$SA','M$DEP','M$DPS','M$CPF','M$KOT','M$NWNP')"
                                 +"minus "
                                +"(SELECT K.SCREEN_ID FROM SYSADMIN_EMP_SCREEN_MAP K "
                                +"WHERE K.EMP_NO=? AND K.LOC_ID=?)) "
                                +"ORDER BY LEVEL1, LEVEL2, LEVEL3 ";

                levelList=oBD.getLevels(sQuery,oForm.getTxtExisEmployeeNo(),oForm.getTxtReptEmployeeNo(),oForm.getLSiteID(),oForm.getNewLSiteID());                                
                if(levelList.size()>0)
                {
                    oForm.setMenuList(levelList);
                    oForm.setDescTable("1");
                }
                else
                {
                    errors.clear();
                    errors.add("error",new ActionError("HRMS.ReptOfficer.ScreenFAILURE"));
                    saveErrors(request,errors);
                    oForm.getMenuList().clear();
                }
                //oSPMForm.setAssignedList(osaVO.getAssignedList());
                //oSPMForm.setHdnDelCnt(osaVO.getAssignedList().size());
            }
            catch(IBAFatalException e) 
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.Database.Error"));
                saveErrors(request,errors);
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }

        if("Save".equals(oForm.getSAction()))
        {
            ArrayList tmpList=new ArrayList();
            try
            {
                for(int i=0; i<oForm.getMenuList().size();i++)
                {
                    //checking for records (rows) which are not Checked
                    if(!("Checked".equals(oForm.getHdnCheck()[i])))
                    {
                        //adding into the arraylist
                        tmpList.add(oForm.getMenuList().get(i));
                    }
                    if("Checked".equals(oForm.getHdnCheck()[i]))
                    {
                        //adding into the arraylist
                        oForm.getHeaderList().add(oForm.getMenuList().get(i));
                    }
                }
                oVO.setHeaderList(oForm.getHeaderList());
                oVO.setTxtExisEmployeeNo(oForm.getTxtExisEmployeeNo());
                oVO.setTxtReptEmployeeNo(oForm.getTxtReptEmployeeNo());
                oVO.setTxtExisEmployeeName(oForm.getTxtExisEmployeeName());
                oVO.setTxtReptEmployeeName(oForm.getTxtReptEmployeeName());
                oVO.setMenuList(oForm.getMenuList());
                oVO.setLSiteID(oForm.getLSiteID());
                oVO.setLUserID(oForm.getLUserID());
                if(oBD.updateList(oVO))
                {
                    errors.clear();
                    errors.add("error",new ActionError("HRMS.TRAININGMASTER.SUCCESS"));
                    saveErrors(request,errors);
                    oForm.setSAction("Fail");
                }
            }
            catch(IBAFatalException e) 
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.Database.Error"));
                saveErrors(request,errors);
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }

        if("Reset".equals(oForm.getSAction()))
        {
            funcReset(oForm);
        }
        
        return mapping.findForward("success");
    }
    //---------Function to handle Exception and save Error messages-----------------
     /**
    * Method       Handles Exception and Adds to the Error
    * @param1=Message which contains error key
    * @param2=request which is httpservelet request     
    */
    private void ExceptionHandling(String Message,HttpServletRequest request) 
    {
        errors.clear();
        errors.add("error",new ActionError(Message));
        saveErrors(request,errors);
    }

    public void funcReset(ReportingOfficerScreenAccessForm oForm)
    {
        oForm.setSAction("");
        oForm.setHdnValue("");
        oForm.setTxtExisEmployeeName("");
        oForm.setTxtExisEmployeeNo("");
        oForm.setTxtReptEmployeeName("");
        oForm.setTxtReptEmployeeNo("");
        oForm.setMenuList(new ArrayList());
        oForm.setHeaderList(new ArrayList());
        oForm.setDescTable("0");
        oForm.setHdnCount("0");
    }
}