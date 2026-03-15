/*
 * Program Name : WindowCloseSesAction.java
 * Author       : Swapnendu Kumar Bastia
 * Date Written : 06/09/2012
 * Description  : This is the Action Class for Session out during Browser Window Close.
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
import java.util.Enumeration;

public class WindowCloseSesAction extends Action  
{
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, EnrgiseSystemException, EnrgiseApplicationException
    {
        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;
        System.out.println("Browser Close Session Out");
        if(session!=null)
        {
            session.invalidate();
        }
        return null;
    }
}