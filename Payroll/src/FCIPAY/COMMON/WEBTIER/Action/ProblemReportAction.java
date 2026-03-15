
/*
 * Program Name : ProblemReportAction.java
 * Author       : Jegan.V
 * Date Written : 24/05/2004
 * Description  : This is the Action Class which does the action performed on the jsp page.
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

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ProblemReportVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.ProblemReportDAO;
import FCIPAY.COMMON.WEBTIER.Form.ProblemReportForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;


public class ProblemReportAction extends Action 
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        ActionErrors errors=new ActionErrors();
        ProblemReportForm oProblemReportForm=(ProblemReportForm)form;
        ProblemReportVO oProblemReportVO=new ProblemReportVO();
        ProblemReportDAO oProblemReportDAO= new ProblemReportDAO();

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

//===================For SAVE the Problem Report========================================

        if(oProblemReportForm.getHdnAction().equals("Save"))
        {
            try
            {
                oProblemReportVO.setTxtScreenName(oProblemReportForm.getTxtScreenName());
                oProblemReportVO.setTxtArProblemDesc(oProblemReportForm.getTxtArProblemDesc());
                oProblemReportVO.setTxtArCause(oProblemReportForm.getTxtArCause());
                oProblemReportVO.setUserEmpNo(obUserInfo.getLEmployeeNo());
                oProblemReportVO.setUserLoc(obUserInfo.getLLocationCode());
                
                if(oProblemReportDAO.saveDtls(oProblemReportVO))
                {
                    ResetForm(oProblemReportForm);
                    errors.clear();
                    errors.add("error",new ActionError("Common.ProblemReport.Success"));
                    saveErrors(request,errors);
                }
                else
                {
                    errors.clear();
                    errors.add("error",new ActionError("Common.DB.Administrator"));
                    saveErrors(request,errors);
                }
            }
            catch(Exception e)
            {
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }

//===================For RESET The form values===========================================

        else if(oProblemReportForm.getHdnAction().equals("Reset"))
        {
            errors.clear();
            ResetForm(oProblemReportForm);        
        }
        return mapping.findForward("success");
    }

   /**
     * This is the function for reseting the screen.
     * @param form for resetting the values
     */
    public void ResetForm(ProblemReportForm oProblemForm)
    {
        oProblemForm.setHdnAction("");
        oProblemForm.setTxtArCause("");
        oProblemForm.setTxtArProblemDesc("");
        oProblemForm.setTxtScreenName("");
    }
}