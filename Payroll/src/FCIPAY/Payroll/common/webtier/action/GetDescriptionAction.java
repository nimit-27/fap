package FCIPAY.Payroll.common.webtier.action;
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
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.WEBTIER.Form.MaintainExternalSavingsForm;
import FCIPAY.Payroll.WEBTIER.Form.PaySlipReportForm;
import FCIPAY.Payroll.WEBTIER.Form.PayITForecastForm;
import FCIPAY.Payroll.WEBTIER.Form.PayITForecastProjForm;
import FCIPAY.Payroll.WEBTIER.Form.MaintainDirectPayrollForm;
import FCIPAY.Payroll.WEBTIER.Form.HistoryEntryForm;
import FCIPAY.Payroll.WEBTIER.Form.MaintainInternalSavingsForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.GetDescriptionBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainExternalSavingsBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainDirectPayrollBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.HistoryEntryBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainInternalSavingsBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayReportBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class GetDescriptionAction extends BaseAction
{
  public GetDescriptionAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {  

      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      UserSession oUser = getUserSessionBean(request);
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = null;
      long lPageRequested = 1;
      boolean bLimitReached = false;
      ArrayList oDetailList = null;



      if(oBaseDetailVO != null)
      {
        if(oBaseDetailVO.getOThisPageData().size() >= oDetailSizeValues.getDetailRecordPerPage())
        {
          bLimitReached = true;
        }
        // Detail exists check if save required
        if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
        {
          if(oBaseDetailVO.getOThisPageData() != null)
          {
              oDetailList = getDetailArray(oBaseForm);
          }
          else
          {
            oBaseDetailVO.setOThisPageData(new ArrayList());
          }
        }
    }

//      oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);              

      oBaseDetailBean = getDetailBean(form);

      long lUserId = 0;
      long lSiteId = 0; 
      String sUserName = ""; 

      UserInfoBean obUserInfo = new UserInfoBean();
      if(request.getSession().getAttribute("USERINFO")==null){}
      else{
      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
      lUserId = obUserInfo.getLEmployeeNo();
      lSiteId = obUserInfo.getLLocationCode();
      sUserName = obUserInfo.getSEmployeeName();
      }


      if(oDetailList != null)
      {
//        oDetailList.add(oBaseDetailBean);
        oBaseDetailVO.setOThisPageData(oDetailList);
      }

//      oBaseDetailVO.getOAllPageData().add(oBaseDetailBean);
      if(oDetailList != null)
      {
        oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
        oBaseForm.setDetailDataChanged(true);
        BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
        BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());       
      }    
      
      String sEmpNum;
      if (sScreenName.equals("ExternalScreen")) 
      {

        MaintainExternalSavingsForm oExForm = (MaintainExternalSavingsForm)form;         

        if (oExForm.getHdnAction().equals("GetEmpName"))
        {
          sEmpNum = oExForm.getTxtEmpNo1();
          MaintainExternalSavingsBD oMaintainExternalSavingsBD =(MaintainExternalSavingsBD)oBaseBD;
          String sEmpName = oMaintainExternalSavingsBD.sGetEmpName(sEmpNum, lUserId); 
          oExForm.setTxtEmpName1(sEmpName);        
        }

        if (oExForm.getHdnAction().equals("GetEmpNameDtl"))
        {
          sEmpNum = oExForm.getHdnEmpNo();
          MaintainExternalSavingsBD oMaintainExternalSavingsBD =(MaintainExternalSavingsBD)oBaseBD;
          String sEmpName = oMaintainExternalSavingsBD.sGetEmpName(sEmpNum, lUserId);           
          oExForm.setHdnEmpName(sEmpName);
        }    

        if (oExForm.getHdnAction().equals("GetPayCodeName"))
        {
          String sPayCode; 
          sPayCode = oExForm.getTxtSavCode1();
          MaintainExternalSavingsBD oMaintainExternalSavingsBD =(MaintainExternalSavingsBD)oBaseBD;
          String sPayCodeName = oMaintainExternalSavingsBD.sGetPayCodeName(sPayCode); 
          oExForm.setTxtSavCodeName(sPayCodeName);        
        }

        if (oExForm.getHdnAction().equals("GetPayCodeNameDtl"))
        {
          String sPayCode;         
          sPayCode = oExForm.getHdnPayCode();
          MaintainExternalSavingsBD oMaintainExternalSavingsBD =(MaintainExternalSavingsBD)oBaseBD;
          String sPayCodeName = oMaintainExternalSavingsBD.sGetPayCodeName(sPayCode);           
          oExForm.setHdnPayCodeName(sPayCodeName);
        }                
      }      



      if (sScreenName.equals("DirectPayrollScreen")) 
      {

        MaintainDirectPayrollForm oExForm = (MaintainDirectPayrollForm)form;         

        if (oExForm.getHdnAction().equals("GetEmpName"))
        {
          sEmpNum = oExForm.getTxtEmpNo1();
          MaintainDirectPayrollBD oMaintainDirectPayrollBD =(MaintainDirectPayrollBD)oBaseBD;
          String sEmpName = oMaintainDirectPayrollBD.sGetEmpName(sEmpNum); 
          oExForm.setTxtName1(sEmpName);        
        }

        if (oExForm.getHdnAction().equals("GetEmpNameDtl"))
        {
          sEmpNum = oExForm.getHdnEmpNo();
          String  sEmplbr = oExForm.getHdnEmpLbrFlag();
          MaintainDirectPayrollBD oMaintainDirectPayrollBD =(MaintainDirectPayrollBD)oBaseBD;
        //  String sEmpName = oMaintainDirectPayrollBD.sGetEmpName(sEmpNum); 
          String sEmpName = oMaintainDirectPayrollBD.sGetEmpNumchk(sEmpNum,lSiteId,sEmplbr);  
          oExForm.setHdnEmpName(sEmpName);
        }    

        if (oExForm.getHdnAction().equals("GetPayCodeName"))
        {
          String sPayCode; 
          sPayCode = oExForm.getTxtPayCode1();
          MaintainDirectPayrollBD oMaintainDirectPayrollBD =(MaintainDirectPayrollBD)oBaseBD;
          String sPayCodeName = oMaintainDirectPayrollBD.sGetPayCodeName(sPayCode); 
          oExForm.setTxtPayCodeName(sPayCodeName);        
        }

        if (oExForm.getHdnAction().equals("GetPayCodeNameDtl"))
        {
          String sPayCode;         
          sPayCode = oExForm.getHdnPayCode();
          MaintainDirectPayrollBD oMaintainDirectPayrollBD =(MaintainDirectPayrollBD)oBaseBD;
          String sPayCodeName = oMaintainDirectPayrollBD.sGetPayCodeName(sPayCode);           
          oExForm.setHdnPayCodeName(sPayCodeName);
        }                
      }      


      if (sScreenName.equals("InternalScreen")) 
      {

        MaintainInternalSavingsForm oExForm = (MaintainInternalSavingsForm)form;         

        if (oExForm.getHdnAction().equals("GetEmpName"))
        {
          sEmpNum = oExForm.getTxtEmpNo1();
          MaintainInternalSavingsBD oMaintainInternalSavingsBD =(MaintainInternalSavingsBD)oBaseBD;
          String sEmpName = oMaintainInternalSavingsBD.sGetEmpName(sEmpNum); 
          oExForm.setTxtEmpName1(sEmpName);        
        }

        if (oExForm.getHdnAction().equals("GetEmpNameDtl"))
        {
          sEmpNum = oExForm.getHdnEmpNo();
          MaintainInternalSavingsBD oMaintainInternalSavingsBD =(MaintainInternalSavingsBD)oBaseBD;
          String sEmpName = oMaintainInternalSavingsBD.sGetEmpName(sEmpNum);           
          oExForm.setHdnEmpName(sEmpName);
        }    

        if (oExForm.getHdnAction().equals("GetPayCodeName"))
        {
          String sPayCode; 
          sPayCode = oExForm.getTxtSavCode1();
          MaintainInternalSavingsBD oMaintainInternalSavingsBD =(MaintainInternalSavingsBD)oBaseBD;
          String sPayCodeName = oMaintainInternalSavingsBD.sGetPayCodeName(sPayCode); 
          oExForm.setTxtSavCodeName(sPayCodeName);        
        }

        if (oExForm.getHdnAction().equals("GetPayCodeNameDtl"))
        {
          String sPayCode;         
          sPayCode = oExForm.getHdnPayCode();
          MaintainInternalSavingsBD oMaintainInternalSavingsBD =(MaintainInternalSavingsBD)oBaseBD;
          String sPayCodeName = oMaintainInternalSavingsBD.sGetPayCodeName(sPayCode);           
          oExForm.setHdnPayCodeName(sPayCodeName);
        }                
      }      


    if (sScreenName.equals("PaySlipReport")) 
    {
        PaySlipReportForm oPaySlipReportForm = (PaySlipReportForm)form;             
        PayReportBD oPayReportBD =(PayReportBD)oBaseBD;
        String sAccPriv = oPayReportBD.sGetPaySlipAcc(lUserId);           
        oPaySlipReportForm.setHdnPayUser(sAccPriv);
        oPaySlipReportForm.setHdnLoginUserId(String.valueOf(lUserId));
        oPaySlipReportForm.setHdnLoginUserName(sUserName);
    }

    if (sScreenName.equals("PayITForecastReport")) 
    {
        PayITForecastForm oPayITForecastForm = (PayITForecastForm)form;             
        PayReportBD oPayReportBD =(PayReportBD)oBaseBD;
        String sAccPriv = oPayReportBD.sGetITForecastAcc(lUserId);           
        oPayITForecastForm.setHdnPayUser(sAccPriv);
        oPayITForecastForm.setHdnLoginUserId(String.valueOf(lUserId));
        oPayITForecastForm.setHdnLoginUserName(sUserName);
        oPayITForecastForm.setScreenMode("Q");
    }    


    if (sScreenName.equals("HistoryEntryScreen")) 
      {

        HistoryEntryForm oExForm = (HistoryEntryForm)form;  

       if (oExForm.getHdnAction().equals("GetPayCodeNameDtl"))
        {
          String sPayCode;         
          sPayCode = oExForm.getHdnPayCode();
          HistoryEntryBD oHistoryEntryBD =(HistoryEntryBD)oBaseBD;
          String sPayCodeName = oHistoryEntryBD.sGetPayCodeName(sPayCode);           
          oExForm.setHdnPayCodeName(sPayCodeName);
        }                
      }
    
      
//      UserSession oUser = getUserSessionBean(request);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);                
  }
}