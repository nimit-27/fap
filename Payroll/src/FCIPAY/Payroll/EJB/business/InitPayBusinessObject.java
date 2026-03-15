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
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.PayrollSQLQueries;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class InitPayBusinessObject extends BaseBO
{
  public InitPayBusinessObject()
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
  
  

  public String InitPayRollData(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    String process="INITSAL";
    ArrayList oOutArray; //Output 
  /*    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER)); */
    
         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,process));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,""));
         oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
         oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
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
          
     
   /*  if(hdnEmpLbrFlag.equals("L"))
     {
              oOutArray = oBean.callProc(oParameters,"PKG_INITIAL_PAYROLL_LBR.InitialisePayrollData(?,?,?,?,?)",true,true);
 
     }
     else if(hdnEmpLbrFlag.equals("D"))
     {
              oOutArray = oBean.callProc(oParameters,"pkg_initial_payroll_fci_dps.InitialisePayrollData(?,?,?,?,?)",true,true);
 
     }     
     else
     {
      oOutArray = oBean.callProc(oParameters,"PKG_INITIAL_PAYROLL_FCI.InitialisePayrollData(?,?,?,?,?)",true,true);
     }*/
     
    DBObject oErrorMsg = (DBObject)oOutArray.get(0);
    String error_msg = ((String)oErrorMsg.getObject()).trim();
    DBObject oErrorCode = (DBObject)oOutArray.get(1);
    Integer error_code = ((Integer)oErrorCode.getObject());
  /*  if(!(error_code.equals(new Integer(1))))
    {
        updateSessionStatus("INITSAL", lSiteID, hdnEmpLbrFlag);
    }*/
    oBean = null;
    oParameters = null;
    oOutArray = null;
    return error_msg;       
  }

    public void updateSessionStatus(String module,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList   oParameters = new ArrayList();
        oParameters.add(new InputDBObject(1,ParameterTypes.VARCHAR, new String(module+lSiteID+hdnEmpLbrFlag)));
        int iRetType = oBean.executeUpsert(oParameters,PayrollSQLQueries.Update_Session_State);
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

    //oParameters = new ArrayList();
 
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
    oIt = null;
    oBean = null;
    oRetList = null;
    oOutArray = null;
    oParameters = null;
    return sRevYear;
  }
  
  public ArrayList getSeparationEmpDetail(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
      ArrayList oList = new ArrayList();   
      ArrayList EmpNumList = new ArrayList();   
      ArrayList oOutArray; //Output 
      String sRevYear=getMaxPayYear(lSiteID,hdnEmpLbrFlag);
      String yyyy = sRevYear.substring(0,4);
      String mm=sRevYear.substring(4,6);
      sRevYear="01/"+mm+"/"+yyyy;
      DBUtilitiesBean oBean = new DBUtilitiesBean();  
	  oList.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(lSiteID)));
      oList.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
	  oList.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sRevYear));
      oList.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));       
      oList.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_PAYROLL_MISC.proc_ChkSeparatedEmp(?,?,?,?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   
     
    int count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           EmpNumList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        
        EmpNumList.add(oRow.get("EMP_NUM").getString());
        oRow = null;
  
    }    
    oIt = null;
    oList = null;
    oOutObject = null; 
    oBean = null;
    sRevYear = null;
    yyyy = null;
    mm = null;
    return EmpNumList;
  } 
// Added by dushyant on 20-Oct-2011 for Dps Labour Initialise
 public String InitDpsIncentiveData(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
     if(hdnEmpLbrFlag.equals("A"))
      {
        WrongwrkslipCheck(lSiteID, hdnEmpLbrFlag); // added by dushyant on 15-April-2013
      }     
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,"N"));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LBR_COMPUTE_INCT_V2.proc_createDPSwrkslip_Pday(?,?,?,?,?,?,?,?,?,?)",true,true);
      DBObject oErrorMsg = (DBObject)oOutArray.get(0);
      String error_msg = ((String)oErrorMsg.getObject()).trim();
      DBObject oErrorCode = (DBObject)oOutArray.get(1);
      Integer error_code = ((Integer)oErrorCode.getObject());
      if(!(error_code.equals(new Integer(1))))
      {
        updateSessionStatus("INITINCT",lSiteID, hdnEmpLbrFlag);
      }
      return error_msg;       
  }
// end
/*
 * added by swapnendu Dt 28-Aug-2012 to show the penalised employees on or before
 * the current payroll month.
 * during initialisation process.
 */
  public ArrayList getEmpPenaltyList(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
      ArrayList oParameters = new ArrayList();   
      ArrayList EmpPenaltyList = new ArrayList();   
      ArrayList oOutArray; //Output 
      String sRevYear = getMaxPayYear(lSiteID,hdnEmpLbrFlag);
      DBUtilitiesBean oBean = new DBUtilitiesBean();  
	  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(lSiteID)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
	  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sRevYear));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));       
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_EmpPenaltyList(?,?,?,?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      ArrayList oList = (ArrayList)(oOutObject.getObject());   
     
    int count = 0;
    QueryRow oRow = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           EmpPenaltyList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        
        EmpPenaltyList.add(oRow.get("EMP_NUM").getString());
        oRow = null;
  
    }    
    oIt = null;
    oList = null;
    oOutObject = null; 
    oBean = null;
    sRevYear = null;
    return EmpPenaltyList;
  } 
  
  // added by dushyant on 15-March-2013
    public void WrongwrkslipCheck(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList=null;
      Timestamp oWhenPicked = null;
      int count = 0;
      BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
      String msg=null; 
      ArrayList oOutArray; //Output 

      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_dps_compute_inct.proc_gangcheck(?,?,?,?)",true,true);      
      DBObject oErrorCode = (DBObject)oOutArray.get(0);
      String error_msg = (String)oErrorCode.getObject();
      Integer error_code = (Integer)(((DBObject)oOutArray.get(1)).getObject());
	  if(error_code.intValue()==2)
      {
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(error_msg));
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
	  }
  }  
  // End by dushyant
  
  public ArrayList getEmpTobeSeparateList(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
      ArrayList oParameters = new ArrayList();   
      ArrayList EmpList = new ArrayList();   
      ArrayList oOutArray; //Output 
      String sRevYear = getMaxPayYear(lSiteID,hdnEmpLbrFlag);
      String yyyy = sRevYear.substring(0,4);
      String mm=sRevYear.substring(4,6);
      sRevYear="01/"+mm+"/"+yyyy;
      DBUtilitiesBean oBean = new DBUtilitiesBean();  
	  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(lSiteID)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
	  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sRevYear));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));       
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.Is_Site_Initialisable2(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String abc = (String)(oOutObject.getObject());   
     EmpList.add(abc);
    return EmpList;
  } 
  
}