package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomDetailInfo;
import java.sql.SQLException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.LeaseAccomHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.UTILITY.LeaseAccomBean;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomComboVO;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class LeaseAccomBusinessObject  extends BaseBO
{
  public LeaseAccomBusinessObject()
  {
  }

  public RecordMetaInfo getLeaseAccomHeaderInfo(LeaseAccomQueryVO oLeaseAccomQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaseAccomQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.prog_GetLeaseAccomCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getLeaseAccomHeader(LeaseAccomQueryVO oLeaseAccomQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    QueryRow oRow = null;
    Iterator oIt = null;
    
    int count = 0;

    if(oLeaseAccomQueryVO == null)
    {
      oLeaseAccomQueryVO = new LeaseAccomQueryVO();
    }
    
     ArrayList oOutArray; //Output 
     ArrayList oHeaderList = null;    

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaseAccomQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetLeaseAccomHdr(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      LeaseAccomHeaderBean oLeaseAccomHeader;
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
          oLeaseAccomHeader = new LeaseAccomHeaderBean();
          oLeaseAccomHeader.setTxtEmpNo(oRow.get("emp_num").getString());
          oLeaseAccomHeader.setTxtEmpName(oRow.get("emp_chq_name").getString());
          oHeaderList.add(oLeaseAccomHeader);
      }              
    return oHeaderList;
  }


 public RecordMetaInfo getLeaseAccomDetailMetaInfo(String sPrimaryKey,LeaseAccomDetailInfo oLeaseAccomDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

       String sEMPNO;
      sEMPNO = oLeaseAccomDetailInfo.getTxtEmpNo();      
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sEMPNO));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetLeaseAccomDtlCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
 public ArrayList getLeaseAccomDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LeaseAccomDetailInfo oLeaseAccomDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LeaseAccomBean oLeaseAccomBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oLeaseAccomDtl = null;

      String sEMPNO;
      sEMPNO = oLeaseAccomDetailInfo.getTxtEmpNo();
        
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sEMPNO));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetLeaseAccomDetail(?,?,?,?,?)");
      
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
            oLeaseAccomDtl = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLeaseAccomBean = new LeaseAccomBean(); 
          oLeaseAccomBean.setTxtAccomTyp((oRow.get("accom_type").getString()));
          oLeaseAccomBean.setTxtHraAmt((oRow.get("hra_amt").getString()));
          oLeaseAccomBean.setTxtLicenseFee((oRow.get("licence_fee_dem").getString()));
          oLeaseAccomBean.setTxtLeaseAmt((oRow.get("lease_amt").getString()));
          oLeaseAccomBean.setTxtLeasePerc((oRow.get("population").getString()));
          oLeaseAccomBean.setTxtFromDate(EnrgiseUtil.convertToString(oRow.get("from_date").getDate()));
          oLeaseAccomBean.setTxtToDate(EnrgiseUtil.convertToString(oRow.get("to_date").getDate()));         
          //oLeaseAccomBean.setTxtArrearInst((oRow.get("no_of_instl").getString()));
          oLeaseAccomBean.setDetailId((oRow.get("srl_no").getString()));         
          //  added by varalika on 30-Sep-2011
         DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");    
          oLeaseAccomBean.setTxtCreationDate(formatter.format(oRow.get("created_time_stamp").getDate()));
          oLeaseAccomBean.setTxtCreatedBy(oRow.get("user_id_created").getString());
          oLeaseAccomBean.setTxtCreatedSite(oRow.get("created_site_id").getString());
          if(oRow.get("modified_time_stamp").getDate() != null && !"".equals(oRow.get("modified_time_stamp").getDate()))
          {
          oLeaseAccomBean.setTxtUpdationDate(formatter.format(oRow.get("modified_time_stamp").getDate()));
          }
          if(oRow.get("user_id_modified").getString() != null && !"".equals(oRow.get("user_id_modified").getString()))
          {
          oLeaseAccomBean.setTxtUpdatedBy(oRow.get("user_id_modified").getString());
          }
           if(oRow.get("modified_site_id").getString() != null && !"".equals(oRow.get("modified_site_id").getString()))
          {
          oLeaseAccomBean.setTxtUpdatedSite(oRow.get("modified_site_id").getString());
          }
          //  ended by varalika
          oLeaseAccomBean.setStatus("Q");
          oLeaseAccomDtl.add(oLeaseAccomBean);
        }             
        return oLeaseAccomDtl; 
  }    


  public boolean saveLeaseAccomHeader(LeaseAccomHeaderBean oLeaseAccomHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   /* ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPayScaleDtlIDABean oPayScaleDtlBean;
    BaseDetailVO oBaseDetailVO = null;
          
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oPayScaleHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getTxtRevYYMM()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getLstPayScale()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getLstPayScale()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_SaveGlobalCodeHeader(?,?,?,?)");
  */
      return true;
  }
  

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    /* ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     ArrayList oList;
     int count = 0;
     PayScaleHeaderBean oPayScaleHeaderBean = (PayScaleHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_InsertGlobalCode(?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0); 
      return (String)oOutObject.getObject();*/
   return null ;  
  }  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
  /*  ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    PayScaleHeaderBean oPayScaleHeaderBean = (PayScaleHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_UpdateGlobalCode(?,?,?,?)");    
*/
  }  

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    
  if(sScreenName.equals("LeaseAccomScreen"))
    {
        saveLeaseAccom(sHeaderPrimaryKey,oDetailBeanArray,(LeaseAccomHeaderBean)oBaseHeaderBean);
    }
  }   
  
 private void saveLeaseAccom(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,LeaseAccomHeaderBean oLeaseAccomHeaderBean) throws EnrgiseSystemException
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
        LeaseAccomBean oLeaseAccomBean = (LeaseAccomBean)oIt.next();
