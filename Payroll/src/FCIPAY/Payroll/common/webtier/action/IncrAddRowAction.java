package FCIPAY.Payroll.common.webtier.action;
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
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.WEBTIER.Form.MaintPayScaleForm;
import FCIPAY.Payroll.UTILITY.MaintPayScaleDtlIDABean;
import FCIPAY.Payroll.WEBTIER.Form.MaintainDirectPayrollForm;
import FCIPAY.Payroll.UTILITY.MaintainDirectPayrollBean;
import FCIPAY.Payroll.WEBTIER.Form.MaintainInternalSavingsForm;
import FCIPAY.Payroll.UTILITY.MaintainInternalSavingsBean;
import FCIPAY.Payroll.WEBTIER.Form.MaintainExternalSavingsForm;
import FCIPAY.Payroll.UTILITY.MaintainExternalSavingsBean;
import FCIPAY.Payroll.WEBTIER.Form.MaintElecMtrRdgForm;
import FCIPAY.Payroll.UTILITY.MaintElecMtrRdgBean;
import FCIPAY.Payroll.WEBTIER.Form.MaintEmpLeaveForm;
import FCIPAY.Payroll.WEBTIER.Form.MaintDeptAttanLeaveForm;
import FCIPAY.Payroll.UTILITY.MaintEmpLeaveBean;
import FCIPAY.Payroll.UTILITY.MaintDeptAttanLeaveBean;

import FCIPAY.Payroll.WEBTIER.Form.MaintIntRatesForm;
import FCIPAY.Payroll.UTILITY.IntRateDetailBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;

public class IncrAddRowAction extends BaseAction
{
  public IncrAddRowAction()
  {
  }

  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
     /* if(oBaseForm.getScreenMode().equals(EnrgiseConstants.NEW_MODE))
      {
        throw new EnrgiseApplicationException("wenrgise.common.saveheaderrecord",EnrgiseConstants.MESSAGE);
      } */
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String sHeaderPrimaryKey = oBaseForm.getHeaderPrimaryKey();
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      UserSession oUser = getUserSessionBean(request);
      DetailSizeValues oDetailSizeValues = new DetailSizeValues();
      oDetailSizeValues.setDetailRecordPerPage(FCIPAY.Payroll.common.utility.ParamUtil.getDetailRecordPerPage(sFormName,sScreenName));
      oDetailSizeValues.setMaxPages(FCIPAY.Payroll.common.utility.ParamUtil.getMaxDetailPages(sFormName,sScreenName));
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = null;
      long lPageRequested = 1;
      boolean bLimitReached = false;
      ArrayList oDetailList = null;
      
      if(oBaseDetailVO != null)
      {
        if(oBaseDetailVO.getOThisPageData().size() >= oDetailSizeValues.getDetailRecordPerPage())
        {
          bLimitReached = true;
        }
        // Detail exists check if save required
        if(oBaseForm.isHeaderDataChanged() || oBaseForm.isDetailDataChanged())
        {
          if(oBaseDetailVO.getOThisPageData() != null)
          {
            // If already limit reached then save first
            if(bLimitReached)
            {
              throw new EnrgiseApplicationException("wenrgise.common.savefirst",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
            }
            else
            {
              oDetailList = getDetailArray(oBaseForm);
            }
          }
          else
          {
            oBaseDetailVO.setOThisPageData(new ArrayList());
          }
        }
        else
        {
          lPageRequested = getPageRequested(oBaseDetailVO,oDetailSizeValues);
          oBaseDetailVO = oBaseBD.getDetailRecord(sFormName,sScreenName,sHeaderPrimaryKey,lPageRequested,oDetailSizeValues,oBaseDetailVO,false,oUser);
        }
      }
      else
      {
        oBaseDetailVO = new BaseDetailVO();
        oBaseDetailVO.setCurrentPage(1);
        oBaseDetailVO.setCurrentSlot(1);
        oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
        oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
        oBaseDetailVO.setOThisPageData(new ArrayList());
        oBaseDetailVO.setOAllPageData(new ArrayList());

//        oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);        
      }

      oBaseForm.setThisPageDetailCount(null != oBaseDetailVO.getOThisPageData()?oBaseDetailVO.getOThisPageData().size():0);              
      
      oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() +1);
      oBaseDetailBean = getDetailBean(form);


