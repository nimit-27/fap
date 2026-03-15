package FCIPAY.Payroll.common.webtier.action;
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
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import javax.servlet.http.HttpSession;
import FCIPAY.Payroll.WEBTIER.Form.MaintainExternalSavingsForm;
import FCIPAY.Payroll.WEBTIER.Form.MaintEmpPromotionForm6Pay;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainExternalSavingsBD;
public class QueryModeAction extends BaseAction
{
  public QueryModeAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();

      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      /* Added for Displaying Current User */
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else
      {
      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
      oBaseForm.setLoginEmployeeNo(obUserInfo.getLEmployeeNo());
      oBaseForm.setLoginLocCode(obUserInfo.getLLocationCode());
      oBaseForm.setLoginEmployeeName(obUserInfo.getSEmployeeName());
      oBaseForm.setLoginEmployeelocation(obUserInfo.getSEmpLocation());

      /*
        Added By Arunava
      */
      BaseBD oBaseBD ;
      
       if(sFormName.equals("FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm"))
      {
        oBaseBD = getDetailBusinessDelegate(form);
      }
      else
      {
        
        oBaseBD = getHeaderBusinessDelegate(form);  
      }
          
      oBaseBD.getComboDetails(request);// Get header Combo record      
      oBaseBD.getDetailComboDetails(request);// Get Detail Combo record  
      /*
        Added By Arunava
      */         
      // Added to get the current Payroll Year month.
      String hdnEmpLbrFlag =(String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
      if(hdnEmpLbrFlag== null)
      {
        hdnEmpLbrFlag="";
      }
      
      oBaseForm.setScreenMode("E");
      String payYYMM=oBaseBD.getMaxPayYear(oBaseForm.getLoginLocCode(),hdnEmpLbrFlag);
      if(payYYMM== null)
      {
        payYYMM="";
      }
      oBaseForm.setPayYYMM(payYYMM);

      if (sScreenName!=null && sScreenName.equals("ExternalScreen")) 
      {
        MaintainExternalSavingsForm oExForm = (MaintainExternalSavingsForm)oBaseForm;   
        MaintainExternalSavingsBD oMaintainExternalSavingsBD = new MaintainExternalSavingsBD(); 
        String sFinYear = oMaintainExternalSavingsBD.getFinalYear(oExForm.getLoginLocCode(),oExForm.getHdnEmpLbrFlag());           
        oExForm.setHdnFinYYMM(sFinYear);                        
      }  
      
    }
      /*End of Code */      
        changeMode(oBaseForm,request);
      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}

