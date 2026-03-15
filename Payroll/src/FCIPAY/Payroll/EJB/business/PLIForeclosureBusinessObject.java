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
import FCIPAY.Payroll.UTILITY.PLIForeclosureBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIForeclosureVO;


public class PLIForeclosureBusinessObject extends BaseBO 
{
  public PLIForeclosureBusinessObject()
  {
  }
  
    public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("MaintPLIForeclosure"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

   public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    //  if(sScreenName.equals("MaintLoanForeclosure"))
    
      savePLIForeclosureDetails(oBaseHeaderBean);
    
     
 return null;
 }

 public  void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
    
  }

  
   public RecordMetaInfo getPLIForeclosureHeaderMetaInfo(PLIForeclosureVO oPLIForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
   Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    
   String screenName=oPLIForeclosureVO.getScreenName();

    oParameters = new ArrayList();
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
 
      oOutArray = oBean.callProc(oParameters,"pkg_post_pli_ap.proc_CountPLIForeclosure (?,?,?,?)");
    

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
    ArrayList oParameters = new ArrayList(); 
    ArrayList oList;
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    oParameters = new ArrayList();  
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sEmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sCPF));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sName));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));
    oOutArray = oBean.callProc(oParameters,"pkg_post_pli_ap.proc_EmpNoLOV_PLIForeclosure(?,?,?,?,?,?,?)");
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

  public LovVO getPLIDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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






 public LovVO getPLIDtlLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oOutArray = oBean.callProc(oParameters,"pkg_post_pli_ap.proc_EmpNoLOVQ_PLIForeclosure(?,?,?,?,?,?,?)");
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
 
 
 private String savePLIForeclosureDetails(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
 {
   ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    String errorMsg="";

    PLIForeclosureBean oPLIForeclosureBean = (PLIForeclosureBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters = new ArrayList();     
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtFinyr())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtOutPrn())));
     oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtReceiptNo())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtUserID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtSiteID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtTransID())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtLoanFlag())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtReceiptAmt()))); 
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureBean.getTxtFinyr()))); 
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_post_pli_ap.proc_InsertPLI_Foreclosure(?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
   
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
      
      
      
      
 public ArrayList getPLIForeclosureHeader(PLIForeclosureVO oPLIForeclosureVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oPLIForeclosureVO == null)
    {
      oPLIForeclosureVO = new PLIForeclosureVO();
    }
    
    String screenName=oPLIForeclosureVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    
    oParameters = new ArrayList();   
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIForeclosureVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
   
    {
      oOutArray = oBean.callProc(oParameters,"pkg_post_pli_ap.proc_ExecutePLIForeclosure(?,?,?)");
    }
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    PLIForeclosureBean oPLIForeclosureBean;
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
        oPLIForeclosureBean = new  PLIForeclosureBean();

         oPLIForeclosureBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
         oPLIForeclosureBean.setTxtEmpName(oRow.get("NAME1").getString());    
         oPLIForeclosureBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
         oPLIForeclosureBean.setTxtEmpCategory(oRow.get("EMP_CATEGORY").getString());
         oPLIForeclosureBean.setTxtEmpType(oRow.get("EMP_TYPE").getString());
         oPLIForeclosureBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString()); 
         oPLIForeclosureBean.setTxtEmpCPF(oRow.get("CPF_CODE").getString()); 
         oPLIForeclosureBean.setTxtFinyr(oRow.get("FinYr").getString());
         oPLIForeclosureBean.setTxtPLIAmt(oRow.get("PLIAmt").getString()); 
         oPLIForeclosureBean.setTxtOutPrn(oRow.get("PLIbal").getString());
         oPLIForeclosureBean.setTxtReceiptAmt(oRow.get("receipt_amt").getString());
         oPLIForeclosureBean.setTxtTransID(oRow.get("trans_id").getString());
         oPLIForeclosureBean.setTxtReceiptNo(oRow.get("receipt_num").getString());
         oPLIForeclosureBean.setTxtInvoiceNo(oRow.get("invoice_num").getString());
         oHeaderList.add( oPLIForeclosureBean);
      }    
      
    return oHeaderList;
  }
  
  public BaseHeaderBean getPLIForeclosureDtls(PLIForeclosureVO oPLIForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    PLIForeclosureBean oPLIForeclosure=new PLIForeclosureBean();
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPLIForeclosureVO.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oPLIForeclosureVO.getTxtLoanFlag()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPLIForeclosureVO.getTxtFinyr()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oPLIForeclosureVO.getTxtTransID()));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oPLIForeclosureVO.getTxtT()));
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
    
        DBObject txtPLIAmt=(DBObject)oOutArray.get(0);
      //  DBObject txtPrnInstalNo=(DBObject)oOutArray.get(1);
     //   DBObject txtIntInstalNo=(DBObject)oOutArray.get(2);
       // DBObject txtBalPrnInstal=(DBObject)oOutArray.get(3);
     //   DBObject txtBalIntInstal=(DBObject)oOutArray.get(4);
    //    DBObject txtMonPrnAmt=(DBObject)oOutArray.get(5);
    //    DBObject txtMonIntAmt=(DBObject)oOutArray.get(6);
        DBObject txtPaidPrn=(DBObject)oOutArray.get(1);
    //    DBObject txtPaidInt=(DBObject)oOutArray.get(8);
        
        oPLIForeclosure.setTxtPLIAmt((String)txtPLIAmt.getObject());
       // oPLIForeclosure.setTxtPrnInstalNo((String)txtPrnInstalNo.getObject());
       // oPLIForeclosure.setTxtIntInstalNo((String)txtIntInstalNo.getObject());
        
      //  oPLIForeclosure.setTxtBalPrnInstal((String)txtBalPrnInstal.getObject());
       // oPLIForeclosure.setTxtBalIntInstal((String)txtBalIntInstal.getObject());
      //  oPLIForeclosure.setTxtMonPrnAmt((String)txtMonPrnAmt.getObject());
      //  oPLIForeclosure.setTxtMonIntAmt((String)txtMonIntAmt.getObject());
        oPLIForeclosure.setTxtPaidPrn((String)txtPaidPrn.getObject());
      //  oPLIForeclosure.setTxtPaidInt((String)txtPaidInt.getObject());     
    return oPLIForeclosure;
 }
 
 
}