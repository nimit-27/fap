package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintLoanMstQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintLoanMasterHdrBean;

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
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class LoanMasterBusinessObject extends BaseBO 
{
  public LoanMasterBusinessObject()
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
    MaintLoanMasterHdrBean oMaintLoanMasterHdrBean = (MaintLoanMasterHdrBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintLoanMasterHdrBean.getTxtSanctionDate())));

      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanAmount())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtInstAmt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtRecoverYYMM())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtBalNoofInstall())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtPaidInstall())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtAmtPaid())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtExistLoanBal())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtIntAmount())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtIntAmountFinYear())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtBalIntAmount())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanOpBal())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanStatus())));

      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanType())));            
      
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtUserID())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtSiteID())));
      oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateLoanMaster(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintLoanMasterHdrBean oMaintLoanMasterHdrBean = (MaintLoanMasterHdrBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanType())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintLoanMasterHdrBean.getTxtSanctionDate())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanAmount())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtInstAmt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtRecoverYYMM())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtBalNoofInstall())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtPaidInstall())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtAmtPaid())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtExistLoanBal())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtIntAmount())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtIntAmountFinYear())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtBalIntAmount())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanOpBal())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanStatus())));
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtUserID())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtSiteID())));
      oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(19,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertLoanMaster(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();
      
  }


  public RecordMetaInfo getLoanMstHeaderMetaInfo(MaintLoanMstQueryVO oMaintLoanMstQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMstQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMstQueryVO.getTxtLoanType())));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetLoanMasterCount(?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getLoanMstHeader(MaintLoanMstQueryVO oMaintLoanMstQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintLoanMstQueryVO == null)
    {
      oMaintLoanMstQueryVO = new MaintLoanMstQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMstQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMstQueryVO.getTxtLoanType())));      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetLoanMasterDetail(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());


      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintLoanMasterHdrBean oMaintLoanMasterHdrBean;
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
          oMaintLoanMasterHdrBean = new MaintLoanMasterHdrBean();
          oMaintLoanMasterHdrBean.setHeaderPrimaryKey(oRow.get("emp_num").getString());
          oMaintLoanMasterHdrBean.setTxtEmpNo(oRow.get("emp_num").getString());
          oMaintLoanMasterHdrBean.setTxtEmpName(oRow.get("Name").getString());
          oMaintLoanMasterHdrBean.setTxtLoanType(oRow.get("loan_type").getString());
          oMaintLoanMasterHdrBean.setTxtLoan(oRow.get("pay_code_desc").getString());
         
          oMaintLoanMasterHdrBean.setTxtSanctionDate(EnrgiseUtil.convertToString(oRow.get("sanction_date").getDate()));
          oMaintLoanMasterHdrBean.setTxtLoanAmount(oRow.get("loan_amount").getString());
          oMaintLoanMasterHdrBean.setTxtInstAmt(oRow.get("instal_amount").getString());
          oMaintLoanMasterHdrBean.setTxtRecoverYYMM(oRow.get("recovery_yymm").getString());
          oMaintLoanMasterHdrBean.setTxtBalNoofInstall(oRow.get("bal_instal").getString());
          oMaintLoanMasterHdrBean.setTxtPaidInstall(oRow.get("paid_instal").getString());
          oMaintLoanMasterHdrBean.setTxtAmtPaid(oRow.get("amount_paid").getString());
          oMaintLoanMasterHdrBean.setTxtExistLoanBal(oRow.get("exist_loan_balance").getString());
          oMaintLoanMasterHdrBean.setTxtIntAmount(oRow.get("intt_amount").getString());
          oMaintLoanMasterHdrBean.setTxtIntAmountFinYear(oRow.get("intt_amount").getString());
          oMaintLoanMasterHdrBean.setTxtBalIntAmount(oRow.get("bal_intt_amount").getString());
          oMaintLoanMasterHdrBean.setTxtLoanOpBal(oRow.get("loan_open_balance").getString());
          oMaintLoanMasterHdrBean.setTxtLoanStatus(oRow.get("loan_status").getString());
          
          oHeaderList.add(oMaintLoanMasterHdrBean);
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

  public LovVO getQueryEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpLoanLOV(?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("Name").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
public LovVO getLoanMasterLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("LoanType");  
    arylstHeaderNames.add("LoanType Description"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    
    String sPaycode,sDesc;
    sPaycode=oLovQueryVO.getSearchField1();
    sDesc=oLovQueryVO.getSearchField2();

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetLoanType(?,?,?,?)");
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
      if(sScreenName.equals(EnrgiseConstants.NEW_MODE))
      {
          checkEmpNo(oBaseHeaderBean,oList);        
      }
    reportError(oList);        
  }


  private void checkDuplicateCheck(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
     
    checkEmpNo(oBaseHeaderBean,oList);        
    reportError(oList);
        
  }
  private void checkEmpNo(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        MaintLoanMasterHdrBean oMaintLoanMasterHdrBean = (MaintLoanMasterHdrBean)oBaseHeaderBean;

          String empNo = oMaintLoanMasterHdrBean.getTxtEmpNo();

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintLoanMasterHdrBean.getTxtLoanType())));          
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_AnnIncCheck(?,?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              oList.add(new EnrgiseApplicationException("payroll.AnnInc.duplicatecheck"));
            }         
  }
}