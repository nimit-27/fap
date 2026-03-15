package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;

import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipOprationComboVO;

public class WrkSlipBusinessObject extends BaseBO 
{
    public WrkSlipBusinessObject()
    {
        
    }
    
    public void initializeBOImpl(String sScreenName)
    {
     
    }
    
    public WrkSlipComboVO getWrkSlipComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList();
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      WrkSlipComboVO oWrkSlipComboVO = new WrkSlipComboVO();
      int count = 0;
      ArrayList oOutArray; //Output 
      ComboVO oComboVO=null;
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oWrkSlipNormTyp = null;
      ArrayList oWrkSlipLeadNorm = null;
      ArrayList oWrkSlipOprList = null;
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNormTypeList(?,?)");
        
      oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
      oOutArray = null;
      oParameters = null;
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
          oWrkSlipNormTyp = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String normTypLabel = oRow.get("code_desc").getString();
        String normTypValue = oRow.get("code_sdesc").getString();
        oComboVO = new ComboVO(normTypLabel,normTypValue);
        oWrkSlipNormTyp.add(oComboVO);
        oRow = null;
        oComboVO = null;
      }
      oList = null;
      oIt = null;
      oWrkSlipComboVO.setNormTypList(oWrkSlipNormTyp);
      oWrkSlipNormTyp = null;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNormTypeList(?,?)");
        
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
          oWrkSlipLeadNorm = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String leadNormLabel = oRow.get("code_desc").getString();
        String leadNormValue = oRow.get("code_sdesc").getString();
        oComboVO = new ComboVO(leadNormLabel,leadNormValue);
        oWrkSlipLeadNorm.add(oComboVO);
        oRow = null;
        oComboVO = null;
      }
      oWrkSlipComboVO.setLeadNormList(oWrkSlipLeadNorm);
      oWrkSlipLeadNorm = null;
      oList = null;
      oParameters=null;
      oOutArray=null;
      oIt=null;
      //oBean=null;

