/*    
    * Module:        ComputeAction.java 
    * Author:        Arunava Chanda
    * Date Written:  August 2005
    * Description:   Action Class for Adhoc Transactions
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.Payroll.WEBTIER.Action;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.ECSDataFileReportBD;
import FCIPAY.Payroll.WEBTIER.Form.ECSDataFileForm;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.UTILITY.ECSDataFileHdrBean;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.EJB.common.session.UserSession;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

public class ECSDataAction  extends BaseAction
{
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */

  public ECSDataAction() 
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {  
    BaseForm oBaseForm = (BaseForm)form;        
    ECSDataFileReportBD oECSDataFileReportBD = new ECSDataFileReportBD();
    ECSDataFileForm oECSDataFileForm = (ECSDataFileForm)form;
    ECSDataFileHdrBean oECSDataFileHdrBean = new ECSDataFileHdrBean();
    ECSDataFileForm fedoForm = (ECSDataFileForm)oBaseForm;   

    String sFormName = form.getClass().getName(); //Get fully qualified form class
//    BaseQueryVO oBaseQueryVO = getQueryVO(form); //Create new query vo instance
    
      long lUserID = 200; 
      long lSiteID = 200;

//      UserSession oUser = getUserSessionBean(request);
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }

//    BeanUtils.copyProperties(oECSDataFileHdrBean,oECSDataFileForm);

/*    oECSDataFileHdrBean.setTxtECSDataFileYYMM(oECSDataFileForm.getTxtYYMM());
    oECSDataFileHdrBean.settxtSponserBankMICRNo(oECSDataFileForm.gettxtSponserBankMICRNo());
    oECSDataFileHdrBean.settxtUserAccountNo(oECSDataFileForm.gettxtUserAccountNo());
    oECSDataFileHdrBean.setTxtUserNumber(oECSDataFileForm.getTxtUserNumber());
    oECSDataFileHdrBean.settxtUserName(oECSDataFileForm.gettxtUserName());
    oECSDataFileHdrBean.settxtCreditTransCode(oECSDataFileForm.gettxtCreditTransCode());
    oECSDataFileHdrBean.settxtCreditContraTransCode(oECSDataFileForm.gettxtCreditContraTransCode());
    oECSDataFileHdrBean.settxtMICRTransCode(oECSDataFileForm.gettxtMICRTransCode());    
    oECSDataFileHdrBean.settxtSettlementDate(oECSDataFileForm.gettxtSettlementDate());
    oECSDataFileHdrBean.settxtDeliveredTotalAmt(oECSDataFileForm.gettxtDeliveredTotalAmt());
    oECSDataFileHdrBean.settxtCreditContraDesc(oECSDataFileForm.gettxtCreditContraDesc());  */
    
    //oECSDataFileHdrBean.se
    
      String sHdnVal = fedoForm.getHdnAction();
      String sHdnOption = fedoForm.getHdnOption();
      
      if (sHdnVal.equals("SUB")) 
      {               
//           String oErrorCode = new String();    
          BeanUtils.copyProperties(oECSDataFileHdrBean,oECSDataFileForm);
          String oErrorCode; 
          if (sHdnOption.equals("ECSData"))
            oErrorCode = oECSDataFileReportBD.GenEcsData(oECSDataFileHdrBean,lUserID,lSiteID);
          else
            oErrorCode = oECSDataFileReportBD.GenSBIData(oECSDataFileHdrBean,lUserID,lSiteID);          
    
          fedoForm.setHdnAction("");
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(oErrorCode));
          fedoForm.setHdnDataLoad("Save");
          fedoForm.setScreenMode("U");
          fedoForm.setHdnMessage(new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments).getKey());
          fedoForm.setHdnMessage(oArguments.toString()); 
          throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
      }
      else if (sHdnVal.equals("S")) 
      {
            fedoForm.setHdnOption(sHdnOption);
            if (sHdnOption.equals("ECSData"))
              throw new EnrgiseApplicationException("Pay.ECS.Data.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
            else 
              throw new EnrgiseApplicationException("Pay.SBI.Data.Progress.Message",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);                    
            
      }      
                            
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);    
  
  }
  
}