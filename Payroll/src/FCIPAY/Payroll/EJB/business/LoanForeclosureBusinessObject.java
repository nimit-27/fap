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

public class LoanForeclosureBusinessObject extends BaseBO 
{
  public LoanForeclosureBusinessObject()
  {
  }
  
    public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("MaintLoanForeclosure"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

   public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    //  if(sScreenName.equals("MaintLoanForeclosure"))
    
      saveLoanForeclosureDetails(oBaseHeaderBean);
    
     
 return null;
 }

 public  void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
    
  }

  
   public RecordMetaInfo getLoanForeclosureHeaderMetaInfo(LoanForeclosureVO oLoanForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
   Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    
   String screenName=oLoanForeclosureVO.getScreenName();

    oParameters = new ArrayList();
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
 
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_CountLoanForeclosure (?,?,?,?)");
    

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
   oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }

  

  public LovVO getEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
   // arylstVisibility.add(EnrgiseConstants.HIDDEN);
   // arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_EmpNoLOV_LoanForeclosure(?,?,?,?,?,?,?)");
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

  public LovVO getLoanDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanForeclosuredtlLOV(?,?,?)");
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






 public LovVO getLoanDtlLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, sCPF));     
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, sName));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_EmpNoLOVQ_LoanForeclosure(?,?,?,?,?,?,?)");
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
   }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
 
 
 private String saveLoanForeclosureDetails(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
 {
   ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    String errorMsg="";

    LoanForeclosureBean oLoanForeclosureBean = (LoanForeclosureBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters = new ArrayList();     
      /* Loan/Advance Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtLoan())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtOutPrn())));
      // current location will be passed for trasfer from field.
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtOutInt())));         
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtReceiptNo())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtUserID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtSiteID())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtTransID())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtLoanFlag())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtPaidInt())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureBean.getTxtReceiptAmt())));    
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_InsertLoan_Foreclosure(?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
   
      DBObject oOutObject = (DBObject)oOutArray.get(0);
     // return (String)oOutObject.getObject(); 
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println(""+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
       // else 
        //{
            //  ArrayList oArguments = new ArrayList();   
            //  oArguments.add(new String(errorMsg));  
           //   throw new EnrgiseApplicationException("Pay.Forclose_Message",oArguments); 
      //  }
     return errorMsg;
      }
      
      
      
      
      public ArrayList getLoanForeclosureHeader(LoanForeclosureVO oLoanForeclosureVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oLoanForeclosureVO == null)
    {
      oLoanForeclosureVO = new LoanForeclosureVO();
    }
    
    String screenName=oLoanForeclosureVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    
    oParameters = new ArrayList();   
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oLoanForeclosureVO.getLoginLocCode())));  
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanForeclosureVO.getTxtTransID()))); 
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
   
    {
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_ExecuteLoanForeclosure(?,?,?,?,?)");
    }
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    LoanForeclosureBean oLoanForeclosureBean;
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
        oLoanForeclosureBean = new  LoanForeclosureBean();

         oLoanForeclosureBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
         oLoanForeclosureBean.setTxtEmpName(oRow.get("NAME1").getString());    
         oLoanForeclosureBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
         oLoanForeclosureBean.setTxtEmpCategory(oRow.get("EMP_CATEGORY").getString());
         oLoanForeclosureBean.setTxtEmpType(oRow.get("EMP_TYPE").getString());
         oLoanForeclosureBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString()); 
          oLoanForeclosureBean.setTxtEmpCPF(oRow.get("CPF_CODE").getString()); 
         oLoanForeclosureBean.setTxtLoan(oRow.get("Loan_id").getString());   
         oLoanForeclosureBean.setTxtLoanDesc(oRow.get("pay_code_desc").getString()); 
         oLoanForeclosureBean.setTxtLoanAmt(oRow.get("LoanAmt").getString()); 
         oLoanForeclosureBean.setTxtPaidPrn(oRow.get("paid_principal_amt").getString());               
         //oLoanForeclosureBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
         oLoanForeclosureBean.setTxtPaidInt(oRow.get("paid_interest_amt").getString());
         oLoanForeclosureBean.setTxtReceiptNo(oRow.get("receipt_num").getString());
         oLoanForeclosureBean.setTxtSysdate(oRow.get("fore_closure_dt").getString());
         oLoanForeclosureBean.setTxtOutPrn(oRow.get("outstanding_principal").getString());
         oLoanForeclosureBean.setTxtOutInt(oRow.get("outstanding_interest").getString());
         oLoanForeclosureBean.setTxtMonPrnAmt(oRow.get("Monthly_Principal").getString());
         oLoanForeclosureBean.setTxtMonIntAmt(oRow.get("Monthly_Int").getString());
         oLoanForeclosureBean.setTxtPrnInstalNo(oRow.get("Num_Prn").getString());
         oLoanForeclosureBean.setTxtIntInstalNo(oRow.get("Num_Int").getString());
         oLoanForeclosureBean.setTxtReceiptAmt(oRow.get("receipt_amt").getString());
        
        oHeaderList.add( oLoanForeclosureBean);
      }    
      
    return oHeaderList;
  }
  
  public BaseHeaderBean getLoanForeclosureDtls(LoanForeclosureVO oLoanForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    LoanForeclosureBean oLoanForeclosure=new LoanForeclosureBean();
    oParameters = new ArrayList();
    
    
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtLoanFlag()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtLoan()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtTransID()));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtT()));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR)); 
  
     oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER)); 
  //  oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetForeclosureDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);    
    
        DBObject txtLoanAmt=(DBObject)oOutArray.get(0);
        DBObject txtPrnInstalNo=(DBObject)oOutArray.get(1);
        DBObject txtIntInstalNo=(DBObject)oOutArray.get(2);
        DBObject txtBalPrnInstal=(DBObject)oOutArray.get(3);
        DBObject txtBalIntInstal=(DBObject)oOutArray.get(4);
        DBObject txtMonPrnAmt=(DBObject)oOutArray.get(5);
        DBObject txtMonIntAmt=(DBObject)oOutArray.get(6);
        DBObject txtPaidPrn=(DBObject)oOutArray.get(7);
        DBObject txtPaidInt=(DBObject)oOutArray.get(8);
        
        oLoanForeclosure.setTxtLoanAmt((String)txtLoanAmt.getObject());
        oLoanForeclosure.setTxtPrnInstalNo((String)txtPrnInstalNo.getObject());
        oLoanForeclosure.setTxtIntInstalNo((String)txtIntInstalNo.getObject());
        
        oLoanForeclosure.setTxtBalPrnInstal((String)txtBalPrnInstal.getObject());
        oLoanForeclosure.setTxtBalIntInstal((String)txtBalIntInstal.getObject());
        oLoanForeclosure.setTxtMonPrnAmt((String)txtMonPrnAmt.getObject());
        oLoanForeclosure.setTxtMonIntAmt((String)txtMonIntAmt.getObject());
        oLoanForeclosure.setTxtPaidPrn((String)txtPaidPrn.getObject());
        oLoanForeclosure.setTxtPaidInt((String)txtPaidInt.getObject());     
    return oLoanForeclosure;
 }
 
 
 
 
 
 
 
 public BaseHeaderBean getForecloseInterestDtls(LoanForeclosureVO oLoanForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    LoanForeclosureBean oLoanForeclosureBean=new LoanForeclosureBean();
    oParameters = new ArrayList();
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtLoanFlag())); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtLoan()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLoanForeclosureVO.getTxtTransID()));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));  
    
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));     
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_InterestCalcForeclosure(?,?,?,?,?,?,?,?)",true,true);
    
    
        DBObject txtPaidInt=(DBObject)oOutArray.get(0);
        DBObject txtPaidPrn=(DBObject)oOutArray.get(1);    
        
        oLoanForeclosureBean.setTxtPaidInt((String)txtPaidInt.getObject());
        oLoanForeclosureBean.setTxtPaidPrn((String)txtPaidPrn.getObject());      
    return oLoanForeclosureBean;
 }
  
  
}