
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
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PostSalInvToAPBD;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PostSalaryInvToAPForm;
import FCIPAY.Payroll.UTILITY.MaintainDirectPayrollBean;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainDirectPayrollBD;
import FCIPAY.Payroll.WEBTIER.Form.MaintainDirectPayrollForm;
import FCIPAY.Payroll.WEBTIER.Form.MaintainInternalSavingsForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainInternalSavingsBD;


public class CheckPayCodeSaveAction extends BaseAction
{
  public CheckPayCodeSaveAction()
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
        if(sScreenName.equalsIgnoreCase("DirectPayrollScreen")){
          MaintainDirectPayrollForm maintainDirectPayrollForm = (MaintainDirectPayrollForm)oBaseForm;
         // String [] txtPaycode1 = maintainDirectPayrollForm.getTxtPayCode();
         // String txtPaycode=txtPaycode1[0];
          MaintainDirectPayrollBD maintainDirectPayrollBD=(MaintainDirectPayrollBD)oBaseBD;        
          ArrayList payCodes =maintainDirectPayrollBD.getPayCodes();
          request.getSession().setAttribute("payCodesList",payCodes);
//////////////////////
		      ArrayList DepuPayCodes =maintainDirectPayrollBD.getDepuPayCodes();
          request.getSession().setAttribute("DepuPayCodesList",DepuPayCodes);
		  ////////////////////////



 } 
          if(sScreenName.equalsIgnoreCase("InternalScreen")){
          
          MaintainInternalSavingsForm maintainInternalSavingsForm = (MaintainInternalSavingsForm)oBaseForm;        
          MaintainInternalSavingsBD maintainInternalSavingsBD=(MaintainInternalSavingsBD)oBaseBD;        
          ArrayList payCodes =maintainInternalSavingsBD.getInternalsavingPayCodes();
          request.getSession().setAttribute("payCodesList",payCodes);
          
          
          }
          
     /* if(oErrorCode.equalsIgnoreCase("Valid PayCode"))
      {            
              maintainDirectPayrollForm.setTxtPayCode1(txtPaycode);
              maintainDirectPayrollForm.setScreenMode("Q");
              ArrayList oArguments = new ArrayList();
              oArguments.add(new String("Please Enter Supplier Details !!!!"));
              throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
           else if(!oErrorCode.equalsIgnoreCase("Valid PayCode"))
       {
              String value="correct user";      
              request.setAttribute("ERROR_MSG",value);
              maintainDirectPayrollForm.setTxtPayCode1(txtPaycode);
       }*/
     //maintainDirectPayrollForm.setTxtPayCode1(txtPaycode);
     //MaintainDirectPayrollBean maintainDirectPayrollBean = new MaintainDirectPayrollBean();
     //maintainDirectPayrollBean.setTxtPayCode(txtPaycode);
    /*  if (oErrorCode.equalsIgnoreCase("Valid PayCode"))
       {                  
              request.setAttribute("madatory_field","madatory_field");
             
       }
        if (oErrorCode.equalsIgnoreCase("Invalid PayCode"))
       {                  
                request.setAttribute("notmadatory_field","notmadatory_field");
             // maintainDirectPayrollForm.setScreenMode("N");
             
       }*/
          return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
    
  }

}