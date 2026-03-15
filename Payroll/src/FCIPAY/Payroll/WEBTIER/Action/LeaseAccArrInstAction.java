package FCIPAY.Payroll.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.lang.reflect.InvocationTargetException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.WEBTIER.Form.LeaseAccomForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.LeaseAccomBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;
import java.io.PrintWriter;

public class LeaseAccArrInstAction extends BaseAction
{
  public LeaseAccArrInstAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {        
    BaseForm oBaseForm = (BaseForm)form;
    String sFormName = form.getClass().getName(); //Get fully qualified form class
    String sScreenName = oBaseForm.getScreenName();
    LeaseAccomBD oBaseBD = new LeaseAccomBD();  
    LeaseAccomForm fedoForm = (LeaseAccomForm)oBaseForm;
    BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
    ArrayList oDetailBeanArray = null;
    BaseDetailVO oBaseDetailVO = null;
    BaseHeaderVO oBaseHeaderVO = null;   
    
    StringBuffer s = new StringBuffer();      
    
    BeanUtils.copyProperties(oBaseHeaderBean,form);      
    
    long siteId = oBaseForm.getLoginLocCode();
    long userId = oBaseForm.getLoginEmployeeNo();        
    
    String sEmpNo = request.getParameter("empNo");
    String sEmpFlg = request.getParameter("empFlg");
    String startDate = request.getParameter("sDateVal");
    String endDate = request.getParameter("eDateVal");
    //String fldName=request.getParameter("fldVal");    
    
    
    ArrayList payCodeInfo = new ArrayList();    
    //payCodeInfo = oBaseBD.getLeaseAccArrInst(sEmpNo, sEmpFlg, startDate,endDate,siteId,userId);
    //oDetailBeanArray.set(Integer.parseInt(index),oLoanDtlsDetailBean);
    for(int i =0; i < payCodeInfo.size();i++)
    {
      s.append(payCodeInfo.get(i).toString());
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