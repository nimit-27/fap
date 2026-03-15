package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DeptLabourComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DeptLabourQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.Labour.Utility.DeptLabourInfoHeaderBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
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


public class DeptLabourBusinessObject extends BaseBO 
{

  public DeptLabourBusinessObject()
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
    DeptLabourInfoHeaderBean oDeptLabourInfoHeaderBean = (DeptLabourInfoHeaderBean)oBaseHeaderBean;
    // added by devendra on 30 sept 2010 start
    String screenNameForSuper="";
     screenNameForSuper = oDeptLabourInfoHeaderBean.getScreenNameForSuper(); 
    String payRevFlag = oDeptLabourInfoHeaderBean.getPayRevFlag();
   // String payRevFlagForUpdate="";
    //if(payRevFlag!=null && payRevFlag.equalsIgnoreCase("6"))
    //{
    //    payRevFlagForUpdate="Y";
    //}
    // added by devendra on 30 sept 2010 end
    ArrayList oOutArray; //Output 
    ArrayList oAddOutArray; //Output 
    if ((oDeptLabourInfoHeaderBean.getTxtPayModeType() == null) || (oDeptLabourInfoHeaderBean.getTxtPayMode().equals("B")) || (oDeptLabourInfoHeaderBean.getTxtPayMode().equals("C"))) 
      sPayModeType = " "; 
    else
      sPayModeType = oDeptLabourInfoHeaderBean.getTxtPayModeType();
    
    String sCantFlag;
    if (oDeptLabourInfoHeaderBean.getHdnCantFlag().equals("Y"))
      sCantFlag = "Y" ;
    else 
      sCantFlag = "N";
    
    String sHdnWashFlag;
    if (oDeptLabourInfoHeaderBean.getHdnWashFlag().equals("Y"))
      sHdnWashFlag = "Y";
    else
      sHdnWashFlag = "N";            
       
    String sCCAFlag;
    if (oDeptLabourInfoHeaderBean.getHdnCCAFlag().equals("Y"))
      sCCAFlag = "Y";
    else
      sCCAFlag ="N";  
      
    String sHdnPLIFlag;
    if (oDeptLabourInfoHeaderBean.getHdnPLIFlag().equals("Y"))
      sHdnPLIFlag = "Y";
    else
      sHdnPLIFlag ="N";
    
    String sConvFlag;
    if (oDeptLabourInfoHeaderBean.getHdnConvFlag().equals("Y"))
      sConvFlag = "Y";
    else
      sConvFlag ="N"; 
      
    String sHdnStationCompFlag;
    if (oDeptLabourInfoHeaderBean.getHdnStationCompFlag().equals("Y"))
      sHdnStationCompFlag = "Y";
    else
      sHdnStationCompFlag ="N"; 
      
    String sFpsNo = oDeptLabourInfoHeaderBean.getTxtFpsNo();
    String zonalFpsNo = sFpsNo;  // Added by dushyant on 23-may-2013
  /*  commented by dushyant on 23-may-2013  
    if(sFpsNo!=null && sFpsNo.length()>0) 
    {
        zonalFpsNo = getZonalFPS(oDeptLabourInfoHeaderBean.getTxtEmpNo(), oDeptLabourInfoHeaderBean.getParentZone(), sFpsNo, "EMPCTGRY$DPTL");
    }
  */  
    String sHdnSplCmpAllowFlag;
    String sHdnPersPaySFNFlag;
    
