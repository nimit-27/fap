package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;

import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.UserRespQueryVO;
import FCIPAY.Payroll.UTILITY.UserRespHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UserRespDetailInfo;
import FCIPAY.Payroll.UTILITY.UserRespBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UsrRespComboVO;

public class UsrRespMapBusinessObject extends BaseBO 
{
  public UsrRespMapBusinessObject()
  {
  }
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("LeaveScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public RecordMetaInfo getUsrRespHeaderMetaInfo(UserRespQueryVO oUserRespQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    
    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oUserRespQueryVO.getTxtUserCode()));      
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserRespQueryVO.getTxtMapLoc())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_UserRespHeaderCount(?,?,?,?,?)");

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
	oTimeObject  = null;       
	oTotalRecord = null;
	oOutArray    = null;
	oParameters  = null;
    return oRecordMetaInfo;
  }

  public ArrayList getUsrRespHeader(UserRespQueryVO oUserRespQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    ArrayList oHeaderList = null;
    int count = 0;
    if(oUserRespQueryVO == null)
    {
      oUserRespQueryVO = new UserRespQueryVO();
    }

    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oUserRespQueryVO.getTxtUserCode()));      
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserRespQueryVO.getTxtMapLoc())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_UserRespHeader(?,?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
    UserRespHeaderBean oHeaderBeanObject;
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
        oHeaderBeanObject = new UserRespHeaderBean();
        oHeaderBeanObject.setTxtUserCode(oRow.get("user_id").getString());
        oHeaderBeanObject.setTxtMapLoc(oRow.get("mapped_loc_id").getString());
        oHeaderList.add(oHeaderBeanObject);
        oRow = null;
        oHeaderBeanObject = null; 
    } 
    oList = null;
    oIt = null;
    oUserRespQueryVO = null;
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
    return oHeaderList;
  }

  public RecordMetaInfo getUserRespDetailMetaInfo(String sPrimaryKey, UserRespDetailInfo oUserRespDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    ArrayList oParameters; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oUserRespDetailInfo.getTxtUserCode())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oUserRespDetailInfo.getTxtMapLoc())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_UserRespDetailCount(?,?,?,?,?)");
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    oTotalRecord = null;
    oTimeObject = null;
    oOutArray = null;
    oParameters = null;
    return oRecordMetaInfo;
  }
  
  public ArrayList getUserRespDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, UserRespDetailInfo oUserRespDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters; //Input Parameters
    int count = 0;
    ArrayList oOutArray; //Output 
    UserRespBean oUserRespBean;
    QueryRow oRow = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDetailList = null;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserRespDetailInfo.getTxtUserCode())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserRespDetailInfo.getTxtMapLoc())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_UserRespDetail(?,?,?,?,?,?)");
  
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
        oDetailList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oUserRespBean = new UserRespBean();
      oUserRespBean.setTxtRespId(oRow.get("resp_id").getString());
      oUserRespBean.setTxtRespEndDt(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("resp_end_dt").getDate())); 
      oUserRespBean.setStatus("Q");

      oDetailList.add(oUserRespBean);
      oRow = null;
      oUserRespBean = null; //added by swapnendu Dt 24 Oct 2011.
    }
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oUserRespDetailInfo = null;
    return oDetailList;
    
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      saveDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
  }

  private void saveDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    UserRespHeaderBean oDummyHeaderBean = (UserRespHeaderBean)oBaseHeaderBean;
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        UserRespBean oUserBean = (UserRespBean)oIt.next();
        if(oUserBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_user_resp.proc_insert_sysadminmap(?,?,?,?,?,?)");
            bInsert = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtMapLoc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRespId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRespEndDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
          oParameters = null;
        }
        else if(oUserBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_user_resp.proc_update_sysadminmap(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtMapLoc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRespId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRespEndDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          oParameters = null;
        }
        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_user_resp.proc_delete_sysadminmap(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtMapLoc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRespId())));
          oBeanDelete.addToBatch(oParameters);  
          oParameters = null;
        }
        oUserBean = null;
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
      finally
      {
      }
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    //ArrayList oParameters = new ArrayList(); //Input Parameters
    //oParameters = new ArrayList();
    return null;
  }

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
/*      ArrayList oList = new ArrayList();
      checkYrEndRemittance(oBaseHeaderBean,oList);
      reportError(oList);
      checkMaxPayYear(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
      checkTotAmtPayable(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
      oList = new ArrayList();
      checkPaycodeApplicable(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);*/
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public UsrRespComboVO getUsrRespComboVO()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
            
    UsrRespComboVO oUsrRespComboVO = new UsrRespComboVO();  
    
    oList = new ArrayList();
    oList = getUsrRespComboRecords("pkg_user_resp.proc_Get_Resp_List(?,?)","resp_id","resp_name");
    oUsrRespComboVO.setRespList(oList);                
    return oUsrRespComboVO;
  }
  
  private ArrayList getUsrRespComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
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

}