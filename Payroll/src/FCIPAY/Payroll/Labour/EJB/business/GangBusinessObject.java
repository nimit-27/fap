package FCIPAY.Payroll.Labour.EJB.business;

import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.Labour.Utility.MaintGangBean;
import FCIPAY.Payroll.Labour.Utility.MaintGangHeaderBean;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.GangComboVO;

public  class GangBusinessObject extends BaseBO
{
  public GangBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("GangMasterScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
     // oParameters = new ArrayList();
     oParameters=null;
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      MaintGangHeaderBean oMaintGangHeaderBean = (MaintGangHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtLocId())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtGangName())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtType())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtMou())));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER)); 
      oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_InsertGang(?,?,?,?,?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oParameters=null;
      oOutArray=null;
      oMaintGangHeaderBean = null;
      oBean = null;
      return (String)oOutObject.getObject();
  }
 
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {  
      saveGang(sHeaderPrimaryKey,(MaintGangHeaderBean)oBaseHeaderBean, oDetailBeanArray);
         
  }
  
  private void saveGang(String sHeaderPrimaryKey, MaintGangHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        MaintGangBean oMaintGangBean = (MaintGangBean)oIt.next();
        if(oMaintGangBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertGangDetail(?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();       
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getHdnEmpId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtEmpTyp())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFrom())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromHrs())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromMin())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtTo())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToHrs())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToMin())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));          
          oBeanInsert.addToBatch(oParameters);
          oParameters = null;
        }
        else if(oMaintGangBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateGangDetail(?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getDetailId())));                  
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getHdnEmpId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtEmpTyp()))); 
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFrom())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromHrs())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromMin())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtTo())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToHrs())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToMin())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          oParameters = null;
          
          
        }
        else if(oMaintGangBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteGangDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getDetailId())));      
          oBeanDelete.addToBatch(oParameters);     
          oParameters = null;
        }
        oMaintGangBean = null;
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
       oIt = null;
       oBeanDelete=null;
       oBeanInsert = null;
       oBean = null;
      }
  }
 
 public RecordMetaInfo getGangDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));   
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetGangCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());  
      oParameters=null;
      oOutArray=null;
      oTotalRecord=null;
      oTimeObject=null;
      oBean=null;
      return oRecordMetaInfo;            
  }
 
 public ArrayList getGangDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintGangBean oMaintGangBean;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oGangMbrDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetGangMbrDetail(?,?,?,?,?)");
      
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
            oGangMbrDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintGangBean = new MaintGangBean();
          oMaintGangBean.setHdnEmpId((oRow.get("emp_num").getString()));
          oMaintGangBean.setTxtCpfCode((oRow.get("cpf_code").getString()));
          oMaintGangBean.setTxtEmpName((oRow.get("empname").getString()));
          oMaintGangBean.setStatus("Q");
          oMaintGangBean.setTxtEmpTyp(oRow.get("mbr_typ").getString());
          oMaintGangBean.setTxtCurrBas(oRow.get("basic_mgw").getString());
          oMaintGangBean.setTxtFrom((oRow.get("strt_dt").getString()));
          oMaintGangBean.setTxtFromHrs((oRow.get("strt_hh").getString()));
          oMaintGangBean.setTxtFromMin((oRow.get("strt_mi").getString()));
          oMaintGangBean.setTxtTo((oRow.get("end_dt").getString()));
          oMaintGangBean.setHdnEffToDt((oRow.get("end_dt").getString()));
          oMaintGangBean.setTxtToHrs((oRow.get("end_hh").getString()));
          oMaintGangBean.setHdnEffToHr((oRow.get("end_hh").getString()));
          oMaintGangBean.setTxtToMin((oRow.get("end_mi").getString()));
          oMaintGangBean.setHdnEffToMin((oRow.get("end_mi").getString())); 
          oMaintGangBean.setDetailId(oRow.get("gang_dtl_id").getString());
          oGangMbrDetail.add(oMaintGangBean);
          oRow = null;
          oMaintGangBean = null;

        }
      oParameters=null;
      oOutArray=null;  
      oIt=null;
      oBean=null;
      oList=null;
      return oGangMbrDetail;
  }

  public LovVO getGangDepotLOVDataQ(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Location Id");    
    arylstHeaderNames.add("Location Name");        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);

    LOVBean oLOVBean;
    int count;
    count = 0;
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetDepotLoV(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("loc_id").getString());                   
       oLOVBean.setDetailField2(oRow.get("loc_desc").getString());            
      
      oList.add(oLOVBean);
      oLOVBean = null;
      oRow = null;
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

  public LovVO getGangLOVDataQ(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");    
    arylstHeaderNames.add("Gang Name");
    arylstHeaderNames.add("Loc Code");
    arylstHeaderNames.add("Loc Name");
    arylstHeaderNames.add("Labour Type");
    arylstHeaderNames.add("MOU");
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
      String lbrType;
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtLocId"))).trim()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));   
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));   
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtType"))).trim()));         
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
       oLOVBean.setDetailField3(oRow.get("site_id").getString());           
       oLOVBean.setDetailField4(oRow.get("loc_desc").getString());
       oLOVBean.setDetailField5(oRow.get("lbr_typ").getString());
       oLOVBean.setDetailField6(oRow.get("mou_code").getString());
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

  public LovVO getGangLbrLOVDataN(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee Id");  
    arylstHeaderNames.add("CPF Code"); 
    arylstHeaderNames.add("Employee Name");  
    arylstHeaderNames.add("Designation");  
    arylstHeaderNames.add("basic");
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtLocId"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtLbrType"))).trim()));    
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.getGangLbrEmpLOV(?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("cpf_code").getString());   // added by dushyant on 01-03-2011
       oLOVBean.setDetailField3(oRow.get("emp_name").getString());           
       oLOVBean.setDetailField4(oRow.get("dsgn_desc").getString());          
       oLOVBean.setDetailField5(oRow.get("basic_mgw").getString());   
      
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
  
  public String updateGangDate( PayrollBaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
  System.out.println("in business object");
    System.out.println(oBaseHeaderBean.getTxtUserID());
       String errMsg=null;
       Integer errCode ;
ArrayList oOutArray;
        ArrayList oParameters = new ArrayList(); 
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          oParameters = new ArrayList();
//MaintGangHeaderBean oBaseHeaderBean=(MaintGangHeaderBean)oBaseHeaderBean;
        Iterator oIt = oDetailBeanArray.iterator();
        while(oIt.hasNext()) 
        {
          MaintGangBean oMaintGangBean = (MaintGangBean)oIt.next();
         
            System.out.println(oMaintGangBean.getDetailId());

        if(oMaintGangBean.getItemChecked().equals("Y") )
        {
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getHdnEmpId())));                  
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));                  
         oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getDetailId())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFrom())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromHrs())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromMin())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtTo())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToHrs())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToMin())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
         oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_lbr_gang.proc_UpdateGangdate(?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
            errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
          errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();      
         return errMsg;
        }
        }         return errMsg;

  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {      
      ArrayList oList = new ArrayList();
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray, oList);
      checkWorkslipDetails(oBaseHeaderBean,oDetailBeanArray, oList);  // added by dushyant on 05-Sep-2011
      reportError(oList);      
    } 
  }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    Integer chkFlag = null;
    oIt = oDetailBeanArray.iterator();
   MaintGangHeaderBean oMaintGangHeaderBean = (MaintGangHeaderBean)oBaseHeaderBean;
    //System.out.println(oMaintGangHeaderBean.getTxtGangName());

      while(oIt.hasNext())
      {
        MaintGangBean oMaintGangBean = (MaintGangBean)oIt.next();
        if(!(oMaintGangBean.getStatus().equals("D")))
          count++;
          
        if(oMaintGangBean.getStatus().equals("N"))    
        {          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getHdnEmpId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintGangBean.getTxtFrom())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromHrs())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtFromMin())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtGangName())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtLocId())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getHdnEmpLbrFlag())));
          
          oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_chkLbrExist(?,?,?,?,?,?,?,?,?,?)",true,true);
      
          chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
          DBObject oMsgObject = (DBObject)oOutArray.get(1);    
          String error_msg = (String)oMsgObject.getObject();
          DBObject oErrObject = (DBObject)oOutArray.get(2);    
          Integer errorCode = (Integer)oErrObject.getObject();
          if(!(errorCode.equals(new Integer(0))))
          {        
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(error_msg));            
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }
          else
          {
            if(chkFlag.equals(new Integer(1)))
            { 
              ArrayList oArguments = new ArrayList();
              String empNo = oMaintGangBean.getTxtEmpName();
              empNo = empNo +" ("+oMaintGangBean.getHdnEmpId()+")";
              oArguments.add(new String(empNo));
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("Payroll.Labour.Gang.Error",oArguments));     
              oArguments = null;
            }      
            
            else if(chkFlag.equals(new Integer(2)))
            {
              ArrayList oArguments = new ArrayList();
              String empNo = oMaintGangBean.getTxtEmpName();
           
              oArguments.add(new String(empNo));
              oList.add(new EnrgiseApplicationException("Payroll.Labour.GangDate.Error",oArguments));     
             oArguments = null;
            }
          }  
            oMsgObject = null;
            oErrObject = null;
        }
      }
      oParameters=null;
      oOutArray=null; 
      oBean=null;
      oIt = null;
  }

  public GangComboVO getGangComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    GangComboVO oGangComboVO = new GangComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oMouList = null;
   
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getMOU(?,?)");
      
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
        oMouList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String mouLabel = oRow.get("code_desc").getString();
      String mouValue = oRow.get("code_desc").getString();
      oComboVO = new ComboVO(mouLabel,mouValue);
      oMouList.add(oComboVO);
      oComboVO = null;
      mouLabel = null;
      mouValue = null;
    }

    oGangComboVO.setMouList(oMouList);
    oParameters=null;
    oOutArray=null; 
    oIt=null;
    oBean=null;
    return oGangComboVO;
  }

  private void checkWorkslipDetails(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    Integer chkFlag = null;
    oIt = oDetailBeanArray.iterator();
    MaintGangHeaderBean oMaintGangHeaderBean = (MaintGangHeaderBean)oBaseHeaderBean;

      while(oIt.hasNext())
      {
        MaintGangBean oMaintGangBean = (MaintGangBean)oIt.next();
        if(!(oMaintGangBean.getStatus().equals("D")))
          count++;
          
        if(oMaintGangBean.getStatus().equals("U"))    
        {          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getHdnEmpId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintGangBean.getTxtTo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToHrs())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangBean.getTxtToMin())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGangHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_chkWorkslip(?,?,?,?,?,?,?,?,?)",true,true);
      
          chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
          
          
          DBObject oMsgObject = (DBObject)oOutArray.get(1);    
          String error_msg = (String)oMsgObject.getObject();
          DBObject oErrObject = (DBObject)oOutArray.get(2);    
          Integer errorCode = (Integer)oErrObject.getObject();
   
          DBObject oWrkObject = (DBObject)oOutArray.get(3);    
          String wrkslip_msg = (String)oWrkObject.getObject();
   
          if(!(errorCode.equals(new Integer(0))))
          {        
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(error_msg));            
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }
          else
          {
            if(chkFlag.equals(new Integer(1)))
            { 
              ArrayList oArguments = new ArrayList();
              String empNo = oMaintGangBean.getTxtEmpName();
              empNo = empNo +" ("+oMaintGangBean.getHdnEmpId()+")";
              oArguments.add(new String(empNo));
              oArguments.add(new Integer(count));
              oArguments.add(new String(wrkslip_msg));  
              oList.add(new EnrgiseApplicationException("Payroll.Labour.Gang.Workslip.Error",oArguments)); 
              oArguments = null;
              empNo = null;
            }                 
          } 
           oMsgObject=null;
           oWrkObject=null;
           oErrObject=null;
           wrkslip_msg = null;

        }
        oMaintGangBean = null;
      }
       oParameters=null;
       oOutArray=null; 
       oBean=null;
       oList=null;
  }
}