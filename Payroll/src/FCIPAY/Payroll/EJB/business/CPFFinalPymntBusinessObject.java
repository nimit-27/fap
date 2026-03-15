package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentBean;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentDetailBean;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPayComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentBaseDetailInfo;

public class CPFFinalPymntBusinessObject extends BaseBO 
{

  public CPFFinalPymntBusinessObject()
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

// THIS METHOD CANCELS THE SANCTION ORDER.
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    CPFFinalPaymentBean oCPFFinalPaymentBean = (CPFFinalPaymentBean)oBaseHeaderBean;
    ArrayList oOutArray=new ArrayList(); //Output   
    
      oParameters = new ArrayList();
      
   //   if(oCPFFinalPaymentBean.getHdnSancType().equals("A")||oCPFFinalPaymentBean.getHdnSancType().equals("P"))
  //    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getHeaderPrimaryKey())));     
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtUserID())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtSiteID()))); 
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));     
        oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_CancelCPFPartFnlAdv_Dtls(?,?,?,?,?)",true,true);        
     // }
      DBObject oErrMsg = (DBObject)oOutArray.get(0);
      DBObject oErrCode = (DBObject)oOutArray.get(1);
      Integer errCode=(Integer)oErrCode.getObject();
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add((String)oErrMsg.getObject());
        System.out.println("Error!!! while Cancelling Sanction Order ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    CPFFinalPaymentBean oCPFFinalPaymentBean = (CPFFinalPaymentBean)oBaseHeaderBean;
    ArrayList oOutArray=new ArrayList(); //Output   
    
      oParameters = new ArrayList();
      
      if(oCPFFinalPaymentBean.getHdnSancType().equals("A")||oCPFFinalPaymentBean.getHdnSancType().equals("P"))
      {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getSancOrderNo())));      
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oCPFFinalPaymentBean.getSancDate())));      
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getHdnSancType())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtEmpNo())));      
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getSancAmount())));      
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getNoInstallAmt())));      
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getInstallAmt())));            
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getFirstInstall()))); 
        
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getRecoveryYYMM())));     
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getWithdrEmpContri())));     
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getWithdrVpfContri())));      
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getWithdrEmplyrContri()))); 
        
                   
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtReason())));
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntInstall())));      
        oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getNoIntInstall())));
        
             
      //  oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtDedIT())));
        
        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtUserID())));
        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtSiteID()))); 
        //Added by Ankit on 16-June-2014
        oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean. getEmpContri()))); 
        oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getEmplyrContri()))); 
        oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getVpfContri()))); 
        oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtApplAmt()))); 
        oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getClaimReqId())));
		oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oCPFFinalPaymentBean.getPossDate())));
        oParameters.add(new DBObject(24,DBObject.OUT,ParameterTypes.VARCHAR)); 
        oParameters.add(new DBObject(25,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(26,DBObject.OUT,ParameterTypes.INTEGER));     
         oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_InsertCPFPartFnlAdv_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);         
      }
      else
      {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtEmpNo())));      
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oCPFFinalPaymentBean.getSancDate())));      
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getSancOrderNo())));
        
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtUserID())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtSiteID()))); 
        
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getEmpContri())));      
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getVpfContri())));      
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getEmplyrContri())));    
        
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstEmpContri())));            
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstVpfContri()))); 
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstEmplyrContri())));  
        
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstIntrvngPrd())));     
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTdsIntIntrvngPrd()))); 
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getClaimReqId()))); 

        oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR)); 
        oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(17,DBObject.OUT,ParameterTypes.INTEGER));     
        oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.Proc_InsertCPFFinal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
      
      }
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      DBObject oErrMsg = (DBObject)oOutArray.get(1);
      DBObject oErrCode = (DBObject)oOutArray.get(2);
      Integer errCode=(Integer)oErrCode.getObject();
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add((String)oErrMsg.getObject());
        System.out.println("Error!!! while Releasing Final Payment record CPF  ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
      return (String)oOutObject.getObject();      
  }

  public RecordMetaInfo getCPFFinPayHeaderMetaInfo(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String screenName=oCPFFinalPaymentQueryVO.getScreenName();
    String locCode = oCPFFinalPaymentQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getHdnSancType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    if (screenName.equals("CPFFinalPaymentScreen"))    
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFAdvanceCnt(?,?,?,?,?,?,?)");
    else
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFAdvanceCnt(?,?,?,?,?,?,?)");
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getCPFFinPayHeader(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oCPFFinalPaymentQueryVO == null)
    {
      oCPFFinalPaymentQueryVO = new CPFFinalPaymentQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String screenName=oCPFFinalPaymentQueryVO.getScreenName();
    String locCode = oCPFFinalPaymentQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
  //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
   // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getHdnSancType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    
    
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    
    if (screenName.equals("CPFFinalPaymentScreen"))    
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFAdvanceDtl(?,?,?,?,?,?)");
    else
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFAdvanceDtl(?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    CPFFinalPaymentBean oCPFFinalPaymentBean;
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
        oCPFFinalPaymentBean = new CPFFinalPaymentBean();
        // added by gagan on 01-07-2013 to add new sanction num
        oCPFFinalPaymentBean.setTxtSysSantionNum(oRow.get("sys_sanction_no").getString());
        // ended by gagan
        oCPFFinalPaymentBean.setHeaderPrimaryKey(oRow.get("sanction_no").getString());
        oCPFFinalPaymentBean.setTxtEmpNo(oRow.get("emp_num").getString());          
        oCPFFinalPaymentBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oCPFFinalPaymentBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oCPFFinalPaymentBean.setTxtCateg(oRow.get("emp_categ").getString());      
        oCPFFinalPaymentBean.setTxtEmpType(oRow.get("emp_type").getString());                
        oCPFFinalPaymentBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oCPFFinalPaymentBean.setTxtPresentPOP(oRow.get("loc_sdesc").getString());       
     //   oCPFFinalPaymentBean.setRemarks(oRow.get("remarks").getString());    
        oCPFFinalPaymentBean.setTxtEmpStatus(oRow.get("emp_stat").getString());
        oCPFFinalPaymentBean.setTxtStaffCode(oRow.get("staff_code").getString());

        if (screenName.equals("CPFFinalPaymentScreen")) 
        {
          oCPFFinalPaymentBean.setEmpContri(oRow.get("emp_subs").getString());
          oCPFFinalPaymentBean.setEmplyrContri(oRow.get("emplr_subs").getString());
          oCPFFinalPaymentBean.setVpfContri(oRow.get("vpf_subs").getString());
        }else
        {
          oCPFFinalPaymentBean.setEmpContri(oRow.get("employee_pf_close_bal").getString());
          oCPFFinalPaymentBean.setEmplyrContri(oRow.get("employer_pf_close_bal").getString());
          oCPFFinalPaymentBean.setVpfContri(oRow.get("vpf_close_bal").getString());
        }   
        oCPFFinalPaymentBean.setFirstInstall(oRow.get("first_instl_amt").getString());
        oCPFFinalPaymentBean.setInstallAmt(oRow.get("instl_amt").getString());
        oCPFFinalPaymentBean.setNoInstallAmt(oRow.get("num_prin_inst").getString());
        oCPFFinalPaymentBean.setRecoveryYYMM(oRow.get("recvry_yymm").getString());
        
        oCPFFinalPaymentBean.setIntInstall(oRow.get("INTR_INSTALL").getString());
        oCPFFinalPaymentBean.setNoIntInstall(oRow.get("NO_INTR_INSTALL").getString());
        oCPFFinalPaymentBean.setTxtReason(oRow.get("SANC_REASON").getString());
        
        oCPFFinalPaymentBean.setWithdrEmpContri(oRow.get("emp_subs_withwl").getString());
        oCPFFinalPaymentBean.setWithdrEmplyrContri(oRow.get("emplr_subs_withwl").getString());
        oCPFFinalPaymentBean.setWithdrVpfContri(oRow.get("vpf_subs_withwl").getString());
        
        oCPFFinalPaymentBean.setSancAmount(oRow.get("sanc_amt").getString());
        oCPFFinalPaymentBean.setSancDate(EnrgiseUtil.convertToString(oRow.get("sanc_date").getDate()));
        oCPFFinalPaymentBean.setSancOrderNo(oRow.get("sanc_order_no").getString());
        oCPFFinalPaymentBean.setTxtInvID(oRow.get("invoice_num").getString());
        
        oCPFFinalPaymentBean.setIntrstEmpContri(oRow.get("intr_emp_subs").getString());
        oCPFFinalPaymentBean.setIntrstEmplyrContri(oRow.get("intr_emplr_subs").getString());
        oCPFFinalPaymentBean.setIntrstVpfContri(oRow.get("intr_vpf_subs").getString());
        oCPFFinalPaymentBean.setIntrstIntrvngPrd(oRow.get("intr_intrv_period").getString());
        oCPFFinalPaymentBean.setTdsIntIntrvngPrd(oRow.get("tds_intrv_period").getString());
		//Added by Sonali
        oCPFFinalPaymentBean.setPossDate(EnrgiseUtil.convertToString(oRow.get("POSSESION_DATE").getDate()));
        //Added By amresh
        oCPFFinalPaymentBean.setClaimReqId(oRow.get("CLAIM_REQUEST_ID").getString());
        //Added by Ankit on 21-Jul-14
        oCPFFinalPaymentBean.setTxtApplAmt(oRow.get("max_app_amt").getString());
       // oCPFFinalPaymentBean.setTxtDedIT(oRow.get("IT_DEDUCTED").getString());
        String cancelStatus=oRow.get("cancel_flag").getString();
        String cancelDate=EnrgiseUtil.convertToString(oRow.get("cancel_dt").getDate());
        if(cancelStatus!=null && cancelStatus.equals("Y"))
          oCPFFinalPaymentBean.setCancelStatus("Sanction Order Cancelled on "+cancelDate);
        else if(cancelStatus!=null && cancelStatus.equals("R"))
          oCPFFinalPaymentBean.setCancelStatus("Payment Cancelled on "+cancelDate);
        else
          oCPFFinalPaymentBean.setCancelStatus("");
        oHeaderList.add(oCPFFinalPaymentBean);
      }  
      
    return oHeaderList;
    
  }

  public RecordMetaInfo getCPFReleasePayDetailMetaInfo(String sPrimaryKey,CPFFinalPaymentBaseDetailInfo oCPFFinalPaymentBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String screenName=oCPFFinalPaymentBaseDetailInfo.getScreenName();
    String locCode = oCPFFinalPaymentBaseDetailInfo.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBaseDetailInfo.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBaseDetailInfo.getHdnSancType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBaseDetailInfo.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    if (screenName.equals("CPFReleasePayScreen"))    
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFReleaseCnt(?,?,?,?,?,?,?)");
    else
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFReleaseCnt(?,?,?,?,?)");
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getCPFReleasePayDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,CPFFinalPaymentBaseDetailInfo oCPFFinalPaymentBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oCPFFinalPaymentBaseDetailInfo == null)
    {
      oCPFFinalPaymentBaseDetailInfo = new CPFFinalPaymentBaseDetailInfo();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String screenName=oCPFFinalPaymentBaseDetailInfo.getScreenName();
    String locCode = oCPFFinalPaymentBaseDetailInfo.getLoginLocCode()+"";
    oParameters = new ArrayList();
  //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
   // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBaseDetailInfo.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBaseDetailInfo.getHdnSancType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBaseDetailInfo.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    
    if (screenName.equals("CPFReleasePayScreen"))    
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFReleaseDtl(?,?,?,?,?,?)");
    else
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFReleaseDtl(?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    CPFFinalPaymentDetailBean oCPFFinalPaymentDetailBean;
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
        oCPFFinalPaymentDetailBean = new CPFFinalPaymentDetailBean();

        oCPFFinalPaymentDetailBean.setTxtEmpNoDtl(oRow.get("emp_num").getString());          
        oCPFFinalPaymentDetailBean.setTxtEmpNameDtl(oRow.get("EMP_NAME").getString()); 
        
        oCPFFinalPaymentDetailBean.setSancAmountDtl(oRow.get("sanc_amt").getString());
        oCPFFinalPaymentDetailBean.setSancDateDtl(EnrgiseUtil.convertToString(oRow.get("sanc_date").getDate()));
        oCPFFinalPaymentDetailBean.setSancOrderNoDtl(oRow.get("sanc_order_no").getString());
        oCPFFinalPaymentDetailBean.setDetailId(oRow.get("sanction_no").getString());
        oCPFFinalPaymentDetailBean.setFlgDedITDtl(oRow.get("monthflag").getString());
        oCPFFinalPaymentDetailBean.setTxtRecYYYYMM(oRow.get("Rec_YYMM_col").getString());
        oCPFFinalPaymentDetailBean.setTxtsancReason(oRow.get("code_desc").getString());
        oCPFFinalPaymentDetailBean.setTxtEmployeeCntr(oRow.get("EMP_SUBS_WITHWL").getString());
        oCPFFinalPaymentDetailBean.setTxtEmployerCntr(oRow.get("EMPLR_SUBS_WITHWL").getString());//
        oCPFFinalPaymentDetailBean.setClaimReqId(oRow.get("CLAIM_REQUEST_ID").getString());
        oCPFFinalPaymentDetailBean.setTxtInvoiceNo(oRow.get("invoice_num").getString());
        oCPFFinalPaymentDetailBean.setDedITDtl(oRow.get("it_deducted").getString());
        oCPFFinalPaymentDetailBean.setTxtDedIT(oRow.get("it_deducted").getString());
        oHeaderList.add(oCPFFinalPaymentDetailBean);
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
  
  public LovVO getEmpCPFFinPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");      
    arylstHeaderNames.add("CPF Code");      
    arylstHeaderNames.add("Location");  
    arylstHeaderNames.add("Emp Status");  
    arylstHeaderNames.add("Staff Code");    
    arylstHeaderNames.add("empcontri");    
    arylstHeaderNames.add("emplr Contri");    
    arylstHeaderNames.add("vpf Contri");    
    
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
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
  //  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));  
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFEmpLovN(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("emp_categ").getString());           
        oLOVBean.setDetailField5(oRow.get("emp_type").getString());           
        oLOVBean.setDetailField6(oRow.get("cpf_code").getString());                    
        oLOVBean.setDetailField7(oRow.get("loc_sdesc").getString());                 
        oLOVBean.setDetailField8(oRow.get("emp_stat").getString());
        oLOVBean.setDetailField9(oRow.get("staff_code").getString());    
        oLOVBean.setDetailField10(oRow.get("employee_pf_close_bal").getString());                 
        oLOVBean.setDetailField11(oRow.get("employer_pf_close_bal").getString());                 
        oLOVBean.setDetailField12(oRow.get("vpf_close_bal").getString());                 
              
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }  

  public LovVO getEmpCPFAdvPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");       
    arylstHeaderNames.add("CPF Code");     
    arylstHeaderNames.add("Location");  
    arylstHeaderNames.add("Emp Status");  
    arylstHeaderNames.add("Staff Code");    
    arylstHeaderNames.add("empcontri");    
    arylstHeaderNames.add("emplr Contri");    
    arylstHeaderNames.add("vpf Contri");    
    
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
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
   // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));  
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFEmpAdvLovN(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("emp_categ").getString());           
        oLOVBean.setDetailField5(oRow.get("emp_type").getString());           
        oLOVBean.setDetailField6(oRow.get("cpf_code").getString());                    
        oLOVBean.setDetailField7(oRow.get("loc_sdesc").getString());                 
        oLOVBean.setDetailField8(oRow.get("emp_stat").getString());
        oLOVBean.setDetailField9(oRow.get("staff_code").getString());    
        oLOVBean.setDetailField10(oRow.get("employee_pf_close_bal").getString());                 
        oLOVBean.setDetailField11(oRow.get("employer_pf_close_bal").getString());                 
        oLOVBean.setDetailField12(oRow.get("vpf_close_bal").getString());                 
              
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }  
  
  public LovVO getEmpCPFFinalPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");        
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");  
    arylstHeaderNames.add("Emp Status");  
    arylstHeaderNames.add("Staff Code"); 
    
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
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));  
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFSprEmpLovN(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("emp_categ").getString());           
        oLOVBean.setDetailField5(oRow.get("emp_type").getString());           
        oLOVBean.setDetailField6(oRow.get("cpf_code").getString());                    
        oLOVBean.setDetailField7(oRow.get("loc_sdesc").getString());                 
        oLOVBean.setDetailField8(oRow.get("emp_stat").getString());
        oLOVBean.setDetailField9(oRow.get("staff_code").getString());                  
              
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getQueryEmpCPFFinPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnSancType"))));   
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFEmpLovQ(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField3(oRow.get("cpf_code").getString());      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getQueryEmpCPFFinalPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnSancType"))));   
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFSprEmpLov(?,?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField3(oRow.get("cpf_code").getString());     
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getQueryEmpCPFReleasePayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnSancType")).trim()));   
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFRelLovQ(?,?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField3(oRow.get("cpf_code").getString());    
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
        CPFFinalPaymentBean oCPFFinalPaymentBean = (CPFFinalPaymentBean)oBaseHeaderBean;
        if(sScreenName.equals("CPFPartFinalPayScreen") && (!(oCPFFinalPaymentBean.equals("BFRRETR"))))
        {
            ArrayList oList = new ArrayList();
            checkYrEndRemittance(oBaseHeaderBean,oList);
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
        CPFFinalPaymentBean oCPFFinalPaymentBean = (CPFFinalPaymentBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oCPFFinalPaymentBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2, DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(3, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_othrPay_YrEndChk_CpfSanc(?,?,?)",true,true);
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
    ArrayList oList=new ArrayList();
    //validateCPFAmt(oBaseHeaderBean,sScreenMode,oList);
    reportError(oList);
  }
  
 /* private void validateCPFAmt(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      String chkFlag="";
      ComFinalHeaderBean oConvAllowHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowHeaderBean.getTxtGraSancAmt())));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_finalsettleparam_check(?,?,?)",true,true);
      chkFlag = (String)((DBObject)oOutArray.get(0)).getObject();
      if(chkFlag!=null &&(!chkFlag.equals("0SUCCESS")))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(chkFlag);
        oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
      }
      
  }  */
  
  public CPFFinalPayComboVO getCPFFinalPayComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CPFFinalPayComboVO oCPFFinalPayComboVO = new CPFFinalPayComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oSancType = null;
    ArrayList oAdvReason = null;
    ArrayList oPartReason = null;


 // Get Sanction Types....
 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetSancTypeLOV(?,?)");

    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }

    count = 0;
    oIt = oList.iterator();
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oSancType = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String label = oRow.get("code_desc").getString();
      String value = oRow.get("code_sdesc").getString();
      oComboVO = new ComboVO(label,value);
      oSancType.add(oComboVO);
    }
    oCPFFinalPayComboVO.setSancTypeList(oSancType);
    
     // Get Reasons for Advance....
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFAdvReason(?,?)");

    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }

    count = 0;
    oIt = oList.iterator();
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oAdvReason = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String label = oRow.get("code_desc").getString();
      String value = oRow.get("code_sdesc").getString();
      oComboVO = new ComboVO(label,value);
      oAdvReason.add(oComboVO);
    }
    oCPFFinalPayComboVO.setAdvReasonList(oAdvReason);
    
    //Get Reasons for Part Final Payments....
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetCPFPartFnlReason(?,?)");

    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }

    count = 0;
    oIt = oList.iterator();
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oPartReason = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String label = oRow.get("code_desc").getString();
      String value = oRow.get("code_sdesc").getString();
      oComboVO = new ComboVO(label,value);
      oPartReason.add(oComboVO);
    }
    oCPFFinalPayComboVO.setPartReasonList(oPartReason);
    return oCPFFinalPayComboVO;
  }
 
 public String realeaseCPFPay(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CPFFinalPaymentBean oCPFFinalPaymentBean=(CPFFinalPaymentBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output  
    
    String sancType=oCPFFinalPaymentBean.getHdnSancType();
    if(sancType.equals("P")||sancType.equals("A"))
    {
      checkYYMM(oCPFFinalPaymentBean);
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtDedIT()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getHdnRecYYMM()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtUserID()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtSiteID()));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.Proc_ReleaseAdvPartFinal(?,?,?,?,?,?,?)",true,true);
    }else
    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtEmpNo())));      
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oCPFFinalPaymentBean.getSancDate())));      
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getSancOrderNo())));
        
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtUserID())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTxtSiteID()))); 
        
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getEmpContri())));      
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getVpfContri())));      
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getEmplyrContri())));    
        
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstEmpContri())));            
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstVpfContri()))); 
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstEmplyrContri())));  
        
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getIntrstIntrvngPrd())));     
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentBean.getTdsIntIntrvngPrd()))); 
        
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getHeaderPrimaryKey())); 
        oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));     
        oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.Proc_ReleaseFinal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true); 
    }
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    
    String sRetMsg=errCode.toString()+","+errMsg;
    // Added by gagan on 18-05-2013
     if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add(errMsg);
        System.out.println("Error!!! "+errMsg);
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
    // Ended by gagan on 18-05-2013
    return sRetMsg;
 }
 
 public BaseHeaderBean getCPFFinalDtls(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    CPFFinalPaymentBean oCPFFinalPaymentBean=new CPFFinalPaymentBean();
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentQueryVO.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCPFFinalPaymentQueryVO.getSancDate())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oCPFFinalPaymentQueryVO.getUserId())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oCPFFinalPaymentQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); //1 emp contribution 
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR)); //2 vpf contribution
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); //3 employer contribution
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR)); //4 emp interest
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR)); //5 vpf interest
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR)); //6 emplyr interest
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR)); //7 int on intervening period
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR)); //8 TDS for intervening period
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR)); //9 Sanction Amount
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.VARCHAR)); //10 errMsg
    oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.INTEGER)); //11 errCode
    //oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.Proc_GetFinalDtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,false);
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.Proc_Get_final_amt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,false);
    
      DBObject oErrMsg = (DBObject)oOutArray.get(9);
      DBObject oErrCode = (DBObject)oOutArray.get(10);
      Integer errCode=(Integer)oErrCode.getObject();
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add((String)oErrMsg.getObject());
        System.out.println("Error!!! while getting CPF Final Details ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
        DBObject oEmpContr=(DBObject)oOutArray.get(0);
        DBObject oVpfContr=(DBObject)oOutArray.get(1);
        DBObject oEmplyrContr=(DBObject)oOutArray.get(2);
        DBObject oEmpInt=(DBObject)oOutArray.get(3);
        DBObject oVpfInt=(DBObject)oOutArray.get(4);
        DBObject oEmplyrInt=(DBObject)oOutArray.get(5);
        DBObject oIntrvngInt=(DBObject)oOutArray.get(6);
        DBObject oIntrvngTDS=(DBObject)oOutArray.get(7);
        DBObject oSancAmount=(DBObject)oOutArray.get(8);
        
        oCPFFinalPaymentBean.setEmpContri((String)oEmpContr.getObject());
        oCPFFinalPaymentBean.setVpfContri((String)oVpfContr.getObject());
        oCPFFinalPaymentBean.setEmplyrContri((String)oEmplyrContr.getObject());
        
        oCPFFinalPaymentBean.setIntrstEmpContri((String)oEmpInt.getObject());
        oCPFFinalPaymentBean.setIntrstVpfContri((String)oVpfInt.getObject());
        oCPFFinalPaymentBean.setIntrstEmplyrContri((String)oEmplyrInt.getObject());
        oCPFFinalPaymentBean.setIntrstIntrvngPrd((String)oIntrvngInt.getObject());
        oCPFFinalPaymentBean.setTdsIntIntrvngPrd((String)oIntrvngTDS.getObject());
        oCPFFinalPaymentBean.setSancAmount((String)oSancAmount.getObject());
    return oCPFFinalPaymentBean;
 }
 
 public BaseHeaderBean getMaxApplAmt(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    CPFFinalPaymentBean oCPFFinalPaymentBean=new CPFFinalPaymentBean();
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentQueryVO.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getTxtReason())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getEmpContri())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getEmplyrContri())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getVpfContri())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getHdnSancType())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCPFFinalPaymentQueryVO.getSancDate())));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR)); //1 Max Applicable Amount 
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR)); //2 errMsg
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER)); //3 errCode
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_GetMxApplAmt(?,?,?,?,?,?,?,?,?,?)",true,true);
    
      DBObject oErrMsg = (DBObject)oOutArray.get(1);
      DBObject oErrCode = (DBObject)oOutArray.get(2);
      Integer errCode=(Integer)oErrCode.getObject();
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add((String)oErrMsg.getObject());
        System.out.println("Error!!! while getting CPF Final Details ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }else
      {
        DBObject oApplAmt=(DBObject)oOutArray.get(0);
        oCPFFinalPaymentBean.setTxtApplAmt((String)oApplAmt.getObject());
      }
    return oCPFFinalPaymentBean;
 }
 
 public BaseHeaderBean getIntInst(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    CPFFinalPaymentBean oCPFFinalPaymentBean=new CPFFinalPaymentBean();
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getSancAmount())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFFinalPaymentQueryVO.getNoInstallAmt())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); //1 Int Install
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR)); //2 No of Int Install
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); //3 errMsg
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER)); //4 errCode
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_calcIntInstall(?,?,?,?,?,?)",true,true);
    
      DBObject oErrMsg = (DBObject)oOutArray.get(2);
      DBObject oErrCode = (DBObject)oOutArray.get(3);
      Integer errCode=(Integer)oErrCode.getObject();
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add((String)oErrMsg.getObject());
        System.out.println("Error!!! while getting Int Install ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }else
      {
        DBObject oIntInstall=(DBObject)oOutArray.get(0);
        oCPFFinalPaymentBean.setIntInstall((String)oIntInstall.getObject());
        
        DBObject oNoIntInstall=(DBObject)oOutArray.get(1);
        oCPFFinalPaymentBean.setNoIntInstall((String)oNoIntInstall.getObject());
      }
    return oCPFFinalPaymentBean;
 }
 //modified by himanshu on 9-july-2014
  public String calcCpfYrInt(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CPFFinalPaymentBean oCPFFinalPaymentBean=(CPFFinalPaymentBean)oBaseHeaderBean;
    checkMonthEnd(oCPFFinalPaymentBean);
    checkPaidStatus(oCPFFinalPaymentBean);
    ArrayList oOutArray; //Output  
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtYr()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtSiteID()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtUserID()));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.UpdatePFYearEnd(?,?,?,?,?,?,?)",true,true);
    oOutArray = oBean.callProc(oParameters,"pkg_cpf_year_end_fci.proc_cal_yr_end_interest(?,?,?,?,?)",true,true); 
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    String sRetMsg=errCode.toString()+","+errMsg;
    
    //added by gagan on 18-05-2013
     if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add(sRetMsg);
        System.out.println("Error!!! while getting Int Install ::"+sRetMsg);
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
      //ended by gagan on 18-05-2013
    
    return sRetMsg;
 }
 //end of modification by himanshu
 
 //added by himanshu on 9-july-2014
 public String freezeCpfYrInt(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CPFFinalPaymentBean oCPFFinalPaymentBean=(CPFFinalPaymentBean)oBaseHeaderBean;
    checkMonthEnd(oCPFFinalPaymentBean);
    checkPaidStatus(oCPFFinalPaymentBean);
    ArrayList oOutArray; //Output  
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtYr()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtUserID()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtSiteID()));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.UpdatePFYearEnd(?,?,?,?,?,?,?)",true,true);
    oOutArray = oBean.callProc(oParameters,"pkg_cpf_year_end_fci.freeze_year_end(?,?,?,?,?)",true,true); 
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    String sRetMsg=errCode.toString()+","+errMsg;
    
    //added by gagan on 18-05-2013
     if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add(sRetMsg);
        System.out.println("Error!!! while getting Int Install ::"+sRetMsg);
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
      //ended by gagan on 18-05-2013
    
    return sRetMsg;
 }
 // end of addition by himanshu
 private void checkMonthEnd(CPFFinalPaymentBean oCPFFinalPaymentBean) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output  
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtYr()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtEmpLbrFlag()));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_ValidMonthEnd(?,?,?,?)",true,true);
    DBObject oErrMsg = (DBObject)oOutArray.get(0);
    DBObject oErrCode = (DBObject)oOutArray.get(1);
    Integer errCode=(Integer)oErrCode.getObject();
    if(!errCode.equals(new Integer(0)))
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add((String)oErrMsg.getObject());
      throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
    }
 }
 
 private void checkYYMM(CPFFinalPaymentBean oCPFFinalPaymentBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oCPFFinalPaymentBean.getTxtSiteID()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");                 
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

      String sRevYear = "";
      String status = "";   
      String arcFlag="";
      
      oIt = oRetList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        sRevYear = oRow.get("yymm").getString(); 
        status = oRow.get("status").getString(); 
        arcFlag = oRow.get("arc_flag").getString(); 
      }

    if(arcFlag!=null && arcFlag.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
  }    

