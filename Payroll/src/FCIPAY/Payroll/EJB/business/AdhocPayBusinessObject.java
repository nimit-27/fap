package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.AdhocPayHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintAdhocPayBean;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayDetailInfo;
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
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class AdhocPayBusinessObject extends BaseBO 
{
  public AdhocPayBusinessObject()
  {
  }

 public String adhocPayTransaction(String procs, String payCode, String payMode, String payYYMM ,long lUserId, long lSiteId) throws EnrgiseSystemException
 {
   ArrayList oParameters = new ArrayList(); //Input Parameters
   DBUtilitiesBean oBean = new DBUtilitiesBean();
   ArrayList oList;
   String err = new String();

   String lUser = String.valueOf(lUserId);
   String lSite = String.valueOf(lSiteId);

   oParameters = new ArrayList();   
   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(payCode)));
   oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(payMode)));
   oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(payYYMM)));
   oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, lUser));
   oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, lSite));
   oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
   oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));

   ArrayList oOutArray = null; //Output 
   if(procs.equals("1"))
   {
     oOutArray = oBean.callProc(oParameters,"ADHOC_PAYROLL.proc_payCreateAdhoc(?,?,?,?,?,?,?)");    
     DBObject oErr = (DBObject)oOutArray.get(0);
     err = new String((oErr.getObject()).toString());
   }
   if(procs.equals("0"))
   {
     oOutArray = oBean.callProc(oParameters,"ADHOC_PAYROLL.proc_payUndoAdhoc(?,?,?,?,?)");    
     DBObject oErr = (DBObject)oOutArray.get(0);
     err = new String((oErr.getObject()).toString());
   }
   
   return err;
 }
 public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("MtrRdgScreen"))
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
    oParameters = new ArrayList();
    return null;
      
  }


  public RecordMetaInfo getAdhocPayHeaderMetaInfo(AdhocPayQueryVO oAdhocPayQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayQueryVO.getTxtPayCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayQueryVO.getTxtPayYYMM())));
      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GeAdhocPayHeaderCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }


  public boolean saveMtrRdgHeader(AdhocPayHeaderBean oAdhocPayHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
//    AddressDetailBean oAddress;
    BaseDetailVO oBaseDetailVO = null;
          
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oAdhocPayHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oAdhocPayHeaderBean.getTxtPayCode()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oAdhocPayHeaderBean.getTxtPayYYMM()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_saveDARatesHeader(?,?,?,?)");
      return true;
  }



  public ArrayList getAdhocPayHeader(AdhocPayQueryVO oAdhocPayQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oAdhocPayQueryVO == null)
    {
      oAdhocPayQueryVO = new AdhocPayQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayQueryVO.getTxtPayCode())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayQueryVO.getTxtPayYYMM())));
      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAdhocPayHeader(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      AdhocPayHeaderBean oAdhocPayHeaderBean;
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
          oAdhocPayHeaderBean = new AdhocPayHeaderBean();
          oAdhocPayHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
          oAdhocPayHeaderBean.setTxtPayCodeDesc(oRow.get("pay_code_desc").getString());
          
          oAdhocPayHeaderBean.setTxtPayYYMM(oRow.get("yymm").getString());
          oAdhocPayHeaderBean.setTxtPayMode(oRow.get("pay_mode").getString());
          oAdhocPayHeaderBean.setHdnPayrollFlag(oRow.get("payroll_flag").getString());          
          
          oHeaderList.add(oAdhocPayHeaderBean);
      }
      
        
    return oHeaderList;
  }


  
  public RecordMetaInfo getAdhocPayDetailMetaInfo(String sPrimaryKey,AdhocPayDetailInfo oAdhocPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

    String paycode,paymode,yearmon;
    paycode=oAdhocPayDetailInfo.getTxtPayCode();
    paymode=oAdhocPayDetailInfo.getTxtPayMode();
    yearmon=oAdhocPayDetailInfo.getTxtPayYYMM();
      
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,paycode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,yearmon));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,paymode));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAdhocDtlCount(?,?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getAdhocPayDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,AdhocPayDetailInfo oAdhocPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintAdhocPayBean oAdhocPay = null; 

    String paycode,paymode,yearmon;
    paycode=oAdhocPayDetailInfo.getTxtPayCode();
    paymode=oAdhocPayDetailInfo.getTxtPayMode();
    yearmon=oAdhocPayDetailInfo.getTxtPayYYMM();
      
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oAdhocPayDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, paycode));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, yearmon));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, paymode));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAdhocDetail(?,?,?,?,?,?,?)");
      
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
            oAdhocPayDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oAdhocPay = new MaintAdhocPayBean();

          oAdhocPay.setTxtSrlNo((oRow.get("srl_no").getString()));
          
          oAdhocPay.setStatus("Q");
          oAdhocPay.setTxtOptCode(oRow.get("opt_code").getString());
          oAdhocPay.setTxtGroupCode(oRow.get("group_code").getString());
          oAdhocPay.setTxtCategCode(oRow.get("categ_code").getString());
          oAdhocPay.setTxtDesigCode(oRow.get("dsgn_code").getString());
          oAdhocPay.setTxtAmount(oRow.get("amount").getString());


          oAdhocPayDetail.add(oAdhocPay);
        }
        
        
    return oAdhocPayDetail;
    
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("AdhocPayScreen"))
    {      
      saveAdhocPay(sHeaderPrimaryKey,(AdhocPayHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveAdhocPay(String sPrimaryKey,AdhocPayHeaderBean oAdhocPayHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    

     String paycode,paymode,yearmon;
    paycode=oAdhocPayHeaderBean.getTxtPayCode();
    paymode=oAdhocPayHeaderBean.getTxtPayMode();
    yearmon=oAdhocPayHeaderBean.getTxtPayYYMM();
  
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintAdhocPayBean oMaintAdhocPayBean = (MaintAdhocPayBean)oIt.next();
//        System.out.println(oMaintAdhocPayBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintAdhocPayBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertAdhocPayDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, paycode));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,yearmon ));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, paymode));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtOptCode())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtGroupCode())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtCategCode())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtDesigCode())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtAmount())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintAdhocPayBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateAdhocPay(?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, paycode));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, yearmon));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtOptCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtSrlNo())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtGroupCode())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtCategCode())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtDesigCode())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtAmount())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintAdhocPayBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteAdhocPay(?,?,?,?)");
            bDelete = true;
          }

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, paycode));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, yearmon));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtSrlNo())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAdhocPayBean.getTxtOptCode())));
          oBeanDelete.addToBatch(oParameters);          
        }
      }
      
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
 public AdhocPayComboVO getAdhocPayComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    AdhocPayComboVO oAdhocPay=null;


    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetGroup(?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        ArrayList oGroupList = null;
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oGroupList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oAdhocPay = new AdhocPayComboVO();
          String grpId = ((oRow.get("emp_grp").getString()));
          String grpDesc= ((oRow.get("emp_grp").getString()));
          ComboVO oComboVO = new ComboVO(grpDesc,grpId);
          oGroupList.add(oComboVO);
        }


      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCtgry(?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        ArrayList oCategList = null;
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oCategList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oAdhocPay = new AdhocPayComboVO();
          String categId = ((oRow.get("gbl_code").getString()));
          String categDesc= ((oRow.get("code_sdesc").getString()));
          ComboVO oComboVO = new ComboVO(categDesc,categId);
          oCategList.add(oComboVO);
        }        
        oAdhocPay.setCategList(oCategList);        
        oAdhocPay.setGroupList(oGroupList);
        return oAdhocPay;
  }
  
