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
import FCIPAY.Payroll.WEBTIER.Form.MaintEmpPenalityForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpPenalityBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPenalityQueryVO;

public class PenaltyWaiveOffAction extends BaseAction
{
  public PenaltyWaiveOffAction()
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
      
      String butAction = "";   
      MaintEmpPenalityForm fedoForm = (MaintEmpPenalityForm)oBaseForm;      
      EmpPenalityBD oEmpPenalityBD = (EmpPenalityBD)oBaseBD;
      EmpPenalityQueryVO oEmpPenalityQueryVO = new EmpPenalityQueryVO();
      long lUserID = fedoForm.getLoginEmployeeNo();
      long lSiteID = fedoForm.getLoginLocCode();
      BeanUtils.copyProperties(oEmpPenalityQueryVO,form);
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      oEmpPenalityQueryVO.setUserId(lUserID);
      oEmpPenalityQueryVO.setSiteId(lSiteID);
      String hdnAction=fedoForm.getHdnAction();
      if(hdnAction.equals("WAIVEOFF"))
      {
          String sErrCode = oEmpPenalityBD.penaltyWaiver(oEmpPenalityQueryVO);
          if(sErrCode.equals("0"))
          {
            fedoForm.setTxtWaiveFlg("W");
            throw new EnrgiseApplicationException("Pay.PenaltyWaive_SUCCESS",EnrgiseConstants.MESSAGE);
          }
          else
          {
            throw new EnrgiseApplicationException("Pay.PenaltyWaive_ERROR",EnrgiseConstants.MESSAGE);
          }
      }
      else if(hdnAction.equals("INCRSTOP"))
      {
          String sErrCode = oEmpPenalityBD.incrementStop(oEmpPenalityQueryVO);
          if(sErrCode.equals("0"))
          {
            fedoForm.setTxtWaiveFlg("W");
            throw new EnrgiseApplicationException("Pay.PenaltyIncrStop_SUCCESS",EnrgiseConstants.MESSAGE);
          }
          else
          {
            throw new EnrgiseApplicationException("Pay.PenaltyIncrStop_ERROR",EnrgiseConstants.MESSAGE);
          }
      }
      else
      {
          return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
      }
      
  }
}