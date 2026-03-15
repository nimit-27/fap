package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintSplDutyAllowBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyAllowQueryVO;
import FCIPAY.Payroll.UTILITY.SplDutyAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyAllowDetailInfo;
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
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;

public class SplDutyAllowBusinessObject extends BaseBO 
{
  public SplDutyAllowBusinessObject()
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
    if(sScreenName.equals("SplDutyCdaScreen"))
    {
      sPayScaleType = "CDA";
      saveSplDutyAllow(sHeaderPrimaryKey,sPayScaleType,(SplDutyAllowHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    else
    {
      sPayScaleType = "IDA";
      saveSplDutyAllow(sHeaderPrimaryKey,sPayScaleType,(SplDutyAllowHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
  }

  private void saveSplDutyAllow(String sHeaderPrimaryKey,String sPayScaleType, SplDutyAllowHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
      MaintSplDutyAllowBean oMaintSplDutyAllowBean = (MaintSplDutyAllowBean)oIt.next();
      if(oMaintSplDutyAllowBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
      {
        if(!bInsert)
        {
          oBeanInsert = new DBUtilitiesBean();
          oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPaySplDutyMst(?,?,?,?,?,?,?,?,?,?,?,?)");
          bInsert = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtCtgry())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtDsgnId())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtArea())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtAllow())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtParamFlg())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtRmrks())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintSplDutyAllowBean.getTxtEndDt())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtPayScale())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBeanInsert.addToBatch(oParameters);
      }
      else if(oMaintSplDutyAllowBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
      {
        if(!bUpdate)
        {
          oBean = new DBUtilitiesBean();
          oBean.createBatch("PAYROLL_PKG.proc_UpdatePaySplDutyMst(?,?,?,?,?,?,?,?,?,?,?,?,?)");
          bUpdate = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getDetailId())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtCtgry())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtDsgnId())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtArea())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtAllow())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtParamFlg())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtRmrks())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintSplDutyAllowBean.getTxtEndDt())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getTxtPayScale())));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
        oBean.addToBatch(oParameters);
      }
      else if(oMaintSplDutyAllowBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
      {
        if(!bDelete)
        {
          oBeanDelete = new DBUtilitiesBean();
          oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePaySplDutyMst(?)");
          bDelete = true;
        }
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintSplDutyAllowBean.getDetailId())));
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

  public RecordMetaInfo getSplDutyDetailMetaInfo(String sPrimaryKey,SplDutyAllowDetailInfo oSplDutyAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oSplDutyAllowDetailInfo.getTxtEffDt())));                
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPaySplDutyMst(?,?,?,?,?)");

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    return oRecordMetaInfo;
  }

  public ArrayList getSplDutyDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,SplDutyAllowDetailInfo oSplDutyAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output
    MaintSplDutyAllowBean oMaintSplDutyAllowBean;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oSplDutyDetail = null;

    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oSplDutyAllowDetailInfo.getTxtEffDt())));                
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPaySplDutyMst(?,?,?,?,?,?)");

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
        oSplDutyDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oMaintSplDutyAllowBean = new MaintSplDutyAllowBean();
      oMaintSplDutyAllowBean.setTxtCtgry(oRow.get("CTGRY").getString());
      oMaintSplDutyAllowBean.setTxtDsgnId(oRow.get("DSGN_ID").getString());
      oMaintSplDutyAllowBean.setTxtDsgn(oRow.get("DSGN_DESC").getString());
      oMaintSplDutyAllowBean.setStatus("Q");
      oMaintSplDutyAllowBean.setTxtAllow(oRow.get("ALLOW").getString());
      oMaintSplDutyAllowBean.setTxtParamFlg(oRow.get("FLG_PARAM").getString());
      //requires table to be modified dt 19 Oct 2007
      oMaintSplDutyAllowBean.setTxtPayScale(oRow.get("PAY_SCALE").getString());
      oMaintSplDutyAllowBean.setTxtStartDt(EnrgiseUtil.convertToString(oRow.get("START_DT").getDate()));
      oMaintSplDutyAllowBean.setTxtEndDt(EnrgiseUtil.convertToString(oRow.get("END_DT").getDate()));
      oMaintSplDutyAllowBean.setDetailId(oRow.get("SPL_DUTY_MST_ID").getString());
      oMaintSplDutyAllowBean.setTxtArea(oRow.get("AREA_TYPE").getString());
      oSplDutyDetail.add(oMaintSplDutyAllowBean);
    }
    return oSplDutyDetail;
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

  public SplDutyComboVO getSplDutyComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    SplDutyComboVO oSplDutyComboVO = new SplDutyComboVO();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oSplDutyCtgry = null;
    ArrayList oSplDutyAreaTyp = null;

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
        oSplDutyCtgry = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String ctgryLabel = oRow.get("code_sdesc").getString();
      String ctgryValue = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(ctgryLabel,ctgryValue);
      oSplDutyCtgry.add(oComboVO);
    }
    oSplDutyComboVO.setCtgryList(oSplDutyCtgry);

    // To Get Combo For Area Type
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getSplDutyArea(?,?)");

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
        oSplDutyAreaTyp = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String areaLabel = oRow.get("code_desc").getString();
      String areaValue = oRow.get("code_sdesc").getString();
      oComboVO = new ComboVO(areaLabel,areaValue);
      oSplDutyAreaTyp.add(oComboVO);
    }
    oSplDutyComboVO.setAreaTypList(oSplDutyAreaTyp);

    return oSplDutyComboVO;
  }
  
  public LovVO getSCADsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Designation Code");
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtCtgry").trim())));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_SplDutyDsgnLOV(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("dsgn_desc").getString());
       oLOVBean.setDetailField2(oRow.get("dsgn_id").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getSCAPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Scale");
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDsgnPayScaleCodelov(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_scale_code").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public RecordMetaInfo getSplDutyHeaderMetaImpl(SplDutyAllowQueryVO oSplDutyQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oSplDutyQueryVO.getTxtEffDt())));                
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPaySplDutyHdr(?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getSplDutyHeader(SplDutyAllowQueryVO oSplDutyQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oSplDutyQueryVO == null)
    {
      oSplDutyQueryVO = new SplDutyAllowQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
   //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHillCmpnstryAllowQueryVO.getTxtPayScaleTyp())));                  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oSplDutyQueryVO.getTxtEffDt()))); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPaySplDutyHdr(?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      SplDutyAllowHeaderBean oSplDutyAllowHeaderBean;
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
          oSplDutyAllowHeaderBean = new SplDutyAllowHeaderBean();       
          oSplDutyAllowHeaderBean.setTxtEffDt(EnrgiseUtil.convertToString(oRow.get("start_dt").getDate()));                                                  
          oHeaderList.add(oSplDutyAllowHeaderBean);
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
      SplDutyAllowHeaderBean oSplDutyAllowHeaderBean = (SplDutyAllowHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oSplDutyAllowHeaderBean.getTxtEffDt())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_SplDutyAllowCheck(?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("wenrgise.common.dateCheck",oArguments));
      }
  }
}