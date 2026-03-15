package FCIPAY.Payroll.common.utility;

import java.util.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedInputStream;
import FCIPAY.Payroll.common.utility.ReportReader;
import java.net.URLEncoder;

public class ReportServerLinker extends Action
{
  public ReportServerLinker()
  {}
  String reportName;
 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
    URL reportURL = new URL(getReportURL(request));
    URLConnection connection = reportURL.openConnection();
    BufferedInputStream bufferedInputStream=null;
    try{
      bufferedInputStream = new BufferedInputStream(connection.getInputStream());
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    System.out.println(connection.getContentLength());
    byte[] buffer = new byte[1024];
    int count=0;
    response.setContentType("application/pdf");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Content-Disposition", "attachment; filename=" + reportName +".pdf");
    response.setContentLength((int) connection.getContentLength());
    request.setAttribute("status","Downloaded");
    OutputStream responseOutputStream = response.getOutputStream();
    while((count = bufferedInputStream.read(buffer,0,1024)) != -1)
    {
        responseOutputStream.write(buffer, 0, count);
    }
    responseOutputStream.flush();
    responseOutputStream.close();
    bufferedInputStream.close();
    return null;
  }
  
   public String getReportURL(HttpServletRequest request)
   {
      ReportReader oReportReader = new ReportReader();
      String serverURL = "http://"+oReportReader.getAppServerName()+":"+oReportReader.getAppServerPortNumber()+"/"+oReportReader.getAppServerReportPathAlias()+"/rwservlet?"+oReportReader.getRepKey()+"&report="+oReportReader.getRepPath();
      String requestParams = request.getParameter("submitParam").toString();
      reportName = requestParams.substring(0,requestParams.indexOf("."));
      String[] conRequestParams = requestParams.split("\\|");
      String rdf = conRequestParams[0];
      String rptParams = rdf;
      for(int i=1; i<conRequestParams.length; i++) 
      {
        String[] keyAndValues = conRequestParams[i].split("\\@");
        rptParams = rptParams + "&" + keyAndValues[0] + "=" + (keyAndValues[1] == null ? "" : keyAndValues[1]);
      }
      String url = serverURL + rptParams;
      String url1=url.replaceAll(" ","%20");
      return url1;
     
  }
}