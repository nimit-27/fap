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
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.Labour.WEBTIER.Form.MaintWrkSlipForm;

public class NewModeAction extends BaseAction
{
  public NewModeAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      
      BaseForm oBaseForm = (BaseForm)form;
      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sGangId=null;
      String sGangName=null;
      String sMoU=null;
      String sSite=null;
      if(sScreenName.equals("WrkSlipScreen") || sScreenName.equals("DPSWrkSlipScreen"))
      {
          MaintWrkSlipForm fedoForm = (MaintWrkSlipForm)oBaseForm; 
          sGangId = fedoForm.getHdnGangId();
          sGangName = fedoForm.getTxtGangName();
          sMoU = fedoForm.getHdnMou();
          sSite = fedoForm.getTxtSite(); 
      }
      
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      
      changeMode(oBaseForm,request);
      oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE);
      if(sScreenName.equals("WrkSlipScreen") || sScreenName.equals("DPSWrkSlipScreen"))
      {
          MaintWrkSlipForm fedoForm = (MaintWrkSlipForm)oBaseForm; 
          fedoForm.setHdnGangId(sGangId);
          fedoForm.setTxtGangName(sGangName);
          fedoForm.setHdnMou(sMoU);
          fedoForm.setTxtSite(sSite);
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}
