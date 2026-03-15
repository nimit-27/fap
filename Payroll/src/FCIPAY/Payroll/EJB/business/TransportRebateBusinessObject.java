package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleComboVO;
import FCIPAY.Payroll.common.vo.ComboVO;
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
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintTransportSubsideQueryVO;
import FCIPAY.Payroll.UTILITY.MaintTransportSubsideBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintTransportSubsideDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintTransportSubsideHeaderBean;

public class TransportRebateBusinessObject extends BaseBO
{
  public TransportRebateBusinessObject()
  {
  }

  public RecordMetaInfo getTransportRebateHeaderMetaInfo(MaintTransportSubsideQueryVO oMaintTransportSubsideQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      Timestamp oWhenPicked = null;
      int count = 0;
      BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
      String locCode = oMaintTransportSubsideQueryVO.getLoginLocCode()+"";
      ArrayList oOutArray; //Output 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideQueryVO.getTxtFinYear())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideQueryVO.getHdnEmpLbrFlag())));      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetTransSubsideHdrCount(?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
  }
  
  public ArrayList getTransportRebateHeader(MaintTransportSubsideQueryVO oMaintTransportSubsideQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = null; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    if(oMaintTransportSubsideQueryVO == null)
    {
        oMaintTransportSubsideQueryVO = new MaintTransportSubsideQueryVO();
    }
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    String locCode = oMaintTransportSubsideQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideQueryVO.getTxtFinYear()))); 
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideQueryVO.getHdnEmpLbrFlag())));  
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetTransSubsideHdr(?,?,?,?,?,?,?,?)");
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    MaintTransportSubsideHeaderBean oMaintTransportSubsideHeaderBean;
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
      oMaintTransportSubsideHeaderBean = new MaintTransportSubsideHeaderBean();
      oMaintTransportSubsideHeaderBean.setTxtEmpNo(oRow.get("emp_num").getString());
      oMaintTransportSubsideHeaderBean.setTxtEmpName(oRow.get("name").getString());
      oMaintTransportSubsideHeaderBean.setTxtFinYear(oRow.get("FIN_YEAR").getString());
      oHeaderList.add(oMaintTransportSubsideHeaderBean);
    }              
    return oHeaderList;
  }
 

    public RecordMetaInfo getTransportRebateDetailMetaInfo(String sPrimaryKey,MaintTransportSubsideDetailInfo oMaintTransportSubsideDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output 
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        oRecordMetaInfo.setRecordCount(12);
        return oRecordMetaInfo;            
    }

    public ArrayList getTransportRebateDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,MaintTransportSubsideDetailInfo oMaintTransportSubsideDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        MaintTransportSubsideBean oMaintTransportSubsideBean;
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        ArrayList oDtlArray = null;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oMaintTransportSubsideDetailInfo.getTxtEmpNo()));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideDetailInfo.getTxtFinYear())));                      
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_TransportSubsideDetail(?,?,?,?,?,?)");
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
            return getNewTransportrebateDetails(oMaintTransportSubsideDetailInfo);
        } 
        oIt = oList.iterator();
        oDtlArray = new ArrayList();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            oMaintTransportSubsideBean = new MaintTransportSubsideBean();
            oMaintTransportSubsideBean.setTxtYYMM(oRow.get("yymm").getString());
            oMaintTransportSubsideBean.setTxtMonth(oRow.get("month").getString());
            oMaintTransportSubsideBean.setTxtAmt(oRow.get("rebate_amt").getString());
            oMaintTransportSubsideBean.setDetailId(oRow.get("srl_no").getString());
            oMaintTransportSubsideBean.setStatus("Q");
            oDtlArray.add(oMaintTransportSubsideBean); 
        }
        return oDtlArray; 
  }    

  public ArrayList getNewTransportrebateDetails(MaintTransportSubsideDetailInfo oMaintTransportSubsideDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    int count = 0;
    MaintTransportSubsideBean oMaintTransportSubsideBean;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleDetail = null;
    int mm=3;
    String strYYMM="";
    String [] arrMonth={"January","February","March","April","May","June","July","August","September","October","November","December"};
    while(count<12)
    {
      if(count == 0)
        {
          oPayScaleDetail = new ArrayList();
        }
        count++;
        oMaintTransportSubsideBean = new MaintTransportSubsideBean();
        strYYMM = oMaintTransportSubsideDetailInfo.getTxtFinYear().substring(0,4);
        if(mm<3)
        {
            strYYMM=(Integer.parseInt(strYYMM)+1)+"";
        }
        if(mm<10)
        {
            oMaintTransportSubsideBean.setTxtYYMM(strYYMM+"0"+mm);
        }
        else
        {
            oMaintTransportSubsideBean.setTxtYYMM(strYYMM+mm);
        }
        oMaintTransportSubsideBean.setTxtAmt(oMaintTransportSubsideDetailInfo.getTxtAmtHdr());
        oMaintTransportSubsideBean.setTxtMonth(arrMonth[mm-1]);
        oMaintTransportSubsideBean.setStatus("N");           
        oPayScaleDetail.add(oMaintTransportSubsideBean);
        if(mm==12)
          mm=1;
        else
          mm++;
    }
    return oPayScaleDetail; 
  } 

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      return null;
  }  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
  }  

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
      saveTransportRebate(sHeaderPrimaryKey, oBaseHeaderBean, oDetailBeanArray);
  }   
  
  private void saveTransportRebate(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    MaintTransportSubsideHeaderBean oMaintTransportSubsideHeaderBean = (MaintTransportSubsideHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray;
    ArrayList oParameters = null; //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintTransportSubsideBean oMaintTransportSubsideBean = (MaintTransportSubsideBean)oIt.next();
        if(oMaintTransportSubsideBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAYROLL_MISC.proc_InsertTransSubsideDetail(?,?,?,?,?,?)");
            bInsert = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtFinYear())));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideBean.getTxtYYMM())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideBean.getTxtAmt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
          oParameters=null;
       }
        else if(oMaintTransportSubsideBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_payroll_misc.proc_UpdateTransSubsideDetail(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtFinYear())));          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideBean.getTxtYYMM())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideBean.getTxtAmt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTransportSubsideHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          oParameters = null;
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
   
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("PayScaleCDA"))
    {
      sDetailTable = "lstPayScaleDtl";
    }
    initializeBO("PayScaleCDA",sDetailTable);
  }  
  
  public LovVO getTransportSubsideLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_TransportSubside_LOVQ(?,?,?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
       oLOVBean.setDetailField2(oRow.get("empName").getString());            
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString()); 
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getTransportSubsideLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_TransportSubside_LOVN(?,?,?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
       oLOVBean.setDetailField2(oRow.get("empName").getString());            
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString()); 
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    MaintTransportSubsideHeaderBean oMaintTransportSubsideHeaderBean = (MaintTransportSubsideHeaderBean)oBaseHeaderBean;
    checkMaxPayYear(oMaintTransportSubsideHeaderBean.getTxtSiteID(),oMaintTransportSubsideHeaderBean.getHdnEmpLbrFlag());
    reportError(oList);
  }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private String checkMaxPayYear(String siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = null; //Input Parameters
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
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    return "";
  }
  
  public String getMaxPayYear(long siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
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
      status = oRow.get("status").getString(); 
    }    
    return sRevYear;
  }
  
}