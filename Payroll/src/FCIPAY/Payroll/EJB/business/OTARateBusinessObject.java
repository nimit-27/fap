package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OTATypeComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintOTARateBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
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
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyDetailInfo;

public class OTARateBusinessObject extends BaseBO
{
  public OTARateBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    
    if(sScreenName.equals("CCARateALLScreen"))
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
      saveOTARate(sHeaderPrimaryKey,(DummyHeaderBean)oBaseHeaderBean,oDetailBeanArray);
  }

  private void saveOTARate(String sHeaderPrimaryKey,DummyHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;

    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;

    Iterator oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
      MaintOTARateBean oMaintOTARateBean = (MaintOTARateBean)oIt.next();
      if(oMaintOTARateBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
      {
        if(!bInsert)
        {
          oBeanInsert = new DBUtilitiesBean();
          oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayRmtAreaMst(?,?,?,?,?,?,?,?,?,?)");
          bInsert = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintOTARateBean.getTxtOTATyp())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintOTARateBean.getTxtRate())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getHeaderPrimaryKey())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBeanInsert.addToBatch(oParameters);
      }
      else if(oMaintOTARateBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
      {
        if(!bUpdate)
        {
          oBean = new DBUtilitiesBean();
          oBean.createBatch("PAYROLL_PKG.proc_UpdatePayRmtAreaMst(?,?,?,?,?,?,?,?,?,?,?)");
          bUpdate = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintOTARateBean.getDetailId())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintOTARateBean.getTxtOTATyp())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintOTARateBean.getTxtRate())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getHeaderPrimaryKey())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBean.addToBatch(oParameters);
      }
      else if(oMaintOTARateBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
      {
        if(!bDelete)
        {
          oBeanDelete = new DBUtilitiesBean();
          oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayRmtAreaMst(?)");
          bDelete = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintOTARateBean.getDetailId())));
        oBeanDelete.addToBatch(oParameters);
      }
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

  public RecordMetaInfo getOTARateDetailMetaInfo(String sPrimaryKey,DummyDetailInfo oDummyDetailInfo ) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oDummyDetailInfo.getLoginLocCode())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPayRmtAreaMst(?,?,?,?,?)");

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    return oRecordMetaInfo;
  }

  public ArrayList getOTARateDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,DummyDetailInfo oDummyDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output
    MaintOTARateBean oMaintOTARateBean;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oOTARateDetail = null;

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,new Long(oDummyDetailInfo.getLoginLocCode())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayRmtAreaMst(?,?,?,?,?,?)");

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
        oOTARateDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oMaintOTARateBean = new MaintOTARateBean();
     // oMaintHillCmpnstryAllowBean.setTxtSrlNo((oRow.get("srl_no").getString()));
      oMaintOTARateBean.setTxtOTATyp(oRow.get("CTGRY").getString());
      oMaintOTARateBean.setStatus("Q");
      oMaintOTARateBean.setTxtRate(oRow.get("ALLOW").getString());
      oMaintOTARateBean.setDetailId(oRow.get("RMT_AREA_MST_ID").getString());
      oOTARateDetail.add(oMaintOTARateBean);
    }
    return oOTARateDetail;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oList = new ArrayList();
      String sPayScaleType="";
      if(sScreenMode.equals(EnrgiseConstants.NEW_MODE))
      {
        chkEffDate(oBaseHeaderBean,sScreenMode,sPayScaleType,oList);
        reportError(oList);
      }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }

  public OTATypeComboVO getOTARateComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    OTATypeComboVO oOTATypeComboVO = new OTATypeComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oOTAType = null;

    // To Get Combo For Employee Category
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCtgry(?,?)");

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
        oOTAType = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String ctgryLabel = oRow.get("code_sdesc").getString();
      String ctgryValue = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(ctgryLabel,ctgryValue);
      oOTAType.add(oComboVO);
    }
    oOTATypeComboVO.setOtaTypList(oOTAType);

    return oOTATypeComboVO;
  }
  
  public RecordMetaInfo getOTARateHeaderMetaImpl(DummyQueryVO oDummyQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oDummyQueryVO.getLoginLocCode()))); 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDummyQueryVO.getHeaderPrimaryKey())));                
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPayRmtAreaHdr(?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getOTARateHeader(DummyQueryVO oDummyQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oDummyQueryVO == null)
    {
      oDummyQueryVO = new DummyQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(oDummyQueryVO.getLoginLocCode())));                  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oDummyQueryVO.getHeaderPrimaryKey()))); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayRmtAreaHdr(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      DummyHeaderBean oDummyHeaderBean;
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
          oDummyHeaderBean = new DummyHeaderBean();       
          oDummyHeaderBean.setHeaderPrimaryKey(EnrgiseUtil.convertToString(oRow.get("start_dt").getDate()));                                                  
          oHeaderList.add(oDummyHeaderBean);
      }              
    return oHeaderList;
  } 

  private void chkEffDate(BaseHeaderBean oBaseHeaderBean,String sScreenMode,String sPayScaleType,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oDummyHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_RmtAreaAllowCheck(?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("wenrgise.common.dateCheck",oArguments));
      }
  }
}