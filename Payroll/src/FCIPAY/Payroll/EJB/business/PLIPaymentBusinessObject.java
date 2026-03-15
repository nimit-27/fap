package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPaymentQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPaymentDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.PLIPaymentHeaderBean;
import FCIPAY.Payroll.UTILITY.PLIPaymentDetailBean;
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
import java.util.Calendar;

public class PLIPaymentBusinessObject extends BaseBO
{
  public PLIPaymentBusinessObject()
  {
  }
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;    
    int count = 0;
    int i=0;
    String errorMsg ="";
    PLIPaymentHeaderBean oPLIPaymentHeaderBean = (PLIPaymentHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    
      oParameters = new ArrayList();     
      /*Employee Header Info */         
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getHeaderPrimaryKey())));          
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtPLIType())));          
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtPLIPerc())));          
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtPLIAdvAmnt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String("E")));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtPLIYear())));  
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));      

      oOutArray = oBean.callProc(oParameters,"pkg_post_pli_ap.proc_InsPLIPaymentDetail(?,?,?,?,?,?,?,?,?,?,?)",true,true);        
  
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      //String sEmpNo = (String)oOutObject.getObject();
      DBObject oMsgObject = (DBObject)oOutArray.get(1);    
      String error_msg = (String)oMsgObject.getObject();
      DBObject oErrObject = (DBObject)oOutArray.get(2);    
      Integer errorCode = (Integer)oErrObject.getObject();
      if(!(errorCode.equals(new Integer(0))))
      {        
         ArrayList oArguments = new ArrayList();
         oArguments.add(new String(error_msg));
         System.out.println("Error!!! while Adjusting deductions ::"+error_msg);
         throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
      }
    return (String)oOutObject.getObject();
  }
  

   public RecordMetaInfo getPLIPaymentHeaderMetaInfo(PLIPaymentQueryVO oPLIPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String locCode = oPLIPaymentQueryVO.getLoginLocCode()+"";
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getOptSelectAllEmp())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtEmpNo())));      
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtPLIType())));    
    
      if(oPLIPaymentQueryVO.getTxtPLIType().toString().equals("PLIADV"))
      {
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtPLIAdvAmnt())));
      }
      
      else
      {
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtPLIPerc())));
      }
      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPaymentHeaderCount(?,?,?,?,?,?,?,?,?,?)");      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getPLIPaymentHeader(PLIPaymentQueryVO oPLIPaymentQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oPLIPaymentQueryVO == null)
    {
      oPLIPaymentQueryVO = new PLIPaymentQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    String locCode = oPLIPaymentQueryVO.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getOptSelectAllEmp())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtEmpNo())));      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtPLIType())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtPLIPerc())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getTxtPLIAdvAmnt())));
      oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPaymentHeader(?,?,?,?,?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      PLIPaymentHeaderBean oPLIPaymentHeaderBean;
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
          oPLIPaymentHeaderBean = new PLIPaymentHeaderBean();          
          //oPLIPaymentHeaderBean.setTxtEmpNo(oRow.get("lbr_typ").getString());
          if(oPLIPaymentQueryVO.getOptSelectAllEmp().equals("L"))
          {
            oPLIPaymentHeaderBean.setOptSelectAllEmp("L");
          }
          else
          {
            oPLIPaymentHeaderBean.setOptSelectAllEmp("E");
            oPLIPaymentHeaderBean.setTxtEmpNo(new String(oPLIPaymentQueryVO.getTxtEmpNo()));
          }
          oPLIPaymentHeaderBean.setHeaderPrimaryKey(oRow.get("fin_yyyy").getString());
          
          if(oPLIPaymentQueryVO.getTxtPLIType().toString().equals("PLIADV"))
            oPLIPaymentHeaderBean.setTxtPLIAdvAmnt(oRow.get("pli_adv_amount").getString());
          else
            oPLIPaymentHeaderBean.setTxtPLIPerc(oRow.get("pli_perc").getString());
            
          oPLIPaymentHeaderBean.setTxtPLIType(oPLIPaymentQueryVO.getTxtPLIType().toString());
          
          oPLIPaymentHeaderBean.setHdnEmpLbrFlag(oPLIPaymentQueryVO.getHdnEmpLbrFlag());          
          oHeaderList.add(oPLIPaymentHeaderBean);
      }              
    return oHeaderList;
  }
  
  public RecordMetaInfo getPLIPaymentDetailMetaInfo(String sPrimaryKey,PLIPaymentDetailInfo oPLIPaymentDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
  
      String locCode = oPLIPaymentDetailInfo.getLoginLocCode()+"";
      System.out.println(oPLIPaymentDetailInfo.getScreenModeFlag());     
      
  
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getOptSelectAllEmp())));
      if(oPLIPaymentDetailInfo.getOptSelectAllEmp().equals("E"))
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtEmpNo())));  
      else
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("")));  
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));  
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIType())));
      
         if(oPLIPaymentDetailInfo.getTxtPLIType().toString().equals("PLIADV"))
        {
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIAdvAmnt())));
        }
       else
        {
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIPerc())));
        }
      
   //   oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIPerc()))); 
   //   oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIAdvAmnt())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getHdnEmpLbrFlag()))); 
      //oParameters.add(new DBObjec(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPaymentDtlCount(?,?,?,?,?,?,?,?,?,?)");    
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }

 public ArrayList getPLIPaymentDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,PLIPaymentDetailInfo oPLIPaymentDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    PLIPaymentDetailBean oPLIPaymentDetailBean; 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;
      String locCode = oPLIPaymentDetailInfo.getLoginLocCode()+"";

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getOptSelectAllEmp())));      
      if(oPLIPaymentDetailInfo.getOptSelectAllEmp().equals("E"))
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtEmpNo())));      
      else
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String("")));      
      
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIType()))); 
      
       if(oPLIPaymentDetailInfo.getTxtPLIType().toString().equals("PLIADV"))
        {
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIAdvAmnt())));
        }
       else
        {
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIPerc())));
        }

      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getHdnEmpLbrFlag())));    
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPaymentDtl(?,?,?,?,?,?,?,?,?,?,?)");     
      
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
          oPLIPaymentDetailBean = new PLIPaymentDetailBean();
          oPLIPaymentDetailBean.setTxtAllEmpNo((oRow.get("emp_num").getString()));          
          oPLIPaymentDetailBean.setTxtAllEmpName((oRow.get("empName").getString()));
          oPLIPaymentDetailBean.setTxtDesig((oRow.get("dsgn_desc").getString()));                              
          if(oPLIPaymentDetailInfo.getTxtPLIType().equals("PLIPAY"))
          {
            oPLIPaymentDetailBean.setPrevPLIPaidAmnt((oRow.get("pli_advance").getString()));
            oPLIPaymentDetailBean.setTxtPLIAmnt((oRow.get("pli_amount").getString()));          
            oPLIPaymentDetailBean.setTxtIncomTax((oRow.get("pli_it_deduct").getString()));
            oPLIPaymentDetailBean.setTxtLeaveDed((oRow.get("pli_leave_dedn").getString()));
            oPLIPaymentDetailBean.setNetAmntPayble((oRow.get("pli_net_amount").getString()));                    
          } 
          else
          {
            oPLIPaymentDetailBean.setPrevPLIPaidAmnt((oRow.get("pli_adv_amount").getString()));
            oPLIPaymentDetailBean.setTxtIncomTax((oRow.get("pli_it_deduct").getString()));
            oPLIPaymentDetailBean.setNetAmntPayble((oRow.get("pli_bal_amount").getString()));  
          } 
          //oPLIPaymentDetailBean.setStatus("Q");
          oDARateDetail.add(oPLIPaymentDetailBean);
        }             
        return oDARateDetail; 
  }  
  
  /*private RecordMetaInfo getNewPLIEmpDetailMetaInfo(String locCode, PLIPaymentDetailInfo oPLIPaymentDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      //System.out.println(oPLIPaymentDetailInfo.getScreenMode());
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getOptSelectAllEmp())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtEmpNo())));              
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIYear())));              
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIType())));              
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPayEmpCount(?,?,?,?,?,?,?,?)");      
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }
  
  private ArrayList getNewPLIEmpDetail(String locCode, long lDetailFirstPosition,long lDetailLastPosition,PLIPaymentDetailInfo oPLIPaymentDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    PLIPaymentDetailBean oPLIPaymentDetailBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getOptSelectAllEmp())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtEmpNo())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIYear())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentDetailInfo.getTxtPLIType())));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPayEmpDtl(?,?,?,?,?,?,?,?,?)");      
      
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
          oPLIPaymentDetailBean = new PLIPaymentDetailBean();          
          oPLIPaymentDetailBean.setTxtAllEmpNo((oRow.get("emp_num").getString()));
          oPLIPaymentDetailBean.setTxtAllEmpName((oRow.get("empName").getString()));          
          oPLIPaymentDetailBean.setTxtDesig((oRow.get("dsgn_desc").getString()));          
          oPLIPaymentDetailBean.setPrevPLIPaidAmnt((oRow.get("pli_adv_amt").getString()));
          oPLIPaymentDetailBean.setTxtPLIAmnt("");
          oPLIPaymentDetailBean.setTxtIncomTax("");
          oPLIPaymentDetailBean.setNetAmntPayble("");   
          oPLIPaymentDetailBean.setStatus("N");
          oPLIPaymentDetailInfo.setScreenModeFlag("false");
          oDARateDetail.add(oPLIPaymentDetailBean);
        }             
        return oDARateDetail; 
  }*/  

  public boolean savePayScaleHeader(PLIPaymentHeaderBean oPLIPaymentHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       return true;
  } 

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
      savePLIPayment(sHeaderPrimaryKey,oDetailBeanArray,(PLIPaymentHeaderBean)oBaseHeaderBean);   
  }   
  
 private void savePLIPayment(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,PLIPaymentHeaderBean oPLIPaymentHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
   /* boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters    
    ArrayList oOutArray=new ArrayList();
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    
      Iterator oIt = oDetailBeanArray.iterator();
      StringBuffer empNolist = new StringBuffer("");
      //String sEmpType="E";
      while(oIt.hasNext())
      {
        PLIPaymentDetailBean oPLIPaymentDetailBean = (PLIPaymentDetailBean)oIt.next();
        if(oPLIPaymentDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if (empNolist.length()==0)				
            empNolist.append(new String(oPLIPaymentDetailBean.getTxtAllEmpNo())); 			
          else
          {
            empNolist.append(",");
            empNolist.append(new String(oPLIPaymentDetailBean.getTxtAllEmpNo())); 			
          }                  
        }      
      }    
        if (empNolist.length()==0)				
          empNolist.append(0);
          
        oParameters = new ArrayList();                    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNolist)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getHeaderPrimaryKey())));          
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtPLIType())));          
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtPLIPerc())));          
        //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));                    
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtPLIAdvAmnt())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtSiteID())));         
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getHdnEmpLbrFlag()))); //hardcording for 'E' is modified by swapnendu Dt 07-Nov-2012
        oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
        //oPLIPaymentHeaderBean.setScreenModeFlag("false");
     //   oBeanInsert.addToBatch(oParameters);
          oBeanInsert = new DBUtilitiesBean();
          String emplbr=oPLIPaymentHeaderBean.getHdnEmpLbrFlag().toString();
          if(emplbr.equalsIgnoreCase("E"))
          {}
          else{
          oOutArray = oBeanInsert.callProc(oParameters,"pkg_post_pli_ap.proc_InsPLIPaymentBulk(?,?,?,?,?,?,?,?,?,?)",true,true);
          }
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          System.out.println("Error!!! while inserting Loan Details ::"+errCode);
          if( ! errCode.equals(new Integer(0)))
          {
             ArrayList oArguments = new ArrayList();
             oArguments.add(new String((String)oOutObject.getObject()));
             throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
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
      }*/
  }
   
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("DARatesCDAScreen"))
    {
      sDetailTable = "lstPayScaleDtl";
    }
    initializeBO("DARateCDAScreen",sDetailTable);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtFinYr").trim()))); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtType").trim()))); 
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtScreenMode").trim()))); 
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));      
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPLIPayEmpLOV(?,?,?,?,?,?,?,?,?)");
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
      checkYrEndRemittance(oBaseHeaderBean,oList); //added by swapnendu Dt 21 Mar 2012
      checkPLILimit(oBaseHeaderBean,oList);//added by geetika Dt 14-10-2014
      reportError(oList);
  }

    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        PLIPaymentHeaderBean oPLIPaymentHeaderBean = (PLIPaymentHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oPLIPaymentHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oPLIPaymentHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oPLIPaymentHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(4, DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_othrPaymnt_YrEndcheck(?,?,?,?,?)",true,true);
        Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
        String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() != 0)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
        }
    }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    //checkDaRatHeader(oBaseHeaderBean,oList);
    //checkDaRateGreaterHeader(oBaseHeaderBean,oList);
    reportError(oList);
    
    
  }

 /*private void checkDaRatHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        PLIPaymentHeaderBean  oPLIPaymentHeaderBean  = (PLIPaymentHeaderBean)oBaseHeaderBean;

//        System.out.println(oPLIPaymentHeaderBean.getHeaderMode());       
        if(oPLIPaymentHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtDAType())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DADuplicateCheck(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.DARate.DuplicateCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }*/


  /*private void checkDaRateGreaterHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        PLIPaymentHeaderBean  oPLIPaymentHeaderBean  = (PLIPaymentHeaderBean)oBaseHeaderBean;

//        System.out.println(oPLIPaymentHeaderBean.getHeaderMode());
        
        if(oPLIPaymentHeaderBean.getHeaderMode().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPLIPaymentHeaderBean.getTxtYYMM())));
          
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DaCheck(?,?,?)");
          oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yyyymm").getString(); 
              if (!sRevYear.equals("0"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(sRevYear);              
                oList.add(new EnrgiseApplicationException("Payroll.DaRate.YearCheck",oArguments));              
              }                
             }


          /* oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.DARate.GreaterCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }*/
  
  //added by geetika on 14-10-2014
  private void checkPLILimit(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        Calendar cal = Calendar.getInstance();
        int month =cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        String yearmonth1;
        if (month<10)
        {
          yearmonth1 =  Integer.toString(year) + 0 +Integer.toString(month);
        }
        else
        {
          yearmonth1 =  Integer.toString(year) + Integer.toString(month);
        
        }
        
        int yearmonth = Integer.parseInt(yearmonth1);
        PLIPaymentHeaderBean oPLIPaymentHeaderBean = (PLIPaymentHeaderBean)oBaseHeaderBean;
        if (oPLIPaymentHeaderBean.getTxtPLIAdvAmnt().toString().equalsIgnoreCase(""))
        {
        }
        else
        {
        int userPLI=Integer.parseInt(oPLIPaymentHeaderBean.getTxtPLIAdvAmnt());
        String plitype = oPLIPaymentHeaderBean.getTxtPLIType();
        if (plitype.equals("PLIADV"))
        {
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String("PLI Adv Limit")));
        }
        else
        {
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String("PLI Act Limit")));
        }
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.INTEGER, new Integer(yearmonth)));
        oParameters.add(new DBObject(3, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_pay_fixed_misc_param.Get_Allow_PLI(?,?,?)",true,true);
        Integer errCode = (Integer)(((DBObject)(oOutArray.get(0))).getObject());
        if(userPLI>errCode.intValue())
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(errCode);
            oList.add(new EnrgiseApplicationException("Payroll.PLI.message",oArguments));
        }
        }
    }
}