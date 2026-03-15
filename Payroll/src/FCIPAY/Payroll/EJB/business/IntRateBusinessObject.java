package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintInterestRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintInterestRateBean;
import FCIPAY.Payroll.UTILITY.IntRateHeaderBean;
import FCIPAY.Payroll.UTILITY.IntRateDetailBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.util.Date;
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
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;


public class IntRateBusinessObject extends BaseBO
{
  public IntRateBusinessObject()
  {
  }
  
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("InterestRateScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    IntRateHeaderBean oIntRateHeaderBean = (IntRateHeaderBean)oBaseHeaderBean;
   // if(oIntRateHeaderBean.getLoanIntType().equals("N"))
  //  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;
  
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getHeaderPrimaryKey())));    
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateFrom())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateTo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateIntRateHeader(?,?,?,?,?,?)");
   // }
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    IntRateHeaderBean oIntRateHeaderBean = (IntRateHeaderBean)oBaseHeaderBean;
    if(oIntRateHeaderBean.getLoanIntType().equals("N"))
    {
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oIntRateHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oIntRateHeaderBean.getLoanIntType())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateFrom())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateTo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); //int rate=null for non int bearing loans(advances) 
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertIntRateHeader(?,?,?,?,?,?,?,?)");
      //DBObject oOutObject = (DBObject)oOutArray.get(0);
      //return (String)oOutObject.getObject();    
    }
    return new String("");
  }


  public boolean saveMtrRdgHeader(IntRateHeaderBean oMaintElecMtrRdgHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      return true;
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("IntRateScreen"))
    {      
      saveIntRate(sHeaderPrimaryKey,(IntRateHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveIntRate(String sPrimaryKey,IntRateHeaderBean oIntRateHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;   

    /*String EmpNo,MtrNo,Freq;
    EmpNo=oMaintElecMtrRdgHeaderBean.getTxtEmpNo();
    MtrNo=oMaintElecMtrRdgHeaderBean.getTxtMtrNo();
    Freq=oMaintElecMtrRdgHeaderBean.getTxtFreq();
    System.out.println(EmpNo);  
    System.out.println(MtrNo);
    System.out.println(Freq);*/
    
  
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        IntRateDetailBean oIntRateDetailBean = (IntRateDetailBean)oIt.next();
//        System.out.println(oIntRateDetailBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oIntRateDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertIntRateDetail(?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oIntRateHeaderBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oIntRateHeaderBean.getLoanIntType())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateFrom())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateTo())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateDetailBean.getStartField())));                    
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateDetailBean.getEndField())));                    
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateDetailBean.getTxtIntRate())));           
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oIntRateDetailBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateIntRateHeader(?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oIntRateHeaderBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateFrom())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateTo())));  
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oIntRateDetailBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteIntRateDetail(?,?,?)");
            bDelete = true;
          }

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oIntRateHeaderBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateFrom())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oIntRateDetailBean.getTxtSerialNo())));
          oBeanDelete.addToBatch(oParameters);          
        }
      }
      
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
   //     oBeanDelete.executeBatch();
   System.out.println("Delete not Allowed");
      }
   
  }

  public RecordMetaInfo getIntRateHeaderMetaInfo(IntRateQueryVO oIntRateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();

    if(oIntRateQueryVO.getLoanType() == null)
    {
   /*   String hPrimaryKey = oIntRateQueryVO.getHeaderPrimaryKey();
      int ind = hPrimaryKey.indexOf(",",0);
      oIntRateQueryVO.setLoanType(hPrimaryKey.substring(0, ind));
//      System.out.println(oIntRateQueryVO.getLoanType());
      int ind1 = hPrimaryKey.indexOf(",",ind+1);
      oIntRateQueryVO.setDateFrom(hPrimaryKey.substring(ind+1, ind1));
//      System.out.println(oIntRateQueryVO.getDateFrom());
      oIntRateQueryVO.setDateTo(hPrimaryKey.substring(ind1+1, hPrimaryKey.length()));
//      System.out.println(oIntRateQueryVO.getDateTo());
*/
    }    
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateQueryVO.getLoanIntType())));
     // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateQueryVO.getRefundFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateQueryVO.getDateFrom())));      
    //  oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateQueryVO.getDateTo())));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntRateHeaderCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  
  public ArrayList getIntRateHeader(IntRateQueryVO oIntRateQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oIntRateQueryVO == null)
    {
      oIntRateQueryVO = new IntRateQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

 /*   if(oIntRateQueryVO.getLoanType() == null)
    {
      String hPrimaryKey = oIntRateQueryVO.getHeaderPrimaryKey();
      int ind = hPrimaryKey.indexOf(",",0);
      oIntRateQueryVO.setLoanType(hPrimaryKey.substring(0, ind));
//      System.out.println(oIntRateQueryVO.getLoanType());
      int ind1 = hPrimaryKey.indexOf(",",ind+1);
      oIntRateQueryVO.setDateFrom(hPrimaryKey.substring(ind+1, ind1));
//      System.out.println(oIntRateQueryVO.getDateFrom());
      oIntRateQueryVO.setDateTo(hPrimaryKey.substring(ind1+1, hPrimaryKey.length()));
//      System.out.println(oIntRateQueryVO.getDateTo());
    }    
\*/
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntRateQueryVO.getLoanIntType())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateQueryVO.getDateFrom())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntRateHeader(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     
      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      IntRateHeaderBean oIntRateHeaderBean;
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
          oIntRateHeaderBean = new IntRateHeaderBean();
//          oMaintDARatesHeaderBean.setHeaderPrimaryKey(oRow.get("srl_no").getString());
          oIntRateHeaderBean.setHeaderPrimaryKey(oRow.get("LOAN_TYPE").getString());
          oIntRateHeaderBean.setLoanIntType(oRow.get("LOAN_INT_TYPE").getString());
         // oIntRateHeaderBean.setRefundFlag(oRow.get("REFUNDABLE_FLAG").getString());
          oIntRateHeaderBean.setLoanHdrDesc(oRow.get("LOAN_DESC").getString());
          oIntRateHeaderBean.setDateFrom(EnrgiseUtil.convertToString(oRow.get("DATE_FROM").getDate()));
          oIntRateHeaderBean.setDateTo(EnrgiseUtil.convertToString(oRow.get("DATE_TO").getDate()));
          oIntRateHeaderBean.setHdnHeaderFlag(oRow.get("loanFlag").getString());
         // oIntRateHeaderBean.setTxtIntRate(oRow.get("Interest_Rate").getString());
          oHeaderList.add(oIntRateHeaderBean);
      }      
        
    return oHeaderList;
  }
  
  public RecordMetaInfo getIntRateDetailMetaInfo(String sPrimaryKey,IntRateDetailInfo oIntRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      String intTypeDesc;      
     // intTypeDesc = oIntRateDetailInfo.getLoanHdrDesc();

      
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));      
    //  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oIntRateDetailInfo.getLoanIntType()));      
    //  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oIntRateDetailInfo.getRefundFlag()));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateDetailInfo.getDateFrom())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateDetailInfo.getDateTo())));
      
    //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntRateDetailCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;      
      //return null;
  }
  
  public ArrayList getIntRateDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,IntRateDetailInfo oIntRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    IntRateDetailBean oIntRate;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oIntRateDetail = null;

      String intTypeDesc;      
     // intTypeDesc = oIntRateDetailInfo.getLoanHdrDesc();
      
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateDetailInfo.getDateFrom())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateDetailInfo.getDateTo())));
     
      
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntRateDetail(?,?,?,?,?,?,?)");      
      
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
            oIntRateDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oIntRate = new IntRateDetailBean();
          oIntRate.setStartField((oRow.get("amount_from").getString()));
          oIntRate.setEndField((oRow.get("amount_to").getString()));
         // oIntRate.setLoanType((oRow.get("LOAN_TYPE").getString()));
        //  oIntRate.setLoanDesc((oRow.get("LOAN_DESC").getString()));
        //  oIntRate.setLoanIntType((oRow.get("LOAN_INT_TYPE").getString()));
          oIntRate.setTxtIntRate((oRow.get("Interest_Rate").getString()));
       //   oIntRate.setDateFrom(EnrgiseUtil.convertToString(oRow.get("DATE_FROM").getDate()));
       //   oIntRate.setDateTo(EnrgiseUtil.convertToString(oRow.get("DATE_TO").getDate()));
          //oIntRate.setTxtPenalty((oRow.get("penalty").getString())); 
          //oIntRate.setTxtConcession((oRow.get("concession").getString()));           
          oIntRate.setTxtSerialNo((oRow.get("loan_srl_no").getString())); 
          oIntRate.setStatus("Q"); 
                  
          oIntRateDetail.add(oIntRate);
        }
  
       return oIntRateDetail;   
  } 
  
  public LovVO getLoanTypeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Loan Type");    
    arylstHeaderNames.add("Loan Description");    
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetLoanTypeLOVQ(?,?)");
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
        
         oLOVBean.setDetailField1(oRow.get("loan_type").getString());            
         oLOVBean.setDetailField2(oRow.get("loan_desc").getString());            
        
        oList.add(oLOVBean);
      }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public LovVO getLoanTypeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Loan Type");    
    arylstHeaderNames.add("Loan Description");    
    //arylstHeaderNames.add("Date From");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
      oOutArray = oBean.callProc(oParameters,"pkg_loan.proc_GetLoanTypeLOVN(?,?)");
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
        
         oLOVBean.setDetailField1(oRow.get("pay_code").getString());            
         oLOVBean.setDetailField2(oRow.get("pay_code_desc").getString());            
        
        oList.add(oLOVBean);
      }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    if(sScreenMode.equals("N"))
    {
      checkMandatoryHeader(oBaseHeaderBean);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  private void checkMandatoryHeader(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    chkEffDate(oBaseHeaderBean, oList);
    reportError(oList);
  }

  private void checkInterestRate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void chkEffDate(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      String errMsg;
      
      IntRateHeaderBean oIntRateHeaderBean = (IntRateHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oIntRateHeaderBean.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oIntRateHeaderBean.getDateFrom())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_ValidateLoanIntDate(?,?,?,?)",true,true);
      chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
      errMsg=(String)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(errMsg);
        oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
      }
  }
}