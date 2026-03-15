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
import java.util.*;

import FCIPAY.COMMON.WEBTIER.Form.LoginForm;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.LoginBD;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.Encryption;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.COMMON.UTILITY.comboBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Enumeration;

//import IBA.COMMON.WEBTIER.Action.ChangePwdAction;

public class LoginAction extends Action 
{
    LoginBD oLoginBD = new LoginBD();

    /**
    * This is the main action called from the Struts framework.
    * @param mapping The ActionMapping used to select this instance.
    * @param form The optional ActionForm bean for this request.
    * @param request The HTTP Request we are processing.
    * @param response The HTTP Response we are processing.
    */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, EnrgiseSystemException, EnrgiseApplicationException
    {
        //System.out.println("Inside LogIn Action");
        ActionErrors errors = new ActionErrors();    
        ArrayList lList = new ArrayList();       
        UserInfoBean oUIBean = new UserInfoBean();
        String sActionVal = null;
         
        LoginForm oForm = (LoginForm)form;

        HttpSession session = request.getSession(true);
        //If the user has pressed enter from the Login page
        if(oForm.getActionValue().equals("Login"))
            oForm.setHdnAction("Login");

        //If the user has pressed tab from the password field
        if(oForm.getHdnAction().equals("GetLocDetails")) 
        {
            try
            {
                //System.out.println("Before getting locations");
                lList=oLoginBD.getLocationCodes(oForm.getTxtUserId(),Encryption.encodePassword(oForm.getTxtPwd(),"MD5"));
                //setting the Location Code ArrayList to the Form
                oForm.setLocList(lList);
                /*Start-------------------------session fixation---------------------------------------------
                  added by swapnendu on 01-06-2016 for session fixation
                * */
                //copy session attributes from new session to a map. 
                HashMap old = new HashMap();
                Enumeration keys = (Enumeration)session.getAttributeNames();
                while (keys.hasMoreElements()) {
                    String key = (String)keys.nextElement();
                    old.put(key, session.getAttribute(key));
                    session.removeAttribute(key);
                }
                //invalidating existing session.
                session.invalidate();

                //create new session and copy key value pairs from map to new session.
                session=request.getSession(true);
                /*Iterator itr = old.entrySet().iterator();
                while (itr.hasNext()) {
                    String key = (String)itr.next();
                    session.setAttribute(key, old.get(key));
                }*/
                for(Object obj : old.entrySet()) {
                    Map.Entry<String, String> entry = (Map.Entry)obj;
                    session.setAttribute(entry.getKey(),entry.getValue());
                    
                }
                /*End-----------------------------------------------------------------------------
                 * */

                if(lList.size()==1)
                {
                    oForm.setLstLocCode(((comboBean)(lList.get(0))).getIdString());
                //    oLoginBD.updateLoginAttempts(oForm.getTxtUserId(),0);
                }
                if(lList.size()==0)
                {
               //     oLoginBD.updateLoginAttempts(oForm.getTxtUserId(),1);
                    errors.clear();
                    errors.add("error", new ActionError("Common.LogIn.InvalidUser"));
                    saveErrors(request,errors);
                    oForm.setTxtPwd("");
                    oForm.setTxtUserId("");
                }
            }

              catch(EnrgiseApplicationException e)
              {
                if(errors == null)
                {
                  errors = new ActionErrors();
                }
                        // Process the exception
                if(e.getArguments() == null)
                { // The exception has not got any arguments
        
                //Check whether it is an error or a message and place it in proper place
                  if(e.getErrorType().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR))
                  { // Error
                    errors.add(ActionErrors.GLOBAL_ERROR,new ActionError(e.getKey()));
                  }
                  else
                  { // Message         
                    errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionError(e.getKey()));
                  }
                } 
                else
                { //No Arguments
                // Check whether it is of type error
                  if(e.getErrorType().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR))
                  { // Error         
                    errors.add(ActionErrors.GLOBAL_ERROR,new ActionError(e.getKey(),e.getArguments().toArray()));
                  }
                  else
                  { //Message         
                    errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionError(e.getKey(),e.getArguments().toArray()));
                  }
                }
                saveErrors(request,errors);
              }              
    
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
                throw new EnrgiseSystemException("Common.LogIn.InvalidUser", e);            
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
//                throw new EnrgiseSystemException("Common.DB.Administrator", e );                            
                errors.clear();
                errors.add("error", new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);    
            }  
                            
/*            catch(IBAFatalException ibafe) 
            {
                ibafe.printStackTrace();
                errors.clear();
                errors.add("error", new ActionError("Common.LogIn.InvalidUser"));
                saveErrors(request,errors);
            }
            catch(Exception e) 
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error", new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);    
            }  */
            
        }

        //if the user has pressed the Login Button or pressed Enter
        if(oForm.getHdnAction().equals("Login")) 
        {
            if((oForm.getTxtUserId().equals(""))||(oForm.getTxtPwd().equals(""))||(oForm.getLstLocCode().equals(""))) 
            {
                errors.clear();
                errors.add("error", new ActionError("Common.LogIn.InvalidUser"));
                saveErrors(request,errors);
                oForm.setTxtPwd("");
                oForm.setTxtUserId("");
                lList.clear();
                oForm.setLocList(lList);
                oForm.setActionValue("");
                oForm.setHdnAction("");
            }
            else
            {
                try
                {
                    lList=oLoginBD.getEmpDetails(oForm.getTxtUserId(),Encryption.encodePassword(oForm.getTxtPwd(),"MD5"),oForm.getLstLocCode());
                    oUIBean.setLEmployeeNo(Long.parseLong(lList.get(0).toString()));
                    oUIBean.setSEmployeeName(lList.get(1).toString());
                    oUIBean.setLLocationCode(Long.parseLong(oForm.getLstLocCode()));
                    oUIBean.setSEmpLocation(lList.get(3).toString());
                    oUIBean.setSSubLocation(lList.get(4).toString());  //This contains the location type for the given location
                    // set attribute
                    session.setAttribute("USERINFO", oUIBean);
                    String psswrdStts=lList.get(5).toString();
                    session.setAttribute("psswrdStts",psswrdStts);
                   /* if(psswrdStts.equals("0"))
                    {
                      return mapping.findForward("ChangePassword");
                    }*/
                    return mapping.findForward("MainPage");
                }
/*                catch(IBAFatalException iba)
                {       
                    iba.printStackTrace();
                    errors.clear();
                    errors.add("error", new ActionError("Common.LogIn.InvalidUser"));
                    saveErrors(request,errors);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    errors.clear();
                    errors.add("error", new ActionError("Common.DB.Administrator"));
                    saveErrors(request,errors);
                }  */

                  catch(EnrgiseSystemException e)
                  {
                    e.printStackTrace();
                    throw new EnrgiseSystemException("Common.LogIn.InvalidUser", e);            
                  }              
                 catch(Exception e) 
                 {
                    e.printStackTrace();
    //                throw new EnrgiseSystemException("Common.DB.Administrator", e );                            
                    errors.clear();
                    errors.add("error", new ActionError("Common.DB.Administrator"));
                    saveErrors(request,errors);    
                }  
                
                //For Clearing the Form Values
                oForm.setTxtPwd("");
                oForm.setTxtUserId("");
                lList.clear();
                oForm.setLocList(lList);
            }
        }
        oForm.setActionValue("");
        oForm.setHdnAction("");
        return mapping.findForward("success");                                
    }   
}   