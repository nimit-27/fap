package FCIPAY.Payroll.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MonthlyPayrollBD;
import FCIPAY.Payroll.WEBTIER.Form.MonthlyPayrollForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.UTILITY.MonthlyPayrollHeaderBean;
import java.util.ArrayList;

public class MonthlyPayrollAction extends BaseAction
{
  public MonthlyPayrollAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {     
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName); 
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      MonthlyPayrollBD oMonthlyPayrollBD=(MonthlyPayrollBD)oBaseBD;
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      long lUserID = 200;
      long lSiteID = 200;      
      String empNo = (String)(request.getParameter("param1"));
      String all = (String)(request.getParameter("param2")); 
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }       
      MonthlyPayrollForm fedoForm = (MonthlyPayrollForm)oBaseForm;
      String sHdnVal = fedoForm.getHdnAction();
      if (sHdnVal.equals("SUB")) 
      {               
            String oErrorCode = oMonthlyPayrollBD.MonthlyPayTransaction(empNo,all,lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag(),fedoForm.getHdnMaxRebFlag());
            MonthlyPayrollHeaderBean oMonthlyPayrollHeaderBean = (MonthlyPayrollHeaderBean)oBaseHeaderBean;
            fedoForm.setHdnAction("");            
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oErrorCode));
            throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
      else if (sHdnVal.equals("S")) 
      {
          throw new EnrgiseApplicationException("Pay.Comp.MthlyPayrl.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }           
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }            
}



