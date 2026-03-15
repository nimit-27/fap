
/*
 * Program Name : SA_ScreenEmpMapAction.java
 * Author       : Jegan.V
 * Date Written : 08/03/2004
 * Description  : This is the Action Class which does the action performed on the jsp page.
 *
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

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.WEBTIER.Form.SA_ScreenEmpMapForm;
import FCIPAY.COMMON.DATAACCESSTIER.VO.SA_ScreenEmpMapVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.SA_ScreenEmpMapDAO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class SA_ScreenEmpMapAction extends Action  
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
//    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,IBAFatalException
      public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, EnrgiseSystemException, EnrgiseApplicationException
    {
        ActionErrors errors=new ActionErrors();
        SA_ScreenEmpMapDAO osaDAO=new SA_ScreenEmpMapDAO();
        SA_ScreenEmpMapVO osaVO=new SA_ScreenEmpMapVO();
        

        SA_ScreenEmpMapForm osaMapForm = (SA_ScreenEmpMapForm)form;

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


//===================OnLoading to get the Employee list and Module List===================

        if(osaMapForm.getHdnAction().equals("OnLoad")) 
        {
            try 
            {
                osaVO=osaDAO.getOnLoadDtls(obUserInfo.getLLocationCode());
                osaMapForm.setEmpList(osaVO.getEmpList());
                osaMapForm.setModuleList(osaVO.getModuleList());
                osaMapForm.setHdnFocus("");
            }
/*            catch(IBAFatalException e) 
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
            }  */

              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              
            
        }


//===================To get the Employee list after entering from the Text box===================

        if(osaMapForm.getHdnAction().equals("GetEmpLst")) 
        {
            try 
            {
                ArrayList empLikeList=new ArrayList();
                empLikeList=osaDAO.getEmpLikeList(obUserInfo.getLLocationCode(),osaMapForm.getTxtEmpNo());
                osaMapForm.setEmpList(empLikeList);
                osaMapForm.setHdnEmpName("");
                osaMapForm.setHdnDept("");
                osaMapForm.setHdnDesig("");
                osaMapForm.setHdnFocus("lstEmpNo");
            }
/*            catch(IBAFatalException e) 
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
            }  */

              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              

            
        }

//===================For getting the Employee Details based on selecting Emp No===================

        if(osaMapForm.getHdnAction().equals("GetEmpDtls")) 
        {
            osaMapForm.getAssignedList().clear();
            osaMapForm.getMenuList().clear();
            ArrayList locList=new ArrayList();
            
            try 
            {
                locList=osaDAO.getEmpDtls(osaMapForm.getLstEmpNo());
               // osaMapForm.setHdnEmpName(osaVO.getHdnEmpName());
               // osaMapForm.setHdnDept(osaVO.getHdnDept());
               // osaMapForm.setHdnDesig(osaVO.getHdnDesig());
                osaMapForm.setLocList(locList);
                osaMapForm.setHdnFocus("lstLoc");   
            }
/*            catch(IBAFatalException e) 
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
            }  */
              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              

            
            osaMapForm.setLstHeader("");
            osaMapForm.setLstModule("");
            osaMapForm.getMenuList().clear();
            osaMapForm.getAssignedList().clear();
            osaMapForm.setHdnDelCnt(0);
        }


//===================For getting the Header based on selecting the module===================

        if(osaMapForm.getHdnAction().equals("GetHeader")) 
        {
            ArrayList headList=new ArrayList();
            osaMapForm.getAssignedList().clear();
            osaMapForm.getMenuList().clear();
            try 
            {
                headList=osaDAO.getHeaderDtls(osaMapForm.getLstModule());
                osaMapForm.setHeaderList(headList);
                osaMapForm.setHdnFocus("lstHeader");
            }
/*            catch(IBAFatalException e) 
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
            }  */
              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              

            
        }


//===================For getting the Levels based on selecting the Header===================

        if(osaMapForm.getHdnAction().equals("GetLevels")) 
        {
            ArrayList levelList=new ArrayList();
            try 
            {
                osaVO=osaDAO.getLevelDtls(osaMapForm.getLstModule(),osaMapForm.getLstHeader(),osaMapForm.getLstEmpNo(),osaMapForm.getLstLoc());
                if(osaVO.getMenuList().size()>0)
                {
                    osaMapForm.setMenuList(osaVO.getMenuList());
                }
                else
                {
                    errors.clear();
                    errors.add("error",new ActionError("Common.SAMaster.NoScreenList"));
                    saveErrors(request,errors);
                    osaMapForm.getMenuList().clear();
                }
                osaMapForm.setAssignedList(osaVO.getAssignedList());
                osaMapForm.setHdnDelCnt(osaVO.getAssignedList().size());
            }
/*            catch(IBAFatalException e) 
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
            }  */

              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              
            
        }

