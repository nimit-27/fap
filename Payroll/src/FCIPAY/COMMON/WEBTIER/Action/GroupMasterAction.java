/*
 * Program Name : GroupMasterAction.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is Action class of Group Master 
*/

package FCIPAY.COMMON.WEBTIER.Action;
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

import java.util.ArrayList;

import FCIPAY.COMMON.WEBTIER.Form.GroupMasterForm;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.GroupMasterDAO;
import FCIPAY.COMMON.DATAACCESSTIER.VO.GroupMasterVO;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.UserInfoBean;


public class GroupMasterAction extends Action  
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        ActionErrors errors=new ActionErrors();
        GroupMasterDAO oGrpDAO=new GroupMasterDAO();
        GroupMasterVO oGrpVO=new GroupMasterVO();
        
        GroupMasterForm oGrpForm = (GroupMasterForm)form;
        
//===================For checking the userInfobean is expired or not===================

        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;// = new UserInfoBean();
        if(session!=null) 
        {
            //session.setAttribute("USERINFO",obUserInfo);
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("ErrorPage");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else 
            return mapping.findForward("ErrorPage");

            
//=======For Getting the values on the Load the previously created Groups==========

        if(oGrpForm.getHdnAction().equals("OnLoad")) 
        {
            try
            {
                oGrpVO=oGrpDAO.getOnLoadDtls(obUserInfo.getLLocationCode());
                oGrpForm.setModuleList(oGrpVO.getModuleList());
                oGrpForm.setGrpList(oGrpVO.getGrpList());
                oGrpForm.setHdnGrpCnt(oGrpVO.getGrpList().size());
            }
            catch(IBAFatalException ibafe) 
            {
                //ibafe.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }


//=======================For Replacing the Row values ============================

        if(oGrpForm.getHdnAction().equals("ReplaceRow")) 
        {
            oGrpVO=oGrpForm.createVO();
            oGrpVO.setUserId(obUserInfo.getLEmployeeNo());
            oGrpVO.setLocId(obUserInfo.getLLocationCode());
            
            try 
            {
                ArrayList tempList=new ArrayList();
                tempList=oGrpDAO.UpdateGrpDtls(oGrpVO);
                if(tempList.size()>0)
                {
                    oGrpForm.setGrpList(tempList);
                    oGrpForm.setHdnGrpCnt(tempList.size());
                    errors.clear();
                    errors.add("error",new ActionError("Common.SAMaster.Update"));
                    saveErrors(request,errors);
                }
            }
            catch(IBAFatalException ibafe) 
            {
                errors.clear();
                errors.add("error",new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch(Exception e) 
            {
                //e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
            oGrpForm.setTxtDesc("");
            oGrpForm.setTxtGrpSDesc("");
            oGrpForm.setLstStatus("");
            oGrpForm.setRadSelect("");
        }


//=======================For Saving the Group values ============================

        if(oGrpForm.getHdnAction().equals("Save")) 
        {
            oGrpVO=oGrpForm.createVO();
            oGrpVO.setUserId(obUserInfo.getLEmployeeNo());
            oGrpVO.setLocId(obUserInfo.getLLocationCode());
            
            try 
            {
                ArrayList tempList=new ArrayList();
                tempList=oGrpDAO.saveGrpDtls(oGrpVO);
                if(tempList.size()>0)
                {
                    oGrpForm.setGrpList(tempList);
                    oGrpForm.setHdnGrpCnt(tempList.size());                    
                    errors.clear();
                    errors.add("error",new ActionError("Common.SAMaster.Success"));
                    saveErrors(request,errors);
                }
            }
            catch(IBAFatalException ibafe) 
            {
                errors.clear();
                if(ibafe.getErrorKey().equals("1"))
                    errors.add("error",new ActionError("Common.SAMaster.UK"));
                else
                    errors.add("error",new ActionError(ibafe.getErrorKey()));
                saveErrors(request,errors);
            }
            catch(Exception e) 
            {
                //e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
            oGrpForm.setTxtDesc("");
            oGrpForm.setTxtGrpSDesc("");
            oGrpForm.setLstStatus("");
            oGrpForm.setRadSelect("");
            oGrpForm.setLstModule("");
        }


//=======================For Replacing the Row values ============================

        if(oGrpForm.getHdnAction().equals("Reset")) 
        {
            oGrpForm.setHdnGrpCnt(0);
            oGrpForm.setHdnAction("");
            oGrpForm.setTxtDesc("");
            oGrpForm.setTxtGrpSDesc("");
            oGrpForm.getGrpList().clear();
            oGrpForm.setLstStatus("");
            oGrpForm.setRadSelect("");
            oGrpForm.setLstModule("");
        }
        return mapping.findForward("success");
    }
}