      oParameters = new ArrayList();     
      oAddressParam = new ArrayList();     
      /* Employee Header Info */
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtDsgnDesc())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPFType())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCpfCode())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(zonalFpsNo)));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtDojFCI())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPresentPOP())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtDOJSite())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpStatus())));
      
      /* Employee Payroll Info*/      
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayType())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayScaleCode())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCurtBasic())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayStatus())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(sPayModeType)));   
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtBranchCode())));      
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtBankAccNo())));            
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPayStsChnDate())));            
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtInrSt())));      
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtStagInc())));      
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtStagEffDate())));      
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPanNo())));      
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCityTypeHra())));                              
      
      // Employee Hr Flag Info      
      
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(sCantFlag))); 
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnWashFlag)));       
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnStationCompFlag)));       
      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(sCCAFlag)));      
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPLIFlag)));      
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(sConvFlag)));      
      
      if (oDeptLabourInfoHeaderBean.getHdnSplCmpAllowFlag().equals("Y"))
      {
        sHdnSplCmpAllowFlag = "Y";
        oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplCmpAllowFlag)));
        oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSplCmpAllowAmt())));
      }
      else
      {
        sHdnSplCmpAllowFlag ="N";        
        oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplCmpAllowFlag)));
        oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }
      
      if (oDeptLabourInfoHeaderBean.getHdnPersPaySFNFlag().equals("Y"))
      {
        sHdnPersPaySFNFlag = "Y";
        oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPaySFNFlag)));       
        oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPersPaySFNAmt())));        
      }  
      else
      {
        sHdnPersPaySFNFlag ="N";        
        oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPaySFNFlag)));       
        oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }
      
      /* Employee hrms Info*/                        
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtDOB())));
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtGender())));
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtMarStat())));
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtFatherNam())));
      oParameters.add(new DBObject(37,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHomTwn())));
      oParameters.add(new DBObject(38,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHandi())));     
      oParameters.add(new DBObject(39,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtHandiEffDate())));     
      oParameters.add(new DBObject(40,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPrvPromDate())));      
      oParameters.add(new DBObject(41,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtRetireDate())));
      oParameters.add(new DBObject(42,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHRAStat())));      
      oParameters.add(new DBObject(43,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtHRAEffDate())));     
      
      oParameters.add(new DBObject(44,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getParentZone())));       
      oParameters.add(new DBObject(45,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getPrefix()))); 
      //oParameters.add(new DBObject(75,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSection()))); 
      oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtMHSTyp())));
      oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEpsFlag())));
      oParameters.add(new DBObject(48,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtEpsEntDt())));
      oParameters.add(new DBObject(49,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtEpsSepDt())));      
      oParameters.add(new DBObject(50,DBObject.IN,ParameterTypes.VARCHAR,new String("")));        
      oParameters.add(new DBObject(51,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPersPaySFNEffFrom())));
      oParameters.add(new DBObject(52,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPersPaySFNEffTill())));
      oParameters.add(new DBObject(53,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplCmpAllowEffFrom())));
      oParameters.add(new DBObject(54,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplCmpAllowEffTill())));

      if(oDeptLabourInfoHeaderBean.getHdnSplDtyAllowFlag()!=null)
        oParameters.add(new DBObject(55,DBObject.IN,ParameterTypes.VARCHAR,oDeptLabourInfoHeaderBean.getHdnSplDtyAllowFlag()));
      else
        oParameters.add(new DBObject(55,DBObject.IN,ParameterTypes.VARCHAR,""));
      if(oDeptLabourInfoHeaderBean.getTxtSplDtyAllowArea()!=null)
      {
              if(oDeptLabourInfoHeaderBean.getHdnSplDtyAllowFlag()!=null && oDeptLabourInfoHeaderBean.getHdnSplDtyAllowFlag().equalsIgnoreCase("Y"))
              {
                    oParameters.add(new DBObject(56,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSplDtyAllowArea()))); // added by devendra on 22 sept 2010        
              }else
              {
                    oParameters.add(new DBObject(56,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); // added by devendra on 22 sept 2010        
              }
          
      }
      else
      {
          oParameters.add(new DBObject(56,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); // added by devendra on 22 sept 2010
      }
      oParameters.add(new DBObject(57,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplDtyAllowEffFrom())));
      oParameters.add(new DBObject(58,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplDtyAllowEffTill())));
      oParameters.add(new DBObject(59,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtLabourCode())));
      
      oParameters.add(new DBObject(60,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(61,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(62,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(63,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpFirstName())));
      oParameters.add(new DBObject(64,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpLastName())));
      oParameters.add(new DBObject(65,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpMiddleName())));
      oParameters.add(new DBObject(66,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtFathHusflag())));
      //oParameters.add(new DBObject(66,DBObject.OUT,ParameterTypes.INTEGER)); commented by devendra on 30th sept
          //oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_UpdateDeptLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");   commented by devendra on 22 sept 2010
        //  oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_UpdateDeptLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");    commented by devendra on 30th sept
      
      // added by devendra on 30 sept 2010 start
      if(screenNameForSuper!=null && !screenNameForSuper.equalsIgnoreCase("DeptLabourDetailAdminScreen")) 
      { 
          oParameters.add(new DBObject(67,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtMemberId())));
          oParameters.add(new DBObject(68,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPohwFlag())));
          oParameters.add(new DBObject(69,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(70,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_UpdateDeptLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);   // added by devendra on 22 sept 2010
      } 
      else 
      { 
          oParameters.add(new DBObject(67,DBObject.IN,ParameterTypes.VARCHAR,new String(payRevFlag)));
          oParameters.add(new DBObject(68,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtLastIncrDt())));
        oParameters.add(new DBObject(69,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCasteCateg())));
        oParameters.add(new DBObject(70,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHandiType())));
        oParameters.add(new DBObject(71,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtReligion())));
        oParameters.add(new DBObject(72,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtExsrvcman())));
        oParameters.add(new DBObject(73,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtAadharNum())));
        oParameters.add(new DBObject(74,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtUanNum())));
        oParameters.add(new DBObject(75,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtCPFIntEndDt())));
        oParameters.add(new DBObject(76,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtMemberId())));
          oParameters.add(new DBObject(77,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPohwFlag())));

          oParameters.add(new DBObject(78,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(79,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_UpdtDeptLbrFinDtlAdmin(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
      } 
      // added by devendra on 30 th sept 2010 end
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
    DeptLabourInfoHeaderBean oDeptLabourInfoHeaderBean = (DeptLabourInfoHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output  
    //ArrayList oAddOutArray; //Output 
    String sCityType, sHraCityType; 
    
    if ((oDeptLabourInfoHeaderBean.getTxtPayModeType() == null) || (oDeptLabourInfoHeaderBean.getTxtPayMode().equals("B")) || (oDeptLabourInfoHeaderBean.getTxtPayMode().equals("C"))) 
      sPayModeType = " "; 
    else
      sPayModeType = oDeptLabourInfoHeaderBean.getTxtPayModeType();       
        
    String sCantFlag;
    if (oDeptLabourInfoHeaderBean.getHdnCantFlag().equals("Y"))
      sCantFlag = "Y" ;
    else 
      sCantFlag = "N";
    
    String sHdnWashFlag;
    if (oDeptLabourInfoHeaderBean.getHdnWashFlag().equals("Y"))
      sHdnWashFlag = "Y";
    else
      sHdnWashFlag = "N";            
       
    String sCCAFlag;
    if (oDeptLabourInfoHeaderBean.getHdnCCAFlag().equals("Y"))
      sCCAFlag = "Y";
    else
      sCCAFlag ="N";  
      
    String sHdnPLIFlag;
    if (oDeptLabourInfoHeaderBean.getHdnPLIFlag().equals("Y"))
      sHdnPLIFlag = "Y";
    else
      sHdnPLIFlag ="N";
    
    String sConvFlag;
    if (oDeptLabourInfoHeaderBean.getHdnConvFlag().equals("Y"))
      sConvFlag = "Y";
    else
      sConvFlag ="N";      

    String sHdnStationCompFlag;
    if (oDeptLabourInfoHeaderBean.getHdnStationCompFlag().equals("Y"))
      sHdnStationCompFlag = "Y";
    else
      sHdnStationCompFlag ="N";  
          
    String sHdnSplCmpAllowFlag;
    if (oDeptLabourInfoHeaderBean.getHdnSplCmpAllowFlag().equals("Y"))
      sHdnSplCmpAllowFlag = "Y";
    else
      sHdnSplCmpAllowFlag ="N";      
          
    String sHdnPersPaySFNFlag;
    if (oDeptLabourInfoHeaderBean.getHdnPersPaySFNFlag().equals("Y"))
      sHdnPersPaySFNFlag = "Y";
    else
      sHdnPersPaySFNFlag ="N";        
        
    String sFpsNo = oDeptLabourInfoHeaderBean.getTxtFpsNo();
    String zonalFpsNo = sFpsNo;  // Added by dushyant on 23-MAy-2013  
    
  /*  // commented by dushyant on 23-MAy-2013  
    if(sFpsNo!=null && sFpsNo.length()>0) 
    {
        zonalFpsNo = getZonalFPS(oDeptLabourInfoHeaderBean.getTxtEmpNo(), oDeptLabourInfoHeaderBean.getParentZone(), sFpsNo, "EMPCTGRY$DPTL");
    }
  */       
      //String sTabNum = oDeptLabourInfoHeaderBean.getHdnTabVal(); 
      oParameters = new ArrayList();   
      //oAddressParam = new ArrayList();     
      /* Employee Header Info */   
      String payRevFlag=oDeptLabourInfoHeaderBean.getPayRevFlag();
      String payScaleCode=oDeptLabourInfoHeaderBean.getTxtPayScaleCode();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtStaffCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpFirstName())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpMiddleName())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpLastName())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtDsgnDesc())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCateg())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag())));
      //oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpTypeId())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPFType())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCpfCode())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(zonalFpsNo)));  //added by swapnendu Dt 05 Oct 2011    
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtDojFCI())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPresentPOP())));      
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtDOJSite())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEmpStatus())));
      
      /* Employee Payroll Info*/      
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayType())));
      
      
      if (payRevFlag.equalsIgnoreCase("3") && !(payScaleCode.contains("#"))) 
       {
       payScaleCode=payRevFlag + '#' +oDeptLabourInfoHeaderBean.getTxtPayScaleCode();
        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,payScaleCode));
        }
      else{
      
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayScaleCode())));
             }
      
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCurtBasic())));
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayStatus())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(sPayModeType)));              
      //oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtBankCode())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtBranchCode())));      
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtBankAccNo())));            
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPayStsChnDate())));      
      //oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPerPayHighQual())));
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtInrSt())));      
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtStagInc())));      
      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtStagEffDate())));
      //oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSubsAmt())));      
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPanNo())));
      //oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtLicFeeDEM())));
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCityTypeHra())));                              
      
      // Employee Hr Flag Info      
      //oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(sHraFlag)));       
      //oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(sNpaFlag)));      
      oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(sCantFlag))); 
      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnWashFlag)));       
      oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnStationCompFlag)));       
      oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(sCCAFlag)));      
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPLIFlag)));      
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(sConvFlag)));      
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplCmpAllowFlag)));
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSplCmpAllowAmt())));     
      oParameters.add(new DBObject(37,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPaySFNFlag)));       
      oParameters.add(new DBObject(38,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPersPaySFNAmt())));
         
      /* Employee hrms Info*/                        
      oParameters.add(new DBObject(39,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtDOB())));
      oParameters.add(new DBObject(40,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtGender())));
      oParameters.add(new DBObject(41,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtMarStat())));
      oParameters.add(new DBObject(42,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtFatherNam())));
      oParameters.add(new DBObject(43,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHomTwn())));
      oParameters.add(new DBObject(44,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHandi())));     
      oParameters.add(new DBObject(45,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtHandiEffDate())));     
      oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPrvPromDate())));      
      oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtRetireDate())));
      oParameters.add(new DBObject(48,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHRAStat())));      
      oParameters.add(new DBObject(49,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtHRAEffDate())));   
      oParameters.add(new DBObject(50,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getParentZone())));                
      
      oParameters.add(new DBObject(51,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getPrefix())));  
      
      oParameters.add(new DBObject(52,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtMHSTyp())));
      oParameters.add(new DBObject(53,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtEpsFlag())));
      oParameters.add(new DBObject(54,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtEpsEntDt())));
      oParameters.add(new DBObject(55,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtEpsSepDt())));
      oParameters.add(new DBObject(56,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      
      oParameters.add(new DBObject(57,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPersPaySFNEffFrom())));
      oParameters.add(new DBObject(58,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtPersPaySFNEffTill())));
      oParameters.add(new DBObject(59,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplCmpAllowEffFrom())));
      oParameters.add(new DBObject(60,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplCmpAllowEffTill())));
     
      oParameters.add(new DBObject(61,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnSplDtyAllowFlag())));
      oParameters.add(new DBObject(62,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSplDtyAllowArea()))); // added by devendra on 22 sept 2010
      oParameters.add(new DBObject(63,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplDtyAllowEffFrom())));
      oParameters.add(new DBObject(64,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDeptLabourInfoHeaderBean.getTxtSplDtyAllowEffTill())));
      oParameters.add(new DBObject(65,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtLabourCode())));
     
      oParameters.add(new DBObject(66,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(67,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(68,DBObject.IN,ParameterTypes.VARCHAR,payRevFlag)); // Modified by Ravindra Singh on 24 September 2020
       oParameters.add(new DBObject(69,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCasteCateg())));
        oParameters.add(new DBObject(70,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtHandiType())));
        oParameters.add(new DBObject(71,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtReligion())));
        oParameters.add(new DBObject(72,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtExsrvcman())));
        oParameters.add(new DBObject(73,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtAadharNum())));
        oParameters.add(new DBObject(74,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtUanNum())));
        oParameters.add(new DBObject(75,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtFathHusflag())));
      oParameters.add(new DBObject(76,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtMemberId())));
      oParameters.add(new DBObject(77,DBObject.INOUT,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(78,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(79,DBObject.OUT,ParameterTypes.INTEGER));

      //oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_InsertDeptLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");        commented by devendra on 21 sept 2010
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_InsertDeptLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);  // added by devendra on 22 sept 2010      
     
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

  public RecordMetaInfo getDeptLabHeaderMetaInfo(DeptLabourQueryVO oDeptLabourQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oDeptLabourQueryVO.getLoginLocCode()+"";

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtEmpFirstName())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtEmpLastName())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtDsgnDesc())));    
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtEmpStatus())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtStaffCode())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getParentZone())));    
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtCpfCode()))); 
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getHdnEmpLbrFlag()))); 
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getPayRevFlag())));  // added by devendra on 21 sept 2010
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinCount(?,?,?,?,?,?)");
    //changed pkg Name dt 16 july 2008
    //oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetDeptLbrFinCount(?,?,?,?,?,?,?,?,?,?,?,?,?)"); commented by devendra on 21 sept 2010
    oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetDeptLbrFinCount(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // added by devendra on 21 sept 2010
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getDeptLabourHeader(DeptLabourQueryVO oDeptLabourQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sSiteId = oDeptLabourQueryVO.getTxtEmpLastName()+"";
    int count = 0;

    if(oDeptLabourQueryVO == null)
    {
      oDeptLabourQueryVO = new DeptLabourQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String locCode = oDeptLabourQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtEmpFirstName())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtEmpLastName())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtDsgnDesc())));    
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtEmpStatus())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtStaffCode())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getParentZone())));    
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getTxtCpfCode())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getHdnEmpLbrFlag()))); 
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourQueryVO.getPayRevFlag()))); // added by devendra on 21 sept 2010 
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.INTEGER));
    //changed pkg Name dt 16 july 2008
    //oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetDeptLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); commented by devendra on 21 sept 2010
    oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetDeptLbrFinDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // added by devendra on 21 sept 2010
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    DeptLabourInfoHeaderBean oDeptLabourInfoHeaderBean;
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
        oDeptLabourInfoHeaderBean = new DeptLabourInfoHeaderBean();

        oDeptLabourInfoHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oDeptLabourInfoHeaderBean.setTxtStaffCode(oRow.get("STAFF_CODE").getString());
        oDeptLabourInfoHeaderBean.setParentZone(oRow.get("PARENT_ZONE").getString());
        oDeptLabourInfoHeaderBean.setTxtEmpFirstName(oRow.get("EMP_FIRST_NAME").getString());        
        oDeptLabourInfoHeaderBean.setTxtEmpMiddleName(oRow.get("EMP_MIDDLE_NAME").getString());        
        oDeptLabourInfoHeaderBean.setTxtEmpLastName(oRow.get("EMP_LAST_NAME").getString());        
        oDeptLabourInfoHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oDeptLabourInfoHeaderBean.setTxtDsgnDesc(oRow.get("DESIGNATION_ID").getString());                
        oDeptLabourInfoHeaderBean.setTxtPFType(oRow.get("EMP_PF_TYPE").getString());
        oDeptLabourInfoHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oDeptLabourInfoHeaderBean.setTxtFpsNo(oRow.get("FPS_NUM").getString());           
        oDeptLabourInfoHeaderBean.setTxtDojFCI(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("COMP_JOINING_DATE").getDate()));
        oDeptLabourInfoHeaderBean.setTxtPresentPOPDesc(oRow.get("LOC_DESC").getString());        
        oDeptLabourInfoHeaderBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
        oDeptLabourInfoHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oDeptLabourInfoHeaderBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString());          
        oDeptLabourInfoHeaderBean.setPrefix(oRow.get("PREFIX").getString());       
        oDeptLabourInfoHeaderBean.setTxtPayType(oRow.get("PAY_SCALE_TYPE").getString());
        oDeptLabourInfoHeaderBean.setTxtPayScaleCode(oRow.get("PAY_SCALE_CODE").getString());
        oDeptLabourInfoHeaderBean.setTxtCurtBasic(oRow.get("BASIC").getString());                
        oDeptLabourInfoHeaderBean.setTxtPayStatus(oRow.get("PAY_STATUS").getString());         
        oDeptLabourInfoHeaderBean.setTxtPayMode(oRow.get("PAY_MODE").getString());
        oDeptLabourInfoHeaderBean.setTxtPayModeType(oRow.get("PAY_MODE_TYPE").getString());                                      
        oDeptLabourInfoHeaderBean.setTxtBankDesc(oRow.get("bank_name").getString());        
        oDeptLabourInfoHeaderBean.setTxtBranchCode(oRow.get("BRANCH_CODE").getString());        
        oDeptLabourInfoHeaderBean.setTxtBranchDesc(oRow.get("bank_branch_name").getString());        
        oDeptLabourInfoHeaderBean.setTxtBankAccNo(oRow.get("BANK_AC_NO").getString());
        oDeptLabourInfoHeaderBean.setTxtPayStsChnDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate()));        
        oDeptLabourInfoHeaderBean.setTxtInrSt(oRow.get("INCREMENT_STATUS").getString());
        oDeptLabourInfoHeaderBean.setTxtStagInc(oRow.get("STAG_INCR").getString());        
        oDeptLabourInfoHeaderBean.setTxtStagEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("STAG_INCR_EFF_DATE").getDate()));
        
        oDeptLabourInfoHeaderBean.setTxtPanNo(oRow.get("EMP_PAN_NO").getString());
        oDeptLabourInfoHeaderBean.setTxtLabourCode(oRow.get("KOT_LBR_ID").getString());
        
        oDeptLabourInfoHeaderBean.setTxtCityTypeHra(oRow.get("CITY_TYPE_HRA").getString());       
        
        oDeptLabourInfoHeaderBean.setTxtDOB(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("EMP_BIRTH_DATE").getDate()));
        oDeptLabourInfoHeaderBean.setTxtGender(oRow.get("EMP_SEX_CODE").getString());                  
        oDeptLabourInfoHeaderBean.setTxtMarStat(oRow.get("MARITAL_STATUS").getString());          
        oDeptLabourInfoHeaderBean.setTxtFatherNam(oRow.get("FATHER_NAME").getString());  
        oDeptLabourInfoHeaderBean.setTxtHomTwn(oRow.get("HOMETOWN").getString());          
        oDeptLabourInfoHeaderBean.setTxtHandi(oRow.get("HANDICAPPED_FLAG").getString()); 
        oDeptLabourInfoHeaderBean.setTxtHandiEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("HANDICAPPED_EFF_DATE").getDate()));        
        oDeptLabourInfoHeaderBean.setTxtPrvPromDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));        
        oDeptLabourInfoHeaderBean.setTxtRetireDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("RETIREMENT_DATE").getDate()));                
        oDeptLabourInfoHeaderBean.setTxtHRAStat(oRow.get("HRA_STATUS").getString()); 
        oDeptLabourInfoHeaderBean.setTxtHRAEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("HRA_EFF_DATE").getDate()));              
       
       oDeptLabourInfoHeaderBean.setTxtMHSTyp(oRow.get("MHS_FLAG").getString());
          //ADDED BY AMRESH
             /*    if(oRow.get("EPS_FLAG").getString().equalsIgnoreCase("Y") || oRow.get("EPS_FLAG").getString().equalsIgnoreCase("P"))
                     oDeptLabourInfoHeaderBean.setTxtEpsFlag("Y");
                 else
                    oDeptLabourInfoHeaderBean.setTxtEpsFlag("N");*/
       oDeptLabourInfoHeaderBean.setTxtEpsFlag(oRow.get("EPS_FLAG").getString());
       //oDeptLabourInfoHeaderBean.setTxtEpsFlag(oRow.get("EPS_FLAG").getString());
       oDeptLabourInfoHeaderBean.setTxtEpsEntDt(EnrgiseUtil.convertToString(oRow.get("EPS_ENTLMNT_DT").getDate()));
       oDeptLabourInfoHeaderBean.setTxtEpsSepDt(EnrgiseUtil.convertToString(oRow.get("EPS_SEP_DT").getDate()));
       oDeptLabourInfoHeaderBean.setTxtEpsSepRsn(oRow.get("EPS_SEP_REASON").getString());
       
       oDeptLabourInfoHeaderBean.setTxtPersPaySFNEffFrom(EnrgiseUtil.convertToString(oRow.get("PP_SFN_EFF_FROM").getDate()));
       oDeptLabourInfoHeaderBean.setTxtPersPaySFNEffTill(EnrgiseUtil.convertToString(oRow.get("PP_SFN_EFF_TILL").getDate()));
       oDeptLabourInfoHeaderBean.setTxtSplCmpAllowEffFrom(EnrgiseUtil.convertToString(oRow.get("SPL_CMP_EFF_FROM").getDate()));
       oDeptLabourInfoHeaderBean.setTxtSplCmpAllowEffTill(EnrgiseUtil.convertToString(oRow.get("SPL_CMP_EFF_TILL").getDate()));
       oDeptLabourInfoHeaderBean.setTxtSplDtyAllowArea(oRow.get("SPL_DTY_AREA_TYPE").getString()); // added by devendra on 22 sept 2010
       oDeptLabourInfoHeaderBean.setTxtSplDtyAllowEffFrom(EnrgiseUtil.convertToString(oRow.get("SPL_DTY_EFF_FROM").getDate()));
       oDeptLabourInfoHeaderBean.setTxtSplDtyAllowEffTill(EnrgiseUtil.convertToString(oRow.get("SPL_DTY_EFF_TILL").getDate()));
        oDeptLabourInfoHeaderBean.setTxtLastIncrDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("last_increment_date").getDate()));                
        if(oRow.get("LUNCH_SUBS_FLAG").getString().equals("Y"))
        {
          oDeptLabourInfoHeaderBean.setSelectCant(true);
          oDeptLabourInfoHeaderBean.setHdnCantFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectCant(false);
          oDeptLabourInfoHeaderBean.setHdnCantFlag("N");
        }
        
        if(oRow.get("WASHING_ALLOW_FLAG").getString().equals("Y"))
        {
          oDeptLabourInfoHeaderBean.setSelectWash(true);
          oDeptLabourInfoHeaderBean.setHdnWashFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectWash(false);
          oDeptLabourInfoHeaderBean.setHdnWashFlag("N");
        }
        
        if(oRow.get("STATION_COMP_FLAG").getString().equals("Y"))
        {
          oDeptLabourInfoHeaderBean.setSelectStationComp(true);
          oDeptLabourInfoHeaderBean.setHdnStationCompFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectStationComp(false);
          oDeptLabourInfoHeaderBean.setHdnStationCompFlag("N");
        }
        
        if(oRow.get("CCA_FLAG").getString().equals("Y"))
        {
          oDeptLabourInfoHeaderBean.setSelectCCAFlag(true);
          oDeptLabourInfoHeaderBean.setHdnCCAFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectCCAFlag(false);
          oDeptLabourInfoHeaderBean.setHdnCCAFlag("N");
        }
        
        if(oRow.get("PLI_FLAG").getString().equals("Y"))
        {
          oDeptLabourInfoHeaderBean.setSelectPLI(true);
          oDeptLabourInfoHeaderBean.setHdnPLIFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectPLI(false);
          oDeptLabourInfoHeaderBean.setHdnPLIFlag("N");
        } 
        
        if(oRow.get("CONV_ALLOW_FLAG").getString().equals("Y"))
        {
          oDeptLabourInfoHeaderBean.setSelectConvFlag(true);
          oDeptLabourInfoHeaderBean.setHdnConvFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectConvFlag(false);
          oDeptLabourInfoHeaderBean.setHdnConvFlag("N");
        }
        
       // if(oRow.get("PERS_PAY_SFN_FLAG").getString().equals("Y")) commented by devendra on 16th sept 2010
       if(oRow.get("PERS_PAY_SFN_FLAG").getString()!=null && oRow.get("PERS_PAY_SFN_FLAG").getString().equals("Y")) //added by devendra on 16th sept 2010
        {
          oDeptLabourInfoHeaderBean.setSelectPersPaySFN(true);
          oDeptLabourInfoHeaderBean.setHdnPersPaySFNFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectPersPaySFN(false);
          oDeptLabourInfoHeaderBean.setHdnPersPaySFNFlag("N");
        }
        
       // if(oRow.get("SPL_COMP_ALLOW_FLAG").getString().equals("Y")) commented by devendra on 16th sept 2010
       if(oRow.get("SPL_COMP_ALLOW_FLAG").getString()!=null && oRow.get("SPL_COMP_ALLOW_FLAG").getString().equals("Y")) //added by devendra on 16th sept 2010
        {
          oDeptLabourInfoHeaderBean.setSelectSplCmpAllow(true);
          oDeptLabourInfoHeaderBean.setHdnSplCmpAllowFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectSplCmpAllow(false);
          oDeptLabourInfoHeaderBean.setHdnSplCmpAllowFlag("N");
        }
        
        if(oRow.get("SPL_DTY_ALLOW_FLAG").getString()!=null && oRow.get("SPL_DTY_ALLOW_FLAG").getString().equals("Y"))
        {
          oDeptLabourInfoHeaderBean.setSelectSplDtyAllow(true);
          oDeptLabourInfoHeaderBean.setHdnSplDtyAllowFlag("Y");
        }
        else
        {
          oDeptLabourInfoHeaderBean.setSelectSplDtyAllow(false);
          oDeptLabourInfoHeaderBean.setHdnSplDtyAllowFlag("N");
        }
        
        oDeptLabourInfoHeaderBean.setHdnBoardFlag(oRow.get("BOARD_FLG").getString());        
        
        oDeptLabourInfoHeaderBean.setTxtPersPaySFNAmt(oRow.get("PERS_PAY_SFN_AMOUNT").getString());        
        
        oDeptLabourInfoHeaderBean.setTxtSplCmpAllowAmt(oRow.get("SPL_COMP_ALLOW").getString());        
        oDeptLabourInfoHeaderBean.setPayRevFlag(oRow.get("PAY_REV_FLAG").getString());       //added by devendra on 21 sept 2010
        oDeptLabourInfoHeaderBean.setTxtGangId(oRow.get("gang_id").getString());       //added by swapnendu Dt 21 May 2012
        oDeptLabourInfoHeaderBean.setTxtGangName(oRow.get("gang_name").getString());       //added by swapnendu on 21 May 2012
        oDeptLabourInfoHeaderBean.setTxtOldCpfCode(oRow.get("OLD_CPF_CODE").getString());     //added by dushyant Dt 18 May 2013
        oDeptLabourInfoHeaderBean.setTxtCasteCateg(oRow.get("CASTE_CATEGORY").getString()); 
        oDeptLabourInfoHeaderBean.setTxtHandiType(oRow.get("HANDICAPPED_TYPE").getString()); 
        oDeptLabourInfoHeaderBean.setTxtReligion(oRow.get("RELIGION").getString()); 
        oDeptLabourInfoHeaderBean.setTxtExsrvcman(oRow.get("EX_SERVICEMEN").getString()); 
        oDeptLabourInfoHeaderBean.setTxtAadharNum(oRow.get("AADHAR_NUM").getString()); 
        oDeptLabourInfoHeaderBean.setTxtUanNum(oRow.get("UAN").getString()); 
        oDeptLabourInfoHeaderBean.setTxtFathHusflag(oRow.get("fath_hus_flag").getString());
        oDeptLabourInfoHeaderBean.setTxtMemberId(oRow.get("member_id").getString());
          oDeptLabourInfoHeaderBean.setTxtPohwFlag(oRow.get("pohw_flag").getString());
          oDeptLabourInfoHeaderBean.setTxtPohwEffDt(EnrgiseUtil.convertToString(oRow.get("pohw_eff_date").getDate()));
        oDeptLabourInfoHeaderBean.setTxtCPFIntEndDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("interest_end_date").getDate()));

        oHeaderList.add(oDeptLabourInfoHeaderBean);
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
  
  private ArrayList getEmpFinComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList();
    ArrayList oOutArray;
    //DeptLabourComboVO oEmpFin=null;
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

  public DeptLabourComboVO getDeptLabourComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oConvAllowCity = null;    
    DeptLabourComboVO oDeptLbrCmbVO=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
        
    oDeptLbrCmbVO = new DeptLabourComboVO();  
    
    ArrayList oDeptLbrStatList = new ArrayList();
    oDeptLbrStatList = getEmpFinComboRecords("pkg_pay_labour.proc_GetDeptLbrStatus(?,?)","deptLbrstatus_id","DeptLbrstatus_desc");
    oDeptLbrCmbVO.setValueEmpStatArrayList(oDeptLbrStatList);

    ArrayList oDeptStatAllList = new ArrayList();
    oDeptStatAllList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_GetEmpStatusLOV(?,?)","gbl_code","code_desc");
    oDeptLbrCmbVO.setValueEmpStatAllArrayList(oDeptStatAllList);
    
    ArrayList oParentZoneList = new ArrayList();
    oParentZoneList = getEmpFinComboRecords("pkg_pay_labour.proc_GetLbrParentZone(?,?)","loc_id","loc_desc");
    oDeptLbrCmbVO.setValueParentZoneArrayList(oParentZoneList);
    
    ArrayList oEmpSplCompList = new ArrayList();
    oEmpSplCompList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetSplCompAllow(?,?)","splcomp_id","splcomp_desc");
    oDeptLbrCmbVO.setValueSplCompArrayList(oEmpSplCompList);
    
    ArrayList oEmpAccomTypeList = new ArrayList();
    oEmpAccomTypeList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetAccomType(?,?)","accomtype_id","accomtype_desc");
    oDeptLbrCmbVO.setValueAccomTypeArrayList(oEmpAccomTypeList);

    ArrayList oMHSTypeList = new ArrayList();
    oMHSTypeList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_GetMHSType(?,?)","code_sdesc","code_desc");
    oDeptLbrCmbVO.setMhsTypList(oMHSTypeList);

    ArrayList oEpsSepTypeList = new ArrayList();
    oEpsSepTypeList = getEmpFinComboRecords("PAYROLL_PKG_EXT.getEPSSepType(?,?)","code_sdesc","code_desc");
    oDeptLbrCmbVO.setEpsSepTypList(oEpsSepTypeList);
    
    oDeptLbrCmbVO.setCityHraList(oConvAllowCity);      
    
    // added by devendra on 22 sept 2010 start
     ArrayList oSplDtyAreaList = new ArrayList();
    oSplDtyAreaList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_getSplDutyArea(?,?)","code_sdesc","code_desc");
    oDeptLbrCmbVO.setSplDtyAreaList(oSplDtyAreaList);   
    // added by devendra on 22 sept 2010 end
    
    ArrayList oCasteCategList = new ArrayList();
    oCasteCategList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_getcastecateg(?,?)","code_sdesc","code_desc");
    oDeptLbrCmbVO.setValueCasteCategList(oCasteCategList);   
      
    ArrayList oHandiTypeList = new ArrayList();
    oHandiTypeList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_gethanditype(?,?)","code_sdesc","code_desc");
    oDeptLbrCmbVO.setValueHandiTypeList(oHandiTypeList);
    
    ArrayList oReligionList = new ArrayList();
    oReligionList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_getreligion(?,?)","code_sdesc","code_desc");
    oDeptLbrCmbVO.setValueReligionList(oReligionList);
    
    return oDeptLbrCmbVO;
  }
  
  public LovVO getDeptLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinLOV(?,?,?,?)");
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
  
  
  public LovVO getEmpTypeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee Type Id");    
    arylstHeaderNames.add("Employee Type");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PopupEmpTypeData(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("emptype_id").getString());             
       oLOVBean.setDetailField2(oRow.get("emptype_desc").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

   public LovVO getDeptLabLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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


  public LovVO getQueryDeptLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("First Name");    
    arylstHeaderNames.add("Middle Name");    
    arylstHeaderNames.add("Last Name");    
    arylstHeaderNames.add("CPF Code");    // added by devendra on 21 sept 2010
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE); // added by devendra on 21 sept 2010
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
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));     
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField4())));  // added by devendra on 24 th sept 2010
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));    
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpFinLOV_new(?,?,?,?,?,?,?)"); commented by devendra on 24 sept 2010
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpFinLOV_new(?,?,?,?,?,?,?,?)"); // added by devendra on 24 sept 2010
    
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
        oLOVBean.setDetailField3(oRow.get("EMP_MIDDLE_NAME").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_LAST_NAME").getString());    
        oLOVBean.setDetailField5(oRow.get("CPF_CODE").getString()); // added by devendra on 24 sept 2010
      
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
      checkMandatoryDetail(oBaseHeaderBean,sScreenMode,sScreenName);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean, String sScreenMode, String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oList = new ArrayList();
    
      //added by nand on 22-may-2013
      DeptLabourInfoHeaderBean oDeptLabourInfoHeaderBean = (DeptLabourInfoHeaderBean)oBaseHeaderBean; 
      checkMaxPayYear(oDeptLabourInfoHeaderBean.getTxtSiteID(),oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag());
      reportError(oList);
      //checkFirst(oBaseHeaderBean,oList);
      checkEmpNo(oBaseHeaderBean,oList); 
      if(sScreenMode.equals(EnrgiseConstants.NEW_MODE)|| sScreenName.equals("DeptLabourDetailAdminScreen"))
      {                 
          checkEmpCurBasicLimit(oBaseHeaderBean,oList);                    
      }
       if(sScreenMode.equals(EnrgiseConstants.UPDATE_MODE)&& sScreenName.equals("DeptLabourDetailAdminScreen")&&(oDeptLabourInfoHeaderBean.getTxtDsgnDesc().equals("174")||oDeptLabourInfoHeaderBean.getTxtDsgnDesc().equals("178")||oDeptLabourInfoHeaderBean.getTxtDsgnDesc().equals("404")||oDeptLabourInfoHeaderBean.getTxtDsgnDesc().equals("405")))
      {
      checkGangDetails(oBaseHeaderBean, oList);
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
    DeptLabourInfoHeaderBean oDeptLabourInfoHeaderBean = (DeptLabourInfoHeaderBean)oBaseHeaderBean;    
    String empNo = oDeptLabourInfoHeaderBean.getHeaderPrimaryKey(); 
    String cpfCode=oDeptLabourInfoHeaderBean.getTxtCpfCode();
    String fpsNo=oDeptLabourInfoHeaderBean.getTxtFpsNo();
    String panNo=oDeptLabourInfoHeaderBean.getTxtPanNo();
    String birthDate =oDeptLabourInfoHeaderBean.getTxtDOB();
     String aadharNo =oDeptLabourInfoHeaderBean.getTxtAadharNum();
    String uan=oDeptLabourInfoHeaderBean.getTxtUanNum();
    String retDate=oDeptLabourInfoHeaderBean.getTxtRetireDate();
    if (fpsNo!=null && !fpsNo.equals(""))
    {
  /*  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHeaderPrimaryKey()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag()))); //added by swapnendu Dt 06 Mar 2011 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCpfCode()))); 
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_EmpDuplicateCheck(?,?,?,?,?)"); */ // Commented by dushyant on 17-April-2013 
      
       // Added by dushyant for CPF check zone wise on 17-April-2013  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag()))); 
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCpfCode()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtFpsNo()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getParentZone())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayStatus())));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"apps.FCI_PKG_CR_161.proc_empduplicatecheck(?,?,?,?,?,?,?,?)",true,true);
    // End by dushyant for CPF check zone wise on 17-April-2013  
    
      chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
      String error_msg=(String)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
      } 
    }
