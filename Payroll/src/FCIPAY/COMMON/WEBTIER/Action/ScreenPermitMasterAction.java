/* 
    * Module:        ScreenPermitMasterAction.java 
    * Author:        Gaurav Arora  
    * Date Written:  11/2004    
    * Description:   Action class for Permit Master Screen
    * Revision Log   (mm/dd/yy initials description) 
    * -------------------------------------------------------- 
    * mm/dd/yy xxx  What you changed … 
*/ 


package FCIPAY.COMMON.WEBTIER.Action;
import FCIPAY.COMMON.WEBTIER.Form.ScreenPermitMasterForm;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.ScreenPermitMasterBD;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ScreenPermitMasterVO;
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
import FCIPAY.COMMON.DATAACCESSTIER.VO.SA_ScreenEmpMapVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.SA_ScreenEmpMapDAO;

public class ScreenPermitMasterAction extends Action
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
    ScreenPermitMasterForm oSPMForm=(ScreenPermitMasterForm)form;
    ScreenPermitMasterBD oSPMBD=new ScreenPermitMasterBD();
    ScreenPermitMasterVO oSPMVO=new ScreenPermitMasterVO();
    SA_ScreenEmpMapDAO osaDAO=new SA_ScreenEmpMapDAO();
    SA_ScreenEmpMapVO osaVO=new SA_ScreenEmpMapVO();


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
                osaVO=osaDAO.getOnLoadDtls(obUserInfo.getLLocationCode());
                oSPMForm.setEmpList(osaVO.getEmpList());
                oSPMForm.setModuleList(osaVO.getModuleList());
                //oSPMForm.setHdnFocus("");
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
            saveErrors(request,errors);
            return mapping.findForward("success"); 
            
        }


        if(butAction.equals("List"))
        {
        try
            {
            iLCCode=oSPMForm.getLstModuleName();
            iLCCode1=oSPMForm.getHdnID();
            List cList3 = new ArrayList();
            String sDescQuery3="SELECT um.EMP_NO||' ('||lm.loc_desc||')' EMP_NO,um.EMP_NO||':'||lm.loc_id  EMP_LOC FROM SYSADMIN_USER_LOC ul,sysadmin_user_mst um,com_loc_mst lm where ul.emp_no=um.emp_no and um.emp_stat_flg='A' and LOC_STAT_FLG='A' and lm.loc_id=ul.loc_id minus SELECT DISTINCT sm.EMP_NO||' ('|| lm.loc_desc||')' EMP_NO,sm.EMP_NO || ':' || lm.loc_id EMP_LOC FROM SYSADMIN_EMP_SCREEN_MAP sm,com_loc_mst lm WHERE sm.SCREEN_ID="+iLCCode1+" and lm.loc_id=sm.loc_id";
            cList3=oSPMBD.getValues3(sDescQuery3);
            oSPMForm.setLstUnMapLabels((List)cList3.get(0));
            oSPMForm.setLstUnMapValues((List)cList3.get(1));
            
            
           
             
             List cList4 = new ArrayList();
             System.out.println("It is in"+butAction);
             String sDescQuery4="SELECT DISTINCT sm.EMP_NO||' ('|| lm.loc_desc||')'EMP_NO,sm.EMP_NO||':'||lm.loc_id  EMP_LOC FROM SYSADMIN_EMP_SCREEN_MAP sm,com_loc_mst lm WHERE sm.SCREEN_ID="+iLCCode1+" and lm.loc_id=sm.loc_id";
             cList4=oSPMBD.getValues3(sDescQuery4); 
             oSPMForm.setLstMapLabels((List)cList4.get(0));
             oSPMForm.setLstMapValues((List)cList4.get(1));
             request.setAttribute("oSPMForm",oSPMForm);
             oSPMForm.setSAction("Load");
         //    oSPMForm.setChkSelect("");
             oSPMForm.setHdnCount("0");
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
                System.out.println("It is in save before BD");
                iLCCode=oSPMForm.getLstModuleName();
                iLCCode1=oSPMForm.getHdnID();
       
                if(oSPMBD.saveDetails(oSPMVO,iLCCode,iLCCode1))
                {
                   oSPMForm.reset(mapping,request);
                    errors.add("error",new ActionError("Finance.Insert.Success"));
                    saveErrors(request,errors);
                    oSPMForm.setSAction("Load");
                     request.setAttribute("oSPMForm",oSPMForm);
                    oSPMForm.getLstMapValues().clear();
                    oSPMForm.getLstMapLabels().clear();
                    oSPMForm.getLstUnMapValues().clear();
                    oSPMForm.getLstUnMapLabels().clear();
                    oSPMForm.getHeaderList().clear();
                  //  oSPMForm.getModuleList().clear();
                    oSPMForm.setLstModule("");
                    oSPMForm.getMenuList().clear();
                    oSPMForm.setHdnCount("0");
                    oSPMForm.setDescTable("0");
                      return mapping.findForward("success");
                }
                    

            }

         catch ( IBAFatalException ibafe )
            {    
              ibafe.printStackTrace();
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibafe.getErrorKey()));
            }
         catch ( IBABusinessException ibabe )
            {
            ibabe.printStackTrace();
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibabe.getErrorKey()));
            }        
        catch ( IBAException ibae )
            {
            ibae.printStackTrace();
                oSPMForm.setSAction("Load");
                errors.add("error", new ActionError(ibae.getErrorKey()));
            } 
            catch(Exception e) 
            {
              e.printStackTrace();
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
            oSPMForm.getLstMapValues().clear();
            oSPMForm.getLstMapLabels().clear();
            oSPMForm.getLstUnMapValues().clear();
            oSPMForm.getLstUnMapLabels().clear();
            oSPMForm.setChkSelect("");
            oSPMForm.getMenuList().clear();
            oSPMForm.getHeaderList().clear();
            oSPMForm.setHdnCount("");
            oSPMForm.setHdnID("");
            oSPMForm.getModuleList().clear();
            oSPMForm.setDescTable("0");
            saveErrors(request,errors);
            return mapping.findForward("success"); 

            
        }
    
                
        if(butAction.equals("Display"))
        {
             ArrayList headList=new ArrayList();
            //oSPMForm.getAssignedList().clear();
            oSPMForm.getMenuList().clear();
            try 
            {
                headList=osaDAO.getHeaderDtls(oSPMForm.getLstModule());
                oSPMForm.setHeaderList(headList);
                //osaMapForm.setHdnFocus("lstHeader");
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
            saveErrors(request,errors);
            return mapping.findForward("success"); 

        }
      
       if(butAction.equals("GetLevels"))
       {
            ArrayList levelList=new ArrayList();
            try 
            {
               String sQuery= "SELECT T1.SCREENACCESS_ID, T1.LEVEL1, T1.LEVEL2, T1.LEVEL3  FROM SYSADMIN_SCREENACCESS_MST T1 WHERE T1.MODULE_NAME = ? AND T1.HEADER_NAME = ?"+
                               "  ORDER BY LEVEL1, LEVEL2, LEVEL3 ";

                levelList=oSPMBD.getLevels(sQuery,oSPMForm.getLstModule(),oSPMForm.getLstHeader());                                
                if(levelList.size()>0)
                {
                    oSPMForm.setMenuList(levelList);
                    oSPMForm.setDescTable("1");
                }
                else
                {
                    errors.clear();
                    errors.add("error",new ActionError("Common.SAMaster.NoScreenList"));
                    saveErrors(request,errors);
                    oSPMForm.getMenuList().clear();
                }
                //oSPMForm.setAssignedList(osaVO.getAssignedList());
                //oSPMForm.setHdnDelCnt(osaVO.getAssignedList().size());
            }
            catch(IBAFatalException e) 
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.Database.Error"));
                saveErrors(request,errors);
            }
            catch(Exception e) 
            {
                e.printStackTrace();    
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }
        
    return mapping.findForward("success");
    }
}
