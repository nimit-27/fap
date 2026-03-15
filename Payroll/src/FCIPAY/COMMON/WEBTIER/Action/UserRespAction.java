package FCIPAY.COMMON.WEBTIER.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.WEBTIER.Form.UsrRespMapForm;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import org.apache.struts.action.ActionForm;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.lang.reflect.InvocationTargetException;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.util.ArrayList;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.SA_ScreenEmpMapDAO;
import FCIPAY.COMMON.UTILITY.comboBean;

public class UserRespAction extends BaseAction
{
  public UserRespAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
       
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();	  
      String aScreenAction = (String)(request.getParameter("param1"));
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      UsrRespMapForm fedoForm = (UsrRespMapForm)oBaseForm; 
      String sHdnAction = fedoForm.getHdnAction();
      if (sHdnAction.equals("validateuser"))
      {
         DBUtilitiesBean oBean = new DBUtilitiesBean();
         ArrayList oParameters = new ArrayList();
         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,fedoForm.getTxtUserCode())); 
         oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
         ArrayList oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_chk_user_valid(?,?)",true,true);
         DBObject oOutObject=(DBObject)oOutArray.get(0);
         String retCnt=(String)oOutObject.getObject();
         if(retCnt.equals("0"))
         {
             fedoForm.setTxtUserCode("");
             ArrayList oArrayList = new ArrayList();
             oArrayList.add(new comboBean("","No Rows Found"));
             fedoForm.setLocList(oArrayList);
             throw new EnrgiseApplicationException("Common.Invalid.User");
         }
         SA_ScreenEmpMapDAO oSA_ScreenEmpMapDAO = new SA_ScreenEmpMapDAO();
         ArrayList locList=oSA_ScreenEmpMapDAO.getEmpDtls(Long.parseLong(fedoForm.getTxtUserCode()));
         if(locList.size()==0)
         {
             throw new EnrgiseApplicationException("No Location is mapped with this user");
         }
         fedoForm.setLocList(locList);
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              
  }
}