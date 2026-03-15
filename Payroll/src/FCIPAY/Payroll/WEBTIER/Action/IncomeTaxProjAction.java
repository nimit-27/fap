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
import FCIPAY.Payroll.WEBTIER.Form.CompIncTaxProjForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.IncomeTaxProjBD;
import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class IncomeTaxProjAction extends BaseAction
{
  public IncomeTaxProjAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      IncomeTaxProjBD oIncomeTaxBD=(IncomeTaxProjBD)oBaseBD;
      String butAction = "";  
      long loginUserId = 100 ;
      long lLoginSiteId = 100  ;
      CompIncTaxProjForm fedoForm = (CompIncTaxProjForm)oBaseForm;
      System.out.println("skhdvlsj");
      BeanUtils.copyProperties(oBaseHeaderBean,form);      

      UserInfoBean obUserInfo = new UserInfoBean();

      if(request.getSession().getAttribute("USERINFO")!=null)
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        loginUserId = obUserInfo.getLEmployeeNo();
        lLoginSiteId = obUserInfo.getLLocationCode();
      }

      butAction = fedoForm.getButAction();

      String sHdnVal = fedoForm.getHdnAction();
      String sRunYYMM = fedoForm.getTxtYYMM(); 
      if (sHdnVal.equals("SUB")) 
      {        
      
          String oErrorCode = oIncomeTaxBD.computeProjectedTax(oBaseHeaderBean,loginUserId,lLoginSiteId, sRunYYMM);
          System.out.println(oErrorCode);    
          fedoForm.setHdnAction("");

            if(oErrorCode.equals("INCTAX_MTHY_PRYL_RUN_EX"))
                  {
                    throw new EnrgiseApplicationException("INCTAX.MTHY.PRYL.RUN.EX",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
             if(oErrorCode.equals("INCTAX_SUCCES_EX"))
                  {
                    throw new EnrgiseApplicationException("INCTAX.PROJ.SUCCES.EX",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
             if(oErrorCode.equals("INCTAX_INVALID_EMPNO"))
                  {
                    throw new EnrgiseApplicationException("INCTAX.INVALID.EMPNO",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
             if(oErrorCode.equals("INCTAX.NOREC.FOUND"))
                  {
                    throw new EnrgiseApplicationException("INCTAX.NOREC.FOUND",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }            

            if(oErrorCode.equals("INCTAX_FAILURE_EX"))
                  {
                    throw new EnrgiseApplicationException("INCTAX.FAILURE.EX",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
            if(oErrorCode.equals("INVALID_RUN_YYMM"))
                  {
                    throw new EnrgiseApplicationException("INCTAX.RUN.YYMM",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
            if(oErrorCode.equals("INCTAX_INVALID_MARCH_RUN"))
                  {
                    throw new EnrgiseApplicationException("INCTAX.INVALID.MARCH.RUN",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
 
      }
      else if (sHdnVal.equals("S")) 
      {
            throw new EnrgiseApplicationException("Pay.Comp.IncTax.Proj.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
      }      
            
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
}