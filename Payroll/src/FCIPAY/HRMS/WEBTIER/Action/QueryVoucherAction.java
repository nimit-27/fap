/* 
 * Module:        QueryVoucherAction.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This Action Class is the Entry doing the operations in Query Screen used by all Voucher Screens
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.HRMS.WEBTIER.Form.QueryVoucherForm;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.QueryVoucherBD;

public class QueryVoucherAction extends Action 
{

   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
      QueryVoucherForm oQueryVoucherForm=(QueryVoucherForm) form;
      /*
         This IF Condition gets satisfied when the Query button in all voucher screen is pressed
       */
      QueryVoucherBD oQueryVoucherBD=new QueryVoucherBD();
      ActionErrors errors=new ActionErrors();
      if(oQueryVoucherForm.gettxtHidAction().equals("SearchQuery")) {
         int totRows=0;
         try {
             UserInfoBean obUserInfo;// = new UserInfoBean();
             HttpSession session = request.getSession(false);
             if(session!=null) {
//                 session.setAttribute("USERINFO",obUserInfo);
                 if(session.getAttribute("USERINFO") == null)
                    return mapping.findForward("SessionExpired");
                 else
                    obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
             }
              else 
                 return mapping.findForward("SessionExpired"); 
            oQueryVoucherForm.getlstSearchResult().clear();
            oQueryVoucherForm.setselRadio("");
            totRows=oQueryVoucherBD.getQueryResults_BD(obUserInfo.getLEmployeeNo(),obUserInfo.getLLocationCode(),oQueryVoucherForm.gettxtTransStatus(),oQueryVoucherForm.getlstSearchResult());
            oQueryVoucherForm.settxtHidTotRows(Integer.toString(totRows));
            oQueryVoucherForm.setTxtSMS("");
         }
         catch(IBABusinessException ibaBus) 
         {
            ExceptionHandling(ibaBus.getErrorKey(),request,errors);
         }
         catch(IBAFatalException ibaFat) 
         {
            ExceptionHandling(ibaFat.getErrorKey(),request,errors);
         }
         catch(Exception exp) 
         {
            ExceptionHandling("Finance.UnKnown.Administrator",request,errors);
         }
         oQueryVoucherForm.settxtHidAction("");         
         return mapping.findForward("SamePage");
      }
      else if(oQueryVoucherForm.gettxtHidAction().equals("ClearValues")) {
         oQueryVoucherForm.getlstSearchResult().clear();
         oQueryVoucherForm.setselRadio("");
         oQueryVoucherForm.settxtHidTotRows("");
         oQueryVoucherForm.setTxtSMS("Submit");
      }
      return mapping.findForward("Same");
   }
   /**
    * Method    Handles the Exception part
    * @param1   Message
    * @param2   HttpServletRequest
    */
   private void ExceptionHandling(String Message,HttpServletRequest request,ActionErrors errors) 
   {
      errors.clear();
      errors.add("error",new ActionError(Message));
      saveErrors(request,errors);
   }
}