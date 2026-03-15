/*
 * Name             :   EmpBriefcaseReimbursementBusinessObject.java
 * 
 * Creation Date    :   27-March-2023
 * 
 * Version          :   1.0.0.1
 * 
 * Created By       :   Amresh Kumar
 * 
 * Modified By       :        Modified Line number        :       Modification Date
 * 
 * 
 * */



package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpBriefcaseReimbursementComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.common.utility.*;
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
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.UTILITY.EmpBriefcaseReimbursementHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpBriefcaseReimbursementQueryVO;
import FCIPAY.Payroll.WEBTIER.Form.EmpBriefcaseReimbursementForm;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;


public class EmpBriefcaseReimbursementBusinessObject extends BaseBO
{
  public EmpBriefcaseReimbursementBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("CCARateALLScreen"))
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
    int count = 0;
    EmpBriefcaseReimbursementHeaderBean oEmpBriefcaseReimbursementHeaderBean = (EmpBriefcaseReimbursementHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output      
    
      oParameters = new ArrayList();     
    
      /* Employee Header Info */            
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtsanctionId())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpBriefcaseReimbursementHeaderBean.getTxtSancDate())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtSancNum())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtsanctionAmt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtBillNum())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpBriefcaseReimbursementHeaderBean.getTxtBillDate())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtRemark())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE1())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE2())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE3())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE4())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE5())));
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE6())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE7())));
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE8())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE9())));
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE10())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE11())));
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE12())));
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE13())));
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE14())));
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE15())));
      oParameters.add(new DBObject(26,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(27,DBObject.OUT,ParameterTypes.VARCHAR));

      oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_UPDATE_pay_briefcase_reim(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
      
      DBObject oErrObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();


  }

public LovVO getEmpBriefcaseReimbursementAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    /*
     * LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Supplier ID");
    arylstHeaderNames.add("Supplier Name");
    arylstHeaderNames.add("Supplier No"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);

    oLovVO.setVisibilityList(arylstVisibility);
    String sAgencyName,sAgency,sAgencyNo;
    sAgency=oLovQueryVO.getSearchField1();
    sAgencyName=oLovQueryVO.getSearchField2();
    sAgencyNo=oLovQueryVO.getSearchField3();

    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;
      System.out.println(oLovQueryVO.getProperty("txtSiteID"));
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sAgency));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sAgencyName));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sAgencyNo ));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtEmpNo")));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtPayCode")));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.proc_getMedClaimAgencyCodelov(?,?,?,?,?,?,?,?)"); 
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
      
      oLOVBean.setDetailField1(oRow.get("vendor_id").getString());   
      oLOVBean.setDetailField2(oRow.get("vendor_name").getString());    
      oLOVBean.setDetailField3(oRow.get("segment1").getString());            
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean = null;
    }
     
    oLovVO.setDetailList(oList);
    oList = null;
    iter = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;*/
    return null;
  }

  
  public LovVO getEmpBriefcaseReimbursementAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    /*
     * LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Supplier SiteID");  
    arylstHeaderNames.add("Supplier Site Code");  
    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtAgency")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty( "txtSiteID")));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_MedClaimAgencySiteCodelov(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("vendor_site_id").getString());            
       oLOVBean.setDetailField2(oRow.get("vendor_site_code").getString());                   
           
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean = null;
    }
     
      oLovVO.setDetailList(oList);
        oList = null;
    iter = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;*/
    return null;
  }
 
 
 
 public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    //ArrayList oParameters1 = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
     DBUtilitiesBean oBean1 = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    EmpBriefcaseReimbursementHeaderBean oEmpBriefcaseReimbursementHeaderBean = (EmpBriefcaseReimbursementHeaderBean)oBaseHeaderBean;
    int payCode = Integer.parseInt(oEmpBriefcaseReimbursementHeaderBean.getTxtPayCode()); 
    ArrayList oOutArray; //Output  
    ArrayList oOutArray1; 
    System.out.println(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE8());
            /* Employee Header Info */   
                        oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.VARCHAR));
                        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtEmpNo())));
                        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpBriefcaseReimbursementHeaderBean.getTxtSancDate())));
                        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtSancNum())));
                        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtsanctionAmt())));
                        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtBillNum())));
                        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpBriefcaseReimbursementHeaderBean.getTxtBillDate())));
                        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtRemark())));
                        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtSiteID())));
                        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtUserID())));
                        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE1())));
                        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE2())));
                        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE3())));
                        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE4())));
                        oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE5())));
                        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE6())));
                        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE7())));
                        oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE8())));
                        oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE9())));
                        oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE10())));
                        oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE11())));
                        oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE12())));
                        oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE13())));
                        oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE14())));
                        oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementHeaderBean.getTxtATTRIBUTE15())));
                        oParameters.add(new DBObject(26,DBObject.OUT,ParameterTypes.INTEGER));
                        oParameters.add(new DBObject(27,DBObject.OUT,ParameterTypes.VARCHAR));
                        
                      System.out.println(oParameters);
                System.out.println(oParameters.size());
                      oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_INSERT_pay_briefcase_reim(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true); 
                   
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            DBObject oErrObject = (DBObject)oOutArray.get(2);
            Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
            System.out.println("Error!!! while inserting Over & Above Details ::"+errCode);
            if( ! errCode.equals(new Integer(0)))
            {
               ArrayList oArguments = new ArrayList();
               oArguments.add(new String((String)oErrObject.getObject()));
               System.out.println("Error!!! while inserting Over & Above ::"+oErrObject.getObject());
               throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }     
            
            return (String)oOutObject.getObject(); 
