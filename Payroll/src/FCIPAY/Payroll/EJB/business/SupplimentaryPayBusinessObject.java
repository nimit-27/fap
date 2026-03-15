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

import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayQueryVO;
import FCIPAY.Payroll.UTILITY.SupplimentaryPayHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayDetailInfo;
import FCIPAY.Payroll.UTILITY.SupplPayBean;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

public class SupplimentaryPayBusinessObject extends BaseBO 
{
  public SupplimentaryPayBusinessObject()
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

  public RecordMetaInfo getSupPayHeaderMetaInfo(SupplPayQueryVO oSupplPayQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    
    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oSupplPayQueryVO.getTxtEmpNo()));      
    //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountSupplPayHeader(?,?,?,?)");

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

  public ArrayList getSupPayHeader(SupplPayQueryVO oSupplPayQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    ArrayList oHeaderList = null;
    int count = 0;
    if(oSupplPayQueryVO == null)
    {
      oSupplPayQueryVO = new SupplPayQueryVO();
    }

    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oSupplPayQueryVO.getTxtEmpNo()));      
    //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_SupplPayHeader(?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    SupplimentaryPayHeaderBean oHeaderBeanObject;
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
        oHeaderBeanObject = new SupplimentaryPayHeaderBean();
        oHeaderBeanObject.setTranId(oRow.get("trans_id").getString());
        oHeaderBeanObject.setTxtEmpNo(oRow.get("emp_num").getString());
        oHeaderBeanObject.setTxtEmpName(oRow.get("empName").getString());
        oHeaderBeanObject.setTxtCPFCode(oRow.get("CPF_CODE").getString());
        oHeaderBeanObject.setTxtStaffCode(oRow.get("staff_code").getString());
        oHeaderBeanObject.setTxtDesg(oRow.get("dsgn_desc").getString());
        oHeaderBeanObject.setTxtPayScale(oRow.get("PAY_SCALE_CODE").getString());
        oHeaderBeanObject.setTxtPayScaleType(oRow.get("PAY_SCALE_TYPE").getString());
        oHeaderBeanObject.setTxtCatg(oRow.get("category").getString());
        oHeaderBeanObject.setTxtCPFAuto(oRow.get("cpf_amt").getString());
        oHeaderBeanObject.setTxtIncomeTax(oRow.get("incm_amt").getString());
        oHeaderBeanObject.setTxtInvoice(oRow.get("invc_num").getString());
        oHeaderBeanObject.setTxtNetAmt(oRow.get("vnet_amt").getString());
        oHeaderBeanObject.setTxtPenAmt(oRow.get("vpen_amt").getString());
        oHeaderList.add(oHeaderBeanObject);
        
        oRow = null;
        oHeaderBeanObject = null; //added by swapnendu Dt 24 Oct 2011.
    } 
    oList = null;
    oIt = null;
    oSupplPayQueryVO = null;
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
    return oHeaderList;
  }

  public RecordMetaInfo getSupplPayDetailMetaInfo(String sPrimaryKey, SupplPayDetailInfo oSupplPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    String tran_id=oSupplPayDetailInfo.getTranId(); 
    ArrayList oParameters; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    if(oSupplPayDetailInfo.getButtonFlag().equals("IN")) {
      return oRecordMetaInfo;
    }
    if(oSupplPayDetailInfo.getButtonFlag().equals("SV")) {
        oParameters = new ArrayList();
        ArrayList oOutArray;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oSupplPayDetailInfo.getTxtEmpNo()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,tran_id));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.GentranIdPop(?,?,?)",true,true);
        
        DBObject oOutObject=(DBObject)oOutArray.get(0);
        Integer vTran_id = (Integer)oOutObject.getObject();
        tran_id = vTran_id.toString();
        oParameters = null;
        oOutArray = null;
        oOutObject = null;
    }
   
    ArrayList oOutArray; //Output 
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,tran_id));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayDetailInfo.getTxtEmpNo())));
    //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayDetailInfo.getLoginLocCode())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountSupplPayDetail(?,?,?,?,?)");
      
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    
    oTotalRecord = null;
    oTimeObject = null;
    oOutArray = null;
    oParameters = null;
    return oRecordMetaInfo;
  }
  
  public ArrayList getSupplPayDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, SupplPayDetailInfo oSupplPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    String tran_id=oSupplPayDetailInfo.getTranId(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters; //Input Parameters
    if(oSupplPayDetailInfo.getButtonFlag().equals("IN")) return null;
    
    if(oSupplPayDetailInfo.getButtonFlag().equals("SV")) {
        ArrayList oOutArray;
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oSupplPayDetailInfo.getTxtEmpNo()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,tran_id));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.GentranIdPop(?,?,?)",true,true);
        
        DBObject oOutObject=(DBObject)oOutArray.get(0);
        Integer vTran_id = (Integer)oOutObject.getObject();
        tran_id = vTran_id.toString();
        oOutArray = null;
        oParameters = null;
    }
    
    
    int count = 0;
    ArrayList oOutArray; //Output 
    SupplPayBean oSupplPayBean;
    QueryRow oRow = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oEmpLeaveDetail = null;
      
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,tran_id));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayDetailInfo.getTxtEmpNo())));
    //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayDetailInfo.getLoginLocCode())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetSupplPayDetail(?,?,?,?,?,?)");
  
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
      oSupplPayBean = new SupplPayBean();
      oSupplPayBean.setDetailId(oRow.get("PAY_ARR_TEMP_ID").getString());
      oSupplPayBean.setTxtPayCode(oRow.get("PAY_CODE").getString()); 
      oSupplPayBean.setTxtPayDesc((oRow.get("PAY_CODE_DESC").getString()));
      oSupplPayBean.setStatus("Q");
      oSupplPayBean.setTxtYYMM(oRow.get("FOR_YYMM").getString());
      oSupplPayBean.setTxtPayMode(oRow.get("PAY_MODE").getString());
      oSupplPayBean.setTxtAmt(oRow.get("TXN_AMT").getString());
      oEmpLeaveDetail.add(oSupplPayBean);
      oRow = null;
      oSupplPayBean = null; //added by swapnendu Dt 24 Oct 2011.
    }
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oSupplPayDetailInfo = null;
    return oEmpLeaveDetail;
    
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException {
      saveSupplPayDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
  }

 private void checkEmpPayCodeMap(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
	   ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     ArrayList oOutArray; //Output
     ArrayList oRetList;
     QueryRow oRow = null;
     Iterator oIt = null;
     String payCode = null;
    Integer errCode = null;
    String errMsg = null;
    SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
    
      oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        SupplPayBean oUserBean = (SupplPayBean)oIt.next();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oDummyHeaderBean.getTxtEmpNo()));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oUserBean.getTxtPayCode()));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));       
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.proc_emppaycodechk(?,?,?,?)",true,true);                 
          errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
          //errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
          if (errCode.intValue() != 0)
          {
             if(payCode == null)
             {
               payCode = oUserBean.getTxtPayCode();
             }
          
          else
           {
           payCode = payCode+ ", "+oUserBean.getTxtPayCode();
           }
          
          }
      }
    
       if(payCode != null)
              {
                  ArrayList oArguments = new ArrayList();
                  oArguments.add(new String(payCode));
                  oList.add(new EnrgiseApplicationException("Payroll.Supplimentary.EmpPayCodeChk",oArguments));
        }
   
  }
 
 
  private void saveSupplPayDetails(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean,
                                     ArrayList oDetailBeanArray) throws EnrgiseSystemException,
                                                                        EnrgiseApplicationException {
        boolean bInsert = false;
        boolean bUpdate = false;
        boolean bDelete = false;
        Integer errCode = null;
        String errMsg = null;
        ArrayList oList =null;
        
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = null;
        DBUtilitiesBean oBeanInsert = null;
        DBUtilitiesBean oBeanDelete = null;
        SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;

        oBean = new DBUtilitiesBean();
        ArrayList oOutArray;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR,
                                     new String(oDummyHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR,
                                     new String(oDummyHeaderBean.getTranId())));
        oParameters.add(new DBObject(3, DBObject.OUT, ParameterTypes.INTEGER));

        oOutArray = oBean.callProc(oParameters, "pkg_payroll_misc.GentranIdSave(?,?,?)", true, true);

        DBObject oOutObject = (DBObject)oOutArray.get(0);
        Integer tran_id = (Integer)oOutObject.getObject();

        oOutObject = null;
        oOutArray = null;
        oParameters = null;

        Iterator oIt = oDetailBeanArray.iterator();
        while (oIt.hasNext()) {
            SupplPayBean oUserBean = (SupplPayBean)oIt.next();
            //        System.out.println(oMaintHraRateBean.getStatus());
            //        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
            if (oUserBean.getStatus().equals(EnrgiseConstants.NEW_MODE)) {
                
               // verrmsg
               // verrcode
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtEmpNo())));
                oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtPayCode())));
                oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtYYMM())));
                oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtAmt())));
                oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtPayMode())));
                oParameters.add(new DBObject(6, DBObject.IN, ParameterTypes.INTEGER, tran_id));
                oParameters.add(new DBObject(7, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtSiteID())));
                oParameters.add(new DBObject(8, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtIncomeTax())));
                oParameters.add(new DBObject(9, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(10, DBObject.OUT, ParameterTypes.VARCHAR));
                oParameters.add(new DBObject(11, DBObject.OUT, ParameterTypes.INTEGER));
                
             //   if (!bInsert) {
                    
                    oBeanInsert = new DBUtilitiesBean();
                    oOutArray = oBeanInsert.callProc(oParameters, "pkg_payroll_misc.proc_Insert_pay_Arrear_Temp2(?,?,?,?,?,?,?,?,?,?,?)", true, true);
                    errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
                    errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
                       if (errCode.intValue() != 0){                       
                            ArrayList oArguments = new ArrayList();
                            oArguments.add(new String(errMsg));
                            System.out.println("Error!!! while inserting Employee ::"+errMsg);
                            throw new EnrgiseApplicationException("Payroll.SupplPli.Check",oArguments);
                        }         
                //    bInsert = true;
              //  }
                //oBeanInsert.addToBatch(oParameters);
                oParameters = null;
            } else if (oUserBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE)) {
//                if (!bUpdate) {
//                    oBean = new DBUtilitiesBean();
//                    oBean.createBatch("pkg_payroll_misc_supp.proc_Update_SupplPay_Arrear(?,?,?,?,?,?,?,?,?,?,?,?)");
//                    bUpdate = true;
//                }
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getDetailId())));
                oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtEmpNo())));
                oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtPayCode())));
                oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtYYMM())));
                oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtAmt())));
                oParameters.add(new DBObject(6, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getTxtPayMode())));
                //oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.INTEGER,new String(sHeaderPrimaryKey))); //tran id (for updating after insertion & during execute)
                oParameters.add(new DBObject(7, DBObject.IN, ParameterTypes.INTEGER,
                                             new String(oDummyHeaderBean.getDelUpTran())));
                oParameters.add(new DBObject(8, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtSiteID())));
                oParameters.add(new DBObject(9, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtIncomeTax())));
                oParameters.add(new DBObject(10, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(11, DBObject.OUT, ParameterTypes.VARCHAR));
                oParameters.add(new DBObject(12, DBObject.OUT, ParameterTypes.INTEGER));                
                if (!bUpdate) {                    
                    oBeanInsert = new DBUtilitiesBean();
                    oOutArray = oBeanInsert.callProc(oParameters, "pkg_payroll_misc.proc_Update_SupplPay_Arrear(?,?,?,?,?,?,?,?,?,?,?,?)", true, true);
                    errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
                    errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
                       if (errCode.intValue() != 0){                       
                            ArrayList oArguments = new ArrayList();
                            oArguments.add(new String(errMsg));
                            System.out.println("Error!!! while Updating Employee ::"+errMsg);
                            throw new EnrgiseApplicationException("Payroll.SupplPli.Check",oArguments);
                        }         
                    bUpdate = true;
                }                
               // oBean.addToBatch(oParameters);
                oParameters = null;
            }

            else if (oUserBean.getStatus().equals(EnrgiseConstants.DELETE_MODE)) {
//                if (!bDelete) {
//                    oBeanDelete = new DBUtilitiesBean();
//                    oBeanDelete.createBatch("pkg_payroll_misc_supp.proc_DeleteSupplPayment1(?,?,?,?,?)");
//                    bDelete = true;
//                }
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oUserBean.getDetailId())));
                oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getTxtEmpNo())));
                //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));  //sending tran id.
                oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR,
                                             new String(oDummyHeaderBean.getDelUpTran())));
                oParameters.add(new DBObject(4, DBObject.OUT, ParameterTypes.VARCHAR));
                oParameters.add(new DBObject(5, DBObject.OUT, ParameterTypes.INTEGER));
                if (!bDelete) {                    
                    oBeanInsert = new DBUtilitiesBean();
                    oOutArray = oBeanInsert.callProc(oParameters, "pkg_payroll_misc.proc_DeleteSupplPayment1(?,?,?,?,?)", true, true);
                    errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
                    errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
                       if (errCode.intValue() != 0){                       
                            ArrayList oArguments = new ArrayList();
                            oArguments.add(new String(errMsg));
                            System.out.println("Error!!! while Deleteing Employee ::"+errMsg);
                            throw new EnrgiseApplicationException("Payroll.SupplPli.Check",oArguments);
                        }         
                    bDelete = true;
                }
                //oBeanDelete.addToBatch(oParameters);
                oParameters = null;
            }
            oUserBean = null;
        }

