package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveTravelConcessionQueryVO;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.UTILITY.LTCEncashHeaderBean;
import FCIPAY.Payroll.UTILITY.LeaveTravelConcessionHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;

import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;

public class LeaveTravelConcessionBusinessObject  extends BaseBO{
 public LeaveTravelConcessionBusinessObject() {
        
 }


 public LovVO getEmpLTCLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oOutArray = oBean.callProc(oParameters,"pkg_ltc_reimbursement.proc_GetEmpLTCReimbQ(?,?,?,?,?,?)");
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
 
 public LovVO getEmpLTCLOVN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oOutArray = oBean.callProc(oParameters,"pkg_ltc_reimbursement.proc_GetEmpLTCReimbLOV(?,?,?,?,?,?)");
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
    
 public RecordMetaInfo getLeaveTravelConcessionHeaderMetaInfo(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      Timestamp oWhenPicked = null;
      int count = 0;
      BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
      ArrayList oOutArray; //Output
      
      String screenName=oLeaveTravelConcessionQueryVO.getScreenName();

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaveTravelConcessionQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionQueryVO.getTxtEmpNo())));    
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      
      oOutArray = oBean.callProc(oParameters,"pkg_ltc_reimbursement.proc_GetEmpLTCReimbDtlCnt(?,?,?,?,?,?)");
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;    
 }


 public ArrayList getLeaveTravelConcessionHeader(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;

      if(oLeaveTravelConcessionQueryVO == null)
      {
        oLeaveTravelConcessionQueryVO = new LeaveTravelConcessionQueryVO();
      }
      
      String screenName=oLeaveTravelConcessionQueryVO.getScreenName();
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;  
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaveTravelConcessionQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getTxtEmpNo())).toUpperCase()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_ltc_reimbursement.proc_GetEmpLTCReimbDtl(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   
      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      LeaveTravelConcessionHeaderBean oLeaveTravelConcessionHeaderBean;
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
          oLeaveTravelConcessionHeaderBean = new LeaveTravelConcessionHeaderBean();

          oLeaveTravelConcessionHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
          oLeaveTravelConcessionHeaderBean.setTxtEmpName(oRow.get("empName").getString());    
          oLeaveTravelConcessionHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
          oLeaveTravelConcessionHeaderBean.setTxtCategDesc(oRow.get("category").getString());
          oLeaveTravelConcessionHeaderBean.setTxtEmpType(oRow.get("emp_type_det").getString()); 
          oLeaveTravelConcessionHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());          
          oLeaveTravelConcessionHeaderBean.setTxtPresentPOPDesc(oRow.get("loc_desc").getString());               
          oLeaveTravelConcessionHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
          oLeaveTravelConcessionHeaderBean.setTxtEmpStatus(oRow.get("emp_status_det").getString());
          oLeaveTravelConcessionHeaderBean.setTxtCurrBas(oRow.get("basic").getString());
          
          oLeaveTravelConcessionHeaderBean.setHeaderPrimaryKey(oRow.get("ltc_reimburse_id").getString());
          oLeaveTravelConcessionHeaderBean.setTxtSnctnDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("sanction_dt").getDate()));
          oLeaveTravelConcessionHeaderBean.setTxtApplnDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("application_dt").getDate()));
          oLeaveTravelConcessionHeaderBean.setTxtYYYY(oRow.get("block_yr").getString());
          oLeaveTravelConcessionHeaderBean.setTxtLTCType(oRow.get("ltc_type").getString());
          oLeaveTravelConcessionHeaderBean.setTxtPayModeType(oRow.get("pay_mode").getString());
          oLeaveTravelConcessionHeaderBean.setTxtTicketAmount(oRow.get("ticket_amt").getString());
          oLeaveTravelConcessionHeaderBean.setTxtDedIT(oRow.get("it_ded").getString());
          oLeaveTravelConcessionHeaderBean.setTxtDedOthr(oRow.get("othr_ded").getString());
          oLeaveTravelConcessionHeaderBean.setTxtNetAmt(oRow.get("net_amt").getString());
          oLeaveTravelConcessionHeaderBean.setTxtRmrks(oRow.get("rmrks").getString());
          oLeaveTravelConcessionHeaderBean.setTxtInvId(oRow.get("invoice_id").getString());

          oLeaveTravelConcessionHeaderBean.setTxtSnctnNo(oRow.get("sanction_no").getString());
          oLeaveTravelConcessionHeaderBean.setTxtPersonNo(oRow.get("no_of_person").getString());
          oLeaveTravelConcessionHeaderBean.setTxtTravelDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("travel_dt").getDate()));
          oLeaveTravelConcessionHeaderBean.setTxtTravelPlace(oRow.get("travel_place").getString());
          oLeaveTravelConcessionHeaderBean.setTxtOtherTravelPlace(oRow.get("other_travel_place").getString());
          oLeaveTravelConcessionHeaderBean.setTxtTravelMode(oRow.get("mode_of_travel").getString());
          oLeaveTravelConcessionHeaderBean.setTxtOtherTravelMode(oRow.get("other_mode_of_travel").getString());
          oHeaderList.add(oLeaveTravelConcessionHeaderBean);
        }    
        
      return oHeaderList;
 }  

 
 public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
 {
  ArrayList oParameters = new ArrayList(); //Input Parameters
  DBUtilitiesBean oBean = new DBUtilitiesBean();
  ArrayList oList;
  String sPayModeType; 
  int count = 0;
  int i=0;
  LeaveTravelConcessionHeaderBean oLeaveTravelConcessionHeaderBean = (LeaveTravelConcessionHeaderBean)oBaseHeaderBean;
  ArrayList oOutArray; //Output     

    oParameters = new ArrayList();     
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtLTCType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtYYYY())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtDedIT())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtDedOthr())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtNetAmt())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtPayModeType())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtRmrks())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveTravelConcessionHeaderBean.getTxtSnctnDt())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLeaveTravelConcessionHeaderBean.getTxtApplnDt())));
    
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtSiteID())));
    
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtSnctnNo())));
    oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtTravelPlace())));
    oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtOtherTravelPlace())));
    oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtTravelDt())));
    oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtTravelMode())));
    oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtOtherTravelMode())));
    oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtPersonNo())));
    oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtTicketAmount())));
        
    oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(22,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(23,DBObject.OUT,ParameterTypes.INTEGER));

    oOutArray = oBean.callProc(oParameters,"pkg_ltc_reimbursement.proc_InsertPayLTCReimb(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");        
 
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    DBObject oErrObject = (DBObject)oOutArray.get(1);
    System.out.println("Error while inserting LTC REIMBURSEMENT ::"+oErrObject.getObject());  
    return (String)oOutObject.getObject(); 
        
 }

 @Override
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException {
        ArrayList<DBObject> oParameters = new ArrayList<>(); // Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        LeaveTravelConcessionHeaderBean oLeaveTravelConcessionHeaderBean = (LeaveTravelConcessionHeaderBean) oBaseHeaderBean;
        ArrayList<DBObject> oOutArray; // Output

        // Prepare input parameters with safe parsing for integers
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getHeaderPrimaryKey())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, oLeaveTravelConcessionHeaderBean.getTxtLTCType()));
        oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR, oLeaveTravelConcessionHeaderBean.getTxtYYYY()));
        oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getTxtDedIT())));
        oParameters.add(new DBObject(6, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getTxtDedOthr())));
        oParameters.add(new DBObject(7, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getTxtNetAmt())));
        oParameters.add(new DBObject(8, DBObject.IN, ParameterTypes.VARCHAR, oLeaveTravelConcessionHeaderBean.getTxtPayModeType()));
        oParameters.add(new DBObject(9, DBObject.IN, ParameterTypes.VARCHAR, oLeaveTravelConcessionHeaderBean.getTxtRmrks()));
        oParameters.add(new DBObject(10, DBObject.IN, ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oLeaveTravelConcessionHeaderBean.getTxtSnctnDt())));
        oParameters.add(new DBObject(11, DBObject.IN, ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oLeaveTravelConcessionHeaderBean.getTxtApplnDt())));
        oParameters.add(new DBObject(12, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(13, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(14, DBObject.IN, ParameterTypes.VARCHAR, oLeaveTravelConcessionHeaderBean.getTxtSnctnNo()));
        oParameters.add(new DBObject(15, DBObject.IN, ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oLeaveTravelConcessionHeaderBean.getTxtTravelDt())));
        oParameters.add(new DBObject(16, DBObject.IN, ParameterTypes.INTEGER, safeParseInt(oLeaveTravelConcessionHeaderBean.getTxtTicketAmount())));
        oParameters.add(new DBObject(17, DBObject.OUT, ParameterTypes.VARCHAR)); // errmsg
        oParameters.add(new DBObject(18, DBObject.OUT, ParameterTypes.INTEGER)); // errorcode

        // Call the procedure
        oOutArray = oBean.callProc(oParameters, "pkg_ltc_reimbursement.proc_UpdatePayLTCReimb(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", true, true);

        // Handle errors from the procedure call
        Integer errcode = (Integer) ((DBObject) oOutArray.get(1)).getObject();
        if (errcode.intValue() != 0) {
            ArrayList<String> oArguments = new ArrayList<>();
            oArguments.add((String) ((DBObject) oOutArray.get(0)).getObject());
            ArrayList<EnrgiseApplicationException> oList = new ArrayList<>();
            oList.add(new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE", oArguments));
            reportError(oList);
        }
    }

    // Helper method to safely parse integers from strings
    private Integer safeParseInt(String value) {
        try {
            if (value == null || value.trim().isEmpty()) {
                return null; // or 0 depending on business rules
            }
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return null; // or handle error/logging if needed
        }
    }



 public ArrayList getLeaveTravelConcessionITDed(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    if(oLeaveTravelConcessionQueryVO == null)
    {
      oLeaveTravelConcessionQueryVO = new LeaveTravelConcessionQueryVO();
    }
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();      
    String sFlag=checkMaxPayYear(oLeaveTravelConcessionQueryVO);      
    oParamList.add(sFlag);
    return oParamList;
 }

 private String checkMaxPayYear(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oLeaveTravelConcessionQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionQueryVO.getHdnEmpLbrFlag())));
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

      if (sMonth.equals("03") )
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
 @Override
 public void saveDetailImpl(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, String sScreenName, ArrayList oDetailBeanArray) {
 }

 @Override
 public void initializeBOImpl(String sScreenName) {
 }

