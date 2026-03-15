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
import FCIPAY.Payroll.UTILITY.PensionEmpShareUploadBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.lang.Integer;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

import FCIPAY.Payroll.UTILITY.EmpTrnsfrHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintPaycodeVSAgencycodeBean;
import FCIPAY.Payroll.UTILITY.PensionEmpShareUploadBean;

public class PensionEmpShareUploadBusinessObject extends BaseBO
{
  public PensionEmpShareUploadBusinessObject()
  {
  }
   public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("PensionEmpShareUpload"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }
  
  
  public RecordMetaInfo getPensionEmpShareUploadDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      System.out.println("inrecdtl");
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_emp_share.proc_GetPensionEmpShareCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
    
  public ArrayList getPensionEmpShareUploadDetail( String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    System.out.println("ingetdtl");
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    PensionEmpShareUploadBean oAgency;
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
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_pension_emp_share.proc_GetDtlPensionEmpShare(?,?,?,?,?,?)",true,true);
      
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
          oAgency = new  PensionEmpShareUploadBean();
          oAgency.setTxtEmployeeNo((oRow.get("EMP_NUM").getString()));
          oAgency.setStatus("Q");
          oAgency.setTxtEmployeeNoDesc((oRow.get("EMP_NAME").getString()));
          oAgency.setTxtGrossAmount(oRow.get("GROSS_AMT").getString());
          oAgency.setTxtTaxableAmount(oRow.get("TAXABLE_AMT").getString());
          oAgency.setTxtIncomeTax((oRow.get("INCOME_TAX").getString()));
          oAgency.setTxtNetAmount((oRow.get("NET_PAYABLE_AMT").getString()));
          
          oAgency.setTxtRemarks(oRow.get("REMARKS").getString());
          oAgency.setDetailId ((oRow.get("PENSION_SHARE_ID").getString()));
         //  oAgency.setTxtDraw((oRow.get("DRAWN_ON").getString()));
         // oAgency.setTxtSite(oRow.get("SITE_ID").getString());
      //    oAgency.setHdnSrlNo((oRow.get("SRL_NO").getString()));
          oAgencyDetail.add(oAgency);
        }
        
        
    return oAgencyDetail;
     }
 
 
 public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("PensionEmpShareUpload"))
    {
      savePensionEmpShareUploadDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
  }    
  
  
  private void savePensionEmpShareUploadDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
         DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        PensionEmpShareUploadBean oPensionEmpShareUploadBean = (PensionEmpShareUploadBean)oIt.next();
//        System.out.println(oMaintAgencyBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oPensionEmpShareUploadBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_pension_emp_share.proc_InsertPensionEmpShare(?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtGrossAmount())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtTaxableAmount())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtIncomeTax())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtNetAmount())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtRemarks())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
       /* else if(oPensionEmpShareUploadBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_AGENCY_MAP.proc_UpdatePaycodeAgencycode(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtSrlNo())));
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtPayCode())));
          // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCodeDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtAgency())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtAgencySite())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtLocation())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtEmployeeNo())));
         // oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtDraw())));
         // oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtSite())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          

          oBean.addToBatch(oParameters);
       
        }*/
        else if(oPensionEmpShareUploadBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {

          if(!bDelete)
          {

            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PENSION_EMP_SHARE.PROC_PENSION_DEL(?,?,?)");
              bDelete = true;
          }
            oParameters = new ArrayList();
           
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionEmpShareUploadBean.getTxtEmployeeNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oBeanDelete.addToBatch(oParameters);  
            oParameters = null;
        }
      }

      try
      {
      if(bInsert)
      {
        oBeanInsert.executeBatch();
      }
      
     /* if(bUpdate)
      {
        oBean.executeBatch();        
      }*/

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
  /////////////added by manish  ////////////////
 
 
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

	if(bDetailDataChanged)
      {
        checkAprilMonthStatus(oBaseHeaderBean,sScreenName,sScreenMode);
        
      }


      DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
      ArrayList oList=new ArrayList();
      checkMaxPayYear(oDummyHeaderBean.getTxtSiteID(),oDummyHeaderBean.getHdnEmpLbrFlag());
      checkPayrollStat(oDummyHeaderBean.getTxtSiteID());
  }

  private void checkAprilMonthStatus(BaseHeaderBean oBaseHeaderBean,String sScreenName, String sScreenMode) throws EnrgiseSystemException, EnrgiseApplicationException
        {  
            ArrayList oList = new ArrayList();
            DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
            checkStatus(oDummyHeaderBean.getTxtSiteID());
            reportError(oList);
               

        }    
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
   // ArrayList oList = new ArrayList();
    
//    checkFirst(oBaseHeaderBean,oList);
   //  checkAgency(oDetailBeanArray,oList);
  //   reportError(oList);
    
    
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


    oParameters = new ArrayList();
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    //oParameters=null;
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
    //oOutArray=null;
    //oRetList=null;
    
    return "";
    }
  
 
  
  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return null;
  }
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
    
  }

   public LovVO getPensionEmpShareUploadEmployeeNoLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmployeeNo");   
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField3()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_emp_share.proc_getPensionShareEmpLov(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());     
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());     
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
private String checkStatus(String siteId) throws EnrgiseSystemException, EnrgiseApplicationException
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
      String status ="";

      oParameters = new ArrayList();
    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_emp_share.proc_status_check(?,?)",true, true);
      Integer oStatus = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(oStatus.intValue() > 2)
      {
        throw new EnrgiseApplicationException("payroll.Common.statusCheck");
      }
      
      return "";
    }
  private String checkPayrollStat(String siteId) throws EnrgiseSystemException, EnrgiseApplicationException
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


        oParameters = new ArrayList();

        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));


        oOutArray = oBean.callProc(oParameters,"PKG_PENSION_EMP_SHARE.PROC_CHECK_PAYROLL_STAT_CHECK(?,?)",true,true);
        //oParameters=null;
            Integer oStatus = (Integer)((DBObject)oOutArray.get(0)).getObject();
                  if(oStatus.intValue() ==1)
                  {
                    throw new EnrgiseApplicationException("Payroll.Pay.StatCheck");
                  }
                  
         return "";
        }
    }



