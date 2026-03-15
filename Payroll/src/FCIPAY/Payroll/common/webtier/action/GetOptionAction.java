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
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class GetOptionAction extends BaseAction
{
  public GetOptionAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      String sFinancialYear; 
      BaseForm oBaseForm = (BaseForm)form;      
/*      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",EnrgiseConstants.MESSAGE);
      }  */
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);

      if (sScreenName.equals("ExternalScreen")) 
      {
        MaintainExternalSavingsForm oExForm = (MaintainExternalSavingsForm)form;         
        sFinancialYear = oExForm.getTxtFinYYMM(); 
        changeMode(oBaseForm,request);      
        oBaseForm.setTotalDetailRecord(0);
        clearDetailLists(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailList(sFormName));
        oBaseForm.setDetailStartPage(0);
        oExForm.setTxtFinYYMM(sFinancialYear);       
      }
      else
      {
      changeMode(oBaseForm,request);      
      oBaseForm.setTotalDetailRecord(0);
      clearDetailLists(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailList(sFormName));
      oBaseForm.setDetailStartPage(0);
      }
            
      UserSession oUser = getUserSessionBean(request);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
}   
    