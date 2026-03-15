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
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
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
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintKotWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotWrkSlpDtlsVO;
import FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipBean;
import FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipBean;

public class KotWrkSlipBusinessObject extends BaseBO 
{
    public KotWrkSlipBusinessObject()
    {
        
    }
    
    public void initializeBOImpl(String sScreenName)
    {
     
    }
    
    public WrkSlipComboVO getWrkSlipComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      WrkSlipComboVO oWrkSlipComboVO = new WrkSlipComboVO();
      int count = 0;
      ArrayList oOutArray; //Output 
      ComboVO oComboVO=null;
     
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oWrkSlipLeadNorm = null;
      
      //To get Lead Norm Details
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getLeadNormTyp(?,?)");
        
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
      }

      oWrkSlipComboVO.setLeadNormList(oWrkSlipLeadNorm);
      return oWrkSlipComboVO;
    }
    
  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    String sPayModeType; 
    int count = 0;
    int i=0;
    MaintKotWrkSlipHeaderBean oMaintKotWrkSlipHeaderBean = (MaintKotWrkSlipHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output     

      oParameters = new ArrayList();     
      /* Employee Header Info */   
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getTxtWrkSlipDt())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getTxtWrkSlipTyp())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getHdnEmpLbrFlag())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getTxtLocId())));      
      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getTxtSiteID()))); 
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getHdnWrkSlipId())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR,new String(oMaintKotWrkSlipHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_InsertKotWrkSlipLbrHdr(?,?,?,?,?,?,?,?,?,?)",true,true);        
   
      DBObject oOutObject = (DBObject)oOutArray.get(1);
      String sEmpNo = (String)oOutObject.getObject();
       DBObject oMsgObject = (DBObject)oOutArray.get(2);    
      String error_msg = (String)oMsgObject.getObject();
      DBObject oErrObject = (DBObject)oOutArray.get(3);    
      Integer errorCode = (Integer)oErrObject.getObject();
      if(!(errorCode.equals(new Integer(0))))
      {        
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(error_msg));
         System.out.println("Error!!! while inserting wrkslip header::"+error_msg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
      
      return (String)oOutObject.getObject(); 
      
  }

  
    public RecordMetaInfo getWrkSlipHeaderMetaImpl(MaintKotWrkSlipQueryVO oMaintWrkSlipQueryVO) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        ArrayList oOutArray; //Output 
        String loginLocId = String.valueOf(oMaintWrkSlipQueryVO.getLoginLocCode());
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getHdnWrkSlipId())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintWrkSlipQueryVO.getTxtWrkSlipDt())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtWrkSlipTyp())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtYYMM())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtLocId())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(loginLocId)));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetKotWrkSlipCount(?,?,?,?,?,?,?,?,?)");
          
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        return oRecordMetaInfo;
    }

    public ArrayList getWrkSlipHeaderRecord(MaintKotWrkSlipQueryVO oMaintWrkSlipQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
      
          if(oMaintWrkSlipQueryVO == null)
          {
            oMaintWrkSlipQueryVO = new MaintKotWrkSlipQueryVO();
          }
          String loginLocId = String.valueOf(oMaintWrkSlipQueryVO.getLoginLocCode());      
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getHdnWrkSlipId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintWrkSlipQueryVO.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtWrkSlipTyp())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtYYMM())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipQueryVO.getTxtLocId())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(loginLocId)));
          oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetKotWrkSlip(?,?,?,?,?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          MaintKotWrkSlipHeaderBean oWrkSlipHeader;
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
              oWrkSlipHeader = new MaintKotWrkSlipHeaderBean();                      
              oWrkSlipHeader.setHeaderPrimaryKey(oRow.get("workslip_seq").getString());
              oWrkSlipHeader.setTxtLocId(oRow.get("worksite_id").getString());              
              oWrkSlipHeader.setTxtLoc(oRow.get("worksite_desc").getString());              
              oWrkSlipHeader.setHdnWrkSlipId(oRow.get("workslip_id").getString());              
              oWrkSlipHeader.setTxtWrkSlipDt(EnrgiseUtil.convertToString(oRow.get("workslip_dt").getDate()));
              oWrkSlipHeader.setTxtWrkSlipTyp(oRow.get("workslip_type").getString());              
              oWrkSlipHeader.setTxtYYMM(oRow.get("yyyymm").getString());
              oHeaderList.add(oWrkSlipHeader);
          }              
        return oHeaderList;
    }
    
    public RecordMetaInfo getKotWrkSlipDetailMetaInfo(String sPrmaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        ArrayList oOutArray; //Output 
        KotWrkSlpDtlsVO  oHdrBean = (KotWrkSlpDtlsVO)oBaseDetailInfo;
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrmaryKey)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHdrBean.getTxtYYMM())));        
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetKotWrkSlipDetailCount(?,?,?,?,?)");
          
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        return oRecordMetaInfo;

    }
    
    public ArrayList getKotWrkSlipDetail(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException,EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
    
          ArrayList oOutArray; //Output 
          KotWrkSlpDtlsVO  oHdrBean = (KotWrkSlpDtlsVO)oBaseDetailInfo;
          ArrayList oHeaderList = null;

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHdrBean.getTxtYYMM())));        
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetKotWrkSlipDetail(?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          MaintKotWrkSlipBean oWrkSlipBean;
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
              oWrkSlipBean = new MaintKotWrkSlipBean();        
              oWrkSlipBean.setTxtOperId(oRow.get("operation_id").getString());
              oWrkSlipBean.setTxtOperDesc(oRow.get("opr_desc").getString());
              oWrkSlipBean.setTxtOperDatum(oRow.get("datum_val").getString());
              oWrkSlipBean.setTxtBags(oRow.get("no_of_bags").getString());
              oWrkSlipBean.setTxtBagTyp(oRow.get("bag_type").getString());
              oWrkSlipBean.setTxtNormTyp(oRow.get("lead_norm").getString());
              oWrkSlipBean.setTxtIncentive(oRow.get("incentive").getString());
              oWrkSlipBean.setTxtOperSeq(oRow.get("operation_seq").getString());
              oWrkSlipBean.setStatus("Q");
              oHeaderList.add(oWrkSlipBean);
          }              
        return oHeaderList;

    }
    //Function to get Labour Detail Count in Kotwal Labour Screen
    public RecordMetaInfo getKotWrkSlipLbrDetailMetaInfo(String sPrmaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        ArrayList oOutArray; //Output 
        KotWrkSlpDtlsVO  oHdrBean = (KotWrkSlpDtlsVO)oBaseDetailInfo;
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrmaryKey)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHdrBean.getTxtYYMM())));        
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetKotWrkSlipLbrDetailCnt(?,?,?,?,?)");
          
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        return oRecordMetaInfo;

    }
    
    //Function to get Labour Detail in Kotwal Labour Screen
    public ArrayList getKotWrkSlipLbrDetail(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException,EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
    
          ArrayList oOutArray; //Output 
           KotWrkSlpDtlsVO  oHdrBean = (KotWrkSlpDtlsVO)oBaseDetailInfo;
          ArrayList oHeaderList = null;

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHdrBean.getTxtYYMM())));        
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetKotWrkSlipLbrDetail(?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          MaintKotWrkSlipBean oWrkSlipBean;
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
              oWrkSlipBean = new MaintKotWrkSlipBean();
              oWrkSlipBean.setTxtLbrCode(oRow.get("kot_lbr_id").getString());
              oWrkSlipBean.setTxtLbrID(oRow.get("labour_id").getString());
              oWrkSlipBean.setTxtLbrName(oRow.get("name1").getString());
              oWrkSlipBean.setTxtLbrDsgn(oRow.get("dsgn").getString());
              oWrkSlipBean.setTxtIncentivelbr(oRow.get("incentive").getString());
              
              oWrkSlipBean.setStatus("Q");
              oHeaderList.add(oWrkSlipBean);
          }              
        return oHeaderList;

    }
    
    
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {     
    if(sScreenName.equals("LabourWrkSlipScreen"))
    {   
      saveKotWrkSlip(sHeaderPrimaryKey,(MaintKotWrkSlipHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }
    else 
    {  
      saveKotWrkSlipDtl(sHeaderPrimaryKey,(MaintKotWrkSlipHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    } 
  }
    
  private void saveIncentive(MaintKotWrkSlipHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray)throws EnrgiseSystemException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;
      MaintKotWrkSlipHeaderBean oMaintWrkSlipHeaderBean = (MaintKotWrkSlipHeaderBean)oBaseHeaderBean;
      String firstDatum="";
      String firstOprBag="";
      
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintKotWrkSlipBean oMaintWrkSlipBean = (MaintKotWrkSlipBean)oIt.next();
        if(oMaintWrkSlipBean.getTxtOperDatum()!=null && !oMaintWrkSlipBean.getTxtOperDatum().equals(""))
        {
          firstDatum=oMaintWrkSlipBean.getTxtOperDatum();
          firstOprBag=oMaintWrkSlipBean.getTxtBags();
          break;
        }
      }
      ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oMaintWrkSlipHeaderBean.getTxtWrkSlipDt()))));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(firstDatum)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(firstOprBag)));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipHeaderBean.getTxtTotIncentive())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER)); 
      oOutArray = oBean.callProc(oParameters,"PKG_LBR_COMPUTE_INCT_V2.proc_InsertKotwalIncentive(?,?,?,?,?,?,?,?)",true,true);
  }
    
    
    //Method to submit Kotwal Labours Detail
    private void saveKotWrkSlip(String sHeaderPrimaryKey,MaintKotWrkSlipHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray)throws EnrgiseSystemException
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
        MaintKotWrkSlipBean oMaintWrkSlipBean = (MaintKotWrkSlipBean)oIt.next();
        if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
              oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertKotLbrDtls(?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();       
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtLbrID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtLbrDsgn())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtIncentivelbr())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getHdnEmpLbrFlag())));      
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_InsertKotWrkSlpLbrDtl(?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtLbrID())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtIncentivelbr())));       
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));          
          oBean.addToBatch(oParameters);
        }
        else if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {        
        if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteKotLbrDetail(?,?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtLbrID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          
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
    
    
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
    {
     
    }
    
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      if(bDetailDataChanged)
      {
        checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray,sScreenName);
      }
    }
    
    public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
    }

    public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
    }
    
    private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, String screenName) throws EnrgiseSystemException, EnrgiseApplicationException
    {    
      ArrayList oList = new ArrayList();  
      checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
      validateKotLbrDtls(oBaseHeaderBean, oDetailBeanArray,oList, screenName);
      reportError(oList);        
    }
    
    private void checkYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oRetList = null;
      Iterator oIt = null;
        MaintKotWrkSlipHeaderBean oMaintKotWrkSlipHeaderBean=(MaintKotWrkSlipHeaderBean)oBaseHeaderBean;
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintKotWrkSlipHeaderBean.getTxtSiteID()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintKotWrkSlipHeaderBean.getHdnEmpLbrFlag()));  
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");                 
        oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
  
        String sRevYear = "";
        String status = "";   
        String arcFlag="";
        
        oIt = oRetList.iterator();
        while(oIt.hasNext())
        {
          oRow = (QueryRow)oIt.next();
          sRevYear = oRow.get("yymm").getString(); 
          status = oRow.get("status").getString(); 
          arcFlag = oRow.get("arc_flag").getString(); 
        }
  
      if(arcFlag!=null && arcFlag.equals("Y"))
      {
        if(status!=null && (Integer.parseInt(status) == 2))
          throw new EnrgiseApplicationException("payroll.Common.PayrollDone");
        else
          throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
      }
         
    }
    
  private void validateKotLbrDtls(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray,ArrayList oList, String screenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;
    MaintKotWrkSlipHeaderBean oKotWrkSlipHeaderBean=(MaintKotWrkSlipHeaderBean)oBaseHeaderBean;
    Integer chkFlag=new Integer(0);
    String errMsg="";
    
    oIt = oDetailBeanArray.iterator();
    if (screenName.equals("LabourWrkSlipScreen"))
    {
      while(oIt.hasNext())
      {
        MaintKotWrkSlipBean oMaintWrkSlipBean = (MaintKotWrkSlipBean)oIt.next();
        if(!oMaintWrkSlipBean.getStatus().equals("D"))
        count++;
        
        if(oMaintWrkSlipBean.getStatus().equals("N"))
        {
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotWrkSlipHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oKotWrkSlipHeaderBean.getTxtLocId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtLbrID())));                             
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));        
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));        
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_ValidateKotwalLbrDtls(?,?,?,?,?)",true,true);            
          chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
          errMsg=(String)((DBObject)oOutArray.get(0)).getObject();
          if(!chkFlag.equals(new Integer(0)))
          {
            ArrayList oArguments=new ArrayList();
            oArguments.add(errMsg);
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
          }
        }
      }
    }
  }
    
  public void deleteHeaderImpl(String sPrimaryKey) throws EnrgiseSystemException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;
      
      ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_DeleteKotWrkSlip(?,?)");
  }
  
  public LovVO getWrkSlipGangLOVDataQ(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");    
    arylstHeaderNames.add("Gang Name"); 
    arylstHeaderNames.add("No of Labours"); 
    arylstHeaderNames.add("Mukadam"); 
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      //Passing Null value for Depot Id...
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtLbrTyp").trim()));      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getLOVGang(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("lbrs").getString());          
       oLOVBean.setDetailField4(oRow.get("mukadam").getString()); 
      
      oList.add(oLOVBean);
    }     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getKotWrkslipOperLOV(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Operation Id");    
    arylstHeaderNames.add("Operation");  
    arylstHeaderNames.add("Datum"); 
  //  arylstHeaderNames.add("No of Labours");
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);   
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
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetOprLOV(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("opr_id").getString());            
       oLOVBean.setDetailField2(oRow.get("opr_desc").getString());          
       oLOVBean.setDetailField3(oRow.get("datum_val").getString());             
      
      oList.add(oLOVBean);
    }     
      oLovVO.setDetailList(oList);
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
      MaintKotWrkSlipHeaderBean oMaintWrkSlipHeaderBean = (MaintKotWrkSlipHeaderBean)oBaseHeaderBean;
   
      return;
  }
 
  public ArrayList wrkslipCalcIncentive(MaintKotWrkSlipHeaderBean oBaseHeaderBean,String sScreenName,ArrayList oDetailBeanArray)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oDatumParam = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean =  new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    ArrayList oOutDatumVal; //Output 
    int count=0;
    String firstDatum="";
    Integer firstD = null;
    String incen="";
    int remDatum=0;
   
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintKotWrkSlipBean oMaintWrkSlipBean = (MaintKotWrkSlipBean)oIt.next();
        if(!oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(oMaintWrkSlipBean.getTxtOperDatum()==null || oMaintWrkSlipBean.getTxtOperDatum().equals(""))
          {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOperId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBags())));        
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("3")));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray= oBean.callProc(oParameters,"PKG_LBR_COMPUTE_INCT_V2.get_Non_Datum_Opr_Incent_Kot(?,?,?,?,?)");
            DBObject oOutObject=(DBObject)oOutArray.get(0);
            incen=(String)oOutObject.getObject();
          }else
          {
            count++;
            if(count==1)
            {
              oDatumParam = new ArrayList();
              oDatumParam.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOperDatum())));
              oDatumParam.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getHeaderPrimaryKey())));
              oDatumParam.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
              oDatumParam.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
              oOutDatumVal = oBean.callProc(oDatumParam,"PKG_PAY_LABOUR.proc_adjustDatum(?,?,?,?)");
              DBObject oOutObject=(DBObject)oOutDatumVal.get(0);              
              firstDatum = oOutObject.getObject().toString();
              
            }
            if(remDatum<0)
              remDatum=0;
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOperId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtNormTyp())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBagTyp())));
            if(count==1)
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(firstDatum+"")));
            else
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(remDatum+"")));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBags())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtTotBags())));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray= oBean.callProc(oParameters,"PKG_LBR_COMPUTE_INCT_V2.get_Datum_Opr_Incentive_Kot(?,?,?,?,?,?,?,?)");
            if(count==1)
            {             
              remDatum=Integer.parseInt(firstDatum)-Integer.parseInt(oMaintWrkSlipBean.getTxtBags());
            }else
            {
              remDatum=remDatum-Integer.parseInt(oMaintWrkSlipBean.getTxtBags());
            }
            DBObject oOutObject=(DBObject)oOutArray.get(0);
            incen=(String)oOutObject.getObject();
          }
          oMaintWrkSlipBean.setTxtIncentive(incen);
        }
      }
      return oDetailBeanArray;
  }  
  
 public ArrayList getKotLabourDetail(String sKotId, String fldName, long loginLocId, String depotId )throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oResult = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
    Timestamp oWhenPicked = null;
    int count = 0;  
    String sLoginLocId =String.valueOf(loginLocId);
    //String sDepotId =String.valueOf(depotId);
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();    
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sKotId)));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sLoginLocId)));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(depotId)));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));      
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));      
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER)); 
      if(fldName.equalsIgnoreCase("LabourCode"))
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getKotLbrDetail(?,?,?,?,?,?,?)",true,true);      
      else
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getKotEmpDetail(?,?,?,?,?,?,?)",true,true);      
      
      
      String empId;
      String kotLbrName;
      String kotLbrDsgn;
      DBObject oErrObject = (DBObject)oOutArray.get(3);    
      Integer errorCode = (Integer)oErrObject.getObject();
      if((errorCode.equals(new Integer(0))))
      {       
        
        empId = (String)((DBObject)oOutArray.get(0)).getObject();    
        kotLbrName = (String)((DBObject)oOutArray.get(1)).getObject();    
        kotLbrDsgn = (String)((DBObject)oOutArray.get(2)).getObject();    
        
      }else
      {
        empId = "";
        kotLbrName = "";
        kotLbrDsgn = "";    
      }
      oResult.add(empId);
      oResult.add(kotLbrName);
      oResult.add(kotLbrDsgn);      
      return oResult;      
  } 
  
  

