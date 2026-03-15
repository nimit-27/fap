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
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.EmpTrnsfrHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
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
import FCIPAY.Payroll.UTILITY.LoanForeclosureBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanForeclosureVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanRescheduleVO;
import FCIPAY.Payroll.UTILITY.LoanRescheduleBean;

public class LoanRescheduleBusinessObject extends BaseBO 
{
  public LoanRescheduleBusinessObject()
  {
  }
 public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("MaintLoanReschedule"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    //  if(sScreenName.equals("MaintLoanForeclosure"))    
    saveLoanRescheduleDetails(oBaseHeaderBean);     
    return null;
  }

 public  void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
    
  }
  
   public RecordMetaInfo getLoanRescheduleHeaderMetaInfo(LoanRescheduleVO oLoanRescheduleVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    
    String screenName=oLoanRescheduleVO.getScreenName();

    oParameters = new ArrayList();
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
 
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_CountLoanReschedule (?,?,?,?)");    

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
   oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }

  

  public LovVO getEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category");
    arylstHeaderNames.add("Employee Type");
    arylstHeaderNames.add("Employee Status");
    arylstHeaderNames.add("CPF Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);   
    oLovVO.setVisibilityList(arylstVisibility);
    
     // search parameters
    String sEmpNo,sCPF,sName;
    sEmpNo=oLovQueryVO.getSearchField1();
    sCPF=oLovQueryVO.getSearchField2();
    sName=oLovQueryVO.getSearchField3();
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sEmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sCPF));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sName));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_EmpNoLOV_LoanReschedule(?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("name1").getString());
      oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());
      oLOVBean.setDetailField4(oRow.get("emp_category").getString());
      oLOVBean.setDetailField5(oRow.get("emp_type").getString());
      oLOVBean.setDetailField6(oRow.get("emp_status").getString());
      oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());      
      
      oList.add(oLOVBean);
    }     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getLoanRescheduleDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Code");
    arylstHeaderNames.add("Description");   
    arylstHeaderNames.add("Balance Amount");
    arylstHeaderNames.add("Balance Interest");
    arylstHeaderNames.add("TRANSMASTID");
    arylstHeaderNames.add("Loan/Advance");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtEmpNo"))));         
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.Get_LoanLOV_Reschedule (?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("CODE").getString());
      oLOVBean.setDetailField2(oRow.get("DESCRIPTION").getString());
      oLOVBean.setDetailField3(oRow.get("PENDING_BALANCE").getString());
      oLOVBean.setDetailField4(oRow.get("PENDING_INTEREST").getString());      
      oLOVBean.setDetailField5(oRow.get("transmast_id").getString());
      oLOVBean.setDetailField6(oRow.get("FLAG").getString());     
      
      oList.add(oLOVBean);
    }     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

 public LovVO getLoanRescheduleDtlLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    
    String sEmpNo,sCPF,sName;
    sEmpNo=oLovQueryVO.getSearchField1();
    sCPF=oLovQueryVO.getSearchField2();
    sName=oLovQueryVO.getSearchField3();
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sEmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sCPF));     
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, sName));  
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_EmpNoLOVQ_LoanReschedule(?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("NAME1").getString());
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
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
      ArrayList oList = new ArrayList();
      checkRecYYMM(oBaseHeaderBean,oList);
      reportError(oList);   
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  } 
  
  private void checkRecYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    Iterator oDtlIt=null;
    String sFlag="";    
    String status="";
    LoanRescheduleBean oLoanRescheduleBean=(LoanRescheduleBean)oBaseHeaderBean;    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();      
      status = oRow.get("arc_flag").getString(); 
    }
      
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }    
  } 
   
 private String saveLoanRescheduleDetails(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
 {
   ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    String errorMsg ="";
    LoanRescheduleBean oLoanRescheduleBean = (LoanRescheduleBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters = new ArrayList();     
      /* Loan/Advance Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtUserID())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtSiteID())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtEmpNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtLoan()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtTransID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtOutPrn())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtOutInt())));    
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtPaidPrn())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtPaidInt())));    
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtNewPrnInstal())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtNewIntInstal())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtNewPrnAmt())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtNewIntAmt())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleBean.getTxtLoanFlag())));
      oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_InsertLoanReschedule(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
   
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println(""+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
     return errorMsg;
  }  
    
      
      
  public ArrayList getLoanRescheduleHeader(LoanRescheduleVO oLoanRescheduleVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oLoanRescheduleVO == null)
    {
      oLoanRescheduleVO = new LoanRescheduleVO();
    }
    
    String screenName=oLoanRescheduleVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    
    oParameters = new ArrayList();   
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oLoanRescheduleVO.getLoginLocCode()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanRescheduleVO.getTxtTransID())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_ExecuteLoanReschedule(?,?,?,?,?)");   
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    LoanRescheduleBean oLoanRescheduleBean;
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
        oLoanRescheduleBean = new  LoanRescheduleBean();

         oLoanRescheduleBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
         oLoanRescheduleBean.setTxtEmpName(oRow.get("NAME1").getString());    
         oLoanRescheduleBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
         oLoanRescheduleBean.setTxtEmpCategory(oRow.get("EMP_CATEGORY").getString());
         oLoanRescheduleBean.setTxtEmpType(oRow.get("EMP_TYPE").getString());
         oLoanRescheduleBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString()); 
         oLoanRescheduleBean.setTxtEmpCPF(oRow.get("CPF_CODE").getString()); 
         oLoanRescheduleBean.setTxtLoan(oRow.get("Loan_id").getString());   
         oLoanRescheduleBean.setTxtLoanDesc(oRow.get("pay_code_desc").getString());  
         oLoanRescheduleBean.setTxtPaidPrnAmt(oRow.get("old_principal_amt").getString());                        
         oLoanRescheduleBean.setTxtPaidIntAmt(oRow.get("old_Interest_amt").getString());
         oLoanRescheduleBean.setTxtLoanAmt(oRow.get("LoanAmt").getString());
         oLoanRescheduleBean.setTxtNewPrnInstal(oRow.get("new_principal_installs").getString());
         oLoanRescheduleBean.setTxtNewIntInstal(oRow.get("new_interest_installs").getString());
         oLoanRescheduleBean.setTxtSysdate(oRow.get("reschedule_dt").getString());
         oLoanRescheduleBean.setTxtNewPrnAmt(oRow.get("new_principal_amt").getString());
         oLoanRescheduleBean.setTxtOutPrn(oRow.get("principal_outstandng").getString());
         oLoanRescheduleBean.setTxtOutInt(oRow.get("interest_outstanding").getString());
         oLoanRescheduleBean.setTxtAlreadyPrn(oRow.get("old_principal_installs").getString());
         oLoanRescheduleBean.setTxtAlreadyInt(oRow.get("old_interest_installs").getString());       
         oLoanRescheduleBean.setTxtNewIntAmt(oRow.get("new_interest_amt").getString());
        
        oHeaderList.add( oLoanRescheduleBean);
      }          
    return oHeaderList;
  }
    
   public BaseHeaderBean getLoanRescheduleDtls(LoanRescheduleVO oLoanRescheduleVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    LoanRescheduleBean oLoanRescheduleBean=new LoanRescheduleBean();
    oParameters = new ArrayList();
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtLoanFlag()));
    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtEmpNo()));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR)); 
   
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtTransID()));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtLoan()));
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));
     oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER)); 
  //  oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_Getdtlbutton(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
    
/*      DBObject oErrCode = (DBObject)oOutArray.get(7);
     DBObject oErrMsg = (DBObject)oOutArray.get(8);
    
      Integer errCode=(Integer)oErrCode.getObject();
 
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
   //    oArguments.add((String)oErrMsg.getObject());
   //     System.out.println("Error!!! while getting CPF Final Details ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }else
      {
*/        DBObject txtPaidPrn=(DBObject)oOutArray.get(0);
        DBObject txtPaidInt=(DBObject)oOutArray.get(1);
        DBObject txtPaidPrnAmt=(DBObject)oOutArray.get(2);
        DBObject txtPaidIntAmt=(DBObject)oOutArray.get(3);
        DBObject txtLoanAmt=(DBObject)oOutArray.get(4);
        DBObject txtAlreadyPrn=(DBObject)oOutArray.get(5);
        DBObject txtAlreadyInt=(DBObject)oOutArray.get(6);      
        
        oLoanRescheduleBean.setTxtPaidPrn((String)txtPaidPrn.getObject());
        oLoanRescheduleBean.setTxtPaidInt((String)txtPaidInt.getObject());
        oLoanRescheduleBean.setTxtPaidPrnAmt((String)txtPaidPrnAmt.getObject());
        
        oLoanRescheduleBean.setTxtPaidIntAmt((String)txtPaidIntAmt.getObject());
        oLoanRescheduleBean.setTxtLoanAmt((String)txtLoanAmt.getObject());
        oLoanRescheduleBean.setTxtAlreadyPrn((String)txtAlreadyPrn.getObject());
        oLoanRescheduleBean.setTxtAlreadyInt((String)txtAlreadyInt.getObject());     
        
// }
    return oLoanRescheduleBean;
 } 
 
 public BaseHeaderBean getInterestDtls(LoanRescheduleVO oLoanRescheduleVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    LoanRescheduleBean oLoanRescheduleBean=new LoanRescheduleBean();
    oParameters = new ArrayList();
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtLoan()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtTransID()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtPaidPrnAmt()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtNewPrnInstal()));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtPaidPrn()));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtNewIntInstal()));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,oLoanRescheduleVO.getTxtLoanFlag())); 
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER)); 
    
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_CalcRescheduleInt(?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
    
    
/*      DBObject oErrCode = (DBObject)oOutArray.get(7);
     DBObject oErrMsg = (DBObject)oOutArray.get(8);
    
      Integer errCode=(Integer)oErrCode.getObject();
 
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
   //    oArguments.add((String)oErrMsg.getObject());
   //     System.out.println("Error!!! while getting CPF Final Details ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }else
      {
*/      DBObject txtIntAmtRem=(DBObject)oOutArray.get(0);
        DBObject txtNewPrnAmt=(DBObject)oOutArray.get(1);
        DBObject txtNewMnthIntAmt=(DBObject)oOutArray.get(2);
        
        oLoanRescheduleBean.setTxtOutInt((String)txtIntAmtRem.getObject());
        oLoanRescheduleBean.setTxtNewPrnAmt((String)txtNewPrnAmt.getObject());
        oLoanRescheduleBean.setTxtNewIntAmt((String)txtNewMnthIntAmt.getObject());
              
// }
    return oLoanRescheduleBean;
 }
 
 
 public LovVO getLoanRescheduleEmpLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    
    String sEmpNo,sCPF,sName;
    sEmpNo=oLovQueryVO.getSearchField1();
    sCPF=oLovQueryVO.getSearchField2();
    sName=oLovQueryVO.getSearchField3();
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sEmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sCPF));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, sName)); 
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_EmpNoLOVQ_LoanReschedule(?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("NAME1").getString());
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
}