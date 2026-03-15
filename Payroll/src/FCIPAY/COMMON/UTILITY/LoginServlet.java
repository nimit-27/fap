package FCIPAY.COMMON.UTILITY;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.http.HttpServlet;

public class LoginServlet extends HttpServlet
{

  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try
    {
      HttpSession session = request.getSession();
      UserInfoBean oUserInfo = new UserInfoBean();

      session.setAttribute("USERINFO",oUserInfo);

      RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/HRMS/JSP/frmLanguageMaster.jsp");
      rd.forward(request,response);            
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}