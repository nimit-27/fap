package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveTravelConcessionQueryVO;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;
import FCIPAY.Payroll.UTILITY.LTCEncashHeaderBean;
import FCIPAY.Payroll.UTILITY.LeaveTravelConcessionHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;

import javax.ejb.CreateException;

public class LeaveTravelConcessionBD  extends BaseBD{
    
    public LeaveTravelConcessionBD() {
        super();
    }

    @Override
    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException{
        try
        {      
          PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
          PayrollFacade oEmpFinInfoFacade = oHome.create();
          return oEmpFinInfoFacade.getLeaveTravelConcessionHeaderMetaInfo((LeaveTravelConcessionQueryVO)oBaseQueryVO);
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
    public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO, long lStartPosition, long lLastPosition)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException{
        try
        {      
          PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
          PayrollFacade oEmpFinInfoFacade = oHome.create();
          
          ArrayList oHeaderList = oEmpFinInfoFacade.getLeaveTravelConcessionHeader((LeaveTravelConcessionQueryVO)oQueryVO,lStartPosition,lLastPosition);
          return oHeaderList;
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
    public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
        PayrollFacade oEmpFinInfoFacade = oHome.create();
        return oEmpFinInfoFacade.saveLeaveTravelConcessionInfo((LeaveTravelConcessionHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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

    
    public ArrayList getITDed(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
        PayrollFacade oEmpFinInfoFacade = oHome.create();
        
        ArrayList oPayInfo = oEmpFinInfoFacade.getLeaveTravelConcessionITDed((LeaveTravelConcessionQueryVO)oQueryVO);
        return oPayInfo;
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
        

    public String sendLeaveTravelConcessionInv(String sPrimaryKey,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {      
        PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
        PayrollFacade oEmpFinInfoFacade = oHome.create();
        
        return oEmpFinInfoFacade.sendLeaveTravelConcessionInv(sPrimaryKey,hdnEmpLbrFlag,lUserID,lSiteID);
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
    public String  deleteLeaveTravelConcessionPayment(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
        PayrollNewFacade oEmpFinInfoFacade = oHome.create();
        
        String oLeaveInfo = oEmpFinInfoFacade.deleteLeaveTravelConcession((LeaveTravelConcessionQueryVO)oQueryVO);
        return oLeaveInfo;
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
    
    public String cancelLeaveTravelConcessionInv(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {      
        PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
        PayrollNewFacade oEmpFinInfoFacade = oHome.create();
        String oLeaveInfo = oEmpFinInfoFacade.cancelLeaveTravelConcessionInv((LeaveTravelConcessionQueryVO)oQueryVO);
       return oLeaveInfo;
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

    @Override
    public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) {
        return false;
    }

}
