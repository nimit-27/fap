/*
 * Program Name : ResetPwdAction.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Action Class for the Reset password screen
 *
*/

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

import FCIPAY.COMMON.WEBTIER.Form.ResetPwdForm;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ResetPwdVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.ResetPwdDAO;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class ResetPwdAction extends Action  {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        ResetPwdForm oResetPwdForm = (ResetPwdForm)form;
        ResetPwdVO oResetPwdVO=new ResetPwdVO();
        ActionErrors errors=new ActionErrors();

//===================For checking the userInfobean is expired or not===================

        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;// = new UserInfoBean();
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

//===================For getting the Employee Details====================================

        if(oResetPwdForm.getHdnAction().equals("GetEmpDtls")) 
        {
            ResetPwdDAO oResetPwdDAO=new ResetPwdDAO();
            try
            {
                oResetPwdVO=oResetPwdDAO.getEmpDetails(oResetPwdForm.getTxtEmpNo());
                oResetPwdForm.setHdnEmpName(oResetPwdVO.getHdnEmpName());
                oResetPwdForm.setHdnEmpDesig(oResetPwdVO.getHdnEmpDesig());
                oResetPwdForm.setHdnEmpDept(oResetPwdVO.getHdnEmpDept());
                oResetPwdForm.setHdnEmpDtls(oResetPwdVO.getHdnEmpDtls());
                if(oResetPwdVO.getHdnEmpDtls()==0)
                {
                    errors.clear();
                    errors.add("error",new ActionError("Common.Invalid.Employee"));
                    saveErrors(request,errors);  
                }
            }
            catch(Exception e) 
            {
                errors.clear();
                errors.add("error",new ActionError("Common.Database.Error"));
                saveErrors(request,errors);
                e.printStackTrace();    
            }
        }

//===================For Reseting the Password of the Employee====================================

        if(oResetPwdForm.getHdnAction().equals("ResetPwd")) 
        {
            ResetPwdDAO oResetPwdDAO=new ResetPwdDAO();
            try
            {
                if(oResetPwdDAO.resetPwd(oResetPwdForm.getTxtEmpNo())) 
                {
                    System.out.println("Inserted Successfully");
                    errors.clear();
                    errors.add("error",new ActionError("Common.ResetPwd.Success"));
                    saveErrors(request,errors);
                }
            }
            catch(Exception e) 
            {
                errors.clear();
                errors.add("error",new ActionError("Common.Database.Error"));
                saveErrors(request,errors);
                e.printStackTrace();    
            }
        }

//==============================For Cancel====================================

        if(oResetPwdForm.getHdnAction().equals("Cancel")) 
        {
            oResetPwdForm.setHdnAction("");
            oResetPwdForm.setHdnEmpDept("");
            oResetPwdForm.setHdnEmpDesig("");
            oResetPwdForm.setHdnEmpDtls(0);
            oResetPwdForm.setHdnEmpName("");
            oResetPwdForm.setTxtEmpNo(0);
        }
        return mapping.findForward("success");
    }
}