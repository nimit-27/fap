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
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GenBasicArrearBD;
import FCIPAY.Payroll.UTILITY.BasicArrearHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.WEBTIER.Form.GenerateBasicArrearForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import java.util.ArrayList;



public class GenBasicArrearAction extends BaseAction
{
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */

 public GenBasicArrearAction()
  {
  }

   
   public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {     
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName); 
      GenBasicArrearBD oGenBasicArrearBD=(GenBasicArrearBD)oBaseBD;
      String butAction = ""; 
      GenerateBasicArrearForm fedoForm = (GenerateBasicArrearForm)oBaseForm;
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
      String sHdnVal = fedoForm.getHdnAction();

    if(butAction.equals("Generate"))
    { 
        if (sHdnVal.equals("SUB")) 
        {
            String oErrorCode =  oGenBasicArrearBD.GenBasicArr(oBaseHeaderBean,lUserID,lSiteID);
            ArrayList oArguments = new ArrayList();
            oArguments.clear();
            oArguments.add(new String(oErrorCode));
            throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);          
       
            /*   BasicArrearHeaderBean oBasicArrearHeaderBean = (BasicArrearHeaderBean)oBaseHeaderBean;  
            
            if(oErrorCode.equals("BASICARREAR_SUCCESS"))
            {
            fedoForm.setHdnPayrollFlag("Y");
            throw new EnrgiseApplicationException("Payroll.BasicArr.BASICARR_GEN_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if(oErrorCode.equals("BASICARREAR_FAILED"))
            {
            throw new EnrgiseApplicationException("Payroll.BasicArr.BASICARREAR_GEN_FAILED",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            
            if(oErrorCode.equals("BASICARR_ALREADY_GENERATED"))
            {
            throw new EnrgiseApplicationException("Payroll.BasicArr.PayrollFlagChk",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if (oErrorCode.equals("CANNOT_GEN_BASICARR_FOR_PREV_MONTH"))
            {
            throw new EnrgiseApplicationException("Payroll.BasicArr.PayYYMMLessCurYYMMChk",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if (oErrorCode.equals("BASICARR_ALREADY_DONE_UNDO"))
            {
            ArrayList oArguments = new ArrayList();          
            oArguments.add(fedoForm.getTxtpayYYMM());
            throw  new EnrgiseApplicationException("Payroll.BasicArr.PayCurYYMMStatusChk",oArguments);                   
            }
            
            throw new EnrgiseApplicationException("Payroll.BasicArr.BASICARR_GEN_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            */
           
        }
        else if (sHdnVal.equals("S")) 
        {
            throw new EnrgiseApplicationException("Pay.basic.Payroll.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
        }      
    }
     else
     {
          String oErrorCode =   oGenBasicArrearBD.UndoBasicArr(oBaseHeaderBean,lUserID,lSiteID);
          BasicArrearHeaderBean oBasicArrearHeaderBean = (BasicArrearHeaderBean)oBaseHeaderBean;  
          

           if(oErrorCode.equals("UNDO_BASICARREAR_SUCCESS"))
              {
                fedoForm.setHdnPayrollFlag("N");
                throw new EnrgiseApplicationException("Payroll.BasicArr.UNDO_BASICARR_GEN_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
           if(oErrorCode.equals("UNDO_BASICARREAR_FAILED"))
              {
                throw new EnrgiseApplicationException("Payroll.BasicArr.UNDO_BASICARR_GEN_FAILED",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }  


           if(oErrorCode.equals("BASICARR_NOT_GENERATED_CANT_UNDO"))
              {
                throw new EnrgiseApplicationException("Payroll.BasicArr.UndoPayrollFlagChk",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
           if (oErrorCode.equals("CANNOT_UNDO_BASICARR_FOR_PREV_MONTH"))
              {
                throw new EnrgiseApplicationException("Payroll.UndoBasicArr.PayYYMMLessCurYYMMChk",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
           if (oErrorCode.equals("CANT_UNDO"))
              {
                ArrayList oArguments = new ArrayList();          
                oArguments.add(fedoForm.getTxtpayYYMM());
                throw  new EnrgiseApplicationException("Payroll.UndoBasicArr.PayCurYYMMStatusChk",oArguments);                   

              }

                fedoForm.setHdnPayrollFlag("N");
                throw new EnrgiseApplicationException("Payroll.BasicArr.UNDO_BASICARR_GEN_SUCCESS",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
             
      
      }
           
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }

 


}