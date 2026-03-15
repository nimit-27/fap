package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintPayCodesBean;
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
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayCodeDetailInfo;
public class PayCodeBusinessObject extends BaseBO
{
  public PayCodeBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("PayCodeScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
/*    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintPayCodesBean oMaintPayCodesBean = (MaintPayCodesBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output  */

      oParameters = new ArrayList();
/*      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oGlobalCodeHeaderBean.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getStudentName())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getSex())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER)); */
//      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_UpdateGlobalCode(?,?,?,?)");
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
/*    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintPayCodesBean oMaintPayCodesBean = (MaintPayCodesBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output  */



      oParameters = new ArrayList();
/*      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getStudentName())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getSex())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER)); */
//      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_InsertGlobalCode(?,?,?,?)");

//      DBObject oOutObject = (DBObject)oOutArray.get(0);
//      return (String)oOutObject.getObject();
        return null;
      
  }
  
  public RecordMetaInfo getPayCodeDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    PayCodeDetailInfo oPayCodeDetailInfo=(PayCodeDetailInfo)oBaseDetailInfo;
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oPayCodeDetailInfo.getTxtFromPayCode()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPayCodeDetailInfo.getTxtToPayCode()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayCodeCount(?,?,?,?,?,?)");
//    oOutArray = oBean.executeQuery(oParameters,LoginSQLQueries.GET_LOC_CODE);        
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getPayCodesDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPayCodesBean oPayCode;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayDetail = null;
    PayCodeDetailInfo oPayCodeDetailInfo=(PayCodeDetailInfo)oBaseDetailInfo;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oPayCodeDetailInfo.getTxtFromPayCode()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oPayCodeDetailInfo.getTxtToPayCode()));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayCodeDetail(?,?,?,?,?,?,?)");
      
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
            oPayDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oPayCode = new MaintPayCodesBean();
          oPayCode.settxtPayCode((oRow.get("PAY_CODE").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oPayCode.setStatus("Q");
          oPayCode.settxtPayCodeDesc(oRow.get("PAY_CODE_DESC").getString());
          oPayCode.setlstTaxableIndicator(oRow.get("taxable_ind").getString());          
          oPayCode.setlstSavingsRebate(oRow.get("ext_save_rebate").getString());          
          oPayCode.settxtRebateLimit(oRow.get("REBATE_LIMIT").getString());
          oPayCode.settxtAdjPriority(oRow.get("ADJ_PRIORITY").getString());
          oPayCode.setLstProfTaxFlag(oRow.get("PROF_TAX_FLAG").getString());    
          oPayCode.settxtSrlNo((count)+"");
          oPayDetail.add(oPayCode);
        }        
        
    return oPayDetail;
    
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("PayCodeScreen"))
    {
      savePayCodes(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void savePayCodes(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintPayCodesBean oMaintPayCodesBean = (MaintPayCodesBean)oIt.next();
//        System.out.println(oMaintPayCodesBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintPayCodesBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayCodeDetail(?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtPayCodeDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.getlstTaxableIndicator())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.getlstSavingsRebate())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtRebateLimit())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtAdjPriority())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.getLstProfTaxFlag())));          
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintPayCodesBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdatePayCodeDetail(?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtPayCodeDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.getlstTaxableIndicator())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.getlstSavingsRebate())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtRebateLimit())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtAdjPriority())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.getLstProfTaxFlag())));          
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintPayCodesBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayCodeDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtPayCode())));
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
  
/*  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintPayCodesBean oMaintPayCodesBean = (MaintPayCodesBean)oIt.next();
        System.out.println(oMaintPayCodesBean.getStatus());
        if(oMaintPayCodesBean.getStatus().equals("N"))    
        {
          String pcode = oMaintPayCodesBean.gettxtPayCode();
          
          throw new EnrgiseApplicationException("wenrgise.sysadmin.error.second",oArguments);    
        }
      }
  }

  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
  }


  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
*/  

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oDetailBeanArray);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    
//    checkFirst(oBaseHeaderBean,oList);
    checkPayCode(oDetailBeanArray,oList);
    reportError(oList);
    
    
  }
  
/*  private void checkFirst(BaseHeaderBean oBaseHeaderBean,ArrayList oList)
  {
    if(1 == 1)
    {
      oList.add(new EnrgiseApplicationException("wenrgise.sysadmin.error.first"));
    }
  } */
  
  private void checkPayCode(ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
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
        MaintPayCodesBean oMaintPayCodesBean = (MaintPayCodesBean)oIt.next();
//        System.out.println(oMaintPayCodesBean.getStatus());

        if(!(oMaintPayCodesBean.getStatus().equals("D")))
          count++;


        if(oMaintPayCodesBean.getStatus().equals("N"))    
        {
          String pcode = oMaintPayCodesBean.gettxtPayCode();

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayCodesBean.gettxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PayCodeCheck(?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(1));
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("wenrgise.common.duplicateCode",oArguments));
            }
        }
      }
  }


}