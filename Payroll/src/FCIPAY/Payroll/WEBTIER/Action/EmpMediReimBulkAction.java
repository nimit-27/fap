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
import FCIPAY.Payroll.WEBTIER.Form.MediReimbursDtlsAllForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MediReimbursDtlsAllBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;

public class EmpMediReimBulkAction extends BaseAction
{
  public EmpMediReimBulkAction()
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
        String errMsg = "";
        ArrayList oArguments=new ArrayList();
        MediReimbursDtlsAllForm fedoForm = (MediReimbursDtlsAllForm)oBaseForm;
        MediReimbursDtlsAllBD oMediReimbursDtlsAllBD = (MediReimbursDtlsAllBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String payCode=fedoForm.getTxtPayCode();

        if(payCode.equals("138"))
          errMsg = oMediReimbursDtlsAllBD.sendInvBulk(fedoForm.getHdnEmpLbrFlag(),fedoForm.getyearMonth(),payCode,lUserID,lSiteID);
        else if(payCode.equals("195") || payCode.equals("132"))
          errMsg = oMediReimbursDtlsAllBD.sendInvBulk(fedoForm.getHdnEmpLbrFlag(),fedoForm.getFinYear(),payCode,lUserID,lSiteID);
        else
          errMsg = oMediReimbursDtlsAllBD.sendInv(fedoForm.getHdnEmpLbrFlag(),fedoForm.getQuarter(),fedoForm.getFinYear(),fedoForm.getMedicalDate(),lUserID,lSiteID);
     
        oArguments.add(new String(errMsg));
        throw new EnrgiseApplicationException("Payroll.MedicalBulk.sendInv",oArguments);
        /*if(errCode[0].equals("0"))
        {
          throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }*/
  }
}