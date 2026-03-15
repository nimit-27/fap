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
import FCIPAY.Payroll.WEBTIER.Form.PerformMonthEndUpdateForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GetDescriptionBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MonthEndUpdateBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class GetUserAction extends BaseAction
{
  public GetUserAction()
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
      //DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      //oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      //oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = null;
      long lPageRequested = 1;
      boolean bLimitReached = false;
      ArrayList oDetailList = null;


      if(oBaseDetailVO != null)
      {
        // Detail exists check if save required
        if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
        {
          if(oBaseDetailVO.getOThisPageData() != null)
          {
              oDetailList = getDetailArray(oBaseForm);
          }
          else
          {
            oBaseDetailVO.setOThisPageData(new ArrayList());
          }
        }
    }

//      oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);              

      //oBaseDetailBean = getDetailBean(form);

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
      }


      if(oDetailList != null)
      {
//        oDetailList.add(oBaseDetailBean);
        oBaseDetailVO.setOThisPageData(oDetailList);
      }

//      oBaseDetailVO.getOAllPageData().add(oBaseDetailBean);
      if(oDetailList != null)
      {
        oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
        oBaseForm.setDetailDataChanged(true);
        BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
        BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());       
      }    
      
    if (sScreenName.equals("MonthUpdateScreen")) 
    {
        PerformMonthEndUpdateForm oExForm = (PerformMonthEndUpdateForm)form;  
        
        if (oExForm.getHdnAction().equals("EMPTJ"))
        {
            MonthEndUpdateBD oMonthEndUpdateBD =(MonthEndUpdateBD)oBaseBD;
            String totEmpWaitingToJoin = oMonthEndUpdateBD.getEmpWaitingToJoin(lUserId,lSiteId);
            oExForm.setTxtEmpWaitJoin(totEmpWaitingToJoin);
        }                
    }
  
//      UserSession oUser = getUserSessionBean(request);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);                
  }
}