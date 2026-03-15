package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayHistDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.PaymentHistoryBean;
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

public class PayHistBusinessObject extends BaseBO
{
  public PayHistBusinessObject()
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
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {   
    return null;
  }


 public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("PaymentHistoryScreen"))
    {      
      savePayHist(sHeaderPrimaryKey,oDetailBeanArray);
    }
    
  }
  
  private void savePayHist(String sPrimaryKey, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    int ind = sPrimaryKey.indexOf(",",0);
    String empNo = sPrimaryKey.substring(0,ind);
    String type = sPrimaryKey.substring(ind+1,sPrimaryKey.length());
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        PaymentHistoryBean oPaymentHistoryBean = (PaymentHistoryBean)oIt.next();
        if(oPaymentHistoryBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayHistDetail(?,?,?,?,?)");
            bInsert = true;
          }

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, empNo));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, type));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oPaymentHistoryBean.getTxtPayAmt())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPaymentHistoryBean.getTxtPayDate())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String(oPaymentHistoryBean.getTxtRemark())));   
     
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oPaymentHistoryBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdatePayHistDetail(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, empNo));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, type));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oPaymentHistoryBean.getTxtSerialNo())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oPaymentHistoryBean.getTxtPayAmt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oPaymentHistoryBean.getTxtPayDate())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, new String(oPaymentHistoryBean.getTxtRemark())));  
          oBean.addToBatch(oParameters);
          
        }
        else if(oPaymentHistoryBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayHistDetail(?,?,?)");
            bDelete = true;
          }
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, empNo));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, type));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oPaymentHistoryBean.getTxtSerialNo())));   
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

  public RecordMetaInfo getComFinalHeaderMetaInfo(ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;    
  }




  public ArrayList getPayHistHeader(ComFinalSetQueryVO oComFinalSetQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }


  
  public RecordMetaInfo getPayHistDetailMetaInfo(String sPrimaryKey,PayHistDetailInfo oPayHistDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPayHistDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oPayHistDetailInfo.getTxtPayHead()));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayHistDetailCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;      
  }
  
  public ArrayList getPayHistDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,PayHistDetailInfo oPayHistDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray;
    PaymentHistoryBean oPaymentHistoryBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayHistDetail = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPayHistDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oPayHistDetailInfo.getTxtPayHead()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayHistDetail(?,?,?,?,?,?)");
      
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
            oPayHistDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oPaymentHistoryBean = new PaymentHistoryBean();
          oPaymentHistoryBean.setTxtPayAmt((oRow.get("Pay_Amount").getString()));
          oPaymentHistoryBean.setTxtPayDate(EnrgiseUtil.convertToString(oRow.get("Pay_Date").getDate()));
          oPaymentHistoryBean.setTxtRemark((oRow.get("Pay_Remark").getString())); 
          oPaymentHistoryBean.setTxtSerialNo((oRow.get("Pay_Srl_No").getString())); 
          oPaymentHistoryBean.setStatus("Q"); 
                  
          oPayHistDetail.add(oPaymentHistoryBean);
        }  
       return oPayHistDetail;
  }
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {    

  }
}