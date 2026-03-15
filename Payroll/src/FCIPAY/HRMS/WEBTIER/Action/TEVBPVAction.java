/*
    * Module:        TEVBPVAction.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Action Class for TEV Screen
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

import FCIPAY.HRMS.WEBTIER.Form.TEVBPVForm;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.TEVBPVBD;
import FCIPAY.HRMS.DATAACCESSTIER.VO.TEVBPVVO;
import FCIPAY.COMMON.UTILITY.*;
import java.util.*;

public class TEVBPVAction extends Action 
{
     TEVBPVVO oTBVO = new TEVBPVVO();
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
        String sDesg="";
        String butAction=null;             
        TEVBPVForm tbForm = (TEVBPVForm)form;        
   
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
        sDesg=obUserInfo.getSDesignation();
        oTBVO.setLEmployeeNo(lEmpNo);   
        oTBVO.setLLocationCode(lLocCode);
        oTBVO.setTxtDesg(sDesg);
//        System.out.println("location code is:"+lLocCode);
        try
        {
            butAction=request.getParameter("sAction");
            System.out.println(butAction);           
        }
        catch(NullPointerException iba)
        {
            errors.clear();
            errors.add("error", new ActionError("Finance.DB.Administrator"));
            saveErrors(request,errors);         
        }

        if(butAction.equals("Load"))
        {        
            List lstClaims = new ArrayList();   
            List lstPrd = new ArrayList();
            try
            {
                lstClaims=oTBBD.getClaims(lLocCode);
                if(!((List) lstClaims.get(0)).isEmpty())
                {            
                    tbForm.setLstClaimNoValues((List) lstClaims.get(0));
                    tbForm.setLstClaimNoLabels((List) lstClaims.get(1));
                }
                else
                {
                    throw new IBABusinessException("Finance.TEVBPV.NoClaimFound");
                }
                lstPrd=oTBBD.getCurrPrd(lLocCode);
                if(!lstPrd.isEmpty())
                {
                    tbForm.setLstPeriodValues((List) lstPrd.get(0));
                    tbForm.setLstPeriodLabels((List) lstPrd.get(1));
                    tbForm.setTxtClaimDate((String) lstPrd.get(2));
                }
                else
                {
                    tbForm.setsAction("LoadingFailed");
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
                tbForm.setsAction("LoadingFailed");
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
            tbForm.resetForm(mapping,request);            
            return mapping.findForward("Success");
        }
        
        if(butAction.equals("GetClmDtls"))
        {        
            List lstClaimDtls = new ArrayList();
            String sClaimNo = "";
            String sDocRemarks = "TEV for";
            int j=0;
            try
            {
                if(tbForm.setVO())
                    oTBVO = tbForm.getVO();
                oTBVO.setLEmployeeNo(lEmpNo);   
                oTBVO.setLLocationCode(lLocCode);
                tbForm.setTxtDocLoc(oTBBD.getDocLoc(lLocCode));
                tbForm.setHideRows(0);
                tbForm.setVoucherDtls(lstClaimDtls);
                if(!oTBVO.getLstClaimNo().equals(""))
                {
                    oTBBD.getClaimDtls(oTBVO.getLstClaimNo(),oTBVO);
                    if(!oTBVO.getLstClaimDtls().isEmpty())
                    { 
                                tbForm.setTrId((String) oTBVO.getLstClaimDtls().get(0));
                                tbForm.setTxtTravelDesc((String)  oTBVO.getLstClaimDtls().get(1));
                                tbForm.setTxtEmpNo((String)  oTBVO.getLstClaimDtls().get(2));
                                tbForm.setTxtEmpName((String)  oTBVO.getLstClaimDtls().get(3));
                                sDocRemarks = sDocRemarks +" "+ ((String)  oTBVO.getLstClaimDtls().get(3));
                                tbForm.setTxtDocRem(sDocRemarks);
                                tbForm.setLstPmtModeValues(oTBVO.getLstPmtModeValues());
                                 tbForm.setLstPmtModeLabels(oTBVO.getLstPmtModeLabels());
                                for(j=0;j < tbForm.getLstClaimNoValues().size();j++)
                                {
                                    if(((String)tbForm.getLstClaimNoValues().get(j)).equals(tbForm.getLstClaimNo()))
                                    {
                                        sClaimNo = (String) tbForm.getLstClaimNoLabels().get(j);
                                        j=tbForm.getLstClaimNoValues().size();
                                    }
                                }
                                tbForm.setTxtDocRef(sClaimNo);
                    }
                }
                else
                {
                    tbForm.setTxtTravelDesc("");
                    tbForm.setTxtEmpNo("");
                    tbForm.setTxtEmpName("");
                    tbForm.setTxtDocRef("");                 
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
                tbForm.setsAction("ClmDtlsNotFound");
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
                if(tbForm.setVO())
                    oTBVO = tbForm.getVO();
                oTBVO.setLEmployeeNo(lEmpNo);   
                oTBVO.setLLocationCode(lLocCode);
                oTBVO=oTBBD.getVouchDetails(oTBVO);
                lstVouchDtls = oTBVO.getVoucherDtls();
                if(!lstVouchDtls.isEmpty())
                {
                    tbForm.setVoucherDtls(lstVouchDtls);
                    tbForm.setHideRows(lstVouchDtls.size());
                    tbForm.setTxtTotCr(oTBVO.getTxtTotCr());
                    tbForm.setTxtTotDr(oTBVO.getTxtTotDr());
                }
                else
                {
                    tbForm.setsAction("ClmDtlsNotFound");
                    System.out.println("No data found");
                }    

            }
            catch (NullPointerException ne)
            {
                errors.clear();
                errors.add("error", new ActionError("Finance.DB.Administrator"));
                saveErrors(request,errors);
            }
            catch ( IBAFatalException ibafe )
            {                 
                errors.clear();
                errors.add("error", new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch ( IBABusinessException ibabe)
            {       
                tbForm.setsAction("ClmDtlsNotFound");
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
            List lstClaims = new ArrayList();
            try
            {
                if(tbForm.setVO())
                    oTBVO = tbForm.getVO();
                    oTBVO.setLEmployeeNo(lEmpNo);   
                    oTBVO.setLLocationCode(lLocCode);
                    oTBVO.setTxtDesg(sDesg);
                if(oTBBD.saveDetails(oTBVO))
                {
                    errors.clear();
                    messages.clear();
                    tbForm.resetForm(mapping, request);
                    messages.add("message", new ActionMessage("Finance.TEVBPV.Show.VoucherNo", oTBVO.getTxtVouchNo()));
                    saveMessages(request, messages);
                    errors.add("error", new ActionError("Finance.Insert.Success"));
                    saveErrors(request,errors);
                    lstClaims=oTBBD.getClaims(lLocCode);
                    if(!lstClaims.isEmpty())
                    {            
                        tbForm.setLstClaimNoValues((List) lstClaims.get(0));
                        tbForm.setLstClaimNoLabels((List) lstClaims.get(1));
                    }
                    else
                    {
                        tbForm.setsAction("LoadingFailed");
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
                tbForm.setsAction("SaveFailed");
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

        if(butAction.equals("SendBack"))
        {   
            List lstClaims = new ArrayList();
            try
            {
                if(tbForm.setVO())
                    oTBVO = tbForm.getVO();
                oTBVO.setLEmployeeNo(lEmpNo);   
                oTBVO.setLLocationCode(lLocCode);
                if(oTBBD.updateOnSendBack(oTBVO))
                {
                    errors.clear();                    
                    tbForm.resetForm(mapping, request);
                    errors.add("error", new ActionError("Finance.TEVBPV.SendBackSuccess"));
                    saveErrors(request,errors);
                    lstClaims=oTBBD.getClaims(lLocCode);                         
                    tbForm.setLstClaimNoValues((List) lstClaims.get(0));
                    tbForm.setLstClaimNoLabels((List) lstClaims.get(1));
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
                tbForm.setsAction("SaveFailed");
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
        return mapping.findForward("failure");
    }
}