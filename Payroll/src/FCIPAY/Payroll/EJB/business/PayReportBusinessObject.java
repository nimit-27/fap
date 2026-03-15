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
import FCIPAY.Payroll.UTILITY.ECSDataFileHdrBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayReportComboVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;
//import IBA.Payroll.UTILITY.PayGeneratePaySlipHdrBean;
public class PayReportBusinessObject extends BaseBO
{
  public PayReportBusinessObject()
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






//////////////////////////////////FOR GENERATING FORM 16 //////////////////////////////
public LovVO getEmpNameGenerateFormSixteenLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code"); // added by 'Swapnendu' on 13-08-2010.
   // arylstHeaderNames.add("Middle Name");
  //  arylstHeaderNames.add("Last Name");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;

    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;

    String empType=oLovQueryVO.getProperty("hdnEmpLbrFlag");
    //String screenname=oLovQueryVO.getProperty("screenname");

    if(empType==null || empType.equals(""))
    {
      empType="E";
    }else
    {
      System.out.println("EmpType is"+empType);
    }

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
   /*if (screenname.equals("MiscRecoveryRep"))
    {
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String("")));

    }
    else
    {*/
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
   // }    
	oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(empType)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      String screenname;
      screenname = oLovQueryVO.getProperty("screenName");

      if(screenname==null || screenname.equals(""))
      {
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCodelov(?,?,?,?,?,?,?)");
      }
      else
      {
        System.out.println("screenname is"+screenname);
          if (screenname.equals("PrmsMediClaimReport"))
          {
              oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_GetEmpCodelov(?,?,?,?,?,?,?)");
          } 
          else {
              oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCodelov(?,?,?,?,?,?,?)");
          }
      }

        DBObject oOutObject;
        oOutObject = (DBObject) oOutArray.get(0);
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

      oList.add(oLOVBean);
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }



/* Added by jatin 0n 16 aug 2012 */
  public LovVO getEmpNamePaySlip(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code"); // added by 'Swapnendu' on 13-08-2010.
   // arylstHeaderNames.add("Middle Name");
  //  arylstHeaderNames.add("Last Name");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;

    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;

    String empType=oLovQueryVO.getProperty("hdnEmpLbrFlag");    
    String gngCode=oLovQueryVO.getProperty("txtLocId");
    String dptCode=oLovQueryVO.getProperty("headerPrimaryKey");
    
    if(gngCode.equals("0"))
    {
        gngCode="";
    }
    
    if(dptCode.equals("0"))
    {
        dptCode="";
    }
    System.out.println(gngCode+ dptCode);
    if(empType==null || empType.equals(""))
    {
      empType="E";
    }else
    {
      System.out.println("EmpType is"+empType);
    }

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(empType)));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,gngCode));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,dptCode));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));

    //same procedure as used in Employee Info Master-- dt 15 Oct 2007
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCodelov_Payslip(?,?,?,?,?,?,?,?,?)");
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

      oList.add(oLOVBean);
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }

//lov for employees in LPC report.
  public LovVO getEmpLastPayCertifReportLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
   // arylstHeaderNames.add("Middle Name");
  //  arylstHeaderNames.add("Last Name");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    ArrayList oOutArray; //Output
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(empType)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));

    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpLPClov(?,?,?,?,?,?,?)");
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

      oList.add(oLOVBean);
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getEmpCPFLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
   // arylstHeaderNames.add("Middle Name");
  //  arylstHeaderNames.add("Last Name");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
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

    //same procedure as used in Employee Info Master-- dt 15 Oct 2007
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetCPFEmpLovN(?,?,?,?,?,?)");
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

      oList.add(oLOVBean);
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  ///////////////////////////////////////////ADDED BY KRITI
  public LovVO getEmpPnsnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("CPF Code");
   // arylstHeaderNames.add("Middle Name");
  //  arylstHeaderNames.add("Last Name");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
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

    //same procedure as used in Employee Info Master-- dt 15 Oct 2007
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getempcodepensionlov(?,?,?,?,?,?)");
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
        oLOVBean.setDetailField3(oRow.get("cpf_code").getString());

      oList.add(oLOVBean);
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }

///////////////////////////////////////////LICENCE FEE///////////////////////////////////
public LovVO getLicenceFeeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


/////////////////////////////////EOLHPL///////////////////////////////////
public LovVO getEOLHPLLOVYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


////////////////YrBonusAward Statement Report/////////////
public LovVO getYrBonusAwardYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}

////////////////Pay Generate rec earnings Report/////////////
public LovVO getPayGenRecEarningsYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}

