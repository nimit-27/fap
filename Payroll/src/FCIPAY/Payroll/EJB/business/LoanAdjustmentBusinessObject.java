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
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanAdjustmentVO;
import FCIPAY.Payroll.UTILITY.LoanAdjustmentHeaderBean;

public class LoanAdjustmentBusinessObject extends BaseBO 
{
  public LoanAdjustmentBusinessObject()
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
    return null;
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    String errorMsg ="";
    LoanAdjustmentHeaderBean oLoanAdjustmentHeaderBean = (LoanAdjustmentHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtOutAson())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtOpenYYMM())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtLoan()))); 
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtLoanFlag())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtAdjOutAson())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtTransID())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtPaidPrnAmt())));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_set_loan_mnth_opbal(?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
   
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

   }

  public LovVO getLoanAdjustmentLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");    
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
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtOpenYYMM"))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_getLoanAdjustmentLOVDataQ(?,?,?,?,?,?,?,?)");
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
    LoanAdjustmentHeaderBean oLoanAdjustmentHeaderBean=(LoanAdjustmentHeaderBean)oBaseHeaderBean;    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentHeaderBean.getHdnEmpLbrFlag())));
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
          
  public RecordMetaInfo getLoanAdjustHeaderMetaInfo(LoanAdjustmentVO oLoanAdjustmentVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentVO.getTxtTransID())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
 
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_CountYymm_Opbal (?,?,?,?,?)");

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }
      
  public ArrayList getLoanAdjustHeader(LoanAdjustmentVO oLoanAdjustmentVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    if(oLoanAdjustmentVO == null)
    {
      oLoanAdjustmentVO = new LoanAdjustmentVO();
    }
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentVO.getTxtOpenYYMM())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanAdjustmentVO.getTxtTransID())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_get_yymm_opbal(?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    LoanAdjustmentHeaderBean oLoanAdjustmentHeaderBean;
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
        oLoanAdjustmentHeaderBean = new  LoanAdjustmentHeaderBean();

         oLoanAdjustmentHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
         oLoanAdjustmentHeaderBean.setTxtEmpName(oRow.get("NAME1").getString());    
         oLoanAdjustmentHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
         oLoanAdjustmentHeaderBean.setTxtEmpCategory(oRow.get("EMP_CATEGORY").getString());
         oLoanAdjustmentHeaderBean.setTxtEmpType(oRow.get("EMP_TYPE").getString());
         oLoanAdjustmentHeaderBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString()); 
         oLoanAdjustmentHeaderBean.setTxtEmpCPF(oRow.get("CPF_CODE").getString()); 
         oLoanAdjustmentHeaderBean.setTxtLoan(oRow.get("Loan_id").getString());   
         oLoanAdjustmentHeaderBean.setTxtLoanDesc(oRow.get("pay_code_desc").getString());  
         oLoanAdjustmentHeaderBean.setTxtLoanAmt(oRow.get("loan_open_bal").getString());
         oLoanAdjustmentHeaderBean.setTxtOutPrn(oRow.get("As_on_today").getString());
         oLoanAdjustmentHeaderBean.setTxtOutAson(oRow.get("as_on_yymm").getString());
         oLoanAdjustmentHeaderBean.setTxtPaidPrnAmt(oRow.get("Monthly_instal").getString());                        
         oLoanAdjustmentHeaderBean.setTxtAlreadyPrn(oRow.get("total_principal_instls").getString());
         oLoanAdjustmentHeaderBean.setTxtPaidPrn(oRow.get("bal_principal_instls").getString());
         oLoanAdjustmentHeaderBean.setTxtTransID(oRow.get("TRANSMAST_ID").getString());
         oLoanAdjustmentHeaderBean.setTxtLoanFlag(oRow.get("loan_flag").getString());
         oLoanAdjustmentHeaderBean.setTxtOpenYYMM(oRow.get("YYMM").getString());
         oLoanAdjustmentHeaderBean.setTxtRecvYYMM(oRow.get("RECOVERY_YYMM").getString());
         oHeaderList.add( oLoanAdjustmentHeaderBean);
      }          
    return oHeaderList;
  }
    
   public BaseHeaderBean getAdjustmentDtls(LoanAdjustmentVO oLoanAdjustmentVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    LoanAdjustmentHeaderBean oLoanAdjustmentHeaderBean=new LoanAdjustmentHeaderBean();
    oParameters = new ArrayList();
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanAdjustmentVO.getTxtLoanFlag()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanAdjustmentVO.getTxtEmpNo()));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR)); 
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,oLoanAdjustmentVO.getTxtTransID()));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,oLoanAdjustmentVO.getTxtLoan()));
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER)); 
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_Getdtlbutton(?,?,?,?,?,?,?,?,?,?,?,?,?)");
 
        DBObject txtPaidPrn=(DBObject)oOutArray.get(0);
        DBObject txtPaidInt=(DBObject)oOutArray.get(1);
        DBObject txtPaidPrnAmt=(DBObject)oOutArray.get(2);
        DBObject txtPaidIntAmt=(DBObject)oOutArray.get(3);
        DBObject txtLoanAmt=(DBObject)oOutArray.get(4);
        DBObject txtAlreadyPrn=(DBObject)oOutArray.get(5);
        DBObject txtAlreadyInt=(DBObject)oOutArray.get(6);      
        
        oLoanAdjustmentHeaderBean.setTxtPaidPrn((String)txtPaidPrn.getObject());
        oLoanAdjustmentHeaderBean.setTxtPaidInt((String)txtPaidInt.getObject());
        oLoanAdjustmentHeaderBean.setTxtPaidPrnAmt((String)txtPaidPrnAmt.getObject());
        
        oLoanAdjustmentHeaderBean.setTxtPaidIntAmt((String)txtPaidIntAmt.getObject());
        oLoanAdjustmentHeaderBean.setTxtLoanAmt((String)txtLoanAmt.getObject());
        oLoanAdjustmentHeaderBean.setTxtAlreadyPrn((String)txtAlreadyPrn.getObject());
        oLoanAdjustmentHeaderBean.setTxtAlreadyInt((String)txtAlreadyInt.getObject());     
        
    return oLoanAdjustmentHeaderBean;
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
  public LovVO getLoanAdjustDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Code");
    arylstHeaderNames.add("Description");   
    arylstHeaderNames.add("Balance Amount");
    arylstHeaderNames.add("TRANSMASTID");
    arylstHeaderNames.add("Loan/Advance");
    arylstHeaderNames.add("Recovery YYMM");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    oOutArray = oBean.callProc(oParameters,"PKG_LOAN.Get_LoanLOV_Adjustment (?,?,?)");
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
      //oLOVBean.setDetailField4(oRow.get("PENDING_INTEREST").getString());      
      oLOVBean.setDetailField4(oRow.get("transmast_id").getString());
      oLOVBean.setDetailField5(oRow.get("FLAG").getString());     
      oLOVBean.setDetailField6(oRow.get("RECOVERY_YYMM").getString());     
      oList.add(oLOVBean);
    }     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
}