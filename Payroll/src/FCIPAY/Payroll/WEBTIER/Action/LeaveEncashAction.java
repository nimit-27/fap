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

public class LeaveEncashAction extends BaseAction
{
  public LeaveEncashAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   
      if(sScreenName.equals("ComFinalSetScreen"))
      {
        ComFinalSetForm fedoForm = (ComFinalSetForm)oBaseForm;      
        LeaveEncashBD oLeaveEncashBD=new LeaveEncashBD();
        lUserID = fedoForm.getLoginEmployeeNo();
        lUserID = fedoForm.getLoginLocCode();
        //This is to set the application date to the sys date....
        //Added by Balpreet Dt 27 March 2008 for Final Payments
         fedoForm.setTxtApplnDt(fedoForm.getTxtDate());
          LeaveEncashQueryVO oLeaveEncashQueryVO=new LeaveEncashQueryVO();
          BeanUtils.copyProperties(oLeaveEncashQueryVO,form);
          
          ArrayList oArrayList = oLeaveEncashBD.getPayInfo(oLeaveEncashQueryVO);
          String sWage=(String)oArrayList.get(0);
          if(sWage.equals("0"))
          {
            fedoForm.setTxtNoAccELd("");
            throw new EnrgiseApplicationException("Pay.Payroll.LeaveEncash.Error",EnrgiseConstants.MESSAGE);
          }
          fedoForm.setHdnDayWage(sWage);
         // fedoForm.setHdnCpfDed((String)oArrayList.get(1));
        
      }
      else
      {
        LeaveEncashForm fedoForm = (LeaveEncashForm)oBaseForm;      
        LeaveEncashBD oLeaveEncashBD=(LeaveEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lUserID = fedoForm.getLoginLocCode();     

          LeaveEncashQueryVO oLeaveEncashQueryVO=new LeaveEncashQueryVO();
          BeanUtils.copyProperties(oLeaveEncashQueryVO,form);
          
          ArrayList oArrayList = oLeaveEncashBD.getPayInfo(oLeaveEncashQueryVO);
          String sWage=(String)oArrayList.get(0);
          if(sWage.equals("0"))
          {
            fedoForm.setTxtApplnDt("");
            throw new EnrgiseApplicationException("Pay.Payroll.LeaveEncash.Error",EnrgiseConstants.MESSAGE);
          }
          fedoForm.setHdnDayWage(sWage);
          fedoForm.setHdnCpfDed((String)oArrayList.get(1));
          if(fedoForm.getScreenMode().equals("N"))
          {
              fedoForm.setTxtEL("");
              fedoForm.setTxtEncshAmt("");
              fedoForm.setTxtNetAmt("");
          }
          
      }
        /*  if(oErrorCode.equals("DAARREAR_SUCCESS"))
          {
            fedoForm.setPayrollFlag("Y");
          }
          else
          {
            fedoForm.setPayrollFlag("N");
          }
          */
          
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
  
}