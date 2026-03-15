package FCIPAY.HRMS.WEBTIER.Action;
/*
 * Module:        LeaveMastAction.java
 * Author:        Moon Nag Sarkar
 * Date Written:  13/09/2003
* Description:  action called from the Struts framework class that calls methods in other classes based on the action after which the form is submitted
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;


import FCIPAY.COMMON.UTILITY.UserInfoBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.lang.String;
import java.lang.Long;
import FCIPAY.COMMON.UTILITY.*;
import java.sql.SQLException;

import  FCIPAY.HRMS.WEBTIER.Form.LeaveMastForm;
import  FCIPAY.HRMS.DATAACCESSTIER.VO.LeaveMastVO;
import  FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.LeaveMastBD;
import  FCIPAY.HRMS.UTILITY.DrcrtList;
import java.lang.*;


public class LeaveMastAction extends Action 
{

    
   // private static ArrayList drcrtList=null;
    
     ArrayList oLeaveMastVOs=null;
    public LeaveMastAction()
    {
    }

     public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,IBABusinessException,IBAFatalException,IBAException,SQLException
    {
        LeaveMastForm oForm=(LeaveMastForm) form;
        LeaveMastVO oLeaveMastVO =null,oELeaveMastVO =null;
        LeaveMastBD oLeaveMastBD=null;
//==========================================ADDED============================================
          ArrayList drcrtList=null;
 //=================================================================================================        
        long lEmpNo=0;
        long lLocCode=0;
    
        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo = new UserInfoBean();
        try{
            if(session!=null) {
            //          oSession.setAttribute("USERINFO",obUserInfo);
                if(session.getAttribute("USERINFO") == null)
                    return mapping.findForward("ErrorPage");
                else
                    obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
            }
            else 
                return mapping.findForward("ErrorPage");
        }catch(NullPointerException ne){
            ne.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    
    //obUserInfo = session.getAttribute("USERINFO") == null ? new UserInfoBean():(UserInfoBean)session.getAttribute("USERINFO");

        lEmpNo = obUserInfo.getLEmployeeNo();
        lLocCode = obUserInfo.getLLocationCode();

    ActionErrors oclActionErrors=new ActionErrors();
    ActionForward actionForward=mapping.findForward("success");

    int iProcessFlag=0;
    long oid;

    if(oForm.getsAction().equals("Insert"))
    { 
        try 
            {
                oLeaveMastVO=oForm.createVO();
                oLeaveMastVO.setEmpno(lEmpNo);
                oLeaveMastVO.setLocCode(lLocCode);

                if(oLeaveMastVO!= null)
                {
                        oLeaveMastBD = new LeaveMastBD();
                        if(oLeaveMastBD.setDetails(oLeaveMastVO,iProcessFlag))
                        {    
                          
                            oclActionErrors.clear();      
                            oclActionErrors.add("Insert Failure",new ActionError("HRMS.Insert.Success"));
                            saveErrors(request,oclActionErrors);     
                            
                            return mapping.findForward("success"); 
                        }
                        else
                        {
                            oclActionErrors.clear();      
                            oclActionErrors.add("Insert Failure",new ActionError("HRMS.Insert.Failure"));
                            saveErrors(request,oclActionErrors);          
                        }

                }
    
           }
             catch(IBABusinessException ibae)
             {
                oclActionErrors.clear();      
                oclActionErrors.add("Insert Failure",new ActionError(ibae.getErrorKey()));
                saveErrors(request,oclActionErrors);
             }
            catch(IBAFatalException ifae)
            {
                oclActionErrors.clear();
                oclActionErrors.add("Insert Failure",new ActionError("HRMS.Master.LeaveExists"));
                saveErrors(request,oclActionErrors);
            }
            catch(IBAException ie)
            {
                oclActionErrors.clear();
                oclActionErrors.add("Insert Failure",new ActionError(ie.getErrorKey()));
                saveErrors(request,oclActionErrors);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
     return mapping.findForward("success"); 
 }

 if (oForm.getsAction().equals("Edit")) 
 {
     try
     {

        for (int i=0 ; i< oLeaveMastVOs.size(); i++) 
      {
          oELeaveMastVO = (LeaveMastVO) oLeaveMastVOs.get(i);
      
        if((new Long(oELeaveMastVO.getSLEAVE_ID()).toString()).equals(oForm.getLstSdesc()))
          {
                oELeaveMastVO.setSDISPLAY_FLG(oForm.getLstDisplay());
                oELeaveMastVO.setMAX_LIMIT_FREQ(oForm.getLstMax_Limit_Freq());
                oELeaveMastVO.setSLEAVE_ID(Long.parseLong(oForm.getLstSdesc()));
                oELeaveMastVO.setSLEAVE_SDESC(oForm.getTxtSdesc());
                oELeaveMastVO.setSLEAVE_LDESC(oForm.getTxtLdesc());
                oELeaveMastVO.setSMAX_LIMIT_1(Long.parseLong(oForm.getTxtMax_Limit_1()));
                oELeaveMastVO.setSMAX_LIMIT_2(Long.parseLong(oForm.getTxtMax_Limit_2()));
                oELeaveMastVO.setSMAX_LIMIT_3(Long.parseLong(oForm.getTxtMax_Limit_3()));
                oELeaveMastVO.setSMIN_EXP_REQ(Long.parseLong(oForm.getTxtMin_Exp_Req()));
                oELeaveMastVO.setlstApply(oForm.getlstApply());
              oLeaveMastVOs.remove(i);
              oLeaveMastVOs.add(i,oELeaveMastVO);
                break;
          }
      }
     
          oLeaveMastVO=oForm.createVO();
          oLeaveMastVO.setEmpno(lEmpNo);
          oLeaveMastVO.setLocCode(lLocCode);
          if(oLeaveMastVO!=null)
          {
            oLeaveMastBD = new LeaveMastBD();
            iProcessFlag=1;
            if(oLeaveMastBD.setDetails(oLeaveMastVO,iProcessFlag))
            {    //oForm.setsMode("");
                oForm.setLstDisplay("");
                oForm.setLstMax_Limit_Freq("");
                oForm.setLstSdesc("");
                oForm.setTxtID("");
                oForm.setTxtLdesc("");
                oForm.setTxtMax_Limit_1("");
                oForm.setTxtMax_Limit_2("");
                oForm.setTxtMax_Limit_3("");
                oForm.setTxtMin_Exp_Req("");
                oForm.setTxtSdesc("");
                oForm.setlstApply("");
                oclActionErrors.clear();      
              oclActionErrors.add("Insert Failure",new ActionError("HRMS.Update.Success"));
              saveErrors(request,oclActionErrors);          
            }
            else
            {
              oclActionErrors.clear();      
              oclActionErrors.add("Insert Failure",new ActionError("HRMS.Update.Failure"));
              saveErrors(request,oclActionErrors);          
            }            
            
        }
            return mapping.findForward("success");
     }
         
          catch(IBABusinessException ibae){
        oclActionErrors.clear();      
        oclActionErrors.add("Insert Failure",new ActionError(ibae.getErrorKey()));
        saveErrors(request,oclActionErrors);
      }catch(IBAFatalException ifae){
        oclActionErrors.clear();
        oclActionErrors.add("Insert Failure",new ActionError(ifae.getErrorKey()));
        saveErrors(request,oclActionErrors);
      }catch(IBAException ie){
        oclActionErrors.clear();
        oclActionErrors.add("Insert Failure",new ActionError(ie.getErrorKey()));
        saveErrors(request,oclActionErrors);
      }
      return mapping.findForward("success");
    }
     
    if (oForm.getsAction().equals("Query"))
    {
    try  {
                oForm.setLstDisplay("");
                oForm.setLstMax_Limit_Freq("");
                oForm.setLstSdesc("");
                oForm.setTxtID("");
                oForm.setTxtLdesc("");
                oForm.setTxtMax_Limit_1("");
                oForm.setTxtMax_Limit_2("");
                oForm.setTxtMax_Limit_3("");
                oForm.setTxtMin_Exp_Req("");
                oForm.setTxtSdesc("");
                oForm.setlstApply("");
       drcrtList=new ArrayList();
      
        oLeaveMastBD = new LeaveMastBD();
        drcrtList=oLeaveMastBD.getLeaveDetails();
        System.out.println(drcrtList.size());
         if(drcrtList.size()< 1)
            throw new IBAException("HRMS.Master.RecordNotFound");
         else
            oForm.setDrcrtList(drcrtList);
        oLeaveMastVOs = oLeaveMastBD.getDetails();
   }
    catch(IBAException ie){
        oclActionErrors.clear();
        oclActionErrors.add("Query Failed",new ActionError(ie.getErrorKey()));
        saveErrors(request,oclActionErrors);
      }catch(Exception e){
        oclActionErrors.clear();
        oclActionErrors.add("Query Failed",new ActionError("HRMS.Master.RecordNotFound"));
        saveErrors(request,oclActionErrors);
      }
      return mapping.findForward("success"); 
     
}



if (oForm.getsAction().equals("Reset"))
{
                oForm.setLstDisplay("");
                oForm.setLstMax_Limit_Freq("");
                oForm.setLstSdesc("");
                oForm.setTxtID("");
                oForm.setTxtLdesc("");
                oForm.setTxtMax_Limit_1("");
                oForm.setTxtMax_Limit_2("");
                oForm.setTxtMax_Limit_3("");
                oForm.setTxtMin_Exp_Req("");
                oForm.setTxtSdesc("");
                oForm.setlstApply("");
                oForm.setsMode("Insert");
        return mapping.findForward("success");                 
}





 
  if (oForm.getsAction().equals("Retrieve")){
       
      for (int i=0 ; i< oLeaveMastVOs.size(); i++) 
      {
          oLeaveMastVO = (LeaveMastVO) oLeaveMastVOs.get(i);
          
        if((new Long(oLeaveMastVO.getSLEAVE_ID()).toString()).equals(oForm.getLstSdesc()))
          {
                oForm.setLstDisplay(oLeaveMastVO.getSDISPLAY_FLG());
                oForm.setLstMax_Limit_Freq(oLeaveMastVO.getMAX_LIMIT_FREQ());
               
                oForm.setTxtSdesc(oLeaveMastVO.getSLEAVE_SDESC());
                oForm.setTxtLdesc(oLeaveMastVO.getSLEAVE_LDESC());
                oForm.setTxtMax_Limit_1(Long.toString(oLeaveMastVO.getSMAX_LIMIT_1()));
                oForm.setTxtMax_Limit_2(Long.toString(oLeaveMastVO.getSMAX_LIMIT_2()));
                oForm.setTxtMax_Limit_3(Long.toString(oLeaveMastVO.getSMAX_LIMIT_3()));
                oForm.setTxtMin_Exp_Req(Long.toString(oLeaveMastVO.getSMIN_EXP_REQ()));
                oForm.setlstApply(oLeaveMastVO.getlstApply());
           
          }
       
      }
    
    }
 return mapping.findForward("success");  
}
}