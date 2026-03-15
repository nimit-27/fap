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
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GenerateCPVBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class GenerateCPVAction extends BaseAction
{
  public GenerateCPVAction()
  {
  }

 public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {

      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      GenerateCPVBD oGenerateCPVBD=(GenerateCPVBD)oBaseBD;
      long lUserID = 200;
      long lSiteID = 200;


      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }

    String oErrorCode = oGenerateCPVBD.GenerateCPV(lUserID,lSiteID);

        if(oErrorCode.equals("GEN_CPV_SUCCESS"))
          {
               throw new EnrgiseApplicationException("Pay.Gen.CPV.Success",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
          }
        if(oErrorCode.equals("GEN_CPV_FAILED"))
          {
               throw new EnrgiseApplicationException("Pay.Gen.CPV.Failure",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
          }          
        if(oErrorCode.equals("GEN_CPV_CANNOT_BE_RUN"))
          {
               throw new EnrgiseApplicationException("PAY.Gen.CPV.RUN",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
          }

        if(oErrorCode.equals("GEN_CPV_DONE_ALREADY"))
          {
               throw new EnrgiseApplicationException("PAY.Gen.CPV.DONE.ALREADY",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
          }
          
    return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }

}