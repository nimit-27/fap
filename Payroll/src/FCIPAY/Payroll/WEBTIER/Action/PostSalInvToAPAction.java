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

public class PostSalInvToAPAction extends BaseAction
{
  public PostSalInvToAPAction()
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
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }
      
/* commented by devendra on 29th sept 2010 start
     PostSalaryInvToAPForm fedoForm = (PostSalaryInvToAPForm)oBaseForm;
     PostSalInvToAPBD oPostSalInvToAPBD=(PostSalInvToAPBD)oBaseBD;
    //PostSalJVToGLBD oPostSalJVToGLBD = new PostSalJVToGLBD();
     String oErrorCode =oPostSalInvToAPBD.PostSalInvToAP(lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag());

/*        if(oErrorCode.equals("POST_SALJV_SUCCESS"))
          {
               throw new EnrgiseApplicationException("Pay.Post.GL.Success",EnrgiseConstants.MESSAGE);
          }
        if(oErrorCode.equals("POST_SALJV_FAILED"))
          {
               throw new EnrgiseApplicationException("Pay.Post.GL.Failure",EnrgiseConstants.MESSAGE);
          }          
        if(oErrorCode.equals("POST_SALJV_CANNOT_BE_RUN"))
          {
               throw new EnrgiseApplicationException("PAY.POST.CANNOT.RUN",EnrgiseConstants.MESSAGE);
          }

        if(oErrorCode.equals("POST_SALJV_DONE_ALREADY"))
          {
               throw new EnrgiseApplicationException("PAY.POST.SALJV.DONE.ALREADY",EnrgiseConstants.MESSAGE);
          } *
          

          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(oErrorCode));
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);            
          commented by devendra on 29th sept 2010 end */
          
          
          // added by devendra on 29th sept 2010 start
          PostSalaryInvToAPForm fedoForm = (PostSalaryInvToAPForm)oBaseForm;
          PostSalInvToAPBD oPostSalInvToAPBD=(PostSalInvToAPBD)oBaseBD;
          String sHdnVal = fedoForm.getHdnAction();
//added by Neeraj Starts
          String invoice_date=fedoForm.getTxtInvDt();
          fedoForm.setFormFlag("Second");
    //added by Neeraj Ends
          if (sHdnVal.equals("SUB")) 
          {
              //System.out.println("Invoice Date is ---->"+invoice_date);
              //String oErrorCode =oPostSalInvToAPBD.PostSalInvToAP(lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag()); //Commented by Neeraj On 19 Oct,2010
              //Added By Neeraj Starts
              String oErrorCode =oPostSalInvToAPBD.PostSalInvToAP(lUserID,lSiteID,fedoForm.getHdnEmpLbrFlag(),invoice_date);
              //Added By neeraj Ends
              fedoForm.setHdnAction("");
              //added by Neeraj Starts
              fedoForm.setTxtInvDt(invoice_date);
              fedoForm.setFormFlag("Second");
               if(oErrorCode.equals("INACTIVE"))
                {
                    throw new EnrgiseApplicationException("PAY.POST.SALJV.INACTIVE.ALREADY",EnrgiseConstants.MESSAGE);
                }
              
              //added by Neeraj Ends
              ArrayList oArguments = new ArrayList();
              oArguments.add(new String(oErrorCode));
              throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
          }
           else if (sHdnVal.equals("S")) 
          {
                throw new EnrgiseApplicationException("Pay.Sal.Inv.Posting.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
          } 
          return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
          
          // added by devendra on 29th sept 2010 end
          
//    return mapping.findForward(EnrgiseConstants.SUCCESS);
  }
}