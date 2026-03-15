/*
 * Action Class to Delete the Header Record
 * @author Balpreet
 * Created On 7 Sep 2007.
 */
package FCIPAY.Payroll.common.webtier.action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
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

public class DeleteRecordAction extends BaseAction 
{
    public DeleteRecordAction()
    {
    }
  
    public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
    {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      BaseBD oBaseBD = getHeaderBusinessDelegate(form);
      UserSession oUser = getUserSessionBean(request);
      
      if(!oBaseForm.isDetailDataChanged() && !oBaseForm.isHeaderDataChanged())
      {
         if (oBaseForm.getScreenName().equals("ECSDataFileScreen"))
        {
              oBaseForm.setScreenMode("Q");
        }            
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }

      
      oBaseBD.deleteHeaderRecordImpl(sHeaderPrimaryKey,sScreenName);
      oBaseForm.setHeaderDataChanged(false);
      oBaseForm.setDetailDataChanged(false);
      
      changeMode(oBaseForm,request);
      oBaseForm.setScreenMode(EnrgiseConstants.QUERY_MODE);
      
      throw new EnrgiseApplicationException("wenrgise.common.datasaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);

      //return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
    }
}