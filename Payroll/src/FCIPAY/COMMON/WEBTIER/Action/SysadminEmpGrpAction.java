package FCIPAY.COMMON.WEBTIER.Action;
import FCIPAY.COMMON.WEBTIER.Form.SysadminEmpGrpForm;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.SysadminEmpGrpBD;
import FCIPAY.COMMON.DATAACCESSTIER.VO.SysadminEmpGrpVO;
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
import javax.servlet.http.HttpSession;
import java.util.*;
import java.sql.*;
import FCIPAY.COMMON.UTILITY.*;

public class SysadminEmpGrpAction extends Action
{
/**
    * This is the main action called from the Struts framework.
    * @param mapping The ActionMapping used to select this instance.
    * @param form The optional ActionForm bean for this request.
    * @param request The HTTP Request we are processing.
    * @param response The HTTP Response we are processing.
*/

public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, IBAException, SQLException,NullPointerException
    {
    long lLocCode;
    long lEmpNo;
    String iLCCode=null;
    String iLCCode1=null;
    SysadminEmpGrpForm oSPMForm=(SysadminEmpGrpForm)form;
    SysadminEmpGrpBD oSPMBD=new SysadminEmpGrpBD();
    SysadminEmpGrpVO oSPMVO=new SysadminEmpGrpVO();


    UserInfoBean obUserInfo = new UserInfoBean();
        HttpSession session = request.getSession(false);
        if(session!=null) 
        {if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("failure");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else
             return mapping.findForward("failure");
             lLocCode = obUserInfo.getLLocationCode();
             lEmpNo = obUserInfo.getLEmployeeNo();
             String butAction = oSPMForm.getSAction();
             ActionErrors errors = new ActionErrors();

            if(butAction.equals("Load"))
           {          
            try
             {                
                List cList1 = new ArrayList();
                //System.out.println("It is in"+butAction);
                
                 cList1=oSPMBD.getValues(lLocCode);    
                if(!cList1.isEmpty())
                {
                    oSPMForm.setLstMNameValues(cList1);
                    oSPMForm.setLstMNameLabels(cList1);               
                }
                else
                {
                    errors.add("error", new ActionError("Finance.LocCode.NotFound"));
                }
            }
            catch ( IBAFatalException ibafe )
            {    
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibafe.getErrorKey()));
            }
            catch ( IBABusinessException ibabe )
            {
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibabe.getErrorKey()));
            }        
            catch ( IBAException ibae )
            {
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibae.getErrorKey()));
            } 

            catch (NullPointerException npe)
            {
            }

            saveErrors(request,errors);
            return mapping.findForward("success"); 
            
        }

          if(butAction.equals("Display"))
        {
        try
            {   
                
                oSPMVO.setLstModuleName(oSPMForm.getLstModuleName());
                oSPMVO=oSPMBD.displayDesc(oSPMVO);
                oSPMForm.setTxtGrpDesc(oSPMVO.getTxtGrpDesc());
                oSPMForm.setTxtModule(oSPMVO.getTxtModule());
                iLCCode=oSPMForm.getLstModuleName();
            
                List cList3 = new ArrayList();
                //String sDescQuery3="SELECT EMP_NO FROM SYSADMIN_USER_LOC where LOC_STAT_FLG='A' AND LOC_ID='"+lLocCode+"'"+"minus SELECT DISTINCT(EMP_NO) FROM SYSADMIN_EMP_SCREEN_MAP WHERE LOC_ID='"+lLocCode+"'AND SCREEN_ID="+iLCCode1;
                String sDescQuery3="SELECT EMP_NO FROM SYSADMIN_USER_LOC where LOC_STAT_FLG='A' AND LOC_ID='"+lLocCode+"'"+"minus SELECT DISTINCT(EMP_NO) FROM sysadmin_grp_emp_mst WHERE grp_sdesc='"+iLCCode+"'";
  
                cList3=oSPMBD.getValues3(sDescQuery3);
                oSPMForm.setLstUnMapLabels(cList3);
                oSPMForm.setLstUnMapValues(cList3);    
           
             
                 List cList4 = new ArrayList();
                 //System.out.println("It is in"+butAction);
                 String sDescQuery4="SELECT DISTINCT(EMP_NO) FROM sysadmin_grp_emp_mst WHERE grp_sdesc='"+iLCCode+"'";

                 cList4=oSPMBD.getValues3(sDescQuery4); 
                 oSPMForm.setLstMapLabels(cList4);
                 oSPMForm.setLstMapValues(cList4);
                                
                request.setAttribute("oSPMForm",oSPMForm);
                oSPMForm.setSAction("Load"); 
                /*oSPMForm.getLstMapValues().clear();
                oSPMForm.getLstMapLabels().clear();
                oSPMForm.getLstUnMapValues().clear();
                oSPMForm.getLstUnMapLabels().clear();*/
            }
            catch ( IBAFatalException ibafe )
            {    
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibafe.getErrorKey()));
            }
            catch ( IBABusinessException ibabe )
            {
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibabe.getErrorKey()));
            }        
            catch ( IBAException ibae )
            {
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibae.getErrorKey()));
            } 
             catch (NullPointerException npe)
            {
            }

            saveErrors(request,errors);
            return mapping.findForward("success"); 

        }

          if(butAction.equals("Save"))
        {
            try
            {
                if(oSPMForm.setVO())
                oSPMVO=oSPMForm.getVO();
                oSPMVO.setlEmployeeNo(lEmpNo);
                oSPMVO.setlLocationCode(lLocCode);
                errors.clear();
                //System.out.println("It is in save before BD");
                iLCCode=oSPMForm.getLstModuleName();
                iLCCode1=oSPMForm.getLstScreenName();
       
                if(oSPMBD.saveDetails(oSPMVO,iLCCode,iLCCode1))
                {
                   oSPMForm.reset(mapping,request);
                    errors.add("error",new ActionError("Finance.Insert.Success"));
                    saveErrors(request,errors);
                    oSPMForm.setSAction("Load");
                    return mapping.findForward("success");
                }
                    request.setAttribute("oSPMForm",oSPMForm);
                    oSPMForm.getLstMapValues().clear();
                    oSPMForm.getLstMapLabels().clear();
                    oSPMForm.getLstUnMapValues().clear();
                    oSPMForm.getLstUnMapLabels().clear();

            }

         catch ( IBAFatalException ibafe )
            {    
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibafe.getErrorKey()));
            }
         catch ( IBABusinessException ibabe )
            {
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibabe.getErrorKey()));
            }        
        catch ( IBAException ibae )
            {
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibae.getErrorKey()));
            } 
        catch (NullPointerException npe)
            {
            }

            saveErrors(request,errors);
            return mapping.findForward("success"); 

        }

          if(butAction.equals("Reset"))
        {
            request.setAttribute("oSPMForm",oSPMForm);
            oSPMForm.getLstMNameValues().clear();
            oSPMForm.getLstMNameLabels().clear();
            oSPMForm.getLstSNameValues().clear();
            oSPMForm.getLstSNameLabels().clear();
            oSPMForm.setTxtGrpDesc(null);
            oSPMForm.setTxtModule(null);
            oSPMForm.getLstMapValues().clear();
            oSPMForm.getLstMapLabels().clear();
            oSPMForm.getLstUnMapValues().clear();
            oSPMForm.getLstUnMapLabels().clear();
            saveErrors(request,errors);
            return mapping.findForward("success"); 

            
        }
             
        return mapping.findForward("failure");        
    }
}