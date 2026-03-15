package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSInfoComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSInfoQueryVO;
import FCIPAY.Payroll.Labour.Utility.DPSInfoHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class DPSInfoBusinessObject extends BaseBO 
{

  public DPSInfoBusinessObject()
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sTabNum; 
    String sPayModeType;
    int count = 0;
    DPSInfoHeaderBean oEmpFinInfoHeaderBean = (DPSInfoHeaderBean)oBaseHeaderBean;
    String sFpsNo = oEmpFinInfoHeaderBean.getTxtFpsNo();
    String zonalFpsNo = sFpsNo ; // Added by dushyant on 23-MAy-2013  
    
  /*  -- Commented by dushyant on 23-MAy-2013   
    if(sFpsNo!=null && sFpsNo.length()>0) 
    {
        zonalFpsNo = getZonalFPS(oEmpFinInfoHeaderBean.getHeaderPrimaryKey(), oEmpFinInfoHeaderBean.getParentZone(), sFpsNo, "EMPCTGRY$DPSL");
    }
  */  // Commented by dushyant on 23-MAy-2013  
  
    ArrayList oOutArray; //Output 
    ArrayList oAddOutArray; //Output 

      oParameters = new ArrayList();     
      oAddressParam = new ArrayList();     
      /* Employee Header Info */
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGender())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOB())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDojFCI())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPresentPOP())));  
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpStatus())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDsgnDesc())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayStatus())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPayStsChnDate()))); 
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurMGW())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandi()))); 
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMarStat())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayMode()))); 
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnIRFlag())));     
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtRetireDate()))); 
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCpfCode())));  
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHandiEffDate()))); 
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFatherNam())));
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHomTwn()))); 
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(zonalFpsNo))); //added by swapnendu Dt 05 Oct 2011
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOJSite())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnBFFlag())));
      if (oEmpFinInfoHeaderBean.getHdnSocRecFlag().equals("Y"))
      {
        oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnSocRecFlag())));
        oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSocRecAmt())));        
      }
      else
      {
        oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnSocRecFlag())));
        oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String("")));        
      } 
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getParentZone()))); 
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getPrefix())));  
      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCateg()))); 
      
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEpsFlag())));    
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsEntDt())));       
      oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String("")));  
      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsSepDt())));

      oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));        
      oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpFirstName())));    
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpLastName())));    
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpMiddleName())));    
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(37,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPanNo())));
      oParameters.add(new DBObject(38,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCasteCateg())));
        oParameters.add(new DBObject(39,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandiType())));
        oParameters.add(new DBObject(40,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtReligion())));
        oParameters.add(new DBObject(41,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtExsrvcman())));
        oParameters.add(new DBObject(42,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAadharNum())));
        oParameters.add(new DBObject(43,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUanNum())));
         oParameters.add(new DBObject(44,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFathHusflag())));
      oParameters.add(new DBObject(45,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtCPFIntEndDt())));
      oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMemberId())));
      oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPohwFlag())));

      oParameters.add(new DBObject(48,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(49,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_UpdateDpsLbrFinDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);   
      
      // Employee Address Info                  
      /*oAddressParam.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
      //oAddressParam.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAddType())));
      oAddressParam.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPermAddL1())));
      oAddressParam.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPermAddL2())));
      oAddressParam.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPermPin())));
      oAddressParam.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPermCity())));
      oAddressParam.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPermState())));
      oAddressParam.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPermCountry())));      
      oAddressParam.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTempAddL1())));
      oAddressParam.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTempAddL2())));
      oAddressParam.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTempPin())));
      oAddressParam.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTempCity())));
      oAddressParam.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTempState())));
      oAddressParam.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtTempCountry())));      
      
      oAddressParam.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
      oAddressParam.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));     
      oAddressParam.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));
      oAddOutArray = oBean.callProc(oAddressParam,"PAYROLL_PKG.proc_CheckEmpAddrDtl_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  */ 
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_msg = (String)oOutObject.getObject();
      DBObject oErrObject = (DBObject)oOutArray.get(1);    
      Integer errorCode = (Integer)oErrObject.getObject();
      if(!(errorCode.equals(new Integer(0))))
      {        
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(error_msg));
         System.out.println("Error!!! while Updating Employee ::"+error_msg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }

  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    //ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    DPSInfoHeaderBean oEmpFinInfoHeaderBean = (DPSInfoHeaderBean)oBaseHeaderBean;
    String sFpsNo = oEmpFinInfoHeaderBean.getTxtFpsNo();
    String zonalFpsNo = sFpsNo;
  /*  // commented by dushyant on 23-May-2013
    if(sFpsNo!=null && sFpsNo.length()>0) 
    {
        zonalFpsNo = getZonalFPS(oEmpFinInfoHeaderBean.getHeaderPrimaryKey(), oEmpFinInfoHeaderBean.getParentZone(), sFpsNo, "EMPCTGRY$DPSL");
    }
 */
    ArrayList oOutArray; //Output  
       
      oParameters = new ArrayList();      
      /* Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpFirstName())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpMiddleName())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpLastName())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGender())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOB())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDojFCI())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPresentPOP())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpStatus()))); 
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtStaffCode())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDsgnDesc())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayStatus())));          
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPayStsChnDate())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurMGW())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandi())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMarStat())));
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnIRFlag())));   
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtRetireDate())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPFType()))); 
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCpfCode())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHandiEffDate())));
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFatherNam()))); 
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHomTwn())));
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(zonalFpsNo)));   //added by swapnendu Dt 05 Oct 2011
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOJSite())));
      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnBFFlag()))); 
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnSocRecFlag()))); 
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSocRecAmt())));
      oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getParentZone()))); 
      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getPrefix())));       
      oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCateg())));
          
      oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEpsFlag())));    
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsEntDt())));            
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsSepDt())));
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String("")));        
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(37,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(38,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPanNo())));   // added by dushaynt on 20-dec-2011
      
      oParameters.add(new DBObject(39,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCasteCateg())));
        oParameters.add(new DBObject(40,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandiType())));
        oParameters.add(new DBObject(41,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtReligion())));
        oParameters.add(new DBObject(42,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtExsrvcman())));
        oParameters.add(new DBObject(43,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAadharNum())));
        oParameters.add(new DBObject(44,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUanNum())));
        oParameters.add(new DBObject(45,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFathHusflag())));
      oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMemberId())));
      oParameters.add(new DBObject(48,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(49,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(50,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_InsertDpsLbrFinDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String sEmpNo = (String)oOutObject.getObject();
      DBObject oMsgObject = (DBObject)oOutArray.get(1);    
      String error_msg = (String)oMsgObject.getObject();
      DBObject oErrObject = (DBObject)oOutArray.get(2);    
      Integer errorCode = (Integer)oErrObject.getObject();
      if(!(errorCode.equals(new Integer(0))))
      {        
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(error_msg));
         System.out.println("Error!!! while Adjusting deductions ::"+error_msg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }      

      return (String)oOutObject.getObject(); 
      
  }
  private String getZonalFPS(String empno, String parentZone, String fpsNo, String ctgry) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empno)));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(parentZone)));    
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(fpsNo)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(ctgry)));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetZonalFpsNo(?,?,?,?,?,?,?)",true,true);

    DBObject oOutObject = (DBObject)oOutArray.get(0);
    String pFpsNo  = (String)(oOutObject.getObject());
    
    oOutObject = (DBObject)oOutArray.get(1);
    String errMsg = (String)(oOutObject.getObject());

    oOutObject = (DBObject)oOutArray.get(2);
    Integer errCode = (Integer)(oOutObject.getObject());

    ArrayList oList = new ArrayList();
    if (errCode.intValue() != 0)
    {
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(errMsg));
        oList.add(new EnrgiseApplicationException("Payroll.EmpSixPay.UpdateCheck",oArguments));
    }
    reportError(oList);
    return pFpsNo;
  }   

  public RecordMetaInfo getDPSInfoHeaderMetaInfo(DPSInfoQueryVO oEmpFinanceQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oEmpFinanceQueryVO.getLoginLocCode()+"";

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpFirstName())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpLastName())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtDsgnDesc())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpStatus())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtStaffCode())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getParentZone())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCpfCode()))); 
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER));    
    oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetDpsLbrFinCount(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getDPSInfoHeader(DPSInfoQueryVO oEmpFinanceQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sSiteId = oEmpFinanceQueryVO.getTxtEmpLastName()+"";
    int count = 0;

    if(oEmpFinanceQueryVO == null)
    {
      oEmpFinanceQueryVO = new DPSInfoQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String locCode = oEmpFinanceQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpFirstName())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpLastName())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtDsgnDesc())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpStatus())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtStaffCode())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getParentZone()))); 
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCpfCode()))); 
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetDpsLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    DPSInfoHeaderBean oEmpFinInfoHeaderBean;
    count = 0;
    QueryRow oRow = null;
    HashMap oColumns = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oHeaderList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oEmpFinInfoHeaderBean = new DPSInfoHeaderBean();

        oEmpFinInfoHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpFinInfoHeaderBean.setTxtStaffCode(oRow.get("STAFF_CODE").getString());
        oEmpFinInfoHeaderBean.setParentZone(oRow.get("PARENT_ZONE").getString());
        oEmpFinInfoHeaderBean.setTxtEmpFirstName(oRow.get("EMP_FIRST_NAME").getString());        
        oEmpFinInfoHeaderBean.setTxtEmpMiddleName(oRow.get("EMP_MIDDLE_NAME").getString());        
        oEmpFinInfoHeaderBean.setTxtEmpLastName(oRow.get("EMP_LAST_NAME").getString());  
        oEmpFinInfoHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());   
        oEmpFinInfoHeaderBean.setTxtDsgnDesc(oRow.get("DESIGNATION_ID").getString());         
        oEmpFinInfoHeaderBean.setTxtPFType(oRow.get("EMP_PF_TYPE").getString());
        oEmpFinInfoHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpFinInfoHeaderBean.setTxtFpsNo(oRow.get("FPS_NUM").getString());           
        oEmpFinInfoHeaderBean.setTxtDojFCI(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("COMP_JOINING_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtPresentPOPDesc(oRow.get("LOC_DESC").getString());        
        oEmpFinInfoHeaderBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
        oEmpFinInfoHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString());      
        oEmpFinInfoHeaderBean.setPrefix(oRow.get("PREFIX").getString());    
        
        oEmpFinInfoHeaderBean.setTxtCurMGW(oRow.get("MGW").getString());                
        oEmpFinInfoHeaderBean.setTxtPayStatus(oRow.get("PAY_STATUS").getString());         
        oEmpFinInfoHeaderBean.setTxtPayMode(oRow.get("PAY_MODE").getString());          
        oEmpFinInfoHeaderBean.setTxtPayStsChnDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate()));       
        
        oEmpFinInfoHeaderBean.setTxtDOB(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("EMP_BIRTH_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtGender(oRow.get("EMP_SEX_CODE").getString());                  
        oEmpFinInfoHeaderBean.setTxtMarStat(oRow.get("MARITAL_STATUS").getString());          
        oEmpFinInfoHeaderBean.setTxtFatherNam(oRow.get("FATHER_NAME").getString());  
        oEmpFinInfoHeaderBean.setTxtHomTwn(oRow.get("HOMETOWN").getString());          
        oEmpFinInfoHeaderBean.setTxtHandi(oRow.get("HANDICAPPED_FLAG").getString()); 
        oEmpFinInfoHeaderBean.setTxtHandiEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("HANDICAPPED_EFF_DATE").getDate()));        
        oEmpFinInfoHeaderBean.setTxtRetireDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("RETIREMENT_DATE").getDate()));                        
        
      /*  if(oRow.get("EPS_FLAG").getString().equalsIgnoreCase("Y") || oRow.get("EPS_FLAG").getString().equalsIgnoreCase("P"))
          oEmpFinInfoHeaderBean.setTxtEpsFlag("Y");
        else
          oEmpFinInfoHeaderBean.setTxtEpsFlag("N");*/
        oEmpFinInfoHeaderBean.setTxtEpsFlag(oRow.get("EPS_FLAG").getString());
        oEmpFinInfoHeaderBean.setTxtEpsEntDt(EnrgiseUtil.convertToString(oRow.get("EPS_ENTLMNT_DT").getDate()));
        oEmpFinInfoHeaderBean.setTxtEpsSepDt(EnrgiseUtil.convertToString(oRow.get("EPS_SEP_DT").getDate()));
        oEmpFinInfoHeaderBean.setTxtEpsSepRsn(oRow.get("EPS_SEP_REASON").getString()); 
        oEmpFinInfoHeaderBean.setTxtPanNo(oRow.get("EMP_PAN_NO").getString());     // Added by dushaynt on 20-dec-2011
        oEmpFinInfoHeaderBean.setTxtCPFIntEndDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("interest_end_date").getDate()));

        
        /* Employee Address Tab Fields
        oEmpFinInfoHeaderBean.setTxtAddId(oRow.get("ADDRESS_ID").getString());  
        oEmpFinInfoHeaderBean.setTxtPermAddL1(oRow.get("PERM_ADD_L1").getString());
        oEmpFinInfoHeaderBean.setTxtPermAddL2(oRow.get("PERM_ADD_L2").getString());
        oEmpFinInfoHeaderBean.setTxtPermPin(oRow.get("PERM_PIN").getString());
        oEmpFinInfoHeaderBean.setTxtPermCity(oRow.get("PERM_CITY").getString());          
        oEmpFinInfoHeaderBean.setTxtPermState(oRow.get("PERM_STATE").getString());                 
        oEmpFinInfoHeaderBean.setTxtPermCountry(oRow.get("PERM_COUNTRY").getString());                    
        oEmpFinInfoHeaderBean.setTxtTempAddL1(oRow.get("PRES_ADD_L1").getString());
        oEmpFinInfoHeaderBean.setTxtTempAddL2(oRow.get("PRES_ADD_L2").getString());          
        oEmpFinInfoHeaderBean.setTxtTempPin(oRow.get("PRES_PIN").getString());          
        oEmpFinInfoHeaderBean.setTxtTempCity(oRow.get("PRES_CITY").getString());
        oEmpFinInfoHeaderBean.setTxtTempState(oRow.get("PRES_STATE").getString());    
        oEmpFinInfoHeaderBean.setTxtTempCountry(oRow.get("PRES_COUNTRY").getString());   */       
        
        oEmpFinInfoHeaderBean.setHdnIRFlag("");
        oEmpFinInfoHeaderBean.setHdnBFFlag("");
        oEmpFinInfoHeaderBean.setHdnSocRecFlag("");
        oEmpFinInfoHeaderBean.setTxtSocRecAmt(""); 
          oEmpFinInfoHeaderBean.setTxtBankAccNo(oRow.get("BANK_AC_NO").getString());  //Added by Swarnika in ref to issue 75040
          oEmpFinInfoHeaderBean.setTxtBranchDesc(oRow.get("BRANCH_CODE").getString());
          oEmpFinInfoHeaderBean.setTxtBankDesc(oRow.get("BANK_CODE").getString());
        oEmpFinInfoHeaderBean.setTxtCateg(oRow.get("emp_category").getString());          
        oEmpFinInfoHeaderBean.setTxtGangId(oRow.get("gang_id").getString());       //added by swapnendu Dt 21 May 2012   
        oEmpFinInfoHeaderBean.setTxtGangName(oRow.get("gang_name").getString());     //added by swapnendu Dt 21 May 2012 
        oEmpFinInfoHeaderBean.setTxtOldCpfCode(oRow.get("OLD_CPF_CODE").getString());     //added by dushyant Dt 18 May 2013
      oEmpFinInfoHeaderBean.setTxtCasteCateg(oRow.get("CASTE_CATEGORY").getString()); 
        oEmpFinInfoHeaderBean.setTxtHandiType(oRow.get("HANDICAPPED_TYPE").getString()); 
        oEmpFinInfoHeaderBean.setTxtReligion(oRow.get("RELIGION").getString()); 
        oEmpFinInfoHeaderBean.setTxtExsrvcman(oRow.get("EX_SERVICEMEN").getString()); 
        oEmpFinInfoHeaderBean.setTxtAadharNum(oRow.get("AADHAR_NUM").getString()); 
        oEmpFinInfoHeaderBean.setTxtUanNum(oRow.get("UAN").getString()); 
        oEmpFinInfoHeaderBean.setTxtFathHusflag(oRow.get("fath_hus_flag").getString());
          oEmpFinInfoHeaderBean.setTxtMemberId(oRow.get("member_id").getString());
          oEmpFinInfoHeaderBean.setTxtPohwFlag(oRow.get("pohw_flag").getString());
          oEmpFinInfoHeaderBean.setTxtPohwEffDt(EnrgiseUtil.convertToString(oRow.get("pohw_eff_date").getDate()));

        oHeaderList.add(oEmpFinInfoHeaderBean);
      }    
      
    return oHeaderList;
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("DaRatesScreen"))
    {
      saveDARates(sHeaderPrimaryKey,oDetailBeanArray);
    }    
  }  
  
  private ArrayList getDPSComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList();
    ArrayList oOutArray;
    //EmpFinanceComboVO oEmpFin=null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    QueryRow oRow = null;    
    int count = 0;
    
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,sProc);
    
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
        throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
        
    count = 0;
    oIt = oList.iterator();
    ArrayList oValueList = null;
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oValueList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();        
        String fieldId = ((oRow.get(sField_id).getString()));
        String fieldDesc= ((oRow.get(sField_desc).getString()));
        ComboVO oComboVO = new ComboVO(fieldDesc,fieldId);
        oValueList.add(oComboVO);    
    }
    return oValueList;
  }     

  public DPSInfoComboVO getDPSInfoComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oConvAllowCity = null;    
    DPSInfoComboVO oEmpFin=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
        
    oEmpFin = new DPSInfoComboVO();  
    
    ArrayList oEmpStatList = new ArrayList();
    oEmpStatList = getDPSComboRecords("PKG_PAY_LABOUR.proc_GetDeptLbrStatus(?,?)","deptLbrstatus_id","DeptLbrstatus_desc");
    oEmpFin.setValueEmpStatArrayList(oEmpStatList);
    
    ArrayList oEmpStatAllList = new ArrayList();
    oEmpStatAllList = getDPSComboRecords("PAYROLL_PKG_EXT.proc_GetEmpStatusLOV(?,?)","gbl_code","code_desc");
    oEmpFin.setValueEmpStatAllArrayList(oEmpStatAllList);
       
    ArrayList oParentZoneList = new ArrayList();
    oParentZoneList = getDPSComboRecords("pkg_pay_labour.proc_GetLbrParentZone(?,?)","loc_id","loc_desc");
    oEmpFin.setValueParentZoneArrayList(oParentZoneList);

    ArrayList oEpsSepTypeList = new ArrayList();
    oEpsSepTypeList = getDPSComboRecords("PAYROLL_PKG_EXT.getEPSSepType(?,?)","code_sdesc","code_desc");
    oEmpFin.setEpsSepTypList(oEpsSepTypeList);
   
    ArrayList oCasteCategList = new ArrayList();
    oCasteCategList = getDPSComboRecords("PAYROLL_PKG_EXT.proc_getcastecateg(?,?)","code_sdesc","code_desc");
    oEmpFin.setValueCasteCategList(oCasteCategList);   
      
    ArrayList oHandiTypeList = new ArrayList();
    oHandiTypeList = getDPSComboRecords("PAYROLL_PKG_EXT.proc_gethanditype(?,?)","code_sdesc","code_desc");
    oEmpFin.setValueHandiTypeList(oHandiTypeList);
    
    ArrayList oReligionList = new ArrayList();
    oReligionList = getDPSComboRecords("PAYROLL_PKG_EXT.proc_getreligion(?,?)","code_sdesc","code_desc");
    oEmpFin.setValueReligionList(oReligionList);
    
    return oEmpFin;
  }
  
  public LovVO getDPSLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));    
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinLOV_new(?,?,?,?)");
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
     oLOVBean.setDetailField2(oRow.get("EMP_FIRST_NAME").getString());            
     oLOVBean.setDetailField2(oRow.get("EMP_MIDDLE_NAME").getString());            
     oLOVBean.setDetailField2(oRow.get("EMP_LAST_NAME").getString());            
                  
     oList.add(oLOVBean);
    }
    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

   public LovVO getEmpLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Site Id");        
    arylstHeaderNames.add("Site Name");  
    arylstHeaderNames.add("City Type");    
    arylstHeaderNames.add("Area Type");
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetLbrLocDetail(?,?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("city_type_gbl").getString());            
       oLOVBean.setDetailField4(oRow.get("area_type_gbl").getString());            
      oList.add(oLOVBean);
    }     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public LovVO getQueryDPSLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("First Name");    
    arylstHeaderNames.add("Last Name");    
    arylstHeaderNames.add("CPF Code");      // added by dushyant on 15-11-2010
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String("D")));   // added by dushyant on 15-11-2010
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField4())));  // added by dushyant on 15-11-2010
  //  oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String("D")));       commented by dushyant on 15-11-2010    
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));    
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
  //  oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpFinLOV_new(?,?,?,?,?,?,?)");   //commented by dushyant on 15-11-2010  
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpFinLOV_new(?,?,?,?,?,?,?,?)");
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
      
        oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
        oLOVBean.setDetailField2(oRow.get("EMP_FIRST_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("EMP_LAST_NAME").getString());            
        oLOVBean.setDetailField4(oRow.get("CPF_CODE").getString());        // added by dushyant on 15-11-2010       
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  private void saveDARates(String sPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
  }
  
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bHeaderDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,sScreenMode);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oList = new ArrayList();
    
      //added by nand on 22-may-2013
      DPSInfoHeaderBean oDPSInfoHeaderBean =(DPSInfoHeaderBean)oBaseHeaderBean;
      checkMaxPayYear(oDPSInfoHeaderBean.getTxtSiteID(),oDPSInfoHeaderBean.getHdnEmpLbrFlag());
      reportError(oList);
//    checkFirst(oBaseHeaderBean,oList);
      checkEmpNo(oBaseHeaderBean,oList); 
      if(sScreenName.equals(EnrgiseConstants.NEW_MODE))
      {      
          //checkEmpCurBasicLimit(oBaseHeaderBean,oList);                    
      }
      
    reportError(oList);        
  }  

  private void checkEmpNo(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Integer chkFlag = null;
    Iterator oIt = null;
    DPSInfoHeaderBean oEmpFinInfoHeaderBean = (DPSInfoHeaderBean)oBaseHeaderBean;    
    oParameters = new ArrayList();
    String empNo = oEmpFinInfoHeaderBean.getHeaderPrimaryKey(); 
    String cpfCode=oEmpFinInfoHeaderBean.getTxtCpfCode();
    String fpsNo=oEmpFinInfoHeaderBean.getTxtFpsNo();
    String panNo=oEmpFinInfoHeaderBean.getTxtPanNo();
    String birthDate =oEmpFinInfoHeaderBean.getTxtDOB();
    String aadharNo =oEmpFinInfoHeaderBean.getTxtAadharNum();
    String uan=oEmpFinInfoHeaderBean.getTxtUanNum();
     String retDate=oEmpFinInfoHeaderBean.getTxtRetireDate();
   
    
    if(fpsNo!=null && !fpsNo.equals(""))  // FPS number aadded by dushaynt on 23-may-2013
    {
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnEmpLbrFlag()))); //added by swapnendu Dt 06 Mar 2011  
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,cpfCode)); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,fpsNo)); 
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getParentZone()))); 
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayStatus())));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
   // oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_EmpDuplicateCheck(?,?,?,?,?)"); 
    oOutArray = oBean.callProc(oParameters,"apps.FCI_PKG_CR_161.proc_empduplicatecheck(?,?,?,?,?,?,?,?)",true,true);
      
      chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
      String error_msg=(String)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
      } 
    }
    
