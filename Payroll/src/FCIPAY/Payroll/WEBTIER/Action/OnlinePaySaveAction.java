package FCIPAY.Payroll.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PostSalInvToAPBD;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PostSalaryInvToAPForm;
import FCIPAY.Payroll.WEBTIER.Form.OnlinePaySlipReportForm;
import FCIPAY.Payroll.WEBTIER.Form.AnnualCPFReportForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.OnlinePayReportBD;
import FCIPAY.Payroll.WEBTIER.Form.PensionDetailRepForm;

public class OnlinePaySaveAction extends BaseAction
{
  public OnlinePaySaveAction()
  {
  }

 public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      long lUserID = 200;
      long lSiteID = 200;
      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else
      {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        lUserID = obUserInfo.getLEmployeeNo();
        lSiteID = obUserInfo.getLLocationCode();
      }
      
         
         
         if(sScreenName.equalsIgnoreCase("OnlinePaySlipReport"))
         {
                   OnlinePaySlipReportForm onlinePaySlipReportForm = (OnlinePaySlipReportForm)oBaseForm;
                   String txtEmpno= onlinePaySlipReportForm.getTxtEmpNo();
                   String txtPwd = onlinePaySlipReportForm.getTxtCPFDDYYMM();
                   String sitecode=onlinePaySlipReportForm.getTxtSiteCode();
                   OnlinePayReportBD onlinePayReportBD=(OnlinePayReportBD)oBaseBD;				  
                   String oErrorCode =onlinePayReportBD.validateUser(onlinePaySlipReportForm.getTxtEmpNo(),onlinePaySlipReportForm.getTxtCPFDDYYMM(),onlinePaySlipReportForm.getTxtYYMM(),sitecode,onlinePaySlipReportForm.getHdnEmpLbrFlag());
				 
                    if(oErrorCode.equalsIgnoreCase("Invalid User"))
                    {                          
                            onlinePaySlipReportForm.setTxtCPFDDYYMM("");
                           
                            onlinePaySlipReportForm.setScreenMode("Q");
                            ArrayList oArguments = new ArrayList();
                            oArguments.add(new String(oErrorCode));
                            throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
                    }
                   else if(oErrorCode.equalsIgnoreCase("Month End Updation is in Progress"))
                    {  
                            onlinePaySlipReportForm.setScreenMode("Q");
                            onlinePaySlipReportForm.setTxtCPFDDYYMM("");
                            ArrayList oArguments = new ArrayList();
                            oArguments.add(new String(oErrorCode));
                            throw new EnrgiseApplicationException("Pay.Online.Payroll_ERROR",oArguments);
                    }
                  else if(oErrorCode.equalsIgnoreCase("Valid User"))
                     {
                            String value="correct user";      
                            request.setAttribute("ERROR_MSG",value);
                            onlinePaySlipReportForm.setTxtCPFDDYYMM(txtPwd);
                            onlinePaySlipReportForm.setTxtSiteCode(sitecode);
                     }
                    
         }else if(sScreenName.equalsIgnoreCase("PensionDetailReport")){
             PensionDetailRepForm pensionDetailRepForm = (PensionDetailRepForm)oBaseForm;
             String txtEmpNo = pensionDetailRepForm.getTxtEmp();
             String txtPwd = pensionDetailRepForm.getTxtCPFDDYYMM();
             String sitecode=pensionDetailRepForm.getTxtSiteID();
             OnlinePayReportBD onlinePayReportBD=(OnlinePayReportBD)oBaseBD;
             String oErrorCode =onlinePayReportBD.validateUser(txtEmpNo,pensionDetailRepForm.getTxtCPFDDYYMM(),pensionDetailRepForm.getTxtYYMM(),sitecode,pensionDetailRepForm.getHdnEmpLbrFlag());
             
                    if(oErrorCode.equalsIgnoreCase("Invalid User"))
                   {
                           pensionDetailRepForm.setTxtCPFDDYYMM("");
                           pensionDetailRepForm.setScreenMode("Q");
                           pensionDetailRepForm.setTxtResult("Invalid");
                           ArrayList oArguments = new ArrayList();
                           oArguments.add(new String(oErrorCode));
                           throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
                   }
                   else if(oErrorCode.equalsIgnoreCase("Valid User"))
                    {
                           String value="correct user";      
                           request.setAttribute("ERROR_MSG",value);
                           pensionDetailRepForm.setTxtResult("correct");
                           pensionDetailRepForm.setTxtCPFDDYYMM(txtPwd);
                           pensionDetailRepForm.setTxtSiteID(sitecode);
                    }
         
         }
         else{
                  AnnualCPFReportForm annualCPFReportForm = (AnnualCPFReportForm)oBaseForm;
                  String txtEmpNo = annualCPFReportForm.getTxtEmpNo();
                  String txtPwd = annualCPFReportForm.getTxtCPFDDYYMM();
                  String sitecode=annualCPFReportForm.getTxtSiteCode();
                  OnlinePayReportBD onlinePayReportBD=(OnlinePayReportBD)oBaseBD;
                  String oErrorCode =onlinePayReportBD.validateUser(txtEmpNo,annualCPFReportForm.getTxtCPFDDYYMM(),annualCPFReportForm.getTxtYYMM(),sitecode,annualCPFReportForm.getHdnEmpLbrFlag());
                  
                         if(oErrorCode.equalsIgnoreCase("Invalid User"))
                        {
                                annualCPFReportForm.setTxtCPFDDYYMM("");
                                annualCPFReportForm.setScreenMode("Q");
                                ArrayList oArguments = new ArrayList();
                                oArguments.add(new String(oErrorCode));
                                throw new EnrgiseApplicationException("Pay.Undo.Payroll_ERROR",oArguments);
                        }
                        else if(oErrorCode.equalsIgnoreCase("Valid User"))
                         {
                                String value="correct user";      
                                request.setAttribute("ERROR_MSG",value);
                                annualCPFReportForm.setTxtCPFDDYYMM(txtPwd);
                                annualCPFReportForm.setTxtSiteCode(sitecode);
                         }
          
         }
       
          return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);         
    
  }

}