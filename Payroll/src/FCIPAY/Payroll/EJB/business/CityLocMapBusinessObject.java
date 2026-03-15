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
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapComboVO;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapQueryVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapDetailInfo;

public class CityLocMapBusinessObject extends BaseBO 
{
  public CityLocMapBusinessObject()
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
  
  //Added by Swapnendu Dt 15 -Sep 2010. 
  public RecordMetaInfo getCityLocMapHeaderMetaInfo(CityLocMapQueryVO oCityLocMapQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCityLocMapQueryVO.getHdnEmpLbrFlag()));      
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oCityLocMapQueryVO.getTxtLocidSrch()));      
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountCityTypeLocMap(?,?,?,?,?)");

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    return oRecordMetaInfo;
  }

//added by Swapnendu Dt 16 sep-2010.
  public ArrayList getCityLocMapHeader(CityLocMapQueryVO oCityLocMapQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oCityLocMapQueryVO == null)
    {
      oCityLocMapQueryVO = new CityLocMapQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCityLocMapQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oCityLocMapQueryVO.getTxtLocidSrch()));      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.PROC_CITYLOCMAPHEADER(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MaintCityLocMapHeaderBean oMaintCityLocMapHeaderBean;
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
          oMaintCityLocMapHeaderBean = new MaintCityLocMapHeaderBean();
          oMaintCityLocMapHeaderBean.setTxtLocidSrch(oRow.get("loc_id").getString());
          oMaintCityLocMapHeaderBean.setTxtLocSrch(oRow.get("LOC_DESC").getString());
          oHeaderList.add(oMaintCityLocMapHeaderBean);
      }              
    return oHeaderList;
  }

  public RecordMetaInfo getCityLocMapDetailMetaInfo(BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    CityLocMapDetailInfo oCityLocMapDetailInfo = (CityLocMapDetailInfo)oBaseDetailInfo;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oCityLocMapDetailInfo.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCityLocMapDetailInfo.getTxtLocidSrch())));  // added By swapnendu dt 30 aug 2010
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountCityTypeLocMap(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getCityLocMapDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintCityLocMapBean oMaintCityLocMapBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oEmpLeaveDetail = null;
    CityLocMapDetailInfo oCityLocMapDetailInfo = (CityLocMapDetailInfo)oBaseDetailInfo;
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCityLocMapDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCityLocMapDetailInfo.getTxtLocidSrch())));  //Added by Swapnendu on Dt 25-Aug 2010.
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetCityTypeLocMap(?,?,?,?,?,?)");
      
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
            oEmpLeaveDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintCityLocMapBean = new MaintCityLocMapBean();
          oMaintCityLocMapBean.setTxtLocId(oRow.get("loc_id").getString()); 
          oMaintCityLocMapBean.setTxtLoc((oRow.get("loc_desc").getString()));
          oMaintCityLocMapBean.setStatus("U");
          oMaintCityLocMapBean.setTxtAreaTyp(oRow.get("area_typ_gbl").getString());
          oMaintCityLocMapBean.setTxtPopTyp(oRow.get("population").getString());
          oMaintCityLocMapBean.setTxtCityTyp(oRow.get("city_typ_gbl").getString());
          oMaintCityLocMapBean.setTxtFrom((EnrgiseUtil.convertToString(oRow.get("start_dt").getDate())));
          oMaintCityLocMapBean.setTxtTo(EnrgiseUtil.convertToString(oRow.get("end_dt").getDate()));          
          oMaintCityLocMapBean.setDetailId((oRow.get("city_typ_loc_map_id").getString()));
          oMaintCityLocMapBean.setTxtTranCityTyp((oRow.get("TRNSPRT_CITY").getString()));
          oMaintCityLocMapBean.setTxtMgwCityTyp((oRow.get("mgw_type").getString()));
          oEmpLeaveDetail.add(oMaintCityLocMapBean);
        }
    return oEmpLeaveDetail;
  }

  public CityLocMapComboVO getCityLocMapComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    CityLocMapComboVO oCityLocMapComboVO = new CityLocMapComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oCityTyp = null;
    ArrayList oAreaTyp = null;
    ArrayList oPopTyp = null;
    ArrayList oTranCityTyp = null;
    ArrayList oMgwCityTyp = null;
   // COMBO FOR CITY TYPE
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
            oCityTyp = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_desc").getString();
          String ctgryValue = oRow.get("code_sdesc").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oCityTyp.add(oComboVO);
        }
   
        oCityLocMapComboVO.setCityTypList(oCityTyp);
    
    
     // COMBO FOR REMOTE AREA TYPE
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
            oAreaTyp = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_sdesc").getString();
          String ctgryValue = oRow.get("code_sdesc").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oAreaTyp.add(oComboVO);
        }

      
    /* Newly Added */
    oCityLocMapComboVO.setAreaTypList(oAreaTyp);


      // Combo for Population Type
       // COMBO FOR REMOTE AREA TYPE
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPopTypeLocLov(?,?)");
      
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
            oPopTyp = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_desc").getString();
          String ctgryValue = oRow.get("code_sdesc").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oPopTyp.add(oComboVO);
        }

      
    /* Newly Added */
    oCityLocMapComboVO.setPopTypList(oPopTyp);

