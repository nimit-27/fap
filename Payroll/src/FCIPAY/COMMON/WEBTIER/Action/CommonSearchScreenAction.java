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

import java.util.ArrayList;

import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;

import FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates.CommonSearchScreenBD;
import FCIPAY.COMMON.WEBTIER.Form.CommonSearchScreenForm;

public class CommonSearchScreenAction extends Action 
{
   /**
    * This is the main action called from the Struts framework.
    * @param mapping The ActionMapping used to select this instance.
    * @param form The optional ActionForm bean for this request.
    * @param request The HTTP Request we are processing.
    * @param response The HTTP Response we are processing.
    */
   private CommonSearchScreenBD oCommonSearchScreenBD=null;
   private CommonSearchScreenForm oCommonSearchScreenForm=null;
   private ActionErrors errors=null;

   public CommonSearchScreenAction() throws IBAFatalException
   {
      errors=new ActionErrors();
      oCommonSearchScreenBD=new CommonSearchScreenBD();         
   }
   
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
      oCommonSearchScreenForm=(CommonSearchScreenForm)form;
      if(oCommonSearchScreenForm.gettxtHidAction().equals("LoadingFirst")) 
      {
         oCommonSearchScreenForm.onLoadReset();
         oCommonSearchScreenForm.setselRadio("");
         return mapping.findForward("SamePage");
      }
      else if(oCommonSearchScreenForm.gettxtHidAction().equals("SearchRecords")) 
      {
         String Id=oCommonSearchScreenForm.gettxt_Id();
         String Code=oCommonSearchScreenForm.gettxt_Code();
         String Desc=oCommonSearchScreenForm.gettxt_Desc();
         String TableName=oCommonSearchScreenForm.gettxtTable();
         String IdValue=oCommonSearchScreenForm.gettxtId();
         String DescValue=oCommonSearchScreenForm.gettxtDesc();
         String AddCond=oCommonSearchScreenForm.gettxt_AddCond();
         int totRows=0;
//         System.out.println("Id="+Id+" Desc="+Desc+" Table="+TableName+" IdValue="+IdValue+" DescValue="+DescValue + "AddCond="+AddCond);
         try 
         {
            oCommonSearchScreenForm.getlstSearchResult().clear();
//            System.out.println("In Action ="+AddCond);
            totRows=oCommonSearchScreenBD.SearchRecords_BD(Id,Desc,TableName,IdValue,DescValue,AddCond,oCommonSearchScreenForm.getlstSearchResult());
            oCommonSearchScreenForm.settxtHidTotRows(Integer.toString(totRows));
         }
         catch(IBABusinessException ibaBus) 
         {
            ExceptionHandling(ibaBus.getErrorKey(),request);
         }
         catch(IBAFatalException ibaFat) 
         {
            ExceptionHandling(ibaFat.getErrorKey(),request);
         }
         catch(Exception exp) 
         {
            ExceptionHandling("Finance.UnKnown.Administrator",request);
         }         
         oCommonSearchScreenForm.settxtHidAction("");
         return mapping.findForward("SamePage");
      }
      return mapping.findForward("success");
   }
   
   private void ExceptionHandling(String Message,HttpServletRequest request) 
   {
      errors.clear();
      errors.add("error",new ActionError(Message));
      saveErrors(request,errors);
   }
}