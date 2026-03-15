// 
// Decompiled by Procyon v0.5.36
// 

package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopAMCComboVO;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopAMCQueryVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import javax.ejb.CreateException;
import FCIPAY.Payroll.UTILITY.EmpLaptopAMCHeaderBean;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.rmi.RemoteException;
import java.util.ArrayList;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;

public class EmpLaptopAMCBD extends BaseBD
{
    public RecordMetaInfo getTotalDetailRecordCountImpl(final String sPrimaryKey, final String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException {
        return null;
    }
    
    public ArrayList getDetailRecordImpl(final String sPrimaryKey, final String sScreenName, final long lAbsoluteStart, final long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException {
        return null;
    }
    
    public String saveImpl(final BaseHeaderBean oBaseHeaderBean, final Timestamp oWhenPicked, final String sScreenName, final String sScreenMode, final boolean bHeaderDataChanged, final ArrayList oDetailBeanArray, final boolean bDetailDataChanged, final Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException {
        try {
            final PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
            final PayrollFacade oEmpFinInfoFacade = oHome.create();
            return oEmpFinInfoFacade.saveEmpLaptopAMCInfo((EmpLaptopAMCHeaderBean)oBaseHeaderBean, oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
        }
        catch (RemoteException oRe) {
            throw new EnrgiseSystemException((Exception)oRe);
        }
        catch (CreateException oCrt) {
            throw new EnrgiseSystemException((Exception)oCrt);
        }
    }
    
    public boolean updateHeaderRecordImpl(final BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException {
        return true;
    }
    
    public RecordMetaInfo getHeaderMetaImpl(final BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException {
        try {
            final PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
            final PayrollFacade oEmpFinInfoFacade = oHome.create();
            return oEmpFinInfoFacade.getEmpLaptopAMCHeaderMetaInfo((EmpLaptopAMCQueryVO)oQueryVO);
        }
        catch (RemoteException oRe) {
            throw new EnrgiseSystemException((Exception)oRe);
        }
        catch (CreateException oCrt) {
            throw new EnrgiseSystemException((Exception)oCrt);
        }
    }
    
    public ArrayList getHeaderRecordImpl(final BaseQueryVO oQueryVO, final long lStartPosition, final long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException {
        try {
            final PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
            final PayrollFacade oEmpFinInfoFacade = oHome.create();
            return oEmpFinInfoFacade.getEmpLaptopAMCHeader((EmpLaptopAMCQueryVO)oQueryVO, lStartPosition, lLastPosition);
        }
        catch (RemoteException oRe) {
            throw new EnrgiseSystemException((Exception)oRe);
        }
        catch (CreateException oCrt) {
            throw new EnrgiseSystemException((Exception)oCrt);
        }
    }
    
    public void getComboDetails(final HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException {
        try {
            final PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
            final PayrollFacade oEmpFinInfoFacade = oHome.create();
            final EmpLaptopAMCComboVO oLaptopBuybackComboVO = oEmpFinInfoFacade.getEmpLaptopAMCComboDetails();
            request.getSession().setAttribute("MediBillPayCode", (Object)oLaptopBuybackComboVO);
        }
        catch (RemoteException oRe) {
            throw new EnrgiseSystemException((Exception)oRe);
        }
        catch (CreateException oCrt) {
            throw new EnrgiseSystemException((Exception)oCrt);
        }
    }
    
    public String sendInv(final String oLaptopBuybackId, final String hdnEmpLbrFlag, final long lUserID, final long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException {
        try {
            final PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
            final PayrollFacade oEmpFinInfoFacade = oHome.create();
            return oEmpFinInfoFacade.sendEmpLaptopAMCInv(oLaptopBuybackId, hdnEmpLbrFlag, lUserID, lSiteID);
        }
        catch (RemoteException oRe) {
            throw new EnrgiseSystemException((Exception)oRe);
        }
        catch (CreateException oCrt) {
            throw new EnrgiseSystemException((Exception)oCrt);
        }
    }
    
    public String LaptopBuybackCancelInv(final BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException {
        try {
            final PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)ServiceLocator.getLocator().getService("PayrollNewFacade");
            final PayrollNewFacade oEmpFinInfoFacade = oHome.create();
            final String oLeaveInfo = oEmpFinInfoFacade.EmpLaptopAMCCancelInv((EmpLaptopAMCQueryVO)oQueryVO);
            return oLeaveInfo;
        }
        catch (RemoteException oRe) {
            throw new EnrgiseSystemException((Exception)oRe);
        }
        catch (CreateException oCrt) {
            throw new EnrgiseSystemException((Exception)oCrt);
        }
    }
}
