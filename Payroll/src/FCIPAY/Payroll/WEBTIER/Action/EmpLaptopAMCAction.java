// 
// Decompiled by Procyon v0.5.36
// 

package FCIPAY.Payroll.WEBTIER.Action;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import java.io.IOException;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.util.ArrayList;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpLaptopAMCBD;
import FCIPAY.Payroll.WEBTIER.Form.EmpLaptopAMCForm;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForward;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class EmpLaptopAMCAction extends BaseAction
{
    public ActionForward executeImpl(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException {
        final BaseForm oBaseForm = (BaseForm)form;
        final String sFormName = form.getClass().getName();
        final String sScreenName = oBaseForm.getScreenName();
        final BaseBD oBaseBD = this.getDetailBusinessDelegate(form);
        final BaseHeaderBean oBaseHeaderBean = this.getBaseHeaderBean(sFormName);
        long lUserID = 200L;
        long lSiteID = 200L;
        final String butAction = "";
        final EmpLaptopAMCForm fedoForm = (EmpLaptopAMCForm)oBaseForm;
        final EmpLaptopAMCBD oEmpLaptopAMCBD = (EmpLaptopAMCBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        final String errMsg = oEmpLaptopAMCBD.sendInv(fedoForm.getHeaderPrimaryKey(), fedoForm.getHdnEmpLbrFlag(), lUserID, lSiteID);
        final String[] errCode = errMsg.split(",", 2);
        final ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
        if (errCode[0].equals("0")) {
            throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS", oArguments);
        }
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR", oArguments);
    }
}
