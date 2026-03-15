package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintInterestRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.InrRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.ComFinalHeaderBean;
import FCIPAY.Payroll.UTILITY.IntRateDetailBean;
import FCIPAY.Payroll.UTILITY.ComFinalDetailBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.util.Date;
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
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetComboVO;
import java.text.*;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

public class ComFinalBusinessObject extends BaseBO
{
  public ComFinalBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("ComFinalSetScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }
  public String compute(String procs, ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
   // ArrayList oList;
    String errorMsg="";

    ArrayList oOutArray = null; //Output 
    ArrayList oList=new ArrayList();
   if((procs.equals("SAL")||procs.equals("INCT")||procs.equals("DED")) && !oComFinalSetQueryVO.getHdnEmpLbrFlag().equals("E"))
   {
           checkMaxPayYear(oComFinalSetQueryVO.getLoginLocCode(),oComFinalSetQueryVO.getHdnEmpLbrFlag(),oComFinalSetQueryVO.getTxtDate(),oList,procs); 

   }
   else
   {
    checkMaxPayYear(oComFinalSetQueryVO.getLoginLocCode(),oComFinalSetQueryVO.getHdnEmpLbrFlag(),oComFinalSetQueryVO.getTxtDate(),oList); 
   }
    reportError(oList);
    oList=null;
    if(procs.equals("DED"))
    { 
      oParameters = new ArrayList();   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_OutstndgAdjstFinal(?,?,?,?,?)",true,true);    
      oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        
         
      } 
      oOutArray=null;
    }
    if(procs.equals("GRA"))
    {
      oParameters = new ArrayList();   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalSetQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_RelGratuity(?,?,?,?,?,?)",true,true);    
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         
      } 
      //oOutArray=null;
    }
    if(procs.equals("LEAVE"))
    {
      //oParameters = new ArrayList();  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalSetQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_RelLeaveEncash(?,?,?,?,?,?)",true,true);    
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         
      } 
      //oOutArray=null;
    }    
    
    ///////////////
    if(procs.equals("IT"))
    {
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_CALCULATE_TAX_ACTUALS_FCI.getITOutstdFinalSettle(?,?,?,?,?,?)",true,true);    
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();    
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if(! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        
      } 
      //oOutArray=null;
    }
    
    ///////////////
    if(procs.equals("NEG_INV"))
    {
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalSetQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_CreateLiability(?,?,?,?,?,?)",true,true);    
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();    
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if(! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        
      } 
      //oOutArray=null;
    }
    
    //////////////
    if(procs.equals("SAL"))
    {
      oParameters = new ArrayList();   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalSetQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_RelLastSal(?,?,?,?,?,?)",true,true);    
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
    }
//Incentive Release added by swapnendu Dt 24 Jul 12
    if(procs.equals("INCT"))
    {
      oParameters = new ArrayList();   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalSetQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_rellastinct(?,?,?,?,?,?)",true,true);    
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
       
      } 
      //oOutArray=null;
    }
    
     if(procs.equals("HPL"))
    { 
      oParameters = new ArrayList();   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_RelHPLEncash(?,?,?,?,?,?)",true,true);    
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         
      } 
      //oOutArray=null;
    }
    
   //added by swarnika 
      if(procs.equals("VRS"))
      {
       oParameters = new ArrayList();   
       oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
       oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getHdnEmpLbrFlag()));
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
       oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
       oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
       oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
       oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_RelVrsAmt(?,?,?,?,?,?)",true,true);    
       //oParameters=null;
       DBObject oOutObject = (DBObject)oOutArray.get(0);
       errorMsg = (String)oOutObject.getObject();
       Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
       if( ! errCode.equals(new Integer(0)))
       {
          ArrayList oArguments = new ArrayList();
          
          
          
          oArguments.add(new String(errorMsg));
          System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          
       } 
       //oOutArray=null;
      }
      
    return errorMsg;
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
    String graFlag;
   String editflag =oComFinalHeaderBean.getChkEditSepEntry();
    /*String penFlag, graFlag, gisFlag, pfSettleFlag, leaveFlag, comFlag;
    if(oComFinalHeaderBean.getPenFlag())
      penFlag = new String("1");
    else
      penFlag = new String("0");      
    if(oComFinalHeaderBean.getComFlag())
      comFlag = new String("1");
    else
      comFlag = new String("0");
    if(oComFinalHeaderBean.getGraFlag())
      graFlag = new String("1");
    else
      graFlag = new String("0");
    if(oComFinalHeaderBean.getGisFlag())
      gisFlag = new String("1");
    else
      gisFlag = new String("0");
    if(oComFinalHeaderBean.getPfSettleFlag())
      pfSettleFlag = new String("1");
    else
      pfSettleFlag = new String("0");
    if(oComFinalHeaderBean.getLeaveFlag())
      leaveFlag = new String("1");
    else
      leaveFlag = new String("0");*/
