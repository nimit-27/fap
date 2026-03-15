package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OTAPymntQueryVO;
import FCIPAY.Payroll.UTILITY.OTAPymntHeaderBean;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.UTILITY.OTAPymntBean;

public class OTAPymntBusinessObject extends BaseBO 
{
  public OTAPymntBusinessObject()
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    String netpay; 
    String netminusITstr;
    int grosspay =0;
    int onethird =0;
    int netfinal =0;
    int netAmnt =0;
    int ITDed =0;  
    
    OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output 
    String ceilAmt="";
    grosspay = Integer.parseInt(oOTAPymntHeaderBean.getTxtGrossAmt());
    onethird = Integer.parseInt(oOTAPymntHeaderBean.getTxtNetAmt());
    if(oOTAPymntHeaderBean.getTxtDedIT().equals(""))
    {
      ITDed =0;
    }
    else
    {
      ITDed = Integer.parseInt(oOTAPymntHeaderBean.getTxtDedIT());
    }  
    if(oOTAPymntHeaderBean.getCeilFlag().toString().equals("Y"))
    {
      netfinal = (grosspay - onethird);
      if(grosspay > onethird)    
        netAmnt = onethird;    
      else
        netAmnt = grosspay;
    }
    else
    {
      netAmnt = grosspay;      
    }
    //netminusIT = (onethird - ITDed);
    netminusITstr = String.valueOf(netAmnt);    
    
    if(oOTAPymntHeaderBean.getCeilFlag().toString().equals("Y"))
    {
      ceilAmt="Y";
      netpay = String.valueOf(netfinal);
    } 
    else
    {
      ceilAmt="N";
      netpay="";
    }      
      System.out.println("OTA PAYMENT PARAMS");
      System.out.println(oOTAPymntHeaderBean.toString());
      
      

