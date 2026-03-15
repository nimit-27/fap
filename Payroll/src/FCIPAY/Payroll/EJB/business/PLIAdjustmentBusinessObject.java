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

import FCIPAY.Payroll.UTILITY.SupplimentaryPayHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIReportDetailInfo;
import FCIPAY.Payroll.UTILITY.SupplPayBean;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIReportAdjustmentQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayQueryVO;
import FCIPAY.Payroll.UTILITY.PLIPaymentHeaderBean;

import FCIPAY.Payroll.UTILITY.PLIReportBean;

import java.rmi.RemoteException;

public class PLIAdjustmentBusinessObject extends BaseBO 
{
  public PLIAdjustmentBusinessObject()
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

    @Override
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
        return null;
    }

    @Override
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        oParameters = new ArrayList();
    }

    @Override
    public void saveDetailImpl(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, String sScreenName,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException {
        savePLIReportDetail(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);

    }

    @Override
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                              String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                              ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                              Timestamp oDetailPicked)  throws EnrgiseSystemException, EnrgiseApplicationException{
        

        if(bDetailDataChanged)
        {
          ArrayList oList = new ArrayList();
          checkYrEndRemittance(oBaseHeaderBean,oList);
          reportError(oList);
          checkMaxPayYear(oBaseHeaderBean,oDetailBeanArray,oList);
          reportError(oList);
          //checkTotAmtPayable(oBaseHeaderBean,oDetailBeanArray,oList);
          //reportError(oList);
          //oList = new ArrayList();
         // checkPaycodeApplicable(oBaseHeaderBean,oDetailBeanArray,oList);
         // reportError(oList);
         // checkTransferCase(oBaseHeaderBean,oList);
         // reportError(oList);
         //     checkEmpPayCodeMap(oBaseHeaderBean,oDetailBeanArray,oList);
         // reportError(oList); 
         // checkPliDiff(oBaseHeaderBean,oDetailBeanArray,oList);
        // reportError(oList); 
        }
    }
    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        PLIPaymentHeaderBean oPLIPaymentHeaderBean = (PLIPaymentHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oPLIPaymentHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oPLIPaymentHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oPLIPaymentHeaderBean.getTxtSiteID())));
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
        PLIPaymentHeaderBean oDummyHeaderBean = (PLIPaymentHeaderBean)oBaseHeaderBean;
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
            PLIReportBean  oPLIReportBean  = (PLIReportBean)oIt.next();
            count++;
            if(oPLIReportBean.getStatus().equals("N") || oPLIReportBean.getStatus().equals("U"))
            {
                String yymm = oPLIReportBean.getTxtYYMM();
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
            oPLIReportBean = null;
        }
        oIt = null;
    }

    @Override
    public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                                  String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                                  ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                                  Timestamp oDetailPicked) {
    }

    @Override
    public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                                 String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                                 ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                                 Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException {
    }

    public LovVO getPLIReportEmpDtlLOVData(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException {
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

    public LovVO getPLIReportEmpDtlLOVDataQuery(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException {

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

    public RecordMetaInfo getPLIReportHeaderMetaInfo(PLIReportAdjustmentQueryVO oPLIReportAdjustmentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException {

        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        
        ArrayList oOutArray;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPLIReportAdjustmentQueryVO.getTxtEmpNo()));      
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

    public ArrayList getPLIReportHeader(PLIReportAdjustmentQueryVO oPLIReportAdjustmentQueryVO, long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException{

        ArrayList oParameters = new ArrayList(); 
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        ArrayList oHeaderList = null;
        int count = 0;
        if(oPLIReportAdjustmentQueryVO == null)
        {
          oPLIReportAdjustmentQueryVO = new PLIReportAdjustmentQueryVO();
        }

        ArrayList oOutArray;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPLIReportAdjustmentQueryVO.getTxtEmpNo()));      
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
        PLIPaymentHeaderBean oHeaderBeanObject;
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
            oHeaderBeanObject = new PLIPaymentHeaderBean();
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
        oPLIReportAdjustmentQueryVO = null;
        oOutArray = null;
        oParameters = null;
        oOutObject = null;
        oBean = null;
        return oHeaderList;
    }

    public RecordMetaInfo getPLIReportDetailMetaInfo(String string, PLIReportDetailInfo oPLIReportDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException{

        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        String tran_id=oPLIReportDetailInfo.getTranId(); 
        ArrayList oParameters; //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        if(oPLIReportDetailInfo.getButtonFlag().equals("IN")) {
          return oRecordMetaInfo;
        }
        if(oPLIReportDetailInfo.getButtonFlag().equals("SV")) {
            oParameters = new ArrayList();
            ArrayList oOutArray;
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPLIReportDetailInfo.getTxtEmpNo()));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,tran_id));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            
            oOutArray = oBean.callProc(oParameters,"pkg_pli_forclosure.GentranIdPop1(?,?,?)",true,true);
            
            DBObject oOutObject=(DBObject)oOutArray.get(0);
            Integer vTran_id = (Integer)oOutObject.getObject();
            tran_id = vTran_id.toString();
            oParameters = null;
            oOutArray = null;
            oOutObject = null;
        }
        
        ArrayList oOutArray; //Output 
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oPLIReportDetailInfo.getTxtEmpNo())));
        //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayDetailInfo.getLoginLocCode())));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pli_forclosure.proc_countPliAdjustdetail(?,?,?,?)");
          
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

    public ArrayList getPLIReportDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, PLIReportDetailInfo oPLIReportDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException{

        String tran_id=oPLIReportDetailInfo.getTranId(); 
        
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters; //Input Parameters
        if(oPLIReportDetailInfo.getButtonFlag().equals("IN")) return null;
        
        if(oPLIReportDetailInfo.getButtonFlag().equals("SV")) {
            ArrayList oOutArray;
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPLIReportDetailInfo.getTxtEmpNo()));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,tran_id));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            
            oOutArray = oBean.callProc(oParameters,"pkg_pli_forclosure.GentranIdPop1(?,?,?)",true,true);
            
            DBObject oOutObject=(DBObject)oOutArray.get(0);
            Integer vTran_id = (Integer)oOutObject.getObject();
            tran_id = vTran_id.toString();
            oOutArray = null;
            oParameters = null;
        }
        
        
        int count = 0;
        ArrayList oOutArray; //Output 
        PLIReportBean oPLIReportBean;
        QueryRow oRow = null;
        ArrayList oList = null;
        Iterator oIt = null;
        ArrayList oEmpLeaveDetail = null;
          
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oPLIReportDetailInfo.getTxtEmpNo())));
        //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oSupplPayDetailInfo.getLoginLocCode())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pli_forclosure.proc_getPliAdjust_Report(?,?,?,?,?)");
        
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
          oPLIReportBean = new PLIReportBean();
          oPLIReportBean.setDetailId(oRow.get("FIN_YYMM").getString());
          oPLIReportBean.setStatus("Q");
          oPLIReportBean.setTxtYYMM(oRow.get("FIN_YYMM").getString());
          oPLIReportBean.setTxtPayMode(oRow.get("PAY_MODE").getString());
          oPLIReportBean.setTxtAmt(oRow.get("TXN_AMT").getString());
          oEmpLeaveDetail.add(oPLIReportBean);
          oRow = null;
          oPLIReportBean = null; //added by swapnendu Dt 24 Oct 2011.
        }
        oList = null;
        oIt = null;
        oBean = null;
        oOutArray = null;
        oParameters = null;
        oPLIReportDetailInfo = null;
        return oEmpLeaveDetail;
    }

    public String populateData1(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException{

        DBUtilitiesBean oBean = null;
        PLIPaymentHeaderBean oDummyHeaderBean = (PLIPaymentHeaderBean)oBaseHeaderBean;
        ArrayList oParameters = new ArrayList();
        oBean = new DBUtilitiesBean();
        ArrayList oOutArray;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTranId())));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"pkg_pli_forclosure.gentranidpop1(?,?,?)",true,true);
        
        DBObject oOutObject=(DBObject)oOutArray.get(0);
        Integer vtran_id=(Integer)oOutObject.getObject();
        String tran_id = vtran_id.toString();

       /*  oParameters = new ArrayList();
        oOutArray = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(tran_id)));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"pkg_pli_forclosure.get_pli_adjust_report(?,?,?,?,?)",true,true); */
    
        String headerPrmKey = tran_id;
        oBean = null;
       
        return headerPrmKey;
    }

    public LovVO getPaycodeAgencycodePayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException{

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

    private void savePLIReportDetail(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException {
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
              PLIPaymentHeaderBean oDummyHeaderBean = (PLIPaymentHeaderBean)oBaseHeaderBean;

              oBean = new DBUtilitiesBean();
              ArrayList oOutArray;
              oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
              oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTranId())));
              oParameters.add(new DBObject(3, DBObject.OUT, ParameterTypes.INTEGER));

              oOutArray = oBean.callProc(oParameters, "pkg_pli_forclosure.genPLItranidsave(?,?,?)", true, true);

              DBObject oOutObject = (DBObject)oOutArray.get(0);
              Integer tran_id = (Integer)oOutObject.getObject();

              oOutObject = null;
              oOutArray = null;
              oParameters = null;

              Iterator oIt = oDetailBeanArray.iterator();
              while (oIt.hasNext()) {
                  PLIReportBean oUserBean = (PLIReportBean)oIt.next();
                  //        System.out.println(oMaintHraRateBean.getStatus());
                  //        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
                  if (oUserBean.getStatus().equals(EnrgiseConstants.NEW_MODE)) {
                      
                     // verrmsg
                     // verrcode
                      oParameters = new ArrayList();
                      oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEmpNo())));
                      oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR,new String(oUserBean.getTxtYYMM())));
                      oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR,new String(oUserBean.getTxtAmt())));
                      oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayMode())));
                      oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.INTEGER, tran_id));
                      oParameters.add(new DBObject(6, DBObject.IN, ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
                      oParameters.add(new DBObject(7, DBObject.IN, ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
                      oParameters.add(new DBObject(8, DBObject.OUT, ParameterTypes.VARCHAR));
                      oParameters.add(new DBObject(9, DBObject.OUT, ParameterTypes.INTEGER));
                      
                   //   if (!bInsert) {
                          
                          oBeanInsert = new DBUtilitiesBean();
                          oOutArray = oBeanInsert.callProc(oParameters, "pkg_pli_forclosure.proc_Insert_pay_emp_adjustment(?,?,?,?,?,?,?,?,?)", true, true);
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
        //                    oBean.createBatch("pkg_pli_forclosure_supp.proc_Update_SupplPay_Arrear(?,?,?,?,?,?,?,?,?,?,?,?)");
        //                    bUpdate = true;
        //                }
                      oParameters = new ArrayList();
                      oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR,
                                                   new String(oUserBean.getDetailId())));
                      oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR,
                                                   new String(oDummyHeaderBean.getTxtEmpNo())));
                      oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR,
                                                   new String(oUserBean.getTxtYYMM())));
                      oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR,
                                                   new String(oUserBean.getTxtAmt())));
                      oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.VARCHAR,
                                                   new String(oUserBean.getTxtPayMode())));
                      //oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.INTEGER,new String(sHeaderPrimaryKey))); //tran id (for updating after insertion & during execute)
                      oParameters.add(new DBObject(6, DBObject.IN, ParameterTypes.VARCHAR,
                                                   new String(oDummyHeaderBean.getTxtSiteID())));
                      oParameters.add(new DBObject(7, DBObject.IN, ParameterTypes.VARCHAR,
                                                   new String(oDummyHeaderBean.getTxtUserID())));
                      oParameters.add(new DBObject(8, DBObject.OUT, ParameterTypes.VARCHAR));
                      oParameters.add(new DBObject(9, DBObject.OUT, ParameterTypes.INTEGER));                
                      if (!bUpdate) {                    
                          oBeanInsert = new DBUtilitiesBean();
                          oOutArray = oBeanInsert.callProc(oParameters, "pkg_pli_forclosure.proc_update_pliadjust_report(?,?,?,?,?,?,?,?,?)", true, true);
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
                  //                    oBeanDelete.createBatch("pkg_pli_forclosure_supp.proc_DeleteSupplPayment1(?,?,?,?,?)");
                  //                    bDelete = true;
                  //                }
                                 oParameters = new ArrayList();
                                 oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oUserBean.getDetailId())));
                                 oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oDummyHeaderBean.getTxtEmpNo())));
                                 //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));  //sending tran id.
                                // oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oDummyHeaderBean.getTranId())));
                                 oParameters.add(new DBObject(3, DBObject.OUT, ParameterTypes.VARCHAR));
                                 oParameters.add(new DBObject(4, DBObject.OUT, ParameterTypes.INTEGER));
                                 if (!bDelete) {                    
                                     oBeanInsert = new DBUtilitiesBean();
                                     oOutArray = oBeanInsert.callProc(oParameters, "pkg_pli_forclosure.proc_deletePliAdjust_Report(?,?,?,?)", true, true);
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
          }
}
