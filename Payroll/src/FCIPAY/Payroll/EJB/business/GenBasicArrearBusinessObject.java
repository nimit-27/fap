package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenBasicArrearQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BasicArrDetailInfo;
import java.sql.SQLException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.BasicArrearHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.UTILITY.GenerateBasicArrearBean;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayYearStatusVO;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.PayrollSQLQueries;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class GenBasicArrearBusinessObject extends BaseBO
{
  public GenBasicArrearBusinessObject()
  {
  }

  public RecordMetaInfo getBasicArrearHeaderMetaInfo(GenBasicArrearQueryVO oGenBasicArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenBasicArrearQueryVO.getTxtpayYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oGenBasicArrearQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new Long(oGenBasicArrearQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBasicArrCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getBasicArrearHeader(GenBasicArrearQueryVO oGenBasicArrearQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oGenBasicArrearQueryVO == null)
    {
      oGenBasicArrearQueryVO = new GenBasicArrearQueryVO();
    }
    
     ArrayList oOutArray; //Output 
     ArrayList oHeaderList = null;

          oParameters = new ArrayList();
       
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oGenBasicArrearQueryVO.getLoginLocCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oGenBasicArrearQueryVO.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));

            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");

            ArrayList oRetList = null;
            Iterator oIt = null;
            QueryRow oRow = null;            
            
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

            String sCurYYMM = "";
            String status = "";
  
            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              sCurYYMM = oRow.get("yymm").getString(); 
              status = oRow.get("status").getString(); 
            }    

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenBasicArrearQueryVO.getTxtpayYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oGenBasicArrearQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new Long(oGenBasicArrearQueryVO.getLoginLocCode())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBasicArr(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      BasicArrearHeaderBean oBasicArrHeader;
      count = 0;
      oRow = null;
      HashMap oColumns = null;
      oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oHeaderList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oBasicArrHeader = new BasicArrearHeaderBean();
          oBasicArrHeader.setTxtpayYYMM(oRow.get("pay_yymm").getString());
          oBasicArrHeader.setHdnPayrollFlag(oRow.get("payroll_flag").getString());
          oBasicArrHeader.setHdnCurYYMM(sCurYYMM);
          oBasicArrHeader.setHdnPayStatus(status);
          oHeaderList.add(oBasicArrHeader);
      }              
    return oHeaderList;
  }


 public RecordMetaInfo getBasicArrearDetailMetaInfo(String sPrimaryKey,BasicArrDetailInfo oBasicArrDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

       String PayYYMM;
      PayYYMM = oBasicArrDetailInfo.getTxtpayYYMM(); 
     
      
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,PayYYMM));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oBasicArrDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.BIGINT,new Long(oBasicArrDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBasicArrDtlCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
 



 public ArrayList getBasicArrearDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,BasicArrDetailInfo oBasicArrDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    GenerateBasicArrearBean oBasicArrDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oBasicArrDetail = null;

      String PayYYMM;
      PayYYMM = oBasicArrDetailInfo.getTxtpayYYMM();
        
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,PayYYMM));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oBasicArrDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.BIGINT,new Long(oBasicArrDetailInfo.getLoginLocCode())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBasicArrDetail(?,?,?,?,?,?,?)");
      
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
            oBasicArrDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oBasicArrDtl = new GenerateBasicArrearBean();
          oBasicArrDtl.setTxtEmployeeNo((oRow.get("emp_num").getString()));          
       //   oPayScaleDtl.setTxtRevYYMM1((oRow.get("rev_year").getString()));
        //  oPayScaleDtl.setTxtPayScaleCode((oRow.get("pay_scale_code").getString()));
          oBasicArrDtl.setTxtEmployeeName((oRow.get("name").getString()));
          oBasicArrDtl.setTxtFromDate(EnrgiseUtil.convertToString(oRow.get("from_date").getDate()));
          oBasicArrDtl.setTxtUptoMonth((oRow.get("to_yymm").getString()));                    
       
          oBasicArrDtl.setStatus("Q");
          oBasicArrDetail.add(oBasicArrDtl);
        }             
        return oBasicArrDetail; 
  }    



  public boolean saveBasicArrearHeader(BasicArrearHeaderBean oBasicArrearHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   /* ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResultSet oRs;
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPayScaleDtlIDABean oPayScaleDtlBean;
    BaseDetailVO oBaseDetailVO = null;
          
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(oPayScaleHeaderBean.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getTxtRevYYMM()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getLstPayScale()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getLstPayScale()));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_SaveGlobalCodeHeader(?,?,?,?)");
*/
      return true;
  }
  

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    /* ArrayList oParameters = new ArrayList(); //Input Parameters
     DBUtilitiesBean oBean = new DBUtilitiesBean();
     ArrayList oList;
     int count = 0;
     PayScaleHeaderBean oPayScaleHeaderBean = (PayScaleHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_InsertGlobalCode(?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0); 
      return (String)oOutObject.getObject();*/
   return null ;  
  }  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  /*  ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    PayScaleHeaderBean oPayScaleHeaderBean = (PayScaleHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oPayScaleHeaderBean.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_UpdateGlobalCode(?,?,?,?)");    
*/
  }  

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  if(sScreenName.equals("GenerateBasicArrearScreen") || sScreenName.equals("GenerateDepBasicArrearScreen"))
    {
        saveBasicArrear(sHeaderPrimaryKey,oDetailBeanArray,(BasicArrearHeaderBean)oBaseHeaderBean);
    }
  }   
  
 private void saveBasicArrear(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,BasicArrearHeaderBean oBasicArrearHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
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
        GenerateBasicArrearBean oGenerateBasicArrearBean = (GenerateBasicArrearBean)oIt.next();
//        System.out.println(oGenerateBasicArrearBean.getStatus());
        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oGenerateBasicArrearBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertBasicArrDetail(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtEmployeeNo())));
         // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oGenerateBasicArrearBean.getTxtFromDate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oGenerateBasicArrearBean.getTxtFromDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtUptoMonth())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
       else if(oGenerateBasicArrearBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateBasicArr(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
        
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oGenerateBasicArrearBean.getTxtFromDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtUptoMonth())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtSiteID())));
        
          oBean.addToBatch(oParameters);
          
        }
     else if(oGenerateBasicArrearBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
             Integer sitId=new Integer(oBasicArrearHeaderBean.getTxtSiteID());
             String yrChck=chckPayrollRunning(sitId,new String(oBasicArrearHeaderBean.getHdnEmpLbrFlag()));
            // System.out.println("value of year"+yrChck);
             if(!yrChck.equals("0"))
             {
                   throw new EnrgiseApplicationException("Payroll.BasicArrear.Deleteemp",EnrgiseConstants.MESSAGE); 
             }
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteBasicArrDetail(?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oGenerateBasicArrearBean.getTxtFromDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getHdnEmpLbrFlag())));
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
      }
       oBasicArrearHeaderBean.setScreenModePay1("U");     
  }
   
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("GenerateBasicArrearScreen"))
    {
      sDetailTable = "lstBasicArrDtl";
    }
    initializeBO("GenerateBasicArrearScreen",sDetailTable);
  }  


