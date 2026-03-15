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
import FCIPAY.Payroll.common.webtier.action.BaseAction;

import FCIPAY.Payroll.WEBTIER.Form.OTAPymntForm;

public class GetTabAction extends BaseAction
{
  public GetTabAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      /*if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        if(!(oBaseForm.getScreenName().equals("MaintainEmpFinDetailScreen")||oBaseForm.getScreenName().equals("MaintDeptLabourDetailScreen")||oBaseForm.getScreenName().equals("DPSInfoScreen")))
          throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }   */
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      if(sScreenName.equals("OTAPymntScreen") || (sScreenName.equals("OTAPymntDedScreen")))
      {
        OTAPymntForm fedoForm = (OTAPymntForm)oBaseForm;
        fedoForm.getLstInstrDtls().clear();
        fedoForm.getLstInstrDtlsDed().clear();
      }     
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      UserSession oUser = getUserSessionBean(request);
      String sForwardedPage = oBaseForm.getForwardedPage();
      if(sForwardedPage != null)
      {
        return mapping.findForward(sForwardedPage);
      }
      else
      {
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }
  }
}