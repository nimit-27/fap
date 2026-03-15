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

import FCIPAY.COMMON.WEBTIER.Form.HomePageForm;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.HomePageDAO;

public class HomePageAction extends Action  {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        HomePageForm ohomepageForm=(HomePageForm)form;
        HomePageDAO oHomePageDAO=new HomePageDAO();
        if(ohomepageForm.getHdnAction().equals("Load"))
        {
            try
            {
                String HdnUrl=oHomePageDAO.getReportURL(ohomepageForm.getHdnReportURL(),"HomePage");
                if(HdnUrl.equals(""))
                    System.out.println("No Report Url Found");
                else
                {
                    ohomepageForm.setHdnReportURL(HdnUrl);
                    //session.setAttribute("ReportElementNo",null);
                    ohomepageForm.setHdnAction("Loaded");
                }
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
            }
        }
        else if(ohomepageForm.getHdnAction().equals("Reset")) 
        {
            HttpSession oHttpSession=request.getSession(false);
            ohomepageForm.setHdnAction("");
            ohomepageForm.setHdnReportURL("");
            oHttpSession.setAttribute("ReportElementNo",null);
            //System.out.println("Into Reset and Action Value="+ohomepageForm.getHdnAction());
        }
        return mapping.findForward("success");
    }
}