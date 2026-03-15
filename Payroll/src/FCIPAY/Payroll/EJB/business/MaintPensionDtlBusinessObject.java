package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailInfo;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPCDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPCDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPcDtlComboVO;
import FCIPAY.Payroll.UTILITY.MaintPCDetailHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintPfDetailBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPfDtlComboVO;
import FCIPAY.Payroll.UTILITY.MaintPCDetailBean;
import FCIPAY.Payroll.UTILITY.MaintPFDetailHeaderBean;
import FCIPAY.Payroll.UTILITY.PensionAdjustHistoryBean;
import FCIPAY.Payroll.UTILITY.PensionAdjustHistoryBeanDtl;
import FCIPAY.Payroll.UTILITY.PfAdjustHistoryBean;
import FCIPAY.Payroll.UTILITY.PfAdjustHistoryBeanDtl;
public class MaintPensionDtlBusinessObject extends BaseBO 
{
  public MaintPensionDtlBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("PcDetailScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public RecordMetaInfo getPensionHeaderMetaInfo(MaintPCDetailQueryVO oMaintPCDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintPCDetailQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailQueryVO.getTxtFromYear())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_getPensiondtlcount(?,?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;    
  }

  public ArrayList getPensionHeader(MaintPCDetailQueryVO oMaintPCDetailQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintPCDetailQueryVO == null)
    {
      oMaintPCDetailQueryVO = new MaintPCDetailQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintPCDetailQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailQueryVO.getTxtFromYear())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_getPensiondtldetail(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintPCDetailHeaderBean oMaintPCDetailHeaderBean;
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
          oMaintPCDetailHeaderBean = new MaintPCDetailHeaderBean();
          oMaintPCDetailHeaderBean.setTxtEmpNo(oRow.get("emp_num").getString());
          oMaintPCDetailHeaderBean.setTxtEmpName(oRow.get("name").getString());
          oMaintPCDetailHeaderBean.setTxtPFAcctNo(oRow.get("cpf_code").getString());
          oMaintPCDetailHeaderBean.setTxtFromYear(oRow.get("from_year").getString());
          oMaintPCDetailHeaderBean.setTxtToYear(oRow.get("to_year").getString()); 
          oMaintPCDetailHeaderBean.setTxtPensionId(oRow.get("emp_pension_id").getString());           
        
          oMaintPCDetailHeaderBean.setTxtEmpOpnConPc(oRow.get("employee_pc_open_bal").getString());                    
          oMaintPCDetailHeaderBean.setTxtEmprOpnConPc(oRow.get("employer_pc_open_bal").getString());                    
          oMaintPCDetailHeaderBean.setTxtVolOpnPc(oRow.get("VPC_OPEN_BAL").getString());                    
          oMaintPCDetailHeaderBean.setTxtVolCloPc(oRow.get("VPC_CLOSE_BAL").getString()); 
          oMaintPCDetailHeaderBean.setTxtEmpCloConPc(oRow.get("employee_pf_close_bal").getString());                    
          oMaintPCDetailHeaderBean.setTxtEmprCloConPc(oRow.get("employer_pf_close_bal").getString()); 
          
          oMaintPCDetailHeaderBean.setTxtEmpIntQ1(oRow.get("employee_pc_int_q1").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmpIntQ2(oRow.get("employee_pc_int_q2").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmpIntQ3(oRow.get("employee_pc_int_q3").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmpIntQ4(oRow.get("employee_pc_int_q4").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmpIntAnn(oRow.get("employee_pc_int_ann").getString());                              

          oMaintPCDetailHeaderBean.setTxtEmprIntQ1(oRow.get("employer_pc_int_q1").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmprIntQ2(oRow.get("employer_pc_int_q2").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmprIntQ3(oRow.get("employer_pc_int_q3").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmprIntQ4(oRow.get("employer_pc_int_q4").getString());                              
          oMaintPCDetailHeaderBean.setTxtEmprIntAnn(oRow.get("employer_pc_int_ann").getString());                                    

          oMaintPCDetailHeaderBean.setTxtVolInPCQ1(oRow.get("VPC_int_q1").getString());                              
          oMaintPCDetailHeaderBean.setTxtVolInPCQ2(oRow.get("VPC_int_q2").getString());                              
          oMaintPCDetailHeaderBean.setTxtVolInPCQ3(oRow.get("VPC_int_q3").getString());                              
          oMaintPCDetailHeaderBean.setTxtVolInPCQ4(oRow.get("VPC_int_q4").getString());                              
          oMaintPCDetailHeaderBean.setTxtVolInPCQAnn(oRow.get("VPC_int_ann").getString()); 
          oHeaderList.add(oMaintPCDetailHeaderBean);
      }
    return oHeaderList;
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    
  if(sScreenName.equals("PcDetailScreen"))
    {
        savePCDtl(sHeaderPrimaryKey,oDetailBeanArray,(MaintPCDetailHeaderBean)oBaseHeaderBean);
    }
  }   

  private void savePCDtl(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,MaintPCDetailHeaderBean oMaintPCDetailHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBean1 = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintPCDetailBean oMaintPCDetailBean = (MaintPCDetailBean)oIt.next();
      
      }
//adding detail history
    ArrayList oOutArray = new ArrayList();
    oParameters = new ArrayList();
    oBean1 = new DBUtilitiesBean();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtFromYear())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtYYMMDtl())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtAdjTypeDtl())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtPayModeDtl())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtAdjAmtDtl())));      
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtRmrkDtl())));      
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean1.callProc(oParameters,"pkg_pension_adjustment.INSERT_PAY_EMP_PNSN_DTL_ADJ(?,?,?,?,?,?,?,?,?,?,?)",true,true);
      DBObject oOutObject = (DBObject)oOutArray.get(1);
      Integer errCode = (Integer)(oOutObject.getObject());
      
      oOutObject = (DBObject)oOutArray.get(0);
      String errMsg = (String)(oOutObject.getObject());
        if(!errCode.equals(new Integer(0)))
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(errMsg);
              throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
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


  public LovVO getPensionDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Cpf Code");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_getPensiondetaillov(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("CPC_CODE").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getQueryPensionDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Cpf Code");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_queryPensiondetailLOV(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
   
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
        checkMandatoryDetail(oBaseHeaderBean);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    checkPCDtlHeader(oBaseHeaderBean,oList);
    reportError(oList);   
  }

 private void checkPCDtlHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    ArrayList oRetList = null;
    
      MaintPCDetailHeaderBean  oMaintPCDetailHeaderBean  = (MaintPCDetailHeaderBean)oBaseHeaderBean;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtFromYear())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_checkmandatorydtls(?,?,?,?)");
  
       oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oRetList.size() <= 0)
        {        
          ArrayList oArguments = new ArrayList();
          oList.add(new EnrgiseApplicationException("Payroll.PCEmpNoFromYr.PensionCheck",EnrgiseConstants.MESSAGE));
        }
  }
 