public LovVO getRecEarnPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
    String sQuery = "select distinct pc.pay_code,pc.pay_code_desc from pay_codes pc where 1=1 and pc.pay_code < = 900";
    if(oLovQueryVO.getSearchField1() != null)
    {
        sQuery = sQuery + " and  pc.pay_code LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    if(oLovQueryVO.getSearchField2() != null)
    {
        sQuery = sQuery + " and  pc.pay_code_desc LIKE '%" + oLovQueryVO.getSearchField2() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pc.pay_code";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("PayCode");
    oHeaderList.add("pay_code_desc");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("pay_code").getString());
          oLOVBean.setDetailField2(oRow.get("pay_code_desc").getString());

          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


public LovVO getPayGenRecEarningsAgencyCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct agency_code,agency_name  from pay_agency_mst where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  agency_code LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY agency_code";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("AgencyCode");
    oHeaderList.add("AgencyName");
    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
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
          oLOVBean.setDetailField1(oRow.get("agency_code").getString());

          oLOVBean.setDetailField2(oRow.get("agency_name").getString());

          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}

////////////////Monthly Leave Details Report/////////////
public LovVO getMonthlyLeaveDetailsYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());

          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}

////////////////////
////////////////SalStatementYear Report/////////////
public LovVO getSalStatementYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}
/////////////////////GenerateBankStatement/////////////
public LovVO getBankStatementCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
{
 // String sQuery = "Select distinct hep.Emp_No,hep.First_Name || ' ' || hep.Middle_Name || ' ' || hep.Last_Name FULLNAME from hrm_employee hep ";
 String sQuery = "Select distinct bank_code,bank_name BANKNAME from pay_bank_mast where 1=1 ";
    if(oLovQueryVO.getSearchField1() != null)
    {
      sQuery = sQuery + " and  bank_code LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
      if(oLovQueryVO.getSearchField2() != null)
    {
      sQuery = sQuery + " and upper(bank_name) LIKE '%" + oLovQueryVO.getSearchField2().toUpperCase() + "%' ";
    }

//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();

    oHeaderList.add("Bank Code");
    oHeaderList.add("Bank Name");
    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();

    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
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


          oLOVBean.setDetailField1(oRow.get("bank_code").getString());
          oLOVBean.setDetailField2(oRow.get("BANKNAME").getString());
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}
////////////////Generate Upgrade Allowance ReportReport/////////////
public LovVO getUpgradeAllowanceYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}
////////////////Generate Canteen Subsidy Report/////////////
public LovVO getCanteenSubsidyYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}
////////////////Pay Slip Report/////////////
public LovVO getPaySlipYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {

    String sMaxYYMM=oLovQueryVO.getProperty("hdnMaxYYMM").trim();

    String sQuery = "select distinct pim.yymm  from pay_image pim where yymm >= 200609 ";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

     sQuery = sQuery + " and  pim.yymm <= " + sMaxYYMM + " ";

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


public LovVO getPaySlipLoc(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
    String sQuery = "SELECT DISTINCT(location_code) FROM pay_emp_mast;";
/*    if(EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    } */

//    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
//    oHeaderList.add("Location");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
//    arylstVisibility.add(EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("location_code").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


////////////////////

//IT Forecast Report
public LovVO getITForecastYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}

public LovVO getBankStatementYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yymm  from pay_image pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("yymm").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}

public LovVO getITForecastEmp(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "SELECT DISTINCT IT.EMP_NUM, P.EMP_NAME FROM PAY_IT_FORECAST IT, PAY_EMP_MAST P WHERE IT.EMP_NUM = P.EMP_NUM";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  it.emp_num LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField2()))
    {
        sQuery = sQuery + " and  upper(p.emp_name) LIKE '%" + oLovQueryVO.getSearchField2().toUpperCase() + "%' ";
    }

    sQuery = sQuery + " ORDER BY it.emp_num";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("emp_num");
    oHeaderList.add("Emp_Name");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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
          oLOVBean.setDetailField1(oRow.get("emp_num").getString());
          oLOVBean.setDetailField2(oRow.get("emp_name").getString());


          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}

////////////////////
//End IT Forecast Report


//ECS Data File Report
public LovVO getECSDataFileYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct pim.yyyymm from pay_ecs_data_file_report pim where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  pim.yyyymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY pim.yyyymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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

public String GenerateECSDataFile(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  //public void GenerateECSDataFile(String YYMM,String SponserBankMICR, String UserAccntNo, String UserNo, String UserName, String CrTransCode, String CrContraTransCode, String MICRTransCode, String SettlementDate, String DeliveredTotAmt, String CrContraDesc) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    ECSDataFileHdrBean oECSDataFileHdrBean=(ECSDataFileHdrBean)oBaseHeaderBean;


    ArrayList oOutArray; //Output

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtYYMM()));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtECSTranCode()));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtUserNumber()));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtUserName()));
      oParameters.add(new DBObject(5,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtECSTapeInputNo()));
      oParameters.add(new DBObject(6,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtSponBkBrSortCode()));
      oParameters.add(new DBObject(7,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtUserBankAccNo()));
      oParameters.add(new DBObject(8,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtLedgerFolioNo()));
      oParameters.add(new DBObject(9,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtUserDefLimit()));
      oParameters.add(new DBObject(10,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oECSDataFileHdrBean.getTxtSettlementDate())));
      oParameters.add(new DBObject(11,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtCreditTranCode()));
      oParameters.add(new DBObject(12,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtCreditDestAccType()));
