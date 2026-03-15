/* 
 * Module:        RedirectAction.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Dec - 2003 
 * Description:   This Action Class is the gets the input from 
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import java.util.StringTokenizer;

public class RedirectAction extends Action  {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
     public RedirectAction() {
     }
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        //System.out.println("Inside Action Class");
        String strFormBean="";
        String strForward="";
        //Added by BAlpreet for parameterizationin the emp lbr screens
        String strEmpLbrFlag="";

        StringTokenizer strTok=new StringTokenizer(request.getParameter("action"),"|");

        strFormBean=strTok.nextToken();
        strForward=strTok.nextToken();
        if(strTok.hasMoreTokens())
          strEmpLbrFlag=strTok.nextToken();

        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;// = new UserInfoBean();

	if(session==null && strFormBean.equals("frmLogin") && strForward.equals("LoginPage"))
            return mapping.findForward("LoginPage");
        else if(session!=null && strFormBean.equals("frmLogin") && strForward.equals("LoginPage")) {
            session.invalidate();
            return mapping.findForward("LoginPage");
        }

        if(session!=null) 
        {
            //session.setAttribute("USERINFO",obUserInfo);
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("ErrorPage");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else 
        {
             System.out.println("FAILURE");
             return mapping.findForward("ErrorPage");
        }
        //Added by Balpreet for flagging screens for the modules
        session.setAttribute("hdnEmpLbrFlag",strEmpLbrFlag);
        // if it is for reports then this if condition will satisfy
        if((strForward.equals("HomePage")) ||(strForward.equals("HomePageEmp")))
            session.setAttribute("ReportElementNo",strFormBean);
        else
        {
            if(session.getAttribute(strFormBean)!=null) 
            {
                session.removeAttribute(strFormBean);
                if(strFormBean.equals("frmScheduleGroupDetails")) 
                {
                    if(session.getAttribute("frmScheduleSubGroupDetails")!=null)
                        session.removeAttribute("frmScheduleSubGroupDetails");
                }
                else if(strFormBean.equals("frmCostCentre")) 
                {
                    if(session.getAttribute("frmCostCentreSubGroup")!=null)
                        session.removeAttribute("frmCostCentreSubGroup");
                }
                // Remove the leave cancellation,revision and extension pages 
                else if(strFormBean.equals("frmLeaveAppln1")) 
                {
                    if(session.getAttribute("frmLeaveCancln")!=null)
                        session.removeAttribute("frmLeaveCancln");
                    else if(session.getAttribute("frmLeaveRevn")!=null)
                        session.removeAttribute("frmLeaveRevn");
                    else if(session.getAttribute("frmLeaveExtn")!=null)
                        session.removeAttribute("frmLeaveExtn");                    
                
                }
                //added by Balram to remove the child approval screen from session
                if(strFormBean.equals("frmAdvClaimReqApproval"))
                {
                     if(session.getAttribute("frmAdvanceApp")!=null)
                        session.removeAttribute("frmAdvanceApp");
                }
                if (strFormBean.equals("frmPromoList"))
                {
                    if(session.getAttribute("frmPromoDetail")!=null)
                        session.removeAttribute("frmPromoDetail");
                }
                if (strFormBean.equals("frmZOC"))
                {
                    if(session.getAttribute("frmZOCrpt")!=null)
                        session.removeAttribute("frmZOCrpt");
                }         
                if (strFormBean.equals("frmProbationClosure"))
                {
                    if(session.getAttribute("frmProbationRpt")!=null)
                        session.removeAttribute("frmProbationRpt");

                    if(session.getAttribute("frmConfirmationRpt")!=null)
                        session.removeAttribute("frmConfirmationRpt");
                        
                }
                if (strFormBean.equals("frmNonTechGradeEntry"))
                {
                    if(session.getAttribute("frmPromotionOrderNT")!=null)
                        session.removeAttribute("frmPromotionOrderNT");

                    if(session.getAttribute("frmPromotionOrderNT")!=null)
                        session.removeAttribute("frmPromotionOrderNT");
                        
                }
                 if (strFormBean.equals("frmLeaveApprvl"))
                {
                    if(session.getAttribute("frmLeaveDetails")!=null)
                        session.removeAttribute("frmLeaveDetails");
                }
                 if(strFormBean.equals("frmPreMatRet")) 
                {
                    if(session.getAttribute("frmPropPremRetRev")!=null) 
                        session.removeAttribute("frmPropPremRetRev");
                }
                 if(strFormBean.equals("frmInterviewlist")) 
                {
                    if(session.getAttribute("frmInterList")!=null) 
                        session.removeAttribute("frmInterList");
                }

                 if (strFormBean.equals("frmEmpPers1"))
                {
                    if(session.getAttribute("frmEmpPers2")!=null)
                        session.removeAttribute("frmEmpPers2");
                }
                 if (strFormBean.equals("frmPostcreation"))
                {
                    if(session.getAttribute("frmSanctionOrder")!=null)
                        session.removeAttribute("frmSanctionOrder");
                }
                 if(strFormBean.equals("frmAppScr")) 
                {
                    if(session.getAttribute("frmScreenedList")!=null) 
                        session.removeAttribute("frmScreenedList");
                }
                 if(strFormBean.equals("frmTrkStatus")) 
                {
                    if(session.getAttribute("frmLeaveDetails")!=null) 
                        session.removeAttribute("frmLeaveDetails");

                    if(session.getAttribute("LeaveEncashApplnView")!=null) 
                        session.removeAttribute("LeaveEncashApplnView");
                }
            }
             if(strFormBean.equals("frmPropertyIntimation") || strFormBean.equals("frmPrptyApp1") || strFormBean.equals("frmPrptyDisc") || strFormBean.equals("frmPrptyVig") || strFormBean.equals("frmPrptyVigFinal") ||   strFormBean.equals("frmPrptyCompAuth") ||    strFormBean.equals("frmPrptyAcptOrder")) 
            {
                if(session.getAttribute("frmPropertyIntiView")!=null) 
                    session.removeAttribute("frmPropertyIntiView");
            }
            
        }
        return mapping.findForward(strForward);
    }
}