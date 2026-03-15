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
import FCIPAY.Payroll.WEBTIER.Form.LeaveEncashForm;
import FCIPAY.Payroll.WEBTIER.Form.ComFinalSetForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaveEncashBD;
import FCIPAY.Payroll.UTILITY.LeaveEncashHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveEncashQueryVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.WEBTIER.Form.LTCEncashForm;
import FCIPAY.Payroll.WEBTIER.Form.OTAPymntForm;
import FCIPAY.Payroll.WEBTIER.Form.PayOverAboveForm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OTAPymntQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayOverAboveQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LTCEncashBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaveTravelConcessionBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayOverAboveBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.OTAPymntBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveTravelConcessionQueryVO;
import FCIPAY.Payroll.WEBTIER.Form.LeaveTravelConcessionForm;

public class DeleteOtherPayment extends BaseAction
{
  public DeleteOtherPayment()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();	  
      String aScreenAction = (String)(request.getParameter("param1"));
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   
	  String oMsg = "";
      
     if(aScreenAction.equalsIgnoreCase("leavencash"))
	  {
        LeaveEncashForm fedoForm = (LeaveEncashForm)oBaseForm;      
        LeaveEncashBD oLeaveEncashBD=(LeaveEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        //lUserID = fedoForm.getLoginLocCode();     
        LeaveEncashQueryVO oLeaveEncashQueryVO=new LeaveEncashQueryVO();
        BeanUtils.copyProperties(oLeaveEncashQueryVO,form);
        oMsg = oLeaveEncashBD.deleteLeaveEncashPayment(oLeaveEncashQueryVO);
          
	  }

	  if(aScreenAction.equalsIgnoreCase("ltcencash"))
	  {
        LTCEncashForm fedoForm = (LTCEncashForm)oBaseForm;      
        LTCEncashBD oLTCEncashBD=(LTCEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        //lUserID = fedoForm.getLoginLocCode();     
        LTCEncashQueryVO oLTCEncashQueryVO=new LTCEncashQueryVO();
        BeanUtils.copyProperties(oLTCEncashQueryVO,form);
        oMsg = oLTCEncashBD.deleteLTCEncashPayment(oLTCEncashQueryVO);
          
	  }

	   if(aScreenAction.equalsIgnoreCase("OTAPay"))
	  {
        OTAPymntForm fedoForm = (OTAPymntForm)oBaseForm;      
        OTAPymntBD oOTAPymntBD=(OTAPymntBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        //lUserID = fedoForm.getLoginLocCode();     
        OTAPymntQueryVO oOTAPymntQueryVO=new OTAPymntQueryVO();
        BeanUtils.copyProperties(oOTAPymntQueryVO,form);
        oMsg = oOTAPymntBD.deleteOTAPymnt(oOTAPymntQueryVO);
          
	  }
if (aScreenAction.equalsIgnoreCase("ltConcession")) {
            LeaveTravelConcessionForm fedoForm = (LeaveTravelConcessionForm)oBaseForm;
            LeaveTravelConcessionBD oLeaveTravelConcessionBD = (LeaveTravelConcessionBD)oBaseBD;
            lUserID = fedoForm.getLoginEmployeeNo();
            //lUserID = fedoForm.getLoginLocCode();
            LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO = new LeaveTravelConcessionQueryVO();
            BeanUtils.copyProperties(oLeaveTravelConcessionQueryVO, form);
            oMsg = oLeaveTravelConcessionBD.deleteLeaveTravelConcessionPayment(oLeaveTravelConcessionQueryVO);

        }
	    if(aScreenAction.equalsIgnoreCase("ovrNabv"))
	  {
        PayOverAboveForm fedoForm = (PayOverAboveForm)oBaseForm;      
        PayOverAboveBD oPayOverAboveBD=(PayOverAboveBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        //lUserID = fedoForm.getLoginLocCode();     
        PayOverAboveQueryVO oPayOverAboveQueryVO=new PayOverAboveQueryVO();
        BeanUtils.copyProperties(oPayOverAboveQueryVO,form);
        oMsg = oPayOverAboveBD.deletePayOverAbovePymnt(oPayOverAboveQueryVO);
          
	  }



          if(oMsg.equalsIgnoreCase("Success"))
          {            
            throw new EnrgiseApplicationException("Pay.Payroll.LeaveEncash.DeleteSuccess",EnrgiseConstants.MESSAGE);
          }
          else if(!oMsg.equalsIgnoreCase("Success")){
          throw new EnrgiseApplicationException("Pay.Payroll.LeaveEncash.Error.DeleteFailed",EnrgiseConstants.MESSAGE);          
          }
          
    
       
          
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
  
}