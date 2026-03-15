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
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
public class RefreshAction extends BaseAction
{
  public RefreshAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      
      BaseForm oBaseForm = (BaseForm)form;
      
      oBaseForm.setHeaderDataChanged(false);
      oBaseForm.setDetailDataChanged(false);
      if(oBaseForm.getScreenMode().equals( FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE) || oBaseForm.getScreenMode().equals( FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE))
      {
        changeMode(oBaseForm,request);
      }
      else
      {
        String sFormName = form.getClass().getName(); //Get fully qualified form class
        String sScreenName = oBaseForm.getScreenName();
        UserSession oUser = getUserSessionBean(request);
        BaseQueryVO oBaseQueryVO = null;
        BaseHeaderVO oBaseHeaderVO = null;
        BaseBD oBaseBD = getHeaderBusinessDelegate(form);
        BaseDetailVO oBaseDetailVO = null;


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
          oBaseQueryVO = getQueryVO(form);
          oBaseQueryVO.setHeaderPrimaryKey(oBaseForm.getHeaderPrimaryKey());
          oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
          BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
          BeanUtils.copyProperties(form,oBaseHeaderVO);
        
        }
      }
      
        oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
        if(null !=  oBaseDetailVO)
        {
          // Get the first page of the detail record
          DetailSizeValues oDetailSizeValues = new DetailSizeValues();
          oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
          oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));

/////////////////////////////////
            BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
            if(null == oBaseDetailInfo)
            {
              oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,oBaseForm.getHeaderPrimaryKey(),oBaseForm.getPageRequested(),oDetailSizeValues,oBaseDetailVO,false,oUser);
            }
            else
            {
              BeanUtils.copyProperties(oBaseDetailInfo,form);
              oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,oBaseForm.getHeaderPrimaryKey(),oBaseForm.getPageRequested(),oDetailSizeValues,oBaseDetailVO,false,oUser,oBaseDetailInfo);
            }

/////////////////////////////////////
  
          //oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,oBaseForm.getHeaderPrimaryKey(),1,oDetailSizeValues,null,true,oUser);
          //oBaseForm.setDetailStartPage(1);
          if(oBaseDetailVO.getOThisPageData() != null)
          {
            oBaseForm.setThisPageDetailCount(oBaseDetailVO.getOThisPageData().size());
            BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
          }
          else
          {
            oBaseForm.setThisPageDetailCount(0);
          }
          //BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);
          
        }
        
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}