//added by Swapnendu Dt 27 -Aug 2010.
    //Combo For TRANSPORT CITY TYPE LIST-------
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetTransCityLOV(?,?)");
      
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
            oTranCityTyp = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_sdesc").getString();
          String ctgryValue = oRow.get("code_sdesc").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oTranCityTyp.add(oComboVO);
        }
    oCityLocMapComboVO.setTranCityTypList(oTranCityTyp);
//added by Swapnendu Dt 27 -Aug 2010.

//added by Swapnendu Dt 26 Apr 2011
    //Combo For MGW city type-------
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetMGWCityType(?,?)");
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
            oMgwCityTyp = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("CODE_DESC").getString();
          String ctgryValue = oRow.get("GBL_CODE").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oMgwCityTyp.add(oComboVO);
        }
        
    oCityLocMapComboVO.setMgwCityTypList(oMgwCityTyp);
//added by Swapnendu Dt 26 Apr 2011.

    return oCityLocMapComboVO;
  }


//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      saveCityLocMapDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
  }
  
  private void saveCityLocMapDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    MaintCityLocMapHeaderBean oDummyHeaderBean = (MaintCityLocMapHeaderBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintCityLocMapBean oMaintCityLocMapBean = (MaintCityLocMapBean)oIt.next();
            if(oMaintCityLocMapBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
            {
              if(!bInsert)
              {
                oBeanInsert = new DBUtilitiesBean();
                oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertCityTypeLocMap(?,?,?,?,?,?,?,?,?,?)");
                bInsert = true;
              }
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtLocidSrch())));  //added by Swapnendu Dt 30 -Aug 2010.
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtCityTyp())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtAreaTyp())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtPopTyp())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtMgwCityTyp())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtFrom())));
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtTo())));  //added by Swapnendu Dt 30 -Aug 2010.
              oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
              oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
              oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtTranCityTyp())));  //added by Swapnendu Dt 30 -Aug 2010.
    
              oBeanInsert.addToBatch(oParameters);
            }
            else if(oMaintCityLocMapBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
            {
              if(!bUpdate)
              {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("PAYROLL_PKG.proc_UpdateCityTypeLocMap(?,?,?,?,?,?,?,?,?,?)");
                bUpdate = true;
              }
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getDetailId())));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtLocidSrch())));  //added by Swapnendu Dt 30 -Aug 2010.
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtCityTyp())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtAreaTyp())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtPopTyp())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtFrom())));                    
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtTo())));
              oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
              oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
              oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtTranCityTyp())));  //added by Swapnendu Dt 30 -Aug 2010.
              oBean.addToBatch(oParameters);
           
            }
            else if(oMaintCityLocMapBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
            {
              if(!bDelete)
              {
                oBeanDelete = new DBUtilitiesBean();
                oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteCityTypeLocMap(?)");
                bDelete = true;
              }
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getDetailId())));
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

  public LovVO getCityMapLocLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location Id");    
    arylstHeaderNames.add("Location Name");    
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
      /*oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_EmpLocData(?,?)");*/
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetPayMapCityLocLov(?,?,?,?)");
      
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
      
       oLOVBean.setDetailField1(oRow.get("loc_id").getString());            
       oLOVBean.setDetailField2(oRow.get("loc_desc").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
   //   checkDuplicateDetail(oDetailBeanArray);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
}