//added by swapnendu Dt 06 Feb 2012 start..
      String mou = "MoU I";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(mou)));
      oParameters.add(new DBObject(2, DBObject.OUT, ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3, DBObject.OUT, ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getOperationList(?,?,?)");
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
          oWrkSlipOprList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String oprValue = oRow.get("code_desc").getString();
        String oprLabel = oRow.get("code_sdesc").getString();
        oComboVO = new ComboVO(oprLabel,oprValue);
        oWrkSlipOprList.add(oComboVO);
        oRow = null;
        oComboVO = null;
      }
      oWrkSlipComboVO.setOperationList(oWrkSlipOprList);
      oWrkSlipOprList = null;
      oList = null;
      oParameters=null;
      oOutArray=null;
      oIt=null;
      oWrkSlipLeadNorm=null;
      oBean=null;
//added by swapnendu Dt 06 Feb 2012 end..
      return oWrkSlipComboVO;
    }
  
    public WrkSlipOprationComboVO getWrkSlipOprationCombo(MaintWrkSlipHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList();
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        WrkSlipOprationComboVO oWrkSlipOprationComboVO = new WrkSlipOprationComboVO();
        int count = 0;
        ArrayList oOutArray; //Output 
        ComboVO oComboVO=null;
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        ArrayList oWrkSlipOprList = null;
        //MaintWrkSlipHeaderBean oMaintWrkSlipHeaderBean = (MaintWrkSlipHeaderBean)oBaseHeaderBean;
        //oParameters = new ArrayList();
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oBaseHeaderBean.getHeaderPrimaryKey())));
        oParameters.add(new DBObject(2, DBObject.OUT, ParameterTypes.CURSOR));
        oParameters.add(new DBObject(3, DBObject.OUT, ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetSORCombo(?,?,?)");
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
          oWrkSlipOprList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String oprValue = oRow.get("operation_id").getString();
        String oprLabel = oRow.get("operation_desc").getString();
        oComboVO = new ComboVO(oprLabel,oprValue);
        oWrkSlipOprList.add(oComboVO);
        oRow = null;
        oComboVO = null;
        }
        oWrkSlipOprationComboVO.setOperationList(oWrkSlipOprList);
        return oWrkSlipOprationComboVO;
    }

    public RecordMetaInfo getWrkSlipHeaderMetaImpl(MaintWrkSlipQueryVO oMaintWrkSlipQueryVO) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
        ArrayList oOutArray; //Output 
    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getHdnGangId())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintWrkSlipQueryVO.getTxtWrkSlipDt())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtYYMM())));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetWrkSlipCount(?,?,?,?,?,?)");
          
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
        oBaseHeaderVO = null;
        oMaintWrkSlipQueryVO = null;
        return oRecordMetaInfo;
    }

    public ArrayList getWrkSlipHeaderRecord(MaintWrkSlipQueryVO oMaintWrkSlipQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
      
          if(oMaintWrkSlipQueryVO == null)
          {
            oMaintWrkSlipQueryVO = new MaintWrkSlipQueryVO();
          }
      
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getHdnGangId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintWrkSlipQueryVO.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtYYMM())));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetWrkSlip(?,?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          MaintWrkSlipHeaderBean oWrkSlipHeader;
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
              oWrkSlipHeader = new MaintWrkSlipHeaderBean();
              oWrkSlipHeader.setTxtSiteId(oMaintWrkSlipQueryVO.getTxtSiteId());
              oWrkSlipHeader.setTxtSiteName(oMaintWrkSlipQueryVO.getTxtSiteName());
              oWrkSlipHeader.setTxtGangName(oRow.get("GANG_NAME").getString());
              oWrkSlipHeader.setTxtSite(oRow.get("loc_desc").getString());    // added by dushyant on 17-03-2011
              oWrkSlipHeader.setHdnGangId(oRow.get("GANG_ID").getString());
              oWrkSlipHeader.setHdnWrkSlipId(oRow.get("WRKSLIP_ID").getString());
              oWrkSlipHeader.setHeaderPrimaryKey(oRow.get("WRKSLIP_ID").getString());
              oWrkSlipHeader.setTxtWrkSlipDt(EnrgiseUtil.convertToString(oRow.get("WRK_SLIP_DT").getDate()));
              oWrkSlipHeader.setHdnMou(oRow.get("MOU_CODE").getString());
              //oWrkSlipHeader.setTxtBagTyp(oRow.get("WT_FLG").getString());
              oWrkSlipHeader.setTxtYYMM(oMaintWrkSlipQueryVO.getTxtYYMM());
              oHeaderList.add(oWrkSlipHeader);
              oRow = null;
              oWrkSlipHeader = null;
          }   
        oParameters=null;
        oOutArray=null;
        oIt=null;
        oWrkSlipHeader=null;
        oBean=null;
        oOutObject=null;
        oMaintWrkSlipQueryVO = null;
        return oHeaderList;
    }
    
    /*public getOperationTypeCombo(MaintWrkSlipQueryVO oMaintWrkSlipQueryVO) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        ArrayList oOutArray; //Output 
        if(oMaintWrkSlipQueryVO == null)
        {
        oMaintWrkSlipQueryVO = new MaintWrkSlipQueryVO();
        }
        WrkSlipComboVO oWrkSlipComboVO = new WrkSlipComboVO();
    }*/
    
    public RecordMetaInfo getWrkSlipDetailMetaInfo(String sPrmaryKey,String sLbrTyp) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        ArrayList oOutArray; //Output 
    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrmaryKey)));
    //    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sLbrTyp)));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetWrkSlipDetailCount(?,?,?,?)");
          
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
    
    public ArrayList getWrkSlipDetail(String sPrimaryKey,String sLbrTyp,long lStartPosition,long lLastPosition) throws EnrgiseSystemException,EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
    
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(sLbrTyp)));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetWrkSlipDetail(?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          MaintWrkSlipBean oWrkSlipBean;
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
              oWrkSlipBean = new MaintWrkSlipBean();
              oWrkSlipBean.setHdnWrkSlipDtlId(oRow.get("WRKSLIP_DTL_ID").getString());
              oWrkSlipBean.setTxtNormTyp(oRow.get("NORM_TYPE").getString());
              oWrkSlipBean.setTxtBags(oRow.get("NO_BAGS").getString());
              oWrkSlipBean.setTxtBagTyp(oRow.get("WT_FLG").getString());
              oWrkSlipBean.setHdnHndlngNormId(oRow.get("NORM_ID").getString());
              //oWrkSlipBean.setTxtHndlngNorm(oRow.get("NORM_ID").getString());
              oWrkSlipBean.setHdnHndlngNormUnit(oRow.get("NORM_UNIT_TYPE").getString());
              oWrkSlipBean.setTxtOTHrs(oRow.get("OTA_HRS").getString());
              oWrkSlipBean.setTxtSlab(oRow.get("slab_rate").getString());
              oWrkSlipBean.setHdnSlabId(oRow.get("SLAB_ID").getString());
              oWrkSlipBean.setTxtEmpList(oRow.get("lbr_list").getString());              
              oWrkSlipBean.setTxtStartHrs(oRow.get("strt_hr").getString());
              oWrkSlipBean.setTxtStartMin(oRow.get("strt_mi").getString());
              oWrkSlipBean.setTxtEndHrs(oRow.get("end_hr").getString());
              oWrkSlipBean.setTxtEndMin(oRow.get("end_mi").getString());
              if(oRow.get("cont_wrk_chk").getString().equals("Y"))
              {
                  oWrkSlipBean.setChkContWork(true);
                  oWrkSlipBean.setHdnContWork("Y");
              }
              else
              {
                  oWrkSlipBean.setChkContWork(false);
                  oWrkSlipBean.setHdnContWork("N");
              }
              oWrkSlipBean.setStatus("Q");
              oHeaderList.add(oWrkSlipBean);
              oRow = null;
              oWrkSlipBean = null;
          }  
       oParameters=null;
       oOutArray=null;
       oIt=null;
       oWrkSlipBean=null;
       oBean=null;
       oList = null;
       oOutObject=null;
       return oHeaderList;
    }

    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {  
        saveWrkSlipDtls(sHeaderPrimaryKey,(MaintWrkSlipHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }
    
    private void saveWrkSlipDtls(String sHeaderPrimaryKey,MaintWrkSlipHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray)throws EnrgiseSystemException
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
        MaintWrkSlipBean oMaintWrkSlipBean = (MaintWrkSlipBean)oIt.next();
        if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertWrkSlipDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getHdnHndlngNormId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBags())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtNormTyp())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getHdnSlabId())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOTHrs())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtStartHrs())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtStartMin())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtEndHrs())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtEndMin())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtEmpList())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBagTyp())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getHdnContWork())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
          oParameters = null;
        }
        else if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateWrkSlipDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getHdnWrkSlipDtlId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getHdnHndlngNormId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBags())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtNormTyp())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getHdnSlabId())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOTHrs())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtStartHrs())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtStartMin())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtEndHrs())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtEndMin())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtEmpList())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBagTyp())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getHdnContWork())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          oParameters = null;
        }
        else if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteWrkSlipDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey))); //added by swapnendu on 25 feb 2011
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oMaintWrkSlipBean.getHdnWrkSlipDtlId())));
          oBeanDelete.addToBatch(oParameters);          
          oParameters = null;
        }
          oMaintWrkSlipBean = null;

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
          oBean = null;
          oBeanInsert = null;
          oBeanDelete = null;
      }
    }

    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;
      MaintWrkSlipHeaderBean oMaintWrkSlipHeaderBean = (MaintWrkSlipHeaderBean)oBaseHeaderBean;
      
      ArrayList oOutArray; //Output 
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipHeaderBean.getHdnGangId())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintWrkSlipHeaderBean.getTxtWrkSlipDt()))));
      //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(oMaintWrkSlipHeaderBean.getTxtBagTyp()))); commented by swapnendu Dt 20 May 2011
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER)); 
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_InsertWrkSlip(?,?,?,?,?,?)",true,true);

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oParameters = null;
      oOutArray = null;
      oBean=null;
      oMaintWrkSlipHeaderBean = null;
      return (String)oOutObject.getObject();
    }
    
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
    {
     
    }
    
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oList=new ArrayList();
      if(sScreenMode.equals("N"))
      {
        checkDuplicacy(oBaseHeaderBean,oList);
      }
      reportError(oList);
      if(sScreenName.equals("WrkSlipScreen"))
      {
        oList=new ArrayList();
        chkValidBagType(oBaseHeaderBean, oDetailBeanArray, oList);
        reportError(oList);
      }
      checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList); // Added by dushyant on 27-Nov-2012
	  chkGangForLbrList(oBaseHeaderBean, oDetailBeanArray, oList);
      reportError(oList);
    }
    
    public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
    }

    public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
    }
    
  public void deleteHeaderImpl(String sPrimaryKey) throws EnrgiseSystemException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;
      
      ArrayList oOutArray; //Output 
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_DeleteWrkSlip(?,?)");
      oParameters=null;
      oOutArray=null;
      oBean=null;
  }
  
  public LovVO getWrkSlipGangLOVDataQ(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");    
    arylstHeaderNames.add("Gang Name");
   // arylstHeaderNames.add("Labour Type");
    arylstHeaderNames.add("MOU");
    arylstHeaderNames.add("Depo Name");   // added by dushaynt on 10-03-2011 for depo location 
    
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    // added by dushaynt on 10-03-2011 for depo location 
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      //Passing Null value for Depot Id...
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtLbrTyp").trim()));      
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getLOVGang(?,?,?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("gang_id").getString());            
       oLOVBean.setDetailField2(oRow.get("gang_name").getString());           
       //oLOVBean.setDetailField3(oRow.get("site_id").getString());           
   //  oLOVBean.setDetailField4(oRow.get("loc_desc").getString());
  //   oLOVBean.setDetailField5(oRow.get("lbr_typ").getString());
       oLOVBean.setDetailField3(oRow.get("mou_code").getString());
       oLOVBean.setDetailField4(oRow.get("loc_desc").getString());    // added by dushaynt on 10-03-2011 for depo location   
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean = null;
    }     
    oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  public LovVO getWrkSlipNormSlabLOV(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Slab Id");     
    arylstHeaderNames.add("Slab Range");   
    arylstHeaderNames.add("Rates");
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtNormTyp"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtMou"))).trim()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtBagTyp"))).trim()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getSlabLOV(?,?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("norm_id").getString());            
       oLOVBean.setDetailField2(oRow.get("norm_min_limit").getString()+"-"+oRow.get("norm_max_limit").getString()); 
       oLOVBean.setDetailField3(oRow.get("norm_percent").getString());           
   //    oLOVBean.setDetailField3(oRow.get("site_id").getString());           
   //    oLOVBean.setDetailField4(oRow.get("loc_desc").getString());
  //     oLOVBean.setDetailField5(oRow.get("lbr_typ").getString());
      
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean = null;
    }     
    oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  public LovVO getWrkSlipHndlingNormLOV(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("HndlingNorm Id");    
    arylstHeaderNames.add("Type of Work");   
    arylstHeaderNames.add("Unit");
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtMou"))).trim()));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHandlingNormLOV(?,?,?)");
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
      oLOVBean.setDetailField1(oRow.get("NORM_ID").getString());            
      oLOVBean.setDetailField2(oRow.get("NORM_DESC").getString());            
      oLOVBean.setDetailField3(oRow.get("NORM_UNIT_TYPE").getString());     
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean = null;
    }     
    oLovVO.setDetailList(oList);
    oList = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  private void checkDuplicacy(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      MaintWrkSlipHeaderBean oMaintWrkSlipHeaderBean = (MaintWrkSlipHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintWrkSlipHeaderBean.getHdnGangId()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintWrkSlipHeaderBean.getTxtWrkSlipDt()))));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_wrkSlipDuplChk(?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("wenrgise.common.dupliCheck",oArguments));
      }
      oParameters = null;
      oOutArray = null;
      oBean = null;
      oMaintWrkSlipHeaderBean = null;
  }
  
  private void chkValidBagType(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        QueryRow oRow = null;
        
        Iterator oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
            MaintWrkSlipBean  oMaintWrkSlipBean = (MaintWrkSlipBean)oIt.next();
            count++;
            if(oMaintWrkSlipBean.getStatus().equals("N") || oMaintWrkSlipBean.getStatus().equals("U"))
            {
                String oprId = oMaintWrkSlipBean.getHdnHndlngNormId();
                String bagTyp = oMaintWrkSlipBean.getHdnHndlngNormUnit(); 
                ArrayList oParameters = new ArrayList();
                oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, oMaintWrkSlipBean.getHdnHndlngNormId()));
                oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, oMaintWrkSlipBean.getHdnHndlngNormUnit()));
                oParameters.add(new DBObject(3, DBObject.OUT, ParameterTypes.VARCHAR));
                oParameters.add(new DBObject(4, DBObject.OUT, ParameterTypes.INTEGER));
                oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_ChkValidBagType(?,?,?,?)");
                String chkFlag = (String)((DBObject)oOutArray.get(0)).getObject();
                Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
                if(chkFlag != null)
                {
                    ArrayList oArguments = new ArrayList();
                    oArguments.add(new String(chkFlag));
                    oArguments.add(new Integer(count));
                    oList.add(new EnrgiseApplicationException("Payroll.Labour.InvalidUnit",oArguments));
                    oArguments = null;
                }
            }
        }
        oIt = null;
        
  }
  
  private void chkGangForLbrList(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        QueryRow oRow = null;
        MaintWrkSlipHeaderBean oMaintWrkSlipHeaderBean = (MaintWrkSlipHeaderBean)oBaseHeaderBean;
        Iterator oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
            MaintWrkSlipBean  oMaintWrkSlipBean = (MaintWrkSlipBean)oIt.next();
            count++;
            if(oMaintWrkSlipBean.getStatus().equals("N") || oMaintWrkSlipBean.getStatus().equals("U"))
            {
                ArrayList oParameters = new ArrayList();
                oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, oMaintWrkSlipHeaderBean.getHdnGangId()));
                oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, oMaintWrkSlipBean.getTxtEmpList()));
                oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, oMaintWrkSlipHeaderBean.getTxtWrkSlipDt()));
                oParameters.add(new DBObject(4, DBObject.OUT, ParameterTypes.VARCHAR));
                oParameters.add(new DBObject(5, DBObject.OUT, ParameterTypes.INTEGER));
                oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.PROC_CHKGANG_FOR_LBRLIST(?,?,?,?,?)",true,true);
                Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
                String errMsg = (String)((DBObject)oOutArray.get(0)).getObject();
                if(!(errCode.toString()).equals("0"))
                {
                    ArrayList oArguments = new ArrayList();
                    oArguments.add(errMsg);
                    oArguments.add(new Integer(count));
                    oList.add(new EnrgiseApplicationException("Payroll.Labour.LabourListChk",oArguments));
                    oArguments = null;
                }
            }
        }
        oIt = null;
  }
  public LovVO getWrkSlipSORLOV(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("SOR Id");    
    arylstHeaderNames.add("Type of Work");
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetSORLOV(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("operation_id").getString());            
       oLOVBean.setDetailField2(oRow.get("operation_desc").getString());     
      
      oList.add(oLOVBean);
    }     
      oLovVO.setDetailList(oList);
    oList = null;
    iter = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }

  public LovVO getWrkSlipEmpLOV(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Emp No");    
    arylstHeaderNames.add("Emp Name");   
    arylstHeaderNames.add("Designation");
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnGangId"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtWrkSlipDt"))).trim()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtEndHrs"))).trim()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtEndMin"))).trim()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetGangLbrLOV(?,?,?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("emp_num").getString());            
      oLOVBean.setDetailField2(oRow.get("emp_name").getString());           
      oLOVBean.setDetailField3(oRow.get("mbr_typ").getString());     
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean = null;
    }     
    oLovVO.setDetailList(oList);
    oList = null;
    iter = null;
    oBean = null;
    oOutArray = null;
    oOutObject = null;
    oParameters = null;
    arylstHeaderNames = null;
    arylstVisibility = null;
    return oLovVO;
  }
  //  Added by dushyant on 29-Nov-2012 to stop workslip check after initialisation.
   private void checkYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;    
      MaintWrkSlipHeaderBean oMaintWrkSlipHeaderBean=(MaintWrkSlipHeaderBean)oBaseHeaderBean;   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintWrkSlipHeaderBean.getTxtWrkSlipDt())))); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintWrkSlipHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oMaintWrkSlipHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));    
      oOutArray = oBean.callProc(oParameters,"pkg_lbr_single_month_end.proc_GetWrkskipStatus(?,?,?,?,?)"); 
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

      String sRevYear = "";
      String status = "";   
      String arcFlag="";
      String emplbr="";
      
      oIt = oRetList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        sRevYear = oRow.get("yymm").getString(); 
        status = oRow.get("status").getString(); 
        arcFlag = oRow.get("arc_flag").getString();
        emplbr = oRow.get("emp_type").getString(); 
      }

    if(arcFlag!=null && arcFlag.equals("Y")&& (emplbr.equals("A")||emplbr.equals("I"))) /*condition modified by ashish bansal on 15-02-2013 for dept. labour*/
    {
      if(status!=null && (Integer.parseInt(status) >= 3))
      {
        //throw new EnrgiseApplicationException("payroll.Common.PayrollDone");
        oList = new ArrayList();
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(sRevYear));
        oList.add(new EnrgiseApplicationException("Payroll.Labour.WorkslipMondchek",oArguments));
        reportError(oList);
      }
      else
        throw new EnrgiseApplicationException("payroll.Labour.Workslipcheck");
    }         
  }
  
  // End 

}