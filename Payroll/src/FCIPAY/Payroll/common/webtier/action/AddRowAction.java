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
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class AddRowAction extends BaseAction
{
  public AddRowAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
 /*     BaseForm oBaseForm = (BaseForm)form;
      if(oBaseForm.getScreenMode().equals(EnrgiseConstants.NEW_MODE) || oBaseForm.getHeaderPrimaryKey() == null)
      {
        throw new EnrgiseApplicationException("wenrgise.common.saveheaderrecord",EnrgiseConstants.MESSAGE);
      }
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      UserSession oUser = getUserSessionBean(request);
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);      
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseBD oBaseBD = null;
      
      if(null == oBaseDetailVO)
      {
        // Get Detail not pressed, get the detail record for the first page
        // for a new record this might return zero record
        oBaseBD = getDetailBusinessDelegate(form);
        oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser);
        oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);
      }
      
      // Get the page number where the row be added
      long lPageRequested = getPageRequested(oBaseDetailVO,oDetailSizeValues);
      
      ArrayList oDetailList = null;
      if(oBaseDetailVO.getCurrentPage() != lPageRequested)
      {
        // We need to go to a different page, if any unsaved data is there please save it
        if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
        {
          throw new EnrgiseApplicationException("wenrgise.common.savefirst",EnrgiseConstants.MESSAGE);          
        }
        // Get the data of the required page
        oBaseBD = getDetailBusinessDelegate(form);
        oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);
        BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
        if(null == oBaseDetailInfo)
        {
          oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,lPageRequested,oDetailSizeValues,oBaseDetailVO,false,oUser);        
        }
        else 
        {
          BeanUtils.copyProperties(oBaseDetailInfo,form);
          oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,lPageRequested,oDetailSizeValues,oBaseDetailVO,false,oUser,oBaseDetailInfo);
        }
//        oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,lPageRequested,oDetailSizeValues,oBaseDetailVO,false,oUser);
        oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);
        oDetailList = oBaseDetailVO.getOThisPageData();
        oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
        
      }
      else
      {
        // Get the array from the form to reflect any
        // change done on the form
        oDetailList = getDetailArray(oBaseForm);
        oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);        
      }
      
      // Get another new bean instance
      BaseDetailBean oBaseDetailBean = getDetailBean(form);
      oBaseDetailBean.setStatus("N");
      // Add new bean to the list
      oDetailList.add(oBaseDetailBean);
      oBaseForm.setThisPageDetailCount(oBaseForm.getThisPageDetailCount() + 1);
      oBaseForm.setDetailDataChanged(true);
      // Set the list in the form
      BeanUtils.setProperty(oBaseForm,ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailList);
      return mapping.findForward(EnrgiseConstants.SUCCESS);   */

      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      UserSession oUser = getUserSessionBean(request);
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);      
      boolean bGetDetailNotPressed = false;
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseBD oBaseBD = null;
      BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
      
      if(null == oBaseDetailVO)
      {
        // Get Detail not pressed, get the detail record for the first page
        // for a new record this might return zero record
        bGetDetailNotPressed = true;
        oBaseBD = getDetailBusinessDelegate(form);
        
        if(null == oBaseDetailInfo)
        {
          oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser);        
        }
        else
        {
          if(!oBaseForm.getScreenMode().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE))
          {
            BeanUtils.copyProperties(oBaseDetailInfo,form);
            oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser,oBaseDetailInfo);
          }
          else
          {
            oBaseDetailVO = new BaseDetailVO();
            oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
            oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());            
          }
        }
        //oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser);
        oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);
      }
      
      // Get the page number where the row be added
      long lPageRequested = getPageRequested(oBaseDetailVO,oDetailSizeValues);
      
      ArrayList oDetailList = null;
      if(oBaseDetailVO.getCurrentPage() != lPageRequested)
      {
        // We need to go to a different page, if any unsaved data is there please save it
        if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
        {
          throw new EnrgiseApplicationException("wenrgise.common.savefirst",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);          
        }
        // Get the data of the required page 
        oBaseBD = getDetailBusinessDelegate(form);
        oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);
         if(null == oBaseDetailInfo)
        {
          oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,oBaseDetailVO,false,oUser);        
        }
        else
        {
           oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,oBaseDetailVO,false,oUser,oBaseDetailInfo);
        }
        oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);
        oDetailList = oBaseDetailVO.getOThisPageData();        
      }
      else
      {
        // Get the array from the form to reflect any
        // change done on the form
        if(bGetDetailNotPressed)
        {
          // If Get Detail not pressed form does not contain any data
          oDetailList = oBaseDetailVO.getOThisPageData() != null?oBaseDetailVO.getOThisPageData():new ArrayList();          
        }
        else
        {
        // Get the array from the form to reflect any
        // change done on the form
          oDetailList = getDetailArray(oBaseForm);          
        }
        oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);        
      }

      // Get another new bean instance
      BaseDetailBean oBaseDetailBean = getDetailBean(form);
      oBaseDetailBean.setStatus("N");
      // Add new bean to the list
      oDetailList.add(oBaseDetailBean);
      oBaseForm.setThisPageDetailCount(oBaseForm.getThisPageDetailCount() + 1);
      oBaseForm.setDetailDataChanged(true);
      // Set the list in the form
      BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailList);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);         
      
