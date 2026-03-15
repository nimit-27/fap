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
import FCIPAY.Payroll.WEBTIER.Form.EmpMediBillsForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpMediBillsBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;

public class EmpMediBillsAction extends BaseAction
{
  public EmpMediBillsAction()
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
      
        EmpMediBillsForm fedoForm = (EmpMediBillsForm)oBaseForm;
        EmpMediBillsBD oEmpMediBillsBD=(EmpMediBillsBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String errMsg = oEmpMediBillsBD.sendInv(fedoForm.getHeaderPrimaryKey(),fedoForm.getHdnEmpLbrFlag(),lUserID,lSiteID);

        String [] errCode=errMsg.split(",",2);
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
        if(errCode[0].equals("0"))
        {
          throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
        
          
    //  return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
  
}