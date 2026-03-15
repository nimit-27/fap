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
import FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates.MaintKotWrkSlipBD;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.Labour.WEBTIER.Form.MaintKotWrkSlipForm;
import java.io.PrintWriter;

public class WrkSlipKOTDetAction extends BaseAction
{
  public WrkSlipKOTDetAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      MaintKotWrkSlipBD oBaseBD = new MaintKotWrkSlipBD();
    //  UserSession oUser = getUserSessionBean(request);
      MaintKotWrkSlipForm fedoForm = (MaintKotWrkSlipForm)oBaseForm;
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      ArrayList oDetailBeanArray = null;
      BaseDetailVO oBaseDetailVO = null;
      BaseHeaderVO oBaseHeaderVO = null;
      Timestamp oHeaderPicked = null;
      Timestamp oDetailPicked = null;
      StringBuffer s = new StringBuffer();      
      
      BeanUtils.copyProperties(oBaseHeaderBean,form);      
      
      long siteId = oBaseForm.getLoginLocCode();      
      String depotId = fedoForm.getTxtLocId();      
      
      String kotwalId=request.getParameter("kotVal");
      String fldName=request.getParameter("fldVal");    
      
      
      ArrayList kotInfo = new ArrayList();    
      kotInfo = oBaseBD.getKotLabourDetail(kotwalId,fldName,siteId, depotId);
      //oDetailBeanArray.set(Integer.parseInt(index),oLoanDtlsDetailBean);
      for(int i =0; i < kotInfo.size();i++)
      {
        s.append(kotInfo.get(i).toString());
        s.append("|");
      }  
      int l = s.length();
      String s1 =s.substring(0,l-1);     
      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      out.write(s1);
      //out.flush();
     return null;
  }
}