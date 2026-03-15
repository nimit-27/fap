package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrHndlngAttndHeaderBean;
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

public class NWNPMaintLbrHndlngAttndBD  extends PayrollBaseBD{
    
    public NWNPMaintLbrHndlngAttndBD() {
        super();
    }

    public RecordMetaInfo getHeaderMetaImpl(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       try
       {          
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oLabourFacade = oHome.create();
         return oLabourFacade.getNWNPHndlngAttndHeaderMetaInfo((NWNPLbrHndlngAttndQueryVO)oQueryVO);
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
         
         ArrayList oHeaderList = oLabourFacade.getNWNPHndlngAttndHeader((NWNPLbrHndlngAttndQueryVO)oQueryVO,lStartPosition,lLastPosition);

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

         if(sScreenName.equals("NWNPHndlngAttndScreen"))
         {
             return oLabourFacade.getNWNPHndlngAttndDetailMetaInfo("IDA",(NWNPLbrHndlngAttndDetailInfo)oBaseDetailInfo);
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
         return null;  
     }

      public ArrayList getDetailRecordImpl(String sPrimaryKey,String sScreenName,long lAbsoluteStart,long lAbsoluteEnd,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
     {
       try
       {      
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oLabourFacade = oHome.create();
         return oLabourFacade.getNWNPHndlngAttndDetail("IDA",lAbsoluteStart,lAbsoluteEnd,(NWNPLbrHndlngAttndDetailInfo)oBaseDetailInfo);
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
         return oLabourFacade.saveNWNPHndlngAttnd((NWNPLbrHndlngAttndHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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
