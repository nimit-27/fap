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
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class GetHeaderAction extends BaseAction
{
  public GetHeaderAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      
      BaseForm oBaseForm = (BaseForm)form;
      
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      BaseQueryVO oBaseQueryVO = getQueryVO(form); //Create new query vo instance
//      System.out.println("Class name " + oBaseQueryVO.getClass().getName());
       BaseBD oBaseBD ;
      
       if(sFormName.equals("FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm"))
      {
        oBaseBD = getDetailBusinessDelegate(form);
      }
      else
      {
        
        oBaseBD = getHeaderBusinessDelegate(form);  
      }
 
      BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
      oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
      UserSession oUser = getUserSessionBean(request);

     UserInfoBean obUserInfo = new UserInfoBean();      

     if(request.getSession().getAttribute("USERINFO")==null){}
      else{
      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
      oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
      oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
      }

      BaseHeaderVO oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
      if(oBaseHeaderVO.getTotalCount() == 0)
      {
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
        throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }

      if(oBaseHeaderVO.getTotalCount() > 0)
      {
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
      }      
      controlHeaderNavigation(oBaseForm);
      
      BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
      BeanUtils.copyProperties(form,oBaseHeaderVO);
      if(oBaseForm.getTotalCount() > 0)
      {
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
      }
     oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
     oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
     if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
    {
          oBaseForm.setScreenMode("Q");
    }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}