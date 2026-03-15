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
import FCIPAY.Payroll.UTILITY.MaintainInternalSavingsBean;
import FCIPAY.Payroll.UTILITY.IntSavHeaderBean;
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
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.sql.Date;
//import IBA.Payroll.common.utility.DateUtility;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntSavDetailInfo;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

public class IntSavBusinessObject extends BaseBO
{
  public IntSavBusinessObject()
  {
  }
 public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("InternalScreen"))
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
  
  public RecordMetaInfo getIntSavDetailMetaInfo(String sPrimaryKey,IntSavDetailInfo oIntSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

      String EmpNo,Savcode;
      EmpNo = oIntSavDetailInfo.getTxtEmpNo1();
      Savcode = oIntSavDetailInfo.getTxtSavCode1();

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Savcode));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oIntSavDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oIntSavDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntSavCount(?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getIntSavDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,IntSavDetailInfo oIntSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintainInternalSavingsBean oIntSav;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oIntSavDetail = null;

      String EmpNo,Savcode;
      EmpNo = oIntSavDetailInfo.getTxtEmpNo1();
      Savcode = oIntSavDetailInfo.getTxtSavCode1();

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,Savcode));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oIntSavDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oIntSavDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntSavDetail(?,?,?,?,?,?,?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oIntSavDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oIntSav = new MaintainInternalSavingsBean();
          oIntSav.setTxtEmpNo((oRow.get("emp_num").getString()));
          oIntSav.setTxtEmpName((oRow.get("Name").getString()));
          oIntSav.setStatus("Q");
          oIntSav.setTxtSavCode(oRow.get("savings_code").getString());
          oIntSav.setHdnSavCodeSrlNo(oRow.get("savings_srl_no").getString());          
          oIntSav.setTxtDescription(oRow.get("pay_code_desc").getString());          
          oIntSav.setTxtSavingsNumber(oRow.get("savings_number").getString());          
          //oIntSav.setTxtSavingsDate(oRow.get("savings_date").getString());
          
          //String dd=FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("savings_date").getDate());          
          DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");       
          String savingDate = formatter.format(oRow.get("savings_date").getDate()); 
          //System.out.println("Today : " + savingDate); 

          
          
          String mm=savingDate.substring(3,5);//
          String yy=savingDate.substring(6,10);
          String displayDate=yy+mm;
          
          oIntSav.setTxtSavingsDate(displayDate);
          //oIntSav.setTxtSavingsDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("savings_date").getDate()));
          
          oIntSav.setTxtValUpto(oRow.get("valid_upto_yymm").getString());
          oIntSav.setTxtAmount(oRow.get("savings_amount").getString());          
          oIntSav.setTxtLastYYMM(oRow.get("last_payroll_yymm").getString());
          oIntSav.setTxtAgency(oRow.get("agency_code").getString()); 
          oIntSav.setTxtAgencySite(oRow.get("agency_site_desc").getString());
          oIntSav.setTxtAgencySiteCode(oRow.get("agency_site_code").getString()); 
          oIntSav.setTxtAgencyName(oRow.get("agency_code_desc").getString()); 
          oIntSav.setTxtAgencyNo(oRow.get("segment_desc").getString());
          
          //  added by varalika on 30-Sep-2011
          oIntSav.setTxtCreationDate(formatter.format(oRow.get("created_time_stamp").getDate()));
          oIntSav.setTxtCreatedBy(oRow.get("user_id_created").getString());
          oIntSav.setTxtCreatedSite(oRow.get("created_site_id").getString());
          if(oRow.get("modified_time_stamp").getDate() != null && !"".equals(oRow.get("modified_time_stamp").getDate()))
          {
          oIntSav.setTxtUpdationDate(formatter.format(oRow.get("modified_time_stamp").getDate()));
          }
          if(oRow.get("user_id_modified").getString() != null && !"".equals(oRow.get("user_id_modified").getString()))
          {
          oIntSav.setTxtUpdatedBy(oRow.get("user_id_modified").getString());
          }
           if(oRow.get("modified_site_id").getString() != null && !"".equals(oRow.get("modified_site_id").getString()))
          {
          oIntSav.setTxtUpdatedSite(oRow.get("modified_site_id").getString());
          }
          //  ended by varalika
          
          oIntSavDetail.add(oIntSav);
        }
  
    return oIntSavDetail;
    
  }