//    }
  }
  
 
private void checkDependentDtls(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    /*
     * ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oArguments = new ArrayList(); 
    
    
   
      EmpBriefcaseReimbursementHeaderBean oEmpBriefcaseReimbursementHeaderBean = (EmpBriefcaseReimbursementHeaderBean)oBaseHeaderBean;
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oEmpBriefcaseReimbursementHeaderBean.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oEmpBriefcaseReimbursementHeaderBean.getTxtStartDate()));  
	  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oEmpBriefcaseReimbursementHeaderBean.getTxtEndDate()));  
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oEmpBriefcaseReimbursementHeaderBean.getTxtDpndntNam()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));       
	  oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetEmpDependentDtl(?,?,?,?,?,?)");                 
      Integer m = (Integer)((DBObject)oOutArray.get(0)).getObject();
	  count= m.intValue();
      if(count>1){	
                  oArguments.add("");
                  oList.add(new EnrgiseApplicationException("Payroll.MedicalBill.checkDependentDtls",oArguments));
                  oArguments=null;
	  }
	  
    oParameters=null;*/
  }
private void checkEmpPayCodeMap(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
     ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     ArrayList oOutArray; //Output
     ArrayList oRetList;
     QueryRow oRow = null;
     Iterator oIt = null;
    
    EmpBriefcaseReimbursementHeaderBean oEmpBriefcaseReimbursementHeaderBean = (EmpBriefcaseReimbursementHeaderBean)oBaseHeaderBean;
      
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oEmpBriefcaseReimbursementHeaderBean.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oEmpBriefcaseReimbursementHeaderBean.getTxtPayCode()));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));       
	  oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.proc_emppaycodechk(?,?,?,?)",true,true);                 
    Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
    String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() != 0)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Payroll.EmpPrmsMedical.EmpPayCodeChk",oArguments));
        }
   
  }
 

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }


  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
       
  }
  
    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
