package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TrblAreaComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TrblAreaAllowQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintTrblAreaAllowBean;
import FCIPAY.Payroll.UTILITY.TrblAreaAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintTrblAreaAllowDetailInfo;
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


public class TrblAreaAllowBusinessObject extends BaseBO
{
  public TrblAreaAllowBusinessObject()
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
    String sPayScaleType;
    if(sScreenName.equals("TrblAreaCdaScreen"))
    {
      sPayScaleType = "CDA";
      saveTrblAreaAllow(sHeaderPrimaryKey,sPayScaleType,(TrblAreaAllowHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    else
    {
      sPayScaleType = "IDA";
      saveTrblAreaAllow(sHeaderPrimaryKey,sPayScaleType,(TrblAreaAllowHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
  }

  private void saveTrblAreaAllow(String sHeaderPrimaryKey,String sPayScaleType, TrblAreaAllowHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
      MaintTrblAreaAllowBean oMaintTrblAreaAllowBean = (MaintTrblAreaAllowBean)oIt.next();
      if(oMaintTrblAreaAllowBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
      {
        if(!bInsert)
        {
          oBeanInsert = new DBUtilitiesBean();
          oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayTrblAreaMst(?,?,?,?,?,?,?,?,?)");
          bInsert = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtCtgry())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtBasicFrom())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtBasicTo())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtAllow())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintTrblAreaAllowBean.getTxtEndDt())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBeanInsert.addToBatch(oParameters);
      }
      else if(oMaintTrblAreaAllowBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
      {
        if(!bUpdate)
        {
          oBean = new DBUtilitiesBean();
          oBean.createBatch("PAYROLL_PKG.proc_UpdatePayTrblAreaMst(?,?,?,?,?,?,?,?,?,?)");
          bUpdate = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getDetailId())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtCtgry())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtBasicFrom())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtBasicTo())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getTxtAllow())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintTrblAreaAllowBean.getTxtEndDt())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBean.addToBatch(oParameters);
      }
      else if(oMaintTrblAreaAllowBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
      {
        if(!bDelete)
        {
          oBeanDelete = new DBUtilitiesBean();
          oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayTrblAreaMst(?)");
          bDelete = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintTrblAreaAllowBean.getDetailId())));
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

  public RecordMetaInfo getTrblAreaDetailMetaInfo(String sPrimaryKey,MaintTrblAreaAllowDetailInfo oMaintTrblAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintTrblAreaAllowDetailInfo.getTxtEffDt())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPayTrblAreaMst(?,?,?,?,?)");

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    return oRecordMetaInfo;
  }

  public ArrayList getTrblAreaDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,MaintTrblAreaAllowDetailInfo oMaintTrblAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output
    MaintTrblAreaAllowBean oMaintTrblAreaAllowBean;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oTrblAreaDetail = null;

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintTrblAreaAllowDetailInfo.getTxtEffDt())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayTrblAreaMst(?,?,?,?,?,?)");

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
        oTrblAreaDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oMaintTrblAreaAllowBean = new MaintTrblAreaAllowBean();
     // oMaintHillCmpnstryAllowBean.setTxtSrlNo((oRow.get("srl_no").getString()));
     oMaintTrblAreaAllowBean.setTxtCtgry(oRow.get("CTGRY").getString());
      oMaintTrblAreaAllowBean.setTxtBasicFrom((oRow.get("BASIC_FROM").getString()));
      oMaintTrblAreaAllowBean.setStatus("Q");
      oMaintTrblAreaAllowBean.setTxtBasicTo(oRow.get("BASIC_TO").getString());
      oMaintTrblAreaAllowBean.setTxtAllow(oRow.get("ALLOW").getString());
      oMaintTrblAreaAllowBean.setTxtStartDt(EnrgiseUtil.convertToString(oRow.get("START_DT").getDate()));
      oMaintTrblAreaAllowBean.setTxtEndDt(EnrgiseUtil.convertToString(oRow.get("END_DT").getDate()));
      oMaintTrblAreaAllowBean.setDetailId(oRow.get("TRBL_AREA_MST_ID").getString());
      oTrblAreaDetail.add(oMaintTrblAreaAllowBean);
    }
    return oTrblAreaDetail;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oList = new ArrayList();
      String sPayScaleType="";
      if(sScreenName.equals("TrblAreaCdaScreen"))
      {
        sPayScaleType = "CDA";            
      }
      else 
      {
        sPayScaleType = "IDA";            
      }  
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

  public TrblAreaComboVO getTrblAreaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    TrblAreaComboVO oTrblAreaComboVO = new TrblAreaComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oTrblAreaCtgry = null;

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
        oTrblAreaCtgry = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String ctgryLabel = oRow.get("code_sdesc").getString();
      String ctgryValue = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(ctgryLabel,ctgryValue);
      oTrblAreaCtgry.add(oComboVO);
    }
    oTrblAreaComboVO.setCtgryList(oTrblAreaCtgry);
    return oTrblAreaComboVO;
  }
  
  public RecordMetaInfo getTrblAreaHeaderMetaImpl(TrblAreaAllowQueryVO oTrblAreaQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
     // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHillCmpnstryAllowQueryVO.getTxtPayScaleTyp()))); 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oTrblAreaQueryVO.getTxtEffDt())));                
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPayTrblAreaHdr(?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getTrblAreaHeader(TrblAreaAllowQueryVO oTrblAreaQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oTrblAreaQueryVO == null)
    {
      oTrblAreaQueryVO = new TrblAreaAllowQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
   //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHillCmpnstryAllowQueryVO.getTxtPayScaleTyp())));                  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oTrblAreaQueryVO.getTxtEffDt()))); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayTrblAreaHdr(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      TrblAreaAllowHeaderBean oTrblAreaAllowHeaderBean;
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
          oTrblAreaAllowHeaderBean = new TrblAreaAllowHeaderBean();       
          oTrblAreaAllowHeaderBean.setTxtEffDt(EnrgiseUtil.convertToString(oRow.get("start_dt").getDate()));                                                  
          oHeaderList.add(oTrblAreaAllowHeaderBean);
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
      TrblAreaAllowHeaderBean oTrblAreaAllowHeaderBean = (TrblAreaAllowHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oTrblAreaAllowHeaderBean.getTxtEffDt())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_TrblAreaAllowCheck(?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("wenrgise.common.dateCheck",oArguments));
      }
  }
}