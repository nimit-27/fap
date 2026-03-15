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

import FCIPAY.Payroll.UTILITY.SpclCmpnstryAllowSixPayHeaderBean;
import FCIPAY.Payroll.UTILITY.SpclCmpnstryAllowSixPayBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SpclCmpnstryAllowSixPayDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SpclCmpnstryComboVOSixPay;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SpclCmpnstryAllowSixPayQueryVO;

public class SpclCmpnstryAllowBusinessObject extends BaseBO 
{
  public SpclCmpnstryAllowBusinessObject()
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

  public RecordMetaInfo getSpclCompstryAllowHeaderMetaInfo(SpclCmpnstryAllowSixPayQueryVO oSpclCmpnstryAllowSixPayQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        Timestamp oWhenPicked = null;
        int count = 0;
        BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
                    
        ArrayList oOutArray; //Output 
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getTxtPayScaleTyp()))); 
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getCboAllowType()))); 
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getCboAreaType()))); 
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountSpclCompAllowHeader(?,?,?,?,?,?,?)");
        
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        return oRecordMetaInfo;
  }

  public ArrayList getSpclCompstryAllowHeader(SpclCmpnstryAllowSixPayQueryVO oSpclCmpnstryAllowSixPayQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        int count = 0;
        
        if(oSpclCmpnstryAllowSixPayQueryVO == null)
        {
            oSpclCmpnstryAllowSixPayQueryVO = new SpclCmpnstryAllowSixPayQueryVO();
        }
        
        ArrayList oOutArray; //Output 
        ArrayList oHeaderList = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getTxtPayScaleTyp())));                  
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getCboAllowType()))); 
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getCboAreaType()))); 
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayQueryVO.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetSpclCompAllowHeader(?,?,?,?,?,?,?,?)");
        
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        
        if(oList.size() == 0)
        {        
            throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        SpclCmpnstryAllowSixPayHeaderBean oHeaderBean;
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
            oHeaderBean = new SpclCmpnstryAllowSixPayHeaderBean();
            //oHeaderBean
            oHeaderBean.setCboAllowType(oRow.get("allowance_type").getString());
            oHeaderBean.setCboAreaType(oRow.get("area_type").getString());
            oHeaderBean.setTxtEffFrmDt(EnrgiseUtil.convertToString(oRow.get("eff_strt_dt").getDate()));
            oHeaderBean.setTxtEffToDt(EnrgiseUtil.convertToString(oRow.get("eff_end_dt").getDate()));
            oHeaderList.add(oHeaderBean);
        }              
        return oHeaderList;
  } 

    public RecordMetaInfo getSpclCompAllowDetailMetaInfo(String sPrimaryKey,SpclCmpnstryAllowSixPayDetailInfo oSpclCmpnstryAllowSixPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oSpclCmpnstryAllowSixPayDetailInfo.getTxtPayScaleTyp()));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oSpclCmpnstryAllowSixPayDetailInfo.getCboAllowType()));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oSpclCmpnstryAllowSixPayDetailInfo.getCboAreaType()));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayDetailInfo.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_CountSpclCompAllowDetail(?,?,?,?,?,?,?)");
        
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
        
        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
        return oRecordMetaInfo;
    }
    
    public ArrayList getSpclCompAllowDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,SpclCmpnstryAllowSixPayDetailInfo oSpclCmpnstryAllowSixPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output
        SpclCmpnstryAllowSixPayBean oSpclCmpnstryAllowSixPayBean;
        
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oList = null;
        Iterator oIt = null;
        ArrayList oBadClmtDetail = null;
        
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oSpclCmpnstryAllowSixPayDetailInfo.getTxtPayScaleTyp()));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oSpclCmpnstryAllowSixPayDetailInfo.getCboAllowType()));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oSpclCmpnstryAllowSixPayDetailInfo.getCboAreaType()));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oSpclCmpnstryAllowSixPayDetailInfo.getTxtEffFrmDt())));                
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_SpclCompAllowDetail(?,?,?,?,?,?,?,?)");
        
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
            oSpclCmpnstryAllowSixPayBean = new SpclCmpnstryAllowSixPayBean();
            oSpclCmpnstryAllowSixPayBean.setDetailId(oRow.get("PAY_SPL_CMPNSTRY_ID").getString());
            oSpclCmpnstryAllowSixPayBean.setTxtPayBand((oRow.get("PAY_BAND").getString()));
            oSpclCmpnstryAllowSixPayBean.setStatus("Q");
            oSpclCmpnstryAllowSixPayBean.setTxtGrade(oRow.get("GRADE_PAY").getString());
            oSpclCmpnstryAllowSixPayBean.setTxtRate(oRow.get("RATE").getString());
            oSpclCmpnstryAllowSixPayBean.setCboCatg(oRow.get("CATEGORY").getString());
            
            oBadClmtDetail.add(oSpclCmpnstryAllowSixPayBean);
        }
        return oBadClmtDetail;
    }
  
    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
        String sPayScaleType;
        SpclCmpnstryAllowSixPayHeaderBean oDummyHeaderBean = (SpclCmpnstryAllowSixPayHeaderBean)oBaseHeaderBean;
        if(sScreenName.equals("SpclCmpnstryAllowScreenCDA"))
        {
            sPayScaleType = "CDA";
            saveSpclCompstryAllowDetail(sHeaderPrimaryKey, sPayScaleType, oDummyHeaderBean, oDetailBeanArray);
        }
        else
        {
            sPayScaleType = "IDA";
            saveSpclCompstryAllowDetail(sHeaderPrimaryKey, sPayScaleType, oDummyHeaderBean, oDetailBeanArray);
        }
    }

  private void saveSpclCompstryAllowDetail(String sHeaderPrimaryKey, String sPayScaleType, SpclCmpnstryAllowSixPayHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        SpclCmpnstryAllowSixPayBean oUserBean = (SpclCmpnstryAllowSixPayBean)oIt.next();
        //System.out.println(oMaintHraRateBean.getStatus());
        //System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oUserBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
            if(!bInsert)
            {
                oBeanInsert = new DBUtilitiesBean();
                oBeanInsert.createBatch("pkg_payroll_misc.proc_InsertSpclCompAllowMst(?,?,?,?,?,?,?,?,?,?,?)");
                bInsert = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getCboAllowType())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getCboAreaType())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffFrmDt())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffToDt())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayBand())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtGrade())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRate())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getCboCatg())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oBeanInsert.addToBatch(oParameters);
        }
        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
            if(!bUpdate)
            {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("pkg_payroll_misc.proc_UpdateSpclCompAllowMst(?,?,?,?,?,?,?,?,?,?,?,?)");
                bUpdate = true;
            }
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getDetailId())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getCboAllowType())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getCboAreaType())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffFrmDt())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtEffToDt())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtPayBand())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtGrade())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtRate())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getCboCatg())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oBean.addToBatch(oParameters);
        }
        
        else if(oUserBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
            if(!bDelete)
            {
                oBeanDelete = new DBUtilitiesBean();
                oBeanDelete.createBatch("pkg_payroll_misc.proc_DeleteSpclCompAllowMst(?,?)");
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

public SpclCmpnstryComboVOSixPay getCmpnstryComboDetailsSixPay() throws EnrgiseSystemException, EnrgiseApplicationException
{
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    SpclCmpnstryComboVOSixPay oBadClmtComboVO = new SpclCmpnstryComboVOSixPay();
    int count = 0;
    ArrayList oOutArray; //Output
    ComboVO oComboVO=null;
    
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oBadClmtCtgry = null;
    
    ArrayList oCategList = new ArrayList();
    oCategList = getComboRecords("PAYROLL_PKG.proc_GetEmpCtgry(?,?)","gbl_code","code_sdesc");
    oBadClmtComboVO.setCtgryList(oCategList);
    
    ArrayList oAllowTypeList = new ArrayList();
    oAllowTypeList = getComboRecords("PAYROLL_PKG.proc_GetSplCompAllow(?,?)","splcomp_id","splcomp_desc");
    oBadClmtComboVO.setAllowanceList(oAllowTypeList);
    
    ArrayList oAreaType = new ArrayList();
    oAreaType = getComboRecords("PAYROLL_PKG.proc_GetRmtAreaLOV(?,?)","gbl_code","code_sdesc");
    oBadClmtComboVO.setAreaTypeList(oAreaType);
    
    
    return oBadClmtComboVO;
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

}