public RecordMetaInfo getPensionDetailMetaInfo(String sPrimaryKey,MaintPCDetailInfo oMaintPCDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

        String sEmpNo;
        String sFromYear;
        sEmpNo = oMaintPCDetailInfo.getTxtEmpNo(); 
        sFromYear = oMaintPCDetailInfo.getTxtFromYear(); 
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sEmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sFromYear));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_getpensiondetailcount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }

 public ArrayList getPensionDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,MaintPCDetailInfo oMaintPCDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPCDetailBean oPCDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPCDetail = null;
    String sEmpNo;
   String sFromYear;
   sEmpNo = oMaintPCDetailInfo.getTxtEmpNo(); 
   sFromYear = oMaintPCDetailInfo.getTxtFromYear(); 
    
   oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sEmpNo));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sFromYear));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintPCDetailInfo.getSiteId())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_getPensiondetail(?,?,?,?,?,?,?)");
  
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
        oPCDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oPCDtl = new MaintPCDetailBean();
        oPCDtl.setTxtYearMon(oRow.get("YYYYMM").getString());
        oPCDtl.setTxtEmpSub(oRow.get("EMPLOYEE_SUBS").getString());
        oPCDtl.setTxtEmpCon(oRow.get("EMPLOYER_CONT").getString());
        oPCDtl.setTxtVolPc(oRow.get("VPC").getString());
        oPCDtl.setTxtArrEmp(oRow.get("EMP_ARREAR").getString());
        oPCDtl.setTxtArrEmpr(oRow.get("EMPR_ARREAR").getString());
        oPCDtl.setTxtRemDate(EnrgiseUtil.convertToString(oRow.get("REMIT_DATE").getDate()));
        oPCDtl.setTxtNoOfDays(oRow.get("NO_OF_DAYS").getString());
        oPCDtl.setStatus("Q");
        oPCDetail.add(oPCDtl);
    }             
    return oPCDetail; 
  }    