//        ArrayList oParameters = new ArrayList(); //Input Parameters
//        DBUtilitiesBean oBean = new DBUtilitiesBean();
//        ArrayList oOutArray; //Output
//        ArrayList oRetList;
//        QueryRow oRow = null;
//        Iterator oIt = null;
//        EmpBriefcaseReimbursementHeaderBean oEmpBriefcaseReimbursementHeaderBean = (EmpBriefcaseReimbursementHeaderBean)oBaseHeaderBean;
//        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oEmpBriefcaseReimbursementHeaderBean.getHdnEmpLbrFlag())));
//        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oEmpBriefcaseReimbursementHeaderBean.getTxtUserID())));
//        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oEmpBriefcaseReimbursementHeaderBean.getTxtSiteID())));
//        oParameters.add(new DBObject(4, DBObject.OUT,ParameterTypes.VARCHAR));
//        oParameters.add(new DBObject(5, DBObject.OUT,ParameterTypes.INTEGER));
//        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_othrPaymnt_YrEndcheck(?,?,?,?,?)",true,true);
//        Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
//        String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
//        if(errCode.intValue() != 0)
//        {
//            ArrayList oArguments = new ArrayList();
//            oArguments.add(new String(errMsg));
//            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
//        }
    }

  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }

  public EmpBriefcaseReimbursementComboVO getEmpBriefcaseReimbursementComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    EmpBriefcaseReimbursementComboVO oEmpBriefcaseReimbursementComboVO = new EmpBriefcaseReimbursementComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayCode = null;

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_PAY_BRIEFCASE_REIM_PAYCODELOV(?,?)");

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
        oPayCode = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String payCodeLabel = oRow.get("pay_code_desc").getString();
      String payCodeValue = oRow.get("pay_code").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      oPayCode.add(oComboVO);
    }
    oEmpBriefcaseReimbursementComboVO.setPayCodeList(oPayCode);
    return oEmpBriefcaseReimbursementComboVO;
  }
  
  public RecordMetaInfo getEmpBriefcaseReimbursementHeaderMetaInfo(EmpBriefcaseReimbursementQueryVO oEmpBriefcaseReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpBriefcaseReimbursementQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementQueryVO.getTxtPayCode())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_GET_pay_briefcase_reim_CNT(?,?,?,?,?,?,?)"); 
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;
    
  }

    public ArrayList getEmpBriefcaseReimbursementHeader(EmpBriefcaseReimbursementQueryVO oEmpBriefcaseReimbursementQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;

      if(oEmpBriefcaseReimbursementQueryVO == null)
      {
        oEmpBriefcaseReimbursementQueryVO = new EmpBriefcaseReimbursementQueryVO();
      }
      
        ArrayList oOutArray; //Output 
        ArrayList oHeaderList = null;

              oParameters = new ArrayList();                 
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpBriefcaseReimbursementQueryVO.getLoginLocCode())));    
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpBriefcaseReimbursementQueryVO.getTxtEmpNo())));    
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oEmpBriefcaseReimbursementQueryVO.getHdnEmpLbrFlag()))); 
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, new String(oEmpBriefcaseReimbursementQueryVO.getTxtPayCode()))); 
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_GET_pay_briefcase_reim_HDR(?,?,?,?,?,?,?,?)");
        
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());

        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        EmpBriefcaseReimbursementHeaderBean oEmpBriefcaseReimbursementHeaderBean;
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
            oEmpBriefcaseReimbursementHeaderBean= new EmpBriefcaseReimbursementHeaderBean();
            oEmpBriefcaseReimbursementHeaderBean.setHeaderPrimaryKey(oRow.get("REIM_ALLOW_ID").getString());                                           

            oEmpBriefcaseReimbursementHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString()); 
            oEmpBriefcaseReimbursementHeaderBean.setTxtEmpName(oRow.get("EMPNAME").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtsanctionId(oRow.get("REIM_ALLOW_ID").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtSancDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SANCTION_DATE").getDate()));
            oEmpBriefcaseReimbursementHeaderBean.setTxtSancNum(oRow.get("SANCTION_NUMBER").getString());                                           
            oEmpBriefcaseReimbursementHeaderBean.setTxtsanctionAmt(oRow.get("SANCTION_AMOUNT").getString());                                           
            oEmpBriefcaseReimbursementHeaderBean.setTxtBillDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("BILL_DATE").getDate()));
            oEmpBriefcaseReimbursementHeaderBean.setTxtInvID(oRow.get("INVOICE_NUM").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtBillNum(oRow.get("BILL_NUMBER").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtRemark(oRow.get("REMARKS").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE1(oRow.get("ATTRIBUTE1").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE2(oRow.get("ATTRIBUTE2").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE3(oRow.get("ATTRIBUTE3").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE4(oRow.get("ATTRIBUTE4").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE5(oRow.get("ATTRIBUTE5").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE6(oRow.get("ATTRIBUTE6").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE7(oRow.get("ATTRIBUTE7").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE8(oRow.get("ATTRIBUTE8").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE9(oRow.get("ATTRIBUTE9").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE10(oRow.get("ATTRIBUTE10").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE11(oRow.get("ATTRIBUTE11").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE12(oRow.get("ATTRIBUTE12").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE13(oRow.get("ATTRIBUTE13").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE14(oRow.get("ATTRIBUTE14").getString());
            oEmpBriefcaseReimbursementHeaderBean.setTxtATTRIBUTE15(oRow.get("ATTRIBUTE15").getString());
            oHeaderList.add(oEmpBriefcaseReimbursementHeaderBean);
        }              
      return oHeaderList;
    } 
  public LovVO getEmpBriefcaseReimbursementLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag")).trim())); 
    //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPayCode")).trim())); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID")).trim()));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_GET_pay_briefcase_reimLOVN(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField3(oRow.get("cpf_code").getString()); 
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getEmpBriefcaseReimbursementLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag")).trim())); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPayCode")).trim())); 
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID")).trim()));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_GET_pay_briefcase_reimLOVQ(?,?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField3(oRow.get("cpf_code").getString()); 
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getEmpDependentLov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
   /* LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Dependent Name");          
    arylstHeaderNames.add("Relationship");          
    arylstHeaderNames.add("Dependent Id");          
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("EmpNo")).trim()));     
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLovQueryVO.getProperty("BillDate"))));     
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.proc_getprmsempdependentlov(?,?,?,?)");
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
      
        oLOVBean.setDetailField1(oRow.get("DEPENDENT_NAME").getString());                    
        oLOVBean.setDetailField2(oRow.get("DEPENDENT_REL").getString());                    
        oLOVBean.setDetailField3(oRow.get("EMP_DPNDNT_ID").getString());                    
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);*/
    return null;
  }  
  
  public String sendEmpBriefcaseReimbursementInv(String oEmpBriefcaseReimbursementId,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oEmpBriefcaseReimbursementId));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_SEND_pay_briefcase_reim_INVOICE(?,?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());    
    String sRetMsg=errCode.toString()+","+errMsg;   
    
    return sRetMsg;
    
  }
  
  public String  EmpBriefcaseReimbursementCancelInv(EmpBriefcaseReimbursementQueryVO oEmpBriefcaseReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    String msg=null;
  
    if(oEmpBriefcaseReimbursementQueryVO == null)
    {
      oEmpBriefcaseReimbursementQueryVO = new EmpBriefcaseReimbursementQueryVO();
    }
    
   
    
    String screenName=oEmpBriefcaseReimbursementQueryVO.getScreenName();
    ArrayList oOutArray;
    ArrayList oOutArray1;//Output 
    ArrayList oParamList = new ArrayList();  
    ArrayList oList = new ArrayList();  
    

    
    oParameters = new ArrayList();
    
       
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpBriefcaseReimbursementQueryVO.getTxtEmpNo()))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpBriefcaseReimbursementQueryVO.getTxtInvID()))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpBriefcaseReimbursementQueryVO.getScreenName()))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpBriefcaseReimbursementQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oEmpBriefcaseReimbursementQueryVO.getUserId()))));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_cancel_othr_pymnt_inv.proc_cancel_op_invoices(?,?,?,?,?,?,?)",true,true);
  
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    if (errCode.equals(0))
           {
                   oOutArray1 = oBean.callProc(oParameters,"pkg_allow_n_reim_payroll.PROC_DEL_INV_NUM(?,?,?,?,?,?,?)",true,true);
               }
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());    
    String sRetMsg=errMsg;   
    
    return sRetMsg;
  }
  
}