//        try {
//            if (bInsert) {
//                oBeanInsert.executeBatch();
//            }
//
//            if (bUpdate) {
//                oBean.executeBatch();
//            }
//
//            if (bDelete) {
//                oBeanDelete.executeBatch();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } 
//        finally {
//            oDummyHeaderBean = null;
//            oBean = null;
//            oBeanInsert = null;
//            oBeanDelete = null;
//        }
    }

  public String populateData(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DBUtilitiesBean oBean = null;
    SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
    ArrayList oParameters = new ArrayList();
    oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTranId())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.GentranIdPop(?,?,?)",true,true);
    
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    Integer vtran_id=(Integer)oOutObject.getObject();
    String tran_id = vtran_id.toString();

    oParameters = new ArrayList();
    oOutArray = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(tran_id)));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
         
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.get_cpf_inctax2(?,?,?,?,?,?,?,?)",true,true);
    
    DBObject oOutObj1 = (DBObject)oOutArray.get(0);
    DBObject oOutObj2 = (DBObject)oOutArray.get(1);
    DBObject oOutObj3 = (DBObject)oOutArray.get(2);
    DBObject oOutObj4 = (DBObject)oOutArray.get(3);
    DBObject oOutObj5 = (DBObject)oOutArray.get(4);
    
    String cpfAmt = (String)oOutObj1.getObject();
    String incmAmt = (String)oOutObj2.getObject();
    String invoice = (String)oOutObj3.getObject();
    String netAmt = (String)oOutObj4.getObject();
    String penAmt = (String)oOutObj5.getObject();
    
    String headerPrmKey = cpfAmt+","+incmAmt+","+invoice+","+tran_id+","+netAmt+","+penAmt;
    oBean = null;
    cpfAmt = null;
    incmAmt = null;
    invoice = null;
    netAmt = null;
    penAmt = null;
      
    oOutObj1 = null;
    oOutObj2 = null;
    oOutObj3 = null;
    oOutObj4 = null;
    oOutObj5 = null;
    return headerPrmKey;
  }
 
  public LovVO getSupPayEmpDtlLOVDataQuery(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
    arylstHeaderNames.add("Staff Code");
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Payscale");
    arylstHeaderNames.add("PayScaleType");
    arylstHeaderNames.add("Catagory");
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

    String empType=oLovQueryVO.getProperty("hdnEmpLbrFlag");

    if(empType==null || empType.equals(""))
    {
      empType="E";
    }else
    {
      System.out.println("EmpType is"+empType);
    }

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(empType)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));

    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetSupplPayEmpLovQ(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("EMPNAME").getString());
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField4(oRow.get("STAFF_CODE").getString());
      oLOVBean.setDetailField5(oRow.get("DSGN_DESC").getString());
      oLOVBean.setDetailField6(oRow.get("PAY_SCALE_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("PAY_SCALE_TYPE").getString());
      oLOVBean.setDetailField8(oRow.get("CATEGORY").getString());
      oList.add(oLOVBean);
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

  public LovVO getSupPayEmpDtlLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
    arylstHeaderNames.add("Staff Code");
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Payscale");
    arylstHeaderNames.add("PayScaleType");
    arylstHeaderNames.add("Catagory");
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

    String empType=oLovQueryVO.getProperty("hdnEmpLbrFlag");

    if(empType==null || empType.equals(""))
    {
      empType="E";
    }else
    {
      System.out.println("EmpType is"+empType);
    }

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(empType)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes
    .INTEGER));
oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetSupplPayEmpLov(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("EMPNAME").getString());
      oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());
      oLOVBean.setDetailField4(oRow.get("STAFF_CODE").getString());
      oLOVBean.setDetailField5(oRow.get("DSGN_DESC").getString());
      oLOVBean.setDetailField6(oRow.get("PAY_SCALE_CODE").getString());
      oLOVBean.setDetailField7(oRow.get("PAY_SCALE_TYPE").getString());
      oLOVBean.setDetailField8(oRow.get("CATEGORY").getString());
      oList.add(oLOVBean);
      oLOVBean = null; //added by swapnendu Dt 24 Oct 2011 
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
  
  public LovVO getPaycodeAgencycodePayCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");   
    arylstHeaderNames.add("PayCode Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
    String sPaycode,sDesc;
    sPaycode=oLovQueryVO.getSearchField1();
    sDesc=oLovQueryVO.getSearchField2();
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      /*oParameters = new ArrayList();     
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetPaycodeAgencyLOV(?,?,?,?)");*/
      
      GetLovAction oGetLovAction = new GetLovAction();
      oOutArray = oGetLovAction.GetLov(oLovQueryVO,"N");
      
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
       oLOVBean = null; //added by swapnendu Dt 24 Oct 2011.
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

    private void checkMaxPayYear(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = null; //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oRetList = null;
        Iterator oIt = null;
        String sRevYear = "";
        SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
        oParameters = new ArrayList();
        if((oDummyHeaderBean.getHdnEmpLbrFlag()).equals("E"))
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
        }
        else
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear_OvrAbv_Lbr(?,?,?,?)");
        }
        oDummyHeaderBean = null; //added by swapnendu Dt 24 Oct 2011
        
        oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        oOutArray = null;
        oParameters = null;
        oIt = oRetList.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            sRevYear = oRow.get("yymm").getString(); //getting current payroll month.
            String status = oRow.get("arc_flag").getString(); 
            oRow = null;
        }
        int payYear = Integer.parseInt(sRevYear);
        oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
            SupplPayBean  oSupplPayBean  = (SupplPayBean)oIt.next();
            count++;
            if(oSupplPayBean.getStatus().equals("N") || oSupplPayBean.getStatus().equals("U"))
            {
                String yymm = oSupplPayBean.getTxtYYMM();
                int yyyyMM = Integer.parseInt(yymm);
                if(yyyyMM > payYear)
                {
                    ArrayList oArguments = new ArrayList();
                    oArguments.add(new String(sRevYear));
                    oArguments.add(new Integer(count));
                    oList.add(new EnrgiseApplicationException("Payroll.SupplyPay.MaxPayYearCheck",oArguments));
                    oArguments = null;
                }
            }
            oSupplPayBean = null;
        }
        oIt = null;
    }
        
    private void checkTotAmtPayable(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        SupplimentaryPayHeaderBean oSupplimentaryPayHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
        oIt = oDetailBeanArray.iterator();
        int totAmt = 0, amt1=0,amt2=0;
       
        while(oIt.hasNext())
        {
            SupplPayBean oSupplPayBean = (SupplPayBean)oIt.next();
            if(oSupplPayBean.getStatus().equals("N") || oSupplPayBean.getStatus().equals("U"))
            {
                if((oSupplPayBean.getTxtPayMode().equals("1")) || (oSupplPayBean.getTxtPayMode().equals("4")))
                {
                    amt1 =  amt1+ Integer.parseInt(oSupplPayBean.getTxtAmt());  
                               
                }
                else if((oSupplPayBean.getTxtPayMode().equals("2")) || (oSupplPayBean.getTxtPayMode().equals("5")))
                {
                    amt2 =  amt2+(Integer.parseInt(oSupplPayBean.getTxtAmt())); 
                }
            }
        }
        totAmt = amt1 - amt2 ; 
        
        /*if(totAmt < 0 )                   //Commented by Ankur on 01/07/2013
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String("The net amount payable can not be negative. Plese check your payment."));
            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
        } */
    }

    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        SupplimentaryPayHeaderBean oSupplimentaryPayHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oSupplimentaryPayHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oSupplimentaryPayHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oSupplimentaryPayHeaderBean.getTxtSiteID())));
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
 private void checkTransferCase(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        SupplimentaryPayHeaderBean oSupplimentaryPayHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oSupplimentaryPayHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2, DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(3, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_transfer_emp_check(?,?,?)",true,true);
        Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
        String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() != 0)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            System.out.println(errMsg);
            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
        }
    }

  /*
   * This function checks wheather the given paycodes are applicable for category -III & IV employees. 
   */
    private void checkPaycodeApplicable(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        int cnt = 0;
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        
        String sPayCode = null;
        SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;

        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_Chk_SixPayCode(?,?)",true,true);
          
        oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        oIt = oRetList.iterator();
        if(!((oDummyHeaderBean.getTxtCatg().equals("I") || oDummyHeaderBean.getTxtCatg().equals("II") ||oDummyHeaderBean.getTxtCatg().equals("III") || oDummyHeaderBean.getTxtCatg().equals("IV") && oDummyHeaderBean.getTxtPayScaleType().equals("IDA"))))
        {
            if (oRetList.size()>0)
            {
                String[] arr1 = new String[oRetList.size()];
                while(oIt.hasNext())
                {
                    oRow = (QueryRow)oIt.next();
                    sPayCode = oRow.get("paycode").getString(); 
                    arr1[cnt] = sPayCode;
                    cnt++;
                }
                oIt = null;
                oIt = oDetailBeanArray.iterator();
                while(oIt.hasNext())
                {
                    if (arr1.length>0)
                    {
                        SupplPayBean  oSupplPayBean  = (SupplPayBean)oIt.next();
                        count++;
                        if(oSupplPayBean.getStatus().equals("N") || oSupplPayBean.getStatus().equals("U"))
                        {
                            for(int i=0; i<arr1.length; i++)
                            {
                                if (oSupplPayBean.getTxtPayCode().equals(arr1[i]))
                                {
                                    ArrayList oArguments = new ArrayList();
                                    oArguments.add(new String(oSupplPayBean.getTxtPayCode()));
                                    oArguments.add(new Integer(count));
                                    oList.add(new EnrgiseApplicationException("Payroll.SupplyPay.PayCodeCheck",oArguments));
                                }
                            }
                        }
                        oSupplPayBean = null;
                    }
                }
            }
        }
        oIt = null;
        oRetList = null;
        oDummyHeaderBean = null;
    }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    //ArrayList oParameters = new ArrayList(); //Input Parameters
    //oParameters = new ArrayList();
    return null;
  }

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
      checkYrEndRemittance(oBaseHeaderBean,oList);
      reportError(oList);
      checkMaxPayYear(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
      checkTotAmtPayable(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
      oList = new ArrayList();
      checkPaycodeApplicable(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
      checkTransferCase(oBaseHeaderBean,oList);
      reportError(oList);
	  checkEmpPayCodeMap(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList); 
     // checkPliDiff(oBaseHeaderBean,oDetailBeanArray,oList);
    // reportError(oList); 
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  public String sendInvoice(SupplPayQueryVO oSupplPayQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oSupplPayQueryVO.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oSupplPayQueryVO.getTranId()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayQueryVO.getUserId())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayQueryVO.getSiteId())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.Proc_Send_supppayInvoice(?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    String usrMsg = "";
    if(errCode.intValue() == 0)
    {
      usrMsg = "Invoice sent Successfully";
    }    
    
    String sRetMsg=errCode+", "+errMsg; 
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
    return sRetMsg;
  }
 
  public String  CancelSuppPaymentInv(SupplPayQueryVO oSupplPayQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    String msg=null;
  
    if(oSupplPayQueryVO == null)
    {
      oSupplPayQueryVO = new SupplPayQueryVO();
    }
    
   
    
    String screenName= oSupplPayQueryVO.getScreenName();
    ArrayList oOutArray; //Output 
    ArrayList oParamList = new ArrayList();  
    ArrayList oList = new ArrayList();  
      
    oParameters = new ArrayList();
         
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oSupplPayQueryVO.getTxtEmpNo()))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oSupplPayQueryVO.getTxtInvoice()))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oSupplPayQueryVO.getScreenName()))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new Long(oSupplPayQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oSupplPayQueryVO.getUserId()))));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_cancel_othr_pymnt_inv.proc_cancel_op_invoices(?,?,?,?,?,?,?)",true,true);
    
    String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
    Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
      
    return errMsg;
  }
  //added by kriti for CR 765
    private void checkPliDiff(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
     {    
              ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        String payCode = null;
       Integer errCode = null;
       String errMsg = null;
       SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
       
         oIt = oDetailBeanArray.iterator();
         while(oIt.hasNext())
         {
           SupplPayBean oUserBean = (SupplPayBean)oIt.next();
             oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oDummyHeaderBean.getTxtEmpNo()));
             oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oUserBean.getTxtPayCode()));
             oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oUserBean.getTxtYYMM()));
             oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oUserBean.getTxtAmt()));
             oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));       
             oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
             oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.proc_pliamtcheck(?,?,?,?,?,?)",true,true);                 
             errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
             errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
            
           
             if(errCode.intValue() != 0)
             {
                 ArrayList oArguments = new ArrayList();
                 oArguments.add(new String(errMsg));
                 System.out.println(errMsg);
                 oList.add(new EnrgiseApplicationException("Payroll.SupplPli.Check",oArguments));
             }
       
         
     }
    
  
}
}