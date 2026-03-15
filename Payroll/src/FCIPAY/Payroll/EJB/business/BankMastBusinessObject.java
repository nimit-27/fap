package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintBankMastQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BankMastDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintBankMastHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintBankMasterBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;


public class BankMastBusinessObject extends BaseBO
{
  private String ScreenModePay1;

  public BankMastBusinessObject()
  {
  }

   public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("BankDtlScreen"))
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
    MaintBankMastHeaderBean oMaintBankMastHeaderBean = (MaintBankMastHeaderBean)oBaseHeaderBean;

      if (oMaintBankMastHeaderBean.getScreenModePay1().equals("N"))
      {
        saveNewHeaderImpl(oBaseHeaderBean);
      }
      else
      {
              ArrayList oOutArray; //Output 
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintBankMastHeaderBean.getTxtBankCode()));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintBankMastHeaderBean.getTxtBankName()));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtUserID())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtSiteID())));
              oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));              
              oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateBankDtlHeader(?,?,?,?,?)");
      }
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintBankMastHeaderBean oMaintBankMastHeaderBean = (MaintBankMastHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintBankMastHeaderBean.getTxtBankCode()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintBankMastHeaderBean.getTxtBankName()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));           
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertBankMastHdr(?,?,?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();
 //  return null;   
  }

  public RecordMetaInfo getBankMastHeaderMetaInfo(MaintBankMastQueryVO oMaintBankMastQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();  
    
      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastQueryVO.getTxtBankCode())));      
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBankMasterhdrCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
  }

  public ArrayList getBankMastHeader(MaintBankMastQueryVO oMaintBankMastQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintBankMastQueryVO == null)
    {
      oMaintBankMastQueryVO = new MaintBankMastQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

   

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));

      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oMaintBankMastQueryVO.getTxtBankCode()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBankMast(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     
      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintBankMastHeaderBean oMaintBankMastHeaderBean;
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
          oMaintBankMastHeaderBean = new MaintBankMastHeaderBean();

          oMaintBankMastHeaderBean.setTxtBankCode((oRow.get("bank_code").getString()));
          oMaintBankMastHeaderBean.setTxtBankName((oRow.get("bank_name").getString()));
          oHeaderList.add(oMaintBankMastHeaderBean);
      }
              
    return oHeaderList;
    }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {    
    if(sScreenName.equals("BankDtlScreen"))
    {
        saveBankDetail(sHeaderPrimaryKey,oDetailBeanArray,(MaintBankMastHeaderBean)oBaseHeaderBean);
    }
  }   

  private void saveBankDetail(String sPrimaryKey,  ArrayList oDetailBeanArray, MaintBankMastHeaderBean oMaintBankMastHeaderBean) throws EnrgiseSystemException
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
        MaintBankMasterBean oMaintBankMasterBean = (MaintBankMasterBean)oIt.next();
//        System.out.println(oMaintBankMasterBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintBankMasterBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertBankMastDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;       
          }          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtBankCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtBranchCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtBranchName())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtAddress1())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtAddress2())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtAddress3())));          
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtPinCode())));          
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtMicrNO())));                    
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
       else if(oMaintBankMasterBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateBankMastDetail(?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String (oMaintBankMastHeaderBean.getTxtBankCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintBankMasterBean.getTxtBranchCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtBranchName())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtAddress1())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtAddress2())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtAddress3())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtPinCode())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtMicrNO())));          
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
     else if(oMaintBankMasterBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteBankMastDetail(?,?)");
            bDelete = true;
          }
           oParameters = new ArrayList();
           oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintBankMastHeaderBean.getTxtBankCode())));          
           oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintBankMasterBean.getTxtBranchCode())));
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
   if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean);
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
    }
  }

  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    checkBankMastHeader(oBaseHeaderBean,oList);
    reportError(oList);
    
    
  }

 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();  
    checkBranchCode(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList);
    
    
  }

  private void checkBankMastHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        MaintBankMastHeaderBean  oMaintBankMastHeaderBean  = (MaintBankMastHeaderBean)oBaseHeaderBean;

//        System.out.println(oMaintBankMastHeaderBean.getScreenModePay1());       
        if(oMaintBankMastHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtBankCode())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BankMastHdrDuplicateCheck(?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.MaintBankMast.Hdr.DuplicateCheck",EnrgiseConstants.MESSAGE));
            }
       }
  }

  
private void checkBranchCode(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
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
        MaintBankMasterBean oMaintBankMasterBean = (MaintBankMasterBean)oIt.next();
//        System.out.println(oMaintBankMasterBean.getStatus());
        MaintBankMastHeaderBean  oMaintBankMastHeaderBean  = (MaintBankMastHeaderBean)oBaseHeaderBean;
        if(!(oMaintBankMasterBean.getStatus().equals("D")))
          count++;


        if(oMaintBankMasterBean.getStatus().equals("N"))    
        {
          String sBranch = oMaintBankMasterBean.getTxtBranchName();
          String sBank = oMaintBankMastHeaderBean.getTxtBankCode();
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMasterBean.getTxtBranchCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintBankMastHeaderBean.getTxtBankCode())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BankCodeCheck(?,?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));

          //  oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
 
           oList.add(new EnrgiseApplicationException("Payroll.MaintBankMast.Hdr.DuplicateCheck",oArguments));
            }
        }
      } 
  }

  public RecordMetaInfo getBankMasterDetailMetaInfo(String sPrimaryKey,BankMastDetailInfo oBankMastDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
              
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oBankMastDetailInfo.getTxtBankCode()));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_BankMasterDtlCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;      
      //return null;
  }


  public ArrayList getBankMasterDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,BankMastDetailInfo oBankMastDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintBankMasterBean oMaintBankMasterBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oInrRateDetail = null;

      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oBankMastDetailInfo.getTxtBankCode()));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetBankMasterDetail(?,?,?,?,?)");
      
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
            oInrRateDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintBankMasterBean = new MaintBankMasterBean();
          oMaintBankMasterBean.setTxtBranchCode((oRow.get("bank_branch_id").getString()));
          oMaintBankMasterBean.setTxtBranchName((oRow.get("bank_branch_name").getString()));
          oMaintBankMasterBean.setTxtAddress1((oRow.get("address_line1").getString())); 
          oMaintBankMasterBean.setTxtAddress2((oRow.get("address_line2").getString())); 
          oMaintBankMasterBean.setTxtAddress3((oRow.get("address_line3").getString())); 
          oMaintBankMasterBean.setTxtPinCode((oRow.get("zip").getString())); 
          oMaintBankMasterBean.setTxtMicrNO((oRow.get("bank_num").getString()));           
          oMaintBankMasterBean.setTxtCity((oRow.get("city").getString()));           
          oMaintBankMasterBean.setTxtState((oRow.get("state").getString()));           
          
          
          oMaintBankMasterBean.setStatus("Q"); 
                  
          oInrRateDetail.add(oMaintBankMasterBean);
        }
  
       return oInrRateDetail;    
  }


  public LovVO getBankCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Bank Description");  
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);

    String BankCode, BankName; 
    BankCode=oLovQueryVO.getSearchField1();
    BankName=oLovQueryVO.getSearchField2();    
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, BankName));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetBankCodeLOVQ(?,?,?)");
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
                       
      oLOVBean.setDetailField1(oRow.get("bank_name").getString());                   
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

  

    

 

  private void checkMandatoryHeader(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    checkInterestRate(oBaseHeaderBean, oList);
    reportError(oList);
  }

  private void checkInterestRate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  public String getScreenModePay1()
  {
    return ScreenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    ScreenModePay1 = newScreenModePay1;
  }
 
}