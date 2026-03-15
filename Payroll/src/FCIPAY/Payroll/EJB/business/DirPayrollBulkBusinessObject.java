package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollBulkQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollBulkDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.DirPayrollBulkHeaderBean;
import FCIPAY.Payroll.UTILITY.DirectPayrollBulkBean;
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
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.UTILITY.MaintDirectPayrollHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintainDirectPayrollBean;

public class DirPayrollBulkBusinessObject extends BaseBO
{
  public DirPayrollBulkBusinessObject()
  {
  }
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    DirPayrollBulkHeaderBean oDirPayrollBulkHeaderBean = (DirPayrollBulkHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    
      oParameters = new ArrayList();     
      /*Employee Header Info */         
      /*oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getLoanAmnt())));          
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getSanctionDate())));          
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getSanctionNo())));          
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getRecStartDate())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getNoofPrnInstall())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getNoofIntInstall())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getInstallAmnt())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getFirstInstallAmnt())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getIntInstallAmnt())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtSiteID())));
      
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getHdnEmpLbrFlag())));  
      oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getLoanType())));          
      oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getSanctionDate())));          
      oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getSanctionNo())));          
      oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));      

      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsLoanDtlsAllDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");        
  
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();   */ return null;    
  }
  

   public RecordMetaInfo getDirPayrollBulkHeaderMetaInfo(DirPayrollBulkQueryVO oDirPayrollBulkQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String locCode = oDirPayrollBulkQueryVO.getLoginLocCode()+"";
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtPayMode())));            
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtValidFrom())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtDepoCode())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtGangId())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDirPylBulkHeaderCount(?,?,?,?,?,?,?,?,?,?)");      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getDirPayrollBulkHeader(DirPayrollBulkQueryVO oDirPayrollBulkQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oDirPayrollBulkQueryVO == null)
    {
      oDirPayrollBulkQueryVO = new DirPayrollBulkQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    String locCode = oDirPayrollBulkQueryVO.getLoginLocCode()+"";
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getHeaderPrimaryKey())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtPayMode())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtValidFrom())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtDepoCode())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkQueryVO.getTxtGangId())));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"APPS_PKG.proc_GetDirPayrollBulkHeader(?,?,?,?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      DirPayrollBulkHeaderBean oDirPayrollBulkHeaderBean;
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
          oDirPayrollBulkHeaderBean = new DirPayrollBulkHeaderBean();          
          oDirPayrollBulkHeaderBean.setHeaderPrimaryKey(oRow.get("pay_code").getString());
          oDirPayrollBulkHeaderBean.setTxtPayCodeName(oRow.get("pay_code_desc").getString());
          oDirPayrollBulkHeaderBean.setPayTxnHdrId(oRow.get("pay_payroll_txn_hdr_id").getString());
          oDirPayrollBulkHeaderBean.setTxtPayMode(oDirPayrollBulkQueryVO.getTxtPayMode().toString());          
          oDirPayrollBulkHeaderBean.setTxtPayType(oRow.get("pay_type").getString());
          oDirPayrollBulkHeaderBean.setTxtNoofDays(oRow.get("no_fo_days").getString());
          oDirPayrollBulkHeaderBean.setTxtValidFrom(oRow.get("valid_from_yymm").getString());
          oDirPayrollBulkHeaderBean.setTxtAmount(oRow.get("total_amt").getString());
          oDirPayrollBulkHeaderBean.setTxtInstAmount(oRow.get("inst_amt").getString());          
          oDirPayrollBulkHeaderBean.setTxtNoInst(oRow.get("no_of_inst").getString());
          oDirPayrollBulkHeaderBean.setTxtAdvBalance(oRow.get("bal_amount").getString());
          oDirPayrollBulkHeaderBean.setTxtAgency(oRow.get("agency_code").getString());
          oDirPayrollBulkHeaderBean.setTxtAgencyName(oRow.get("agency_code_desc").getString());
          oDirPayrollBulkHeaderBean.setTxtAgencySiteCode(oRow.get("agency_site_code").getString());                    
          oDirPayrollBulkHeaderBean.setTxtAgencySite(oRow.get("agency_site_desc").getString());
          oDirPayrollBulkHeaderBean.setTxtDepoCode(oRow.get("site_id").getString());
          oDirPayrollBulkHeaderBean.setTxtDepoName(oRow.get("site_id_desc").getString());
          oDirPayrollBulkHeaderBean.setTxtGangId(oRow.get("gang_id").getString());
          oDirPayrollBulkHeaderBean.setTxtGangName(oRow.get("gang_name").getString());
          
          oDirPayrollBulkHeaderBean.setHdnEmpLbrFlag(oDirPayrollBulkQueryVO.getHdnEmpLbrFlag());          
          oHeaderList.add(oDirPayrollBulkHeaderBean);
      }              
    return oHeaderList;
  }
  
  public RecordMetaInfo getDirPayrollBulkDetailMetaInfo(String sPrimaryKey,DirPayrollBulkDetailInfo oDirPayrollBulkDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      //oParameters = new ArrayList();
      String locCode = oDirPayrollBulkDetailInfo.getLoginLocCode()+"";
      //System.out.println(oDirPayrollBulkDetailInfo.getScreenModeFlag());           
      /*if(oDirPayrollBulkDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getNewPLIEmpDetailMetaInfo(locCode, oDirPayrollBulkDetailInfo);
      }*/
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));  
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getPayTxnHdrId())));  
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtPayMode())));  
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtValidFrom())));  
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getHdnEmpLbrFlag())));       
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDirPayrollBulkDtlCount(?,?,?,?,?,?,?,?,?)");    
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }

 public ArrayList getDirPayrollBulkDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,DirPayrollBulkDetailInfo oDirPayrollBulkDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    DirectPayrollBulkBean oDirectPayrollBulkBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oLoanDtls = null;
    String locCode = oDirPayrollBulkDetailInfo.getLoginLocCode()+"";     
      
      /*if(oDirPayrollBulkDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getNewPLIEmpDetail(locCode,lDetailFirstPosition,lDetailLastPosition,oDirPayrollBulkDetailInfo);
      }*/

      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getPayTxnHdrId())));  
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtPayMode())));  
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtValidFrom())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getHdnEmpLbrFlag())));       
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDirPayrollBulkDtl(?,?,?,?,?,?,?,?,?,?)");     
      
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
            oLoanDtls = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oDirectPayrollBulkBean = new DirectPayrollBulkBean();
          oDirectPayrollBulkBean.setTxtEmpNo((oRow.get("emp_num").getString()));          
          oDirectPayrollBulkBean.setTxtName((oRow.get("empName").getString()));
          oDirectPayrollBulkBean.setTxtDsgn((oRow.get("dsgn_desc").getString()));                                        
          oDirectPayrollBulkBean.setTxtCateg((oRow.get("CODE_SDESC").getString()));
          oDirectPayrollBulkBean.setTxtPresentPOP((oRow.get("LOC_DESC").getString()));                    
          //oDirectPayrollBulkBean.setStatus("Q");
          oLoanDtls.add(oDirectPayrollBulkBean);
        }             
        return oLoanDtls; 
  }  
  
  /*private RecordMetaInfo getNewPLIEmpDetailMetaInfo(String locCode, DirPayrollBulkDetailInfo oDirPayrollBulkDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      //System.out.println(oDirPayrollBulkDetailInfo.getScreenMode());
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getOptSelectAllEmp())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtEmpNo())));              
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtPLIYear())));              
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtPLIType())));              
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPayEmpCount(?,?,?,?,?,?,?,?)");      
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }
  
  private ArrayList getNewPLIEmpDetail(String locCode, long lDetailFirstPosition,long lDetailLastPosition,DirPayrollBulkDetailInfo oDirPayrollBulkDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    DirectPayrollBulkBean oDirectPayrollBulkBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getOptSelectAllEmp())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtEmpNo())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtPLIYear())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkDetailInfo.getTxtPLIType())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPayEmpDtl(?,?,?,?,?,?,?,?,?)");      
      
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
            oDARateDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oDirectPayrollBulkBean = new DirectPayrollBulkBean();          
          oDirectPayrollBulkBean.setTxtAllEmpNo((oRow.get("emp_num").getString()));
          oDirectPayrollBulkBean.setTxtAllEmpName((oRow.get("empName").getString()));          
          oDirectPayrollBulkBean.setTxtDesig((oRow.get("dsgn_desc").getString()));          
          oDirectPayrollBulkBean.setPrevPLIPaidAmnt((oRow.get("pli_adv_amt").getString()));
          oDirectPayrollBulkBean.setTxtPLIAmnt("");
          oDirectPayrollBulkBean.setTxtIncomTax("");
          oDirectPayrollBulkBean.setNetAmntPayble("");   
          oDirectPayrollBulkBean.setStatus("N");
          oDirPayrollBulkDetailInfo.setScreenModeFlag("false");
          oDARateDetail.add(oDirectPayrollBulkBean);
        }             
        return oDARateDetail; 
  }*/  

  public boolean savePayScaleHeader(DirPayrollBulkHeaderBean oDirPayrollBulkHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       return true;
  } 

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
      saveDirPayrollBulk(sHeaderPrimaryKey,oDetailBeanArray,(DirPayrollBulkHeaderBean)oBaseHeaderBean);   
  }   
  
 private void saveDirPayrollBulk(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,DirPayrollBulkHeaderBean oDirPayrollBulkHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters    
    ArrayList oOutArray=new ArrayList();
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
      Iterator oIt = oDetailBeanArray.iterator();
      StringBuffer empNolist = new StringBuffer("");
      String sEmpType="E";
      while(oIt.hasNext())
      {
        DirectPayrollBulkBean oDirectPayrollBulkBean = (DirectPayrollBulkBean)oIt.next();
        if(oDirectPayrollBulkBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if (empNolist.length()==0)				
            empNolist.append(new String(oDirectPayrollBulkBean.getTxtEmpNo())); 			
          else
          {
            empNolist.append(",");
            empNolist.append(new String(oDirectPayrollBulkBean.getTxtEmpNo())); 			
          }                  
        }      
      }    
      /*if(!bInsert)
        {
          oBeanInsert = new DBUtilitiesBean();
          oBeanInsert.createBatch("PAYROLL_PKG_EXT.proc_InsertLoanDetailBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          bInsert = true;
        }*/
        if (empNolist.length()==0)				
          empNolist.append(0);
          
        oParameters = new ArrayList();                    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNolist)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getHeaderPrimaryKey())));          
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtPayMode())));                  
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtPayType())));                  
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtNoofDays())));                  
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtAmount())));          
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtValidFrom())));          
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtInstAmount())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtNoInst())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtAdvBalance())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtAgency())));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtAgencySiteCode())));        
        
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtSiteID())));         
        oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getHdnEmpLbrFlag()))); 
        oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtDepoCode())));
        oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtGangId())));
        oParameters.add(new DBObject(19,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.INTEGER));
        //oBeanInsert.addToBatch(oParameters);
        
        oBeanInsert = new DBUtilitiesBean();
          oOutArray = oBeanInsert.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertDirectPayDetailBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          System.out.println("Error!!! while inserting Loan Details ::"+errCode);
          if( ! errCode.equals(new Integer(0)))
          {
             ArrayList oArguments = new ArrayList();
             oArguments.add(new String((String)oOutObject.getObject()));
             throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }        

      try
      {
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
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
  }
   
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("DARatesCDAScreen"))
    {
      sDetailTable = "lstPayScaleDtl";
    }
    initializeBO("DARateCDAScreen",sDetailTable);
  }  
  
  public LovVO getDirPayBulkEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName"); 
    arylstHeaderNames.add("Category");        
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("Present Place of Posting");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);   
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN); 
    oLovVO.setVisibilityList(arylstVisibility);
    
    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField2();

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, Name));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
    //  oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtDepoCode").trim()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtDepoCode").trim()))); 
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtGangId").trim()))); 
    //  oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtGangId").trim()));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDirectPayEmpLovN(?,?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField2(oRow.get("emp_Name").getString());   
      oLOVBean.setDetailField3(oRow.get("category").getString());                    
      oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString());                    
      oLOVBean.setDetailField5(oRow.get("LOC_DESC").getString());     
       
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  
  public LovVO getLoanDtlAllEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");        
    arylstHeaderNames.add("Category");        
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("Present Place of Posting");
    arylstHeaderNames.add("CPF Code");        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN); 
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;    
/*     DateUtility d=new DateUtility();
       String str=d.getSysDate();
       String monOfSysDate=str.substring(3,5);
       String yearOfSysDate=str.substring(6,10);
       String yyyymm=yearOfSysDate+monOfSysDate;
       System.out.println(yyyymm);  */
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));      
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetLoanDtlsExclEmpLOV(?,?,?,?,?,?,?)");
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
        
        oLOVBean.setDetailField1(oRow.get("EMP_NO").getString());            
        oLOVBean.setDetailField2(oRow.get("Name").getString());                    
        oLOVBean.setDetailField3(oRow.get("category").getString());                    
        oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString());                    
        oLOVBean.setDetailField5(oRow.get("LOC_DESC").getString());                     
        oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
        
        oList.add(oLOVBean);
      }
       
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  
  private void checkYYMM(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    DirPayrollBulkHeaderBean oDirPayrollBulkHeaderBean=(DirPayrollBulkHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oDirPayrollBulkHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oDirPayrollBulkHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");   //commented by Dushaynt Dt 02 Apr 2012
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear_DirectPay(?,?,?,?)");   //added by Dushaynt Dt 02 Apr 2012
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

      String sRevYear = "";
      String status = "";   
      String arcFlag="";
      
      oIt = oRetList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        sRevYear = oRow.get("yymm").getString(); 
        status = oRow.get("status").getString(); 
        arcFlag = oRow.get("arc_flag").getString(); 
      }

    if(arcFlag!=null && arcFlag.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }

            int iFromYear = Integer.parseInt(oDirPayrollBulkHeaderBean.getTxtValidFrom());      
            if((Integer.parseInt(sRevYear) == iFromYear  && (Integer.parseInt(status) == 2 ))  ) 
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oArguments.add(new String(sRevYear));
              oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.MonthlyPayrollRun",oArguments));
            }
            else if ((Integer.parseInt(sRevYear)  > iFromYear ))
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oArguments.add(new String(sRevYear));              
              oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.YYYYMMNotValid",oArguments));
              }         
       
      
  }