//===================For Saving the Screen Details for the Employee===========================================

        if(osaMapForm.getHdnAction().equals("Save")) 
        {
            long[] selScreenId = new long[osaMapForm.getHdnScreenCnt()];
            long[] delScreenEmpId=new long[osaMapForm.getHdnDelCnt()];
            long[] delScreenId=new long[osaMapForm.getHdnDelCnt()]; //added by swapnendu Dt 12.12.2012 
            int j=0;
            int k=0;
            int l=0;
            
            for(int i=0;i<osaMapForm.getHdnScreenId().length;i++) 
            {
                if(osaMapForm.getHdnCheck()[i].equals("y"))
                    selScreenId[j++]=osaMapForm.getHdnScreenId()[i];
                if(osaMapForm.getHdnCheck()[i].equals("d"))
                {
                    delScreenEmpId[k++]=osaMapForm.getHdnScreenId()[i];
                    System.out.println("osaMapForm.getHdnAudScreenId()[i]=="+osaMapForm.getHdnAudScreenId()[i]);
                    delScreenId[l++]=osaMapForm.getHdnAudScreenId()[i];
                }
            }
           /* System.out.println("The Screen Id to be saved are as ");
            for(j=0;j<selScreenId.length;j++)
                System.out.println(selScreenId[j]);

            System.out.println("The ScreenEmp Id to be deleted are as ");
            for(j=0;j<delScreenEmpId.length;j++)
                System.out.println(delScreenEmpId[j]);*/

            //storing the values in the VO
            osaVO.setLstEmpNo(osaMapForm.getLstEmpNo());
            osaVO.setUserEmpNo(obUserInfo.getLEmployeeNo());
            osaVO.setLstLoc(osaMapForm.getLstLoc());
            osaVO.setUserSiteId(obUserInfo.getLLocationCode());
            osaVO.setHdnScreenId(selScreenId);
            osaVO.setHdnDelScreenEmpId(delScreenEmpId);
            osaVO.setHdnAudScreenId(delScreenId); //added by swapnendu Dt 12.12.2012
            try
            {
                if(osaDAO.saveDtls(osaVO)) 
                {
                    errors.clear();
                    errors.add("error",new ActionError("Common.SARights.Success"));
                    saveErrors(request,errors);
                }
                osaMapForm.getMenuList().clear();
                osaMapForm.getAssignedList().clear();
                osaMapForm.setHdnCheck(null);
                osaMapForm.setHdnScreenId(null);
                osaMapForm.setHdnAudScreenId(null);  //added by swapnendu Dt 12.12.2012
                osaMapForm.setHdnScreenCnt(0);
                osaMapForm.setHdnDelCnt(0);
                osaMapForm.setChkSelect("");
                osaMapForm.setChkDel("");
                osaMapForm.setLstHeader("");
            }
/*            catch(IBAFatalException e) 
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
            }  */

              catch(EnrgiseApplicationException e)
              {
                e.printStackTrace();
              }                  
              catch(EnrgiseSystemException e)
              {
                e.printStackTrace();
              }              
             catch(Exception e) 
             {
                e.printStackTrace();
            }              
            
        }

//===================For Reseting the Screen===========================================

        if(osaMapForm.getHdnAction().equals("Reset")) 
        {
            ResetForm(osaMapForm);
        }
        
        return mapping.findForward("success");
    }


    public void ResetForm(SA_ScreenEmpMapForm osaMapForm) 
    {
        osaMapForm.setHdnAction("");
        osaMapForm.setHdnDept("");
        osaMapForm.setHdnDesig("");
        osaMapForm.setHdnEmpName("");        
        osaMapForm.getHeaderList().clear();
        osaMapForm.getEmpList().clear();
        osaMapForm.getMenuList().clear();
        osaMapForm.getModuleList().clear();
        osaMapForm.setLstEmpNo(0);
        osaMapForm.setLstHeader("");
        osaMapForm.setLstModule("");
        osaMapForm.setHdnCheck(null);
        osaMapForm.setHdnScreenId(null);
        osaMapForm.setChkSelect("");
        osaMapForm.setChkDel("");
        osaMapForm.setHdnScreenCnt(0);
        osaMapForm.setHdnDelCnt(0);
        osaMapForm.setTxtEmpNo(0);
    }

}