/*      
      BaseDetailBean oBaseDetailBean = null;
      
      if(oBaseDetailVO != null)
      {
        if(oBaseDetailVO.getOThisPageData().size() >= oDetailSizeValues.getDetailRecordPerPage())
        {
          bLimitReached = true;
        }
        else
        {          
        //COMMENTED BY BALESH
          oDetailList = getDetailArray(oBaseForm);
        }
        
        
        // Detail exists check if save required
       if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
         
        {
            // If already limit reached then save first
            if(bLimitReached)
            {
              throw new EnrgiseApplicationException("wenrgise.common.savefirst",EnrgiseConstants.MESSAGE);
            }
            else
            {
              oBaseForm.setThisPageDetailCount(oBaseForm.getThisPageDetailCount() + 1);
              oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);              
            }
        }
        else
        {
          lPageRequested = getPageRequested(oBaseDetailVO,oDetailSizeValues);
          oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);
          oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,lPageRequested,oDetailSizeValues,oBaseDetailVO,oUser);
          if(!bLimitReached)
          {
            oBaseForm.setThisPageDetailCount(oBaseForm.getThisPageDetailCount() + 1);            
          }
          else
          {
            oBaseForm.setThisPageDetailCount((null != oBaseDetailVO.getOThisPageData())?oBaseDetailVO.getOThisPageData().size() + 1: 1);
          }
        }
      }
      else
      {
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setCurrentPage(1);
        //oBaseDetailVO.setPageRequested(1);
        oBaseDetailVO.setCurrentSlot(1);
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setOThisPageData(new ArrayList());
        oBaseDetailVO.setOAllPageData(new ArrayList());
        oBaseForm.setThisPageDetailCount(oBaseForm.getThisPageDetailCount() + 1);
        oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);
      }
      */
      /* Changed by Basu */
      //oBaseForm.setTotalDetailRecord(oBaseForm.getTotalDetailRecord() +1);
      /*
      oBaseDetailBean = getDetailBean(form);
      oBaseDetailBean.setStatus("N");
      if(oDetailList != null)
      {
        oDetailList.add(oBaseDetailBean);
        oBaseDetailVO.setOThisPageData(oDetailList);
      }
      else
      {
        //oDetailList = new ArrayList();
        //oDetailList.add(oBaseDetailBean);
        //oBaseDetailVO.setOThisPageData(oDetailList);
        if(null == oBaseDetailVO.getOThisPageData())
        {
          oBaseDetailVO.setOThisPageData(new ArrayList());
        }
        oBaseDetailVO.getOThisPageData().add(oBaseDetailBean);        
      }
      if(oBaseDetailVO.getOAllPageData() == null)
      {
        oBaseDetailVO.setOAllPageData(new ArrayList());
      }
      //oBaseDetailVO.getOAllPageData().add(oBaseDetailBean);
      oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      oBaseForm.setDetailDataChanged(true);
      BeanUtils.setProperty(oBaseForm,ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
      //BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);
      return mapping.findForward(EnrgiseConstants.SUCCESS);
      */
  }
  
  private void populateThisPageList(BaseDetailVO oBaseDetailVO, DetailSizeValues oDetailSizeValues)
  {
//      oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() + 1);
        long lGrandTotalDetailRecord = oBaseDetailVO.getTotalDetailRecord() - oBaseDetailVO.getRowDeleted() + oBaseDetailVO.getRowAdded();
        int iPage =(int) lGrandTotalDetailRecord % oDetailSizeValues.getDetailRecordPerPage() + 1;
        int iDetailStartPosition = (iPage-1)*oDetailSizeValues.getDetailRecordPerPage() + 1;
        if(iDetailStartPosition < lGrandTotalDetailRecord +1)
        {
          
        }
    
  }
  
  private long getPageRequested(BaseDetailVO oBaseDetailVO,DetailSizeValues oDetailSizeValues)
  {
    long lLastRecordNumber = oBaseDetailVO.getTotalDetailRecord() - oBaseDetailVO.getRowDeleted() + oBaseDetailVO.getRowAdded() +1;
    return (lLastRecordNumber % oDetailSizeValues.getDetailRecordPerPage() != 0)?(lLastRecordNumber / oDetailSizeValues.getDetailRecordPerPage() + 1):(lLastRecordNumber / oDetailSizeValues.getDetailRecordPerPage());
  }
}