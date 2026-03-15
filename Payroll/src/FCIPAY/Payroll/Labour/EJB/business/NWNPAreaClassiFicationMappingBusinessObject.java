package FCIPAY.Payroll.Labour.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.NWNPCityLocMapDetailInfo;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaClassiFicationMappingQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaMappingComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourOprtnDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPWrkSlipComboVO;
import FCIPAY.Payroll.Labour.Utility.NWNPAreaClassiFicationMappingBean;
import FCIPAY.Payroll.Labour.Utility.NWNPAreaClassiFicationMappingHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourOprtnDtlBean;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapBean;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;

import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NWNPAreaClassiFicationMappingBusinessObject extends BaseBO{
    public NWNPAreaClassiFicationMappingBusinessObject() {
       
    }
    
    public ArrayList getNWNPAreaClassiFicationMappingDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output     
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oNWNPLabourSORDtl = null;
      NWNPLabourOprtnDtlBean oNWNPLabourOprtnDtlBean;
     
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(sPrimaryKey)));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getnwnplbroprtndetail(?,?,?,?,?)");
        
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
              oNWNPLabourSORDtl = new ArrayList();
             
            }
            count++;
            oRow = (QueryRow)oIt.next();
            oNWNPLabourOprtnDtlBean = new NWNPLabourOprtnDtlBean();
            oNWNPLabourOprtnDtlBean.setDetailId((oRow.get("operation_id").getString()));
            oNWNPLabourOprtnDtlBean.setTxtOperation((oRow.get("operation_desc").getString()));
            oNWNPLabourOprtnDtlBean.setStatus("Q");
    
            oNWNPLabourSORDtl.add(oNWNPLabourOprtnDtlBean);
          }        
      return oNWNPLabourSORDtl;
      
    }

    public LovVO getNwnpCityMapLocLovData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        LovVO oLovVO=new LovVO();  
        ArrayList arylstHeaderNames=new ArrayList();
        arylstHeaderNames.add("locid");  
        arylstHeaderNames.add("LocDesc"); 
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
          if(!oLovQueryVO.getSearchField1().equals("")){
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
          }else{
                 oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
              }
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_GetNwnpPayMapCityLocLov(?,?,?,?)");
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
          
          oLOVBean.setDetailField1(oRow.get("LOC_ID").getString());            
          oLOVBean.setDetailField2(oRow.get("LOC_DESC").getString());   
           
          oList.add(oLOVBean);
        }
          oLovVO.setDetailList(oList);
        return oLovVO;
      }

    public NWNPAreaMappingComboVO getNwnpAreaMappComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList();
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      NWNPAreaMappingComboVO oNwnpAreaMappComboVO = new NWNPAreaMappingComboVO();
      int count = 0;
      ArrayList oOutArray; //Output 
      ComboVO oComboVO=null;
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      
      ArrayList oAreaMapOprList = null;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1, DBObject.OUT, ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2, DBObject.OUT, ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNwnpOperationList(?,?)");
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
          oAreaMapOprList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String oprValue = oRow.get("code_desc").getString();
        String oprLabel = oRow.get("code_sdesc").getString();
        oComboVO = new ComboVO(oprLabel,oprValue);
        oAreaMapOprList.add(oComboVO);
        oRow = null;
        oComboVO = null;
      }
      oNwnpAreaMappComboVO.setLocationList(oAreaMapOprList);
      oAreaMapOprList = null;
      oList = null;
      oParameters=null;
      oOutArray=null;
      oIt=null;
      oBean=null;
      return oNwnpAreaMappComboVO;
    }


    public RecordMetaInfo getNWNPCityLocMapDetailMetaInfo(BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      NWNPCityLocMapDetailInfo oNwnpCityLocMapDetailInfo = (NWNPCityLocMapDetailInfo)oBaseDetailInfo;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNwnpCityLocMapDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpCityLocMapDetailInfo.getTxtDPLocidSrch())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_countnwnpcitytypelocmap(?,?,?,?,?)");
        
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
        return oRecordMetaInfo;            
    }

    public RecordMetaInfo getNWNPCityLocMapHeaderMetaInfo(NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      Timestamp oWhenPicked = null;
      int count = 0;
      BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
      
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNWNPAreaClassiFicationMappingQueryVO.getHdnEmpLbrFlag()));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oNWNPAreaClassiFicationMappingQueryVO.getTxtDPLocidSrch()));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_CountNwnpCityTypeLocMap(?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    }


    public ArrayList getNWNPCityLocMapHeader(NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;

      if(oNWNPAreaClassiFicationMappingQueryVO == null)
      {
        oNWNPAreaClassiFicationMappingQueryVO = new NWNPAreaClassiFicationMappingQueryVO();
      }
      
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;



        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNWNPAreaClassiFicationMappingQueryVO.getHdnEmpLbrFlag()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oNWNPAreaClassiFicationMappingQueryVO.getTxtDPLocidSrch()));      
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.PROC_NWNPCITYLOCMAPHEADER(?,?,?,?,?,?)");
        
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

    public ArrayList getNWNPCityLocMapDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      NWNPAreaClassiFicationMappingBean oNWNPAreaClassiFicationMappingBean;
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oEmpLeaveDetail = null;
      NWNPCityLocMapDetailInfo oNWNPCityLocMapDetailInfo = (NWNPCityLocMapDetailInfo)oBaseDetailInfo;
      
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPCityLocMapDetailInfo.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPCityLocMapDetailInfo.getTxtDPLocidSrch())));  //Added by Swapnendu on Dt 25-Aug 2010.
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getnwnpcitytypelocmap(?,?,?,?,?,?)");
        
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
            oNWNPAreaClassiFicationMappingBean = new NWNPAreaClassiFicationMappingBean();
            oNWNPAreaClassiFicationMappingBean.setTxtLocId(oRow.get("loc_id").getString()); 
            oNWNPAreaClassiFicationMappingBean.setTxtLoc((oRow.get("loc_desc").getString()));
            oNWNPAreaClassiFicationMappingBean.setTxtCityTypId(oRow.get("city_type_id").getString());               
            oNWNPAreaClassiFicationMappingBean.setStatus("U");
            oNWNPAreaClassiFicationMappingBean.setTxtAreaTyp(oRow.get("area_type").getString());
            //oNWNPAreaClassiFicationMappingBean.setTxtPopTyp(oRow.get("population").getString());
            //oNWNPAreaClassiFicationMappingBean.setTxtCityTyp(oRow.get("city_typ_gbl").getString());
            oNWNPAreaClassiFicationMappingBean.setTxtFrom((EnrgiseUtil.convertToString(oRow.get("start_dt").getDate())));
            oNWNPAreaClassiFicationMappingBean.setTxtTo(EnrgiseUtil.convertToString(oRow.get("end_date").getDate()));          
            //oNWNPAreaClassiFicationMappingBean.setDetailId((oRow.get("city_typ_loc_map_id").getString()));
            //oNWNPAreaClassiFicationMappingBean.setTxtTranCityTyp((oRow.get("TRNSPRT_CITY").getString()));
            //oNWNPAreaClassiFicationMappingBean.setTxtMgwCityTyp((oRow.get("mgw_type").getString()));
            oEmpLeaveDetail.add(oNWNPAreaClassiFicationMappingBean);
          }
      return oEmpLeaveDetail;
    }

    @Override
    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
        saveNWNPCityLocMapDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }

    private void saveNWNPCityLocMapDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
      boolean bInsert = false;
      boolean bUpdate = false;
      boolean bDelete = false;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = null;
      DBUtilitiesBean oBeanInsert = null;
      DBUtilitiesBean oBeanDelete = null;
      NWNPAreaClassiFicationMappingHeaderBean oDummyHeaderBean = (NWNPAreaClassiFicationMappingHeaderBean)oBaseHeaderBean;
      
        Iterator oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
          NWNPAreaClassiFicationMappingBean oMaintCityLocMapBean = (NWNPAreaClassiFicationMappingBean)oIt.next();
              if(oMaintCityLocMapBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
              {
                if(!bInsert)
                {
                  oBeanInsert = new DBUtilitiesBean();
                  oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertNwnpCityTypeLocMap(?,?,?,?,?,?)");
                  bInsert = true;
                }
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtDPLocidSrch())));
                //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtCityTypId())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtAreaTyp())));
                //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtPopTyp())));
                //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtMgwCityTyp())));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtFrom())));
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtTo())));
                oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
                //oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtTranCityTyp())));
      
                oBeanInsert.addToBatch(oParameters);
              }
              else if(oMaintCityLocMapBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
              {
                if(!bUpdate)
                {
                  oBean = new DBUtilitiesBean();
                  oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateNwnpCityTypeLocMap(?,?,?,?,?,?,?)");
                  bUpdate = true;
                }
                oParameters = new ArrayList();
                //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getDetailId())));
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtCityTypId())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtDPLocidSrch())));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtAreaTyp())));
                //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtPopTyp())));
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtFrom())));                    
                oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintCityLocMapBean.getTxtTo())));
                oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
                //oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityLocMapBean.getTxtTranCityTyp())));
                oBean.addToBatch(oParameters);
             
              }
              else if(oMaintCityLocMapBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
              {
                if(!bDelete)
                {
                  oBeanDelete = new DBUtilitiesBean();
                  oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteCityTypeLocMap(?)");
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




    @Override
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
        return null;
    }

    @Override
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
    }

    @Override
    public void initializeBOImpl(String sScreenName) {
    }

    @Override
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                              String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                              ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                              Timestamp oDetailPicked) {
    }

    @Override
    public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                                  String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                                  ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                                  Timestamp oDetailPicked) {
    }

    @Override
    public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                                 String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                                 ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                                 Timestamp oDetailPicked) {
    }
}
