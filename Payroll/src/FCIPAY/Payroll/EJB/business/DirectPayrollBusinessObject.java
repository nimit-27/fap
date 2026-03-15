package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintDirectPayrollQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintDirectPayrollHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintainDirectPayrollBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollDetailInfo;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

public class DirectPayrollBusinessObject extends BaseBO
{
  public DirectPayrollBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("DirectPayrollScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
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
  
  public RecordMetaInfo getDirectPayrollDetailMetaInfo(String sPrimaryKey,DirPayrollDetailInfo oDirPayrollDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

      String EmpNo,MtrNo,paycode;
      EmpNo = oDirPayrollDetailInfo.getTxtEmpNo1();
      paycode = oDirPayrollDetailInfo.getTxtPayCode1();
      
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,paycode));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oDirPayrollDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayCount(?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
	oTimeObject  = null;       
	oTotalRecord = null;
	oOutArray    = null;
	oParameters  = null;
      return oRecordMetaInfo;            
  }
  
  public ArrayList getDirectPayrollDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,DirPayrollDetailInfo oDirPayrollDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintainDirectPayrollBean oDirPay;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDirPayDetail = null;

      String EmpNo,paycode;
      EmpNo = oDirPayrollDetailInfo.getTxtEmpNo1();
      paycode = oDirPayrollDetailInfo.getTxtPayCode1();
      
//      System.out.println(EmpNo);  
//      System.out.println(paycode);
      
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,paycode));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(oDirPayrollDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetDirectPayDetailN(?,?,?,?,?,?,?,?)");
      
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
            oDirPayDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oDirPay = new MaintainDirectPayrollBean();
          oDirPay.setTxtEmpNo((oRow.get("emp_num").getString()));
          oDirPay.setTxtName((oRow.get("name").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oDirPay.setStatus("Q");
          oDirPay.setTxtPayrollFlag(oRow.get("payroll_flag").getString());
          oDirPay.setTxtPayCode(oRow.get("pay_code").getString());
          oDirPay.setTxtDescription((oRow.get("pay_code_desc").getString()));      
          String sPayMode = "";
          oDirPay.setTxtPayMode(oRow.get("pay_mode").getString());
          oDirPay.setTxtAmount(oRow.get("total_amt").getString());
          oDirPay.setTxtValidFrom(oRow.get("valid_from_yymm").getString());          
          oDirPay.setTxtSrlNo(oRow.get("pay_code_srl").getString()); 
          oDirPay.setTxtInstAmount(oRow.get("inst_amt").getString());          
          oDirPay.setTxtNoInst(oRow.get("no_of_inst").getString());          
          oDirPay.setTxtAdvBalance(oRow.get("BAL_AMOUNT").getString());                             
          oDirPay.setTxtAgency(oRow.get("agency_code").getString()); 
          oDirPay.setTxtAgencyNo(oRow.get("segment_desc").getString());    
      //  oDirPay.setTxtAgencyNo(oRow.get("agency_no").getString());   // added by yogesh on 5 th october 2010                             
          oDirPay.setTxtAgencyName(oRow.get("agency_code_desc").getString()); 
          oDirPay.setTxtTxnCateg(oRow.get("txn_categ").getString()); 
          oDirPay.setTxtAgencySiteCode(oRow.get("agency_site_code").getString()); 
          oDirPay.setTxtAgencySite(oRow.get("agency_site_desc").getString());
		  oDirPay.setTxtCreationDate(oRow.get("created_date").getString());
          oDirPay.setTxtCreatedBy(oRow.get("created_by").getString());
          oDirPay.setTxtCreatedSite(oRow.get("created_site").getString());
          oDirPay.setTxtUpdationDate(oRow.get("updated_date").getString());
          oDirPay.setTxtUpdatedBy(oRow.get("updated_by").getString());
          oDirPay.setTxtUpdatedSite(oRow.get("updated_site").getString());
          oDirPay.setTxtCategory(oRow.get("emp_category").getString());
          oDirPay.setTxtEmpStatus(oRow.get("emp_status").getString());
          oDirPay.setTxtSavNo(oRow.get("SAVINGS_NO").getString());   // added by swapnendu Dt 04 Feb 2013
		  //oDirPay.setTxtCategory(oRow.get("pay_scale_type").getString());
          oDirPayDetail.add(oDirPay);
          oRow = null;
          oDirPay = null;
        }             
    oList = null;
    oIt = null;
    oDirPayrollDetailInfo = null;
    oOutArray = null;
    oParameters = null;
    oBean = null;
    return oDirPayDetail;    
  }  


//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    if(sScreenName.equals("DirectPayrollScreen"))
    {
      saveDirectPayroll(sHeaderPrimaryKey,(MaintDirectPayrollHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }
    
  }
  
  private  void saveDirectPayroll(String sHeaderPrimaryKey,MaintDirectPayrollHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    ArrayList oOutArray = new ArrayList(); // added by yogesh
    int j=0;
    ArrayList oParameters = new ArrayList(); //Input Parameters
    //ArrayList oParameters1 = new ArrayList(); //added by sonia 
    ArrayList oOutArray1;//added by sonia 
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    String msg;
     int count=1;
    
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            //oBeanInsert.createBatch("PAYROLL_PKG_EXT.proc_InsertDirectPayDetail(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            oBeanInsert.createBatch("PKG_PAYROLL_MISC.proc_InsertDirectPayDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           //oBeanInsert.createBatch("PKG_PAYROLL_MISC.proc_InsertDirectPayDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayMode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAmount())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtValidFrom())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtInstAmount())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtNoInst()))); 
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAdvBalance())));           
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtSavNo())));   //added by swapnendu Dt 04 Feb 2013
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAgency())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtTxnCateg()))); 
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAgencySiteCode())));          
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
          oParameters = null;
        }
        else if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateDirectPayrollDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtEmpNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayMode())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtValidFrom())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAmount())));         
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtInstAmount())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtNoInst()))); 
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAdvBalance())));                     
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtSavNo())));    // added by swapnendu Dt 04 Feb 2013
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAgency())));         
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAgencySiteCode())));          
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtTxnCateg())));                  
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
         
          oBean.addToBatch(oParameters);
          oParameters = null;
       
        }
        else if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteDirectPayDetail(?,?,?,?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtSrlNo())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtValidFrom())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAmount())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));          
          oBeanDelete.addToBatch(oParameters);
          oParameters = null;
        }
        oMaintainDirectPayrollBean = null;
      }
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
    oIt = null;
    oBean = null;
    oBeanInsert = null;
    oBeanDelete = null;
  
  }

  public LovVO getDirectPayEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    //arylstHeaderNames.add("PayCode"); 
    arylstHeaderNames.add("CPFCode"); //added by yogesh on  5 th august
	arylstHeaderNames.add("Category"); // added by sonia on 02-02-2011
	arylstHeaderNames.add("Scale Type");// added by sonia on 02-02-2011
    arylstHeaderNames.add("Employee Status");// added by sonia on 07-07-2011

    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 02-02-2011 
	arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 02-02-2011 
    arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 07-07-2011 
    oLovVO.setVisibilityList(arylstVisibility);

    String EmpNo,Name,CPFCode;
    //EmpNo=oLovQueryVO.getSearchField1();
    //Name=oLovQueryVO.getSearchField2();
    //CPFCode=oLovQueryVO.getSearchField3();

    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField3()));// added by yogesh on 5th aug 2010
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      /* commented by yogesh on 5 th august*/
     // oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayEmpLovQ(?,?,?,?,?,?)");  commented by yogesh
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetDirectPayEmpLovQ(?,?,?,?,?,?,?)");// added by yogesh on 5th aug 2010
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
	   oLOVBean.setDetailField4(oRow.get("emp_category").getString());// added by sonia on 02-02-2011
       oLOVBean.setDetailField5(oRow.get("pay_scale_type").getString());// added by sonia on 02-02-2011
       oLOVBean.setDetailField6(oRow.get("emp_status").getString());// added by sonia on 07-07-2011
       
      oList.add(oLOVBean);
      oLOVBean = null;
      oRow = null;
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