public LovVO getAdhocYearLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("YearMonth");    
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAdhocYYMM(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("YYMM").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


public LovVO getAdhocPayCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAdhocPayQ(?,?,?,?)");
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



public LovVO getAdhocPayCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayrollPayLovN(?,?,?,?)");
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

public LovVO getAdhocDesgLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("DESIGNATION");
    arylstHeaderNames.add("DESIGNATION DESCRIPTION");  
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
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDsgnLov(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("DSGN_ID").getString());
       oLOVBean.setDetailField2(oRow.get("dsgn_desc").getString());  
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

 public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }  

  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean);
      
    }
  }
  
private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    checkAdhocPayHeader(oBaseHeaderBean,oList);
    checkMaxPayYear(oBaseHeaderBean,oList);
    reportError(oList);
   
  }

 private void checkAdhocPayHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        AdhocPayHeaderBean  oAdhocPayHeaderBean  = (AdhocPayHeaderBean)oBaseHeaderBean;

        //System.out.println(oAdhocPayHeaderBean.getScreenModePay1());       
        if(oAdhocPayHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayHeaderBean.getTxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayHeaderBean.getTxtPayMode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oAdhocPayHeaderBean.getTxtPayYYMM())));

          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_AdhocHeaderDuplicateCheck(?,?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.Adhoc.DuplicateCheck",EnrgiseConstants.MESSAGE));
              //oAdhocPayHeaderBean.setHeaderMode("N");
            }
        }
  }


private void checkMaxPayYear(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        AdhocPayHeaderBean  oAdhocPayHeaderBean  = (AdhocPayHeaderBean)oBaseHeaderBean;

//        System.out.println(oAdhocPayHeaderBean.getHeaderMode());       
        if(oAdhocPayHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
       
          oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxAdhocPayYear(?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yymm").getString(); 
              String status = oRow.get("status").getString(); 

              if (!sRevYear.equals(oAdhocPayHeaderBean.getTxtPayYYMM()))
              {
                  oAdhocPayHeaderBean.setHeaderMode("N");
                  ArrayList oArguments = new ArrayList();
                  oArguments.add(sRevYear);
                  oList.add(new EnrgiseApplicationException("Payroll.Adhoc.maxPayYearcheck",oArguments));                
              }

              else 
              {
                if (Integer.parseInt(status) >= 2 )
                {
                    oAdhocPayHeaderBean.setHeaderMode("N");
                    oList.add(new EnrgiseApplicationException("Payroll.Adhoc.statusCheck",EnrgiseConstants.MESSAGE));                                
                }
              }

            }           

        }
  }



}