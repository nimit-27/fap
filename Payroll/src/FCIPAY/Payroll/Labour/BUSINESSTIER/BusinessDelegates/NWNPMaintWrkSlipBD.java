package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPWrkSlipComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipOprationComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;

import javax.ejb.CreateException;

import javax.servlet.http.HttpServletRequest;

public class NWNPMaintWrkSlipBD extends PayrollBaseBD {
    public NWNPMaintWrkSlipBD() {
        
    }
    
    public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oPayFacade = oHome.create();
        NWNPWrkSlipComboVO oWrkSlipComboVO = oPayFacade.getNwnpWrkSlipComboDetails();
        request.getSession().setAttribute("NormTyp",oWrkSlipComboVO);
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

    public WrkSlipOprationComboVO getOprationCombo(MaintWrkSlipHeaderBean oMaintWrkSlipHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oPayFacade = oHome.create();
        //WrkSlipOprationComboVO oWrkSlipOprationComboVO = new WrkSlipOprationComboVO();
        WrkSlipOprationComboVO oWrkSlipOprationComboVO = oPayFacade.getWrkSlipOprationCombo(oMaintWrkSlipHeaderBean);
        return oWrkSlipOprationComboVO;
      }
      catch(RemoteException oRe)
      {
      oRe.printStackTrace();
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
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        return oLabourFacade.saveNwnpWrkSlip((NWNPMaintWrkSlipHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
    public boolean updateHeaderRecordImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oPayFacade = oHome.create();
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
    
    @Override
    public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        if(sScreenName.equals("NWNPWrkSlipScreen"))
        {
          return oLabourFacade.getNwnpWrkSlipDetail(sPrimaryKey,"N",lAbsoluteStart,lAbsoluteEnd); 
        }
        else
        {
          return oLabourFacade.getWrkSlipDetail(sPrimaryKey,"L",lAbsoluteStart,lAbsoluteEnd);
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
    
    @Override
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        if(sScreenName.equals("NWNPWrkSlipScreen"))
        {
          return oLabourFacade.getNwnpWrkSlipDetailMetaInfo(sPrimaryKey,"N");
        } else
        {
          return oLabourFacade.getWrkSlipDetailMetaInfo(sPrimaryKey,"L");
        }
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
    
    @Override
    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {
          LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
          LabourFacade oPayFacade = oHome.create();
          return oPayFacade.getNwnpWrkSlipHeaderMetaImpl(oQueryVO);
      
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
    public ArrayList getHeaderRecordImpl(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
       try
      {
          LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
          LabourFacade oPayFacade = oHome.create();
          return oPayFacade.getNwnpWrkSlipHeaderRecord(oQueryVO,lStartPosition,lLastPosition);      
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
    
    public void deleteHeaderRecordImpl(String sPrimaryKey,String sScreenName)throws EnrgiseSystemException, EnrgiseApplicationException
    {
       try
      {
          LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
          LabourFacade oPayFacade = oHome.create();
          oPayFacade.deleteNwnpWrkSlipHeaderRecord(sPrimaryKey,sScreenName);      
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