public LovVO getDirectPayEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    arylstHeaderNames.add("CPFCode"); 
	arylstHeaderNames.add("Category");// added by sonia on 02-02-2011
	arylstHeaderNames.add("Scale Type");// added by sonia on 02-02-2011
    arylstHeaderNames.add("Employee Status");// added by sonia on 07-07-2011 

    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
	arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 02-02-2011
	arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 02-02-2011
    arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 07-07-2011
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField3()));// added by yogesh on 5th aug 2010
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayEmpLovN(?,?,?,?,?,?,?)");
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetDirectPayEmpLovN(?,?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("emp_Name").getString());   
       oLOVBean.setDetailField3(oRow.get("cpf_code").getString());   
	   oLOVBean.setDetailField4(oRow.get("emp_category").getString());// added by sonia on 02-02-2011
	   oLOVBean.setDetailField5(oRow.get("pay_scale_type").getString());// added by sonia on 02-02-2011
       oLOVBean.setDetailField6(oRow.get("emp_status").getString());// added by sonia on 07-07-2011
       oList.add(oLOVBean);
       oRow = null;
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

public LovVO getDirectPayrollPayLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Paycode");  
    arylstHeaderNames.add("PaycodeDesc"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
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
      //oParameters = new ArrayList();
      /*oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayrollPayLovQ(?,?,?,?)");*/
      
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
      oLOVBean = null;
      oRow = null;
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

public LovVO getDirectPayrollPayLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Paycode");  
    arylstHeaderNames.add("PaycodeDesc"); 
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
      //oParameters = new ArrayList();
     /* oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayrollPayLovN(?,?,?,?,?)");*/


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
      oRow = null;
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

public LovVO getDirectPayAgencyLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    //arylstHeaderNames.add("Agency");  
    //arylstHeaderNames.add("Agency name");  
    arylstHeaderNames.add("Supplier ID");  //added by yogesh on 23 09 2010
    arylstHeaderNames.add("Supplier Name");   //added by yogesh on 23 09 2010
    arylstHeaderNames.add("Supplier No"); //added by yogesh on 23 09 2010
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE); //added by yogesh on 23 09 2010

    oLovVO.setVisibilityList(arylstVisibility);
    String sAgencyName,sAgency,sAgencyNo;
    //String sAgencyCode,sAgencyCodeDesc,sAgencyNo; //sAgencyNo  added by yogesh on 23 09 2010
    sAgency=oLovQueryVO.getSearchField1();
    sAgencyName=oLovQueryVO.getSearchField2();
    sAgencyNo=oLovQueryVO.getSearchField3();

    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sAgency));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sAgencyName));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sAgencyNo ));//added by yogesh on 23 sep 2010
       oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtEmpNo")));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtPayCode")));

      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetPayAbvAgencyCodeLOVN(?,?,?,?,?,?,?,?)"); // added by yogesh on 19 aug 2010
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
      
      oLOVBean.setDetailField1(oRow.get("vendor_id").getString());   
      oLOVBean.setDetailField2(oRow.get("vendor_name").getString());    
      oLOVBean.setDetailField3(oRow.get("segment1").getString());            
      oList.add(oLOVBean);
      oRow = null;
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

