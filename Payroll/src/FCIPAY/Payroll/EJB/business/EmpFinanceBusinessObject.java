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


public class EmpFinanceBusinessObject extends BaseBO 
{

  public EmpFinanceBusinessObject()
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sTabNum; 
    String sPayModeType;
    int count = 0;
    EmpFinInfoHeaderBean oEmpFinInfoHeaderBean = (EmpFinInfoHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output 
    ArrayList oAddOutArray; //Output 

    //sTabNum = oEmpFinInfoHeaderBean.HdnTabVal();       
    if ((oEmpFinInfoHeaderBean.getTxtPayModeType() == null) || (oEmpFinInfoHeaderBean.getTxtPayMode().equals("B")) || (oEmpFinInfoHeaderBean.getTxtPayMode().equals("C"))) 
       sPayModeType = " "; 
    else
    {
       sPayModeType = oEmpFinInfoHeaderBean.getTxtPayModeType();
    }
      
    String sHraFlag;
    if (oEmpFinInfoHeaderBean.getHdnHraFlag().equals("Y"))
      sHraFlag = "Y";
    else
      sHraFlag ="N";  

    String sNpaFlag;
    if (oEmpFinInfoHeaderBean.getHdnNpaFlag().equals("Y"))
      sNpaFlag = "Y";
    else
      sNpaFlag ="N";
    
    String sCantFlag;
    if (oEmpFinInfoHeaderBean.getHdnCantFlag().equals("Y"))
      sCantFlag = "Y" ;
    else 
      sCantFlag = "N";
    
    String sHdnWashFlag;
    if (oEmpFinInfoHeaderBean.getHdnWashFlag().equals("Y"))
      sHdnWashFlag = "Y";
    else
      sHdnWashFlag = "N";            
       
    String sCCAFlag;
    if (oEmpFinInfoHeaderBean.getHdnCCAFlag().equals("Y"))
      sCCAFlag = "Y";
    else
      sCCAFlag ="N";  
      
    String sHdnPLIFlag;
    if (oEmpFinInfoHeaderBean.getHdnPLIFlag().equals("Y"))
      sHdnPLIFlag = "Y";
    else
      sHdnPLIFlag ="N";
    
    String sConvFlag;
    if (oEmpFinInfoHeaderBean.getHdnConvFlag().equals("Y"))
      sConvFlag = "Y";
    else
      sConvFlag ="N";      
    
    String sHdnDustOpAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnDustOpAllowFlag().equals("Y"))
      sHdnDustOpAllowFlag = "Y";
    else
      sHdnDustOpAllowFlag ="N"; 
      
    String sHdnStationCompFlag;
    if (oEmpFinInfoHeaderBean.getHdnStationCompFlag().equals("Y"))
      sHdnStationCompFlag = "Y";
    else
      sHdnStationCompFlag ="N"; 
       
    String sDepuFlag;
    if (oEmpFinInfoHeaderBean.getHdnDepuFlag().equals("Y"))
      sDepuFlag = "Y";
    else
      sDepuFlag = "N"; 

    String sOpAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnOpAllowFlag().equals("Y"))
      sOpAllowFlag = "Y";
    else
      sOpAllowFlag = "N"; 

    String sHdnSplDtyAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnSplDtyAllowFlag()!=null && oEmpFinInfoHeaderBean.getHdnSplDtyAllowFlag().equals("Y"))
      sHdnSplDtyAllowFlag = "Y";
    else
      sHdnSplDtyAllowFlag ="N";    
  
    // added by devendra start
     String payRevFlag=oEmpFinInfoHeaderBean.getPayRevFlag();
    /*if (payRevFlag!=null && payRevFlag.equalsIgnoreCase("6"))
          payRevFlag = "Y";
    else
        payRevFlag = "";toberemoved*/
    // added by devendra end
    //added by gagan on 17-06-2013 under CR-283
   // String carAvailFlag;
   // if (oEmpFinInfoHeaderBean.getSelectCarAvail().equals("Y"))
    //  carAvailFlag = "Y";
   // else
   //   carAvailFlag = "N"; 
    //ended by gagan
    String sHdnDblHraFlag;
    //String sHdnAdvIncrFlag;
    String sHdnSplCmpAllowFlag;
    String sHdnSplPaySprtFlag;
    String sHdnSplPayCshAllowFlag;
    String sHdnPersPaySFNFlag;
    String sHdnPersPayHQuaFlag;
    String sHdnPersPayHndQuaFlag;
    String sFpsNo = oEmpFinInfoHeaderBean.getTxtFpsNo();
    String zonalFpsNo = sFpsNo;  // Added by dushyant on 23-MAy-2013 
    
