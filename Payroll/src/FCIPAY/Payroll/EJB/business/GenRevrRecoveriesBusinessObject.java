package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenRevrRecoveriesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RevrRecoveriesDetailInfo;
import java.sql.SQLException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.RevrRecoveriesHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.UTILITY.GenRevrRecoveriesBean;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayYearStatusVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class GenRevrRecoveriesBusinessObject extends BaseBO
{
  public GenRevrRecoveriesBusinessObject()
  {
  }

  public RecordMetaInfo getRevrRecoveriesHeaderMetaInfo(GenRevrRecoveriesQueryVO oGenRevrRecoveriesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesQueryVO.getTxtpayYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oGenRevrRecoveriesQueryVO.getHdnEmpLbrFlag()));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPromRevrCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  
  public ArrayList getRevrRecoveriesHeader(GenRevrRecoveriesQueryVO oGenRevrRecoveriesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oGenRevrRecoveriesQueryVO == null)
    {
      oGenRevrRecoveriesQueryVO = new GenRevrRecoveriesQueryVO();
    }
    
     ArrayList oOutArray; //Output 
     ArrayList oHeaderList = null;

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oGenRevrRecoveriesQueryVO.getLoginLocCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oGenRevrRecoveriesQueryVO.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));

            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");

            ArrayList oRetList = null;
            Iterator oIt = null;
            QueryRow oRow = null;            
            
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

            String sCurYYMM = "";
            String status = "";
  
            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              sCurYYMM = oRow.get("yymm").getString(); 
              status = oRow.get("status").getString(); 
            }    

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesQueryVO.getTxtpayYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oGenRevrRecoveriesQueryVO.getHdnEmpLbrFlag()));
     // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPromRevr(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      RevrRecoveriesHeaderBean oRevrRecoveriesHeader;
      count = 0;
      oRow = null;
      HashMap oColumns = null;
      oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oHeaderList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oRevrRecoveriesHeader = new RevrRecoveriesHeaderBean();
          oRevrRecoveriesHeader.setTxtpayYYMM(oRow.get("pay_yymm").getString());
          oRevrRecoveriesHeader.setHdnPayrollFlag(oRow.get("payroll_flag").getString());
          oRevrRecoveriesHeader.setHdnCurYYMM(sCurYYMM);
          oRevrRecoveriesHeader.setHdnPayStatus(status);
          oHeaderList.add(oRevrRecoveriesHeader);
      }              
    return oHeaderList;
  }


 public RecordMetaInfo getRevrRecoveriesDetailMetaInfo(String sPrimaryKey,RevrRecoveriesDetailInfo oRevrRecoveriesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

       String PayYYMM;
      PayYYMM = oRevrRecoveriesDetailInfo.getTxtpayYYMM(); 
     
      
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oRevrRecoveriesDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,PayYYMM));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPromrevrDtlCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
 



 public ArrayList getRevrRecoveriesDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,RevrRecoveriesDetailInfo oRevrRecoveriesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    GenRevrRecoveriesBean oRevrRecoveriesDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oRevrRecoveriesDetail = null;

      String PayYYMM;
      PayYYMM = oRevrRecoveriesDetailInfo.getTxtpayYYMM();
        
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oRevrRecoveriesDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,PayYYMM));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetpromRevrDetail(?,?,?,?,?,?,?)");
      
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
            oRevrRecoveriesDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oRevrRecoveriesDtl = new GenRevrRecoveriesBean();
          oRevrRecoveriesDtl.setTxtEmployeeNo((oRow.get("emp_num").getString()));          
       //   oPayScaleDtl.setTxtRevYYMM1((oRow.get("rev_year").getString()));
        //  oPayScaleDtl.setTxtPayScaleCode((oRow.get("pay_scale_code").getString()));
          oRevrRecoveriesDtl.setTxtEmployeeName((oRow.get("empName").getString()));
          oRevrRecoveriesDtl.setTxtFromDate(EnrgiseUtil.convertToString(oRow.get("from_date").getDate()));
          oRevrRecoveriesDtl.setTxtUptoMonth((oRow.get("to_yymm").getString()));                    
       
          oRevrRecoveriesDtl.setStatus("Q");
          oRevrRecoveriesDetail.add(oRevrRecoveriesDtl);
        }             
        return oRevrRecoveriesDetail; 
  }    



  public boolean saveRevrRecoveriesHeader(RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
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

  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    saveRevrRecoveries(sHeaderPrimaryKey,oDetailBeanArray,(RevrRecoveriesHeaderBean)oBaseHeaderBean);
  }   
  
 private void saveRevrRecoveries(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean) throws EnrgiseSystemException
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
        GenRevrRecoveriesBean oGenRevrRecoveriesBean = (GenRevrRecoveriesBean)oIt.next();
//        System.out.println(oGenerateBasicArrearBean.getStatus());
        if(oGenRevrRecoveriesBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPromRevrDetail(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oGenRevrRecoveriesBean.getTxtFromDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesBean.getTxtUptoMonth())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesHeaderBean.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
       else if(oGenRevrRecoveriesBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdatePromRevr(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtpayYYMM())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oGenRevrRecoveriesBean.getTxtFromDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesBean.getTxtUptoMonth())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesHeaderBean.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtSiteID())));
        
          oBean.addToBatch(oParameters);
          
        }
     else if(oGenRevrRecoveriesBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePromRevrDetail(?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenRevrRecoveriesBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oGenRevrRecoveriesBean.getTxtFromDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesHeaderBean.getHdnEmpLbrFlag()));
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
       oRevrRecoveriesHeaderBean.setScreenModePay1("U");     
  }
   
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("GenerateBasicArrearScreen"))
    {
      sDetailTable = "lstBasicArrDtl";
    }
    initializeBO("GenerateBasicArrearScreen",sDetailTable);
  }  


