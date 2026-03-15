package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpCPFSearchQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpCPFSearchComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.EmpCPFSearchBean;
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

public class EmpCPFSearchBusinessObject extends BaseBO 
{

  public EmpCPFSearchBusinessObject()
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters  
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    EmpCPFSearchBean oEmpCPFSearchBean = (EmpCPFSearchBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output 
    
    oParameters = new ArrayList();  
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchBean.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchBean.getTxtPresentPOP()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchBean.getTxtCityTypeHra()))); 
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_UpdateEmpCPFSearchDetail(?,?,?,?,?)",true,true);    
    
        
      DBObject oMsgObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oMsgObject.getObject();
      DBObject oErrObject = (DBObject)oOutArray.get(1);    
      Integer errorCode = (Integer)oErrObject.getObject();
      if(!(errorCode.equals(new Integer(0))))
      {        
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(error_msg));
         System.out.println("Error!!! while Updating Employee POP ::"+error_msg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    
      return null;
  }

  public RecordMetaInfo getEmpCPFSearchHeaderMetaInfo(EmpCPFSearchQueryVO oEmpCPFSearchQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    //String screenName=oEmpCPFSearchQueryVO.getScreenName();
    String locCode = oEmpCPFSearchQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtCpfCode().trim())));    
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtDsgn())));    
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtEmpFirstName().trim())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtEmpLastName().trim())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtCadre())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtPresentPOP())));      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtEmpTypeId())));      
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getCPFEmpCount(?,?,?,?,?,?,?,?,?,?,?)");
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getEmpCPFSearchHeader(EmpCPFSearchQueryVO oEmpCPFSearchQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpCPFSearchQueryVO == null)
    {
      oEmpCPFSearchQueryVO = new EmpCPFSearchQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;      
    String locCode = oEmpCPFSearchQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();   
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtCpfCode().trim())));          
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtDsgn())));          
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtEmpFirstName().trim())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtEmpLastName().trim())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtCadre())));      
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtPresentPOP())));      
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpCPFSearchQueryVO.getTxtEmpTypeId())));
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getCPFEmpDetail(?,?,?,?,?,?,?,?,?,?,?,?)");
        
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    EmpCPFSearchBean oEmpCPFSearchBean;
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
        oEmpCPFSearchBean = new EmpCPFSearchBean();

        oEmpCPFSearchBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpCPFSearchBean.setTxtStaffCode(oRow.get("STAFF_CODE").getString());
        oEmpCPFSearchBean.setParentZone(oRow.get("PARENT_ZONE").getString());
        oEmpCPFSearchBean.setTxtEmpFirstName(oRow.get("EMP_FIRST_NAME").getString());        
        oEmpCPFSearchBean.setTxtEmpMiddleName(oRow.get("EMP_MIDDLE_NAME").getString());        
        oEmpCPFSearchBean.setTxtEmpLastName(oRow.get("EMP_LAST_NAME").getString());        
        oEmpCPFSearchBean.setTxtDsgn(oRow.get("DESIGNATION_ID").getString());
        oEmpCPFSearchBean.setTxtDsgnDesc(oRow.get("dsgn_desc").getString());
        oEmpCPFSearchBean.setTxtCateg(oRow.get("EMP_CAT").getString());
        //oEmpCPFSearchBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpCPFSearchBean.setTxtCadre(oRow.get("CADRE").getString());
        //oEmpCPFSearchBean.setTxtEmpTypeId(oRow.get("EMP_TYP").getString());        
        oEmpCPFSearchBean.setTxtEmpType(oRow.get("emp_typ").getString());        
        oEmpCPFSearchBean.setTxtPFType(oRow.get("EMP_PF_TYPE").getString());
        oEmpCPFSearchBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        //oEmpCPFSearchBean.setTmpCpfFlg(oRow.get("CPF_FLG").getString());
        oEmpCPFSearchBean.setTxtFpsNo(oRow.get("FPS_NUM").getString());           
        oEmpCPFSearchBean.setTxtDojFCI(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("COMP_JOINING_DATE").getDate()));
        oEmpCPFSearchBean.setTxtPresentPOPDesc(oRow.get("LOC_DESC").getString());        
        oEmpCPFSearchBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
        oEmpCPFSearchBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oEmpCPFSearchBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString());  
        oEmpCPFSearchBean.setTxtDepuType(oRow.get("DEPUTATION_TYPE").getString());       
        oEmpCPFSearchBean.setPrefix(oRow.get("PREFIX").getString());       
        //oEmpCPFSearchBean.setTxtSection(oRow.get("SECTION_ID").getString());       
        oEmpCPFSearchBean.setTxtSectionDesc(oRow.get("SECTION").getString());               
        //oEmpCPFSearchBean.setTxtDivision(oRow.get("DIVISION").getString());        
        oEmpCPFSearchBean.setTxtDOB(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("emp_birth_date").getDate()));               
        oEmpCPFSearchBean.setTxtRetireDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));               
        
        oEmpCPFSearchBean.setTxtPayType(oRow.get("PAY_SCALE_TYPE").getString());
        oEmpCPFSearchBean.setTxtPayScaleCode(oRow.get("PAY_SCALE_CODE").getString());
        oEmpCPFSearchBean.setTxtCurtBasic(oRow.get("BASIC").getString());                
        oEmpCPFSearchBean.setTxtPayStatus(oRow.get("PAY_STATUS").getString());         
        oEmpCPFSearchBean.setTxtPayMode(oRow.get("PAY_MODE").getString());
        oEmpCPFSearchBean.setTxtPayModeType(oRow.get("PAY_MODE_TYPE").getString());                                      
        oEmpCPFSearchBean.setTxtBankDesc(oRow.get("BANK_NAME").getString());        
        //oEmpCPFSearchBean.setTxtBranchCode(oRow.get("BRANCH_CODE").getString());        
        oEmpCPFSearchBean.setTxtBranchDesc(oRow.get("BRANCH_NAME").getString());        
        oEmpCPFSearchBean.setTxtBankAccNo(oRow.get("BANK_AC_NO").getString());
        oEmpCPFSearchBean.setTxtPayStsChnDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate()));
        //oEmpCPFSearchBean.setTxtPerPay(oRow.get("personal_pay").getString()); 
        //oEmpCPFSearchBean.setTxtPerPayHighQual(oRow.get("PERS_PAY_HIGH_QUAL").getString());
        oEmpCPFSearchBean.setTxtInrSt(oRow.get("INCREMENT_STATUS").getString());
        oEmpCPFSearchBean.setTxtStagInc(oRow.get("STAG_INCR").getString());        
        oEmpCPFSearchBean.setTxtStagEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("STAG_INCR_EFF_DATE").getDate()));
        //oEmpCPFSearchBean.setTxtSubsAmt(oRow.get("VCPF_SUBS_AMOUNT").getString());
        oEmpCPFSearchBean.setTxtPanNo(oRow.get("EMP_PAN_NO").getString());        
        oEmpCPFSearchBean.setTxtCityTypeHra(oRow.get("CITY_TYPE_HRA").getString());    
        oEmpCPFSearchBean.setTxtMHSTyp(oRow.get("mhs_flag").getString());  
        oEmpCPFSearchBean.setTxtEpsFlag(oRow.get("eps_flag").getString());
        oEmpCPFSearchBean.setTxtEpsEntDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eps_entlmnt_dt").getDate()));
        oEmpCPFSearchBean.setTxtEpsSepRsn(oRow.get("eps_sep_reason").getString());
        oEmpCPFSearchBean.setTxtEpsSepDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eps_sep_dt").getDate()));
        oEmpCPFSearchBean.setTxtGradePay(oRow.get("GRADE_PAY").getString());
        oEmpCPFSearchBean.setTxtPayRevFlag(oRow.get("PAY_REV_FLAG").getString()); //added by yogesh
        //System.out.println("emp-firstname::"+oRow.get("EMP_FIRST_NAME").getString()+"pay-rev-flag::"+oRow.get("PAY_REV_FLAG").getString()+"LOCATION DESC::"+oRow.get("LOC_DESC").getString());
                        
        oHeaderList.add(oEmpCPFSearchBean);
      }  
      
    return oHeaderList;
    
  }
  
  public EmpCPFSearchComboVO getCPFSearchComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpCPFSearchComboVO oEmpCPFSearch=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;   
    //String empNo ="";
    oEmpCPFSearch = new EmpCPFSearchComboVO();          
    //empNo = oEmpSusp.getHeaderPrimaryKey();
    
    ArrayList oCadreList = new ArrayList();
    oCadreList = getEmpCPFComboRecords("PAYROLL_PKG.proc_GetCadre(?,?)","cadre_id","cadre_desc");
    oEmpCPFSearch.setValueCadreArrayList(oCadreList);    
        
    return oEmpCPFSearch;
  } 
  
  
  private ArrayList getEmpCPFComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
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
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sEmpNo)));
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
  
  public LovVO getEmpCPFSearchLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Site Id");        
    arylstHeaderNames.add("Site Name");  
    arylstHeaderNames.add("City Type");        
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetEmpLocLOV(?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("city_typ_gbl").getString());                   
      oList.add(oLOVBean);
    }     
      oLovVO.setDetailList(oList);
    return oLovVO;
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
    //if(bHeaderDataChanged)
   // {
      //checkMandatoryDetail(oBaseHeaderBean,sScreenMode);
   // }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }  
  
  public LovVO getQueryEmpMastSearchLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("First Name");    
    arylstHeaderNames.add("Middle Name");    
    arylstHeaderNames.add("Last Name");    
    arylstHeaderNames.add("CPF Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPresentPOP"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));  
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtEmpTypeId"))));           
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField4())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtDsgn"))));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtCadre"))));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));    
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.getQueryEmpMastSearchLOVData(?,?,?,?,?,?,?,?,?,?)");
    
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
        oLOVBean.setDetailField2(oRow.get("EMP_FIRST_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("EMP_MIDDLE_NAME").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_LAST_NAME").getString());      
        oLOVBean.setDetailField5(oRow.get("CPF_CODE").getString());   // added  by devendra on 16th aug 2010
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
}