      oParameters = new ArrayList();    
      /* Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtGrossAmt())));   
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtDedIT())));    
    
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(netminusITstr)));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtDedAmt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(netpay)));
            
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtRmrks())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(ceilAmt)));
      
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));
      
      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_UpdatePayOTA(?,?,?,?,?,?,?,?,?,?,?,?)",false,false); 
      
      DBObject oErrObject = (DBObject)oOutArray.get(0);
      String errormessage =(String)((DBObject)oOutArray.get(0)).getObject();
      System.out.println(errormessage);

      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      System.out.println(errCode);
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
   // int netpay =0;
    String netpay;
    String othr_ded =""; 
    String netminusITstr;
    int grosspay =0;
    int onethird =0;
    int netfinal =0;
    int netminusIT =0;
    int ITDed =0;
    OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
    
    ArrayList oOutArray; //Output 
    String ceilAmt="";
    //grosspay = oOTAPymntHeaderBean.getTxtGrossAmt().equals((new Integer(0)));
    grosspay = Integer.parseInt(oOTAPymntHeaderBean.getTxtGrossAmt());
    onethird = Integer.parseInt(oOTAPymntHeaderBean.getTxtNetAmt());
    if(oOTAPymntHeaderBean.getTxtDedIT().equals(""))
    {
      ITDed =0;
    }
    else
    {
      ITDed = Integer.parseInt(oOTAPymntHeaderBean.getTxtDedIT());
    }  
    
    if(oOTAPymntHeaderBean.getCeilFlag().toString().equals("Y"))
    {
      ceilAmt="Y";
      if(grosspay > onethird)    
      {        
        othr_ded = String.valueOf(grosspay - onethird); 
        netminusIT = onethird - ITDed;
      }  
      else
      {        
        othr_ded = String.valueOf(0);
        netminusIT = grosspay - ITDed;
      }  
    }else
    {
      ceilAmt="N";
      netminusIT = grosspay - ITDed;
    }
    
    netminusITstr = String.valueOf(netminusIT);
    
      oParameters = new ArrayList();    
      /* Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtYYMM())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtGrossAmt())));   
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtDedIT())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(othr_ded)));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(netminusITstr)));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtPayModeType())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtRmrks())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(ceilAmt)));
      
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_InsertPayOTA(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");        
   
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      //DBObject oErrObject = (DBObject)oOutArray.get(1);
      //System.out.println("Error while inserting OTA Payments ::"+oErrObject.getObject());
      /*DBObject oErr = (DBObject)oOutArray.get(oOutArray.size() - 1);
      if( ! oErr.getObject().equals(new Integer(0)))
      {
          DBObject oErrObject = (DBObject)oOutArray.get(1);
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String((String)oErrObject.getObject()));
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
      */
      return (String)oOutObject.getObject();       
  }


  public RecordMetaInfo getOTAPymntHeaderMetaInfo(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oOTAPymntQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtEmpNo())).toUpperCase()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtCpfCode()))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtDsgnDesc()))));
   // oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtCateg()))));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(""))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getHdnEmpLbrFlag()))));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpOTAHdrCnt(?,?,?,?,?,?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }

  public LovVO getEmpOTAPymntLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category");
    arylstHeaderNames.add("Employee Type");
    arylstHeaderNames.add("Cpf Code");
    arylstHeaderNames.add("Present Place of Posting");
    arylstHeaderNames.add("Date of Joining Location");
    arylstHeaderNames.add("Employee Status");
    arylstHeaderNames.add("Current Basic");
    arylstHeaderNames.add("Designation Id");
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag")).trim()));      
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpOTAN(?,?,?,?,?,?)");
    
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
      oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());
      oLOVBean.setDetailField4(oRow.get("category").getString());
      oLOVBean.setDetailField5(oRow.get("EMP_TYPE").getString());
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("loc_desc").getString());
      oLOVBean.setDetailField8(oRow.get("site_joining_date").getString());
      oLOVBean.setDetailField9(oRow.get("emp_status").getString());
      oLOVBean.setDetailField10(oRow.get("basic").getString());
      oLOVBean.setDetailField11(oRow.get("designation_id").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpOTAPymntLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
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
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));     
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpOTAQ(?,?,?,?,?,?)");
    
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
      oLOVBean.setDetailField2(oRow.get("empName").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public ArrayList getOTAPymntHeader(OTAPymntQueryVO oOTAPymntQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oOTAPymntQueryVO == null)
    {
      oOTAPymntQueryVO = new OTAPymntQueryVO();
    }
    
    String screenName=oOTAPymntQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oOTAPymntQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtEmpNo())).toUpperCase()));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtCpfCode()))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtDsgnDesc())))); 
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,(new String(""))));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,oOTAPymntQueryVO.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpOTAHdr(?,?,?,?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject()); 

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    OTAPymntHeaderBean oOTAPymntHeaderBean;
    count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    String hrlyWage;
    String sFlag=checkMaxPayYear(oOTAPymntQueryVO);
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oHeaderList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oOTAPymntHeaderBean = new OTAPymntHeaderBean();

        oOTAPymntHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oOTAPymntHeaderBean.setTxtEmpName(oRow.get("empName").getString());    
        oOTAPymntHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());   
        oOTAPymntHeaderBean.setTxtDsgnDesc(oRow.get("designation_id").getString());
        oOTAPymntHeaderBean.setTxtCategDesc(oRow.get("category").getString());
        oOTAPymntHeaderBean.setTxtEmpType(oRow.get("emp_type_det").getString()); 
        oOTAPymntHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());          
        oOTAPymntHeaderBean.setTxtPresentPOPDesc(oRow.get("locdesc").getString());               
        oOTAPymntHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oOTAPymntHeaderBean.setTxtEmpStatus(oRow.get("emp_status_det").getString());
        oOTAPymntHeaderBean.setTxtCurrBas(oRow.get("basic").getString());
        
        oOTAPymntHeaderBean.setHeaderPrimaryKey(oRow.get("emp_ota_id").getString());
        oOTAPymntHeaderBean.setTxtYYMM(oRow.get("ota_yymm").getString());
        oOTAPymntHeaderBean.setTxtPayModeType(oRow.get("pay_mode").getString());
        oOTAPymntHeaderBean.setTxtDedIT(oRow.get("it_ded").getString());
        oOTAPymntHeaderBean.setTxtDedOthr(oRow.get("othr_ded").getString());
        oOTAPymntHeaderBean.setTxtNetAmt(oRow.get("net_amt").getString());
        oOTAPymntHeaderBean.setTxtHdnNetAmt(oRow.get("net_amt").getString());
        oOTAPymntHeaderBean.setTxtRmrks(oRow.get("rmrks").getString());
      /*  String sCeilFlag=oRow.get("ciel_flag").getString();
        if(sCeilFlag!=null && sCeilFlag.equals("Y"))
        {
          oOTAPymntHeaderBean.setCeilFlag(true);
        }else
        {
          oOTAPymntHeaderBean.setCeilFlag(false);
        }
        */
        oOTAPymntHeaderBean.setCeilFlag(oRow.get("ciel_flag").getString());
        oOTAPymntHeaderBean.setTxtGrossAmt(oRow.get("gross_amt").getString());
        oOTAPymntHeaderBean.setTxtDedAmt(oRow.get("TOTAL_OTHER_DEDN_AMT").getString());
        oOTAPymntHeaderBean.setTxtInvId(oRow.get("invoice_num").getString());
        hrlyWage=getEmpHrlyWage(oOTAPymntHeaderBean.getTxtEmpNo(),oOTAPymntHeaderBean.getTxtYYMM(),oOTAPymntQueryVO.getHdnEmpLbrFlag());
        oOTAPymntHeaderBean.setTxtHrlyWage(hrlyWage);
        oOTAPymntHeaderBean.setHdnFlagIT(sFlag); 
        oHeaderList.add(oOTAPymntHeaderBean);
      }    
      
    return oHeaderList;
  }
  
  public String getEmpHrlyWage(String sEmpNo,String sYYYYMM,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sEmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sYYYYMM));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpOTAHrlyRate(?,?,?,?,?)");
    
    DBObject oWageObject = (DBObject)oOutArray.get(0);
    String sWage = (String)(oWageObject.getObject());
    
    return sWage;
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("OTAPymntScreen"))
      saveOTADetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    else
      saveOTADedDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oList=new ArrayList();
      OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
      checkYrEndRemittance(oBaseHeaderBean,oList); //added by swapnendu Dt 21 Mar 2012
      reportError(oList);
      checkMaxPayYear(oOTAPymntHeaderBean.getTxtSiteID(),oOTAPymntHeaderBean.getHdnEmpLbrFlag());
      reportError(oList);
      if(sScreenMode.equals(EnrgiseConstants.NEW_MODE))
      {
        checkDuplicacy(oBaseHeaderBean,oList);
        reportError(oList);
      }
      if(sScreenName.equals("DeptOTAPymntScreen"))
      {
        validateOTAHrs(oBaseHeaderBean,oList);
        reportError(oList);
      }
      checkGrossAmt(oBaseHeaderBean,oList);
      reportError(oList);
  }
  
    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oOTAPymntHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oOTAPymntHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oOTAPymntHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(4, DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_othrPaymnt_YrEndcheck(?,?,?,?,?)",true,true);
        Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
        String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() != 0)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
        }
    }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }

  public RecordMetaInfo getOTAPymntDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpOTADtlCnt(?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }
  
  public ArrayList getOTAPymntDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    
    ArrayList oOutArray; //Output 
    ArrayList oDetailList = null;  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetEmpOTADtl(?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject()); 

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    OTAPymntBean oOTAPymntBean;
    count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oDetailList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oOTAPymntBean = new OTAPymntBean();

       // oOTAPymntBean.(oRow.get("emp_ota_id").getString());
        oOTAPymntBean.setTxtEmolument(oRow.get("ota_amt").getString());
        oOTAPymntBean.setTxtOTARate(oRow.get("ota_rate").getString());
        oOTAPymntBean.setTxtOTAHrs(oRow.get("ota_hrs").getString());
        oOTAPymntBean.setDetailId(oRow.get("emp_ota_dtl_id").getString());
        oOTAPymntBean.setStatus("Q");
        oDetailList.add(oOTAPymntBean);
    }    
    return oDetailList;
  }
  
  private void saveOTADetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    boolean bCancel = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    DBUtilitiesBean oBeanCancel = null;
    OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        OTAPymntBean oOTAPymntBean = (OTAPymntBean)oIt.next();
        if(oOTAPymntBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_over_n_above_sal.proc_InsertPayOTADtl(?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtOTAHrs())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtOTARate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtEmolument())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey))); 
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oOTAPymntBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_over_n_above_sal.proc_UpdatePayOTADtl(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtOTAHrs())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtOTARate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtEmolument())));             
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
       
        }
        else if(oOTAPymntBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_over_n_above_sal.proc_DeletePayOTADtl(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getDetailId())));
      //    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtTypeofCity())));
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
  
  private void saveOTADedDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    boolean bCancel = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    DBUtilitiesBean oBeanCancel = null;
    OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        OTAPymntBean oOTAPymntBean = (OTAPymntBean)oIt.next();
        if(oOTAPymntBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_over_n_above_sal.proc_InsertOtaDedn(?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtPayCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtAmt())));          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oOTAPymntBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_over_n_above_sal.proc_UpdateOtaDedn(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtPayCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getTxtAmt())));             
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
       
        }
        else if(oOTAPymntBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_over_n_above_sal.proc_DeleteOtaDedn(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntBean.getDetailId())));
      //  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtTypeofCity())));
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
  
  public RecordMetaInfo getOTAPymntDedDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_getOtaDednDtlCnt(?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }
  
  public ArrayList getOTAPymntDedDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    
    ArrayList oOutArray; //Output 
    ArrayList oDetailList = null;  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_getOtaDednDtl(?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject()); 

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    OTAPymntBean oOTAPymntBean;
    count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oDetailList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oOTAPymntBean = new OTAPymntBean();

       // oOTAPymntBean.(oRow.get("emp_ota_id").getString());
        oOTAPymntBean.setTxtPayCode(oRow.get("PAY_CODE").getString());
        oOTAPymntBean.setTxtDesc(oRow.get("PAY_CODE_DESC").getString());
        oOTAPymntBean.setTxtAmt(oRow.get("DEDN_AMT").getString());
        oOTAPymntBean.setDetailId(oRow.get("EMP_OTA_DEDN_ID").getString());
        oOTAPymntBean.setStatus("Q");
        oDetailList.add(oOTAPymntBean);
    }    
    return oDetailList;
  }  
  
  private void checkDuplicacy(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oOTAPymntHeaderBean.getTxtYYMM()));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_OTA_YYMM_Check(?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(oOTAPymntHeaderBean.getTxtEmpNo());
        oArguments.add(oOTAPymntHeaderBean.getTxtYYMM());
        oList.add(new EnrgiseApplicationException("Payroll.OTA.dupliCheck",oArguments));
      }
  }
  
  private void checkGrossAmt(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      String ceilAmt="";
      Integer pFlag=new Integer(0);
      OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
    //  if(oOTAPymntHeaderBean.isCeilFlag())
      if(oOTAPymntHeaderBean.getCeilFlag().toString().equals("Y"))
      {
        String grossAmt=oOTAPymntHeaderBean.getTxtGrossAmt();
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oOTAPymntHeaderBean.getTxtYYMM()));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,grossAmt));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oOTAPymntHeaderBean.getHdnTotHrs()));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_OTAGrossChk(?,?,?,?,?,?,?,?)");
        pFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
        ceilAmt = (String)((DBObject)oOutArray.get(1)).getObject();
        if(!pFlag.equals(new Integer(0)))
        {
          if(ceilAmt.equals("0"))
          {
            ArrayList oArguments = new ArrayList();
            oArguments.add(((DBObject)oOutArray.get(2)).getObject());
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
          }
        } 
        else
        {
          oOTAPymntHeaderBean.setTxtNetAmt(ceilAmt);
        }          
      }      
  }

  private void validateOTAHrs(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      OTAPymntHeaderBean oOTAPymntHeaderBean = (OTAPymntHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oOTAPymntHeaderBean.getTxtYYMM()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oOTAPymntHeaderBean.getHdnTotHrs()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_ValidateOTAHrs(?,?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(((DBObject)oOutArray.get(1)).getObject());
        oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
      }
  }
  
  public String sendInv(String otaId,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,otaId));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.Proc_SendOTAInvoice(?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    
    String sRetMsg=errCode.toString()+","+errMsg;
    
    return sRetMsg;
  }
  
  public ArrayList getOTAPymntITDed(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    if(oOTAPymntQueryVO == null)
    {
      oOTAPymntQueryVO = new OTAPymntQueryVO();
    }
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    
    String sFlag=checkMaxPayYear(oOTAPymntQueryVO);    
   
    oParamList.add(sFlag);
    return oParamList;
  }

  private String checkMaxPayYear(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    String sFlag="";
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oOTAPymntQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOTAPymntQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yymm").getString(); 
              String status = oRow.get("status").getString();
              String sMonth=sRevYear.substring(4);
              int stat=Integer.parseInt(status);

              if (sMonth.equals("03") )
              {
                sFlag="Y";
              }
              else
              {
                sFlag="N";
              }
             }
        return sFlag;
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
    if(hdnEmpLbrFlag.equals("E"))
    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    }
    else
    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear_OvrAbv_Lbr(?,?,?,?)");
    }
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
  
  public LovVO getOTAPaymentPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Code");    
    arylstHeaderNames.add("Pay Code Desc");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_over_n_above_sal.proc_GetOTAPaymentPayCodeLOV(?,?,?,?)");
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

   public String  deleteOTAPymnt(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    String msg=null;

    if(oOTAPymntQueryVO == null)
    {
      oOTAPymntQueryVO = new OTAPymntQueryVO();
    }
    
    String screenName=oOTAPymntQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oOTAPymntQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtEmpNo()))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtNetAmt()))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtGrossAmt())))); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oOTAPymntQueryVO.getTxtYYMM()))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,(new String("112"))));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new Long(oOTAPymntQueryVO.getUserId())));    
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_deleteOTAPymnt(?,?,?,?,?,?,?,?,?)");
    
      DBObject oErrObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
      
      if(!errCode.equals(new Integer(0)))
      {
         msg="Failed";
      } 
      
       else if(  errCode.equals(new Integer(0)))
      {
         msg="Success";
      }      
    return msg;
  }
  
}