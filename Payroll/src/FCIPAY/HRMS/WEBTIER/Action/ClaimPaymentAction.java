/*
    * Module:        ClaimPaymentAction.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Action Class for Claim Payment through Voucher Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import FCIPAY.HRMS.DATAACCESSTIER.VO.ClaimPaymentVO;
import FCIPAY.HRMS.WEBTIER.Form.ClaimPaymentForm;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.TEVBPVBD;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.ClaimPaymentBD;
import FCIPAY.COMMON.UTILITY.*;

public class ClaimPaymentAction extends Action 
{
    ClaimPaymentBD oCPBD = new ClaimPaymentBD();
    ClaimPaymentVO oCPVO = new ClaimPaymentVO();
    TEVBPVBD oTBBD = new TEVBPVBD();
    ActionErrors errors = new ActionErrors(); 
    ActionMessages messages = new ActionMessages();
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        long lEmpNo = 0 ;       
        long lLocCode = 0;
        String butAction=null;             
        ClaimPaymentForm cpForm = (ClaimPaymentForm)form;        
   
        UserInfoBean obUserInfo = new UserInfoBean();
        HttpSession session = request.getSession(false);
//        System.out.println(session.getId());
        if(session!=null) 
        {
//            session.setAttribute("USERINFO",obUserInfo);
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("failure");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else
             return mapping.findForward("failure");
        lEmpNo = obUserInfo.getLEmployeeNo();
        lLocCode = obUserInfo.getLLocationCode(); 
        oCPVO.setLEmployeeNo(lEmpNo);   
        oCPVO.setLLocationCode(lLocCode);
//        System.out.println("location code is:"+lLocCode);
        try
        {
            butAction=cpForm.getsAction();
//            System.out.println(butAction);           
        }
        catch(NullPointerException iba)
        {
            errors.clear();
            errors.add("error", new ActionError("Finance.DB.Administrator"));
            saveErrors(request,errors);         
        }

        if(butAction.equals("Load"))
        {        
            List lstEmpNos = new ArrayList();   
            List lstPrd = new ArrayList();
            if(cpForm.setVO())
                oCPVO = cpForm.getVO();
            try
            {
                lstEmpNos=oCPBD.getEmpNos(lLocCode,oCPVO.getHidMIdforRetreival());
                if(!lstEmpNos.isEmpty())
                {            
                    cpForm.setLstEmpNoValues(lstEmpNos);
                    cpForm.setLstEmpNoLabels(lstEmpNos);
                }
                else
                {
                    cpForm.setsAction("LoadingFailed");
                    System.out.println("No data found");
                }
                lstPrd=oCPBD.getBPVCPVCurrPrd(lLocCode);
                if(!lstPrd.isEmpty())
                {
                    cpForm.setLstPeriodValues((List) lstPrd.get(0));
                    cpForm.setLstPeriodLabels((List) lstPrd.get(1));
                    cpForm.setTxtVouchDate((String) lstPrd.get(2));
                }
                else
                {
                    cpForm.setsAction("LoadingFailed");
                    System.out.println("No data found");
                }
            }
            catch ( IBAFatalException ibafe )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch ( IBABusinessException ibabe)
            {       
                cpForm.setsAction("LoadingFailed");
                errors.clear();
                errors.add("error", new ActionError(ibabe.getErrorKey()));
                saveErrors(request,errors);
            }        
            catch ( IBAException ibae )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibae.getErrorKey()));
                saveErrors(request,errors);
            }
                      
            return mapping.findForward("Success");
        }

        if(butAction.equals("Reset"))
        {        
            cpForm.resetForm(mapping,request);            
            return mapping.findForward("Success");
        }
        
        if(butAction.equals("GetEmpDtls"))
        {        
            String sEmpName = "";
            String sClaimNo = "";
            int j=0;
            try
            {
                if(cpForm.setVO())
                    oCPVO = cpForm.getVO();
                oCPVO.setLEmployeeNo(lEmpNo);   
                oCPVO.setLLocationCode(lLocCode);
                cpForm.setTxtDocLoc(oTBBD.getDocLoc(lLocCode));
                cpForm.setHideRows(0);
                cpForm.setTxtTotDrAmt("");
                cpForm.setVoucherDtls(new ArrayList());
                if(!oCPVO.getLstEmpNo().equals(""))
                {
                    sEmpName = oCPBD.getEmpDtls(oCPVO.getLstEmpNo());
                    cpForm.setTxtEmpName(sEmpName);
                }
                else
                {
                    cpForm.setTxtEmpName("");  
                }
                
            }
            catch ( IBAFatalException ibafe )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch ( IBABusinessException ibabe)
            {       
                cpForm.setsAction("ClmDtlsNotFound");
                errors.clear();
                errors.add("error", new ActionError(ibabe.getErrorKey()));
                saveErrors(request,errors);
            }        
            catch ( IBAException ibae )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibae.getErrorKey()));
                saveErrors(request,errors);
            }
                      
            return mapping.findForward("Success");
        }

        if(butAction.equals("GETVOUCHDTLS"))
        {        
            List lstVouchDtls = new ArrayList();   
            try
            {
                if(cpForm.setVO())
                    oCPVO = cpForm.getVO();
                oCPVO.setLEmployeeNo(lEmpNo);   
                oCPVO.setLLocationCode(lLocCode);
                lstVouchDtls=oCPBD.getVouchDetails(oCPVO);
                if(!lstVouchDtls.isEmpty())
                {
                    cpForm.setVoucherDtls(lstVouchDtls);
                    cpForm.setHideRows(lstVouchDtls.size());
                }
                else
                {
                    cpForm.setsAction("ClmDtlsNotFound");
                    System.out.println("No data found");
                }    

            }
            catch ( IBAFatalException ibafe )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch ( IBABusinessException ibabe)
            {       
                cpForm.setsAction("ClmDtlsNotFound");
                errors.clear();
                errors.add("error", new ActionError(ibabe.getErrorKey()));
                saveErrors(request,errors);
            }        
            catch ( IBAException ibae )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibae.getErrorKey()));
                saveErrors(request,errors);
            }
                      
            return mapping.findForward("Success");
        }

        if(butAction.equals("Save"))
        {   
            List lstEmpNos = new ArrayList();
            try
            {
                if(cpForm.setVO())
                    oCPVO = cpForm.getVO();
                oCPVO.setLEmployeeNo(lEmpNo);   
                oCPVO.setLLocationCode(lLocCode);
                if(oCPBD.saveDetails(oCPVO))
                {
                    //System.out.println(oCPVO.getTxtHidVoucherId());
                    cpForm.setTxtHidVouId(oCPVO.getTxtHidVoucherId());
                    errors.clear();
                    messages.clear();
                    cpForm.resetForm(mapping, request);
                    messages.add("message", new ActionMessage("Finance.TEVBPV.Show.VoucherNo", oCPVO.getTxtVouchNo()));
                    saveMessages(request, messages);
                    errors.add("error", new ActionError("Finance.Insert.Success"));
                    saveErrors(request,errors);
                    lstEmpNos=oCPBD.getEmpNos(lLocCode,oCPVO.getTxtModuleId());
                    if(!lstEmpNos.isEmpty())
                    {            
                        cpForm.setLstEmpNoValues(lstEmpNos);
                        cpForm.setLstEmpNoLabels(lstEmpNos);
                    }
                    else
                    {
                        cpForm.setsAction("LoadingFailed");
                        System.out.println("No data found");
                    }
                }
                else
                {
                    errors.clear();
                    errors.add("error", new ActionError("Finance.DB.Administrator"));
                    saveErrors(request,errors);
                }                
            }
            catch ( IBAFatalException ibafe )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch ( IBABusinessException ibabe)
            {       
                cpForm.setsAction("SaveFailed");
                errors.clear();
                errors.add("error", new ActionError(ibabe.getErrorKey()));
                saveErrors(request,errors);
            }        
            catch ( IBAException ibae )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibae.getErrorKey()));
                saveErrors(request,errors);
            }
                      
            return mapping.findForward("Success");
        }
        return mapping.findForward("Success");
    }
}