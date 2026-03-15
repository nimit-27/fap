package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCAComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintCCARatesBean;
import FCIPAY.Payroll.UTILITY.MaintCCARatesCdaBean;
import FCIPAY.Payroll.UTILITY.MaintCCARatesIdaBean;
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
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCARatesQueryVO;
import FCIPAY.Payroll.UTILITY.CCARatesHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCARatesDetailInfo;

public class CCARateBusinessObject extends BaseBO
{
  public CCARateBusinessObject()
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
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    oParameters = new ArrayList();    
    return null;      
  }


//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    String sPayScaleType;
    
    if(sScreenName.equals("CCARateCDAScreen"))
    {
      sPayScaleType = "CDA";    
      saveCCARate(sHeaderPrimaryKey,sPayScaleType,(CCARatesHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }
    else 
    {
      sPayScaleType = "IDA";    
      saveCCARate(sHeaderPrimaryKey,sPayScaleType,(CCARatesHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }        
  }
  
  private void saveCCARate(String sHeaderPrimaryKey,String sPayScaleType, CCARatesHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        MaintCCARatesBean oMaintCCARatesBean = (MaintCCARatesBean)oIt.next();
        if(oMaintCCARatesBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
              oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayFixedCCARates(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintCCARatesBean.getTxtCtgry()))); 
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getStartField())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getEndField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getTxtAllow())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));          
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCCARatesBean.getTxtEndDate())));   
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintCCARatesBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdatePayFixedCCARates(?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getDetailId())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintCCARatesBean.getTxtCtgry()))); 
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getEndField())));                              
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getTxtAllow())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oBaseHeaderBean.getTxtEffDt())));                    
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCCARatesBean.getTxtEndDate())));                    
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintCCARatesBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayFixedCCARates(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCCARatesBean.getDetailId())));
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
  
  public RecordMetaInfo getCCARateAllDetailMetaInfo(String sPrimaryKey,CCARatesDetailInfo oCCARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey.substring(0,3)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey.substring(4,sPrimaryKey.length())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCCARatesDetailInfo.getTxtEffDt())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPayFixedCCARates(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getCCARateAllDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,CCARatesDetailInfo oCCARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintCCARatesBean oCCARateAll;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oCCARateAllDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey.substring(0,3)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey.substring(4,sPrimaryKey.length())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCCARatesDetailInfo.getTxtEffDt())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayFixedCCARates(?,?,?,?,?,?,?)");
      
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
            oCCARateAllDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oCCARateAll = new MaintCCARatesBean();
          oCCARateAll.setDetailId((oRow.get("CCA_RATES_ID").getString()));
          oCCARateAll.setTxtCtgry((oRow.get("CTGRY").getString()));
          oCCARateAll.setStartField((oRow.get("amount_from").getString()));
          oCCARateAll.setStatus("Q");
          oCCARateAll.setEndField(oRow.get("amount_to").getString());  
          oCCARateAll.setTxtAllow(oRow.get("ALLOW").getString());          
          oCCARateAll.setTxtStartDate(EnrgiseUtil.convertToString(oRow.get("START_DT").getDate()));
          oCCARateAll.setTxtEndDate(EnrgiseUtil.convertToString(oRow.get("END_DT").getDate()));
          oCCARateAllDetail.add(oCCARateAll);
        }        
    return oCCARateAllDetail;
    
  }


public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oList = new ArrayList();
      String sPayScaleType="";
      if(sScreenName.equals("CCARateCDAScreen"))
      {
        sPayScaleType = "CDA";            
      }
      else 
      {
        sPayScaleType = "IDA";            
      }  
   //   if(sScreenMode.equals(EnrgiseConstants.NEW_MODE))
    //  {
        chkEffDate(oBaseHeaderBean,sScreenMode,sPayScaleType,oList);
        reportError(oList);
   //   }

  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  public CCAComboVO getCCARateComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CCAComboVO oCCAComboVO = new CCAComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oCCARateCity = null;
    ArrayList oCCARateCtgry = null;
    
    // GET CITY TYPE COMBO INFO Modified by Balpreet Dt 24 Dec 2007.
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetCityTypeLocLov(?,?)");
    
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
        oCCARateCity = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String cityLabel = oRow.get("code_desc").getString();
      // Not Selecting gbl_code coz this wil affect our business logic. 
      String cityValue = oRow.get("code_sdesc").getString();
      oComboVO = new ComboVO(cityLabel,cityValue);
      oCCARateCity.add(oComboVO);
    }
    oCCAComboVO.setCityList(oCCARateCity);
    
    
    // GET CATEGORY COMBO INFO  Added By Balpreet Dt 17 Oct 2007
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
        oCCARateCtgry = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String cityLabel = oRow.get("code_sdesc").getString();
      String cityValue = oRow.get("gbl_code").getString();
      oComboVO = new ComboVO(cityLabel,cityValue);
      oCCARateCtgry.add(oComboVO);
    }
    oCCAComboVO.setCtgryList(oCCARateCtgry);

    return oCCAComboVO;
       
  }

  public RecordMetaInfo getCCARateHeaderMetaInfo(CCARatesQueryVO oCCARatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oCCARatesQueryVO.getTxtEffDt())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCCARatesQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_COUNTPAYFIXEDCCAHEADER(?,?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getCCARateHeader(CCARatesQueryVO oCCARatesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oCCARatesQueryVO == null)
    {
      oCCARatesQueryVO = new CCARatesQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oCCARatesQueryVO.getTxtEffDt()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCCARatesQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPAYFIXEDCCAHEADER(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      CCARatesHeaderBean oCCARatesHeaderBean;
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
          oCCARatesHeaderBean = new CCARatesHeaderBean();
          oCCARatesHeaderBean.setHeaderPrimaryKey(oRow.get("city").getString());          
          oCCARatesHeaderBean.setTxtEffDt(EnrgiseUtil.convertToString(oRow.get("START_DT").getDate()));                                                  
          oHeaderList.add(oCCARatesHeaderBean);
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
      CCARatesHeaderBean oCCARatesHeaderBean = (CCARatesHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCCARatesHeaderBean.getTxtEffDt())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oCCARatesHeaderBean.getHeaderPrimaryKey()));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CCARateCheck(?,?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("wenrgise.common.dateCheck",oArguments));
      }
  }
  
}