if (!editflag.equals(new String ("E"))) 
{
    if(oComFinalHeaderBean.getGraFlag())
      graFlag = new String("Y");
    else
      graFlag = new String("N");

    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtNoAccELd())));    
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtGratuity())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtLeave())));    
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtGraSancAmt())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtGraSancNo())));
    
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtLeaveEncaSancAmt())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtLeaveEncaSancNo())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtGraSancDt())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtLeaveEncaSancDt())));
   
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtLien())));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR, new String(graFlag)));
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtHPLNetAmt())));
    oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtHPLEncaSancAmt())));
    String hPLEncaSancNo = oComFinalHeaderBean.getTxtHPLEncaSancNo();
    if(hPLEncaSancNo==null)
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR, new String("")));
    else
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtHPLEncaSancNo())));
    oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtHPLEncaSancDt())));
    String hPLNoAccEld = oComFinalHeaderBean.getTxtHPLNoAccEld();
    if(hPLNoAccEld==null)
     oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR, new String("")));
    else
     oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtHPLNoAccEld())));
    
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtVrsNetAmt())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtVrsGrossAmt())));
      String vrsAmtSancNo = oComFinalHeaderBean.getTxtVrsSancNo();
      if (vrsAmtSancNo==null)
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR, new String(""))); 
      else 
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtVrsSancNo())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtVrsSancDt())));
      
    
    oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtUserID())));
    
    oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(24,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(25,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_UpdateComFinalSetHeader(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);    
    oParameters=null;
    graFlag=null;
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
     String errorMg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if(!errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMg));
         System.out.println("Error!!! while updating separation entry ::");
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         
      } 
      
    /*  else 
      {
      ArrayList oArguments = new ArrayList();
     oArguments.add(new String(errorMg));
     throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } */
    
  }
  else
  {
      System.out.println("in else");  
       ArrayList oOutArray; //Output 

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oComFinalHeaderBean.getTxtDate())));   
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtSepTyp())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtDepOrg())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtLien())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
    //oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_updatesepentry(?,?,?,?,?,?,?,?,?)",true,true);  
    //oParameters=null;
    //oBean=null;
       
      DBObject oOutObject = (DBObject)oOutArray.get(0);
     String errorMg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if(!errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMg));
         System.out.println("Error!!! while updating separation entry ::");
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         
      } 
      
     /* else 
      {
      ArrayList oArguments = new ArrayList();
     oArguments.add(new String(errorMg));
     throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
      */
     
      
      //return (String)oComFinalHeaderBean.getTxtEmpNo();
      
      
  }
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    //ArrayList oList;
    int count = 0;
    ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oComFinalHeaderBean.getTxtDate())));   
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtSepTyp())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtDepOrg())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtLien())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_InsertComFinalSetHeader(?,?,?,?,?,?,?,?,?,?)",true,true);  
    //oParameters=null;
    //oBean=null;
       
      DBObject oOutObject = (DBObject)oOutArray.get(0);
     String errorMg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if(!errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMg));
         System.out.println("Error!!! while Adjusting deductions ::");
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
         
      } 
      
      return (String)oComFinalHeaderBean.getTxtEmpNo();    
  }


  public boolean saveComFinalHeader(ComFinalHeaderBean oComFinalHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      return true;
  }

 public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("ComFinalSetScreen"))
    {      
      saveComFinal(sHeaderPrimaryKey,(ComFinalHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }    
  }
  
  private void saveComFinal(String sPrimaryKey,ComFinalHeaderBean oComFinalHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        ComFinalDetailBean oComFinalDetailBean = (ComFinalDetailBean)oIt.next();
        if(oComFinalDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_COMP_FINAL_SETTLE.proc_InsertComFinalSetDetail(?,?,?,?,?,?,?)");
            bInsert = true;
          }

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtPayCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtAmt()))); 
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtTransMastId()))); 
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtOldNewFlag())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));  
     
          oBeanInsert.addToBatch(oParameters);
          //oParameters=null;
        }
        else if(oComFinalDetailBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_COMP_FINAL_SETTLE.proc_UpdateComFinalSetDetail(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtSerialNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtPayCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtAmt())));   
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          // oParameters=null;
          
        }
        else if(oComFinalDetailBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!oComFinalDetailBean.getTxtSerialNo().equals(""))
          {
            if(!bDelete)
            {
              oBeanDelete = new DBUtilitiesBean();
              oBeanDelete.createBatch("PKG_COMP_FINAL_SETTLE.proc_DeleteComFinalSetDetail(?,?)");
              bDelete = true;
            }         
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtSerialNo())));   
            oBeanDelete.addToBatch(oParameters);
             //oParameters=null;
          }
        }
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
   
  }

  public RecordMetaInfo getComFinalHeaderMetaInfo(ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
     
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_GetComFinalHeaderCount(?,?,?,?,?,?)");
       //oParameters=null;
       //oBean=null;
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      //oOutArray=null;
      return oRecordMetaInfo;
    
  }


  public boolean saveIntRatesHeader(ComFinalHeaderBean oComFinalHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    /*ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
//    AddressDetailBean oAddress;
    BaseDetailVO oBaseDetailVO = null;
          
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintInrRateHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintInrRateHeaderBean.getTxtDateFrom()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oMaintInrRateHeaderBean.getTxtDateTo()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_saveDARatesHeader(?,?,?,?)");*/
      return true;
  }



  public ArrayList getComFinalHeader(ComFinalSetQueryVO oComFinalSetQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oComFinalSetQueryVO == null)
    {
      oComFinalSetQueryVO = new ComFinalSetQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

    /*if(oComFinalSetQueryVO.getLoanType() == null)
    {
      String hPrimaryKey = oIntRateQueryVO.getHeaderPrimaryKey();
      int ind = hPrimaryKey.indexOf(",",0);
      oIntRateQueryVO.setLoanType(hPrimaryKey.substring(0, ind));
      System.out.println(oIntRateQueryVO.getLoanType());
      int ind1 = hPrimaryKey.indexOf(",",ind+1);
      oIntRateQueryVO.setDateFrom(hPrimaryKey.substring(ind+1, ind1));
      System.out.println(oIntRateQueryVO.getDateFrom());
      oIntRateQueryVO.setDateTo(hPrimaryKey.substring(ind1+1, hPrimaryKey.length()));
      System.out.println(oIntRateQueryVO.getDateTo());
    } */   

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_GetComFinalHeader(?,?,?,?,?,?,?)");
      //oParameters=null;
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     
      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      ComFinalHeaderBean oComFinalHeaderBean;
      count = 0;
      QueryRow oRow = null;
      HashMap oColumns = null;
      Iterator oIt = oList.iterator();
      String penFlag, graFlag, gisFlag, pfSettleFlag, leaveFlag;
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oHeaderList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oComFinalHeaderBean = new ComFinalHeaderBean();
//          oMaintDARatesHeaderBean.setHeaderPrimaryKey(oRow.get("srl_no").getString());
          oComFinalHeaderBean.setHdnEmpLbrFlag(oComFinalSetQueryVO.getHdnEmpLbrFlag());
          oComFinalHeaderBean.setTxtEmpNo(oRow.get("Emp_Num").getString());
          oComFinalHeaderBean.setTxtEmpName(oRow.get("emp_name").getString());
          oComFinalHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
          oComFinalHeaderBean.setTxtCategDesc(oRow.get("ctgry").getString());
          oComFinalHeaderBean.setTxtEmpType(oRow.get("emp_type").getString());
          oComFinalHeaderBean.setTxtPresentPOPDesc(oRow.get("loc_desc").getString());
          oComFinalHeaderBean.setTxtDOJSite(oRow.get("comp_joining_date").getString());
          oComFinalHeaderBean.setTxtCpfCode(oRow.get("cpf_code").getString());
          oComFinalHeaderBean.setTxtEmpStatus(oRow.get("status").getString());          
          oComFinalHeaderBean.setTxtNetEarning(oRow.get("salary").getString());
          
          oComFinalHeaderBean.setTxtNoAccELd(oRow.get("ACCL_EL_DAYS").getString());
          oComFinalHeaderBean.setTxtDate(EnrgiseUtil.convertToString(oRow.get("EXPIRY_DATE").getDate()));
          oComFinalHeaderBean.setTxtTotDed(oRow.get("TOTAL_DEDUCTIONS").getString());
          oComFinalHeaderBean.setTxtOutDed(oRow.get("TOTAL_DEDUCTIONS").getString());
          oComFinalHeaderBean.setTxtGratuity(oRow.get("Gratuity_Amt").getString());
          oComFinalHeaderBean.setTxtLeave(oRow.get("Leave_Encash_Amt").getString());
          
          oComFinalHeaderBean.setTxtSepTyp(oRow.get("SEP_TYPE").getString());
          oComFinalHeaderBean.setTxtDepOrg(oRow.get("DEPU_ORG").getString());
          
          oComFinalHeaderBean.setTxtGraSancNo(oRow.get("GRATUITY_SANC_NO").getString());
          oComFinalHeaderBean.setTxtGraPaidAmt(oRow.get("GRATUITY_PAID_AMT").getString());
          oComFinalHeaderBean.setTxtGraSancDt(EnrgiseUtil.convertToString(oRow.get("GRATUITY_SANC_DATE").getDate()));
          oComFinalHeaderBean.setTxtGraSancAmt(oRow.get("GRATUITY_SANC_AMT").getString());
          
          oComFinalHeaderBean.setTxtLeaveEncaSancNo(oRow.get("LEAVE_ENCASH_SANC_NO").getString());
          oComFinalHeaderBean.setTxtLeavePaidAmt(oRow.get("Leave_Encash_Paid_Amt").getString());
          oComFinalHeaderBean.setTxtLeaveEncaSancDt(EnrgiseUtil.convertToString(oRow.get("LEAVE_ENCASH_SANC_DATE").getDate()));
          oComFinalHeaderBean.setTxtLeaveEncaSancAmt(oRow.get("LEAVE_ENCASH_SANC_AMT").getString());
          
          oComFinalHeaderBean.setTxtHPLEncaSancAmt(oRow.get("HPL_ENCASH_SANC_AMT").getString());
          oComFinalHeaderBean.setTxtHPLEncaSancDt(EnrgiseUtil.convertToString(oRow.get("HPL_ENCASH_SANC_DATE").getDate()));        
          oComFinalHeaderBean.setTxtHPLEncaSancNo(oRow.get("HPL_ENCASH_SANC_NO").getString());
          oComFinalHeaderBean.setTxtHPLNetAmt(oRow.get("HPL_ENCASH_AMT").getString());
          oComFinalHeaderBean.setTxtLien(oRow.get("LIEN_PERIOD").getString());
          oComFinalHeaderBean.setTxtHPLNoAccEld(oRow.get("HPL_EL_DAYS").getString());
          oComFinalHeaderBean.setTxtVrsSancNo(oRow.get("VRS_SANC_NO").getString());
          oComFinalHeaderBean.setTxtVrsGrossAmt(oRow.get("VRS_SANC_AMT").getString());
          oComFinalHeaderBean.setTxtVrsSancDt(EnrgiseUtil.convertToString(oRow.get("VRS_SANC_DATE").getDate()));
          oComFinalHeaderBean.setTxtVrsNetAmt(oRow.get("VRS_GROSS_AMT").getString());
         
          oComFinalHeaderBean.setTxtflagITDetail(oRow.get("ITflag").getString());
          oComFinalHeaderBean.setTxtIfGratuityChng(oRow.get("chkGratuity").getString());
          
          
          String sGraFlag=oRow.get("ADJ_FRM_GRATUITY").getString();
          if(sGraFlag!=null && sGraFlag.equals("Y"))
          {
            oComFinalHeaderBean.setGraFlag(true);
          }
          else
          {
            oComFinalHeaderBean.setGraFlag(false);
          }
          oComFinalHeaderBean.setTxtIncentiveAmt(oRow.get("incentive").getString());
          
          oComFinalHeaderBean.setTxtLastSalInv(oRow.get("INVOICE_NUM_LAST_SAL").getString());
          oComFinalHeaderBean.setTxtLeaveEncInv(oRow.get("INVOICE_NUM_LEAVE_ENCSHMNT").getString());
          oComFinalHeaderBean.setTxtGratuityInv(oRow.get("INVOICE_NUM_GRATUITY").getString());
          oComFinalHeaderBean.setTxtOutStandInv(oRow.get("INVOICE_NUM_OUTSTNDNG_AMT").getString());
          oComFinalHeaderBean.setTxtHPLEncInv(oRow.get("INVOICE_NUM_HPL_ENCSHMNT").getString());
          oComFinalHeaderBean.setTxtIncentiveInv(oRow.get("INVOICE_NUM_LAST_INCT").getString());
          oComFinalHeaderBean.setTxtVrsInv(oRow.get("INVOICE_NUM_VRS").getString());
          oHeaderList.add(oComFinalHeaderBean);
          oComFinalHeaderBean=null;
      }      
      //oOutArray=null;
      // oList=null; 
    return oHeaderList;
  }


  
  public RecordMetaInfo getComFinalDetailMetaInfo(String sPrimaryKey,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; 
    Long recCount=new Long(0);
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oComFinalSetDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_GetComFinalDetailCount(?,?,?,?)");
     // oParameters=null;
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      recCount=(Long)oTotalRecord.getObject();
      if(recCount.equals(new Long(0)))
      {
        ArrayList oList=new ArrayList();
        checkMaxPayYear(oComFinalSetDetailInfo.getLoginLocCode(),oComFinalSetDetailInfo.getHdnEmpLbrFlag(),oComFinalSetDetailInfo.getTxtDate(),oList); 
        reportError(oList);
        return getComfinLoanDtlCount(sPrimaryKey,oComFinalSetDetailInfo);
      }
      
      if(oComFinalSetDetailInfo.getTxtflagGetDetail().equals("IT"))
      {
        ArrayList oList=new ArrayList();
        return getITDtlCount(sPrimaryKey,oComFinalSetDetailInfo);
      }
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      //oOutArray=null;
      return oRecordMetaInfo;      
  }

  public RecordMetaInfo getITDtlCount(String sPrimaryKey,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oComFinalSetDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_OutstndgLoanAdvCount(?,?,?,?,?,?,?)",false,true);
      //oParameters=null;
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      //oOutArray=null;
      return oRecordMetaInfo;      
  }
  
  
  
  public RecordMetaInfo getComfinLoanDtlCount(String sPrimaryKey,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oComFinalSetDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_OutstndgLoanAdvCount(?,?,?,?,?,?,?)",false,true);
      //oParameters=null;
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      //oOutArray=null;
      return oRecordMetaInfo;      
  }
  
  
  public ArrayList getComfinLoanDtl(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray;
    ComFinalDetailBean oComFinalDetailBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oComFinalDetail = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oComFinalSetDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getUserId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.Proc_OutstndgLoanAdv(?,?,?,?,?,?)",false,true);
      //oParameters=null;
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
       // oOutArray=null;
        if(oList.size() == 0)
        {
       //   throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
       return new ArrayList();
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oComFinalDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oComFinalDetailBean = new ComFinalDetailBean();
          oComFinalDetailBean.setTxtTransMastId((oRow.get("id").getString()));
          oComFinalDetailBean.setTxtAmt((oRow.get("balamt").getString()));
          oComFinalDetailBean.setTxtOutAmt((oRow.get("balamt").getString()));
          oComFinalDetailBean.setTxtDesc((oRow.get("paycodedesc").getString())); 
          oComFinalDetailBean.setTxtPayCode((oRow.get("paycode").getString())); 
          oComFinalDetailBean.setTxtDednAdjFlag("N");
          oComFinalDetailBean.setStatus("N");
          oComFinalDetailBean.setTxtRecFlag("Y");
          oComFinalDetailBean.setTxtOldNewFlag((oRow.get("flag").getString()));
            
          oComFinalDetail.add(oComFinalDetailBean);
          oComFinalDetailBean=null;
        }  
        //oList=null;
       return oComFinalDetail;
  }
  
  public ArrayList getComFinalDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray;
    ComFinalDetailBean oComFinalDetailBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oComFinalDetail = null;

   oParameters = new ArrayList();
   if(oComFinalSetDetailInfo.getTxtflagGetDetail().equals("N"))
   {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oComFinalSetDetailInfo.getTxtEmpNo()));
        //  oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_GetComFinalDetail(?,?,?,?,?)");
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size()== 0)
        {        
            int recordCount = getDetailCount(oComFinalSetDetailInfo.getTxtEmpNo());// added by sonia
            if(recordCount == 0)
            {
                ArrayList oErrList=new ArrayList();
                //checkMaxPayYear(oComFinalSetDetailInfo.getLoginLocCode(),oComFinalSetDetailInfo.getHdnEmpLbrFlag(),oComFinalSetDetailInfo.getTxtDate(),oErrList); 
                checkMaxPayYear(oComFinalSetDetailInfo.getLoginLocCode(),oComFinalSetDetailInfo.getHdnEmpLbrFlag(),oComFinalSetDetailInfo.getTxtDate(),oErrList,"GET");
                reportError(oErrList);
                return getComfinLoanDtl(sPrimaryKey,lDetailFirstPosition,lDetailLastPosition,oComFinalSetDetailInfo);
            }
            else
            {
                return new ArrayList();                    
            }  
        }
    } 
      
    if(oComFinalSetDetailInfo.getTxtflagGetDetail().equals("IT"))
    {        
        ArrayList oErrList=new ArrayList();
        checkMaxPayYear(oComFinalSetDetailInfo.getLoginLocCode(),oComFinalSetDetailInfo.getHdnEmpLbrFlag(),oComFinalSetDetailInfo.getTxtDate(),oErrList); 
        reportError(oErrList);
        return getITDtls(sPrimaryKey,lDetailFirstPosition,lDetailLastPosition,oComFinalSetDetailInfo);
    }  
    count = 0;
    oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
            oComFinalDetail = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oComFinalDetailBean = new ComFinalDetailBean();
        oComFinalDetailBean.setTxtSerialNo((oRow.get("srl_no").getString()));
        oComFinalDetailBean.setTxtAmt((oRow.get("dedn_amount").getString()));
        oComFinalDetailBean.setTxtDesc((oRow.get("pay_code_desc").getString())); 
        oComFinalDetailBean.setTxtPayCode((oRow.get("pay_code").getString()));  
        oComFinalDetailBean.setTxtTransMastId((oRow.get("pay_code").getString()));
        oComFinalDetailBean.setTxtOutAmt((oRow.get("outstandingamt").getString()));
        oComFinalDetailBean.setTxtDednAdjFlag((oRow.get("adj_flag").getString()));  //added by swapnendu to freez the deduction components after adjustment on them is done, to restrict further changes in these components.
        oComFinalDetailBean.setChkManDednFlag(oRow.get("arc_flag").getString());
        oComFinalDetailBean.setStatus("Q");
        oComFinalDetailBean.setTxtRecFlag("Y");
          
        oComFinalDetail.add(oComFinalDetailBean);
    }  
    return oComFinalDetail;
  }
  //////added by sonia /////////////
  public int getDetailCount(String empno) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
      ArrayList oList = new ArrayList();      
      ArrayList oOutArray; //Output 
      DBUtilitiesBean oBean = new DBUtilitiesBean();      
      oList.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empno)));
      oList.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));       
      oList.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oList,"PKG_COMP_FINAL_SETTLE.proc_checkSeparationDetails(?,?,?)");
      Integer i = (Integer)((DBObject)oOutArray.get(0)).getObject();
      int count = i.intValue();
  //oList=null;
      return count;
  
  }
  //////end added by sonia/////////////
 public ArrayList getITDtls(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray;
    ComFinalDetailBean oComFinalDetailBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oComFinalDetail = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oComFinalSetDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getUserId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_CALCULATE_TAX_ACTUALS_FCI.getITOutstdFinalSettle(?,?,?,?,?,?)",false,true);
      //oParameters=null;
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
       // oOutArray=null;
        if(oList.size() == 0)
        {   
       //   throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
            return new ArrayList();
        }  
      
        count = 0;
        oIt = oList.iterator();
          
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oComFinalDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oComFinalDetailBean = new ComFinalDetailBean();
          oComFinalDetailBean.setTxtTransMastId((oRow.get("id").getString()));
          oComFinalDetailBean.setTxtAmt((oRow.get("balamt").getString()));
          oComFinalDetailBean.setTxtOutAmt((oRow.get("balamt").getString()));
          oComFinalDetailBean.setTxtDesc((oRow.get("paycodedesc").getString())); 
          oComFinalDetailBean.setTxtPayCode((oRow.get("paycode").getString())); 
          oComFinalDetailBean.setTxtOldNewFlag((oRow.get("flag").getString())); 
          oComFinalDetailBean.setTxtDednAdjFlag((oRow.get("adj_flag").getString()));  //added by swapnendu to freez the deduction components after adjustment on them is done, to restrict further changes in these components.
          oComFinalDetailBean.setStatus("N");
          oComFinalDetailBean.setTxtRecFlag("Y");
                  
          oComFinalDetail.add(oComFinalDetailBean);
          oComFinalDetailBean=null;
        }  
       // oList=null;
       return oComFinalDetail;
  } 
  
  
  public LovVO getComFinalSetEmpNoN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");   
    arylstHeaderNames.add("CPF Code");     
    arylstHeaderNames.add("Category"); 
    arylstHeaderNames.add("Emp Status");         
    arylstHeaderNames.add("Designation");  
    arylstHeaderNames.add("Present Place of Posting");   
    arylstHeaderNames.add("Emp Type");
    arylstHeaderNames.add("Date of Joining");  
    arylstHeaderNames.add("Retirement Date");   
    oLovVO.setHeaderList(arylstHeaderNames);
    arylstHeaderNames=null;
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);
    //arylstVisibility=null;
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField3()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_GetComFinalSetEmpNoLOVN(?,?,?,?,?,?,?)");
      //oParameters=null;
      DBObject oOutObject=(DBObject)oOutArray.get(0);
      oList=(ArrayList)(oOutObject.getObject());
     // oOutArray=null;

      QueryRow oRow=null;

 
    Iterator iter = oList.iterator();
    String ss=getTdyDate();
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
      oLOVBean.setDetailField4(oRow.get("category").getString());            
      oLOVBean.setDetailField5(oRow.get("emp_status").getString());            
      oLOVBean.setDetailField6(oRow.get("dsgn_desc").getString());            
      oLOVBean.setDetailField7(oRow.get("place_of_posting").getString());            
      oLOVBean.setDetailField8(oRow.get("emp_type").getString());            
      oLOVBean.setDetailField9(EnrgiseUtil.convertToString(oRow.get("site_joining_date").getDate()));            
      oLOVBean.setDetailField10("");   
      //oLOVBean.setDetailField10(ss);   
      oList.add(oLOVBean);
     // oLOVBean=null;
    }
     
    oLovVO.setDetailList(oList);
    //oList=null;
    return oLovVO;
  }
  
  public LovVO getComFinalSetEmpNoQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");
  	arylstHeaderNames.add("CPF Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    //arylstHeaderNames=null;
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
	  arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    //arylstVisibility=null;
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField3()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_GetComFinalSetEmpNoLOVQ(?,?,?,?,?,?,?)");
      //oParameters=null;
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
      oList.add(oLOVBean);
      //oLOVBean=null;
    }
     //oOutArray=null;
    oLovVO.setDetailList(oList);
    oList=null;
    return oLovVO;
  }
  public LovVO getComFinalSetPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Code");    
    arylstHeaderNames.add("Pay Code Desc");    
    oLovVO.setHeaderList(arylstHeaderNames);
    //arylstHeaderNames=null;
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
   // arylstVisibility=null;
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtEmpNo")));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_GetComFinalSetPayCodeLOV(?,?,?,?,?)");

      /*GetLovAction oGetLovAction = new GetLovAction();
      oOutArray = oGetLovAction.GetLov(oLovQueryVO,"N");*/

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
      //oLOVBean=null;
    }
     
    oLovVO.setDetailList(oList);
    //oList=null;
    //oOutArray=null;
    return oLovVO;
  }
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {   
      ArrayList oList = new ArrayList();
      CheckEmpAppsUser(oBaseHeaderBean,oList);
    if(bHeaderDataChanged)
    {
      checkMandatoryHeader(oBaseHeaderBean);
    }
    ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
  
/*
    //added by geetika 19/12/2013 (Start)
    if(oComFinalHeaderBean.getTxtIfGratuityChng().equals("Y"))
    {
        ArrayList oList = new ArrayList();
        checkGratAdjust(oBaseHeaderBean,oList);
        reportError(oList);
         
    }
 //added by geetika 19/12/2013 (End)*/

    if(sScreenMode.equals("N") && !oComFinalHeaderBean.getHdnEmpLbrFlag().equals("E"))
    {
        checkAttenBeforeSepar(oBaseHeaderBean,oList);
        reportError(oList);
         
    }
  /*  if(bDetailDataChanged)
    {
      ComFinalHeaderBean oConvAllowHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
      ArrayList oList=new ArrayList();
      checkMaxPayYear(Long.parseLong(oConvAllowHeaderBean.getTxtSiteID()),"E",oConvAllowHeaderBean.getTxtDate(), oList);
      reportError(oList);
    }*/


    checkEmpClearance(oBaseHeaderBean,sScreenName,bHeaderDataChanged,oList);
    reportError(oList);

  }
    private void CheckEmpAppsUser(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
   
            ArrayList oParameters = new ArrayList(); //Input Parameters
            DBUtilitiesBean oBean = new DBUtilitiesBean();
            
              ArrayList oOutArray = new ArrayList();
            QueryRow oRow = null;
            QueryValue oValue = null;
            ArrayList oRetList = null;
            Iterator oIt = null;    
            ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtEmpNo()))); 
            oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CheckEmpAppsUser(?,?,?)",true,true);
            
            DBObject oOutObject = (DBObject)oOutArray.get(0);    
            String error_msg = (String)oOutObject.getObject();    
            if(error_msg!=null)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(error_msg);
              oList.add(new EnrgiseApplicationException("payroll.Common.EmpAbscondCheck",oArguments));
            }          

    }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  private void checkMandatoryHeader(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
    checkMaxPayYear(oComFinalHeaderBean.getTxtSiteID(),oComFinalHeaderBean.getHdnEmpLbrFlag());
    reportError(oList);
    chkGraCeil(oBaseHeaderBean,oList);
    reportError(oList);
    
  }

  private void chkGraCeil(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      String chkFlag="";
      ComFinalHeaderBean oConvAllowHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowHeaderBean.getTxtGraSancAmt())));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.proc_finalsettleparam_check(?,?,?)",true,true);
    //  oParameters=null;
      chkFlag = (String)((DBObject)oOutArray.get(0)).getObject();
      if(chkFlag!=null &&(!chkFlag.equals("0SUCCESS")))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(chkFlag);
        oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        //oArguments=null;
      }
      //oOutArray=null;
  }  
  public ComFinalSetComboVO getComFinalSetComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ComFinalSetComboVO oComFinalSetComboVO = new ComFinalSetComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oSepTypList = null;
   
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_COMP_FINAL_SETTLE.getSeprationTyp(?,?)");
     // oParameters=null;
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
        oSepTypList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String mouLabel = oRow.get("code_desc").getString();
      String mouValue = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(mouLabel,mouValue);
      oSepTypList.add(oComboVO);
     // oComboVO=null;
      //mouLabel=null;
     // mouValue=null;
    }

    oComFinalSetComboVO.setSepTypList(oSepTypList);
    //oSepTypList=null;
   // oList=null;
    return oComFinalSetComboVO;
  }
  
  private void checkMaxPayYear(long siteId,String hdnEmpLbrFlag,String sDate, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
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

    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
   // oParameters=null;
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      String sRevYear = oRow.get("yymm").getString(); 
      String status = oRow.get("status").getString(); 
      String sYYM=EnrgiseUtil.changeDateFormat("dd-MMM-yyyy","yyyyMM",sDate);
      iRes=EnrgiseUtil.compareDates(new SimpleDateFormat("yyyyMM"),sYYM,sRevYear);
     // sRevYear=null;
    //status=null;
    //sYYM=null;
    }    
      
    if(iRes!=-1)
    {
      ArrayList oArguments = new ArrayList();
      if(hdnEmpLbrFlag.equals("L")||hdnEmpLbrFlag.equals("D"))
      { 
		oList.add(new EnrgiseApplicationException("payroll.common.FinalSetCheckLbr"));
      }
      else
      {
      	oList.add(new EnrgiseApplicationException("Payroll.Status.Leave.Check"));  
      }
    }
      
      
      //oArguments=null;
    
    //oOutArray=null;
    
   // oRetList=null;
  }
  
  private void checkMaxPayYear(long siteId,String hdnEmpLbrFlag,String sDate, ArrayList oList, String prcess) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  String empType=hdnEmpLbrFlag;
  if( prcess.equals("INCT")) 
  { if (hdnEmpLbrFlag.equals("L"))
  {
     empType="I"; 
  }
  else
  {
      empType="A";
  }
      
  }
    
        ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    int iRes=0;
    int status=0;
    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,empType));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      String sRevYear = oRow.get("yymm").getString(); 
       status = Integer.parseInt(oRow.get("status").getString()); 
      String sYYM=EnrgiseUtil.changeDateFormat("dd-MMM-yyyy","yyyyMM",sDate);
      iRes=EnrgiseUtil.compareDates(new SimpleDateFormat("yyyyMM"),sYYM,sRevYear);
     
    }    
      
    if(iRes!=-1)
    {
    if(iRes==0 && status>=4)
    {
    return;
    }
     
      	oList.add(new EnrgiseApplicationException("Payroll.Status.Leave.Check"));  
      
    }
       
    
   
      
     
  } 
  private String checkMaxPayYear(String siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
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
    int status =0;

    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    //oParameters=null;
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = Integer.parseInt(oRow.get("status").getString()); 
    }    
    
   // int iStat=Integer.parseInt(status);
    if( status < 3 && status > 0)
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    //oOutArray=null;
    //oRetList=null;
    
    return "";
  }
  
  
  
