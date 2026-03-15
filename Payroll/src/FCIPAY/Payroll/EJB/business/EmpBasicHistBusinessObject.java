package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.BasicHistDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ChangeZoneDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ChangeZoneVO;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.UTILITY.ChangeZoneBean;
import FCIPAY.Payroll.UTILITY.ChangeZoneHeaderBean;
import FCIPAY.Payroll.UTILITY.EmpBasicHistBean;
import FCIPAY.Payroll.UTILITY.SupplimentaryPayHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EmpBasicHistBusinessObject extends BaseBO {
    public EmpBasicHistBusinessObject() {
        super();
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

    public RecordMetaInfo getSupPayHeaderMetaInfo(ChangeZoneVO oChangeZoneVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      return null;
      
    }

    public ArrayList getSupPayHeader(ChangeZoneVO oChangeZoneVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      return null;
    }

    public RecordMetaInfo getbasicHistDetailMetaInfo(String sPrimaryKey, BasicHistDetailInfo oBasicHistDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      ArrayList oParameters; //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oBasicHistDetailInfo.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oBasicHistDetailInfo.getTxtYYMMFrom()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oBasicHistDetailInfo.getTxtYYMMTo()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_emp_basic_hist.proc_countbasichistdetail(?,?,?,?,?,?)");
        
          DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      
      oTotalRecord = null;
      oTimeObject = null;
      oOutArray = null;
      oParameters = null;
      return oRecordMetaInfo;
    }
    
    public ArrayList getBasicHistDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, BasicHistDetailInfo oBasicHistDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oBasicHist=null;
      ArrayList oParameters; //Input Parameters
      ArrayList oOutArray;
      ArrayList oList=null;
      QueryRow oRow = null;
      HashMap oColumns = null;
      EmpBasicHistBean oEmpBasicHistBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oBasicHistDetailInfo.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oBasicHistDetailInfo.getTxtYYMMFrom()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oBasicHistDetailInfo.getTxtYYMMTo()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_emp_basic_hist.proc_getbasichistdetail(?,?,?,?,?,?,?)",true,true);
    
     DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());   
      /*oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();*/
     
      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      int count = 0;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
        if(count == 0)
        {
          oBasicHist = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        oEmpBasicHistBean = new EmpBasicHistBean();
          oEmpBasicHistBean.setStatus("Q");
        oEmpBasicHistBean.setTxtStartDt(EnrgiseUtil.convertToString(oRow.get("EFF_START_DATE").getDate())) ;
      //  String vzone=   oChangeZoneBean.getTxtParZone();
        oEmpBasicHistBean.setTxtEndDt(EnrgiseUtil.convertToString(oRow.get("EFF_END_DATE").getDate()));
        oEmpBasicHistBean.setTxtBasic(oRow.get("AMOUNT").getString());
        oEmpBasicHistBean.setTxtOldPayscale(oRow.get("PAY_SCALE").getString());
        oEmpBasicHistBean.setTxtGradePay(oRow.get("GRADE_PAY").getString());
        oEmpBasicHistBean.setTxtEvent(oRow.get("EVENT_DESC").getString());
          
        oBasicHist.add(oEmpBasicHistBean);
        oRow = null;
        oEmpBasicHistBean = null;
      }
      oList = null;
      oIt = null;
      oBean = null;
      oOutArray = null;
      oParameters = null;
      oBasicHistDetailInfo = null;
      return oBasicHist;
    }

    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
        saveChangeZoneDetail(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }

    private void saveChangeZoneDetail(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
      boolean bInsert = false;
      boolean bUpdate = false;
      boolean bDelete = false;
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = null;
      DBUtilitiesBean oBeanInsert = null;
      DBUtilitiesBean oBeanDelete = null;
      ChangeZoneHeaderBean oDummyHeaderBean = (ChangeZoneHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray;
      oBean = new DBUtilitiesBean();
    //   oOutObject = null;
      oOutArray = null;
      oParameters = null;
        Iterator oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
          ChangeZoneBean oUserBean = (ChangeZoneBean)oIt.next();
          if(oUserBean.getStatus().equals(EnrgiseConstants.QUERY_MODE))
          {
            if(!bUpdate)
            {
              oBean = new DBUtilitiesBean();
              oBean.createBatch("pkg_cpf_fci.update_parent_zone(?,?,?,?,?,?)");
              bUpdate = true;
            }
            
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oDummyHeaderBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(oUserBean.getTxtYYMM())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oUserBean.getTxtNewParZoneCode())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oDummyHeaderBean.getTxtNewParentZone())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oDummyHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(oDummyHeaderBean.getTxtSiteID())));

            //oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.INTEGER,new String(sHeaderPrimaryKey))); //tran id (for updating after insertion & during execute)
            
            oBean.addToBatch(oParameters);
            oParameters = null;
          }
          oUserBean = null;
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
            oDummyHeaderBean = null;
            oBean = null;
            oBeanInsert = null;
            oBeanDelete = null;
        }
    }


          

    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
    }

    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
    {
      //ArrayList oParameters = new ArrayList(); //Input Parameters
      //oParameters = new ArrayList();
      return null;
    }

    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    }
    public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {

    }
    public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      
    }

    public LovVO getEmpBasicHistLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {  
        LovVO oLovVO=new LovVO();  
        ArrayList arylstHeaderNames=new ArrayList();
        arylstHeaderNames.add("Employee No");    
        arylstHeaderNames.add("Employee Name");
        arylstHeaderNames.add("CPF Code");  
        arylstHeaderNames.add("Designation");
        arylstHeaderNames.add("Date Of Birth");
        arylstHeaderNames.add("CategoryDesc"); 
        arylstHeaderNames.add("Staff Code");    
        arylstHeaderNames.add("Pay Scale Code"); 
        arylstHeaderNames.add("Pay revision");    
         
      
      oLovVO.setHeaderList(arylstHeaderNames);
      
      ArrayList arylstVisibility=new ArrayList();
      arylstVisibility.add(EnrgiseConstants.VISIBLE);
      arylstVisibility.add(EnrgiseConstants.VISIBLE);
      arylstVisibility.add(EnrgiseConstants.VISIBLE);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
      arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3()))); 
   //   oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));     
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_emp_basic_hist.Proc_getempbasicfixlov(?,?,?,?,?,?)");
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
          oLOVBean.setDetailField3(oRow.get("cpf_code").getString());
          oLOVBean.setDetailField2(oRow.get("emp_name").getString());
          oLOVBean.setDetailField4(oRow.get("DSGN_DESC").getString());
          oLOVBean.setDetailField5(EnrgiseUtil.convertToString(oRow.get("EMP_BIRTH_DATE").getDate())); 
          oLOVBean.setDetailField6(oRow.get("EMP_CATEGORY").getString());
          oLOVBean.setDetailField7(oRow.get("staff_code").getString());
          oLOVBean.setDetailField8(oRow.get("PAY_SCALE_CODE").getString());
          oLOVBean.setDetailField9(oRow.get("PAY_REVISION").getString());  
                  
                
        oList.add(oLOVBean);
      }
       
        oLovVO.setDetailList(oList);
      return oLovVO;
    }


}