public LovVO getDirectPayAgencyLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Agency Code");  
    arylstHeaderNames.add("Agency Name");  
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    

    oLovVO.setVisibilityList(arylstVisibility);

    String agcode,Name;
    agcode=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField2();
    
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, agcode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, Name));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayAgencyLovN(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("agency_code").getString());            
       oLOVBean.setDetailField2(oRow.get("agency_name").getString());                   
           
      oList.add(oLOVBean);
      oLOVBean = null;
      oRow = null;
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
/* added by jatin */
public LovVO getDirectPayRetireEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    arylstHeaderNames.add("CPFCode"); 
	  arylstHeaderNames.add("Category");// added by sonia on 02-02-2011
	  arylstHeaderNames.add("Scale Type");// added by sonia on 02-02-2011
    arylstHeaderNames.add("Employee Status");// added by sonia on 07-07-2011 

    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
	  arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 02-02-2011
	  arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 02-02-2011
    arylstVisibility.add(EnrgiseConstants.VISIBLE);// added by sonia on 07-07-2011
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField3()));// added by yogesh on 5th aug 2010
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayEmpLovN(?,?,?,?,?,?,?)");
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getdirectpayretireemplovn(?,?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("emp_Name").getString());   
       oLOVBean.setDetailField3(oRow.get("cpf_code").getString());   
	     oLOVBean.setDetailField4(oRow.get("emp_category").getString());// added by sonia on 02-02-2011
	     oLOVBean.setDetailField5(oRow.get("pay_scale_type").getString());// added by sonia on 02-02-2011
       oLOVBean.setDetailField6(oRow.get("emp_status").getString());// added by sonia on 07-07-2011
       oList.add(oLOVBean);
       oRow = null;
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

