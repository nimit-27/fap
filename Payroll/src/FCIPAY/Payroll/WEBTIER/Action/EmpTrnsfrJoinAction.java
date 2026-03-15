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
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.WEBTIER.Form.ECSDataFileForm;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.EmpTrnsfrBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrQueryVO;

public class EmpTrnsfrJoinAction extends BaseAction
{
  public EmpTrnsfrJoinAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseBD oBaseBD = new EmpTrnsfrBD();
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      ArrayList oDetailBeanArray = null;
      BaseDetailVO oBaseDetailVO = null;
      BaseHeaderVO oBaseHeaderVO = null;
      Timestamp oHeaderPicked = null;
      Timestamp oDetailPicked = null;
      UserSession oUser = getUserSessionBean(request);
      
      if(!oBaseForm.isDetailDataChanged() && !oBaseForm.isHeaderDataChanged())
      {
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }
      
      BeanUtils.copyProperties(oBaseHeaderBean,form);
      
        if(oBaseForm.isHeaderDataChanged())
        {
         // oBaseHeaderVO = oUser.getBaseHeaderVO(sFormName);
          if(oBaseHeaderVO != null)
          {
            oHeaderPicked = oBaseHeaderVO.getOWhenPicked();
            oBaseHeaderBean = getBaseHeaderBean(sFormName);
          }
          
          BeanUtils.copyProperties(oBaseHeaderBean,form);
        
        }
      
      
    /* Added By Payroll Team for Passing USERID and SITEID  */
      long userId = oBaseForm.getLoginEmployeeNo();
      long siteId = oBaseForm.getLoginLocCode();

      BeanUtils.setProperty(oBaseHeaderBean,"txtUserID",String.valueOf(userId) );
      BeanUtils.setProperty(oBaseHeaderBean,"txtSiteID",String.valueOf(siteId) );

      if(oBaseForm.getScreenName().equals("TransferInScreen"))
      {
        String sHeaderPrimaryKey = oBaseBD.saveRecord(oBaseHeaderBean,oHeaderPicked,oBaseForm.getScreenName(), oBaseForm.getScreenMode(),oBaseForm.isHeaderDataChanged(), oDetailBeanArray,oBaseForm.isDetailDataChanged(),oDetailPicked);
        oBaseForm.setHeaderDataChanged(false);
        oBaseForm.setDetailDataChanged(false);
        if(null != oBaseDetailVO)
        {
          //oBaseDetailVO.setRowDeleted(0);     //I change
         // oBaseDetailVO.setRowAdded(0);
        }
        oBaseForm.setHeaderPrimaryKey(sHeaderPrimaryKey);
        
        changeMode(oBaseForm,request);
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);
        throw new EnrgiseApplicationException("wenrgise.common.datasaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      } 
      else
      {
        EmpTrnsfrBD oEmpTrnsfrBD=(EmpTrnsfrBD)oBaseBD ;
        String sHeaderPrimaryKey = oEmpTrnsfrBD.cancelTrnsfr(oBaseHeaderBean);
        oBaseForm.setHeaderDataChanged(false);
        oBaseForm.setDetailDataChanged(false);
        if(null != oBaseDetailVO)
        {
          //oBaseDetailVO.setRowDeleted(0);     //I change
         // oBaseDetailVO.setRowAdded(0);
        }
        oBaseForm.setHeaderPrimaryKey(sHeaderPrimaryKey);
        ArrayList oArgs=new ArrayList();
        oArgs.add(sHeaderPrimaryKey);
       /* changeMode(oBaseForm,request);
        oBaseForm.setScreenMode(FCIPAY.Payroll.common.utility.EnrgiseConstants.QUERY_MODE);*/
        BaseQueryVO oBaseQueryVO = null;
          if(oBaseForm.isHeaderFields())
          {      
              if(oBaseForm.getPositionRequested() > 0)
              {
                // A particular header position requested so ignore the primary key
                oBaseQueryVO = oUser.getBaseQueryVO(sFormName);
                //BeanUtils.copyProperties(oBaseQueryVO,form);
                //oBaseQueryVO.setHeaderPrimaryKey(null);
                oBaseHeaderVO = oBaseBD.getNextHeaderRecord(oBaseQueryVO,oBaseForm.getPositionRequested(),sFormName,true,oUser);
                int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
                BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
                BeanUtils.copyProperties(form,oBaseHeaderVO);
              }
              else
              {
                // Only this particular record is required
                oBaseQueryVO = new EmpTrnsfrQueryVO();
    
                BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
                oBaseQueryVO.setHeaderPrimaryKey(sHeaderPrimaryKey);
                oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
                oBaseHeaderVO = oBaseBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
                BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
                BeanUtils.copyProperties(form,oBaseHeaderVO);
              }
          }
        
        oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);
        throw new EnrgiseApplicationException("Payroll.EmpTrnsfr.CancelSuccess",oArgs);
      }
      //return mapping.findForward(EnrgiseConstants.SUCCESS);
  }
}