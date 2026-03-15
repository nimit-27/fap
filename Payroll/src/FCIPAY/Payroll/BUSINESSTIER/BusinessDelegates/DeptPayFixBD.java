package FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import javax.ejb.CreateException;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.DeptPayFixBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;

public class DeptPayFixBD extends PayrollBaseBD  {
    public DeptPayFixBD() {
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

     public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
     {
       try
       {      
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oDeptPromotionFacade = oHome.create();
         return oDeptPromotionFacade.saveDeptPayFix((DeptPayFixBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
       //  return null;
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
         LabourFacade oDeptPromotionFacade = oHome.create();
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
         LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
         LabourFacade oDeptPromotionFacade = oHome.create();
         return oDeptPromotionFacade.getPayFixHeaderMetaInfo((DummyQueryVO)oQueryVO);
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
         LabourFacade oDeptPromotionFacade = oHome.create();
         
         ArrayList oHeaderList = oDeptPromotionFacade.getPayFixHeader((DummyQueryVO)oQueryVO,lStartPosition,lLastPosition);
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

   
     
    
}
