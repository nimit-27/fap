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
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ClassificationComboVO;
import FCIPAY.Payroll.UTILITY.MaintCatVsPayCodeBean;
import FCIPAY.Payroll.UTILITY.CatVsPayCodeHeaderBean;

public class CatVsPayCodeBusinessObject extends BaseBO
{
  public CatVsPayCodeBusinessObject()
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
  
  
  public RecordMetaInfo getCatVsPayCodeMetaInfo (String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_GetCatVsPayCodeCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getCatVsPayCodeDetail( String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintCatVsPayCodeBean oMaintCatVsPayCodeBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oMaintCatVsPayCodeDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_GetDtlCatVsPayCode(?,?,?,?,?)");
      
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
            oMaintCatVsPayCodeDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintCatVsPayCodeBean = new  MaintCatVsPayCodeBean();
          oMaintCatVsPayCodeBean.setTxtPayCode((oRow.get("PAY_CODE").getString()));
            
          
          oMaintCatVsPayCodeBean.setTxtPayCodeDesc((oRow.get("PAY_CODE_DESC").getString()));
          
          oMaintCatVsPayCodeDetail.add(oMaintCatVsPayCodeBean);
        }
        
        
    return oMaintCatVsPayCodeDetail;
     }
 
 
 public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("MaintCatVsPayCode"))
    {
      SaveClassificationMapping(oBaseHeaderBean,oDetailBeanArray);
    }
  }    
  
  
  private void SaveClassificationMapping(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    CatVsPayCodeHeaderBean oCatVsPayCodeHeaderBean = (CatVsPayCodeHeaderBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintCatVsPayCodeBean oMaintCatVsPayCodeBean = (MaintCatVsPayCodeBean)oIt.next();
//        System.out.println(oMaintAgencyBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintCatVsPayCodeBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("payroll_pkg_ext.proc_insertdtlcatvspaycode(?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCatVsPayCodeBean.getTxtPayCode())));
         
        
    
        
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCatVsPayCodeHeaderBean.getTxtCategory())));   //Added by Swapnendu Dt 19- Aug 2010.
          
       
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCatVsPayCodeHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCatVsPayCodeHeaderBean.getTxtSiteID())));
            
          oBeanInsert.addToBatch(oParameters);
        }
      
        else if(oMaintCatVsPayCodeBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("payroll_pkg_ext.proc_deldtlcatvspaycode(?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
         
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCatVsPayCodeBean.getTxtPayCode())));
                  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCatVsPayCodeHeaderBean.getTxtCategory()));   //Added by Swapnendu Dt 19- Aug 2010.
          
       
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCatVsPayCodeHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCatVsPayCodeHeaderBean.getTxtSiteID())));
          
          oBeanDelete.addToBatch(oParameters);          
        }
      }

      try
      {
      if(bInsert)
      {
        oBeanInsert.executeBatch();
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
 
 
  
   public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    
  
  
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
  
 
  
  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return null;
  }
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
    
  }

  public LovVO getCatVSPayCodeLOVPayCodeDataQ(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtCategory"))); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_GetCatVSPayLOVPayCode(?,?,?,?,?)");
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
  

  
 
  
  
  
  
     public ClassificationComboVO getClassificationCombo() throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList();
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ClassificationComboVO oClassificationComboVO = new ClassificationComboVO();
      int count = 0;
      ArrayList oOutArray; //Output 
      ComboVO oComboVO=null;
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oClassificationTyp = null;
   
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg.proc_get_category(?,?)");
        
      oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
      oOutArray = null;
      oParameters = null;
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
          oClassificationTyp = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String classificationTypValue = oRow.get("code").getString();
        String classificationTypLabel = oRow.get("code_desc").getString();
        oComboVO = new ComboVO(classificationTypLabel,classificationTypValue);
        oClassificationTyp.add(oComboVO);
        oRow = null;
        oComboVO = null;
      }
      oList = null;
      oIt = null;
      oClassificationComboVO.setClassificationTypList(oClassificationTyp);
     
      return oClassificationComboVO;
    }
  
  
  
  
 
    
}
