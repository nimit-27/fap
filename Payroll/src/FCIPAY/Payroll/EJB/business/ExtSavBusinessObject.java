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
import FCIPAY.Payroll.UTILITY.MaintainExternalSavingsBean;
import FCIPAY.Payroll.UTILITY.ExtSavHeaderBean;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.ExtSavDetailInfo;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

public class ExtSavBusinessObject extends BaseBO
{
  public ExtSavBusinessObject()
  {
  }
 public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("ExternalScreen"))
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
  
  public RecordMetaInfo getExtSavDetailMetaInfo(String sPrimaryKey,ExtSavDetailInfo oExtSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

    String   sLoginEmpNo;  
    String sLoginSiteId; 
    
      String EmpNo,Savcode, sFinYYMM;
      String lUserId, lSiteId;
      EmpNo = oExtSavDetailInfo.getTxtEmpNo1();
      Savcode = oExtSavDetailInfo.getTxtSavCode1();
      sFinYYMM = oExtSavDetailInfo.getTxtFinYYMM();  
      lUserId =  String.valueOf(oExtSavDetailInfo.getUserId()); 
      lSiteId = String.valueOf(oExtSavDetailInfo.getSiteId()); 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Savcode));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sFinYYMM)); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oExtSavDetailInfo.getHdnEmpLbrFlag()));     
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR ,lUserId));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,lSiteId));            
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetExtSavCount(?,?,?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getExtSavDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,ExtSavDetailInfo oExtSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintainExternalSavingsBean oExtSav;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oExtSavDetail = null;

      String EmpNo,Savcode, sFinYYMM;
      String lUserId, lSiteId;      
      EmpNo = oExtSavDetailInfo.getTxtEmpNo1();
      Savcode = oExtSavDetailInfo.getTxtSavCode1();
      sFinYYMM = oExtSavDetailInfo.getTxtFinYYMM();     

    lUserId =  String.valueOf(oExtSavDetailInfo.getUserId()); 
    lSiteId = String.valueOf(oExtSavDetailInfo.getSiteId()); 
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,Savcode));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sFinYYMM));  
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oExtSavDetailInfo.getHdnEmpLbrFlag()));     
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR ,lUserId));      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,lSiteId));                  
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetExtSavDetail(?,?,?,?,?,?,?,?,?,?)");
      
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
            oExtSavDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oExtSav = new MaintainExternalSavingsBean();
          oExtSav.setTxtEmpNo((oRow.get("emp_num").getString()));
          oExtSav.setTxtEmpName((oRow.get("Name").getString()));
          oExtSav.setStatus("Q");
          oExtSav.setTxtSavCode(oRow.get("savings_code").getString());
          oExtSav.setTxtDescription(oRow.get("pay_code_desc").getString());                             
          oExtSav.setTxtType(oRow.get("savings_type").getString());
          oExtSav.setTxtSavingsNumber(oRow.get("savings_number").getString());
          oExtSav.setTxtSavingsYear(oRow.get("savings_year").getString());
          oExtSav.setTxtAmount(oRow.get("savings_amount").getString());    
          oExtSav.setHdnSavCodeSrlNo(oRow.get("savings_srl_no").getString());
