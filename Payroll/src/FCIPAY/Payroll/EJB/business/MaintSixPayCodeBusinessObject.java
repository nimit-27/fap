package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;

import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayQueryVO;
import FCIPAY.Payroll.UTILITY.SupplimentaryPayHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayDetailInfo;
import FCIPAY.Payroll.UTILITY.SupplPayBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintSixPayCodesDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintSixPayCodesHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintSixPayCodesBean;
//import FCIPAY.Payroll.WEBTIER.Form.SupplPayForm;

public class MaintSixPayCodeBusinessObject extends BaseBO 
{
  public MaintSixPayCodeBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("LeaveScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

    
 ////added by Sonia
  public RecordMetaInfo getSixPayDetailMetaInfo(String sPrimaryKey, MaintSixPayCodesDetailInfo oMaintSixPayCodesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    ArrayList oParameters; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();   
    ArrayList oOutArray; //Output     
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSixPayCodesDetailInfo.getTxtPayCode1())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountPayCodeDetail(?,?,?,?)");      
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    return oRecordMetaInfo;
  }
  
  public ArrayList getSixPayDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, MaintSixPayCodesDetailInfo oMaintSixPayCodesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    //System.out.println("tran id in get Detail===="+oSupplPayDetailInfo.getTranId());  
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList(); //Input Parameters
    
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oOutArray1; //Output 
    //SupplPayBean oSupplPayBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oEmpLeaveDetail = null;      
    oParameters = new ArrayList(); 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSixPayCodesDetailInfo.getTxtPayCode1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray1 = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetPayCodeDetail(?,?,?,?,?)");
  
