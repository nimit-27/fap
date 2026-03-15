package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpAddressQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.EmpAddressHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class EmpAddressBusinessObject extends BaseBO 
{

  public EmpAddressBusinessObject()
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sTabNum; 
    String sPayModeType;
    int count = 0;
    EmpAddressHeaderBean oEmpAddressHeaderBean = (EmpAddressHeaderBean)oBaseHeaderBean;
    
    ArrayList oOutArray; //Output 
    ArrayList oAddOutArray; //Output 

    //sTabNum = oEmpFinInfoHeaderBean.HdnTabVal();  
      oParameters = new ArrayList();     
      oAddressParam = new ArrayList();     
  
      // Employee Address Info                  
      oAddressParam.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getHeaderPrimaryKey())));
      //oAddressParam.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAddType())));
      oAddressParam.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermAddL1())));
      oAddressParam.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermAddL2())));
      oAddressParam.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermPin())));
      oAddressParam.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermCity())));
      oAddressParam.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermState())));
      oAddressParam.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermCountry())));      
      oAddressParam.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempAddL1())));
      oAddressParam.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempAddL2())));
      oAddressParam.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempPin())));
      oAddressParam.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempCity())));
      oAddressParam.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempState())));
      oAddressParam.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempCountry())));      
      
      oAddressParam.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtUserID())));
      oAddressParam.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtSiteID())));    
      oAddressParam.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));
      oAddOutArray = oBean.callProc(oAddressParam,"PAYROLL_PKG.proc_CheckEmpAddrDtl_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
      
      DBObject oOutObject = (DBObject)oAddOutArray.get(0);
      //return (String)oOutObject.getObject(); 
      
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    EmpAddressHeaderBean oEmpAddressHeaderBean = (EmpAddressHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output  
    
      // Employee Address Info                  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getHeaderPrimaryKey())));
      //oAddressParam.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAddType())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermAddL1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermAddL2())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermPin())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermCity())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermState())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtPermCountry())));      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempAddL1())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempAddL2())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempPin())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempCity())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempState())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtTempCountry())));      
      
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressHeaderBean.getTxtSiteID())));    
      oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CheckEmpAddrDtl_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");   
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
    //  return (String)oOutObject.getObject(); 
    return oEmpAddressHeaderBean.getHeaderPrimaryKey();
      
  }


  public RecordMetaInfo getEmpAddressHeaderMetaInfo(EmpAddressQueryVO oEmpAddressQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressQueryVO.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpAddressQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpAddressDtlCount(?,?,?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getEmpAddressHeader(EmpAddressQueryVO oEmpAddressQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpAddressQueryVO == null)
    {
      oEmpAddressQueryVO = new EmpAddressQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null; 
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressQueryVO.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpAddressQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpAddressQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    //Changed pkg name dt 16 Jul 2008 
    oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetEmpAddressDetail(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    EmpAddressHeaderBean oEmpFinInfoHeaderBean;
    count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oHeaderList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oEmpFinInfoHeaderBean = new EmpAddressHeaderBean();
        
        // Employee Address Tab Fields 
        oEmpFinInfoHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpFinInfoHeaderBean.setTxtEmpName(oRow.get("Name").getString());
        oEmpFinInfoHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oEmpFinInfoHeaderBean.setTxtCateg(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpFinInfoHeaderBean.setTxtEmpType(oRow.get("EMP_TYPE_DESC").getString());
        oEmpFinInfoHeaderBean.setTxtStaffCode(oRow.get("STAFF_CODE").getString());
        oEmpFinInfoHeaderBean.setTxtPresentPOP(oRow.get("loc_desc").getString());
        oEmpFinInfoHeaderBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());
        oEmpFinInfoHeaderBean.setTxtDojFCI(EnrgiseUtil.convertToString(oRow.get("COMP_JOINING_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtDOJSite(EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        
        oEmpFinInfoHeaderBean.setTxtAddId(oRow.get("ADDRESS_ID").getString());  
        oEmpFinInfoHeaderBean.setTxtPermAddL1(oRow.get("PERM_ADD_L1").getString());
        oEmpFinInfoHeaderBean.setTxtPermAddL2(oRow.get("PERM_ADD_L2").getString());
        oEmpFinInfoHeaderBean.setTxtPermPin(oRow.get("PERM_PIN").getString());
        oEmpFinInfoHeaderBean.setTxtPermCity(oRow.get("PERM_CITY").getString());          
        oEmpFinInfoHeaderBean.setTxtPermState(oRow.get("PERM_STATE").getString());          
        oEmpFinInfoHeaderBean.setTxtPermStateDesc(oRow.get("PERM_STATE_DESC").getString());          
        oEmpFinInfoHeaderBean.setTxtPermCountry(oRow.get("PERM_COUNTRY").getString());                    
        oEmpFinInfoHeaderBean.setTxtTempAddL1(oRow.get("PRES_ADD_L1").getString());
        oEmpFinInfoHeaderBean.setTxtTempAddL2(oRow.get("PRES_ADD_L2").getString());          
        oEmpFinInfoHeaderBean.setTxtTempPin(oRow.get("PRES_PIN").getString());          
        oEmpFinInfoHeaderBean.setTxtTempCity(oRow.get("PRES_CITY").getString());
        oEmpFinInfoHeaderBean.setTxtTempState(oRow.get("PRES_STATE").getString());          
        oEmpFinInfoHeaderBean.setTxtTempStateDesc(oRow.get("PRES_STATE_DESC").getString());          
        oEmpFinInfoHeaderBean.setTxtTempCountry(oRow.get("PRES_COUNTRY").getString());
        
        oHeaderList.add(oEmpFinInfoHeaderBean);
      }    
      
    return oHeaderList;
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }  
   
  public LovVO getEmpFinInfoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");      
    arylstHeaderNames.add("CPf Code");    
    //arylstHeaderNames.add("Group");    
    //arylstHeaderNames.add("Category");  
    //arylstHeaderNames.add("Designation");  

    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);           

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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));  
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));  
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));      
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinLOV(?,?,?,?)");
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinLOV_new(?,?,?,?,?,?,?)");
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
     oLOVBean.setDetailField2(oRow.get("emp_name").getString());             
     oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());          
     /*oLOVBean.setDetailField3(oRow.get("emp_grp").getString());            
     oLOVBean.setDetailField4(oRow.get("emp_categ_id").getString());            
     oLOVBean.setDetailField5(oRow.get("emp_dsgn_id").getString());      
     oLOVBean.setDetailField6(oRow.get("EMP_HNDP_CATEG").getString());      
     oLOVBean.setDetailField7(oRow.get("EMP_5TH_PAY_BASIC").getString());             
     oLOVBean.setDetailField8(EnrgiseUtil.convertToString(oRow.get("emp_prom_cruc_dt").getDate()));       
     oLOVBean.setDetailField9(oRow.get("INCR_MONTH").getString());               */             
     oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bHeaderDataChanged)
    {
  //    checkMandatoryDetail(oBaseHeaderBean,sScreenMode);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
 
  public LovVO getEmpMastStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("State Code");  
    arylstHeaderNames.add("State Description");  
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
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));            
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetStateCodeApps(?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("Lookup_code").getString());                   
      oLOVBean.setDetailField2(oRow.get("Meaning").getString());                   
      oList.add(oLOVBean);
    }     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }    
}