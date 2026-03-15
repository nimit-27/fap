package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPenalityQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPenalityComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintEmpPenalityBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class EmpPenalityBusinessObject extends BaseBO 
{

  public EmpPenalityBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("DaRatesScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    MaintEmpPenalityBean oEmpPenalityBean = (MaintEmpPenalityBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtPenaltyId())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtEmpNo())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getPenaType())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getInstalmntAmt())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getBalAmt())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getBalInstalmnt())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getFstInstamntAmt())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getRemarks())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpPenalityBean.getNewPenaEffDate())));          
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpPenalityBean.getTxtPenaEffDateTo())));          
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtIncrType())));
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtPayType())));
    oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtCurtBasic())));
    oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtGradePay()))); 
    oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtUserID())));
    oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtSiteID())));
    oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(19,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.Proc_UpdatePenaltyDTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
    Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
    if (errcode.intValue()!=0)
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String((String)(((DBObject)oOutArray.get(0)).getObject())));
      ArrayList oList = new ArrayList();
      oList.add(new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments));
      reportError(oList);
    }
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    int i=0;
    String gradepay=null;
    MaintEmpPenalityBean oEmpPenalityBean = (MaintEmpPenalityBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output       
    if(oEmpPenalityBean.getTxtPayType().equalsIgnoreCase("IDA"))
    {
        gradepay="0.0";    
    }
    else 
    {
        gradepay=oEmpPenalityBean.getNewGradePay();
    }      
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtEmpNo())));   
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getPenaType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getNewDsgn())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getNewBasic())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpPenalityBean.getNewPenaEffDate())));          
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpPenalityBean.getTxtPenaEffDateTo())));          
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtIncrType())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getRemarks())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtCurtBasic())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtDsgn())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getNewPayScaleCode())));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getPayScaleCode())));          
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(gradepay)));
    oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtGradePay())));               
    oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getNewCateg())));
    oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtCateg())));
    oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getInstalmntAmt())));
    oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getFstInstamntAmt())));
    oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getNoOfInstalmnt())));
    oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getRecvdAmt())));        
    oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getRecvYYMM())));                
    oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getHdnEmpLbrFlag())));                
    oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtUserID())));
    oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtSiteID()))); 
    oParameters.add(new DBObject(25,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtEmpNo())));
    oParameters.add(new DBObject(26,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(27,DBObject.OUT,ParameterTypes.INTEGER));     
    
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.Proc_InsertPenaltyDTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);    
    Integer errcode = (Integer)((DBObject)oOutArray.get(2)).getObject();
    if (errcode.intValue()!=0)
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String((String)(((DBObject)oOutArray.get(1)).getObject())));
      ArrayList oList = new ArrayList();
      oList.add(new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments));
      reportError(oList);
    }
    return errcode.toString();
  }

  public RecordMetaInfo getPenalityHeaderMetaInfo(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray = new ArrayList();
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    if (screenName.equals("MaintEmpPenalityScreen")) 
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo()))); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));        
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetEmpPenalityDetailCount(?,?,?,?,?,?)");
    }
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getPenalityHeader(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oHeaderList = null;  
    ArrayList oList;
    int count = 0;

    if(oEmpPenalityQueryVO == null)
    {
      oEmpPenalityQueryVO = new EmpPenalityQueryVO();
    }

    ArrayList oOutArray = new ArrayList();
    
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    
    if (screenName.equals("MaintEmpPenalityScreen")) 
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetEmpPenaltyDetail(?,?,?,?,?,?,?)");
    }
   
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpPenalityBean oEmpPenalityBean;
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
        oEmpPenalityBean = new MaintEmpPenalityBean();

        oEmpPenalityBean.setTxtPenaltyId(oRow.get("penalty_id").getString());
        oEmpPenalityBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oEmpPenalityBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpPenalityBean.setTxtDsgn(oRow.get("dsgn_id").getString());        
        oEmpPenalityBean.setTxtDsgnDesc(oRow.get("dsgn_desc").getString());        
        oEmpPenalityBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpPenalityBean.setTxtEmpType(oRow.get("emp_type_desc").getString());                
        oEmpPenalityBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("pay_scale_code").getString());         
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString()); 
        oEmpPenalityBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());  
        oEmpPenalityBean.setTxtCurtBasic(oRow.get("BASIC").getString());               
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("grade_pay").getString()); 
        oEmpPenalityBean.setNewDsgn(oRow.get("new_designation").getString());  
        oEmpPenalityBean.setNewDsgnDesc(oRow.get("NEW_DSGN_DESC").getString());  
        oEmpPenalityBean.setNewBasic(oRow.get("new_basic").getString()); 
        oEmpPenalityBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));        
        oEmpPenalityBean.setRemarks(oRow.get("remarks").getString());                
        oEmpPenalityBean.setTxtGradePay(oRow.get("new_grade_pay").getString()); 
        oEmpPenalityBean.setTxtPayScaleType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setInstalmntAmt(oRow.get("INST_AMT").getString());
        oEmpPenalityBean.setFstInstamntAmt(oRow.get("FIRST_INST_AMT").getString());
        oEmpPenalityBean.setNoOfInstalmnt(oRow.get("NO_OF_INST").getString());
        oEmpPenalityBean.setRecvdAmt(oRow.get("TOTAL_AMT").getString());
        oEmpPenalityBean.setBalAmt(oRow.get("BAL_AMOUNT").getString());
        oEmpPenalityBean.setRecvYYMM(oRow.get("VALID_FROM_YYMM").getString());
        oEmpPenalityBean.setPenaType(oRow.get("PENALTY_TYPE").getString());
        oEmpPenalityBean.setTxtPayType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setPayScaleCode(oRow.get("pay_scale_code").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("loc_desc").getString());
        oEmpPenalityBean.setNewPenaEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PENALTY_EFF_DATE").getDate()));         
        oEmpPenalityBean.setNewPayScaleCode(oRow.get("new_pay_scale_code").getString());
        oEmpPenalityBean.setTxtWaiveAmt(oRow.get("paid_amt").getString());
        oEmpPenalityBean.setTxtWaiveFlg(oRow.get("penalty_flag").getString());
        oEmpPenalityBean.setTxtPenaEffDateTo(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PENALTY_END_DATE").getDate()));         
        oEmpPenalityBean.setTxtIncrType(oRow.get("INCR_TYPE").getString());
        oEmpPenalityBean.setBalInstalmnt(oRow.get("bal_instalmnt").getString());
        oEmpPenalityBean.setTxtIncrReinstFlg(oRow.get("incr_reinst_flag").getString());
        oEmpPenalityBean.setTxtWaiveAmtRmn(oRow.get("REMN_AMT").getString());
        
        oHeaderList.add(oEmpPenalityBean);
      }  
      
    return oHeaderList;
    
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("DaRatesScreen"))
    {
      saveDARates(sHeaderPrimaryKey,oDetailBeanArray);
    }    
  }  
 /*
  public LovVO getPenalityEmpTypeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee Type");    
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
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PopupEmpTypeData(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("emptype_desc").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
*/
  public LovVO getQueryEmpPenalityLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");    
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Pay Scale Type");        
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Grade Pay");
	arylstHeaderNames.add("Designation Id");
    arylstHeaderNames.add("DOJ Present Place");
    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetEmpPenaltyLOV(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());         
        oLOVBean.setDetailField10(oRow.get("BASIC").getString());
        oLOVBean.setDetailField11(oRow.get("pay_scale_code").getString()); 
        oLOVBean.setDetailField12(oRow.get("PAY_SCALE_TYPE").getString());
        oLOVBean.setDetailField13(oRow.get("grade_pay").getString());
        oLOVBean.setDetailField14(oRow.get("designation_id").getString()); 
        oLOVBean.setDetailField15(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
              
        oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpPenalityLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");    
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");      
    arylstHeaderNames.add("Basic");       
    arylstHeaderNames.add("Pay Scale Type");        
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Grade Pay");
	arylstHeaderNames.add("Designation Id");
    arylstHeaderNames.add("DOJ Present Place");
    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetEmpNewPenaltyLOV(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());       
        oLOVBean.setDetailField10(oRow.get("BASIC").getString());
		oLOVBean.setDetailField11(oRow.get("pay_scale_code").getString()); 
        oLOVBean.setDetailField12(oRow.get("PAY_SCALE_TYPE").getString());
		oLOVBean.setDetailField13(oRow.get("grade_pay").getString());
        oLOVBean.setDetailField14(oRow.get("designation_id").getString()); 
        oLOVBean.setDetailField15(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        
              
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getPenaltyDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code/Pay Band");
    arylstHeaderNames.add("Grade Pay");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("payType"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPromoType"))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtCategory"))));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_getPenaltyDsgnLOVData(?,?,?,?,?)");
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
        oLOVBean.setDetailField1(oRow.get("dsgn_id").getString());   
        oLOVBean.setDetailField2(oRow.get("dsgn_desc").getString());
        oLOVBean.setDetailField3(oRow.get("ctgry").getString());
        oLOVBean.setDetailField4(oRow.get("ctgry_desc").getString());        
        oLOVBean.setDetailField5(oRow.get("pay_scale_code").getString());
        oLOVBean.setDetailField6(oRow.get("grade_pay").getString());
        //oLOVBean.setDetailField7(oRow.get("end_basic").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  
  private void saveDARates(String sPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bHeaderDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,sScreenMode);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oList = new ArrayList();
    
