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
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class DeleteRowAction extends BaseAction
{
  public DeleteRowAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String [] itemChecked = oBaseForm.getItemChecked();
      
      UserSession oUser = getUserSessionBean(request);
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = null;
//      ArrayList oDetailArray = oBaseDetailVO.getOThisPageData();
      //oBaseForm.setThisPageDetailCount((null != oBaseDetailVO.getOThisPageData())?oBaseDetailVO.getOThisPageData().size():0);
      ArrayList oDetailArray = getDetailArray(oBaseForm);
      int count = 0;
      for(int i=0; i < itemChecked.length; ++i)
      {
        if(itemChecked[i].equals("Y"))
        {
          ++count;
          ((BaseDetailBean)oDetailArray.get(i)).setStatus("D");
          //((BaseDetailBean)oDetailArray.get(i)).setItemChecked("N");
          //oBaseDetailVO.setTotalDetailRecord(oBaseDetailVO.getTotalDetailRecord() - 1);
          oBaseDetailVO.setRowDeleted(oBaseDetailVO.getRowDeleted() + 1);
        }
      }
      if(count > 0)
      {
        oBaseForm.setDetailDataChanged(true);
      }
      BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailArray);
      
      //oBaseDetailVO.setOThisPageData(oDetailArray);
      //BeanUtils.setProperty(oBaseForm,ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
      //oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
}