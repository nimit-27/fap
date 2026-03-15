package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MaintPFDetailHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintPfDetailBean;
import FCIPAY.Payroll.UTILITY.MaintDARateBean;
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
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPfDtlComboVO;
import FCIPAY.Payroll.UTILITY.PfAdjustHistoryBean;
import FCIPAY.Payroll.UTILITY.PfAdjustHistoryBeanDtl;
public class MaintPFDtlBusinessObject extends BaseBO 
{
  public MaintPFDtlBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("pfDetailScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintPFDetailHeaderBean oMaintPFDetailHeaderBean = (MaintPFDetailHeaderBean)oBaseHeaderBean;

      if (oMaintPFDetailHeaderBean.getScreenModePay1().equals("N"))
      {
        saveNewHeaderImpl(oBaseHeaderBean);
      }
      else
      {
              ArrayList oOutArray; //Output 

              oParameters = new ArrayList();
             // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtPFAcctNo())));
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtToYear())));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpOpnCon())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpOpnInt())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprOpnCon())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprOpnInt())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpCloCon())));
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpCloInt())));
              oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprCloCon())));
              oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprCloInt())));
        //      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpInSub())));
        //      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprInCon())));
        //      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVolInPf())));
        //      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmpInSubDate())));
        //      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmprInConDate())));
        //      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtVolInPFDate())));
        //      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpOutSub())));
        //      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprOutCon())));
        //      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVolOutPf())));
        //      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmpOutSubDate())));
        //      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmprOutConDate())));
        //      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtVolOutPFDate())));
        //      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getHeaderPrimaryKey())));
              oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
              oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
              
              oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFOpnPf())));
              oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFCloPf())));
              oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFOpnInt())));
              oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFCloInt())));
        //next 4 parameters are required for adjust header record history table.
              oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtAdjTypeHdr())));
              oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtPayMode())));
              oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtAdjAmtHdr())));
              oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtRmrkHdr())));
              
              oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtUserID())));
              oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtSiteID())));              
                
              // Out variable added by gagan on 18-05-2013
              oParameters.add(new DBObject(22,DBObject.OUT,ParameterTypes.VARCHAR));
              oParameters.add(new DBObject(23,DBObject.OUT,ParameterTypes.INTEGER));
              oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_UpdatePFHdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
               DBObject oOutObject = (DBObject)oOutArray.get(1);
               Integer errCode = (Integer)(oOutObject.getObject());
      
              oOutObject = (DBObject)oOutArray.get(0);
              String errMsg = (String)(oOutObject.getObject());
             // added by gagan on 16-05-2013  
             if(!errCode.equals(new Integer(0)))
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(errMsg);
              throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }
              // addition ended by gagan on 16-05-2013
      }
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
  // Commented by Balpreet Dt 15-Feb 2008 Not required....
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintPFDetailHeaderBean oMaintPFDetailHeaderBean = (MaintPFDetailHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtToYear())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpOpnCon())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpOpnInt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprOpnCon())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprOpnInt())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpCloCon())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpCloInt())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprCloCon())));
      oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprCloInt())));
//      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpInSub())));
//      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprInCon())));
//      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVolInPf())));
//      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmpInSubDate())));
//      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmprInConDate())));
//      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtVolInPFDate())));
//      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpOutSub())));
//      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmprOutCon())));
//      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVolOutPf())));
//      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmpOutSubDate())));
//      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtEmprOutConDate())));
//      oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintPFDetailHeaderBean.getTxtVolOutPFDate())));
      oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFOpnPf())));
      oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFCloPf())));
      oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFOpnInt())));
      oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtVPFCloInt())));
//next 4 parameters are required for adjust header record history table.
      oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtAdjTypeHdr())));
      oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtPayMode())));
      oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtAdjAmtHdr())));
      oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtRmrkHdr())));
      oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(22,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(23,DBObject.OUT,ParameterTypes.INTEGER));
      // Out variable added by gagan on 18-05-2013
      oParameters.add(new DBObject(24,DBObject.OUT,ParameterTypes.VARCHAR));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_InsertPFHdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
