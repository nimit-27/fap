package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintPaycodeVSAgencycodeBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;

import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;


public class PayAcctAgencyCodeBusinessObject extends BaseBO
{
  public PayAcctAgencyCodeBusinessObject() 
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("PayAcctCodeScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
/*    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintPayCodesBean oMaintPayCodesBean = (MaintPayCodesBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output  */



      oParameters = new ArrayList();
/*      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getStudentName())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getSex())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER)); */
//      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_InsertGlobalCode(?,?,?,?)");

//      DBObject oOutObject = (DBObject)oOutArray.get(0);
//      return (String)oOutObject.getObject();
        return null;
      
  }
 



//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    String sPayScaleType;    
    if(sScreenName.equals("MaintPaycodeVSAgencycode"))
    {
      saveAgencyDetails(sHeaderPrimaryKey,(DummyHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }

         
  }
  
  private void saveAgencyDetails(String sHeaderPrimaryKey,DummyHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
       MaintPaycodeVSAgencycodeBean oMaintPaycodeVSAgencycodeBean = (MaintPaycodeVSAgencycodeBean)oIt.next();
      //  PayCodesVsAcctCodesBean oPayCodesVsAcctCodesBean = (PayCodesVsAcctCodesBean)oIt.next();
//        System.out.println(oPayCodesVsAcctCodesBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintPaycodeVSAgencycodeBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_AGENCY_MAP.proc_InsertPaycodeAgencycode(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgencySite())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtLocation())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintPaycodeVSAgencycodeBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_AGENCY_MAP.proc_UpdatePaycodeAgencycode(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgencySite())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtLocation())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintPaycodeVSAgencycodeBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_AGENCY_MAP.proc_DeleteAgencyDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
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
  }
  
  public RecordMetaInfo getPaycodeAgencycodeDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetPaycodeAgencycodeCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getPaycodeAgencycodeDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPaycodeVSAgencycodeBean oAgency;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oAgencyDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetDtlPaycodeAgencycode(?,?,?,?,?)");
      
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
            oAgencyDetail = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oAgency = new  MaintPaycodeVSAgencycodeBean();
          oAgency.setTxtPayCode((oRow.get("PAY_CODE").getString()));
          oAgency.setStatus("Q");
          oAgency.setTxtPayCodeDesc((oRow.get("PAY_CODE_DESC").getString()));
          oAgency.setTxtAgency(oRow.get("AGENCY_CODE").getString());
          oAgency.setTxtAgencyDesc(oRow.get("VENDOR_NAME").getString());
          oAgency.setTxtAgencySite((oRow.get("AGENCY_SITE_CODE").getString()));
          oAgency.setTxtAgencySiteDesc((oRow.get("vendor_site_code").getString()));
          oAgency.setTxtLocation(oRow.get("LOC_ID").getString());
          oAgency.setTxtLocationDesc(oRow.get("LOC_DESC").getString());
          oAgency.setTxtEmployeeNo((oRow.get("EMP_NUM").getString()));
          oAgency.setTxtEmployeeNoDesc((oRow.get("EMP_FIRST_NAME").getString()));
          oAgency.setDetailId((oRow.get("PAY_AGENCY_ID").getString()));
          oAgencyDetail.add(oAgency);

        }
        
    return oAgencyDetail;
    
  }



public LovVO getPayacctPayCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Paycode");  
    arylstHeaderNames.add("PaycodeDesc"); 
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayAcctCodeLovQ(?,?,?,?)");
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



public LovVO getPayacctPayCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Paycode");  
    arylstHeaderNames.add("PaycodeDesc"); 
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayAcctCodeLovN(?,?,?,?)");
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


public LovVO getPayAcctAgencyLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Agencycode");  
    arylstHeaderNames.add("AgencyDesc");      
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);

    String AgencyCode, AgencyName; 
    AgencyCode=oLovQueryVO.getSearchField1();
    AgencyName=oLovQueryVO.getSearchField2();        
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayAcctCodeAgencyLovQ(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("agency_code").getString());            
       oLOVBean.setDetailField2(oRow.get("agency_name").getString());                   
    
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

public LovVO getPayAcctAgencyLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Agencycode");  
    arylstHeaderNames.add("Description");  
    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    String AgencyCode, AgencyName; 
    AgencyCode=oLovQueryVO.getSearchField1();
    AgencyName=oLovQueryVO.getSearchField2();    
    
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, AgencyCode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, AgencyName));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayAcctCodeAgencyLovN(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("agency_code").getString());   
       oLOVBean.setDetailField2(oRow.get("agency_name").getString());                            
     
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


 public LovVO getPayacctAcctCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("AcctCode");  
    arylstHeaderNames.add("Description");      
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);

    String AgencyCode, AgencyName; 
    AgencyCode=oLovQueryVO.getSearchField1();
    AgencyName=oLovQueryVO.getSearchField2();        
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, AgencyCode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, AgencyName));            
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayAcctCodeAcctLovQ(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("acct_code").getString());            
    
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

public LovVO getPayacctAcctCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("AcctCode");  
    arylstHeaderNames.add("Desc");  
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;

      
    String sAcctCode,sDesc;
    sAcctCode=oLovQueryVO.getSearchField1();
    sDesc=oLovQueryVO.getSearchField2();
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sAcctCode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetPayAcctCodeAcctLovN(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("acct_id").getString());   
       oLOVBean.setDetailField2(oRow.get("acct_desc").getString());            
     
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }



 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
      chkDuplicate(oDetailBeanArray,oList);
      reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  

  private void chkDuplicate(ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;// Output Parameters
    ArrayList oRetList = null;
    oParameters = new ArrayList();  
    Iterator oIt = null;
    
      oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintPaycodeVSAgencycodeBean  oMaintPaycodeVSAgencycodeBean  = (MaintPaycodeVSAgencycodeBean)oIt.next();
        if(oMaintPaycodeVSAgencycodeBean.getStatus().equals("N"))
        {
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode()))); 
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_PayAgencyDuplicateCheck(?,?,?,?)");
          oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
          if(oRetList.size() >0)
          {        
            oList.add(new EnrgiseApplicationException("Payroll.PaycodeVSAgencycode.PayAgencychk"));
          }
        }
      }
  }

  
  
}