public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean);
        ArrayList oList = new ArrayList();
        chkPayCodeAllowed(oBaseHeaderBean,oDetailBeanArray,oList);//added by manish on 09-Feb-2016 to restrict entry of forbidden pay codes
        reportError(oList);//added by manish on 09-Feb-2016
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();  
    checkYYMM(oBaseHeaderBean,oList);
    reportError(oList);     
    checkPayAgencyMap(oBaseHeaderBean,oList);
     reportError(oList);     
  }

 /*private void checkDaRatHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        DirPayrollBulkHeaderBean  oDirPayrollBulkHeaderBean  = (DirPayrollBulkHeaderBean)oBaseHeaderBean;

//        System.out.println(oDirPayrollBulkHeaderBean.getHeaderMode());       
        if(oDirPayrollBulkHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtDAType())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DADuplicateCheck(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.DARate.DuplicateCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }*/


  /*private void checkDaRateGreaterHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        DirPayrollBulkHeaderBean  oDirPayrollBulkHeaderBean  = (DirPayrollBulkHeaderBean)oBaseHeaderBean;

//        System.out.println(oDirPayrollBulkHeaderBean.getHeaderMode());
        
        if(oDirPayrollBulkHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDirPayrollBulkHeaderBean.getTxtYYMM())));
          
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DaCheck(?,?,?)");
          oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yyyymm").getString(); 
              if (!sRevYear.equals("0"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(sRevYear);              
                oList.add(new EnrgiseApplicationException("Payroll.DaRate.YearCheck",oArguments));              
              }                
             }


          /* oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.DARate.GreaterCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }*/
  private void chkPayCodeAllowed(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  ArrayList payCodeList = new ArrayList();
  Iterator oIt = oDetailBeanArray.iterator();
  ArrayList oOutArray ; //Output
  ArrayList oArguments = new ArrayList();
  DBUtilitiesBean oBean = new DBUtilitiesBean(); ;
  ArrayList oParameters;
      DirPayrollBulkHeaderBean oDirPayrollBulkHeaderBean=(DirPayrollBulkHeaderBean)oBaseHeaderBean;
      System.out.println("PAYCODE IS" + oDirPayrollBulkHeaderBean.getHeaderPrimaryKey());

        oParameters = new ArrayList();
        
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oDirPayrollBulkHeaderBean.getHdnEmpLbrFlag()));  
oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oDirPayrollBulkHeaderBean.getHeaderPrimaryKey()));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC_EXT.proc_chkMDPPayCodeAllowed(?,?,?,?)",true,true);
        
         String err_msg = (String)((DBObject)oOutArray.get(0)).getObject();
         Integer err_code = (Integer)((DBObject)oOutArray.get(1)).getObject();
                     
         oOutArray = null;
         oBean = null;
         oParameters = null;
         if(err_code.intValue() != 0)
         {
             oArguments.add(err_msg);
             oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.InvalidCombiEmpAndPaycCode",oArguments));
             oArguments = null;
         }                                                                             
     
    
  
   oDirPayrollBulkHeaderBean = null;  
  }

   private void checkPayAgencyMap(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
  
    
    ArrayList oOutArray= new ArrayList();
    ArrayList oArguments = new ArrayList(); 
 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters = new ArrayList();
 
    int count=1;
    DirPayrollBulkHeaderBean oBaseHeaderBean1 = (DirPayrollBulkHeaderBean)oBaseHeaderBean;

			
					  
					 
                            if(oBaseHeaderBean1.getHeaderPrimaryKey().equals("307")||oBaseHeaderBean1.getHeaderPrimaryKey().equals("348")||oBaseHeaderBean1.getHeaderPrimaryKey().equals("507"))
                            {										
                                  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR));
                                  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean1.getHeaderPrimaryKey())));
                                  oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean1.getTxtSiteID())));
                                  oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));       
                                  oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
                                  oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_SupplierMandatoryCheck(?,?,?,?,?)");
                                  Integer m = (Integer)((DBObject)oOutArray.get(0)).getObject();
                                  count= m.intValue();
                                    oOutArray = null;
                                  if(count==0){		
                                        if(oBaseHeaderBean1.getTxtAgency().equalsIgnoreCase("") )
                                        {oArguments.add(" ");
                                      	 oList.add(new EnrgiseApplicationException("Payroll.MaintDirect.CheckMandatorySpplier",oArguments));
                                        }
                                  }										  
                            }
                        
					   
				
            
				  


     oBean = null;
    
     oBaseHeaderBean1 = null;
  }
 
  
  
  
  
}