public LovVO getPensionFromYrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("FromYear");    
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
      oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_GetPensionFromYrLov(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("from_year").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public MaintPcDtlComboVO getPensionDetailCombo() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    MaintPcDtlComboVO oMaintPcDtlComboVO = new MaintPcDtlComboVO();
    int count = 0;
    ArrayList oOutArray; //Output

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ComboVO oComboVO = null;

    oList = new ArrayList();
    oList = getComboRecords("pkg_pension_adjustment.proc_Pension_Adjust_Hdr_Combo(?,?)","gbl_code","code_desc");
    oMaintPcDtlComboVO.setAdjPensionHdrList(oList);
    
    oList = new ArrayList();
    oList = getComboRecords("pkg_pension_adjustment.proc_Pension_Adjust_Dtl_Combo(?,?)","gbl_code","code_desc");
    oMaintPcDtlComboVO.setAdjPensionDtlList(oList);
    
    return oMaintPcDtlComboVO;
  }
  
  private ArrayList getComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
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

    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;
      MaintPCDetailHeaderBean oMaintPCDetailHeaderBean = (MaintPCDetailHeaderBean)oBaseHeaderBean;
      ArrayList oOutArray;  
      oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtFromYear())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtToYear())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpOpnConPc())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpIntQ1())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpIntQ2())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpIntQ3())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpIntQ4())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpIntAnn())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmpCloConPc())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmprOpnConPc())));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmprCloConPc())));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmprIntQ1())));
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmprIntQ2())));
        oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmprIntQ3())));
        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmprIntQ4())));
        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtEmprIntAnn())));
        oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtVolOpnPc())));
        oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtVolCloPc())));
        oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtVolInPCQ1())));
        oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtVolInPCQ2())));
        oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtVolInPCQ3())));
        oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtVolInPCQ4())));
        oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtVolInPCQAnn())));
        oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtAdjTypeHdr())));
        oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtPayMode())));
        oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtAdjAmtHdr())));
        oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtQuarterHdr())));
        oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtRmrkHdr())));
        oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPCDetailHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(32,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(33,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_updatepensionhdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
        DBObject oOutObject = (DBObject)oOutArray.get(1);
        Integer errCode = (Integer)(oOutObject.getObject());
        
        oOutObject = (DBObject)oOutArray.get(0);
        String errMsg = (String)(oOutObject.getObject());
        if(!errCode.equals(new Integer(0)))
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(errMsg);
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        }
    }
    public ArrayList getPcAdjustHistoryHdr(MaintPCDetailQueryVO oMaintPCDetailQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters = new ArrayList();
        ArrayList oOutArray;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        QueryRow oRow = null;    
        int count = 0;
        PensionAdjustHistoryBean oPensionAdjustHistoryBean;
        ArrayList adjHistList = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPCDetailQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPCDetailQueryVO.getTxtFromYear())));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_get_pay_emp_pnsn_hdr_adj(?,?,?,?)");
        
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {
            return null;
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
            if(count == 0)
            {
                adjHistList = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();
            oPensionAdjustHistoryBean = new PensionAdjustHistoryBean();
            oPensionAdjustHistoryBean.setTxtAdjHdrId((oRow.get("Pension_HDR_ID").getString()));
            oPensionAdjustHistoryBean.setTxtAdjTypeHdr1((oRow.get("CODE_DESC").getString()));
            oPensionAdjustHistoryBean.setTxtPayMode1((oRow.get("PAY_MODE").getString()));
            oPensionAdjustHistoryBean.setTxtAdjAmtHdr1((oRow.get("ADJUST_AMT").getString()));
            oPensionAdjustHistoryBean.setTxtQuarterHdrl((oRow.get("QUARTER").getString()));
            oPensionAdjustHistoryBean.setTxtRmrkHdr1((oRow.get("REMARK").getString()));
            oPensionAdjustHistoryBean.setTxtModDtHdr((oRow.get("MODIFIED_DT").getString()));
            adjHistList.add(oPensionAdjustHistoryBean);
        }             
        return adjHistList; 
    }
    public ArrayList getPcAdjustHistoryDtl(MaintPCDetailQueryVO oMaintPCDetailQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters = new ArrayList();
        ArrayList oOutArray;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        QueryRow oRow = null;    
        int count = 0;
        PensionAdjustHistoryBeanDtl oPensionAdjustHistoryBeanDtl;
        ArrayList adjHistList = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPCDetailQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPCDetailQueryVO.getTxtFromYear())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPCDetailQueryVO.getTxtYYMMDtl())));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pension_adjustment.proc_get_pay_emp_pnsn_dtl_adj(?,?,?,?,?)");
        
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {
            return null;
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
            if(count == 0)
            {
                adjHistList = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();
            oPensionAdjustHistoryBeanDtl = new PensionAdjustHistoryBeanDtl();
            oPensionAdjustHistoryBeanDtl.setTxtAdjTypeDtl1((oRow.get("CODE_DESC").getString()));
            oPensionAdjustHistoryBeanDtl.setTxtPayModeDtl1((oRow.get("PAY_MODE").getString()));
            oPensionAdjustHistoryBeanDtl.setTxtAdjAmtDtl1((oRow.get("ADJUST_AMT").getString()));
            oPensionAdjustHistoryBeanDtl.setTxtRmrkDtl1((oRow.get("REMARK").getString()));
            oPensionAdjustHistoryBeanDtl.setTxtModDtDtl((oRow.get("modified_dt").getString()));
            adjHistList.add(oPensionAdjustHistoryBeanDtl);
        }             
        return adjHistList; 
    }

    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
        return null;
    }
