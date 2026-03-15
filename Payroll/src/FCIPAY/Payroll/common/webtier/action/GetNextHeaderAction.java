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
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class GetNextHeaderAction  extends BaseAction
{
  public GetNextHeaderAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, EnrgiseSystemException, EnrgiseApplicationException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException
  {
      BaseForm oBaseForm = (BaseForm)form;
      
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      UserSession oUser = getUserSessionBean(request);
      checkHeaderNavigation(oBaseForm,oUser.getBaseHeaderVO(sFormName));
      BaseBD oBaseBD ;
      
       if(sFormName.equals("FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm"))
      {
        oBaseBD = getDetailBusinessDelegate(form);
      }
      else
      {
        
        oBaseBD = getHeaderBusinessDelegate(form);  
      }
  
      BaseQueryVO oBaseQueryVO = oUser.getBaseQueryVO(sFormName); //Create new query vo instance
      BaseHeaderVO oBaseHeaderVO = oBaseBD.getNextHeaderRecord(oBaseQueryVO,oBaseForm.getPositionRequested(),sFormName,false,oUser);// Get header record
      int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
      BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
      oBaseForm.setTotalDetailRecord(0);
      clearDetailLists(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailList(sFormName));
      oBaseForm.setDetailStartPage(0);
      BeanUtils.copyProperties(form,oBaseHeaderVO);
      oBaseForm.setNewPositionRequested(null);

      oBaseForm.setPageRequested(0);
      oBaseForm.setTotalPageCount(0);
      
      controlHeaderNavigation(oBaseForm);      
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}