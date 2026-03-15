package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import FCIPAY.Payroll.Labour.Utility.CalcDeptIncentiveHeaderBean;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.Labour.Utility.MaintIncentiveOperationsKotBean;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsDtlKotBean;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsHdrKotBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotLbrOprDetailsVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotwalLbrMasterDetailsVO;

public class IncentiveOperationsKotDtBusinessObjectl extends BaseBO
{
  public IncentiveOperationsKotDtBusinessObjectl()
  {
  }
   public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;        
    if(sScreenName.equals("IncentiveOperationsDtlMap"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return;   
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
     return null;      
  }
  
 
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
   if(sScreenMode.equals(EnrgiseConstants.UPDATE_MODE))
      {
        chkKotLbrOprEffDate(oBaseHeaderBean,oList);
        reportError(oList);
      }
  }
  public RecordMetaInfo getLabourOperationsDtlsDetailMetaInfo (String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
      
      KotwalLbrMasterDetailsVO oHdrBean = (KotwalLbrMasterDetailsVO)oBaseDetailInfo;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oHdrBean.getTxtBagType()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oHdrBean.getTxtEffFromDt()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oHdrBean.getTxtEffToDt()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oHdrBean.getTxtOperationID()));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_LbrOperationsDtlsKotCount(?,?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }


  public ArrayList getLabourOperationsDtlsDetail( String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    IncentiveOperationsDtlKotBean oAgency;
    KotwalLbrMasterDetailsVO oHdrBean = (KotwalLbrMasterDetailsVO)oBaseDetailInfo;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oAgencyDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oHdrBean.getTxtBagType()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oHdrBean.getTxtEffFromDt()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oHdrBean.getTxtEffToDt()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oHdrBean.getTxtOperationID()));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
     
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetDtlLbrOprtnsKotDtls(?,?,?,?,?,?,?,?,?)");
      
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
            oAgencyDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oAgency = new   IncentiveOperationsDtlKotBean();
       //  oAgency.setTxtOperationID((oRow.get("OPR_ID").getString()));
            
          oAgency.setStatus("Q");
          
          oAgency.setTxtDatumFrom((oRow.get("DATUM_FROM").getString()));
          oAgency.setTxtDatumTo(oRow.get("DATUM_TO").getString());          
          oAgency.setTxtL1(oRow.get("L1_RATE").getString());
          oAgency.setTxtL2((oRow.get("L2_RATE").getString()));
          oAgency.setTxtL3((oRow.get("L3_RATE").getString()));
          oAgency.setTxtL4((oRow.get("L4_RATE").getString()));
          oAgency.setTxtL5((oRow.get("L5_RATE").getString()));
          oAgency.setTxtL6((oRow.get("L6_RATE").getString()));
          oAgency.setTxtOpr_Sequence((oRow.get("opr_dtl_id").getString()));          
  
          oAgencyDetail.add(oAgency);
        }
        
        
    return oAgencyDetail;
     }
  
   public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("IncentiveOperationsDtlMap"))
    {
      saveLabourOperationsDtlsDetails(sHeaderPrimaryKey,(IncentiveOperationsHdrKotBean) oBaseHeaderBean,oDetailBeanArray);
    }
  }    
  
  
    private void saveLabourOperationsDtlsDetails(String sHeaderPrimaryKey,IncentiveOperationsHdrKotBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
     ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    IncentiveOperationsHdrKotBean oDummyHeaderBean = (IncentiveOperationsHdrKotBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
       IncentiveOperationsDtlKotBean oMaintCategoryLocationBean = (IncentiveOperationsDtlKotBean)oIt.next();
        if(oMaintCategoryLocationBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertKotLbrOperationsDtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffFromDt())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffToDt())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtBagType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtOperationID()))); 
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtDatumVal()))); 
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtDatumFrom())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtDatumTo())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtL1())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtL2())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtL3())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtL4())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtL5())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtL6())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
         
          oBeanInsert.addToBatch(oParameters);
        }
       else if(oMaintCategoryLocationBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateKotLbrOperations(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();          
          oBean.addToBatch(oParameters);
       
        }
        else if(oMaintCategoryLocationBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
      if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteKotLbrOprtnsDtls(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
         
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtOpr_Sequence())));        
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
 
  public LovVO getKotLbrOperationsDtlsLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Operation Id");   
    arylstHeaderNames.add("Description");   
    //arylstHeaderNames.add("CPF Code"); 
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
   // arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    
    String sEmpNO,sEmpCPF;    
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
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetOprID_KotLbrDtlsLOV(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("opr_id").getString());            
       oLOVBean.setDetailField2(oRow.get("opr_desc").getString());          
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  
 public ArrayList getKotLbrOperationsDtlsHeader( KotLbrOprDetailsVO oKotLbrOprDetailsVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    IncentiveOperationsHdrKotBean oHdrBean = new  IncentiveOperationsHdrKotBean();
    ArrayList oList;
    int count = 0;

   if(oKotLbrOprDetailsVO == null)
    {
      oKotLbrOprDetailsVO = new KotLbrOprDetailsVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oKotLbrOprDetailsVO.getTxtEffFromDt()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotLbrOprDetailsVO.getTxtBagType())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotLbrOprDetailsVO.getTxtOperationID())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetKOT_OPR_DTLSHEADER(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      IncentiveOperationsHdrKotBean oCCARatesHeaderBean;
      count = 0;
      QueryRow oRow = null;
     // HashMap oColumns = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oHeaderList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oCCARatesHeaderBean = new IncentiveOperationsHdrKotBean();
          oCCARatesHeaderBean.setTxtBagType(oRow.get("BAG_TYPE").getString());          
          oCCARatesHeaderBean.setTxtOperationID(oRow.get("OPR_ID").getString()); 
          oCCARatesHeaderBean.setTxtOperationDesc(oRow.get("opr_desc").getString()); 
          oCCARatesHeaderBean.setTxtEffToDt(EnrgiseUtil.convertToString(oRow.get("EFFECTIVE_TILL").getDate()));   
          oCCARatesHeaderBean.setTxtEffFromDt(EnrgiseUtil.convertToString(oRow.get("EFFECTIVE_FROM").getDate()));
          oCCARatesHeaderBean.setTxtDatumVal(oRow.get("datum_val").getString());
          oHeaderList.add(oCCARatesHeaderBean);
      }              
    return oHeaderList;
  }   
  
 public RecordMetaInfo getKotLbrOperationsDtlsMetaInfo(KotLbrOprDetailsVO oKotLbrOprDetailsVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotLbrOprDetailsVO.getHeaderPrimaryKey())));     
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotLbrOprDetailsVO.getTxtEffFromDt())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotLbrOprDetailsVO.getTxtBagType()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotLbrOprDetailsVO.getTxtOperationID())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_COUNTKOT_LBR_OPRHEADER(?,?,?,?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }  
  
  private String chkKotLbrOprEffDate(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      
      int i=0;
      String errorMsg="";
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      IncentiveOperationsHdrKotBean oCCARatesHeaderBean = (IncentiveOperationsHdrKotBean)oBaseHeaderBean;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCCARatesHeaderBean.getTxtEffFromDt())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCCARatesHeaderBean.getTxtOperationID())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCCARatesHeaderBean.getTxtBagType())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));     
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_KotOprDtlsDateCheck(?,?,?,?,?)",true,true);
      DBObject oOutObject = (DBObject)oOutArray.get(0);     
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println(""+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
     return errorMsg;
      }
 
}