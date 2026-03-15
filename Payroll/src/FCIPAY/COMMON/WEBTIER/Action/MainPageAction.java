/*
 * Program Name : MainPageAction.java
 * Author       : Jegan.V
 * Date Written : 01/03/2004
 * Description  : This is the Action Class for the Mainpage Screen
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

import java.util.ArrayList;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.WEBTIER.Form.MainPageForm;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.MainPageDAO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;


public class MainPageAction extends Action  
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
//    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
      public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, EnrgiseSystemException, EnrgiseApplicationException
    {
        MainPageForm oMainPageForm = (MainPageForm)form;
        MainPageDAO oMainPageDAO=new MainPageDAO();
        ArrayList tempList=new ArrayList();
        
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

//===================ON Loading the Form get the Module Names===================
        if(oMainPageForm.getHdnAction().equals("OnLoad")) 
        {
            try 
            {            
/*                tempList=oMainPageDAO.getModule(obUserInfo.getLEmployeeNo(),obUserInfo.getLLocationCode());
                oMainPageForm.setModuleList(tempList);                  */
                System.out.println("MP Context Path: "+ request.getContextPath());
                tempList=oMainPageDAO.getModule(obUserInfo.getLEmployeeNo(),obUserInfo.getLLocationCode(),request.getContextPath());
                oMainPageForm.setModuleList(tempList);                                
            }
/*            catch(IBAFatalException ibafe) 
            {
                ibafe.printStackTrace();
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
            }  */
              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              
        }

//===================ON Clicking the Logout Button go to Login Page===================
        else if(oMainPageForm.getHdnAction().equals("Logout")) {
            session.invalidate();
            return mapping.findForward("LoginPage");
        }

//===================ON Clicking the Change passoword Button go to Login Page===================
        else if(oMainPageForm.getHdnAction().equals("Change Password")) 
            return mapping.findForward("ChangePassword");
            

//===================ON Clicking the Other Button go to Home Page===================
        else
        {
            tempList=new ArrayList();
            try
            {
              
                System.out.println("Action Value  : " + oMainPageForm.getHdnAction());
                String module=oMainPageForm.getHdnAction();
                
                tempList=oMainPageDAO.getDyanmicMenu(obUserInfo.getLEmployeeNo(),obUserInfo.getLLocationCode(),oMainPageForm.getHdnAction());
                oMainPageForm.setMenuList(tempList);
                //setting the arraylist to the session so that it can be taken in menu.jsp
                session.setAttribute("menuList",oMainPageForm.getMenuList());
                if(module.equalsIgnoreCase("Dept Labour Payroll"))
                {
                  obUserInfo.setSEmpType("L");
                }
                else if (module.equalsIgnoreCase("DPS Labour Payroll"))
                {
                  obUserInfo.setSEmpType("D");
                }
                else if (module.equalsIgnoreCase("Employee Payroll"))
                {
                  obUserInfo.setSEmpType("E");
                }
                else if (module.equalsIgnoreCase("NWNP Labour Payroll"))
                {
                  obUserInfo.setSEmpType("N");
                }
                /*System.out.println("The Menu is as follows : ");
                for(int i=0;i<oMainPageForm.getMenuList().size();i++) 
                {
                    System.out.println(((DynamicMenuBean)(oMainPageForm.getMenuList().get(i))).getDynamicMenu());    
                }*/
            }
/*        catch(IBAFatalException ibafe) 
            {
                ibafe.printStackTrace();
            }

            catch(Exception e) 
            {
                e.printStackTrace();    
            }  */

              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              

            return mapping.findForward("HomePage");
        }
        return mapping.findForward("success");
    }
}