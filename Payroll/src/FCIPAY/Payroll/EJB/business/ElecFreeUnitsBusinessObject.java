package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import java.sql.SQLException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

//import IBA.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.UTILITY.ElecFreeUnitsHeaderBean;

import FCIPAY.Payroll.UTILITY.ElecFreeUnitsBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ElecFreeUnitsQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ElecFreeUnitsDetailInfo;

import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;


public class ElecFreeUnitsBusinessObject extends BaseBO 
{
  public ElecFreeUnitsBusinessObject()
  {
  }

  public RecordMetaInfo getElecFreeUnitsHeaderMetaInfo(ElecFreeUnitsQueryVO oElecFreeUnitsQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsQueryVO.getTxtRevYear())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsQueryVO.getTxtGradeCode())));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetElecFreeUnitsCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getElecFreeUnitsHeader(ElecFreeUnitsQueryVO oElecFreeUnitsQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oElecFreeUnitsQueryVO == null)
    {
      oElecFreeUnitsQueryVO = new ElecFreeUnitsQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      //System.out.println(oElecFreeUnitsQueryVO.getTxtRevYYMM());
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsQueryVO.getTxtRevYear())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsQueryVO.getTxtGradeCode())));
   
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetElecFreeUnits(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      ElecFreeUnitsHeaderBean oElecFreeUnitsHeader;
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
          oElecFreeUnitsHeader = new ElecFreeUnitsHeaderBean();
          oElecFreeUnitsHeader.setTxtRevYear(oRow.get("rev_year").getString());
          oElecFreeUnitsHeader.setTxtGradeCode(oRow.get("grade_id").getString());
          oElecFreeUnitsHeader.setTxtGradeDesc(oRow.get("descr").getString());               
          oHeaderList.add(oElecFreeUnitsHeader);
      }              
    return oHeaderList;
  }

  public RecordMetaInfo getElecFreeUnitsDetailMetaInfo(String sPrimaryKey, ElecFreeUnitsDetailInfo oElecFreeUnitsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

      String sRevYear = sPrimaryKey.substring(0,6);    
      int len = sPrimaryKey.length();
      String sGradeCode = sPrimaryKey.substring(6,len);    
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sRevYear));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sGradeCode));    
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetElecFreeUnitsDtlCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }

  public ArrayList getElecFreeUnitsDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,  ElecFreeUnitsDetailInfo oElecFreeUnitsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    ElecFreeUnitsBean oElecFreeUnitsDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oElecFreeUnitsDetail = null;

      String sRevYear = sPrimaryKey.substring(0,6);    
      int len = sPrimaryKey.length();
      String sGradeCode = sPrimaryKey.substring(6,len);    
          
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sRevYear));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sGradeCode)); 
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetElecFreeUnitsDetail(?,?,?,?,?,?)");
      
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
            oElecFreeUnitsDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oElecFreeUnitsDtl = new ElecFreeUnitsBean();
          oElecFreeUnitsDtl.sethdnElecFreeUnitsSrlNo(oRow.get("srl_no").getString());          
          oElecFreeUnitsDtl.setStartField((oRow.get("amount_from").getString()));
          oElecFreeUnitsDtl.setEndField((oRow.get("amount_to").getString()));          
          oElecFreeUnitsDtl.setTxtElecFreeUnits(oRow.get("Free_Unit").getString());                    
//          oElecFreeUnitsDtl.setTxtElecFreeUnitsAmount(oRow.get("Free_Unit").getString());                              
          oElecFreeUnitsDtl.setStatus("Q");
          oElecFreeUnitsDetail.add(oElecFreeUnitsDtl);
        }             
        return oElecFreeUnitsDetail; 
  }    


  public boolean saveElecFreeUnitsHeader(ElecFreeUnitsHeaderBean oElecFreeUnitsHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
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

  public void saveDetailImpl(String sHeaderPrimaryKey, String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }   

  
  public void saveDetailImpl(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      saveElecFreeUnits(sHeaderPrimaryKey, (ElecFreeUnitsHeaderBean)oBaseHeaderBean, oDetailBeanArray);
  }   
  
 private void saveElecFreeUnits(String sHeaderPrimaryKey, ElecFreeUnitsHeaderBean oElecFreeUnitsHeaderBean,  ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        ElecFreeUnitsBean oElecFreeUnitsBean = (ElecFreeUnitsBean)oIt.next();
//        System.out.println(oElecFreeUnitsBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oElecFreeUnitsBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertElecFreeUnitsDetail(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtRevYear())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtGradeCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.getStartField())));          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.getEndField())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.getTxtElecFreeUnits())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtSiteID())));          
          oBeanInsert.addToBatch(oParameters);
        }
       else if(oElecFreeUnitsBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateElecFreeUnitsDetail(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtRevYear())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.gethdnElecFreeUnitsSrlNo())));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtGradeCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.getStartField())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.getEndField())));          
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.getTxtElecFreeUnits())));          
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtSiteID())));          
          
          oBean.addToBatch(oParameters);
          
        }
     else if(oElecFreeUnitsBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteElecFreeUnitsDetail(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtRevYear())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsBean.gethdnElecFreeUnitsSrlNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtGradeCode())));          
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
/*    String sDetailTable = null;
    sDetailTable = "lstInstrDtls";
    initializeBO("IncomeTaxScreen",sDetailTable); */
  }  

 /* Methods for LOV */
 
public LovVO getElecFreeUnitsLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Revision Year");  
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetElecFreeUnitsLov(?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("rev_year").getString());                   
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  } 

/* Method for GradeCode LOV */


  public LovVO getElecFreeUnitsGradecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Grade Code");  
    arylstHeaderNames.add("Grade Description");  
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEFUGradecodeLov(?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("grade_id").getString());                   
      oLOVBean.setDetailField2(oRow.get("grade_desc").getString());                   
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }  
  
/* Method for StateCode LOV */    


  //Added
  
   public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    checkElecFreeUnitsHeader(oBaseHeaderBean,oList);
    reportError(oList);
    
    
  }


  private void checkElecFreeUnitsHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        ElecFreeUnitsHeaderBean  oElecFreeUnitsHeaderBean  = (ElecFreeUnitsHeaderBean)oBaseHeaderBean;

        System.out.println(oElecFreeUnitsHeaderBean.getScreenModeElecFreeUnits());
        
        if(oElecFreeUnitsHeaderBean.getScreenModeElecFreeUnits().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtRevYear())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oElecFreeUnitsHeaderBean.getTxtGradeCode())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEFUDuplicateCheck(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.Tax.DuplicateCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }

  //Added
  
}