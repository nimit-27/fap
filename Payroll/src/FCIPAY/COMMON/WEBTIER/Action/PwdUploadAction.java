    /*
     * Module       :   UploadAction.java
     * Author       :   V.Jegan
     * Date Written :   4th Oct 2004
     * Description  :   The Action class file for the PasswordUpload.jsp page
     *                  which handles all the operations of the page
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
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
import FCIPAY.COMMON.WEBTIER.Form.PwdUploadForm;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.PwdUploadDAO;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class PwdUploadAction extends Action 
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
        PwdUploadForm oPwdForm=(PwdUploadForm)form;
        ActionErrors errors=new ActionErrors();
        
//=======================Checking the UserInfo Bean class========================
        UserInfoBean obUserInfo;// = new UserInfoBean();
        HttpSession session = request.getSession(false);
        if(session!=null) 
        {
            //session.setAttribute("USERINFO",obUserInfo);
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("failure");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else
             return mapping.findForward("failure");

//=====================FOR UPLOADING THE FILE===========================================

        if(oPwdForm.getUploadAction().equals("upload"))
        {
            oPwdForm.setErrLineNo(0);
            try
            {
                PwdUploadDAO oPwdDAO=new PwdUploadDAO();
                if(oPwdDAO.setValues(oPwdForm.getFile(),obUserInfo.getLEmployeeNo(),obUserInfo.getLLocationCode()))
                {
                    errors.clear();
                    errors.add("error",new ActionError("Finance.Upload.Success"));
                    saveErrors(request,errors);
                }
                else
                {
                    errors.clear();
                    errors.add("error",new ActionError("Finance.Upload.Failure"));
                    saveErrors(request,errors);
                }
            }
            catch(IBAFatalException e)
            {
                e.printStackTrace();
                errors.clear();
                //System.out.println("Error Code is " + e.getiErrCode());
                //System.out.println("Error Message is " + e.getsMessage());
                //System.out.println("Error Code Own is " + e.getErrorKey());
                //This is for checking the password column is more than 8 characters
                if(e.getsMessage().equals("Length"))
                    oPwdForm.setErrLineNo(e.getiErrCode());
                //This is for checking the Employee already exists
                else if(e.getErrorKey().equals("1"))
                    errors.add("error",new ActionError("Common.PwdUpload.PK"));
                //This is for checking that the employee is not there in the HRM_Employee
                else if(e.getErrorKey().equals("2291"))
                    errors.add("error",new ActionError("Common.PwdUpload.FK"));
                //This is an general Error.
                else
                    errors.add("error",new ActionError("Finance.Upload.Failure"));
                saveErrors(request,errors);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Finance.Upload.Failure"));
                saveErrors(request,errors);
            }
        }

//=====================FOR RESETING THE FORM===========================================

        if(oPwdForm.getUploadAction().equals("reset"))
        {
            oPwdForm.setFile("");
            oPwdForm.setUploadAction("");
            oPwdForm.setErrLineNo(0);
        }
        
        return mapping.findForward("success");
    }
}