    oList = (ArrayList)((DBObject)oOutArray1.get(0)).getObject();
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
        oEmpLeaveDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      MaintSixPayCodesBean omaintSixPayCodesBean = new MaintSixPayCodesBean();
      omaintSixPayCodesBean.setDetailId(oRow.get("pay_code_bob_id").getString());
      omaintSixPayCodesBean.setTxtPayCode(oRow.get("pay_code").getString()); 
      omaintSixPayCodesBean.setTxtPercentage((oRow.get("percentage").getString()));
      omaintSixPayCodesBean.setTxtDescription((oRow.get("pay_code_desc").getString()));
      System.out.println("desc----"+oRow.get("dsgn_desc").getString());
      omaintSixPayCodesBean.setTxtDsgnDesc((oRow.get("dsgn_desc").getString()));
      omaintSixPayCodesBean.setStatus("Q");
      omaintSixPayCodesBean.setTxtDesg(oRow.get("dsgn_id").getString());
      omaintSixPayCodesBean.setTxtConveyance(oRow.get("vehicle_type").getString());
      omaintSixPayCodesBean.setTxtEducation(oRow.get("institutaion_type").getString());
      omaintSixPayCodesBean.setTxtMobile(oRow.get("handicapped_flag").getString());
      omaintSixPayCodesBean.setTxtStartDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("start_date").getDate()));
      omaintSixPayCodesBean.setTxtEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("end_date").getDate()));      
      oEmpLeaveDetail.add(omaintSixPayCodesBean);
    }
    
    return oEmpLeaveDetail;
    
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
     // saveSupplPayDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
  }

  public String saveSixPayData(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    MaintSixPayCodesHeaderBean oDummyHeaderBean = (MaintSixPayCodesHeaderBean)oBaseHeaderBean;    
    oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintSixPayCodesBean oUserBean = (MaintSixPayCodesBean)oIt.next();
        if(oUserBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_payroll_misc.proc_Insert_sixpay_codes(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPayCode1())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPercentage())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtDesg())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtConveyance())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEducation())));          
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtMobile())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtStartDate())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEndDate()))); 
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          //oParameters.add(new DBObject(11,DBObject.INOUT,ParameterTypes.VARCHAR));
          //oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));
         //  oParameters.add(new DBObject(108,DBObject.OUT,ParameterTypes.VARCHAR));
         // oParameters.add(new DBObject(109,DBObject.OUT,ParameterTypes.INTEGER));
        
          oBeanInsert.addToBatch(oParameters);
        }
        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_payroll_misc.proc_update_sixpay_codes(?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPayCode1())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPercentage())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtDesg())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtConveyance())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEducation())));          
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtMobile())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtStartDate())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEndDate()))); 
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          System.out.println("ID--"+ oUserBean.getDetailId());
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getDetailId())));
          //oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));
          //oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR));
          oBean.addToBatch(oParameters);
        }        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_payroll_misc.proc_DeleteSixPayCodeDetail(?,?,?,?,?,?,?,?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPayCode1())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPercentage())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtDesg())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtConveyance())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEducation())));          
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtMobile())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtStartDate())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEndDate()))); 
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          System.out.println("ID to be deleted--"+ oUserBean.getDetailId());
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getDetailId())));
          oBeanDelete.addToBatch(oParameters);          
        }
      }

      try
      {
      if(bInsert)
      {
        oBeanInsert.executeBatch();
      }
      
      if(bUpdate)
      {
        oBean.executeBatch();        
      }

      if(bDelete)
      {
        oBeanDelete.executeBatch();
      }
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
	  return "";
  }

  

  public LovVO getSupPayEmpDtlLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
    arylstHeaderNames.add("Staff Code");
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Payscale");
    arylstHeaderNames.add("Catagory");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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

    String empType=oLovQueryVO.getProperty("hdnEmpLbrFlag");

    if(empType==null || empType.equals(""))
    {
      empType="E";
    }else
    {
      System.out.println("EmpType is"+empType);
    }

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(empType)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));

    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetSupplPayEmpLov(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("EMPNAME").getString());
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField4(oRow.get("STAFF_CODE").getString());
      oLOVBean.setDetailField5(oRow.get("DSGN_DESC").getString());
      oLOVBean.setDetailField6(oRow.get("PAY_SCALE_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("CATEGORY").getString());
      oList.add(oLOVBean);
    }
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getPaycodeAgencycodePayCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");   
    arylstHeaderNames.add("PayCode Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
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
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetPaycodeAgencyLOV(?,?,?,?)");
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

  private void checkMaxPayYear(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    String sRevYear = "";
    SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      String status = oRow.get("arc_flag").getString(); 
     }
    
    int payYear = Integer.parseInt(sRevYear);

     oIt = null;
     oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        SupplPayBean  oSupplPayBean  = (SupplPayBean)oIt.next();
        count++;
        if(oSupplPayBean.getStatus().equals("N") || oSupplPayBean.getStatus().equals("U"))
        {
          String yymm = oSupplPayBean.getTxtYYMM();
          int yyyyMM = Integer.parseInt(yymm);
            if(yyyyMM >= payYear)
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(new String(sRevYear));
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("Payroll.SupplyPay.MaxPayYearCheck",oArguments));
            }
        }
      }
  }    

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
    return null;
  }

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
      //checkDuplicateDetail(oDetailBeanArray,oList);
      //reportError(oList);
      //oList = new ArrayList();
      checkMaxPayYear(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  
  
  
  //////////////////////////////added by sonia////////////////////////////////////
   public LovVO getSixCommissionPayCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");   
    arylstHeaderNames.add("PayCode Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
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
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetSixCommPaycodeLOV1(?,?,?,?)");
      //oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetPaycodeAgencyLOV(?,?,?,?)");
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
  ///////////////end added by Sonia//////////////////////////////// 
  

 public LovVO getSixPayCodeDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code");     
    arylstHeaderNames.add("Board Flag"); 
    arylstHeaderNames.add("Pay Band"); 
    arylstHeaderNames.add("Grade Pay"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;  
    
  
    String sDsgn,sCatgry,sPayScaleCode,sPayScaleType;
    sDsgn=oLovQueryVO.getSearchField1();
    sCatgry=oLovQueryVO.getSearchField2();
    sPayScaleCode=oLovQueryVO.getSearchField3();
   
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sDsgn));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sCatgry));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPayScaleCode));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDsgnLov1(?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("dsgn_id").getString());   
        oLOVBean.setDetailField1(oRow.get("dsgn_desc").getString());
        oLOVBean.setDetailField3(oRow.get("ctgry").getString());
        oLOVBean.setDetailField4(oRow.get("ctgry_desc").getString());        
        oLOVBean.setDetailField5(oRow.get("pay_scale_code").getString());        
        oLOVBean.setDetailField6(oRow.get("BOARD_FLG").getString());
        oLOVBean.setDetailField7(oRow.get("PAY_BAND_NAME").getString());
        oLOVBean.setDetailField8(oRow.get("GRADE_PAY_AMT").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

}