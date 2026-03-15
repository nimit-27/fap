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
//import FCIPAY.Payroll.UTILITY.LoanRescheduleBean;
import FCIPAY.Payroll.UTILITY.PLIForeclosureBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIForeclosureVO;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PLIForeclosureBD;
import FCIPAY.Payroll.WEBTIER.Form.PLIForeclosureForm;

public class PLIForeclosureAction extends BaseAction
{
  public PLIForeclosureAction()
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
      PLIForeclosureForm fedoForm = ( PLIForeclosureForm)oBaseForm;      
       PLIForeclosureBD oPLIForeclosureBD=new PLIForeclosureBD();
     // lUserID = fedoForm.getLoginEmployeeNo();
   //   lSiteID = fedoForm.getLoginLocCode();
    BeanUtils.copyProperties(oBaseHeaderBean,form);
  //    BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(lUserID) );
  //   BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(lSiteID) );
   
      String hdnAction=fedoForm.getHdnAction();
     //  String hdnAction=fedoForm.getHdnAction();
      if(hdnAction.equals("getDtls"))
      {
          PLIForeclosureVO oPLIForeclosureVO=new  PLIForeclosureVO();
          BeanUtils.copyProperties(oPLIForeclosureVO,form);
         // oLoanRescheduleVO.setUserId(lUserID);
          oBaseHeaderBean = oPLIForeclosureBD.getPLIForeclosureDtls(oPLIForeclosureVO);
         PLIForeclosureBean oPLIForeclosureBean= (PLIForeclosureBean)oBaseHeaderBean;
          fedoForm.setTxtPLIAmt(oPLIForeclosureBean.getTxtPLIAmt());
        //  fedoForm.setTxtPrnInstalNo(oPLIForeclosureBean.getTxtPrnInstalNo());
          //fedoForm.setTxtIntInstalNo(oPLIForeclosureBean.getTxtIntInstalNo());
        //  fedoForm.setTxtPaidIntAmt(oPLIForeclosureBean.getTxtPaidIntAmt());
         // fedoForm.setTxtBalPrnInstal(oPLIForeclosureBean.getTxtBalPrnInstal());
          //fedoForm.setTxtBalIntInstal(oPLIForeclosureBean.getTxtBalIntInstal());
        //  fedoForm.setTxtMonPrnAmt(oPLIForeclosureBean.getTxtMonPrnAmt());
         // fedoForm.setTxtMonIntAmt(oPLIForeclosureBean.getTxtMonIntAmt());
          //fedoForm.setTxtPaidPrn(oPLIForeclosureBean.getTxtPaidPrn());
          //fedoForm.setTxtPaidInt(oPLIForeclosureBean.getTxtPaidInt());
        //  fedoForm.setIntrstIntrvngPrd(oLoanRescheduleBean.getIntrstIntrvngPrd());
        //  fedoForm.setTdsIntIntrvngPrd(oLoanRescheduleBean.getTdsIntIntrvngPrd());
        //  fedoForm.setSancAmount(oLoanRescheduleBean.getSancAmount());
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      
      
   
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);         
  }
  
}
