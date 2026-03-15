package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsComboVO;
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
import FCIPAY.Payroll.UTILITY.EmpMediBillsHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;


public class EmpMediBillsBusinessObject extends BaseBO
{
  public EmpMediBillsBusinessObject()
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
    EmpMediBillsHeaderBean oEmpMediBillsHeaderBean = (EmpMediBillsHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output      
    int payCode = Integer.parseInt(oEmpMediBillsHeaderBean.getTxtPayCode());
      oParameters = new ArrayList();     
    
      /* Employee Header Info */            
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtBillAgst())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtDpndntId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtClaimAmt())));   
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtDedIT())));//txtITDedAmt
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtITDedAmt())));//txtITDedAmt
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtAgency())));    
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtAgencySiteCode())));    
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpMediBillsHeaderBean.getTxtBillDate())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpMediBillsHeaderBean.getTxtFileDate())));            
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtRemark())));            
      
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtStartDate())));//added by sonia on 22-11-2011
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtEndDate())));//added by sonia on 22-11-2011
      
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtSiteID())));      
      /*
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getQuarter())));  // added by devendra on 8 sept 2010
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getFinYear()))); // added by devendra on 8 sept 2010 
      */
      if(payCode==200)
       {
               oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getQuarter())));  // added by devendra on 8 sept 2010
               oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getFinYear()))); // added by devendra on 8 sept 2010 
       }
       else
       {
               oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String("")));  // added by devendra on 8 sept 2010
               oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); // added by devendra on 8 sept 2010 
       }
      oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(19,DBObject.OUT,ParameterTypes.INTEGER));

    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_UpdateEmpMedicalClaim(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);       //commented by devendra on 8 sept 2010
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_UpdateEmpMedicalClaim(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        // added by devendra on 8 sept 2010 
   
      //DBObject oOutObject = (DBObject)oOutArray.get(0);
      DBObject oErrObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      //System.out.println("Error!!! while updating Medical Bills Details ::"+errCode);
      /*if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String((String)oErrObject.getObject()));
         System.out.println("Error!!! while updating Over & Above ::"+oErrObject.getObject());
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } */   
      //return (String)oOutObject.getObject(); 

  }

public LovVO getMedClaimAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    //arylstHeaderNames.add("Agency");  
    //arylstHeaderNames.add("Agency name");  
    arylstHeaderNames.add("Supplier ID");  //added by yogesh on 23 09 2010
    arylstHeaderNames.add("Supplier Name");   //added by yogesh on 23 09 2010
    arylstHeaderNames.add("Supplier No"); //added by yogesh on 23 09 2010
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE); //added by yogesh on 23 09 2010

    oLovVO.setVisibilityList(arylstVisibility);
    String sAgencyName,sAgency,sAgencyNo;
    //String sAgencyCode,sAgencyCodeDesc,sAgencyNo; //sAgencyNo  added by yogesh on 23 09 2010
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
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sAgencyNo ));//added by yogesh on 23 sep 2010
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtEmpNo")));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtPayCode")));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_getMedClaimAgencyCodelov(?,?,?,?,?,?,?,?)"); // added by yogesh on 19 aug 2010
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
    arylstVisibility = null;
    return oLovVO;
  }

  
  public LovVO getMedClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    //arylstHeaderNames.add("Agency Site Code");  
    //arylstHeaderNames.add("Agency Site");  
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
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtAgency")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty( "txtSiteID")));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
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
    arylstVisibility = null;
    return oLovVO;
  }
 
 
 
 public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oParameters1 = new ArrayList(); // added by devendra on 13th aug 2010
    DBUtilitiesBean oBean = new DBUtilitiesBean();
     DBUtilitiesBean oBean1 = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    EmpMediBillsHeaderBean oEmpMediBillsHeaderBean = (EmpMediBillsHeaderBean)oBaseHeaderBean;
    int payCode = Integer.parseInt(oEmpMediBillsHeaderBean.getTxtPayCode()); // added by devendra on 13th aug 2010
    ArrayList oOutArray; //Output  
    ArrayList oOutArray1; // added by devendra on 13th aug 2010
    
    ///////////////////////////// first checking whether this particular employee has already been done a reimbursement for 
    //the selected quarter, fin year and pay code=200 and location code
    if(payCode==200)
    {
              oParameters1.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtPayCode())));
              oParameters1.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getQuarter())));   
              oParameters1.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getFinYear())));
              oParameters1.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtSiteID()))); 
              oParameters1.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtEmpNo()))); 
              oParameters1.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
              oParameters1.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
              oParameters1.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
              
                oOutArray1 = oBean1.callProc(oParameters1,"pkg_payroll_misc.proc_chkExistReimbursReq(?,?,?,?,?,?,?,?)",true,true);     
          
             
              DBObject oOutObject1 = (DBObject)oOutArray1.get(0);
              DBObject oErrObject1 = (DBObject)oOutArray1.get(1);
              Integer errCode1 = (Integer)((DBObject)oOutArray1.get(2)).getObject();
              System.out.println("Error!!! Following is the description ::"+errCode1);
              if( ! errCode1.equals(new Integer(0)))
              {
                    ArrayList oArguments = new ArrayList();
                    oArguments.add(new String((String)oErrObject1.getObject()));
                    System.out.println("Error!!! while inserting Over & Above ::"+oErrObject1.getObject());
                    throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
              }     
    }
   
            //oParameters = new ArrayList();     
            /* Employee Header Info */   
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtBillAgst())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtDpndntId())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtPayCode())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtClaimAmt())));   
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtDedIT())));  
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtAgency())));    
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtAgencySiteCode())));    
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpMediBillsHeaderBean.getTxtBillDate())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpMediBillsHeaderBean.getTxtFileDate())));            
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtRemark())));      
            oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtITDedAmt())));
            oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtClaimAmt())));
            oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtStartDate())));//added by sonia on 22-11-2011
            oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtEndDate())));//added by sonia on 22-11-2011
            oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getTxtSiteID())));
             if(payCode==200)
              {
                      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getQuarter())));  // added by devendra on 8 sept 2010
                      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsHeaderBean.getFinYear()))); // added by devendra on 8 sept 2010 
              }
              else
              {
                      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String("")));  // added by devendra on 8 sept 2010
                      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); // added by devendra on 8 sept 2010 
              }
            oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(22,DBObject.OUT,ParameterTypes.INTEGER));
      
            //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertEmpMedicalClaim(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true); // commented by devendra on 8th sept 2010    
            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertEmpMedicalClaim(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true); 
         
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            DBObject oErrObject = (DBObject)oOutArray.get(1);
            Integer errCode = (Integer)((DBObject)oOutArray.get(2)).getObject();
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
  