/////////////////
/*
 public ArrayList getComfinLoanDtl(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    

    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        ComFinalDetailBean oComFinalDetailBean = (ComFinalDetailBean)oIt.next();
//        System.out.println(oComFinalDetailBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oComFinalDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_COMP_FINAL_SETTLE.proc_InsertComFinalSetDetail(?,?,?,?,?,?)");
            bInsert = true;
          }

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));  
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oComFinalDetailBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_COMP_FINAL_SETTLE.getITOutstdFinalSettle(?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtSerialNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtPayCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtAmt())));   
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oComFinalDetailBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!oComFinalDetailBean.getTxtSerialNo().equals(""))
          {
            if(!bDelete)
            {
              oBeanDelete = new DBUtilitiesBean();
              oBeanDelete.createBatch("PKG_COMP_FINAL_SETTLE.proc_DeleteComFinalSetDetail(?,?)");
              bDelete = true;
            }         
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalDetailBean.getTxtSerialNo())));   
            oBeanDelete.addToBatch(oParameters);
          }
        }
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
  
////////////////

*/

 public String computeITDetails(ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
 // public String computeITDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    //ArrayList oParameters = new ArrayList(); //Input Parameters
    //DBUtilitiesBean oBean = new DBUtilitiesBean();
   // ArrayList oList; 
  
    String errorMsg="";

    ArrayList oOutArray = null; //Output 
    ArrayList oList=new ArrayList();
  
    reportError(oList);
 // if(procs.equals("IT"))
  {
  /*    oParameters = new ArrayList();   
   /*   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalSetQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetQueryVO.getUserId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetQueryVO.getSiteId())));  
     
     
   //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oComFinalSetQueryVO.getTxtEmpNo()));
    //  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getUserId())));
    //  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT, new Long(oComFinalSetQueryVO.getLoginLocCode())));
    //  oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
    //  oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oComFinalSetDetailInfo.getTxtEmpNo()));
    //  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalSetDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getUserId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oComFinalSetDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
   //   oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_CALCULATE_TAX_ACTUALS_FCI.getITOutstdFinalSettle(?,?,?,?,?)",true,true);    
/*      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
   //  Integer errCode = (Integer)((DBObject)oOutArray.get(2)).getObject();
 /*   
   if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println("Error!!! while Adjusting deductions ::"+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
  */    
 /* }
    return errorMsg;
  }
*/
 /*       oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {   
       //   throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
       return new ArrayList();
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oComFinalDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oComFinalDetailBean = new ComFinalDetailBean();
          oComFinalDetailBean.setTxtTransMastId((oRow.get("id").getString()));
          oComFinalDetailBean.setTxtAmt((oRow.get("balamt").getString()));
          oComFinalDetailBean.setTxtOutAmt((oRow.get("balamt").getString()));
          oComFinalDetailBean.setTxtDesc((oRow.get("paycodedesc").getString())); 
          oComFinalDetailBean.setTxtPayCode((oRow.get("paycode").getString())); 
          oComFinalDetailBean.setStatus("N");
          oComFinalDetailBean.setTxtRecFlag("Y");
                  
          oComFinalDetail.add(oComFinalDetailBean);
        }  
       return oComFinalDetail;
  }
*/  
}
return null;
  }
  
  
  
  
  ///////////////////
  
  public String getTdyDate() {
String s;
Date date = new Date();
String DATE_FORMAT = "dd-MMM-yyyy";
SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//System.out.println("Today is " + sdf.format(date));
s = sdf.format(date);
DATE_FORMAT=null;
sdf=null;
return s;
}


 private void checkAttenBeforeSepar(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      String chkFlag="";
      ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtEmpNo())));
         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtDate())));
         oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getHdnEmpLbrFlag())));
         oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
         oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour_ext.proc_check_atten_before_separ(?,?,?,?,?,?)",true,true);
    //  oParameters=null;
      chkFlag = (String)((DBObject)oOutArray.get(0)).getObject();
      if(chkFlag!=null &&(!chkFlag.equals("0SUCCESS")))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(chkFlag);
        oList.add(new EnrgiseApplicationException("Payroll.Separation.AttenCheck",oArguments));
        //oArguments=null;
      }
      //oOutArray=null;
  }