//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("InternalScreen"))
    {
      saveIntSav(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveIntSav(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    IntSavHeaderBean oIntSavHeaderBean = (IntSavHeaderBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
//        System.out.println(oMaintainInternalSavingsBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintainInternalSavingsBean.getStatus().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertIntSavDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          
          String savingDate = oMaintainInternalSavingsBean.getTxtSavingsDate();
          String yy=savingDate.substring(0,4);
          String mnth=savingDate.substring(4,6);
          String month=getMonth(mnth);
          String sav_date="01-"+month+"-"+yy; 
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtSavCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtSavingsNumber())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtValUpto())));                   
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(sav_date)));          
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAmount())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAgency())));         
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAgencySiteCode())));  

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintainInternalSavingsBean.getStatus().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateIntSavDetail(?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          
          
          String savingDate = oMaintainInternalSavingsBean.getTxtSavingsDate();
          String yy=savingDate.substring(0,4);
          String mnth=savingDate.substring(4,6);
          String month=getMonth(mnth);
          String sav_date="01-"+month+"-"+yy; 
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getHdnSavCodeSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtEmpNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtSavCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtSavingsNumber())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtValUpto())));                   
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(sav_date)));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAmount())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtSiteID()))); 
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAgency())));         
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAgencySiteCode())));  


           oBean.addToBatch(oParameters);
       
        }
        else if(oMaintainInternalSavingsBean.getStatus().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteIntSav(?,?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getHdnSavCodeSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtSavCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtEmpNo())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtSiteID())));
           

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
         System.out.println("Exception caught is"+e.getMessage());
      }
  }
