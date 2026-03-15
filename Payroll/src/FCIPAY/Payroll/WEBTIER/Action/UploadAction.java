    /*
     * Module       :   UploadAction.java
     * Author       :   V.Jegan
     * Date Written :   30th Sept 2003
     * Description  :   The Action class file for the upload.jsp page
     *                  which handles all the operations of the page
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */


package FCIPAY.Payroll.WEBTIER.Action;
import FCIPAY.Payroll.WEBTIER.Form.UploadForm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UploadVO;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.UploadBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ErrorMessageVO;
import FCIPAY.COMMON.UTILITY.*;
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
import java.util.Calendar;
import org.apache.struts.upload.FormFile;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.UserInfoBean;


public class UploadAction extends Action 
{

    public UploadAction() 
    {
        
    }

    /**
    * This is the main action called from the Struts framework.
    * @param mapping The ActionMapping used to select this instance.
    * @param form The optional ActionForm bean for this request.
    * @param request The HTTP Request we are processing.
    * @param response The HTTP Response we are processing.
    */
    HttpSession session;
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, IBAException, Exception
    {
        UploadVO oUploadVO=new UploadVO();
        UploadBD oUploadBD=new UploadBD();
        UploadForm oUploadForm=(UploadForm)form;
        ActionErrors errors = new ActionErrors();
        UploadForm myForm = (UploadForm)form;
        FormFile myFile = myForm.getTheFile();
        String fileName    = myFile.getFileName();
        String contentType = myFile.getContentType();
        int fileSize       = myFile.getFileSize();
        byte[] fileData    = myFile.getFileData();
       // System.out.println("File Name: " + fileName);
      //  System.out.println("File Size: " + fileSize);
       //   System.out.println("File Size: " + fileData.length);
       // System.out.println("File Path :" +myForm.getTheFile());

        
        


//=======================Checking the UserInfo Bean class========================
/*        UserInfoBean obUserInfo;// = new UserInfoBean();
        HttpSession session = request.getSession(false);
        if(session!=null) 
        {
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("failure");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else
             return mapping.findForward("failure");  */

              oUploadVO.setOptReportType(oUploadForm.getOptReportType());
              if (oUploadForm.getOptReportType().equals("3"))
                  oUploadVO.setTxtEmpField(oUploadForm.getTxtEmpField());

              UserInfoBean obUserInfo = new UserInfoBean();
              if(request.getSession().getAttribute("USERINFO")==null)
              {
                oUploadVO.setUserEmpNo(180302);
                oUploadVO.setUserLocId(93);     
              }
              else{
                obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                oUploadVO.setUserEmpNo(obUserInfo.getLEmployeeNo());
                oUploadVO.setUserLocId(obUserInfo.getLLocationCode());                
/*                lUserID = obUserInfo.getLEmployeeNo();
                lSiteID = obUserInfo.getLLocationCode(); */
      }             


//==================Uploading the UserInfo bean values to the VO====================
//        oUploadVO.setUserEmpNo(obUserInfo.getLEmployeeNo());
//        oUploadVO.setUserLocId(obUserInfo.getLLocationCode());



//=================Values to be checked and loaded on the Form Load================
/*        if(oUploadForm.getUploadAction().equals("onLoad")) 
        {
            oUploadForm.setErrLineNo(0);
            if((oUploadBD.getAccCode(oUploadVO)))
            {
                oUploadForm.setListAccCode(oUploadVO.getListAccCode());
            }
            else
                return mapping.findForward("failure");
        } */

//================Process for Uploading the Form===================================

        ErrorMessageVO oErrorMessageVO = new ErrorMessageVO(); 
        if(oUploadForm.getUploadAction().equals("upload"))
        {
            Calendar c= Calendar.getInstance();
            long l1=c.getTime().getTime();
            oUploadVO.setLstAccCode(oUploadForm.getLstAccCode());
         //   oUploadVO.setFile(oUploadForm.getFile());
            try
            {

                oErrorMessageVO = oUploadBD.setDetails(oUploadVO,myFile);
                if(oErrorMessageVO.isBErrorFlag())
                {
                    oUploadForm.setErrLineNo(0);
                    oUploadForm.setLstAccCode(0);
                    errors.clear();
                    ArrayList oArguments = new ArrayList();
                    String sErrorMsg = "Upload Done Successfully. " + oErrorMessageVO.getErrorCode();
                    oArguments.add(sErrorMsg);                                        
//                    errors.add("error", new ActionError("Payroll.Upload.Success"));
                    errors.add("error", new ActionError("Pay.Undo.Payroll_ERROR", oArguments));                    
                    saveErrors(request,errors);  
                }
                else
                {
                    oUploadForm.setErrLineNo(oUploadVO.getErrLineNo());
                    errors.clear();
                    String sErrorMsg = "Upload Done With Errors. " + oErrorMessageVO.getErrorCode();                    
                    ArrayList oArguments = new ArrayList();                    
                    oArguments.add(sErrorMsg);                                                           
//                    oArguments.add(new String(oErrorMessageVO.getErrorCode()));                    
//                  errors.add("error", new ActionError("Payroll.Upload.Failure", oArguments));                    
                    errors.add("error", new ActionError("Pay.Undo.Payroll_ERROR", oArguments));                    
                    saveErrors(request,errors);
                }
            }
            
            catch(IBAFatalException ibaf) 
            {
                oUploadForm.setErrLineNo(oUploadVO.getErrLineNo());                    
                errors.clear();
                if(ibaf.getErrorKey().equals("1"))
                {
                    errors.add("error",new ActionError("Finance.InstrumentNo.Exists"));
                    saveErrors(request,errors);
                }

                else if(ibaf.getErrorKey().equals("1843"))
                {
                    errors.add("error",new ActionError("Finance.Date.Invalid"));
                    saveErrors(request,errors);
                }
                else
                {
                    errors.add("error", new ActionError("Finance.Data.Invaid"));
                    saveErrors(request,errors);
                }
            }

            catch(Exception e)
            {
                oUploadForm.setErrLineNo(oUploadVO.getErrLineNo());
                e.printStackTrace();
                errors.clear();
                errors.add("error", new ActionError("Finance.Upload.Failure"));
                saveErrors(request,errors);
            }
/*            c= Calendar.getInstance();
            long l2=c.getTime().getTime();
            System.out.println("l1 = " + l1);
            System.out.println("l2 = " + l2);
            System.out.println("l2-l1 = " + (l2-l1)); */
        }


        if(oUploadForm.getUploadAction().equals("ActUpload"))
        {
            String retval; 
            retval = oUploadBD.uploadFinal(oUploadVO);   
            errors.clear();

            if(retval.equals("UPLOAD_SUCCESS_EX"))
              errors.add("error", new ActionError("Payroll.Upload.Act.Success"));                                            
//            throw new EnrgiseApplicationException("Payroll.Upload.Act.Success");
            else
              errors.add("error", new ActionError("Payroll.Upload.Act.Failure"));                                            
//            throw new EnrgiseApplicationException("Payroll.Upload.Act.Failure");            

             saveErrors(request,errors);
        }
        

//==================For Reseting the Form ========================================================
        if(oUploadForm.getUploadAction().equals("reset"))
        {
            oUploadForm.setErrLineNo(0);
            oUploadForm.setLstAccCode(0);
            oUploadForm.setFile("");
            oUploadForm.setUploadAction("");
        }
        //System.out.println("Error is on the Line No " + oUploadForm.getErrLineNo());
//        return mapping.findForward("success");
          return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);     
    }
}