      if(sScreenName.equals("DirectPayrollScreen"))
      {
        MaintainDirectPayrollForm fedoForm = (MaintainDirectPayrollForm)oBaseForm;
        ArrayList newList = fedoForm.getLstInstrDtls();  
//        if(newList.size()>0)
//        {  
            if (fedoForm.getOptVal().equals("1"))
            {
                String sEmpNo1 = fedoForm.getTxtEmpNo1();
                String sEmpName = fedoForm.getTxtName1();
                String sEmpStatus = fedoForm.getTxtEmpStatus1();
                MaintainDirectPayrollBean fedoBean = (MaintainDirectPayrollBean)oBaseDetailBean;                
                fedoBean.setTxtEmpNo(sEmpNo1);                
                fedoBean.setTxtName(sEmpName);
                fedoBean.setTxtEmpStatus(sEmpStatus);
            }

            else if (fedoForm.getOptVal().equals("2"))
            {
                String sPayCode1 = fedoForm.getTxtPayCode1();
                String sPayCodeDesc = fedoForm.getTxtPayCodeName();
                MaintainDirectPayrollBean fedoBean = (MaintainDirectPayrollBean)oBaseDetailBean;                
                fedoBean.setTxtPayCode(sPayCode1); 
                fedoBean.setTxtDescription(sPayCodeDesc);
                
            }            
//        }
      }  
 if(sScreenName.equals("InternalScreen"))
      {
        MaintainInternalSavingsForm fedoForm = (MaintainInternalSavingsForm)oBaseForm;
        MaintainInternalSavingsBean fedoBean = (MaintainInternalSavingsBean)oBaseDetailBean;
        fedoBean.setTxtEmpNo(fedoForm.getTxtEmpNo1());
        fedoBean.setTxtEmpName(fedoForm.getTxtEmpName1());
        fedoBean.setTxtSavCode(fedoForm.getTxtSavCode1());
        fedoBean.setTxtDescription(fedoForm.getTxtSavCodeName());
      }

      if(sScreenName.equals("ExternalScreen"))
      {
        MaintainExternalSavingsForm fedoForm = (MaintainExternalSavingsForm)oBaseForm;
        MaintainExternalSavingsBean fedoBean = (MaintainExternalSavingsBean)oBaseDetailBean;
        fedoBean.setTxtEmpNo(fedoForm.getTxtEmpNo1());
        fedoBean.setTxtEmpName(fedoForm.getTxtEmpName1());
        fedoBean.setTxtSavCode(fedoForm.getTxtSavCode1());
        fedoBean.setTxtDescription(fedoForm.getTxtSavCodeName());
      }      

// Added by Balpreet Dt 7 Mar 2008 . For adding employee wise leave information....
      if(sScreenName.equals("LeaveScreen"))
      {
        MaintEmpLeaveForm fedoForm = (MaintEmpLeaveForm)oBaseForm;
        MaintEmpLeaveBean fedoBean = (MaintEmpLeaveBean)oBaseDetailBean;
        fedoBean.setTxtEmpCode(fedoForm.getTxtEmpNo());
        fedoBean.setTxtEmpName(fedoForm.getTxtEmpNameHdr());
        fedoBean.setTxtGender(fedoForm.getTxtGend());
      }      
 if(sScreenName.equals("AttandanceUpdationScreen"))
      {
        MaintDeptAttanLeaveForm fedoForm = (MaintDeptAttanLeaveForm)oBaseForm;
        MaintDeptAttanLeaveBean fedoBean = (MaintDeptAttanLeaveBean)oBaseDetailBean;
        fedoBean.setTxtEmpCode(fedoForm.getTxtEmpNo());
       
        
        fedoBean.setTxtEmpName(fedoForm.getTxtEmpNameHdr());
        
      }    
// Added by Balpreet Dt 3 June 2008 . For adding loan wise loan information ....
/*      if(sScreenName.equals("IntRateScreen"))
      {
        MaintIntRatesForm fedoForm = (MaintIntRatesForm)oBaseForm;
        IntRateDetailBean fedoBean = (IntRateDetailBean)oBaseDetailBean;
        fedoBean.setLoanType(fedoForm.getHeaderPrimaryKey());
        fedoBean.setLoanDesc(fedoForm.getLoanHdrDesc());
      }      
*/

