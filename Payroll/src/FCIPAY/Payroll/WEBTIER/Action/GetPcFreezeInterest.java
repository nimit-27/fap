package FCIPAY.Payroll.WEBTIER.Action;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.CPFFinalPaymentBD;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.MaintainPensionBD;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPCDetailQueryVO;

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
import FCIPAY.Payroll.WEBTIER.Form.MaintPensionDetailForm;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

import FCIPAY.Payroll.UTILITY.MaintPCDetailHeaderBean;
import FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm;

public class GetPcFreezeInterest extends BaseAction
{
  public GetPcFreezeInterest()
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
      
      String errMsg="";

      MaintPensionDetailForm fedoForm = (MaintPensionDetailForm)oBaseForm;
      MaintainPensionBD oMaintainPCBD = (MaintainPensionBD)oBaseBD;
      long lUserID = fedoForm.getLoginEmployeeNo();
      long lSiteID = fedoForm.getLoginLocCode();
      MaintPCDetailQueryVO oMaintPCDetailQueryVO = new MaintPCDetailQueryVO();
      BeanUtils.copyProperties(oMaintPCDetailQueryVO,form);
      BeanUtils.copyProperties(oMaintPCDetailQueryVO,form);
      oMaintPCDetailQueryVO.setUserId(lUserID);
      oMaintPCDetailQueryVO.setSiteId(lSiteID);
      
      
      if(sScreenName.equals("FreezePensionScreen"))
      {  
          lUserID = fedoForm.getLoginEmployeeNo();
          lSiteID = fedoForm.getLoginLocCode();
          
            //MaintainPensionBD oMaintainPCBD=(MaintainPensionBD)oBaseBD;
             
          //MaintPCDetailQueryVO oMaintPCDetailQueryVO=new MaintPCDetailQueryVO();
          BeanUtils.copyProperties(oMaintPCDetailQueryVO,form);
          errMsg = oMaintainPCBD.freezePenYrInt(oMaintPCDetailQueryVO);
          String [] errCode=errMsg.split(",",2);
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(errCode[1]));
          oArguments.add(new String(errMsg));
          if(errCode[0].equals("0"))
          {
            throw new EnrgiseApplicationException("Payroll.Pen.freeze.Success");
          }
          else
          {
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }
                             
        
        /*BeanUtils.copyProperties(oBaseHeaderBean,form);
        //MaintainPensionBean oMaintainPensionBean=(MaintainPensionBean)oBaseHeaderBean;
        long userId = oBaseForm.getLoginEmployeeNo();
        long siteId = oBaseForm.getLoginLocCode();
      
        BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
        BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );
        errMsg = oMaintainPCBD.freezePenYrInt(oBaseHeaderBean);*/
         
         /*String [] errCode=errMsg.split(",",2);
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errCode[1]));
         if(errCode[0].equals("0"))
         {
           throw new EnrgiseApplicationException("Payroll.Pen.freeze.Success");
         }
         else
         {
           throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         }
      }*/
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);

  }   
}
