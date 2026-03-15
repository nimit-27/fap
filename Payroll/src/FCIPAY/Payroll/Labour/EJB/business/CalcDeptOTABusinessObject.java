package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import FCIPAY.Payroll.Labour.Utility.CalcDeptOTAHeaderBean;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

public class CalcDeptOTABusinessObject extends BaseBO
{
  public CalcDeptOTABusinessObject()
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
  
  

  public String calcDeptOTA(long lUserID,long lSiteID,CalcDeptOTAHeaderBean oCalcDeptOTAHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDeptOTAHeaderBean.getTxtGangId())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDeptOTAHeaderBean.getTxtLocId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_lbr_compute_inct_v2.proc_createDeptLabrOTA_txn(?,?,?,?,?,?)",true,true);      

      DBObject oErrorCode = (DBObject)oOutArray.get(0);
      String error_code = ((String)oErrorCode.getObject()).trim();

      return error_code;       
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

  public LovVO getCalcOTAGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");    
    arylstHeaderNames.add("Gang Name");   
    arylstHeaderNames.add("Depot Id");  
    arylstHeaderNames.add("Depot Name");       
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE); 
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtLocId")).trim())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField1()))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtLbrType"))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getCalcGangLOV(?,?,?,?,?)");
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getLOVGang(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("site_id").getString());
       oLOVBean.setDetailField4(oRow.get("loc_desc").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getCalcOTADepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location Id");    
    arylstHeaderNames.add("Location Name");        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);

    LOVBean oLOVBean;
    int count;
    count = 0;
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
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

}