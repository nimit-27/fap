package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspSlryRlsComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintEmpSuspensionBean;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspInvDtlsComboVO;// added by sonia on 17-10-2011

public class EmpSuspensionBusinessObject extends BaseBO 
{

  public EmpSuspensionBusinessObject()
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

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    MaintEmpSuspensionBean oEmpSuspensionBean = (MaintEmpSuspensionBean)oBaseHeaderBean;
    
    ArrayList oOutArray; //Output 
    ArrayList oAddOutArray; //Output   
    String radiosel = oEmpSuspensionBean.getRadFlg();
    if(radiosel.equals("0"))
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspId())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevSubsAllow())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevSubsEffDate())));             
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevokeType())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevokeDate())));            
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate())));      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspReason())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtUserID())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtSiteID())));       
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));        
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateEmpSuspDetail(?,?,?,?,?,?,?,?,?,?,?)");   
    }
    else
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspId())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevSubsAllow())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevSubsEffDate())));             
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevokeType())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevokeDate())));            
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate())));      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspReason())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtUserID())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtSiteID())));       
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));        
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_UpdateEmpAbscDetail(?,?,?,?,?,?,?,?,?,?,?)");   
    }
      DBObject oOutObject = (DBObject)oOutArray.get(0); 
      //return (String)oOutObject.getObject(); 
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    MaintEmpSuspensionBean oEmpSuspensionBean = (MaintEmpSuspensionBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    String radiosel = oEmpSuspensionBean.getRadFlg();
    if(radiosel.equals("0"))
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspReason())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSubsAllow())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSubsEffDate())));             
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtUserID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtSiteID()))); 
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtEmpNo())));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));     
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));      

      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertEmpSuspDetail(?,?,?,?,?,?,?,?,?,?)");    
        
        String oErrMsg = (String)((DBObject)oOutArray.get(1)).getObject();
        Integer oErrCode = (Integer)((DBObject)oOutArray.get(2)).getObject();
        if(!oErrCode.equals(new Integer(0))) 
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oErrMsg));
        //    System.out.println("Error!!! while Updating Employee ::"+oErrMsg);
            throw new EnrgiseApplicationException("Pay.Payroll_SUSPENSIONERROR",oArguments);
        }           
    }
    else
    {
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspReason())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSubsAllow())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSubsEffDate())));             
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtUserID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtSiteID()))); 
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtEmpNo())));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));     

      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_InsertEmpAbscDetail(?,?,?,?,?,?,?,?,?)",true,true);        
    }
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();      
  }


  public RecordMetaInfo getSuspensionHeaderMetaInfo(EmpSuspensionQueryVO oEmpSuspensionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();    
    ArrayList oOutArray; //Output 
    String locCode = oEmpSuspensionQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionQueryVO.getHeaderPrimaryKey()))); 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionQueryVO.getHdnEmpLbrFlag())));        
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionQueryVO.getRadFlg())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpSuspDetailCount(?,?,?,?,?,?,?)");
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;    
  }


  public ArrayList getSuspensionHeader(EmpSuspensionQueryVO oEmpSuspensionQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEmpSuspensionQueryVO == null)
    {
      oEmpSuspensionQueryVO = new EmpSuspensionQueryVO();
    }

    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;  
    String locCode = oEmpSuspensionQueryVO.getLoginLocCode()+"";
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionQueryVO.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionQueryVO.getHdnEmpLbrFlag())));           
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));    
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionQueryVO.getRadFlg())));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpSuspDetail(?,?,?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());   

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    
    MaintEmpSuspensionBean oEmpSuspensionBean;
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
        oEmpSuspensionBean = new MaintEmpSuspensionBean();
        oEmpSuspensionBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
        oEmpSuspensionBean.setTxtEmpName(oRow.get("EMP_NAME").getString());                
        oEmpSuspensionBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
        //oEmpSuspensionBean.setTxtDsgnDesc(oRow.get("DESIGNATION_ID").getString());
        oEmpSuspensionBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());
        //oEmpSuspensionBean.setTxtCategDesc(oRow.get("EMP_CATEGORY_DESC").getString());        
        oEmpSuspensionBean.setTxtEmpType(oRow.get("emp_type_desc").getString());                
        oEmpSuspensionBean.setTxtCpfCode(oRow.get("CPF_CODE").getString());
        oEmpSuspensionBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString());        
        //oEmpSuspensionBean.setTxtPresentPOP(oRow.get("PRES_LOCATION_CODE").getString());        
        oEmpSuspensionBean.setTxtDOJSite(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));
        oEmpSuspensionBean.setTxtEmpStatus(oRow.get("EMP_STATUS_DESC").getString());                  
        oEmpSuspensionBean.setSuspId(oRow.get("SUSPENSION_ID").getString());                  
        oEmpSuspensionBean.setSuspEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SUSP_EFF_DATE").getDate()));        
        oEmpSuspensionBean.setSuspReason(oRow.get("SUSP_REASON").getString());  
        oEmpSuspensionBean.setSubsAllow(oRow.get("SUBSISTENCE_ALLOWANCE").getString());          
        oEmpSuspensionBean.setSubsEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SUBS_ALLW_EFF_DATE").getDate()));                
        oEmpSuspensionBean.setRevokeDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("REVOCATION_DATE").getDate()));
        oEmpSuspensionBean.setRevokeType(oRow.get("REVOCATION_TYPE").getString());
        oEmpSuspensionBean.setRevSubsAllow(oRow.get("REVISED_SUBS_ALLOW").getString());          
        oEmpSuspensionBean.setRevSubsEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("REVISED_SUBS_ALLW_EFF_DT").getDate()));                
        oEmpSuspensionBean.setRadFlg(oRow.get("info_2").getString());          
        
        oHeaderList.add(oEmpSuspensionBean);
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
    //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sEmpNo)));
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
  
 /* private ArrayList getEmpSuspSalRlsComboRecords(String sProc, Stirng sEmpNo, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sEmpNo)));
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
  }*/

  public EmpSuspensionComboVO getEmpSuspComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpSuspensionComboVO oEmpSusp=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;   
    //String empNo ="";
    oEmpSusp = new EmpSuspensionComboVO();          
    //empNo = oEmpSusp.getHeaderPrimaryKey();
    
    ArrayList oRevokTypeList = new ArrayList();
    oRevokTypeList = getEmpFinComboRecords("PAYROLL_PKG.proc_GetRevokeTypeLov(?,?)","gbl_code","code_desc");
    oEmpSusp.setValueRevokTypeList(oRevokTypeList);
        
    return oEmpSusp;
  } 
  
  public EmpSuspSlryRlsComboVO getEmpSuspSalRlsComboDetails(EmpSuspensionQueryVO oEmpSuspensionQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpSuspSlryRlsComboVO oEmpSusp=null;
    EmpSuspensionComboVO oEmpSuspSalRls =null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
    ComboVO oComboVO=null;
    ArrayList oPayCode = null;
    //String empNo ="";
    oEmpSusp = new EmpSuspSlryRlsComboVO();          
    String empNo = oEmpSuspensionQueryVO.getHeaderPrimaryKey();
      
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getSalRlsYrMnthLov(?,?,?)");

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
      String payCodeLabel = oRow.get("code_sdesc").getString();
      String payCodeValue = oRow.get("code_desc").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      oPayCode.add(oComboVO);
    }          
    oEmpSusp.setValueSalRlsYrMnthList(oPayCode);    
    return oEmpSusp;
  } 
 
  
  
 /////added by sonia on 17-10-2011
 
 
 public EmpSuspInvDtlsComboVO getEmpSuspInvDtlsComboDetails(EmpSuspensionQueryVO oEmpSuspensionQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output     
    EmpSuspInvDtlsComboVO oEmpSusp=null;
    EmpSuspensionComboVO oEmpSuspInvDtls =null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
    ComboVO oComboVO=null;
    ArrayList oPayCode = null;
    //String empNo ="";
    oEmpSusp = new EmpSuspInvDtlsComboVO();          
    String empNo = oEmpSuspensionQueryVO.getHeaderPrimaryKey();
      
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNo)));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getInvDtlsLov(?,?,?)");
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetInvoiceYYMM(?,?,?)");

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
      String payCodeLabel = oRow.get("Inv_Num").getString();
      String payCodeValue = oRow.get("Inv_Num").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      oPayCode.add(oComboVO);
    }          
    oEmpSusp.setValueInvDtlsList(oPayCode);    
    return oEmpSusp;
  } 
 
 
 ///end
  
  public LovVO getEmpSuspensionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ FCI");  
        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));      
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpNewSuspensionLOV(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField5(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField7(oRow.get("LOC_DESC").getString());  
        oLOVBean.setDetailField8(oRow.get("EMP_STATUS_DESC").getString());          
        oLOVBean.setDetailField9(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));                      
         
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  
  
  public LovVO getQueryEmpSuspensionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Category");    
    arylstHeaderNames.add("Emp Type");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Location");    
    arylstHeaderNames.add("Emp Status");    
    arylstHeaderNames.add("DOJ FCI");  
        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));    
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("radFlg"))));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpSuspensionLOV(?,?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());            
        oLOVBean.setDetailField4(oRow.get("EMP_CATEGORY_DESC").getString());           
        oLOVBean.setDetailField5(oRow.get("emp_type_desc").getString());           
        oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());           
        oLOVBean.setDetailField7(oRow.get("LOC_DESC").getString());          
        oLOVBean.setDetailField8(oRow.get("EMP_STATUS_DESC").getString());  
        oLOVBean.setDetailField9(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("SITE_JOINING_DATE").getDate()));                       
        
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
    MaintEmpSuspensionBean oMaintEmpSuspensionBean = (MaintEmpSuspensionBean)oBaseHeaderBean;
    checkMaxPayYear(oMaintEmpSuspensionBean.getTxtSiteID(),oMaintEmpSuspensionBean.getHdnEmpLbrFlag());
   // checkDetailAbsc(oMaintEmpSuspensionBean,oList);
    reportError(oList);
    oList=new ArrayList(); 
      CheckEmpAppsUser(oMaintEmpSuspensionBean,oList);
    if((oMaintEmpSuspensionBean.getRadFlg().equals("1")))
    {
    CheckEmpBeforeAbscond(oMaintEmpSuspensionBean,oList);
    }
    
     if((oMaintEmpSuspensionBean.getRadFlg().equals("0")))
    {
    CheckEmpBeforeSuspend(oMaintEmpSuspensionBean,oList);
    }
    if((oMaintEmpSuspensionBean.getHdnEmpLbrFlag().equals("D")))
       {
         CheckDpslabourSusp(oMaintEmpSuspensionBean,oList);  // Added by dushyant on 04-dec-2012
         CheckWrkslipBeforeAbscond(oMaintEmpSuspensionBean,oList); // Added by Nand on 02-Jan-2014
       }   
   // reportError(oList);  
   /* 
    ****
	commented by vikash on 21/August/2020
	at the time of suspension employee did't get 50%(anything) the salary
   if((oMaintEmpSuspensionBean.getHdnEmpLbrFlag().equals("L")))
       {
         CheckWrkslipBeforeAbscond(oMaintEmpSuspensionBean,oList);  // Added by Nand on 02-Jan-2014
      }
	  */ 
    reportError(oList);     
  }
    private void CheckEmpAppsUser(MaintEmpSuspensionBean oEmpSuspensionBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     
       ArrayList oOutArray = new ArrayList();
     QueryRow oRow = null;
     QueryValue oValue = null;
     ArrayList oRetList = null;
     Iterator oIt = null;    
    
     
     oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtEmpNo()))); 
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
   private void CheckEmpBeforeAbscond(MaintEmpSuspensionBean oEmpSuspensionBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
      ArrayList oOutArray = new ArrayList();
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
   
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate()))); 
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CheckEmpAbscDetail(?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.Common.EmpAbscondCheck",oArguments));
    }        
    
  } //added by priyanka
 public String empSuspReleaseSalary(MaintEmpSuspensionBean oMaintEmpSuspensionBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
{                 
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;   
      String errorMsg ="";
      
      ArrayList oOutArray; //Output 

      String lUserId = String.valueOf(loginUserId);
      String lSiteId = String.valueOf(lLoginSiteId);
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpSuspensionBean.getHeaderPrimaryKey())));                   
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpSuspensionBean.getTxtYYMM())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,lUserId));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,lSiteId));       
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));      
      
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_EmpSuspRlsSalary(?,?,?,?,?,?)",true,true);        
   
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      errorMsg = (String)oOutObject.getObject();
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(errorMsg));
         System.out.println(""+errorMsg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      } 
     return errorMsg;
}

  public String revokEmp(MaintEmpSuspensionBean oEmpSuspensionBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = null; //Input Parameters
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;   
    QueryRow oRow = null;
    String sRevYear="";
    String status ="";
    ArrayList oOutArray; //Output 
    
    //max pay year check added by swapnendu Dt 21-06-2012.
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEmpSuspensionBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    ArrayList oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    Iterator oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = oRow.get("arc_flag").getString(); 
    }    
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    String radiosel = oEmpSuspensionBean.getRadFlg();
    if(radiosel.equals("0"))
    {
      oParameters = new ArrayList();       
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspId())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevSubsAllow())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevSubsEffDate())));             
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevokeType())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevokeDate())));            
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate())));      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspReason())));
      
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtUserID())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtSiteID())));       
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));        
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateEmpSuspDetail(?,?,?,?,?,?,?,?,?,?,?)");   
  }
  else
  {
  oParameters = new ArrayList();       
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspId())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevSubsAllow())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevSubsEffDate())));             
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getRevokeType())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getRevokeDate())));            
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate())));      
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getSuspReason())));
      
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtUserID())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtSiteID())));       
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));        
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_UpdateEmpAbscDetail(?,?,?,?,?,?,?,?,?,?,?)");   
  }
      //DBObject oOutObject = (DBObject)oOutArray.get(0); 
      return oEmpSuspensionBean.getHeaderPrimaryKey();
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
  
