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

import FCIPAY.Payroll.EJB.facade.MasterFacade;
import FCIPAY.Payroll.EJB.facade.MasterFacadeHome;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DsgnComboVO;

public class MaintDsgn6PayBD extends PayrollBaseBD 
{
      public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      if(sScreenName.equals("Dsgn6PayScreen"))
      {
        return oPayFacade.getDsgnDetailMetaInfo(sPrimaryKey);
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
  


  public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    try
    {      
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      if(sScreenName.equals("Dsgn6PayScreen"))
      {
        return oPayFacade.get6PayDsgnDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd);
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
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      return oPayFacade.save6PayDsgnDetail((DummyHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
     // return null;
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
      MasterFacade oPayFacade = oHome.create();
//      return oSysFacade.getGlobalCodeHeaderMetaInfo((GlobalCodeQueryVO)oQueryVO);
      return new RecordMetaInfo();
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
      MasterFacadeHome oHome = (MasterFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("MasterFacade");
      MasterFacade oPayFacade = oHome.create();
      return new ArrayList();

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
      DsgnComboVO oDsgnComboVO = oPayFacade.get6PayEmpCtgryDetails(); // for populating emp category
      //DsgnComboVO oDsgnComboVO2 = oPayFacade.get6PayDsgnComboPayScaleDetails(); // for populating pay scale code
      //DsgnComboVO oDsgnComboVO3 = oPayFacade.get6PayDsgnComboPayBandDetails();  // for populating pay band code
      if(request.getSession().getAttribute("EmpCtgry")!=null)
      {
        request.getSession().removeAttribute("EmpCtgry");
      }
      request.getSession().setAttribute("EmpCtgry",oDsgnComboVO);
      
      /*
       if(request.getSession().getAttribute("PayScaleCode")!=null)
      {
        request.getSession().removeAttribute("PayScaleCode");
      }
      request.getSession().setAttribute("PayScaleCode",oDsgnComboVO2);
      
       if(request.getSession().getAttribute("PayBandCode")!=null)
      {
        request.getSession().removeAttribute("PayBandCode");
      }
      request.getSession().setAttribute("PayBandCode",oDsgnComboVO3);
      */
      
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