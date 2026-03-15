package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpReinstateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpReinstateComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintEmpReinstateBean;
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


public class EmpReinstateBusinessObject extends BaseBO 
{

  public EmpReinstateBusinessObject()
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
    /*ArrayList oParameters = new ArrayList(); //Input Parameters    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
     */
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    MaintEmpReinstateBean oEmpReinstateBean = (MaintEmpReinstateBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    
      oParameters = new ArrayList();     
      /*Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpReinstateBean.getReinstEffDate())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateBean.getReinstReason())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateBean.getIntervngPrd())));            
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateBean.getTxtUserID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateBean.getTxtSiteID()))); 
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpReinstateBean.getTxtEmpNo())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));     
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertEmpReinstDetail(?,?,?,?,?,?,?,?)",true,true);        
  
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();      
  }


  public RecordMetaInfo getEmpReinstHeaderMetaInfo(EmpReinstateQueryVO oEmpReinstateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oEmpReinstateQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateQueryVO.getHeaderPrimaryKey()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateQueryVO.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpReinstDetailCount(?,?,?,?,?,?)",true,true);
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getEmpReinstHeader(EmpReinstateQueryVO oEmpReinstateQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpReinstateQueryVO == null)
    {
      oEmpReinstateQueryVO = new EmpReinstateQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String locCode = oEmpReinstateQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateQueryVO.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpReinstateQueryVO.getHdnEmpLbrFlag())));           
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpReinstDetail(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpReinstateBean oEmpReinstateBean;
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
        oEmpReinstateBean = new MaintEmpReinstateBean();
        oEmpReinstateBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpReinstateBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpReinstateBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        //oEmpReinstateBean.setTxtDsgnDesc(oRow.get("DESIGNATION_ID").getString());
        oEmpReinstateBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        //oEmpReinstateBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());        
        oEmpReinstateBean.setTxtEmpType(oRow.get("emp_type_desc").getString());                
        oEmpReinstateBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpReinstateBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString());        
        //oEmpReinstateBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
        oEmpReinstateBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oEmpReinstateBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());                  
        
        oEmpReinstateBean.setReinstId(oRow.get("REINSTATE_ID").getString());                  
        oEmpReinstateBean.setReinstEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("REINSTATE_EFF_DT").getDate()));        
        oEmpReinstateBean.setReinstReason(oRow.get("REINSTATE_REASON").getString());  
        oEmpReinstateBean.setIntervngPrd(oRow.get("INTERVENING_PRD").getString());                  
        
        oHeaderList.add(oEmpReinstateBean);
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
  
  private ArrayList getEmpFinComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList();
    ArrayList oOutArray;
    //EmpFinanceComboVO oEmpFin=null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    QueryRow oRow = null;    
    int count = 0;
    
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,sProc);
    
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
        
    count = 0;
    oIt = oList.iterator();
    ArrayList oValueList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oValueList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();        
        String fieldId = ((oRow.get(sField_id).getString()));
        String fieldDesc= ((oRow.get(sField_desc).getString()));
        ComboVO oComboVO = new ComboVO(fieldDesc,fieldId);
        oValueList.add(oComboVO);    
    }
    return oValueList;
  }     

  public EmpReinstateComboVO getEmpReinstComboDet()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpReinstateComboVO oEmpReinstVO=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
    oEmpReinstVO = new EmpReinstateComboVO();          
    
    ArrayList oIntrvngPrdList = new ArrayList();
    oIntrvngPrdList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_GetIntervngPrdLov(?,?)","code_sdesc","code_desc");
    oEmpReinstVO.setIntervPrdList(oIntrvngPrdList);
    
    return oEmpReinstVO;
  } 
 
  
  public LovVO getEmpReinstLOVN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ FCI");  
        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));      
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpReinstLOVN(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField5(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField7(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField8(oRow.get("EMP_STATUS_DESC").getString());          
        oLOVBean.setDetailField9(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));                        
                 
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  
  
  public LovVO getEmpReinstLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ FCI");  
        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));  
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpReinstLOVQ(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField5(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField7(oRow.get("LOC_DESC").getString());          
        oLOVBean.setDetailField8(oRow.get("EMP_STATUS_DESC").getString());  
        oLOVBean.setDetailField9(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));                       
        
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
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
    MaintEmpReinstateBean oMaintEmpReinstateBean=(MaintEmpReinstateBean)oBaseHeaderBean;
    checkMaxPayYear(oMaintEmpReinstateBean.getTxtSiteID(),oMaintEmpReinstateBean.getHdnEmpLbrFlag());
    checkReinstateStatus(oMaintEmpReinstateBean.getTxtEmpNo(),oMaintEmpReinstateBean.getReinstEffDate(),oMaintEmpReinstateBean.getReinstReason(),oMaintEmpReinstateBean.getIntervngPrd(),oMaintEmpReinstateBean.getHdnEmpLbrFlag(),oMaintEmpReinstateBean.getTxtSiteID());
    reportError(oList);        
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
  //added by nand on 13 Sep 2013 for checking reinstate while saving
  private void checkReinstateStatus(String txtEmpNo,String reinstEffDate,String reinstReason,String intervngPrd,String hdnEmpLbrFlag,String siteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    String oRetList = null;
    Iterator oIt = null;
    int iRes=0;
    //String sRevYear="";
    //String status ="";

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,txtEmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(reinstEffDate)));     
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,reinstReason));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,intervngPrd));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));    
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.Emp_Reinstate_Chk(?,?,?,?,?,?,?,?)",true,true);
    oRetList = (String)((DBObject)oOutArray.get(0)).getObject();
    Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
    //oIt = oRetList.iterator();
    if (!errCode.equals(new Integer(0)))
    {
    throw new EnrgiseApplicationException("payroll.Common.ReinstateCheck");
    }
    //DBObject oOutObject = (DBObject)oOutArray.get(0);
   // System.out.println("Error!!! while inserting Reinstate Details ::"+errCode);
    //return (String)oOutObject.getObject();  
  } 
}