public String  getMonth(String mnth){
String month="";
if(mnth.equalsIgnoreCase("01")){
month="JAn";
}
if(mnth.equalsIgnoreCase("02")){
month="Feb";
}
if(mnth.equalsIgnoreCase("03")){
month="Mar";
}

if(mnth.equalsIgnoreCase("04")){
month="Apr";
}
if(mnth.equalsIgnoreCase("05")){
month="May";
}
if(mnth.equalsIgnoreCase("06")){
month="Jun";
}
if(mnth.equalsIgnoreCase("07")){
month="Jul";
}
if(mnth.equalsIgnoreCase("08")){
month="Aug";
}
if(mnth.equalsIgnoreCase("09")){
month="Sep";
}
if(mnth.equalsIgnoreCase("10")){
month="Oct";
}
if(mnth.equalsIgnoreCase("11")){
month="Nov";
}
if(mnth.equalsIgnoreCase("12")){
month="Dec";
}
return month;
}
 public LovVO getIntSavLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");   
    arylstHeaderNames.add("CPF Code");   
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
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
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpNoLov(?,?,?,?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("cpf_code").getString()); 
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

 public LovVO getIntSavQLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
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
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntSavEmpLovQ(?,?,?,?,?,?,?)");
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
         oLOVBean.setDetailField3(oRow.get("cpf_code").getString());            
        
        oList.add(oLOVBean);
      }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public LovVO getIntSavCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("SavingsCode");  
    arylstHeaderNames.add("SavingsCodeDesc");          // added by dushyant on 16-09-2010
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
     /* oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField1()))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField2()))));     // added by dushyant on 16-09-2010
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntSavLovQ_new(?,?,?,?)");       // added by dushyant on 16-09-2010 
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



public LovVO getIntSavCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("SavingsCode");  
    arylstHeaderNames.add("SavingsCodeDesc"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
     /* oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField1()))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField2()))));     // added by dushyant on 16-09-2010
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
   // oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntSavLovN(?,?,?)");
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIntSavLovN_new(?,?,?,?)"); */
      // added by dushyant on 19-09-2010 for saving desc
      
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
         MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
           if(oMaintainInternalSavingsBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
                  {
                     oBean = new DBUtilitiesBean();
                     oParameters = new ArrayList();
                     oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAgency())));                      
                     oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAgencySiteCode())));        
                     oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));       
                     oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
                     if(((!oMaintainInternalSavingsBean.getTxtAgency().equalsIgnoreCase("")) && (!oMaintainInternalSavingsBean.getTxtAgencySiteCode().equalsIgnoreCase(""))))
                     {
                         oOutArray1 = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_CheckSupplier(?,?,?,?)");
                         Integer i = (Integer)((DBObject)oOutArray1.get(0)).getObject();
                         count = i.intValue();                   
                          if(count == 0)     
                          {                             
                            SrlNo= SrlNo +" "+oMaintainInternalSavingsBean.getTxtSrlNo();                           
                          }
                     }
                  }     
  
  }
  if(!SrlNo.equalsIgnoreCase("Record")){
  oArguments.add(" in " + SrlNo);
  oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.CheckSupplier",oArguments));
  }
  }

 
  public ArrayList getAccDirPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oList = new ArrayList();   
      ArrayList payCodeList = new ArrayList();   
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();      
      oList.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));       
      oList.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_PAYROLL_MISC.proc_Chk_Acct_Dir(?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   
     
    int count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           payCodeList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        
        payCodeList.add(oRow.get("pay_code").getString());
  
      }    
      
    return payCodeList;

  }
   private void checkPayAgencyMap(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
	  ArrayList payCodeList = new ArrayList();     
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oOutArray ; //Output 
    ArrayList oArguments = new ArrayList(); 
    String Empno="Record";
    DBUtilitiesBean oBean ; 
    ArrayList oParameters;
    payCodeList=getAccDirPayCodes();
    int count=1;
    IntSavHeaderBean oBaseHeaderBean1 = (IntSavHeaderBean)oBaseHeaderBean;

				while(oIt.hasNext())
				  {
					  MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
					   if(oMaintainInternalSavingsBean.getStatus().equals(EnrgiseConstants.NEW_MODE)){
             oBean = new DBUtilitiesBean();
             oParameters = new ArrayList();
					   for(int i=0;i<payCodeList.size();i++)
									{
										if(payCodeList.get(i).toString().equalsIgnoreCase(oMaintainInternalSavingsBean.getTxtSavCode())){										
										  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtEmpNo())));
										  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtSavCode())));
										  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean1.getTxtSiteID())));
                      //System.out.println(oMaintainInternalSavingsBean.getTxtEmpNo()+"--"+oMaintainInternalSavingsBean.getTxtSavCode()+"--"+oBaseHeaderBean1.getTxtSiteID());
                      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));       
										  oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
										  oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_SupplierMandatoryCheck(?,?,?,?,?)");
										  Integer m = (Integer)((DBObject)oOutArray.get(0)).getObject();
										  count= m.intValue();
                      
										  if(count==0){
                       if(((oMaintainInternalSavingsBean.getTxtAgency().equalsIgnoreCase("")) && (oMaintainInternalSavingsBean.getTxtAgencySiteCode().equalsIgnoreCase(""))))
                     {
										  Empno=Empno +" "+ oMaintainInternalSavingsBean.getTxtSrlNo();		
                     }
										  }										  
										}
									}
					   
					   }
				  }

	if(!Empno.equalsIgnoreCase("Record")){
                  oArguments.add(Empno);
                  oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.CheckMandatorySpplier",oArguments));
           }
  }

 /////////////end added by sonia on 09-02-2011////////////////

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
    /////////////added by sonia on 09-02-2011/////////     
    ArrayList oList1 = new ArrayList();
    ArrayList oList2 = new ArrayList();
    checksupplierRecord(oBaseHeaderBean,oDetailBeanArray,oList1);
    reportError(oList1);
    checkPayAgencyMap(oBaseHeaderBean,oDetailBeanArray,oList2);
    reportError(oList2);
  /////////////added by sonia on 09-02-2011/////////  
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    IntSavHeaderBean oIntSavHeaderBean = (IntSavHeaderBean)oBaseHeaderBean;
    // checkMaxPayYear(oIntSavHeaderBean.getTxtSiteID(),oIntSavHeaderBean.getHdnEmpLbrFlag());
    checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList);    
    //    checkFirst(oBaseHeaderBean,oList);
    checkVolPF(oBaseHeaderBean,oDetailBeanArray,oList);
    checkValidUpto(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList);
    chkDuplicateSavings(oBaseHeaderBean,oDetailBeanArray,oList);//added by swapnendu Dt 24 Apr 2012.
    reportError(oList);
  }
  
    private void chkDuplicateSavings(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        QueryRow oRow = null;
        QueryValue oValue = null;
        String errMsg = null;
        Iterator oIt = null;
        IntSavHeaderBean oIntSavHeaderBean = (IntSavHeaderBean)oBaseHeaderBean;
        oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
            MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
            if(!(oMaintainInternalSavingsBean.getStatus().equals("D")))
            {
                count++;
                if(oMaintainInternalSavingsBean.getStatus().equals("N"))
                {
                    if((!(oMaintainInternalSavingsBean.getTxtSavingsNumber().equals(""))) || (oMaintainInternalSavingsBean.getTxtSavingsNumber()!=null))
                    {
                        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oMaintainInternalSavingsBean.getTxtEmpNo())));
                        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oMaintainInternalSavingsBean.getTxtSavingsNumber())));
                        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oMaintainInternalSavingsBean.getTxtSavingsDate())));
                        oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR, new String(oMaintainInternalSavingsBean.getTxtValUpto())));
                        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
                        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
                        oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_ValidateSavings(?,?,?,?,?,?)",true,false);
                        errMsg = (String)((DBObject)oOutArray.get(0)).getObject();
                        Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
                        if(!errCode.equals(new Integer(0)))
                        {
                            ArrayList oArguments = new ArrayList();
                            oArguments.add(errMsg);
                            oArguments.add(new Integer(count));
                            oList.add(new EnrgiseApplicationException("Payroll.SavingNo.duplicatecheck",oArguments));
                        }
                    }
                }
            }
        }
    }

  private void checkVolPF(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    String errMsg = null;
    Iterator oIt = null;
    IntSavHeaderBean oIntSavHeaderBean = (IntSavHeaderBean)oBaseHeaderBean;
    oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
//        System.out.println(oMaintainInternalSavingsBean.getStatus());

        if(!(oMaintainInternalSavingsBean.getStatus().equals("D")))
          count++;


        if(oMaintainInternalSavingsBean.getStatus().equals("N")|| oMaintainInternalSavingsBean.getStatus().equals("U")) 
        {
          String pcode = oMaintainInternalSavingsBean.getTxtSavingsNumber();

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtSavCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainInternalSavingsBean.getTxtAmount())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_ValidateVPFAmt(?,?,?,?,?,?,?)",true,false);
      
            errMsg = (String)((DBObject)oOutArray.get(0)).getObject();
            Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
            if(!errCode.equals(new Integer(0)))
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(errMsg);
              oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
            }
        }
      }
  }
