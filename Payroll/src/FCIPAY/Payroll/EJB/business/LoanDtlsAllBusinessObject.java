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
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.LoanDtlsAllHeaderBean;
import FCIPAY.Payroll.UTILITY.LoanDtlsAllDetailBean;
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

public class LoanDtlsAllBusinessObject extends BaseBO
{
  public LoanDtlsAllBusinessObject()
  {
  }
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean = (LoanDtlsAllHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    
    oParameters = new ArrayList();     
    /*Employee Header Info         
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHeaderPrimaryKey())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getLoanAmnt())));          
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getSanctionDate())));          
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getSanctionNo())));          
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getRecStartDate())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofPrnInstall())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofIntInstall())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getInstallAmnt())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getFirstInstallAmnt())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getIntInstallAmnt())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtSiteID())));
    
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHdnEmpLbrFlag())));  
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getLoanType())));          
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getSanctionDate())));          
    oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getSanctionNo())));          
    oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER)); */       
      
      
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtEmpList())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHeaderPrimaryKey())));          
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getLoanAmnt())));          
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsAllHeaderBean.getSanctionDate())));          
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getSanctionNo())));          
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getRecStartDate())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofPrnInstall())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofIntInstall())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getIntInstallAmnt())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getInstallAmnt())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getFirstInstallAmnt())));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtSiteID())));         
    oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtLocId())));
    oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtGangId())));
    oParameters.add(new DBObject(17,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.INTEGER));       

      //oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_InsLoanDtlsAllDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_InsertLoanDetailBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);        
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
      System.out.println("Error!!! while inserting Loan Details ::"+errCode);
      if( ! errCode.equals(new Integer(0)))
      {
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String((String)oOutObject.getObject()));
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }    
      return (String)oLoanDtlsAllHeaderBean.getHeaderPrimaryKey(); 
  }
  

   public RecordMetaInfo getLoanDtlsAllHeaderMetaInfo(LoanDtlsAllQueryVO oLoanDtlsAllQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String locCode = oLoanDtlsAllQueryVO.getLoginLocCode()+"";
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oLoanDtlsAllQueryVO.getSanctionDate())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllQueryVO.getSanctionNo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllHeaderCount(?,?,?,?,?,?,?,?)");      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getLoanDtlsAllHeader(LoanDtlsAllQueryVO oLoanDtlsAllQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oLoanDtlsAllQueryVO == null)
    {
      oLoanDtlsAllQueryVO = new LoanDtlsAllQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    String locCode = oLoanDtlsAllQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oLoanDtlsAllQueryVO.getSanctionDate())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllQueryVO.getSanctionNo())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllHeader(?,?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean;
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
          oLoanDtlsAllHeaderBean = new LoanDtlsAllHeaderBean();          
          oLoanDtlsAllHeaderBean.setHeaderPrimaryKey(oRow.get("loan_type").getString());
          oLoanDtlsAllHeaderBean.setLoanDesc(oRow.get("pay_code_desc").getString());
          oLoanDtlsAllHeaderBean.setSanctionDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("sanction_date").getDate()));          
          oLoanDtlsAllHeaderBean.setSanctionNo(oRow.get("sanction_no").getString());
          oLoanDtlsAllHeaderBean.setLoanAmnt(oRow.get("loan_amount").getString());
          oLoanDtlsAllHeaderBean.setRecStartDate(oRow.get("recovery_yymm").getString());
          oLoanDtlsAllHeaderBean.setInstallAmnt(oRow.get("instal_amount").getString());
          oLoanDtlsAllHeaderBean.setNoofPrnInstall(oRow.get("num_principal_instls").getString());
          oLoanDtlsAllHeaderBean.setNoofIntInstall(oRow.get("num_interest_instls").getString());
          oLoanDtlsAllHeaderBean.setIntInstallAmnt(oRow.get("int_instal_amount").getString());
          oLoanDtlsAllHeaderBean.setFirstInstallAmnt(oRow.get("first_instal_amt").getString());          
                   
          oLoanDtlsAllHeaderBean.setHdnEmpLbrFlag(oLoanDtlsAllQueryVO.getHdnEmpLbrFlag());          
          oHeaderList.add(oLoanDtlsAllHeaderBean);
      }              
    return oHeaderList;
  }
  
  public RecordMetaInfo getLoanDtlsAllDetailMetaInfo(String sPrimaryKey,LoanDtlsAllDetailInfo oLoanDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      String locCode = oLoanDtlsAllDetailInfo.getLoginLocCode()+"";
      System.out.println(oLoanDtlsAllDetailInfo.getScreenModeFlag());     
      
      /*if(oLoanDtlsAllDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getNewPLIEmpDetailMetaInfo(locCode, oLoanDtlsAllDetailInfo);
      }*/
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));  
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsAllDetailInfo.getSanctionDate()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllDetailInfo.getSanctionNo())));  
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllDetailInfo.getHdnEmpLbrFlag())));       
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllDtlCount(?,?,?,?,?,?,?,?)");    
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }

 public ArrayList getLoanDtlsAllDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LoanDtlsAllDetailInfo oLoanDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LoanDtlsAllDetailBean oLoanDtlsAllDetailBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oLoanDtls = null;
    String locCode = oLoanDtlsAllDetailInfo.getLoginLocCode()+"";
     
      
      /*if(oLoanDtlsAllDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getNewPLIEmpDetail(locCode,lDetailFirstPosition,lDetailLastPosition,oLoanDtlsAllDetailInfo);
      }*/

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToSqlDate(oLoanDtlsAllDetailInfo.getSanctionDate())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllDetailInfo.getSanctionNo())));          
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllDetailInfo.getHdnEmpLbrFlag())));       
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllDtl(?,?,?,?,?,?,?,?,?)");     
      
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
          oLoanDtlsAllDetailBean = new LoanDtlsAllDetailBean();
          oLoanDtlsAllDetailBean.setTxtEmpNo((oRow.get("emp_num").getString()));          
          oLoanDtlsAllDetailBean.setTxtEmpName((oRow.get("empName").getString()));
          oLoanDtlsAllDetailBean.setTxtDsgn((oRow.get("dsgn_desc").getString()));                                        
          oLoanDtlsAllDetailBean.setTxtCateg((oRow.get("CODE_SDESC").getString()));
          oLoanDtlsAllDetailBean.setTxtPresentPOP((oRow.get("LOC_DESC").getString()));                    
          //oLoanDtlsAllDetailBean.setStatus("Q");
          oLoanDtls.add(oLoanDtlsAllDetailBean);
        }             
        return oLoanDtls; 
  }  
  
 
  public boolean savePayScaleHeader(LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       return true;
  } 

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
      saveLoanDtlsAll(sHeaderPrimaryKey,oDetailBeanArray,(LoanDtlsAllHeaderBean)oBaseHeaderBean);   
  }   
  
 private void saveLoanDtlsAll(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
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
        LoanDtlsAllDetailBean oLoanDtlsAllDetailBean = (LoanDtlsAllDetailBean)oIt.next();
        if(oLoanDtlsAllDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if (empNolist.length()==0)				
            empNolist.append(new String(oLoanDtlsAllDetailBean.getTxtEmpNo())); 			
          else
          {
            empNolist.append(",");
            empNolist.append(new String(oLoanDtlsAllDetailBean.getTxtEmpNo())); 			
          }                  
        }      
      }    
      /*if(!bInsert)
        {
          oBeanInsert = new DBUtilitiesBean();
          oBeanInsert.createBatch("PKG_LOAN.proc_InsertLoanDetailBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          bInsert = true;
        }*/
        if (empNolist.length()==0)				
          empNolist.append(0);
          
        oParameters = new ArrayList();                    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNolist)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHeaderPrimaryKey())));          
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getLoanAmnt())));          
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsAllHeaderBean.getSanctionDate())));          
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getSanctionNo())));          
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getRecStartDate())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofPrnInstall())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofIntInstall())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getIntInstallAmnt())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getInstallAmnt())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getFirstInstallAmnt())));
        
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtSiteID())));         
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHdnEmpLbrFlag())));  
        oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));
        //oBeanInsert.addToBatch(oParameters);
        
        oBeanInsert = new DBUtilitiesBean();
          oOutArray = oBeanInsert.callProc(oParameters,"PKG_LOAN.proc_InsertLoanDetailBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
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

  
  public LovVO getLoanDtlAllEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");            
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("Category");        
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
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));      
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsExclEmpLOV(?,?,?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());               
        oLOVBean.setDetailField4(oRow.get("category").getString());                    
        oLOVBean.setDetailField5(oRow.get("LOC_DESC").getString());                     
        oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
        
        oList.add(oLOVBean);
      }
       
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   if(bHeaderDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray,sScreenMode);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, String sScreenMode) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();  
    checkYYMM(oBaseHeaderBean,oList);
    //validateFestivalAdvDtls(oBaseHeaderBean, oDetailBeanArray ,oList,sScreenMode);
    reportError(oList);     
    
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
    LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean=(LoanDtlsAllHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLoanDtlsAllHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");                 
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

        int iFromYear = Integer.parseInt(oLoanDtlsAllHeaderBean.getRecStartDate());      
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
          oList.add(new EnrgiseApplicationException("Payroll.MaintLoanDtlBulk.YYYYMMNotValid",oArguments));
        }
  }
  
  private void validateFestivalAdvDtls(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList,String sScreenMode) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;
    LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean=(LoanDtlsAllHeaderBean)oBaseHeaderBean;    
        
    Integer chkFlag=new Integer(0);
    String errMsg="";
    StringBuffer empNolist = new StringBuffer("");    
        
    if(sScreenMode.equals(EnrgiseConstants.NEW_MODE))
    {
      if (empNolist.length()==0)				
        empNolist.append(new String(oLoanDtlsAllHeaderBean.getTxtEmpList())); 			
      else
      {
        empNolist.append(",");
        empNolist.append(new String(oLoanDtlsAllHeaderBean.getTxtEmpList())); 			
      }                  
    }          
    
    if (empNolist.length()==0)				
      empNolist.append(0);      
      
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getLoanType())));                                 
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(empNolist)));                                 
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR));        
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));        
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_ValidateFestiveAdvBulk(?,?,?,?)",true,true);            
    chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
    errMsg=(String)((DBObject)oOutArray.get(0)).getObject();
    if(!chkFlag.equals(new Integer(0)))
    {
      ArrayList oArguments=new ArrayList();
      oArguments.add(errMsg);
      oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
    }             
  }
  
  public LoanDtlsAllHeaderBean computeIntRate(LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;    
    if(oLoanDtlsAllHeaderBean.getLoanFlag().equals("P"))
    {
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getLoanAmnt()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getNoofPrnInstall())); 
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getTxtSiteID())); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getHdnEmpLbrFlag()));        
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); //First Installment
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR)); //Installment Amt
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); //Rec Start Date
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_AdjustInstlAmt(?,?,?,?,?,?,?,?,?)",true,true);
      
        String firstInstAmt = (String)((DBObject)oOutArray.get(0)).getObject();
        String instAmt = (String)((DBObject)oOutArray.get(1)).getObject();
        String recYYMM = (String)((DBObject)oOutArray.get(2)).getObject();
        String errMsg=(String)((DBObject)oOutArray.get(3)).getObject();
        Integer errCode= (Integer)((DBObject)oOutArray.get(4)).getObject();
        if(!errCode.equals(new Integer(0)))
        {
          ArrayList oArgs=new ArrayList();
          oArgs.add(errMsg);
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArgs);
        }
        
        oLoanDtlsAllHeaderBean.setFirstInstallAmnt(firstInstAmt);
        oLoanDtlsAllHeaderBean.setInstallAmnt(instAmt);
        oLoanDtlsAllHeaderBean.setRecStartDate(recYYMM);
    }
    else
    {
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getLoanType()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getLoanAmnt()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getFirstInstallAmnt()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getNoofPrnInstall()));   
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsAllHeaderBean.getSanctionDate())));      
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_CompBFundLoanInttAmt(?,?,?,?,?,?,?,?,?)",true,true);
      
        String intAmt = (String)((DBObject)oOutArray.get(0)).getObject();
        String intInstAmt = (String)((DBObject)oOutArray.get(1)).getObject();
        String errMsg=(String)((DBObject)oOutArray.get(2)).getObject();
        Integer errCode= (Integer)((DBObject)oOutArray.get(3)).getObject();
        if(!errCode.equals(new Integer(0)))
        {
          ArrayList oArgs=new ArrayList();
          oArgs.add(errMsg);
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArgs);
        }
        
        oLoanDtlsAllHeaderBean.setIntInstallAmnt(intInstAmt);
        oLoanDtlsAllHeaderBean.setIntAmnt(intAmt);
    }
        return oLoanDtlsAllHeaderBean;
      //  return intAmt;
  }  
  //Added by Nand on 14 Aug 2013 For Location/Gang Wise Emp Exclusion
  public LovVO getLoanDtlAllDepotEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");            
    arylstHeaderNames.add("Category");        
    arylstHeaderNames.add("Designation");    
    arylstHeaderNames.add("Present Place of Posting");
    //arylstHeaderNames.add("CPF Code");        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN); 
    //arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtLocId").trim())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtGangId").trim())));            
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
        oLOVBean.setDetailField4(oRow.get("category").getString());                    
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());               
        oLOVBean.setDetailField5(oRow.get("LOC_DESC").getString());                     
        //oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
        
        oList.add(oLOVBean);
      }
       
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
}