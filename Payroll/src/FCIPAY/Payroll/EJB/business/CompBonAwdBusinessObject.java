package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintAnnIncQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CompBonAwdQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.ComBonusAwardsHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintAnnIncHeaderBean;
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

public class CompBonAwdBusinessObject extends BaseBO  
{
  public CompBonAwdBusinessObject()
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
    ComBonusAwardsHeaderBean oComBonusAwardsHeaderBean = (ComBonusAwardsHeaderBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getOptSelect())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtYYMM())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtMaxEmolAmt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtBonDays())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtMaxAwdAmt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtAwdDays())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtSrlNo())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_UpdateBonAwd(?,?,?,?,?,?,?,?,?,?,?)");
    
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    ComBonusAwardsHeaderBean oComBonusAwardsHeaderBean = (ComBonusAwardsHeaderBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output 



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getOptSelect())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtYYMM())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtMaxEmolAmt())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtBonDays())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtMaxAwdAmt())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtAwdDays())));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtUserID())));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtSiteID())));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_InsertBonAwd(?,?,?,?,?,?,?,?,?,?)");

      DBObject oOutObject = (DBObject)oOutArray.get(0);
      return (String)oOutObject.getObject();
      
  }


  public RecordMetaInfo getBonAwdHeaderMetaInfo(CompBonAwdQueryVO oCompBonAwdQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();

      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oCompBonAwdQueryVO.getOptSelect())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oCompBonAwdQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getBonusRewardsCount(?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }


  public String CompBonAwd(ComBonusAwardsHeaderBean oComBonusAwardsHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    String errocCode;
      if(oComBonusAwardsHeaderBean.getOptSelect().equals("B"))
      {
        errocCode = ComputeBonus(oComBonusAwardsHeaderBean, loginUserId, lLoginSiteId);
        return errocCode;
      }
      else
      {
        errocCode = ComputeAwards(oComBonusAwardsHeaderBean,loginUserId, lLoginSiteId);
        return errocCode;
      }
  }


  public String ComputeBonus(ComBonusAwardsHeaderBean oComBonusAwardsHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {

    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;   

    ArrayList oOutArray; //Output 


      oParameters = new ArrayList();
     // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtPayYYMM())));
     // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtDAType())));
     // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtStYYMM())));
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtMaxEmolAmt())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtBonDays())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,String.valueOf(loginUserId)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,String.valueOf(lLoginSiteId)));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_YearlyBonusAwards.Ysp_Bonus(?,?,?,?,?,?)");


      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_code = (String)oOutObject.getObject();

      
      return error_code;
//      return null;
  }

  public String ComputeAwards(ComBonusAwardsHeaderBean oComBonusAwardsHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException
  {

    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;   

    ArrayList oOutArray; //Output 


      oParameters = new ArrayList();
     // oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtPayYYMM())));
     // oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtDAType())));
     // oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtStYYMM())));
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtAwdDays())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oComBonusAwardsHeaderBean.getTxtMaxAwdAmt())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(loginUserId))));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(String.valueOf(lLoginSiteId))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));

      oOutArray = oBean.callProc(oParameters,"PKG_YearlyBonusAwards.Ysp_YearlyAward(?,?,?,?,?,?)");


      DBObject oOutObject = (DBObject)oOutArray.get(0);
      String error_code = (String)oOutObject.getObject();

      
      return error_code;
//      return null;
  }




  public ArrayList getBonAwdHeader(CompBonAwdQueryVO oCompBonAwdQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
   ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oCompBonAwdQueryVO == null)
    {
      oCompBonAwdQueryVO = new CompBonAwdQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oCompBonAwdQueryVO.getOptSelect())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oCompBonAwdQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getBonusRewardsDetail(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      ComBonusAwardsHeaderBean oComBonusAwardsHeaderBean;
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
          oComBonusAwardsHeaderBean = new ComBonusAwardsHeaderBean();
          oComBonusAwardsHeaderBean.setOptSelect(oRow.get("BONUS_AWARDS_FLAG").getString());
         // oComBonusAwardsHeaderBean.setOptVal(oRow.get("OPT_TYPE").getString());
          oComBonusAwardsHeaderBean.setTxtAwdDays(oRow.get("NO_OF_YEAR_DAYS").getString());
          oComBonusAwardsHeaderBean.setTxtBonDays(oRow.get("NO_OF_BONUS_DAYS").getString());
          oComBonusAwardsHeaderBean.setTxtBonAwdFlag(oRow.get("BONUS_AWARDS_FLAG").getString());
         // oComBonusAwardsHeaderBean.setTxtEmpName(oRow.get("EMPNAME").getString());
          oComBonusAwardsHeaderBean.setTxtMaxEmolAmt(oRow.get("MTHLY_EMOL_LIMIT").getString());
          oComBonusAwardsHeaderBean.setTxtYYMM(oRow.get("YYMM").getString());
          oComBonusAwardsHeaderBean.setTxtSrlNo(oRow.get("srl_no").getString());
          oComBonusAwardsHeaderBean.setTxtMaxAwdAmt(oRow.get("MAX_AWARD_AMT").getString());


          oHeaderList.add(oComBonusAwardsHeaderBean);
      }
      
        
    return oHeaderList; 
    //return null;
  }


  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("DaRatesScreen"))
    {
     // saveDARates(sHeaderPrimaryKey,oDetailBeanArray);
    }
    
  }

  public LovVO getEmpBonAwdLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("YearMonth");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_QueryBonAwdLOV(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("YearMonth").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
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
  
  
}