//        System.out.println(oLeaseAccomBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oLeaseAccomBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG_EXT.proc_InsertLeaseAccomDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtAccomTyp()));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtHraAmt()));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtLicenseFee()));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtLeaseAmt()));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtLeasePerc())); //added by Swapnendu Dt 10 Jan 2012
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaseAccomBean.getTxtFromDate())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaseAccomBean.getTxtToDate())));          
          //oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtArrearInst()));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
       else if(oLeaseAccomBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG_EXT.proc_UpdateLeaseAccomDetail(?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtAccomTyp()));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtHraAmt()));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtLicenseFee()));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtLeaseAmt()));          
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtLeasePerc())); //added by Swapnendu Dt 10 Jan 2012
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaseAccomBean.getTxtFromDate())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaseAccomBean.getTxtToDate())));          
          //oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,oLeaseAccomBean.getTxtArrearInst()));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomBean.getDetailId())));                    
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtSiteID())));
        
          oBean.addToBatch(oParameters);
          
        }
     else if(oLeaseAccomBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG_EXT.proc_DeleteLeaseAccomDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomBean.getDetailId())));          
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
          throw new EnrgiseSystemException();
      }
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


 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    LeaseAccomHeaderBean oLeaseAccomHeaderBean = (LeaseAccomHeaderBean)oBaseHeaderBean;
    checkMaxPayYear(oLeaseAccomHeaderBean.getTxtSiteID(),oLeaseAccomHeaderBean.getHdnEmpLbrFlag());
    reportError(oList);
    checkLicFeeAccom(oBaseHeaderBean,oDetailBeanArray,oList);
    checkDuplicacy(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList);    
  }

 private void checkLicFeeAccom(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    LeaseAccomHeaderBean  oLeaseAccomHeaderBean  = (LeaseAccomHeaderBean)oBaseHeaderBean;
    String sDetailId="";
    String sFromDt="";
    String sToDt="";
    String recList="";
    boolean updateRec=false;
    boolean newRec=false;

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_LeaseAccomDuplicateCheck(?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
 
    Iterator iter = oRetList.iterator();
    while(iter.hasNext())
    {
      oRow = (QueryRow)iter.next();
      sDetailId=oRow.get("hra_dtl_id").getString();
      sFromDt=EnrgiseUtil.convertToString(oRow.get("eff_start_date").getDate());
      sToDt=EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate());
    }
    
    oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        LeaseAccomBean oLeaseAccomBean = (LeaseAccomBean)oIt.next();
        if(!oLeaseAccomBean.getStatus().equals("D"))
          count++;
        if(oLeaseAccomBean.getStatus().equals("U") && !oLeaseAccomBean.getDetailId().equals(sDetailId))
        {
            recList+=count+",";
        }
        else if(oLeaseAccomBean.getStatus().equals("U"))
        {
          updateRec=true;
        }
        if(oLeaseAccomBean.getStatus().equals("N"))
        {
          String effDate=oLeaseAccomBean.getTxtFromDate();
          int res=EnrgiseUtil.compareDates(null,effDate,sToDt);
          if(sToDt.equals(""))
          {
            
          }
          else
          {
          if(res<=0 )
          {
            oList.add(new EnrgiseApplicationException("Payroll.LeaseAccom.EffDate.Error"));
          }
          }
          
          
          
          newRec=true;
        }
    }
    if(newRec && updateRec)
    {
      ArrayList oArguments=new ArrayList();
      oArguments.add(recList);
      oList.add(new EnrgiseApplicationException("Payroll.LeaseAccom.Update.Error",oArguments));
    }else if(!recList.equals(""))
    {
      ArrayList oArguments=new ArrayList();
      oArguments.add(recList);
      oList.add(new EnrgiseApplicationException("Payroll.LeaseAccom.Update.Error",oArguments));
    }
  }

 private void checkDuplicacy(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;
    LeaseAccomHeaderBean  oLeaseAccomHeaderBean  = (LeaseAccomHeaderBean)oBaseHeaderBean;
    Integer chkFlag=new Integer(0);
    String errMsg="";
    
    oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        LeaseAccomBean oLeaseAccomBean = (LeaseAccomBean)oIt.next();
        if(!oLeaseAccomBean.getStatus().equals("D"))
          count++;
        if(oLeaseAccomBean.getStatus().equals("N"))
        {
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaseAccomHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaseAccomBean.getTxtFromDate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaseAccomBean.getTxtToDate())));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_VerifyLeaseAccomDtls(?,?,?,?,?,?)");
          chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
          errMsg=(String)((DBObject)oOutArray.get(1)).getObject();
          if(!chkFlag.equals(new Integer(0)))
          {
            ArrayList oArguments=new ArrayList();
            oArguments.add(errMsg);
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
          }
        }
    }
  }

