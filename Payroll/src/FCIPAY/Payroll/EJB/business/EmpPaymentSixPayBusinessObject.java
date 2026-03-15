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

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPaySixQueryVO;
import FCIPAY.Payroll.UTILITY.EmpPaySixHeaderBean;
import FCIPAY.Payroll.UTILITY.EmpPaySixBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPaySixDetailInfo;

public class EmpPaymentSixPayBusinessObject extends BaseBO 
{
  public EmpPaymentSixPayBusinessObject()
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

  public RecordMetaInfo getEmpSixPayHeaderMetaInfo(EmpPaySixQueryVO oEmpPaySixQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oEmpPaySixQueryVO.getTxtEmpNo()));      
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPaySixQueryVO.getTxtYYMM())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPaySixQueryVO.getTxtEffDt())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    
    if (oEmpPaySixQueryVO.getScreenName().equals("EmpSixPayScreen"))
    {
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountEmpSixPayHeader(?,?,?,?,?,?)");
    }
     else 
    {
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountEmpSixPayHeaderSuper(?,?,?,?,?,?)");
    }
    
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;
  }

  public ArrayList getEmpSixPayHeader(EmpPaySixQueryVO oEmpPaySixQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    if(oEmpPaySixQueryVO == null)
    {
      oEmpPaySixQueryVO = new EmpPaySixQueryVO();
    }
   
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oEmpPaySixQueryVO.getTxtEmpNo()));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPaySixQueryVO.getTxtYYMM())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPaySixQueryVO.getTxtEffDt())));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    
     if (oEmpPaySixQueryVO.getScreenName().equals("EmpSixPayScreen"))
    {
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getEmpSixPayHeader1(?,?,?,?,?,?,?)");
    }
     else 
    {
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getEmpSixPayHeader1Super(?,?,?,?,?,?,?)");
    }
    
    
    
   // oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getEmpSixPayHeader1(?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    EmpPaySixHeaderBean oHeaderBeanObject;
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
        oHeaderBeanObject = new EmpPaySixHeaderBean();
        oHeaderBeanObject.setTxtEmpNo(oRow.get("EMP_NUM").getString());
        oHeaderBeanObject.setTxtEmpName(oRow.get("empName").getString());
        oHeaderBeanObject.setTxtDsgn(oRow.get("DSGN_DESC").getString());
        oHeaderBeanObject.setTxtCategDesc(oRow.get("category").getString());
        oHeaderBeanObject.setTxtEmpType(oRow.get("emp_type").getString());
        oHeaderBeanObject.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oHeaderBeanObject.setTxtPresentPOPDesc(oRow.get("loc_desc").getString());
        //oHeaderBeanObject.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("join_date").getDate()));
        oHeaderBeanObject.setTxtEmpStatus(oRow.get("EMP_STATUS").getString());
        oHeaderBeanObject.setTxtPayScale(oRow.get("pay_scale_code").getString());
        oHeaderBeanObject.setTxtYYMM(oRow.get("fin_year").getString());
        oHeaderBeanObject.setTxtEffDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("effective_dt").getDate()));
        oHeaderBeanObject.setChkVhclType(oRow.get("office_vehicle_flag").getString());
        oHeaderBeanObject.setHeaderPrimaryKey(oRow.get("emp_bob_trans_id").getString());
        
        oHeaderBeanObject.setTxtPayCodeAdj(oRow.get("vpay_code").getString());
        oHeaderBeanObject.setTxtPayCodePerc(oRow.get("vpaycode_prcent").getString());
        oHeaderBeanObject.setTxtPercAdj(oRow.get("vadjust_prcnt").getString());
        if (oEmpPaySixQueryVO.getScreenName().equals("EmpSixPayScreenSuperUser"))
        {
            oHeaderBeanObject.setTxtPayRevFlag(oRow.get("pay_rev_flag").getString());
        }
        oHeaderList.add(oHeaderBeanObject);
    }              
    return oHeaderList;
  }

  public RecordMetaInfo getEmpSixPayDetailMetaInfo(String sPrimaryKey, EmpPaySixDetailInfo oEmpPaySixDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    ArrayList oParameters; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
    if(oEmpPaySixDetailInfo.getButtonFlag().equals("IN")) return oRecordMetaInfo;
    
    if(oEmpPaySixDetailInfo.getButtonFlag().equals("SV")) {
        oParameters = new ArrayList();
        ArrayList oOutArray;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oEmpPaySixDetailInfo.getTxtEmpNo()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GentranIdPop_EmpSixPay(?,?,?)",true,true);
        
        DBObject oOutObject=(DBObject)oOutArray.get(0);
        Integer vTran_id = (Integer)oOutObject.getObject();
        sPrimaryKey = vTran_id.toString();
    }

    ArrayList oOutArray; //Output 

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpPaySixDetailInfo.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpPaySixDetailInfo.getTxtYYMM())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPaySixDetailInfo.getTxtEffDt())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountEmpSixPayDetail(?,?,?,?,?,?,?)");
      
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    return oRecordMetaInfo;
  }
  
  public ArrayList getEmpSixPayDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, EmpPaySixDetailInfo oEmpPaySixDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList(); //Input Parameters
    
    if(oEmpPaySixDetailInfo.getButtonFlag().equals("IN")) return null;
    
    if(oEmpPaySixDetailInfo.getButtonFlag().equals("SV")) {
        ArrayList oOutArray;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oEmpPaySixDetailInfo.getTxtEmpNo()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GentranIdPop_EmpSixPay(?,?,?)",true,true);
        
        DBObject oOutObject=(DBObject)oOutArray.get(0);
        Integer vTran_id = (Integer)oOutObject.getObject();
        sPrimaryKey = vTran_id.toString();
    }

    int count = 0;
    ArrayList oOutArray; //Output 
    EmpPaySixBean oEmpPaySixBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oEmpLeaveDetail = null;
      
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpPaySixDetailInfo.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oEmpPaySixDetailInfo.getTxtYYMM())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpPaySixDetailInfo.getTxtEffDt())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_EmpSixPayDetail(?,?,?,?,?,?,?,?)");
  
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
        oEmpLeaveDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oEmpPaySixBean = new EmpPaySixBean();
      oEmpPaySixBean.setDetailId(oRow.get("PAY_EMP_BOB_ID").getString());
      oEmpPaySixBean.setTxtPayCode(oRow.get("PAY_CODE").getString()); 
      oEmpPaySixBean.setTxtPayDesc((oRow.get("PAY_CODE_DESC").getString()));
      oEmpPaySixBean.setStatus("N");
      oEmpPaySixBean.setTxtPrcntage(oRow.get("PERCENTAGE").getString());
      oEmpPaySixBean.setTxtPayMode(oRow.get("PAYMODE_FLAG").getString());
      oEmpLeaveDetail.add(oEmpPaySixBean);
    }
    
    return oEmpLeaveDetail;
    
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      saveEmpSixPayDetail(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
  }

  private void saveEmpSixPayDetail(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
        boolean bInsert = false;
        boolean bUpdate = false;
        boolean bDelete = false;
        
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = null;
        DBUtilitiesBean oBeanInsert = null;
        DBUtilitiesBean oBeanDelete = null;
        EmpPaySixHeaderBean oDummyHeaderBean = (EmpPaySixHeaderBean)oBaseHeaderBean;
        
        oBean = new DBUtilitiesBean();
        ArrayList oOutArray;
        
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHeaderPrimaryKey()))); //holds transaction id.
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_EmpSixPay_GentranId(?,?,?)",true,true);
        
        DBObject oOutObject=(DBObject)oOutArray.get(0);
        Integer tran_id=(Integer)oOutObject.getObject();
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        EmpPaySixBean oUserBean = (EmpPaySixBean)oIt.next();
        //      System.out.println(oMaintHraRateBean.getStatus());
        //      System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oUserBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
            if(!bInsert)
            {
                oBeanInsert = new DBUtilitiesBean();
                oBeanInsert.createBatch("pkg_payroll_misc.proc_insert_emp_six_pay(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                bInsert = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,tran_id));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayCode())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPrcntage())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPayCodeAdj())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPayCodePerc())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPercAdj())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtYYMM())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayMode())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffDt())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getChkVhclType())));
            oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oBeanInsert.addToBatch(oParameters);
        }
        /*
        else if(oUserBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
            if(!bUpdate)
            {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("pkg_payroll_misc.proc_Update_empsix_pay(?,?,?,?,?,?,?,?,?,?,?)");
                bUpdate = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oDummyHeaderBean.getHeaderPrimaryKey()));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getDetailId())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayCode())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPrcntage())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtYYMM())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayMode())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffDt())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getChkVhclType())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oBean.addToBatch(oParameters);
        }*/
        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
            if(!bDelete)
            {
                oBeanDelete = new DBUtilitiesBean();
                oBeanDelete.createBatch("pkg_payroll_misc.proc_Delete_empsix_pay(?,?,?)");
                bDelete = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oDummyHeaderBean.getHeaderPrimaryKey()));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getDetailId())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
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
         e.printStackTrace();
      }
  }
  
     private void Emp_chk_Sts(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    int cnt = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    EmpPaySixHeaderBean oDummyHeaderBean = (EmpPaySixHeaderBean)oBaseHeaderBean;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtYYMM())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.Proc_Send_supppayInvoice(?,?,?,?,?,?)",true,true);
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_checkEmpSixPayHeaderSuper(?,?,?,?)",true,true);
      
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    if (errCode.intValue() != 0)
    {
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errMsg));
        oList.add(new EnrgiseApplicationException("Payroll.EmpSixPay.UpdateCheck",oArguments));
    }
  }    
  
  private void Emp_Trans_Promo_Sts(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    int cnt = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    EmpPaySixHeaderBean oDummyHeaderBean = (EmpPaySixHeaderBean)oBaseHeaderBean;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtYYMM())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.Proc_Send_supppayInvoice(?,?,?,?,?,?)",true,true);
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_emp_status_chk1(?,?,?,?)",true,true);
      
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    if (errCode.intValue() != 0)
    {
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errMsg));
        oList.add(new EnrgiseApplicationException("Payroll.EmpSixPay.UpdateCheck",oArguments));
    }
  }    

  private void checkEffectiveDate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    int cnt = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    EmpPaySixHeaderBean oDummyHeaderBean = (EmpPaySixHeaderBean)oBaseHeaderBean;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtYYMM())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffDt())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters, "pkg_payroll_misc.proc_chk_sixpay_effDat(?,?,?,?)",true,true);
      
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    if (errCode.intValue() != 0)
    {
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errMsg));
        oList.add(new EnrgiseApplicationException("Payroll.EmpSixPay.effdtCheck",oArguments));
    }
  }
  
 
  public LovVO getEmpPaymentLOVData_Super(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    arylstHeaderNames.add("Employee Status");
    arylstHeaderNames.add("Pay Scale");
    arylstHeaderNames.add("Fin Year");
    arylstHeaderNames.add("Designation Code");
    arylstHeaderNames.add("Handicapped Flag");
    arylstHeaderNames.add("Pay Revision Flag");
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));   
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getempsixpaylovdata_Super(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField3(oRow.get("DSGN_DESC").getString());
      oLOVBean.setDetailField4(oRow.get("category").getString());
      oLOVBean.setDetailField5(oRow.get("emp_type").getString());
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("loc_desc").getString());
      oLOVBean.setDetailField8(oRow.get("EMP_STATUS").getString());
      oLOVBean.setDetailField9(oRow.get("PAY_SCALE_CODE").getString());
      oLOVBean.setDetailField10(oRow.get("finn_year").getString());
      oLOVBean.setDetailField11(oRow.get("designation_id").getString());
      oLOVBean.setDetailField12(oRow.get("handicapped_flag").getString());
      oLOVBean.setDetailField13(oRow.get("pay_rev_flag").getString());   

      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
 
  public LovVO getEmpPaymentLOVData_Q(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    arylstHeaderNames.add("Employee Status");
    arylstHeaderNames.add("Pay Scale");
    arylstHeaderNames.add("Fin Year");
    arylstHeaderNames.add("Designation Code");
    arylstHeaderNames.add("Handicapped Flag");
    arylstHeaderNames.add("Pay Revision Flag");
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));   
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getEmpSixPayLOVData_Q1(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField3(oRow.get("DSGN_DESC").getString());
      oLOVBean.setDetailField4(oRow.get("category").getString());
      oLOVBean.setDetailField5(oRow.get("emp_type").getString());
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("loc_desc").getString());
      oLOVBean.setDetailField8(oRow.get("EMP_STATUS").getString());
      oLOVBean.setDetailField9(oRow.get("PAY_SCALE_CODE").getString());
      oLOVBean.setDetailField10(oRow.get("finn_year").getString());
      oLOVBean.setDetailField11(oRow.get("designation_id").getString());
      oLOVBean.setDetailField12(oRow.get("handicapped_flag").getString());
      oLOVBean.setDetailField13(oRow.get("pay_rev_flag").getString());
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpPaymentLOVData_N(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    arylstHeaderNames.add("Employee Status");
    arylstHeaderNames.add("Pay Scale");
    arylstHeaderNames.add("Fin Year");
    arylstHeaderNames.add("Designation Code");
    arylstHeaderNames.add("Handicapped Flag");
    arylstHeaderNames.add("Pay Revision Flag");
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
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));   
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getEmpSixPayLOVData_N(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField3(oRow.get("DSGN_DESC").getString());
      oLOVBean.setDetailField4(oRow.get("category").getString());
      oLOVBean.setDetailField5(oRow.get("emp_type").getString());
      oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("loc_desc").getString());
      oLOVBean.setDetailField8(oRow.get("EMP_STATUS").getString());
      oLOVBean.setDetailField9(oRow.get("PAY_SCALE_CODE").getString());
      oLOVBean.setDetailField10(oRow.get("finn_year").getString());
      oLOVBean.setDetailField11(oRow.get("designation_id").getString());
      oLOVBean.setDetailField12(oRow.get("handicapped_flag").getString());
      oLOVBean.setDetailField13(oRow.get("pay_rev_flag").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpSixPayCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");   
    arylstHeaderNames.add("PayCode Description");   
    arylstHeaderNames.add("Percentage");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
    String sPaycode,sDesc,payrev;
    sPaycode=oLovQueryVO.getSearchField1();
    sDesc=oLovQueryVO.getSearchField2();
    payrev=oLovQueryVO.getProperty("txtPayRevFlag");
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();     
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, payrev));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnDesgId")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnHandFlag")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetEmpSixPayCodeLOVData(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField3(oRow.get("percentage").getString());            
      
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

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
      checkEffectiveDate(oBaseHeaderBean,oList);
      reportError(oList);
      oList = new ArrayList();
       if(sScreenName.equals("EmpSixPayScreen"))
       {
      Emp_Trans_Promo_Sts(oBaseHeaderBean,oDetailBeanArray,oList);
       }
       else
       {
       Emp_chk_Sts(oBaseHeaderBean,oDetailBeanArray,oList);
       }
       
         reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

}