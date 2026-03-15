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
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GenRevrRecoveriesBD;
import FCIPAY.Payroll.UTILITY.RevrRecoveriesHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.WEBTIER.Form.GenerateRevrRecoveriesForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import java.util.ArrayList;



public class GenRevrRecoveriesAction extends BaseAction
{
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */

 public GenRevrRecoveriesAction()
  {
  }

   
   public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {     
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName); 
      GenRevrRecoveriesBD oGenRevrRecoveriesBD=(GenRevrRecoveriesBD)oBaseBD;
      String butAction = ""; 
      GenerateRevrRecoveriesForm fedoForm = (GenerateRevrRecoveriesForm)oBaseForm;
      BeanUtils.copyProperties(oBaseHeaderBean,form);      
      butAction = fedoForm.getButAction();


    long lUserID = 200;
      long lSiteID = 200;      

      
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }                   


      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }

    //  BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
    //  BeanUtils.copyProperties(oBaseHeaderBean,form);
      String SPayrollYYMM = (String)(request.getParameter("param1"));

    if(butAction.equals("Generate"))
      { 
           // GenBasicArrearBD oGenBasicArrearBD = new GenBasicArrearBD();   
            String oErrorCode =  oGenRevrRecoveriesBD.GenRevrRecoveries(oBaseHeaderBean,lUserID,lSiteID);
            RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean = (RevrRecoveriesHeaderBean)oBaseHeaderBean;  

         if(oErrorCode.equals("PROMOTION REVERSAL RECOVERIES SUCCESS"))
          {
                fedoForm.setHdnPayrollFlag("Y");
                throw new EnrgiseApplicationException("Payroll.RevrRecovery.GEN_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
          }
        else
         {  
            ArrayList oArguments = new ArrayList();          
            oArguments.add(oErrorCode);
            throw  new EnrgiseApplicationException("Payroll.RevrRecovery.GEN_FAILED",oArguments);                   
          }
      }
     else
     {
         // GenBasicArrearBD oGenBasicArrearBD = new GenBasicArrearBD();  
          String oErrorCode =   oGenRevrRecoveriesBD.UndoRevrRecoveries(oBaseHeaderBean,lUserID,lSiteID);
          RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean = (RevrRecoveriesHeaderBean)oBaseHeaderBean;  
          

          if(oErrorCode.equals("UNDO PROMOTION REVERSAL SUCCESS"))
          {
              fedoForm.setHdnPayrollFlag("N");
              throw new EnrgiseApplicationException("Payroll.RevrRecovery.UNDO_GEN_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
          }
          else
          {  
            ArrayList oArguments = new ArrayList();          
            oArguments.add(oErrorCode);
            throw  new EnrgiseApplicationException("Payroll.RevrRecovery.UNDO_GEN_FAILED",oArguments);                   
          }
      }
           
    //  return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }

 /*public ActionForward executeImpl(BasicArrearHeaderBean oBasicArrearHeaderBean,ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {     
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();

      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",EnrgiseConstants.MESSAGE);
      }

      String SPayrollYYMM = (String)(request.getParameter("param1"));
      GenBasicArrearBD oGenBasicArrearBD = new GenBasicArrearBD();            
      oGenBasicArrearBD.GenBasicArr((BasicArrearHeaderBean)oBasicArrearHeaderBean,SPayrollYYMM);
      return mapping.findForward(EnrgiseConstants.SUCCESS);
  }*/


}