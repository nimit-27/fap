package FCIPAY.Payroll.Labour.WEBTIER.Action;
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
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.MaintGangBD;
import FCIPAY.Payroll.Labour.Utility.MaintGangHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;
import FCIPAY.Payroll.Labour.Utility.MaintGangBean;

public class GangUpdateRowAction extends BaseAction
{
    public GangUpdateRowAction()
    {
    }
    
    public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
  System.out.println("start action");
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      ArrayList oArguments = new ArrayList();
      String oMsg = "";
      UserSession oUser = getUserSessionBean(request);
      BaseDetailBean oBaseDetailBean = null;
      ArrayList oDetailBeanArray = getDetailArray(oBaseForm);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
       long userId = oBaseForm.getLoginEmployeeNo();
      long siteId = oBaseForm.getLoginLocCode();

      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
      MaintGangBD oMaintGangBD= new MaintGangBD();
      oMsg = oMaintGangBD.updateGangRow( (PayrollBaseHeaderBean)oBaseHeaderBean, oDetailBeanArray);
         System.out.println("end action");
           System.out.println(oMsg);
      oArguments.add(new String(oMsg));     
      //MaintGangBean oMaintGangBean = (MaintGangBean)oBaseHeaderBean;
//BeanUtils.copyProperties(form,oBaseHeaderVO);
 
       BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailBeanArray);
      

         if(!(oMsg.equalsIgnoreCase("success")))
            throw new EnrgiseApplicationException("Payroll.GangDetail.Update",oArguments);

      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}