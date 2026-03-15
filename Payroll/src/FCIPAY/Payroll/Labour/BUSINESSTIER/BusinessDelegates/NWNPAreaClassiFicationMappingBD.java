package FCIPAY.Payroll.Labour.BUSINESSTIER.BusinessDelegates;

import FCIPAY.Payroll.BUSINESSTIER.BusinessDelegates.PayrollBaseBD;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.EJB.facade.LabourFacade;
import FCIPAY.Payroll.EJB.facade.LabourFacadeHome;
import FCIPAY.Payroll.EJB.facade.MasterFacade;
import FCIPAY.Payroll.EJB.facade.MasterFacadeHome;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaClassiFicationMappingQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaMappingComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPWrkSlipComboVO;
import FCIPAY.Payroll.Labour.Utility.NWNPAreaClassiFicationMappingHeaderBean;
import FCIPAY.Payroll.UTILITY.DeptPayFixBean;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;

import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import com.sun.jmx.snmp.Timestamp;

import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.ejb.CreateException;

import javax.servlet.http.HttpServletRequest;

public class NWNPAreaClassiFicationMappingBD extends PayrollBaseBD{
    public NWNPAreaClassiFicationMappingBD() {
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
          LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
          LabourFacade oLabFacade = oHome.create();
          if(sScreenName.equals("NWNPAreaClassiFicationMappingScreen"))
          {
              return oLabFacade.getNwnpCityLocMapDetailMetaInfo(oBaseDetailInfo);
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
          LabourFacade oLabFacade = oHome.create();
          if(sScreenName.equals("NWNPAreaClassiFicationMappingScreen"))
          {
              return oLabFacade.getNwnpCityLocMapDetail(sPrimaryKey,lAbsoluteStart,lAbsoluteEnd,oBaseDetailInfo);
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




//         public String saveImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
//         {
//           try
//           {      
//             LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
//             LabourFacade oDeptPromotionFacade = oHome.create();
//             return oDeptPromotionFacade.saveDeptPayFix((DeptPayFixBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
//           //  return null;
//           }
//           catch(RemoteException oRe)
//           {
//             throw new EnrgiseSystemException(oRe);
//           }
//           catch(CreateException oCrt)
//           {
//             throw new EnrgiseSystemException(oCrt);      
//           }
//           
//         }

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
             LabourFacade oLabFacade = oHome.create();
             return oLabFacade.getNwnpCityLocMapHeaderMetaInfo((NWNPAreaClassiFicationMappingQueryVO)oQueryVO);
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
             LabourFacade oLabFacade = oHome.create();
             
             ArrayList oHeaderList = oLabFacade.getNwnpCityLocMapHeader((NWNPAreaClassiFicationMappingQueryVO)oQueryVO,lStartPosition,lLastPosition);
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

    @Override
//    public String saveImpl(BaseHeaderBean oBaseHeaderBean, java.sql.Timestamp oWhenPicked, String sScreenName,
//                           String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,
//                           boolean bDetailDataChanged, java.sql.Timestamp oDetailPicked) {
//        return null;
//    }

    public String saveImpl(BaseHeaderBean oBaseHeaderBean, java.sql.Timestamp oWhenPicked, String sScreenName,String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, java.sql.Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
      try
      {      
        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
        LabourFacade oPayFacade = oHome.create();
        return oPayFacade.saveNwnpCityLocMapDetail((NWNPAreaClassiFicationMappingHeaderBean)oBaseHeaderBean , oWhenPicked, sScreenName,sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
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

    
//    public void getComboDetails(HttpServletRequest request) throws EnrgiseSystemException, EnrgiseApplicationException
//    {
//      try
//      {      
//        LabourFacadeHome oHome = (LabourFacadeHome)FCIPAY.Payroll.common.utility.ServiceLocator.getLocator().getService("LabourFacade");
//        LabourFacade oPayFacade = oHome.create();
//        NWNPAreaMappingComboVO oAreaMappComboVO = oPayFacade.getNwnpLocationComboDetails();
//        request.getSession().setAttribute("mapInfo",oAreaMappComboVO);
//      }
//      catch(RemoteException oRe)
//      {
//        throw new EnrgiseSystemException(oRe);
//      }
//      catch(CreateException oCrt)
//      {
//        throw new EnrgiseSystemException(oCrt);      
//      }
//    }
}
