package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintElecMtrRdgQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintElecMtrRdgHeaderBean;
import FCIPAY.Payroll.UTILITY.EnqPayImgBean;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageDetailInfo;
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
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class CompPayrollBusinessObject extends BaseBO
{
  public CompPayrollBusinessObject()
  {
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
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return;   
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
     return null;      
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    return;    
  }
  
  /*public RecordMetaInfo getEnqPayImageHeaderMetaInfo(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  { 
   return null;
  }*/

  /*public ArrayList getEnqPayImageHeader(EnqPayImageQueryVO oEnqPayImageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        
    return null;
    }
    
  public RecordMetaInfo getEnqPayImageDetailMetaInfo(String sPrimaryKey,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }

  public ArrayList getEnqPayImageDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    return null;
  }*/

  public void compMonthlyPayroll(String empNo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("200")));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("200")));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_CREATE_PYRL_TXN.Ysp_CreatePayrlTxn(?,?,?,?,?)");      
      oOutArray = null;
      oParameters = null;
  }


public LovVO getMthlyPayrollLovEmp(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    oLovVO.setHeaderList(arylstHeaderNames);    
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    
    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField2();

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, Name));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMthlyPayrollEmpLovN(?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("empName").getString());   
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  

  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
}