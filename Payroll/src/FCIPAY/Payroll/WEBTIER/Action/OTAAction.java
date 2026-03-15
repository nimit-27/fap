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
import FCIPAY.Payroll.WEBTIER.Form.OTAPymntForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.OTAPymntBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OTAPymntQueryVO;

public class OTAAction extends BaseAction
{
  public OTAAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      long lUserID = 200;
      long lSiteID = 200;
      String butAction = "";   
      OTAPymntForm fedoForm = (OTAPymntForm)oBaseForm;      
      OTAPymntBD oOTAPymntBD=(OTAPymntBD)oBaseBD;
      lUserID = fedoForm.getLoginEmployeeNo();
      lUserID = fedoForm.getLoginLocCode();
      String sWage = oOTAPymntBD.getHrlyWage(fedoForm.getTxtEmpNo(),fedoForm.getTxtYYMM(),fedoForm.getHdnEmpLbrFlag());
          if(sWage.equals("0"))
          {
            fedoForm.setTxtYYMM("");
            throw new EnrgiseApplicationException("Pay.Payroll.LeaveEncash.Error",EnrgiseConstants.MESSAGE);
          }
          fedoForm.setTxtHrlyWage(sWage);
         // fedoForm.setHdnCpfDed((String)oArrayList.get(1));
         
///  To check IT deduction Flag & set it accordingly         
          OTAPymntQueryVO oOTAPymntQueryVO=new OTAPymntQueryVO();
          BeanUtils.copyProperties(oOTAPymntQueryVO,form);
          
          ArrayList oArrayList = oOTAPymntBD.getITDed(oOTAPymntQueryVO);
          String sFlag=(String)oArrayList.get(0);
         /* if(sFlag.equals("Y"))
          {
            Long sITded=(Long)oArrayList.get(0);
            fedoForm.setTxtDedIT(sITded.toString());
            fedoForm.setHdnFlagIT(sFlag);
            int netAmt=Integer.parseInt(fedoForm.getTxtGrossAmt())-Integer.parseInt(fedoForm.getTxtDedIT());
            fedoForm.setTxtNetAmt(netAmt+"");
          }else
          {
            fedoForm.setHdnFlagIT(sFlag);
          } */
           fedoForm.setHdnFlagIT(sFlag);     
          
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);              

  }
  
}