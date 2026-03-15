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
import FCIPAY.Payroll.WEBTIER.Form.EmpTrnsfrForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpTrnsfrBD;
import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class EmpTrnsfrRlsSalaryAction extends BaseAction
{
  public EmpTrnsfrRlsSalaryAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      EmpTrnsfrBD oEmpTrnsfrBD=(EmpTrnsfrBD)oBaseBD;
      String butAction = "";  
      long loginUserId = 100 ;
      long lLoginSiteId = 100  ;
      EmpTrnsfrForm fedoForm = (EmpTrnsfrForm)oBaseForm;
      BeanUtils.copyProperties(oBaseHeaderBean,form);      

      UserInfoBean obUserInfo = new UserInfoBean();
      String btnFlag = fedoForm.getButtonFlag();
      if(request.getSession().getAttribute("USERINFO")!=null)
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        loginUserId = obUserInfo.getLEmployeeNo();
        lLoginSiteId = obUserInfo.getLLocationCode();
      } 
          //String oErrorCode = oEmpSuspensionBD.computeProjectedTax(oBaseHeaderBean,loginUserId,lLoginSiteId);
          String oErrorCode = null;
          if(btnFlag.equals("SAL"))
          {
              oErrorCode = oEmpTrnsfrBD.releaseSalary(oBaseHeaderBean,loginUserId,lLoginSiteId);
          }
          else
          {
              oErrorCode = oEmpTrnsfrBD.releaseIncentive(oBaseHeaderBean,loginUserId,lLoginSiteId);
          }
          if (oErrorCode.equals(""))
          {
              System.out.println(oErrorCode);    
          }
          else
          {
              ArrayList oArguments = new ArrayList();
              oArguments.add(new String(oErrorCode));
              throw new EnrgiseApplicationException("Payroll.Susp.Payroll_MSG",oArguments);  
          }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}