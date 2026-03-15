package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintInterestRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.InrRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintInrRateHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintInterestRateBean;
import FCIPAY.Payroll.UTILITY.LoanDtlsHeaderBean;
import FCIPAY.Payroll.UTILITY.LoanDtlsDetailBean;
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


public class LoanDtlsAdminBusinessObject extends BaseBO
{
  public LoanDtlsAdminBusinessObject()
  {
  }
  
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("InterestRateScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    LoanDtlsHeaderBean oLoanDtlsHeaderBean = (LoanDtlsHeaderBean)oBaseHeaderBean;
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    LoanDtlsHeaderBean oLoanDtlsHeaderBean = (LoanDtlsHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     
    return new String("");
  }


  public boolean saveMtrRdgHeader(LoanDtlsHeaderBean oMaintElecMtrRdgHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      return true;
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    if(sScreenName.equals("LoanDtlsScreen"))
   {      
      saveLoanDtls(sHeaderPrimaryKey,(LoanDtlsHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    else 
      if(sScreenName.equals("LoanAdminDtlsScreen") || sScreenName.equals("LoanDtlsAdminScreen"))
     {      
        saveLoanAdminDtls(sHeaderPrimaryKey,(LoanDtlsHeaderBean)oBaseHeaderBean,oDetailBeanArray);
      }
    
  }
  
  private void saveLoanDtls(String sPrimaryKey,LoanDtlsHeaderBean oLoanDtlsHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
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
      while(oIt.hasNext())
      {
        LoanDtlsDetailBean oLoanDtlsDetailBean = (LoanDtlsDetailBean)oIt.next();

        if(oLoanDtlsDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsHeaderBean.getTxtEmpNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanType())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsDetailBean.getSanctionDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getSanctionNo())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanAmnt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getRecStartDate())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getInstallAmnt())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getFirstInstallAmnt())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofPrnInstall())));          
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofIntInstall())));         
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getIntAmnt())));                             
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.INTEGER));
          
          oBeanInsert = new DBUtilitiesBean();
          oOutArray = oBeanInsert.callProc(oParameters,"PKG_LOAN.proc_InsertLoanDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          System.out.println("Error!!! while inserting Loan Details ::"+errCode);
          if( ! errCode.equals(new Integer(0)))
          {
             ArrayList oArguments = new ArrayList();
             oArguments.add(new String((String)oOutObject.getObject()));
             throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          } 

        }
        else if(oLoanDtlsDetailBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_LOAN.proc_UpdateLoanDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsHeaderBean.getTxtEmpNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanType())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsDetailBean.getSanctionDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getSanctionNo())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanAmnt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getRecStartDate())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getInstallAmnt())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getFirstInstallAmnt())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofPrnInstall())));          
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofIntInstall())));                    
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getTransMastId()))); 
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getIntAmnt()))); 
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtSiteID())));          
          oBean.addToBatch(oParameters);
          
        }
        else if(oLoanDtlsDetailBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_LOAN.proc_DeleteLoanDetail(?,?)");
            bDelete = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsHeaderBean.getTxtEmpNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsDetailBean.getLoanType())));                    
          oBeanDelete.addToBatch(oParameters);          
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

  private void saveLoanAdminDtls(String sPrimaryKey,LoanDtlsHeaderBean oLoanDtlsHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
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
      while(oIt.hasNext())
      {
        LoanDtlsDetailBean oLoanDtlsDetailBean = (LoanDtlsDetailBean)oIt.next();
        if(oLoanDtlsDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {       

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsHeaderBean.getTxtEmpNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanType())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsDetailBean.getSanctionDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getSanctionNo())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanAmnt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getRecStartDate())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getInstallAmnt())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getFirstInstallAmnt())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofPrnInstall())));          
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofIntInstall())));         
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getIntInstallAmnt())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getIntAmnt())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getBalPrnAmt())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getPaidInstall())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getBalInstall())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getPaidAmt())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getBalIntAmt()))); 
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.INTEGER));
          
          oBeanInsert = new DBUtilitiesBean();
          oOutArray = oBeanInsert.callProc(oParameters,"PKG_SUPER_USER_SCREEN.proc_InsertLoanAdminDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          System.out.println("Error!!! while inserting Loan Details ::"+errCode);
          if( ! errCode.equals(new Integer(0)))
          {
             ArrayList oArguments = new ArrayList();
             oArguments.add(new String((String)oOutObject.getObject()));
             throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          } 

        }
        else if(oLoanDtlsDetailBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsHeaderBean.getTxtEmpNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanType())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsDetailBean.getSanctionDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getSanctionNo())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getLoanAmnt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getRecStartDate())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getInstallAmnt())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getFirstInstallAmnt())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofPrnInstall())));          
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getNoofIntInstall())));  
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getIntInstallAmnt())));  
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getBalPrnAmt()))); 
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getPaidInstall()))); 
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getBalInstall())));     
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getPaidAmt())));        
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getIntAmnt())));    
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getBalIntAmt())));                       
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsDetailBean.getTransMastId())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(21,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(22,DBObject.OUT,ParameterTypes.INTEGER));
          
          oBean = new DBUtilitiesBean();
          oOutArray = oBean.callProc(oParameters,"PKG_SUPER_USER_SCREEN.proc_UpdateLoanAdminDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          System.out.println("Error!!! while inserting Loan Details ::"+errCode);
          if( ! errCode.equals(new Integer(0)))
          {
             ArrayList oArguments = new ArrayList();
             oArguments.add(new String((String)oOutObject.getObject()));
             throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          } 
          
        }
        else if(oLoanDtlsDetailBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_LOAN.proc_DeleteLoanDetail(?,?)");
            bDelete = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsHeaderBean.getTxtEmpNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oLoanDtlsDetailBean.getLoanType())));                    
          oBeanDelete.addToBatch(oParameters);          
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


  public RecordMetaInfo getLoanDtlsHeaderMetaInfo(LoanDtlsQueryVO oLoanDtlsQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();  
    
      ArrayList oOutArray; //Output 
      String locCode = oLoanDtlsQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanHeaderCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
  }
  
  public ArrayList getLoanDtlsHeader(LoanDtlsQueryVO oLoanDtlsQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

   if(oLoanDtlsQueryVO == null)
    {
      oLoanDtlsQueryVO = new LoanDtlsQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
   
      String locCode = oLoanDtlsQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));                
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanHeader(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     
      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      LoanDtlsHeaderBean oLoanDtlsHeaderBean;
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
          oLoanDtlsHeaderBean = new LoanDtlsHeaderBean();
          oLoanDtlsHeaderBean.setTxtEmpNo(oRow.get("EMP_NUM").getString());
          oLoanDtlsHeaderBean.setTxtEmpName(oRow.get("EMPNAME").getString());
          oLoanDtlsHeaderBean.setTxtDsgn(oRow.get("dsgn_desc").getString());
          oLoanDtlsHeaderBean.setTxtCateg(oRow.get("code_sdesc").getString());
          oLoanDtlsHeaderBean.setTxtPresentPOP(oRow.get("LOC_DESC").getString());          
          oHeaderList.add(oLoanDtlsHeaderBean);
      }     
        
    return oHeaderList;
  }
  
  public RecordMetaInfo getLoanDtlsDetailMetaInfo(String sPrimaryKey,LoanDtlsDetailInfo oLoanDtlsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      String fromdate,todate;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsDetailInfo.getTxtEmpNo()));                  
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDetailCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getLoanDtlsDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LoanDtlsDetailInfo oLoanDtlsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LoanDtlsDetailBean oLoanDtls;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oLoanDtlsDetail = null;      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsDetailInfo.getTxtEmpNo()));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDetail(?,?,?,?,?)");
      
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
            oLoanDtlsDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLoanDtls = new LoanDtlsDetailBean();
          oLoanDtls.setLoanType((oRow.get("pay_code").getString()));
          oLoanDtls.setLoanDesc((oRow.get("pay_code_desc").getString()));
          oLoanDtls.setLoanAmnt((oRow.get("loan_amount").getString()));           
          oLoanDtls.setSanctionDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("sanction_date").getDate()));
          oLoanDtls.setSanctionNo((oRow.get("SANCTION_NO").getString()));           
          oLoanDtls.setRecStartDate((oRow.get("recovery_yymm").getString()));           
          oLoanDtls.setNoofPrnInstall((oRow.get("num_principal_instls").getString())); 
          oLoanDtls.setNoofIntInstall((oRow.get("num_interest_instls").getString())); 
          oLoanDtls.setInstallAmnt((oRow.get("instal_amount").getString())); 
          oLoanDtls.setFirstInstallAmnt((oRow.get("FIRST_INSTAL_AMT").getString())); 
          oLoanDtls.setIntInstallAmnt((oRow.get("int_instal_amount").getString())); 
          oLoanDtls.setTransMastId((oRow.get("TRANSMAST_ID").getString())); 
          oLoanDtls.setStatus("Q");   
          oLoanDtls.setLoanFlag(oRow.get("loan_adv_flag").getString());
          oLoanDtlsDetail.add(oLoanDtls);
        }
  
       return oLoanDtlsDetail;
  } 

  public ArrayList getLoanAdminDtlsDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LoanDtlsDetailInfo oLoanDtlsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LoanDtlsDetailBean oLoanDtls;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oLoanDtlsDetail = null;      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsDetailInfo.getTxtEmpNo()));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_SUPER_USER_SCREEN.proc_GetLoanAdminDetail(?,?,?,?,?)");
      
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
            oLoanDtlsDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLoanDtls = new LoanDtlsDetailBean();
          oLoanDtls.setLoanType((oRow.get("pay_code").getString()));
          oLoanDtls.setLoanDesc((oRow.get("pay_code_desc").getString()));
          oLoanDtls.setLoanAmnt((oRow.get("loan_amount").getString()));           
          oLoanDtls.setSanctionDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("sanction_date").getDate()));
          oLoanDtls.setSanctionNo((oRow.get("SANCTION_NO").getString()));           
          oLoanDtls.setRecStartDate((oRow.get("recovery_yymm").getString()));           
          oLoanDtls.setNoofPrnInstall((oRow.get("num_principal_instls").getString())); 
          oLoanDtls.setNoofIntInstall((oRow.get("num_interest_instls").getString())); 
          oLoanDtls.setInstallAmnt((oRow.get("instal_amount").getString())); 
          oLoanDtls.setFirstInstallAmnt((oRow.get("FIRST_INSTAL_AMT").getString())); 
          oLoanDtls.setIntInstallAmnt((oRow.get("int_instal_amount").getString())); 
          oLoanDtls.setTransMastId((oRow.get("TRANSMAST_ID").getString())); 
          
          oLoanDtls.setBalInstall(oRow.get("bal_instal").getString());
          oLoanDtls.setBalIntAmt(oRow.get("bal_intt_amount").getString());
          oLoanDtls.setBalPrnAmt(oRow.get("bal_amt").getString());
          oLoanDtls.setIntAmnt(oRow.get("intt_amount").getString());
          oLoanDtls.setPaidAmt(oRow.get("amount_paid").getString());
          oLoanDtls.setPaidInstall(oRow.get("paid_instal").getString());
          
          oLoanDtls.setStatus("Q");   
          oLoanDtls.setLoanFlag(oRow.get("loan_adv_flag").getString());
          oLoanDtlsDetail.add(oLoanDtls);
        }
  
       return oLoanDtlsDetail;
  } 

  
  public LovVO getQueryLoanDtlsLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));       
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_QueryEmpLoanDtlLOVQ(?,?,?,?,?,?,?)");
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
        oLOVBean.setDetailField6(oRow.get("cpf_code").getString());                    
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getNewLoanDtlsLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));       
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryEmpLoanDtlLOV(?,?,?,?,?,?,?)");
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
  
  public LovVO getLoanDtlsTypeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Loan Type");    
    arylstHeaderNames.add("Loan Description"); 
    arylstHeaderNames.add("Loan Flag");  
    arylstHeaderNames.add("No Install"); 
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
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetLoanTypeLOVQ(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("loan_type").getString());            
       oLOVBean.setDetailField2(oRow.get("loan_desc").getString()); 
       oLOVBean.setDetailField3(oRow.get("loan_adv_flag").getString());
       oLOVBean.setDetailField4(oRow.get("instl_num").getString()); 
       oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    if(sScreenName.equals("LoanDtlsScreen"))
    {   
      ArrayList oList = new ArrayList();
      checkRecYYMM(oBaseHeaderBean,oDetailBeanArray, oList);
      reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  private void checkRecYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    Iterator oDtlIt=null;
    String sFlag="";
    String sRevYear="";
    String status="";
    LoanDtlsHeaderBean oLoanDtlsHeaderBean=(LoanDtlsHeaderBean)oBaseHeaderBean;
    LoanDtlsDetailBean oLoanDtlsDetailBean=null;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsHeaderBean.getHdnEmpLbrFlag())));
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
      
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    oDtlIt= oDetailBeanArray.iterator();
    while(oDtlIt.hasNext())
    {
       oLoanDtlsDetailBean=(LoanDtlsDetailBean)oDtlIt.next();
       if(oLoanDtlsDetailBean.getStatus().equals("N"))
       {
         if(status.equals("N"))
         {
           if(Integer.parseInt(oLoanDtlsDetailBean.getRecStartDate()) < Integer.parseInt(sRevYear))
           {
              ArrayList oArgs=new ArrayList();
              oArgs.add(sRevYear);
              throw new EnrgiseApplicationException("Payroll.Loan.YYMM.Error",oArgs);
           }
         }       
       }      
     }
  } 
  
  public ArrayList computeIntRate(String loanTyp,String loanAmnt,String fstInstlAmnt,String prnInstlNo,String sancDate) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oResult = new ArrayList();
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;        
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,loanTyp));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,loanAmnt));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,fstInstlAmnt));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,prnInstlNo));   
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sancDate)));      
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
      oResult.add(intInstAmt);
      oResult.add(intAmt);   
    return oResult;
  }
  
  public ArrayList computePayAdvIntRate(String loanAmnt,String empLbrFlag,String prnInstlNo, long siteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    ArrayList oResult = new ArrayList();
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;       
    String locCode = String.valueOf(siteId);
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,loanAmnt));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,prnInstlNo)); 
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,empLbrFlag));        
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
        
        oResult.add(recYYMM);
        oResult.add(instAmt);
        oResult.add(firstInstAmt);
      
    return oResult;
  }
  
}