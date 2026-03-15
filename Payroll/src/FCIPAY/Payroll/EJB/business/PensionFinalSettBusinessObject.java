package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PensionFinalSettQueryVO;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentBean;
import FCIPAY.Payroll.UTILITY.PensionFinalSettBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;

import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PensionFinalSettBusinessObject  extends BaseBO{
    
    public PensionFinalSettBusinessObject() {
        
    }


    /**
     * @param oLovQueryVO
     * @return
     * @throws EnrgiseSystemException
     * @throws EnrgiseApplicationException
     */
    public LovVO getPensionEmpLovQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnSancType"))));   
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_GetEmpLovQ(?,?,?,?,?,?,?)");
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

    /**
     * @param oLovQueryVO
     * @return
     * @throws EnrgiseSystemException
     * @throws EnrgiseApplicationException
     */
    public LovVO getPensionEmpLovN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {  
      LovVO oLovVO=new LovVO();  
      ArrayList arylstHeaderNames=new ArrayList();
      arylstHeaderNames.add("Employee No");    
      arylstHeaderNames.add("Employee Name");    
      arylstHeaderNames.add("Designation");        
      arylstHeaderNames.add("CategoryDesc");    
      arylstHeaderNames.add("Emp Type");        
      arylstHeaderNames.add("CPF Code");    
      arylstHeaderNames.add("Location");  
      arylstHeaderNames.add("Emp Status");  
      arylstHeaderNames.add("Staff Code");
      arylstHeaderNames.add("Emp Birth Date");
      arylstHeaderNames.add("Pension Id");
      arylstHeaderNames.add("Retirement Date");
      
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
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));  
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_GetEmpLovN(?,?,?,?,?,?,?)");
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
          oLOVBean.setDetailField4(oRow.get("emp_categ").getString());           
          oLOVBean.setDetailField5(oRow.get("emp_type").getString());           
          oLOVBean.setDetailField6(oRow.get("cpf_code").getString());                    
          oLOVBean.setDetailField7(oRow.get("loc_sdesc").getString());                 
          oLOVBean.setDetailField8(oRow.get("emp_stat").getString());
          oLOVBean.setDetailField9(oRow.get("staff_code").getString());                  
          oLOVBean.setDetailField10(EnrgiseUtil.convertToString(oRow.get("emp_birth_date").getDate()));
          oLOVBean.setDetailField11(oRow.get("pension_number").getString());
          oLOVBean.setDetailField12(EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
                
        oList.add(oLOVBean);
      }
       
        oLovVO.setDetailList(oList);
      return oLovVO;
    }

    /**
     * @param oPensionFinalSettQueryVO
     * @return
     * @throws EnrgiseSystemException
     * @throws EnrgiseApplicationException
     */
    public ArrayList getPensionFinalDtls(PensionFinalSettQueryVO oPensionFinalSettQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException{
       ArrayList oParameters = new ArrayList(); //Input Parameters
       DBUtilitiesBean oBean = new DBUtilitiesBean();
       ArrayList oOutArray; //Output  
       ArrayList oList;
       int count;
       count = 0;
       
       PensionFinalSettBean oPensionFinalSettBean;
       oParameters = new ArrayList();
       oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(1)));
       oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(1)));
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oPensionFinalSettQueryVO.getLoginLocCode())));
       oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oPensionFinalSettQueryVO.getTxtEmpNo()));
       oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPensionFinalSettQueryVO.getTxtAnnuSubDt())));
       oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
       oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
       
       oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_GetEmpPensionBal(?,?,?,?,?,?,?)",true,false);
       
         DBObject oErrCode = (DBObject)oOutArray.get(1);
         Integer errCode=(Integer)oErrCode.getObject();
         if(!errCode.equals(new Integer(0)))
         {
           System.out.println("Error!!! while getting Pension Final Details");
           throw new EnrgiseApplicationException("Pay.Payroll_ERROR"); 
         }
       
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
          oPensionFinalSettBean=new PensionFinalSettBean();
          oPensionFinalSettBean.setEmpContri(oRow.get("employee_contribution").getString());
          oPensionFinalSettBean.setEmplyrContri(oRow.get("employer_contribution").getString());
          oPensionFinalSettBean.setTxtVPFCont(oRow.get("vpf_contribution").getString());
          oPensionFinalSettBean.setTxtTotalInt(oRow.get("total_interest").getString());
          oPensionFinalSettBean.setSancAmount(oRow.get("sanction_amount").getString());
          oList.add(oPensionFinalSettBean);
        }
     return oList;
    }

    /**
     * @param oPensionFinalSettQueryVO
     * @return
     * @throws EnrgiseSystemException
     * @throws EnrgiseApplicationException
     */
    public RecordMetaInfo getPensionFinSettHeaderMetaInfo(PensionFinalSettQueryVO oPensionFinalSettQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException{
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      Timestamp oWhenPicked = null;
      int count = 0;
      BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
      ArrayList oOutArray; //Output 
      String screenName=oPensionFinalSettQueryVO.getScreenName();
      String locCode = oPensionFinalSettQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettQueryVO.getHdnEmpLbrFlag())));        
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      
      //oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
            
      oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_GetPensionCnt(?,?,?,?,?)");
              
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
      //DBObject oTimeObject = (DBObject)oOutArray.get(1);
      //oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    }


    /**
     * @param oPensionFinalSettQueryVO
     * @param lStartPosition
     * @param lLastPosition
     * @return
     * @throws EnrgiseSystemException
     * @throws EnrgiseApplicationException
     */
    public ArrayList getPensionFinSettHeader(PensionFinalSettQueryVO oPensionFinalSettQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;

      if(oPensionFinalSettQueryVO == null)
      {
        oPensionFinalSettQueryVO = new PensionFinalSettQueryVO();
      }

      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;  
      String screenName=oPensionFinalSettQueryVO.getScreenName();
      String locCode = oPensionFinalSettQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettQueryVO.getTxtCpfCode())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettQueryVO.getTxtEmpName())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettQueryVO.getHdnEmpLbrFlag())));        
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
            
      oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_GetEmpDtlQry(?,?,?,?,?,?,?)");
            
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      PensionFinalSettBean oPensionFinalSettBean;
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
          oPensionFinalSettBean = new PensionFinalSettBean();
            oPensionFinalSettBean.setHeaderPrimaryKey(oRow.get("seq_no").getString());
            oPensionFinalSettBean.setTxtEmpNo(oRow.get("emp_num").getString());
            oPensionFinalSettBean.setTxtEmpName(oRow.get("emp_name").getString());
            oPensionFinalSettBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
            oPensionFinalSettBean.setTxtCateg(oRow.get("emp_categ").getString()); 
            oPensionFinalSettBean.setTxtEmpType(oRow.get("emp_type").getString());                
            oPensionFinalSettBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
            oPensionFinalSettBean.setTxtPresentPOP(oRow.get("loc_sdesc").getString());       
            oPensionFinalSettBean.setTxtStaffCode(oRow.get("staff_code").getString());
            oPensionFinalSettBean.setTxtEmpStatus(oRow.get("emp_stat").getString());
          
            oPensionFinalSettBean.setTxtPensionId(oRow.get("pension_number").getString());                      
            oPensionFinalSettBean.setTxtDOB(EnrgiseUtil.convertToString(oRow.get("emp_birth_date").getDate()));
            oPensionFinalSettBean.setTxtRetirementDt(EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
          
            oPensionFinalSettBean.setTxtSysSantionNum(oRow.get("system_sanc_no").getString());
            oPensionFinalSettBean.setTxtAnnuSubDt(EnrgiseUtil.convertToString(oRow.get("annuity_sancdt").getDate()));
          
            oPensionFinalSettBean.setEmpContri(oRow.get("employee_contribution").getString());
            oPensionFinalSettBean.setSancOrderNo(oRow.get("sanc_order_no").getString());
            oPensionFinalSettBean.setEmplyrContri(oRow.get("employer_contribution").getString());
            oPensionFinalSettBean.setTxtAnnuityProv(oRow.get("annuity_prov").getString());
            oPensionFinalSettBean.setTxtVPFCont(oRow.get("vpf_contribution").getString());
            oPensionFinalSettBean.setTxtPensionType(oRow.get("pension_type").getString());
            oPensionFinalSettBean.setTxtTotalInt(oRow.get("total_interest").getString());
            oPensionFinalSettBean.setSancAmount(oRow.get("sanction_amount").getString());
          
            oPensionFinalSettBean.setTxtAnnuityStartDt(EnrgiseUtil.convertToString(oRow.get("annuity_stdt").getDate()));
            oPensionFinalSettBean.setTxtAnnuityNum(oRow.get("annuity_no").getString());
            //oPensionFinalSettBean.setTxtActualSettPrinc(oRow.get("act_sett_prin").getString());
            oPensionFinalSettBean.setTxtSettlAmount(oRow.get("settlement_amt").getString());
            oPensionFinalSettBean.setTxtPurchagePric(oRow.get("purchse_price").getString());
            oPensionFinalSettBean.setTxtFM(oRow.get("gst_charges").getString());
            oPensionFinalSettBean.setTxtAnnuityFreq(oRow.get("annuity_freq").getString());
            oPensionFinalSettBean.setTxtAnnuityAmount(oRow.get("annuity_amt").getString());
            oPensionFinalSettBean.setTxtDateOfExit(EnrgiseUtil.convertToString(oRow.get("exitdate").getDate()));
            oPensionFinalSettBean.setFinAnnuityFlag(oRow.get("fin_annuity_flag").getString());
          
          String cancelStatus=oRow.get("cancel_flag").getString();
          String cancelDate=EnrgiseUtil.convertToString(oRow.get("cancel_dt").getDate());
          
          if(cancelStatus!=null && cancelStatus.equals("Y"))
            oPensionFinalSettBean.setCancelStatus("Sanction Order Cancelled on "+cancelDate);
          else
            oPensionFinalSettBean.setCancelStatus("");
          oHeaderList.add(oPensionFinalSettBean);
        }  
        
      return oHeaderList;
      
    }

    /**
     * @param oBaseHeaderBean
     * @return
     * @throws EnrgiseSystemException
     * @throws EnrgiseApplicationException
     */
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;    
      int count = 0;
      int i=0;
      PensionFinalSettBean oPensionFinalSettBean = (PensionFinalSettBean)oBaseHeaderBean;
      ArrayList oOutArray=new ArrayList(); //Output   
      
        oParameters = new ArrayList();
        
        if(oPensionFinalSettBean.getHdnSancType().equals("A")||oPensionFinalSettBean.getHdnSancType().equals("P"))
        {
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getSancOrderNo())));      
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oPensionFinalSettBean.getSancDate())));      
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getHdnSancType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtEmpNo())));      
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getSancAmount())));      
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getNoInstallAmt())));      
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getInstallAmt())));            
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getFirstInstall()))); 
          
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getRecoveryYYMM())));     
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getWithdrEmpContri())));     
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getWithdrVpfContri())));      
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getWithdrEmplyrContri()))); 
          
                     
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtReason())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getIntInstall())));      
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getNoIntInstall())));
          
               
        //  oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtDedIT())));
          
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtUserID())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtSiteID()))); 
          //Added by Ankit on 16-June-2014
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean. getEmpContri()))); 
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getEmplyrContri()))); 
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getVpfContri()))); 
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtApplAmt()))); 
          
          oParameters.add(new DBObject(22,DBObject.OUT,ParameterTypes.VARCHAR)); 
          oParameters.add(new DBObject(23,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(24,DBObject.OUT,ParameterTypes.INTEGER));     
          oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_GenratePensionSanc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
        }
        else
        {
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oPensionFinalSettBean.getTxtAnnuSubDt())));      
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getSancOrderNo())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtAnnuityProv())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtPensionType())));            

          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getEmpContri())));      
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtVPFCont())));      
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getEmplyrContri())));    
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtTotalInt())));    
          
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtUserID())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtSiteID()))); 
          
          oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR)); 
          oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.INTEGER));     
          oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_GenratePensionSanc(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
        
        }
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        DBObject oErrMsg = (DBObject)oOutArray.get(1);
        DBObject oErrCode = (DBObject)oOutArray.get(2);
        Integer errCode=(Integer)oErrCode.getObject();
        if(!errCode.equals(new Integer(0)))
        {
          ArrayList oArguments = new ArrayList();
          oArguments.add((String)oErrMsg.getObject());
          System.out.println("Error!!! while Releasing Final Payment record CPF  ::"+oErrMsg.getObject());
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        }
        return (String)oOutObject.getObject();      
    }

    // THIS METHOD CANCELS THE SANCTION ORDER.
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
    {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    PensionFinalSettBean oPensionFinalSettBean = (PensionFinalSettBean)oBaseHeaderBean;
    ArrayList oOutArray=new ArrayList(); //Output   
    
      oParameters = new ArrayList();
      
    if(!oPensionFinalSettBean.getSaveAnnuityFlag().equals("Y"))
      {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getSancOrderNo())));     
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtSiteID()))); 
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtUserID())));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));     
        oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.proc_Pension_Sanc_Order_Canc(?,?,?,?,?,?)",true,true);        
      }else{
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oPensionFinalSettBean.getTxtAnnuityStartDt())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtAnnuityNum())));
          //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtActualSettPrinc())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtSettlAmount())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtPurchagePric())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtFM())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtAnnuityFreq())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtAnnuityAmount())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtDateOfExit())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtUserID())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oPensionFinalSettBean.getTxtSiteID()))); 
          oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER));     
          oOutArray = oBean.callProc(oParameters,"PKG_PENSION_FINAL_SETTLEMENT.Proc_Insert_Annuity_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
      }
          DBObject oErrMsg = (DBObject)oOutArray.get(0);
          DBObject oErrCode = (DBObject)oOutArray.get(1);
          Integer errCode=(Integer)oErrCode.getObject();
      if(!errCode.equals(new Integer(0)))
      {
        ArrayList oArguments = new ArrayList();
        oArguments.add((String)oErrMsg.getObject());
        System.out.println("Error!!! while Cancelling Sanction Order ::"+oErrMsg.getObject());
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
    }
   
    
    @Override
    public void saveDetailImpl(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, String sScreenName,
                               ArrayList oDetailBeanArray) {
    }

    @Override
    public void initializeBOImpl(String sScreenName) {
    }

    @Override
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                              String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                              ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                              Timestamp oDetailPicked) {
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
                                                 Timestamp oDetailPicked) {
    }
}
