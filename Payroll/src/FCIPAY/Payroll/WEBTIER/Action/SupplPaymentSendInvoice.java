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
import FCIPAY.Payroll.WEBTIER.Form.SupplPayForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.SupplimentaryPayBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayQueryVO;

public class SupplPaymentSendInvoice extends BaseAction
{
  public SupplPaymentSendInvoice()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      
      String butAction = "";   
      SupplPayForm fedoForm = (SupplPayForm)oBaseForm;      
      SupplimentaryPayBD oSupplimentaryPayBD=(SupplimentaryPayBD)oBaseBD;
      long lUserID = fedoForm.getLoginEmployeeNo();
      long lSiteID = fedoForm.getLoginLocCode();
      SupplPayQueryVO oSupplPayQueryVO=new SupplPayQueryVO();
      BeanUtils.copyProperties(oSupplPayQueryVO,form);
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      oSupplPayQueryVO.setUserId(lUserID);
      oSupplPayQueryVO.setSiteId(lSiteID);
      String sErrCode = oSupplimentaryPayBD.sendInv(oSupplPayQueryVO);
      String [] errCode=sErrCode.split(",",2);
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(errCode[1]));
      if(errCode[0].equals("0"))
      {
        sHeaderPrimaryKey = oSupplimentaryPayBD.PopulateData(oBaseHeaderBean);
        fedoForm.setHeaderPrimaryKey(sHeaderPrimaryKey);
        throw new EnrgiseApplicationException("Pay.Payroll_SUCCESS",oArguments);
      }
      else
      {
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
        
          
    //  return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
  
}