public LovVO getBasicArrLOVDataPayYYMM(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay YYMM");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));      
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBasicArrPayYYMMLov(?,?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_yymm").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


public LovVO getBasicArrLOVDataEmpNo(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("EmpNo");  
    arylstHeaderNames.add("EmpName");  
    arylstHeaderNames.add("CPF Code"); 
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);  
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    oLovVO.setVisibilityList(arylstVisibility);
    

    String EmpNo,Name;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField3();
    String cpfCode=oLovQueryVO.getSearchField2();

    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, Name));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, cpfCode));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetBasicArrEmpNoLov(?,?,?,?,?,?,?)");
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

  public String GenBasicArr(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
     
     
      
   oList = new ArrayList();
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    BasicArrearHeaderBean oBasicArrearHeaderBean = (BasicArrearHeaderBean)oBaseHeaderBean; 
    ArrayList oOutArray; //Output 

/*    String sPayrollYYMM=oBasicArrearHeaderBean.getTxtpayYYMM();
    String sPayrollFlag=oBasicArrearHeaderBean.getHdnPayrollFlag();
    String SCurentYYMM=oBasicArrearHeaderBean.getHdnCurYYMM();
    String sStatus=oBasicArrearHeaderBean.getHdnPayStatus();

    int k =   Integer.parseInt(sPayrollYYMM);
    int l =  Integer.parseInt(SCurentYYMM);
    
    if(sPayrollFlag.equals("Y"))
    {
//        oList.add(new EnrgiseApplicationException("Payroll.BasicArr.PayrollFlagChk",EnrgiseConstants.MESSAGE));                                
        throw new EnrgiseApplicationException("Payroll.BasicArr.PayrollFlagChk",EnrgiseConstants.MESSAGE);        
    }

    else if (k  < l)
     {
//        oList.add(new EnrgiseApplicationException("Payroll.BasicArr.PayYYMMLessCurYYMMChk",EnrgiseConstants.MESSAGE));                                
        throw new EnrgiseApplicationException("Payroll.BasicArr.PayYYMMLessCurYYMMChk",EnrgiseConstants.MESSAGE);                
     }

     else if(sPayrollYYMM.equals(SCurentYYMM) && sStatus.equals("2"))
     {
        ArrayList oArguments = new ArrayList();          
        oArguments.add(sPayrollYYMM);
        throw  new EnrgiseApplicationException("Payroll.BasicArr.PayCurYYMMStatusChk",oArguments);             
        //oList.add(new EnrgiseApplicationException("Payroll.BasicArr.PayCurYYMMStatusChk",EnrgiseConstants.MESSAGE));                                
     }

     else
     { */
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oBasicArrearHeaderBean.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_basic_arrear_generate_fci.proc_GenBasicArrear(?,?,?,?,?,?)",true,true);      
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    String oErrorMsg = (String)oOutObject.getObject();
    Integer errCode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
    
    if(errCode.equals(new Integer(0)))
    {
        oBasicArrearHeaderBean.setHdnPayrollFlag("Y");
    }
    else if(!(errCode.equals(new Integer(1))))
    {
        updateSessionStatus("BASICSAL",lSiteID, oBasicArrearHeaderBean.getHdnEmpLbrFlag());
    }
    return oErrorMsg;      
  }

    public void updateSessionStatus(String module,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList   oParameters = new ArrayList();
        oParameters.add(new InputDBObject(1,ParameterTypes.VARCHAR, new String(module+lSiteID+hdnEmpLbrFlag)));
        int iRetType = oBean.executeUpsert(oParameters,PayrollSQLQueries.Update_Session_State);
    }