/// added by sonia on 15-11-2011

private void checkDependentDtls(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
	ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oArguments = new ArrayList(); 
    
    
   
      EmpMediBillsHeaderBean oEmpMediBillsHeaderBean = (EmpMediBillsHeaderBean)oBaseHeaderBean;
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oEmpMediBillsHeaderBean.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oEmpMediBillsHeaderBean.getTxtStartDate()));  
	  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oEmpMediBillsHeaderBean.getTxtEndDate()));  
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oEmpMediBillsHeaderBean.getTxtDpndntNam()));  //added by geetika
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
	  
    oParameters=null;
  }
  //end by sonia on 15-11-2011
private void checkEmpPayCodeMap(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
	   ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     ArrayList oOutArray; //Output
     ArrayList oRetList;
     QueryRow oRow = null;
     Iterator oIt = null;
    
    EmpMediBillsHeaderBean oEmpMediBillsHeaderBean = (EmpMediBillsHeaderBean)oBaseHeaderBean;
      
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oEmpMediBillsHeaderBean.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oEmpMediBillsHeaderBean.getTxtPayCode()));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));       
	  oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.proc_emppaycodechk(?,?,?,?)",true,true);                 
    Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
    String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() != 0)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Payroll.EmpMedical.EmpPayCodeChk",oArguments));
        }
   
  }
  //end by sonia on 15-11-2011


  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }


  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oList = new ArrayList();
    checkEmpPayCodeMap(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList); 
    checkYrEndRemittance(oBaseHeaderBean,oList);
    reportError(oList);
    checkDependentDtls(oBaseHeaderBean,oDetailBeanArray,oList);
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
        EmpMediBillsHeaderBean oEmpMediBillsHeaderBean = (EmpMediBillsHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oEmpMediBillsHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oEmpMediBillsHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oEmpMediBillsHeaderBean.getTxtSiteID())));
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

  public EmpMediBillsComboVO getEmpMediBillsComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    EmpMediBillsComboVO oEmpMediBillsComboVO = new EmpMediBillsComboVO();
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
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_MediBill_PayCodeLOV(?,?)");

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
    oEmpMediBillsComboVO.setPayCodeList(oPayCode);
    return oEmpMediBillsComboVO;
  }
  
  public RecordMetaInfo getEmpMediBillsHeaderMetaInfo(EmpMediBillsQueryVO oEmpMediBillsQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    
    //String screenName=oEmpMediBillsQueryVO.getScreenName();

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpMediBillsQueryVO.getLoginLocCode())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getTxtPayCode())));
    if(oEmpMediBillsQueryVO.getQuarter()!=null)
    {
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getQuarter()))); // added by devendra on 8 sept 2010
    }
    else
    {
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); // added by devendra on 8 sept 2010
    }
    
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getFinYear()))); // added by devendra on 8 sept 2010
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetMedicalClaimHdrCnt(?,?,?,?,?,?,?)"); // commented by devendra on 8th sept 2010
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetMedicalClaimHdrCnt(?,?,?,?,?,?,?,?,?)"); // added by devendra on 8th sept 2010
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;
    
  }

  public ArrayList getEmpMediBillsHeader(EmpMediBillsQueryVO oEmpMediBillsQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpMediBillsQueryVO == null)
    {
      oEmpMediBillsQueryVO = new EmpMediBillsQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();                 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpMediBillsQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getTxtEmpNo())));    
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oEmpMediBillsQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, new String(oEmpMediBillsQueryVO.getTxtPayCode()))); 
        if(oEmpMediBillsQueryVO.getQuarter()!=null)
        {
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getQuarter()))); // added by devendra on 8 sept 2010
        }
        else
        {
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); // added by devendra on 8 sept 2010
        }
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpMediBillsQueryVO.getFinYear())));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
     // oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetMedicalClaimHdr(?,?,?,?,?,?,?,?)"); // commented by devendra on 8 sept 2010
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetMedicalClaimHdr(?,?,?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      EmpMediBillsHeaderBean oEmpMediBillsHeaderBean;
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
          oEmpMediBillsHeaderBean = new EmpMediBillsHeaderBean();       
          oEmpMediBillsHeaderBean.setHeaderPrimaryKey(oRow.get("emp_medical_claim_id").getString());                                           
          oEmpMediBillsHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());                                           
          oEmpMediBillsHeaderBean.setTxtEmpName(oRow.get("empName").getString());
          oEmpMediBillsHeaderBean.setTxtDpndntNam(oRow.get("dependent_name").getString());
          oEmpMediBillsHeaderBean.setTxtBillAgst(oRow.get("bill_against").getString());
          oEmpMediBillsHeaderBean.setTxtClaimAmt(oRow.get("claim_amnt").getString());
          oEmpMediBillsHeaderBean.setTxtAgencyName(oRow.get("agency_code_desc").getString());
          oEmpMediBillsHeaderBean.setTxtAgencySite(oRow.get("agency_site_desc").getString());
          oEmpMediBillsHeaderBean.setTxtDedIT(oRow.get("taxable").getString());
          oEmpMediBillsHeaderBean.setTxtInvID(oRow.get("invoice_num").getString());
          oEmpMediBillsHeaderBean.setTxtBillDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("bill_date").getDate()));        
          oEmpMediBillsHeaderBean.setTxtFileDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("file_date").getDate()));        
          oEmpMediBillsHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
          //oEmpMediBillsHeaderBean.setHdnPayYYMM(oRow.get("pay_yymm").getString());
          oEmpMediBillsHeaderBean.setTxtRemark(oRow.get("remarks").getString());
          oEmpMediBillsHeaderBean.setTxtITDedAmt(oRow.get("IT_DEDUCT").getString());
          oEmpMediBillsHeaderBean.setTxtNetAmt(oRow.get("NET_AMOUNT").getString());
          oEmpMediBillsHeaderBean.setQuarter(oRow.get("QUARTER").getString());// added by devendra on 8 sept 2010
          oEmpMediBillsHeaderBean.setFinYear(oRow.get("FIN_YR").getString()); // added by devendra on 8 sept 2010
          oEmpMediBillsHeaderBean.setTxtStartDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("FROM_DATE").getDate()));// added by sonia on 22 nov 2011
          oEmpMediBillsHeaderBean.setTxtEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("TO_DATE").getDate()));// added by sonia on 22 nov 2011
          
          oHeaderList.add(oEmpMediBillsHeaderBean);
      }              
    return oHeaderList;
  } 

  public LovVO getEmpMediBillsLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code");
    arylstHeaderNames.add("IT Flag");
    
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
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_MedicalClaimEmpLOV(?,?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("MARCH_FLAG").getString());
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getEmpMediBillsLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code");
    arylstHeaderNames.add("IT Flag");
    
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
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_MedicalClaimEmpLOVQ(?,?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField4(oRow.get("MARCH_FLAG").getString());
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getEmpDependentLov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
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
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpDependentLOV(?,?,?,?)");
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
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }  
  
  public String sendEmpMediBillsInv(String oEmpMediBillsId,String hdnEmpLbrFlag,long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oEmpMediBillsId));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.Proc_MedicalClaimInvoice(?,?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());    
    String sRetMsg=errCode.toString()+","+errMsg;   
    
    return sRetMsg;
    
  }
  
  public String  EmpMediBillsCancelInv(EmpMediBillsQueryVO oEmpMediBillsQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    String msg=null;
  
    if(oEmpMediBillsQueryVO == null)
    {
      oEmpMediBillsQueryVO = new EmpMediBillsQueryVO();
    }
    
   
    
    String screenName=oEmpMediBillsQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    ArrayList oList = new ArrayList();  
    

    
    oParameters = new ArrayList();
    
       
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpMediBillsQueryVO.getTxtEmpNo()))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpMediBillsQueryVO.getTxtInvID()))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oEmpMediBillsQueryVO.getScreenName()))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpMediBillsQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oEmpMediBillsQueryVO.getUserId()))));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_cancel_othr_pymnt_inv.proc_cancel_op_invoices(?,?,?,?,?,?,?)",true,true);
    
   //   DBObject oErrObject = (DBObject)oOutArray.get(0);
       
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());    
    String sRetMsg=errMsg;   
    
    return sRetMsg;
  }
  
}