//Added by arvind
    public String freezePenYrInt(MaintPCDetailQueryVO oMaintPCDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       ArrayList oParameters = new ArrayList(); //Input Parameters
       DBUtilitiesBean oBean = new DBUtilitiesBean();
        if(oMaintPCDetailQueryVO == null)
        {
          oMaintPCDetailQueryVO = new MaintPCDetailQueryVO();
        }
       //MaintainPensionBean oMaintainPensionBean=(MaintainPensionBean)oBaseHeaderBean;
       //checkMonthEnd(oCPFFinalPaymentBean);
       //checkPaidStatus(oCPFFinalPaymentBean);
       ArrayList oOutArray; //Output  
       oParameters = new ArrayList();
       
       oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintPCDetailQueryVO.getTxtQuarter()));
       oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintPCDetailQueryVO.getTxtYr()));
       //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oMaintPCDetailQueryVO.getTxtUserID()));
       //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oMaintPCDetailQueryVO.getTxtSiteID()));
       oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
       oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
       // oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
       //oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.UpdatePFYearEnd(?,?,?,?,?,?,?)",true,true);
       oOutArray = oBean.callProc(oParameters,"pkg_pension_upload.proc_check_freeze_stat(?,?,?,?)",true,true); 
       //DBObject oOutObject = (DBObject)oOutArray.get(1);
       Integer errCode = (Integer)((DBObject)oOutArray.get(0)).getObject();
       
       //oOutObject = (DBObject)oOutArray.get(0);
       String errMsg = (String)(((DBObject)(oOutArray.get(1))).getObject());
       String sRetMsg=errCode.toString()+","+errMsg;
       
       //added by gagan on 18-05-2013
        if(!errCode.equals(new Integer(0)))
         {
           ArrayList oArguments = new ArrayList();
           oArguments.add(sRetMsg);
           System.out.println("Error!!! while getting Int Install ::"+sRetMsg);
           throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         }
         //ended by gagan on 18-05-2013
       
       return sRetMsg;
    }
}
