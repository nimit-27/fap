package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenDAArrearQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;

import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.PayrollSQLQueries;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class DAArrearBusinessObject extends BaseBO 
{
  public DAArrearBusinessObject()
  {
  }
public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("DaRatesScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }

  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    GenDAArrearHeaderBean oGenDAArrearHeaderBean = (GenDAArrearHeaderBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output
        String dahratype;
        dahratype = oGenDAArrearHeaderBean.getTxtDAType();
        oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtPayYYMM())));
     // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtDAType())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtStYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtEndYYMM())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtUserID())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtSiteID())));      
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      

      if(dahratype.equalsIgnoreCase("IDA")||dahratype.equalsIgnoreCase("CDA"))
      {
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.PROC_UPDATEDAARREAR(?,?,?,?,?,?,?,?)");
      }else if(dahratype.equalsIgnoreCase("HRAIDA")||dahratype.equalsIgnoreCase("HRACDA"))
      {
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.PROC_UPDATEHRAARREAR(?,?,?,?,?,?,?,?)");
      }
    
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    GenDAArrearHeaderBean oGenDAArrearHeaderBean = (GenDAArrearHeaderBean)oBaseHeaderBean;

      ArrayList oOutArray=null; //Output 

      oParameters = new ArrayList();
        String dahratype;
        dahratype = new String(oGenDAArrearHeaderBean.getTxtDAType());
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtPayYYMM())));
  //    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtDAType())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtStYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtEndYYMM())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtUserID())));      
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtSiteID())));      
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
            if(dahratype.equalsIgnoreCase("IDA")||dahratype.equalsIgnoreCase("CDA"))
                {
                    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.PROC_INSERTDAARREARLOG(?,?,?,?,?,?,?,?,?)");
                }else if(dahratype.equalsIgnoreCase("HRAIDA")||dahratype.equalsIgnoreCase("HRACDA"))
                {                   
                    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.PROC_INSERTHRAARREARLOG(?,?,?,?,?,?,?,?,?)");
                }
            
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();      
      
  }


  public RecordMetaInfo getDAArrearHeaderMetaInfo(GenDAArrearQueryVO oGenDAArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray=null; //Output 
    String dahratype;
    dahratype = oGenDAArrearQueryVO.getTxtDAType();
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtPayYYMM())));
     // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtDAType())));
     oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oGenDAArrearQueryVO.getLoginLocCode())));// added by sonia on 16-03-2011
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      
   
               oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDAArrearCount(?,?,?,?,?,?,?)");
       
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getDAArrearHeader(GenDAArrearQueryVO oGenDAArrearQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oGenDAArrearQueryVO == null)
    {
      oGenDAArrearQueryVO = new GenDAArrearQueryVO();
    }
    
      ArrayList oOutArray=null; //Output 
    ArrayList oHeaderList = null;
      String dahratype;
    
      dahratype = oGenDAArrearQueryVO.getTxtPayYYMM().toString();
      if(dahratype.length()>6){
          if(dahratype.length()==10)
              dahratype=dahratype.substring(7,10); 
          else
              dahratype=dahratype.substring(7,9);
          }
      else if(dahratype.length()<=6)
      {dahratype=oGenDAArrearQueryVO.getTxtDAType();
          }
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtPayYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtDAType())));
     // oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(oGenDAArrearQueryVO.getLoginLocCode()))); // added by sonia on 16-03-2011
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      
   
               oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DAArrearHeader(?,?,?,?,?,?,?,?)");
   
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      GenDAArrearHeaderBean oGenDAArrearHeaderBean;
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
          oGenDAArrearHeaderBean = new GenDAArrearHeaderBean();
          oGenDAArrearHeaderBean.setTxtPayYYMM(oRow.get("pay_yymm").getString());
          
                           if(dahratype.equalsIgnoreCase("HRA")||dahratype.equalsIgnoreCase("HRAIDA")||dahratype.equalsIgnoreCase("HRACDA"))
                                oGenDAArrearHeaderBean.setTxtDAType(oRow.get("hra_type").getString()); 
                            
                            else{
                                    oGenDAArrearHeaderBean.setTxtDAType(oRow.get("da_type").getString());                                                 
                                } 
     
          oGenDAArrearHeaderBean.setTxtStYYMM(oRow.get("from_yymm").getString());
          oGenDAArrearHeaderBean.setTxtEndYYMM(oRow.get("to_yymm").getString());
          oGenDAArrearHeaderBean.setPayrollFlag(oRow.get("payroll_flag").getString());
          oHeaderList.add(oGenDAArrearHeaderBean);
      }
      
        
    return oHeaderList;
  }


  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    /*if(sScreenName.equals("GenDAArrScreen"))
    {
      saveDAArrear(sHeaderPrimaryKey,oDetailBeanArray);
    }*/
    
  }


