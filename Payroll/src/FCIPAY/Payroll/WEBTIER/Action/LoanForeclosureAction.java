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
import FCIPAY.Payroll.UTILITY.LoanForeclosureBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanForeclosureVO;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LoanForeclosureBD;
import FCIPAY.Payroll.WEBTIER.Form.LoanForeclosureForm;

public class LoanForeclosureAction extends BaseAction
{
  public LoanForeclosureAction()
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
      LoanForeclosureForm fedoForm = ( LoanForeclosureForm)oBaseForm;      
     LoanForeclosureBD oLoanForeclosureBD=new LoanForeclosureBD();
     // lUserID = fedoForm.getLoginEmployeeNo();
   //   lSiteID = fedoForm.getLoginLocCode();
    BeanUtils.copyProperties(oBaseHeaderBean,form);
  //    BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(lUserID) );
  //   BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(lSiteID) );
   
      String hdnAction=fedoForm.getHdnAction();
     //  String hdnAction=fedoForm.getHdnAction();
      if(hdnAction.equals("getDtls"))
      {
          LoanForeclosureVO oLoanForeclosureVO=new  LoanForeclosureVO();
          BeanUtils.copyProperties(oLoanForeclosureVO,form);
         // oLoanRescheduleVO.setUserId(lUserID);
          oBaseHeaderBean = oLoanForeclosureBD.getLoanForeclosureDtls(oLoanForeclosureVO);
         LoanForeclosureBean oLoanForeclosureBean= (LoanForeclosureBean)oBaseHeaderBean;
          fedoForm.setTxtLoanAmt(oLoanForeclosureBean.getTxtLoanAmt());
          fedoForm.setTxtPrnInstalNo(oLoanForeclosureBean.getTxtPrnInstalNo());
          fedoForm.setTxtIntInstalNo(oLoanForeclosureBean.getTxtIntInstalNo());
        //  fedoForm.setTxtPaidIntAmt(oLoanForeclosureBean.getTxtPaidIntAmt());
          fedoForm.setTxtBalPrnInstal(oLoanForeclosureBean.getTxtBalPrnInstal());
          fedoForm.setTxtBalIntInstal(oLoanForeclosureBean.getTxtBalIntInstal());
          fedoForm.setTxtMonPrnAmt(oLoanForeclosureBean.getTxtMonPrnAmt());
          fedoForm.setTxtMonIntAmt(oLoanForeclosureBean.getTxtMonIntAmt());
          fedoForm.setTxtPaidPrn(oLoanForeclosureBean.getTxtPaidPrn());
          fedoForm.setTxtPaidInt(oLoanForeclosureBean.getTxtPaidInt());
        //  fedoForm.setIntrstIntrvngPrd(oLoanRescheduleBean.getIntrstIntrvngPrd());
        //  fedoForm.setTdsIntIntrvngPrd(oLoanRescheduleBean.getTdsIntIntrvngPrd());
        //  fedoForm.setSancAmount(oLoanRescheduleBean.getSancAmount());
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      
      
     if(hdnAction.equals("CalcInt"))
      {
          LoanForeclosureVO oLoanForeclosureVO=new  LoanForeclosureVO();
          BeanUtils.copyProperties(oLoanForeclosureVO,form);
         // oLoanRescheduleVO.setUserId(lUserID);
          oBaseHeaderBean = oLoanForeclosureBD.getForecloseInterestDtls(oLoanForeclosureVO);
        LoanForeclosureBean oLoanForeclosureBean= (LoanForeclosureBean)oBaseHeaderBean;
          fedoForm.setTxtPaidInt(oLoanForeclosureBean.getTxtPaidInt());
          fedoForm.setTxtPaidPrn(oLoanForeclosureBean.getTxtPaidPrn());
        //  fedoForm.setTxtPaidPrnAmt(oLoanRescheduleBean.getTxtPaidPrnAmt());
        //  fedoForm.setTxtPaidIntAmt(oLoanRescheduleBean.getTxtPaidIntAmt());
        //  fedoForm.setIntrstEmplyrContri(oLoanRescheduleBean.getIntrstEmplyrContri());
        //  fedoForm.setIntrstVpfContri(oLoanRescheduleBean.getIntrstVpfContri());
        //  fedoForm.setIntrstIntrvngPrd(oLoanRescheduleBean.getIntrstIntrvngPrd());
        //  fedoForm.setTdsIntIntrvngPrd(oLoanRescheduleBean.getTdsIntIntrvngPrd());
        //  fedoForm.setSancAmount(oLoanRescheduleBean.getSancAmount());
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);         
  }
  
}