// added by gagan on 16-05-2013  
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      Integer errCode = (Integer)(oOutObject.getObject());
      
      oOutObject = (DBObject)oOutArray.get(1);
      String errMsg = (String)(oOutObject.getObject());
        if(!errCode.equals(new Integer(0)))
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(errMsg);
              throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }
    // addition ended by gagan on 16-05-2013
      return (String)oOutObject.getObject();
    
 //  return null;   
  }

  public RecordMetaInfo getPFDetailHeaderMetaInfo(MaintPFDetailQueryVO oMaintPFDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();

    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintPFDetailQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailQueryVO.getTxtFromYear())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailQueryVO.getTxtPfType())));       
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPFDtlCount(?,?,?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;    
  }

  public ArrayList getPFDetailHeader(MaintPFDetailQueryVO oMaintPFDetailQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintPFDetailQueryVO == null)
    {
      oMaintPFDetailQueryVO = new MaintPFDetailQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintPFDetailQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailQueryVO.getTxtFromYear())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailQueryVO.getTxtPfType())));      
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPFDtlDetail(?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintPFDetailHeaderBean oMaintPFDetailHeaderBean;
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
          oMaintPFDetailHeaderBean = new MaintPFDetailHeaderBean();
          oMaintPFDetailHeaderBean.setTxtEmpNo(oRow.get("emp_num").getString());
          oMaintPFDetailHeaderBean.setTxtEmpName(oRow.get("name").getString());
          oMaintPFDetailHeaderBean.setTxtPFAcctNo(oRow.get("cpf_code").getString());
          oMaintPFDetailHeaderBean.setTxtFromYear(oRow.get("from_year").getString());
          oMaintPFDetailHeaderBean.setTxtToYear(oRow.get("to_year").getString()); 
          oMaintPFDetailHeaderBean.setTxtPfType(oRow.get("emp_pf_type").getString());           
        
          oMaintPFDetailHeaderBean.setTxtEmpOpnCon(oRow.get("employee_pf_open_bal").getString());                    
          oMaintPFDetailHeaderBean.setTxtEmpOpnInt(oRow.get("employee_pf_open_int_bal").getString());                              
          oMaintPFDetailHeaderBean.setTxtEmprOpnCon(oRow.get("employer_pf_open_bal").getString());                    
          oMaintPFDetailHeaderBean.setTxtEmprOpnInt(oRow.get("employer_pf_open_int_bal").getString());                              
          oMaintPFDetailHeaderBean.setTxtVPFOpnPf(oRow.get("VPF_OPEN_BAL").getString());                    
          oMaintPFDetailHeaderBean.setTxtVPFOpnInt(oRow.get("VPF_OPEN_INT_BAL").getString());                    
          oMaintPFDetailHeaderBean.setTxtVPFCloPf(oRow.get("VPF_CLOSE_BAL").getString());                              
          oMaintPFDetailHeaderBean.setTxtVPFCloInt(oRow.get("VPF_CLOSE_INT_BAL").getString());                              

          oMaintPFDetailHeaderBean.setTxtEmpCloCon(oRow.get("employee_pf_close_bal").getString());                    
          oMaintPFDetailHeaderBean.setTxtEmpCloInt(oRow.get("employee_pf_close_int_bal").getString());                              
          oMaintPFDetailHeaderBean.setTxtEmprCloCon(oRow.get("employer_pf_close_bal").getString());                    
          oMaintPFDetailHeaderBean.setTxtEmprCloInt(oRow.get("employer_pf_close_int_bal").getString());                              

          oMaintPFDetailHeaderBean.setTxtEmpInSub(oRow.get("employee_subs_trans_in_amt").getString());                                        
          oMaintPFDetailHeaderBean.setTxtEmprInCon(oRow.get("employer_cont_trans_in_amt").getString());                                                  
          oMaintPFDetailHeaderBean.setTxtVolInPf(oRow.get("vpf_trans_in_amt").getString());                                                  
          
          oMaintPFDetailHeaderBean.setTxtEmpInSubDate(EnrgiseUtil.convertToString(oRow.get("employee_subs_trans_in_date").getDate()));                                        
          oMaintPFDetailHeaderBean.setTxtEmprInConDate(EnrgiseUtil.convertToString(oRow.get("employer_cont_trans_in_date").getDate()));                                                  
          oMaintPFDetailHeaderBean.setTxtVolInPFDate(EnrgiseUtil.convertToString(oRow.get("vpf_trans_in_date").getDate()));  

          oMaintPFDetailHeaderBean.setTxtEmpOutSub(oRow.get("employee_subs_trans_out_amt").getString());                                        
          oMaintPFDetailHeaderBean.setTxtEmprOutCon(oRow.get("employer_cont_trans_out_amt").getString());                                                  
          oMaintPFDetailHeaderBean.setTxtVolOutPf(oRow.get("vpf_trans_out_amt").getString());                                                  
          oMaintPFDetailHeaderBean.setTxtEmpOutSubDate(EnrgiseUtil.convertToString(oRow.get("employee_subs_trans_out_date").getDate()));                                        
          oMaintPFDetailHeaderBean.setTxtEmprOutConDate(EnrgiseUtil.convertToString(oRow.get("employer_cont_trans_out_date").getDate()));                                                  
          oMaintPFDetailHeaderBean.setTxtVolOutPFDate(EnrgiseUtil.convertToString(oRow.get("vpf_trans_out_date").getDate()));                                                  

          oHeaderList.add(oMaintPFDetailHeaderBean);
      }
    return oHeaderList;
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    
  if(sScreenName.equals("pfDetailScreen"))
    {
        savePFDtl(sHeaderPrimaryKey,oDetailBeanArray,(MaintPFDetailHeaderBean)oBaseHeaderBean); //uncommented by swapnendu on 07 Jan 2011.
    }
  }   

  private void savePFDtl(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,MaintPFDetailHeaderBean oMaintPFDetailHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBean1 = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
      Iterator oIt = oDetailBeanArray.iterator();
      checkInterestCalc(oMaintPFDetailHeaderBean);
      while(oIt.hasNext())
      {
        MaintPfDetailBean oMaintPfDetailBean = (MaintPfDetailBean)oIt.next();
        if(oMaintPfDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPFDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtYearMon())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtEmpSub())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtEmpCon())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtVolPf())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAdvAmtEmpSub())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAdvAmtVpf())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtRefAdv())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtExtraVpf())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAmtWithDrwEmp())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAmtWithDrwEmpr())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAmtWithDrwVpf())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtEPS())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtPfArrear())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtAdvDate()))));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtAdvRefDate()))));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtWithDate()))));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtBonToPfDate()))));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtBonusToPf())));
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
       /*else if(oMaintPfDetailBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdatePFDtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtYearMon())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtEmpSub())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtEmpCon())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtVolPf())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAdvAmtEmpSub())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAdvAmtVpf())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtRefAdv())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtExtraVpf())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAmtWithDrwEmp())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAmtWithDrwEmpr())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtAmtWithDrwVpf())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtEPS())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtPfArrear())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtAdvDate()))));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtAdvRefDate()))));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtWithDate()))));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintPfDetailBean.getTxtBonToPfDate()))));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtBonusToPf())));
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtSiteID())));
        
          oBean.addToBatch(oParameters);
          
        }
     else if(oMaintPfDetailBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePFDetail(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtYearMon())));
          oBeanDelete.addToBatch(oParameters);          
        }*/
      }
