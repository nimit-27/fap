package FCIPAY.Payroll.Labour.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.MaintKotWrkSlipBD;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class KotWrkSlipAction extends BaseAction
{
  public KotWrkSlipAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      MaintKotWrkSlipBD oBaseBD = new MaintKotWrkSlipBD();
    //  UserSession oUser = getUserSessionBean(request);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      ArrayList oDetailBeanArray = null;
      BaseDetailVO oBaseDetailVO = null;
      BaseHeaderVO oBaseHeaderVO = null;
      Timestamp oHeaderPicked = null;
      Timestamp oDetailPicked = null;
      
      if(!oBaseForm.isDetailDataChanged() && !oBaseForm.isHeaderDataChanged())
      {
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }
      
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      
  /*    if(oBaseForm.getScreenMode().equals(EnrgiseConstants.NEW_MODE))
      {
        oHeaderPicked = null;
      }
      else
      {  */
        if(oBaseForm.isHeaderDataChanged())
        {
      //    oBaseHeaderVO = oUser.getBaseHeaderVO(sFormName);
          if(oBaseHeaderVO != null)
          {
            oHeaderPicked = oBaseHeaderVO.getOWhenPicked();
            oBaseHeaderBean = getBaseHeaderBean(sFormName);
          }
          BeanUtils.copyProperties(oBaseHeaderBean,form);
        }
        
          if(oBaseDetailVO != null)
          {
            oDetailPicked = oBaseDetailVO.getOWhenPicked();
          }

        if(oBaseForm.isDetailDataChanged())
        {
          oDetailBeanArray = getDetailArray(oBaseForm);
        }
      
      
    /* Added By Payroll Team for Passing USERID and SITEID  */
      long userId = oBaseForm.getLoginEmployeeNo();
      long siteId = oBaseForm.getLoginLocCode();

      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );

    /* End of Code By Payroll Team for Passing USERID and SITEID  */
      
      oDetailBeanArray = oBaseBD.calcIncentive(oBaseHeaderBean,oBaseForm.getScreenName(),oDetailBeanArray);
 //     oBaseForm.setHeaderDataChanged(false);
 //     oBaseForm.setDetailDataChanged(false);
 
       BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailBeanArray);
       
      
    //  oBaseForm.setScreenMode(EnrgiseConstants.UPDATE_MODE);            
   /*   if (sScreenName.equals("MaintainEmpFinDetailScreen"))
      {   
        oBaseForm.setScreenMode("U");    
      }
      if (sScreenName.equals("TransferScreen"))
      {   
        oBaseForm.setScreenMode("U");    
      }
*/
     // throw new EnrgiseApplicationException("Payroll.EmpLeave.CancelSuccess",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
     return mapping.findForward(EnrgiseConstants.SUCCESS);
  }
}