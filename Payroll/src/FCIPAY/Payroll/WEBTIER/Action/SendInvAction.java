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
import FCIPAY.Payroll.WEBTIER.Form.OTAPymntForm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayOverAboveQueryVO;
import FCIPAY.Payroll.WEBTIER.Form.PayOverAboveForm;
import FCIPAY.Payroll.WEBTIER.Form.LeaveEncashForm;
import FCIPAY.Payroll.WEBTIER.Form.LTCEncashForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.OTAPymntBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayOverAboveBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaveEncashBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LTCEncashBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
//LeaveTravelConcession(LTC)
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaveTravelConcessionBD;
import FCIPAY.Payroll.WEBTIER.Form.LeaveTravelConcessionForm;

public class SendInvAction extends BaseAction
{
  public SendInvAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); 
	  BaseHeaderVO oBaseHeaderVO = null;
	  UserSession oUser = getUserSessionBean(request);
      //BaseQueryVO oBaseQueryVO = getQueryVO(form); //Get fully qualified form class
      String sQueryVO = FCIPAY.Payroll.common.utility.ParamUtil.getQueryVO(sFormName); // Get the fully qualified VO class name
      BaseQueryVO oBaseQueryVO = (BaseQueryVO)Class.forName(sQueryVO).newInstance(); //Create new query vo instance
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";

      if(sScreenName.equals("PayOverAboveScreen"))
      {
        PayOverAboveForm fedoForm = (PayOverAboveForm)oBaseForm;
        PayOverAboveBD oPayOverAboveBD=(PayOverAboveBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String errMsg = oPayOverAboveBD.sendInv(fedoForm.getHeaderPrimaryKey(),fedoForm.getHdnEmpLbrFlag(),lUserID,lSiteID);
        PayOverAboveQueryVO oPayOverAboveQueryVO=new PayOverAboveQueryVO();
		    BeanUtils.copyProperties(oPayOverAboveQueryVO,form);
        String [] errCode=errMsg.split(",",2);
       
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
				if(errCode[0].equals("0"))
				{
//code entered by swapnendu start
                  BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));

                  UserInfoBean obUserInfo = new UserInfoBean();      
                  
                  if(request.getSession().getAttribute("USERINFO")==null){}
                  else{
                      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                      oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
                      oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
                  }
                  
                  oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
                  if(oBaseHeaderVO.getTotalCount() == 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
                      throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
                  
                  if(oBaseHeaderVO.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }      
                  controlHeaderNavigation(oBaseForm);
                  
                  BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                  BeanUtils.copyProperties(form,oBaseHeaderVO);
                  if(oBaseForm.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }
                  oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
                  oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
                  if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
                  {
                      oBaseForm.setScreenMode("Q");
                  }

//code entered by swapnendu end

					throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
						
				}
				else
				{
				  throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
				}

				
	
      }
	  
	  
	  
	  
	  else if(sScreenName.equals("LeaveEncashScreen"))
      {
        LeaveEncashForm fedoForm = (LeaveEncashForm)oBaseForm;
        LeaveEncashBD oLeaveEncashBD=(LeaveEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String errMsg = oLeaveEncashBD.sendInv(fedoForm.getHeaderPrimaryKey(),fedoForm.getHdnEmpLbrFlag(),lUserID,lSiteID);
/*
         BaseHeaderVO oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
      if(oBaseHeaderVO.getTotalCount() == 0)
      {
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
        throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }

      if(oBaseHeaderVO.getTotalCount() > 0)
      {
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
      }      
      controlHeaderNavigation(oBaseForm);
      
      BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
      BeanUtils.copyProperties(form,oBaseHeaderVO);
      if(oBaseForm.getTotalCount() > 0)
      {
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
      }
     oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
     oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  



 */
        String [] errCode=errMsg.split(",",2);
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
        if(errCode[0].equals("0"))
        {
        //code entered by swapnendu start
                  BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));

                  UserInfoBean obUserInfo = new UserInfoBean();      
                  
                  if(request.getSession().getAttribute("USERINFO")==null){}
                  else{
                      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                      oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
                      oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
                  }
                  
                  oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
                  if(oBaseHeaderVO.getTotalCount() == 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
                      throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
                  
                  if(oBaseHeaderVO.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }      
                  controlHeaderNavigation(oBaseForm);
                  
                  BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                  BeanUtils.copyProperties(form,oBaseHeaderVO);
                  if(oBaseForm.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }
                  oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
                  oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
                  if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
                  {
                      oBaseForm.setScreenMode("Q");
                  }

//code entered by swapnendu end

          throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
        
        
        
      }else if(sScreenName.equals("LTCEncashScreen"))
      {
        LTCEncashForm fedoForm = (LTCEncashForm)oBaseForm;
        LTCEncashBD oLTCEncashBD=(LTCEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String errMsg = oLTCEncashBD.sendLTCEncashInv(fedoForm.getHeaderPrimaryKey(),fedoForm.getHdnEmpLbrFlag(),lUserID,lSiteID);

        String [] errCode=errMsg.split(",",2);
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
        if(errCode[0].equals("0"))
        {
        //code entered by swapnendu start
                  BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));

                  UserInfoBean obUserInfo = new UserInfoBean();      
                  
                  if(request.getSession().getAttribute("USERINFO")==null){}
                  else{
                      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                      oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
                      oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
                  }
                  
                  oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
                  if(oBaseHeaderVO.getTotalCount() == 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
                      throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
                  
                  if(oBaseHeaderVO.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }      
                  controlHeaderNavigation(oBaseForm);
                  
                  BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                  BeanUtils.copyProperties(form,oBaseHeaderVO);
                  if(oBaseForm.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }
                  oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
                  oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
                  if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
                  {
                      oBaseForm.setScreenMode("Q");
                  }

//code entered by swapnendu end

          throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
      }
      
      else if(sScreenName.equals("LeaveEncashScreen"))
      {
        LeaveEncashForm fedoForm = (LeaveEncashForm)oBaseForm;
        LeaveEncashBD oLTCEncashBD=(LeaveEncashBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String errMsg = oLTCEncashBD.sendLeaveEncashInv(fedoForm.getHeaderPrimaryKey(),fedoForm.getHdnEmpLbrFlag(),lUserID,lSiteID);

        String [] errCode=errMsg.split(",",2);
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
        if(errCode[0].equals("0"))
        {
        
        //code entered by swapnendu start
                  BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));

                  UserInfoBean obUserInfo = new UserInfoBean();      
                  
                  if(request.getSession().getAttribute("USERINFO")==null){}
                  else{
                      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                      oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
                      oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
                  }
                  
                  oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
                  if(oBaseHeaderVO.getTotalCount() == 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
                      throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
                  
                  if(oBaseHeaderVO.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }      
                  controlHeaderNavigation(oBaseForm);
                  
                  BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                  BeanUtils.copyProperties(form,oBaseHeaderVO);
                  if(oBaseForm.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }
                  oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
                  oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
                  if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
                  {
                      oBaseForm.setScreenMode("Q");
                  }

//code entered by swapnendu end

          throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
      }else if(sScreenName.equals("LeaveTravelConcessionScreen"))
      {
        LeaveTravelConcessionForm fedoForm = (LeaveTravelConcessionForm)oBaseForm;
        LeaveTravelConcessionBD oLeaveTravelConcessionBD=(LeaveTravelConcessionBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String errMsg = oLeaveTravelConcessionBD.sendLeaveTravelConcessionInv(fedoForm.getHeaderPrimaryKey(),fedoForm.getHdnEmpLbrFlag(),lUserID,lSiteID);

        String [] errCode=errMsg.split(",",2);
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
        if(errCode[0].equals("0"))
        {
              BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
              oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));

              UserInfoBean obUserInfo = new UserInfoBean();      
              
              if(request.getSession().getAttribute("USERINFO")==null){}
              else{
                  obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                  oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
                  oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
              }
              
              oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
              if(oBaseHeaderVO.getTotalCount() == 0)
              {
                  oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
                  throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
              }
              
              if(oBaseHeaderVO.getTotalCount() > 0)
              {
                  oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
              }      
              controlHeaderNavigation(oBaseForm);
              
              BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
              BeanUtils.copyProperties(form,oBaseHeaderVO);
              if(oBaseForm.getTotalCount() > 0)
              {
                  oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
              }
              oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
              oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
              if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
              {
                  oBaseForm.setScreenMode("Q");
              }

          throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
      }
      else
      {
        OTAPymntForm fedoForm = (OTAPymntForm)oBaseForm;
        OTAPymntBD oOTAPymntBD=(OTAPymntBD)oBaseBD;
        lUserID = fedoForm.getLoginEmployeeNo();
        lSiteID = fedoForm.getLoginLocCode();
        String errMsg = oOTAPymntBD.sendInv(fedoForm.getHeaderPrimaryKey(),fedoForm.getHdnEmpLbrFlag(),lUserID,lSiteID);
  
        String [] errCode=errMsg.split(",",2);
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errCode[1]));
        if(errCode[0].equals("0"))
        {
 //code entered by swapnendu start
                  BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                  oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));

                  UserInfoBean obUserInfo = new UserInfoBean();      
                  
                  if(request.getSession().getAttribute("USERINFO")==null){}
                  else{
                      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                      oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
                      oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
                  }
                  
                  oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
                  if(oBaseHeaderVO.getTotalCount() == 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
                      throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                  }
                  
                  if(oBaseHeaderVO.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }      
                  controlHeaderNavigation(oBaseForm);
                  
                  BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                  BeanUtils.copyProperties(form,oBaseHeaderVO);
                  if(oBaseForm.getTotalCount() > 0)
                  {
                      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
                  }
                  oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
                  oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
                  if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
                  {
                      oBaseForm.setScreenMode("Q");
                  }

//code entered by swapnendu end

          throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
      }
//	return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);

  }

}