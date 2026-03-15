package FCIPAY.Payroll.Labour.WEBTIER.Action;
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
import FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDeptOTIncentiveForm;
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.CalcDeptOTIncentiveBD;
import FCIPAY.Payroll.Labour.Utility.CalcDeptOTIncentiveHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class CalcDeptOTIncentiveAction extends BaseAction 
{
  public CalcDeptOTIncentiveAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      CalcDeptOTIncentiveBD oCalcDeptOTIncentiveBD=(CalcDeptOTIncentiveBD)oBaseBD;
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   

      CalcDeptOTIncentiveForm fedoForm = (CalcDeptOTIncentiveForm)oBaseForm;
      lUserID = fedoForm.getLoginEmployeeNo();
      lSiteID = fedoForm.getLoginLocCode();
      
      BeanUtils.copyProperties(oBaseHeaderBean,form);      


      /* Added for Getting Current User */
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }
      /*End of Code */

      String sHdnVal = fedoForm.getHdnAction();
      if (sHdnVal.equals("SUB")) 
      {
          String oErrorCode = oCalcDeptOTIncentiveBD.calcDeptOTIncentive(lUserID,lSiteID,(CalcDeptOTIncentiveHeaderBean)oBaseHeaderBean);
          fedoForm.setHdnAction("");          
          System.out.println(oErrorCode);


          fedoForm.setHdnAction("");

//      Modified By Balpreet Dt 23-Oct 2007. for displaying success msg properly...
          
          if(oErrorCode.equals("0SUCCESS")) {
            throw new EnrgiseApplicationException("Pay.Init.Payroll.Success.Message",EnrgiseConstants.MESSAGE);
          }
          else {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oErrorCode));
            throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);              
          }
      }
      else if (sHdnVal.equals("S")) 
      {
            throw new EnrgiseApplicationException("Pay.Lbr.Incentive.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }      
           return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }
  
}