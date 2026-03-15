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
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class GetDetailAction extends BaseAction
{
  public GetDetailAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      if(oBaseForm.getScreenMode().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE))
      {
        throw new EnrgiseApplicationException("wenrgise.common.saveheaderrecord",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      
      UserSession oUser = getUserSessionBean(request);
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
      BaseDetailVO oBaseDetailVO = null;
      if(null == oBaseDetailInfo)
      {
        oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser);        
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
        
        oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser,oBaseDetailInfo);
      }
      /* Changed by Basu */
      //oBaseForm.setDetailStartPage(1);
      if(oBaseDetailVO.getOThisPageData() != null)
      {        
        BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
      }
      /* Changed by Basu */
      oBaseForm.setPageRequested(1);
      oBaseForm.setThisPageDetailCount((null != oBaseDetailVO.getOThisPageData())?oBaseDetailVO.getOThisPageData().size():0);
      //BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);
       
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
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}