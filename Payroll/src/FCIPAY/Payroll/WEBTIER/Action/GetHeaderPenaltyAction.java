package FCIPAY.Payroll.WEBTIER.Action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import java.util.ArrayList;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpPenalityBD;

public class GetHeaderPenaltyAction extends BaseAction
{
  public GetHeaderPenaltyAction()
  {
  }
  
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      
      BaseForm oBaseForm = (BaseForm)form;
      
      if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      //BaseQueryVO oBaseQueryVO = getQueryVO(form); //Create new query vo instance
      String sScreenName = oBaseForm.getScreenName(); // Get the action
      String sQueryVO = FCIPAY.Payroll.common.utility.ParamUtil.getQueryVO(sFormName); // Get the fully qualified VO class name
      BaseQueryVO oBaseQueryVO = (BaseQueryVO)Class.forName(sQueryVO).newInstance(); //Create new query vo instance
      
      String sBusinessDelegate  = FCIPAY.Payroll.common.utility.ParamUtil.getHeaderBD(sFormName); // Get the fully qualified Business Delegate class name
      BaseBD oBaseBD = (BaseBD)Class.forName(sBusinessDelegate).newInstance(); //Create new BD instance
      BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
      oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
      UserSession oUser = getUserSessionBean(request);

      UserInfoBean obUserInfo = new UserInfoBean();      

     if(request.getSession().getAttribute("USERINFO")==null){}
      else{
      obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
      oBaseQueryVO.setUserId(obUserInfo.getLEmployeeNo());
      oBaseQueryVO.setSiteId(obUserInfo.getLLocationCode());
      }
      String shdnAction = (String)request.getParameter("hdnAction");
      
      
      //////////////////////////////////
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
        //oQueryVO.setPositionRequested(1); //No particular position requested
        
        try
        {
            EmpPenalityBD oEmpPenalityBD = new EmpPenalityBD();
            RecordMetaInfo oHeaderMetaInfo = null;
            if(shdnAction.equals("GET_HDR_WAVE"))
            {
                oHeaderMetaInfo = oEmpPenalityBD.getHdrRcdWaveOffMetaImpl(oBaseQueryVO);        
            }
            else if(shdnAction.equals("GET_HDR_INCR"))
            {
                oHeaderMetaInfo = oEmpPenalityBD.getHdrRcdIncrWaveMetaImpl(oBaseQueryVO); 
            }
            else if(shdnAction.equals("GET_HDR_DISMISS"))
            {
                oHeaderMetaInfo = oEmpPenalityBD.getHdrRcdDissReinstateMetaImpl(oBaseQueryVO); 
            }
            
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
            if(shdnAction.equals("GET_HDR_WAVE"))
            {
                oHeaderList = oEmpPenalityBD.getHdrRcdWaveOffImpl(oBaseQueryVO,oBaseHeaderVO.getHeaderStartPosition(),oBaseHeaderVO.getHeaderLastPosition());
            }
            else if(shdnAction.equals("GET_HDR_INCR"))
            {
                oHeaderList = oEmpPenalityBD.getHdrRcdIncrWaveImpl(oBaseQueryVO,oBaseHeaderVO.getHeaderStartPosition(),oBaseHeaderVO.getHeaderLastPosition());
            }
            else if(shdnAction.equals("GET_HDR_DISMISS"))
            {
                oHeaderList = oEmpPenalityBD.getHdrRcdDissReinstateImpl(oBaseQueryVO,oBaseHeaderVO.getHeaderStartPosition(),oBaseHeaderVO.getHeaderLastPosition());
            }

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
        }
        catch(RemoteException oEx)
        {
            throw new EnrgiseSystemException();
        }
        
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
     return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
  
}