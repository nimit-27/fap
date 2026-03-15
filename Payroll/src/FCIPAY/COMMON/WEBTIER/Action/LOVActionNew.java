/*
 * Program Name : CreateLovAction.java
 * Author       : Neeraj.G
 * Date Written : 05/10/2010
 * Description  : This is the Action Class for the Create User Screen
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
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.webtier.form.NewLovForm;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.VO.NewLovVO;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.CreateUserDAO;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.xml.vo.LOVInfo;
import java.util.StringTokenizer;
import FCIPAY.Payroll.common.businessdelegate.LOVBD;


public class LOVActionNew extends Action  {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        NewLovForm oNewLovForm = (NewLovForm)form;
        NewLovVO oNewLovVO=new NewLovVO();
        LovQueryVO oLOVQueryVO= new LovQueryVO();
        
        LovVO oLovVO=new LovVO();
        LOVInfo oLOVInfo = FCIPAY.Payroll.common.utility.LOVManager.getInstance().getCachedObject(oNewLovForm.getLovKey());
        ActionErrors errors=new ActionErrors();
        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;// = new UserInfoBean();
        if(session!=null) 
        {
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("ErrorPage");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else 
            return mapping.findForward("ErrorPage");
      if(oNewLovForm.getTxtHidAction().equals("FirstTime"))
      {
        oNewLovForm.setTxtHidTotCols(-1);
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }
       else if(oNewLovForm.getTxtHidAction().equals("SearchRecords")) 
        {
            LOVBD oLOVBD = new LOVBD();
            CreateUserDAO oCreateUserDAO=new CreateUserDAO();
            try
            {
                // code added by swapnendu Dt 24 Aug 2011 to send queryParameter in LOV function call start
                StringTokenizer stParameters= new StringTokenizer(oNewLovForm.getQueryParam(),",");
                String sKeyValuePair;
                while(stParameters.hasMoreTokens())
                {
                  sKeyValuePair=stParameters.nextToken();
                  StringTokenizer stKeyVal= new StringTokenizer(sKeyValuePair ,"=");
                  String sKey=null;
                  String sValue=null;
                  while(stKeyVal.hasMoreTokens())
                  {
                    sKey=stKeyVal.nextToken();
                    sValue=stKeyVal.nextToken();
                  }
                  oLOVQueryVO.setProperty(sKey,sValue);
                }
              oLOVQueryVO.setSearchField1(oNewLovForm.getSearchField1());
              oLOVQueryVO.setSearchField2(oNewLovForm.getSearchField2());
              oLOVQueryVO.setSearchField3(oNewLovForm.getSearchField3());
              oLOVQueryVO.setSearchField4(oNewLovForm.getSearchField4()); // added by devendra on 16th aug 2010
              oLOVQueryVO.setSearchField5(oNewLovForm.getSearchField5());
              oLOVQueryVO.setSearchField6(oNewLovForm.getSearchField6());
              oLovVO = oLOVBD.getLOVData(oLOVInfo,oLOVQueryVO);
               if(oLovVO.getDetailList().size() >0)
                {
                  BeanUtils.copyProperties(oNewLovForm,oLovVO);
                  oNewLovForm.setTxtHidTotRows(oLovVO.getDetailList().size());
                  oNewLovForm.setTxtHidTotCols(oLovVO.getHeaderList().size());
                }
                else
                {
                  oNewLovForm.setTxtHidTotRows(-1);  
                  oNewLovForm.setTxtHidTotCols(-1);
                }
                oNewLovForm.setTxtHidSubmitFirst("false");
                oNewLovForm.setInsertFlag(oLOVInfo.getInsertFlag()); 
            }
            catch(Exception e) 
            {
                errors.clear();
                errors.add("error",new ActionError("Common.Database.Error"));
                saveErrors(request,errors);
                e.printStackTrace();    
            }
        }
        System.out.println("Sucess full");
        return mapping.findForward("success");
    }
}