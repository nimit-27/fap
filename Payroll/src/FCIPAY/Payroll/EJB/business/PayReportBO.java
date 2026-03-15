package FCIPAY.Payroll.EJB.business;
import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.LOVBean;

import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.UserInfo;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
//import IBA.Payroll.Bean.PayGenerateTransactionScheduleHdrBean;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
//import IBA.Payroll.UTILITY.PayGeneratePaySlipHdrBean;
public class PayReportBO extends BaseBO
{
  public PayReportBO()
  {
  }
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    return;    
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;        
    if(sScreenName.equals("EnqPayImgScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  /*

//////////////////////////////FOR PAY SLIP TO GET ALL THE EMPLOYEES NAME AND NO////////////////
public LovVO getEmpNameReportLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
{
  String sQuery = "Select distinct hep.ID,hep.Emp_No,hep.First_Name || ' ' || hep.Middle_Name || ' ' || hep.Last_Name FULLNAME from hrm_emp_pers hep,pay_image pim where pim.e_per_dtl_id=hep.ID";
    if(oLovQueryVO.getSearchField1() != null)
    {
      sQuery = sQuery + " and  Emp_No LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
      if(oLovQueryVO.getSearchField2() != null)
    {
      sQuery = sQuery + " and First_Name || ' ' || Middle_Name || ' ' || Last_Name LIKE '%" + oLovQueryVO.getSearchField2() + "%' ";
    }

    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("Payroll.GenerateReport.id");
    oHeaderList.add("Payroll.GenerateReport.nameEmp");
    oHeaderList.add("Payroll.GenerateReport.empNo");
    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          
          oLOVBean.setDetailField1(oRow.get("ID").getString());
          oLOVBean.setDetailField2(oRow.get("Emp_No").getString());
          oLOVBean.setDetailField3(oRow.get("FULLNAME").getString());
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


public LovVO getPaySlipYearMonthLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yyyymm from pay_image pim where 1=1";
    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yyyymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
   
    sQuery = sQuery + " ORDER BY pim.yyyymm";
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("Payroll.GenerateReport.yyyymm");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
     
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailField1(oRow.get("yyyymm").getString());
         
           //oLOVBean.setDetailField3(EnrgiseUtil.convertToString(oRow.get("PI_DATE").getDate()));
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


///////////////////////////////////////////FOR TRANSACTION SCHEDULE////////////////////////

public LovVO getReportPayCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
   {
    String sQuery = "select distinct pc.id, pc.pay_code, pc.pay_code_desc from pay_codes pc where pay_code between 100 and 999";
    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pc.pay_code LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField2()))
    {
        sQuery = sQuery + " and  pc.pay_code_desc LIKE '%" + oLovQueryVO.getSearchField2() + "%' ";
    }
      sQuery = sQuery + " ORDER BY pay_code";
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("payroll.transaction.id");
    oHeaderList.add("payroll.transaction.pay_code");
    oHeaderList.add("payroll.transaction.pay_code_desc");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailField1(oRow.get("id").getString());
          oLOVBean.setDetailField2(oRow.get("pay_code").getString());
          oLOVBean.setDetailField3(oRow.get("pay_code_desc").getString());

           //oLOVBean.setDetailField3(EnrgiseUtil.convertToString(oRow.get("PI_DATE").getDate()));
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
} 

public LovVO getReportYearMonthLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yyyymm from pay_image pim where 1=1";
    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yyyymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
   
    sQuery = sQuery + " ORDER BY pim.yyyymm";
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("Payroll.GenerateReport.yyyymm");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
     
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailField1(oRow.get("yyyymm").getString());
         
           //oLOVBean.setDetailField3(EnrgiseUtil.convertToString(oRow.get("PI_DATE").getDate()));
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}
//////////////////////////////////////FOR PF RECOVERY SCHEDULE/////////////////////

public LovVO getReportPFRecYearMonthLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pepd.yyyymm from pay_emp_pf_dtl pepd  where 1=1";
    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pepd.yyyymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
   
    sQuery = sQuery + " ORDER BY pepd.yyyymm";
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("Payroll.GenerateReport.yyyymm");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
     
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailField1(oRow.get("yyyymm").getString());
         
           
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


/////////////////////////////////FOR  GENERATING PAYROLL  REPORT ///////////////////////////

public LovVO getReportPayrollSummaryYearMonthLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yyyymm from pay_image pim  where 1=1";
    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yyyymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
   
    sQuery = sQuery + " ORDER BY pim.yyyymm";
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("Payroll.GenerateReport.yyyymm");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
     
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailField1(oRow.get("yyyymm").getString());
         
           
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}






//////////////////////////////////FOR GENERATING FORM 16 //////////////////////////////

public LovVO getEmpNameGenerateFormSixteenLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
{
  String sQuery = "Select distinct hep.ID,hep.Emp_No,hep.First_Name || ' ' || hep.Middle_Name || ' ' || hep.Last_Name FULLNAME from hrm_emp_pers hep,pay_emp_mast pem where pem.e_per_dtl_id=hep.ID";
    if(oLovQueryVO.getSearchField1() != null)
    {
      sQuery = sQuery + " and  Emp_No LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
      if(oLovQueryVO.getSearchField2() != null)
    {
      sQuery = sQuery + " and First_Name || ' ' || Middle_Name || ' ' || Last_Name LIKE '%" + oLovQueryVO.getSearchField2() + "%' ";
    }

    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("Payroll.GenerateReport.id");
    oHeaderList.add("Payroll.GenerateReport.Emp_No");
    oHeaderList.add("Payroll.GenerateReport.FULLNAME");
    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          
          oLOVBean.setDetailField1(oRow.get("ID").getString());
          oLOVBean.setDetailField2(oRow.get("Emp_No").getString());
          oLOVBean.setDetailField3(oRow.get("FULLNAME").getString());
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


//////////////////////////////////////FOR BANK STATEMENT///////////////////////////

public LovVO getReportBankCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct hep.BANK_SAL_ACC_CD  from hrm_emp_pers hep where 1=1";
    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  hep.BANK_SAL_ACC_CD LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
   
    sQuery = sQuery + " ORDER BY hep.BANK_SAL_ACC_CD";
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("Payroll.GenerateReport.BANK_SAL_ACC_CD");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
     
    oLovVO.setVisibilityList(arylstVisibility);
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailField1(oRow.get("BANK_SAL_ACC_CD").getString());
         
           //oLOVBean.setDetailField3(EnrgiseUtil.convertToString(oRow.get("PI_DATE").getDate()));
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}
////////////////////////////////////TRANSACTION SCHEDULE ALL////////////////
public boolean GetTransactionScheduleAll(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException,EnrgiseApplicationException

	{
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters=new ArrayList();
    
     PayGenerateTransactionScheduleHdrBean oPayGenerateTransactionScheduleHdrBean=(PayGenerateTransactionScheduleHdrBean)oBaseHeaderBean;   
        if(oPayGenerateTransactionScheduleHdrBean.getTxtAllPayCodeFlag().equalsIgnoreCase("A"))
        {
        //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPayGenerateTransactionScheduleHdrBean.getTxtAllPayCodeFlag()));
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPayGenerateTransactionScheduleHdrBean.getTxtYYMM()));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oBean.callProc(oParameters,"PKG_RPT_TRANSACTION.proc_GetQuotaionInfo(?,?,?,?)");
        }
       return true;
  }

//////////////////////////////////FOR ALL PAYSLIP///////////////

public boolean GetPaySlipAll(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException,EnrgiseApplicationException

	{
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters=new ArrayList();
    
     PayGeneratePaySlipHdrBean oPayGeneratePaySlipHdrBean=(PayGeneratePaySlipHdrBean)oBaseHeaderBean;   
        if(oPayGeneratePaySlipHdrBean.getTxtAllEmpFlag().equalsIgnoreCase("A"))
        {
        
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPayGeneratePaySlipHdrBean.getTxtYYMM()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oPayGeneratePaySlipHdrBean.getMsgOfTheMonth()));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oBean.callProc(oParameters,"PKG_RPT_PAYSLIP.proc_GetPaySlipInfo(?,?,?,?,?)");
        }
       return true;
  }
*/
//////////////////////////////////////////////////////////////////////////////
public void initializeBOImpl()
{
}

  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    System.out.println("Save Ille!");
    
  }
  
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
   System.out.println("Update ille!");  
  }
  
   public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
  
    return "saveNewHeaderImpl ille!";  
  }

  public String saveHeaderImpl(BaseHeaderBean oBaseHeaderBean,String ScreenMode) throws EnrgiseSystemException
  {
  
  return  new String();
  }
   public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
	{
	}

  public void additionalTimestampValidationImpl(BaseHeaderBean param1, java.sql.Timestamp param2, java.lang.String param3, java.lang.String param4, boolean param5, java.util.ArrayList param6, boolean param7, java.sql.Timestamp param8)
	{
	}
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
	{
	} 
  
}