/*   // Commented by dushyant on 23-MAy-2013   
    if(sFpsNo!=null && sFpsNo.length()>0) 
    {
        zonalFpsNo = getZonalFPS(oEmpFinInfoHeaderBean.getTxtEmpNo(), oEmpFinInfoHeaderBean.getParentZone(), sFpsNo, oEmpFinInfoHeaderBean.getTxtCateg());
    }
*/    
      oParameters = new ArrayList();     
      oAddressParam = new ArrayList();     
      /* Employee Header Info */
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtStaffCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpFirstName())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpMiddleName())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpLastName())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDsgnDesc())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCateg())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCadre())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpTypeId())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPFType())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCpfCode())));
      //oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFpsNo()))); //commented on 23 Sep 2011     
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,zonalFpsNo)); // added on 23 Sep 2011
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDojFCI())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPresentPOP())));      
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOJSite())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpStatus())));
      
      /* Employee Payroll Info*/      
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayType())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayScaleCode())));
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurtBasic())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayStatus())));
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(sPayModeType)));              
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtBankCode())));
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtBranchCode())));      
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtBankAccNo())));            
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPayStsChnDate())));      
     // oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPerPayHighQual())));
      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtInrSt())));      
      //oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtStagInc())));      
      //oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtStagEffDate())));
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSubsAmt())));      
      oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPanNo())));
      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtLicFeeDEM())));
      oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCityTypeHra())));                              
      
      // Employee Hr Flag Info      
      oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(sHraFlag)));       
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(sNpaFlag)));      
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(sCantFlag))); 
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnWashFlag)));       
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnStationCompFlag)));       
      oParameters.add(new DBObject(37,DBObject.IN,ParameterTypes.VARCHAR,new String(sCCAFlag)));      
      oParameters.add(new DBObject(38,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPLIFlag)));      
      oParameters.add(new DBObject(39,DBObject.IN,ParameterTypes.VARCHAR,new String(sConvFlag)));
      oParameters.add(new DBObject(40,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnDustOpAllowFlag)));      
      oParameters.add(new DBObject(41,DBObject.IN,ParameterTypes.VARCHAR,new String(sDepuFlag)));
      
      if (oEmpFinInfoHeaderBean.getHdnDblHraFlag().equals("Y"))
      {
        sHdnDblHraFlag = "Y";
        oParameters.add(new DBObject(42,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnDblHraFlag)));
        oParameters.add(new DBObject(43,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDblHraCity())));        
      }
      else
      {
        sHdnDblHraFlag ="N";     
        oParameters.add(new DBObject(42,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnDblHraFlag)));
        oParameters.add(new DBObject(43,DBObject.IN,ParameterTypes.VARCHAR,new String("")));        
      }      
      
      oParameters.add(new DBObject(44,DBObject.IN,ParameterTypes.VARCHAR,new String("")));      
      oParameters.add(new DBObject(45,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); 
      
      if (oEmpFinInfoHeaderBean.getHdnSplCmpAllowFlag().equals("Y"))
      {
        sHdnSplCmpAllowFlag = "Y";
        oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplCmpAllowFlag)));
        oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplCmpAllowAmt())));
      }
      else
      {
        sHdnSplCmpAllowFlag ="N";        
        oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplCmpAllowFlag)));
        oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }
      
      if (oEmpFinInfoHeaderBean.getHdnSplPaySprtFlag().equals("Y"))
      {
        sHdnSplPaySprtFlag = "Y";
        oParameters.add(new DBObject(48,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplPaySprtFlag)));        
        oParameters.add(new DBObject(49,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplPaySprtAmt())));
      }  
      else
      {
        sHdnSplPaySprtFlag ="N";        
        oParameters.add(new DBObject(48,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplPaySprtFlag)));        
        oParameters.add(new DBObject(49,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }  
      
      if (oEmpFinInfoHeaderBean.getHdnSplPayCshAllowFlag().equals("Y"))
      {
        sHdnSplPayCshAllowFlag = "Y";
        oParameters.add(new DBObject(50,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplPayCshAllowFlag)));
        oParameters.add(new DBObject(51,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplPayCshAllowAmt())));
      }  
      else
      {
        sHdnSplPayCshAllowFlag ="N";
        oParameters.add(new DBObject(50,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplPayCshAllowFlag)));
        oParameters.add(new DBObject(51,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }
      
      if (oEmpFinInfoHeaderBean.getHdnPersPaySFNFlag().equals("Y"))
      {
        sHdnPersPaySFNFlag = "Y";
        oParameters.add(new DBObject(52,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPaySFNFlag)));       
        oParameters.add(new DBObject(53,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPaySFNAmt())));        
      }  
      else
      {
        sHdnPersPaySFNFlag ="N";        
        oParameters.add(new DBObject(52,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPaySFNFlag)));       
        oParameters.add(new DBObject(53,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }
      
      if (oEmpFinInfoHeaderBean.getHdnPersPayHQuaFlag().equals("Y"))
      {
        sHdnPersPayHQuaFlag = "Y";
        oParameters.add(new DBObject(54,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPayHQuaFlag)));
        oParameters.add(new DBObject(55,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPayHQuaAmt())));
      }
      else
      {
        sHdnPersPayHQuaFlag ="N"; 
        oParameters.add(new DBObject(54,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPayHQuaFlag)));
        oParameters.add(new DBObject(55,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }
      
      /* Employee hrms Info*/                        
      oParameters.add(new DBObject(56,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOB())));
      oParameters.add(new DBObject(57,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGender())));
      oParameters.add(new DBObject(58,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMarStat())));
      oParameters.add(new DBObject(59,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFatherNam())));
      oParameters.add(new DBObject(60,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHomTwn())));
      oParameters.add(new DBObject(61,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandi())));     
      oParameters.add(new DBObject(62,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHandiEffDate())));     
      oParameters.add(new DBObject(63,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPrvPromDate())));      
      oParameters.add(new DBObject(64,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtRetireDate())));
      oParameters.add(new DBObject(65,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHRAStat())));      
      oParameters.add(new DBObject(66,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHRAEffDate())));
      oParameters.add(new DBObject(67,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getLstAccomType())));
     // oParameters.add(new DBObject(70,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtLeaseAmt()))); 
     oParameters.add(new DBObject(68,DBObject.IN,ParameterTypes.VARCHAR,new String(""))); 
      
      oParameters.add(new DBObject(69,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getParentZone())));          
      if (oEmpFinInfoHeaderBean.getTxtEmpStatus().equals("EMPSTATUS$DEPU"))
        oParameters.add(new DBObject(70,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDepuType())));    
      else
        oParameters.add(new DBObject(70,DBObject.IN,ParameterTypes.VARCHAR,new String("")));    
      
      oParameters.add(new DBObject(71,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getPrefix()))); 
      oParameters.add(new DBObject(72,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSection()))); 
      oParameters.add(new DBObject(73,DBObject.IN,ParameterTypes.VARCHAR,new String(sOpAllowFlag))); 
      
      oParameters.add(new DBObject(74,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHRAEndDate())));
      oParameters.add(new DBObject(75,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMHSTyp()))); 
      
      oParameters.add(new DBObject(76,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEpsFlag())));
      oParameters.add(new DBObject(77,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsEntDt())));
      oParameters.add(new DBObject(78,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsSepDt())));

      oParameters.add(new DBObject(79,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(80,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDblHraEffFrom())));
      oParameters.add(new DBObject(81,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDblHraEffTill())));
      oParameters.add(new DBObject(82,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplCmpAllowEffFrom())));
      oParameters.add(new DBObject(83,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplCmpAllowEffTill())));
      oParameters.add(new DBObject(84,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPaySprtEffFrom())));
      oParameters.add(new DBObject(85,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPaySprtEffTill())));
      oParameters.add(new DBObject(86,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPayCshAllowEffFrom())));
      oParameters.add(new DBObject(87,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPayCshAllowEffTill())));
      oParameters.add(new DBObject(88,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPaySFNEffFrom())));
      oParameters.add(new DBObject(89,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPaySFNEffTill())));
      oParameters.add(new DBObject(90,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHQuaEffFrom())));
      oParameters.add(new DBObject(91,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHQuaEffTill())));
      if (oEmpFinInfoHeaderBean.getHdnPersPayHndQuaFlag().equals("Y"))
      {
        sHdnPersPayHndQuaFlag = "Y";
        oParameters.add(new DBObject(92,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPayHndQuaFlag)));
        oParameters.add(new DBObject(93,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaNoIncr())));
        oParameters.add(new DBObject(94,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaAmt())));
       }
      else
      {
        sHdnPersPayHndQuaFlag ="N"; 
        oParameters.add(new DBObject(92,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPayHndQuaFlag)));
        oParameters.add(new DBObject(93,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        oParameters.add(new DBObject(94,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      
      }
      oParameters.add(new DBObject(95,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaEffFrom())));
      oParameters.add(new DBObject(96,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaEffTill())));


      if(oEmpFinInfoHeaderBean.getScreenFlag().equals("MaintainEmpAdminFinDetailScreen"))
      {
        oParameters.add(new DBObject(97,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(98,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(99,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
        oParameters.add(new DBObject(100,DBObject.IN,ParameterTypes.VARCHAR,payRevFlag)); // added by devendra
        oParameters.add(new DBObject(101,DBObject.IN,ParameterTypes.VARCHAR,oEmpFinInfoHeaderBean.getTxtGradePay())); // added by devendra
        oParameters.add(new DBObject(102,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplDtyAllowFlag))); 
        oParameters.add(new DBObject(103,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplDtyAllowArea())));
        oParameters.add(new DBObject(104,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplDtyAllowEffFrom())));
        oParameters.add(new DBObject(105,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplDtyAllowEffTill())));
        oParameters.add(new DBObject(106,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMhsAmt())));
     //   oParameters.add(new DBObject(109,DBObject.IN,ParameterTypes.VARCHAR,new String(carAvailFlag)));
       	oParameters.add(new DBObject(107,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCasual())));
        oParameters.add(new DBObject(108,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCasteCateg())));
        oParameters.add(new DBObject(109,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandiType())));
        oParameters.add(new DBObject(110,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtReligion())));
        oParameters.add(new DBObject(111,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtExsrvcman())));
        oParameters.add(new DBObject(112,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAadharNum())));
        oParameters.add(new DBObject(113,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUanNum())));
        oParameters.add(new DBObject(114,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPenNum())));
        oParameters.add(new DBObject(115,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFathHusflag())));
          if (oEmpFinInfoHeaderBean.getTxtNpsFlag()==""||oEmpFinInfoHeaderBean.getTxtNpsFlag()==null)
                        {
                            oParameters.add(new DBObject(116,DBObject.IN,ParameterTypes.VARCHAR,new String("N")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(116,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtNpsFlag())));
                        
                        }
                        
                        if (oEmpFinInfoHeaderBean.getTxtPranNo()==""||oEmpFinInfoHeaderBean.getTxtPranNo()==null)
                        {
                            oParameters.add(new DBObject(117,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(117,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPranNo())));
                        
                        }
        oParameters.add(new DBObject(118,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtCPFIntEndDt())));
          oParameters.add(new DBObject(119,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMemberId())));
          //oParameters.add(new DBObject(120,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPohwFlag())));
          //oParameters.add(new DBObject(121,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPohwEffDt())));


          
               oParameters.add(new DBObject(120,DBObject.OUT,ParameterTypes.VARCHAR));
               oParameters.add(new DBObject(121,DBObject.OUT,ParameterTypes.INTEGER));
        //oOutArray = oBean.callProc(oParameters,"PKG_SUPER_USER_SCREEN.proc_UpdateEmpFinDetail_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);     // commented by devendra on 24 sept 2010
        oOutArray = oBean.callProc(oParameters,"PKG_SUPER_USER_SCREEN.proc_UpdateEmpFinDetail_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);     // added by devendra on 24 sept 2010
      }else
      {
        oParameters.add(new DBObject(97,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplDtyAllowFlag)));
        oParameters.add(new DBObject(98,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplDtyAllowEffFrom())));
        oParameters.add(new DBObject(99,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplDtyAllowEffTill())));
        oParameters.add(new DBObject(100,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGradePay())));
        oParameters.add(new DBObject(101,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplDtyAllowArea())));
        
        oParameters.add(new DBObject(102,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(103,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(104,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
      //  oParameters.add(new DBObject(107,DBObject.IN,ParameterTypes.VARCHAR,new String(carAvailFlag)));
      oParameters.add(new DBObject(105,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCasteCateg())));
        oParameters.add(new DBObject(106,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandiType())));
        oParameters.add(new DBObject(107,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtReligion())));
        oParameters.add(new DBObject(108,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtExsrvcman())));
        oParameters.add(new DBObject(109,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAadharNum())));
        oParameters.add(new DBObject(110,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUanNum())));
          oParameters.add(new DBObject(111,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPenNum())));
          oParameters.add(new DBObject(112,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFathHusflag())));
          if (oEmpFinInfoHeaderBean.getTxtNpsFlag()==""||oEmpFinInfoHeaderBean.getTxtNpsFlag()==null)
                        {
                            oParameters.add(new DBObject(113,DBObject.IN,ParameterTypes.VARCHAR,new String("N")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(113,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtNpsFlag())));
                        
                        }
                        
                        if (oEmpFinInfoHeaderBean.getTxtPranNo()==""||oEmpFinInfoHeaderBean.getTxtPranNo()==null)
                        {
                            oParameters.add(new DBObject(114,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(114,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPranNo())));
                        
                        }
        oParameters.add(new DBObject(115,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMemberId())));
          oParameters.add(new DBObject(116,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPohwFlag())));
          oParameters.add(new DBObject(117,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPohwEffDt())));

                 oParameters.add(new DBObject(118,DBObject.OUT,ParameterTypes.VARCHAR));
                 oParameters.add(new DBObject(119,DBObject.OUT,ParameterTypes.INTEGER));;

        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateEmpFinDetail_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);   
      }
      DBObject oMsgObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oMsgObject.getObject();
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
    EmpFinInfoHeaderBean oEmpFinInfoHeaderBean = (EmpFinInfoHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output  
    //ArrayList oAddOutArray; //Output 
    String sCityType, sHraCityType; 
      String payScaleCode=oEmpFinInfoHeaderBean.getTxtPayScaleCode();
    if ((oEmpFinInfoHeaderBean.getTxtPayModeType() == null) || (oEmpFinInfoHeaderBean.getTxtPayMode().equals("B")) || (oEmpFinInfoHeaderBean.getTxtPayMode().equals("C"))) 
      sPayModeType = " "; 
    else
      sPayModeType = oEmpFinInfoHeaderBean.getTxtPayModeType();      
    
    String sHraFlag;
    if (oEmpFinInfoHeaderBean.getHdnHraFlag().equals("Y"))
      sHraFlag = "Y";
    else
      sHraFlag ="N";  

    String sNpaFlag;
    if (oEmpFinInfoHeaderBean.getHdnNpaFlag().equals("Y"))
      sNpaFlag = "Y";
    else
      sNpaFlag ="N";
    
    String sCantFlag;
    if (oEmpFinInfoHeaderBean.getHdnCantFlag().equals("Y"))
      sCantFlag = "Y" ;
    else 
      sCantFlag = "N";
    
    String sHdnWashFlag;
    if (oEmpFinInfoHeaderBean.getHdnWashFlag().equals("Y"))
      sHdnWashFlag = "Y";
    else
      sHdnWashFlag = "N";            
       
    String sCCAFlag;
    if (oEmpFinInfoHeaderBean.getHdnCCAFlag().equals("Y"))
      sCCAFlag = "Y";
    else
      sCCAFlag ="N";  
      
    String sHdnPLIFlag;
    if (oEmpFinInfoHeaderBean.getHdnPLIFlag().equals("Y"))
      sHdnPLIFlag = "Y";
    else
      sHdnPLIFlag ="N";
    
    String sConvFlag;
    if (oEmpFinInfoHeaderBean.getHdnConvFlag().equals("Y"))
      sConvFlag = "Y";
    else
      sConvFlag ="N";      
    
    String sHdnDustOpAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnDustOpAllowFlag().equals("Y"))
      sHdnDustOpAllowFlag = "Y";
    else
      sHdnDustOpAllowFlag ="N";  
      
    String sHdnStationCompFlag;
    if (oEmpFinInfoHeaderBean.getHdnStationCompFlag().equals("Y"))
      sHdnStationCompFlag = "Y";
    else
      sHdnStationCompFlag ="N";  
       
    String sDepuFlag;
    if (oEmpFinInfoHeaderBean.getHdnDepuFlag().equals("Y"))
      sDepuFlag = "Y";
    else
      sDepuFlag = "N"; 
    
    String sHdnDblHraFlag;
    if (oEmpFinInfoHeaderBean.getHdnDblHraFlag().equals("Y"))
      sHdnDblHraFlag = "Y";
    else
      sHdnDblHraFlag ="N";     
          
    String sHdnSplCmpAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnSplCmpAllowFlag().equals("Y"))
      sHdnSplCmpAllowFlag = "Y";
    else
      sHdnSplCmpAllowFlag ="N";      
      
    String sHdnSplPaySprtFlag;
    if (oEmpFinInfoHeaderBean.getHdnSplPaySprtFlag().equals("Y"))
      sHdnSplPaySprtFlag = "Y";
    else
      sHdnSplPaySprtFlag ="N";        
      
    String sHdnSplPayCshAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnSplPayCshAllowFlag().equals("Y"))
      sHdnSplPayCshAllowFlag = "Y";
    else
      sHdnSplPayCshAllowFlag ="N";
      
    String sHdnPersPaySFNFlag;
    if (oEmpFinInfoHeaderBean.getHdnPersPaySFNFlag().equals("Y"))
      sHdnPersPaySFNFlag = "Y";
    else
      sHdnPersPaySFNFlag ="N";        
  
    String sHdnPersPayHQuaFlag;
    if (oEmpFinInfoHeaderBean.getHdnPersPayHQuaFlag().equals("Y"))
      sHdnPersPayHQuaFlag = "Y";
    else
      sHdnPersPayHQuaFlag ="N";          

    String sHdnOpAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnOpAllowFlag().equals("Y"))
      sHdnOpAllowFlag = "Y";
    else
      sHdnOpAllowFlag ="N";      
      
    // added by gagan under Cr-283
   //  String carAvailFlag;
  //  if (oEmpFinInfoHeaderBean.getSelectCarAvail().equals("Y"))
   //   carAvailFlag = "Y";
  //  else
  //    carAvailFlag = "N"; 

    String sHdnPersPayHndQuaFlag;
    if (oEmpFinInfoHeaderBean.getHdnPersPayHndQuaFlag().equals("Y"))
      sHdnPersPayHndQuaFlag = "Y";
    else
      sHdnPersPayHndQuaFlag ="N"; 

    String sHdnSplDtyAllowFlag;
    if (oEmpFinInfoHeaderBean.getHdnSplDtyAllowFlag().equals("Y"))
      sHdnSplDtyAllowFlag = "Y";
    else
      sHdnSplDtyAllowFlag ="N";      
       
    String sFpsNo = oEmpFinInfoHeaderBean.getTxtFpsNo();
    String zonalFpsNo = sFpsNo; // Added by dushyant on 23-MAy-2013 
    
