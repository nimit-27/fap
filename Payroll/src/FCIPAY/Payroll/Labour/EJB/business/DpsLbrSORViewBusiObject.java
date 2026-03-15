package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORViewQryVO;
import java.sql.SQLException;
import java.util.StringTokenizer;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORViewBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORViewHeaderBean;
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

public class DpsLbrSORViewBusiObject extends BaseBO 
{

  public DpsLbrSORViewBusiObject()
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
  
   public RecordMetaInfo getSORViewHeaderMetaInfo(DpsLabourSORViewQryVO oDpsLabourSORViewQryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oDpsLabourSORViewQryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDpsLabourSORViewQryVO.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsSORViewHeaderCount(?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getSORViewHeader(DpsLabourSORViewQryVO oDpsLabourSORViewQryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oDpsLabourSORViewQryVO == null)
    {
      oDpsLabourSORViewQryVO = new DpsLabourSORViewQryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;
      String locCode = oDpsLabourSORViewQryVO.getLoginLocCode()+"";

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oDpsLabourSORViewQryVO.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsSORViewHeaderDtl(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      DpsLabourSORViewHeaderBean oDpsLbrSORHeader;
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
          oDpsLbrSORHeader = new DpsLabourSORViewHeaderBean();
          oDpsLbrSORHeader.setHeaderPrimaryKey(oRow.get("loc_id").getString());          
          oDpsLbrSORHeader.setTxtRegName(oRow.get("loc_desc").getString());          
          //oDpsLbrSORHeader.setHeaderPrimaryKey(EnrgiseUtil.convertToString(oRow.get("eff_start_date").getDate()));           
          
          oHeaderList.add(oDpsLbrSORHeader);
      }             
    return oHeaderList;
  } 
  
  public RecordMetaInfo getDpsLbrSORViewMetaInfo(String sPrimaryKey, String ScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output     
      
      oParameters = new ArrayList();           
      //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlInfo.getTxtRegCode())));       
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsLbrSORViewDtlCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getDpsLbrSORViewDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
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
    DpsLabourSORViewBean oDpsLabourSORViewBean;
   
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDpsLabourSORDtlInfo.getTxtRegCode())));       
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetDpsLbrSORViewDtl(?,?,?,?,?)");
      
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
          oDpsLabourSORViewBean = new DpsLabourSORViewBean();
          //oDpsLabourSORViewBean.setTxtLocCode((oRow.get("pay_code").getString()));          
          //oDpsLabourSORViewBean.setTxtEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate())); 
          oDpsLabourSORViewBean.setPrevOperation((oRow.get("operation_id").getString()));
          oDpsLabourSORViewBean.setPrevOperDesc((oRow.get("operation_desc").getString()));
          oDpsLabourSORViewBean.setPrevBagRateAbv65((oRow.get("pre_abv_rate").getString()));
          oDpsLabourSORViewBean.setPrevBagRateBlw65((oRow.get("pre_blow_rate").getString()));
          oDpsLabourSORViewBean.setCurBagRateAbv65((oRow.get("current_abv_rate").getString()));
          oDpsLabourSORViewBean.setCurBagRateBlw65((oRow.get("curr_blow_rate").getString()));
          //oDpsLabourSORViewBean.setTxtEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate())); 
          oDpsLabourSORViewBean.setStatus("Q");
 
          oDpsLabourSORDtl.add(oDpsLabourSORViewBean);
        }        
    return oDpsLabourSORDtl;
    
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

  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("MaintDpsLbrSORDtlScreen"))
    {
      //saveDpsLbrSORInfo(sHeaderPrimaryKey,(DpsLabourSORViewBean)oBaseHeaderBean, oDetailBeanArray);
    }    
  }   
  
  private void saveDARates(String sPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,sScreenMode,oDetailBeanArray);
    }
  }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
        
  }
}