//          oExtSav.setTxtFinYYMM(oRow.get("fin_yymm").getString());  

           //  added by varalika on 30-Sep-2011
          DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
          oExtSav.setTxtCreationDate(formatter.format(oRow.get("created_time_stamp").getDate()));
          oExtSav.setTxtCreatedBy(oRow.get("user_id_created").getString());
          oExtSav.setTxtCreatedSite(oRow.get("created_site_id").getString());
          if(oRow.get("modified_time_stamp").getDate() != null && !"".equals(oRow.get("modified_time_stamp").getDate()))
          {
          oExtSav.setTxtUpdationDate(formatter.format(oRow.get("modified_time_stamp").getDate()));
          }
          if(oRow.get("user_id_modified").getString() != null && !"".equals(oRow.get("user_id_modified").getString()))
          {
          oExtSav.setTxtUpdatedBy(oRow.get("user_id_modified").getString());
          }
           if(oRow.get("modified_site_id").getString() != null && !"".equals(oRow.get("modified_site_id").getString()))
          {
          oExtSav.setTxtUpdatedSite(oRow.get("modified_site_id").getString());
          }
          //  ended by varalika
          
          oExtSavDetail.add(oExtSav);
        }
          
    return oExtSavDetail;
    
  }

  //public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
   if(sScreenName.equals("ExternalScreen"))
    {
      saveExtSav(sHeaderPrimaryKey,(ExtSavHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveExtSav(String sHeaderPrimaryKey,ExtSavHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
   //ExtSavHeaderBean oExtSavHeaderBean = (ExtSavHeaderBean)oBaseHeaderBean; 
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintainExternalSavingsBean oMaintainExternalSavingsBean = (MaintainExternalSavingsBean)oIt.next();
//        System.out.println(oMaintainExternalSavingsBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintainExternalSavingsBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertExtSavDetail(?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtSavCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtFinYYMM())));          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtType())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtSavingsNumber())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtSavingsYear())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtAmount())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        
          oBeanInsert.addToBatch(oParameters);
        }


       else if(oMaintainExternalSavingsBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
       {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateExtSavDetail(?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getHdnSavCodeSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtEmpNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtSavCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtFinYYMM())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtType())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtSavingsNumber())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtSavingsYear())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtAmount())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
       
        }
        else if(oMaintainExternalSavingsBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteExtSav(?,?,?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getHdnSavCodeSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtSavCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainExternalSavingsBean.getTxtEmpNo())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtFinYYMM())));  
		  oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
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
    ExtSavHeaderBean oExtSavHeaderBean = (ExtSavHeaderBean)oBaseHeaderBean;
    checkMaxPayYear(oExtSavHeaderBean.getTxtSiteID(),oExtSavHeaderBean.getHdnEmpLbrFlag());
    reportError(oList);    

  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
public LovVO getExtSavLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code");                            // added by dushyant 0n 16-09-2010
    oLovVO.setHeaderList(arylstHeaderNames);

    String sLoginEmpNo;  
    sLoginEmpNo=new String("");  
    
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);         // added by dushyant on 16-09-2010
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));  
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));    
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sLoginEmpNo));            
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));     // added by dushyant on 16-09-2010
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetExtSavEmpNoLov_new(?,?,?,?,?,?,?,?)");    //  previously "proc_GetExtSavEmpNoLov"
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
       oLOVBean.setDetailField2(oRow.get("Name").getString());            
       oLOVBean.setDetailField3(oRow.get("cpf_code").getString());    // added by dushyant on 16-09-2010
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
 
 public LovVO getExtSavQLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code");                       // added by dushyant on 15-09-2010
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);           // added by dushyant on 15-09-2010
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtYrMnth"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));           
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));             // added by dushyant on 15-09-2010
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetExtSavEmpLovQ_new(?,?,?,?,?,?,?)");   // previously "proc_GetExtSavEmpLovQ"
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
       oLOVBean.setDetailField2(oRow.get("Name").getString());            
       oLOVBean.setDetailField3(oRow.get("cpf_code").getString());        // added by dushyant on 15-09-2010
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


public LovVO getExtSavCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("SavingsCode");  
    arylstHeaderNames.add("SavingsCodeDesc"); 
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
      /*oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField1()))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField2()))));   // added by dushyant on 17-09-2010 for saving desc
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetExtSavLovQ_new(?,?,?,?)");*/
      GetLovAction oGetLovAction = new GetLovAction();
      oOutArray = oGetLovAction.GetLov(oLovQueryVO,"N");
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



public LovVO getExtSavCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("SavingsCode");  
    arylstHeaderNames.add("SavingsCode Description"); 
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
      /*oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField1()))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField2()))));       // added by dushyant for sav_desc_insert_mode on 17-09-2010
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetExtSavLovN_new(?,?,?,?)");    //  previously "proc_GetExtSavLovN"
      */
      GetLovAction oGetLovAction = new GetLovAction();
      oOutArray = oGetLovAction.GetLov(oLovQueryVO,"N");
     
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



  public LovVO getExtSavFinYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Financial Period");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryExtSavFinYYMMLOV(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("FIN_YYMM").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public String sGetFinYear(long lLocCode,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      String sLocCode=lLocCode+"";
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sLocCode.trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.Get_FinYear(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      String sFinYear = (((Long)oTotalRecord.getObject()).toString());
      return sFinYear; 
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
    
    return "";
  }
  }