public LovVO getRevrRecoveriesLOVDataPayYYMM(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay YYMM");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPromRevrPayYYMMLov(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_yymm").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


public LovVO getRevrRecoveriesLOVDataEmpNo(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    

    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField2();

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, EmpNo));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, Name));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPromRevrEmpNoLov(?,?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("emp_num").getString());            
      oLOVBean.setDetailField2(oRow.get("empName").getString());   
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public String GenRevrRecoveries(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
     
     
      
   oList = new ArrayList();
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean = (RevrRecoveriesHeaderBean)oBaseHeaderBean; 
    ArrayList oOutArray; //Output 


      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtpayYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PROM_REV_RECOVERIES_FCI.proc_PromReversal(?,?,?,?,?,?)");      

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_code = (String)oOutObject.getObject();
     
      if(error_code.equals("PROMOTION REVERSAL RECOVERIES SUCCESS"))
      oRevrRecoveriesHeaderBean.setHdnPayrollFlag("Y");
      
      return error_code;      
  }


public String UndoRevrRecoveries(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseApplicationException, EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
     
    oList = new ArrayList();
    Timestamp oWhenPicked = null;
    int count = 0;
    String error_code = "";    
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean = (RevrRecoveriesHeaderBean)oBaseHeaderBean; 
    ArrayList oOutArray; //Output 

   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtpayYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"Pkg_UndoPromReversal.Ysp_UndoPromReversal(?,?,?,?,?,?)");      

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      error_code = (String)oOutObject.getObject();
      

     if(error_code.equals("UNDO PROMOTION REVERSAL SUCCESS"))
      oRevrRecoveriesHeaderBean.setHdnPayrollFlag("N");
     
     return error_code;
  }


 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean);
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
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
    
     checkMaxPayYear(oBaseHeaderBean,oList);
     checkRevrRecoveriesHeader(oBaseHeaderBean,oList);

     reportError(oList);
    
    
  }

 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    
     check_Upto_PayYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
     reportError(oList);
    
    
  }
  
private void checkRevrRecoveriesHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        RevrRecoveriesHeaderBean  oRevrRecoveriesHeaderBean  = (RevrRecoveriesHeaderBean)oBaseHeaderBean;

//        System.out.println(oBasicArrearHeaderBean.getScreenModePay1());       
        if(oRevrRecoveriesHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesHeaderBean.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PromRevrDuplicateCheck(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("pay_yymm").getString(); 
              if (!sRevYear.equals("0"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(sRevYear);              
                oList.add(new EnrgiseApplicationException("Payroll.BasicArr.DuplicateCheck",oArguments));              
              }                
             }
           

            
        }
  }


 private void check_Upto_PayYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();
      long counter = 0;

      while(oIt.hasNext())
      {
        counter = counter + 1;
        GenRevrRecoveriesBean oGenerateBasicArrearBean = (GenRevrRecoveriesBean)oIt.next();
        System.out.println(oGenerateBasicArrearBean.getStatus());
        RevrRecoveriesHeaderBean  oBasicArrearHeaderBean  = (RevrRecoveriesHeaderBean)oBaseHeaderBean;
        if(!(oGenerateBasicArrearBean.getStatus().equals("D")))
          count++;


       if((oGenerateBasicArrearBean.getStatus().equals("N")) ||   (oGenerateBasicArrearBean.getStatus().equals("U")))
       {
          String uptoMonth = oGenerateBasicArrearBean.getTxtUptoMonth();
          String payYYMM = oBasicArrearHeaderBean.getTxtpayYYMM();
          if (Integer.parseInt(uptoMonth) >= Integer.parseInt(payYYMM))
          {   
              ArrayList oArguments = new ArrayList();          
              oArguments.add(uptoMonth);
              oArguments.add(Long.toString(counter));
              oList.add(new EnrgiseApplicationException("Payroll.BasicArr.UptoYYMM_payYYMMcheck",oArguments));             
          }

       }
      }
  }


private void checkMaxPayYear(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        RevrRecoveriesHeaderBean  oRevrRecoveriesHeaderBean  = (RevrRecoveriesHeaderBean)oBaseHeaderBean;

        System.out.println(oRevrRecoveriesHeaderBean.getScreenModePay1());       
        if(oRevrRecoveriesHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRevrRecoveriesHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oRevrRecoveriesHeaderBean.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yymm").getString(); 
              String status = oRow.get("status").getString(); 

              if (!sRevYear.equals(oRevrRecoveriesHeaderBean.getTxtpayYYMM()))
              {
                  oRevrRecoveriesHeaderBean.setScreenModePay1("N");
                  ArrayList oArguments = new ArrayList();
                  oArguments.add(sRevYear);
                  oList.add(new EnrgiseApplicationException("Payroll.BasicArr.maxPayYearcheck",oArguments));                
              }

              else 
              {
                if (Integer.parseInt(status) >= 2 )
                {
                    oRevrRecoveriesHeaderBean.setScreenModePay1("N");
                    oList.add(new EnrgiseApplicationException("Payroll.BasicArr.statusCheck",EnrgiseConstants.MESSAGE));                                
                }
              }

            }           
        }
  }
}