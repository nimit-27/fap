package FCIPAY.Payroll.WEBTIER.Action;
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
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintLoanDtlsBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.UTILITY.LoanDtlsDetailBean;
import java.io.PrintWriter;
public class LoanDtlAction extends BaseAction
{
  public LoanDtlAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      MaintLoanDtlsBD oBaseBD = new MaintLoanDtlsBD();
      //UserSession oUser = getUserSessionBean(request);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      ArrayList oDetailBeanArray = null;
      StringBuffer s = new StringBuffer();
     
      long siteId = oBaseForm.getLoginLocCode();
      
      String loanTyp=request.getParameter("loanTyp");
      String loanAmnt=request.getParameter("loanAmnt");
      String fstInstlAmnt=request.getParameter("fstInstlAmnt");
      String prnInstlNo=request.getParameter("prnInstlNo");
      String sancDate=request.getParameter("sancDate");         
      
      ArrayList frstInstlInfo = new ArrayList();   
      
      frstInstlInfo = oBaseBD.computeIntRate(loanTyp,loanAmnt,fstInstlAmnt,prnInstlNo,sancDate);
      
      for(int i =0; i < frstInstlInfo.size();i++)
      {
        s.append(frstInstlInfo.get(i).toString());
        s.append("|");
      }
      
      int l = s.length();
      String s1 =s.substring(0,l-1);
      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      out.write(s.toString());
      //out.flush();
     return null;
  }
}