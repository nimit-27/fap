package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;
import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import java.util.ArrayList;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipOprationComboVO;

public class MaintWrkSlipBD extends PayrollBaseBD 
{

   public MaintWrkSlipBD()
    {
      super();
    }
    
    public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oPayFacade = oHome.create();
        WrkSlipComboVO oWrkSlipComboVO = oPayFacade.getWrkSlipComboDetails();
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
    
    public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        return oLabourFacade.saveWrkSlip((MaintWrkSlipHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
    
    public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        if(sScreenName.equals("DPSWrkSlipScreen"))
        {
          return oLabourFacade.getWrkSlipDetail(sPrimaryKey,"D",lAbsoluteStart,lAbsoluteEnd); 
        }else if(sScreenName.equals("KOTWrkSlipScreen"))
        {
          return oLabourFacade.getWrkSlipDetail(sPrimaryKey,"K",lAbsoluteStart,lAbsoluteEnd);
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
    
    
    public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oLabourFacade = oHome.create();
        if(sScreenName.equals("DPSWrkSlipScreen"))
        {
          return oLabourFacade.getWrkSlipDetailMetaInfo(sPrimaryKey,"D");
        }
        else if(sScreenName.equals("KOTWrkSlipScreen"))
        {
          return oLabourFacade.getWrkSlipDetailMetaInfo(sPrimaryKey,"K");
        }else
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
    
    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      try
      {
          LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
          LabourFacade oPayFacade = oHome.create();
          return oPayFacade.getWrkSlipHeaderMetaImpl(oQueryVO);
      
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
          LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
          LabourFacade oPayFacade = oHome.create();
          return oPayFacade.getWrkSlipHeaderRecord(oQueryVO,lStartPosition,lLastPosition);      
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
          oPayFacade.deleteWrkSlipHeaderRecord(sPrimaryKey,sScreenName);      
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