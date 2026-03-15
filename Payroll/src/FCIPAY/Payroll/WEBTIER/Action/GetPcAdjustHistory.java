package FCIPAY.Payroll.WEBTIER.Action;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainPensionBD;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPCDetailQueryVO;

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
import FCIPAY.Payroll.WEBTIER.Form.MaintPensionDetailForm;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

public class GetPcAdjustHistory extends BaseAction
{
  public GetPcAdjustHistory()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);

      MaintPensionDetailForm fedoForm = (MaintPensionDetailForm)oBaseForm;
      MaintainPensionBD oMaintainPCBD = (MaintainPensionBD)oBaseBD;
      long lUserID = fedoForm.getLoginEmployeeNo();
      long lSiteID = fedoForm.getLoginLocCode();
      MaintPCDetailQueryVO oMaintPCDetailQueryVO = new MaintPCDetailQueryVO();
      BeanUtils.copyProperties(oMaintPCDetailQueryVO,form);
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      oMaintPCDetailQueryVO.setUserId(lUserID);
      oMaintPCDetailQueryVO.setSiteId(lSiteID);
      fedoForm.setAdjHistHdrList(oMaintainPCBD.getPcAdjustHistoryHdr(oMaintPCDetailQueryVO));

      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);

  }   
}