// one parameter added by himanshu on 9-july-2014
 private void checkPaidStatus(CPFFinalPaymentBean oCPFFinalPaymentBean) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output  
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtYr()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtEmpLbrFlag()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtSiteID()));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_CheckCPFIntrPaid(?,?,?,?,?)",true,true);
    DBObject oErrMsg = (DBObject)oOutArray.get(0);
    DBObject oErrCode = (DBObject)oOutArray.get(1);
    Integer errCode=(Integer)oErrCode.getObject();
    if(!errCode.equals(new Integer(0)))
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add((String)oErrMsg.getObject());
      throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
    }
 }

 public String revokeCPFPay(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
 {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CPFFinalPaymentBean oCPFFinalPaymentBean=(CPFFinalPaymentBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output  
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtEmpNo()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtInvID())); 
      // added by gagan on 16-05-2013
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtUserID()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oCPFFinalPaymentBean.getTxtSiteID()));
      // addition ended by gagan on 16-05-2013
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.Proc_RevokeFinalPay(?,?,?,?,?,?,?)",true,true);
      DBObject oOutObject = (DBObject)oOutArray.get(1);
      Integer errCode = (Integer)(oOutObject.getObject());
      
      oOutObject = (DBObject)oOutArray.get(0);
      String errMsg = (String)(oOutObject.getObject());
     // added by gagan on 16-05-2013  
    if(!errCode.equals(new Integer(0)))
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add(errMsg);
      throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
    }
      // addition ended by gagan on 16-05-2013
      String sRetMsg=errCode.toString()+","+errMsg;
      return sRetMsg;
 }
