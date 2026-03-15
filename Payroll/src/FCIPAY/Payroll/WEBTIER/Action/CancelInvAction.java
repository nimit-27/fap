package FCIPAY.Payroll.WEBTIER.Action;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LTCEncashBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.WEBTIER.Form.LTCEncashForm;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import FCIPAY.Payroll.WEBTIER.Form.EmpMediBillsForm;
import FCIPAY.Payroll.WEBTIER.Form.SupplPayForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpMediBillsBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.SupplimentaryPayBD ;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PLIActCancelBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIActCancelQueryVO;
import FCIPAY.Payroll.WEBTIER.Form.PLIActualCancelForm;
import  java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm;//added by arvind
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CPFFinalPaymentBD;//added by arvind

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaveEncashBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;//added by arvind

import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveEncashQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayQueryVO;
import FCIPAY.Payroll.WEBTIER.Form.LeaveEncashForm;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpPrmsMediBillsBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsMediBillsQueryVO;
import FCIPAY.Payroll.WEBTIER.Form.EmpPrmsMediBillsForm;

public class CancelInvAction extends BaseAction
{
    public CancelInvAction()
    {
    }
    
     public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); 
	     ArrayList oArguments = new ArrayList();
      String oMsg = "";
      String sQueryVO = FCIPAY.Payroll.common.utility.ParamUtil.getQueryVO(sFormName); // Get the fully qualified VO class name
      BaseQueryVO oBaseQueryVO = (BaseQueryVO)Class.forName(sQueryVO).newInstance(); //Create new query vo instance
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      long lUserID = 200;
      long lSiteID = 200;
      

   	  
	  
	  
	 if(sScreenName.equals("LTCEncashScreen"))
      {
         LTCEncashForm fedoForm = (LTCEncashForm)oBaseForm;      
        LTCEncashBD oLTCEncashBD=(LTCEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();     
        LTCEncashQueryVO oLTCEncashQueryVO=new LTCEncashQueryVO();
        BeanUtils.copyProperties(oLTCEncashQueryVO,form);
        oMsg = oLTCEncashBD.cancelLTCEncashInv(oLTCEncashQueryVO);
               oArguments.add(new String(oMsg));     

                throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);

      }
      
     if(sScreenName.equals("EmpMediBillsScreen"))
      {
         EmpMediBillsForm fedoForm = (EmpMediBillsForm)oBaseForm;  
         lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode(); 
        
        EmpMediBillsBD oEmpMediBillsBD=(EmpMediBillsBD)oBaseBD;
            
        EmpMediBillsQueryVO oEmpMediBillsQueryVO=new EmpMediBillsQueryVO();
        BeanUtils.copyProperties(oEmpMediBillsQueryVO,form);
        oMsg = oEmpMediBillsBD.EmpMediBillsCancelInv(oEmpMediBillsQueryVO);
                       oArguments.add(new String(oMsg));     

                throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
        
      }
    
       if(sScreenName.equals("SupplPaymentScreen"))
      {
         SupplPayForm fedoForm = (SupplPayForm)oBaseForm;  
         lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode(); 
        
        SupplimentaryPayBD oSupplimentaryPayBD=(SupplimentaryPayBD)oBaseBD;
            
        SupplPayQueryVO oSupplPayQueryVO=new SupplPayQueryVO();
        BeanUtils.copyProperties(oSupplPayQueryVO,form);
        oMsg = oSupplimentaryPayBD.CancelSuppPaymentInv(oSupplPayQueryVO);
                       oArguments.add(new String(oMsg));     

                throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
        
      } 