public LovVO getDirectPayCodePFLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Paycode");  
    arylstHeaderNames.add("PaycodeDesc"); 
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
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getdirectpayrollpaycpfn(?,?,?,?,?)");
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
      oRow = null;
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



 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();  
    checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList);        
  }

  private void checkYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
      MaintDirectPayrollHeaderBean oMaintDirectPayrollHeaderBean=(MaintDirectPayrollHeaderBean)oBaseHeaderBean;
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oMaintDirectPayrollHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintDirectPayrollHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)"); //commented by Dushyant Dt 02 Apr 2012         
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear_DirectPay(?,?,?,?)");  //added by Dushyant Dt 02 Apr 2012
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

      String sRevYear = "";
      String status = "";   
      String arcFlag="";
      
      oIt = oRetList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        sRevYear = oRow.get("yymm").getString(); 
        status = oRow.get("status").getString(); 
        arcFlag = oRow.get("arc_flag").getString(); 
      }

    if(arcFlag!=null && arcFlag.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
      
      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
//        System.out.println(oMaintainDirectPayrollBean.getStatus());
        if(!(oMaintainDirectPayrollBean.getStatus().equals("D")))
          count++;

        if(!oMaintainDirectPayrollBean.getStatus().equals("Q") && !oMaintainDirectPayrollBean.getTxtValidFrom().equals(""))    
        {
            int iFromYear = Integer.parseInt(oMaintainDirectPayrollBean.getTxtValidFrom());
            int vRevYear=0;
            if(!sRevYear.equalsIgnoreCase("")){
            vRevYear=Integer.parseInt(sRevYear);
            }
            if(vRevYear == iFromYear  && Integer.parseInt(status) == 2 )  
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oArguments.add(new String(sRevYear));
              oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.MonthlyPayrollRun",oArguments));
            }
            else if (vRevYear  > iFromYear )
            {        
              ArrayList oArguments = new ArrayList();
              if((oMaintainDirectPayrollBean.getStatus().equals("D")))
              {
                //oMaintainDirectPayrollBean.setStatus("Q");    //commented by yogesh on 22 nd sep 2010
               // oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.Deletion")); //commented by yogesh on 22 nd sep 2010
              }else
              {
                if(!(oMaintainDirectPayrollBean.getTxtPayCode().equals("396") || oMaintainDirectPayrollBean.getTxtPayCode().equals("397"))) //added by swapnendu Dt 28 Feb 2013 to update 
                {
                    oArguments.add(new Integer(count));
                    oArguments.add(new String(sRevYear));              
                    oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.YearMonthNotValid",oArguments));
                    oArguments = null;
                }
              }
            }            
        }
      }
      oRetList = null;
      sRevYear = null;
      oOutArray = null;
      oParameters = null;
      oMaintDirectPayrollHeaderBean = null;
      oBean = null;
  }
   ///start changed  by Sonia////////////////
   private void checksupplierRecord(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    int j=0;
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oOutArray1;
    DBUtilitiesBean oBean = null; 
    String msg;
    int count=1;
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oArguments = new ArrayList();
    String SrlNo ="Record";
      while(oIt.hasNext())
      {
          MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
           if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
                  {
                     oBean = new DBUtilitiesBean();
                     oParameters = new ArrayList();
                     oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAgency())));                      
                     oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAgencySiteCode())));        
                     oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));       
                     oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
                     if(((!oMaintainDirectPayrollBean.getTxtAgency().equalsIgnoreCase("")) && (!oMaintainDirectPayrollBean.getTxtAgencySiteCode().equalsIgnoreCase(""))))
                     {
                         oOutArray1 = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_CheckSupplier(?,?,?,?)");
                         Integer i = (Integer)((DBObject)oOutArray1.get(0)).getObject();
                         count = i.intValue();                   
                          if(count == 0)     
                          {                             
                            SrlNo= SrlNo +" "+oMaintainDirectPayrollBean.getTxtSrNo();                           
                          }
                          oOutArray1 = null;
                     }
                     oBean = null;
                     oParameters = null;
                  }     
      oMaintainDirectPayrollBean = null;
  }
  if(!SrlNo.equalsIgnoreCase("Record")){
  oArguments.add(" in " + SrlNo);
  oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.CheckSupplier",oArguments));
  oArguments = null;
  }
  SrlNo = null;
  }
  
  private void checkSixPaycodeCatg(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
	ArrayList payCodeList = new ArrayList();     
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oArguments = new ArrayList(); 
	String Empno="Record";
	payCodeList=getPayCodes();

				while(oIt.hasNext())
				{
					  MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
					   if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
							  {
								
								 String category = oMaintainDirectPayrollBean.getTxtCategory();
								 String pattern = oMaintainDirectPayrollBean.getTxtPattern();
								
                                                                /* Commented By Ravindra on 30/APRIL/2020 #ref 102077 and issue payroll-102196 
                                                                 * if(category.equalsIgnoreCase("III") || category.equalsIgnoreCase("IV")){
									 String pay_code = oMaintainDirectPayrollBean.getTxtPayCode();
									 for(int i=0;i<payCodeList.size();i++)
									{
										if(payCodeList.get(i).toString().equalsIgnoreCase(pay_code)){										
										Empno=Empno +" "+ oMaintainDirectPayrollBean.getTxtSrNo();
										
										}
									}
								 
								 }*/
                 
                 if(category.equalsIgnoreCase("I") || category.equalsIgnoreCase("II")){
                 if(pattern.equalsIgnoreCase("CDA")){
									 String pay_code = oMaintainDirectPayrollBean.getTxtPayCode();
									 for(int i=0;i<payCodeList.size();i++)
									{
										if(payCodeList.get(i).toString().equalsIgnoreCase(pay_code)){										
										Empno=Empno +" "+ oMaintainDirectPayrollBean.getTxtSrNo();
										}
									}
								 }
								 }
                 
                                category = null;
                                pattern = null;
							  }
                              oMaintainDirectPayrollBean = null;
				  }
           if(!Empno.equalsIgnoreCase("Record")){
                  oArguments.add(Empno);
                  oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.CheckCategory",oArguments));
                 
           }
           Empno = null;
           payCodeList = null;
           oArguments = null;
           oIt = null;
  }