// added by sonia on 07-03-2011
private void checkValidUpto(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    String sFinYear="";
    String status="";
     
      IntSavHeaderBean oIntSavHeaderBean = (IntSavHeaderBean)oBaseHeaderBean;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oIntSavHeaderBean.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sFinYear = oRow.get("yymm").getString();
      status = oRow.get("status").getString();
    }
           int payYYMM=0;
            if(!sFinYear.equalsIgnoreCase("")){
             payYYMM=Integer.parseInt(sFinYear);
            }
      //int payYYMM=Integer.parseInt(sFinYear);
       int stat=0;
       if(!status.equalsIgnoreCase("")){
       stat=Integer.parseInt(status);
       }

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
//        System.out.println(oMaintainInternalSavingsBean.getStatus());

        if(!(oMaintainInternalSavingsBean.getStatus().equals("D")))
          count++;


        if(oMaintainInternalSavingsBean.getStatus().equals("N")|| oMaintainInternalSavingsBean.getStatus().equals("U"))   
        {
          String sValidUpto = oMaintainInternalSavingsBean.getTxtValUpto();
          int validUpto=0;
          if(!sValidUpto.equalsIgnoreCase("")){
          validUpto=Integer.parseInt(sValidUpto);
          }
            if(stat>0 && validUpto <= payYYMM)
            {       
              ArrayList oArguments = new ArrayList();
              oArguments.add(sFinYear);
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("Payroll.IntSav.ValidUpto.Error",oArguments));
            }else if(validUpto < payYYMM)
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(sFinYear);
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("Payroll.IntSav.ValidUpto.Error",oArguments));
            }
        }
      }
  }
 //commented by sonia on 07-03-2011
 /* private void checkValidUpto(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    String sFinYear="";
    String status="";
      
      IntSavHeaderBean oIntSavHeaderBean = (IntSavHeaderBean)oBaseHeaderBean;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oIntSavHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oIntSavHeaderBean.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sFinYear = oRow.get("yymm").getString(); 
      status = oRow.get("status").getString(); 
    }
      int payYYMM=Integer.parseInt(sFinYear);
      int stat=Integer.parseInt(status);

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
//        System.out.println(oMaintainInternalSavingsBean.getStatus());

        if(!(oMaintainInternalSavingsBean.getStatus().equals("D")))
          count++;


        if(oMaintainInternalSavingsBean.getStatus().equals("N")|| oMaintainInternalSavingsBean.getStatus().equals("U"))    
        {
          String sValidUpto = oMaintainInternalSavingsBean.getTxtValUpto();
          int validUpto=Integer.parseInt(sValidUpto);
            if(stat>0 && validUpto <= payYYMM)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(sFinYear);
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("Payroll.IntSav.ValidUpto.Error",oArguments));
            }else if(validUpto < payYYMM)
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(sFinYear);
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("Payroll.IntSav.ValidUpto.Error",oArguments));
            }
        }
      }
  }
*/
//end commented by sonia on 07-03-2011
 /*
 Commented by sonia on 01-04-2011
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
  }*/

  /////added by sonia on 01-04-2011//////////////
  private void checkYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
     // MaintDirectPayrollHeaderBean oMaintDirectPayrollHeaderBean=(MaintDirectPayrollHeaderBean)oBaseHeaderBean;
      
       IntSavHeaderBean oIntSavHeaderBean = (IntSavHeaderBean)oBaseHeaderBean;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oIntSavHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oIntSavHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");                 
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

      String sRevYear = "";
      String status = "";   
      String arcFlag="";
      
      oIt = oRetList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        sRevYear = oRow.get("yymm").getString(); 
        status = oRow.get("status").getString(); 
        arcFlag = oRow.get("arc_flag").getString(); 
  }
  
    if(arcFlag!=null && arcFlag.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
      
      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintainInternalSavingsBean oMaintainInternalSavingsBean = (MaintainInternalSavingsBean)oIt.next();
//        System.out.println(oMaintainDirectPayrollBean.getStatus());
        if(!(oMaintainInternalSavingsBean.getStatus().equals("D")))
          count++;
        //System.out.println("Saving Date" +oMaintainInternalSavingsBean.getTxtSavingsDate());
        if(!oMaintainInternalSavingsBean.getStatus().equals("Q") && !oMaintainInternalSavingsBean.getTxtSavingsDate().equals(""))    
        {
            int iFromYear = Integer.parseInt(oMaintainInternalSavingsBean.getTxtSavingsDate());
            int vRevYear=0;
            if(!sRevYear.equalsIgnoreCase("")){
            vRevYear=Integer.parseInt(sRevYear);
            }
            if(vRevYear == iFromYear  && Integer.parseInt(status) == 2 )  
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oArguments.add(new String(sRevYear));
              oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.MonthlyPayrollRun",oArguments));
            }
            else if (vRevYear  > iFromYear )
            {        
              ArrayList oArguments = new ArrayList();
              if((oMaintainInternalSavingsBean.getStatus().equals("D")))
              {
                //oMaintainDirectPayrollBean.setStatus("Q");    //commented by yogesh on 22 nd sep 2010
               // oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.Deletion")); //commented by yogesh on 22 nd sep 2010
              }else
              {
                oArguments.add(new Integer(count));
                oArguments.add(new String(sRevYear));              
                oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.YearMonthNotValid",oArguments));
              }
            }            
        }
      } 
  }
    //////////////////End added by sonia on 09-02-2011////////
}


