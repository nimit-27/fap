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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PostYrEndRemitToAPBD;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PostYrEndRemitToAPForm;

public class PostYrEndRemitToAPAction extends BaseAction
{
    public PostYrEndRemitToAPAction()
    {
    }
    public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
    {
        BaseForm oBaseForm = (BaseForm)form;
        String sFormName = form.getClass().getName(); //Get fully qualified form class
        String sScreenName = oBaseForm.getScreenName();
        BaseBD oBaseBD = getDetailBusinessDelegate(form);
        long lUserID = 200;
        long lSiteID = 200;
        UserInfoBean obUserInfo = new UserInfoBean();
        if(request.getSession().getAttribute("USERINFO")==null){}
        else
        {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
        }
        PostYrEndRemitToAPForm fedoForm = (PostYrEndRemitToAPForm)oBaseForm;
        PostYrEndRemitToAPBD oPostYrEndRemitToAPBD=(PostYrEndRemitToAPBD)oBaseBD;
        String sHdnVal = fedoForm.getHdnAction();
        String invoice_date = fedoForm.getTxtInvDt();
        String sBtnFlag = fedoForm.getBtnFlag();
        fedoForm.setFormFlag("Second");
        if (sBtnFlag.equals("OP"))
        {
            if (sHdnVal.equals("SUB")) 
            {
                String oErrorCode = oPostYrEndRemitToAPBD.PostOthrPayments(lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag(),invoice_date); 
                fedoForm.setHdnAction("");
                fedoForm.setTxtInvDt(invoice_date);
                fedoForm.setFormFlag("Second");
                if(oErrorCode.equals("INACTIVE"))
                {
                    throw new EnrgiseApplicationException("PAY.Remittance.INACTIVE.ALREADY",EnrgiseConstants.MESSAGE);
                }
                ArrayList oArguments = new ArrayList();
                oArguments.add(new String(oErrorCode));
                throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
            }
            else if (sHdnVal.equals("S")) 
            {
                throw new EnrgiseApplicationException("Pay.Remit.To.AP.Posting.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
            } 
        }
        else if (sBtnFlag.equals("SAL"))
        {
            if (sHdnVal.equals("SUB")) 
            {
                String oErrorCode = oPostYrEndRemitToAPBD.PostRemitSalary(lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag(),invoice_date); 
                fedoForm.setHdnAction("");
                fedoForm.setTxtInvDt(invoice_date);
                fedoForm.setFormFlag("Second");
                if(oErrorCode.equals("INACTIVE"))
                {
                    throw new EnrgiseApplicationException("PAY.Remittance.INACTIVE.ALREADY",EnrgiseConstants.MESSAGE);
                }
                ArrayList oArguments = new ArrayList();
                oArguments.add(new String(oErrorCode));
                throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
            }
            else if (sHdnVal.equals("S")) 
            {
                throw new EnrgiseApplicationException("Pay.Remit.To.AP.Posting.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
            } 
        }
        
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
    }
}