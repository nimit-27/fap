/*
 * Program Name : GroupMasterAction.java
 * Author       : Jegan.V
 * Date Written : 29/07/2004
 * Description  : This is Action class of UserLocation Master Screen
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

import FCIPAY.COMMON.WEBTIER.Form.UsrLocMastForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.COMMON.DATAACCESSTIER.VO.UsrLocMastVO;
import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.UsrLocMastBD;
import FCIPAY.COMMON.UTILITY.comboBean;
import FCIPAY.COMMON.UTILITY.UsrLocationBean;

public class UsrLocMastAction extends Action 
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
        
        UsrLocMastVO oUsrLocVO=new UsrLocMastVO();
        UsrLocMastBD oUsrLocBD=new UsrLocMastBD();

        UsrLocMastForm oUsrLocForm = (UsrLocMastForm)form;

        ArrayList listTemp=null;

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

//=================ON LOADING THE PAGE TO GET THE LIST OF EMP NO AND THE LOCATION===================
        if(oUsrLocForm.getHdnAction().equals("OnLoad"))
        {
            try
            {
                oUsrLocVO=oUsrLocBD.getOnLoadDtls();
                oUsrLocForm.setHdnRowCount(0);
                oUsrLocForm.setEmpList(oUsrLocVO.getEmpList());
                oUsrLocForm.setLocList(oUsrLocVO.getLocList());
            }
            catch(Exception e)
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }

//=================TO GET THE EMPLOYEE NAME AFTER SELECTING THE EMPLOYEE NUMBER=======================
        if(oUsrLocForm.getHdnAction().equals("GetEmpDtls"))
        {
            listTemp=new ArrayList();
            oUsrLocForm.setTxtEmpName(getDescription(oUsrLocForm.getEmpList(),oUsrLocForm.getLstEmpNo()));
            try
            {
                listTemp=oUsrLocBD.getUsrLocDtls(oUsrLocForm.getLstEmpNo());
                oUsrLocForm.setAssignedList(listTemp);
                oUsrLocForm.setHdnRowCount(listTemp.size());
                oUsrLocForm.setRadSelect("");
            }
            catch(Exception e)
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }

//=================TO GET THE LOCATION DESC AFTER SELECTING THE LOCATION CODE=======================
        if(oUsrLocForm.getHdnAction().equals("GetLocDtls"))
        {
            int flag=0;
            if(oUsrLocForm.getAssignedList().size()>0)
            {
                long locCode=oUsrLocForm.getLstLocation();
                for(int i=0;i<oUsrLocForm.getAssignedList().size();i++)
                {
                    if(locCode==((UsrLocationBean)oUsrLocForm.getAssignedList().get(i)).getLocCode())
                    {
                        oUsrLocForm.setLstLocation(0);
                        errors.clear();
                        errors.add("error",new ActionError("Common.UsrLocMaster.Exists"));
                        saveErrors(request,errors);
                        flag=1;
                        break;
                    }
                }
            }
            //for getting the location description
            if(flag==0)
                oUsrLocForm.setTxtLocDesc(getDescription(oUsrLocForm.getLocList(),oUsrLocForm.getLstLocation()));
        }

//=================================ON SAVING THE FORM VALUES========================================
        if(oUsrLocForm.getHdnAction().equals("Save"))
        {
            listTemp=new ArrayList();
            UsrLocMastVO oUsrLocMastVO=new UsrLocMastVO();
            try
            {
                int prevListCnt=oUsrLocForm.getAssignedList().size();

                oUsrLocMastVO.setLstEmpNo(oUsrLocForm.getLstEmpNo());
                oUsrLocMastVO.setLstLocation(oUsrLocForm.getLstLocation());
                oUsrLocMastVO.setLstStatus(oUsrLocForm.getLstStatus());
                oUsrLocMastVO.setUserEmpNo(obUserInfo.getLEmployeeNo());
                oUsrLocMastVO.setUserLocId(obUserInfo.getLLocationCode());
                
                listTemp=oUsrLocBD.saveUsrLocDtls(oUsrLocMastVO);

                System.out.println("Previous list Size is " + prevListCnt);
                System.out.println("Current list Size is " + listTemp.size());
                
                if((prevListCnt+1)==listTemp.size())
                {
                    oUsrLocForm.setAssignedList(listTemp);
                    oUsrLocForm.setHdnRowCount(listTemp.size());
                    ResetRow(oUsrLocForm);

                    errors.clear();
                    errors.add("error",new ActionError("Common.SAMaster.Success"));
                    saveErrors(request,errors);
                }
                else
                {
                    errors.clear();
                    errors.add("error",new ActionError("Common.DB.Administrator"));
                    saveErrors(request,errors);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
        }


//=================================ON REPLACING THE ROW VALUES========================================
        if(oUsrLocForm.getHdnAction().equals("ReplaceRow"))
        {
            //System.out.println("Hdn Id is " + oUsrLocForm.getHdnUsrLocId());
            listTemp=new ArrayList();
            UsrLocMastVO oUsrLocMastVO=new UsrLocMastVO();
            try
            {
                oUsrLocMastVO.setHdnUsrLocId(oUsrLocForm.getHdnUsrLocId());
                oUsrLocMastVO.setLstStatus(oUsrLocForm.getLstStatus());
                oUsrLocMastVO.setUserEmpNo(obUserInfo.getLEmployeeNo());
                oUsrLocMastVO.setUserLocId(obUserInfo.getLLocationCode());
                oUsrLocMastVO.setLstEmpNo(((UsrLocationBean)oUsrLocForm.getAssignedList().get(0)).getEmpNo());
                
                listTemp=oUsrLocBD.updateUsrLocDtls(oUsrLocMastVO);

                //System.out.println("Form size is : " + oUsrLocForm.getAssignedList().size());
                //System.out.println("The List size is " + listTemp.size());

                if(oUsrLocForm.getAssignedList().size()==listTemp.size())
                {
                    oUsrLocForm.setAssignedList(listTemp);
                    oUsrLocForm.setHdnRowCount(listTemp.size());
                    ResetRow(oUsrLocForm);

                    errors.clear();
                    errors.add("error",new ActionError("Common.SAMaster.Update"));
                    saveErrors(request,errors);
                }
                else
                {
                    errors.clear();
                    errors.add("error",new ActionError("Common.DB.Administrator"));
                    saveErrors(request,errors);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                errors.clear();
                errors.add("error",new ActionError("Common.DB.Administrator"));
                saveErrors(request,errors);
            }
            oUsrLocForm.setRadSelect("");
        }
        

//=================================ON RESET OF THE FORM========================================
        if(oUsrLocForm.getHdnAction().equals("Reset"))
        {
            oUsrLocForm.getAssignedList().clear();
            oUsrLocForm.setHdnRowCount(0);
            oUsrLocForm.getEmpList().clear();
            oUsrLocForm.getLocList().clear();
            oUsrLocForm.setHdnAction("");
            ResetRow(oUsrLocForm);
        }
        
        return mapping.findForward("success");
    }


    /**
     * This function is to loop the arraylist to find the desc where we are having the id
     * The main thing is the arraylist which should be having elements of the type ComboBean
     * @param-id which will be an input
     * @ouput-desc which will be an output for the corresponding Id.
     */

     public String getDescription(ArrayList templist,long Id)
     {
         String desc="";
         for(int i=0;i<templist.size();i++)
         {
             if(Id==((comboBean)templist.get(i)).getIdLong())
             {
                desc=((comboBean)templist.get(i)).getCode();
                break;
             }
         }
         return desc;
     }

    /**
     * This function is to Reset the Master Row
     */
     public void ResetRow(UsrLocMastForm oUsrLocForm)
     {
        oUsrLocForm.setLstEmpNo(0);
        oUsrLocForm.setLstLocation(0);
        oUsrLocForm.setTxtEmpName("");
        oUsrLocForm.setTxtLocDesc("");
        oUsrLocForm.setLstStatus("");
     }
}