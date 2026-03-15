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

public class PayCodeAgencyCodeBusinessObject extends BaseBO
{
  public PayCodeAgencyCodeBusinessObject()
  {
  }
   public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("MaintPaycodeVSAgencycode"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }
  
  
  public RecordMetaInfo getPaycodeAgencycodeDetailMetaInfo (String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
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
  
  public ArrayList getPaycodeAgencycodeDetail( String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
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
       //   oAgency.setDetailId(oRow.get("PAY_AGENCY_ID").getString());
          oAgency.setDetailId((oRow.get("PAY_AGENCY_ID").getString()));
         //  oAgency.setTxtDraw((oRow.get("DRAWN_ON").getString()));
         // oAgency.setTxtSite(oRow.get("SITE_ID").getString());
      //    oAgency.setHdnSrlNo((oRow.get("SRL_NO").getString()));
          oAgencyDetail.add(oAgency);
        }
        
        
    return oAgencyDetail;
     }
 
 
 public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("MaintPaycodeVSAgencycode"))
    {
      saveAgencyDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
  }    
  
  
  private void saveAgencyDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        MaintPaycodeVSAgencycodeBean oMaintPaycodeVSAgencycodeBean = (MaintPaycodeVSAgencycodeBean)oIt.next();
//        System.out.println(oMaintAgencyBean.getStatus());
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
         // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPaycode)));
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
           //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCodeDesc())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgencySite())));
          //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getDupLoginLocCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oDummyHeaderBean.getTxtSiteID()));   //Added by Swapnendu Dt 19- Aug 2010.
          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtEmployeeNo())));
         // oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtDraw())));
         // oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtSite())));
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
          //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtSrlNo())));
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
          // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCodeDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgencySite())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtLocation())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtEmployeeNo())));
         // oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtDraw())));
         // oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtSite())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          

          oBean.addToBatch(oParameters);
       
        }
        else if(oMaintPaycodeVSAgencycodeBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_AGENCY_MAP.proc_DeletePaycodeAgencycode(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
         
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getDetailId())));
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
  
  /////////////added by sonia on 09-02-2011////////////////
 
  private void checksupplierRecord(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    int j=0;
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oOutArray1;
    DBUtilitiesBean oBean = null; 
    String msg;
    int count=1;
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oArguments = new ArrayList();
    String SrlNo ="Record";
      while(oIt.hasNext())
      {
         MaintPaycodeVSAgencycodeBean oMaintPaycodeVSAgencycodeBean = (MaintPaycodeVSAgencycodeBean)oIt.next();
           if(oMaintPaycodeVSAgencycodeBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
                  {
                     oBean = new DBUtilitiesBean();
                     oParameters = new ArrayList();
                     oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));                      
                     oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgencySite())));        
                     oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));       
                     oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
                     System.out.println(oMaintPaycodeVSAgencycodeBean.getTxtAgency() +"------"+ oMaintPaycodeVSAgencycodeBean.getTxtAgencySite());
                     if(((!oMaintPaycodeVSAgencycodeBean.getTxtAgency().equalsIgnoreCase("")) && (!oMaintPaycodeVSAgencycodeBean.getTxtAgencySite().equalsIgnoreCase(""))))
                     {
                         oOutArray1 = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_CheckSupplier(?,?,?,?)");
                         Integer i = (Integer)((DBObject)oOutArray1.get(0)).getObject();
                         count = i.intValue();                   
                          if(count == 0)     
                          {  
                          if(!oMaintPaycodeVSAgencycodeBean.getTxtEmployeeNo().equalsIgnoreCase("")){                           
                            SrlNo="Paycode:"+oMaintPaycodeVSAgencycodeBean.getTxtPayCode()+",Agency:"+oMaintPaycodeVSAgencycodeBean.getTxtAgency()+",EmployeeNo:"+oMaintPaycodeVSAgencycodeBean.getTxtEmployeeNo();                           
                          }else{
                            SrlNo= "Paycode:"+oMaintPaycodeVSAgencycodeBean.getTxtPayCode()+",Agency:"+oMaintPaycodeVSAgencycodeBean.getTxtAgency();
                          }
                        }
                     }
                  }     
  
  }
  if(!SrlNo.equalsIgnoreCase("Record")){
  oArguments.add(" in " + SrlNo);
  oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.CheckSupplier",oArguments));
  }
  }
  
   public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    
   if(sScreenMode.equals(EnrgiseConstants.UPDATE_MODE))
      {
        chkDuplicate(oDetailBeanArray,oList);
        reportError(oList);
        checksupplierRecord(oBaseHeaderBean,oDetailBeanArray,oList);
        reportError(oList);
      }   
      
      chkLiabilityAgnstPayCode(oBaseHeaderBean,oDetailBeanArray,oList); //added by ankur on 18th of Sep,2013
      reportError(oList);
  
  }
  
  private void chkDuplicate(ArrayList oDetailBeanArray,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
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
       oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtEmployeeNo()))); 
       oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode()))); 
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
       oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
       oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
       oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_PayAgencyDuplicateCheck(?,?,?,?,?)");
       oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
     
     if(oRetList.size() >0)
      {        
        oList.add(new EnrgiseApplicationException("Payroll.PaycodeVSAgencycode.PayAgencychk"));
      }
      else
      { return;
      }
      }
     }
    
     }
   
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    
//    checkFirst(oBaseHeaderBean,oList);
   //  checkAgency(oDetailBeanArray,oList);
     reportError(oList);
    
    
  }
  
  private void checkAgency(ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintPaycodeVSAgencycodeBean oMaintPaycodeVSAgencycodeBean = (MaintPaycodeVSAgencycodeBean)oIt.next();
//        System.out.println(oMaintAgencyBean.getStatus());

        if(!(oMaintPaycodeVSAgencycodeBean.getStatus().equals("D")))
          count++;


        if(oMaintPaycodeVSAgencycodeBean.getStatus().equals("N"))    
        {
          String pcode = oMaintPaycodeVSAgencycodeBean.getTxtPayCode();

          oParameters = new ArrayList();
          //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_AgencyCheck(?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
            }
        }
      }
  }
  
  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return null;
  }
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
    
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
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetPaycodeAgencyLOV(?,?,?,?)");
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
  
  public LovVO getPaycodeAgencycodeAgencyLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Agency");   
    arylstHeaderNames.add("Agency Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    
    String sAgencyCode,sAgencyCodeDesc;
    sAgencyCode=oLovQueryVO.getSearchField1();
    sAgencyCodeDesc=oLovQueryVO.getSearchField2();
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sAgencyCode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sAgencyCodeDesc));
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtEmployeeNo")));

      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetPayOvrAbvAgencyCodeLOV(?,?,?,?,?,?)");
      //oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetAgencyCodeLOV(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("vendor_id").getString());            
       oLOVBean.setDetailField2(oRow.get("vendor_name").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  
  public LovVO getPaycodeAgencycodeAgencySiteLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("AgencySite");   
    arylstHeaderNames.add("AgencySite Description");   
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
     oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtAgency")));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));

      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetAgencySiteCodeLOV(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("vendor_site_id").getString());            
       oLOVBean.setDetailField2(oRow.get("vendor_site_code").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
        public LovVO getPaycodeAgencycodeLocationLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location ID");   
    arylstHeaderNames.add("Location Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
      String sLocationCode,sLocationCodeDesc;
    sLocationCode=oLovQueryVO.getSearchField1();
   sLocationCodeDesc=oLovQueryVO.getSearchField2();
    
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sLocationCode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sLocationCodeDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetLoc_PaycodeAgencyLOV(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("loc_id").getString());            
     oLOVBean.setDetailField2(oRow.get("LOC_DESC").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getPaycodeAgencycodeEmployeeNoLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
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
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetEmpNo_PaycodeAgencyLOV(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("Name1").getString());     
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());     
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
 
    
    // added by Ankur on 18th of Sept ,2013
 private void chkLiabilityAgnstPayCode(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {       
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oOutArray ; //Output 
    ArrayList oArguments = new ArrayList(); 
    DBUtilitiesBean oBean ; 
    ArrayList oParameters;
    int count=0;
    
    //MaintPaycodeVSAgencycodeBean oBaseHeaderBean1 = (MaintPaycodeVSAgencycodeBean)oBaseHeaderBean;

				while(oIt.hasNext())
				  {
					  MaintPaycodeVSAgencycodeBean oMaintPaycodeVSAgencycodeBean = (MaintPaycodeVSAgencycodeBean)oIt.next();
                      count++;
					   if(oMaintPaycodeVSAgencycodeBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
                       {
                        if(!(oMaintPaycodeVSAgencycodeBean.getTxtAgency().equals("")))
                           {
                                oBean = new DBUtilitiesBean(); 
                                      oParameters = new ArrayList();		
                
                                      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCode())));
                                      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtAgency())));
                                      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));       
                                      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
                                      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_CheckLiaAgnstPayCode(?,?,?,?)",true,true);
                                      Integer err_code = (Integer)((DBObject)oOutArray.get(1)).getObject();
                                      String err_msg = (String)((DBObject)oOutArray.get(0)).getObject();
    
                                    if(err_code.intValue() != 0)
                                    {
                                        oArguments.add(err_msg);
                                        oArguments.add(new Integer(count));
                                        oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.PayCodeNotLiable",oArguments));
                                        oArguments = null;
                                    }	
                 
                       }
                   }
                   oMaintPaycodeVSAgencycodeBean = null;
				  }

     oOutArray = null;
     oBean = null;
     //oBaseHeaderBean1 = null;
  }

 // addition by Ankur ends.
    
    
    
}
