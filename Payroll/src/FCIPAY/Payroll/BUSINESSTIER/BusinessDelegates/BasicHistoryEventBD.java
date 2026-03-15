package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.UTILITY.BasicHistoryEventHeaderBean;
import FCIPAY.Payroll.UTILITY.IncomeTaxRegimeHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;

import javax.ejb.CreateException;

public class BasicHistoryEventBD extends PayrollBaseBD {
    public BasicHistoryEventBD() {
        
    }

    @Override
    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException {
        
        try
        {
            PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
            PayrollFacade oPayFacade = oHome.create();
            return oPayFacade.getBasicHistoryEventHeaderMetaImpl(oBaseQueryVO);
        
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
    public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO, long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException{
        try
        {
           PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
           PayrollFacade oPayFacade = oHome.create();
           return oPayFacade.getBasicHistoryEventHeaderRecord(oQueryVO,lStartPosition,lLastPosition);      
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
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey, String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException{
        try
        {      
          PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
          PayrollFacade oPayrollFacade = oHome.create();
          return oPayrollFacade.getBasicHistoryEventDetailMetaInfo(sPrimaryKey,"");
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
    public ArrayList getDetailRecordImpl(String sPrimaryKey, String sScreenName, long lAbsoluteStart,
                                         long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException{
        try
        {      
          PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
          PayrollFacade oPayrollFacade = oHome.create();
          return oPayrollFacade.getBasicHistoryEventDetail(sPrimaryKey,"",lAbsoluteStart,lAbsoluteEnd); 
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
    public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,
                           String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,
                           boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException{
        try
        {      
          PayrollFacadeHome oHome = (PayrollFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollFacade");
          PayrollFacade oPayrollFacade = oHome.create();
          return oPayrollFacade.saveBasicHistoryEvent((BasicHistoryEventHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
    public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) {
        return false;
    }

}
