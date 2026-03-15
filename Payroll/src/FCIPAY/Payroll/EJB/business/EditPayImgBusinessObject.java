package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintElecMtrRdgQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.EnqPayImgBean;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageDetailInfo;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EditPayImgComboVO;
import FCIPAY.Payroll.UTILITY.EnqPayImageHeaderBean;

import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class EditPayImgBusinessObject extends BaseBO
{
  public EditPayImgBusinessObject()
  {
  }
  
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;        
    if(sScreenName.equals("EnqPayImgScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return;   
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
     return null;
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    if(sScreenName.equals("EditPayImgScreen"))
   {      
      saveEditPayImg(sHeaderPrimaryKey,(EnqPayImageHeaderBean)oBaseHeaderBean,oDetailBeanArray);
    }      
  }
  
    private void saveEditPayImg(String sPrimaryKey,EnqPayImageHeaderBean oEnqPayImageHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oOutArray=new ArrayList();
    ArrayList oOutUpdArray=new ArrayList();
    ArrayList oOutDelArray=new ArrayList();
    DBUtilitiesBean oBeanUpdate = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;       
  
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        EnqPayImgBean oEnqPayImgBean = (EnqPayImgBean)oIt.next();

        if(oEnqPayImgBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oEnqPayImageHeaderBean.getTxtEmpNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oEnqPayImageHeaderBean.getTxtYtm())));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtPayCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtPayMode())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtAmt())));  
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtGrossEar())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtGrossDed())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtNetEar())));
          
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));
          
          oBeanInsert = new DBUtilitiesBean();
          oOutArray = oBeanInsert.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertPayImageManual(?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          System.out.println("Error!!! while inserting Loan Details ::"+errCode);
          if( ! errCode.equals(new Integer(0)))
          {
             ArrayList oArguments = new ArrayList();
             oArguments.add(new String((String)oOutObject.getObject()));
             throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          } 

        }
        else if(oEnqPayImgBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oEnqPayImageHeaderBean.getTxtEmpNo())));          
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oEnqPayImageHeaderBean.getTxtYtm())));          
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtPayCode())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtSrlNo()))); 
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtPayMode())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtAmt())));  
            
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtGrossEar())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtGrossDed())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtNetEar())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER));
            
            oBeanUpdate = new DBUtilitiesBean();
            oOutUpdArray = oBeanUpdate.callProc(oParameters,"PAYROLL_PKG_EXT.proc_UpdatePayImageManual(?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
            DBObject oOutObject = (DBObject)oOutUpdArray.get(0);
            Integer errCode = (Integer)((DBObject)oOutUpdArray.get(1)).getObject();            
            if( ! errCode.equals(new Integer(0)))
            {
               ArrayList oArguments = new ArrayList();
               oArguments.add(new String((String)oOutObject.getObject()));
               throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }            
          }  
        }
        else if(oEnqPayImgBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(oEnqPayImageHeaderBean.getTxtEmpNo())));          
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oEnqPayImageHeaderBean.getTxtYtm())));          
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtPayCode())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImgBean.getTxtSrlNo())));            
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
            
            oBeanDelete = new DBUtilitiesBean();
            oOutDelArray = oBeanDelete.callProc(oParameters,"PAYROLL_PKG_EXT.proc_DeletePayImageManual(?,?,?,?,?,?,?)",true,true);
            DBObject oOutObject = (DBObject)oOutDelArray.get(0);
            Integer errCode = (Integer)((DBObject)oOutDelArray.get(1)).getObject();            
            if( ! errCode.equals(new Integer(0)))
            {
               ArrayList oArguments = new ArrayList();
               oArguments.add(new String((String)oOutObject.getObject()));
               throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }                      
            //oBeanDelete.addToBatch(oParameters);          
          }
        }
      }
      
      if(bInsert)
      {
        oBeanInsert.executeBatch();
      }
      
      if(bUpdate)
      {
        oBeanUpdate.executeBatch();        
      }

      if(bDelete)
      {
        oBeanDelete.executeBatch();
      }   
  }
  
  public RecordMetaInfo getEnqPayImageHeaderMetaInfo(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  { 
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
      //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
      //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
      //oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
      //oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_GetPayImgCntEditable(?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
   
  }

  public ArrayList getEnqPayImageHeader(EnqPayImageQueryVO oEnqPayImageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oEnqPayImageQueryVO == null)
    {
      oEnqPayImageQueryVO = new EnqPayImageQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
      //oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
      //oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
      //oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
      //oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_GetPayImageHdrEditable(?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      EnqPayImageHeaderBean oEnqPayImageHeaderBean;
      count = 0;
      QueryRow oRow = null;
      HashMap oColumns = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oHeaderList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oEnqPayImageHeaderBean = new EnqPayImageHeaderBean();
          oEnqPayImageHeaderBean.setTxtEmpNo(oRow.get("Emp_No").getString());          
          oEnqPayImageHeaderBean.setTxtEmpName(oRow.get("EmpName").getString());
          oEnqPayImageHeaderBean.setLstGroup(oRow.get("cadre").getString());
          oEnqPayImageHeaderBean.setLstCateg(oRow.get("emp_category").getString());
          oEnqPayImageHeaderBean.setTxtDesig(oRow.get("Dsgn_Desc").getString());
          oEnqPayImageHeaderBean.setTxtYtm(oRow.get("YYMM").getString());
          oEnqPayImageHeaderBean.setTxtCurrBas(oRow.get("basic").getString());
          oHeaderList.add(oEnqPayImageHeaderBean);
      }    
        
    return oHeaderList;
    }

    
  public RecordMetaInfo getEnqPayImageDetailMetaInfo(String sPrimaryKey,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

    String EmpNo,YearMon;
    EmpNo=oEnqPayImageDetailInfo.getTxtEmpNo();
    YearMon = oEnqPayImageDetailInfo.getTxtYtm();    
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,YearMon));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_GetPayImageDtlCntEditable(?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }

  public ArrayList getEnqPayImageDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    EnqPayImgBean oEnqPayImgBean;    
    String EmpNo,YearMon,empFlag;
    EmpNo=oEnqPayImageDetailInfo.getTxtEmpNo();
    YearMon = oEnqPayImageDetailInfo.getTxtYtm();   
    empFlag = oEnqPayImageDetailInfo.getHdnEmpLbrFlag();
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oEnqPayImageDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,YearMon));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,empFlag));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_GetPayImageDtlEditable(?,?,?,?,?,?,?)");
      
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
            oEnqPayImageDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oEnqPayImgBean = new EnqPayImgBean();
          oEnqPayImgBean.setStatus("Q");
          oEnqPayImgBean.setTxtPayCode(oRow.get("Pay_Code").getString());
          oEnqPayImgBean.setTxtDesc(oRow.get("Pay_Code_Desc").getString());
          oEnqPayImgBean.setTxtSrlNo(oRow.get("Pay_Code_Srl").getString());
          oEnqPayImgBean.setTxtPayMode(oRow.get("Pay_Mode").getString());
          oEnqPayImgBean.setTxtAmt(oRow.get("Txn_Amt").getString());
          oEnqPayImageDetail.add(oEnqPayImgBean);
        }       
        
    return oEnqPayImageDetail;    
  }


