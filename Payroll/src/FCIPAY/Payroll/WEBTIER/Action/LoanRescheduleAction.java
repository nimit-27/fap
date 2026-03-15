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
import FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm;
import FCIPAY.Payroll.WEBTIER.Form.LoanRescheduleForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CPFFinalPaymentBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentBean;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanRescheduleVO;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LoanRescheduleBD;
import FCIPAY.Payroll.UTILITY.LoanRescheduleBean;

public class LoanRescheduleAction extends BaseAction
{
  public LoanRescheduleAction()
  {
  }
  
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
     BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
    //  BaseBD oBaseBD = getHeaderBusinessDelegate(form);
     BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      BaseHeaderVO oBaseHeaderVO = null;
     // UserSession oUser = getUserSessionBean(request);
      
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   
      LoanRescheduleForm fedoForm = (LoanRescheduleForm)oBaseForm;      
     LoanRescheduleBD oLoanRescheduleBD=new LoanRescheduleBD();
     // lUserID = fedoForm.getLoginEmployeeNo();
   //   lSiteID = fedoForm.getLoginLocCode();
    BeanUtils.copyProperties(oBaseHeaderBean,form);
  //    BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(lUserID) );
  //   BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(lSiteID) );
   
      String hdnAction=fedoForm.getHdnAction();
     //  String hdnAction=fedoForm.getHdnAction();
      if(hdnAction.equals("getDtls"))
      {
          LoanRescheduleVO oLoanRescheduleVO=new  LoanRescheduleVO();
          BeanUtils.copyProperties(oLoanRescheduleVO,form);
         // oLoanRescheduleVO.setUserId(lUserID);
          oBaseHeaderBean = oLoanRescheduleBD.getLoanRescheduleDtls(oLoanRescheduleVO);
         LoanRescheduleBean oLoanRescheduleBean= (LoanRescheduleBean)oBaseHeaderBean;
          fedoForm.setTxtPaidPrn(oLoanRescheduleBean.getTxtPaidPrn());
          fedoForm.setTxtPaidInt(oLoanRescheduleBean.getTxtPaidInt());
          fedoForm.setTxtPaidPrnAmt(oLoanRescheduleBean.getTxtPaidPrnAmt());
          fedoForm.setTxtPaidIntAmt(oLoanRescheduleBean.getTxtPaidIntAmt());
          fedoForm.setTxtLoanAmt(oLoanRescheduleBean.getTxtLoanAmt());
          fedoForm.setTxtAlreadyPrn(oLoanRescheduleBean.getTxtAlreadyPrn());
          fedoForm.setTxtAlreadyInt(oLoanRescheduleBean.getTxtAlreadyInt());        
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      
      
     if(hdnAction.equals("CalcInt"))
      {
          LoanRescheduleVO oLoanRescheduleVO=new  LoanRescheduleVO();
          BeanUtils.copyProperties(oLoanRescheduleVO,form);         
          oBaseHeaderBean = oLoanRescheduleBD.getInterestDtls(oLoanRescheduleVO);
          LoanRescheduleBean oLoanRescheduleBean= (LoanRescheduleBean)oBaseHeaderBean;
          fedoForm.setTxtNewIntAmt(oLoanRescheduleBean.getTxtNewIntAmt());
          fedoForm.setTxtNewPrnAmt(oLoanRescheduleBean.getTxtNewPrnAmt());
          fedoForm.setTxtOutInt(oLoanRescheduleBean.getTxtOutInt());        
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);         
  }
  
}