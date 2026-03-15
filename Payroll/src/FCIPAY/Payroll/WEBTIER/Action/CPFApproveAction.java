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
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CPFApproveBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.UTILITY.CPFApproveBean;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CPFApproveBD;

public class CPFApproveAction extends BaseAction
{
  public CPFApproveAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sBusinessDelegate  = FCIPAY.Payroll.common.utility.ParamUtil.getHeaderBD(sFormName); // Get the fully qualified Business Delegate class name
      BaseBD oBaseBD = (BaseBD)Class.forName(sBusinessDelegate).newInstance(); //Create new BD instance
      
      UserSession oUser = getUserSessionBean(request);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      String param = (String)request.getParameter("param");
      ArrayList oDetailBeanArray = null;
      BaseDetailVO oBaseDetailVO = null;
      BaseHeaderVO oBaseHeaderVO = null;
      Timestamp oHeaderPicked = null;
      Timestamp oDetailPicked = null;
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      
        if(oBaseForm.isHeaderDataChanged())
        {
          oBaseHeaderVO = oUser.getBaseHeaderVO(sFormName);
          if(oBaseHeaderVO != null)
          {
            oHeaderPicked = oBaseHeaderVO.getOWhenPicked();
            oBaseHeaderBean = getBaseHeaderBean(sFormName);
          }
          
          BeanUtils.copyProperties(oBaseHeaderBean,form);
        
        }
        
          oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
          if(oBaseDetailVO != null)
          {
            oDetailPicked = oBaseDetailVO.getOWhenPicked();
          }

        if(oBaseForm.isDetailDataChanged())
        {
          oDetailBeanArray = getDetailArray(oBaseForm);
          BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailBeanArray);
        }
      
      long userId = oBaseForm.getLoginEmployeeNo();
      long siteId = oBaseForm.getLoginLocCode();

      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
      CPFApproveBD oCPFApproveBD = new CPFApproveBD();
      int count = 0;
      if(param.equals("approve"))
      {
          oCPFApproveBD.approveRecord(oBaseHeaderBean, oDetailBeanArray);
      }
      else
      {
          oCPFApproveBD.rejectRecord(oBaseHeaderBean, oDetailBeanArray);
      }
      System.out.println("After saving data");
      oBaseForm.setHeaderDataChanged(false);
      oBaseForm.setDetailDataChanged(false);
      // Save is done refresh the page
      BaseQueryVO oBaseQueryVO = null;
      if(oBaseForm.isHeaderFields())
      {
          if(oBaseForm.getPositionRequested() > 0)
          {
            // A particular header position requested so ignore the primary key
            oBaseQueryVO = oUser.getBaseQueryVO(sFormName);
            //BeanUtils.copyProperties(oBaseQueryVO,form);
            //oBaseQueryVO.setHeaderPrimaryKey(null);
            oBaseHeaderVO = oBaseBD.getNextHeaderRecord(oBaseQueryVO,oBaseForm.getPositionRequested(),sFormName,true,oUser);
            int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
            BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
            BeanUtils.copyProperties(form,oBaseHeaderVO);
          }
          else
          {
            // Only this particular record is required
            String sQueryVO = FCIPAY.Payroll.common.utility.ParamUtil.getQueryVO(sFormName); // Get the fully qualified VO class name
            oBaseQueryVO = (BaseQueryVO)Class.forName(sQueryVO).newInstance(); //Create new query vo instance
            
            BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
            oBaseQueryVO.setHeaderPrimaryKey("");
            oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
            oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
            BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
            BeanUtils.copyProperties(form,oBaseHeaderVO);
          }
      }
      
      oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);
      
    // This statement is added to get the details records after insertion & change its screen mode to U. 
      
      if(!oBaseForm.getScreenMode().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE))
      {
        if(null != oBaseDetailVO)
        {
          //if(oBaseDetailVO.getTotalDetailRecord() > 0 || oBaseDetailVO.getRowAdded() > 0)
          if(oBaseDetailVO.getTotalDetailRecord() + oBaseDetailVO.getRowAdded() - oBaseDetailVO.getRowDeleted() >= 0 )
          {
            // Get the first page of the detail record
            DetailSizeValues oDetailSizeValues = new DetailSizeValues();
            oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
            oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
String sHeaderPrimaryKey="";
            BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
            if(null == oBaseDetailInfo)
            {
              if(oBaseForm.getPageRequested() <= 0)
              {
                oBaseForm.setPageRequested(1);
              }
              
              oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,oBaseForm.getPageRequested(),oDetailSizeValues,null,true,oUser);        
              //oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,true,oUser);        
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
              if(oBaseForm.getPageRequested() <= 0)
              {
                oBaseForm.setPageRequested(1);
              }
              oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,oBaseForm.getPageRequested(),oDetailSizeValues,null,true,oUser,oBaseDetailInfo);
            }
            oBaseForm.setPageRequested(oBaseForm.getPageRequested());
            if(oBaseForm.getPageRequested() <= 0)
            {
                oBaseForm.setPageRequested(1);
            }
            oBaseDetailVO.setRowAdded(0);
            oBaseDetailVO.setRowDeleted(0);
            
            if(oBaseDetailVO.getOThisPageData() != null)
            {
              oBaseForm.setThisPageDetailCount(oBaseDetailVO.getOThisPageData().size());
              BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
            }
            else
            {
              oBaseForm.setThisPageDetailCount(0);
            }
          
            BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);    
          }
           long totDetRecord=oBaseDetailVO.getTotalDetailRecord();
           long totRecPerPage=FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName);
           if(totDetRecord%totRecPerPage!=0)
           {
             oBaseForm.setTotalPageCount(totDetRecord/totRecPerPage+1);
           }
           if(totDetRecord%totRecPerPage!=0 && totDetRecord<totRecPerPage)
           {
             oBaseForm.setTotalPageCount(totDetRecord/totRecPerPage+1);
           }
           if(totDetRecord%totRecPerPage==0)
           {
             oBaseForm.setTotalPageCount(totDetRecord/totRecPerPage);
           }
           oBaseDetailVO.setRowDeleted(0);
           oBaseDetailVO.setRowAdded(0);
           oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);          
        }
      }
      //Uncomented by Balpreet Dt 5 june 2008 to solve promotion screen issue.
      if(oBaseForm.getScreenMode().equals(EnrgiseConstants.NEW_MODE))
      {
        oBaseForm.setScreenMode(EnrgiseConstants.UPDATE_MODE);   
      }
      throw new EnrgiseApplicationException("wenrgise.common.datasaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      //return mapping.findForward(EnrgiseConstants.SUCCESS);
  }
}
  