//    checkFirst(oBaseHeaderBean,oList);
      oList = new ArrayList();
      MaintEmpPenalityBean oEmpPenalityBean = (MaintEmpPenalityBean)oBaseHeaderBean;
      checkMaxPayYear(oEmpPenalityBean.getTxtSiteID(),oEmpPenalityBean.getHdnEmpLbrFlag());
      reportError(oList);      
      if(sScreenName.equals(EnrgiseConstants.NEW_MODE) && oEmpPenalityBean.getPenaType().equalsIgnoreCase("PENALTY$DEMO") )
      {
          //checkEmpNo(oBaseHeaderBean,oList); 
          checkPenaltyImposed(oBaseHeaderBean,oList);
          checkEmpCurBasicLimit(oBaseHeaderBean,oList);
      }
      if(sScreenName.equals(EnrgiseConstants.NEW_MODE) && oEmpPenalityBean.getPenaType().equalsIgnoreCase("PENALTY$STOPINCR") )
      { 
          checkPenaltyImposed(oBaseHeaderBean,oList);
      }
//  checkEmpPFLimit(oBaseHeaderBean,oList);                    
    reportError(oList);        
  }  
  
  private void checkEmpCurBasicLimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;  
    String gradepay=null;
    MaintEmpPenalityBean oEmpPenalityBean = (MaintEmpPenalityBean)oBaseHeaderBean;
    
    String empNo = oEmpPenalityBean.getHeaderPrimaryKey();    
    oParameters = new ArrayList();
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    if(oEmpPenalityBean.getTxtPayType().equalsIgnoreCase("IDA")){
    gradepay="0.0";    
    }
    else {
    gradepay=oEmpPenalityBean.getNewGradePay();
    
    }
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtPayType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getNewPayScaleCode())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getNewBasic()))); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(gradepay)));     
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));    
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_ValidateCurBasic_6PC(?,?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
    }       
  }


  public LovVO getEmpPenalityDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code/Pay Band");
    arylstHeaderNames.add("Grade Pay");
    //arylstHeaderNames.add("Start Basic"); 
    //arylstHeaderNames.add("End Basic");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);   
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.HIDDEN);
    //arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPromoType"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtCategory"))));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPenalityDsgnLov(?,?,?,?)"); // commented by sonia on 08-04-2011
	 oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPenalityDsgnIDALov(?,?,?,?)"); // added by sonia on 08-04-2011	
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
        oLOVBean.setDetailField1(oRow.get("dsgn_id").getString());   
        oLOVBean.setDetailField2(oRow.get("dsgn_desc").getString());
        oLOVBean.setDetailField3(oRow.get("ctgry").getString());
        oLOVBean.setDetailField4(oRow.get("ctgry_desc").getString());        
        oLOVBean.setDetailField5(oRow.get("pay_scale_code").getString());
        oLOVBean.setDetailField6(oRow.get("grade_pay").getString());
        //oLOVBean.setDetailField7(oRow.get("end_basic").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  //////added by sonia//////////
  public LovVO getCDAEmpPenalityDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code/Pay Band");
	  arylstHeaderNames.add("Grade Pay");
    //arylstHeaderNames.add("Pay Band Desc");
	
    //arylstHeaderNames.add("Start Basic"); 
    //arylstHeaderNames.add("End Basic");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);   
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPromoType"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtCategory"))));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPenalityDsgnLov(?,?,?,?)");
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
        oLOVBean.setDetailField1(oRow.get("dsgn_id").getString());   
        oLOVBean.setDetailField2(oRow.get("dsgn_desc").getString());
        oLOVBean.setDetailField3(oRow.get("ctgry").getString());
        oLOVBean.setDetailField4(oRow.get("ctgry_desc").getString());        
        oLOVBean.setDetailField5(oRow.get("pay_band").getString());
        oLOVBean.setDetailField6(oRow.get("grade_pay").getString());
        //oLOVBean.setDetailField7(oRow.get("pay_scale_range").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  ///////////End///////////
  
  public LovVO getPromPayScaleCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Pay Scale Desc");   
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDsgnPayScaleCodelov(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_scale_code").getString()); 
       oLOVBean.setDetailField2(oRow.get("PAY_SCALE_DESC").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
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

  public EmpPenalityComboVO getEmpPenalityComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oConvAllowCity = null;    
    EmpPenalityComboVO oEmpPenalityComboVO = new EmpPenalityComboVO();
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
        
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetPenalityType(?,?)");
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    count = 0;
    oIt = oList.iterator();
    ArrayList oEmpPenalityList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
          oEmpPenalityList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String sValue = ((oRow.get("gbl_code").getString()));
        String sLabel= ((oRow.get("code_desc").getString()));
        ComboVO oComboVO = new ComboVO(sLabel,sValue);
        oEmpPenalityList.add(oComboVO);
    }         
    oEmpPenalityComboVO.setValuePenaTypeArrayList(oEmpPenalityList);   
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetPenalityIncrType(?,?)");
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    count = 0;
    oIt = oList.iterator();
    ArrayList oEmpIncrList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
          oEmpIncrList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        
        String sValue = ((oRow.get("gbl_code").getString()));
        String sLabel= ((oRow.get("code_desc").getString()));
        ComboVO oComboVO = new ComboVO(sLabel,sValue);
        oEmpIncrList.add(oComboVO);
    }         
    oEmpPenalityComboVO.setIncrTypeArraylist(oEmpIncrList);      
    return oEmpPenalityComboVO;
  }
  public String penaltyWaiver(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    checkMaxPayYear(""+(oEmpPenalityQueryVO.getLoginLocCode()),oEmpPenalityQueryVO.getHdnEmpLbrFlag());
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtPenaltyId())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtWaiveAmtPrt())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtWaiveAmtRmn())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpPenalityQueryVO.getTxtWaiveDt())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getUserId())));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_payroll_waiveoff(?,?,?,?,?,?,?,?,?,?)",true,true);
    String err_code = ((Integer)((DBObject)oOutArray.get(1)).getObject()).toString();
    String error_msg =  (String)((DBObject)oOutArray.get(0)).getObject();
    if(!err_code.equals("0"))
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      ArrayList oList = new ArrayList();
      oList.add(new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments));
      reportError(oList);
    }
    return err_code;
  }
  public String incrementStop(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    checkMaxPayYear(""+(oEmpPenalityQueryVO.getLoginLocCode()),oEmpPenalityQueryVO.getHdnEmpLbrFlag());
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getPenaType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getNewPenaEffDate())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtPenaEffDateTo())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getRemarks())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getUserId())));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_stop_increment(?,?,?,?,?,?,?,?,?,?)");
    String err = ((Integer)((DBObject)oOutArray.get(1)).getObject()).toString();
    return err;
  }
  public String incrementReinstate(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    checkMaxPayYear(""+(oEmpPenalityQueryVO.getLoginLocCode()),oEmpPenalityQueryVO.getHdnEmpLbrFlag());
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtPenaltyId())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getIncrWaveFrm())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getIncrWaveTo())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtIncrType())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getUserId())));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_increment_reinstate(?,?,?,?,?,?,?,?,?,?)",true,true);
    Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
    if (errcode.intValue()!=0)
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String((String)(((DBObject)oOutArray.get(0)).getObject())));
      ArrayList oList = new ArrayList();
      oList.add(new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments));
      reportError(oList);
    }
    return errcode.toString();
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
    oIt = null;
    oBean = null;
    oRetList = null;
    oOutArray = null;
    oParameters = null;
    return sRevYear;
  }
  
  public RecordMetaInfo getHdrRcdWaveOffMetaImpl(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray = new ArrayList();
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();

    if (screenName.equals("MaintEmpPenalityScreen")) 
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo()))); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));        
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetWaveOffHdrCount(?,?,?,?,?,?)");
    }
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getHdrRcdWaveOffImpl(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oHeaderList = null;  
    ArrayList oList;
    int count = 0;

    if(oEmpPenalityQueryVO == null)
    {
      oEmpPenalityQueryVO = new EmpPenalityQueryVO();
    }

    ArrayList oOutArray = new ArrayList();
    
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    
    if (screenName.equals("MaintEmpPenalityScreen")) 
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetWaveOffHdrDetail(?,?,?,?,?,?,?)");
    }
   
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpPenalityBean oEmpPenalityBean;
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
        oEmpPenalityBean = new MaintEmpPenalityBean();

        oEmpPenalityBean.setTxtPenaltyId(oRow.get("penalty_id").getString());
        oEmpPenalityBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oEmpPenalityBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpPenalityBean.setTxtDsgn(oRow.get("dsgn_id").getString());        
        oEmpPenalityBean.setTxtDsgnDesc(oRow.get("dsgn_desc").getString());        
        oEmpPenalityBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpPenalityBean.setTxtEmpType(oRow.get("emp_type_desc").getString());                
        oEmpPenalityBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("pay_scale_code").getString());         
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString()); 
        oEmpPenalityBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());  
        oEmpPenalityBean.setTxtCurtBasic(oRow.get("BASIC").getString());               
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("grade_pay").getString()); 
        oEmpPenalityBean.setNewDsgn(oRow.get("new_designation").getString());  
        oEmpPenalityBean.setNewDsgnDesc(oRow.get("NEW_DSGN_DESC").getString());  
        oEmpPenalityBean.setNewBasic(oRow.get("new_basic").getString()); 
        oEmpPenalityBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));        
        oEmpPenalityBean.setRemarks(oRow.get("remarks").getString());                
        oEmpPenalityBean.setTxtGradePay(oRow.get("new_grade_pay").getString()); 
        oEmpPenalityBean.setTxtPayScaleType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setInstalmntAmt(oRow.get("INST_AMT").getString());
        oEmpPenalityBean.setFstInstamntAmt(oRow.get("FIRST_INST_AMT").getString());
        oEmpPenalityBean.setNoOfInstalmnt(oRow.get("NO_OF_INST").getString());
        oEmpPenalityBean.setRecvdAmt(oRow.get("TOTAL_AMT").getString());
        oEmpPenalityBean.setBalAmt(oRow.get("BAL_AMOUNT").getString());
        oEmpPenalityBean.setRecvYYMM(oRow.get("VALID_FROM_YYMM").getString());
        oEmpPenalityBean.setPenaType(oRow.get("PENALTY_TYPE").getString());
        oEmpPenalityBean.setTxtPayType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setPayScaleCode(oRow.get("pay_scale_code").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("loc_desc").getString());
        oEmpPenalityBean.setNewPenaEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PENALTY_EFF_DATE").getDate()));         
        oEmpPenalityBean.setNewPayScaleCode(oRow.get("new_pay_scale_code").getString());
        oEmpPenalityBean.setTxtWaiveAmt(oRow.get("paid_amt").getString());
        oEmpPenalityBean.setTxtWaiveFlg(oRow.get("penalty_flag").getString());
        oEmpPenalityBean.setTxtPenaEffDateTo(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PENALTY_END_DATE").getDate()));         
        oEmpPenalityBean.setTxtIncrType(oRow.get("INCR_TYPE").getString());
        oEmpPenalityBean.setBalInstalmnt(oRow.get("bal_instalmnt").getString());
        oEmpPenalityBean.setTxtIncrReinstFlg(oRow.get("incr_reinst_flag").getString());
        oEmpPenalityBean.setTxtWaiveAmtPrt(oRow.get("part_wave_amt").getString());
        oEmpPenalityBean.setTxtWaiveAmtRmn(oRow.get("REMN_AMT").getString());
        oEmpPenalityBean.setTxtWaiveDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("wave_dt").getDate()));
        oHeaderList.add(oEmpPenalityBean);
      }  
    return oHeaderList;
  }

  public RecordMetaInfo getHdrRcdIncrWaveMetaImpl(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray = new ArrayList();
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetIncrWaveHdrCount(?,?,?,?,?,?)");
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }

  public ArrayList getHdrRcdIncrWaveImpl(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oHeaderList = null;  
    ArrayList oList;
    int count = 0;
    if(oEmpPenalityQueryVO == null)
    {
      oEmpPenalityQueryVO = new EmpPenalityQueryVO();
    }
    ArrayList oOutArray = new ArrayList();
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag()))); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetIncrWaveHdrDetail(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpPenalityBean oEmpPenalityBean;
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
        oEmpPenalityBean = new MaintEmpPenalityBean();

        oEmpPenalityBean.setTxtPenaltyId(oRow.get("penalty_id").getString());
        oEmpPenalityBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oEmpPenalityBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpPenalityBean.setTxtDsgn(oRow.get("dsgn_id").getString());        
        oEmpPenalityBean.setTxtDsgnDesc(oRow.get("dsgn_desc").getString());        
        oEmpPenalityBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpPenalityBean.setTxtEmpType(oRow.get("emp_type_desc").getString());                
        oEmpPenalityBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("pay_scale_code").getString());         
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString()); 
        oEmpPenalityBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());  
        oEmpPenalityBean.setTxtCurtBasic(oRow.get("BASIC").getString());               
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("grade_pay").getString()); 
        oEmpPenalityBean.setNewDsgn(oRow.get("new_designation").getString());  
        oEmpPenalityBean.setNewDsgnDesc(oRow.get("NEW_DSGN_DESC").getString());  
        oEmpPenalityBean.setNewBasic(oRow.get("new_basic").getString()); 
        oEmpPenalityBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));        
        oEmpPenalityBean.setRemarks(oRow.get("remarks").getString());                
        oEmpPenalityBean.setTxtGradePay(oRow.get("new_grade_pay").getString()); 
        oEmpPenalityBean.setTxtPayScaleType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setInstalmntAmt(oRow.get("INST_AMT").getString());
        oEmpPenalityBean.setFstInstamntAmt(oRow.get("FIRST_INST_AMT").getString());
        oEmpPenalityBean.setNoOfInstalmnt(oRow.get("NO_OF_INST").getString());
        oEmpPenalityBean.setRecvdAmt(oRow.get("TOTAL_AMT").getString());
        oEmpPenalityBean.setBalAmt(oRow.get("BAL_AMOUNT").getString());
        oEmpPenalityBean.setRecvYYMM(oRow.get("VALID_FROM_YYMM").getString());
        oEmpPenalityBean.setPenaType(oRow.get("PENALTY_TYPE").getString());
        oEmpPenalityBean.setTxtPayType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setPayScaleCode(oRow.get("pay_scale_code").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("loc_desc").getString());
        oEmpPenalityBean.setNewPenaEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PENALTY_EFF_DATE").getDate()));         
        oEmpPenalityBean.setNewPayScaleCode(oRow.get("new_pay_scale_code").getString());
        oEmpPenalityBean.setTxtWaiveAmt(oRow.get("paid_amt").getString());
        oEmpPenalityBean.setTxtWaiveFlg(oRow.get("penalty_flag").getString());
        oEmpPenalityBean.setTxtPenaEffDateTo(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PENALTY_END_DATE").getDate()));         
        oEmpPenalityBean.setTxtIncrType(oRow.get("INCR_TYPE").getString());
        oEmpPenalityBean.setTxtIncrReinstFlg(oRow.get("incr_reinst_flag").getString());
        oEmpPenalityBean.setIncrWaveFrm(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("wave_dt_frm").getDate()));
        oEmpPenalityBean.setIncrWaveTo(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("wave_dt_to").getDate()));
        oHeaderList.add(oEmpPenalityBean);
      }  
    return oHeaderList;
  }
  
  public LovVO getQueryEmpDismissLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");    
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Pay Scale Type");        
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Grade Pay");
	arylstHeaderNames.add("Designation Id");
    arylstHeaderNames.add("DOJ Present Place");
    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetEmpDismissReinstateLOV(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());         
        oLOVBean.setDetailField10(oRow.get("BASIC").getString());
        oLOVBean.setDetailField11(oRow.get("pay_scale_code").getString()); 
        oLOVBean.setDetailField12(oRow.get("PAY_SCALE_TYPE").getString());
        oLOVBean.setDetailField13(oRow.get("grade_pay").getString());
        oLOVBean.setDetailField14(oRow.get("designation_id").getString()); 
        oLOVBean.setDetailField15(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
              
        oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  public LovVO getQueryEmpDismissLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");    
    arylstHeaderNames.add("CategoryDesc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Pay Scale Type");        
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Grade Pay");
	arylstHeaderNames.add("Designation Id");
    arylstHeaderNames.add("DOJ Present Place");
    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetEmpDismissReinstLOVQ(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_ID").getString());           
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField7(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField8(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());         
        oLOVBean.setDetailField10(oRow.get("BASIC").getString());
        oLOVBean.setDetailField11(oRow.get("pay_scale_code").getString()); 
        oLOVBean.setDetailField12(oRow.get("PAY_SCALE_TYPE").getString());
        oLOVBean.setDetailField13(oRow.get("grade_pay").getString());
        oLOVBean.setDetailField14(oRow.get("designation_id").getString()); 
        oLOVBean.setDetailField15(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
              
        oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  public String reinstateDismissed(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    checkMaxPayYear(""+(oEmpPenalityQueryVO.getLoginLocCode()),oEmpPenalityQueryVO.getHdnEmpLbrFlag());
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtReinstateDt())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtReinstRsn())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getSiteId())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpPenalityQueryVO.getUserId())));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_dismissal_reinstate(?,?,?,?,?,?,?,?)");
    Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
    if (errcode.intValue()!=0)
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String((String)(((DBObject)oOutArray.get(0)).getObject())));
      ArrayList oList = new ArrayList();
      oList.add(new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments));
      reportError(oList);
    }
    return errcode.toString();
  }
  public RecordMetaInfo getHdrRcdDissReinstateMetaImpl(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray = new ArrayList();
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetDissReinstateHdrCount(?,?,?,?,?,?)");
      
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }

  public ArrayList getHdrRcdDissReinstateImpl(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oHeaderList = null;  
    ArrayList oList;
    int count = 0;
    if(oEmpPenalityQueryVO == null)
    {
      oEmpPenalityQueryVO = new EmpPenalityQueryVO();
    }
    ArrayList oOutArray = new ArrayList();
    String screenName=oEmpPenalityQueryVO.getScreenName();
    String locCode = oEmpPenalityQueryVO.getLoginLocCode()+"";
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityQueryVO.getHdnEmpLbrFlag()))); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_GetDissReinstateHdrDetail(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpPenalityBean oEmpPenalityBean;
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
        oEmpPenalityBean = new MaintEmpPenalityBean();

        oEmpPenalityBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oEmpPenalityBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpPenalityBean.setTxtDsgn(oRow.get("dsgn_id").getString());        
        oEmpPenalityBean.setTxtDsgnDesc(oRow.get("dsgn_desc").getString());        
        oEmpPenalityBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpPenalityBean.setTxtEmpType(oRow.get("emp_type_desc").getString());                
        oEmpPenalityBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("pay_scale_code").getString());         
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString()); 
        oEmpPenalityBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());  
        oEmpPenalityBean.setTxtCurtBasic(oRow.get("BASIC").getString());               
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("grade_pay").getString()); 
        /* oEmpPenalityBean.setNewDsgn(oRow.get("new_designation").getString());  
        oEmpPenalityBean.setNewDsgnDesc(oRow.get("NEW_DSGN_DESC").getString());  
       oEmpPenalityBean.setNewBasic(oRow.get("new_basic").getString()); */
        oEmpPenalityBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));        
       /* oEmpPenalityBean.setRemarks(oRow.get("remarks").getString());                
        oEmpPenalityBean.setTxtGradePay(oRow.get("new_grade_pay").getString()); 
        oEmpPenalityBean.setTxtPayScaleType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setInstalmntAmt(oRow.get("INST_AMT").getString());
        oEmpPenalityBean.setFstInstamntAmt(oRow.get("FIRST_INST_AMT").getString());
        oEmpPenalityBean.setNoOfInstalmnt(oRow.get("NO_OF_INST").getString());
        oEmpPenalityBean.setRecvdAmt(oRow.get("TOTAL_AMT").getString());
        oEmpPenalityBean.setBalAmt(oRow.get("BAL_AMOUNT").getString());
        oEmpPenalityBean.setRecvYYMM(oRow.get("VALID_FROM_YYMM").getString());
        oEmpPenalityBean.setPenaType(oRow.get("PENALTY_TYPE").getString());*/
        oEmpPenalityBean.setTxtPayType(oRow.get("pay_scale_type").getString());
        oEmpPenalityBean.setPayScaleCode(oRow.get("pay_scale_code").getString());
        oEmpPenalityBean.setTxtPresentPOP(oRow.get("loc_desc").getString());
        oEmpPenalityBean.setTxtReinstateDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("reinstate_eff_dt").getDate()));         
        oEmpPenalityBean.setTxtReinstRsn(oRow.get("reinstate_reason").getString());
        oHeaderList.add(oEmpPenalityBean);
      }  
    return oHeaderList;
  }
  
    private void checkPenaltyImposed(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList();
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray;
      MaintEmpPenalityBean oEmpPenalityBean = (MaintEmpPenalityBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPenalityBean.getTxtEmpNo())));    
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));    
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_CheckIncrementStatus(?,?,?)",true,true);   
      Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if(errcode.intValue()!=0)
      {    
        throw new EnrgiseApplicationException("payroll.EmpInfo.IncrementStatusCheck");
      }       
    }
    
}