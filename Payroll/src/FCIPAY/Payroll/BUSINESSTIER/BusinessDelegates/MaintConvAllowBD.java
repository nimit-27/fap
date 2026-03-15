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
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.UTILITY.MaintConvAllowBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.ConvAllowHeaderBean;
//import IBA.Payroll.DATAACCESSTIER.VO.DummyQuaryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowDetailInfo;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.EJB.common.session.UserSession;

import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.EJB.facade.MasterFacade;
import FCIPAY.Payroll.EJB.facade.MasterFacadeHome;
//import IBA.Payroll.EJB.facade.FixedParametersFacadeLocal;
//import IBA.Payroll.EJB.facade.FixedParametersFacadeLocalHome;
import javax.servlet.http.HttpServletRequest;


public class MaintConvAllowBD extends PayrollBaseBD
{
  public MaintConvAllowBD()
  {
    super();  
  }

  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }
  

  public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayrollFacade = oHome.create();


    String sPayScaleType = "";
     
    if(sScreenName.equalsIgnoreCase("ConvAllowAllScreen"))  
        {
        sPayScaleType = "ALL," +sPrimaryKey;
     return oPayrollFacade.getConvAllowAllDetailMetaInfo(sPayScaleType, (ConvAllowDetailInfo)oBaseDetailInfo);
        }
     else if(sScreenName.equalsIgnoreCase("ConvAllowCDAScreen"))
     {
      sPayScaleType = "CDA," +sPrimaryKey;
      return oPayrollFacade.getConvAllowAllDetailMetaInfo(sPayScaleType, (ConvAllowDetailInfo)oBaseDetailInfo);
     }
     else 
     {
        sPayScaleType = "IDA," +sPrimaryKey;
        return oPayrollFacade.getConvAllowAllDetailMetaInfo(sPayScaleType, (ConvAllowDetailInfo)oBaseDetailInfo);
     }

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
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayrollFacade = oHome.create();


    String sPayScaleType = "";
     
    if(sScreenName.equalsIgnoreCase("ConvAllowAllScreen"))  
        {
        sPayScaleType = "ALL," +sPrimaryKey;
      return oPayrollFacade.getConvAllowAllDetail(sPayScaleType,lAbsoluteStart,lAbsoluteEnd,(ConvAllowDetailInfo)oBaseDetailInfo);
        }
     else if(sScreenName.equalsIgnoreCase("ConvAllowCDAScreen"))
     {
      sPayScaleType = "CDA," +sPrimaryKey;
      return oPayrollFacade.getConvAllowAllDetail(sPayScaleType,lAbsoluteStart,lAbsoluteEnd,(ConvAllowDetailInfo)oBaseDetailInfo);
     }
     else 
     {
        sPayScaleType = "IDA," +sPrimaryKey;
        return oPayrollFacade.getConvAllowAllDetail(sPayScaleType,lAbsoluteStart,lAbsoluteEnd,(ConvAllowDetailInfo)oBaseDetailInfo);
     }

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
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      return oPayFacade.saveConvAllow((ConvAllowHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
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

 
  public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {          
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayrollFacade = oHome.create();
      return oPayrollFacade.getConvAllowHeaderMetaInfo((ConvAllowQueryVO)oQueryVO);
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

  public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayrollFacade = oHome.create();
      
      ArrayList oHeaderList = oPayrollFacade.getConvAllowHeader((ConvAllowQueryVO)oQueryVO,lStartPosition,lLastPosition);

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
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      ConvAllowComboVO oConvAllowComboVO = oPayFacade.getConvAllowComboDetails();
//    request.getSession().setAttribute("ConvAllowCities",oConvAllowComboVO);
      request.getSession().setAttribute("ConvAllowCity",oConvAllowComboVO);
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