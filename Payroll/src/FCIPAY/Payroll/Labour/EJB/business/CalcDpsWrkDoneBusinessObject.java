package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import FCIPAY.Payroll.Labour.Utility.CalcDpsWrkDoneHeaderBean;

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
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.PayrollSQLQueries;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class CalcDpsWrkDoneBusinessObject extends BaseBO
{
  public CalcDpsWrkDoneBusinessObject()
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

  public String calcDpsWrkDone(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    String errorMsg ="";
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String process="INCENTIVE";
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    
   /* oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtGangId())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtLocId())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getScreenFlag())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCalcDpsWrkDoneHeaderBean.getTxtFrom())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCalcDpsWrkDoneHeaderBean.getTxtTo())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_LBR_COMPUTE_INCT_v2.proc_createDPSLabrActual_v2(?,?,?,?,?,?,?,?,?)",true,true);   */
    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,process));
        
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,""));
         oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
       
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtGangId())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtLocId())));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getScreenFlag())));
        oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCalcDpsWrkDoneHeaderBean.getTxtFrom())));
        oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCalcDpsWrkDoneHeaderBean.getTxtTo())));

        oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"fci_payroll_sequential_pkg.proc_chk_concurrency(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true); 
   
   
    DBObject oErrorMsg = (DBObject)oOutArray.get(0);
    String error_msg = ((String)oErrorMsg.getObject()).trim();
    DBObject oErrorCode = (DBObject)oOutArray.get(1);
    Integer error_code = ((Integer)oErrorCode.getObject());
  /*  if(!(error_code.equals(new Integer(1))))
    {
      updateSessionStatus("INCENTIVE",lSiteID, oCalcDpsWrkDoneHeaderBean.getHdnEmpLbrFlag());
    }*/
    return error_msg;     
  } 

    public void updateSessionStatus(String module,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList   oParameters = new ArrayList();
        oParameters.add(new InputDBObject(1,ParameterTypes.VARCHAR, new String(module+lSiteID+hdnEmpLbrFlag)));
        int iRetType = oBean.executeUpsert(oParameters,PayrollSQLQueries.Update_Session_State);
    }

  public String undoDpsWrkDone(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    String process="UNDOINCT";
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
   //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtGangId())));
   //   oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtLocId())));
    
     /* oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtLbrTyp())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LBR_COMPUTE_INCT_v2.PROC_UNDO_INCENTIVE_v2(?,?,?,?,?)",true,true); */
      
       oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getHdnEmpLbrFlag())));
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
      

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Undo DPS Work Done ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }

      return errorMsg;      
  }

  public String PostInvToAP(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String lbrTyp = "";
    String process="POSTINCT";
    if(oCalcDpsWrkDoneHeaderBean.getHdnEmpLbrFlag().equals("L"))
        lbrTyp = "I";
    else if(oCalcDpsWrkDoneHeaderBean.getHdnEmpLbrFlag().equals("D"))   
        lbrTyp = "A";
    
    ArrayList oOutArray; //Output 
    
    //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtGangId())));
 
  /*  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtInvType()))); // added by swapnendu Dt 01 Oct 2012. 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,lbrTyp));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,""));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,""));      
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_post_sal_to_ap.post_Inct_to_ap(?,?,?,?,?,?,?,?)",true,true);  */
    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,lbrTyp));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,process));
        
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,""));
         oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,""));
       
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtInvType())));
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.INTEGER,new Integer(0)));
        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,""));

        oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"fci_payroll_sequential_pkg.proc_chk_concurrency(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true); 
   
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    String oErrorMsg = (String)oOutObject.getObject();
    Integer errCode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
    
  /*  if(!(errCode.equals(new Integer(1))))
    {
        updateSessionStatus("POSTINCT",lSiteID, lbrTyp);
    }*/
    return oErrorMsg;
  }

  public String monthEnd(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String process="MONTHENDINCT";
    System.out.println(oCalcDpsWrkDoneHeaderBean.getHdnEmpLbrFlag());
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
    //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtGangId())));
    //  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtLocId())));
    
    /*  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lUserID)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lSiteID)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getTxtLbrTyp())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LBR_COMPUTE_INCT_v2.Proc_Lbr_Monthend(?,?,?,?,?)",true,true);      */
      
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCalcDpsWrkDoneHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,""));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,process));
        
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,""));
         oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,""));
       
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
   
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Work Done Month End ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }

      return errorMsg;       
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

  public LovVO getCalcWrkDoneGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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

  public LovVO getCalcWrkDoneDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    String flag="";
    
    if(hdnEmpLbrFlag.equals("D"))
    {
      flag="A";
    }
    else
    {
      flag="I";
    }
    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,flag));
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