/*    // Commented by dushyant on 23-MAy-2013
    if(sFpsNo!=null && sFpsNo.length()>0) 
    {
        zonalFpsNo = getZonalFPS(oEmpFinInfoHeaderBean.getTxtEmpNo(), oEmpFinInfoHeaderBean.getParentZone(), sFpsNo, oEmpFinInfoHeaderBean.getTxtCateg());
    }
*/       
      //String sTabNum = oEmpFinInfoHeaderBean.getHdnTabVal(); 
      oParameters = new ArrayList();   
      //oAddressParam = new ArrayList();     
      /* Employee Header Info */   
      String payRevFlag="3";//new String(oEmpFinInfoHeaderBean.getPayRevFlag());
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtStaffCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpFirstName())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpMiddleName())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpLastName())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDsgnDesc())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCateg())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCadre())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpTypeId())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPFType())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCpfCode())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(zonalFpsNo)));      
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDojFCI())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPresentPOP())));      
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOJSite())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEmpStatus())));
      
      /* Employee Payroll Info*/      
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayType())));
     
      if (payRevFlag.equalsIgnoreCase("3")&& !(payScaleCode.contains("#"))) 
       {
       payScaleCode=payRevFlag + '#' +oEmpFinInfoHeaderBean.getTxtPayScaleCode();
        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(payScaleCode)));
        }
      else{
     
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayScaleCode())));
      }
     
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurtBasic())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayStatus())));
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(sPayModeType)));              
      oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtBankCode())));
      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtBranchCode())));      
      oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtBankAccNo())));            
      oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPayStsChnDate())));      
      oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPerPayHighQual())));
     // oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtInrSt())));      
      //oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtStagInc())));      
      //oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtStagEffDate())));
      oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSubsAmt())));      
      oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPanNo())));
      oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtLicFeeDEM())));
      oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCityTypeHra())));                              
      
      // Employee Hr Flag Info      
      oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(sHraFlag)));       
      oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(sNpaFlag)));      
      oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(sCantFlag))); 
      oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnWashFlag)));       
      oParameters.add(new DBObject(36,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnStationCompFlag)));       
      oParameters.add(new DBObject(37,DBObject.IN,ParameterTypes.VARCHAR,new String(sCCAFlag)));      
      oParameters.add(new DBObject(38,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPLIFlag)));      
      oParameters.add(new DBObject(39,DBObject.IN,ParameterTypes.VARCHAR,new String(sConvFlag)));
      oParameters.add(new DBObject(40,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnDustOpAllowFlag)));      
      oParameters.add(new DBObject(41,DBObject.IN,ParameterTypes.VARCHAR,new String(sDepuFlag)));
      oParameters.add(new DBObject(42,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnDblHraFlag)));
      oParameters.add(new DBObject(43,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDblHraCity())));
      //oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnAdvIncrFlag)));
      oParameters.add(new DBObject(44,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAdvIncrType())));      
      oParameters.add(new DBObject(45,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtAdvIncrEffDate())));
      oParameters.add(new DBObject(46,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplCmpAllowFlag)));
      if(sHdnSplCmpAllowFlag.equals("Y"))
        oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplCmpAllowAmt())));
      else
        oParameters.add(new DBObject(47,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        
      oParameters.add(new DBObject(48,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplPaySprtFlag)));
      if(sHdnSplPaySprtFlag.equals("Y"))
        oParameters.add(new DBObject(49,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplPaySprtAmt())));
      else
        oParameters.add(new DBObject(49,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        
      oParameters.add(new DBObject(50,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplPayCshAllowFlag)));
      if(sHdnSplPayCshAllowFlag.equals("Y"))
        oParameters.add(new DBObject(51,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplPayCshAllowAmt())));
      else
        oParameters.add(new DBObject(51,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        
      oParameters.add(new DBObject(52,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPaySFNFlag)));
      if(sHdnPersPaySFNFlag.equals("Y"))
        oParameters.add(new DBObject(53,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPaySFNAmt())));
      else
        oParameters.add(new DBObject(53,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        
      oParameters.add(new DBObject(54,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPayHQuaFlag)));
      if(sHdnPersPayHQuaFlag.equals("Y"))
        oParameters.add(new DBObject(55,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPayHQuaAmt())));
      else
        oParameters.add(new DBObject(55,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        
      /* Employee hrms Info*/                        
      oParameters.add(new DBObject(56,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDOB())));
      oParameters.add(new DBObject(57,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGender())));
      oParameters.add(new DBObject(58,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMarStat())));
      oParameters.add(new DBObject(59,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFatherNam())));
      oParameters.add(new DBObject(60,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHomTwn())));
      oParameters.add(new DBObject(61,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandi())));     
      oParameters.add(new DBObject(62,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHandiEffDate())));     
      oParameters.add(new DBObject(63,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPrvPromDate())));      
      oParameters.add(new DBObject(64,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtRetireDate())));
      oParameters.add(new DBObject(65,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHRAStat())));      
      oParameters.add(new DBObject(66,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHRAEffDate())));
      oParameters.add(new DBObject(67,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getLstAccomType())));
      oParameters.add(new DBObject(68,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtLeaseAmt())));
    //  oParameters.add(new DBObject(70,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(69,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getParentZone())));          
      oParameters.add(new DBObject(70,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtDepuType())));          
      
      oParameters.add(new DBObject(71,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getPrefix()))); 
      oParameters.add(new DBObject(72,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSection()))); 
      
      oParameters.add(new DBObject(73,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnOpAllowFlag)));      
      
      oParameters.add(new DBObject(74,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtHRAEndDate())));
      oParameters.add(new DBObject(75,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMHSTyp()))); 
      
      oParameters.add(new DBObject(76,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtEpsFlag())));
      oParameters.add(new DBObject(77,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsEntDt())));
      oParameters.add(new DBObject(78,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtEpsSepDt())));
     
      oParameters.add(new DBObject(79,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(80,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDblHraEffFrom())));
      oParameters.add(new DBObject(81,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtDblHraEffTill())));
      oParameters.add(new DBObject(82,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplCmpAllowEffFrom())));
      oParameters.add(new DBObject(83,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplCmpAllowEffTill())));
      oParameters.add(new DBObject(84,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPaySprtEffFrom())));
      oParameters.add(new DBObject(85,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPaySprtEffTill())));
      oParameters.add(new DBObject(86,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPayCshAllowEffFrom())));
      oParameters.add(new DBObject(87,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplPayCshAllowEffTill())));
      oParameters.add(new DBObject(88,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPaySFNEffFrom())));
      oParameters.add(new DBObject(89,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPaySFNEffTill())));
      oParameters.add(new DBObject(90,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHQuaEffFrom())));
      oParameters.add(new DBObject(91,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHQuaEffTill())));
      oParameters.add(new DBObject(92,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnPersPayHndQuaFlag)));
      if(sHdnPersPayHndQuaFlag.equals("Y"))
      {
        oParameters.add(new DBObject(93,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaNoIncr())));
        oParameters.add(new DBObject(94,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaAmt())));
      }else
      {
        oParameters.add(new DBObject(93,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        oParameters.add(new DBObject(94,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      }
      oParameters.add(new DBObject(95,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaEffFrom())));
      oParameters.add(new DBObject(96,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPersPayHndQuaEffTill())));
      oParameters.add(new DBObject(97,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtFathHusflag())));

      if(oEmpFinInfoHeaderBean.getScreenFlag().equals("MaintainEmpAdminFinDetailScreen"))
      {
        oParameters.add(new DBObject(98,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(99,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
          if (oEmpFinInfoHeaderBean.getTxtNpsFlag()==""||oEmpFinInfoHeaderBean.getTxtNpsFlag()==null)
                        {
                            oParameters.add(new DBObject(100,DBObject.IN,ParameterTypes.VARCHAR,new String("N")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(100,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtNpsFlag())));
                        
                        }
                        
                        if (oEmpFinInfoHeaderBean.getTxtPranNo()==""||oEmpFinInfoHeaderBean.getTxtPranNo()==null)
                        {
                            oParameters.add(new DBObject(101,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(101,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPranNo())));
                        
                        }
          //oParameters.add(new DBObject(102,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPohwFlag())));
          //oParameters.add(new DBObject(103,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPohwEffDt())));

        oParameters.add(new DBObject(102,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMemberId())));                
        oParameters.add(new DBObject(103,DBObject.INOUT,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
        
        // added by gagan on 18-06-2013 under CR-283
       // oParameters.add(new DBObject(102,DBObject.IN,ParameterTypes.VARCHAR,new String(carAvailFlag)));
        //ended by gagan
        oParameters.add(new DBObject(104,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(105,DBObject.OUT,ParameterTypes.INTEGER));

        oOutArray = oBean.callProc(oParameters,"PKG_SUPER_USER_SCREEN.proc_InsertEmpFinDetail_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);    
      }else
      {
        oParameters.add(new DBObject(98,DBObject.IN,ParameterTypes.VARCHAR,new String(sHdnSplDtyAllowFlag)));
        oParameters.add(new DBObject(99,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplDtyAllowEffFrom())));
        oParameters.add(new DBObject(100,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtSplDtyAllowEffTill())));
        oParameters.add(new DBObject(101,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGradePay())));
        oParameters.add(new DBObject(102,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSplDtyAllowArea())));
        
        
        oParameters.add(new DBObject(103,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(104,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(105,DBObject.IN,ParameterTypes.VARCHAR,payRevFlag)); //updated by vansh goel
        //ADDED BY SWATI
        oParameters.add(new DBObject(106,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCasteCateg())));
        oParameters.add(new DBObject(107,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtHandiType())));
        oParameters.add(new DBObject(108,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtReligion())));
        oParameters.add(new DBObject(109,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtExsrvcman())));
        oParameters.add(new DBObject(110,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtAadharNum())));
        oParameters.add(new DBObject(111,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtUanNum())));
        oParameters.add(new DBObject(112,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPenNum())));
          if (oEmpFinInfoHeaderBean.getTxtNpsFlag()==""||oEmpFinInfoHeaderBean.getTxtNpsFlag()==null)
                        {
                            oParameters.add(new DBObject(113,DBObject.IN,ParameterTypes.VARCHAR,new String("N")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(113,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtNpsFlag())));
                        
                        }
                        
                        if (oEmpFinInfoHeaderBean.getTxtPranNo()==""||oEmpFinInfoHeaderBean.getTxtPranNo()==null)
                        {
                            oParameters.add(new DBObject(114,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
                        }
                        else
                        {
                            oParameters.add(new DBObject(114,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPranNo())));
                        
                        }
          
          oParameters.add(new DBObject(115,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtMemberId())));
          //oParameters.add(new DBObject(116,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPohwFlag())));
          //oParameters.add(new DBObject(117,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinInfoHeaderBean.getTxtPohwEffDt())));

        oParameters.add(new DBObject(116,DBObject.INOUT,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHeaderPrimaryKey())));
        
        // added by gagan on 18-06-2013 under CR-283
       // oParameters.add(new DBObject(108,DBObject.IN,ParameterTypes.VARCHAR,new String(carAvailFlag)));
        //ended by gagan
        oParameters.add(new DBObject(117,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(118,DBObject.OUT,ParameterTypes.INTEGER));
        
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertEmpFinDetail_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);  // modified by devendra       
      }
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

  private String getZonalFPS(String empnum, String parentZone, String fpsNo, String ctgry) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empnum)));    
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
  
  public RecordMetaInfo getEmpFinHeaderMetaInfo(EmpFinanceQueryVO oEmpFinanceQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oEmpFinanceQueryVO.getLoginLocCode()+"";
    if(!oEmpFinanceQueryVO.getTxtPresentPOP().equals(""))
    {
      locCode = oEmpFinanceQueryVO.getTxtPresentPOP();
    }

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpFirstName())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpLastName())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtDsgnDesc())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCateg())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCadre())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpTypeId())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpStatus())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtStaffCode())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getParentZone())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtSection()))); 
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCpfCode()))); 
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtPayType())));
    oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
     oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getPayRevFlag()))); // added by devendra on 13th aug 2010
    oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(17,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinCount(?,?,?,?,?,?)");
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinCount_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // commented by devendra on 13th aug 2010
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinCount_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // added by devendra on 13th aug 2010
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getEmpFinHeader(EmpFinanceQueryVO oEmpFinanceQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sSiteId = oEmpFinanceQueryVO.getTxtEmpLastName()+"";
    int count = 0;

    if(oEmpFinanceQueryVO == null)
    {
      oEmpFinanceQueryVO = new EmpFinanceQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String locCode = oEmpFinanceQueryVO.getLoginLocCode()+"";
    if(!oEmpFinanceQueryVO.getTxtPresentPOP().equals(""))
    {
      locCode = oEmpFinanceQueryVO.getTxtPresentPOP();
    }
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getHeaderPrimaryKey())));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpFirstName())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpLastName())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtDsgnDesc())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCateg())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCadre())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpTypeId())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtEmpStatus())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtStaffCode())));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getParentZone())));
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtSection()))); 
    oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtCpfCode()))); 
    oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getTxtPayType())));
    oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
    oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinanceQueryVO.getPayRevFlag())));  // added by devendra on 13 aug 2010
    oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpFinanceQueryVO.getTxtCPFIntEndDt())));   //---Added by milan --date 30/Aug/2019
    oParameters.add(new DBObject(19,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.INTEGER));
    //Changed pkg name dt 16 Jul 2008 
   // oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetEmpFinDetail_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // commented by devendra on 13 aug 2010
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetEmpFinDetail_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  // added by devendra on 13 aug 2010
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    EmpFinInfoHeaderBean oEmpFinInfoHeaderBean;
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
        oEmpFinInfoHeaderBean = new EmpFinInfoHeaderBean();

        oEmpFinInfoHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpFinInfoHeaderBean.setTxtStaffCode(oRow.get("STAFF_CODE").getString());
        oEmpFinInfoHeaderBean.setParentZone(oRow.get("PARENT_ZONE").getString());
        oEmpFinInfoHeaderBean.setTxtEmpFirstName(oRow.get("EMP_FIRST_NAME").getString());        
        oEmpFinInfoHeaderBean.setTxtEmpMiddleName(oRow.get("EMP_MIDDLE_NAME").getString());        
        oEmpFinInfoHeaderBean.setTxtEmpLastName(oRow.get("EMP_LAST_NAME").getString());        
        oEmpFinInfoHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        oEmpFinInfoHeaderBean.setTxtDsgnDesc(oRow.get("DESIGNATION_ID").getString());
        oEmpFinInfoHeaderBean.setTxtCateg(oRow.get("EMP_CATEGORY").getString());
        oEmpFinInfoHeaderBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        oEmpFinInfoHeaderBean.setTxtCadre(oRow.get("CADRE").getString());
        oEmpFinInfoHeaderBean.setTxtEmpTypeId(oRow.get("EMP_TYPE").getString());        
        oEmpFinInfoHeaderBean.setTxtEmpType(oRow.get("EMP_TYPE_DESC").getString());        
        oEmpFinInfoHeaderBean.setTxtPFType(oRow.get("EMP_PF_TYPE").getString());
        oEmpFinInfoHeaderBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpFinInfoHeaderBean.setTmpCpfFlg(oRow.get("CPF_FLG").getString());
        oEmpFinInfoHeaderBean.setTxtFpsNo(oRow.get("FPS_NUM").getString());           
        oEmpFinInfoHeaderBean.setTxtDojFCI(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("COMP_JOINING_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtPresentPOPDesc(oRow.get("LOC_DESC").getString());        
        oEmpFinInfoHeaderBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
        oEmpFinInfoHeaderBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtEmpStatus(oRow.get("EMP_STATUS").getString());  
        oEmpFinInfoHeaderBean.setTxtDepuType(oRow.get("DEPUTATION_TYPE").getString());       
        oEmpFinInfoHeaderBean.setPrefix(oRow.get("PREFIX").getString());       
        oEmpFinInfoHeaderBean.setTxtSection(oRow.get("SECTION_ID").getString());       
        oEmpFinInfoHeaderBean.setTxtSectionDesc(oRow.get("SECTION").getString());               
        oEmpFinInfoHeaderBean.setTxtDivision(oRow.get("DIVISION").getString()); 
        
        
        oEmpFinInfoHeaderBean.setTxtPayType(oRow.get("PAY_SCALE_TYPE").getString());
        oEmpFinInfoHeaderBean.setTxtPayScaleCode(oRow.get("PAY_SCALE_CODE").getString());
        oEmpFinInfoHeaderBean.setTxtCurtBasic(oRow.get("BASIC").getString());        
        //oEmpFinInfoHeaderBean.setHdnStartBasic(oRow.get("START_BASIC").getString());        
        //oEmpFinInfoHeaderBean.setHdnEndBasic(oRow.get("END_BASIC").getString());        
        oEmpFinInfoHeaderBean.setTxtPayStatus(oRow.get("PAY_STATUS").getString());         
        oEmpFinInfoHeaderBean.setTxtPayMode(oRow.get("PAY_MODE").getString());
        oEmpFinInfoHeaderBean.setTxtPayModeType(oRow.get("PAY_MODE_TYPE").getString());                              
        //oEmpFinInfoHeaderBean.setTxtBankCode(oRow.get("BANK_CODE").getString());        
        oEmpFinInfoHeaderBean.setTxtBankDesc(oRow.get("BANK_NAME").getString());        
        oEmpFinInfoHeaderBean.setTxtBranchCode(oRow.get("BRANCH_CODE").getString());        
        oEmpFinInfoHeaderBean.setTxtBranchDesc(oRow.get("BRANCH_NAME").getString());        
        oEmpFinInfoHeaderBean.setTxtBankAccNo(oRow.get("BANK_AC_NO").getString());
        oEmpFinInfoHeaderBean.setTxtPayStsChnDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PAY_STA_CHG_DT").getDate()));
        //oEmpFinInfoHeaderBean.setTxtPerPay(oRow.get("personal_pay").getString()); 
        oEmpFinInfoHeaderBean.setTxtPerPayHighQual(oRow.get("PERS_PAY_HIGH_QUAL").getString());
        oEmpFinInfoHeaderBean.setTxtInrSt(oRow.get("INCREMENT_STATUS").getString());
        //oEmpFinInfoHeaderBean.setTxtStagInc(oRow.get("STAG_INCR").getString());        
        //oEmpFinInfoHeaderBean.setTxtStagEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("STAG_INCR_EFF_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtSubsAmt(oRow.get("VCPF_SUBS_AMOUNT").getString());
        oEmpFinInfoHeaderBean.setTxtPanNo(oRow.get("EMP_PAN_NO").getString());
        oEmpFinInfoHeaderBean.setTxtLicFeeDEM(oRow.get("LICENCE_FEE_DEM").getString());
        oEmpFinInfoHeaderBean.setTxtCityTypeHra(oRow.get("CITY_TYPE_HRA").getString());       
        
        oEmpFinInfoHeaderBean.setTxtDOB(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("EMP_BIRTH_DATE").getDate()));
        oEmpFinInfoHeaderBean.setTxtGender(oRow.get("EMP_SEX_CODE").getString());                  
        oEmpFinInfoHeaderBean.setTxtMarStat(oRow.get("MARITAL_STATUS").getString());          
        oEmpFinInfoHeaderBean.setTxtFatherNam(oRow.get("FATHER_NAME").getString());  
        oEmpFinInfoHeaderBean.setTxtHomTwn(oRow.get("HOMETOWN").getString());          
        oEmpFinInfoHeaderBean.setTxtHandi(oRow.get("HANDICAPPED_FLAG").getString()); 
        oEmpFinInfoHeaderBean.setTxtHandiEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("HANDICAPPED_EFF_DATE").getDate()));        
        oEmpFinInfoHeaderBean.setTxtPrvPromDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("LAST_PROMOTION_DATE").getDate()));        
        oEmpFinInfoHeaderBean.setTxtRetireDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("RETIREMENT_DATE").getDate()));                
        oEmpFinInfoHeaderBean.setTxtHRAStat(oRow.get("HRA_STATUS").getString()); 
        oEmpFinInfoHeaderBean.setTxtHRAEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("HRA_EFF_DATE").getDate()));              
        oEmpFinInfoHeaderBean.setTxtHRAEndDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("HRA_EFF_END_DATE").getDate()));              
        oEmpFinInfoHeaderBean.setLstAccomType(oRow.get("ACCOM_TYPE").getString());  
        oEmpFinInfoHeaderBean.setTxtLeaseAmt(oRow.get("LEASE_AMT").getString());  
        oEmpFinInfoHeaderBean.setTxtMHSTyp(oRow.get("mhs_flag").getString());
        oEmpFinInfoHeaderBean.setTxtMhsAmt(oRow.get("totmhsamtrcvd").getString()); 

        oEmpFinInfoHeaderBean.setTxtCasual(oRow.get("INFO_1").getString());   
        oEmpFinInfoHeaderBean.setTxtCPFIntEndDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("interest_end_date").getDate()));
        
        //added by gagan on 18-06-2013
      //  if(oRow.get("car_flag").getString()!= null && oRow.get("car_flag").getString().equals("Y"))
       // {
      //    oEmpFinInfoHeaderBean.setSelectCarAvail("Y");
      //  }
     //   else
      //  {
     //     oEmpFinInfoHeaderBean.setSelectCarAvail("N");
     //   } 
        
        
        
        if(oRow.get("NPA_FLAG").getString()!= null && oRow.get("NPA_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectNpa(true);
          oEmpFinInfoHeaderBean.setHdnNpaFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectNpa(false);
          oEmpFinInfoHeaderBean.setHdnNpaFlag("N");
        }          

        if(oRow.get("LUNCH_SUBS_FLAG").getString()!= null && oRow.get("LUNCH_SUBS_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectCant(true);
          oEmpFinInfoHeaderBean.setHdnCantFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectCant(false);
          oEmpFinInfoHeaderBean.setHdnCantFlag("N");
        }
        
        if(oRow.get("DEPUT_ALLOW_FLAG").getString()!= null && oRow.get("DEPUT_ALLOW_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectDepu(true);
          oEmpFinInfoHeaderBean.setHdnDepuFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectDepu(false);
          oEmpFinInfoHeaderBean.setHdnDepuFlag("N");
        }
        
        if(oRow.get("WASHING_ALLOW_FLAG").getString()!= null && oRow.get("WASHING_ALLOW_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectWash(true);
          oEmpFinInfoHeaderBean.setHdnWashFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectWash(false);
          oEmpFinInfoHeaderBean.setHdnWashFlag("N");
        }
        
        if(oRow.get("STATION_COMP_FLAG").getString()!= null && oRow.get("STATION_COMP_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectStationComp(true);
          oEmpFinInfoHeaderBean.setHdnStationCompFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectStationComp(false);
          oEmpFinInfoHeaderBean.setHdnStationCompFlag("N");
        }
        
        if(oRow.get("CCA_FLAG").getString()!= null && oRow.get("CCA_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectCCAFlag(true);
          oEmpFinInfoHeaderBean.setHdnCCAFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectCCAFlag(false);
          oEmpFinInfoHeaderBean.setHdnCCAFlag("N");
        }
        
        if(oRow.get("PLI_FLAG").getString()!= null && oRow.get("PLI_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectPLI(true);
          oEmpFinInfoHeaderBean.setHdnPLIFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectPLI(false);
          oEmpFinInfoHeaderBean.setHdnPLIFlag("N");
        } 
        
        if(oRow.get("CONV_ALLOW_FLAG").getString()!= null && oRow.get("CONV_ALLOW_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectConvFlag(true);
          oEmpFinInfoHeaderBean.setHdnConvFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectConvFlag(false);
          oEmpFinInfoHeaderBean.setHdnConvFlag("N");
        }
        
        if(oRow.get("DUST_OPERATOR_FLAG").getString()!= null && oRow.get("DUST_OPERATOR_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectDustOpAllow(true);
          oEmpFinInfoHeaderBean.setHdnDustOpAllowFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectDustOpAllow(false);
          oEmpFinInfoHeaderBean.setHdnDustOpAllowFlag("N");
        }
        
        if(oRow.get("DBL_HRA_FLAG").getString()!= null && oRow.get("DBL_HRA_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectDblHraFlag(true);
          oEmpFinInfoHeaderBean.setHdnDblHraFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectDblHraFlag(false);
          oEmpFinInfoHeaderBean.setHdnDblHraFlag("N");
        }
        
        if(oRow.get("SPL_PAY_SPORT_FLAG").getString()!= null && oRow.get("SPL_PAY_SPORT_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectSplPaySprt(true);
          oEmpFinInfoHeaderBean.setHdnSplPaySprtFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectSplPaySprt(false);
          oEmpFinInfoHeaderBean.setHdnSplPaySprtFlag("N");
        }
        
        if(oRow.get("SPL_PAY_CASH_FLAG").getString()!= null && oRow.get("SPL_PAY_CASH_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectSplPayCshAllow(true);
          oEmpFinInfoHeaderBean.setHdnSplPayCshAllowFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectSplPayCshAllow(false);
          oEmpFinInfoHeaderBean.setHdnSplPayCshAllowFlag("N");
        }
        
        if(oRow.get("PERS_PAY_SFN_FLAG").getString()!= null && oRow.get("PERS_PAY_SFN_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectPersPaySFN(true);
          oEmpFinInfoHeaderBean.setHdnPersPaySFNFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectPersPaySFN(false);
          oEmpFinInfoHeaderBean.setHdnPersPaySFNFlag("N");
        }
        
        if(oRow.get("PERS_PAY_HIGH_QUAL_FLAG").getString()!= null && oRow.get("PERS_PAY_HIGH_QUAL_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectPersPayHQua(true);
          oEmpFinInfoHeaderBean.setHdnPersPayHQuaFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectPersPayHQua(false);
          oEmpFinInfoHeaderBean.setHdnPersPayHQuaFlag("N");
        }
        
        if(oRow.get("SPL_COMP_ALLOW_FLAG").getString()!= null && oRow.get("SPL_COMP_ALLOW_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectSplCmpAllow(true);
          oEmpFinInfoHeaderBean.setHdnSplCmpAllowFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectSplCmpAllow(false);
          oEmpFinInfoHeaderBean.setHdnSplCmpAllowFlag("N");
        }
        
        if(oRow.get("OPERATIONAL_ALLOW_FLAG").getString()!= null && oRow.get("OPERATIONAL_ALLOW_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectOpAllowFlag(true);
          oEmpFinInfoHeaderBean.setHdnOpAllowFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectOpAllowFlag(false);
          oEmpFinInfoHeaderBean.setHdnOpAllowFlag("N");
        }
        if(oRow.get("PP_HINDI_FLAG").getString()!= null && oRow.get("PP_HINDI_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectPersPayHndQua(true);
          oEmpFinInfoHeaderBean.setHdnPersPayHndQuaFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectPersPayHQua(false);
          oEmpFinInfoHeaderBean.setHdnPersPayHndQuaFlag("N");
        }
        
        if(oRow.get("SPL_DTY_ALLOW_FLAG").getString()!= null && oRow.get("SPL_DTY_ALLOW_FLAG").getString().equals("Y"))
        {
          oEmpFinInfoHeaderBean.setSelectSplDtyAllow(true);
          oEmpFinInfoHeaderBean.setHdnSplDtyAllowFlag("Y");
        }
        else
        {
          oEmpFinInfoHeaderBean.setSelectSplDtyAllow(false);
          oEmpFinInfoHeaderBean.setHdnSplDtyAllowFlag("N");
        }

        oEmpFinInfoHeaderBean.setHdnBoardFlag(oRow.get("BOARD_FLG").getString());        
        oEmpFinInfoHeaderBean.setTxtDblHraCity(oRow.get("DBL_HRA_CITY").getString());        
        oEmpFinInfoHeaderBean.setTxtSplPaySprtAmt(oRow.get("SPL_PAY_SPORT_AMOUNT").getString());        
        oEmpFinInfoHeaderBean.setTxtSplPayCshAllowAmt(oRow.get("SPL_PAY_CASH_AMOUNT").getString());        
        oEmpFinInfoHeaderBean.setTxtPersPaySFNAmt(oRow.get("PERS_PAY_SFN_AMOUNT").getString());        
        oEmpFinInfoHeaderBean.setTxtPersPayHQuaAmt(oRow.get("PERS_PAY_HIGH_QUAL_AMT").getString());        
        oEmpFinInfoHeaderBean.setTxtPersPayHndQuaAmt(oRow.get("PP_HINDI_AMT").getString());        
        oEmpFinInfoHeaderBean.setTxtPersPayHndQuaNoIncr(oRow.get("PP_HINDI_NUM_INCR").getString());        
        oEmpFinInfoHeaderBean.setTxtSplCmpAllowAmt(oRow.get("SPL_COMP_ALLOW").getString());        
        oEmpFinInfoHeaderBean.setTxtAdvIncrType(oRow.get("ADV_INCR_TYPE").getString());        
        oEmpFinInfoHeaderBean.setTxtAdvIncrEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("ADV_INCR_EFF_DATE").getDate()));         
        
        //oEmpFinInfoHeaderBean.setTxtEpsFlag(oRow.get("EPS_FLAG").getString());
        //ADDED BY AMRESH
               if(oRow.get("EPS_FLAG").getString().equalsIgnoreCase("Y") || oRow.get("EPS_FLAG").getString().equalsIgnoreCase("P"))
                   oEmpFinInfoHeaderBean.setTxtEpsFlag("Y");
               else
                   oEmpFinInfoHeaderBean.setTxtEpsFlag("N");
        oEmpFinInfoHeaderBean.setTxtEpsEntDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("EPS_ENTLMNT_DT").getDate()));
        oEmpFinInfoHeaderBean.setTxtEpsSepRsn(oRow.get("EPS_SEP_REASON").getString());
        oEmpFinInfoHeaderBean.setTxtEpsSepDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("EPS_SEP_DT").getDate()));
        oEmpFinInfoHeaderBean.setTxtDblHraEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("DBL_HRA_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtDblHraEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("DBL_HRA_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplCmpAllowEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SPL_CMP_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplCmpAllowEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SPL_CMP_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplPaySprtEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SP_SPRT_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplPaySprtEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SP_SPRT_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplPayCshAllowEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SP_CASH_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplPayCshAllowEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SP_CASH_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtPersPaySFNEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PP_SFN_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtPersPaySFNEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PP_SFN_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtPersPayHQuaEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PP_HQUL_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtPersPayHQuaEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PP_HQUL_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtPersPayHndQuaEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PP_HINDI_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtPersPayHndQuaEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("PP_HINDI_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplDtyAllowEffFrom(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SPL_DTY_EFF_FROM").getDate()));
        oEmpFinInfoHeaderBean.setTxtSplDtyAllowEffTill(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SPL_DTY_EFF_TILL").getDate()));
        oEmpFinInfoHeaderBean.setTxtGradePay(oRow.get("GRADE_PAY").getString());
        oEmpFinInfoHeaderBean.setTxtSplDtyAllowArea(oRow.get("SPL_DTY_AREA_TYPE").getString());
        oEmpFinInfoHeaderBean.setPayRevFlag(oRow.get("PAY_REV_FLAG").getString()); // added by devendra
        oEmpFinInfoHeaderBean.setTxtCreationDate(oRow.get("created_date").getString()); //added by Neeraj
        oEmpFinInfoHeaderBean.setTxtCreatedBy(oRow.get("created_by").getString()); //added by Neeraj
        oEmpFinInfoHeaderBean.setTxtCreatedSite(oRow.get("created_site").getString()); //added by Neeraj
        oEmpFinInfoHeaderBean.setTxtUpdatedBy(oRow.get("updated_by").getString()); //added by Neeraj
        oEmpFinInfoHeaderBean.setTxtUpdatedSite(oRow.get("updated_site").getString()); //added by Neeraj
        oEmpFinInfoHeaderBean.setTxtUpdationDate(oRow.get("updated_date").getString()); //added by Neeraj
        oEmpFinInfoHeaderBean.setTxtCpfapproval(oRow.get("CURR_STATUS").getString());  //added by dushyant Dt 28 May 2013 
        oEmpFinInfoHeaderBean.setTxtOldCpfCode(oRow.get("OLD_CPF_CODE").getString());     //added by dushyant Dt 20 May 2013
        oEmpFinInfoHeaderBean.setTxtCasteCateg(oRow.get("CASTE_CATEGORY").getString()); 
        oEmpFinInfoHeaderBean.setTxtHandiType(oRow.get("HANDICAPPED_TYPE").getString()); 
        oEmpFinInfoHeaderBean.setTxtReligion(oRow.get("RELIGION").getString()); 
        oEmpFinInfoHeaderBean.setTxtExsrvcman(oRow.get("EX_SERVICEMEN").getString()); 
        oEmpFinInfoHeaderBean.setTxtAadharNum(oRow.get("AADHAR_NUM").getString()); 
        oEmpFinInfoHeaderBean.setTxtUanNum(oRow.get("UAN").getString()); 
        oEmpFinInfoHeaderBean.setTxtPenNum(oRow.get("PENSION_NUMBER").getString());
        oEmpFinInfoHeaderBean.setTxtFathHusflag(oRow.get("fath_hus_flag").getString());
        oEmpFinInfoHeaderBean.setTxtPenFlag(oRow.get("PENSION_DED_FLAG").getString());
          oEmpFinInfoHeaderBean.setTxtNpsFlag(oRow.get("NPS_FLAG").getString());
          oEmpFinInfoHeaderBean.setTxtPranNo(oRow.get("PRAN_NO").getString());
          oEmpFinInfoHeaderBean.setTxtMemberId(oRow.get("member_id").getString());
          oEmpFinInfoHeaderBean.setTxtPohwFlag(oRow.get("pohw_flag").getString());
          oEmpFinInfoHeaderBean.setTxtPohwEffDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("pohw_eff_date").getDate()));
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
  
  private ArrayList getEmpFinComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
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

  public EmpFinanceComboVO getEmpFinComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oConvAllowCity = null;    
    EmpFinanceComboVO oEmpFin=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
            
    oEmpFin = new EmpFinanceComboVO();  
    
    ArrayList oCategList = new ArrayList();
    oCategList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetEmpCtgry(?,?)","gbl_code","code_sdesc");
    oEmpFin.setValueCategArrayList(oCategList);                
    
    ArrayList oCadreList = new ArrayList();
    oCadreList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetCadre(?,?)","cadre_id","cadre_desc");
    oEmpFin.setValueCadreArrayList(oCadreList);
    
    ArrayList oPFTypeList = new ArrayList();
    oPFTypeList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetPFType(?,?)","pftype_id","pftype_desc");
    oEmpFin.setValuePFTypeArrayList(oPFTypeList);
    
    ArrayList oEmpStatList = new ArrayList();
    oEmpStatList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetEmpStatus(?,?)","empstatus_id","empstatus_desc");
    oEmpFin.setValueEmpStatArrayList(oEmpStatList);

    ArrayList oEmpStatAllList = new ArrayList();
    oEmpStatAllList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_GetEmpStatusLOV(?,?)","gbl_code","code_desc");
    oEmpFin.setValueEmpStatAllArrayList(oEmpStatAllList);
    
    ArrayList oParentZoneList = new ArrayList();
    oParentZoneList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetParentZone(?,?)","loc_id","loc_desc");
    oEmpFin.setValueParentZoneArrayList(oParentZoneList);
    
    ArrayList oMHSTypeList = new ArrayList();
    oMHSTypeList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_GetMHSType(?,?)","code_sdesc","code_desc");
    oEmpFin.setMhsTypList(oMHSTypeList);
    
    ArrayList oEmpSplCompList = new ArrayList();
    oEmpSplCompList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetSplCompAllow(?,?)","splcomp_id","splcomp_desc");
    oEmpFin.setValueSplCompArrayList(oEmpSplCompList);
    
    ArrayList oEmpAccomTypeList = new ArrayList();
    oEmpAccomTypeList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetAccomType(?,?)","accomtype_id","accomtype_desc");
    oEmpFin.setValueAccomTypeArrayList(oEmpAccomTypeList);

    ArrayList oEpsSepTypeList = new ArrayList();
    oEpsSepTypeList = getEmpFinComboRecords("PAYROLL_PKG_EXT.getEPSSepType(?,?)","code_sdesc","code_desc");
    oEmpFin.setEpsSepTypList(oEpsSepTypeList);
    
    ArrayList oPaySacleList = new ArrayList();
    oPaySacleList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_GetPayScaletypes(?,?)","code_desc","code_desc");
    oEmpFin.setValuePayScale(oPaySacleList);

    ArrayList oSplDtyAreaList = new ArrayList();
    oSplDtyAreaList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_getSplDutyArea(?,?)","code_sdesc","code_desc");
    oEmpFin.setSplDtyAreaList(oSplDtyAreaList);   
    ArrayList oClassificationList = new ArrayList();
    oClassificationList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_getclassificationtypes(?,?)","code","code_desc");
    oEmpFin.setClassificationList(oClassificationList);   
    
    ArrayList oCasteCategList = new ArrayList();
    oCasteCategList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_getcastecateg(?,?)","code_sdesc","code_desc");
    oEmpFin.setValueCasteCategList(oCasteCategList);   
      
    ArrayList oHandiTypeList = new ArrayList();
    oHandiTypeList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_gethanditype(?,?)","code_sdesc","code_desc");
    oEmpFin.setValueHandiTypeList(oHandiTypeList);
    
    ArrayList oReligionList = new ArrayList();
    oReligionList = getEmpFinComboRecords("PAYROLL_PKG_EXT.proc_getreligion(?,?)","code_sdesc","code_desc");
    oEmpFin.setValueReligionList(oReligionList);
    
    ArrayList oPendedList = new ArrayList();
    oPendedList = getEmpFinComboRecords("PAYROLL_PKG.proc_getpendedflag(?,?)","code_sdesc","code_desc");
    oEmpFin.setValuePenFlagArrayList(oPendedList);
    
    return oEmpFin;
  }
  
  public LovVO getEmpFinInfoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("CPf Code");  
    arylstHeaderNames.add("Employee Name");          

    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinLOV(?,?,?,?)");
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpFinLOV_new(?,?,?,?,?)");
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
     oLOVBean.setDetailField2(oRow.get("emp_no").getString());             
     oLOVBean.setDetailField3(oRow.get("EMP_FIRST_NAME").getString());            
     oLOVBean.setDetailField4(oRow.get("EMP_MIDDLE_NAME").getString());            
     oLOVBean.setDetailField5(oRow.get("EMP_LAST_NAME").getString());                              
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpLocDetail(?,?,?,?,?)");
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


  public LovVO getQueryEmpFinInfoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("First Name");    
    arylstHeaderNames.add("Middle Name");    
    arylstHeaderNames.add("Last Name");    
    arylstHeaderNames.add("CPF Code");  // added by devendra
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
     arylstVisibility.add(EnrgiseConstants.VISIBLE); // added by devendra
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
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField4())));  // added by devendra on 16th aug 2010
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));    
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpFinLOV_new(?,?,?,?,?,?,?)");  commented by devendra on 16th aug 2010
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpFinLOV_new(?,?,?,?,?,?,?,?)");  // added  by devendra on 16th aug 2010
    
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
        oLOVBean.setDetailField5(oRow.get("CPF_CODE").getString());   // added  by devendra on 16th aug 2010
      
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
      checkMandatoryDetail(oBaseHeaderBean,sScreenName,sScreenMode);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,String sScreenName, String sScreenMode) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oList = new ArrayList();
      EmpFinInfoHeaderBean oEmpFinInfoHeaderBean = (EmpFinInfoHeaderBean)oBaseHeaderBean;
      checkMaxPayYear(oEmpFinInfoHeaderBean.getTxtSiteID(),oEmpFinInfoHeaderBean.getHdnEmpLbrFlag());
      reportError(oList);
      checkFirst(oBaseHeaderBean,oList);
      checkEmpNo(oBaseHeaderBean,oList);
     
      if(sScreenMode.equals(EnrgiseConstants.NEW_MODE) || sScreenName.equals("MaintainEmpAdminFinDetailScreen") )
      {
                  
          checkEmpCurBasicLimit(oBaseHeaderBean,oList,sScreenMode);           
          
      }
      if(sScreenMode.equals(EnrgiseConstants.UPDATE_MODE))
      {
        if (oEmpFinInfoHeaderBean.getTxtInrSt().equals("R"))
        {
          checkIfPenaltyImposed(oEmpFinInfoHeaderBean.getTxtEmpNo(),oList);       // added by swapnendu Dt 04 jun 13       
        }
      }
    reportError(oList);        
  }  
  
  private void checkIfPenaltyImposed(String empNo, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo)); 
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_PENALTY.proc_checkIfPenaltyImposed(?,?,?)",true,true);
    Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
    if(errcode.intValue()!=0)
    {
        String error_msg = (String) ((DBObject)oOutArray.get(0)).getObject();
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.fpsDuplicatecheck1",oArguments));
    }
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
    EmpFinInfoHeaderBean oEmpFinInfoHeaderBean = (EmpFinInfoHeaderBean)oBaseHeaderBean;    
    String empNo = oEmpFinInfoHeaderBean.getHeaderPrimaryKey(); 
    String cpfCode=oEmpFinInfoHeaderBean.getTxtCpfCode();
    String pfType=oEmpFinInfoHeaderBean.getTxtPFType();
    String fpsNo=oEmpFinInfoHeaderBean.getTxtFpsNo();
    String panNo=oEmpFinInfoHeaderBean.getTxtPanNo();
    String parentzone=oEmpFinInfoHeaderBean.getParentZone();  // Added by dushyant for CPF check zone wise on 17-April-2013  
    String birthDate =oEmpFinInfoHeaderBean.getTxtDOB();
    String aadharNo =oEmpFinInfoHeaderBean.getTxtAadharNum();
    String uan=oEmpFinInfoHeaderBean.getTxtUanNum();
    String retDate=oEmpFinInfoHeaderBean.getTxtRetireDate();
    String PenNum=oEmpFinInfoHeaderBean.getTxtPenNum();

    if(pfType.equals("PFTYPE$CPF") ||(fpsNo!=null && !fpsNo.equals("")))
    {
  
  /*    oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo)); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oEmpFinInfoHeaderBean.getHdnEmpLbrFlag())));  //added by swapnendu Dt 06 Mar 2011
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,cpfCode)); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_EmpDuplicateCheck(?,?,?,?,?)");   */  // Commented by dushyant on 17-April-2013 
      
    // Added by dushyant for CPF check zone wise on 17-April-2013  
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo)); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oEmpFinInfoHeaderBean.getHdnEmpLbrFlag())));  
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,cpfCode));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,fpsNo)); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,parentzone));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayStatus())));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
       oOutArray = oBean.callProc(oParameters,"apps.FCI_PKG_CR_161.proc_empduplicatecheck(?,?,?,?,?,?,?,?)",true,true);

      chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
      String error_msg=(String)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
      } 
      
      // End by dushyant for CPF check zone wise on 17-April-2013  
    }
 
 /*  Commented  by dushyant on 23-may-2013
    if(fpsNo!=null && !fpsNo.equals(""))
    {
      String zonalFpsNo = getZonalFPS(oEmpFinInfoHeaderBean.getTxtEmpNo(), oEmpFinInfoHeaderBean.getParentZone(), fpsNo, oEmpFinInfoHeaderBean.getTxtCateg());
         
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,fpsNo)); //commented by swapnendu Dt 05 Oct 2011
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,zonalFpsNo)); //Added by swapnendu Dt 05 Oct 2011
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_EmpFpsDuplicateCheck(?,?,?,?)"); //commented by swapnendu Dt 14 Jun 2011
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_EmpFpsDuplicateCheck1(?,?,?,?,?)"); //added by swapnendu Dt 14 Jun 2011
      /*chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.fpsDuplicatecheck"));
      } 
      
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
    
   // added by Ankur Varshney on 21/11/2013 for stoppage of updation of BirthDate after employee is retired.
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
        
    }
	
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
    
      if(PenNum!=null && !PenNum.equals(""))
      {
        oParameters = new ArrayList();    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,empNo));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,PenNum));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_empPenNumDuplChk(?,?,?,?)",true,true);
        DBObject oOutObject = (DBObject)oOutArray.get(0);    
        String error_msg = (String)oOutObject.getObject();    
        if(error_msg!=null)
        {        
          ArrayList oArguments = new ArrayList();
          oArguments.add(new String(error_msg));
          oList.add(new EnrgiseApplicationException("payroll.EmpInfo.PenNumDuplicatecheck",oArguments));
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
    
	
	// Addition by Ankur Varshney ends.
    
  }  

  private void checkEmpCurBasicLimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList,String sScreenMode) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    //ArrayList oOutArray; 
   ArrayList oOutArray = new ArrayList(); // added by devendra
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
    EmpFinInfoHeaderBean oEmpFinInfoHeaderBean = (EmpFinInfoHeaderBean)oBaseHeaderBean;
    
    String empNo = oEmpFinInfoHeaderBean.getHeaderPrimaryKey();   
    String  payRevFlag =null;
       // added by devendra
    oParameters = new ArrayList();
    if(sScreenMode.equals(EnrgiseConstants.NEW_MODE)){
           payRevFlag = "3";
        }
    else
    {
            payRevFlag = oEmpFinInfoHeaderBean.getPayRevFlag();
        }
    
    //////////////////////// for 5th pay ccommission////////////////////////////////////////////////////////
    if(payRevFlag!=null && payRevFlag.equalsIgnoreCase("5"))
    {
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo))); 
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayType())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayScaleCode())));
         oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurtBasic())));  
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
         oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_ValidateCurBasic(?,?,?,?,?,?)");    
        
    }
    ///////////////////////////for 6th or 7th pay commission////////////////////////////////////////////////////////
   else if(payRevFlag!=null && (payRevFlag.equalsIgnoreCase("2")|| payRevFlag.equalsIgnoreCase("3")))
   {
       String payScaleCode=oEmpFinInfoHeaderBean.getTxtPayScaleCode();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayType())));
          //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnTmpPayScaleCode())));
          if (payRevFlag.equalsIgnoreCase("3") && !(payScaleCode.contains("#"))) 
                  {
                  payScaleCode=payRevFlag + '#' +oEmpFinInfoHeaderBean.getTxtPayScaleCode();
                   oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,payScaleCode));
                   }  
          else
          {
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayScaleCode())));
              }
        //  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayScaleCode())));
         oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurtBasic())));  
         oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGradePay())));  
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
         oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_ValidateCurBasic_6PC(?,?,?,?,?,?)");  //added by devendra
   }   
   
   //////// for employee maintenance information (normal )//////////////////////////////////////////////////////////////////
   else if(payRevFlag==null || payRevFlag.equalsIgnoreCase(""))
   {
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayType())));
          //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnTmpPayScaleCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayScaleCode())));
         oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurtBasic())));  
        // oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getHdnTmpGradePay())));  
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGradePay())));  
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
         oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_ValidateCurBasic_6PC(?,?,?,?,?,?)");  //added by devendra
   }   
   
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oEmpFinInfoHeaderBean.setResetFlag(new String("true"));
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
    }        
  }
  
  private void checkEmpStagIncrLimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
    EmpFinInfoHeaderBean oEmpFinInfoHeaderBean = (EmpFinInfoHeaderBean)oBaseHeaderBean;    
    if (oEmpFinInfoHeaderBean.getTxtStagInc()!=null)
    {
      String empNo = oEmpFinInfoHeaderBean.getHeaderPrimaryKey();    
      oParameters = new ArrayList();
      //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo))); commented by devendra
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayType())));
      //      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTmpPayScaleCode()))); // commented by devendra on 25-oct-2010
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtPayScaleCode()))); //// added by devendra on 25-oct-2010 
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtCurtBasic())));  
     //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTmpGradePay())));// commented by devendra on 25-oct-2010
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtGradePay())));//// added by devendra on 25-oct-2010 
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpFinInfoHeaderBean.getTxtStagInc())));   commented by devendra
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_ValidateStagIncr(?,?,?,?,?,?)");   
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);    
      String error_msg = (String)oOutObject.getObject();    
      if(error_msg!=null)
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(error_msg));
        oList.add(new EnrgiseApplicationException("payroll.EmpInfo.curBasicCheck",oArguments));
      }
    }
  }


  public LovVO getEmpMastStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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


 public LovVO getEmpMastBankCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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


  public LovVO getEmpMastBranchCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
   
  public LovVO getEmpInfoDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale Code");     
    arylstHeaderNames.add("Board Flag"); 
    arylstHeaderNames.add("Pay Band"); 
    arylstHeaderNames.add("Grade Pay"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;  
    
  
    String sDsgn,sCatgry,sPayScaleCode,sPayScaleType;
    sDsgn=oLovQueryVO.getSearchField1();
    sCatgry=oLovQueryVO.getSearchField2();
    sPayScaleCode=oLovQueryVO.getSearchField3();
   
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sDsgn));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sCatgry));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPayScaleCode));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDsgnLov(?,?,?,?,?)");
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
        oLOVBean.setDetailField7(oRow.get("PAY_BAND_NAME").getString());
        oLOVBean.setDetailField8(oRow.get("GRADE_PAY_AMT").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  // added by devendra start
   public LovVO getEmpInfoDsgnLOVDataIDA(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale/Pay Band Code");     
    arylstHeaderNames.add("Board Flag"); 
    arylstHeaderNames.add("Pay Band"); 
    arylstHeaderNames.add("Grade Pay"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;  
    
  
    String sDsgn,sCatgry,sPayScaleCode,sPayScaleType;
    sDsgn=oLovQueryVO.getSearchField1();
    sCatgry=oLovQueryVO.getSearchField2();
    sPayScaleCode=oLovQueryVO.getSearchField3();
   
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sDsgn));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sCatgry));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPayScaleCode));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetDsgnLovIDA_6pc(?,?,?,?,?)");
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
        oLOVBean.setDetailField7(oRow.get("PAY_BAND_NAME").getString());
        oLOVBean.setDetailField8(oRow.get("GRADE_PAY_AMT").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
   public LovVO getEmpInfoDsgnLOVDataCDA(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {     
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation Code");    
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category Code"); 
    arylstHeaderNames.add("Category");     
    arylstHeaderNames.add("Pay Scale/Pay Band Code");     
    arylstHeaderNames.add("Board Flag"); 
    arylstHeaderNames.add("Pay Band"); 
    arylstHeaderNames.add("Grade Pay"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;  
    
  
    String sDsgn,sCatgry,sPayScaleCode,sPayScaleType;
    sDsgn=oLovQueryVO.getSearchField1();
    sCatgry=oLovQueryVO.getSearchField2();
    sPayScaleCode=oLovQueryVO.getSearchField3();
   
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sDsgn));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sCatgry));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPayScaleCode));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetDsgnLovCDA_6pc(?,?,?,?,?)");
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
        oLOVBean.setDetailField7(oRow.get("PAY_BAND_NAME").getString());
        oLOVBean.setDetailField8(oRow.get("GRADE_PAY_AMT").getString());
        oList.add(oLOVBean);
    }    
    oLovVO.setDetailList(oList);
    return oLovVO;
  }
  //added by devendra end
  
  public LovVO getEmpInfoDsgnQryLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    
    String sDsgn,sCatgry,sPayScaleCode;
    sDsgn=oLovQueryVO.getSearchField1();
    sCatgry=oLovQueryVO.getSearchField2();
    sPayScaleCode=oLovQueryVO.getSearchField3();
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sDsgn));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sCatgry));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPayScaleCode));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDsgnLov(?,?,?,?,?)");
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
  
  public LovVO getEmpInfoSectionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
  
  public ArrayList getEmpFinVldnDetails()  throws EnrgiseSystemException, EnrgiseApplicationException 
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
        oEmpFinVldnBean.setStrFlag(oRow.get("APPL_TO").getString());        
        oEmpVldn.add(oEmpFinVldnBean);
    }
    return oEmpVldn;
  }
  
  private void checkFirst(BaseHeaderBean oBaseHeaderBean,ArrayList oList)
  {
    EmpFinInfoHeaderBean oEmpFinInfoHeaderBean = (EmpFinInfoHeaderBean)oBaseHeaderBean;
    ArrayList oArguments=new ArrayList();
    if (oEmpFinInfoHeaderBean.getTxtEmpStatus().equals("EMPSTATUS$DEPU"))
    {
        if (oEmpFinInfoHeaderBean.getTxtDepuType().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Deputation Type is Mandatory if Employee Status is Deputation");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }

  /*  if ((oEmpFinInfoHeaderBean.getTxtPayMode().equals("O") && oEmpFinInfoHeaderBean.getTxtPayModeType().equals("ESC")) || oEmpFinInfoHeaderBean.getTxtPayMode().equals("B"))
    {
        if (oEmpFinInfoHeaderBean.getTxtBankDesc().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Mandatory Field Bank Name is Empty!");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
        if (oEmpFinInfoHeaderBean.getTxtBranchCode().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Mandatory Field Branch Name is Empty!");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }    
        if (oEmpFinInfoHeaderBean.getTxtBankAccNo().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Mandatory Field Bank Account Number is Empty!");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }        
    } */   
   if (oEmpFinInfoHeaderBean.getHdnDblHraFlag().equals("Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtDblHraCity().equals("") || oEmpFinInfoHeaderBean.getTxtDblHraEffFrom().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Double Hra City is Mandatory if Double Hra is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }
    
    if (oEmpFinInfoHeaderBean.getHdnSplPaySprtFlag().equals("Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtSplPaySprtAmt().equals("") || oEmpFinInfoHeaderBean.getTxtSplPaySprtEffFrom().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Spl. Sport Amount is Mandatory if Spl Sport Pay is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }
    
    if (oEmpFinInfoHeaderBean.getHdnSplPayCshAllowFlag().equals("Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtSplPayCshAllowAmt().equals("") || oEmpFinInfoHeaderBean.getTxtSplPayCshAllowEffFrom().equals("") )
        {
            oArguments=new ArrayList();
            oArguments.add("Spl. Pay Cash Amount is Mandatory if Spl. Pay Cash is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }
    
    if (oEmpFinInfoHeaderBean.getHdnPersPaySFNFlag().equals("Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtPersPaySFNAmt().equals("") || oEmpFinInfoHeaderBean.getTxtPersPaySFNEffFrom().equals("") )
        {
              oArguments=new ArrayList();
              oArguments.add("Personal Pay SFN Amount is Mandatory if Personal Pay SFN is Yes");
              oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }
    
    if (oEmpFinInfoHeaderBean.getHdnPersPayHQuaFlag().equals("Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtPersPayHQuaAmt().equals("") || oEmpFinInfoHeaderBean.getTxtPersPayHQuaEffFrom().equals("") )
        {
            oArguments=new ArrayList();
            oArguments.add("Personal Pay High Qual. Amount is Mandatory if Personal Pay High Qual. is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }

    if (oEmpFinInfoHeaderBean.getHdnPersPayHndQuaFlag().equals("Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtPersPayHndQuaAmt().equals("") || oEmpFinInfoHeaderBean.getTxtPersPayHndQuaNoIncr().equals("") || oEmpFinInfoHeaderBean.getTxtPersPayHndQuaEffFrom().equals("") )
        {
            oArguments=new ArrayList();
            oArguments.add("Personal Pay Hindi Qual. Amount is Mandatory if Personal Pay Hindi Qual. is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }
    
    if (oEmpFinInfoHeaderBean.getHdnSplCmpAllowFlag().equals("Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtSplCmpAllowAmt().equals("") || oEmpFinInfoHeaderBean.getTxtSplCmpAllowEffFrom().equals("") )
        {
            oArguments=new ArrayList();
            oArguments.add("Spl. Comp. Amount is Mandatory if Spl Comp. Allow. is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }

    if (oEmpFinInfoHeaderBean.getTxtHandi().equals( "Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtHandiEffDate().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Handicapped Effective Date is Mandatory if Handicapped is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }

    if (oEmpFinInfoHeaderBean.getTxtEpsFlag().equals( "Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtEpsEntDt().equals(""))
        {
            oArguments=new ArrayList();
            oArguments.add("Entitlement Date is Mandatory if EPS Flag is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
    }
    
     if (oEmpFinInfoHeaderBean.getHdnSplDtyAllowFlag().equals( "Y"))
    {
        if (oEmpFinInfoHeaderBean.getTxtSplDtyAllowArea().equals("") || oEmpFinInfoHeaderBean.getTxtSplDtyAllowEffFrom().equals("") )
        {
            oArguments=new ArrayList();
            oArguments.add("Spl. Dty. Area Type is Mandatory if Spl Dty. Allow. is Yes");
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
        }
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