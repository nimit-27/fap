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
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;

import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import FCIPAY.Payroll.UTILITY.MiscAllowanceSixPayBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscAllowanceSixPayDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscAllowanceComboVOSixPay; //added by swapnendu Dt 30-Mar 2011.
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscAllowanceSixPayQueryVO; //added by swapnendu Dt 11-Apr 2011.
import FCIPAY.Payroll.UTILITY.MiscAllowanceSixPayHeaderBean;

public class MiscAllow6PayBusinessObject extends BaseBO 
{
  public MiscAllow6PayBusinessObject()
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

  public RecordMetaInfo getMiscAllowHeaderMetaInfo(MiscAllowanceSixPayQueryVO oMiscAllowanceSixPayQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
                    
        ArrayList oOutArray; //Output 
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayQueryVO.getTxtPayScaleTyp()))); 
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayQueryVO.getTxtPayCode()))); 
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayQueryVO.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountMiscAllowHeader(?,?,?,?,?,?)");
        
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        return oRecordMetaInfo;
  }

  public ArrayList getMiscAllowHeader(MiscAllowanceSixPayQueryVO oMiscAllowanceSixPayQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        int count = 0;
        
        if(oMiscAllowanceSixPayQueryVO == null)
        {
            oMiscAllowanceSixPayQueryVO = new MiscAllowanceSixPayQueryVO();
        }
        
        ArrayList oOutArray; //Output 
        ArrayList oHeaderList = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayQueryVO.getTxtPayScaleTyp()))); 
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayQueryVO.getTxtPayCode()))); 
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayQueryVO.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetMiscAllowHeader(?,?,?,?,?,?,?)");
        
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        
        if(oList.size() == 0)
        {
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        MiscAllowanceSixPayHeaderBean oHeaderBean;
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
            oHeaderBean = new MiscAllowanceSixPayHeaderBean();
            //oHeaderBean
            oHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
            oHeaderBean.setTxtEffFrmDt(EnrgiseUtil.convertToString(oRow.get("eff_strt_dt").getDate()));
            oHeaderBean.setTxtEffToDt(EnrgiseUtil.convertToString(oRow.get("eff_end_dt").getDate()));
            oHeaderList.add(oHeaderBean);
        }              
        return oHeaderList;
  } 

    public RecordMetaInfo getMiscAllowDetailMetaInfo(String sPrimaryKey, MiscAllowanceSixPayDetailInfo oMiscAllowanceSixPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMiscAllowanceSixPayDetailInfo.getTxtPayScaleTyp()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayDetailInfo.getTxtPayCode())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayDetailInfo.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountMiscAllowDetail(?,?,?,?,?,?)");
        
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        return oRecordMetaInfo;
    }
    
    public ArrayList getMiscAllowDetail(String sPrimaryKey, long lDetailFirstPosition, long lDetailLastPosition, MiscAllowanceSixPayDetailInfo oMiscAllowanceSixPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output
        MiscAllowanceSixPayBean oMiscAllowanceSixPayBean;
        
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        ArrayList oBadClmtDetail = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oMiscAllowanceSixPayDetailInfo.getTxtPayScaleTyp()));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayDetailInfo.getTxtPayCode())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscAllowanceSixPayDetailInfo.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_MiscAllowDetail(?,?,?,?,?,?,?)");
        
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
                oBadClmtDetail = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();
            oMiscAllowanceSixPayBean = new MiscAllowanceSixPayBean();
            oMiscAllowanceSixPayBean.setDetailId(oRow.get("PAY_MISC_ALLOW_ID").getString());
            oMiscAllowanceSixPayBean.setTxtPayBand((oRow.get("PAY_BAND").getString()));
            oMiscAllowanceSixPayBean.setStatus("Q");
            oMiscAllowanceSixPayBean.setTxtGrade(oRow.get("GRADE_PAY").getString());
            oMiscAllowanceSixPayBean.setTxtRate(oRow.get("RATE").getString());
            oMiscAllowanceSixPayBean.setCboCatg(oRow.get("CATEGORY").getString());
            
            oBadClmtDetail.add(oMiscAllowanceSixPayBean);
        }
        return oBadClmtDetail;
    }
 
    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
        String sPayScaleType;
        MiscAllowanceSixPayHeaderBean oDummyHeaderBean = (MiscAllowanceSixPayHeaderBean)oBaseHeaderBean;
        if(sScreenName.equals("MiscAllowanceScreenCDA"))
        {
            sPayScaleType = "CDA";
            saveMiscAllowDetail(sHeaderPrimaryKey, sPayScaleType, oDummyHeaderBean, oDetailBeanArray);
        }
        else
        {
            sPayScaleType = "IDA";
            saveMiscAllowDetail(sHeaderPrimaryKey, sPayScaleType, oDummyHeaderBean, oDetailBeanArray);
        }
    }

  private void saveMiscAllowDetail(String sHeaderPrimaryKey, String sPayScaleType, MiscAllowanceSixPayHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
        boolean bInsert = false;
        boolean bUpdate = false;
        boolean bDelete = false;
        
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = null;
        DBUtilitiesBean oBeanInsert = null;
        DBUtilitiesBean oBeanDelete = null;
        oBean = new DBUtilitiesBean();
        ArrayList oOutArray;
        
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MiscAllowanceSixPayBean oUserBean = (MiscAllowanceSixPayBean)oIt.next();
        //System.out.println(oMaintHraRateBean.getStatus());
        //System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oUserBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
            if(!bInsert)
            {
                oBeanInsert = new DBUtilitiesBean();
                oBeanInsert.createBatch("pkg_payroll_misc.proc_InsertMiscAllowMst(?,?,?,?,?,?,?,?,?,?)");
                bInsert = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPayCode())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffFrmDt())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffToDt())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayBand())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtGrade())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRate())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getCboCatg())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oBeanInsert.addToBatch(oParameters);
        }
        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
            if(!bUpdate)
            {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("pkg_payroll_misc.proc_UpdateMiscAllowMst(?,?,?,?,?,?,?,?,?,?,?)");
                bUpdate = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getDetailId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtPayCode())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffFrmDt())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffToDt())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayBand())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtGrade())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRate())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getCboCatg())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oBean.addToBatch(oParameters);
        }
        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
            if(!bDelete)
            {
                oBeanDelete = new DBUtilitiesBean();
                oBeanDelete.createBatch("pkg_payroll_misc.proc_DeleteMiscAllowMst(?,?)");
                bDelete = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getDetailId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
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
         e.printStackTrace();
      }
  }

  public LovVO getSpclCompAllowPayBand(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Band");
    arylstHeaderNames.add("Start Basic");
    arylstHeaderNames.add("End Basic");
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPayScaleTyp"))));   
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getSpclCompPayBandLov(?,?,?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("PAY_BAND_CODE").getString());
      oLOVBean.setDetailField2(oRow.get("START_BASIC").getString());
      oLOVBean.setDetailField3(oRow.get("END_BASIC").getString());

      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getSpclCompAllowGradePay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Grade Pay");
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPayBand"))));   
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getSpclCompGradePayLov(?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("GRADE_PAY").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
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

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
      //checkEffectiveDate(oBaseHeaderBean,oList);
      reportError(oList);
      oList = new ArrayList();
      //Emp_Trans_Promo_Sts(oBaseHeaderBean,oDetailBeanArray,oList);
      reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  public LovVO getMiscAllowPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayCode");   
    arylstHeaderNames.add("PayCode Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);
    
    // search parameters
    String sPaycode,sDesc;
    sPaycode=oLovQueryVO.getSearchField1();
    sDesc=oLovQueryVO.getSearchField2();
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();     
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, sPaycode));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, sDesc));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetPayCodeMiscAllowLOV(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_code").getString());            
       oLOVBean.setDetailField2(oRow.get("pay_code_desc").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  } 
  public LovVO getMiscAllowPayBand(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Band");
    arylstHeaderNames.add("Start Basic");
    arylstHeaderNames.add("End Basic");
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPayScaleTyp"))));   
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));   
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getMiscAllowPayBandLov(?,?,?,?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("PAY_BAND_CODE").getString());
      oLOVBean.setDetailField2(oRow.get("START_BASIC").getString());
      oLOVBean.setDetailField3(oRow.get("END_BASIC").getString());

      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public LovVO getMiscAllowGradePay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Grade Pay");
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPayBand"))));   
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getMiscGradePayLov(?,?,?)");
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
      
      oLOVBean.setDetailField1(oRow.get("GRADE_PAY").getString());
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
    public MiscAllowanceComboVOSixPay getMiscComboDetailsSixPay() throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        MiscAllowanceComboVOSixPay oMiscAllowanceComboVOSixPay = new MiscAllowanceComboVOSixPay();
        int count = 0;
        ArrayList oOutArray; //Output
        ComboVO oComboVO=null;
        
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
       
        ArrayList oCategList = new ArrayList();
        oCategList = getComboRecords("PAYROLL_PKG.proc_GetEmpCtgry(?,?)","gbl_code","code_sdesc");
        oMiscAllowanceComboVOSixPay.setCtgryList(oCategList);
        return oMiscAllowanceComboVOSixPay;
    }
    
    private ArrayList getComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters = new ArrayList();
        ArrayList oOutArray;
        //EmpFinanceComboVO oEmpFin=null;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        QueryRow oRow = null;    
        int count = 0;
        
        oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,sProc);
        
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
            throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
            
        count = 0;
        oIt = oList.iterator();
        ArrayList oValueList = null;
        while(oIt.hasNext())
        {
            if(count == 0)
            {
               oValueList = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();        
            String fieldId = ((oRow.get(sField_id).getString()));
            String fieldDesc= ((oRow.get(sField_desc).getString()));
            ComboVO oComboVO = new ComboVO(fieldDesc,fieldId);
            oValueList.add(oComboVO);    
        }
        return oValueList;
    }   

}