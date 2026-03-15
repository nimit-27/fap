package FCIPAY.COMMON.WEBTIER.Action;

import java.io.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BadURL extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  public void doPost(HttpServletRequest request, HttpServletResponse response){
      try{
          response.setContentType("text/html");
          PrintWriter out = response.getWriter(); 
          out.print("Host can't be validated, please re-run the Application.");
      }catch(Exception e){
          e.printStackTrace();
      }
  }
}