// Added by dushyant on 11-April-2013 for stopping back date suspension
 private void  CheckDpslabourSusp(MaintEmpSuspensionBean oEmpSuspensionBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
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
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtUserID())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtSiteID())));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_generatedaarrear_fci.proc_chkSusplbrArrear(?,?,?,?,?,?,?)",true,true);
    
    Integer Errorcode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
    String oErrormsg = (String)((DBObject)oOutArray.get(0)).getObject();  
    System.out.println("error_code is:::"+Errorcode+"Afetr Getting Data");
      if(Errorcode.equals(new Integer(1)))
      {  
         ArrayList oArguments = new ArrayList();    
         oArguments.add(new String(oErrormsg));
         oList.add(new EnrgiseApplicationException("Payroll.DPSARREAR.Susplbrcheck",oArguments));
      }
   
  } 
// End by dushyant

// Added by Nand on 02-Jan-2014 not allow to abscond the labour if workslip is feed for dates more than absconding date
 private void CheckWrkslipBeforeAbscond(MaintEmpSuspensionBean oEmpSuspensionBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
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
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate()))); 
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
	oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
  
    oOutArray = oBean.callProc(oParameters,"pkg_pay_labour_ext.proc_inactiveEmpCheck(?,?,?,?)",true,true);
    String oErrormsg = (String)((DBObject)oOutArray.get(0)).getObject(); 
    Integer Errorcode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
    
    //String oErrormsg=null;
    System.out.println("error_messagew is:::"+oErrormsg+"Before Saving Data For labour");
      if(Errorcode.equals(new Integer(1)))
      {  
         ArrayList oArguments = new ArrayList();    
         oArguments.add(new String(oErrormsg));
         oList.add(new EnrgiseApplicationException("payroll.Common.AbscondWrkslipCheck1",oArguments));
         //throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
      }     
  } 
   public void checkDetailAbsc( MaintEmpSuspensionBean oMaintEmpSuspensionBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = null; //Input Parameters
    ArrayList oAddressParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
  //  MaintEmpSuspensionBean oEmpSuspensionBean = new MaintEmpSuspensionBean(); 
   // ArrayList oList;    
    int count = 0;   
    QueryRow oRow = null;
    String sRevYear="";
    String status ="";
    ArrayList oOutArray; //Output 
    
    //max pay year check added by swapnendu Dt 21-06-2012.
    oParameters = new ArrayList();
   
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpSuspensionBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_abscseparationvalidation(?,?,?)");
    Integer Errorcode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
    String oErrormsg = (String)((DBObject)oOutArray.get(0)).getObject();  

    
    if(Errorcode!=null)
    {
     ArrayList oArguments = new ArrayList();  
       oArguments.add(new String(oErrormsg));
        oList.add(new EnrgiseApplicationException("payroll.Common.AbscondWrkslipCheck2",oArguments));    }
      
    
        
      //DBObject oOutObject = (DBObject)oOutArray.get(0); 
      //return oEmpSuspensionBean.getHeaderPrimaryKey();
  }
 private void CheckEmpBeforeSuspend(MaintEmpSuspensionBean oEmpSuspensionBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
      ArrayList oOutArray = new ArrayList();
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
   
    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpSuspensionBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oEmpSuspensionBean.getSuspEffDate()))); 
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"payroll_pkg.proc_CheckEmpSuspDetail(?,?,?,?)",true,true);
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);    
    String error_msg = (String)oOutObject.getObject();    
    if(error_msg!=null)
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.Common.EmpSuspendCheck",oArguments));
    }        
    
  } //added by priyanka
}
// End by Nand
