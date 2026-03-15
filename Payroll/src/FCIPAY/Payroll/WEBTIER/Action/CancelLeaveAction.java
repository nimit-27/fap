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
import java.lang.reflect.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintEmpLeaveBD;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.WEBTIER.Form.ECSDataFileForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;


public class CancelLeaveAction extends BaseAction
{
  public CancelLeaveAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      MaintEmpLeaveBD oBaseBD = new MaintEmpLeaveBD();
    //  UserSession oUser = getUserSessionBean(request);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      ArrayList oDetailBeanArray = null;
      BaseDetailVO oBaseDetailVO = null;
      BaseHeaderVO oBaseHeaderVO = null;
      Timestamp oHeaderPicked = null;
      Timestamp oDetailPicked = null;
      
      if(!oBaseForm.isDetailDataChanged() && !oBaseForm.isHeaderDataChanged())
      {
         if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
        {
              oBaseForm.setScreenMode("Q");
        }            
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }
      
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      
  /*    if(oBaseForm.getScreenMode().equals(EnrgiseConstants.NEW_MODE))
      {
        oHeaderPicked = null;
      }
      else
      {  */
        if(oBaseForm.isHeaderDataChanged())
        {
      //    oBaseHeaderVO = oUser.getBaseHeaderVO(sFormName);
          if(oBaseHeaderVO != null)
          {
            oHeaderPicked = oBaseHeaderVO.getOWhenPicked();
            oBaseHeaderBean = getBaseHeaderBean(sFormName);
          }
          
          BeanUtils.copyProperties(oBaseHeaderBean,form);
        
        }
        
       //   oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
          /* Added By Aqeel Ahmed to reset page detail count before submit the fo */
          //oBaseForm.setThisPageDetailCount((null != oBaseDetailVO.getOThisPageData())?oBaseDetailVO.getOThisPageData().size():0);
          if(oBaseDetailVO != null)
          {
            oDetailPicked = oBaseDetailVO.getOWhenPicked();
          }
          /*
          else
          {
            oBaseDetailVO = new BaseDetailVO();
          }
          */

        if(oBaseForm.isDetailDataChanged())
        {
         // oDetailBeanArray = getDetailArray(oBaseForm);
        }
//      }
      
      
    /* Added By Payroll Team for Passing USERID and SITEID  */
      long userId = oBaseForm.getLoginEmployeeNo();
      long siteId = oBaseForm.getLoginLocCode();

      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );

    /* End of Code By Payroll Team for Passing USERID and SITEID  */
      
      String sHeaderPrimaryKey = oBaseBD.saveRecord(oBaseHeaderBean,oHeaderPicked,oBaseForm.getScreenName(), oBaseForm.getScreenMode(),oBaseForm.isHeaderDataChanged(), oDetailBeanArray,oBaseForm.isDetailDataChanged(),oDetailPicked);
      oBaseForm.setHeaderDataChanged(false);
      oBaseForm.setDetailDataChanged(false);
      if(null != oBaseDetailVO)
      {
        //oBaseDetailVO.setRowDeleted(0);     //I change
       // oBaseDetailVO.setRowAdded(0);
      }
      oBaseForm.setHeaderPrimaryKey(sHeaderPrimaryKey);
      // Save is done refresh the page
      BaseQueryVO oBaseQueryVO = null;
      if(oBaseForm.isHeaderFields())
      {      
          if(oBaseForm.getPositionRequested() > 0)
          {
            // A particular header position requested so ignore the primary key
           // oBaseQueryVO = oUser.getBaseQueryVO(sFormName);
            //BeanUtils.copyProperties(oBaseQueryVO,form);
            //oBaseQueryVO.setHeaderPrimaryKey(null);
        //    oBaseHeaderVO = oBaseBD.getNextHeaderRecord(oBaseQueryVO,oBaseForm.getPositionRequested(),sFormName,true,oUser);
            int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
            BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
            BeanUtils.copyProperties(form,oBaseHeaderVO);
          }
          else
          {
            // Only this particular record is required
           // oBaseQueryVO = getQueryVO(form);

            BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
            oBaseQueryVO.setHeaderPrimaryKey(sHeaderPrimaryKey);
            oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
           // oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
            BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
            BeanUtils.copyProperties(form,oBaseHeaderVO);
        
          }
      }
      
   //   oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);
      
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


            BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
            if(null == oBaseDetailInfo)
            {
              if(oBaseForm.getPageRequested() <= 0)
              {
                oBaseForm.setPageRequested(1);
              }
             // oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,oBaseForm.getPageRequested(),oDetailSizeValues,null,true,oUser);        
              //oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,true,oUser);        
                            
            }
            else
            {
              BeanUtils.copyProperties(oBaseDetailInfo,form);

             UserInfoBean obUserInfo = new UserInfoBean();
              if(request.getSession().getAttribute("USERINFO")==null){}
              else{
              obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
              oBaseDetailInfo.setUserId(obUserInfo.getLEmployeeNo());
              oBaseDetailInfo.setSiteId(obUserInfo.getLLocationCode());              
              }

              
              if(oBaseForm.getPageRequested() <= 0)
              {
                oBaseForm.setPageRequested(1);
              }
             // oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,oBaseForm.getPageRequested(),oDetailSizeValues,null,true,oUser,oBaseDetailInfo);
              //oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,true,oUser,oBaseDetailInfo);
            }

            //oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,true,oUser);
            //oBaseForm.setDetailStartPage(1);

            oBaseForm.setPageRequested(oBaseForm.getPageRequested());

              if(oBaseForm.getPageRequested() <= 0)
              {
                oBaseForm.setPageRequested(1);
              }
            
            //oBaseForm.setPageRequested(1);
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
            //oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
          
        }
        
      }
      
      oBaseForm.setScreenMode(EnrgiseConstants.UPDATE_MODE);            
   /*   if (sScreenName.equals("MaintainEmpFinDetailScreen"))
      {   
        oBaseForm.setScreenMode("U");    
      }
      if (sScreenName.equals("TransferScreen"))
      {   
        oBaseForm.setScreenMode("U");    
      }
*/
      throw new EnrgiseApplicationException("Payroll.EmpLeave.CancelSuccess",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      //return mapping.findForward(EnrgiseConstants.SUCCESS);
  }
}