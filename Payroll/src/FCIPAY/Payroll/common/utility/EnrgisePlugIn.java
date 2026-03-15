package FCIPAY.Payroll.common.utility;

import FCIPAY.Payroll.common.xml.vo.EnrgiseForms;
import FCIPAY.Payroll.common.xml.vo.LOVClass;


import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

public class EnrgisePlugIn  implements PlugIn 
{
//  static final Logger log = Logger.getLogger("wenrgise.common.utility.EnrgisePlugIn");
  private String formPathName = "/WEB-INF/EnrgiseConfig.xml";
  private String pathName = "/WEB-INF/EnrgiseLOV.xml";
  
  public EnrgisePlugIn()
  {
  }
  
//  public void init(ActionServlet servlet, ModuleConfig config) throws ServletException
   public void init(ActionServlet servlet, ModuleConfig config) throws ServletException
  {
    try
    { 
      System.out.println("Hello World - EnrgisePlugIn-1");
      
      EnrgiseForms oEnrgiseForms = (EnrgiseForms)FCIPAY.Payroll.com.Parser.util.common.FWXMLUtility.xmlToObject("FCIPAY.Payroll.common.xml.vo.EnrgiseForms", calculatePath(servlet, formPathName));
		
      EnrgiseManager.getInstance().init(oEnrgiseForms);
      //System.out.println("Hello World - EnrgisePlugIn-2");
      
      LOVClass oLOVClass = (LOVClass)FCIPAY.Payroll.com.Parser.util.common.FWXMLUtility.xmlToObject("FCIPAY.Payroll.common.xml.vo.LOVClass", calculatePath(servlet, pathName));
      
      LOVManager.getInstance().init(oLOVClass);    
        
      //System.out.println("Hello World - EnrgisePlugIn-3");  
      
    }
    catch(Exception oEx)
    {
        System.out.println("Error loading plugins at FCIPAY.Payroll.common.utility.EnrgisePlugIn "); 
    }
      
  }

	public void destroy()
  {
        
  }
  
  private String calculatePath(ActionServlet servlet, String sPath)
  {
    return servlet.getServletContext().getRealPath(sPath);
  }

  public String getFormPathName()
  {
    return formPathName;
  }

  public void setFormPathName(String newFormPathName)
  {
    formPathName = newFormPathName;
  }



}