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
import FCIPAY.Payroll.UTILITY.OverNAboveArrearHeaderBean;
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

public class OverNAboveBusinessObject extends BaseBO 
{
  public OverNAboveBusinessObject()
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
  
  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
   
      return null     ;      
      
  }

public String genOverNAboveArrear(OverNAboveArrearHeaderBean oOverNAboveArrearHeaderBean,long loginUserId ,long lLoginSiteId,String payYYMM) throws EnrgiseApplicationException, EnrgiseSystemException
{     
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;       
    String lUser = String.valueOf(loginUserId);
    String lSite = String.valueOf(lLoginSiteId);    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(payYYMM)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getTxtDAType())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getTxtStYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getTxtEndYYMM())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oOverNAboveArrearHeaderBean.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,lUser));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,lSite));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GenLeaveEncashArrear(?,?,?,?,?,?,?,?,?)",true,true);
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_code = (String)oOutObject.getObject();

      
      return error_code;
}






public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList=new ArrayList();
    
    reportError(oList);
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    /*if(sScreenName.equals("GenDAArrScreen"))
    {
      saveDAArrear(sHeaderPrimaryKey,oDetailBeanArray);
    }*/
    
  }
 public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    
    
  }
  
  public RecordMetaInfo getOverNAboveArrearHeaderMetaInfo(GenDAArrearQueryVO oGenDAArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtPayYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtDAType())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.BIGINT,new Long(oGenDAArrearQueryVO.getLoginLocCode())));// added by sonia on 16-03-2011
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_getovrnabvarrearcount(?,?,?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getOverNAboveArrearHeader(GenDAArrearQueryVO oGenDAArrearQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oGenDAArrearQueryVO == null)
    {
      oGenDAArrearQueryVO = new GenDAArrearQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtPayYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oGenDAArrearQueryVO.getTxtDAType())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oGenDAArrearQueryVO.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.BIGINT,new Long(oGenDAArrearQueryVO.getLoginLocCode()))); // added by sonia on 16-03-2011
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_OVER_N_ABOVE_SAL.proc_ovrnabvarrearheader(?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
     

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      OverNAboveArrearHeaderBean oOverNAboveArrearHeaderBean;
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
          oOverNAboveArrearHeaderBean = new OverNAboveArrearHeaderBean();
          //oGenDAArrearHeaderBean.setHeaderPrimaryKey(oRow.get("pay_yymm").getString());
          oOverNAboveArrearHeaderBean.setTxtPayYYMM(oRow.get("pay_yymm").getString());

          oOverNAboveArrearHeaderBean.setTxtDAType(oRow.get("da_type").getString());
          oOverNAboveArrearHeaderBean.setTxtStYYMM(oRow.get("start_yr").getString());
          oOverNAboveArrearHeaderBean.setTxtEndYYMM(oRow.get("end_yr").getString());
         
          oHeaderList.add(oOverNAboveArrearHeaderBean);
      }
      
        
    return oHeaderList;
  }

  
  
  public String undoOvrAbvArrear(OverNAboveArrearHeaderBean oOverNAboveArrearHeaderBean,long loginUserId ,long lLoginSiteId) throws EnrgiseApplicationException, EnrgiseSystemException
{
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;   

    String lUser = String.valueOf(loginUserId);
    String lSite = String.valueOf(lLoginSiteId);

    ArrayList oOutArray; //Output 


      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getTxtPayYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getTxtDAType())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getTxtStYYMM())));
     oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getTxtEndYYMM())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oOverNAboveArrearHeaderBean.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,lUser));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,lSite));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_undoleaveencasharrear(?,?,?,?,?,?,?,?,?)",true,true);


      DBObject oErrorCode = (DBObject)oOutArray.get(0);
      String error_code = (String)oErrorCode.getObject();

  return error_code;
}
  
   
 
}