/*  // Commented by dushyant on 23-MAy-2013      
    if(fpsNo!=null && !fpsNo.equals(""))
    {
      String zonalFpsNo = getZonalFPS(oDeptLabourInfoHeaderBean.getTxtEmpNo(), oDeptLabourInfoHeaderBean.getParentZone(), fpsNo, "EMPCTGRY$DPTL");
    
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,zonalFpsNo)); //Added by swapnendu Dt 05 Oct 2011
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag())));
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
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag()))); // Added By Ravindra on 23/Nov/2020
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_EmpPanDuplicateCheck_dept(?,?,?,?,?)"); // Extra Parameter Added By Ravindra on 23/Nov/2020
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
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag()))); // Added By Ravindra on 23/Nov/2020
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_empAadharDuplChk_dept(?,?,?,?,?)",true,true); // Extra Parameter Added By Ravindra on 23/Nov/2020
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
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag()))); // Added By Ravindra on 23/Nov/2020
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_empUanDuplChk_dept(?,?,?,?,?)",true,true); // Extra Parameter Added By Ravindra on 23/Nov/2020
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
        oDeptLabourInfoHeaderBean.setTxtRetireDate(rdate);
      }
        
    }
    
  }  

  private void checkEmpCurBasicLimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray = new ArrayList(); // added by devendra on 21 sept 2010
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
    DeptLabourInfoHeaderBean oDeptLabourInfoHeaderBean = (DeptLabourInfoHeaderBean)oBaseHeaderBean;
    String  payRevFlag = oDeptLabourInfoHeaderBean.getPayRevFlag();    // added by devendra on 21 sept 2010
    
    String empNo = oDeptLabourInfoHeaderBean.getHeaderPrimaryKey();    
    oParameters = new ArrayList();
    
    /*   commented by devendra on 21 sept 2010
          Parameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayType())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayScaleCode())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCurtBasic())));  
    
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_ValidateCurBasic(?,?,?,?,?,?)");   */
    
     //////////////////////// for 5th pay ccommission////////////////////////////////////////////////////////
    if(payRevFlag!=null && payRevFlag.equalsIgnoreCase("3"))
    { String payScaleCode=oDeptLabourInfoHeaderBean.getTxtPayScaleCode();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayType())));
        if (payRevFlag.equalsIgnoreCase("3") && !(payScaleCode.contains("#"))) 
                {
                payScaleCode=payRevFlag + '#' +oDeptLabourInfoHeaderBean.getTxtPayScaleCode();
                 oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,payScaleCode));
                 }
        else{
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayScaleCode())));
            }
          
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCurtBasic())));  
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_ValidateCurBasic(?,?,?,?,?,?)");   
    }
    ///////////////////////////for 6th pay commission////////////////////////////////////////////////////////
   else if(payRevFlag!=null && payRevFlag.equalsIgnoreCase("2"))
   {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayType())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayScaleCode())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCurtBasic())));  
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String("0")));   // grade pay will be always 0 for dept labour
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_ValidateCurBasic_6PC(?,?,?,?,?,?)");  //added by devendra
   }
   //////// for employee maintenance information (normal )//////////////////////////////////////////////////////////////////
   else if(payRevFlag==null || payRevFlag.equalsIgnoreCase(""))
   {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayType())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtPayScaleCode())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getTxtCurtBasic())));  
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String("0")));  
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_ValidateCurBasic_6PC(?,?,?,?,?,?)");  //added by devendra
   }   
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
    }        
  }

  public LovVO getDeptLabStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("State Code");  
    arylstHeaderNames.add("State Description");  
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
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetStateCodeApps(?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("Lookup_code").getString());                   
      oLOVBean.setDetailField2(oRow.get("Meaning").getString());                   
      oList.add(oLOVBean);
    }     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }    


 public LovVO getDeptLabBankCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Bank Name");          
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);            
    oLovVO.setVisibilityList(arylstVisibility);

    String BankName; 
    BankName=oLovQueryVO.getSearchField1();   
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, BankName));    
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    //changed pkg Name dt 16 july 2008
    oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetBankCodeLOVQ(?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("bank_name").getString());                   
      oLOVBean.setDetailField2(oRow.get("bank_name").getString());                   
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }      


  public LovVO getDeptLabBranchCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    String sBankCode;  
    sBankCode=oLovQueryVO.getProperty("txtBankCode").trim();  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Branch Code");  
    arylstHeaderNames.add("Branch Description");  
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);

    String BranchCode, BranchName; 
    BranchCode=oLovQueryVO.getSearchField1();
    BranchName=oLovQueryVO.getSearchField2();    
    
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sBankCode)));  
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, BranchCode));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, BranchName));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    //changed pkg Name dt 16 july 2008
    oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetBranchCodeLov(?,?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("bank_branch_id").getString());                   
      oLOVBean.setDetailField2(oRow.get("bank_branch_name").getString());                   
      oList.add(oLOVBean);
    }
     
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
   
  public LovVO getDeptLabDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code");     
    arylstHeaderNames.add("Board Flag"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID"))); //added by nitin on 22-02-2013
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("headerPrimaryKey")));  //added by nitin on 22-02-2013
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
        oLOVBean.setDetailField5(oRow.get("pay_scale_code").getString());        
        oLOVBean.setDetailField6(oRow.get("BOARD_FLG").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getDeptLabDsgnQryLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;  
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    Integer empNo = new Integer(0);
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));  //added by nitin on 22-02-2013
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,empNo));  //added by nitin on 22-02-2013
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
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getDeptLabSectionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Section Code");    
    arylstHeaderNames.add("Section");
    arylstHeaderNames.add("Division");     
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetSectionDivLov(?,?,?)");
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
        oLOVBean.setDetailField1(oRow.get("SECTION_ID").getString());   
        oLOVBean.setDetailField2(oRow.get("SECTION").getString());
        oLOVBean.setDetailField3(oRow.get("DIVISION").getString());        
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

  

  public LovVO getCityCodeLovData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("City Code");  
    arylstHeaderNames.add("City Type");    
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
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetCityTypeLocLov(?,?)");
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
  
  public ArrayList getDeptLabourVldnDetails()  throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    ArrayList oEmpVldn=new ArrayList();
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    ArrayList oOutArray; //Output 
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayCodeRules(?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    EmpFinVldnBean oEmpFinVldnBean;
    count = 0;
    QueryRow oRow = null;
    HashMap oColumns = null;
    Iterator oIt = oList.iterator();
    while(oIt.hasNext())
    {
        if(count == 0)
        {
           oEmpVldn = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oEmpFinVldnBean = new EmpFinVldnBean();
        oEmpFinVldnBean.setStrPayScaleTyp(oRow.get("payScaleType").getString());
        oEmpFinVldnBean.setStrCtgry(oRow.get("category").getString());
        oEmpFinVldnBean.setStrDsgnId(oRow.get("dsgnId").getString());
        oEmpFinVldnBean.setStrEmpStatus(oRow.get("empStatus").getString());
        oEmpFinVldnBean.setStrAllow(oRow.get("payCodeDesc").getString());
        oEmpFinVldnBean.setStrPayCode(oRow.get("payCode").getString());        
        oEmpVldn.add(oEmpFinVldnBean);
    }
    return oEmpVldn;
  }
  
  public int checkKotLabourCode(String sKotCode, long locId )throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    Integer oResult = null; 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
    Timestamp oWhenPicked = null;
    int count = 0;  
    String loginLocId = String.valueOf(locId);
    ArrayList oOutArray; //Output 
    Integer chkFlag = null;

      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sKotCode)));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(loginLocId)));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_checkKotLbrCode(?,?,?,?)",true,true);      
      
      chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
      
      if((chkFlag.equals(new Integer(0))))
      { 
        oResult = (Integer)((DBObject)oOutArray.get(0)).getObject();
        
      }else
      {
        oResult = new Integer(3);    
      }            
      return oResult.intValue();      
  }   
  
  /*procedure added by ashish bansal */
  private void checkGangDetails(BaseHeaderBean oBaseHeaderBean, ArrayList oList)throws EnrgiseSystemException, EnrgiseApplicationException
 {
 ArrayList oParameters = new ArrayList();
  DBUtilitiesBean oBean = new DBUtilitiesBean();
  ArrayList oOutArray;
  DeptLabourInfoHeaderBean oDeptLabourInfoHeaderBean = (DeptLabourInfoHeaderBean)oBaseHeaderBean;
  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oDeptLabourInfoHeaderBean.getHeaderPrimaryKey())));
  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDeptLabourInfoHeaderBean.getHdnEmpLbrFlag())));
  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new Integer(oDeptLabourInfoHeaderBean.getTxtSiteID())));
  oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new Integer(oDeptLabourInfoHeaderBean.getTxtDsgnDesc())));
  oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,""));
  oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
  oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
  oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.check_gangdetail(?,?,?,?,?,?,?)",true,true);
  
   DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject(); 
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.gangetailCheck",oArguments));
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