package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HistoryEntryQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HistoryEntryDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.HistoryEntryHeaderBean;
import FCIPAY.Payroll.UTILITY.HistoryEntryBean;
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





public class HistoryEntryBusinessObject extends BaseBO
{
  private String ScreenModePay1;

  public HistoryEntryBusinessObject()
  {
  }

   public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("HistoryEntryScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
  /*
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    HistoryEntryHeaderBean oHistoryEntryHeaderBean = (HistoryEntryHeaderBean)oBaseHeaderBean;

      if (oHistoryEntryHeaderBean.getScreenModePay1().equals("N"))
      {
        saveNewHeaderImpl(oBaseHeaderBean);
      }
      else
      {
              ArrayList oOutArray; //Output 
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryHeaderBean.getTxtEmpNo()));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryHeaderBean.getTxtYYMM()));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtUserID())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtSiteID())));
              oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));              
              oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_UpdateHistoryHeader(?,?,?,?,?)");
      }
     */
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
/*    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    HistoryEntryHeaderBean oHistoryEntryHeaderBean = (HistoryEntryHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryHeaderBean.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryHeaderBean.getTxtYYMM()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));           
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertHistoryHdr(?,?,?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject(); */
      return null;   
  }

  public RecordMetaInfo getHistoryEntHeaderMetaInfo(HistoryEntryQueryVO oHistoryEntryQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();  
    
      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryQueryVO.getTxtEmpNo())));      
     oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetHistHdrCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
  }

  public ArrayList getHistoryEntHeader(HistoryEntryQueryVO oHistoryEntryQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oHistoryEntryQueryVO == null)
    {
      oHistoryEntryQueryVO = new HistoryEntryQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

   

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));

      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryQueryVO.getTxtEmpNo()));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryQueryVO.getTxtYYMM()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetHistHdr(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     
      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      HistoryEntryHeaderBean oHistoryEntryHeaderBean;
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
          oHistoryEntryHeaderBean = new HistoryEntryHeaderBean();

          oHistoryEntryHeaderBean.setTxtEmpNo((oRow.get("emp_num").getString()));
          oHistoryEntryHeaderBean.setTxtEmpName((oRow.get("name").getString()));
          oHistoryEntryHeaderBean.setTxtYYMM((oRow.get("yymm").getString())); 
          oHeaderList.add(oHistoryEntryHeaderBean);
      }
              
    return oHeaderList;
    }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {    
    if(sScreenName.equals("HistoryEntryScreen"))
    {
        saveHistoryEnt(sHeaderPrimaryKey,oDetailBeanArray,(HistoryEntryHeaderBean)oBaseHeaderBean);
    }
  }   

  private void saveHistoryEnt(String sPrimaryKey,  ArrayList oDetailBeanArray, HistoryEntryHeaderBean oHistoryEntryHeaderBean) throws EnrgiseSystemException
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
        HistoryEntryBean oHistoryEntryBean = (HistoryEntryBean)oIt.next();
//        System.out.println(oHistoryEntryBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oHistoryEntryBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG_EXT.proc_InsertHistoryDetail(?,?,?,?,?,?,?,?,?)");
            bInsert = true;       
          }          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtPayCode())));          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtPayMode())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtAmount())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtUnitID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oHistoryEntryBean.getTxtPaymentDate())));          
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
       else if(oHistoryEntryBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG_EXT.proc_UpdateHistoryDetail(?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtPayCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getHdnSrlNo())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtPayMode())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtAmount())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtUnitID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oHistoryEntryBean.getTxtPaymentDate())));                    
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
     else if(oHistoryEntryBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG_EXT.proc_DeleteHistoryDetail(?,?,?,?,?,?,?,?)");
            bDelete = true;
          }
           oParameters = new ArrayList();
           oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oHistoryEntryHeaderBean.getTxtEmpNo())));          
           oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtYYMM())));
           oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtPayCode())));
           oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getHdnSrlNo())));  
           oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtPayMode())));  
           oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryBean.getTxtAmount())));             
           oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtUserID())));
           oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtSiteID())));            
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
    checkBankMastHeader(oBaseHeaderBean,oList);
    reportError(oList);
    
    
  }

 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();  
  
    reportError(oList);
    
    
  }

  private void checkBankMastHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        HistoryEntryHeaderBean  oHistoryEntryHeaderBean  = (HistoryEntryHeaderBean)oBaseHeaderBean;

//        System.out.println(oHistoryEntryHeaderBean.getScreenModePay1());       
        if(oHistoryEntryHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHistoryEntryHeaderBean.getTxtYYMM())));          
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_HistEntryHdrDupCheck(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.HistoryEntry.Hdr.DuplicateCheck",EnrgiseConstants.MESSAGE));
            }
       }
  }

  

  public RecordMetaInfo getHistoryEntDetailMetaInfo(String sPrimaryKey,HistoryEntryDetailInfo oHistoryEntryDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
              
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryDetailInfo.getTxtYYMM())); 
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_HistEntryDtlCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;      
      //return null;
  }


  public ArrayList getHistoryEntDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,HistoryEntryDetailInfo oHistoryEntryDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    HistoryEntryBean oHistoryEntryBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oInrRateDetail = null;

      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryDetailInfo.getTxtEmpNo()));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oHistoryEntryDetailInfo.getTxtYYMM()));   
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetHistEntryDetail(?,?,?,?,?,?)");
      
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
          oHistoryEntryBean = new HistoryEntryBean();
          oHistoryEntryBean.setTxtPayCode((oRow.get("pay_code").getString()));
          oHistoryEntryBean.setTxtDescription((oRow.get("pay_code_desc").getString()));
          oHistoryEntryBean.setTxtPayMode((oRow.get("pay_mode").getString())); 
          oHistoryEntryBean.setTxtAmount((oRow.get("txn_amt").getString())); 
          oHistoryEntryBean.setHdnSrlNo((oRow.get("pay_code_srl").getString()));           
          oHistoryEntryBean.setTxtUnitID((oRow.get("unit_id").getString()));                     
          oHistoryEntryBean.setTxtPaymentDate(EnrgiseUtil.convertToString(oRow.get("payment_date").getDate()));           
          
          oHistoryEntryBean.setStatus("Q"); 
                  
          oInrRateDetail.add(oHistoryEntryBean);
        }
  
       return oInrRateDetail;    
  }


  public LovVO getHistYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("YearMonth");  

    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    
    oLovVO.setVisibilityList(arylstVisibility);

    String yymm; 
    yymm=oLovQueryVO.getSearchField1();
       
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, yymm));
     
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetBankCodeLOVQ(?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("yymm").getString());                   
                  
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public LovVO getQueryHistYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("YearMonth");  

    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);

    oLovVO.setVisibilityList(arylstVisibility);

    String yymm; 
    yymm=oLovQueryVO.getSearchField1();

    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, yymm));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_QueryHistoryYYMMLOV(?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("yymm").getString());                   
                  
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getQueryHistEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetHistoryEmpLovQ(?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
       oLOVBean.setDetailField2(oRow.get("empName").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;

  }

  public LovVO getNewHistEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetHistoryEmpLovN(?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
       oLOVBean.setDetailField2(oRow.get("empName").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;

  }
    

 

  private void checkMandatoryHeader(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    checkInterestRate(oBaseHeaderBean, oList);
    reportError(oList);
  }

  private void checkInterestRate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  public String getScreenModePay1()
  {
    return ScreenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    ScreenModePay1 = newScreenModePay1;
  }
 
}