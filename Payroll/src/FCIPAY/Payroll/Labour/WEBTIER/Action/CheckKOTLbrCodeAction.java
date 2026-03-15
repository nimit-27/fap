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
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.DeptLabourInfoBD;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import java.io.PrintWriter;

public class CheckKOTLbrCodeAction extends BaseAction
{
  public CheckKOTLbrCodeAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      DeptLabourInfoBD oBaseBD = new DeptLabourInfoBD();
    //  UserSession oUser = getUserSessionBean(request);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      ArrayList oDetailBeanArray = null;
      BaseDetailVO oBaseDetailVO = null;
      BaseHeaderVO oBaseHeaderVO = null;
      Timestamp oHeaderPicked = null;
      Timestamp oDetailPicked = null;
      StringBuffer s = new StringBuffer();
      /*if(!oBaseForm.isDetailDataChanged() && !oBaseForm.isHeaderDataChanged())
      {
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }*/
      
      BeanUtils.copyProperties(oBaseHeaderBean,form);      
      
      long siteId = oBaseForm.getLoginLocCode();      
      
      String kotwalId=request.getParameter("kotVal");
      
      int kotInfo=0; 
      kotInfo = oBaseBD.checkKotLabourCode(kotwalId,siteId);
      //oDetailBeanArray.set(Integer.parseInt(index),oLoanDtlsDetailBean);      
      s.append(kotInfo);
      int l = s.length();      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      out.write(s.toString());
      //out.flush();
     return null;
  }
}