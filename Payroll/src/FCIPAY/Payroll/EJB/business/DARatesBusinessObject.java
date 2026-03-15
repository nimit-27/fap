package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintDaRatesQueryVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.DARatesDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintDARatesHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintDARateBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class DARatesBusinessObject extends BaseBO
{
  public DARatesBusinessObject()
  {
  }
 public RecordMetaInfo getDARatesHeaderMetaInfo(MaintDaRatesQueryVO oMaintDaRatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDaRatesQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDaRatesQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDARateCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getDARatesHeader(MaintDaRatesQueryVO oMaintDaRatesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintDaRatesQueryVO == null)
    {
      oMaintDaRatesQueryVO = new MaintDaRatesQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDaRatesQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDaRatesQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DARateHeader(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintDARatesHeaderBean oMaintDARatesHeaderBean;
      count = 0;
      QueryRow oRow = null;
      HashMap oColumns = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oHeaderList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintDARatesHeaderBean = new MaintDARatesHeaderBean();
          oMaintDARatesHeaderBean.setTxtYYMM(oRow.get("yyyymm").getString());
          oMaintDARatesHeaderBean.setTxtDAType(oRow.get("da_type").getString());
          oHeaderList.add(oMaintDARatesHeaderBean);
      }              
    return oHeaderList;
  }
 public RecordMetaInfo getDARatesDetailMetaInfo(String sPrimaryKey,DARatesDetailInfo oDARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  //public RecordMetaInfo getDARatesDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
   DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
     String sYear,sDAType,hdnflag;
      sYear = oDARatesDetailInfo.getTxtYYMM();
      sDAType = oDARatesDetailInfo.getTxtDAType();
      hdnflag=oDARatesDetailInfo.getHdnEmpLbrFlag();




      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sYear));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnflag));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));            
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDARateDtlCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }

 public ArrayList getDARatesDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,DARatesDetailInfo oDARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  //public ArrayList getDARatesDetail(String sYear, String sDAType, String sPayScaleType,  long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintDARateBean oMaintDARateBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;
      
      String sYear,sDAType,hdnflag;
      sYear = oDARatesDetailInfo.getTxtYYMM();
      sDAType = oDARatesDetailInfo.getTxtDAType();
      hdnflag=oDARatesDetailInfo.getHdnEmpLbrFlag();


      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sYear));
      //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sDAType));  
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,hdnflag));
      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDARateDetail(?,?,?,?,?,?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oDARateDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintDARateBean = new MaintDARateBean();
          oMaintDARateBean.setTxtSrlNo((oRow.get("srl_no").getString()));          
//          oMaintDARateBean.setTxtYYMM((oRow.get("yyyymm").getString()));
//          oMaintDARateBean.setTxtDAType((oRow.get("da_type").getString()));
          oMaintDARateBean.setStartField((oRow.get("low_basic").getString()));
          oMaintDARateBean.setEndField((oRow.get("high_basic").getString()));
          
          oMaintDARateBean.settxtDaRate((oRow.get("da_rate").getString()));
          oMaintDARateBean.settxtDaMinimum((oRow.get("da_min").getString()));
          oMaintDARateBean.setTxtDPRate((oRow.get("dp_rate").getString()));
          oMaintDARateBean.setStatus("Q");
          oDARateDetail.add(oMaintDARateBean);
        }             
        return oDARateDetail; 
  }    


  public boolean savePayScaleHeader(MaintDARatesHeaderBean oMaintDARatesHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       return true;
  }
  

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
      return null ;  
  }  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {

  }  

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    String sPayScaleType;    
    
  if(sScreenName.equals("DaRatesIDAScreen"))
    {
      sPayScaleType = "IDA";    
      saveDARate(sPayScaleType,oDetailBeanArray,(MaintDARatesHeaderBean)oBaseHeaderBean);
    }
    else 
    {
      sPayScaleType = "CDA";    
      saveDARate(sPayScaleType,oDetailBeanArray,(MaintDARatesHeaderBean)oBaseHeaderBean);
    } 
  }   
  
 private void saveDARate(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,MaintDARatesHeaderBean oMaintDARatesHeaderBean) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintDARateBean oMaintDARateBean = (MaintDARateBean)oIt.next();
//        System.out.println(oMaintDARateBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintDARateBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertDARateDetail(?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtDAType())));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getEndField())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.gettxtDaRate())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.gettxtDaMinimum())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getTxtDPRate())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtSiteID())));
          //added by himanshu
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getHdnEmpLbrFlag())));

          oBeanInsert.addToBatch(oParameters);
        }
       else if(oMaintDARateBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateDARate(?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
         
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtYYMM())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));                              
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtDAType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getTxtSrlNo())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getStartField())));
           oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getEndField())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.gettxtDaRate())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.gettxtDaMinimum())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getTxtDPRate())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
          
        }
     else if(oMaintDARateBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
      {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteDARate(?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARateBean.getTxtSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtDAType())));

          oBeanDelete.addToBatch(oParameters);          
        }
      }

      try
      {
          if(bInsert)
          {
            oBeanInsert.executeBatch();
          }
      
          if(bUpdate)
          {
            oBean.executeBatch();   
          }

          if(bDelete)
          {
            oBeanDelete.executeBatch();
          }   
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
  }
   
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("DARatesCDAScreen"))
    {
      sDetailTable = "lstPayScaleDtl";
    }
    initializeBO("DARateCDAScreen",sDetailTable);
  }  




public LovVO getDARateLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("YYYYMM");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;   
     
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDaRateYYMM(?,?)");
      DBObject oOutObject=(DBObject)oOutArray.get(0);
      oList=(ArrayList)(oOutObject.getObject());

      QueryRow oRow=null;

 
    Iterator iter = oList.iterator();
    while(iter.hasNext())
    {
      if(count == 0)
      {
         oList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)iter.next();
      oLOVBean = new LOVBean();
      
       oLOVBean.setDetailField1(oRow.get("YYYYMM").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,sScreenName);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    checkDaRatHeader(oBaseHeaderBean,oList,sScreenName);
    checkDaRateGreaterHeader(oBaseHeaderBean,oList);
    reportError(oList);
    
    
  }

 private void checkDaRatHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    String sPayScaleType;    
    
    if(sScreenName.equals("DaRatesIDAScreen"))
    {
      sPayScaleType = "IDA";    
      
    }
    else 
    {
      sPayScaleType = "CDA";    
      
    } 

        MaintDARatesHeaderBean  oMaintDARatesHeaderBean  = (MaintDARatesHeaderBean)oBaseHeaderBean;

//        System.out.println(oMaintDARatesHeaderBean.getHeaderMode());       
        if(oMaintDARatesHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPayScaleType)));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DADuplicateCheck(?,?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.DARate.DuplicateCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }


  private void checkDaRateGreaterHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        MaintDARatesHeaderBean  oMaintDARatesHeaderBean  = (MaintDARatesHeaderBean)oBaseHeaderBean;

//        System.out.println(oMaintDARatesHeaderBean.getHeaderMode());
        
        if(oMaintDARatesHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDARatesHeaderBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DaCheck(?,?,?,?)");
          oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yyyymm").getString(); 
              if (!sRevYear.equals("0"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(sRevYear);              
                oList.add(new EnrgiseApplicationException("Payroll.DaRate.YearCheck",oArguments));              
              }                
             }


          /* oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.DARate.GreaterCheck",EnrgiseConstants.MESSAGE));
            }*/
        }
  }

  
}