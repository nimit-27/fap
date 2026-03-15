package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintAnnIncQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintAnnIncHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintDARateBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;

import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class AnnIncBusinessObject extends BaseBO 
{
  public AnnIncBusinessObject()
  {
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintAnnIncHeaderBean oMaintAnnIncHeaderBean = (MaintAnnIncHeaderBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtGrossIncome())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTaxableIncome())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHRA())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTaxableHrr())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtIncomeTaxPaid())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtProfessionalTax())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtMedicalReimb())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHRPaid())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTaxDueToAppor())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtApporAmt())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtExternalIncome())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtGIS())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtCPF())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtEPF())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtFPF())));
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtLIC())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtVPF())));
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtOtherDedn())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHbaInt())));
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHbaPrincipal())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtSalPrevEmployer())));
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtExternalITPaid())));
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHouseRent())));
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtIncomeTax())));
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtCTD())));
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtPLI())));
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtULI())));
      oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtGPF())));
//      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtIntDiffPerq())));
      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtEdnCessPaid())));                  
      oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtMthEdnCess())));      
      oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtENCPF())));            
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtBonus())));                  
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtFinYYMM())));            
      
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(37,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateAnnIncome(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintAnnIncHeaderBean oMaintAnnIncHeaderBean = (MaintAnnIncHeaderBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtGrossIncome())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTaxableIncome())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHRA())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTaxableHrr())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtIncomeTaxPaid())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtProfessionalTax())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtMedicalReimb())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHRPaid())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTaxDueToAppor())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtApporAmt())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtExternalIncome())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtGIS())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtCPF())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtEPF())));
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtFPF())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtLIC())));
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtVPF())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtOtherDedn())));
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHbaInt())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHbaPrincipal())));
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtSalPrevEmployer())));
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtExternalITPaid())));
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtHouseRent())));
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtIncomeTax())));

      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtCTD())));
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtPLI())));
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtULI())));
      oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtGPF())));
