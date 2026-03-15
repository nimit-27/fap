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
import FCIPAY.Payroll.WEBTIER.Form.UndoPayrollForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.UndoPayrollTranBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

public class UndoPayTransAction extends BaseAction
{
  public UndoPayTransAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      //BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      UndoPayrollTranBD oUndoPayrollTranBD= new UndoPayrollTranBD();
      String butAction = "";   
      UndoPayrollForm fedoForm = (UndoPayrollForm)oBaseForm;
      String dflag = fedoForm.getDeFlag();
      String empNum = fedoForm.getTxtEmpNum();
      long loginUserId = 100;
      long lLoginSiteId = 100;
      String hdnEmpLbrFlag="";
      //BeanUtils.copyProperties(oBaseHeaderBean,form);      

      loginUserId = fedoForm.getLoginEmployeeNo();
      lLoginSiteId = fedoForm.getLoginLocCode();
      hdnEmpLbrFlag=fedoForm.getHdnEmpLbrFlag();

          String oErrorCode = oUndoPayrollTranBD.undoPayrollTran(dflag,empNum,loginUserId,lLoginSiteId,hdnEmpLbrFlag);


          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(oErrorCode));
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);

      //return mapping.findForward(EnrgiseConstants.SUCCESS);              

  }
  
}