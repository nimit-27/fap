package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPCDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPcDtlComboVO;
import FCIPAY.Payroll.EJB.facade.PayrollFacade;
import FCIPAY.Payroll.EJB.facade.PayrollFacadeHome;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacade;
import FCIPAY.Payroll.EJB.facade.PayrollNewFacadeHome;

import FCIPAY.Payroll.UTILITY.MaintPCDetailHeaderBean;

import FCIPAY.Payroll.UTILITY.MaintPFDetailHeaderBean;

import javax.servlet.http.HttpServletRequest;

public class MaintainPensionBD extends PayrollBaseBD 
{
  public MaintainPensionBD()
  {
    super();  
  }


  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      return null;
  }
  

  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
      return null;    
  }
 
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        try
        {  
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            return oPayFacade.getPensionDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
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
  
  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {
        PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
        PayrollNewFacade oPayFacade = oHome.create();
        return oPayFacade.getPensionDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,oBaseDetailInfo);
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
      PayrollNewFacade oPCDetailFacade = oHome.create();
      return oPCDetailFacade.savePCDetail((MaintPCDetailHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
//      return null;
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
      PayrollNewFacade oPCDetailFacade = oHome.create();
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

  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
      PayrollNewFacade oPCDetailFacade = oHome.create();
      return oPCDetailFacade.getPensionHeaderMetaInfo((MaintPCDetailQueryVO)oQueryVO);
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
      PayrollNewFacade oPCDetailFacade = oHome.create();
      
      ArrayList oHeaderList = oPCDetailFacade.getPensionHeader((MaintPCDetailQueryVO)oQueryVO,lStartPosition,lLastPosition);
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

    public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
    {
       try
        {
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            MaintPcDtlComboVO oMaintPcDtlComboVO = oPayFacade.getPensionDetailCombo();
            if(request.getSession().getAttribute("AdjPcHdr")!=null)
            {
                request.getSession().removeAttribute("AdjPcHdr");
            }
            request.getSession().setAttribute("AdjPcHdr", oMaintPcDtlComboVO);
           
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
    
    public ArrayList getPcAdjustHistoryHdr(MaintPCDetailQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        try
        {
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            return(oPayFacade.getPcAdjustHistoryHdr(oQueryVO));
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
   public ArrayList getPcAdjustHistoryDtl(MaintPCDetailQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        try
        {
            PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
            PayrollNewFacade oPayFacade = oHome.create();
            return(oPayFacade.getPcAdjustHistoryDtl(oQueryVO));
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
   //Added by Arvind
   public String freezePenYrInt(MaintPCDetailQueryVO oMaintPCDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
   {
     try
     {      
       PayrollNewFacadeHome oHome = (PayrollNewFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("PayrollNewFacade");
       PayrollNewFacade oPayrollNewFacade = oHome.create();
       return oPayrollNewFacade.freezePenYrInt(oMaintPCDetailQueryVO);
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
