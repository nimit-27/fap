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
import FCIPAY.Payroll.WEBTIER.Form.InitPayDataForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.ChangeZoneBD;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import FCIPAY.Payroll.WEBTIER.Form.ParrentZoneChngForm;

public class DataSaveAction extends BaseAction 
{
    public DataSaveAction()
    {
    }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
    BaseForm oBaseForm = (BaseForm)form;      
    PayrollBaseForm oPayrollBaseForm = (PayrollBaseForm)form;
    String sFormName = form.getClass().getName(); //Get fully qualified form class
    String sScreenName = oBaseForm.getScreenName();
    BaseBD oBaseBD = getDetailBusinessDelegate(form);
    BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
    String butFlag = "";
     ParrentZoneChngForm fedoForm = (ParrentZoneChngForm)oBaseForm;
      String sHdnVal = fedoForm.getHdnAction();
    BeanUtils.copyProperties(oBaseHeaderBean,form);  
    //butFlag = oPayrollBaseForm.getButtonFlag();
    if (sHdnVal.equals("S")) 
    {
       throw new EnrgiseApplicationException("DataSave.Payroll.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
    }      
    return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }
}