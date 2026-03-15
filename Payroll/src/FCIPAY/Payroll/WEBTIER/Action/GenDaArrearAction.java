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
import FCIPAY.Payroll.WEBTIER.Form.GenDaArrearForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GenDAArrearBD;
import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

public class GenDaArrearAction extends BaseAction
{
  public GenDaArrearAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);      
      GenDAArrearBD oGenDAArrearBD=(GenDAArrearBD)oBaseBD;
      String butAction = "";   
      GenDaArrearForm fedoForm = (GenDaArrearForm)oBaseForm;

      long loginUserId = 100;
      long lLoginSiteId = 100;
            
      BeanUtils.copyProperties(oBaseHeaderBean,form);      
      butAction = fedoForm.getButAction();

      loginUserId = oBaseForm.getLoginEmployeeNo();
      lLoginSiteId =  oBaseForm.getLoginLocCode();
	  String sHdnVal = fedoForm.getHdnAction(); 

     
      
      if(butAction.equals("Generate"))
      {      
        if (sHdnVal.equals("SUB")) 
        {
            String oErrorCode = oGenDAArrearBD.genDAArrear(oBaseHeaderBean,loginUserId,lLoginSiteId);
            fedoForm.setHdnAction("");
            ArrayList oArguments = new ArrayList();
            oArguments.clear();
            oArguments.add(new String(oErrorCode));
            throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
            /*  GenDAArrearHeaderBean oGenDAArrearHeaderBean = (GenDAArrearHeaderBean)oBaseHeaderBean;
            if(oErrorCode.equals("DAARREAR_SUCCESS"))
            {
            fedoForm.setPayrollFlag("Y");
            }
            else
            {
            fedoForm.setPayrollFlag("N");
            }
            
            
            if(oErrorCode.equals("DAARREAR_SUCCESS"))
            {
            throw new EnrgiseApplicationException("Pay.DAArr.DAARREAR_GEN_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if(oErrorCode.equals("NO DA RATES FOUND"))
            {
            throw new EnrgiseApplicationException("Pay.DAArr.NO_DA_RATES_FOUND",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if(oErrorCode.equals("MONTH_ALREADY_COMPUTED"))
            {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oGenDAArrearHeaderBean.getTxtPayYYMM()));
            throw new EnrgiseApplicationException("Pay.DAArr.MONTH_ALREADY_COMPUTED",oArguments);
            }
            if(oErrorCode.equals("SAL_JV_NOT_POSTED"))
            {
            throw new EnrgiseApplicationException("Pay.DAArr.SAL_JV_NOT_POSTED",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if(oErrorCode.equals("UNDO_PAYROLL"))
            {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oGenDAArrearHeaderBean.getTxtPayYYMM()));
            throw new EnrgiseApplicationException("Pay.DAArr.UNDO_PAYROLL",oArguments);
            }
            if(oErrorCode.equals("U_KEY_VIOLATION"))
            {
            throw new EnrgiseApplicationException("Pay.DAArr.U_KEY_VIOLATION",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            // Added by dushaynt on 16-Jan-2012
            if(oErrorCode.equals("Monthend Done"))
            {
            throw new EnrgiseApplicationException("Pay.DAArr.MONTHEND_DONE",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            //End by dushyant*/
        }
        else if (sHdnVal.equals("S")) 
        {
            throw new EnrgiseApplicationException("Pay.DAArr.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
        } 
      }        
      if(butAction.equals("Undo"))
      {           
          String oErrorCode = oGenDAArrearBD.undoDAArrear(oBaseHeaderBean,loginUserId ,lLoginSiteId);
          System.out.println("undo");
          System.out.println(oErrorCode);

          GenDAArrearHeaderBean oGenDAArrearHeaderBean = (GenDAArrearHeaderBean)oBaseHeaderBean;

          if(oErrorCode.equals("DAARREAR_SUCCESS"))
          {
            fedoForm.setPayrollFlag("N");
          }
          else
          {
            fedoForm.setPayrollFlag("Y");
          }

              if(oErrorCode.equals("DAARREAR_SUCCESS"))
              {
                throw new EnrgiseApplicationException("Pay.DAArr.DAARREAR_UNDO_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
              if(oErrorCode.equals("HRAARREAR_SUCCESS"))
             {
                throw new EnrgiseApplicationException("Pay.DAArr.HRAARREAR_UNDO_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
              if(oErrorCode.equals("ALL_EMPLOYEE_UNDONE"))
              {
                throw new EnrgiseApplicationException("Pay.DAArr.ALL_EMPLOYEE_UNDONE",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
              if(oErrorCode.equals("MONTH_ALREADY_COMPUTED"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(new String(oGenDAArrearHeaderBean.getTxtPayYYMM()));
                throw new EnrgiseApplicationException("Pay.DAArr.MONTH_ALREADY_COMPUTED",oArguments);
              }
              if(oErrorCode.equals("DELETE_ERROR"))
              {
                throw new EnrgiseApplicationException("Pay.DAArr.DELETE_ERROR",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
              if(oErrorCode.equals("UPDATE_ERROR"))
              {
                throw new EnrgiseApplicationException("Pay.DAArr.UPDATE_ERROR",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
}