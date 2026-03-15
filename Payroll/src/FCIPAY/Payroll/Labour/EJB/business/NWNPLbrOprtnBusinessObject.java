package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourOprtnDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourOprtnQueryVO;
import java.sql.SQLException;
import java.util.StringTokenizer;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourOprtnHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourOprtnDtlBean;
public class NWNPLbrOprtnBusinessObject extends BaseBO 
{

  public NWNPLbrOprtnBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("DaRatesScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }
  
   public RecordMetaInfo getNWNPLbrOprtnHeaderMetaInfo(NWNPLabourOprtnQueryVO oNWNPLabourOprtnQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oNWNPLabourOprtnQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oNWNPLabourOprtnQueryVO.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getnwnwplbroprtnhdrcount(?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getNWNPLbrOprtnHeader(NWNPLabourOprtnQueryVO oNWNPLabourOprtnQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oNWNPLabourOprtnQueryVO == null)
    {
      oNWNPLabourOprtnQueryVO = new NWNPLabourOprtnQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;
      String locCode = oNWNPLabourOprtnQueryVO.getLoginLocCode()+"";

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oNWNPLabourOprtnQueryVO.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getnwnplbroprtnhdrdtl(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      NWNPLabourOprtnHeaderBean oNWNPLbrOprtnHeader;
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
          oNWNPLbrOprtnHeader = new NWNPLabourOprtnHeaderBean();
          oNWNPLbrOprtnHeader.setHeaderPrimaryKey(EnrgiseUtil.convertToString(oRow.get("eff_start_date").getDate()));                                                  
          oNWNPLbrOprtnHeader.setTxtEndDate(EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate()));                                                  
          oHeaderList.add(oNWNPLbrOprtnHeader);
      }              
    return oHeaderList;
  } 


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
    return null;  
      
  }


  private void saveNWNPLbrOprtnInfo(String sPrimaryKey, NWNPLabourOprtnHeaderBean oNWNPLabourOprtnHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
       NWNPLabourOprtnDtlBean oNWNPLabourOprtnDtlBean = (NWNPLabourOprtnDtlBean)oIt.next(); 
        if(oNWNPLabourOprtnDtlBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_pay_labour.proc_insertnwnplbroprtndetail(?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNWNPLabourOprtnHeaderBean.getEffStartDate())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnDtlBean.getTxtOperation()))); 
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oNWNPLabourOprtnDtlBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_pay_labour.proc_updatenwnplbroprtndtl(?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnDtlBean.getDetailId())));     //added by swapnendu on 05 Mar 2011               
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNWNPLabourOprtnHeaderBean.getEffStartDate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnDtlBean.getTxtOperation())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oNWNPLabourOprtnDtlBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_pay_labour.proc_deletenwnplbroprtndetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnDtlBean.getDetailId())));     //added by swapnendu on 05 Mar 2011               
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnHeaderBean.getEffStartDate())));          
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
  
  public RecordMetaInfo getNWNPLbrOprtnDetailMetaInfo(String sPrimaryKey, String ScreenName, NWNPLabourOprtnDtlInfo oNWNPLabourOprtnDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output     
      
      oParameters = new ArrayList();           
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getnwnplbroprtndetailcnt(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getNWNPLbrOprtnDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, NWNPLabourOprtnDtlInfo oNWNPLabourOprtnDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oNWNPLabourSORDtl = null;
    NWNPLabourOprtnDtlBean oNWNPLabourOprtnDtlBean;
   
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getnwnplbroprtndetail(?,?,?,?,?)");
      
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
            oNWNPLabourSORDtl = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oNWNPLabourOprtnDtlBean = new NWNPLabourOprtnDtlBean();
          oNWNPLabourOprtnDtlBean.setDetailId((oRow.get("operation_id").getString()));
          oNWNPLabourOprtnDtlBean.setTxtOperation((oRow.get("operation_desc").getString()));
          oNWNPLabourOprtnDtlBean.setStatus("Q");
 
          oNWNPLabourSORDtl.add(oNWNPLabourOprtnDtlBean);
        }        
    return oNWNPLabourSORDtl;
    
  }
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("MaintNWNPLbrOprtnScreen"))
    {
      saveNWNPLbrOprtnInfo(sHeaderPrimaryKey,(NWNPLabourOprtnHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }    
  }   
  
  private void saveDARates(String sPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList(); //added by swapnendu on 05 Mar 2011.
      //chkRcdToDlt(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
      checkMandatoryDetail(oBaseHeaderBean,sScreenMode,oDetailBeanArray);
    }
  }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
private void chkRcdToDlt(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
{
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    NWNPLabourOprtnHeaderBean oNWNPLabourOprtnHeaderBean = (NWNPLabourOprtnHeaderBean)oBaseHeaderBean;      
    Iterator oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        count++;
        NWNPLabourOprtnDtlBean oNWNPLabourOprtnDtlBean = (NWNPLabourOprtnDtlBean)oIt.next(); 
        if(oNWNPLabourOprtnDtlBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnDtlBean.getDetailId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNWNPLabourOprtnHeaderBean.getEffStartDate())));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters, "pkg_pay_labour.proc_DpsLabourSORDtl_Del(?,?,?,?)",true,true);
              
            DBObject oOutObject = (DBObject)oOutArray.get(1);
            Integer errCode = (Integer)(oOutObject.getObject());
            
            oOutObject = (DBObject)oOutArray.get(0);
            String errMsg = (String)(oOutObject.getObject());
            if (errCode.intValue() > 0)
            {
                ArrayList oArguments = new ArrayList();
                oArguments.add(new Integer(count));
                oList.add(new EnrgiseApplicationException("Payroll.DPSLabour.SORDelete",oArguments));
            }
        }
    }
}
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oList = new ArrayList();    
    NWNPLabourOprtnHeaderBean oNWNPLabourOprtnHeaderBean = (NWNPLabourOprtnHeaderBean)oBaseHeaderBean;        
      System.out.println(oNWNPLabourOprtnHeaderBean.getScreenModeSOR1());
      if(oNWNPLabourOprtnHeaderBean.getScreenModeSOR1().equals("N"))    
      {
          checkSOREffdate(oBaseHeaderBean,oList,oDetailBeanArray);        
          //checkEmpCurBasicLimit(oBaseHeaderBean,oList);                    
      }
      
    reportError(oList);        
  }  

  private void checkSOREffdate(BaseHeaderBean oBaseHeaderBean, ArrayList oList, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Integer chkFlag = new Integer(0);
    Iterator oIt = null;
    NWNPLabourOprtnHeaderBean oNWNPLabourOprtnHeaderBean = (NWNPLabourOprtnHeaderBean)oBaseHeaderBean;        
    oParameters = new ArrayList();           
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourOprtnHeaderBean.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_oprtneffdatecheck(?,?,?)");
    
    chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
    if(!chkFlag.equals(new Integer(0)))
    {        
      oList.add(new EnrgiseApplicationException("payroll.Labour.EffDatecheck"));
    }            
    
  } 
  
} 