public LovVO getLbrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Labour Code");
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");
    arylstHeaderNames.add("Designation"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);   
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
   
    oLovVO.setVisibilityList(arylstVisibility);
    
     // search parameters
    String sEmpNo,sCPF,sName;
    sEmpNo=oLovQueryVO.getSearchField1();
    sCPF=oLovQueryVO.getSearchField2();
    sName=oLovQueryVO.getSearchField3();
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
             
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sEmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtDepotLocId"))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, sCPF));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, sName));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    
    oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getKotWrkLbrLOVData(?,?,?,?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("kot_lbr_id").getString());
      oLOVBean.setDetailField2(oRow.get("emp_num").getString());
      oLOVBean.setDetailField3(oRow.get("name1").getString());
      oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString());    
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
//Method to submit Kotwal Labours workslip Detail
private void saveKotWrkSlipDtl(String sHeaderPrimaryKey,MaintKotWrkSlipHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray)throws EnrgiseSystemException
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
        MaintKotWrkSlipBean oMaintWrkSlipBean = (MaintKotWrkSlipBean)oIt.next();
        if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
              oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertKotWrkslpDtls(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();       
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOperId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBags())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtBagTyp())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtNormTyp())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtIncentivelbr())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOperSeq())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));        
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_InsertKotWrkSlpLbrDtl(?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtLbrID())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtIncentivelbr())));       
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));          
          oBean.addToBatch(oParameters);
        }
        else if(oMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteKotWrkSlipDetail(?,?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintWrkSlipBean.getTxtOperSeq())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
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
    
  
    
}