//adding detail history
    ArrayList oOutArray = new ArrayList();
    oParameters = new ArrayList();
    oBean1 = new DBUtilitiesBean();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtYYMMDtl())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtAdjTypeDtl())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtPayModeDtl())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtAdjAmtDtl())));      
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtRmrkDtl())));      
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtSiteID())));
    
    // Out variable added by gagan on 29-05-2013
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean1.callProc(oParameters,"PKG_PAYROLL_MISC.INSERT_PAY_EMP_PF_DTL_ADJ(?,?,?,?,?,?,?,?,?,?,?)",true,true);
    // added by gagan on 29-05-2013  
      DBObject oOutObject = (DBObject)oOutArray.get(1);
      Integer errCode = (Integer)(oOutObject.getObject());
      
      oOutObject = (DBObject)oOutArray.get(0);
      String errMsg = (String)(oOutObject.getObject());
        if(!errCode.equals(new Integer(0)))
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(errMsg);
              throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }
    // addition ended by gagan on 29-05-2013
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
  //     oBasicArrearHeaderBean.setScreenModePay1("U");     
  }


  public LovVO getPFDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Cpf Code");    
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
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPFDetailLOV(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("empName").getString());            
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getQueryPFDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("Cpf Code");    
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
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryPFDetailLOV(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("empName").getString());            
       oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
   
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   checkInterestCalc(oBaseHeaderBean);  //if interest is calculated for this employee, no modification is allowed.
   if (sScreenMode.equals("N")) checkMandatoryDetail(oBaseHeaderBean); //if entry already done for that employee in that financial year then, do not enter.
   if(bDetailDataChanged)
    {
        //checkMandatoryDetail(oBaseHeaderBean);
        checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
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
    checkPFDtlHeader(oBaseHeaderBean,oList);
    reportError(oList);
    
  }

 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    checkPFYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList);
  }
    private void checkInterestCalc(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        ArrayList oList = new ArrayList();
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oRetList = null;
        Iterator oIt = null;
        
        MaintPFDetailHeaderBean  oMaintPFDetailHeaderBean  = (MaintPFDetailHeaderBean)oBaseHeaderBean;
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CHK_IF_INTEREST_CALC(?,?,?,?)");
        
        oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oRetList.size() > 0)
        {        
            ArrayList oArguments = new ArrayList();
            oList.add(new EnrgiseApplicationException("Payroll.PF.IfInterestCalc",EnrgiseConstants.MESSAGE));
        }
        reportError(oList);
    }

 private void checkPFDtlHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      MaintPFDetailHeaderBean  oMaintPFDetailHeaderBean  = (MaintPFDetailHeaderBean)oBaseHeaderBean;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PFHdrDuplicateCheck(?,?,?,?)");
  
       oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oRetList.size() > 0)
        {        
          ArrayList oArguments = new ArrayList();
          oList.add(new EnrgiseApplicationException("Payroll.PFEmpNoFromYr.DuplicateCheck",EnrgiseConstants.MESSAGE));
        }
  }

  
