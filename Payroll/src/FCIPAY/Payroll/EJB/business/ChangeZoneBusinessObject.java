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

import FCIPAY.Payroll.DATAACCESSTIER.VO.ChangeZoneVO;
import FCIPAY.Payroll.UTILITY.ChangeZoneHeaderBean;
import FCIPAY.Payroll.UTILITY.SupplimentaryPayHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ChangeZoneDetailInfo;
import FCIPAY.Payroll.UTILITY.ChangeZoneBean;
import FCIPAY.COMMON.WEBTIER.Action.GetLovAction;

public class ChangeZoneBusinessObject extends BaseBO 
{
  public ChangeZoneBusinessObject()
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

  public RecordMetaInfo getSupPayHeaderMetaInfo(ChangeZoneVO oChangeZoneVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
    
  }

  public ArrayList getSupPayHeader(ChangeZoneVO oChangeZoneVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    return null;
  }

  public RecordMetaInfo getChngZoneDetailMetaInfo(String sPrimaryKey, ChangeZoneDetailInfo oChangeZoneDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    ArrayList oParameters; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oChangeZoneDetailInfo.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oChangeZoneDetailInfo.getTxtYYMMFrom()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oChangeZoneDetailInfo.getTxtYYMMTo()));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_countparentzonedetail(?,?,?,?,?,?)");
      
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
  
  public ArrayList getChngZoneDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, ChangeZoneDetailInfo oChangeZoneDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oZoneDetail=null;
    ArrayList oParameters; //Input Parameters
    ArrayList oOutArray;
    ArrayList oList=null;
    QueryRow oRow = null;
    HashMap oColumns = null;
    ChangeZoneBean oChangeZoneBean;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oChangeZoneDetailInfo.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oChangeZoneDetailInfo.getTxtYYMMFrom()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oChangeZoneDetailInfo.getTxtYYMMTo()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getparentzonedetail(?,?,?,?,?,?,?)",true,true);
  
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
        oZoneDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oChangeZoneBean = new ChangeZoneBean();
      oChangeZoneBean.setTxtNewParZone(oRow.get("NEW_PARENT_DESC").getString());
    //  String vzone=   oChangeZoneBean.getTxtParZone();
      oChangeZoneBean.setStatus("Q");
      oChangeZoneBean.setTxtYYMM(oRow.get("yyyymm").getString());
      oChangeZoneBean.setTxtOldParZone(oRow.get("OLD_PARENT_DESC").getString());
      oChangeZoneBean.setTxtOldParZoneCode(oRow.get("OLD_PARENT_ZONE").getString());
      oChangeZoneBean.setTxtNewParZoneCode(oRow.get("PARENT_ZONE").getString());
      oChangeZoneBean.setTxtEmpContr(oRow.get("EMPLOYEE_SUBS").getString());
      oChangeZoneBean.setTxtEmplyrContr(oRow.get("EMPLOYER_CONT").getString());
      oChangeZoneBean.setTxtEPS(oRow.get("EPS").getString());
      oZoneDetail.add(oChangeZoneBean);
      oRow = null;
      oChangeZoneBean = null;
    }
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oChangeZoneDetailInfo = null;
    return oZoneDetail;
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

    private void checkMaxPayYear(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = null; //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int count = 0;
        ArrayList oOutArray; //Output 
        QueryRow oRow = null;
        QueryValue oValue = null;
        ArrayList oRetList = null;
        Iterator oIt = null;
        String sRevYear = "";
        SupplimentaryPayHeaderBean oDummyHeaderBean = (SupplimentaryPayHeaderBean)oBaseHeaderBean;
        oParameters = new ArrayList();
        if((oDummyHeaderBean.getHdnEmpLbrFlag()).equals("E"))
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
        }
        else
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear_OvrAbv_Lbr(?,?,?,?)");
        }
        oDummyHeaderBean = null; //added by swapnendu Dt 24 Oct 2011
        
        oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        oOutArray = null;
        oParameters = null;
        oIt = oRetList.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            sRevYear = oRow.get("yymm").getString(); //getting current payroll month.
            String status = oRow.get("arc_flag").getString(); 
            oRow = null;
        }
        int payYear = Integer.parseInt(sRevYear);
        oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext())
        {
            ChangeZoneBean  oChangeZoneBean  = (ChangeZoneBean)oIt.next();
            count++;
            if(oChangeZoneBean.getStatus().equals("N") || oChangeZoneBean.getStatus().equals("U"))
            {
                String yymm = oChangeZoneBean.getTxtYYMM();
                int yyyyMM = Integer.parseInt(yymm);
                if(yyyyMM > payYear)
                {
                    ArrayList oArguments = new ArrayList();
                    oArguments.add(new String(sRevYear));
                    oArguments.add(new Integer(count));
                    oList.add(new EnrgiseApplicationException("Payroll.SupplyPay.MaxPayYearCheck",oArguments));
                    oArguments = null;
                }
            }
            oChangeZoneBean = null;
        }
        oIt = null;
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

  public LovVO getAllEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");
    arylstHeaderNames.add("Employee Name");      
    arylstHeaderNames.add("CPf Code");    
    arylstHeaderNames.add("site code");    
    arylstHeaderNames.add("site desc");
    arylstHeaderNames.add("Designation");  
    arylstHeaderNames.add("Date Of Birth");
    arylstHeaderNames.add("Current Zone");
    arylstHeaderNames.add("Staff Code");

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
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);
    //arylstVisibility.add(EnrgiseConstants.VISIBLE);           

    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));  
   // oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField4())));  
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_getempfinlov_All(?,?,?,?,?)");
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
     oLOVBean.setDetailField3(oRow.get("cpf_code").getString());
     oLOVBean.setDetailField4(oRow.get("pres_location_code").getString());
     oLOVBean.setDetailField5(oRow.get("loc_desc").getString());
     oLOVBean.setDetailField6(oRow.get("dsgn_desc").getString());
     oLOVBean.setDetailField7(EnrgiseUtil.convertToString(oRow.get("emp_birth_date").getDate()));       
     oLOVBean.setDetailField8(oRow.get("parent_zone_desc").getString());  
     oLOVBean.setDetailField9(oRow.get("staff_code").getString());
     /*oLOVBean.setDetailField5(oRow.get("emp_dsgn_id").getString());      
     oLOVBean.setDetailField6(oRow.get("EMP_HNDP_CATEG").getString());      
     oLOVBean.setDetailField7(oRow.get("EMP_5TH_PAY_BASIC").getString());             
     oLOVBean.setDetailField8(EnrgiseUtil.convertToString(oRow.get("emp_prom_cruc_dt").getDate()));       
     oLOVBean.setDetailField9(oRow.get("INCR_MONTH").getString());               */             
     oList.add(oLOVBean);
    }
     
     oLovVO.setDetailList(oList);
     return oLovVO;
  }
}