//added by arvind on 26/7/2017
    public String  CancelCPFPartFinalInv(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryV0) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      String msg=null;
    
      if(oCPFFinalPaymentQueryV0 == null)
      {
        oCPFFinalPaymentQueryV0 = new CPFFinalPaymentQueryVO();
      }
      
     
      
      String screenName= oCPFFinalPaymentQueryV0.getScreenName();
      ArrayList oOutArray; //Output 
      ArrayList oParamList = new ArrayList();  
      ArrayList oList = new ArrayList();  
        
      oParameters = new ArrayList();
           
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oCPFFinalPaymentQueryV0.getTxtEmpNo()))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oCPFFinalPaymentQueryV0.getTxtInvID()))));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oCPFFinalPaymentQueryV0.getSancOrderNo()))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oCPFFinalPaymentQueryV0.getLoginLocCode()))));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oCPFFinalPaymentQueryV0.getLoginEmployeeNo()))));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      
      oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_check_invoice_canc(?,?,?,?,?,?,?)",true,true);
      
      String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
        
      return errMsg;
    }
    public LovVO getCpfClaimReqIdLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
        {  
          LovVO oLovVO=new LovVO();  
          ArrayList arylstHeaderNames=new ArrayList();
          arylstHeaderNames.add("Claim Request Id");          
          //arylstHeaderNames.add("Relationship");          
          //arylstHeaderNames.add("Dependent Id");          
          oLovVO.setHeaderList(arylstHeaderNames);
          
          ArrayList arylstVisibility=new ArrayList();
          arylstVisibility.add(EnrgiseConstants.VISIBLE);    
          //arylstVisibility.add(EnrgiseConstants.VISIBLE);    
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
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,"A"));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtEmpNo")).trim()));     
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_cpf_fci.proc_getclaimreqIdlov(?,?,?,?,?)");
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
            
              oLOVBean.setDetailField1(oRow.get("REQUEST_ID").getString());                    
              //oLOVBean.setDetailField2(oRow.get("DEPENDENT_REL").getString());                    
              //oLOVBean.setDetailField3(oRow.get("EMP_DPNDNT_ID").getString());                    
            oList.add(oLOVBean);
          }
           
            oLovVO.setDetailList(oList);
          return oLovVO;
        }
    public LovVO getCpfPartFinalClaimReqIdLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
        {  
          LovVO oLovVO=new LovVO();  
          ArrayList arylstHeaderNames=new ArrayList();
          arylstHeaderNames.add("Claim Request Id");          
          //arylstHeaderNames.add("Relationship");          
          //arylstHeaderNames.add("Dependent Id");          
          oLovVO.setHeaderList(arylstHeaderNames);
          
          ArrayList arylstVisibility=new ArrayList();
          arylstVisibility.add(EnrgiseConstants.VISIBLE);    
          //arylstVisibility.add(EnrgiseConstants.VISIBLE);    
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
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,"P"));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtEmpNo")).trim()));     
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_cpf_fci.proc_getclaimreqIdlov(?,?,?,?,?)");
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
            
              oLOVBean.setDetailField1(oRow.get("REQUEST_ID").getString());                    
              //oLOVBean.setDetailField2(oRow.get("DEPENDENT_REL").getString());                    
              //oLOVBean.setDetailField3(oRow.get("EMP_DPNDNT_ID").getString());                    
            oList.add(oLOVBean);
          }
           
            oLovVO.setDetailList(oList);
          return oLovVO;
        }
    public LovVO getCpfFinalClaimReqIdLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
        {  
          LovVO oLovVO=new LovVO();  
          ArrayList arylstHeaderNames=new ArrayList();
          arylstHeaderNames.add("Claim Request Id");          
          //arylstHeaderNames.add("Relationship");          
          //arylstHeaderNames.add("Dependent Id");          
          oLovVO.setHeaderList(arylstHeaderNames);
          
          ArrayList arylstVisibility=new ArrayList();
          arylstVisibility.add(EnrgiseConstants.VISIBLE);    
          //arylstVisibility.add(EnrgiseConstants.VISIBLE);    
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
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,"F"));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtEmpNo")).trim()));     
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_cpf_fci.proc_getclaimreqIdlov(?,?,?,?,?)");
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
            
              oLOVBean.setDetailField1(oRow.get("REQUEST_ID").getString());                    
              //oLOVBean.setDetailField2(oRow.get("DEPENDENT_REL").getString());                    
              //oLOVBean.setDetailField3(oRow.get("EMP_DPNDNT_ID").getString());                    
            oList.add(oLOVBean);
          }
           
            oLovVO.setDetailList(oList);
          return oLovVO;
        }
}