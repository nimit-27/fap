package FCIPAY.Payroll.WEBTIER.Action;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PensionFinalSettBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PensionFinalSettQueryVO;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.UTILITY.PensionFinalSettBean;
import FCIPAY.Payroll.WEBTIER.Form.PensionFinalSettForm;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

import FCIPAY.Payroll.common.webtier.form.BaseForm;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PensionPaymentAction  extends BaseAction{
    
    public PensionPaymentAction() {
     
    }

    public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException{

    BaseForm oBaseForm = (BaseForm)form;      
    String sFormName = form.getClass().getName(); //Get fully qualified form class
    String sScreenName = oBaseForm.getScreenName();
    BaseBD oBaseBD = getDetailBusinessDelegate(form);
    BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
    BaseHeaderVO oBaseHeaderVO = null;
    UserSession oUser = getUserSessionBean(request);
    PensionFinalSettBD oPensionFinalSettBD = null;
    long lUserID = 200;
    long lSiteID = 200;
    String butAction = "";   
    String errMsg = "";
    ArrayList list=new ArrayList();
    PensionFinalSettForm fedoForm = (PensionFinalSettForm)oBaseForm;    
    
    oPensionFinalSettBD=(PensionFinalSettBD)oBaseBD;
    
    
    lUserID = fedoForm.getLoginEmployeeNo();
    lSiteID = fedoForm.getLoginLocCode();
    BeanUtils.copyProperties(oBaseHeaderBean,form);
    BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(lUserID) );
    BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(lSiteID) );
    String hdnAction=fedoForm.getHdnAction();
    if(hdnAction.equals("getFinalDtls"))
    {
        PensionFinalSettQueryVO oPensionFinalSettQueryVO=new PensionFinalSettQueryVO();
        BeanUtils.copyProperties(oPensionFinalSettQueryVO,form);
        oPensionFinalSettQueryVO.setUserId(lUserID);
        list = oPensionFinalSettBD.getFinalDtls(oPensionFinalSettQueryVO);
        PensionFinalSettBean oPensionFinalSettBean= (PensionFinalSettBean)list.get(0);
        fedoForm.setEmpContri(oPensionFinalSettBean.getEmpContri());
        fedoForm.setEmplyrContri(oPensionFinalSettBean.getEmplyrContri());
        fedoForm.setTxtVPFCont(oPensionFinalSettBean.getTxtVPFCont());
        fedoForm.setTxtTotalInt(oPensionFinalSettBean.getTxtTotalInt());
        fedoForm.setSancAmount(oPensionFinalSettBean.getSancAmount());
       // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
    }
    return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);         
}
}
