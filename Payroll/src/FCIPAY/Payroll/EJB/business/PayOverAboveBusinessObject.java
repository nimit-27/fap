package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayOverAboveQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.PayOverAboveHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
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
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

public class PayOverAboveBusinessObject extends BaseBO 
{
  public PayOverAboveBusinessObject()
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
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    PayOverAboveHeaderBean oPayOverAboveHeaderBean = (PayOverAboveHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output      
    
      oParameters = new ArrayList();     
    
      /* Employee Header Info */            
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtPayCode())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPayOverAboveHeaderBean.getTxtApplnDt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPayOverAboveHeaderBean.getTxtSnctnDt())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtSnctnAmnt())));    
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getHdnCpfDed())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtDedIT())));            
      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtSiteID())));      
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_UpdatePayOverAbove(?,?,?,?,?,?,?,?,?,?,?)",true,true);          
      
      DBObject oErrObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      System.out.println("Error!!! while updating Over & Above Details ::"+errCode);       

  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    PayOverAboveHeaderBean oPayOverAboveHeaderBean = (PayOverAboveHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters = new ArrayList();     
      /* Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtPayCode())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPayOverAboveHeaderBean.getTxtApplnDt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPayOverAboveHeaderBean.getTxtSnctnDt())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtSnctnAmnt())));    
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getHdnCpfDed())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtCpfEmpCntrb())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtCpfEmplyrCntrb())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtDedIT())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtNetAmt())));      
      
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtAgencyCode())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtAgencySiteCode())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtAgencyCodeDesc())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtAgencySiteCodeDesc())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(17,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(19,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_InsertPayOverAbove(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
   
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      DBObject oErrObject = (DBObject)oOutArray.get(1);
      Integer errCode = (Integer)((DBObject)oOutArray.get(2)).getObject();
      System.out.println("Error!!! while inserting Over & Above Details ::"+errCode);
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String((String)oErrObject.getObject()));
         System.out.println("Error!!! while inserting Over & Above ::"+oErrObject.getObject());
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }     
      
      return (String)oOutObject.getObject(); 
      
  }


  public RecordMetaInfo getPayOverAbvHeaderMetaInfo(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    
    String screenName=oPayOverAboveQueryVO.getScreenName();

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oPayOverAboveQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetPayOverAboveHdrCnt(?,?,?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }
  
  public ArrayList getPayOverAbvHeader(PayOverAboveQueryVO oPayOverAboveQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oPayOverAboveQueryVO == null)
    {
      oPayOverAboveQueryVO = new PayOverAboveQueryVO();
    }
    
    String screenName=oPayOverAboveQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oPayOverAboveQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtEmpNo())).toUpperCase()));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetPayOverAboveHdr(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());       

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    PayOverAboveHeaderBean oPayOverAboveHeaderBean;
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
        oPayOverAboveHeaderBean = new PayOverAboveHeaderBean();

        oPayOverAboveHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oPayOverAboveHeaderBean.setTxtEmpName(oRow.get("empName").getString());    
        oPayOverAboveHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oPayOverAboveHeaderBean.setTxtCategDesc(oRow.get("category").getString());
        oPayOverAboveHeaderBean.setTxtEmpType(oRow.get("emp_type").getString()); 
        oPayOverAboveHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());          
        oPayOverAboveHeaderBean.setTxtPresentPOPDesc(oRow.get("loc_desc").getString());               
        oPayOverAboveHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oPayOverAboveHeaderBean.setTxtEmpStatus(oRow.get("emp_status").getString());
        oPayOverAboveHeaderBean.setTxtCurrBas(oRow.get("basic").getString());
        
        oPayOverAboveHeaderBean.setHeaderPrimaryKey(oRow.get("pay_id").getString());
        oPayOverAboveHeaderBean.setTxtApplnDt(EnrgiseUtil.convertToString(oRow.get("aplctn_dt").getDate()));
        oPayOverAboveHeaderBean.setTxtSnctnDt(EnrgiseUtil.convertToString(oRow.get("snctn_dt").getDate()));
        oPayOverAboveHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
        oPayOverAboveHeaderBean.setTxtPayCodeDesc(oRow.get("pay_code_desc").getString());
        oPayOverAboveHeaderBean.setHdnCpfDed(oRow.get("cpf_flag").getString());
        oPayOverAboveHeaderBean.setTxtSnctnAmnt(oRow.get("sanction_amt").getString());
        oPayOverAboveHeaderBean.setTxtCpfEmpCntrb(oRow.get("employee_subs").getString());
        oPayOverAboveHeaderBean.setTxtCpfEmplyrCntrb(oRow.get("employer_cont").getString());
        oPayOverAboveHeaderBean.setTxtDedIT(oRow.get("it_ded").getString());
        //oPayOverAboveHeaderBean.setTxtDedOthr(oRow.get("othr_ded").getString());
        oPayOverAboveHeaderBean.setTxtNetAmt(oRow.get("net_amt").getString());
        oPayOverAboveHeaderBean.setTxtAgencyCode(oRow.get("AGENCY_CODE").getString());
        oPayOverAboveHeaderBean.setTxtAgencySiteCode(oRow.get("AGENCY_SITE_CODE").getString());
        oPayOverAboveHeaderBean.setTxtInvoceId(oRow.get("invoice_num").getString());
        oPayOverAboveHeaderBean.setTxtAgencyCodeDesc(oRow.get("agency_code_desc").getString());
        oPayOverAboveHeaderBean.setTxtAgencySiteCodeDesc(oRow.get("agency_site_code_desc").getString());
        oHeaderList.add(oPayOverAboveHeaderBean);
      }    
      
    return oHeaderList;
  }  


  /*public ArrayList getLeaveEncashPayInfo(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    if(oPayOverAboveQueryVO == null)
    {
      oPayOverAboveQueryVO = new PayOverAboveQueryVO();
    }
    
    String screenName=oPayOverAboveQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oPayOverAboveQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtEmpNo())).toUpperCase()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPayOverAboveQueryVO.getTxtApplnDt())));    
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_getEmpPerDayWage(?,?,?,?,?,?)");
    
    DBObject oWageObject = (DBObject)oOutArray.get(0);
    String sDayWage = (String)(oWageObject.getObject());

    oParamList.add(sDayWage);
    
    DBObject oCpfObject = (DBObject)oOutArray.get(1);
    String sCpfDed = (String)(oCpfObject.getObject());
    oParamList.add(sCpfDed);
    
    return oParamList;
  }*/

  public LovVO getEmpPayOverAbvLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category");
    arylstHeaderNames.add("Employee Type");
    arylstHeaderNames.add("Cpf Code");
    arylstHeaderNames.add("Present Place of Posting");
    arylstHeaderNames.add("Date of Joining Location");
    arylstHeaderNames.add("Employee Status");
    arylstHeaderNames.add("Current Basic");
    arylstHeaderNames.add("Pay Scale Type");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));     
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpPayOverAboveN(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("empName").getString());
      oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());
      oLOVBean.setDetailField4(oRow.get("category").getString());
      oLOVBean.setDetailField5(oRow.get("EMP_TYPE").getString());
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("loc_desc").getString());
      oLOVBean.setDetailField8(oRow.get("site_joining_date").getString());
      oLOVBean.setDetailField9(oRow.get("emp_status").getString());
      oLOVBean.setDetailField10(oRow.get("basic").getString());      
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpPayOverAbvLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));     
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpPayOverAboveQ(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("empName").getString());
      oLOVBean.setDetailField3(oRow.get("cpf_code").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getPayCodeOvrAbvLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Code");
    arylstHeaderNames.add("Description");
    arylstHeaderNames.add("Tax Indicator");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
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
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));     
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtEmpNo"))).trim()));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetPayCodeOvrAbvPay(?,?,?,?,?,?)"); 
    /*GetLovAction oGetLovAction = new GetLovAction();
    oOutArray = oGetLovAction.GetLov(oLovQueryVO,"N");*/
    
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
      
      oLOVBean.setDetailField1(oRow.get("pay_code").getString());
      oLOVBean.setDetailField2(oRow.get("pay_code_desc").getString());
      oLOVBean.setDetailField3(oRow.get("taxable_ind").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oList=new ArrayList();
      PayOverAboveHeaderBean oPayOverAboveHeaderBean = (PayOverAboveHeaderBean)oBaseHeaderBean;
      checkYrEndRemittance(oBaseHeaderBean,oList);
      reportError(oList);
      checkMaxPayYear(oPayOverAboveHeaderBean.getTxtSiteID(),oPayOverAboveHeaderBean.getHdnEmpLbrFlag());
      reportError(oList);
    //checkDuplicate(oBaseHeaderBean,sScreenName,sScreenMode,oList);
   // reportError(oList);
  }
  
    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        PayOverAboveHeaderBean oPayOverAboveHeaderBean = (PayOverAboveHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oPayOverAboveHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oPayOverAboveHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oPayOverAboveHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(4, DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_othrPaymnt_YrEndcheck(?,?,?,?,?)",true,true);
        Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
        String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() != 0)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
        }
    }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkDuplicate(BaseHeaderBean oBaseHeaderBean,String sScreenName,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      Integer chkFlag=new Integer(0);
      PayOverAboveHeaderBean oPayOverAboveHeaderBean = (PayOverAboveHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPayOverAboveHeaderBean.getTxtApplnDt())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_LvEncashDuplCheck(?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("Payroll.LeaveEncash.dupliCheck",oArguments));
      }

  }

  public ArrayList getPayOverAboveITDed(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    if(oPayOverAboveQueryVO == null)
    {
      oPayOverAboveQueryVO = new PayOverAboveQueryVO();
    }
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    
    String sFlag=checkMaxPayYear(oPayOverAboveQueryVO);
    
    oParamList.add(sFlag);
    return oParamList;
  }
  
  public String sendPayOvrAbvInv(String oPayOverAboveId,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPayOverAboveId));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.Proc_SendPayOvrAbvInvoice(?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());    
    String sRetMsg=errCode.toString()+","+errMsg;
   
    return sRetMsg;
   
  }

  private String checkMaxPayYear(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = null; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    String sFlag="";
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oPayOverAboveQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayOverAboveQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      String sRevYear = oRow.get("yymm").getString(); 
      String status = oRow.get("status").getString();
      String sMonth=sRevYear.substring(4);
      int stat=Integer.parseInt(status);

      if (sMonth.equals("03"))
      {
        sFlag="Y";
      }
      else
      {
        sFlag="N";
      }
     }
    return sFlag;
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
    if(hdnEmpLbrFlag.equals("E"))
    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    }
    else
    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear_OvrAbv_Lbr(?,?,?,?)");
    }
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = oRow.get("arc_flag").getString(); 
    }    
    
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    
    return "";
  }    
  
 public LovVO getAgencyCodeOvrAbvLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Agency");   
    arylstHeaderNames.add("Agency Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    
    String sAgencyCode,sAgencyCodeDesc;
    sAgencyCode=oLovQueryVO.getSearchField1();
    sAgencyCodeDesc=oLovQueryVO.getSearchField2();
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sAgencyCode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sAgencyCodeDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetPayOvrAbvAgencyCodeLOV(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("vendor_id").getString());            
       oLOVBean.setDetailField2(oRow.get("vendor_name").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }





 public LovVO getAgencySiteCodeOvrAbvLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("AgencySite");   
    arylstHeaderNames.add("AgencySite Description");   
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtAgencyCode")));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetAgencySiteCodeLOV(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("vendor_site_id").getString());            
       oLOVBean.setDetailField2(oRow.get("vendor_site_code").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public String  deletePayOverAbovePymnt(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = null; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    String msg=null;

    if(oPayOverAboveQueryVO == null)
    {
      oPayOverAboveQueryVO = new PayOverAboveQueryVO();
    }
    
    String screenName=oPayOverAboveQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oPayOverAboveQueryVO.getHeaderPrimaryKey()))); //added by swapnendu DT 15 jun 12   
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new Long(oPayOverAboveQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtEmpNo()))));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtSnctnAmnt()))));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtNetAmt()))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtPayCode()))));    
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtApplnDt()))));
    //oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPayOverAboveQueryVO.getTxtSnctnDt()))));//commented by swapnendu DT 15 jun 12   
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oPayOverAboveQueryVO.getTxtSnctnDt())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oPayOverAboveQueryVO.getUserId()))));
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_deletePayOverAbovePymnt(?,?,?,?,?,?,?,?,?,?,?)");
    
      DBObject oErrObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
      
      if(!errCode.equals(new Integer(0)))
      {
         msg="Failed";
      } 
      
       else if(  errCode.equals(new Integer(0)))
      {
         msg="Success";
      }      
    return msg;
  }
  
  
}