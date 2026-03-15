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
import FCIPAY.Payroll.WEBTIER.Form.OverNAboveArrearfrm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.OverNAboveArrear;
import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

public class OverNAboveAction extends BaseAction
{
  public OverNAboveAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      OverNAboveArrear oOverNAboveArrear=(OverNAboveArrear)oBaseBD;
      String butAction = "";   
      OverNAboveArrearfrm fedoForm = (OverNAboveArrearfrm)oBaseForm;

      long loginUserId = 100;
      long lLoginSiteId = 100;
      String payYYMM;
            
      BeanUtils.copyProperties(oBaseHeaderBean,form);      
      butAction = fedoForm.getButAction();

      loginUserId = oBaseForm.getLoginEmployeeNo();
      lLoginSiteId =  oBaseForm.getLoginLocCode();
      payYYMM =  oBaseForm.getPayYYMM();
	    

     
      
      if(butAction.equals("Generate"))
      {      
		   String sHdnVal = fedoForm.getHdnAction();
            if (sHdnVal.equals("S")) 
            {
                throw new EnrgiseApplicationException("Pay.OvrAbvPAyArr.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
            }   
            else if(sHdnVal.equals("SUB")) 
            {
                String oErrorCode = oOverNAboveArrear.genOverNAboveArrear(oBaseHeaderBean,loginUserId,lLoginSiteId,payYYMM);
                System.out.println("generate");
                System.out.println(oErrorCode);
                ArrayList oArguments = new ArrayList();
                oArguments.add(oErrorCode);
                throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
            }
      }          
        if(butAction.equals("Undo"))
      {           
          String oErrorCode = oOverNAboveArrear.undoOvrAbvArrear(oBaseHeaderBean,loginUserId ,lLoginSiteId);
          System.out.println("undo");
          System.out.println(oErrorCode);

            ArrayList oArguments = new ArrayList();
                oArguments.add(oErrorCode);
                throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }
}