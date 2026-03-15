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
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.GetHeaderAction;
import FCIPAY.Payroll.common.webtier.action.GetDetailAction;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
public class GetInsertAction extends BaseAction
{
  public GetInsertAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      
      BaseForm oBaseForm = (BaseForm)form;
      /*
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        return goBack(mapping);
      }
      */
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseQueryVO oBaseQueryVO = getQueryVO(form); //Create new query vo instance
//      System.out.println("Class name " + oBaseQueryVO.getClass().getName());
           BaseBD oBaseBD ;
      
       if(sFormName.equals("FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm"))
      {
        oBaseBD = getDetailBusinessDelegate(form);
      }
      else
      {
        
        oBaseBD = getHeaderBusinessDelegate(form);  
      }
  
      BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
      oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
      UserSession oUser = getUserSessionBean(request);
//      System.out.println(oBaseForm.getHeaderPrimaryKey());
       String sNewPK="x";// = oBaseBD.getInsertDataImpl(oBaseQueryVO);
      oBaseForm.setHeaderPrimaryKey(sNewPK);
     
       // Simulating get header action
         BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
     oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
      oUser = getUserSessionBean(request);
      BaseHeaderVO oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);// Get header record
      BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
      BeanUtils.copyProperties(form,oBaseHeaderVO);
      
      // Simulating the get detail action
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
//      System.out.println(oBaseHeaderVO.getHeaderRecord(1).getHeaderPrimaryKey());
      BaseDetailVO oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,oBaseHeaderVO.getHeaderRecord(1).getHeaderPrimaryKey(),1,oDetailSizeValues,null,true,oUser);
      oBaseForm.setDetailStartPage(1);
      if(oBaseDetailVO.getOThisPageData() != null)
      {        
        BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
      }
      BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);

      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}