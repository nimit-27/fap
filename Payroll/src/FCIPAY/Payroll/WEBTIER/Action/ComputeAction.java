/*    
    * Module:        ComputeAction.java 
    * Author:        Arunava Chanda
    * Date Written:  July 2005
    * Description:   Action Class for Computing Pension, Gratuity, LeaveEncashment, PfSettle, GIS
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.Payroll.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.ComFinalSetBD;
import FCIPAY.Payroll.WEBTIER.Form.ComFinalSetForm;
import java.util.ArrayList;

public class ComputeAction  extends BaseAction
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */

  public ComputeAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {  
/*    String procs = (String)(request.getParameter("param1"));
    String empNo = (String)(request.getParameter("param2"));
    ComFinalSetBD oComFinalSetBD = new ComFinalSetBD();
    ComFinalSetForm oComFinalSetForm = (ComFinalSetForm)form;
    String errorCode = new String ("UNSUCCESSFULLY DONE");
    if(procs.equals("PEN"))
    {
      String pension = oComFinalSetBD.compute(procs,empNo);
      int ind = pension.indexOf(",",0);
      String orgPension = new String(pension.substring(0, ind));
      int ind1 = pension.indexOf(",",ind+1);
      String fmlyPension = new String(pension.substring(ind+1, ind1));
      String redPension = new String(pension.substring(ind1+1, pension.length()));
   //   oComFinalSetForm.setTxtOrgPenAm(orgPension);
  //    String netCom = new Integer(Integer.parseInt(oComFinalSetForm.getTxtMthComValue()) * Integer.parseInt(oComFinalSetForm.getTxtComValue()) * 12).toString(); 
  //    oComFinalSetForm.setTxtNetCom(netCom);    
  //    String redMon = new Integer(Integer.parseInt(orgPension) - Integer.parseInt(oComFinalSetForm.getTxtMthComValue())).toString(); 
   //   oComFinalSetForm.setTxtRedMonPen(redMon);    
   //   oComFinalSetForm.setTxtTmon(redMon);
      //oComFinalSetForm.setTxtMthComValue(fmlyPension);
      //oComFinalSetForm.setTxtRedMonPen(redPension);
      errorCode = "SUCCESSFULLY DONE";
    }
    if(procs.equals("GRA"))
    {
      String gra = oComFinalSetBD.compute(procs,empNo);
      int ind = gra.indexOf(",",0);
      String gratuity = new String(gra.substring(0, ind));
      errorCode = new String(gra.substring(ind+1, gra.length()));
      oComFinalSetForm.setTxtGratuity(gratuity);
    }
    if(procs.equals("LEAVE"))
    {
      String leave = oComFinalSetBD.compute(procs,empNo);
      int ind = leave.indexOf(",",0);
      String leaveEncash = new String(leave.substring(0, ind));
      errorCode = new String(leave.substring(ind+1, leave.length()));
      oComFinalSetForm.setTxtLeave(leaveEncash);
    }
    if(procs.equals("Pf"))
    {
      String pf = oComFinalSetBD.compute(procs,empNo);
      int ind = pf.indexOf(",",0);
      String pfSettle = new String(pf.substring(0, ind));
      errorCode = new String(pf.substring(ind+1, pf.length()));
 //     oComFinalSetForm.setTxtPFSettle(pfSettle);
    }
    if(procs.equals("GIS"))
    {
      String gis = oComFinalSetBD.compute(procs,empNo);
      int ind = gis.indexOf(",",0);
      String gisVal = new String(gis.substring(0, ind));
      errorCode = new String(gis.substring(ind+1, gis.length()));
 //     oComFinalSetForm.setTxtGIS(gisVal);
    } 

    ArrayList oArguments = new ArrayList();
    oArguments.add(new String(errorCode));
    if(errorCode.equals("SUCCESSFULLY DONE"))
    { 
    }
    else
    {      
      oComFinalSetForm.setHeaderDataChanged(false);
    }
    throw new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments);
    */
    return null;
  }
  
}