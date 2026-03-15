package FCIPAY.Payroll.WEBTIER.Action;

import FCIPAY.Payroll.common.webtier.action.BaseAction;
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
import FCIPAY.Payroll.WEBTIER.Form.ComFinalSetForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.ComFinalSetBD;
import FCIPAY.Payroll.UTILITY.ComFinalHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetQueryVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class ComFinalUpdateAction extends BaseAction
{
    public ComFinalUpdateAction()
    {
    }
    
    public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
  ArrayList oArguments = new ArrayList();
  System.out.println("start action");
   BaseForm oBaseForm = (BaseForm)form;
   System.out.println("base form");
   String sFormName = form.getClass().getName();
    ComFinalSetForm oComFinalSetForm = (ComFinalSetForm)form;
     BaseBD oBaseBD = getDetailBusinessDelegate(form);
      UserSession oUser = getUserSessionBean(request);
     String sQueryVO = FCIPAY.Payroll.common.utility.ParamUtil.getQueryVO(sFormName); // Get the fully qualified VO class name
      BaseQueryVO oBaseQueryVO = (BaseQueryVO)Class.forName(sQueryVO).newInstance(); //Create new query vo instance
       BaseHeaderVO oBaseHeaderVO = null;
   System.out.println(sFormName+"form name"); 
       BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
 String aScreenAction = (String)(request.getParameter("param1"));
     
       long userId = oBaseForm.getLoginEmployeeNo();
      long siteId = oBaseForm.getLoginLocCode();
     BeanUtils.copyProperties(oBaseHeaderBean,form);

	  String oMsg = "";
      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
     System.out.println("start action 1");
  
    if(aScreenAction.equalsIgnoreCase("DEL"))
	  {
             System.out.println("start action 2");

         ComFinalSetBD oComFinalSetBD = new ComFinalSetBD();
        oMsg = oComFinalSetBD.deleteComSepEntry(oBaseHeaderBean);
        oArguments.add(new String(oMsg)); 
        System.out.println("in action"+ oMsg);
              
           

        
          throw new EnrgiseApplicationException("Payroll.FinalSettlement.DeleteSepEntry",oArguments);          
         }
	  else
      {
          System.out.println("Action for"+aScreenAction);
          ComFinalSetBD oComFinalSetBD = new ComFinalSetBD();
          oMsg = oComFinalSetBD.deleteSepDtls(oBaseHeaderBean,aScreenAction);
        oArguments.add(new String(oMsg)); 
        System.out.println("in action"+ oMsg);
              
          throw new EnrgiseApplicationException("Payroll.FinalSettlement.DeleteSepEntry",oArguments);          
        
      }
	 
          
      //return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
}