private void checkPFYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintPfDetailBean oMaintPfDetailBean = (MaintPfDetailBean)oIt.next();
//        System.out.println(oMaintPfDetailBean.getStatus());
        MaintPFDetailHeaderBean  oMaintPFDetailHeaderBean  = (MaintPFDetailHeaderBean)oBaseHeaderBean;
        if(!(oMaintPfDetailBean.getStatus().equals("D")))
          count++;


        if(oMaintPfDetailBean.getStatus().equals("N"))    
        {
          String yymm = oMaintPfDetailBean.getTxtYearMon();
          String empno = oMaintPFDetailHeaderBean.getTxtEmpNo();
          String fromyr = oMaintPFDetailHeaderBean.getTxtFromYear();
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPfDetailBean.getTxtYearMon())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPFDetailHeaderBean.getTxtFromYear())));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PfYYMMCheck(?,?,?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));

          //  oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
 
           oList.add(new EnrgiseApplicationException("Payroll.PFDtlYYMM.duplicatecheck",oArguments));
            }
        }
      }
  }

public RecordMetaInfo getPFDetailMetaInfo(String sPrimaryKey,MaintPFDetailInfo oMaintPFDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

        String sEmpNo;
        String sFromYear;
        sEmpNo = oMaintPFDetailInfo.getTxtEmpNo(); 
        sFromYear = oMaintPFDetailInfo.getTxtFromYear(); 
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sEmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sFromYear));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPFDetailCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }

 public ArrayList getPFDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,MaintPFDetailInfo oMaintPFDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPfDetailBean oPFDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPFDetail = null;

        String sEmpNo;
       String sFromYear;
       sEmpNo = oMaintPFDetailInfo.getTxtEmpNo(); 
       sFromYear = oMaintPFDetailInfo.getTxtFromYear(); 
        
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sEmpNo));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sFromYear));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oMaintPFDetailInfo.getSiteId())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPFDetail(?,?,?,?,?,?,?)");
      
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
            oPFDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oPFDtl = new MaintPfDetailBean();
            oPFDtl.setTxtYearMon(oRow.get("YYYYMM").getString());
            oPFDtl.setTxtEmpSub(oRow.get("EMPLOYEE_SUBS").getString());
            oPFDtl.setTxtEmpCon(oRow.get("EMPLOYER_CONT").getString());
            oPFDtl.setTxtVolPf(oRow.get("VPF").getString());
            oPFDtl.setTxtAdvAmtEmpSub(oRow.get("ADV_TAKEN").getString());
            oPFDtl.setTxtAdvAmtVpf(oRow.get("ADV_TAKEN_VPF").getString());
            oPFDtl.setTxtRefAdv(oRow.get("ADV_REFUND").getString());
            oPFDtl.setTxtAdvDate(EnrgiseUtil.convertToString(oRow.get("adv_taken_date").getDate()));
            oPFDtl.setTxtAdvRefDate(EnrgiseUtil.convertToString(oRow.get("adv_refund_date").getDate()));
            oPFDtl.setTxtBonToPfDate(EnrgiseUtil.convertToString(oRow.get("bonus_to_pf_date").getDate()));
            oPFDtl.setTxtBonusToPf(oRow.get("bonus_to_pf").getString());
            oPFDtl.setTxtPfArrear(oRow.get("pf_arrear").getString());                                                                           
            oPFDtl.setTxtWithDate(EnrgiseUtil.convertToString(oRow.get("wid_date").getDate()));
            oPFDtl.setTxtExtraVpf(oRow.get("EXTRA_VPF").getString());
            oPFDtl.setTxtAmtWithDrwEmp(oRow.get("AMT_WITHDRAWN").getString());
            oPFDtl.setTxtAmtWithDrwEmpr(oRow.get("AMT_WITHDRAWN_EMPLR").getString());
            oPFDtl.setTxtAmtWithDrwVpf(oRow.get("AMT_WITHDRAWN_VPF").getString());
            oPFDtl.setTxtEPS(oRow.get("EPS").getString());
            //oPFDtl.setTxtPayMon(oRow.get("pay_yymm").getString());
            oPFDtl.setStatus("Q");
            
            oPFDetail.add(oPFDtl);
        }             
        return oPFDetail; 
  }    