/*  
//added by geetika 19/12/2013
private void checkGratAdjust(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      String chkFlag="";
      ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour_ext.proc_check_grat_adjust(?,?,?,?)",true,true);
    //  oParameters=null;
      chkFlag = (String)((DBObject)oOutArray.get(0)).getObject();
      if(chkFlag!=null &&(!chkFlag.equals("0SUCCESS")))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(chkFlag);
        oList.add(new EnrgiseApplicationException("Payroll.Separation.AttenCheck",oArguments));
        //oArguments=null;
      }
      //oOutArray=null;
  }
 
 
  
  ////////////////////
*/
 
   //added by geetika on 7/04/2014 to check for clearance of invoices before transfering
  private void checkEmpClearance(BaseHeaderBean oBaseHeaderBean, String sScreenName, boolean bHeaderDataChanged,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    //if(sScreenName.equals("TransferScreen"))
    //{
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        Integer chkFlag=new Integer(0);
        ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_op_invoice_pending.PROC_EMP_CLEARANCE_CHECK(?,?,?)",true,true);
        oParameters = null;
        oComFinalHeaderBean = null;
        chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
        if(chkFlag.equals(new Integer(1)))
        {        
           DBObject oMsgObject = (DBObject)oOutArray.get(0);    
           String error_msg = (String)oMsgObject.getObject();
           ArrayList oArguments = new ArrayList();
           oArguments.add(new String(error_msg));            
           oList.add(new EnrgiseApplicationException("Pay.Payroll.Emp_Clearance.Error",oArguments));
        }
    //}
  }


 public String deleteComFinalEntry(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        System.out.println("inside business obnject");
    ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
    ArrayList oParameters = new ArrayList(); //Input Parameters
     ArrayList oOutArray;
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      System.out.println(oComFinalHeaderBean.getTxtEmpNo());
    System.out.println(oComFinalHeaderBean.getTxtEmpType());
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
          //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpLbr())));
         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));  
           oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_comp_final_settle.proc_delsepentry(?,?,?,?,?)",true,true);
   
     
           DBObject oOutObject = (DBObject)oOutArray.get(0);
      String errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
     
      
        // ArrayList oArguments = new ArrayList();
        // oArguments.add(new String(errorMsg));
        // System.out.println("Error!!! while deleting::"+errorMsg);
        // throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        return errorMsg;
         
    
          
          
          
//end 
 
}

 
public String deleteSepDtls(BaseHeaderBean oBaseHeaderBean,String buttonType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        System.out.println("inside business obnject of deleting gratuity etc");
    ComFinalHeaderBean oComFinalHeaderBean = (ComFinalHeaderBean)oBaseHeaderBean;
    ArrayList oParameters = new ArrayList(); //Input Parameters
     ArrayList oOutArray;
      DBUtilitiesBean oBean = new DBUtilitiesBean();

            System.out.println("Button is" + buttonType);
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oComFinalHeaderBean.getTxtEmpNo())));
         
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComFinalHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,buttonType));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_comp_final_settle.proc_updatedednstldtls(?,?,?,?,?,?)",true,true);
         DBObject oOutObject = (DBObject)oOutArray.get(0);
         String errorMsg = (String)oOutObject.getObject();
         Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      
      
        return errorMsg;
         
    
          

 
}

}