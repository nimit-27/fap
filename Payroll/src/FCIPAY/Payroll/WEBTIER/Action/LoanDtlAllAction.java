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
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LoanDtlsAllBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.UTILITY.LoanDtlsAllHeaderBean;


public class LoanDtlAllAction extends BaseAction
{
  public LoanDtlAllAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      LoanDtlsAllBD oBaseBD = new LoanDtlsAllBD();
    //  UserSession oUser = getUserSessionBean(request);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      ArrayList oDetailBeanArray = null;
      
  /*    if(!oBaseForm.isDetailDataChanged() && !oBaseForm.isHeaderDataChanged())
      {
         if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
        {
              oBaseForm.setScreenMode("Q");
        }            
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }
      */
      BeanUtils.copyProperties(oBaseHeaderBean,form);

        if(oBaseForm.isDetailDataChanged())
        {
          oDetailBeanArray = getDetailArray(oBaseForm);
        }
      
      
    /* Added By Payroll Team for Passing USERID and SITEID  */
      long userId = oBaseForm.getLoginEmployeeNo();
      long siteId = oBaseForm.getLoginLocCode();

      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
      
      oBaseHeaderBean = oBaseBD.computeIntRate((LoanDtlsAllHeaderBean)oBaseHeaderBean);
    //  oDetailBeanArray.set(Integer.parseInt(index),oLoanDtlsDetailBean);
      
      BeanUtils.copyProperties(oBaseForm,oBaseHeaderBean);
   
   
     // throw new EnrgiseApplicationException("Payroll.EmpLeave.CancelSuccess",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      return mapping.findForward(EnrgiseConstants.SUCCESS);
  }
}