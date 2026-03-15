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
import FCIPAY.Payroll.WEBTIER.Form.LTCEncashForm;
import FCIPAY.Payroll.WEBTIER.Form.OTAPymntForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaveEncashBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LTCEncashBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaveTravelConcessionBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.OTAPymntBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveEncashQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OTAPymntQueryVO;
//LTC
import FCIPAY.Payroll.WEBTIER.Form.LeaveTravelConcessionForm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveTravelConcessionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

public class ITaxOverAbvSalAction extends BaseAction
{
  public ITaxOverAbvSalAction()
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
      if(sScreenName.equals("LeaveEncashScreen"))
      {
        LeaveEncashForm fedoForm = (LeaveEncashForm)oBaseForm;      
        LeaveEncashBD oLeaveEncashBD=(LeaveEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lUserID = fedoForm.getLoginLocCode();     

          LeaveEncashQueryVO oLeaveEncashQueryVO=new LeaveEncashQueryVO();
          BeanUtils.copyProperties(oLeaveEncashQueryVO,form);
          
          ArrayList oArrayList = oLeaveEncashBD.getITDed(oLeaveEncashQueryVO);
          String sFlag=(String)oArrayList.get(0);
        
           fedoForm.setHdnFlagIT(sFlag);
      }
      if(sScreenName.equals("LTCEncashScreen"))
      {
        LTCEncashForm fedoForm = (LTCEncashForm)oBaseForm;      
        LTCEncashBD oLTCEncashBD=(LTCEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lUserID = fedoForm.getLoginLocCode();     

          LTCEncashQueryVO oLTCEncashQueryVO=new LTCEncashQueryVO();
          BeanUtils.copyProperties(oLTCEncashQueryVO,form);
          
          ArrayList oArrayList = oLTCEncashBD.getITDed(oLTCEncashQueryVO);
          String sFlag=(String)oArrayList.get(0);
        
           fedoForm.setHdnFlagIT(sFlag);
      }
      if(sScreenName.equals("OTAPymntScreen")|| sScreenName.equals("DepOTAPymntScreen"))
      {
        OTAPymntForm fedoForm = (OTAPymntForm)oBaseForm;      
        OTAPymntBD oOTAPymntBD=(OTAPymntBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lUserID = fedoForm.getLoginLocCode();     

          OTAPymntQueryVO oOTAPymntQueryVO=new OTAPymntQueryVO();
          BeanUtils.copyProperties(oOTAPymntQueryVO,form);
          
          ArrayList oArrayList = oOTAPymntBD.getITDed(oOTAPymntQueryVO);
          String sFlag=(String)oArrayList.get(0);
        
           fedoForm.setHdnFlagIT(sFlag);
          ArrayList oDetailList = getDetailArray(oBaseForm);
          BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailList);

      }          
      if(sScreenName.equals("LeaveTravelConcessionScreen"))
      {
        LeaveTravelConcessionForm fedoForm = (LeaveTravelConcessionForm)oBaseForm;      
        LeaveTravelConcessionBD oLeaveTravelConcessionBD=(LeaveTravelConcessionBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lUserID = fedoForm.getLoginLocCode();     

          LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO=new LeaveTravelConcessionQueryVO();
          BeanUtils.copyProperties(oLeaveTravelConcessionQueryVO,form);
          
          ArrayList oArrayList = oLeaveTravelConcessionBD.getITDed(oLeaveTravelConcessionQueryVO);
          String sFlag=(String)oArrayList.get(0);
        
           fedoForm.setHdnFlagIT(sFlag);
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
  
}