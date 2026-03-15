package FCIPAY.Payroll.Labour.EJB.business;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourMinWageQueryVO;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourMinWageQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourMinWageHeaderBean;
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
import java.util.Date;


public class NWNPLbrMinWageBusinessObject extends BaseBO 
{

  public NWNPLbrMinWageBusinessObject()
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sTabNum; 
    String sPayModeType;
    int count = 0;
    NWNPLabourMinWageHeaderBean oNWNPLabourMinWageHeaderBean = (NWNPLabourMinWageHeaderBean)oBaseHeaderBean;
    
    ArrayList oOutArray; //Output 
        
      oParameters = new ArrayList();     
    
      
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    NWNPLabourMinWageHeaderBean oNWNPLabourMinWageHeaderBean = (NWNPLabourMinWageHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output  
    
      oParameters = new ArrayList();   
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oNWNPLabourMinWageHeaderBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourMinWageHeaderBean.getTxtPieceRate())));    
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourMinWageHeaderBean.getTxtVDA())));        
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourMinWageHeaderBean.getTxtCityType())));  // added by dushyant on 19-April-2011
       
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourMinWageHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourMinWageHeaderBean.getTxtSiteID())));      
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.TIMESTAMP));      
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_InsertNWNPLbrMinWageDtl(?,?,?,?,?,?,?,?)");        
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String vPrmKey = EnrgiseUtil.convertToString((Date)oOutObject.getObject());
      
      return vPrmKey; 
      
  }


  public RecordMetaInfo getNWNPLbrMinWageHeaderMetaInfo(NWNPLabourMinWageQueryVO oNWNPLabourMinWageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oNWNPLabourMinWageQueryVO.getLoginLocCode()+"";

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oNWNPLabourMinWageQueryVO.getHeaderPrimaryKey()))); 
    //oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));    
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetNWNPLbrMinWageCount(?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getNWNPLbrMinWageHeader(NWNPLabourMinWageQueryVO oNWNPLabourMinWageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    //String sSiteId = oNWNPLabourASORQueryVO.getTxtEmpLastName()+"";
    int count = 0;

    if(oNWNPLabourMinWageQueryVO == null)
    {
      oNWNPLabourMinWageQueryVO = new NWNPLabourMinWageQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    //String locCode = oNWNPLabourASORQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oNWNPLabourMinWageQueryVO.getHeaderPrimaryKey())));    
    
    //oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetNWNPLbrMinWageDetail(?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    NWNPLabourMinWageHeaderBean oNWNPLabourMinWageHeaderBean;
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
        oNWNPLabourMinWageHeaderBean = new NWNPLabourMinWageHeaderBean();

        oNWNPLabourMinWageHeaderBean.setHeaderPrimaryKey(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_start_date").getDate())); 
        oNWNPLabourMinWageHeaderBean.setTxtEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_end_date").getDate())); 
        oNWNPLabourMinWageHeaderBean.setTxtPieceRate(oRow.get("basic_wage").getString());
        oNWNPLabourMinWageHeaderBean.setTxtCityType(oRow.get("loc_type").getString());  // added by dushyant on 19-April-2011
        oNWNPLabourMinWageHeaderBean.setTxtVDA(oRow.get("vda").getString()); 
        oHeaderList.add(oNWNPLabourMinWageHeaderBean);
      }    
      
    return oHeaderList;
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("DaRatesScreen"))
    {
      saveDARates(sHeaderPrimaryKey,oDetailBeanArray);
    }    
  }   
  
  private void saveDARates(String sPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bHeaderDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,sScreenMode);
    }
  }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oList = new ArrayList();    

      if(sScreenName.equals(EnrgiseConstants.NEW_MODE))
      {
          checkEffdate(oBaseHeaderBean,oList);                  
      }      
    reportError(oList);        
  }  

  private void checkEffdate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    NWNPLabourMinWageHeaderBean oNWNPLabourMinWageHeaderBean = (NWNPLabourMinWageHeaderBean)oBaseHeaderBean;       
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourMinWageHeaderBean.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLabourMinWageHeaderBean.getTxtCityType()))); 
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_MinWageEffDateCheck_nwnp(?,?,?,?)");
    
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oRetList.size() > 0)
    {        
      oList.add(new EnrgiseApplicationException("payroll.Labour.EffDatecheck"));
    }            
  }


   
}
