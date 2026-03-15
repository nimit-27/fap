package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.UTILITY.ComputeTaxHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.DateFormat;
import java.util.Date;
import FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.PayrollSQLQueries;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class ComputeIncomeTaxBusinessObject extends BaseBO
{
  public ComputeIncomeTaxBusinessObject()
  {
  }
  
  public  String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return null;
  }
  public  void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
  {
  }
  public  void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName,ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  public  void initializeBOImpl(String sScreenName)
  {
  }
  public  void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }
  public  void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }
  public  void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }

  public String computeProjectedTax(ComputeTaxHeaderBean oComputeTaxHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
{                 
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;   

      ArrayList oOutArray; //Output 

      String lUserId = String.valueOf(loginUserId);
      String lSiteId = String.valueOf(lLoginSiteId);
      
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oComputeTaxHeaderBean.getTxtEmp())));      
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oComputeTaxHeaderBean.getHdnMaxRebFlag())));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oComputeTaxHeaderBean.getHdnEmpLbrFlag())); 
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,lUserId)); 
      oParameters.add(new DBObject(5,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,lSiteId));  
      oParameters.add(new DBObject(6,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_CALCULATE_TAX_ACTUALS_FCI.Ysp_ComputeTaxActual(?,?,?,?,?,?,?)",true,true); 
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_code = (String)oOutObject.getObject();
      oOutArray = null;
      oParameters = null;
      return error_code;      
}

public String computeActualTax(ComputeTaxHeaderBean oComputeTaxHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
{                 
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;   
    String errorMsg ="";
    ArrayList oOutArray; //Output 
    
    String lUserId = String.valueOf(loginUserId);
    String lSiteId = String.valueOf(lLoginSiteId);
    
    //oParameters = new ArrayList();
    //oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oComputeTaxHeaderBean.getOptSelectAllEmp())));
    oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oComputeTaxHeaderBean.getTxtEmp())));      
    oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oComputeTaxHeaderBean.getHdnMaxRebFlag())));           
    oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oComputeTaxHeaderBean.getHdnEmpLbrFlag()));       
    oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,lUserId)); 
    oParameters.add(new DBObject(5,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,lSiteId));  
    oParameters.add(new DBObject(6,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));
    if(oComputeTaxHeaderBean.getHdnEmpLbrFlag().equals("K"))
    oOutArray = oBean.callProc(oParameters,"PKG_CALCULATE_TAX_ACTUALS_KOT.Ysp_ComputeTaxActual(?,?,?,?,?,?,?)"); 
    else
    oOutArray = oBean.callProc(oParameters,"PKG_CALCULATE_TAX_ACTUALS_FCI.Ysp_ComputeTaxActual(?,?,?,?,?,?,?)",true,true); 
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    String oErrorMsg = (String)oOutObject.getObject();
    Integer errCode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
    if(!(errCode.equals(new Integer(1))))
    {
        updateSessionStatus("ITAX", lLoginSiteId, oComputeTaxHeaderBean.getHdnEmpLbrFlag());
    }
    
    oOutObject = null;  
    oBean = null;
    oParameters = null;
    oOutArray = null;
    return oErrorMsg; 
}

public void updateSessionStatus(String module,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
{
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList   oParameters = new ArrayList();
    oParameters.add(new InputDBObject(1,ParameterTypes.VARCHAR, new String(module+lSiteID+hdnEmpLbrFlag)));
    int iRetType = oBean.executeUpsert(oParameters,PayrollSQLQueries.Update_Session_State);
}

public LovVO getEmpIncTaxLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
{
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
    arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;
      String sScreenName=oLovQueryVO.getProperty("screenName");
      String sEmptype="";
      if(sScreenName.equals("ComputeDepIncomeTaxProjScreen")||sScreenName.equals("ComputeDepMonthlyIncomeTaxScreen"))
      {
        sEmptype="L";
      }else
      {
        sEmptype="E";
      }

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(3,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(4,FCIPAY.Payroll.EJB.common.helper.DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(5,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,FCIPAY.Payroll.EJB.common.helper.DBObject.OUT,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMtrRdgLOV(?,?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("EMP_NO").getString());            
       oLOVBean.setDetailField2(oRow.get("NAME").getString());            
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;

  }
  
  public String getMaxPayYear(long siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    //QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    int iRes=0;
    String sRevYear="";
    String status ="";

    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = oRow.get("status").getString(); 
    }    
    return sRevYear;
  }
 
}