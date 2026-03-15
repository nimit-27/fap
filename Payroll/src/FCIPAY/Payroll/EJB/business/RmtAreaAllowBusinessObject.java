package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintRmtAreaAllowBean;
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

import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaAllowQueryVO;
import FCIPAY.Payroll.UTILITY.RmtAreaAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintRmtAreaAllowDetailInfo;


public class RmtAreaAllowBusinessObject extends BaseBO
{
  public RmtAreaAllowBusinessObject()
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
    if(sScreenName.equals("RmtAreaCdaScreen"))
    {
      sPayScaleType = "CDA";
      saveRmtAreaAllow(sHeaderPrimaryKey,sPayScaleType,(RmtAreaAllowHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    else
    {
      sPayScaleType = "IDA";
      saveRmtAreaAllow(sHeaderPrimaryKey,sPayScaleType,(RmtAreaAllowHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
  }

  private void saveRmtAreaAllow(String sHeaderPrimaryKey,String sPayScaleType, RmtAreaAllowHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
      MaintRmtAreaAllowBean oMaintRmtAreaAllowBean = (MaintRmtAreaAllowBean)oIt.next();
      if(oMaintRmtAreaAllowBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
      {
        if(!bInsert)
        {
          oBeanInsert = new DBUtilitiesBean();
          oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayRmtAreaMst(?,?,?,?,?,?,?,?,?,?)");
          bInsert = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtCtgry())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtRmtArea())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtBasicFrom())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtBasicTo())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtAllow())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintRmtAreaAllowBean.getTxtEndDt())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBeanInsert.addToBatch(oParameters);
      }
      else if(oMaintRmtAreaAllowBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
      {
        if(!bUpdate)
        {
          oBean = new DBUtilitiesBean();
          oBean.createBatch("PAYROLL_PKG.proc_UpdatePayRmtAreaMst(?,?,?,?,?,?,?,?,?,?,?)");
          bUpdate = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getDetailId())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtCtgry())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtRmtArea())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtBasicFrom())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtBasicTo())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getTxtAllow())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintRmtAreaAllowBean.getTxtEndDt())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBean.addToBatch(oParameters);
      }
      else if(oMaintRmtAreaAllowBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
      {
        if(!bDelete)
        {
          oBeanDelete = new DBUtilitiesBean();
          oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayRmtAreaMst(?)");
          bDelete = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintRmtAreaAllowBean.getDetailId())));
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

  public RecordMetaInfo getRmtAreaDetailMetaInfo(String sPrimaryKey,MaintRmtAreaAllowDetailInfo oMaintRmtAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintRmtAreaAllowDetailInfo.getTxtEffDt())));
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

  public ArrayList getRmtAreaDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,MaintRmtAreaAllowDetailInfo oMaintRmtAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output
    MaintRmtAreaAllowBean oMaintRmtAreaAllowBean;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oRmtAreaDetail = null;

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oMaintRmtAreaAllowDetailInfo.getTxtEffDt())));
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
        oRmtAreaDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oMaintRmtAreaAllowBean = new MaintRmtAreaAllowBean();
     // oMaintHillCmpnstryAllowBean.setTxtSrlNo((oRow.get("srl_no").getString()));
      oMaintRmtAreaAllowBean.setTxtCtgry(oRow.get("CTGRY").getString());
      oMaintRmtAreaAllowBean.setTxtRmtArea(oRow.get("AREA_TYP").getString());
      oMaintRmtAreaAllowBean.setTxtBasicFrom((oRow.get("BASIC_FROM").getString()));
      oMaintRmtAreaAllowBean.setStatus("Q");
      oMaintRmtAreaAllowBean.setTxtBasicTo(oRow.get("BASIC_TO").getString());
      oMaintRmtAreaAllowBean.setTxtAllow(oRow.get("ALLOW").getString());
      oMaintRmtAreaAllowBean.setTxtStartDt(EnrgiseUtil.convertToString(oRow.get("START_DT").getDate()));
      oMaintRmtAreaAllowBean.setTxtEndDt(EnrgiseUtil.convertToString(oRow.get("END_DT").getDate()));
      oMaintRmtAreaAllowBean.setDetailId(oRow.get("RMT_AREA_MST_ID").getString());
      oRmtAreaDetail.add(oMaintRmtAreaAllowBean);
    }
    return oRmtAreaDetail;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oList = new ArrayList();
      String sPayScaleType="";
      if(sScreenName.equals("RmtAreaCdaScreen"))
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

  public RmtAreaComboVO getRmtAreaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    RmtAreaComboVO oRmtAreaComboVO = new RmtAreaComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oRmtAreaCtgry = null;
    ArrayList oRmtAreaTyp = null;

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
        oRmtAreaCtgry = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String ctgryLabel = oRow.get("code_sdesc").getString();
      String ctgryValue = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(ctgryLabel,ctgryValue);
      oRmtAreaCtgry.add(oComboVO);
    }
    oRmtAreaComboVO.setCtgryList(oRmtAreaCtgry);
    
    // To Get Combo For Remote Area Types
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetRmtAreaLOV(?,?)");

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
        oRmtAreaTyp = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String ctgryLabel = oRow.get("code_sdesc").getString();
      String ctgryValue = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(ctgryLabel,ctgryValue);
      oRmtAreaTyp.add(oComboVO);
    }
    oRmtAreaComboVO.setRmtAreaList(oRmtAreaTyp);
    return oRmtAreaComboVO;
  }
  
  public RecordMetaInfo getRmtAreaHeaderMetaImpl(RmtAreaAllowQueryVO oRmtAreaQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oRmtAreaQueryVO.getTxtEffDt())));                
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

  public ArrayList getRmtAreaHeader(RmtAreaAllowQueryVO oRmtAreaQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oRmtAreaQueryVO == null)
    {
      oRmtAreaQueryVO = new RmtAreaAllowQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
   //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHillCmpnstryAllowQueryVO.getTxtPayScaleTyp())));                  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oRmtAreaQueryVO.getTxtEffDt()))); 
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
      
      RmtAreaAllowHeaderBean oRmtAreaAllowHeaderBean;
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
          oRmtAreaAllowHeaderBean = new RmtAreaAllowHeaderBean();       
          oRmtAreaAllowHeaderBean.setTxtEffDt(EnrgiseUtil.convertToString(oRow.get("start_dt").getDate()));                                                  
          oHeaderList.add(oRmtAreaAllowHeaderBean);
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
      RmtAreaAllowHeaderBean oRmtAreaAllowHeaderBean = (RmtAreaAllowHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRmtAreaAllowHeaderBean.getTxtEffDt())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
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