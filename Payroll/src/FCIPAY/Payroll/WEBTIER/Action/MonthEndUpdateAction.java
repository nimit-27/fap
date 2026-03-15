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
import FCIPAY.Payroll.WEBTIER.Form.MonthlyPayrollForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MonthEndUpdateBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.WEBTIER.Form.PerformMonthEndUpdateForm;
public class MonthEndUpdateAction extends BaseAction
{

  public MonthEndUpdateAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {

      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      MonthEndUpdateBD oMonthEndUpdateBD=(MonthEndUpdateBD)oBaseBD;
    //MonthEndUpdateBD oMonthEndUpdateBD = new MonthEndUpdateBD();
    //oMonthEndUpdateBD.startMonthEndUpdate();
      long lUserID = 200;
      long lSiteID = 93;


      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }

      PerformMonthEndUpdateForm fedoForm = (PerformMonthEndUpdateForm)oBaseForm;
      
      String sHdnVal = fedoForm.getHdnAction();
      if (sHdnVal.equals("SUB")) 
      {               
            String oErrorCode=null;
          if(sScreenName.equalsIgnoreCase("SingleMonthUpdateScreen"))
          {
               oErrorCode = oMonthEndUpdateBD.startSingleMonthEndUpdate(lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag());
          }
          else
          {
                oErrorCode = oMonthEndUpdateBD.startMonthEndUpdate(lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag());
          }
          fedoForm.setHdnAction("");
          ArrayList oArguments = new ArrayList();
		  /*if(oErrorCode.equals("INACTIVE"))
          {
          throw new EnrgiseApplicationException("PAY.MonthEnd.INACTIVE.ALREADY",EnrgiseConstants.MESSAGE);
          }*/
          oArguments.add(new String(oErrorCode));
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
      else if (sHdnVal.equals("S")) 
      {
            throw new EnrgiseApplicationException("Pay.Month.End.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }      
          
                  
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }



}