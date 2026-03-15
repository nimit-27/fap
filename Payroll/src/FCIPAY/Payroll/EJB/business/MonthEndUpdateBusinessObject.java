package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
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
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.PayrollSQLQueries;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class MonthEndUpdateBusinessObject extends BaseBO
{
  public MonthEndUpdateBusinessObject()
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
  
  

  public String monthEndUpdate(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String oErrorMsg=null;
    String process="MONTHEND";
    ArrayList oOutArray; //Output 
   /* oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"
(?,?,?,?,?)",true,true);*/
    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,process));
        
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,""));
       oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
       
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,""));

        oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"fci_payroll_sequential_pkg.proc_chk_concurrency(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true); 
   
   
    DBObject oDBObject = (DBObject)oOutArray.get(0);
    oErrorMsg = (String)oDBObject.getObject();
    Integer errCode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
  /*  if(!(errCode.equals(new Integer(1))))
    {
        updateSessionStatus("MONTHEND",lSiteID, hdnEmpLbrFlag);
    }*/
    return oErrorMsg;     
  }
  
    public void updateSessionStatus(String module,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList   oParameters = new ArrayList();
        oParameters.add(new InputDBObject(1,ParameterTypes.VARCHAR, new String(module+lSiteID+hdnEmpLbrFlag)));
        int iRetType = oBean.executeUpsert(oParameters,PayrollSQLQueries.Update_Session_State);
    }
  
  public String singleMonthEndUpdate(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
        ArrayList oOutArray; //Output 
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_lbr_single_month_end.proc_single_month_end(?,?,?,?,?)",true,true);
        DBObject oErrorMsg = (DBObject)oOutArray.get(0);
        String error_msg = ((String)oErrorMsg.getObject()).trim();
        DBObject oErrorCode = (DBObject)oOutArray.get(1);
        Integer error_code = ((Integer)oErrorCode.getObject());
        if(!(error_code.equals(new Integer(1))))
        {
            updateSessionStatus("MONTHENDSING",lSiteID, hdnEmpLbrFlag);
        }
        return error_msg;       
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
  
  public String getMaxPayYear(long siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
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
 
    public String getEmpWaitingToJoin(long userId, long siteId) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output 
        ArrayList oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_EmpWaitingToJoin(?,?,?)",true,true);
        DBObject oOutObject = (DBObject)oOutArray.get(1);
        Integer errCode = (Integer)(oOutObject.getObject());
        
        oOutObject = (DBObject)oOutArray.get(0);
        String empWaitToJoin = (String)oOutObject.getObject();
        return empWaitToJoin;
    }
}