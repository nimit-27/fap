package FCIPAY.Payroll.WEBTIER.Action;
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
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.lang.reflect.InvocationTargetException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CPFFinalPaymentBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CPFNewPaymentBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentBean;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class CPFPaymentAction extends BaseAction
{
  public CPFPaymentAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      BaseHeaderVO oBaseHeaderVO = null;
      UserSession oUser = getUserSessionBean(request);
      CPFNewPaymentBD   oCPFNewPaymentBD = null;
      CPFFinalPaymentBD oCPFFinalPaymentBD = null;
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   
      String errMsg = "";
      CPFFinalPaymentForm fedoForm = (CPFFinalPaymentForm)oBaseForm;    
      
       if(sScreenName.equals("CPFNewPaymentScreen"))
      {
               oCPFNewPaymentBD =(CPFNewPaymentBD)oBaseBD;;
              
          }
          else
          {
         oCPFFinalPaymentBD=(CPFFinalPaymentBD)oBaseBD;
            
          }
      
      
      lUserID = fedoForm.getLoginEmployeeNo();
      lSiteID = fedoForm.getLoginLocCode();
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(lUserID) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(lSiteID) );
      String hdnAction=fedoForm.getHdnAction();
      if(hdnAction.equals("relCPFPay"))
      {
         // CPFFinalPaymentBean oCPFFinalPaymentBean=new CPFFinalPaymentBean();
       
          if(sScreenName.equals("CPFNewPaymentScreen"))
          {
              errMsg = oCPFNewPaymentBD.releasePay(oBaseHeaderBean);
              
          }
          else
          {
          errMsg = oCPFFinalPaymentBD.releasePay(oBaseHeaderBean);
            
          }
         String [] errCode=errMsg.split(",",2);
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(errCode[1]));
          if(errCode[0].equals("0"))
          {
            
             //Code to Fetch the data after process.
            CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
            BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
              fedoForm.setHeaderDataChanged(false);
              fedoForm.setDetailDataChanged(false);
        
              BaseQueryVO oBaseQueryVO = oCPFFinalPaymentQueryVO;
              if(fedoForm.isHeaderFields())
              {      
                  if(fedoForm.getPositionRequested() > 0)
                  {
                    // A particular header position requested so ignore the primary key
                    if(sScreenName.equals("CPFNewPaymentScreen"))
                    {
                         oBaseHeaderVO = oCPFNewPaymentBD.getNextHeaderRecord(oBaseQueryVO,fedoForm.getPositionRequested(),sFormName,true,oUser);
                    }
                    else
                    {
                         oBaseHeaderVO = oCPFFinalPaymentBD.getNextHeaderRecord(oBaseQueryVO,fedoForm.getPositionRequested(),sFormName,true,oUser);
                    }
 
                   
                    int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
                    BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
                    BeanUtils.copyProperties(form,oBaseHeaderVO);
                  }
                  else
                  {
                    // Only this particular record is required
                   // oBaseQueryVO = getQueryVO(form);
        
                    BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  //  oBaseQueryVO.setHeaderPrimaryKey(sHeaderPrimaryKey);
                    oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
                     if(sScreenName.equals("CPFNewPaymentScreen"))
                    {
                         oBaseHeaderVO = oCPFNewPaymentBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
                         
                    }
                    else
                    {
                         oBaseHeaderVO = oCPFFinalPaymentBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
                    }

            
                    BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                    BeanUtils.copyProperties(form,oBaseHeaderVO);
                  }
              }
              
              oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);   
              
              //Code to fetch the detail information again...............(added by geetika)start on 16/12/2013
            
             if(!fedoForm.getScreenName().equals("CPFFinalPaymentScreen") && !fedoForm.getScreenName().equals("CPFNewPaymentScreen")&& !fedoForm.getScreenName().equals("CPFAdvanceScreen")&& !fedoForm.getScreenName().equals("CPFPartFinalPayScreen"))
              {
                DetailSizeValues oDetailSizeValues = new DetailSizeValues();
                oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
                oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
                BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
                BaseDetailVO oBaseDetailVO = null;
                String sHeaderPrimaryKey="";
                if(null == oBaseDetailInfo)
                {
                  oBaseDetailVO = oCPFFinalPaymentBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser);        
                }
                else
                {               
                  BeanUtils.copyProperties(oBaseDetailInfo,form);
                  UserInfoBean obUserInfo = new UserInfoBean();
                  if(request.getSession().getAttribute("USERINFO")==null){}
                  else
                  {
                    obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                    oBaseDetailInfo.setUserId(obUserInfo.getLEmployeeNo());
                    oBaseDetailInfo.setSiteId(obUserInfo.getLLocationCode());
                  }
                  
                  oBaseDetailVO = oCPFFinalPaymentBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser,oBaseDetailInfo);
                }
                /* Changed by Basu */
                //oBaseForm.setDetailStartPage(1);
                if(oBaseDetailVO.getOThisPageData() != null)
                {        
                  BeanUtils.setProperty(fedoForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
                }
                /* Changed by Basu */
                fedoForm.setPageRequested(1);
                fedoForm.setThisPageDetailCount((null != oBaseDetailVO.getOThisPageData())?oBaseDetailVO.getOThisPageData().size():0);
                //BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);
                 
               long totDetRecord=oBaseDetailVO.getTotalDetailRecord();
               long totRecPerPage=FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName);
               
               if(totDetRecord%totRecPerPage!=0)
               {
                 fedoForm.setTotalPageCount(totDetRecord/totRecPerPage+1);
               }
               if(totDetRecord%totRecPerPage!=0 && totDetRecord<totRecPerPage)
               {
                 fedoForm.setTotalPageCount(totDetRecord/totRecPerPage+1);
               }
                if(totDetRecord%totRecPerPage==0)
               {
                 fedoForm.setTotalPageCount(totDetRecord/totRecPerPage);
               }
            }
            throw new EnrgiseApplicationException("Payroll.CPF.AvdPartFinal.ReleasePay.Success");
          }
          else
          {
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }
      }
      if(hdnAction.equals("getFinalDtls"))
      {
          CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
          BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
          oCPFFinalPaymentQueryVO.setUserId(lUserID);
          oBaseHeaderBean = oCPFFinalPaymentBD.getFinalDtls(oCPFFinalPaymentQueryVO);
          CPFFinalPaymentBean oCPFFinalPaymentBean= (CPFFinalPaymentBean)oBaseHeaderBean;
          fedoForm.setEmpContri(oCPFFinalPaymentBean.getEmpContri());
          fedoForm.setEmplyrContri(oCPFFinalPaymentBean.getEmplyrContri());
          fedoForm.setVpfContri(oCPFFinalPaymentBean.getVpfContri());
          fedoForm.setIntrstEmpContri(oCPFFinalPaymentBean.getIntrstEmpContri());
          fedoForm.setIntrstEmplyrContri(oCPFFinalPaymentBean.getIntrstEmplyrContri());
          fedoForm.setIntrstVpfContri(oCPFFinalPaymentBean.getIntrstVpfContri());
          fedoForm.setIntrstIntrvngPrd(oCPFFinalPaymentBean.getIntrstIntrvngPrd());
          fedoForm.setTdsIntIntrvngPrd(oCPFFinalPaymentBean.getTdsIntIntrvngPrd());
          fedoForm.setSancAmount(oCPFFinalPaymentBean.getSancAmount());
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      if(hdnAction.equals("calcInt"))
      {
         
         BeanUtils.copyProperties(oBaseHeaderBean,form);
         CPFFinalPaymentBean oCPFFinalPaymentBean=(CPFFinalPaymentBean)oBaseHeaderBean;
         long userId = oBaseForm.getLoginEmployeeNo();
         long siteId = oBaseForm.getLoginLocCode();
  
         BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
         BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
         errMsg = oCPFFinalPaymentBD.calcYrInt(oCPFFinalPaymentBean);
          
          String [] errCode=errMsg.split(",",2);
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(errCode[1]));
          if(errCode[0].equals("0"))
          {
            throw new EnrgiseApplicationException("Payroll.CPF.CalcInt.Success");
          }
          else
          {
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }
      }
      
        //added by himanshu on on 7-july-2014
       if(hdnAction.equals("freezeYrEnd"))
      {
         
         BeanUtils.copyProperties(oBaseHeaderBean,form);
         CPFFinalPaymentBean oCPFFinalPaymentBean=(CPFFinalPaymentBean)oBaseHeaderBean;
         long userId = oBaseForm.getLoginEmployeeNo();
         long siteId = oBaseForm.getLoginLocCode();
  
         BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
         BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
         errMsg = oCPFFinalPaymentBD.freezeYrInt(oCPFFinalPaymentBean);
          
          String [] errCode=errMsg.split(",",2);
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(errCode[1]));
          if(errCode[0].equals("0"))
          {
            throw new EnrgiseApplicationException("Payroll.CPF.freeze.Success");
          }
          else
          {
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }
      }
      //added by himanshu on 14-jan-2015
      if(hdnAction.equals("cancelSuppPayment"))
      {
         BeanUtils.copyProperties(oBaseHeaderBean,form);
         CPFFinalPaymentBean oCPFFinalPaymentBean=(CPFFinalPaymentBean)oBaseHeaderBean;
         long userId = oBaseForm.getLoginEmployeeNo();
         long siteId = oBaseForm.getLoginLocCode();
         BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
         BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
         errMsg = oCPFNewPaymentBD.cancelSupp(oCPFFinalPaymentBean);
         
         
         String [] errCode=errMsg.split(",",2);
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(errCode[1]));
          if(errCode[0].equals("0"))
          {
            
             //Code to Fetch the data after process.
            CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
            BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
              fedoForm.setHeaderDataChanged(false);
              fedoForm.setDetailDataChanged(false);
        
              BaseQueryVO oBaseQueryVO = oCPFFinalPaymentQueryVO;
              if(fedoForm.isHeaderFields())
              {      
                  if(fedoForm.getPositionRequested() > 0)
                  {
                    // A particular header position requested so ignore the primary key
                    if(sScreenName.equals("CPFNewPaymentScreen"))
                    {
                         oBaseHeaderVO = oCPFNewPaymentBD.getNextHeaderRecord(oBaseQueryVO,fedoForm.getPositionRequested(),sFormName,true,oUser);
                    }
                    else
                    {
                         oBaseHeaderVO = oCPFFinalPaymentBD.getNextHeaderRecord(oBaseQueryVO,fedoForm.getPositionRequested(),sFormName,true,oUser);
                    }
 
                   
                    int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
                    BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
                    BeanUtils.copyProperties(form,oBaseHeaderVO);
                  }
                  else
                  {
                    // Only this particular record is required
                   // oBaseQueryVO = getQueryVO(form);
        
                    BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  //  oBaseQueryVO.setHeaderPrimaryKey(sHeaderPrimaryKey);
                    oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
                     if(sScreenName.equals("CPFNewPaymentScreen"))
                    {
                         oBaseHeaderVO = oCPFNewPaymentBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
                         
                    }
                    else
                    {
                         oBaseHeaderVO = oCPFFinalPaymentBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
                    }

            
                    BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                    BeanUtils.copyProperties(form,oBaseHeaderVO);
                  }
              }
              
              oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);   
              
              //Code to fetch the detail information again...............(added by geetika)start on 16/12/2013
            throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
          }
          else
          {
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }
      }
      
      //ended by himanshu on 14-jan-2015
      
      if(hdnAction.equals("getAdvAmt"))
      {
          CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
          BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
          oCPFFinalPaymentQueryVO.setUserId(lUserID);
          oBaseHeaderBean = oCPFFinalPaymentBD.getMaxApplAmt(oCPFFinalPaymentQueryVO);
          CPFFinalPaymentBean oCPFFinalPaymentBean= (CPFFinalPaymentBean)oBaseHeaderBean;
          fedoForm.setTxtApplAmt(oCPFFinalPaymentBean.getTxtApplAmt());
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      if(hdnAction.equals("getIntInst"))
      {
          CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
          BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
          oCPFFinalPaymentQueryVO.setUserId(lUserID);
          oBaseHeaderBean = oCPFFinalPaymentBD.getIntInst(oCPFFinalPaymentQueryVO);
          CPFFinalPaymentBean oCPFFinalPaymentBean= (CPFFinalPaymentBean)oBaseHeaderBean;
          fedoForm.setNoIntInstall(oCPFFinalPaymentBean.getNoIntInstall());
          fedoForm.setIntInstall(oCPFFinalPaymentBean.getIntInstall());
         // BeanUtils.copyProperties(form,oBaseHeaderBean); //Copy header record to form
      }
      if(hdnAction.equals("revokeCPFPay"))
      {
           errMsg = oCPFFinalPaymentBD.revokePay(oBaseHeaderBean);
          
          String [] errCode=errMsg.split(",",2);
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(errCode[1]));
          if(errCode[0].equals("0"))
          {
            
             //Code to Fetch the data after process.
            CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO=new CPFFinalPaymentQueryVO();
            BeanUtils.copyProperties(oCPFFinalPaymentQueryVO,form);
              fedoForm.setHeaderDataChanged(false);
              fedoForm.setDetailDataChanged(false);
        
              BaseQueryVO oBaseQueryVO = oCPFFinalPaymentQueryVO;
              if(fedoForm.isHeaderFields())
              {      
                  if(fedoForm.getPositionRequested() > 0)
                  {
                    // A particular header position requested so ignore the primary key
                    oBaseHeaderVO = oCPFFinalPaymentBD.getNextHeaderRecord(oBaseQueryVO,fedoForm.getPositionRequested(),sFormName,true,oUser);
                    int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
                    BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
                    BeanUtils.copyProperties(form,oBaseHeaderVO);
                  }
                  else
                  {
                    // Only this particular record is required
                   // oBaseQueryVO = getQueryVO(form);
        
                    BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  //  oBaseQueryVO.setHeaderPrimaryKey(sHeaderPrimaryKey);
                    oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
                    oBaseHeaderVO = oCPFFinalPaymentBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
                    BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                    BeanUtils.copyProperties(form,oBaseHeaderVO);
                  }
              }
              oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);  
              throw new EnrgiseApplicationException("Payroll.CPF.AvdPartFinal.ReleasePay.Success");
          }
        }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);         
  }
}