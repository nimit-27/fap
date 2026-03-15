package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OverAbvArrearComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
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
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.UTILITY.OverAbvArrearHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OverAbvArrearQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;

public class OverAbvArrearBusinessObject extends BaseBO
{
  public OverAbvArrearBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("CCARateALLScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {

  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return null;
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  }

  public OverAbvArrearComboVO getOverAbvArrearComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    OverAbvArrearComboVO oOverAbvArrearComboVO = new OverAbvArrearComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayCode = null;

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_OvrNAbv_PayCodeLOV(?,?)");

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
        oPayCode = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String payCodeLabel = oRow.get("pay_code_desc").getString();
      String payCodeValue = oRow.get("pay_code").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      oPayCode.add(oComboVO);
    }
    oOverAbvArrearComboVO.setPayCodeList(oPayCode);
    return oOverAbvArrearComboVO;
  }
  
  public RecordMetaInfo getOverAbvArrearHeaderMetaInfo(OverAbvArrearQueryVO oOverAbvArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oOverAbvArrearQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverAbvArrearQueryVO.getTxtEmpNo())));    
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oOverAbvArrearQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oOverAbvArrearQueryVO.getTxtStartYr())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oOverAbvArrearQueryVO.getTxtEndYr())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverAbvArrearQueryVO.getTxtPayCode())));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_GetOvrNAbv_ArrearCnt(?,?,?,?,?,?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getOverAbvArrearHeader(OverAbvArrearQueryVO oOverAbvArrearQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oOverAbvArrearQueryVO == null)
    {
      oOverAbvArrearQueryVO = new OverAbvArrearQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();                 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new Long(oOverAbvArrearQueryVO.getLoginLocCode())));    
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverAbvArrearQueryVO.getTxtEmpNo())));  
       oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverAbvArrearQueryVO.getTxtPayCode()))); 
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, new String(oOverAbvArrearQueryVO.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR, new String(oOverAbvArrearQueryVO.getTxtStartYr()))); 
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR, new String(oOverAbvArrearQueryVO.getTxtEndYr()))); 
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_GetOvrNAbv_ArrearDlt(?,?,?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      OverAbvArrearHeaderBean oOverAbvArrearHeaderBean;
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
          oOverAbvArrearHeaderBean = new OverAbvArrearHeaderBean();       
          oOverAbvArrearHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());                                                 ;
          oOverAbvArrearHeaderBean.setTxtEmpName(oRow.get("emp_name").getString());
          oOverAbvArrearHeaderBean.setTxtArrAmt(oRow.get("txn_amt").getString());
          oOverAbvArrearHeaderBean.setTxtDedCPF(oRow.get("it_ded").getString());
          oOverAbvArrearHeaderBean.setTxtDedCPF(oRow.get("employee_subs").getString());
          oOverAbvArrearHeaderBean.setTxtInvID(oRow.get("invoice_num").getString());
          oOverAbvArrearHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
          oOverAbvArrearHeaderBean.setHdnPayYYMM(oRow.get("pay_yymm").getString());
          oOverAbvArrearHeaderBean.setHeaderPrimaryKey(oRow.get("org_pmnt_id").getString());
          oOverAbvArrearHeaderBean.setTxtStartYr(oRow.get("start_yr").getString());
          oOverAbvArrearHeaderBean.setTxtEndYr(oRow.get("end_yr").getString());

          oHeaderList.add(oOverAbvArrearHeaderBean);
      }              
    return oHeaderList;
  } 

  public LovVO getEmpOverAbvArrearLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    
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
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag")).trim())); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID")).trim()));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_OvrNAbv_EmpLOV(?,?,?,?,?,?)");
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
   // System.out.println(oList.size());
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
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }  
  
  public String sendOverAbvArrearInv(OverAbvArrearQueryVO oOverAbvArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();

    ArrayList oOutArray; //Output  
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oOverAbvArrearQueryVO.getTxtEmpNo()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oOverAbvArrearQueryVO.getHdnPayYYMM()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oOverAbvArrearQueryVO.getTxtPayCode()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oOverAbvArrearQueryVO.getHeaderPrimaryKey()));   
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oOverAbvArrearQueryVO.getTxtDedIT()));   
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(oOverAbvArrearQueryVO.getUserId())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.BIGINT,new Long(oOverAbvArrearQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.Proc_RelOvrnAbvArrear(?,?,?,?,?,?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(1);
    Integer errCode = (Integer)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(0);
    String errMsg = (String)(oOutObject.getObject());
    if(errCode.equals("0")  )
    {
      errMsg="Invoce sent Successfully";
    }     
    
    String sRetMsg=errCode.toString()+","+errMsg;    
    return sRetMsg;
  }
}