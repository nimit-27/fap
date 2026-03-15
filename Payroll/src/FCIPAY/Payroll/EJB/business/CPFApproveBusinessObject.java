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
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFApprQueryVO;
import FCIPAY.Payroll.UTILITY.CPFApprHeaderBean;
import FCIPAY.Payroll.UTILITY.CPFApproveBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFApprDetailInfo;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFApprQueryVO;

public class CPFApproveBusinessObject extends BaseBO 
{
  public CPFApproveBusinessObject()
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

  public RecordMetaInfo getCPFApprHeaderMetaInfo(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    CPFApprQueryVO oCPFApprQueryVO = (CPFApprQueryVO)oQueryVO;
    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFApprQueryVO.getTxtEmpNo()));      
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprQueryVO.getTxtAppvSts())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprQueryVO.getTxtUnitCode())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oCPFApprQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.proc_getCPFApprHeaderCount(?,?,?,?,?,?,?)");

    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;
  }

  public ArrayList getCPFApprHeader(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    CPFApprQueryVO oCPFApprQueryVO = (CPFApprQueryVO)oQueryVO;
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oCPFApprQueryVO.getTxtEmpNo()));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprQueryVO.getTxtAppvSts())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprQueryVO.getTxtUnitCode())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(oCPFApprQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.proc_getCPFApprHeader(?,?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    CPFApprHeaderBean oHeaderBeanObject;
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
        oHeaderBeanObject = new CPFApprHeaderBean();
        oHeaderBeanObject.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oHeaderBeanObject.setTxtEmpName(oRow.get("EMP_NAME").getString());
        oHeaderBeanObject.setTxtCPFCode(oRow.get("CPF_CODE").getString());
        oHeaderBeanObject.setTxtUnitCode(oRow.get("pres_location_code").getString());
        oHeaderBeanObject.setTxtUnitDesc(oRow.get("loc_desc").getString());
        oHeaderBeanObject.setTxtAppvSts(oRow.get("APPR_STATUS").getString());
        oHeaderList.add(oHeaderBeanObject);
    }           
    return oHeaderList;
  }

  public RecordMetaInfo getCPFApprDetailMetaInfo(String sPrimaryKey, CPFApprDetailInfo oCPFApprDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    ArrayList oParameters; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCPFApprDetailInfo.getTxtEmpNo()));      
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprDetailInfo.getTxtAppvSts())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprDetailInfo.getTxtUnitCode())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oCPFApprDetailInfo.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.proc_CountCPFApprDetail(?,?,?,?,?,?,?)");
      
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    return oRecordMetaInfo;
  }
  
  public ArrayList getCPFApprDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, CPFApprDetailInfo oCPFApprDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList(); //Input Parameters
    
    int count = 0;
    ArrayList oOutArray; //Output 
    CPFApproveBean oCPFApproveBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDtlList = null;
      
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oCPFApprDetailInfo.getTxtEmpNo()));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprDetailInfo.getTxtAppvSts())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oCPFApprDetailInfo.getTxtUnitCode())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(oCPFApprDetailInfo.getLoginLocCode())));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.proc_CPFApprDetail(?,?,?,?,?,?,?,?)");
  
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
        oDtlList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oCPFApproveBean = new CPFApproveBean();
      oCPFApproveBean.setTxtSrNo(count);
      oCPFApproveBean.setTxtApprId(oRow.get("CPF_APPROVE_ID").getString()); 
      oCPFApproveBean.setTxtEmpNo1(oRow.get("EMP_NUM").getString()); 
      oCPFApproveBean.setTxtEmpName1((oRow.get("EMP_NAME").getString()));
      oCPFApproveBean.setStatus("Q");
      oCPFApproveBean.setTxtPOP(oRow.get("loc_desc").getString());
      oCPFApproveBean.setTxtFpsNum(oRow.get("fps_num").getString());
      oCPFApproveBean.setTxtOldCpf(oRow.get("old_cpf_code").getString());
      oCPFApproveBean.setTxtNewCpf(oRow.get("new_cpf_code").getString());
      oCPFApproveBean.setTxtRequester(oRow.get("REQUESTER").getString());
      oCPFApproveBean.setTxtReqDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("req_init_date").getDate()));
      oCPFApproveBean.setTxtReqReason(oRow.get("reason").getString());
      oCPFApproveBean.setTxtAppvSts1(oRow.get("APPR_STATUS").getString());
      oCPFApproveBean.setTxtRemark(oRow.get("REMARK").getString());
      oCPFApproveBean.setTxtReqZone(oRow.get("REQUESTED_ZONE").getString());
      oCPFApproveBean.setTxtReqZoneDesc(oRow.get("REQUESTED_ZONE_DESC").getString());
      oCPFApproveBean.setTxtReqGenFrm(oRow.get("SCREEN_NAME").getString());
      oCPFApproveBean.setTxtApprDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("APPROVAL_DATE").getDate()));
      oDtlList.add(oCPFApproveBean);
    }
    
    return oDtlList;
    
  }
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }

  public void approveRecord(CPFApprHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      boolean bInsert = false;
      boolean bUpdate = false;
      boolean bDelete = false;
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = null;
      DBUtilitiesBean oBeanInsert = null;
      DBUtilitiesBean oBeanDelete = null;
      oBean = new DBUtilitiesBean();
      ArrayList oOutArray;
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        CPFApproveBean oUserBean = (CPFApproveBean)oIt.next();
        if(oUserBean.getItemChecked().equals("Y") && oUserBean.getTxtReqGenFrm().equals("Z"))
        {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtReqZone())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));   
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));   
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.PROC_VALIDATE_APPROVAL(?,?,?,?,?)",true,true);
            Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
            if(errcode.intValue() != 0)
            {
                String errmsg = (String)((DBObject)oOutArray.get(0)).getObject();
                ArrayList oArguments = new ArrayList();
                oArguments.add(new String(errmsg));
                throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);                                    
            }
        }
      }
    oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        CPFApproveBean oUserBean = (CPFApproveBean)oIt.next();
        if(oUserBean.getItemChecked().equals("Y"))
        {
            if(!bUpdate)
            {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("APPS.FCI_PKG_CR_161.PROC_ApproveRecord(?,?,?,?,?,?,?,?)");
                bUpdate = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtApprId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEmpNo1())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtNewCpf())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtFpsNum())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtReqZone())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRemark())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oBean.addToBatch(oParameters);
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
        e.printStackTrace();
    }
  }
  
  public void rejectRecord(CPFApprHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        boolean bInsert = false;
        boolean bUpdate = false;
        boolean bDelete = false;
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = null;
        DBUtilitiesBean oBeanInsert = null;
        DBUtilitiesBean oBeanDelete = null;
        oBean = new DBUtilitiesBean();
        ArrayList oOutArray;
        Iterator oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
            CPFApproveBean oUserBean = (CPFApproveBean)oIt.next();
            if(oUserBean.getItemChecked().equals("Y") && oUserBean.getTxtReqGenFrm().equals("Z"))
            {
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtReqZone())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));   
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));   
                oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
                oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
                oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.PROC_VALIDATE_APPROVAL(?,?,?,?,?)",true,true);
                Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
                if(errcode.intValue() != 0)
                {
                    String errmsg = (String)((DBObject)oOutArray.get(0)).getObject();
                    ArrayList oArguments = new ArrayList();
                    oArguments.add(new String(errmsg));
                    throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);                                    
                }
            }
        }
        
        oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
            CPFApproveBean oUserBean = (CPFApproveBean)oIt.next();
            if(oUserBean.getItemChecked().equals("Y"))
            {
                if(!bUpdate)
                {
                    oBean = new DBUtilitiesBean();
                    oBean.createBatch("APPS.FCI_PKG_CR_161.PROC_rejectRecord(?,?,?,?,?,?)");
                    bUpdate = true;
                }
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtApprId())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtEmpNo1())));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtNewCpf())));
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRemark())));
                oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
                oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
                oBean.addToBatch(oParameters);
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
         e.printStackTrace();
      }
  }
  public LovVO getCPFApprovalLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames = new ArrayList();
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
    oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.PROC_getCPFApprovalLOVDataQ(?,?,?,?,?,?)");
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
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oList.add(oLOVBean);
    }
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getCPFApprovalUnitLOVQ(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("LocId");   
    arylstHeaderNames.add("LocDesc");   
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS.FCI_PKG_CR_161.PROC_GetCPFApprovalUnitLOVQ(?,?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("loc_id").getString());            
      oLOVBean.setDetailField2(oRow.get("loc_desc").getString());            
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

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
    return null;
  }

  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

}