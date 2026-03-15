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
import FCIPAY.Payroll.UTILITY.MaintCategoryLocationBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.lang.Integer;
import FCIPAY.Payroll.UTILITY.MaintHraRateBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HraComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CtgrySchemeComboVO;
//import FCIPAY.Payroll.DATAACCESSTIER.VO.CtgrySchemePayScaleComboVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;

public class CategoryLocationBusinessObject extends BaseBO
{
  public CategoryLocationBusinessObject()
  {
  }
     public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("MaintCategoryLocationMap"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }
  
   public RecordMetaInfo getCategoryLocationDetailMetaInfo (String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP. proc_GetCategorySchemeCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
public CtgrySchemeComboVO getCtgrySchemeComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CtgrySchemeComboVO oCtgrySchemeComboVO = new CtgrySchemeComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDsgnCtgry = null;
  //  ArrayList oPayScale = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCtgry(?,?)");
      
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
            oDsgnCtgry = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_sdesc").getString();
          String ctgryValue = oRow.get("gbl_code").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oDsgnCtgry.add(oComboVO);
        }

      
    /* Newly Added */
    oCtgrySchemeComboVO.setCtgryList(oDsgnCtgry);
   //return oCtgrySchemeComboVO;
    
    
    //payscale
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetPayScaleType(?,?)");
      
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
            oDsgnCtgry = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_sdesc").getString();
          String ctgryValue = oRow.get("gbl_code").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oDsgnCtgry.add(oComboVO);
        }

      
    /* Newly Added */
    oCtgrySchemeComboVO.setPayScale( oDsgnCtgry);
    return oCtgrySchemeComboVO;
      //return oCtgrySchemePayScaleComboVO;
       
  }


  public ArrayList getCategoryLocationDetail( String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintCategoryLocationBean oAgency;
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
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP. proc_GetDtlCategoryScheme(?,?,?,?,?)");
      
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
          oAgency = new  MaintCategoryLocationBean();
          oAgency.setTxtEmpCategory((oRow.get("EMP_CTGRY").getString()));
            
          oAgency.setStatus("Q");
         oAgency.setTxtPayScaleType((oRow.get("PAY_SCALE_TYPE").getString()));
          oAgency.setTxtLocationType(oRow.get("LOC_TYPE").getString());
           oAgency.setTxtDepotType(oRow.get("DEPOT_TYPE").getString());
          oAgency.setTxtScheme((oRow.get("SCHEME_ID").getString()));
       oAgency.setTxtSchemeDesc((oRow.get("DESCRIPTION").getString()));
          //oAgency.setTxtLocation(oRow.get("LOC_ID").getString());
          // oAgency.setTxtLocationDesc(oRow.get("LOC_DESC").getString());
         // oAgency.setTxtEmployeeNo((oRow.get("EMP_NUM").getString()));
         //   oAgency.setTxtEmployeeNoDesc((oRow.get("EMP_FIRST_NAME").getString()));
          // oMaintRmtAreaAllowBean.setDetailId(oRow.get("RMT_AREA_MST_ID").getString());
      oAgency.setDetailId((oRow.get("CTGRY_SCHEME_ID").getString()));
         //  oAgency.setTxtDraw((oRow.get("DRAWN_ON").getString()));
         // oAgency.setTxtSite(oRow.get("SITE_ID").getString());
          //oAgency.setTxtSrlNo((oRow.get("SRL_NO").getString()));
          oAgencyDetail.add(oAgency);
        }
        
        
    return oAgencyDetail;
     }
  
   public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("MaintCategoryLocationMap"))
    {
      saveCategoryDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
  }    
  
  
    private void saveCategoryDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        MaintCategoryLocationBean oMaintCategoryLocationBean = (MaintCategoryLocationBean)oIt.next();
//        System.out.println(oMaintAgencyBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintCategoryLocationBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_AGENCY_MAP.proc_InsertCategoryLocation(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
       //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getDetailId())));
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtEmpCategory())));
           //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCodeDesc())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtPayScaleType())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtLocationType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtDepotType())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtScheme())));
         // oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtDraw())));
         // oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtSite())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
         
          oBeanInsert.addToBatch(oParameters);
        }
       else if(oMaintCategoryLocationBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_AGENCY_MAP.proc_UpdateCategoryScheme(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtSrlNo())));
         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getDetailId())));
         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtEmpCategory())));
          // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPaycodeVSAgencycodeBean.getTxtPayCodeDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtPayScaleType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtLocationType())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtDepotType())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtScheme())));
         // oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtDraw())));
         // oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAgencyBean.getTxtSite())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          

          oBean.addToBatch(oParameters);
       
        }
        else if(oMaintCategoryLocationBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_AGENCY_MAP.proc_DeleteCategoryLocation(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
         
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtEmpCategory())));
         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getTxtPayScaleType())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCategoryLocationBean.getDetailId())));
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
  
   public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   ArrayList oList = new ArrayList();
   if(sScreenMode.equals(EnrgiseConstants.UPDATE_MODE))
      {
   //     chkDuplicate(oDetailBeanArray,oList);
        reportError(oList);
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
  
   public  String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return null;
  }
  public  void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
    
  }
  
   public LovVO getCategorySchemeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Scheme");   
    arylstHeaderNames.add("Scheme Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
    String sScheme,sDesc;
    sScheme=oLovQueryVO.getSearchField1();
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
     // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
     // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetScheme_LOV(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("flex_value_meaning").getString());            
       oLOVBean.setDetailField2(oRow.get("description").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  
  
   public LovVO getCategorySchemeLocationLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location Type");   
  //  arylstHeaderNames.add("Scheme Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
    String sLocationType;
    sLocationType=oLovQueryVO.getSearchField1();
   // sDesc=oLovQueryVO.getSearchField2();
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();     
     // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
     // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetLocType(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("CODE_DESC").getString());            
      // oLOVBean.setDetailField2(oRow.get("description").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }   
  
 
 
   public LovVO getCategorySchemeDepotLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Depot Type");   
  //  arylstHeaderNames.add("Scheme Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
    String sLocationType;
    sLocationType=oLovQueryVO.getSearchField1();
   // sDesc=oLovQueryVO.getSearchField2();
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();     
     // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
     // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_AGENCY_MAP.proc_GetDepotType(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("CODE_DESC").getString());            
      // oLOVBean.setDetailField2(oRow.get("description").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  } 
}