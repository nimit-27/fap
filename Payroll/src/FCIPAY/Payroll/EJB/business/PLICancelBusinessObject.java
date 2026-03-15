package FCIPAY.Payroll.EJB.business;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIActCancelQueryVO;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIActCancelQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPayCanDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPaymentDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayQueryVO;

import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;

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
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.UTILITY.PLIPayCanDetailBean;

import FCIPAY.Payroll.UTILITY.PLIPayCanHeaderBean;

import java.util.Calendar;


public class PLICancelBusinessObject extends BaseBO
{
    
    public PLICancelBusinessObject() 
    {
        
    }
    public void initializeBOImpl(String sScreenName)
    {
     String sDetailTable = null;
     if(sScreenName.equals("PLIPaymentCancellation"))
     {
       sDetailTable = "aaa_myadd";
     }
     initializeBO("aaa_myself",sDetailTable);
    }
    
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
    {
      return null;
    }
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException
    {
      
    }
    public RecordMetaInfo getPLIPaymentCancelHeaderMetaInfo(PLIActCancelQueryVO oPLIActCancelQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     ArrayList oParameters = new ArrayList(); 
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     ArrayList oList;
     Timestamp oWhenPicked = null;
     int count = 0;
     BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
     
     
     ArrayList oOutArray; //Output 

       oParameters = new ArrayList();  
       
       oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIActCancelQueryVO.getTxtPLIYear())));
       oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new Long(oPLIActCancelQueryVO.getLoginLocCode())));
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIActCancelQueryVO.getTxtEmpNo())));    
       oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIActCancelQueryVO.getHdnEmpLbrFlag())));
       oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
       oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
       oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
       oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getplipayheadercount(?,?,?,?,?,?,?)");      
       RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
       
       DBObject oTimeObject = (DBObject)oOutArray.get(1);
       oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
       DBObject oTotalRecord = (DBObject)oOutArray.get(0);
       oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
       return oRecordMetaInfo;
     
    }
    
    public ArrayList getPLIPaymentHeader1(PLIActCancelQueryVO oPLIActCancelQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;

      if(oPLIActCancelQueryVO == null)
      {
        oPLIActCancelQueryVO = new PLIActCancelQueryVO();
      }
      
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;
      String locCode = oPLIActCancelQueryVO.getLoginLocCode()+"";
        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));       
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIActCancelQueryVO.getTxtEmpNo())));      
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIActCancelQueryVO.getTxtPLIYear())));        
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIActCancelQueryVO.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getplipayheader(?,?,?,?,?,?,?,?)");
        
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
       

        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        PLIPayCanHeaderBean oPLIPayCanHeaderBean;
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
            oPLIPayCanHeaderBean = new PLIPayCanHeaderBean();          
           
            oPLIPayCanHeaderBean.setTxtEmpNo(new String(oPLIActCancelQueryVO.getTxtEmpNo()));           
            oPLIPayCanHeaderBean.setHeaderPrimaryKey(oRow.get("fin_yyyy").getString());      
            oPLIPayCanHeaderBean.setHdnEmpLbrFlag(oPLIActCancelQueryVO.getHdnEmpLbrFlag());          
            oHeaderList.add(oPLIPayCanHeaderBean);
        }              
      return oHeaderList;
    }
    
    public RecordMetaInfo getPLIPayDetailMetaInfo(String sPrimaryKey,PLIPayCanDetailInfo oPLIPayCanDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      
        oParameters = new ArrayList();
    
        String locCode = oPLIPayCanDetailInfo.getLoginLocCode()+"";
        System.out.println(oPLIPayCanDetailInfo.getScreenModeFlag());
        
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));       
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPayCanDetailInfo.getTxtEmpNo())));  
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPayCanDetailInfo.getTxtPLIYear())));       
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPayCanDetailInfo.getHdnEmpLbrFlag()))); 
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));      
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getplipaydtlcount(?,?,?,?,?,?,?)");    
        
        RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

        DBObject oTotalRecord = (DBObject)oOutArray.get(0);
        oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
        DBObject oTimeObject = (DBObject)oOutArray.get(1);
        oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
        return oRecordMetaInfo;          
    }

    public ArrayList getPLIPaymentDetail1(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,PLIPayCanDetailInfo oPLIPayCanDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {  
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      PLIPayCanDetailBean oPLIPayCanDetailBean; 
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oDARateDetail = null;
        
      String locCode = oPLIPayCanDetailInfo.getLoginLocCode()+"";
      oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPayCanDetailInfo.getTxtEmpNo())));      
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));      
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPayCanDetailInfo.getHdnEmpLbrFlag())));    
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getplipaydtl(?,?,?,?,?,?,?,?)");     
        
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
              oDARateDetail = new ArrayList();
            }
            count++;
            oRow = (QueryRow)oIt.next();
            oPLIPayCanDetailBean = new PLIPayCanDetailBean();
            oPLIPayCanDetailBean.setTxtEmpNo((oRow.get("emp_num").getString()));          
            oPLIPayCanDetailBean.setTxtEmpName((oRow.get("empName").getString()));
            oPLIPayCanDetailBean.setTxtPLIAmnt((oRow.get("pli_amount").getString()));   
            oPLIPayCanDetailBean.setTxtInvoice((oRow.get("invoice_num").getString()));
           /* oPLIPayCanDetailBean.setTxtLocId((oRow.get("location").getString()));  */
            oPLIPayCanDetailBean.setStatus("Q");
            oDARateDetail.add(oPLIPayCanDetailBean);
          }             
          return oDARateDetail; 
    }
    
    public LovVO getEmpLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    
      LovVO oLovVO=new LovVO();  
      ArrayList arylstHeaderNames=new ArrayList();
      arylstHeaderNames.add("Location Code");
      arylstHeaderNames.add("Location Name");
      arylstHeaderNames.add("Parent Location");
      oLovVO.setHeaderList(arylstHeaderNames);
      arylstHeaderNames=null;
      
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
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_employeelocdata(?,?,?,?,?)");
      DBObject oOutObject=(DBObject)oOutArray.get(0);
      oList=(ArrayList)(oOutObject.getObject());
      oParameters=null;
      
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
        oLOVBean.setDetailField3(oRow.get("parent_loc_desc").getString());      
        oList.add(oLOVBean);
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
    public LovVO getPLIPayEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    
      LovVO oLovVO=new LovVO();  
      ArrayList arylstHeaderNames=new ArrayList();
      arylstHeaderNames.add("Employee No");    
      arylstHeaderNames.add("Employee Name");        
      oLovVO.setHeaderList(arylstHeaderNames);
      
      ArrayList arylstVisibility=new ArrayList();
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
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtLocationID").trim())));      
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtScreenMode").trim()))); 
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));      
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getplicancelemplov(?,?,?,?,?,?,?)");
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
          
           oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
           oLOVBean.setDetailField2(oRow.get("EMP_NAME").getString());            
          oList.add(oLOVBean);
        }
         
        oLovVO.setDetailList(oList);
      return oLovVO;
    }
    
    
    
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     ArrayList oList = new ArrayList();

    }
    
    public String  CancelPLIPaymentInv(PLIActCancelQueryVO oPLIActCancelQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      
      String msg=null;
    
      if(oPLIActCancelQueryVO == null)
      {
        oPLIActCancelQueryVO = new PLIActCancelQueryVO();
      } 
     
      ArrayList oOutArray; //Output 
      ArrayList oParamList = new ArrayList();  
      ArrayList oList = new ArrayList();  
      
        String screenName=oPLIActCancelQueryVO.getScreenName();
        
      oParameters = new ArrayList();                               
        
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPLIActCancelQueryVO.getTxtEmpNo()))));  
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPLIActCancelQueryVO.getTxtInvoice()))));     
         
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oPLIActCancelQueryVO.getScreenName()))));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oPLIActCancelQueryVO.getLoginLocCode()))));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new Long(oPLIActCancelQueryVO.getLoginEmployeeNo()))));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      
      oOutArray = oBean.callProc(oParameters,"pkg_cancel_othr_pymnt_inv.proc_cancel_op_invoices(?,?,?,?,?,?,?)",true,true);      
       
      DBObject oErrMsg = (DBObject)oOutArray.get(0);
      DBObject oErrCode = (DBObject)oOutArray.get(1);
        Integer errCode=(Integer)oErrCode.getObject();
        String  errMsg=(String)oErrMsg.getObject();
        if(!errCode.equals(new Integer(0)))
        {
          ArrayList oArguments = new ArrayList();
          oArguments.add((String)oErrMsg.getObject());          
          throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
        }        
        
      return errMsg;
    }

    
    
    public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {

    }
    public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     
    }
    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
     {
       
     }  
    
    
    
    
}
