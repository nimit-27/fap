package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrAncllryAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrAncllryAttndQueryVO;
import FCIPAY.Payroll.Labour.Utility.LbrAncllryAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrAncllryAttndHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;

import javax.ejb.CreateException;

public class NWNPMaintLbrAncllryAttndBD  extends PayrollBaseBD{
    
    public NWNPMaintLbrAncllryAttndBD() {
        super();
    }
    
    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       try
       {          
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oLabourFacade = oHome.create();
         return oLabourFacade.getNWNPAncllryAttndHeaderMetaInfo((NWNPLbrAncllryAttndQueryVO)oQueryVO);
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
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oLabourFacade = oHome.create();
         
         ArrayList oHeaderList = oLabourFacade.getNWNPAncllryAttndHeader((NWNPLbrAncllryAttndQueryVO)oQueryVO,lStartPosition,lLastPosition);

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
     
     public RecordMetaInfo getTotalDetailRecordCountImpl(String sPrimaryKey, String sScreenName,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       
       try
       {      
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oLabourFacade = oHome.create(); 

         if(sScreenName.equals("NWNPAncllryAttndScreen"))
         {
             return oLabourFacade.getNWNPAncllryAttndDetailMetaInfo("IDA",(NWNPLbrAncllryAttndDetailInfo)oBaseDetailInfo);
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
     
    /* public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
     {
       try
       {      

        String  sYear;
         String sPayScale;
         sYear=sPrimaryKey.substring(0,6);
         sPayScale=sPrimaryKey.substring(7,8);     

         PayrollFacadeHome oHome = (PayrollFacadeHome)ServiceLocator.getLocator().getService("PayrollFacade");
         PayrollFacade oPayrollFacade = oHome.create();
         if(sScreenName.equals("AncllryAttndScreen"))
         {
           return oPayrollFacade.getDARateDetail(sYear, sPayScale, "IDA", lAbsoluteStart,lAbsoluteEnd);
         }          
         if(sScreenName.equals("DaRatesCDAScreen"))
         {
           return oPayrollFacade.getDARateDetail(sYear, sPayScale, "CDA", lAbsoluteStart,lAbsoluteEnd);
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
       
     }*/
    //Newly added lines
      public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
     {
         return null;  
     }

      public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
     {
       try
       {      
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oLabourFacade = oHome.create();
         return oLabourFacade.getNWNPAncllryAttndDetail("IDA",lAbsoluteStart,lAbsoluteEnd,(NWNPLbrAncllryAttndDetailInfo)oBaseDetailInfo);
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


     public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
     {
       try
       {      
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oLabourFacade = oHome.create();
         return oLabourFacade.saveNWNPAncllryAttnd((NWNPLbrAncllryAttndHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
         LabourFacade oLabourFacade = oHome.create();
    //      return oPayrollFacade.saveDARAteHeader((LbrAncllryAttndHeaderBean)oBaseHeaderBean);
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
    
}
