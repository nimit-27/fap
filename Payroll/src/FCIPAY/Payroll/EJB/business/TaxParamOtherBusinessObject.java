package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import java.sql.SQLException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.UTILITY.StdDednBean;
import FCIPAY.Payroll.UTILITY.TaxParamOtherHeaderBean;
//import IBA.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TaxParamOtherQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;


public class TaxParamOtherBusinessObject extends BaseBO
{
  public TaxParamOtherBusinessObject()
  {
  }

  public RecordMetaInfo getTaxParamOtherHeaderMetaInfo(TaxParamOtherQueryVO oTaxParamOtherQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetTaxParamOtherCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getTaxParamHeader(TaxParamOtherQueryVO oTaxParamOtherQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oTaxParamOtherQueryVO == null)
    {
      oTaxParamOtherQueryVO = new TaxParamOtherQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetTaxParamOther(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      TaxParamOtherHeaderBean oTaxParamHeader;
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
          oTaxParamHeader = new TaxParamOtherHeaderBean();
          oTaxParamHeader.setHeaderPrimaryKey(oRow.get("rev_year").getString());
          oTaxParamHeader.setTxtRebLimitAmt(oRow.get("rebate_savings_limit").getString());
          oTaxParamHeader.setTxtAddlLimit(oRow.get("addl_limit").getString());
          oTaxParamHeader.setTxtFemAddl(oRow.get("female_addl").getString());
          oTaxParamHeader.setTxtMediClaimLimit(oRow.get("MEDICAL_CLAIM_LIMIT").getString());
          
          oHeaderList.add(oTaxParamHeader);
      }              
    return oHeaderList;
  }
  public RecordMetaInfo getStdDednDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      return new RecordMetaInfo();
  }

  public ArrayList getStdDednDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    StdDednBean oStdDednDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oStdDednDetail = null;
      
        return new ArrayList();
  }    


  public boolean saveStdDednHeader(TaxParamOtherHeaderBean oTaxParamOtherHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
    BaseDetailVO oBaseDetailVO = null;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtRebLimitAmt())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtFemAddl())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtAddlLimit())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtMediClaimLimit())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtUserID()));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtSiteID()));            
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertTaxParamOtherHeader(?,?,?,?,?,?,?,?)");


      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtRebLimitAmt())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtFemAddl())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtAddlLimit())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtMediClaimLimit())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtUserID()));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtSiteID()));            
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));     
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateTaxParamOtherHeader(?,?,?,?,?,?,?,?)");
      return true;
      
  }
  

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {

    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
    TaxParamOtherHeaderBean oTaxParamOtherHeaderBean = (TaxParamOtherHeaderBean)oBaseHeaderBean;    
    BaseDetailVO oBaseDetailVO = null;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtRebLimitAmt())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtFemAddl())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtAddlLimit())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtMediClaimLimit())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtUserID()));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtSiteID()));            
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER)); 
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertTaxParamOtherHeader(?,?,?,?,?,?,?,?)");
      return (String)oTaxParamOtherHeaderBean.getHeaderPrimaryKey();      
  
  }  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {

    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
    TaxParamOtherHeaderBean oTaxParamOtherHeaderBean = (TaxParamOtherHeaderBean)oBaseHeaderBean;    
    BaseDetailVO oBaseDetailVO = null;
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtOtherYYMM())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtRebLimitAmt())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtFemAddl())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtAddlLimit())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oTaxParamOtherHeaderBean.getTxtMediClaimLimit())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtUserID()));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,oTaxParamOtherHeaderBean.getTxtSiteID()));            
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));     
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateTaxParamOtherHeader(?,?,?,?,?,?,?,?)");   
  }  

  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      saveIncomeTax(sHeaderPrimaryKey,oDetailBeanArray);
  }   
  
 private void saveIncomeTax(String sHeaderPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    
/*      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        StdDednBean oStdDednBean = (StdDednBean)oIt.next();
        System.out.println(oStdDednBean.getStatus());
        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oStdDednBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertStdDednDetail(?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdAmtFrom())));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdAmtTo())));          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdMaleAmt())));                    
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdFemaleAmt())));                    
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdIncPer()))); 
          oBeanInsert.addToBatch(oParameters);
        }
       else if(oStdDednBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateStdDednDetail(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));                              
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getHdnStdDednSrlNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdAmtFrom())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdAmtTo())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdMaleAmt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdFemaleAmt())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getTxtStdIncPer())));
          oBean.addToBatch(oParameters);
          
        }
     else if(oStdDednBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteStdDednDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oStdDednBean.getHdnStdDednSrlNo())));
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
      }  */
  }
   
  public void initializeBOImpl(String sScreenName)
  {
/*    String sDetailTable = null;
    sDetailTable = "lstInstrDtls";
    initializeBO("IncomeTaxScreen",sDetailTable); */
  }  


  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
//      checkMandatoryDetail(oBaseHeaderBean);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

public LovVO getOtherYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Revision Year");  
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
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
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetOtherDetailsLov(?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("rev_year").getString());                   
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;

  } 

  
}