public String UndoBasicArr(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseApplicationException, EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
         
    oList = new ArrayList();
    Timestamp oWhenPicked = null;
    int count = 0;   
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    BasicArrearHeaderBean oBasicArrearHeaderBean = (BasicArrearHeaderBean)oBaseHeaderBean; 
    ArrayList oOutArray; //Output 

/*    String sPayrollYYMM=oBasicArrearHeaderBean.getTxtpayYYMM();
    String sPayrollFlag=oBasicArrearHeaderBean.getHdnPayrollFlag();
    String SCurentYYMM=oBasicArrearHeaderBean.getHdnCurYYMM();
    String sStatus=oBasicArrearHeaderBean.getHdnPayStatus();

    int k =   Integer.parseInt(sPayrollYYMM);
    int l =  Integer.parseInt(SCurentYYMM);
    String error_code = "";
    
   if(sPayrollFlag.equals("N"))
    {
//       throw new EnrgiseApplicationException("Payroll.BasicArr.UndoPayrollFlagChk",EnrgiseConstants.MESSAGE);        
        error_code = "Payroll.BasicArr.UndoPayrollFlagChk";
    }

     else if (k  < l)
     {
//        throw new EnrgiseApplicationException("Payroll.UndoBasicArr.PayYYMMLessCurYYMMChk",EnrgiseConstants.MESSAGE);                
          error_code = "Payroll.UndoBasicArr.PayYYMMLessCurYYMMChk";
     }

     else if(sPayrollYYMM.equals(SCurentYYMM) && sStatus.equals("2"))
     {
           error_code = "Payroll.UndoBasicArr.PayCurYYMMStatusChk";     
//        ArrayList oArguments = new ArrayList();          
//        oArguments.add(sPayrollYYMM);
//        throw  new EnrgiseApplicationException("Payroll.UndoBasicArr.PayCurYYMMStatusChk",oArguments);             

     }

     else
     { */
     
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
//      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("200")));
//      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("200")));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oBasicArrearHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lUserID))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lSiteID))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"Pkg_UndoBasicArrear.Ysp_UndoBasicArrear(?,?,?,?,?,?)");      

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_msg = (String)oOutObject.getObject();
      oOutObject = (DBObject)oOutArray.get(1);      
      Integer error_code = (Integer)oOutObject.getObject(); 
     
      if(error_code.equals(new Integer(0)))
        oBasicArrearHeaderBean.setHdnPayrollFlag("N");
      else
      {
        ArrayList oArguments=new ArrayList();
        oArguments.add(error_msg);
        throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
      }
      
      return error_msg; 
  }


 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean);
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
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
    
