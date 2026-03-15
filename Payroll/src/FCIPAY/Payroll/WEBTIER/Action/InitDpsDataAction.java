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
//import FCIPAY.Payroll.WEBTIER.Form.InitPayDataForm;
import FCIPAY.Payroll.WEBTIER.Form.InitDpsInitialiseForm;     // Added by dushaynt on 21-Oct-2011
//import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.InitPayrollDataBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.InitDpsLabourBD;  // Added by dushaynt on 21-Oct-2011
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class InitDpsDataAction extends BaseAction 
{
  public InitDpsDataAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
    //  InitPayrollDataBD oInitPayrollDataBD=(InitPayrollDataBD)oBaseBD;  // InitDpsLabourBD
      InitDpsLabourBD oInitDpsLabourBD=(InitDpsLabourBD)oBaseBD; 
      long lUserID = 200;
      long lSiteID = 200;
      String param1= "N" ;
      String butAction = "";
      String hdnEmpLbrFlag ="";

      InitDpsInitialiseForm fedoForm = (InitDpsInitialiseForm)oBaseForm;
      lUserID = fedoForm.getLoginEmployeeNo();
      lSiteID = fedoForm.getLoginLocCode();
      //Added by BAlpreet to inculde Labours Payroll Dt 10 March 2008.
      hdnEmpLbrFlag=fedoForm.getHdnEmpLbrFlag();
      
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
       param1 = (String)(request.getParameter("param1"));
      String sHdnVal = fedoForm.getHdnAction();
      if(param1 == null){
      
      param1="";
      }
	  if(param1.equalsIgnoreCase("Separation")){

	    ArrayList empNum =oInitDpsLabourBD.getSeparationEmpDetail(lSiteID,hdnEmpLbrFlag);
      request.getSession().setAttribute("EmpNumList",empNum);
	  
	  }
	  else{
      if (sHdnVal.equals("SUB")) 
      {
            String oErrorCode = oInitDpsLabourBD.InitialPayData(lUserID,lSiteID,hdnEmpLbrFlag);
            fedoForm.setHdnAction("");          
            ArrayList oArguments = new ArrayList();
            oArguments.clear();
            oArguments.add(new String(oErrorCode));
            throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
      else if (sHdnVal.equals("S")) 
      {
            throw new EnrgiseApplicationException("Pay.Init.Payroll.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }      
  }
           return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }
  
}