public ArrayList getPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oList = new ArrayList();   
      ArrayList payCodeList = new ArrayList();   
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();      
      oList.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));       
      oList.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_PAYROLL_MISC.proc_Chk_SixPayCode(?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   
     
        int count = 0;
        QueryRow oRow = null;
        Iterator oIt = oList.iterator();
        while(oIt.hasNext())
        {
            if(count == 0)
            {
               payCodeList = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();
            
            payCodeList.add(oRow.get("paycode").getString());
        
          }    
        oIt = null;  
        oBean = null;
        oOutArray = null;
        oList = null;
        oOutObject = null;
        
        return payCodeList;
  }

  public ArrayList getAccDirPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oList = new ArrayList();   
      ArrayList payCodeList = new ArrayList();   
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();      
      oList.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));       
      oList.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_PAYROLL_MISC.proc_Chk_Acct_Dir(?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   
     
    int count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           payCodeList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        
        payCodeList.add(oRow.get("pay_code").getString());
        oRow = null;
      }    
    oIt = null;  
    oBean = null;
    oList = null;
    oOutArray = null;
    oOutObject = null;
    return payCodeList;

  }

   private void checkPayAgencyMap(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
	ArrayList payCodeList = new ArrayList();     
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oOutArray ; //Output 
    ArrayList oArguments = new ArrayList(); 
    String Empno="Records";
    DBUtilitiesBean oBean ; 
    ArrayList oParameters;
    payCodeList=getAccDirPayCodes();
    int count=1;
    MaintDirectPayrollHeaderBean oBaseHeaderBean1 = (MaintDirectPayrollHeaderBean)oBaseHeaderBean;

				while(oIt.hasNext())
				  {
					  MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
					   if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE)){
                            oBean = new DBUtilitiesBean();
                            oParameters = new ArrayList();
					   for(int i=0;i<payCodeList.size();i++)
                        {
                            if(payCodeList.get(i).toString().equalsIgnoreCase(oMaintainDirectPayrollBean.getTxtPayCode()))
                            {										
                                  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtEmpNo())));
                                  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));
                                  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean1.getTxtSiteID())));
                                  oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));       
                                  oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
                                  oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_SupplierMandatoryCheck(?,?,?,?,?)");
                                  Integer m = (Integer)((DBObject)oOutArray.get(0)).getObject();
                                  count= m.intValue();
                                    oOutArray = null;
                                  if(count==0){		
                                        if(((oMaintainDirectPayrollBean.getTxtAgency().equalsIgnoreCase("")) && (oMaintainDirectPayrollBean.getTxtAgencySiteCode().equalsIgnoreCase(""))))
                                        {
                                          Empno=Empno +" "+ oMaintainDirectPayrollBean.getTxtSrNo();	
                                        }
                                  }										  
                            }
                        }
					   
				   }
                   oMaintainDirectPayrollBean = null;
				  }

	if(!Empno.equalsIgnoreCase("Records")){
                  oArguments.add(Empno);
                  oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.CheckMandatorySpplier",oArguments));
                  oArguments = null;
     }
     oBean = null;
     Empno = null;
     payCodeList = null;
     oBaseHeaderBean1 = null;
  }


 //added by geetika Dt 05/09/2013 (start)
  private void chkInvalidCombiOfEmpAndPayCode(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    ArrayList payCodeList = new ArrayList();     
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oOutArray ; //Output 
    ArrayList oArguments = new ArrayList(); 
    DBUtilitiesBean oBean ; 
    ArrayList oParameters;
    int count=0;
    MaintDirectPayrollHeaderBean oBaseHeaderBean1 = (MaintDirectPayrollHeaderBean)oBaseHeaderBean;
    while(oIt.hasNext())
    {
        MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
        count++;
        if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
            oBean = new DBUtilitiesBean();
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean1.getTxtSiteID())));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));       
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_chkEmpPayCodeCombiValid(?,?,?,?,?)",true,true);
            Integer err_code = (Integer)((DBObject)oOutArray.get(1)).getObject();
            String err_msg = (String)((DBObject)oOutArray.get(0)).getObject();
            oOutArray = null;
            oBean = null;
            oParameters = null;
            if(err_code.intValue() != 0)
            {
                oArguments.add(err_msg);
                oArguments.add(new Integer(count));
                oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.InvalidCombiEmpAndPaycCode",oArguments));
                oArguments = null;
            }										  
        }
        oMaintainDirectPayrollBean = null;
    }
      oBaseHeaderBean1 = null;  
  }
 //added by geetika Dt 05/09/2013 (end)
 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
      ArrayList oList = new ArrayList();
      chkInvalidCombiOfEmpAndPayCode(oBaseHeaderBean,oDetailBeanArray,oList);//added by geetika Dt 05/09/2013
      reportError(oList);//added by geetika Dt 05/09/2013
      checkSixPaycodeCatg(oBaseHeaderBean,oDetailBeanArray,oList);// added by sonia on 02-02-2011
      reportError(oList);// added by sonia on 02-02-2011    
      checksupplierRecord(oBaseHeaderBean,oDetailBeanArray,oList);// added by sonia on 02-02-2011
      reportError(oList);// added by sonia on 07-02-2011
      checkPayAgencyMap(oBaseHeaderBean,oDetailBeanArray,oList);// added by sonia on 02-02-2011
      reportError(oList);// added by sonia on 07-02-2011
      chkInvalidPaymentToEmp(oBaseHeaderBean,oDetailBeanArray,oList);// added by swapnendu Dt 10 May 2013
      reportError(oList);// added by swapnendu Dt 10 May 2013
      chkLiabilityAgnstPayCode(oBaseHeaderBean,oDetailBeanArray,oList); //added by ankur on 18th of Sep,2013
      reportError(oList); 
	  chkPayCodeAllowed(oBaseHeaderBean,oDetailBeanArray,oList);//added by manish on 09-Feb-2016 to restrict entry of forbidden pay codes
      reportError(oList);//added by manish on 09-Feb-2016
    }
  
    
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }


  public LovVO getDirectPayAgencySiteLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    //arylstHeaderNames.add("Agency Site Code");  
    //arylstHeaderNames.add("Agency Site");  
    arylstHeaderNames.add("Supplier SiteID");  
    arylstHeaderNames.add("Supplier Site Code");  
    
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
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtAgency")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty( "txtSiteID")));
     oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      //changed pkg Name dt 16 july 2008
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetPayAgencySiteCodeLOV(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("vendor_site_id").getString());            
       oLOVBean.setDetailField2(oRow.get("vendor_site_code").getString());                   
           
      oList.add(oLOVBean);
      oRow = null;
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
  
  //ADDED BY MANISH JINDAL ON 09-FEB-2016 
     private void chkPayCodeAllowed(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    ArrayList payCodeList = new ArrayList();     
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oOutArray ; //Output 
    ArrayList oArguments = new ArrayList(); 
    DBUtilitiesBean oBean ; 
    ArrayList oParameters;
  
    MaintDirectPayrollHeaderBean oBaseHeaderBean1 = (MaintDirectPayrollHeaderBean)oBaseHeaderBean;
    while(oIt.hasNext())
    {
        MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
    
        if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
            oBean = new DBUtilitiesBean();
            oParameters = new ArrayList();
            //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtEmpNo())));
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean1.getHdnEmpLbrFlag())));
           
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));   
         oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));       
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC_EXT.proc_chkMDPPayCodeAllowed(?,?,?,?)",true,true);
            String err_msg = (String)((DBObject)oOutArray.get(0)).getObject();
			Integer err_code = (Integer)((DBObject)oOutArray.get(1)).getObject();
            oOutArray = null;
            oBean = null;
            oParameters = null;
            if(err_code.intValue() != 0)
            {
                oArguments.add(err_msg);
                oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.InvalidCombiEmpAndPaycCode",oArguments));
                oArguments = null;
            }										  
        }
        oMaintainDirectPayrollBean = null;
    }
      oBaseHeaderBean1 = null;  
  }
 
  //ADDITION END BY MANISH JINDAL
  
  
  
  
  private void chkInvalidPaymentToEmp(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    ArrayList payCodeList = new ArrayList();     
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oOutArray ; //Output 
    ArrayList oArguments = new ArrayList(); 
    DBUtilitiesBean oBean ; 
    ArrayList oParameters;
    int count=0;
    MaintDirectPayrollHeaderBean oBaseHeaderBean1 = (MaintDirectPayrollHeaderBean)oBaseHeaderBean;
    while(oIt.hasNext())
    {
        MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
        count++;
        if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
            oBean = new DBUtilitiesBean();
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean1.getTxtSiteID())));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));       
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_chkInvalidPaymentToEmp(?,?,?,?,?)",true,true);
            Integer err_code = (Integer)((DBObject)oOutArray.get(1)).getObject();
            String err_msg = (String)((DBObject)oOutArray.get(0)).getObject();
            oOutArray = null;
            oBean = null;
            oParameters = null;
            if(err_code.intValue() != 0)
            {
                oArguments.add(err_msg);
                oArguments.add(new Integer(count));
                oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.InvalidPayment",oArguments));
                oArguments = null;
            }										  
        }
        oMaintainDirectPayrollBean = null;
    }
      oBaseHeaderBean1 = null;  
  }
  
  // added by Ankur on 18th of Sept ,2013
 private void chkLiabilityAgnstPayCode(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {       
    Iterator oIt = oDetailBeanArray.iterator();
    ArrayList oOutArray ; //Output 
    ArrayList oArguments = new ArrayList(); 
    DBUtilitiesBean oBean ; 
    ArrayList oParameters;
    int count=0;
    
    MaintDirectPayrollHeaderBean oBaseHeaderBean1 = (MaintDirectPayrollHeaderBean)oBaseHeaderBean;

				while(oIt.hasNext())
				  {
					  MaintainDirectPayrollBean oMaintainDirectPayrollBean = (MaintainDirectPayrollBean)oIt.next();
                      count++;
					   if(oMaintainDirectPayrollBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
                       {
                        if(!(oMaintainDirectPayrollBean.getTxtAgencyNo().equals("")))
                           {
                                oBean = new DBUtilitiesBean(); 
                                      oParameters = new ArrayList();		
                
                                      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtPayCode())));
                                      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintainDirectPayrollBean.getTxtAgencyNo())));
                                      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));       
                                      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
                                      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_CheckLiaAgnstPayCode(?,?,?,?)",true,true);
                                      Integer err_code = (Integer)((DBObject)oOutArray.get(1)).getObject();
                                      String err_msg = (String)((DBObject)oOutArray.get(0)).getObject();
    
                                    if(err_code.intValue() != 0)
                                    {
                                        oArguments.add(err_msg);
                                        oArguments.add(new Integer(count));
                                        oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.PayCodeNotLiable",oArguments));
                                        oArguments = null;
                                    }	
                 
                       }
                   }
                   oMaintainDirectPayrollBean = null;
				  }

     oOutArray = null;
     oBean = null;
     oBaseHeaderBean1 = null;
  }

 // addition by Ankur ends.
  
}