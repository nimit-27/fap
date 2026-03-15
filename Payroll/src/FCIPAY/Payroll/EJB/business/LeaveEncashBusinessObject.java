package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveEncashQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.LeaveEncashHeaderBean;
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


public class LeaveEncashBusinessObject extends BaseBO 
{
  public LeaveEncashBusinessObject()
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
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    LeaveEncashHeaderBean oLeaveEncashHeaderBean = (LeaveEncashHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters = new ArrayList();     
      /* Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveEncashHeaderBean.getTxtApplnDt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveEncashHeaderBean.getTxtSnctnDt())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtEL())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtEncshAmt())));    
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtDedIT())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtDedOthr())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtCpfEmpCntrb())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtCpfEmplyrCntrb())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtNetAmt())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtPayModeType())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtRmrks())));
      
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(17,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_UpdatePayLeaveEncash(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
   
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      String err_msg = (String)((DBObject)oOutArray.get(0)).getObject();
      //System.out.println("Error!!! while updating Encashment Details ::"+errCode);
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(err_msg));
         //System.out.println("Error!!! while inserting Leave Encashment ::"+oErrObject.getObject());
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
    
      
     // return (String)oOutObject.getObject(); 
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    LeaveEncashHeaderBean oLeaveEncashHeaderBean = (LeaveEncashHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters = new ArrayList();     
      /* Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveEncashHeaderBean.getTxtApplnDt())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveEncashHeaderBean.getTxtSnctnDt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtEL())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtEncshAmt())));    
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtDedIT())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtDedOthr())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtCpfEmpCntrb())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtCpfEmplyrCntrb())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtNetAmt())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtPayModeType())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtRmrks())));
      
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(17,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_InsertPayLeaveEncash(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
   
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      DBObject oErrObject = (DBObject)oOutArray.get(1);
      Integer errCode = (Integer)((DBObject)oOutArray.get(2)).getObject();
      System.out.println("Error!!! while inserting Encashment Details ::"+errCode);
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String((String)oErrObject.getObject()));
         System.out.println("Error!!! while inserting Leave Encashment ::"+oErrObject.getObject());
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
      
      
      return (String)oOutObject.getObject(); 
      
  }


  public RecordMetaInfo getLeaveEncashHeaderMetaInfo(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    
    String screenName=oLeaveEncashQueryVO.getScreenName();

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaveEncashQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpLeaveEncashDtlCnt(?,?,?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getLeaveEncashPayInfo(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    if(oLeaveEncashQueryVO == null)
    {
      oLeaveEncashQueryVO = new LeaveEncashQueryVO();
    }
    
    String screenName=oLeaveEncashQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashQueryVO.getHdnEmpLbrFlag())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new Long(oLeaveEncashQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getTxtEmpNo())).toUpperCase()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveEncashQueryVO.getTxtApplnDt())));    
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
   
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_getEmpPerDayWageEmp(?,?,?,?,?,?,?,?)",true,true);
      
    DBObject oWageObject = (DBObject)oOutArray.get(0);
    String sDayWage = (String)(oWageObject.getObject());

    oParamList.add(sDayWage);
    
    DBObject oCpfObject = (DBObject)oOutArray.get(1);
    String sCpfDed = (String)(oCpfObject.getObject());
    oParamList.add(sCpfDed);   
      DBObject oErrObject = (DBObject)oOutArray.get(2);
      Integer errCode = (Integer)((DBObject)oOutArray.get(3)).getObject();
      
      if(  errCode.equals(new Integer(2002)))
      {  ArrayList oArguments = new ArrayList();
         oArguments.add(new String((String)oErrObject.getObject()));
         throw new EnrgiseApplicationException("Pay.Payroll.LeaveEncash.basicCheck",oArguments); 
      } 
    return oParamList;
  }//deleteLeaveEncash


  public String  deleteLeaveEncash(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    String msg=null;

    if(oLeaveEncashQueryVO == null)
    {
      oLeaveEncashQueryVO = new LeaveEncashQueryVO();
    }
    
    String screenName=oLeaveEncashQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    
    oParameters = new ArrayList();
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oLeaveEncashQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getTxtEmpNo()))));
    //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveEncashQueryVO.getTxtApplnDt())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getTxtApplnDt()))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getTxtEncshAmt()))));     
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String("184"))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oLeaveEncashQueryVO.getUserId()))));  
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_deleteLeaveEncashment(?,?,?,?,?,?,?,?)");
    
      DBObject oErrObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
      
      if(!errCode.equals(new Integer(0)))
      {
         msg="Failed";
         //ArrayList oArguments = new ArrayList();
         //oArguments.add(msg);  
         //System.out.println("Error!!! while inserting Leave Encashment ::"+oErrObject.getObject());
         //throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
         
      } 
      
       else if(  errCode.equals(new Integer(0)))
      {
         msg="Success";
        // ArrayList oArguments = new ArrayList();
        // oArguments.add(msg);        
         //throw new EnrgiseApplicationException("Data Saved Successfully!!!",oArguments); 
         
      }      
    return msg;
  }

  public LovVO getEmpLeaveEncashLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpLeaveEncashN(?,?,?,?,?,?)");
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
      oLOVBean.setDetailField11(oRow.get("pay_scale_type").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpLeaveEncashLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpLeaveEncashQ(?,?,?,?,?,?)");
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
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public ArrayList getLeaveEncashHeader(LeaveEncashQueryVO oLeaveEncashQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oLeaveEncashQueryVO == null)
    {
      oLeaveEncashQueryVO = new LeaveEncashQueryVO();
    }
    
    String screenName=oLeaveEncashQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaveEncashQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getTxtEmpNo())).toUpperCase()));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpLeaveEncashDtl(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   
    

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    LeaveEncashHeaderBean oLeaveEncashHeaderBean;
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
        oLeaveEncashHeaderBean = new LeaveEncashHeaderBean();

        oLeaveEncashHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oLeaveEncashHeaderBean.setTxtEmpName(oRow.get("empName").getString());    
        oLeaveEncashHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oLeaveEncashHeaderBean.setTxtCategDesc(oRow.get("category").getString());
        oLeaveEncashHeaderBean.setTxtEmpType(oRow.get("emp_type").getString()); 
        oLeaveEncashHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());          
        oLeaveEncashHeaderBean.setTxtPresentPOPDesc(oRow.get("loc_desc").getString());               
        oLeaveEncashHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oLeaveEncashHeaderBean.setTxtEmpStatus(oRow.get("emp_status").getString());
        oLeaveEncashHeaderBean.setTxtCurrBas(oRow.get("basic").getString());
        oLeaveEncashHeaderBean.setTxtPayScaleType(oRow.get("pay_scale_type").getString());
        
        oLeaveEncashHeaderBean.setHeaderPrimaryKey(oRow.get("lv_encash_id").getString());
        oLeaveEncashHeaderBean.setTxtApplnDt(EnrgiseUtil.convertToString(oRow.get("aplctn_dt").getDate()));
        oLeaveEncashHeaderBean.setTxtSnctnDt(EnrgiseUtil.convertToString(oRow.get("snctn_dt").getDate()));
        oLeaveEncashHeaderBean.setTxtPayModeType(oRow.get("pay_mode").getString());
        oLeaveEncashHeaderBean.setTxtEL(oRow.get("snctn_el").getString());
        oLeaveEncashHeaderBean.setTxtEncshAmt(oRow.get("encsh_amt").getString());
        oLeaveEncashHeaderBean.setTxtCpfEmpCntrb(oRow.get("employee_subs").getString());
        oLeaveEncashHeaderBean.setTxtCpfEmplyrCntrb(oRow.get("employer_cont").getString());
        oLeaveEncashHeaderBean.setTxtDedIT(oRow.get("it_ded").getString());
        oLeaveEncashHeaderBean.setTxtDedOthr(oRow.get("othr_ded").getString());
        oLeaveEncashHeaderBean.setTxtNetAmt(oRow.get("net_amt").getString());
        oLeaveEncashHeaderBean.setTxtRmrks(oRow.get("rmrks").getString());
        oLeaveEncashHeaderBean.setTxtInvId(oRow.get("invoice_id").getString());
        
        oHeaderList.add(oLeaveEncashHeaderBean);
      }    
      
    return oHeaderList;
  }  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(sScreenMode.equals("N"))
    {
      ArrayList oList=new ArrayList();
      LeaveEncashHeaderBean oLeaveEncashHeaderBean =(LeaveEncashHeaderBean)oBaseHeaderBean;
      checkYrEndRemittance(oBaseHeaderBean,oList);
      reportError(oList);
      checkMaxPayYear(oLeaveEncashHeaderBean.getTxtSiteID(),oLeaveEncashHeaderBean.getHdnEmpLbrFlag());
      reportError(oList); 
      checkDuplicate(oBaseHeaderBean,sScreenName,sScreenMode,oList);
      reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
       LeaveEncashHeaderBean oLeaveEncashHeaderBean =(LeaveEncashHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oLeaveEncashHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oLeaveEncashHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oLeaveEncashHeaderBean.getTxtSiteID())));
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
  
  private void checkDuplicate(BaseHeaderBean oBaseHeaderBean,String sScreenName,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      Integer chkFlag=new Integer(0);
      LeaveEncashHeaderBean oLeaveEncashHeaderBean = (LeaveEncashHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveEncashHeaderBean.getTxtApplnDt())));
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

  public ArrayList getLeaveEncashITDed(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    if(oLeaveEncashQueryVO == null)
    {
      oLeaveEncashQueryVO = new LeaveEncashQueryVO();
    }
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    
    String sFlag=checkMaxPayYear(oLeaveEncashQueryVO);
    
  
    oParamList.add(sFlag);
    return oParamList;
  }

  private String checkMaxPayYear(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    String sFlag="";
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaveEncashQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveEncashQueryVO.getHdnEmpLbrFlag())));
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
    String empType="";
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
      empType=oRow.get("emp_type").getString();
    }    
    
   // int iStat=Integer.parseInt(status);
    if(status!=null && status.equals("Y"))
    {
    if(empType.equals("I"))
    {
    throw new EnrgiseApplicationException("payroll.Common.PayrollCheckDept");
    }
    else if(empType.equals("A")) 
    {
    throw new EnrgiseApplicationException("payroll.Common.PayrollCheckDps");

    }
    else
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");

    }
    }
    
    return "";
  }     
  
 public String sendLeaveEncashInv(String otaId,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,otaId));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.Proc_SendLeaveEncashInvoice(?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    
    String sRetMsg=errCode.toString()+","+errMsg;
    
    return sRetMsg;
  }  
 
    public String  cancelLeaveEncashInv(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     String msg=null;
    
     if(oLeaveEncashQueryVO == null)
     {
       oLeaveEncashQueryVO = new LeaveEncashQueryVO();
     }
        
     
     String screenName=oLeaveEncashQueryVO.getScreenName();
     ArrayList oOutArray; //Output 
     ArrayList oParamList = new ArrayList();  
     ArrayList oList = new ArrayList();  
          
     oParameters = new ArrayList();
             
     oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getTxtEmpNo()))));
     oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getTxtInvId()))));
     oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveEncashQueryVO.getScreenName()))));
     oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new Long(oLeaveEncashQueryVO.getLoginLocCode())));
     oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oLeaveEncashQueryVO.getUserId()))));
     oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
     oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
     
     oOutArray = oBean.callProc(oParameters,"pkg_cancel_othr_pymnt_inv.proc_cancel_op_invoices(?,?,?,?,?,?,?)",true,true);
     
      String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
       Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
     
      return errMsg;
    }
    
}