public LovVO getPFFromYrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("FromYear");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPfFromYrLov(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("from_year").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


   public LovVO getInsertPFDetailEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryPFDetailLOV(?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("empName").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public MaintPfDtlComboVO getPfDetailCombo() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    MaintPfDtlComboVO oMaintPfDtlComboVO = new MaintPfDtlComboVO();
    int count = 0;
    ArrayList oOutArray; //Output

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ComboVO oComboVO = null;

    oList = new ArrayList();
    oList = getComboRecords("PKG_PAYROLL_MISC.proc_PF_ADJUST_HDR_COMBO(?,?)","gbl_code","code_desc");
    oMaintPfDtlComboVO.setAdjPfHdrList(oList);
    
    oList = new ArrayList();
    oList = getComboRecords("PKG_PAYROLL_MISC.proc_PF_ADJUST_DTL_COMBO(?,?)","gbl_code","code_desc");
    oMaintPfDtlComboVO.setAdjPfDtlList(oList);
    
    return oMaintPfDtlComboVO;
  }
  
  private ArrayList getComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
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
    public ArrayList getPfAdjustHistoryHdr(MaintPFDetailQueryVO oMaintPFDetailQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters = new ArrayList();
        ArrayList oOutArray;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        QueryRow oRow = null;    
        int count = 0;
        PfAdjustHistoryBean oPfAdjustHistoryBean;
        ArrayList adjHistList = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPFDetailQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPFDetailQueryVO.getTxtFromYear())));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_Get_PAY_EMP_PF_HDR_ADJ(?,?,?,?)");
        
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {
            return null;
            //throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
            if(count == 0)
            {
                adjHistList = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();
            oPfAdjustHistoryBean = new PfAdjustHistoryBean();
            oPfAdjustHistoryBean.setTxtAdjHdrId((oRow.get("PF_HDR_ID").getString()));
            oPfAdjustHistoryBean.setTxtAdjTypeHdr1((oRow.get("CODE_DESC").getString()));
            oPfAdjustHistoryBean.setTxtPayMode1((oRow.get("PAY_MODE").getString()));
            oPfAdjustHistoryBean.setTxtAdjAmtHdr1((oRow.get("ADJUST_AMT").getString()));
            oPfAdjustHistoryBean.setTxtRmrkHdr1((oRow.get("REMARK").getString()));
            oPfAdjustHistoryBean.setTxtModDtHdr((oRow.get("modified_dt").getString()));
            adjHistList.add(oPfAdjustHistoryBean);
        }             
        return adjHistList; 
    }
    public ArrayList getPfAdjustHistoryDtl(MaintPFDetailQueryVO oMaintPFDetailQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters = new ArrayList();
        ArrayList oOutArray;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        QueryRow oRow = null;    
        int count = 0;
        PfAdjustHistoryBeanDtl oPfAdjustHistoryBean;
        ArrayList adjHistList = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPFDetailQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPFDetailQueryVO.getTxtFromYear())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintPFDetailQueryVO.getTxtYYMMDtl())));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_Get_PAY_EMP_PF_DTL_ADJ(?,?,?,?,?)");
        
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {
            return null;
            //throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
            if(count == 0)
            {
                adjHistList = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();
            oPfAdjustHistoryBean = new PfAdjustHistoryBeanDtl();
            oPfAdjustHistoryBean.setTxtAdjTypeDtl1((oRow.get("CODE_DESC").getString()));
            oPfAdjustHistoryBean.setTxtPayModeDtl1((oRow.get("PAY_MODE").getString()));
            oPfAdjustHistoryBean.setTxtAdjAmtDtl1((oRow.get("ADJUST_AMT").getString()));
            oPfAdjustHistoryBean.setTxtRmrkDtl1((oRow.get("REMARK").getString()));
            oPfAdjustHistoryBean.setTxtModDtDtl((oRow.get("modified_dt").getString()));
            adjHistList.add(oPfAdjustHistoryBean);
        }             
        return adjHistList; 
    }
}