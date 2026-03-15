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
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrSalRlsComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.EmpTrnsfrHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import java.sql.ResultSet;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspInvDtlsComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrInvDtlsComboVO;


public class EmpTrnsfrBusinessObject extends BaseBO
{
  public EmpTrnsfrBusinessObject()
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
      EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean = (EmpTrnsfrHeaderBean)oBaseHeaderBean;
     
      ArrayList oOutArray; //Output  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtJoiningDt())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtJoiningTime())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpStatus())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));    
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertEmpJoiningDetail(?,?,?,?,?,?,?,?)");   

      //DBObject oOutObject = (DBObject)oOutArray.get(0);
      oParameters=null;
      oOutArray=null;
      oBean = null;
      oEmpFinInfoHeaderBean = null;
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean = (EmpTrnsfrHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTrnsfrReason())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTrnsfrTo())));
      // current location will be passed for trasfer from field.
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));    
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtTrnsfrDt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtRlvngDt())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtRlvngTime())));
      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
      
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));

     
     oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertEmpTrnsfrDetail(?,?,?,?,?,?,?,?,?,?,?,?)",true,true);   
        
        String oErrMsg = (String)((DBObject)oOutArray.get(1)).getObject();
        Integer oErrCode = (Integer)((DBObject)oOutArray.get(2)).getObject();
        if(!oErrCode.equals(new Integer(0))) 
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oErrMsg));
        //    System.out.println("Error!!! while Updating Employee ::"+oErrMsg);
            throw new EnrgiseApplicationException("Pay.Payroll_TRANSERROR",oArguments);
        }
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oParameters=null;
      oOutArray=null;
      oBean = null;
      oEmpFinInfoHeaderBean = null;
      return (String)oOutObject.getObject(); 
  }

  public RecordMetaInfo getEmpTrnsfrHeaderMetaInfo(EmpTrnsfrQueryVO oEmpTrnsfrQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    
    String screenName=oEmpTrnsfrQueryVO.getScreenName();

   // oParameters = new ArrayList();
    
    if(screenName.equals("TransferScreen"))
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getTxtEmpNo())));    
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpTrnsfrDetailCount(?,?,?,?,?,?)");
    }
    else
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getTxtEmpNo())));    
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getHdnActionFlag())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpTrnsfrInDetailCount(?,?,?,?,?,?,?)");
    }

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
	oTimeObject  = null;       
	oTotalRecord = null;
	oOutArray    = null;
	oParameters  = null;
    screenName = null;
    return oRecordMetaInfo;    
  }

  public ArrayList getEmpTrnsfrHeader(EmpTrnsfrQueryVO oEmpTrnsfrQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpTrnsfrQueryVO == null)
    {
      oEmpTrnsfrQueryVO = new EmpTrnsfrQueryVO();
    }
    
    String screenName=oEmpTrnsfrQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    
   // oParameters = new ArrayList();
    
    if(screenName.equals("TransferScreen"))
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpTrnsfrQueryVO.getTxtEmpNo())).toUpperCase())); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpTrnsfrDetail(?,?,?,?,?,?,?)");
    }else
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpTrnsfrQueryVO.getTxtEmpNo())).toUpperCase())); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getHdnActionFlag())));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpTrnsfrInDetail(?,?,?,?,?,?,?,?)");
    }
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean;
    count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oHeaderList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oEmpFinInfoHeaderBean = new EmpTrnsfrHeaderBean();

        oEmpFinInfoHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oEmpFinInfoHeaderBean.setTxtEmpName(oRow.get("EMP_NAME").getString());    
        oEmpFinInfoHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oEmpFinInfoHeaderBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpFinInfoHeaderBean.setTxtEmpType(oRow.get("EMP_TYPE").getString()); 
        oEmpFinInfoHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());          
        oEmpFinInfoHeaderBean.setTxtPresentPOPDesc(oRow.get("LOC_DESC").getString());               
        oEmpFinInfoHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());
        oEmpFinInfoHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_TRNSFR_ID").getString());
        oEmpFinInfoHeaderBean.setTxtTrnsfrTo(oRow.get("TRNSFR_TO").getString());
        oEmpFinInfoHeaderBean.setTxtTrnsfrToDesc(oRow.get("TRNSFR_TO_DESC").getString());
        oEmpFinInfoHeaderBean.setTxtTrnsfrReason(oRow.get("TRNSFR_REASON").getString());
        oEmpFinInfoHeaderBean.setTxtTrnsfrDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("TRNSFR_DT").getDate()));
        oEmpFinInfoHeaderBean.setTxtRlvngDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("RLVNG_DT").getDate()));
        oEmpFinInfoHeaderBean.setTxtRlvngTime(oRow.get("RLVNG_TIME").getString());
        oEmpFinInfoHeaderBean.setTxtTrnsfrFrom(oRow.get("TRNSFR_FROM").getString());
        oEmpFinInfoHeaderBean.setTxtJoiningDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("JOINING_DT").getDate()));
        oEmpFinInfoHeaderBean.setTxtJoiningTime(oRow.get("JOINING_TIME").getString());
        oEmpFinInfoHeaderBean.setHdnActionFlag(oRow.get("status_flag").getString());
		    oEmpFinInfoHeaderBean.setTxtCreatedDt(oRow.get("created_date").getString());  //added by sonia on 04-11-2011   
        oEmpFinInfoHeaderBean.setTxtModifiedDt(oRow.get("modified_date").getString());  //added by sonia on 04-11-2011
        oHeaderList.add(oEmpFinInfoHeaderBean);
        oRow = null;
        oEmpFinInfoHeaderBean=null;
      }    
    oList = null;
    oIt = null;
    oEmpTrnsfrQueryVO = null;
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
    return oHeaderList;
  }

  public EmpTrnsfrComboVO getEmpTrnsfrComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    EmpTrnsfrComboVO oEmpTrnsfrComboVO = new EmpTrnsfrComboVO();
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
        
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetTrnsfrReason(?,?)");
    oParameters=null;
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    count = 0;
    oIt = oList.iterator();
    ArrayList oTrnsfrList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
          oTrnsfrList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String sValue = ((oRow.get("gbl_code").getString()));
        String sLabel = ((oRow.get("code_sdesc").getString()));
        ComboVO oComboVO = new ComboVO(sLabel,sValue);
        sLabel=null;
        sValue=null;
        oTrnsfrList.add(oComboVO);
        oComboVO=null;
    }         
    oEmpTrnsfrComboVO.setTrnsfrReasonList(oTrnsfrList);      
    oTrnsfrList=null;
    oList=null;
    oBean = null;
    return oEmpTrnsfrComboVO;
  }
  
  public EmpTrnsfrSalRlsComboVO getEmpTrnsfrSalRlsComboDetails(String sEmpNo)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpTrnsfrSalRlsComboVO oEmpTrnsfr=null;    
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
    ComboVO oComboVO=null;
    ArrayList oPayCode = null;
    //String empNo ="";
    oEmpTrnsfr = new EmpTrnsfrSalRlsComboVO();          
      
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sEmpNo)));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getSalRlsYrMnthLov(?,?,?)");
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {
        oPayCode = new ArrayList();
        String payCodeLabel = "-------No Records Found--------";
        String payCodeValue = null;
        oComboVO = new ComboVO(payCodeLabel,payCodeValue);
        oPayCode.add(oComboVO);
        payCodeLabel=null;
        payCodeValue=null;
      //throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    count = 0;
    oIt = oList.iterator();
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oPayCode = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String payCodeLabel = oRow.get("code_sdesc").getString();
      String payCodeValue = oRow.get("code_desc").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      oPayCode.add(oComboVO);
      payCodeLabel=null;
      payCodeValue=null;
    }
    oEmpTrnsfr.setValueSalRlsYrMnthList(oPayCode);
    
    oPayCode = null;
    oParameters = new ArrayList();  
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sEmpNo)));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getIncentiveRlsYrMnth(?,?,?)");
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {
        oPayCode = new ArrayList();
        String payCodeLabel = "-------No Records Found--------";
        String payCodeValue = null;
        oComboVO = new ComboVO(payCodeLabel,payCodeValue);
        oPayCode.add(oComboVO);
        payCodeLabel=null;
        payCodeValue=null;
      //throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    count = 0;
    oIt = oList.iterator();
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oPayCode = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String payCodeLabel = oRow.get("code_sdesc").getString();
      String payCodeValue = oRow.get("code_desc").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      oPayCode.add(oComboVO);
      payCodeLabel=null;
      payCodeValue=null;
    }          
    oEmpTrnsfr.setIncentiveRlsYrMnthList(oPayCode);    
    oPayCode = null;
    oList = null;
    oOutArray = null;
    oList=null;
    oBean = null;
    oParameters = null;
    return oEmpTrnsfr;
  } 

  public LovVO getTrnsfrEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oLovVO.setHeaderList(arylstHeaderNames);
    arylstHeaderNames=null;
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);
    arylstVisibility=null;
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag")))); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpTrnsfrLocLOV(?,?,?,?,?,?,?)");
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    oParameters=null;
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
      oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_DESC").getString());
      oLOVBean.setDetailField5(oRow.get("EMP_TYPE").getString());
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("LOC_DESC").getString());
      oLOVBean.setDetailField8(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
      oLOVBean.setDetailField9(oRow.get("EMP_STATUS_DESC").getString());
      
      oList.add(oLOVBean);
      oLOVBean=null;
    }
     
      oLovVO.setDetailList(oList);
      oList = null;
      oBean = null;
      oOutArray = null;
      oOutObject = null;
      oParameters = null;
      arylstHeaderNames = null;
      arylstVisibility = null;
      return oLovVO;
  }

  public LovVO getTrnsfrEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    arylstHeaderNames=null;
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    arylstVisibility=null;
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpTrnsfrLocLOVQ(?,?,?,?,?,?,?)");
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    oParameters = null;
    QueryRow oRow = null; 
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
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean=null;
    }
     
      oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  public LovVO getTrnsfrEmpLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location Code");
    arylstHeaderNames.add("Location Name");
    arylstHeaderNames.add("Parent Location");
    oLovVO.setHeaderList(arylstHeaderNames);
    arylstHeaderNames=null;
    
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
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtEmpNo"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_EmpTrnsfrLocData(?,?,?,?,?,?)");
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    oParameters=null;
    
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
      
      oLOVBean.setDetailField1(oRow.get("loc_id").getString());
      oLOVBean.setDetailField2(oRow.get("loc_desc").getString()); 
      oLOVBean.setDetailField3(oRow.get("parent_loc_desc").getString());      
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  public LovVO getTrnsfrInEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));   
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnActionFlag"))).trim()));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));     
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpTrnsfrInLocLOVQ(?,?,?,?,?,?,?,?)");
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    oParameters=null;
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
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      
      oList.add(oLOVBean);
      oRow=null;
      oLOVBean=null;
    }
     
      oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  public String cancelEmpTrnsfr(EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
     
    ArrayList oOutArray; //Output  
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));  
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_CancelEmpTrnsfr(?,?,?,?,?,?)",true,true); 
      String oErrMsg = (String)((DBObject)oOutArray.get(0)).getObject();
      Integer oErrCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if(!oErrCode.equals(new Integer(0))) 
      {
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(oErrMsg));
      //    System.out.println("Error!!! while Updating Employee ::"+oErrMsg);
          throw new EnrgiseApplicationException("Pay.Payroll_TRANSERROR",oArguments);
      }
      DBObject oOutObject = (DBObject)oOutArray.get(0);
    oParameters=null;
    oOutArray = null;
    oBean = null;
    return oEmpFinInfoHeaderBean.getTxtEmpNo(); 
  }

 public String releaseSalary(EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {                 
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;   
      ArrayList oOutArray; //Output 
      String lUserId = String.valueOf(loginUserId);
      String lSiteId = String.valueOf(lLoginSiteId);
     // oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtEmpNo())));                   
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtYYMM())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,lUserId));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,lSiteId));       
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_EmpSuspRlsSalary(?,?,?,?,?,?)",true,true); 
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_code = (String)oOutObject.getObject();
      if(error_code==null)
      {
        error_code="";
      }
      oParameters = null;
      oOutArray=null;
      lUserId = null;
      lSiteId = null;
      return error_code;               
  }
 
  public String releaseIncentive(EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {                 
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;   
      ArrayList oOutArray; //Output 
      String lUserId = String.valueOf(loginUserId);
      String lSiteId = String.valueOf(lLoginSiteId);
      String vLbrType = "";;
      if((oEmpTrnsfrHeaderBean.getHdnEmpLbrFlag()).equals("L"))
      {
          vLbrType = "I";
      }
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtEmpNo())));                   
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtYYMM())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(vLbrType)));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,lUserId));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,lSiteId));       
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_empsusprlsinct(?,?,?,?,?,?,?)",true,true); 
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_code = (String)oOutObject.getObject();
      if(error_code==null)
      {
        error_code="";
      }
      oParameters = null;
      oOutArray=null;
      lUserId = null;
      lSiteId = null;
      return error_code;               
  }

  public EmpTrnsfrInvDtlsComboVO getEmpTrnsfrInvDtlsComboDetails(EmpTrnsfrQueryVO oEmpTrnsfrQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpTrnsfrInvDtlsComboVO oEmpSusp=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
    ComboVO oComboVO=null;
    ArrayList oPayCode = null;
    oEmpSusp = new EmpTrnsfrInvDtlsComboVO();          
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpTrnsfrQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetTrnsfrInvoiceYYMM(?,?,?,?)");
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {
        oPayCode = new ArrayList();
        String payCodeLabel = "-------No Records Found--------";
        String payCodeValue = null;
        oComboVO = new ComboVO(payCodeLabel,payCodeValue);
        oPayCode.add(oComboVO);
        payCodeLabel=null;
        payCodeValue=null;
      //throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    count = 0;
    oIt = oList.iterator();
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oPayCode = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String payCodeLabel = oRow.get("Inv_Num").getString();
      String payCodeValue = oRow.get("Inv_Num").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      payCodeLabel=null;
      payCodeValue=null;
      oPayCode.add(oComboVO);
      oComboVO=null;
      oRow = null;
    }          
    oEmpSusp.setValueInvDtlsList(oPayCode);    
    oPayCode = null;
    oList = null;
    oIt = null;
    oList = null;
    oOutArray = null;
    oParameters = null;
    oBean = null;
    return oEmpSusp;
  } 

  public LovVO getRlsSalEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    arylstHeaderNames.add("Incentive Amount");  // added by dushaynt
    
    oLovVO.setHeaderList(arylstHeaderNames);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);   // added by dushaynt
   
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));   
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getEmpRlsSalLOV(?,?,?,?,?,?)");
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    oParameters=null;
    
    String EmpLbr = oLovQueryVO.getProperty("hdnEmpLbrFlag") ;  // Added by dushyant on 02-April-2012
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
      oLOVBean.setDetailField2(oRow.get("NAME").getString());
      oLOVBean.setDetailField3(oRow.get("dsgn_dsc").getString());
      oLOVBean.setDetailField4(oRow.get("emp_catg").getString());
      oLOVBean.setDetailField5(oRow.get("emp_typ").getString());
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("loc_dsc").getString());
      oLOVBean.setDetailField8(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
      oLOVBean.setDetailField9(oRow.get("emp_stat").getString());
      if (EmpLbr.equals("D")) 
      {
        oLOVBean.setDetailField10(oRow.get("Incentive").getString());  // Added by dushyant on 02-April-2012
      }
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean=null;
    }
     
    oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }
  
    private String checkMaxPayYear(String siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
   ;
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
    // modified by Swarnika in ref to issue 44604   
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear2(?,?,?,?)");
    //oParameters=null;
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
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck1");
    }
    //oOutArray=null;
    //oRetList=null;
    
    return "";
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean=(EmpTrnsfrHeaderBean)oBaseHeaderBean;
   ArrayList oList=new ArrayList();
      CheckEmpAppsUser(oBaseHeaderBean,sScreenName,oList);
   if(!(oEmpTrnsfrHeaderBean.getHdnEmpLbrFlag().equals("E")))
   {
     
        TransferCheckProcess(oBaseHeaderBean,sScreenName,bHeaderDataChanged,oList);
        reportError(oList);
   }
   
   checkEmpClearance(oBaseHeaderBean,sScreenName,bHeaderDataChanged,oList);
   checkbasicmaintain(oBaseHeaderBean,sScreenName,bHeaderDataChanged,oList);
   checkMaxPayYear(oEmpTrnsfrHeaderBean.getTxtSiteID(),oEmpTrnsfrHeaderBean.getHdnEmpLbrFlag());
   reportError(oList);
  }
    private void CheckEmpAppsUser(BaseHeaderBean oBaseHeaderBean, String sScreenName,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        if(sScreenName.equals("TransferScreen"))
        {
            ArrayList oParameters = new ArrayList(); //Input Parameters
            DBUtilitiesBean oBean = new DBUtilitiesBean();
            
              ArrayList oOutArray = new ArrayList();
            QueryRow oRow = null;
            QueryValue oValue = null;
            ArrayList oRetList = null;
            Iterator oIt = null;    
            
               EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean=(EmpTrnsfrHeaderBean)oBaseHeaderBean;
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpNo()))); 
            oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CheckEmpAppsUser(?,?,?)",true,true);
            
            DBObject oOutObject = (DBObject)oOutArray.get(0);    
            String error_msg = (String)oOutObject.getObject();    
            if(error_msg!=null)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(error_msg);
              oList.add(new EnrgiseApplicationException("payroll.Common.EmpAbscondCheck",oArguments));
              reportError(oList);
            }          
            
        }  
     
     
    }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList=new ArrayList();
    checkSalProcess(oBaseHeaderBean,sScreenName,bHeaderDataChanged,oList);
    reportError(oList);
  }
  
  private void checkSalProcess(BaseHeaderBean oBaseHeaderBean, String sScreenName, boolean bHeaderDataChanged,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(sScreenName.equals("TransferInScreen") && bHeaderDataChanged==true)
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        Integer chkFlag=new Integer(0);
        EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean=(EmpTrnsfrHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oEmpTrnsfrHeaderBean.getTxtTrnsfrFrom()));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oEmpTrnsfrHeaderBean.getTxtTrnsfrTo()));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.PROC_EMPTRNSFR_CHECK(?,?,?,?,?,?)");
        oParameters = null;
        oEmpTrnsfrHeaderBean = null;
        chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
        if(chkFlag.equals(new Integer(0)))
        {        
          oList.add(new EnrgiseApplicationException("Pay.Payroll.Emp_Join.Error"));
        }
    }
  }
  // Added by dushyant on 02-feb-2012
  private void TransferCheckProcess(BaseHeaderBean oBaseHeaderBean, String sScreenName, boolean bHeaderDataChanged,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(sScreenName.equals("TransferScreen"))
    {   
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      Integer chkFlag=new Integer(0);
      EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean=(EmpTrnsfrHeaderBean)oBaseHeaderBean;
        
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTrnsfrTo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));    
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtTrnsfrDt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtRlvngDt())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtRlvngTime())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_TransLabourCheck(?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
       
       chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
          
        DBObject oMsgObject = (DBObject)oOutArray.get(1);    
        String error_msg = (String)oMsgObject.getObject();
        DBObject oErrObject = (DBObject)oOutArray.get(2);    
        Integer errorCode = (Integer)oErrObject.getObject();
 
        DBObject oWrkObject = (DBObject)oOutArray.get(3);    
        String wrkslip_msg = (String)oWrkObject.getObject();
 
        if(!(errorCode.equals(new Integer(0))))
        {        
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(error_msg));            
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        }
        else
        {
          if(chkFlag.equals(new Integer(0)))
          { 
            ArrayList oArguments = new ArrayList();
            String empNo = oEmpFinInfoHeaderBean.getTxtEmpNo();        
            oArguments.add(new String(empNo));
            oArguments.add(new Integer(count));
            oArguments.add(new String(wrkslip_msg));  
            oList.add(new EnrgiseApplicationException("Payroll.Labour.Transfer.Attendance.Error",oArguments)); 
            oArguments = null;
            empNo = null;
          }                 
          if(chkFlag.equals(new Integer(1)))
          { 
            ArrayList oArguments = new ArrayList();
            String empNo = oEmpFinInfoHeaderBean.getTxtEmpNo();        
            oArguments.add(new String(empNo));
            oArguments.add(new Integer(count));
            oArguments.add(new String(wrkslip_msg));  
            oList.add(new EnrgiseApplicationException("Payroll.Labour.Transfer.Workslip.Error",oArguments)); 
            oArguments = null;
            empNo = null;
          }                 
        } 
         oMsgObject=null;
         oWrkObject=null;
         oErrObject=null;
         wrkslip_msg = null;      
    }
  }
  // end by dushyant
  
  
    
  
  //added by geetika on 7/04/2014 to check for clearance of invoices before transfering
  private void checkEmpClearance(BaseHeaderBean oBaseHeaderBean, String sScreenName, boolean bHeaderDataChanged,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(sScreenName.equals("TransferScreen"))
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        Integer chkFlag=new Integer(0);
        EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean=(EmpTrnsfrHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_op_invoice_pending.PROC_EMP_CLEARANCE_CHECK(?,?,?)",true,true);
        oParameters = null;
        oEmpTrnsfrHeaderBean = null;
        chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
        if(chkFlag.equals(new Integer(1)))
        {        
           DBObject oMsgObject = (DBObject)oOutArray.get(0);    
           String error_msg = (String)oMsgObject.getObject();
           ArrayList oArguments = new ArrayList();
           oArguments.add(new String(error_msg));            
           oList.add(new EnrgiseApplicationException("Pay.Payroll.Emp_Clearance.Error",oArguments));
        }
    }
  }
  
  private void checkbasicmaintain(BaseHeaderBean oBaseHeaderBean, String sScreenName, boolean bHeaderDataChanged,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(sScreenName.equals("TransferInScreen") )
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        Integer chkFlag=new Integer(0);
        EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean=(EmpTrnsfrHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpTrnsfrHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_op_invoice_pending.basic_maintain_check(?,?,?,?)",true,true);
        oParameters = null;
        oEmpTrnsfrHeaderBean = null;
        chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
        if(chkFlag.equals(new Integer(2)))
        {        
           DBObject oMsgObject = (DBObject)oOutArray.get(0);    
           String error_msg = (String)oMsgObject.getObject();
           ArrayList oArguments = new ArrayList();
           oArguments.add(new String(error_msg));            
           oList.add(new EnrgiseApplicationException("Pay.Payroll.Emp_Clearance.Error",oArguments));
        }
    }
  }

//end 
}