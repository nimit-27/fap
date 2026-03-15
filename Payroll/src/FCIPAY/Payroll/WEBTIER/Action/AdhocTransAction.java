/*    
    * Module:        ComputeAction.java 
    * Author:        Arunava Chanda
    * Date Written:  August 2005
    * Description:   Action Class for Adhoc Transactions
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.Payroll.WEBTIER.Action;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintAdhocPayBD;
import FCIPAY.Payroll.WEBTIER.Form.MaintAdhocPayForm;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AdhocTransAction  extends BaseAction
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */

  public AdhocTransAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {  
    String procs = (String)(request.getParameter("param1"));
    MaintAdhocPayBD oMaintAdhocPayBD = new MaintAdhocPayBD();
    MaintAdhocPayForm oMaintAdhocPayForm = (MaintAdhocPayForm)form;
    String payCode = oMaintAdhocPayForm.getTxtPayCode();
    String payMode = oMaintAdhocPayForm.getTxtPayMode();
    String payYYMM = oMaintAdhocPayForm.getTxtPayYYMM();
    long lUserID = oMaintAdhocPayForm.getLoginEmployeeNo();
    long lSiteID = oMaintAdhocPayForm.getLoginLocCode();
    
    String errorCode = oMaintAdhocPayBD.adhocPayTrans(procs,payCode,payMode,payYYMM,lUserID,lSiteID);
    ArrayList oArguments = new ArrayList();
    oArguments.add(new String(errorCode));
    throw new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments);
  }
  
}