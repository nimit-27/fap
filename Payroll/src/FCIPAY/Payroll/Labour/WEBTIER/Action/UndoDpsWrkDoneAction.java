package FCIPAY.Payroll.Labour.WEBTIER.Action;
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
import FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDpsWrkDoneForm;
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.CalcDpsWrkDoneBD;
import FCIPAY.Payroll.Labour.Utility.CalcDpsWrkDoneHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class UndoDpsWrkDoneAction extends BaseAction 
{
  public UndoDpsWrkDoneAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      CalcDpsWrkDoneBD oCalcDpsWrkDoneBD=(CalcDpsWrkDoneBD)oBaseBD;
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   

      CalcDpsWrkDoneForm fedoForm = (CalcDpsWrkDoneForm)oBaseForm;
      lUserID = fedoForm.getLoginEmployeeNo();
      lSiteID = fedoForm.getLoginLocCode();
      String EmpLbrFlag = fedoForm.getHdnEmpLbrFlag().toString();
      BeanUtils.copyProperties(oBaseHeaderBean,form);      


      /* Added for Getting Current User */
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }
      /*End of Code */

      String sHdnVal = fedoForm.getHdnAction();
      if (sHdnVal.equals("SUB")) 
      {
          String oErrorCode = oCalcDpsWrkDoneBD.undoDpsWrkDone(lUserID,lSiteID,(CalcDpsWrkDoneHeaderBean)oBaseHeaderBean);
          fedoForm.setHdnAction("");
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(oErrorCode));
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
      else if (sHdnVal.equals("S")) 
      {
          if(EmpLbrFlag.equals("L"))
            throw new EnrgiseApplicationException("Pay.Lbr.UndoIncentive.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
          else  
            throw new EnrgiseApplicationException("Pay.Lbr.UndoWrkDone.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }      
           return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }
  
}