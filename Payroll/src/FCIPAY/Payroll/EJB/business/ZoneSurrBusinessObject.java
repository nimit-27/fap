package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ZoneSurrQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ZoneSurrComboVO;
import FCIPAY.Payroll.UTILITY.ZoneSurrHeaderBean;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

public class ZoneSurrBusinessObject extends BaseBO 
{
  public ZoneSurrBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("LeaveScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public RecordMetaInfo getZoneSurrHeaderMetaInfo(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    ZoneSurrQueryVO oZoneSurrQueryVO = (ZoneSurrQueryVO)oQueryVO;
    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oZoneSurrQueryVO.getTxtEmpNo()));      
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oZoneSurrQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.proc_getZoneSurrHeaderCount(?,?,?,?,?)",true,true);

    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;
  }

  public ArrayList getZoneSurrHeader(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    ZoneSurrQueryVO oZoneSurrQueryVO = (ZoneSurrQueryVO)oQueryVO;
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oZoneSurrQueryVO.getTxtEmpNo()));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oZoneSurrQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.proc_getZoneSurrHeader(?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    ZoneSurrHeaderBean oHeaderBeanObject;
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
        oHeaderBeanObject = new ZoneSurrHeaderBean();
        oHeaderBeanObject.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oHeaderBeanObject.setTxtEmpName(oRow.get("EMP_NAME").getString());
        oHeaderBeanObject.setTxtStaffCode(oRow.get("staff_code").getString());
        oHeaderBeanObject.setTxtCPFCode(oRow.get("CPF_CODE").getString());
        oHeaderBeanObject.setTxtRetrDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
        oHeaderBeanObject.setTxtUnitCode(oRow.get("pres_location_code").getString());
        oHeaderBeanObject.setTxtUnitDesc(oRow.get("loc_desc").getString());
        oHeaderBeanObject.setTxtCurrZone(oRow.get("parent_zone").getString());
        oHeaderBeanObject.setTxtCurrZoneDesc(oRow.get("parent_zone_desc").getString());
        oHeaderBeanObject.setTxtNewZone(oRow.get("REQUESTED_ZONE").getString());
        oHeaderBeanObject.setTxtSurrRsn(oRow.get("REASON").getString());
        oHeaderBeanObject.setTxtAppvSts(oRow.get("APPR_STATUS").getString());
        oHeaderList.add(oHeaderBeanObject);
    }           
    return oHeaderList;
  }

  public ZoneSurrComboVO getZoneSurrCombo()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
            
    ZoneSurrComboVO oZoneSurrComboVO = new ZoneSurrComboVO();  
    
    ArrayList oCategList = new ArrayList();
    oCategList = getZoneSurrComboRecords("APPS.FCI_PKG_CR_161.PROC_getZoneList(?,?)","loc_id","loc_sdesc");
    oZoneSurrComboVO.setZoneList(oCategList);                
    return oZoneSurrComboVO;
  }
  
  private ArrayList getZoneSurrComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList();
    ArrayList oOutArray;
    //EmpFinanceComboVO oEmpFin=null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    QueryRow oRow = null;    
    int count = 0;
    
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,sProc);
    
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
        
    count = 0;
    oIt = oList.iterator();
    ArrayList oValueList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oValueList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();        
        String fieldId = ((oRow.get(sField_id).getString()));
        String fieldDesc= ((oRow.get(sField_desc).getString()));
        ComboVO oComboVO = new ComboVO(fieldDesc,fieldId);
        oValueList.add(oComboVO);    
    }
    return oValueList;
  }     

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      
  }

  public LovVO getZoneSurrLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames = new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("Cpf Code");
    arylstHeaderNames.add("Retd Date");
    arylstHeaderNames.add("Staff code");
    arylstHeaderNames.add("POP");
    arylstHeaderNames.add("LOCDESC");
    arylstHeaderNames.add("ZONE");
    arylstHeaderNames.add("ZONE DESC");
    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.PROC_getZoneSurrLOVDataQ(?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("emp_name").getString());
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField4(EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
      oLOVBean.setDetailField5(oRow.get("staff_code").getString());
      oLOVBean.setDetailField6(oRow.get("pres_location_code").getString());
      oLOVBean.setDetailField7(oRow.get("loc_desc").getString());
      oLOVBean.setDetailField8(oRow.get("parent_zone").getString());
      oLOVBean.setDetailField9(oRow.get("parent_zone_desc").getString());
      oList.add(oLOVBean);
    }
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getZoneSurrLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames = new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("Cpf Code");
    arylstHeaderNames.add("Retd Date");
    arylstHeaderNames.add("Staff code");
    arylstHeaderNames.add("POP");
    arylstHeaderNames.add("LOCDESC");
    arylstHeaderNames.add("ZONE");
    arylstHeaderNames.add("ZONE DESC");
    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.PROC_getZoneSurrLOVDataN(?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("emp_name").getString());
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField4(EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
      oLOVBean.setDetailField5(oRow.get("staff_code").getString());
      oLOVBean.setDetailField6(oRow.get("pres_location_code").getString());
      oLOVBean.setDetailField7(oRow.get("loc_desc").getString());
      oLOVBean.setDetailField8(oRow.get("parent_zone").getString());
      oLOVBean.setDetailField9(oRow.get("parent_zone_desc").getString());
      oList.add(oLOVBean);
    }
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    int i=0;
    ZoneSurrHeaderBean oHeaderBean = (ZoneSurrHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output  
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHeaderBean.getTxtCPFCode())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,"Z"));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHeaderBean.getTxtNewZone())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oHeaderBean.getTxtSurrRsn())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.CPF_DIVISION_INSERT(?,?,?,?,?,?,?,?,?)",true,true);
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    if(!(errCode.equals(new Integer(0))))
    {        
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errMsg));
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
    } 
    return (String)oOutObject.getObject(); 
  }

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

}