public String genDAArrear(GenDAArrearHeaderBean oGenDAArrearHeaderBean,long loginUserId ,long lLoginSiteId) throws EnrgiseApplicationException, EnrgiseSystemException
{                 
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;   
    String lUser = String.valueOf(loginUserId);
    String lSite = String.valueOf(lLoginSiteId);
    ArrayList oOutArray=null; //Output 
    String dahratype;
    dahratype = oGenDAArrearHeaderBean.getTxtDAType();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtPayYYMM())));
  //  oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtDAType())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtStYYMM())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtEndYYMM())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,lUser));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,lSite));
    oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
    if(oGenDAArrearHeaderBean.getHdnEmpLbrFlag().equals("D"))
    {
        oOutArray = oBean.callProc(oParameters,"Pkg_GenerateDAArrear_fci.proc_DpsMGWbasicarrear(?,?,?,?,?,?,?,?,?)",true,true);
    }
    else  if(dahratype.equalsIgnoreCase("IDA")||dahratype.equalsIgnoreCase("CDA"))
                {
                    oOutArray = oBean.callProc(oParameters,"Pkg_GenerateDAArrear_fci.proc_GenDAArrear(?,?,?,?,?,?,?,?,?)",true,true);  
                }else if(dahratype.equalsIgnoreCase("HRAIDA")||dahratype.equalsIgnoreCase("HRACDA"))
                {                   
                    oOutArray = oBean.callProc(oParameters,"Pkg_GenerateDAArrear_fci.proc_GenHRAArrear(?,?,?,?,?,?,?,?,?)",true,true); 
                }
    
       
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    String error_code = (String)oOutObject.getObject();
    if(!(error_code.equals(new Integer(1))))
    {
        updateSessionStatus("DASAL",lLoginSiteId, oGenDAArrearHeaderBean.getHdnEmpLbrFlag());
    }
    return error_code;
}

public void updateSessionStatus(String module,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
{
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList   oParameters = new ArrayList();
    oParameters.add(new InputDBObject(1,ParameterTypes.VARCHAR, new String(module+lSiteID+hdnEmpLbrFlag)));
    int iRetType = oBean.executeUpsert(oParameters,PayrollSQLQueries.Update_Session_State);
}

public String undoDAArrear(GenDAArrearHeaderBean oGenDAArrearHeaderBean,long loginUserId ,long lLoginSiteId) throws EnrgiseApplicationException, EnrgiseSystemException
{
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;   

    String lUser = String.valueOf(loginUserId);
    String lSite = String.valueOf(lLoginSiteId);

    ArrayList oOutArray=null; //Output 

    String dahratype;
    dahratype = oGenDAArrearHeaderBean.getTxtDAType();
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtPayYYMM())));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtDAType())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,lUser));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,lSite));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    if(dahratype.equalsIgnoreCase("IDA")||dahratype.equalsIgnoreCase("CDA"))
                 {
                     oOutArray = oBean.callProc(oParameters,"Pkg_GenerateDAArrear_fci.proc_UndoDAArrear(?,?,?,?,?,?,?)");

                 }else if(dahratype.equalsIgnoreCase("HRAIDA")||dahratype.equalsIgnoreCase("HRACDA"))
                 {                   
                     oOutArray = oBean.callProc(oParameters,"Pkg_GenerateDAArrear_fci.proc_UndoHRAArrear(?,?,?,?,?,?,?)");

                 }
    

      DBObject oErrorCode = (DBObject)oOutArray.get(0);
      String error_code = (String)oErrorCode.getObject();

  return error_code;
}

