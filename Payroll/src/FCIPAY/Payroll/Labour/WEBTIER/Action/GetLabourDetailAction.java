package FCIPAY.Payroll.Labour.WEBTIER.Action;
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
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.MaintLbrHndlngAttndBD;

public class GetLabourDetailAction extends BaseAction
{
  public GetLabourDetailAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      //BaseBD oBaseBD = getDetailBusinessDelegate(form);
            
     // UserSession oUser = getUserSessionBean(request);
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
      BaseDetailVO oBaseDetailVO = null;
      MaintLbrHndlngAttndBD oMaintLbrHndlngAttndBD = new MaintLbrHndlngAttndBD();      
                     
     // oBaseDetailVO = oMaintLbrHndlngAttndBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser,oBaseDetailInfo);
      
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