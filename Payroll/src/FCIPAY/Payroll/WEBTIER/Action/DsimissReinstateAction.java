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
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.WEBTIER.Form.MaintEmpPenalityForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpPenalityBD;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPenalityQueryVO;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;

public class DsimissReinstateAction extends BaseAction
{
  public DsimissReinstateAction()
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
      MaintEmpPenalityForm fedoForm = (MaintEmpPenalityForm)oBaseForm;      
      EmpPenalityBD oEmpPenalityBD = (EmpPenalityBD)oBaseBD;
      EmpPenalityQueryVO oEmpPenalityQueryVO = new EmpPenalityQueryVO();
      long lUserID = fedoForm.getLoginEmployeeNo();
      long lSiteID = fedoForm.getLoginLocCode();
      BeanUtils.copyProperties(oEmpPenalityQueryVO,form);
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      oEmpPenalityQueryVO.setUserId(lUserID);
      oEmpPenalityQueryVO.setSiteId(lSiteID);
      String hdnAction=fedoForm.getHdnAction();

      String sErrCode = oEmpPenalityBD.reinstateDismissed(oEmpPenalityQueryVO);
      if(sErrCode.equals("0"))
      {
            fedoForm.setTxtWaiveFlg("W");
            String sQueryVO = FCIPAY.Payroll.common.utility.ParamUtil.getQueryVO(sFormName); // Get the fully qualified VO class name
            BaseQueryVO oBaseQueryVO = (BaseQueryVO)Class.forName(sQueryVO).newInstance(); //Create new query vo instance
            BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
            oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
            UserSession oUser = getUserSessionBean(request);
            UserInfoBean obUserInfo = new UserInfoBean();   
            BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
            if(request.getSession().getAttribute("USERINFO")==null){}
            else
            {
                obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
                oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
                oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
            }
            RecordMetaInfo oHeaderMetaInfo = null;
            oHeaderMetaInfo = oEmpPenalityBD.getHdrRcdDissReinstateMetaImpl(oBaseQueryVO); //getting header count
            if(oHeaderMetaInfo != null)
            {        
                oBaseHeaderVO.setOWhenPicked(oHeaderMetaInfo.getOWhenPicked());
                oBaseHeaderVO.setTotalCount(oHeaderMetaInfo.getRecordCount());        
            }
            else
            {
                throw new EnrgiseApplicationException("wenrgise.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            oBaseHeaderVO.setMaxHeaderSize(oBaseQueryVO.getMaxHeaderSize());
            if(oHeaderMetaInfo.getRecordCount() == 0)
            {
                throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            oBaseHeaderVO.setPositionRequested(1);
            oBaseHeaderVO.setCurrentSlot(oBaseHeaderVO.getSlot());
            ArrayList oHeaderList = null;
            oHeaderList = oEmpPenalityBD.getHdrRcdDissReinstateImpl(oBaseQueryVO,oBaseHeaderVO.getHeaderStartPosition(),oBaseHeaderVO.getHeaderLastPosition()); // getting data
            if(oHeaderList == null)
            {        
                throw new EnrgiseApplicationException("wenrgise.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if(oUser == null)
            {
                throw new EnrgiseApplicationException("wenrgise.common.sessiontimedout",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
            }
            oBaseHeaderVO.setOHeaderVOTable(oHeaderList);
            oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);
            oUser.putBaseQueryVO(sFormName,oBaseQueryVO);
            
            if(oBaseHeaderVO.getTotalCount() == 0)
            {
                oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);              
                throw new EnrgiseApplicationException("Payroll.GetDetails.NoRecords2",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            if(oBaseHeaderVO.getTotalCount() > 0)
            {
                oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
            }      
            controlHeaderNavigation(oBaseForm);
            BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
            BeanUtils.copyProperties(form,oBaseHeaderVO);
            if(oBaseForm.getTotalCount() > 0)
            {
                oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE);        
            }
            oBaseForm.setTotalCount(oBaseHeaderVO.getTotalCount());
            oBaseForm.setPositionRequested(oBaseHeaderVO.getPositionRequested());  
            throw new EnrgiseApplicationException("Pay.DismissReinstate_SUCCESS",EnrgiseConstants.MESSAGE);
      }
      else
      {
        throw new EnrgiseApplicationException("Pay.PenIncrReinstate_ERROR",EnrgiseConstants.MESSAGE);
      }
   }
}