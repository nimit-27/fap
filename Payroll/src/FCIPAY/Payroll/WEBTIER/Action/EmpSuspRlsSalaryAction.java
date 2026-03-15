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
import FCIPAY.Payroll.WEBTIER.Form.MaintEmpSuspensionForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpSuspensionBD;
import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class EmpSuspRlsSalaryAction extends BaseAction
{
  public EmpSuspRlsSalaryAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      EmpSuspensionBD oEmpSuspensionBD=(EmpSuspensionBD)oBaseBD;
      String butAction = "";  
      long loginUserId = 100 ;
      long lLoginSiteId = 100  ;
      MaintEmpSuspensionForm fedoForm = (MaintEmpSuspensionForm)oBaseForm;
      System.out.println("skhdvlsj");
      if(fedoForm.getRadFlg().equals("1"))
      {
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String("Absconding employees salary can not be released."));
          throw new EnrgiseApplicationException("Payroll.Susp.Payroll_MSG",oArguments);  
      }
      BeanUtils.copyProperties(oBaseHeaderBean,form);      

      UserInfoBean obUserInfo = new UserInfoBean();

      if(request.getSession().getAttribute("USERINFO")!=null)
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        loginUserId = obUserInfo.getLEmployeeNo();
        lLoginSiteId = obUserInfo.getLLocationCode();
      }           
      
          String oErrorCode = oEmpSuspensionBD.empSuspReleaseSalary(oBaseHeaderBean,loginUserId,lLoginSiteId);
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