public LovVO getEnqYmtLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("YYMM");    
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PopupYearMonthData(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("YYMM").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public LovVO getEditEmpNoLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code");    
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
    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField3(); 
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Name));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField2()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_EditPayImgEmployeeNoData(?,?,?,?,?,?,?)");
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
     oLOVBean.setDetailField2(oRow.get("empName").getString()); 
     oLOVBean.setDetailField3(oRow.get("cpf_code").getString()); 
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getEditEmpNoLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code");    
    arylstHeaderNames.add("Cadre");    
    arylstHeaderNames.add("Emp Category");    
    arylstHeaderNames.add("Basic");    
    arylstHeaderNames.add("Designation");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField3(); 
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;

    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Name));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getSearchField2()));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("payYrMonth")));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertEditPaySlipEmpLOV(?,?,?,?,?,?,?,?)");
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
     oLOVBean.setDetailField2(oRow.get("empName").getString());
     oLOVBean.setDetailField3(oRow.get("cpf_code").getString()); 
     oLOVBean.setDetailField4(oRow.get("cadre").getString()); 
     oLOVBean.setDetailField5(oRow.get("emp_category").getString()); 
     oLOVBean.setDetailField6(oRow.get("basic").getString()); 
     oLOVBean.setDetailField7(oRow.get("dsgn_desc").getString()); 
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


  public LovVO getEditPayImgPayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Paycode");  
    arylstHeaderNames.add("PaycodeDesc"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);    
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEditPayImgPayCodeLov(?,?,?,?)");
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

  public EditPayImgComboVO getEnqPayImageComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {    
    ComboVO oComboVO = null;
    EditPayImgComboVO oEditPayImg=null;
    /* Newly Added */
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayCode = null;
    ArrayList oCategValues = null;
    ArrayList oGroupValues = null;
    EnqPayImageQueryVO oEnqPayImageQueryVO = new EnqPayImageQueryVO();
     String abc = Long.toBinaryString(oEnqPayImageQueryVO.getLoginLocCode());
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(abc)));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getMaxYYMM(?,?,?)");
      
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
        oPayCode = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String payCodeLabel = oRow.get("pYYMM").getString();
      String payCodeValue = oRow.get("pYYMM").getString();
      oComboVO = new ComboVO(payCodeLabel,payCodeValue);
      oPayCode.add(oComboVO);
    }          
    oEditPayImg.setValYrMnth(oPayCode);    
    return oEditPayImg;
  }

  public String getMaxPayYear(long siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    int iRes=0;
    String sRevYear="";
    String status ="";
    String flag="";
      
    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));    
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getMaxYYMM(?,?,?,?)");
     sRevYear = ((DBObject)oOutArray.get(0)).getObject().toString();
    //oIt = oRetList.iterator();
   
      //sRevYear = oIt.get("yymm").getString(); 
     
    return sRevYear;
  }
  
  public ArrayList getPayCodeDetail(String sPayCode)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oResult = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    
    Timestamp oWhenPicked = null;
    int count = 0;        
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();    
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPayCode)));            
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.VARCHAR));            
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));       
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getPayCodeDetail(?,?,?)",true,true);                
    
    String payCodeDesc;      
    DBObject oErrObject = (DBObject)oOutArray.get(1);    
    Integer errorCode = (Integer)oErrObject.getObject();
    
    if((errorCode.equals(new Integer(0))))
    {               
      payCodeDesc = (String)((DBObject)oOutArray.get(0)).getObject();                    
    }
    else
    {
      payCodeDesc = "";            
    }
    oResult.add(payCodeDesc);            
    return oResult;      
  } 

  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
}