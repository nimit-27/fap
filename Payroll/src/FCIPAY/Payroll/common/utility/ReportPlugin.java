package FCIPAY.Payroll.common.utility;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.xml.vo.INFOClass;
import FCIPAY.Payroll.com.Parser.util.common.FWXMLUtility;

public class ReportPlugin  implements PlugIn 
{
  //private String pathName = "/WEB-INF/EnrgiseLOV.xml";
  private String reportPathName= "/WEB-INF/EnrgiseReport.xml";
  public ReportPlugin()
  {
  }
  public void init(ActionServlet servlet, ModuleConfig config) throws ServletException
  {
    try
    {      
   INFOClass oINFOClass = (INFOClass)FCIPAY.Payroll.com.Parser.util.common.FWXMLUtility.xmlToObject("FCIPAY.Payroll.common.xml.vo.INFOClass", calculatePath(servlet, reportPathName));
      ReportManager.getInstance().init(oINFOClass);
      
      
    StringBuffer woStringBuffer = new StringBuffer (); 
//   woStringBuffer.append(" rwserver server=pdas"); //- Location where RDF is located 
    woStringBuffer.append(" rwserver server=fcirpt"); //- Location where RDF is located 
  // woStringBuffer.append(" rwserver server=rep_apps"); //- Location where RDF is located 
    System.out.println(woStringBuffer.toString());
   // Process pr=Runtime.getRuntime().exec(woStringBuffer.toString()); 
    
    }
    catch(Exception oEx)
    {
        System.out.println("Error loading plugins at FCIPAY.Payroll.common.utility.ReportPlugin ");
    }
      
  }
  	public void destroy()
  {
        
  }
  
   private String calculatePath(ActionServlet servlet, String sPath)
  {
    return servlet.getServletContext().getRealPath(sPath);
  }
}
