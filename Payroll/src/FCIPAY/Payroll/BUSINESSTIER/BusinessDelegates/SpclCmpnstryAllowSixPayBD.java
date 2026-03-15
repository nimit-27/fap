package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.ejb.CreateException;
import java.rmi.RemoteException;
import javax.servlet.http.HttpServletRequest;

import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SpclCmpnstryComboVOSixPay;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SpclCmpnstryAllowSixPayQueryVO;
import FCIPAY.Payroll.UTILITY.SpclCmpnstryAllowSixPayHeaderBean;

public class SpclCmpnstryAllowSixPayBD extends PayrollBaseBD  
{
    public SpclCmpnstryAllowSixPayBD()
    {
        super();
    }
  
    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        try
        {      
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            return oPayFacade.getSpclCompstryAllowHeaderMetaInfo((SpclCmpnstryAllowSixPayQueryVO)oQueryVO);
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
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            ArrayList oHeaderList = oPayFacade.getSpclCompstryAllowHeader((SpclCmpnstryAllowSixPayQueryVO)oQueryVO,lStartPosition,lLastPosition);
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

    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        return null;
    }
    
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        try
        {  
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            return oPayFacade.getSpclCompAllowDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
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
  
  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
      return null;
  }

  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {
        PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
        PayrollNewFacade oPayFacade = oHome.create();
        return oPayFacade.getSpclCompAllowDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,oBaseDetailInfo);
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
        PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
        PayrollNewFacade oPayFacade = oHome.create();
        return oPayFacade.saveSpclCompAllow((SpclCmpnstryAllowSixPayHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
        
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
    try
    {      
      PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
      PayrollNewFacade oPayFacade = oHome.create();
//      return oSysFacade.saveGlobalCodeHeader((GlobalCodeHeaderBean)oBaseHeaderBean);
      return true;
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

    public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        try
        {
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            SpclCmpnstryComboVOSixPay oBadClmtComboVO = oPayFacade.getCmpnstryComboDetailsSixPay();
            if(request.getSession().getAttribute("AllowType")!=null)
            {
                request.getSession().removeAttribute("AllowType");
            }
            request.getSession().setAttribute("AllowType",oBadClmtComboVO);
    
            if(request.getSession().getAttribute("AreaType")!=null)
            {
                request.getSession().removeAttribute("AreaType");
            }
            request.getSession().setAttribute("AreaType",oBadClmtComboVO);

            if(request.getSession().getAttribute("Category")!=null)
            {
                request.getSession().removeAttribute("Category");
            }
            request.getSession().setAttribute("Category",oBadClmtComboVO);
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
}