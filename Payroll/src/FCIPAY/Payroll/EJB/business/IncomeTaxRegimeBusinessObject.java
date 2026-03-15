package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.IncomeTaxRegimeQueryVO;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPMaintWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipBean;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipHeaderBean;
import FCIPAY.Payroll.UTILITY.IncomeTaxRegimeBean;
import FCIPAY.Payroll.UTILITY.IncomeTaxRegimeHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;

import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;

public class IncomeTaxRegimeBusinessObject  extends BaseBO{
    
    public IncomeTaxRegimeBusinessObject() {
       
    }
    public LovVO getIncomeTaxRegimeEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
         {
         
           LovVO oLovVO=new LovVO();  
           ArrayList arylstHeaderNames=new ArrayList();
           arylstHeaderNames.add("Employee No");    
           arylstHeaderNames.add("Employee Name");
           arylstHeaderNames.add("CPF Code");
           oLovVO.setHeaderList(arylstHeaderNames);
           
           ArrayList arylstVisibility=new ArrayList();
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
             oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
             oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
             oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
             oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));         
             oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
             oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
             oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
             oOutArray = oBean.callProc(oParameters,"PKG_IT_REGIME.proc_GetIncomeTaxRegimeEmpLovQ(?,?,?,?,?,?,?)");
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
                oLOVBean.setDetailField2(oRow.get("Name").getString());               
                oLOVBean.setDetailField3(oRow.get("cpf_code").getString());            
               
               oList.add(oLOVBean);
             }
            
             oLovVO.setDetailList(oList);
           return oLovVO;
         }


    public RecordMetaInfo getIncomeTaxRegimeHeaderMetaImpl(IncomeTaxRegimeQueryVO oIncomeTaxRegimeQueryVO) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
        ArrayList oOutArray; //Output 
    
        //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oIncomeTaxRegimeQueryVO.getSiteId())));
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oIncomeTaxRegimeQueryVO.getTxtEmpId())));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_IT_REGIME.proc_GetIncomeTaxRegimeCount(?,?,?,?)");
          
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
        oIncomeTaxRegimeQueryVO = null;
        return oRecordMetaInfo;
    }


    public ArrayList getIncomeTaxRegimeHeaderRecord(IncomeTaxRegimeQueryVO oIncomeTaxRegimeQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
      
          if(oIncomeTaxRegimeQueryVO == null)
          {
            oIncomeTaxRegimeQueryVO = new IncomeTaxRegimeQueryVO();
          }
      
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oIncomeTaxRegimeQueryVO.getTxtEmpId())));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_IT_REGIME.proc_GetIncomeTaxRegimeDetail(?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          IncomeTaxRegimeHeaderBean oIncomeTaxRegimeHeaderBean;
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
              oIncomeTaxRegimeHeaderBean = new IncomeTaxRegimeHeaderBean();
              oIncomeTaxRegimeHeaderBean.setTxtSiteID(oIncomeTaxRegimeQueryVO.getTxtSiteId());
              oIncomeTaxRegimeHeaderBean.setTxtSiteName(oIncomeTaxRegimeQueryVO.getTxtSiteName());
              oIncomeTaxRegimeHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NUM").getString());
              oIncomeTaxRegimeHeaderBean.setTxtEmpId(oRow.get("EMP_NUM").getString());
              oIncomeTaxRegimeHeaderBean.setTxtEmpName(oRow.get("NAME").getString());
              
              oHeaderList.add(oIncomeTaxRegimeHeaderBean);
              oRow = null;
              oIncomeTaxRegimeHeaderBean= null;
          }   
        oParameters=null;
        oOutArray=null;
        oIt=null;
        oIncomeTaxRegimeHeaderBean=null;
        oBean=null;
        oOutObject=null;
        oIncomeTaxRegimeQueryVO = null;
        return oHeaderList;
    }

    public RecordMetaInfo getIncomeTaxRegimeDetailMetaInfo(String sPrmaryKey,String sLocId) throws EnrgiseSystemException,EnrgiseApplicationException
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
        oOutArray = oBean.callProc(oParameters,"PKG_IT_REGIME.proc_GetIncomeTaxRegimeCount(?,?,?,?)");
          
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


    public ArrayList getIncomeTaxRegimeDetail(String sPrimaryKey,String sLocId,long lStartPosition,long lLastPosition) throws EnrgiseSystemException,EnrgiseApplicationException
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
          oOutArray = oBean.callProc(oParameters,"PKG_IT_REGIME.proc_GetIncomeTaxRegimeDetail(?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          IncomeTaxRegimeBean oIncomeTaxRegimeBean;
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
              oIncomeTaxRegimeBean = new IncomeTaxRegimeBean();
              oIncomeTaxRegimeBean.setTxtSrlNo(count);
              oIncomeTaxRegimeBean.setTxtFinYear(oRow.get("FIN_YR").getString());
              oIncomeTaxRegimeBean.setTxtITRegime(oRow.get("IT_REGIME_OPT").getString());
              oIncomeTaxRegimeBean.setTxtFinalFlag(oRow.get("FIN_YR_FLAG").getString());
              oIncomeTaxRegimeBean.setTxtFreeze(oRow.get("FIN_YR_FREEZE").getString());
              
//              if(oRow.get("cont_wrk_chk").getString().equals("Y"))
//              {
//                  oNwnpWrkSlipBean.setChkContWork(true);
//                  oNwnpWrkSlipBean.setHdnContWork("Y");
//              }
//              else
//              {
//                  oNwnpWrkSlipBean.setChkContWork(false);
//                  oNwnpWrkSlipBean.setHdnContWork("N");
//              }
              
              oIncomeTaxRegimeBean.setStatus("Q");
              oHeaderList.add(oIncomeTaxRegimeBean);
              oRow = null;
              oIncomeTaxRegimeBean = null;
          }  
       oParameters=null;
       oOutArray=null;
       oIt=null;
       oIncomeTaxRegimeBean=null;
       oBean=null;
       oList = null;
       oOutObject=null;
       return oHeaderList;
    }

    @Override
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
        return null;
    }

    @Override
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
    }

    @Override
    public void saveDetailImpl(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, String sScreenName, ArrayList oDetailBeanArray)  throws EnrgiseSystemException {
        saveIncomeTaxRegimeDtls(sHeaderPrimaryKey,(IncomeTaxRegimeHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }
    
    private void saveIncomeTaxRegimeDtls(String sHeaderPrimaryKey,IncomeTaxRegimeHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray)throws EnrgiseSystemException
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
        IncomeTaxRegimeBean oIncomeTaxRegimeBean = (IncomeTaxRegimeBean)oIt.next();
        if(oIncomeTaxRegimeBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_IT_REGIME.PROC_INSERT_EMP_DTLS(?,?,?,?,?,?,?)");
            bInsert = true;
          }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oIncomeTaxRegimeBean.getTxtFinYear())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oBaseHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(sHeaderPrimaryKey)));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oIncomeTaxRegimeBean.getTxtITRegime())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oBaseHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
            oBeanInsert.addToBatch(oParameters);
            oParameters = null;
                   
        }
        else if(oIncomeTaxRegimeBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_IT_REGIME.proc_UpdateRegimeDetails(?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oIncomeTaxRegimeBean.getTxtFinYear())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oBaseHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oIncomeTaxRegimeBean.getTxtITRegime())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oBaseHeaderBean.getTxtUserID())));
          
          
          oBean.addToBatch(oParameters);
          oParameters = null;
        }
//        else if(oIncomeTaxRegimeBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
//        {
//          if(!bDelete)
//          {
//            oBeanDelete = new DBUtilitiesBean();
//            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteWrkSlipDetail(?,?)");
//            bDelete = true;
//          }
//          oParameters = new ArrayList();
//          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey))); //added by swapnendu on 25 feb 2011
//          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oNwnpMaintWrkSlipBean.getHdnWrkSlipDtlId())));
//          oBeanDelete.addToBatch(oParameters);          
//          oParameters = null;
//        }
          oIncomeTaxRegimeBean = null;

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

//          if(bDelete)
//          {
//            oBeanDelete.executeBatch();
//          }   
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
      finally
      {
          oBean = null;
          oBeanInsert = null;
          //oBeanDelete = null;
      }
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
