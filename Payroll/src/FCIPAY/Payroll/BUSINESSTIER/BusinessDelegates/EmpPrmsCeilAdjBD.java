package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.UTILITY.LeaveEncashHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjHistoryDetailParm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProfTaxDetailInfo;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.UTILITY.EmpPrmsCeilAdjHeaderBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class EmpPrmsCeilAdjBD extends BaseBD 
{
  public EmpPrmsCeilAdjBD()
  {
    super();
  }
 
// @Override
// public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
// {
//  try
//  {      
//      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
//      PayrollFacade oPayrollFacade = oHome.create();
//    
//      return oPayrollFacade.getEmpPrmsCeilAdjDetailMetaInfo(sPrimaryKey,"E");
//  }
//  catch(RemoteException oRe)
//  {
//    throw new EnrgiseSystemException(oRe);
//  }
//  catch(CreateException oCrt)
//  {
//    throw new EnrgiseSystemException(oCrt);      
//  }
// }
//
//
// @Override
// public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
// {
//  try
//  {      
//    PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
//    PayrollFacade oPayrollFacade = oHome.create();
//    
//    return oPayrollFacade.getEmpPrmsCeilAdjDetail(sPrimaryKey,"E",lAbsoluteStart,lAbsoluteEnd); 
//    
//  }
//  catch(RemoteException oRe)
//  {
//    throw new EnrgiseSystemException(oRe);
//  }
//  catch(CreateException oCrt)
//  {
//    throw new EnrgiseSystemException(oCrt);      
//  }
// }
 
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,EmpPrmsCeilAdjHistoryDetailParm oEmpPrmsCeilAdjHistoryDetailParm,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {      
        PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
        PayrollFacade oProfFacade = oHome.create();
        return oProfFacade.getEmpPrmsCeilAdjDetailMetaInfo(sPrimaryKey,oEmpPrmsCeilAdjHistoryDetailParm);
      }
      catch(RemoteException oRe)
      {
        throw new EnrgiseSystemException(oRe);
      }
      catch(CreateException oCrt)
      {
        throw new EnrgiseSystemException(oCrt);      
      }
    }
        
    public BaseDetailVO getDetailRecord(String sFormName, String sScreenName,String sPrimaryKey,long lPageRequested,DetailSizeValues oDetailSizeValues,BaseDetailVO oBaseDetailVO,boolean bForce,UserSession oUser,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oDetailList = null;
      try
      {      
        PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
        PayrollFacade oProfFacade = oHome.create();
        
        if(oBaseDetailVO == null || bForce)
        {
          //oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
          oBaseDetailVO = new BaseDetailVO();
          oBaseDetailVO.setMaxPage(oDetailSizeValues.getMaxPages());
          oBaseDetailVO.setRecordsPerPage(oDetailSizeValues.getDetailRecordPerPage());
          // Get the total number of record and set it into VO
          RecordMetaInfo oRecordMetaInfo = getTotalDetailRecordCountImpl(sPrimaryKey,(EmpPrmsCeilAdjHistoryDetailParm)oBaseDetailInfo,sScreenName);
          if(null == oRecordMetaInfo)
          {
            throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);          
          }
          oBaseDetailVO.setTotalDetailRecord(oRecordMetaInfo.getRecordCount());
          oBaseDetailVO.setOWhenPicked(oRecordMetaInfo.getOWhenPicked());
          if(oRecordMetaInfo.getRecordCount() == 0)
          {
            return oBaseDetailVO;
          }
        
        // The page displayed is requested again
        if(oBaseDetailVO.getCurrentPage() == lPageRequested)
        {
          return oBaseDetailVO;
        }
        else
        {
          long lSlotRequested = oBaseDetailVO.getSlot(lPageRequested);
          if(lSlotRequested == oBaseDetailVO.getCurrentSlot())
          {
            // The page is already in the slot so we do not need to go to the database
            int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
            int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
            oBaseDetailVO.setCurrentPage(lPageRequested);
            FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
            oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
            return oBaseDetailVO;
          }
        }
        
        long lAbsoluteStart = oBaseDetailVO.getAbsoluteStart(lPageRequested);
        long lAbsoluteEnd = oBaseDetailVO.getAbsoluteEnd(lPageRequested);
    //      oDetailList = getDetailRecordImpl(sPrimaryKey,sScreenName,lAbsoluteStart,lAbsoluteEnd);
        oDetailList = oProfFacade.getEmpPrmsCeilAdjDetail(sPrimaryKey,(EmpPrmsCeilAdjHistoryDetailParm)oBaseDetailInfo,lAbsoluteStart,lAbsoluteEnd);
        if(oDetailList == null)
        {        
          throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
        }
        if(oDetailList.size() == 0)
        {
          throw new EnrgiseApplicationException("IBA.Payroll.common.nodetailrecord",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);        
        }
        oBaseDetailVO.setOAllPageData(oDetailList); 
        int iRelativeStartIndex = oBaseDetailVO.getRelativeStart(lPageRequested);
        int iRelativeEndIndex = oBaseDetailVO.getRelativeEnd(lPageRequested);
        FCIPAY.Payroll.common.utility.ArrayListUtil.pageArrayCopier(oBaseDetailVO.getOAllPageData(),oBaseDetailVO.getOThisPageData(),iRelativeStartIndex,iRelativeEndIndex - iRelativeStartIndex +1);
        oBaseDetailVO.setCurrentPage(lPageRequested);
        oBaseDetailVO.setCurrentSlot(oBaseDetailVO.getSlot(lPageRequested));
        oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
        
        return oBaseDetailVO;
        }
        return null;
      }
      catch(RemoteException oRe)
      {
        throw new EnrgiseSystemException(oRe);
      }
      catch(CreateException oCrt)
      {
        throw new EnrgiseSystemException(oCrt);      
      }
      
    }
       
    
  public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      return oEmpFinInfoFacade.saveEmpPrmsCeilAdjInfo((EmpPrmsCeilAdjHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    //  return null;
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
  }

  public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
     return true;
  }

  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      return oEmpFinInfoFacade.getEmpPrmsCeilAdjHeaderMetaInfo((EmpPrmsCeilAdjQueryVO)oQueryVO);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
  }

  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
      PayrollFacade oEmpFinInfoFacade = oHome.create();
      
      return oEmpFinInfoFacade.getEmpPrmsCeilAdjHeader((EmpPrmsCeilAdjQueryVO)oQueryVO,lStartPosition,lLastPosition);
    }
    catch(RemoteException oRe)
    {
      throw new EnrgiseSystemException(oRe);
    }
    catch(CreateException oCrt)
    {
      throw new EnrgiseSystemException(oCrt);      
    }
  }

    @Override
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey, String sScreenName) {
        return null;
    }

    @Override
    public ArrayList getDetailRecordImpl(String sPrimaryKey, String sScreenName, long lAbsoluteStart,
                                         long lAbsoluteEnd) {
        return null;
    }
}
