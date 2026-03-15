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
import FCIPAY.Payroll.UTILITY.OnlineDummyHeaderBean;
public  class OnlinePayReportBusinessObject extends BaseBO 
{
  public OnlinePayReportBusinessObject()
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
  
  public String validateUser(String txtEmpNo,String txtCPFDDYYMM,String yymm,String siteCode,String empType) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    
      ArrayList oList = new ArrayList();
      ArrayList oList1 = new ArrayList();
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      String msg="Invalid User";
      
  /*    if(yymm != null){
       msg=checkStatus( yymm,siteCode,empType);
      }*/
      
      if(msg.equalsIgnoreCase("Invalid User"))
      {      
      String cpf=txtCPFDDYYMM.substring(0,txtCPFDDYYMM.indexOf("@"));
      String dob=txtCPFDDYYMM.substring(txtCPFDDYYMM.indexOf("@")+1,txtCPFDDYYMM.length());
      String day=dob.substring(0,2);
      String month=dob.substring(2,4);
      String year=dob.substring(4,dob.length());
      dob=month+"/"+day+"/"+year;
   
            
      oList.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpNo)));
      oList.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(cpf)));
      oList.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(dob)));
      oList.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));       
      oList.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PAYROLL_PKG_EXT.proc_ValidateUser(?,?,?,?,?)");
      Integer i = (Integer)((DBObject)oOutArray.get(0)).getObject();
      int count = i.intValue();
    if(count == 1)
    {       
        msg="Valid User";
        
    }
  }
 
    return msg;
   //   reportError(oList1);        
  } 
  
  
  public String checkStatus(String yymm,String siteCode,String empType) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    
      ArrayList oList = new ArrayList();
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      String msg="Invalid User"; 
      oList.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(yymm)));
      oList.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(siteCode)));
      oList.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(empType)));
      oList.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));       
      oList.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_PAYROLL_MISC.proc_checkPayStatus(?,?,?,?,?)");
      Integer i = (Integer)((DBObject)oOutArray.get(0)).getObject();
      int count = i.intValue();
    if(count <=3)
    {       
        msg="Month End Updation is in Progress";       
    }
    return msg;
   //   reportError(oList1);        
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