package FCIPAY.Payroll.Labour.EJB.business;

import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPMaintWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPWrkSlipComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipBean;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipBean;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;

import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;

public class NWNPWrkSlipBusinessObject  extends BaseBO{
    
    public NWNPWrkSlipBusinessObject() {
     
    }

    @Override
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        int count = 0;
        NWNPMaintWrkSlipHeaderBean oNwnpMaintWrkSlipHeaderBean = (NWNPMaintWrkSlipHeaderBean)oBaseHeaderBean;
        
        ArrayList oOutArray; //Output 
        
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipHeaderBean.getTxtLocId())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oNwnpMaintWrkSlipHeaderBean.getTxtWrkSlipDt()))));
        //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(oMaintWrkSlipHeaderBean.getTxtBagTyp()))); commented by swapnendu Dt 20 May 2011
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER)); 
        oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_InsertNwnpWrkSlip(?,?,?,?,?,?)",true,true);

        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oParameters = null;
        oOutArray = null;
        oBean=null;
        oNwnpMaintWrkSlipHeaderBean = null;
        return (String)oOutObject.getObject();
    }

    @Override
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
    }

    @Override
    public void saveDetailImpl(String sHeaderPrimaryKey, BaseHeaderBean oBaseHeaderBean, String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException {
    
        saveNwnpWrkSlipDtls(sHeaderPrimaryKey,(NWNPMaintWrkSlipHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }

    private void saveNwnpWrkSlipDtls(String sHeaderPrimaryKey,NWNPMaintWrkSlipHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray)throws EnrgiseSystemException
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
        NWNPMaintWrkSlipBean oNwnpMaintWrkSlipBean = (NWNPMaintWrkSlipBean)oIt.next();
        if(oNwnpMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
              
//              ArrayList oAmountCalParameters = new ArrayList(); //Input Parameters
//              DBUtilitiesBean dbUtilBean = new DBUtilitiesBean();
//                         
//              ArrayList oOutArray; //Output 
//              Integer calAmount = new Integer(0);
//              oAmountCalParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oNwnpMaintWrkSlipBean.getHdnHndlngNormId())));
//              oAmountCalParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oNwnpMaintWrkSlipBean.getTxtBags())));
//              oAmountCalParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtBagTyp())));
//              oAmountCalParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oBaseHeaderBean.getTxtLocId())));
//              //oAmountCalParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
//              //oAmountCalParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
//              oOutArray = dbUtilBean.callProc(oAmountCalParameters,"PKG_NWNP_SALARY_COMP.func_get_sor_amt(?,?,?,?)",true,true);
//              calAmount = (Integer)((DBObject)oOutArray.get(0)).getObject();
//                          
              
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertNwnpWrkSlipDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getHdnHndlngNormId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtBags())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtNormTyp())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getHdnSlabId())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtOTHrs())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtStartHrs())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtStartMin())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtEndHrs())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtEndMin())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtEmpList())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtBagTyp())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getHdnContWork())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.BIGINT,new Long(oBaseHeaderBean.getTxtLocId())));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtGoDownTyp())));
          oBeanInsert.addToBatch(oParameters);
          oParameters = null;
                   
        }
        else if(oNwnpMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateNwnpWrkSlipDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getHdnWrkSlipDtlId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getHdnHndlngNormId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtBags())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtNormTyp())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getHdnSlabId())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtOTHrs())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtStartHrs())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtStartMin())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtEndHrs())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtEndMin())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtEmpList())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtBagTyp())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getHdnContWork())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.BIGINT,new Long(oBaseHeaderBean.getTxtLocId())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipBean.getTxtGoDownTyp())));
          oBean.addToBatch(oParameters);
          oParameters = null;
        }
        else if(oNwnpMaintWrkSlipBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteWrkSlipDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey))); //added by swapnendu on 25 feb 2011
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oNwnpMaintWrkSlipBean.getHdnWrkSlipDtlId())));
          oBeanDelete.addToBatch(oParameters);          
          oParameters = null;
        }
          oNwnpMaintWrkSlipBean = null;

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
    
    @Override
    public void initializeBOImpl(String sScreenName) {
    }

    @Override
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked,
                                              String sScreenName, String sScreenMode, boolean bHeaderDataChanged,
                                              ArrayList oDetailBeanArray, boolean bDetailDataChanged,
                                              Timestamp oDetailPicked) throws EnrgiseSystemException,
                                                                              EnrgiseApplicationException {
        
        ArrayList oList=new ArrayList();
        if(sScreenMode.equals("N"))
        {
          checkDuplicacy(oBaseHeaderBean,oList);
        }
        reportError(oList);
//        if(sScreenName.equals("NWNPWrkSlipScreen"))
//        {
//          oList=new ArrayList();
//          chkValidBagType(oBaseHeaderBean, oDetailBeanArray, oList);
//          reportError(oList);
//        }
        checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList); // Added by dushyant on 27-Nov-2012
        chkGangForLbrList(oBaseHeaderBean, oDetailBeanArray, oList);
        reportError(oList);
        
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
        NWNPMaintWrkSlipHeaderBean oNwnpMaintWrkSlipHeaderBean = (NWNPMaintWrkSlipHeaderBean)oBaseHeaderBean;
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNwnpMaintWrkSlipHeaderBean.getTxtLocId()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oNwnpMaintWrkSlipHeaderBean.getTxtWrkSlipDt()))));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_nwnpWrkSlipDuplChk(?,?,?,?)");
        chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
        if(!chkFlag.equals(new Integer(0)))
        {        
          ArrayList oArguments = new ArrayList();
          oList.add(new EnrgiseApplicationException("wenrgise.common.dupliCheck",oArguments));
        }
        oParameters = null;
        oOutArray = null;
        oBean = null;
        oNwnpMaintWrkSlipHeaderBean = null;
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
              NWNPMaintWrkSlipBean  oNwnpMaintWrkSlipBean = (NWNPMaintWrkSlipBean)oIt.next();
              count++;
              if(oNwnpMaintWrkSlipBean.getStatus().equals("N") || oNwnpMaintWrkSlipBean.getStatus().equals("U"))
              {
                  String oprId = oNwnpMaintWrkSlipBean.getHdnHndlngNormId();
                  String bagTyp = oNwnpMaintWrkSlipBean.getHdnHndlngNormUnit(); 
                  ArrayList oParameters = new ArrayList();
                  oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, oNwnpMaintWrkSlipBean.getHdnHndlngNormId()));
                  oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, oNwnpMaintWrkSlipBean.getHdnHndlngNormUnit()));
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
       NWNPMaintWrkSlipHeaderBean oNwnpMaintWrkSlipHeaderBean=(NWNPMaintWrkSlipHeaderBean)oBaseHeaderBean;   
       oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate((oNwnpMaintWrkSlipHeaderBean.getTxtWrkSlipDt())))); 
       oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oNwnpMaintWrkSlipHeaderBean.getTxtSiteID()));
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNwnpMaintWrkSlipHeaderBean.getHdnEmpLbrFlag()));  
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

    private void chkGangForLbrList(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          int count = 0;
          ArrayList oOutArray; //Output 
          QueryRow oRow = null;
          NWNPMaintWrkSlipHeaderBean oNwnpMaintWrkSlipHeaderBean = (NWNPMaintWrkSlipHeaderBean)oBaseHeaderBean;
          Iterator oIt = oDetailBeanArray.iterator();
          while(oIt.hasNext())
          {
              NWNPMaintWrkSlipBean  oNwnpMaintWrkSlipBean = (NWNPMaintWrkSlipBean)oIt.next();
              count++;
              if(oNwnpMaintWrkSlipBean.getStatus().equals("N") || oNwnpMaintWrkSlipBean.getStatus().equals("U"))
              {
                  ArrayList oParameters = new ArrayList();
                  oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, oNwnpMaintWrkSlipHeaderBean.getTxtLocId()));
                  oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, oNwnpMaintWrkSlipBean.getTxtEmpList()));
                  oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, oNwnpMaintWrkSlipHeaderBean.getTxtWrkSlipDt()));
                  oParameters.add(new DBObject(4, DBObject.OUT, ParameterTypes.VARCHAR));
                  oParameters.add(new DBObject(5, DBObject.OUT, ParameterTypes.INTEGER));
                  oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.PROC_NWNP_CHKGANG_FOR_LBRLIST(?,?,?,?,?)",true,true);
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


    public RecordMetaInfo getNwnpWrkSlipHeaderMetaImpl(NWNPMaintWrkSlipQueryVO oNwnpMaintWrkSlipQueryVO) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
        ArrayList oOutArray; //Output 
    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipQueryVO.getTxtLocId())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNwnpMaintWrkSlipQueryVO.getTxtWrkSlipDt())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipQueryVO.getTxtYYMM())));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNwnpWrkSlipCount(?,?,?,?,?,?)");
          
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
        oNwnpMaintWrkSlipQueryVO = null;
        return oRecordMetaInfo;
    }

    public ArrayList getNwnpWrkSlipHeaderRecord(NWNPMaintWrkSlipQueryVO oNwnpMaintWrkSlipQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
          ArrayList oParameters = new ArrayList(); //Input Parameters
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oList;
          int count = 0;
      
          if(oNwnpMaintWrkSlipQueryVO == null)
          {
            oNwnpMaintWrkSlipQueryVO = new NWNPMaintWrkSlipQueryVO();
          }
      
          ArrayList oOutArray; //Output 
          ArrayList oHeaderList = null;
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipQueryVO.getTxtLocId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNwnpMaintWrkSlipQueryVO.getTxtWrkSlipDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNwnpMaintWrkSlipQueryVO.getTxtYYMM())));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNwnpWrkSlip(?,?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          NWNPMaintWrkSlipHeaderBean oNwnpWrkSlipHeader;
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
              oNwnpWrkSlipHeader = new NWNPMaintWrkSlipHeaderBean();
              oNwnpWrkSlipHeader.setTxtSiteId(oNwnpMaintWrkSlipQueryVO.getTxtSiteId());
              oNwnpWrkSlipHeader.setTxtSiteName(oNwnpMaintWrkSlipQueryVO.getTxtSiteName());
              oNwnpWrkSlipHeader.setTxtGangName(oRow.get("GANG_NAME").getString());
              oNwnpWrkSlipHeader.setTxtSite(oRow.get("loc_desc").getString());   
              oNwnpWrkSlipHeader.setHdnGangId(oRow.get("GANG_ID").getString());
              oNwnpWrkSlipHeader.setHdnWrkSlipId(oRow.get("WRKSLIP_ID").getString());
              oNwnpWrkSlipHeader.setHeaderPrimaryKey(oRow.get("WRKSLIP_ID").getString());
              oNwnpWrkSlipHeader.setTxtWrkSlipDt(EnrgiseUtil.convertToString(oRow.get("WRK_SLIP_DT").getDate()));
              oNwnpWrkSlipHeader.setHdnMou(oRow.get("MOU_CODE").getString());
              
              oNwnpWrkSlipHeader.setTxtLocId(oRow.get("GANG_ID").getString().substring(2));
              oNwnpWrkSlipHeader.setTxtLocation(oRow.get("LOC_DESC").getString());
              
              //oWrkSlipHeader.setTxtBagTyp(oRow.get("WT_FLG").getString());
              oNwnpWrkSlipHeader.setTxtYYMM(oNwnpMaintWrkSlipQueryVO.getTxtYYMM());
              oHeaderList.add(oNwnpWrkSlipHeader);
              oRow = null;
              oNwnpWrkSlipHeader = null;
          }   
        oParameters=null;
        oOutArray=null;
        oIt=null;
        oNwnpWrkSlipHeader=null;
        oBean=null;
        oOutObject=null;
        oNwnpMaintWrkSlipQueryVO = null;
        return oHeaderList;
    }

    public RecordMetaInfo getNwnpWrkSlipDetailMetaInfo(String sPrmaryKey,String sLbrTyp) throws EnrgiseSystemException,EnrgiseApplicationException
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

    public ArrayList getNwnpWrkSlipDetail(String sPrimaryKey,String sLbrTyp,long lStartPosition,long lLastPosition) throws EnrgiseSystemException,EnrgiseApplicationException
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
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNWNPWrkSlipDetail(?,?,?,?,?,?)");
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          oList = (ArrayList)(oOutObject.getObject());
    
          if(oList.size() == 0)
          {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          NWNPMaintWrkSlipBean oNwnpWrkSlipBean;
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
              oNwnpWrkSlipBean = new NWNPMaintWrkSlipBean();
              oNwnpWrkSlipBean.setHdnWrkSlipDtlId(oRow.get("WRKSLIP_DTL_ID").getString());
              oNwnpWrkSlipBean.setTxtNormTyp(oRow.get("NORM_TYPE").getString());
              oNwnpWrkSlipBean.setTxtBags(oRow.get("NO_BAGS").getString());
              oNwnpWrkSlipBean.setTxtBagTyp(oRow.get("WT_FLG").getString());
              oNwnpWrkSlipBean.setHdnHndlngNormId(oRow.get("NORM_ID").getString());
              //oWrkSlipBean.setTxtHndlngNorm(oRow.get("NORM_ID").getString());
              oNwnpWrkSlipBean.setHdnHndlngNormUnit(oRow.get("NORM_UNIT_TYPE").getString());
              oNwnpWrkSlipBean.setTxtOTHrs(oRow.get("OTA_HRS").getString());
              oNwnpWrkSlipBean.setTxtSlab(oRow.get("slab_rate").getString());
              oNwnpWrkSlipBean.setHdnSlabId(oRow.get("SLAB_ID").getString());
              oNwnpWrkSlipBean.setTxtEmpList(oRow.get("lbr_list").getString());              
              oNwnpWrkSlipBean.setTxtStartHrs(oRow.get("strt_hr").getString());
              oNwnpWrkSlipBean.setTxtStartMin(oRow.get("strt_mi").getString());
              oNwnpWrkSlipBean.setTxtEndHrs(oRow.get("end_hr").getString());
              oNwnpWrkSlipBean.setTxtEndMin(oRow.get("end_mi").getString());
              oNwnpWrkSlipBean.setTxtGoDownTyp(oRow.get("SIDING_FLG").getString());  
              if(oRow.get("cont_wrk_chk").getString().equals("Y"))
              {
                  oNwnpWrkSlipBean.setChkContWork(true);
                  oNwnpWrkSlipBean.setHdnContWork("Y");
              }
              else
              {
                  oNwnpWrkSlipBean.setChkContWork(false);
                  oNwnpWrkSlipBean.setHdnContWork("N");
              }
              oNwnpWrkSlipBean.setStatus("Q");
              oHeaderList.add(oNwnpWrkSlipBean);
              oRow = null;
              oNwnpWrkSlipBean = null;
          }  
       oParameters=null;
       oOutArray=null;
       oIt=null;
       oNwnpWrkSlipBean=null;
       oBean=null;
       oList = null;
       oOutObject=null;
       return oHeaderList;
    }


    public void deleteNwnpHeaderImpl(String sPrimaryKey) throws EnrgiseSystemException
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
    
    public LovVO getNWNPWrkSlipLOVDataQ(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
    {
      LovVO oLovVO=new LovVO();  
      ArrayList arylstHeaderNames=new ArrayList();
      
      arylstHeaderNames.add("Location Id");    
      arylstHeaderNames.add("NWNP Location Name");
     // arylstHeaderNames.add("Labour Type");
      //arylstHeaderNames.add("MOU");
      //arylstHeaderNames.add("Depo Name");   // added by dushaynt on 10-03-2011 for depo location 
      
      oLovVO.setHeaderList(arylstHeaderNames);
    
      ArrayList arylstVisibility=new ArrayList();
      arylstVisibility.add(EnrgiseConstants.VISIBLE);
      arylstVisibility.add(EnrgiseConstants.VISIBLE);
      //arylstVisibility.add(EnrgiseConstants.HIDDEN);
      //arylstVisibility.add(EnrgiseConstants.VISIBLE);    // added by dushaynt on 10-03-2011 for depo location 
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
       // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtLbrTyp").trim()));      
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNWNPLocLOV(?,?,?,?,?,?)");
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
        
         //oLOVBean.setDetailField1(oRow.get("gang_id").getString());            
         //oLOVBean.setDetailField2(oRow.get("gang_name").getString());           
         //oLOVBean.setDetailField3(oRow.get("site_id").getString());           
         //oLOVBean.setDetailField4(oRow.get("loc_desc").getString());
         //oLOVBean.setDetailField5(oRow.get("lbr_typ").getString());
         //oLOVBean.setDetailField3(oRow.get("mou_code").getString());
        oLOVBean.setDetailField1(oRow.get("loc_id").getString());
        oLOVBean.setDetailField2(oRow.get("loc_desc").getString());
        
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
    
   public LovVO getNWNPWrkSlipEmpLOV(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException 
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
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtLocId"))).trim()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtWrkSlipDt"))).trim()));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtEndHrs"))).trim()));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtEndMin"))).trim()));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnHndlngNormId"))).trim()));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNwnpLocLbrLov(?,?,?,?,?,?,?)");
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
   
    public NWNPWrkSlipComboVO getNwnpWrkSlipComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList();
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      NWNPWrkSlipComboVO oNwnpWrkSlipComboVO = new NWNPWrkSlipComboVO();
      int count = 0;
      ArrayList oOutArray; //Output 
      ComboVO oComboVO=null;
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      
      ArrayList oWrkSlipOprList = null;
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
      oNwnpWrkSlipComboVO.setOperationList(oWrkSlipOprList);
      oWrkSlipOprList = null;
      oList = null;
      oParameters=null;
      oOutArray=null;
      oIt=null;
      oBean=null;
      return oNwnpWrkSlipComboVO;
    }
   
}
