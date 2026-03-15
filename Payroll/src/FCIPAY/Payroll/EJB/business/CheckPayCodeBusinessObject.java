
package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpFinanceQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpFinanceComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.EmpFinInfoHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.UTILITY.EmpFinVldnBean;

public  class CheckPayCodeBusinessObject extends BaseBO 
{
  public CheckPayCodeBusinessObject()
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

  
   public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    //validateUser(oBaseHeaderBean,sScreenName,sScreenMode);
  }
  
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
     // validateUserDetails(oBaseHeaderBean,sScreenName,sScreenMode);
  }
  
  public ArrayList getInternalsavingPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    
    //String msg="";
      ArrayList oList = new ArrayList();   
      ArrayList payCodeList = new ArrayList();   
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();      
     // oList.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(paycode)));
      oList.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));       
      oList.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PAYROLL_PKG_EXT.proc_Chk_Pay_Code(?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      //String ss=oOutObject.getObject().toString();
      oList = (ArrayList)(oOutObject.getObject());   
      
      
      /////////////////////////////////////////////////////////////////
     

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
        
        payCodeList.add(oRow.get("PAY_CODE").getString());
  
      }    
      
    return payCodeList;
      /////////////////////////////////////////////////////////////////
     
     
     
     
     
      //Integer i = (Integer)((DBObject)oOutArray.get(0)).getObject();
      //int count = i.intValue();
   
    //if(count == 1)
   // {       
       // msg="Valid PayCode";
    //}
           //if(count == 0)
    //{       
      //  msg="Invalid PayCode";
         //  }
   // return oList;
     
  } 

////////////////added by sonia on 25-04-2011

  public ArrayList getPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    
    //String msg="";
      ArrayList oList = new ArrayList();   
      ArrayList payCodeList = new ArrayList();   
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();      
     // oList.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(paycode)));
      oList.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));       
      oList.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_PAYROLL_MISC.proc_getMappedtoAcctCode(?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      //String ss=oOutObject.getObject().toString();
      oList = (ArrayList)(oOutObject.getObject());         
      /////////////////////////////////////////////////////////////////
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
        
        payCodeList.add(oRow.get("PAY_CODE").getString());
  
      }    
      
    return payCodeList;     
  }
//////end  by sonia on 25-04-2011///////////////////////////////////////////////////////////


 public ArrayList getDepuPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    
      ArrayList oList = new ArrayList();   
      ArrayList DepuPayCodesList = new ArrayList();   
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();      
      oList.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));       
      oList.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_PAYROLL_MISC.proc_Chk_Dep_Pay_Code(?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             DepuPayCodesList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          
          DepuPayCodesList.add(oRow.get("code_sdesc").getString());
    
        }    
      
    return DepuPayCodesList; 
     
  } 

////////////////added by sonia on 07-07-2011



public LovVO getSalaryInvoicePayLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetSalaryInvoicePayLovQ(?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("code_sdesc").getString());            
      oLOVBean.setDetailField2(oRow.get("code_desc").getString());   
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }



  
   private boolean checkHeaderTimeStamp(String sPrimaryKey,Timestamp oWhenPicked)
  {
    return true;
  }
  private boolean checkDetailTimeStamp(ArrayList oDetailBeanArray,Timestamp oWhenDetailPicked)
  {
    return true;
  }  
  
  public void deleteHeaderImpl(String sPrimaryKey) throws EnrgiseSystemException
  {    
  }
  
   public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
     
  }  
  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }
  
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
  return "";
  }
}