/*  -- Commented by dushyant on 23-MAy-2013 
    if(fpsNo!=null && !fpsNo.equals(""))
    {
      String zonalFpsNo = getZonalFPS(empNo, oEmpFinInfoHeaderBean.getParentZone(), fpsNo, "EMPCTGRY$DPSL");
    
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,fpsNo)); //commented by swapnendu Dt 05 Oct 2011
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,zonalFpsNo)); //Added by swapnendu Dt 05 Oct 2011
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_EmpFpsDuplicateCheck(?,?,?,?)"); //commented by swapnendu Dt 14 Jun 2011
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_EmpFpsDuplicateCheck1(?,?,?,?,?)"); //added by swapnendu Dt 14 Jun 2011
        
      DBObject oOutObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oOutObject.getObject();    
      if(error_msg!=null)
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.fpsDuplicatecheck1",oArguments));
      }
    }  
 */ 
    if(panNo!=null && !panNo.equals(""))
    {
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,panNo));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_EmpPanDuplicateCheck(?,?,?,?)");
      DBObject oOutObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oOutObject.getObject();    
      if(error_msg!=null)
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.fpsDuplicatecheck1",oArguments));
      }
    }
    
    //Added by Ankur on 28-Nov-2013
    if(birthDate!=null && !birthDate.equals(""))
    {
    
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo)); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,birthDate));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
       
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_BirthDayCheckRetired(?,?,?,?)",true,true);

      chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
      String error_msg=(String)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.birthDateCheckRetired",oArguments));
      } 
        
    }  // addition by Ankur ends
     if(aadharNo!=null && !aadharNo.equals(""))
    {
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,aadharNo));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_empAadharDuplChk(?,?,?,?)",true,true);
      DBObject oOutObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oOutObject.getObject();    
      if(error_msg!=null)
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.aadharDuplicatecheck",oArguments));
      }
    } 
    
    if(uan!=null && !uan.equals(""))
    {
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,uan));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_empUanDuplChk(?,?,?,?)",true,true);
      DBObject oOutObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oOutObject.getObject();    
      if(error_msg!=null)
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.uanDuplicatecheck",oArguments));
      }
    } 
   
    if(retDate!=null && !retDate.equals(""))
    {
    
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo)); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,retDate));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));

      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
       
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_retDayCheck(?,?,?,?,?)",true,true);

      chkFlag = (Integer)((DBObject)oOutArray.get(2)).getObject();
      String error_msg=(String)((DBObject)oOutArray.get(1)).getObject();
      String rdate=(String)(((DBObject)oOutArray.get(0)).getObject());
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.birthDateCheckRetired",oArguments));
      } 
      else
      {
        oEmpFinInfoHeaderBean.setTxtRetireDate(rdate);
      }
        
    }
    
  }

  public LovVO getDPSInfoDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");       
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
  
    oLovVO.setVisibilityList(arylstVisibility);     
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;  
    Integer empNo = new Integer(0);
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String("D")));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));  //added by nitin on 13-03-2013
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,empNo));  //added by nitin on 13-03-2013
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetLbrDsgnLov(?,?,?,?,?)");
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
        oLOVBean.setDetailField1(oRow.get("dsgn_id").getString());   
        oLOVBean.setDetailField2(oRow.get("dsgn_desc").getString());
        oLOVBean.setDetailField3(oRow.get("ctgry").getString());
        oLOVBean.setDetailField4(oRow.get("ctgry_desc").getString());        
       
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
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
      status = oRow.get("arc_flag").getString(); 
    }    
    
    // int iStat=Integer.parseInt(status);
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    
    return "";
  }
}