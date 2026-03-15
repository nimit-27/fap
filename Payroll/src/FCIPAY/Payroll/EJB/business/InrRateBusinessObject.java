package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintInterestRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.InrRateDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintInrRateHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintInterestRateBean;
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
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;


public class InrRateBusinessObject extends BaseBO
{
  public InrRateBusinessObject()
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
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintInrRateHeaderBean oMaintInrRateHeaderBean = (MaintInrRateHeaderBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
     
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInrRateHeaderBean.getTxtDateFrom())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInrRateHeaderBean.getTxtDateTo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getMemberType())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateInrRateHeader(?,?,?,?,?,?)");
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
   
      return null;
  }


  public boolean saveMtrRdgHeader(MaintInrRateHeaderBean oMaintInrRateHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      return true;
  }

 public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("InterestRateScreen"))
    {      
      saveInterestRate(sHeaderPrimaryKey,(MaintInrRateHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveInterestRate(String sPrimaryKey,MaintInrRateHeaderBean oMaintInrRateHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        MaintInterestRateBean oMaintInterestRateBean = (MaintInterestRateBean)oIt.next();
//        System.out.println(oMaintInterestRateBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintInterestRateBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertInrRateDetail(?,?,?,?,?,?,?,?)");
            bInsert = true;
          }

          oParameters = new ArrayList();

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInrRateHeaderBean.getTxtDateFrom())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInrRateHeaderBean.getTxtDateTo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getMemberType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateBean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateBean.getEndField())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateBean.getTxtInrRate())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintInterestRateBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateInrRateDetail(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInrRateHeaderBean.getTxtDateFrom())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintInterestRateBean.getTxtSrlNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getMemberType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateBean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateBean.getEndField())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateBean.getTxtInrRate())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintInterestRateBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteInrRateDetail(?,?,?)");
            bDelete = true;
          }

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintInterestRateBean.getTxtSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInrRateHeaderBean.getTxtDateFrom())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getMemberType())));
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
        oBeanDelete.executeBatch();
      }
   
  }

  public RecordMetaInfo getInterestRateHeaderMetaInfo(MaintInterestRateQueryVO oMaintInterestRateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();

  
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInterestRateQueryVO.getTxtDateFrom())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInterestRateQueryVO.getTxtDateTo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateQueryVO.getMemberType())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetInterestRatehdrCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public boolean saveIntRatesHeader(MaintInrRateHeaderBean oMaintInrRateHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
//    AddressDetailBean oAddress;
    BaseDetailVO oBaseDetailVO = null;
          
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintInrRateHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintInrRateHeaderBean.getTxtDateFrom()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oMaintInrRateHeaderBean.getTxtDateTo()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getMemberType())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_saveDARatesHeader(?,?,?,?,?)");
      return true;
  }

  public ArrayList getInterestRateHeader(MaintInterestRateQueryVO oMaintInterestRateQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintInterestRateQueryVO == null)
    {
      oMaintInterestRateQueryVO = new MaintInterestRateQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

   

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
       oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));

      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInterestRateQueryVO.getTxtDateFrom())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oMaintInterestRateQueryVO.getTxtDateTo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInterestRateQueryVO.getMemberType())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetInterestRate(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     
      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintInrRateHeaderBean oMaintInrRateHeaderBean;
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
          oMaintInrRateHeaderBean = new MaintInrRateHeaderBean();

          oMaintInrRateHeaderBean.setTxtDateFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("DATE_FROM").getDate()));
          oMaintInrRateHeaderBean.setTxtDateTo(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("DATE_TO").getDate()));
          oMaintInrRateHeaderBean.setMemberType(oRow.get("Member_Type").getString());
          oHeaderList.add(oMaintInrRateHeaderBean);
      }
      
        
    return oHeaderList;
  }
  
  public RecordMetaInfo getInterestRateDetailMetaInfo(String sPrimaryKey,InrRateDetailInfo oInrRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
     

      
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oInrRateDetailInfo.getTxtDateFrom())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oInrRateDetailInfo.getTxtDateTo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oInrRateDetailInfo.getMemberType())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InterestRateCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;      
      //return null;
  }
  
  public ArrayList getInterestRateDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,InrRateDetailInfo oInrRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintInterestRateBean oMaintInterestRateBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oInrRateDetail = null;

      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));

      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oInrRateDetailInfo.getTxtDateFrom())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oInrRateDetailInfo.getTxtDateTo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oInrRateDetailInfo.getMemberType())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetInterestRateDetail(?,?,?,?,?,?,?)");
      
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
            oInrRateDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintInterestRateBean = new MaintInterestRateBean();
          oMaintInterestRateBean.setStartField((oRow.get("amount_from").getString()));
          oMaintInterestRateBean.setEndField((oRow.get("amount_to").getString()));
          oMaintInterestRateBean.setTxtInrRate((oRow.get("interest_Rate").getString())); 
          oMaintInterestRateBean.setTxtSrlNo((oRow.get("srl_no").getString()));

          oMaintInterestRateBean.setStatus("Q"); 
                  
          oInrRateDetail.add(oMaintInterestRateBean);
        }
  
       return oInrRateDetail;

    
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
      chkEffDate(oBaseHeaderBean,sScreenMode, oList);
      reportError(oList);
    }
  }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  private void chkEffDate(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      String errMsg;
      
      MaintInrRateHeaderBean oMaintInrRateHeaderBean = (MaintInrRateHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintInrRateHeaderBean.getTxtDateFrom())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintInrRateHeaderBean.getMemberType())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_ValidatePFDate(?,?,?,?)",true,true);
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