@Override
public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                          String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                          ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                          Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException{
    
    ArrayList oList=new ArrayList();
    LeaveTravelConcessionHeaderBean oLeaveTravelConcessionHeaderBean = (LeaveTravelConcessionHeaderBean)oBaseHeaderBean;
    checkYrEndRemittance(oBaseHeaderBean,oList);
    reportError(oList);
    if(sScreenMode.equals("N"))
    {
      checkMaxPayYear(oLeaveTravelConcessionHeaderBean.getTxtSiteID(),oLeaveTravelConcessionHeaderBean.getHdnEmpLbrFlag());
      reportError(oList);
      checkDuplicate(oBaseHeaderBean,sScreenName,sScreenMode,oList);
      reportError(oList);
    }
}

private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
{
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output
    ArrayList oRetList;
    QueryRow oRow = null;
    Iterator oIt = null;
    LeaveTravelConcessionHeaderBean oLeaveTravelConcessionHeaderBean = (LeaveTravelConcessionHeaderBean)oBaseHeaderBean;
    oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oLeaveTravelConcessionHeaderBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oLeaveTravelConcessionHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oLeaveTravelConcessionHeaderBean.getTxtSiteID())));
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

private String checkMaxPayYear(String siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
{
  ArrayList oParameters = null;
  DBUtilitiesBean oBean = new DBUtilitiesBean();
  int count = 0;
  ArrayList oOutArray; 
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
  
 // int iStat=Integer.parseInt(status);
  if(status!=null && status.equals("Y"))
  {
    throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
  }
  
  return "";
}

private void checkDuplicate(BaseHeaderBean oBaseHeaderBean,String sScreenName,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
{
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    Integer chkFlag=new Integer(0);
    LeaveTravelConcessionHeaderBean oLeaveTravelConcessionHeaderBean = (LeaveTravelConcessionHeaderBean)oBaseHeaderBean;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLeaveTravelConcessionHeaderBean.getTxtYYYY())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_DuplLTCReimbCheck(?,?,?,?)");
    chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
    if(!chkFlag.equals(new Integer(0)))
    {        
      ArrayList oArguments = new ArrayList();
      oList.add(new EnrgiseApplicationException("Payroll.LTC.Reimbursement.dupliCheck",oArguments));
    }
}


    public String sendLeaveTravelConcessionInv(String sPrimaryKey,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();

      ArrayList oOutArray; //Output  
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.Proc_SendLTCReimbInvoice(?,?,?,?,?,?)",true,true);
      
      DBObject oOutObject = (DBObject)oOutArray.get(1);
      Integer errCode = (Integer)(oOutObject.getObject());
      
      oOutObject = (DBObject)oOutArray.get(0);
      String errMsg = (String)(oOutObject.getObject());
      
      String sRetMsg=errCode.toString()+","+errMsg;
      
      return sRetMsg;
    
}
    
    public String  deleteLeaveTravelConcession(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      String msg=null;
    
      if(oLeaveTravelConcessionQueryVO == null)
      {
        oLeaveTravelConcessionQueryVO = new LeaveTravelConcessionQueryVO();
      }
      
      String screenName=oLeaveTravelConcessionQueryVO.getScreenName();
      ArrayList oOutArray; //Output 
      ArrayList oParamList = new ArrayList();  
      
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oLeaveTravelConcessionQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getTxtEmpNo()))));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getTxtApplnDt()))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getTxtTicketAmount()))));     
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String("320"))));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getTxtYYYY()))));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new Long(oLeaveTravelConcessionQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_deleteLTCReimbursement(?,?,?,?,?,?,?,?,?)");
      
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
    
public String  cancelLeaveTravelConcessionInv(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      String msg=null;
    
      if(oLeaveTravelConcessionQueryVO == null)
      {
        oLeaveTravelConcessionQueryVO = new LeaveTravelConcessionQueryVO();
      }
      
      String screenName=oLeaveTravelConcessionQueryVO.getScreenName();
      ArrayList oOutArray; //Output 
      ArrayList oParamList = new ArrayList();  
      ArrayList oList = new ArrayList();  
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getTxtEmpNo()))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getTxtInvId()))));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLeaveTravelConcessionQueryVO.getScreenName()))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new Long(oLeaveTravelConcessionQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oLeaveTravelConcessionQueryVO.getUserId()))));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      
      oOutArray = oBean.callProc(oParameters,"pkg_cancel_othr_pymnt_inv.proc_cancel_op_invoices(?,?,?,?,?,?,?)",true,true);
      
     //   DBObject oErrObject = (DBObject)oOutArray.get(0);
     String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
        
      //  if(!errCode.equals(new Integer(0)))
       // {
       //    msg="Failed";
       // } 
        
      //   else if(  errCode.equals(new Integer(0)))
       // {
        //   msg="Success";
       // }   
             
      return errMsg;
}

@Override
public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                              String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                              ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                              Timestamp oDetailPicked) {
}

@Override
public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                             String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                             ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                             Timestamp oDetailPicked) {
}
}
