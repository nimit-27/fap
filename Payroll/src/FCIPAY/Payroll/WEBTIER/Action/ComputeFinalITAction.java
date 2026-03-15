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
import FCIPAY.Payroll.WEBTIER.Form.ComFinalSetForm;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.ComFinalSetBD;
import FCIPAY.Payroll.UTILITY.ComFinalHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetQueryVO;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.COMMON.UTILITY.UserInfoBean;

public class ComputeFinalITAction  extends BaseAction
{
  public ComputeFinalITAction()
  {
  }
  
   public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
    String sFormName = form.getClass().getName(); //Get fully qualified form class
    BaseHeaderVO oBaseHeaderVO = null;
    UserSession oUser = getUserSessionBean(request);
    
    ComFinalSetBD oComFinalSetBD = new ComFinalSetBD();
    ComFinalSetForm oComFinalSetForm = (ComFinalSetForm)form;
    String sScreenName=oComFinalSetForm.getScreenName();
      if(oComFinalSetForm.isHeaderDataChanged() || oComFinalSetForm.isDetailDataChanged())
      {
        throw new EnrgiseApplicationException("wenrgise.common.datashouldbesaved",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }
    
    
    String procs = oComFinalSetForm.getTxtBtnAction();
    String empNo = oComFinalSetForm.getTxtEmpNo();
    String errorCode = new String ("UNSUCCESSFULLY DONE");
    ComFinalSetQueryVO oComFinalSetQueryVO=new ComFinalSetQueryVO();
    BeanUtils.copyProperties(oComFinalSetQueryVO,form);
    
  /*  if(procs.equals("DED"))
    {
       errorCode = oComFinalSetBD.compute(procs,oComFinalSetQueryVO);
    //  errorCode = "SUCCESSFULLY DONE";
    }
    if(procs.equals("GRA"))
    {
      errorCode = oComFinalSetBD.compute(procs,oComFinalSetQueryVO);
    }
    if(procs.equals("LEAVE"))
    {
      errorCode = oComFinalSetBD.compute(procs,oComFinalSetQueryVO);
    }
    if(procs.equals("SAL"))
    {
      errorCode = oComFinalSetBD.compute(procs,oComFinalSetQueryVO);
    }
    
    if(procs.equals("IT"))
    {
      errorCode = oComFinalSetBD.computeITDetails(procs,oComFinalSetQueryVO);
    }
*/
    errorCode = oComFinalSetBD.computeITDetails(oComFinalSetQueryVO);
    ArrayList oArguments = new ArrayList();
    if(errorCode==null || errorCode.equals(""))
    {
      errorCode="SUCCESSFULLY DONE";
    }
    oArguments.add(new String(errorCode));
  /* if(errorCode.equals("SUCCESSFULLY DONE"))
    { 
      throw new EnrgiseApplicationException("pay.ComFinalSet.Payroll_SUCCESS",oArguments);
    }
    else
    {      
      oComFinalSetForm.setHeaderDataChanged(false);
    } */
    
    
    
    //Code to Fetch the data after process.
    
      oComFinalSetForm.setHeaderDataChanged(false);
      oComFinalSetForm.setDetailDataChanged(false);

      BaseQueryVO oBaseQueryVO = oComFinalSetQueryVO;
      if(oComFinalSetForm.isHeaderFields())
      {      
          if(oComFinalSetForm.getPositionRequested() > 0)
          {
            // A particular header position requested so ignore the primary key
            oBaseHeaderVO = oComFinalSetBD.getNextHeaderRecord(oBaseQueryVO,oComFinalSetForm.getPositionRequested(),sFormName,true,oUser);
            int iRelativePosition = (int)(oBaseHeaderVO.getPositionRequested() - oBaseHeaderVO.getHeaderStartPosition() +1);
            BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(iRelativePosition)); //Copy header record to form
            BeanUtils.copyProperties(form,oBaseHeaderVO);
          }
          else
          {
            // Only this particular record is required
           // oBaseQueryVO = getQueryVO(form);

            BeanUtils.copyProperties(oBaseQueryVO,form); // Copy query from action form
          //  oBaseQueryVO.setHeaderPrimaryKey(sHeaderPrimaryKey);
            oBaseQueryVO.setMaxHeaderSize(FCIPAY.Payroll.common.utility.ParamUtil.getHeaderSize(sFormName));
            oBaseHeaderVO = oComFinalSetBD.getHeaderRecord(oBaseQueryVO,sFormName,oUser);
            BeanUtils.copyProperties(form,oBaseHeaderVO.getHeaderRecord(1)); //Copy header record to form
            BeanUtils.copyProperties(form,oBaseHeaderVO);
          }
      }
      
      oUser.putBaseHeaderVO(sFormName,oBaseHeaderVO);   
      
      
      
      //Code to fetch the detail information again...............
      
      
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseDetailInfo oBaseDetailInfo = getBaseDetailInfo(form);
      BaseDetailVO oBaseDetailVO = null;
      String sHeaderPrimaryKey="";
      if(null == oBaseDetailInfo)
      {
        oBaseDetailVO = oComFinalSetBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser);        
      }
      else
      {               
        BeanUtils.copyProperties(oBaseDetailInfo,form);
        UserInfoBean obUserInfo = new UserInfoBean();
        if(request.getSession().getAttribute("USERINFO")==null){}
        else
        {
        obUserInfo =(UserInfoBean)(request.getSession().getAttribute("USERINFO"));
        oBaseDetailInfo.setUserId(obUserInfo.getLEmployeeNo());
        oBaseDetailInfo.setSiteId(obUserInfo.getLLocationCode());
        }
        
        oBaseDetailVO = oComFinalSetBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,1,oDetailSizeValues,null,false,oUser,oBaseDetailInfo);
      }
      /* Changed by Basu */
      //oBaseForm.setDetailStartPage(1);
      if(oBaseDetailVO.getOThisPageData() != null)
      {        
        BeanUtils.setProperty(oComFinalSetForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
      }
      /* Changed by Basu */
      oComFinalSetForm.setPageRequested(1);
      oComFinalSetForm.setThisPageDetailCount((null != oBaseDetailVO.getOThisPageData())?oBaseDetailVO.getOThisPageData().size():0);
      //BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);
       
     long totDetRecord=oBaseDetailVO.getTotalDetailRecord();
     long totRecPerPage=FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName);
     
     if(totDetRecord%totRecPerPage!=0)
     {
       oComFinalSetForm.setTotalPageCount(totDetRecord/totRecPerPage+1);
     }
     if(totDetRecord%totRecPerPage!=0 && totDetRecord<totRecPerPage)
     {
       oComFinalSetForm.setTotalPageCount(totDetRecord/totRecPerPage+1);
     }
      if(totDetRecord%totRecPerPage==0)
     {
       oComFinalSetForm.setTotalPageCount(totDetRecord/totRecPerPage);
     }
    
   throw new EnrgiseApplicationException("pay.ComFinalSet.Payroll_SUCCESS",oArguments);
  }

}