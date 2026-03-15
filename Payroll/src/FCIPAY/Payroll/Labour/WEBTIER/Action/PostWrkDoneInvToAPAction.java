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
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.CalcDpsWrkDoneBD;
import java.util.ArrayList;
import FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDpsWrkDoneForm;
import FCIPAY.Payroll.Labour.Utility.CalcDpsWrkDoneHeaderBean;

public class PostWrkDoneInvToAPAction extends BaseAction
{
  public PostWrkDoneInvToAPAction()
  {
  }

 public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      CalcDpsWrkDoneBD oCalcDpsWrkDoneBD=(CalcDpsWrkDoneBD)oBaseBD;
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   
     
      CalcDpsWrkDoneForm fedoForm = (CalcDpsWrkDoneForm)oBaseForm;
      lUserID = fedoForm.getLoginEmployeeNo();
      lSiteID = fedoForm.getLoginLocCode();
      String EmpLbrFlag = fedoForm.getHdnEmpLbrFlag().toString();
      BeanUtils.copyProperties(oBaseHeaderBean,form);


      /* Added for Getting Current User */
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }
      
      /*End of Code */
      
      // added by dushyant on 13-may-2011
         // CalcDpsWrkDoneForm fedoForm = (CalcDpsWrkDoneForm)oBaseForm;   //CalcDpsWrkDoneForm
        //  CalcDpsWrkDoneBD oCalcDpsWrkDoneBD=(CalcDpsWrkDoneBD)oBaseBD;            //CalcDpsWrkDoneBD
          String sHdnVal = fedoForm.getHdnAction();
      // added by dushyant on 13-may-2011

        
       //   System.out.println(oErrorCode);
          
           // added by dushyant on 13-may-2011 start

           if (sHdnVal.equals("SUB")) 
          {
              String oErrorCode = oCalcDpsWrkDoneBD.PostInvToAP(lUserID,lSiteID,(CalcDpsWrkDoneHeaderBean)oBaseHeaderBean);
              fedoForm.setHdnAction("");             
              ArrayList oArguments = new ArrayList();
              oArguments.add(new String(oErrorCode));
               /*if(EmpLbrFlag.equals("L")){
                  throw new EnrgiseApplicationException("Pay.Lbr.IncentivePostInv.Success.Message",oArguments);
                  }
                  else{
                    throw new EnrgiseApplicationException("Pay.Lbr.WrkDonePostInv.Success.Message",oArguments);
                  }*/
              throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
          }
           else if (sHdnVal.equals("S")) 
          {
                throw new EnrgiseApplicationException("Pay.Sal.Inv.Posting.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
          } 

          
           // added by dushyant on 13-may-2011 end

       
        
         return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }
  
}