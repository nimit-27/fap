package FCIPAY.Payroll.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
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
import FCIPAY.Payroll.WEBTIER.Form.ComputeFSCForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.ComputeFscBD;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class ComputeFSCAction extends BaseAction 
{
  public ComputeFSCAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {  
   BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      ComputeFscBD oComputeFscBD=(ComputeFscBD)oBaseBD;
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   

      ComputeFSCForm fedoForm = (ComputeFSCForm)oBaseForm;
      lUserID = fedoForm.getLoginEmployeeNo();
      lSiteID = fedoForm.getLoginLocCode();
      
      BeanUtils.copyProperties(oBaseHeaderBean,form);      


      /* Added for Getting Current User */
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }
      /*End of Code */

      String sHdnVal = fedoForm.getHdnAction();
      String sFinYear = fedoForm.getTxtFinYear();
      if (sHdnVal.equals("SUB")) 
      {
          System.out.println("Before Compute FSc");
          String oErrorCode = oComputeFscBD.ComputeFsc(lUserID,lSiteID, sFinYear);
          fedoForm.setHdnAction("");          
          System.out.println("Computed FSC");
          System.out.println(oErrorCode);


        /*  if(oErrorCode.equals("DAARREAR_SUCCESS"))
          {
            fedoForm.setPayrollFlag("Y");
          }
          else
          {
            fedoForm.setPayrollFlag("N");
          }
          */
//          ArrayList oArguments = new ArrayList();
//          oArguments.add(new String(oErrorCode));

          fedoForm.setHdnAction("");
          
/*          if(oErrorCode.equals("SUCCESS"))
              {
                throw new EnrgiseApplicationException("Pay.Init.Payroll.Success.Message",EnrgiseConstants.MESSAGE);
              }
        else if (oErrorCode.equals("UNSUCCESSFUL"))
             {
                throw new EnrgiseApplicationException("Pay.Init.Payroll.UnSuccess.Message",EnrgiseConstants.MESSAGE);               
             }  */

          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(oErrorCode));
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);

             
      }
      else if (sHdnVal.equals("S")) 
      {
            throw new EnrgiseApplicationException("Pay.Compute.FSC.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }      
           return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }

}
    
