package FCIPAY.Payroll.WEBTIER.Action;
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
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.lang.reflect.InvocationTargetException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
//import IBA.Payroll.WEBTIER.Form.MonthlyPayrollForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GenerateBPVBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class GenerateBPVAction extends BaseAction
{
  public GenerateBPVAction()
  {
  }
public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {

      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      GenerateBPVBD oGenerateBPVBD=(GenerateBPVBD)oBaseBD;
      long lUserID = 200;
      long lSiteID = 200;


      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }

    String oErrorCode = oGenerateBPVBD.GenerateBPV(lUserID,lSiteID);

/*        if(oErrorCode.equals("GEN_BPV_SUCCESS"))
          {
               throw new EnrgiseApplicationException("Pay.Gen.BPV.Success",EnrgiseConstants.MESSAGE);
          }
        if(oErrorCode.equals("GEN_BPV_FAILED"))
          {
               throw new EnrgiseApplicationException("Pay.Gen.BPV.Failure",EnrgiseConstants.MESSAGE);
          }          
        if(oErrorCode.equals("GEN_BPV_CANNOT_BE_RUN"))
          {
               throw new EnrgiseApplicationException("PAY.Gen.BPV.RUN",EnrgiseConstants.MESSAGE);
          }

        if(oErrorCode.equals("GEN_BPV_DONE_ALREADY"))
          {
               throw new EnrgiseApplicationException("PAY.Gen.BPV.DONE.ALREADY",EnrgiseConstants.MESSAGE);
          }
 */

           ArrayList oArguments = new ArrayList();
          oArguments.add(new String(oErrorCode));
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);                


 //   return mapping.findForward(EnrgiseConstants.SUCCESS);
  }



}