/*      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String("9119132")));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String("93")));  */
      oParameters.add(new DBObject(13,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(14,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_GENERATE_ECS_DATA_FILE.PAY_ECS_DATA_FILE_REPORT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      DBObject oErrorCode = (DBObject)oOutArray.get(0);
      String error_code = (String)oErrorCode.getObject();
      return error_code;
  }




public String GenerateSBIDataFile(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    ECSDataFileHdrBean oECSDataFileHdrBean=(ECSDataFileHdrBean)oBaseHeaderBean;


    ArrayList oOutArray; //Output

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oECSDataFileHdrBean.getTxtYYMM()));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_GENERATE_SBI_DATA_FILE.PAY_SBI_DATA_FILE_REPORT(?,?,?)");
      DBObject oErrorCode = (DBObject)oOutArray.get(0);
      String error_code = (String)oErrorCode.getObject();
      return error_code;
  }

////////////////PF Slip Report/////////////
public LovVO getPFSlipYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
   {
   String sQuery = "select distinct dtl.yyyymm  from pay_emp_pf_dtl dtl where 1=1";
    if(FCIPAY.Payroll.common.utility.EnrgiseUtil.checkString(oLovQueryVO.getSearchField1()))
    {
        sQuery = sQuery + " and  dtl.yyyymm LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }

    sQuery = sQuery + " ORDER BY dtl.yyyymm";
//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("YearMonth");

    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);

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


public LovVO getLoanCodeData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");
    arylstHeaderNames.add("PayCode Description");
    arylstHeaderNames.add("Flag");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);

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
     // oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sPaycode));
     // oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetLoanTypeLOVQ(?,?)"); */
      
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
       oLOVBean.setDetailField3(oRow.get("loan_adv_flag").getString());

      oList.add(oLOVBean);
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }

//Added by Balpreet dt 14 March 2008 For fetching Advance Types LOV

  public LovVO getAdvCodeData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");
    arylstHeaderNames.add("PayCode Description");
    arylstHeaderNames.add("Flag");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);

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
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanPayCodeQ(?,?,?,?)");*/
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
       oLOVBean.setDetailField3(oRow.get("loan_adv_flag").getString());

      oList.add(oLOVBean);
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  //Added by Aqeel dt 23 Oct 2009 For fetching Misc Pay code LOV

  public LovVO getMiscPayCodeData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");
    arylstHeaderNames.add("PayCode Description");
    arylstHeaderNames.add("Flag");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);

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
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetMiscRecovRepPayCode(?,?,?,?)");*/
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
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }

////////////////////
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



  public RecordMetaInfo getEcsHeaderMetaInfo() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();

    ArrayList oOutArray; //Output

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEcsDataCount(?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;

  }


  public ArrayList getECSHeader(long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {

    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;


    ArrayList oOutArray; //Output
    ArrayList oHeaderList = null;



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEcsDataDetail(?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
      }

      ECSDataFileHdrBean oECSDataFileHdrBean;
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
          oECSDataFileHdrBean = new ECSDataFileHdrBean();
          oECSDataFileHdrBean.setTxtECSTranCode(oRow.get("ECS_TRANS_CODE").getString());
          oECSDataFileHdrBean.setTxtUserNumber(oRow.get("USER_NUMER").getString());
          oECSDataFileHdrBean.setTxtUserName(oRow.get("USER_NAME").getString());
          oECSDataFileHdrBean.setTxtECSTapeInputNo(oRow.get("ECS_TAPE_INPUT_NO").getString());
          oECSDataFileHdrBean.setTxtSponBkBrSortCode(oRow.get("SP_BK_BR_SORT_CODE").getString());
          oECSDataFileHdrBean.setTxtUserBankAccNo(oRow.get("USER_BANK_AC_NO").getString());
          oECSDataFileHdrBean.setTxtLedgerFolioNo(oRow.get("LEDGER_FOLIO_NO").getString());
          oECSDataFileHdrBean.setTxtUserDefLimit(oRow.get("USER_DEF_LIMIT").getString());
          oECSDataFileHdrBean.setTxtCreditTranCode(oRow.get("CR_REC_ECS_TRAN_CODE").getString());
          oECSDataFileHdrBean.setTxtCreditDestAccType(oRow.get("DEST_ACCT_TYPE").getString());

          oHeaderList.add(oECSDataFileHdrBean);
      }


    return oHeaderList;
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    ECSDataFileHdrBean oECSDataFileHdrBean = (ECSDataFileHdrBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtECSTranCode())));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtUserNumber())));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtUserName())));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtECSTapeInputNo())));
      oParameters.add(new DBObject(5,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtSponBkBrSortCode())));
      oParameters.add(new DBObject(6,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtUserBankAccNo())));
      oParameters.add(new DBObject(7,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtLedgerFolioNo())));
      oParameters.add(new DBObject(8,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtUserDefLimit())));
      oParameters.add(new DBObject(9,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtCreditTranCode())));
      oParameters.add(new DBObject(10,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtCreditDestAccType())));
      oParameters.add(new DBObject(11,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtUserID())));
      oParameters.add(new DBObject(12,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oECSDataFileHdrBean.getTxtSiteID())));
      oParameters.add(new DBObject(13,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateECSData(?,?,?,?,?,?,?,?,?,?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
//      return (String)oOutObject.getObject();
     return "Data saved";
  }


public LovVO getBranchStatementCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
{
    //String sQuery = "Select distinct hep.Emp_No,hep.First_Name || ' ' || hep.Middle_Name || ' ' || hep.Last_Name FULLNAME from hrm_employee hep ";
    String sBankCode;
    sBankCode=oLovQueryVO.getProperty("txtBankCode").trim();

 String sQuery = "Select distinct branch_code,branch_name  from pay_bank_branch_mast where 1=1 ";
     sQuery = sQuery + " and  bank_code = '" + sBankCode + "'";
    if(oLovQueryVO.getSearchField1() != null)
    {
      sQuery = sQuery + " and  branch_code LIKE '%" + oLovQueryVO.getSearchField1() + "%' ";
    }
      if(oLovQueryVO.getSearchField2() != null)
    {
      sQuery = sQuery + " and upper(branch_name) LIKE '%" + oLovQueryVO.getSearchField2().toUpperCase() + "%' ";
    }

//    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();

    oHeaderList.add("Branch Code");
    oHeaderList.add("Branch Name");
    oLovVO.setHeaderList(oHeaderList);
    ArrayList arylstVisibility=new ArrayList();

    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
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

          oLOVBean.setDetailField1(oRow.get("branch_code").getString());
          oLOVBean.setDetailField2(oRow.get("branch_name").getString());
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
}


public LovVO getRecEarnPayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Paycode");
    arylstHeaderNames.add("PaycodeDesc");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);

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
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetRecEarnPayCodeLOV(?,?,?,?)");
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
    }

      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getLbrGangLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");
    arylstHeaderNames.add("Gang Name");
    arylstHeaderNames.add("MOU");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
   // arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;

      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      String sPaycode,sDesc;
      sPaycode=oLovQueryVO.getSearchField1();
      sDesc=oLovQueryVO.getSearchField2();


      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      //Passing Null value for Depot Id...
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag").trim()));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getLOVGang(?,?,?,?,?,?,?)");
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

       oLOVBean.setDetailField1(oRow.get("gang_id").getString());
       oLOVBean.setDetailField2(oRow.get("gang_name").getString());
       oLOVBean.setDetailField3(oRow.get("mou_code").getString());

      oList.add(oLOVBean);
    }
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

public LovVO getDailyAttSummLstLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location Id");
    arylstHeaderNames.add("Location Description");
   
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

      String sPaycode,sDesc;
      sPaycode=oLovQueryVO.getSearchField1();
      sDesc=oLovQueryVO.getSearchField2();


      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));      
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetDepotLoV(?,?,?)");
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

  public LovVO getGangDtls(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");
    arylstHeaderNames.add("Gang Name");
    
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

      String sPaycode,sDesc;
      sPaycode=oLovQueryVO.getSearchField1();
      sDesc=oLovQueryVO.getSearchField2();


      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtDepotId"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag").trim()));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getgang_name(?,?,?,?)");
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

       oLOVBean.setDetailField1(oRow.get("gang_id").getString());
       oLOVBean.setDetailField2(oRow.get("gang_name").getString());
       

      oList.add(oLOVBean);
    }
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public PayReportComboVO getPayReportComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    PayReportComboVO oPayReportComboVO = new PayReportComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oCateg = null;


 // Get Sanction Types....
 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCtgry(?,?)");

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
        oCateg = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String label = oRow.get("code_sdesc").getString();
      String value = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(label,value);
      oCateg.add(oComboVO);
    }
    oPayReportComboVO.setCategList(oCateg);
    return oPayReportComboVO;
  }
}


