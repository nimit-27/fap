/*
 * Program Name : ChangePwdAction.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Action Class for the Change password screen
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

import FCIPAY.COMMON.WEBTIER.Form.ChangePwdForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ChangePwdVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.ChangePwdDAO;
import FCIPAY.COMMON.UTILITY.*;


import java.security.MessageDigest;
import FCIPAY.COMMON.UTILITY.Encryption;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.WEBTIER.Action.PasswordStrengthChker;

public class ChangePwdAction extends Action  
{
    ActionErrors errors=new ActionErrors();
    ChangePwdVO oChangePwdVO=new ChangePwdVO();

    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,IBAFatalException,Exception
    {
        ChangePwdForm oChangePwdForm = (ChangePwdForm)form;


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


//======================IF Action is "ONLOAD"============================            

        if(oChangePwdForm.getHdnAction().equals("OnLoad"))
        {
            oChangePwdForm.setHdnEmpNo(obUserInfo.getLEmployeeNo());
        }

//======================IF Action is "HOME"============================            

        if(oChangePwdForm.getHdnAction().equals("Home"))
        {
            return mapping.findForward("MainPage");
        }  

//======================IF Action is "CHANGE PASSWORD"============================            

        if(oChangePwdForm.getHdnAction().equals("Change Password"))
        {
            oChangePwdVO=oChangePwdForm.createVO();
            oChangePwdVO.setUserEmpNo(obUserInfo.getLEmployeeNo());
            oChangePwdVO.setUserSiteId(obUserInfo.getLLocationCode());

              //Calling the method to encode the Old and New Passwords
//            oChangePwdVO.setTxtOldPwd(encodePassword(oChangePwdForm.getTxtOldPwd(),"MD5"));
//            oChangePwdVO.setEncryptPwd(encodePassword(oChangePwdForm.getTxtNewPwd(),"MD5"));
            PasswordStrengthChker oPasswordStrengthChker = new PasswordStrengthChker();
            if(!oPasswordStrengthChker.verify(oChangePwdForm.getTxtNewPwd()))
            {
                oChangePwdForm.setTxtConfirmPwd("");
                oChangePwdForm.setTxtNewPwd("");
                oChangePwdForm.setTxtOldPwd("");
                errors.clear();
                errors.add("error",new ActionError("Common.ChangePwd.Policy"));
                saveErrors(request,errors);
                return mapping.findForward("success");
            }
            oChangePwdVO.setTxtOldPwd(Encryption.encodePassword(oChangePwdForm.getTxtOldPwd(),"MD5"));
            oChangePwdVO.setEncryptPwd(Encryption.encodePassword(oChangePwdForm.getTxtNewPwd(),"MD5"));


            ChangePwdDAO oChangePwdDAO=new ChangePwdDAO();
            try
            {
                if(oChangePwdDAO.setPwd(oChangePwdVO))
                {
                    System.out.println("Changed Successfuly");
                    errors.clear();
                    errors.add("error",new ActionError("Common.ChangePwd.Success"));
                    saveErrors(request,errors);
                }
                else
                {
                    System.out.println("Changed Successfuly");
                    errors.clear();
                    errors.add("error",new ActionError("Common.ChangePwd.Incorrect"));
                    saveErrors(request,errors);
                }
            }
            catch(IBAFatalException ibafe) 
            {
                errors.clear();
                errors.add("error",new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch(Exception e) 
            {
                errors.clear();
                errors.add("error",new ActionError("Common.Database.Error"));
                saveErrors(request,errors); 
            }
            oChangePwdForm.setTxtConfirmPwd("");
            oChangePwdForm.setTxtNewPwd("");
            oChangePwdForm.setTxtOldPwd("");
        }
        return mapping.findForward("success");
    }

    
/**
     * Encode a string using algorithm and return the
     * resulting encrypted password. If exception, the plain credentials
     * string is returned
     *
     * @param password Password or other credentials to use in authenticating
     *        this username
     * @param algorithm Algorithm used to do the digest
     *
     * @return encypted password based on the algorithm.
     
    public static String encodePassword(String password, String algorithm) 
    {
        byte[] unencodedPassword = password.getBytes();

        MessageDigest md = null;
        try 
        {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            return password;
        }
        md.reset();
        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);

        // now calculate the hash
        byte[] encodedPassword = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) 
        {
            if (((int) encodedPassword[i] & 0xff) < 0x10) 
                buf.append("0");
            buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
        }
        return buf.toString();
    }*/
}