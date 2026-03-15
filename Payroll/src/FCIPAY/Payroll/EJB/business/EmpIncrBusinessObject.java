package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpIncrQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintEmpIncrBean;
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

public class EmpIncrBusinessObject extends BaseBO 
{

  public EmpIncrBusinessObject()
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
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    String sPayModeType;
    int count = 0;
    MaintEmpIncrBean oEmpIncrBean = (MaintEmpIncrBean)oBaseHeaderBean;
    
    ArrayList oOutArray; //Output 
    ArrayList oAddOutArray; //Output   
    
      //oParameters = new ArrayList();     
    
      /* Employee Incr Detail Info */   
    
      if( oEmpIncrBean.getForwardedPage().equals("advincrdtl"))
      {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getIncrAction())));  
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtAdvIncrNo())));  
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpIncrBean.getTxtIncrRlsEffDate())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtUserID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtSiteID())));      
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateEmpIncrDetail(?,?,?,?,?,?,?)");  
      }
      
      else {
             oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getHeaderPrimaryKey())));
             oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpIncrBean.getTxtStagEffDt()))); ///milan kumari
             oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtStagIncrAmt()))); /////milan kumari 
             oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));      
             oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
             oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_updateStagDetail2(?,?,?,?,?)");   
             
             
         }

      DBObject oOutObject = (DBObject)oOutArray.get(0);  
      oOutArray = null;
      oParameters = null;
      oBean = null;
      oOutObject = null;
      oEmpIncrBean = null;
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    MaintEmpIncrBean oEmpIncrBean = (MaintEmpIncrBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    
      /*Employee Header Info   */
      if( oEmpIncrBean.getForwardedPage().equals("advincrdtl"))
      {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtAdvIncrType())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtAdvIncrNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpIncrBean.getTxtAdvIncrEffDate())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpIncrBean.getTxtIncrEffTill())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getIncrAction())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtUserID())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtCurtBasic()))); //added by yogesh
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtGradePay()))); // added by  yogesh
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtSiteID()))); 
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtEmpNo()))); 
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));      
      oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER));      
      //oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_InsertAdvIncrDetailTest(?,?,?,?,?,?,?,?,?,?,?,?,?)");      //added by yogesh on 16 th of aug 2010  
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_InsertAdvIncr_SixPay(?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
      }
      else{
                 oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getHeaderPrimaryKey())));      
                 oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpIncrBean.getTxtStagEffDt())));
                 oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtStagIncrAmt())));
                 oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtEmpNo()))); 
                 oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));      
                 oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));      
                 oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_updateStagDetail(?,?,?,?,?,?)");
                 
             }

      //added by swapnendu on 22 FEB 2011.
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oOutArray = null;
      oParameters = null;
      oBean = null;
      oEmpIncrBean = null;
      return (String)oOutObject.getObject();     
  }

  public RecordMetaInfo getEmpAdvIncrHeaderMetaInfo(EmpIncrQueryVO oEmpIncrQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oEmpIncrQueryVO.getLoginLocCode()+"";
    String incrType="";
 System.out.println(oEmpIncrQueryVO.getForwardedPage());
 if( oEmpIncrQueryVO.getForwardedPage().equals("advincrdtl"))
          
      {

    if(oEmpIncrQueryVO.getScreenName().equals("MaintEmpIncrScreen")) 
    {
      incrType="N";
    }
    
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHeaderPrimaryKey())));  
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHdnEmpLbrFlag())));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(incrType)));                  
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));    
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpIncrCount(?,?,?,?,?,?,?)");
 }
      
      else{
            

             oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
             oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHeaderPrimaryKey())));  
             oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHdnEmpLbrFlag())));    
             oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
             oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
             oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));    
             oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_getempstagincrcount(?,?,?,?,?,?)");
             
         }
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    oBean = null;
    oTimeObject = null;
    oTotalRecord = null;
    oOutArray = null;
    oParameters = null;
    oBaseHeaderVO = null;
    locCode = null;
    return oRecordMetaInfo;    
  }

  public ArrayList getEmpAdvIncrHeader(EmpIncrQueryVO oEmpIncrQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpIncrQueryVO == null)
    {
      oEmpIncrQueryVO = new EmpIncrQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String locCode = oEmpIncrQueryVO.getLoginLocCode()+"";
    String incrType="";
 if( oEmpIncrQueryVO.getForwardedPage().equals("advincrdtl"))
          
      {

    if(oEmpIncrQueryVO.getScreenName().equals("MaintEmpIncrScreen")) 
    {
        incrType="N";
    }
    
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHeaderPrimaryKey())));  
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHdnEmpLbrFlag())));    
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(incrType)));           
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpIncrDtl(?,?,?,?,?,?,?,?)");
    }
      else 
              
          {
                   
                    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
                    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
                    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
                    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHeaderPrimaryKey())));  
                    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHdnEmpLbrFlag())));
                    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
                    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));   
                    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_getEmpStagDtl(?,?,?,?,?,?,?)");
                    
        }

    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpIncrBean oEmpIncrBean;
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
        oEmpIncrBean = new MaintEmpIncrBean();

        oEmpIncrBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpIncrBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpIncrBean.setTxtStaffCode(oRow.get("STAFF_CODE").getString());                
        oEmpIncrBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oEmpIncrBean.setTxtCateg(oRow.get("emp_catg").getString());
        oEmpIncrBean.setTxtPresentPOP(oRow.get("loc_desc").getString());
        oEmpIncrBean.setTxtCurtBasic(oRow.get("basic").getString());        
        oEmpIncrBean.setTxtPayScaleCode(oRow.get("pay_scale_code").getString());    
        oEmpIncrBean.setTxtInrSt(oRow.get("increment_status").getString());  
        oEmpIncrBean.setTxtPayStsChnDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("pay_sta_chg_dt").getDate()));        
        oEmpIncrBean.setTxtGradePay(oRow.get("grade_pay").getString()); 
          if( oEmpIncrQueryVO.getForwardedPage().equals("advincrdtl"))
          {
        oEmpIncrBean.setTxtAdvIncrType(oRow.get("incr_type").getString());    
        oEmpIncrBean.setTxtAdvIncrAmnt(oRow.get("pay_scale_incr_amt").getString());  
        oEmpIncrBean.setTxtAdvIncrNo(oRow.get("no_of_adv_incr").getString()); 
        oEmpIncrBean.setTxtAdvIncrEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_strt_dt").getDate()));                
        oEmpIncrBean.setTxtIncrEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_end_dt").getDate()));        
        oEmpIncrBean.setIncrAction(oRow.get("incr_status").getString());        

          }
         if( oEmpIncrQueryVO.getForwardedPage().equals("stagnation"))
          {
          oEmpIncrBean.setTxtStagEffDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_dt").getDate()));                
          oEmpIncrBean.setTxtStagIncrAmt(oRow.get("component_value").getString());  
          } 
        if(oEmpIncrQueryVO.getScreenName().equals("MaintEmpIncrScreen")) 
        {
          oEmpIncrBean.setTxtIncrRlsEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("incr_rel_dt").getDate()));        
        }
        
        oHeaderList.add(oEmpIncrBean);
        oEmpIncrBean = null;
        oRow = null;
      }  
    oList = null;
    oIt = null;
    oEmpIncrQueryVO = null;
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
    return oHeaderList;
  }
  
  public RecordMetaInfo getEmpIncrHeaderMetaInfo(EmpIncrQueryVO oEmpIncrQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oEmpIncrQueryVO.getLoginLocCode()+"";
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHeaderPrimaryKey())));  
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHdnEmpLbrFlag())));       
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));    
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpIncrDetailCount(?,?,?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
	oTimeObject  = null;       
	oTotalRecord = null;
	oOutArray    = null;
	oParameters  = null;
    return oRecordMetaInfo;    
  }
  
  public ArrayList getEmpIncrHeader(EmpIncrQueryVO oEmpIncrQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpIncrQueryVO == null)
    {
      oEmpIncrQueryVO = new EmpIncrQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String locCode = oEmpIncrQueryVO.getLoginLocCode()+"";
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHeaderPrimaryKey())));  
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrQueryVO.getHdnEmpLbrFlag())));       
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpIncrDetail(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpIncrBean oEmpIncrBean;
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
        oEmpIncrBean = new MaintEmpIncrBean();

        oEmpIncrBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpIncrBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpIncrBean.setTxtStaffCode(oRow.get("STAFF_CODE").getString());                
        oEmpIncrBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oEmpIncrBean.setTxtCateg(oRow.get("EMP_CATEGORY").getString());
        oEmpIncrBean.setTxtPresentPOP(oRow.get("loc_desc").getString());
        oEmpIncrBean.setTxtCurtBasic(oRow.get("basic").getString());        
        oEmpIncrBean.setTxtPayScaleCode(oRow.get("pay_scale_code").getString());    
        oEmpIncrBean.setTxtInrSt(oRow.get("increment_status").getString());  
        oEmpIncrBean.setTxtPayStsChnDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("pay_sta_chg_dt").getDate()));        
        oEmpIncrBean.setTxtIncrEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("INCR_EFF_DATE").getDate()));        
        oEmpIncrBean.setIncrAction(oRow.get("INCREMENT_STATUS").getString());        
        oEmpIncrBean.setTxtStagIncrAmt(oRow.get("STAG_INCR").getString()); /////// MILAN KUMARI
        oEmpIncrBean.setTxtStagEffDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("STAG_INCR_EFF_DATE").getDate()));  //////MILAN KUMARI     
        oHeaderList.add(oEmpIncrBean);
        oEmpIncrBean = null;
        oRow = null;
      }  
      
    oList = null;
    oIt = null;
    oEmpIncrQueryVO = null;
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
    return oHeaderList;
    
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("DaRatesScreen"))
    {
      saveDARates(sHeaderPrimaryKey,oDetailBeanArray);
    }    
  }  

  public LovVO getEmpAdvIncrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Staff Code");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");        
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Pay Scale Code");    
    arylstHeaderNames.add("Basic");        
    arylstHeaderNames.add("Increment Status");    
    arylstHeaderNames.add("Pay Status Change Date");  
    arylstHeaderNames.add("Grade Pay");// --added by yogesh on 10 aug 2010
    arylstHeaderNames.add("CPF Code");          
    
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
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));    
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpAdvIncrLOV(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField3(oRow.get("STAFF_CODE").getString());                    
        oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString());                    
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY").getString());           
        oLOVBean.setDetailField6(oRow.get("LOC_DESC").getString());           
        oLOVBean.setDetailField7(oRow.get("BASIC").getString());           
        oLOVBean.setDetailField8(oRow.get("PAY_SCALE_CODE").getString());  
        oLOVBean.setDetailField9(oRow.get("INCREMENT_STATUS").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate()));   
        oLOVBean.setDetailField11(oRow.get("GRADE_PAY").getString());          
        oLOVBean.setDetailField12(oRow.get("CPF_CODE").getString());    
                              
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
  public LovVO getEmpIncrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Staff Code");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");        
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Pay Scale Code");    
    arylstHeaderNames.add("Basic");        
    arylstHeaderNames.add("Increment Status");    
    arylstHeaderNames.add("Pay Status Change Date");    
    arylstHeaderNames.add("Grade pay");        //added by yogesh dated 3 aug 2010
    arylstHeaderNames.add("CPF Code");        
    
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
    arylstVisibility.add(EnrgiseConstants.HIDDEN); //added by yogesh dated 3 aug 2010  
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
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));       
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpIncrLOV(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField3(oRow.get("STAFF_CODE").getString());                    
        oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString());                    
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY").getString());           
        oLOVBean.setDetailField6(oRow.get("LOC_DESC").getString());           
        oLOVBean.setDetailField7(oRow.get("BASIC").getString());           
        oLOVBean.setDetailField8(oRow.get("PAY_SCALE_CODE").getString());  
        oLOVBean.setDetailField9(oRow.get("INCREMENT_STATUS").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate())); 
        oLOVBean.setDetailField11(oRow.get("GRADE_PAY").getString());
        oLOVBean.setDetailField12(oRow.get("CPF_CODE").getString());

    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getEmpIncrLOVDataNew(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Staff Code");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");        
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Pay Scale Code");    
    arylstHeaderNames.add("Basic");        
    arylstHeaderNames.add("Increment Status");    
    arylstHeaderNames.add("Pay Status Change Date");          
    //arylstHeaderNames.add("Adv. Increment Amount");                
    arylstHeaderNames.add("Grade pay");  
    arylstHeaderNames.add("CPF Code"); 
    
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
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag")))); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));       
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpIncrLOVNew(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField3(oRow.get("STAFF_CODE").getString());                    
        oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString());                    
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY").getString());           
        oLOVBean.setDetailField6(oRow.get("LOC_DESC").getString());           
        oLOVBean.setDetailField7(oRow.get("BASIC").getString());           
        oLOVBean.setDetailField8(oRow.get("PAY_SCALE_CODE").getString());  
        oLOVBean.setDetailField9(oRow.get("INCREMENT_STATUS").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate()));                       
        //oLOVBean.setDetailField11(oRow.get("INCREMENT_AMT").getString());
        //System.out.println("cpf-code===="+oRow.get("CPF_CODE").getString());
        oLOVBean.setDetailField11(oRow.get("GRADE_PAY").getString());        // added by yogesh on 9th sep 2010
        //System.out.println("oGRADE_PAY.getString=="+oRow.get("GRADE_PAY").getString());
        oLOVBean.setDetailField12(oRow.get("CPF_CODE").getString());         // added by yogesh on 9th sep 2010
       // System.out.println("oRow.getCPF_CODEgetString()=="+oRow.get("CPF_CODE").getString());
        
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

  
  public LovVO getPromEmpTypeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    //oParameters = new ArrayList();
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
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  public LovVO getQueryEmpIncrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category Id");   
    arylstHeaderNames.add("Category Desc");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ Present Place");      
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Prev Incr Date");    
    
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpIncrLOV(?,?,?,?,?)");
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
        oLOVBean.setDetailField5(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField6(oRow.get("LOC_DESC").getString());           
        oLOVBean.setDetailField7(oRow.get("BASIC").getString());           
        oLOVBean.setDetailField8(oRow.get("PAY_SCALE_CODE").getString());  
        oLOVBean.setDetailField9(oRow.get("INCREMENT_STATUS").getString());          
        oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate()));                       
              
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
    checkRecYYMM(oBaseHeaderBean, oList);  
    checkEmpCurBasicLimit(oBaseHeaderBean,oList); 
    checkSameEffDate(oBaseHeaderBean,oList);// added by Himanshu on 14-Nov-2014
    checkSameJoiningDate(oBaseHeaderBean,oList);
    reportError(oList);        
  }  
  
 // added by geetika 30-07-2013 start
  private void checkEmpCurBasicLimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    //ArrayList oOutArray; 
    ArrayList oOutArray = new ArrayList(); // added by devendra
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
     MaintEmpIncrBean oEmpIncrBean = (MaintEmpIncrBean)oBaseHeaderBean;
    
    String empNo = oEmpIncrBean.getHeaderPrimaryKey(); 
      if( oEmpIncrBean.getForwardedPage().equals("advincrdtl"))
       {
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtPayScaleCode())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtCurtBasic())));  
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtGradePay())));  
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_ValidateCurBasic_6PC_new(?,?,?,?,?,?)"); 
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
       } 
     }       
  }
  
  private void checkRecYYMM(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
    String sRevYear="";
    String status="";
    MaintEmpIncrBean oMaintEmpIncrBean=(MaintEmpIncrBean)oBaseHeaderBean;    
   // oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpIncrBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpIncrBean.getHdnEmpLbrFlag())));
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
    oOutArray = null;
    oParameters = null;
    oMaintEmpIncrBean = null;
    oIt = null;
    oRetList = null;
  }


  public LovVO getEmpIncrDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code");
    arylstHeaderNames.add("Start Basic"); 
    arylstHeaderNames.add("End Basic");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPromoType"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtCategory"))));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetIncrDsgnLov(?,?,?,?)");
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
        oLOVBean.setDetailField6(oRow.get("start_basic").getString());
        oLOVBean.setDetailField7(oRow.get("end_basic").getString());
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
  //added by Himanshu on 14-Nov-2014
  private void checkSameEffDate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    //ArrayList oOutArray; 
    ArrayList oOutArray = new ArrayList(); // added by devendra
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
     MaintEmpIncrBean oEmpIncrBean = (MaintEmpIncrBean)oBaseHeaderBean;
    
    String empNo = oEmpIncrBean.getHeaderPrimaryKey();   
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtAdvIncrEffDate())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_validate_effective_date(?,?,?,?)"); 
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
    }        
  }
  
  
 private void checkSameJoiningDate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    //ArrayList oOutArray; 
    ArrayList oOutArray = new ArrayList();
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
     MaintEmpIncrBean oEmpIncrBean = (MaintEmpIncrBean)oBaseHeaderBean;
    
    String empNo = oEmpIncrBean.getHeaderPrimaryKey();   
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpIncrBean.getTxtAdvIncrEffDate())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_validate_joining_date(?,?,?,?)"); 
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curJoiningCheck",oArguments));
    }        
  }//added by priyanka
  
  //end of addition
}