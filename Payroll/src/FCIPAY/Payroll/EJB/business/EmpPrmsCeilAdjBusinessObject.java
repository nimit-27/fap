/*
 * Name             :   EmpPrmsCeilAdjBusinessObject.java
 * 
 * Creation Date    :   14-March-2020
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjHistoryDetailParm;

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
import FCIPAY.Payroll.UTILITY.EmpPrmsCeilAdjHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjQueryVO;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipBean;
import FCIPAY.Payroll.UTILITY.EmpPrmsCeilAdjBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;


public class EmpPrmsCeilAdjBusinessObject extends BaseBO
{
  public EmpPrmsCeilAdjBusinessObject()
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
}

    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    ArrayList oParameters1 = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
     DBUtilitiesBean oBean1 = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    int i=0;
    EmpPrmsCeilAdjHeaderBean oEmpPrmsCeilAdjHeaderBean = (EmpPrmsCeilAdjHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtEmpNum())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtFinYear())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtAdjAmt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtAdjType())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHeaderBean.getTxtRemarks())));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
      
      oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_insert_prms_ceil_adj(?,?,?,?,?,?,?,?,?,?,?)",true,true);

        DBObject oOutObject;
        oOutObject = (DBObject)oOutArray.get(0);
        DBObject oErrObject;
        oErrObject = (DBObject)oOutArray.get(1);
        Integer errCode;
        errCode = (Integer)((DBObject)oOutArray.get(2)).getObject();
        System.out.println("Error!!! while inserting Over & Above Details ::"+errCode);
                  if( ! errCode.equals(new Integer(0)))
                  {
                     ArrayList oArguments = new ArrayList();
                     oArguments.add(new String((String)oErrObject.getObject()));
                     System.out.println("Error!!! while inserting Over & Above ::"+oErrObject.getObject());
                     throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
                  }     
                  
                  return (String)oOutObject.getObject();
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }


  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oList = new ArrayList();
    reportError(oList); 
    reportError(oList);
    reportError(oList);    
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }
  public RecordMetaInfo getEmpPrmsCeilAdjHeaderMetaInfo(EmpPrmsCeilAdjQueryVO oEmpPrmsCeilAdjQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output
    

    oParameters = new ArrayList();   
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjQueryVO.getTxtEmpNum())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_getprmsCeilAdjhdrcnt(?,?,?,?,?)"); 
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;
    
  }

  public ArrayList getEmpPrmsCeilAdjHeader(EmpPrmsCeilAdjQueryVO oEmpPrmsCeilAdjQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpPrmsCeilAdjQueryVO == null)
    {
      oEmpPrmsCeilAdjQueryVO = new EmpPrmsCeilAdjQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();                 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));  
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjQueryVO.getTxtEmpNum())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_getPrmsCeilAdjhdr(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      EmpPrmsCeilAdjHeaderBean oEmpPrmsCeilAdjHeaderBean;
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
          oEmpPrmsCeilAdjHeaderBean = new EmpPrmsCeilAdjHeaderBean();       
          oEmpPrmsCeilAdjHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());                                           
          oEmpPrmsCeilAdjHeaderBean.setTxtEmpNum(oRow.get("EMP_NUM").getString());                                           
          oEmpPrmsCeilAdjHeaderBean.setTxtEmpName(oRow.get("empName").getString());
          oEmpPrmsCeilAdjHeaderBean.setTxtEmpCat(oRow.get("emp_category").getString());
          oEmpPrmsCeilAdjHeaderBean.setTxtCpfCode(oRow.get("cpf_code").getString());
          oEmpPrmsCeilAdjHeaderBean.setTxtSepDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));        
          oEmpPrmsCeilAdjHeaderBean.setTxtSepType(oRow.get("emp_status").getString());
          oEmpPrmsCeilAdjHeaderBean.setTxtEmpDsgn(oRow.get("dsgn_desc").getString());
          oEmpPrmsCeilAdjHeaderBean.setTxtAdjType(oEmpPrmsCeilAdjQueryVO.getTxtAdjType());  
          oEmpPrmsCeilAdjHeaderBean.setTxtFinYear(oEmpPrmsCeilAdjQueryVO.getTxtFinYear());  

          oHeaderList.add(oEmpPrmsCeilAdjHeaderBean);
      }              
    return oHeaderList;
  } 

  public LovVO getEmpPrmsCeilAdjLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
      arylstHeaderNames.add("Employee No");    
      arylstHeaderNames.add("Employee Name");   
      arylstHeaderNames.add("CPF Code");     
      arylstHeaderNames.add("Category"); 
      arylstHeaderNames.add("Emp Status");         
      arylstHeaderNames.add("Designation");  
      arylstHeaderNames.add("Retirement Date"); 
      arylstHeaderNames.add("IT Flag");


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
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID")).trim()));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_Prmsemplov(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("emp_name").getString());            
        oLOVBean.setDetailField3(oRow.get("cpf_code").getString());
        oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString()); 
        oLOVBean.setDetailField5(oRow.get("category").getString());            
        oLOVBean.setDetailField6(oRow.get("emp_status").getString());                       
        oLOVBean.setDetailField7(EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
        oLOVBean.setDetailField8(oRow.get("MARCH_FLAG").getString());
    
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getEmpPrmsCeilAdjLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID")).trim()));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_Prmsemplovq(?,?,?,?,?,?,?)");
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
  
  
    public RecordMetaInfo getEmpPrmsCeilAdjDetailMetaInfo(String sPrmaryKey,EmpPrmsCeilAdjHistoryDetailParm oEmpPrmsCeilAdjHistoryDetailParm) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        ArrayList oOutArray; //Output 
    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrmaryKey)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHistoryDetailParm.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_getprmsCeilAdjhdrcnt(?,?,?,?,?)");
          
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        oParameters=null;
        oOutArray=null;
        oBean=null;
        oTimeObject=null;
        oTotalRecord=null;
        return oRecordMetaInfo;

    }

    public ArrayList getEmpPrmsCeilAdjDetail(String sPrimaryKey,EmpPrmsCeilAdjHistoryDetailParm oEmpPrmsCeilAdjHistoryDetailParm,long lStartPosition,long lLastPosition) throws EnrgiseSystemException,EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
    
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHistoryDetailParm.getTxtFinYear())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPrmsCeilAdjHistoryDetailParm.getTxtAdjType())));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PRMS.PROC_GET_PRMS_ADJ_DETAILS(?,?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          EmpPrmsCeilAdjBean oEmpPrmsCeilAdjBean;
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
              oEmpPrmsCeilAdjBean = new EmpPrmsCeilAdjBean();
              oEmpPrmsCeilAdjBean.setTxtFinY(oRow.get("FIN_YEAR").getString());
              oEmpPrmsCeilAdjBean.setTxtOpeningBal(oRow.get("OPENING_BALANCE").getString());
              oEmpPrmsCeilAdjBean.setTxtAdjustBal(oRow.get("ADJ_AMT").getString());
              oEmpPrmsCeilAdjBean.setTxtAdjustMode(oRow.get("PAY_MODE").getString());
              oEmpPrmsCeilAdjBean.setTxtClaimAmout(oRow.get("CLOSING_BALANCE").getString());
              //oEmpPrmsCeilAdjBean.setTxtAdjustDate(oRow.get("CREATED_TIMESTAMP").getString());
              oEmpPrmsCeilAdjBean.setTxtAdjustDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("CREATED_TIMESTAMP").getDate()));
              oEmpPrmsCeilAdjBean.setTxtUserId(oRow.get("CREATED_USER_ID").getString());

              oEmpPrmsCeilAdjBean.setStatus("Q");
              oHeaderList.add(oEmpPrmsCeilAdjBean);
              oRow = null;
              oEmpPrmsCeilAdjBean = null;
          }  
       oParameters=null;
       oOutArray=null;
       oIt=null;
       oEmpPrmsCeilAdjBean=null;
       oBean=null;
       oList = null;
       oOutObject=null;
       return oHeaderList;
    }
    
}
