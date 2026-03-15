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
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.WEBTIER.Form.MaintainExternalSavingsForm;
import FCIPAY.Payroll.WEBTIER.Form.PaySlipReportForm;
import FCIPAY.Payroll.WEBTIER.Form.MaintainDirectPayrollForm;
import FCIPAY.Payroll.WEBTIER.Form.MaintainInternalSavingsForm;
import FCIPAY.Payroll.WEBTIER.Form.PayITForecastForm;
import FCIPAY.Payroll.WEBTIER.Form.PayITForecastProjForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GetDescriptionBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainExternalSavingsBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainDirectPayrollBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainInternalSavingsBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayReportBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class GetReportAction extends BaseAction
{
  public GetReportAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {  

      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      UserSession oUser = getUserSessionBean(request);
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = null;
      long lPageRequested = 1;
      boolean bLimitReached = false;
      ArrayList oDetailList = null;
      

      long lUserId = 0;
      long lSiteId = 0; 
      String sUserName = ""; 

      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
      lUserId = obUserInfo.getLEmployeeNo();
      lSiteId = obUserInfo.getLLocationCode();
      sUserName = obUserInfo.getSEmployeeName();
      
      oBaseForm.setLoginEmployeeNo(lUserId);
      oBaseForm.setLoginLocCode(lSiteId);
      oBaseForm.setLoginEmployeeName(sUserName);
      oBaseForm.setLoginEmployeelocation(obUserInfo.getSEmpLocation());
      oBaseForm.setLocTyp(obUserInfo.getSSubLocation());

      }


   if (sScreenName.equals("PFFinalBillReport") || sScreenName.equals("HRAReportScreen") || sScreenName.equals("PLIReportScreen")) 
    {
      //  PFFinalBillRepForm oPFFinalBillRepForm = (PFFinalBillRepForm)form;
        oBaseBD.getComboDetails(request);
    }

   if (sScreenName.equals("SCRRep")) 
    {
      //  PFFinalBillRepForm oPFFinalBillRepForm = (PFFinalBillRepForm)form;
        oBaseBD.getComboDetails(request);
    }

 /* if (sScreenName.equals("PayITForecastReport")) 
    {
        PayITForecastForm oPayITForecastForm = (PayITForecastForm)form;             
        PayReportBD oPayReportBD =(PayReportBD)oBaseBD;
        String sAccPriv = oPayReportBD.sGetITForecastAcc(lUserId);           
        oPayITForecastForm.setHdnPayUser(sAccPriv);
        oPayITForecastForm.setHdnLocation("00000");                
        oPayITForecastForm.setHdnLoginUserId(String.valueOf(lUserId));
        oPayITForecastForm.setHdnLoginUserName(sUserName);
        oPayITForecastForm.setScreenMode("Q");
        String sYYMM = oPayReportBD.sGetCurYYMM(); 
        oPayITForecastForm.setTxtYYMM(sYYMM);        
    } */

    if (sScreenName.equals("PayITForecastProjReport")) 
    {
        PayITForecastProjForm oPayITForecastProjForm = (PayITForecastProjForm)form;             
        PayReportBD oPayReportBD =(PayReportBD)oBaseBD;
//        String sAccPriv = oPayReportBD.sGetITForecastAcc(lUserId);           
        oPayITForecastProjForm.setHdnPayUser("N");
        oPayITForecastProjForm.setScreenMode("Q");  
        oPayITForecastProjForm.setHdnLocation("00000");        
        oPayITForecastProjForm.setHdnLoginUserId(String.valueOf(lUserId));
        oPayITForecastProjForm.setHdnLoginUserName(sUserName);
        String sMaxYYMM = oPayReportBD.sGetMaxITForecastYYMM(lUserId);           
        oPayITForecastProjForm.setTxtYYMM(sMaxYYMM);
    }    
    
       oBaseForm.setScreenMode("Q");
//      UserSession oUser = getUserSessionBean(request);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);                
  }
}