//    checkFirst(oBaseHeaderBean,oList);
     checkMaxPayYear(oBaseHeaderBean,oList);
     checkBasicArrHeader(oBaseHeaderBean,oList);
//     checkBasicArrGreaterPayYearMonth(oBaseHeaderBean,oList);

     reportError(oList);
    
    
  }

 private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    
//    checkFirst(oBaseHeaderBean,oList);
//     checkEmpNo(oBaseHeaderBean,oDetailBeanArray,oList);
     check_Upto_PayYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
   //  check_FromDate_PayYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
     reportError(oList);
    
    
  }

/* private void checkBasicArrHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        BasicArrearHeaderBean  oBasicArrearHeaderBean  = (BasicArrearHeaderBean)oBaseHeaderBean;

        System.out.println(oBasicArrearHeaderBean.getScreenModePay1());       
        if(oBasicArrearHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BasicArrDuplicateCheck(?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("Payroll.BasicArr.DuplicateCheck",oArguments));
              oBasicArrearHeaderBean.setScreenModePay1("N");
            }
        }
  }
*/



private void checkBasicArrHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        BasicArrearHeaderBean  oBasicArrearHeaderBean  = (BasicArrearHeaderBean)oBaseHeaderBean;

//        System.out.println(oBasicArrearHeaderBean.getScreenModePay1());       
        if(oBasicArrearHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oBasicArrearHeaderBean.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oBasicArrearHeaderBean.getTxtSiteID()));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BasicArrDuplicateCheck(?,?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("pay_yymm").getString(); 
              if (!sRevYear.equals("0"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(sRevYear);              
                oList.add(new EnrgiseApplicationException("Payroll.BasicArr.DuplicateCheck",oArguments));              
              }                
             }
           

            
        }
  }


 private void checkEmpNo(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        GenerateBasicArrearBean oGenerateBasicArrearBean = (GenerateBasicArrearBean)oIt.next();
//        System.out.println(oGenerateBasicArrearBean.getStatus());
        BasicArrearHeaderBean  oBasicArrearHeaderBean  = (BasicArrearHeaderBean)oBaseHeaderBean;
        if(!(oGenerateBasicArrearBean.getStatus().equals("D")))
          count++;


        if(oGenerateBasicArrearBean.getStatus().equals("N"))    
        {
          String pcode = oGenerateBasicArrearBean.getTxtEmployeeNo();
          String payYYMM = oBasicArrearHeaderBean.getTxtpayYYMM();
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtEmployeeNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BasicArrEmpNoCheck(?,?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));

          //  oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
 
           oList.add(new EnrgiseApplicationException("Payroll.BasicArrEmpNo.duplicatecheck",oArguments));
            }
        }
      }
  }




 private void checkBasicArrGreaterPayYearMonth(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        BasicArrearHeaderBean  oBasicArrearHeaderBean  = (BasicArrearHeaderBean)oBaseHeaderBean;

//        System.out.println(oBasicArrearHeaderBean.getScreenModePay1());       
        if(oBasicArrearHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BasicArrGreaterYearCheck(?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("pay_yymm").getString(); 
              if (!sRevYear.equals("0"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(sRevYear);              
                oList.add(new EnrgiseApplicationException("Payroll.BasicArr.PayYearCheck",oArguments));              
              }                
             }
           

            
        }
  }



 private void check_Upto_PayYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();
      long counter = 0;

      while(oIt.hasNext())
      {
        counter = counter + 1;
        GenerateBasicArrearBean oGenerateBasicArrearBean = (GenerateBasicArrearBean)oIt.next();
        System.out.println(oGenerateBasicArrearBean.getStatus());
        BasicArrearHeaderBean  oBasicArrearHeaderBean  = (BasicArrearHeaderBean)oBaseHeaderBean;
        if(!(oGenerateBasicArrearBean.getStatus().equals("D")))
          count++;


       if((oGenerateBasicArrearBean.getStatus().equals("N")) ||   (oGenerateBasicArrearBean.getStatus().equals("U")))
       {
          String uptoMonth = oGenerateBasicArrearBean.getTxtUptoMonth();
          String payYYMM = oBasicArrearHeaderBean.getTxtpayYYMM();
          if (Integer.parseInt(uptoMonth) >= Integer.parseInt(payYYMM))
          {   
              ArrayList oArguments = new ArrayList();          
              oArguments.add(uptoMonth);
              oArguments.add(Long.toString(counter));
              oList.add(new EnrgiseApplicationException("Payroll.BasicArr.UptoYYMM_payYYMMcheck",oArguments));             
          }

/*          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtUptoMonth())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BasicArrUptoYYMMCheck(?,?,?,?)");    
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));

          //  oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
 
           oList.add(new EnrgiseApplicationException("Payroll.BasicArr.UptoYYMM_payYYMMcheck",oArguments));
           
            }  */

            
       }
      }
  }



  public PayYearStatusVO getMaxPayYear() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    PayYearStatusVO oPayYearStatusVO = new PayYearStatusVO();
    int count = 0;
    ArrayList oOutArray; //Output 
