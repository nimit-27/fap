package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORDtlInfo;
import java.sql.SQLException;
import java.util.StringTokenizer;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORDtlBean;
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
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORQueryVO;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORDtlBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORHeaderBean;

public class NWNPLbrSORBusinessObject extends BaseBO 
{

  public NWNPLbrSORBusinessObject()
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
  
   public RecordMetaInfo getNWNPLbrSORHeaderMetaInfo(NWNPLabourSORQueryVO oNWNPLabourSORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
     // String locCode = oNWNPLabourSORQueryVO.getLoginLocCode()+"";
     //String locCode = oNWNPLabourSORQueryVO.getTxtLocId();
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORQueryVO.getTxtLocId())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oNWNPLabourSORQueryVO.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetNWNPLbrSORHeaderCount(?,?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getNWNPLbrSORHeader(NWNPLabourSORQueryVO oNWNPLabourSORQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oNWNPLabourSORQueryVO == null)
    {
      oNWNPLabourSORQueryVO = new NWNPLabourSORQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;
      //String locCode = oNWNPLabourSORQueryVO.getLoginLocCode()+"";
       //String locCode = oNWNPLabourSORQueryVO.getTxtLocId()+"";

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORQueryVO.getTxtLocId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oNWNPLabourSORQueryVO.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetNWNPLbrSORHeaderDtl(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      NWNPLabourSORHeaderBean oNWNPLbrSORHeader;
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
          oNWNPLbrSORHeader = new NWNPLabourSORHeaderBean();
        //  oNWNPLbrSORHeader.setTxtRegCode(oRow.get("depot_id").getString());          
         // oNWNPLbrSORHeader.setTxtRegName(oRow.get("Region_name").getString());          
          oNWNPLbrSORHeader.setHeaderPrimaryKey(EnrgiseUtil.convertToString(oRow.get("eff_start_date").getDate()));                                                  
          oNWNPLbrSORHeader.setTxtEndDate(EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate()));
          oNWNPLbrSORHeader.setTxtLocId(oRow.get("depot_id").getString()); 
          oNWNPLbrSORHeader.setTxtLocation(oRow.get("depot_name").getString());                                                  

          oHeaderList.add(oNWNPLbrSORHeader);
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


  private void saveNWNPLbrSORInfo(String sPrimaryKey, NWNPLabourSORHeaderBean oNWNPLabourSORHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
       NWNPLabourSORDtlBean oNWNPLabourSORDtlBean = (NWNPLabourSORDtlBean)oIt.next(); 
       //  PayCodesVsAcctCodesBean oPayCodesVsAcctCodesBean = (PayCodesVsAcctCodesBean)oIt.next();
//        System.out.println(oDpsLabourSORDtlBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oNWNPLabourSORDtlBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_pay_labour.proc_InsertNWNPLbrSORDetail(?,?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getTxtLocId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getDetailId()))); 
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNWNPLabourSORHeaderBean.getEffStartDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtSorRateUpto50())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtSorRateUpto75())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtSorRateabove75())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtBagRateBlw65())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtBagRateAbv65())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtPieceWiseRate())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtBaseYr())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oNWNPLabourSORDtlBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_pay_labour.proc_UpdateNWNPLbrSORDetail(?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getTxtLocId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getDetailId())));     //added by swapnendu on 05 Mar 2011               
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNWNPLabourSORHeaderBean.getEffStartDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtSorRateUpto50())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtSorRateUpto75()))); 
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtSorRateabove75())));          
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtBagRateBlw65())));          
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtBagRateAbv65())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtPieceWiseRate())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getTxtBaseYr())));          
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oNWNPLabourSORDtlBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_pay_labour.proc_DeleteNWNPLbrSORDetail(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getTxtLocId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getDetailId())));     //added by swapnendu on 05 Mar 2011               
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getEffStartDate())));          
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
  
  public RecordMetaInfo getNWNPLbrSORDetailMetaInfo(String sPrimaryKey, String ScreenName, NWNPLabourSORDtlInfo oNWNPLabourSORDtlInfo/*,NWNPLabourSORHeaderBean oNWNPLabourSORHeaderBean*//*,NWNPLabourSORQueryVO oNWNPLabourSORQueryVO*/) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output     
      
      oParameters = new ArrayList();           
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlInfo.getTxtLocId())));       
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetNWNPLbrSORDetailCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getNWNPLbrSORDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, NWNPLabourSORDtlInfo oNWNPLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
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
    NWNPLabourSORDtlBean oNWNPLabourSORDtlBean;
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,String.valueOf(oNWNPLabourSORDtlInfo.getTxtLocId())));       
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetNWNPLbrSORDetail(?,?,?,?,?,?)");
      
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
          oNWNPLabourSORDtlBean = new NWNPLabourSORDtlBean();
          oNWNPLabourSORDtlBean.setDetailId((oRow.get("operation_id").getString()));
          oNWNPLabourSORDtlBean.setTxtOperation((oRow.get("operation_desc").getString()));
          oNWNPLabourSORDtlBean.setTxtSorRateUpto50((oRow.get("sor_rates_upto_50").getString()));
          oNWNPLabourSORDtlBean.setTxtSorRateUpto75((oRow.get("sor_rates_upto_75").getString()));
          oNWNPLabourSORDtlBean.setTxtSorRateabove75((oRow.get("sor_rates_above_75").getString()));
          oNWNPLabourSORDtlBean.setTxtBagRateBlw65((oRow.get("sor_rates_below_65").getString()));
          oNWNPLabourSORDtlBean.setTxtBagRateAbv65((oRow.get("sor_rates_above_65").getString()));
          oNWNPLabourSORDtlBean.setTxtPieceWiseRate((oRow.get("piece_wise_rate").getString()));  
          oNWNPLabourSORDtlBean.setTxtBaseYr((oRow.get("base_yr").getString()));
            
          oNWNPLabourSORDtlBean.setStatus("Q");
 
          oNWNPLabourSORDtl.add(oNWNPLabourSORDtlBean);
        }        
    return oNWNPLabourSORDtl;
    
  }
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("MaintNWNPLbrSORDtlScreen"))
    {
      saveNWNPLbrSORInfo(sHeaderPrimaryKey,(NWNPLabourSORHeaderBean)oBaseHeaderBean, oDetailBeanArray);
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
    NWNPLabourSORHeaderBean oNWNPLabourSORHeaderBean = (NWNPLabourSORHeaderBean)oBaseHeaderBean;      
    Iterator oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        count++;
        NWNPLabourSORDtlBean oNWNPLabourSORDtlBean = (NWNPLabourSORDtlBean)oIt.next(); 
        if(oNWNPLabourSORDtlBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORDtlBean.getDetailId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNWNPLabourSORHeaderBean.getEffStartDate())));
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
    NWNPLabourSORHeaderBean oNWNPLabourSORHeaderBean = (NWNPLabourSORHeaderBean)oBaseHeaderBean;        
      System.out.println(oNWNPLabourSORHeaderBean.getScreenModeSOR1());
      if(oNWNPLabourSORHeaderBean.getScreenModeSOR1().equals("N"))    
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
    NWNPLabourSORHeaderBean oNWNPLabourSORHeaderBean = (NWNPLabourSORHeaderBean)oBaseHeaderBean;        
    oParameters = new ArrayList();           
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLabourSORHeaderBean.getTxtSiteID())); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourSORHeaderBean.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_SOREffDateCheck(?,?,?,?)");
    
    chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
    if(!chkFlag.equals(new Integer(0)))
    {        
      oList.add(new EnrgiseApplicationException("payroll.Labour.EffDatecheck"));
    }            
    
  }

  public LovVO getNWNPLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location Id");    
    arylstHeaderNames.add("Location Name");        
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
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getnwnpdepotlov(?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("loc_id").getString());                   
       oLOVBean.setDetailField2(oRow.get("loc_desc").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }  
    
    public LovVO getNWNPOprLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    
      LovVO oLovVO=new LovVO();  
      ArrayList arylstHeaderNames=new ArrayList();
      arylstHeaderNames.add("Operation Id");    
      arylstHeaderNames.add("Operation Desc");        
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
        //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
        //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
        //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
        oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getnwnpoperationlov(?,?)");
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
        
         oLOVBean.setDetailField1(oRow.get("Operation_id").getString());                   
         oLOVBean.setDetailField2(oRow.get("Operation_desc").getString());            
        
        oList.add(oLOVBean);
      }
       
        oLovVO.setDetailList(oList);
      return oLovVO;
    }
    
}