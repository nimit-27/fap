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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

import FCIPAY.COMMON.WEBTIER.Form.EmplGrpRoleAssignForm;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.EmplGrpRoleAssignBD;
import FCIPAY.COMMON.DATAACCESSTIER.VO.EmplGrpRoleAssignVO;

import java.lang.reflect.InvocationTargetException;
import java.lang.IllegalAccessException;
import org.apache.commons.beanutils.BeanUtils;

public class EmplGrpRoleAssignAction extends Action  {

    private ActionErrors errors=new ActionErrors();
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        EmplGrpRoleAssignForm oEmplGrpRoleAssignForm=(EmplGrpRoleAssignForm)form;

/*      Checking if session is active and getting the userinfo bean from session and from that getting 
        the user id and loc id */
        
        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;
         
        if(session!=null) {
            if(session.getAttribute("USERINFO") == null)
               return mapping.findForward("ErrorPage");
            else
               obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else 
            return mapping.findForward("ErrorPage");
         
        long locId=obUserInfo.getLLocationCode();
        long empId=obUserInfo.getLEmployeeNo();
        
        if(oEmplGrpRoleAssignForm.getTxtHidAction().equals("quitUser")) {
            if(session!=null)
                session.invalidate();
        }
        else if(oEmplGrpRoleAssignForm.getTxtHidAction().equals("Reset")) {
            oEmplGrpRoleAssignForm.reSet();
            return mapping.findForward("SamePage");
        }
        else if("getEmpUserLocIdDetails".equals(oEmplGrpRoleAssignForm.getTxtHidAction())) {
            EmplGrpRoleAssignBD oEmplGrpRoleAssignBD=new EmplGrpRoleAssignBD();
            try {
                oEmplGrpRoleAssignForm.getLstGroupRows().clear();
                oEmplGrpRoleAssignForm.getLstModules().clear();
                oEmplGrpRoleAssignForm.getLstRoleRows().clear();
                oEmplGrpRoleAssignForm.getLstRoles().clear();
                ArrayList lstReturn=oEmplGrpRoleAssignBD.getEmpUserLocIdDetailsBD(Long.parseLong(oEmplGrpRoleAssignForm.getTxtEmplNo()),locId);
                oEmplGrpRoleAssignForm.setTxtEmplName((String)lstReturn.get(0));
                oEmplGrpRoleAssignForm.setTxtHidUserLocId(String.valueOf(((Long)lstReturn.get(1)).longValue()));
                oEmplGrpRoleAssignForm.setLstModules((ArrayList)lstReturn.get(2));
                oEmplGrpRoleAssignForm.setLstRoles((ArrayList)lstReturn.get(3));
            }
            catch(IBABusinessException ibaBus) 
             {
                ExceptionHandling(ibaBus.getErrorKey(),request);
                oEmplGrpRoleAssignForm.setTxtHidDisableButtons("NoEmpFound");
                return mapping.findForward("SamePage");
             }
             catch(IBAFatalException ibaFat) 
             {
                ExceptionHandling(ibaFat.getErrorKey(),request);
                oEmplGrpRoleAssignForm.setTxtHidDisableButtons("NoEmpFound");
                return mapping.findForward("SamePage");
             }
             catch(Exception exp) 
             {
                ExceptionHandling("Finance.UnKnown.Administrator",request);
                oEmplGrpRoleAssignForm.setTxtHidDisableButtons("NoEmpFound");
                return mapping.findForward("SamePage");
             }
             oEmplGrpRoleAssignForm.setTxtHidAction("");
             oEmplGrpRoleAssignForm.setTxtHidDisableButtons("");
             return mapping.findForward("SamePage");
        }
/*        else if("getEmplGroupDetails".equals(oEmplGrpRoleAssignForm.getTxtHidAction())) {
            EmplGrpRoleAssignBD oEmplGrpRoleAssignBD=new EmplGrpRoleAssignBD();
            try {
                ArrayList lstReturn=oEmplGrpRoleAssignBD.getEmpGroupDetailsBD(Long.parseLong(oEmplGrpRoleAssignForm.getTxtEmplNo()),locId,oEmplGrpRoleAssignForm.getTxtModule());
                oEmplGrpRoleAssignForm.setLstGroupRows(lstReturn);
                oEmplGrpRoleAssignForm.setTxtHidTotRowsGroups(String.valueOf(lstReturn.size()));
            }
            catch(IBABusinessException ibaBus) 
             {
                ExceptionHandling(ibaBus.getErrorKey(),request);
             }
             catch(IBAFatalException ibaFat) 
             {
                ExceptionHandling(ibaFat.getErrorKey(),request);
             }
             catch(Exception exp) 
             {
                ExceptionHandling("Finance.UnKnown.Administrator",request);
             }
             oEmplGrpRoleAssignForm.setTxtHidAction("");
             return mapping.findForward("SamePage");
        }*/
        else if("getEmpRoleRowDetails".equals(oEmplGrpRoleAssignForm.getTxtHidAction())) {
            EmplGrpRoleAssignBD oEmplGrpRoleAssignBD=new EmplGrpRoleAssignBD();
            try {
                ArrayList lstReturn=oEmplGrpRoleAssignBD.getEmpGroupDetailsBD(Long.parseLong(oEmplGrpRoleAssignForm.getTxtEmplNo()),locId,oEmplGrpRoleAssignForm.getTxtModule());
                oEmplGrpRoleAssignForm.setLstGroupRows(lstReturn);
                oEmplGrpRoleAssignForm.setTxtHidTotRowsGroups(String.valueOf(lstReturn.size()));
                ArrayList lstReturn1=oEmplGrpRoleAssignBD.getEmpRoleRowDetailsBD(Long.parseLong(oEmplGrpRoleAssignForm.getTxtHidUserLocId()),oEmplGrpRoleAssignForm.getTxtRole(),oEmplGrpRoleAssignForm.getTxtModule());
                oEmplGrpRoleAssignForm.setLstRoleRows(lstReturn1);
                oEmplGrpRoleAssignForm.setIsGroupChecked("");
                oEmplGrpRoleAssignForm.setIsRoleChecked("");
                oEmplGrpRoleAssignForm.setTxtHidTotRowsRole(String.valueOf(lstReturn1.size()));
            }
             catch(IBABusinessException ibaBus) 
             {
                ExceptionHandling(ibaBus.getErrorKey(),request);
             }
             catch(IBAFatalException ibaFat) 
             {
                ExceptionHandling(ibaFat.getErrorKey(),request);
             }
             catch(Exception exp) 
             {
                ExceptionHandling("Finance.UnKnown.Administrator",request);
             }
             oEmplGrpRoleAssignForm.setTxtHidAction("");
             return mapping.findForward("SamePage");
        }
        else if("Save".equals(oEmplGrpRoleAssignForm.getTxtHidAction())) {
            EmplGrpRoleAssignBD oEmplGrpRoleAssignBD=new EmplGrpRoleAssignBD();
            EmplGrpRoleAssignVO oEmplGrpRoleAssignVO=new EmplGrpRoleAssignVO();
            oEmplGrpRoleAssignForm.setTxtUserId(String.valueOf(empId));
            oEmplGrpRoleAssignForm.setTxtLocId(String.valueOf(locId));
            try {
                BeanUtils bUtils=new BeanUtils();
                bUtils.copyProperties(oEmplGrpRoleAssignVO,oEmplGrpRoleAssignForm);
                oEmplGrpRoleAssignBD.SaveBD(oEmplGrpRoleAssignVO);
                oEmplGrpRoleAssignForm.reSet();
                throw new IBABusinessException("Finance.Insert.Success");
            }
            catch(InvocationTargetException e) {
                ExceptionHandling("Finance.UnKnown.Administrator",request);
            }
            catch(IllegalAccessException e) {
                ExceptionHandling("Finance.UnKnown.Administrator",request);
            }
            catch(IBABusinessException ibaBus) 
            {
               ExceptionHandling(ibaBus.getErrorKey(),request);
            }
            catch(IBAFatalException ibaFat) 
            {
               ExceptionHandling(ibaFat.getErrorKey(),request);
            }
            catch(Exception exp) 
            {
              ExceptionHandling("Finance.UnKnown.Administrator",request);
            }
            oEmplGrpRoleAssignForm.setTxtHidAction("");
            return mapping.findForward("SamePage");
        }
        
        return mapping.findForward("SamePage");
    }
    
    private void ExceptionHandling(String Message,HttpServletRequest request) { 
       errors.clear();
       errors.add("error",new ActionError(Message));
       saveErrors(request,errors);
    }
}