      if(sScreenName.equals("MtrRdgScreen"))
      {
        MaintElecMtrRdgForm fedoForm = (MaintElecMtrRdgForm)oBaseForm;
        ArrayList newList = fedoForm.getLstInstrDtls();  
        MaintElecMtrRdgBean fedoBean = (MaintElecMtrRdgBean)oBaseDetailBean;
        if(newList.size()>0)
        {
            int tflag = 0;
            int iIndex = newList.size() - 1;
            while(fedoForm.getStatus()[iIndex].equals("D"))
            {
              --iIndex;
              if(iIndex <0)
              {
                iIndex = 0;
                tflag = 1;
                break;
              }             
            }
            
            String tempR = fedoForm.getTxtFinalReading()[iIndex];
            long valR = Long.parseLong(tempR);
            String tempY = fedoForm.getTxtFinalYearMonth()[iIndex];
            long valY = Long.parseLong(tempY);

            fedoBean.setTxtInitialReading(String.valueOf(valR+1));
            fedoBean.setTxtInitialYearMonth(String.valueOf(valY+1));


              if(iIndex == 0 && tflag == 1)
              {
                  fedoBean.setTxtInitialReading("0");
                  fedoBean.setTxtInitialYearMonth("0");
              }
        }
        else
        {
            fedoBean.setTxtInitialReading(String.valueOf(0));
            fedoBean.setTxtInitialYearMonth(String.valueOf(0));          
        }
      }
    
      
      oBaseDetailBean.setStatus("N");
      oBaseForm.setThisPageDetailCount(oBaseForm.getThisPageDetailCount() + 1);
      if(oDetailList != null)
      {
        oDetailList.add(oBaseDetailBean);
        oBaseDetailVO.setOThisPageData(oDetailList);
      }
      else
      {
        oBaseDetailVO.getOThisPageData().add(oBaseDetailBean);        
      }
      if(oBaseDetailVO.getOAllPageData() == null)
      {
        oBaseDetailVO.setOAllPageData(new ArrayList());
      }
      oBaseDetailVO.getOAllPageData().add(oBaseDetailBean);
      oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      oBaseForm.setDetailDataChanged(true);
      BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
      //BeanUtils.copyProperties(oBaseForm,oBaseDetailVO);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
  
  private void populateThisPageList(BaseDetailVO oBaseDetailVO, DetailSizeValues oDetailSizeValues)
  {
//      oBaseDetailVO.setRowAdded(oBaseDetailVO.getRowAdded() + 1);
        long lGrandTotalDetailRecord = oBaseDetailVO.getTotalDetailRecord() - oBaseDetailVO.getRowDeleted() + oBaseDetailVO.getRowAdded();
        int iPage =(int) lGrandTotalDetailRecord % oDetailSizeValues.getDetailRecordPerPage() + 1;
        int iDetailStartPosition = (iPage-1)*oDetailSizeValues.getDetailRecordPerPage() + 1;
        if(iDetailStartPosition < lGrandTotalDetailRecord +1)
        {
          
        }
    
  }
  
  private long getPageRequested(BaseDetailVO oBaseDetailVO,DetailSizeValues oDetailSizeValues)
  {
    long lLastRecordNumber = oBaseDetailVO.getTotalDetailRecord() - oBaseDetailVO.getRowDeleted() + oBaseDetailVO.getRowAdded() +1;
    return (lLastRecordNumber % oDetailSizeValues.getDetailRecordPerPage() != 0)?(lLastRecordNumber / oDetailSizeValues.getDetailRecordPerPage() + 1):(lLastRecordNumber / oDetailSizeValues.getDetailRecordPerPage());
  }
  
}