if(sScreenName.equals("PLIPaymentCancellation"))
    {
        PLIActualCancelForm fedoForm = (PLIActualCancelForm)oBaseForm;  
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode(); 
        PLIActCancelBD oPLIActCancelBD=(PLIActCancelBD)oBaseBD;
        PLIActCancelQueryVO oPLIActCancelQueryVO=new PLIActCancelQueryVO();
        BeanUtils.copyProperties(oPLIActCancelQueryVO,form);
        oMsg = oPLIActCancelBD.CancelPLIPaymentInv(oPLIActCancelQueryVO);
        oArguments.add(new String(oMsg));     
        throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
    }

    if(sScreenName.equals("LeaveEncashScreen"))
        {
            LeaveEncashForm fedoForm = (LeaveEncashForm)oBaseForm;      
            LeaveEncashBD oLTCEncashBD=(LeaveEncashBD)oBaseBD;
            lUserID = fedoForm.getLoginEmployeeNo();
            lSiteID = fedoForm.getLoginLocCode();
            LeaveEncashQueryVO oLeaveEncashQueryVO=new LeaveEncashQueryVO();
            BeanUtils.copyProperties(oLeaveEncashQueryVO,form);
            oMsg = oLTCEncashBD.cancelLeaveEncashInv(oLeaveEncashQueryVO);
                  oArguments.add(new String(oMsg));     

                   throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
        }
// added by arvind
if(sScreenName.equals("CPFPartFinalPayScreen"))
    {
      CPFFinalPaymentForm fedoForm = (CPFFinalPaymentForm)oBaseForm;  
      lUserID = fedoForm.getLoginEmployeeNo();
     lSiteID = fedoForm.getLoginLocCode(); 
     
        CPFFinalPaymentBD oCPFFinalPaymentBD=(CPFFinalPaymentBD)oBaseBD;
         
     CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
     BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
     oMsg = oCPFFinalPaymentBD.CancelPartFinalInv(oCPFFinalPaymentQueryVO);
                    oArguments.add(new String(oMsg));     
             throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
     
    }
if(sScreenName.equals("CPFAdvanceScreen"))
    {
      CPFFinalPaymentForm fedoForm = (CPFFinalPaymentForm)oBaseForm;  
      lUserID = fedoForm.getLoginEmployeeNo();
     lSiteID = fedoForm.getLoginLocCode(); 
     
        CPFFinalPaymentBD oCPFFinalPaymentBD=(CPFFinalPaymentBD)oBaseBD;
         
     CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
     BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
     oMsg = oCPFFinalPaymentBD.CancelPartFinalInv(oCPFFinalPaymentQueryVO);
                    oArguments.add(new String(oMsg));     
             throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
     
    }
    
    if(sScreenName.equals("CPFFinalPaymentScreen"))
    {
      CPFFinalPaymentForm fedoForm = (CPFFinalPaymentForm)oBaseForm;  
      lUserID = fedoForm.getLoginEmployeeNo();
     lSiteID = fedoForm.getLoginLocCode(); 
     
        CPFFinalPaymentBD oCPFFinalPaymentBD=(CPFFinalPaymentBD)oBaseBD;
         
     CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
     BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
     oMsg = oCPFFinalPaymentBD.CancelPartFinalInv(oCPFFinalPaymentQueryVO);
                    oArguments.add(new String(oMsg));     
throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
     
    }
  if(sScreenName.equals("EmpPrmsMediBillsScreen"))
     {
        EmpPrmsMediBillsForm fedoForm = (EmpPrmsMediBillsForm)oBaseForm;  
        lUserID = fedoForm.getLoginEmployeeNo();
       lSiteID = fedoForm.getLoginLocCode(); 
       
       EmpPrmsMediBillsBD oEmpPrmsMediBillsBD=(EmpPrmsMediBillsBD)oBaseBD;
           
       EmpPrmsMediBillsQueryVO oEmpPrmsMediBillsQueryVO=new EmpPrmsMediBillsQueryVO();
       BeanUtils.copyProperties(oEmpPrmsMediBillsQueryVO,form);
       oMsg = oEmpPrmsMediBillsBD.EmpPrmsMediBillsCancelInv(oEmpPrmsMediBillsQueryVO);
                     
					  oArguments.add(new String(oMsg));     

               throw new EnrgiseApplicationException("Payroll.OtherPayment.CancelInvSuccess",oArguments);
       
     }  
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS); 
      
}
}