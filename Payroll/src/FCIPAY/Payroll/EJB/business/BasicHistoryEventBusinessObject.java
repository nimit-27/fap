package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.BasicHistoryEventQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IncomeTaxRegimeQueryVO;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.UTILITY.BasicHistoryEventBean;
import FCIPAY.Payroll.UTILITY.BasicHistoryEventHeaderBean;
import FCIPAY.Payroll.UTILITY.IncomeTaxRegimeBean;
import FCIPAY.Payroll.UTILITY.IncomeTaxRegimeHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;

import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicHistoryEventBusinessObject extends BaseBO {
    public BasicHistoryEventBusinessObject() {

    }

    public LovVO getBasicHistoryEventEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException,
                                                                             EnrgiseApplicationException {

        LovVO oLovVO = new LovVO();
        ArrayList arylstHeaderNames = new ArrayList();
        arylstHeaderNames.add("Employee No");
        arylstHeaderNames.add("Employee Name");
        arylstHeaderNames.add("CPF Code");
        oLovVO.setHeaderList(arylstHeaderNames);

        ArrayList arylstVisibility = new ArrayList();
        arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
        arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
        arylstVisibility.add(FCIPAY.Payroll.common.utility.EnrgiseConstants.VISIBLE);
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
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, (new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oLovQueryVO.getSearchField1())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oLovQueryVO.getSearchField2())));
        oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR, (new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));
        oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.VARCHAR, new String(oLovQueryVO.getSearchField3())));
        oParameters.add(new DBObject(6, DBObject.OUT, ParameterTypes.CURSOR));
        oParameters.add(new DBObject(7, DBObject.OUT, ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters, "pkg_pay_basic_data_fix.proc_getBasicHistEventEmpLovq(?,?,?,?,?,?,?)");
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());

        QueryRow oRow = null;

        Iterator iter = oList.iterator();
        while (iter.hasNext()) {
            if (count == 0) {
                oList = new ArrayList();
            }
            count++;
            oRow = (QueryRow)iter.next();
            oLOVBean = new LOVBean();

            oLOVBean.setDetailField1(oRow.get("emp_num").getString());
            oLOVBean.setDetailField2(oRow.get("Name").getString());
            oLOVBean.setDetailField3(oRow.get("cpf_code").getString());

            oList.add(oLOVBean);
        }

        oLovVO.setDetailList(oList);
        return oLovVO;
    }


    public RecordMetaInfo getBasicHistoryEventHeaderMetaImpl(BasicHistoryEventQueryVO oBasicHistoryEventQueryVO) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
        ArrayList oOutArray; //Output 
    
        //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oIncomeTaxRegimeQueryVO.getSiteId())));
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventQueryVO.getTxtEmpId())));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pay_basic_data_fix.proc_GetBasicHistEventCount(?,?,?,?)");
          
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        //DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        //oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        oRecordMetaInfo.setRecordCount(1);
        oParameters=null;
        oOutArray=null;
        oBean=null;
        oTimeObject=null;
        //oTotalRecord=null;
        oBaseHeaderVO = null;
        oBasicHistoryEventQueryVO = null;
        return oRecordMetaInfo;
    }

    public ArrayList getBasicHistoryEventHeaderRecord(BasicHistoryEventQueryVO oBasicHistoryEventQueryVO, long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
      
          if(oBasicHistoryEventQueryVO == null)
          {
            oBasicHistoryEventQueryVO = new BasicHistoryEventQueryVO();
          }
      
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventQueryVO.getTxtEmpId())));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_pay_basic_data_fix.proc_GetBasicHistEventDetail(?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          BasicHistoryEventHeaderBean oBasicHistoryEventHeaderBean;
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
              oBasicHistoryEventHeaderBean = new BasicHistoryEventHeaderBean();
              oBasicHistoryEventHeaderBean.setTxtSiteID(oBasicHistoryEventQueryVO.getTxtSiteId());
              oBasicHistoryEventHeaderBean.setTxtSiteName(oBasicHistoryEventQueryVO.getTxtSiteName());
              oBasicHistoryEventHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
              oBasicHistoryEventHeaderBean.setTxtEmpId(oRow.get("EMP_NUM").getString());
              oBasicHistoryEventHeaderBean.setTxtEmpName(oBasicHistoryEventQueryVO.getTxtEmpName());
              
              oHeaderList.add(oBasicHistoryEventHeaderBean);
              oRow = null;
              oBasicHistoryEventHeaderBean= null;
          }   
        oParameters=null;
        oOutArray=null;
        oIt=null;
        oBasicHistoryEventHeaderBean=null;
        oBean=null;
        oOutObject=null;
        oBasicHistoryEventQueryVO = null;
        return oHeaderList;
    }

    public RecordMetaInfo getBasicHistoryEventDetailMetaInfo(String sPrmaryKey,String sLocId) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        ArrayList oOutArray; //Output 
        
        //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(sLocId)));
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrmaryKey)));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pay_basic_data_fix.proc_GetBasicHistEventCount(?,?,?,?)");
          
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        oParameters=null;
        oOutArray=null;
        oBean=null;
        oTimeObject=null;
        oTotalRecord=null;
        return oRecordMetaInfo;
    }

    public ArrayList getBasicHistoryEventDetail(String sPrimaryKey, String sLocId, long lStartPosition, long lLastPosition) throws EnrgiseSystemException,EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
    
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sLocId)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_pay_basic_data_fix.proc_GetBasicHistEventDetail(?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          BasicHistoryEventBean oBasicHistoryEventBean;
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
              oBasicHistoryEventBean = new BasicHistoryEventBean();
              oBasicHistoryEventBean.setTxtSrlNo(count);
              oBasicHistoryEventBean.setTxtEventEffDate(FCIPAY.Payroll.common.utility.EnrgiseUtil.convertToString(oRow.get("vstart_dt").getDate()));
              oBasicHistoryEventBean.setTxtIncrementType(oRow.get("vincr_type").getString());
              oBasicHistoryEventBean.setTxtEventType(oRow.get("event_desc").getString());
              oBasicHistoryEventBean.setTxtAmount(oRow.get("vbasic").getString());
              oBasicHistoryEventBean.setTxtEventFlag(oRow.get("appflag").getString());
              oBasicHistoryEventBean.setTxtFreezeFlag(oRow.get("Frzflag").getString());
          
              oBasicHistoryEventBean.setStatus("Q");
              oHeaderList.add(oBasicHistoryEventBean);
              oRow = null;
              oBasicHistoryEventBean = null;
          } 
        oParameters=null;
        oOutArray=null;
        oIt=null;
        oBasicHistoryEventBean=null;
        oBean=null;
        oList = null;
        oOutObject=null;
        return oHeaderList;
    }

    @Override
    public void saveDetailImpl(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException {
        saveBasicHistoryEventDtls(sHeaderPrimaryKey,(BasicHistoryEventHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }
    
    private void saveBasicHistoryEventDtls(String sHeaderPrimaryKey,BasicHistoryEventHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBean1 = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
        
        ArrayList oOutArray; //Output 
        ArrayList oList;
        DBUtilitiesBean oBean2 = new DBUtilitiesBean();
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(sHeaderPrimaryKey)));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean2.callProc(oParameters,"pkg_pay_basic_data_fix.PROC_COUNT_BASIC_HIST_EVENT(?,?,?)");
        
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        
      if(oList.size() == 0)
      {        
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        BasicHistoryEventBean oBasicHistoryEventBean = (BasicHistoryEventBean)oIt.next();
        if(oBasicHistoryEventBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_pay_basic_data_fix.PROC_INSERT_BASIC_HIST_EVENT(?,?,?,?,?,?,?)");
            bInsert = true;
          }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(sHeaderPrimaryKey)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtEventEffDate())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtIncrementType())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtEventType())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(!oBasicHistoryEventBean.getTxtAmount().equals("")?oBasicHistoryEventBean.getTxtAmount():"0")));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtEventFlag())));
           // oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtFreezeFlag())));
            if("Not Modified".equalsIgnoreCase(oBasicHistoryEventBean.getTxtFreezeFlag())){
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String("N")));
            }else if("Modified".equalsIgnoreCase(oBasicHistoryEventBean.getTxtFreezeFlag())){
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String("Y")));
            }else if("Freezed".equalsIgnoreCase(oBasicHistoryEventBean.getTxtFreezeFlag())){
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String("F")));
            }
            
            oBeanInsert.addToBatch(oParameters);
            oParameters = null;
                   
        }
        else if(oBasicHistoryEventBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_pay_basic_data_fix.PROC_UPDATE_BASIC_HIST_EVENT(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(sHeaderPrimaryKey)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtEventEffDate())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtIncrementType())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtEventType())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oBasicHistoryEventBean.getTxtAmount())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicHistoryEventBean.getTxtEventFlag())));
            
            if("Not Modified".equalsIgnoreCase(oBasicHistoryEventBean.getTxtFreezeFlag())){
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String("N")));
            }else if("Modified".equalsIgnoreCase(oBasicHistoryEventBean.getTxtFreezeFlag())){
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String("Y")));
            }else if("Freezed".equalsIgnoreCase(oBasicHistoryEventBean.getTxtFreezeFlag())){
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String("F")));
            }
            
          oBean.addToBatch(oParameters);
          oParameters = null;
        }
          oBasicHistoryEventBean = null;

      }
    }

      try
      {
          if(bInsert)
          {
              oBeanInsert.executeBatch();
              
              oBean1 = new DBUtilitiesBean();
              oBean1.createBatch("pkg_pay_basic_data_fix.PROC_UPDATE_BASIC_REVISION(?)");
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(sHeaderPrimaryKey)));
                
              oBean1.addToBatch(oParameters);
              oBean1.executeBatch();
              oParameters = null;
          }
      
          if(bUpdate)
          {
            oBean.executeBatch();   
          }
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
      finally
      {
          oBean = null;
          oBeanInsert = null;
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
