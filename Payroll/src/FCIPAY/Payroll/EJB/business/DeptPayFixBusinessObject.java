package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.UTILITY.DeptPayFixBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;

public class DeptPayFixBusinessObject extends BaseBO  {
    public DeptPayFixBusinessObject() {
        super();
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
      ArrayList oAddressParam = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      String sTabNum; 
      String sPayModeType;
      int count = 0;
      DeptPayFixBean oEmpPayFixBean = (DeptPayFixBean)oBaseHeaderBean;
      
      ArrayList oOutArray; //Output 
      ArrayList oAddOutArray; //Output   
      
        oParameters = new ArrayList();     
      
        /* Employee Promotion Header Info */            
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getHeaderPrimaryKey())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getTxtEmpType())));
    if (oEmpPayFixBean.getTxtEmpType().equalsIgnoreCase("CDA")) 
    {
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("0")));   
    } 
    if (oEmpPayFixBean.getTxtEmpType().equalsIgnoreCase("IDA")) 
    {
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("0")));   
    } 
    if(oEmpPayFixBean.getTxtFixationFlag().equalsIgnoreCase("E"))
    {
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String("")));   
    }
    else
    {
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getNewBasic())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getNewBasic1())));
        
    }
        
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getTxtFixationFlag())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getTxtUserID())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getTxtSiteID())));
        oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.PROC_UPDATE_LBR_BASIC_FIXATION(?,?,?,?,?,?,?,?,?,?)",true,true);   
        
        DBObject oOutObject = (DBObject)oOutArray.get(0); 
        DBObject oErrObject = (DBObject)oOutArray.get(1);
        String errMsg= (String)oOutObject.getObject(); 
        Integer errCode=(Integer)oErrObject.getObject();
        if(!errCode.equals(new Integer(0)))
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(errMsg);
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
    }

    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;    
      int count = 0;
      int i=0;
      DeptPayFixBean oEmpPayFixBean = (DeptPayFixBean)oBaseHeaderBean;
      ArrayList oOutArray; //Output   
      
        oParameters = new ArrayList();     
        /*Employee Header Info */   
        
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getHeaderPrimaryKey()))); 
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getTxtPayType()+"1")));   
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getPayBand())));        
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getGradePay())));              
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpPayFixBean.getNewPromEffDate())));   
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getNewBasic())));       
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getTxtUserID())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPayFixBean.getTxtSiteID()))); 
        oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));      

        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertPayFixation(?,?,?,?,?,?,?,?,?,?)");        
    
        DBObject oOutObject = (DBObject)oOutArray.get(0); 
        DBObject oErrObject = (DBObject)oOutArray.get(1);
        String errMsg= (String)oOutObject.getObject(); 
        Integer errCode=(Integer)oErrObject.getObject();
        if(!errCode.equals(new Integer(0)))
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(errMsg);
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
        }
        return (String)oEmpPayFixBean.getHeaderPrimaryKey();      
    }

    public RecordMetaInfo getPayFixHeaderMetaInfo(DummyQueryVO oEmpPromotionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      Timestamp oWhenPicked = null;
      int count = 0;
      BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
      ArrayList oOutArray; //Output 
    //  String screenName=oEmpPromotionQueryVO.getScreenName();
      String locCode = oEmpPromotionQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHeaderPrimaryKey())));        
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHdnEmpLbrFlag())));        
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPayFixCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;    
    }


    public ArrayList getPayFixHeader(DummyQueryVO oEmpPromotionQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;

      if(oEmpPromotionQueryVO == null)
      {
        oEmpPromotionQueryVO = new DummyQueryVO();
      }

      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;  
    //  String screenName=oEmpPromotionQueryVO.getScreenName();
      String locCode = oEmpPromotionQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      
      //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
       // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHeaderPrimaryKey()))); 
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPromotionQueryVO.getHdnEmpLbrFlag()))); 
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPayFixedDetail(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      DeptPayFixBean oDeptPromotionBean;
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
          oDeptPromotionBean = new DeptPayFixBean();

          oDeptPromotionBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
          oDeptPromotionBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
          oDeptPromotionBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
          //oEmpPromotionBean.setTxtDsgnDesc(oRow.get("DESIGNATION_ID").getString());
          oDeptPromotionBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
          //oEmpPromotionBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());        
          oDeptPromotionBean.setTxtEmpType(oRow.get("PAY_SCALE_TYPE").getString());                
          oDeptPromotionBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
          oDeptPromotionBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString());        
          //oEmpPromotionBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
          oDeptPromotionBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
          oDeptPromotionBean.setTxtEmpStatus(oRow.get("EMP_TYPE_DESC").getString());  
          oDeptPromotionBean.setTxtCurtBasic(oRow.get("BASIC").getString()); 
         // oEmpPromotionBean.setTxtStagInc(oRow.get("new_Stag_incr").getString());        
          
              
          oDeptPromotionBean.setPayScaleCode(oRow.get("pay_scale_code").getString()); 
         
          oDeptPromotionBean.setNewStagInc(oRow.get("stag_incr").getString());
          oDeptPromotionBean.setPayBand(oRow.get("PAY_SCALE_TYPE").getString());
          oDeptPromotionBean.setGradePay(oRow.get("grade_pay_amt").getString());
         // oEmpPromotionBean.setNewGradePay(oRow.get("new_grade_pay").getString());
          oDeptPromotionBean.setNewBasic(oRow.get("new_basic").getString());   
          oDeptPromotionBean.setTxtFixationFlag(oRow.get("final_flag").getString());   
          oDeptPromotionBean.setNewPromEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("eff_from_date").getDate()));        
          oDeptPromotionBean.setNewBasic1(oRow.get("ATTRIBUTE4").getString());   
          oDeptPromotionBean.setNewPromEffDate1(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("ATTRIBUTE5").getDate()));        
         // oDeptPromotionBean.setNewPromEffDate1(oRow.get("ATTRIBUTE5").toString());        
          
          
          /*if(oRow.get("PAY_REV_CANCEL_FLAG").getString()!=null && !oRow.get("PAY_REV_CANCEL_FLAG").getString().equals(""))
          {
            oEmpPromotionBean.setCancelStatus("Cancelled on "+oRow.get("pay_rev_cancel_date").getString());
          }
          else
          {
            oEmpPromotionBean.setCancelStatus("");
          }*/
          
          oHeaderList.add(oDeptPromotionBean);
        }  
        
      return oHeaderList;
      
    }
    
    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
    }  
    
    public LovVO getDeptPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      arylstHeaderNames.add("DOJ Present Place");      
      arylstHeaderNames.add("Basic");     
      arylstHeaderNames.add("Pay Scale Type");      
      arylstHeaderNames.add("Stagnation Incr");    
      arylstHeaderNames.add("Designation Id");     
      arylstHeaderNames.add("Pay Code");     
      arylstHeaderNames.add("Pay Band");     
      arylstHeaderNames.add("Grade Pay");    
      
      oLovVO.setHeaderList(arylstHeaderNames);
      
      ArrayList arylstVisibility=new ArrayList();
      arylstVisibility.add(EnrgiseConstants.VISIBLE);
      arylstVisibility.add(EnrgiseConstants.VISIBLE);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpNewPayFixLOV(?,?,?,?,?,?,?)");
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
          oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
          //oLOVBean.setDetailField10(oRow.get("PAY_STATUS").getString());                   
          oLOVBean.setDetailField11(oRow.get("BASIC").getString()); 
        //  oLOVBean.setDetailField12(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));
          oLOVBean.setDetailField12(oRow.get("PAY_SCALE_TYPE").getString());          
       //   oLOVBean.setDetailField14(oRow.get("pers_pay_sfn_amount").getString());          
       //   oLOVBean.setDetailField15(oRow.get("pers_pay_high_qual_amt").getString());          
      //    oLOVBean.setDetailField16(oRow.get("adv_incr_amt").getString());          
          oLOVBean.setDetailField13(oRow.get("stag_incr").getString());          
          oLOVBean.setDetailField14(oRow.get("designation_id").getString());       
          oLOVBean.setDetailField15(oRow.get("pay_scale_code").getString());       
          oLOVBean.setDetailField16(oRow.get("pay_band_name").getString());       
          oLOVBean.setDetailField17(oRow.get("grade_pay_amt").getString());          
                
        oList.add(oLOVBean);
      }
       
        oLovVO.setDetailList(oList);
      return oLovVO;
    }

    public LovVO getQueryDeptPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpPayFixLOV(?,?,?,?,?,?,?)");
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
          oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString()); 
                
        oList.add(oLOVBean);
      }
       
        oLovVO.setDetailList(oList);
      return oLovVO;
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
        DeptPayFixBean oEmpPromotionBean = (DeptPayFixBean)oBaseHeaderBean;
      //  checkMaxPayYear(oEmpPromotionBean.getTxtSiteID(),oEmpPromotionBean.getHdnEmpLbrFlag());
      //  reportError(oList);
        if(sScreenName.equals(EnrgiseConstants.NEW_MODE))
        {
            //checkEmpNo(oBaseHeaderBean,oList); 
            checkDeptCurBasicLimit(oBaseHeaderBean,oList);
        }  

    //  checkEmpPFLimit(oBaseHeaderBean,oList);
      reportError(oList);        
    }  
    
    private void checkDeptCurBasicLimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oRetList = null;
      Iterator oIt = null;    
      DeptPayFixBean oDeptPromotionBean = (DeptPayFixBean)oBaseHeaderBean;
      
      String empNo = oDeptPromotionBean.getHeaderPrimaryKey();    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptPromotionBean.getTxtPayType()+"1")));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptPromotionBean.getPayBand())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptPromotionBean.getNewBasic())));  
      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_ValidatePayFixation(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oOutObject.getObject();    
      if(error_msg!=null)
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
      }       
    }


    public LovVO getDeptPromotionDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {     
      LovVO oLovVO=new LovVO();  
      ArrayList arylstHeaderNames=new ArrayList();
      arylstHeaderNames.add("Designation Code");    
      arylstHeaderNames.add("Designation");
      arylstHeaderNames.add("Category Code"); 
      arylstHeaderNames.add("Category");     
      arylstHeaderNames.add("Pay Scale Code");
      arylstHeaderNames.add("Pay Scale Desc");
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPromotionDsgnLov(?,?,?,?)");
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
          oLOVBean.setDetailField6(oRow.get("pay_scale_range").getString());
          //oLOVBean.setDetailField7(oRow.get("end_basic").getString());
          oList.add(oLOVBean);
      }    
      oLovVO.setDetailList(oList);
      return oLovVO;
    } 
    
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
    
    public LovVO getQueryDeptSelectGrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      arylstHeaderNames.add("Prev Promotion Date");    
      arylstHeaderNames.add("Pay Scale Type");
      arylstHeaderNames.add("Personal Pay for SFN");    
      arylstHeaderNames.add("Personal Pay for High Qual.");    
      arylstHeaderNames.add("Personal Pay for Adv. Incr");    
      arylstHeaderNames.add("Stagnation Incr");
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpSelectGrLOV(?,?,?,?,?,?)");
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
          oLOVBean.setDetailField10(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
          //oLOVBean.setDetailField10(oRow.get("PAY_STATUS").getString());                   
          oLOVBean.setDetailField11(oRow.get("BASIC").getString()); 
          oLOVBean.setDetailField12(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));
          oLOVBean.setDetailField13(oRow.get("PAY_SCALE_TYPE").getString()); 
          oLOVBean.setDetailField14(oRow.get("pers_pay_sfn_amount").getString());          
          oLOVBean.setDetailField15(oRow.get("pers_pay_high_qual_amt").getString());          
          oLOVBean.setDetailField16(oRow.get("adv_incr_amt").getString());          
          oLOVBean.setDetailField17(oRow.get("stag_incr").getString()); 
          oLOVBean.setDetailField18(oRow.get("designation_id").getString());          
                  
                
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
}
