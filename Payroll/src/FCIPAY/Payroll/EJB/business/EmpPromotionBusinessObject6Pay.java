package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPromotionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPromotionComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintEmpPromotionBean6Pay;
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

public class EmpPromotionBusinessObject6Pay extends BaseBO 
{

  public EmpPromotionBusinessObject6Pay()
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
    MaintEmpPromotionBean6Pay oEmpPromotionBean = (MaintEmpPromotionBean6Pay)oBaseHeaderBean;
    
    ArrayList oOutArray; //Output 
    ArrayList oAddOutArray; //Output   
    
      oParameters = new ArrayList();     
    
     
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    MaintEmpPromotionBean6Pay oEmpPromotionBean = (MaintEmpPromotionBean6Pay)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    
      oParameters = new ArrayList();     
      /*Employee Header Info */   
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getPromType())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getNewDsgnDesc())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getNewBasic())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getNewPerPayHighQual())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getNewPerPayFutIncr())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getNewStagInc())));            
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpPromotionBean.getNewPromEffDate())));      
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpPromotionBean.getAdhcPromEndDate())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getRemarks()))); 
      
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtDsgnDesc())));     
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getNewCateg())));     
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtCurtBasic())));     
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getPayScaleCode())));           
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtStagInc())));     
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtPerPayHighQual())));     
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getPerPayFutureIncr())));     
       
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtUserID())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtSiteID()))); 
      oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtEmpNo())));
      oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.INTEGER));      

      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertEmpPromDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");        
  
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();      
  }

  public RecordMetaInfo getPromotionHeaderMetaInfo(EmpPromotionQueryVO oEmpPromotionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String screenName=oEmpPromotionQueryVO.getScreenName();
    String locCode = oEmpPromotionQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    
    if (screenName.equals("MaintEmpPromotionScreen6Pay")) 
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHdnEmpLbrFlag())));        
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpPromDetailCount(?,?,?,?,?,?)");
    }
    else
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHeaderPrimaryKey())));        
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHdnEmpLbrFlag())));        
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpSelectGrDetailCount(?,?,?,?,?,?)");
    }
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getPromotionHeader(EmpPromotionQueryVO oEmpPromotionQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpPromotionQueryVO == null)
    {
      oEmpPromotionQueryVO = new EmpPromotionQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String screenName=oEmpPromotionQueryVO.getScreenName();
    String locCode = oEmpPromotionQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    
    if (screenName.equals("MaintEmpPromotionScreen6Pay")) 
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpPromDetail(?,?,?,?,?,?,?)");
    }
    else
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpSelectGrDetail(?,?,?,?,?,?,?)");
    }
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpPromotionBean6Pay oEmpPromotionBean;
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
        oEmpPromotionBean = new MaintEmpPromotionBean6Pay();

        oEmpPromotionBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpPromotionBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpPromotionBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        //oEmpPromotionBean.setTxtDsgnDesc(oRow.get("DESIGNATION_ID").getString());
        oEmpPromotionBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        //oEmpPromotionBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());        
        oEmpPromotionBean.setTxtEmpType(oRow.get("emp_type_desc").getString());                
        oEmpPromotionBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpPromotionBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString());        
        //oEmpPromotionBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
        oEmpPromotionBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("site_joining_date").getDate()));
        oEmpPromotionBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());  
        oEmpPromotionBean.setTxtCurtBasic(oRow.get("BASIC").getString());        
        oEmpPromotionBean.setTxtPrvPromDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));        
        oEmpPromotionBean.setTxtPersPaySFNAmt(oRow.get("pers_pay_sfn_amount").getString());        
        oEmpPromotionBean.setTxtPerPayHighQual(oRow.get("pers_pay_high_qual_amt").getString());        
        oEmpPromotionBean.setTxtPerPayAdvIncr(oRow.get("adv_incr_amt").getString());        
        oEmpPromotionBean.setTxtStagInc(oRow.get("stag_incr").getString());        
        
        oEmpPromotionBean.setPromType(oRow.get("promotion_type").getString());        
        oEmpPromotionBean.setNewDsgn(oRow.get("NEW_DSGN_DESC").getString());  
        oEmpPromotionBean.setNewDsgnDesc(oRow.get("new_designation").getString());  
        oEmpPromotionBean.setNewBasic(oRow.get("new_basic").getString());               
        oEmpPromotionBean.setPayScaleCode(oRow.get("pay_scale_code").getString()); 
        oEmpPromotionBean.setPayScaleCodeDesc(oRow.get("pay_scale_range").getString()); 
        oEmpPromotionBean.setNewPromEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("prom_eff_date").getDate()));        
        oEmpPromotionBean.setRemarks(oRow.get("remarks").getString());                
        oEmpPromotionBean.setAdhcPromEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PROM_EFF_END_DATE").getDate()));        
        oEmpPromotionBean.setNewPerPayFutIncr(oRow.get("PERS_PAY_FUT_INCR_NEW").getString());        
        oEmpPromotionBean.setNewStagInc(oRow.get("PERS_PAY_HIGH_QUAL_AMT_NEW").getString());        
        oEmpPromotionBean.setNewStagInc(oRow.get("STAG_INCR_NEW").getString());        
        
        oHeaderList.add(oEmpPromotionBean);
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

  public EmpPromotionComboVO getEmpPromComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpPromotionComboVO oEmpProm=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
    oEmpProm = new EmpPromotionComboVO();  
    
    ArrayList oPromTypeList = new ArrayList();
    oPromTypeList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetPromTypelov(?,?)","promType_id","promType_desc");
    oEmpProm.setValuePromTypeArrayList(oPromTypeList);
    
    return oEmpProm;
  }
  
  public LovVO getEmpPromotionLOVData6Pay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");    
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ Present Place");      
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Prev Promotion Date");    
    arylstHeaderNames.add("Pay Scale Type");    
    arylstHeaderNames.add("Personal Pay for SFN");    
    arylstHeaderNames.add("Personal Pay for High Qual.");    
    arylstHeaderNames.add("Personal Pay for Adv. Incr");    
    arylstHeaderNames.add("Stagnation Incr");    
    arylstHeaderNames.add("Designation Id");    
    
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpNewPromotionLOV(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        //oLOVBean.setDetailField10(oRow.get("PAY_STATUS").getString());                   
        oLOVBean.setDetailField11(oRow.get("BASIC").getString()); 
        oLOVBean.setDetailField12(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));
        oLOVBean.setDetailField13(oRow.get("PAY_SCALE_TYPE").getString());          
        oLOVBean.setDetailField14(oRow.get("pers_pay_sfn_amount").getString());          
        oLOVBean.setDetailField15(oRow.get("pers_pay_high_qual_amt").getString());          
        oLOVBean.setDetailField16(oRow.get("adv_incr_amt").getString());          
        oLOVBean.setDetailField17(oRow.get("stag_incr").getString());          
        oLOVBean.setDetailField18(oRow.get("designation_id").getString());          
              
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpSelectGrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");    
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ Present Place");      
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Prev Promotion Date");    
    arylstHeaderNames.add("Pay Scale Type");    
    arylstHeaderNames.add("Personal Pay for SFN");    
    arylstHeaderNames.add("Personal Pay for High Qual.");    
    arylstHeaderNames.add("Personal Pay for Adv. Incr");    
    arylstHeaderNames.add("Stagnation Incr");    
    arylstHeaderNames.add("Designation Id");    
    
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetSelGrPromotionLOV(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        //oLOVBean.setDetailField10(oRow.get("PAY_STATUS").getString());                   
        oLOVBean.setDetailField11(oRow.get("BASIC").getString()); 
        oLOVBean.setDetailField12(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));
        oLOVBean.setDetailField13(oRow.get("PAY_SCALE_TYPE").getString());          
        oLOVBean.setDetailField14(oRow.get("pers_pay_sfn_amount").getString());          
        oLOVBean.setDetailField15(oRow.get("pers_pay_high_qual_amt").getString());          
        oLOVBean.setDetailField16(oRow.get("adv_incr_amt").getString());          
        oLOVBean.setDetailField17(oRow.get("stag_incr").getString());          
        oLOVBean.setDetailField18(oRow.get("designation_id").getString());          
              
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  
  public LovVO getPromEmpTypeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee Type");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
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
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PopupEmpTypeData(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("emptype_desc").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getQueryEmpPromotionLOVData6Pay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");   
    arylstHeaderNames.add("Category Desc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ Present Place");      
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Prev Promotion Date");    
    arylstHeaderNames.add("Pay Scale Type");
    arylstHeaderNames.add("Personal Pay for SFN");    
    arylstHeaderNames.add("Personal Pay for High Qual.");    
    arylstHeaderNames.add("Personal Pay for Adv. Incr");    
    arylstHeaderNames.add("Stagnation Incr");
    arylstHeaderNames.add("Designation Id");
    
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpPromotionLOV(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        //oLOVBean.setDetailField10(oRow.get("PAY_STATUS").getString());                   
        oLOVBean.setDetailField11(oRow.get("BASIC").getString()); 
        oLOVBean.setDetailField12(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));
        oLOVBean.setDetailField13(oRow.get("PAY_SCALE_TYPE").getString()); 
        oLOVBean.setDetailField14(oRow.get("pers_pay_sfn_amount").getString());          
        oLOVBean.setDetailField15(oRow.get("pers_pay_high_qual_amt").getString());          
        oLOVBean.setDetailField16(oRow.get("adv_incr_amt").getString());          
        oLOVBean.setDetailField17(oRow.get("stag_incr").getString());
        oLOVBean.setDetailField18(oRow.get("designation_id").getString());          
              
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
    
//    checkFirst(oBaseHeaderBean,oList);
      oList = new ArrayList();
      MaintEmpPromotionBean6Pay oEmpPromotionBean = (MaintEmpPromotionBean6Pay)oBaseHeaderBean;
      checkMaxPayYear(oEmpPromotionBean.getTxtSiteID(),oEmpPromotionBean.getHdnEmpLbrFlag());
      reportError(oList);
      if(sScreenName.equals(EnrgiseConstants.NEW_MODE))
      {
          //checkEmpNo(oBaseHeaderBean,oList); 
          checkEmpCurBasicLimit(oBaseHeaderBean,oList);
      }  

//  checkEmpPFLimit(oBaseHeaderBean,oList);                    
    reportError(oList);        
  }  
  
  private void checkEmpCurBasicLimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
    MaintEmpPromotionBean6Pay oEmpPromotionBean = (MaintEmpPromotionBean6Pay)oBaseHeaderBean;
    
    String empNo = oEmpPromotionBean.getHeaderPrimaryKey();    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getTxtPayType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getPayScaleCode())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionBean.getNewBasic())));  
    
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_ValidateCurBasic(?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
    }       
  }


  public LovVO getEmpPromotionDsgnLOVData6Pay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Pay Scale Desc");
    //arylstHeaderNames.add("Start Basic"); 
    //arylstHeaderNames.add("End Basic");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);   
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.HIDDEN);
    //arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPromoType"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtCategory"))));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPromotionDsgnLov(?,?,?,?)");
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
        oLOVBean.setDetailField1(oRow.get("dsgn_id").getString());   
        oLOVBean.setDetailField2(oRow.get("dsgn_desc").getString());
        oLOVBean.setDetailField3(oRow.get("ctgry").getString());
        oLOVBean.setDetailField4(oRow.get("ctgry_desc").getString());        
        oLOVBean.setDetailField5(oRow.get("pay_scale_code").getString());
        oLOVBean.setDetailField6(oRow.get("pay_scale_range").getString());
        //oLOVBean.setDetailField7(oRow.get("end_basic").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  
  public LovVO getPromPayScaleCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Pay Scale Desc");   
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDsgnPayScaleCodelov(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_scale_code").getString()); 
       oLOVBean.setDetailField2(oRow.get("PAY_SCALE_DESC").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getQueryEmpSelectGrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");   
    arylstHeaderNames.add("Category Desc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ Present Place");      
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Prev Promotion Date");    
    arylstHeaderNames.add("Pay Scale Type");
    arylstHeaderNames.add("Personal Pay for SFN");    
    arylstHeaderNames.add("Personal Pay for High Qual.");    
    arylstHeaderNames.add("Personal Pay for Adv. Incr");    
    arylstHeaderNames.add("Stagnation Incr");
    arylstHeaderNames.add("Designation Id");
    
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpSelectGrLOV(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        //oLOVBean.setDetailField10(oRow.get("PAY_STATUS").getString());                   
        oLOVBean.setDetailField11(oRow.get("BASIC").getString()); 
        oLOVBean.setDetailField12(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));
        oLOVBean.setDetailField13(oRow.get("PAY_SCALE_TYPE").getString()); 
        oLOVBean.setDetailField14(oRow.get("pers_pay_sfn_amount").getString());          
        oLOVBean.setDetailField15(oRow.get("pers_pay_high_qual_amt").getString());          
        oLOVBean.setDetailField16(oRow.get("adv_incr_amt").getString());          
        oLOVBean.setDetailField17(oRow.get("stag_incr").getString()); 
        oLOVBean.setDetailField18(oRow.get("designation_id").getString());          
                
              
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
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
}