package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORComboVO;
import java.sql.SQLException;
import java.util.StringTokenizer;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORDtlBean;
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

public class DpsLbrSORBusinessObject extends BaseBO 
{

  public DpsLbrSORBusinessObject()
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
  
   public RecordMetaInfo getDpsLbrSORHeaderMetaInfo(DpsLabourSORQueryVO oDpsLabourSORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oDpsLabourSORQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDpsLabourSORQueryVO.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsLbrSORHeaderCount(?,?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getDpsLbrSORHeader(DpsLabourSORQueryVO oDpsLabourSORQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oDpsLabourSORQueryVO == null)
    {
      oDpsLabourSORQueryVO = new DpsLabourSORQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;
      String locCode = oDpsLabourSORQueryVO.getLoginLocCode()+"";

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oDpsLabourSORQueryVO.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsLbrSORHeaderDtl(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      DpsLabourSORHeaderBean oDpsLbrSORHeader;
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
          oDpsLbrSORHeader = new DpsLabourSORHeaderBean();
          oDpsLbrSORHeader.setTxtRegCode(oRow.get("site_id").getString());          
          oDpsLbrSORHeader.setTxtRegName(oRow.get("Region_name").getString());          
          oDpsLbrSORHeader.setHeaderPrimaryKey(EnrgiseUtil.convertToString(oRow.get("eff_start_date").getDate()));                                                  
          oDpsLbrSORHeader.setTxtEndDate(EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate()));                                                  
          oHeaderList.add(oDpsLbrSORHeader);
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


  private void saveDpsLbrSORInfo(String sPrimaryKey, DpsLabourSORHeaderBean oDpsLabourSORHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
       DpsLabourSORDtlBean oDpsLabourSORDtlBean = (DpsLabourSORDtlBean)oIt.next(); 
       //  PayCodesVsAcctCodesBean oPayCodesVsAcctCodesBean = (PayCodesVsAcctCodesBean)oIt.next();
//        System.out.println(oDpsLabourSORDtlBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oDpsLabourSORDtlBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_pay_labour.proc_InsertDpsLbrSORDetail(?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getTxtLocCode())));
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDpsLabourSORHeaderBean.getEffStartDate())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getTxtOperation()))); 
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getTxtBagRateBlw65())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getTxtBagRateAbv65())));                   
         // oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDpsLabourSORHeaderBean.getTxtEndDate())));                    
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oDpsLabourSORDtlBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_pay_labour.proc_UpdateDpsLbrSORDetail(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getDetailId())));     //added by swapnendu on 05 Mar 2011               
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDpsLabourSORHeaderBean.getEffStartDate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getTxtOperation())));          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getTxtBagRateBlw65())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getTxtBagRateAbv65())));          
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oDpsLabourSORDtlBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_pay_labour.proc_DeleteDpsLbrSORDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getDetailId())));     //added by swapnendu on 05 Mar 2011               
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORHeaderBean.getEffStartDate())));          
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
  
  public RecordMetaInfo getDpsLbrSORDetailMetaInfo(String sPrimaryKey, String ScreenName, DpsLabourSORDtlInfo oDpsLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output     
      
      oParameters = new ArrayList();           
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlInfo.getTxtRegCode())));       
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsLbrSORDetailCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getDpsLbrSORDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, DpsLabourSORDtlInfo oDpsLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDpsLabourSORDtl = null;
    DpsLabourSORDtlBean oDpsLabourSORDtlBean;
   
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlInfo.getTxtRegCode())));       
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsLbrSORDetail(?,?,?,?,?,?)");
      
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
            oDpsLabourSORDtl = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oDpsLabourSORDtlBean = new DpsLabourSORDtlBean();
          //oDpsLabourSORDtlBean.setTxtLocCode((oRow.get("pay_code").getString()));          
          //oDpsLabourSORDtlBean.setTxtEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate())); 
          oDpsLabourSORDtlBean.setDetailId((oRow.get("operation_id").getString()));
          oDpsLabourSORDtlBean.setTxtOperation((oRow.get("operation_desc").getString()));
          oDpsLabourSORDtlBean.setTxtBagRateBlw65((oRow.get("sor_rates_below").getString()));
          oDpsLabourSORDtlBean.setTxtBagRateAbv65((oRow.get("sor_rates_above").getString()));
          //oDpsLabourSORDtlBean.setTxtEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate())); 
          oDpsLabourSORDtlBean.setStatus("Q");
 
          oDpsLabourSORDtl.add(oDpsLabourSORDtlBean);
        }        
    return oDpsLabourSORDtl;
    
  }
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("MaintDpsLbrSORDtlScreen"))
    {
      saveDpsLbrSORInfo(sHeaderPrimaryKey,(DpsLabourSORHeaderBean)oBaseHeaderBean, oDetailBeanArray);
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
      chkRcdToDlt(oBaseHeaderBean,oDetailBeanArray,oList);
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
    DpsLabourSORHeaderBean oDpsLabourSORHeaderBean = (DpsLabourSORHeaderBean)oBaseHeaderBean;      
    Iterator oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        count++;
        DpsLabourSORDtlBean oDpsLabourSORDtlBean = (DpsLabourSORDtlBean)oIt.next(); 
        if(oDpsLabourSORDtlBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlBean.getDetailId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDpsLabourSORHeaderBean.getEffStartDate())));
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
    DpsLabourSORHeaderBean oDpsLabourSORHeaderBean = (DpsLabourSORHeaderBean)oBaseHeaderBean;        
      System.out.println(oDpsLabourSORHeaderBean.getScreenModeSOR1());
      if(oDpsLabourSORHeaderBean.getScreenModeSOR1().equals("N"))    
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
    DpsLabourSORHeaderBean oDpsLabourSORHeaderBean = (DpsLabourSORHeaderBean)oBaseHeaderBean;        
    oParameters = new ArrayList();           
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oDpsLabourSORHeaderBean.getTxtSiteID())); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORHeaderBean.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_SOREffDateCheck(?,?,?,?)");
    
    chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
    if(!chkFlag.equals(new Integer(0)))
    {        
      oList.add(new EnrgiseApplicationException("payroll.Labour.EffDatecheck"));
    }            
    
  } 
  
/*  public DpsLabourSORComboVO getDpsLbrSORComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    DpsLabourSORComboVO oDpsLabourSORComboVO = new DpsLabourSORComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oMiscAllow = null;    
    
    oOutArray = new ArrayList();    
    ArrayList oDpsLbrSrvcList = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsLbrSORServiceLov(?,?)");
      
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
            oDpsLbrSrvcList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String serviceId = oRow.get("norm_id").getString();
          String serviceDesc = oRow.get("norm_desc").getString();
          oComboVO = new ComboVO(serviceDesc,serviceId);
          oDpsLbrSrvcList.add(oComboVO);
        }

      
    // Newly Added 
    oDpsLabourSORComboVO.setValueServiceList(oDpsLbrSrvcList);
    return oDpsLabourSORComboVO;
       
  } */

  
}