public LovVO getDAArrearLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Payroll Year");    
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
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      
      
      oOutArray = oBean.callProc(oParameters,"Pkg_GenerateDAArrear_fci.proc_GetDAArrearYear(?,?,?,?)");
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



public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GenDAArrearHeaderBean oGenDAArrearHeaderBean=(GenDAArrearHeaderBean)oBaseHeaderBean;
    ArrayList oList=new ArrayList();
    chkPayYYMM(oBaseHeaderBean,oList,sScreenMode);
    reportError(oList);
    oList=new ArrayList();   
    if(oGenDAArrearHeaderBean.getHdnEmpLbrFlag().equals("D"))
       {
        chkOverlapyear(oBaseHeaderBean,oList,sScreenMode); // Added by dushyant on 04-Dec-2012
       }
    reportError(oList);  
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  private void chkPayYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oList,String screenMode) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray=null; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      String chkFlag="";
      GenDAArrearHeaderBean oGenDAArrearHeaderBean = (GenDAArrearHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      String dahratype;
          dahratype = oGenDAArrearHeaderBean.getTxtDAType();
                
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtPayYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getTxtSiteID()));
    //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getTxtDAType()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      if(dahratype.equalsIgnoreCase("IDA")||dahratype.equalsIgnoreCase("CDA"))
                    {
                        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_chkDAArrearYYMM(?,?,?,?,?,?)");        
                    }else if(dahratype.equalsIgnoreCase("HRAIDA")||dahratype.equalsIgnoreCase("HRACDA"))
                    {                   
                        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_chkHRAArrearYYMM(?,?,?,?,?,?)");   
                    }
     
      chkFlag = ((String)((DBObject)oOutArray.get(0)).getObject()).trim();
      System.out.println("chkFlag is:::"+chkFlag+"Afetr Getting Data");
      if(chkFlag.equals("Y"))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("Payroll.DAARREAR.Generated",oArguments));
      }else if(screenMode.equals("N")&& chkFlag.equals("N"))
      {
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("Payroll.DAARREAR.duplicateCheck",oArguments));
      }
  }
  
// Added by dushyant on 04-Dec-2013 for overlapping year
 private void chkOverlapyear(BaseHeaderBean oBaseHeaderBean,ArrayList oList,String screenMode) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray=null; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
     
      GenDAArrearHeaderBean oGenDAArrearHeaderBean = (GenDAArrearHeaderBean)oBaseHeaderBean;
      String dahratype;
          dahratype = oGenDAArrearHeaderBean.getTxtDAType();
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtStYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearHeaderBean.getTxtEndYYMM())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getTxtSiteID()));
    //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getTxtDAType()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,dahratype));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
     
      
      if(dahratype.equalsIgnoreCase("IDA")||dahratype.equalsIgnoreCase("CDA"))
                   {
                       oOutArray = oBean.callProc(oParameters,"pkg_generatedaarrear_fci.proc_chkArrearOverlapyymm(?,?,?,?,?,?,?)",true,true);
                   }else if(dahratype.equalsIgnoreCase("HRAIDA")||dahratype.equalsIgnoreCase("HRACDA"))
                   {                   
                       oOutArray = oBean.callProc(oParameters,"pkg_generatedaarrear_fci.proc_chkhraArrOverlapyymm(?,?,?,?,?,?,?)",true,true);
                   }
      
      Integer Errorcode = (Integer)(((DBObject)oOutArray.get(1)).getObject());
      String oErrormsg = (String)((DBObject)oOutArray.get(0)).getObject();  
      System.out.println("error_code is:::"+Errorcode+"Afetr Getting Data");
      if(Errorcode.equals(new Integer(1)))
      {  
         ArrayList oArguments = new ArrayList();    
         oArguments.add(new String(oErrormsg));
         oList.add(new EnrgiseApplicationException("Payroll.DAARREAR.Overlapyear",oArguments));
      }
  }
// End By Dushyant

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

}