//    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleCode = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(0)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("E")));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");

            ArrayList oRetList = null;
            
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
      


            String sCurYYMM = "";
            String status = "";
  
            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              sCurYYMM = oRow.get("yymm").getString(); 
              status = oRow.get("status").getString(); 
            }    
      
            
/*        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
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
            oPayScaleCode = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String PayscaleLabel = oRow.get("pay_scale_code").getString();
          String PayscaleValue = oRow.get("pay_scale_desc").getString();
          oComboVO = new ComboVO(PayscaleLabel,PayscaleValue);
          oPayScaleCode.add(oComboVO);
        }  */


    oPayYearStatusVO.setHdnPayStatus(status);
    oPayYearStatusVO.setHdnCurYYMM(sCurYYMM);
    return oPayYearStatusVO;
       
  }
  



private void checkMaxPayYear(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        BasicArrearHeaderBean  oBasicArrearHeaderBean  = (BasicArrearHeaderBean)oBaseHeaderBean;

//        System.out.println(oBasicArrearHeaderBean.getScreenModePay1());       
        if(oBasicArrearHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
       
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oBasicArrearHeaderBean.getHdnEmpLbrFlag()));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yymm").getString(); 
              String status = oRow.get("status").getString(); 

              if (!sRevYear.equals(oBasicArrearHeaderBean.getTxtpayYYMM()))
              {
                  oBasicArrearHeaderBean.setScreenModePay1("N");
                  ArrayList oArguments = new ArrayList();
                  oArguments.add(sRevYear);
                  oList.add(new EnrgiseApplicationException("Payroll.BasicArr.maxPayYearcheck",oArguments));                
              }

              else 
              {
                if (Integer.parseInt(status) >= 2 )
                {
                    oBasicArrearHeaderBean.setScreenModePay1("N");
                    oList.add(new EnrgiseApplicationException("Payroll.BasicArr.statusCheck",EnrgiseConstants.MESSAGE));                                
                }
              }

            }           
/*            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.BasicArr.maxPayYearcheck",EnrgiseConstants.MESSAGE));
            }  */
        }
  }






/* private void check_FromDate_PayYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        GenerateBasicArrearBean oGenerateBasicArrearBean = (GenerateBasicArrearBean)oIt.next();
        System.out.println(oGenerateBasicArrearBean.getStatus());
        BasicArrearHeaderBean  oBasicArrearHeaderBean  = (BasicArrearHeaderBean)oBaseHeaderBean;
        if(!(oGenerateBasicArrearBean.getStatus().equals("D")))
          count++;


        if(oGenerateBasicArrearBean.getStatus().equals("N"))    
        {
          String Fromdate = oGenerateBasicArrearBean.getTxtFromDate();
          String payYYMM = oBasicArrearHeaderBean.getTxtpayYYMM();
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenerateBasicArrearBean.getTxtFromDate())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oBasicArrearHeaderBean.getTxtpayYYMM())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_BasicArrFrmDtYYMMCheck(?,?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));

          //  oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
 
           oList.add(new EnrgiseApplicationException("Payroll.BasicArr.FromDate_payYYMMcheck",oArguments));
            }
        }
      }
  }

*/

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

    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = oRow.get("status").getString(); 
    }    
    return sRevYear;
  }
  
  public String chckPayrollRunning(Integer siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
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

    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.INTEGER,siteId));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_pylrCheck(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = oRow.get("status").getString(); 
    }    
    return status;
  }
  /* added by jatin */
     
}