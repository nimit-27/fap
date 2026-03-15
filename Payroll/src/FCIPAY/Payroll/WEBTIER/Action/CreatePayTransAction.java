/*    
    * Module:        CreatePayrollTransactionAction.java 
    * Author:        Surajeet Chakraborty
    * Date Written:  December 2004
    * Description:   Action Class for FE Release Details
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
import FCIPAY.Payroll.common.utility.ParamUtil;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CreatePayTransBD;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.WEBTIER.Form.CreatePayrollForm;

public class CreatePayTransAction  extends BaseAction
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */

  public CreatePayTransAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {     
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      CreatePayTransBD oCreatePayTransBD=(CreatePayTransBD)oBaseBD;
      CreatePayrollForm fedoForm = (CreatePayrollForm)oBaseForm;
      ArrayList oArguments=null;
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      long lUserID = 200;
      long lSiteID = 200;
      String screenName="";
   
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }  
      String sHdnVal = fedoForm.getHdnAction();
      if(sHdnVal.equals("SUB")) 
      {
          String procs = (String)(request.getParameter("param1"));
          String empNo = (String)(request.getParameter("param2"));
          String oErrorCode = oCreatePayTransBD.createPayTransaction(procs, empNo,lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag());
          fedoForm.setHdnAction("");
          oArguments = new ArrayList();
          oArguments.clear();
          oArguments.add(new String(oErrorCode));
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
      else if (sHdnVal.equals("S")) 
      {
        throw new EnrgiseApplicationException("Pay.Create.PayTrans.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      } 
    return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}