//      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtIntDiffPerq())));
      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtEdnCessPaid())));
      oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtMthEdnCess())));
      oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtENCPF())));      
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtBonus())));            
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtFinYYMM())));      

      
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(37,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTransportAllowance())));
      oParameters.add(new DBObject(38,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtTransportRebate())));    
      oParameters.add(new DBObject(39,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(40,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertAnnIncome(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();
      
  }


  public RecordMetaInfo getAnnIncHeaderMetaInfo(MaintAnnIncQueryVO oMaintAnnIncQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncQueryVO.getTxtFinYYMM())));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAnnIncomeCount(?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }




  public ArrayList getAnnIncHeader(MaintAnnIncQueryVO oMaintAnnIncQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintAnnIncQueryVO == null)
    {
      oMaintAnnIncQueryVO = new MaintAnnIncQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncQueryVO.getTxtFinYYMM())));      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAnnIncomeDetailNew(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintAnnIncHeaderBean oMaintAnnIncHeaderBean;
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
          oMaintAnnIncHeaderBean = new MaintAnnIncHeaderBean();
          oMaintAnnIncHeaderBean.setHeaderPrimaryKey(oRow.get("emp_num").getString());
          oMaintAnnIncHeaderBean.setTxtEmpNo(oRow.get("emp_num").getString());
          oMaintAnnIncHeaderBean.setTxtEmpName(oRow.get("Name").getString());
          oMaintAnnIncHeaderBean.setTxtApporAmt(oRow.get("apportioned_amt").getString());
          oMaintAnnIncHeaderBean.setTxtCPF(oRow.get("ytm_cpf").getString());
          oMaintAnnIncHeaderBean.setTxtEPF(oRow.get("ytm_epf").getString());
          oMaintAnnIncHeaderBean.setTxtExternalIncome(oRow.get("external_income").getString());
          oMaintAnnIncHeaderBean.setTxtExternalITPaid(oRow.get("ytm_high_edu_cess").getString());
          oMaintAnnIncHeaderBean.setTxtFPF(oRow.get("ytm_fpf").getString());
          oMaintAnnIncHeaderBean.setTxtGIS(oRow.get("ytm_gis").getString());
          oMaintAnnIncHeaderBean.setTxtGrossIncome(oRow.get("ytm_gross_erng").getString());
          oMaintAnnIncHeaderBean.setTxtHbaInt(oRow.get("hba_interest").getString());
          oMaintAnnIncHeaderBean.setTxtHbaPrincipal(oRow.get("hba_principal").getString());
          oMaintAnnIncHeaderBean.setTxtHouseRent(oRow.get("mth_rent").getString());
          oMaintAnnIncHeaderBean.setTxtHRA(oRow.get("ytm_hra").getString());
          oMaintAnnIncHeaderBean.setTxtHRPaid(oRow.get("ytm_rent_paid").getString());
          oMaintAnnIncHeaderBean.setTxtIncomeTax(oRow.get("mthly_tax_dedn_amt").getString());
          oMaintAnnIncHeaderBean.setTxtIncomeTaxPaid(oRow.get("ytm_it_paid").getString());
          oMaintAnnIncHeaderBean.setTxtLIC(oRow.get("ytm_lic").getString());
          oMaintAnnIncHeaderBean.setTxtMedicalReimb(oRow.get("ytm_surcharge").getString());
          oMaintAnnIncHeaderBean.setTxtOtherDedn(oRow.get("other_deductions").getString());
          oMaintAnnIncHeaderBean.setTxtProfessionalTax(oRow.get("ytm_prof_tax").getString());
          oMaintAnnIncHeaderBean.setTxtSalPrevEmployer(oRow.get("sal_prev_employer").getString());
          oMaintAnnIncHeaderBean.setTxtTaxableHrr(oRow.get("ytm_taxable_hrr").getString());
          oMaintAnnIncHeaderBean.setTxtTaxableIncome(oRow.get("ytm_taxable_erng").getString());
          oMaintAnnIncHeaderBean.setTxtTaxDueToAppor(oRow.get("tax_due_to_apportion").getString());
          oMaintAnnIncHeaderBean.setTxtVPF(oRow.get("ytm_vpf").getString());

          oMaintAnnIncHeaderBean.setTxtCTD(oRow.get("YTM_CTD").getString());
          oMaintAnnIncHeaderBean.setTxtPLI(oRow.get("YTM_PLI").getString());
          oMaintAnnIncHeaderBean.setTxtULI(oRow.get("YTM_ULI").getString());
          oMaintAnnIncHeaderBean.setTxtGPF(oRow.get("YTM_GPF").getString());
//          oMaintAnnIncHeaderBean.setTxtIntDiffPerq(oRow.get("INTERST_DIFF_PERK").getString());
          oMaintAnnIncHeaderBean.setTxtEdnCessPaid(oRow.get("YTM_EDN_CESS").getString());
          oMaintAnnIncHeaderBean.setTxtMthEdnCess(oRow.get("MTH_EDN_CESS").getString());
          oMaintAnnIncHeaderBean.setTxtENCPF(oRow.get("YTM_ENCPF").getString());          
          oMaintAnnIncHeaderBean.setTxtBonus(oRow.get("YTM_BONUS").getString());                    
          oMaintAnnIncHeaderBean.setTxtFinYYMM(oRow.get("FIN_YYMM").getString());
          
          oHeaderList.add(oMaintAnnIncHeaderBean);
      }
      
        
    return oHeaderList;
  }


  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("DaRatesScreen"))
    {
      saveDARates(sHeaderPrimaryKey,oDetailBeanArray);
    }
    
  }

  public LovVO getAnnIncLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF COde");    

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
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(5,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetAnnIncEmpLOV(?,?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("emp_no").getString());            
       oLOVBean.setDetailField2(oRow.get("Name").getString());            
       oLOVBean.setDetailField3(oRow.get("cpf_code").getString());            

      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public LovVO getQueryAnnIncLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_AnnIncLOVQuery(?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("Name").getString());            
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());            

      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }



  public LovVO getAnnIncFinYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Financial Period");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryAnnIncFinYYMMLOV(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("FIN_YYMM").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }  
  
  private void saveDARates(String sPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
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
      if(sScreenName.equals(EnrgiseConstants.NEW_MODE))
      {
          checkEmpNo(oBaseHeaderBean,oList);        
      }
    reportError(oList);        
  }


  private void checkDuplicateCheck(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
     
    checkEmpNo(oBaseHeaderBean,oList);        
    reportError(oList);
        
  }
  
  
/*  private void checkFirst(BaseHeaderBean oBaseHeaderBean,ArrayList oList)
  {
    if(1 == 1)
    {
      oList.add(new EnrgiseApplicationException("wenrgise.sysadmin.error.first"));
    }
  } */
  
  private void checkEmpNo(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        MaintAnnIncHeaderBean oMaintAnnIncHeaderBean = (MaintAnnIncHeaderBean)oBaseHeaderBean;

          String empNo = oMaintAnnIncHeaderBean.getTxtEmpNo();

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getHeaderPrimaryKey())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncHeaderBean.getTxtFinYYMM())));          
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_AnnIncCheck(?,?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              oList.add(new EnrgiseApplicationException("payroll.AnnInc.duplicatecheck"));
            }         
  }

  
  
}