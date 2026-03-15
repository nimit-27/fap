package FCIPAY.Payroll.WEBTIER.Action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.WEBTIER.Form.MaintEmpSuspensionForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrQueryVO;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpSuspensionBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpTrnsfrBD;
import FCIPAY.Payroll.WEBTIER.Form.EmpTrnsfrForm;


public class TrnsfrInvDtlsLovAction extends BaseAction
{
    public TrnsfrInvDtlsLovAction()
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
      
      EmpTrnsfrForm fedoForm = (EmpTrnsfrForm)oBaseForm;      
      EmpTrnsfrBD oEmpTrnsfrBD=(EmpTrnsfrBD)oBaseBD;
      lUserID = fedoForm.getLoginEmployeeNo();
      lUserID = fedoForm.getLoginLocCode();     
    
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        if(!(oBaseForm.getScreenName().equals("MaintainEmpFinDetailScreen")||oBaseForm.getScreenName().equals("MaintDeptLabourDetailScreen")||oBaseForm.getScreenName().equals("DPSInfoScreen")||oBaseForm.getScreenName().equals("NWNPInfoScreen")))
          throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }         
           
      UserSession oUser = getUserSessionBean(request);
      EmpTrnsfrQueryVO oEmpTrnsfrQueryVO=new EmpTrnsfrQueryVO();
      BeanUtils.copyProperties(oEmpTrnsfrQueryVO,form);        
      
      oEmpTrnsfrBD.getEmpInvDtlsComboDetails(request, oEmpTrnsfrQueryVO);      
      
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