public LovVO getLeaseAccomEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    arylstHeaderNames.add("CPf Code"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE); 
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);

    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField3();
    String cpfCode=oLovQueryVO.getSearchField2();
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, Name));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, cpfCode));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteId")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetLeaseAccomEmpLovQ(?,?,?,?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("emp_no").getString());            
      oLOVBean.setDetailField2(oRow.get("empName").getString());           
      oLOVBean.setDetailField3(oRow.get("cpf_code").getString());   
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }



public LovVO getLeaseAccomEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName");  
    arylstHeaderNames.add("Cpf Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE); 
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    
    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField3();
    String cpfCode=oLovQueryVO.getSearchField2();

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, Name));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, cpfCode));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteId")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetLeaseAccomEmpLovN(?,?,?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("emp_no").getString());            
      oLOVBean.setDetailField2(oRow.get("empName").getString()); 
      oLOVBean.setDetailField3(oRow.get("cpf_code").getString()); 
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LeaseAccomComboVO getLeaseAccomComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output    
    LeaseAccomComboVO oLeaseAccomComboVO = new LeaseAccomComboVO();
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
        
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetAccomTypeLOV(?,?)");
    
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    count = 0;
    oIt = oList.iterator();
    ArrayList oAccomTypList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
          oAccomTypList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        //oEmpFin = new EmpFinanceComboVO();
        String sValue = ((oRow.get("gbl_code").getString()));
        String sLabel= ((oRow.get("code_desc").getString()));
        ComboVO oComboVO = new ComboVO(sLabel,sValue);
        oAccomTypList.add(oComboVO);
    }         
        
    oLeaseAccomComboVO.setAccomTypList(oAccomTypList);      
    
    //creating combo for Lease Accomodation Percentge by swapnendu Dt 10 jan 2012.
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_getLeaseAccmPerc(?,?)");
    
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    count = 0;
    oIt = oList.iterator();
    ArrayList oAccomPerList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
          oAccomPerList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String sValue = ((oRow.get("gbl_code").getString()));
        String sLabel= ((oRow.get("code_desc").getString()));
        ComboVO oComboVO = new ComboVO(sLabel,sValue);
        oAccomPerList.add(oComboVO);
        oComboVO = null;
        oRow = null;
    }         
    oLeaseAccomComboVO.setAccomPerList(oAccomPerList);      
    
    return oLeaseAccomComboVO;
  }

  private String checkMaxPayYear(String siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    int iRes=0;
    String sRevYear="";
    String status ="";

    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = oRow.get("arc_flag").getString(); 
    }    
    
   // int iStat=Integer.parseInt(status);
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    
    return "";
  }
  
  public ArrayList getLeaseAccArrInst(String sEmpNo,String sEmpFlg, String startDate, String endDate,long siteId,long userId)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oResult = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
    Timestamp oWhenPicked = null;    
    int count = 0;        
    Long userLoc = new Long(siteId);
    Long oUserId = new Long(userId);
    
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sEmpNo)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sEmpFlg)));    
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(startDate)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(endDate)));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserId.toString())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(userLoc.toString())));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));            
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));   
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));            
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));       
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.Proc_GetLeaseFlag(?,?,?,?,?,?,?,?,?,?)",true,true);                
    
    String arrFlag;
    Integer arrInstal = new Integer(0);      
    
    DBObject oErrObject = (DBObject)oOutArray.get(3);    
    Integer errorCode = (Integer)oErrObject.getObject();
    
    if((errorCode.equals(new Integer(0))))
    {               
      arrFlag = (String)((DBObject)oOutArray.get(0)).getObject();        
      arrInstal = (Integer)((DBObject)oOutArray.get(1)).getObject();
    }
    else
    {
      arrFlag = "";        
    }   
    
    oResult.add(arrFlag);            
    oResult.add(arrInstal.toString());            
    return oResult;      
  } 
  
}