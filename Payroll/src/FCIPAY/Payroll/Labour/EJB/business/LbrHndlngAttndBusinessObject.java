package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.lang.String;
import java.util.Calendar;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class LbrHndlngAttndBusinessObject extends BaseBO
{
  public LbrHndlngAttndBusinessObject()
  {
  }
 public RecordMetaInfo getHndlngAttndHeaderMetaInfo(LbrHndlngAttndQueryVO oLbrHndlngAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    //BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getLstLabourType())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getTxtGangId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getTxtLocId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHndlngAttndCount(?,?,?,?,?,?,?)");      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
	oTimeObject  = null;       
	oTotalRecord = null;
	oOutArray    = null;
	oParameters  = null;
      return oRecordMetaInfo;
    
  }
  public ArrayList getHndlngAttndHeader(LbrHndlngAttndQueryVO oLbrHndlngAttndQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oLbrHndlngAttndQueryVO == null)
    {
      oLbrHndlngAttndQueryVO = new LbrHndlngAttndQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getLstLabourType())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getTxtGangId())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getTxtLocId())));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHndlngAttndHeader(?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean;
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
          oLbrHndlngAttndHeaderBean = new LbrHndlngAttndHeaderBean();          
          oLbrHndlngAttndHeaderBean.setLstLabourType(oRow.get("lbr_typ").getString());
          oLbrHndlngAttndHeaderBean.setTxtGangId(oRow.get("gang_id").getString());
          oLbrHndlngAttndHeaderBean.setTxtGangName(oRow.get("gang_name").getString());
          oLbrHndlngAttndHeaderBean.setTxtLocId(oLbrHndlngAttndQueryVO.getTxtLocId().toString());
          oLbrHndlngAttndHeaderBean.setTxtLocation(oRow.get("loc_desc").getString());
          oLbrHndlngAttndHeaderBean.setTxtYYMM(oRow.get("yyyymm").getString());
          oHeaderList.add(oLbrHndlngAttndHeaderBean);
          oRow = null;
          oLbrHndlngAttndHeaderBean = null;
      }              
    oList = null;
    oIt = null;
    oLbrHndlngAttndQueryVO = null;
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
   return oHeaderList;
  }
 public RecordMetaInfo getHndlngAttndDetailMetaInfo(String sPrimaryKey,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  //public RecordMetaInfo getDARatesDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      System.out.println(oLbrHndlngAttndDetailInfo.getScreenModeFlag());
      
      if(oLbrHndlngAttndDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getLabourDetailMetaInfo(oLbrHndlngAttndDetailInfo);
      }
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtGangId()));  
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getLstLabourType()));  
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtLocId()));            
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtYYMM()));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHndlngAttndDtlCount(?,?,?,?,?,?,?)");    
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oLbrHndlngAttndDetailInfo = null;
    oTotalRecord = null;
    oTimeObject = null;
    return oRecordMetaInfo;          
  }

 public ArrayList getHndlngAttndDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LbrHndlngAttndBean oLbrHndlngAttndBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;
      
      //String sYear,sDAType;
      //sYear = oLbrHndlngAttndDetailInfo.getTxtYYMM();
      //sDAType = oLbrHndlngAttndDetailInfo.getTxtDAType();
      
      if(oLbrHndlngAttndDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getLabourDetail(sPrimaryKey,lDetailFirstPosition,lDetailLastPosition,oLbrHndlngAttndDetailInfo);
      }

      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getLstLabourType()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtGangId())); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtLocId()));  
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtYYMM()));      
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHndlngAttndDetail(?,?,?,?,?,?,?,?)");      
      
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
          oLbrHndlngAttndBean = new LbrHndlngAttndBean();          
          oLbrHndlngAttndBean.setTxtEmpNo((oRow.get("emp_num").getString()));
          oLbrHndlngAttndBean.setTxtEmpName((oRow.get("emp_name").getString()));          
          oLbrHndlngAttndBean.setTxtLabourCode((oRow.get("kot_lbr_id").getString()));          
          oLbrHndlngAttndBean.setTxtDays1((oRow.get("day1").getString()));
          oLbrHndlngAttndBean.setTxtDays2((oRow.get("day2").getString()));
          oLbrHndlngAttndBean.setTxtDays3((oRow.get("day3").getString()));
          oLbrHndlngAttndBean.setTxtDays4((oRow.get("day4").getString()));
          oLbrHndlngAttndBean.setTxtDays5((oRow.get("day5").getString()));
          oLbrHndlngAttndBean.setTxtDays6((oRow.get("day6").getString()));
          oLbrHndlngAttndBean.setTxtDays7((oRow.get("day7").getString()));
          oLbrHndlngAttndBean.setTxtDays8((oRow.get("day8").getString()));
          oLbrHndlngAttndBean.setTxtDays9((oRow.get("day9").getString()));
          oLbrHndlngAttndBean.setTxtDays10((oRow.get("day10").getString()));
          oLbrHndlngAttndBean.setTxtDays11((oRow.get("day11").getString()));
          oLbrHndlngAttndBean.setTxtDays12((oRow.get("day12").getString()));
          oLbrHndlngAttndBean.setTxtDays13((oRow.get("day13").getString()));
          oLbrHndlngAttndBean.setTxtDays14((oRow.get("day14").getString()));
          oLbrHndlngAttndBean.setTxtDays15((oRow.get("day15").getString()));
          oLbrHndlngAttndBean.setTxtDays16((oRow.get("day16").getString()));
          oLbrHndlngAttndBean.setTxtDays17((oRow.get("day17").getString()));
          oLbrHndlngAttndBean.setTxtDays18((oRow.get("day18").getString()));
          oLbrHndlngAttndBean.setTxtDays19((oRow.get("day19").getString()));
          oLbrHndlngAttndBean.setTxtDays20((oRow.get("day20").getString()));
          oLbrHndlngAttndBean.setTxtDays21((oRow.get("day21").getString()));
          oLbrHndlngAttndBean.setTxtDays22((oRow.get("day22").getString()));
          oLbrHndlngAttndBean.setTxtDays23((oRow.get("day23").getString()));
          oLbrHndlngAttndBean.setTxtDays24((oRow.get("day24").getString()));
          oLbrHndlngAttndBean.setTxtDays25((oRow.get("day25").getString()));
          oLbrHndlngAttndBean.setTxtDays26((oRow.get("day26").getString()));
          oLbrHndlngAttndBean.setTxtDays27((oRow.get("day27").getString()));
          oLbrHndlngAttndBean.setTxtDays28((oRow.get("day28").getString()));
          oLbrHndlngAttndBean.setTxtDays29((oRow.get("day29").getString()));
          oLbrHndlngAttndBean.setTxtDays30((oRow.get("day30").getString()));
          oLbrHndlngAttndBean.setTxtDays31((oRow.get("day31").getString()));
          oLbrHndlngAttndBean.setStatus("Q");
          oDARateDetail.add(oLbrHndlngAttndBean);
          oRow = null;
          oLbrHndlngAttndBean = null;
        }             
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oLbrHndlngAttndDetailInfo = null;
    return oDARateDetail; 
  }  
  
  private RecordMetaInfo getLabourDetailMetaInfo(LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  //public RecordMetaInfo getDARatesDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      //System.out.println(oLbrHndlngAttndDetailInfo.getScreenMode());
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtGangId())); 
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getLstLabourType()));            
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtLocId()));  
      //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));            
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHndlngLabourDtlCount(?,?,?,?,?,?)");      
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

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
  
  private ArrayList getLabourDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LbrHndlngAttndBean oLbrHndlngAttndBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;
      
      String sYearMnth,sDAType;
      sYearMnth = oLbrHndlngAttndDetailInfo.getTxtYYMM();
      //sDAType = oLbrHndlngAttndDetailInfo.getTxtDAType();
      
      String sYear=sYearMnth.substring(0,4);
	  String sMonth=sYearMnth.substring(4,6);			       
        sYearMnth = null;
        sDAType = null;
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtGangId()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getLstLabourType())); 
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndDetailInfo.getTxtLocId()));        
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHndlngLabourDetail(?,?,?,?,?,?,?)");      
      
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
          oLbrHndlngAttndBean = new LbrHndlngAttndBean();          
          oLbrHndlngAttndBean.setTxtEmpNo((oRow.get("emp_num").getString()));
          oLbrHndlngAttndBean.setTxtEmpName((oRow.get("emp_name").getString()));          
          oLbrHndlngAttndBean.setTxtLabourCode((oRow.get("kot_lbr_id").getString()));          
          oLbrHndlngAttndBean.setTxtDays1("W");
          oLbrHndlngAttndBean.setTxtDays2("W");
          oLbrHndlngAttndBean.setTxtDays3("W");
          oLbrHndlngAttndBean.setTxtDays4("W");
          oLbrHndlngAttndBean.setTxtDays5("W");
          oLbrHndlngAttndBean.setTxtDays6("W");
          oLbrHndlngAttndBean.setTxtDays7("W");
          oLbrHndlngAttndBean.setTxtDays8("W");
          oLbrHndlngAttndBean.setTxtDays9("W");
          oLbrHndlngAttndBean.setTxtDays10("W");
          oLbrHndlngAttndBean.setTxtDays11("W");
          oLbrHndlngAttndBean.setTxtDays12("W");
          oLbrHndlngAttndBean.setTxtDays13("W");
          oLbrHndlngAttndBean.setTxtDays14("W");
          oLbrHndlngAttndBean.setTxtDays15("W");
          oLbrHndlngAttndBean.setTxtDays16("W");
          oLbrHndlngAttndBean.setTxtDays17("W");
          oLbrHndlngAttndBean.setTxtDays18("W");
          oLbrHndlngAttndBean.setTxtDays19("W");
          oLbrHndlngAttndBean.setTxtDays20("W");
          oLbrHndlngAttndBean.setTxtDays21("W");
          oLbrHndlngAttndBean.setTxtDays22("W");
          oLbrHndlngAttndBean.setTxtDays23("W");
          oLbrHndlngAttndBean.setTxtDays24("W");
          oLbrHndlngAttndBean.setTxtDays25("W");
          oLbrHndlngAttndBean.setTxtDays26("W");
          oLbrHndlngAttndBean.setTxtDays27("W");
          oLbrHndlngAttndBean.setTxtDays28("W");
          oLbrHndlngAttndBean.setTxtDays29("W");
          oLbrHndlngAttndBean.setTxtDays30("W");
          oLbrHndlngAttndBean.setTxtDays31("W");
          oLbrHndlngAttndBean.setStatus("N");
          oLbrHndlngAttndDetailInfo.setScreenModeFlag("false");
          oDARateDetail.add(oLbrHndlngAttndBean);
          oRow = null;
          oLbrHndlngAttndBean = null;
        }             
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oLbrHndlngAttndDetailInfo = null;
    return oDARateDetail; 
  }  


  public boolean savePayScaleHeader(LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       return true;
  }
  

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
      return null ;  
  }  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {

  }  

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    String sPayScaleType;    
    
  if(sScreenName.equals("HndlngAttndScreen"))
    {
      sPayScaleType = "IDA";    
      saveHndlngAttnd(sPayScaleType,oDetailBeanArray,(LbrHndlngAttndHeaderBean)oBaseHeaderBean);
    }
    else 
    {
      sPayScaleType = "CDA";    
      saveHndlngAttnd(sPayScaleType,oDetailBeanArray,(LbrHndlngAttndHeaderBean)oBaseHeaderBean);
    } 
  }   
  
 private void saveHndlngAttnd(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = null; //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        LbrHndlngAttndBean oLbrHndlngAttndBean = (LbrHndlngAttndBean)oIt.next();
        if(oLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsHndlngAttndDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }          
          oParameters = new ArrayList();                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtYYMM())));                    
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays1())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays2())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays3())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays4())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays5())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays6())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays7())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays8())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays9())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays10())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays11())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays12())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays13())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays14())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays15())));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays16())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays17())));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays18())));
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays19())));
          oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays20())));
          oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays21())));
          oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays22())));
          oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays23())));
          oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays24())));
          oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays25())));
          oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays26())));
          oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays27())));
          oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays28())));
          oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays29())));
          oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays30())));
          oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays31())));
          oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtSiteID())));         
          //oLbrHndlngAttndHeaderBean.setScreenModeFlag("false");
          oBeanInsert.addToBatch(oParameters);
          oParameters = null;
        }
       else if(oLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdHndlngAttndDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }        
         
          oParameters = new ArrayList();                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtYYMM())));                    
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays1())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays2())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays3())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays4())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays5())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays6())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays7())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays8())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays9())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays10())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays11())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays12())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays13())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays14())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays15())));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays16())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays17())));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays18())));
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays19())));
          oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays20())));
          oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays21())));
          oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays22())));
          oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays23())));
          oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays24())));
          oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays25())));
          oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays26())));
          oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays27())));
          oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays28())));
          oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays29())));
          oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays30())));
          oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtDays31())));
          oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
          oParameters = null; 
        }
     else if(oLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
      {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteDARate(?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));         

          oBeanDelete.addToBatch(oParameters); 
          oParameters = null;
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
      finally
      {
        oBean = null;
        oBeanInsert = null;
        oBeanDelete = null;
      }
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




public LovVO getHndlngAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("YYYYMM");    
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
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHndlngAttndYYMM(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("YYYYMM").getString());            
      
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
  
  public LovVO getGangLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  { 
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");    
    arylstHeaderNames.add("Gang Name");    
    arylstHeaderNames.add("Location");     
    arylstHeaderNames.add("Location ID");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
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
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtLbrType").trim())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetGangLOV(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField3(oRow.get("loc_desc").getString());              
       oLOVBean.setDetailField4(oRow.get("loc_id").getString());            
      
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

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
        ArrayList oList=new ArrayList();
        checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
        checkDuplicacy(oBaseHeaderBean,sScreenMode,oDetailBeanArray,oList);
        LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean=(LbrHndlngAttndHeaderBean) oBaseHeaderBean;
        if((oLbrHndlngAttndHeaderBean.getHdnEmpLbrFlag().equals("D")) && (sScreenMode.equals("N") || sScreenMode.equals("U")))
        {
          checkLWPCountBeforeSave(oBaseHeaderBean,sScreenMode,oDetailBeanArray,oList);
        }
        reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  } 
 
  private void checkWrkSlipFilled(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = null; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    String days = null;
    boolean flag = false;
    LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean=(LbrHndlngAttndHeaderBean)oBaseHeaderBean;
    Iterator oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        LbrHndlngAttndBean oLbrHndlngAttndBean = (LbrHndlngAttndBean)oIt.next();
        count++;
    }
    String[][] modfDays = new String[count][31];
    String[] empArr = new String[count];
    count=0;
    oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        LbrHndlngAttndBean oLbrHndlngAttndBean = (LbrHndlngAttndBean)oIt.next();
        count++;
        if(oLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
            if(oLbrHndlngAttndBean.getDayModified1().equals("Y"))
            {
                modfDays[count-1][0] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified2().equals("Y"))
            {
                modfDays[count-1][1] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified3().equals("Y"))
            {
                modfDays[count-1][2] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified4().equals("Y"))
            {
                modfDays[count-1][3] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified5().equals("Y"))
            {
                modfDays[count-1][4] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified6().equals("Y"))
            {
                modfDays[count-1][5] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified7().equals("Y"))
            {
                modfDays[count-1][6] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified8().equals("Y"))
            {
                modfDays[count-1][7] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified9().equals("Y"))
            {
                modfDays[count-1][8] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified10().equals("Y"))
            {
                modfDays[count-1][9] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified11().equals("Y"))
            {
                modfDays[count-1][10] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified12().equals("Y"))
            {
                modfDays[count-1][11] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified13().equals("Y"))
            {
                modfDays[count-1][12] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified14().equals("Y"))
            {
                modfDays[count-1][13] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified15().equals("Y"))
            {
                modfDays[count-1][14] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified16().equals("Y"))
            {
                modfDays[count-1][15] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified17().equals("Y"))
            {
                modfDays[count-1][16] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified18().equals("Y"))
            {
                modfDays[count-1][17] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified19().equals("Y"))
            {
                modfDays[count-1][18] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified20().equals("Y"))
            {
                modfDays[count-1][19] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified21().equals("Y"))
            {
                modfDays[count-1][20] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified22().equals("Y"))
            {
                modfDays[count-1][21] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified23().equals("Y"))
            {
                modfDays[count-1][22] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified24().equals("Y"))
            {
                modfDays[count-1][23] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified25().equals("Y"))
            {
                modfDays[count-1][24] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified26().equals("Y"))
            {
                modfDays[count-1][25] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified27().equals("Y"))
            {
                modfDays[count-1][26] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified28().equals("Y"))
            {
                modfDays[count-1][27] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified29().equals("Y"))
            {
                modfDays[count-1][28] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified30().equals("Y"))
            {
                modfDays[count-1][29] = "Y";
                flag=true;
            }
            if(oLbrHndlngAttndBean.getDayModified31().equals("Y"))
            {
                modfDays[count-1][30] = "Y";
                flag=true;
            }
        }
        if(flag)
        {
            empArr[count-1] = (String)oLbrHndlngAttndBean.getTxtEmpNo();
        }
    }
    if(flag)
    {
        oList = new ArrayList();
        ArrayList oArguments = null;
        for(int i=0; i<modfDays.length; i++)
        {
            String msgDt="";
            for(int j=0; j < modfDays[i].length; j++)
            {
                if(modfDays[i][j]!= null)
                {
                    if(modfDays[i][j].equals("Y"))
                    {
                        oParameters = new ArrayList();
                        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empArr[i])));
                        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.INTEGER,new Integer(j+1)));
                        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndHeaderBean.getTxtYYMM()));
                        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndHeaderBean.getTxtGangId()));
                        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndHeaderBean.getTxtSiteID()));
                        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndHeaderBean.getHdnEmpLbrFlag()));  
                        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
                        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
                        oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_chkWrkslipFilled(?,?,?,?,?,?,?,?)");
                        String dt = (String)((DBObject)oOutArray.get(0)).getObject();
                        if(dt!=null)
                        {
                            msgDt = msgDt+", "+dt;
                        }
                    }
                }
            }
            
            if(!msgDt.equals(""))
            {
                oArguments = new ArrayList();
                oArguments.add(new String(empArr[i]));
                oArguments.add(new String(msgDt.substring(2)));
                oArguments.add(new Integer(i+1));
                oList.add(new EnrgiseApplicationException("Payroll.Labour.AttndWrkSlpChk",oArguments));
                oArguments=null;
            }
        }
        reportError(oList);
    }
  }

  private void checkYYMM(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
      LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean=(LbrHndlngAttndHeaderBean)oBaseHeaderBean;
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndHeaderBean.getTxtYYMM())); //added by swapnendu Dt. 13 Sep 2012
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrHndlngAttndHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetMaxPayYear(?,?,?,?,?)");                 
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
      oParameters = null;
      oOutArray = null;
      oLbrHndlngAttndHeaderBean = null;
      oBean = null;
      String sRevYear = "";
      String status = "";   
      String arcFlag="";
      
      oIt = oRetList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        sRevYear = oRow.get("yymm").getString(); 
        status = oRow.get("status").getString(); 
        arcFlag = oRow.get("arc_flag").getString(); 
        oRow = null;
      }
    oIt = null;
    if(arcFlag!=null && arcFlag.equals("Y"))
    {
      if(status!=null && (Integer.parseInt(status) >= 3))
      {
        //throw new EnrgiseApplicationException("payroll.Common.PayrollDone");
        oList = new ArrayList();
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(sRevYear));
        oList.add(new EnrgiseApplicationException("Payroll.Labour.AttndChk",oArguments));
        reportError(oList);
      }
      else
        throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    else //validation is applicable if attendance is filling for current payroll month.
    {
      checkWrkSlipFilled(oBaseHeaderBean,oDetailBeanArray,oList); //added by swapnendu Dt.17 Sep 2012, to check if workslip is entered for the modifying attendance.
    }
  }

  private void checkDuplicacy(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;
    LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean=(LbrHndlngAttndHeaderBean) oBaseHeaderBean;
    oIt = oDetailBeanArray.iterator();
    Integer chkFlag;
    boolean flag=false;
    String strEmpList="";
      while(oIt.hasNext())
      {
        LbrHndlngAttndBean oLbrHndlngAttndBean = (LbrHndlngAttndBean)oIt.next();

        if(!(oLbrHndlngAttndBean.getStatus().equals("D")))
          count++;

        if(oLbrHndlngAttndBean.getStatus().equals("N"))    
        {
          //oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_lbrAttendCheck(?,?,?,?)");
          chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
            if(!chkFlag.equals(new Integer(0)))
            {        
              flag=true;
              strEmpList=oLbrHndlngAttndBean.getTxtEmpNo()+",";              
            }
          }
          oLbrHndlngAttndBean = null;
        }
        if(flag==true)
        {
           ArrayList oArguments = new ArrayList();
           oArguments.add(strEmpList);
           oList.add(new EnrgiseApplicationException("payroll.lbr.attend.duplicate",oArguments));
           oArguments = null;
           strEmpList = null;
        }
          oOutArray = null;
          oParameters = null;
          oBean = null;
        oLbrHndlngAttndHeaderBean = null;
  }
  
   private void checkPCount(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = null; //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    ArrayList oOutArray;
      
    LbrHndlngAttndHeaderBean oLbrHndlngHeaderBean=(LbrHndlngAttndHeaderBean) oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
    //    LbrHndlngAttndBean oLbrHndlngAttndBean = (LbrHndlngAttndBean)oIt.next();
          LbrHndlngAttndBean oLbrHndlngAttndHeaderBean=(LbrHndlngAttndBean) oIt.next();
        //  LbrHndlngAttndHeaderBean oLbrHndlngHeaderBean=(LbrHndlngAttndHeaderBean) oIt.next();          
          oParameters = new ArrayList();                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngHeaderBean.getTxtYYMM())));                    
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays1())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays2())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays3())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays4())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays5())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays6())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays7())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays8())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays9())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays10())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays11())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays12())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays13())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays14())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays15())));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays16())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays17())));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays18())));
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays19())));
          oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays20())));
          oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays21())));
          oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays22())));
          oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays23())));
          oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays24())));
          oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays25())));
          oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays26())));
          oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays27())));
          oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays28())));
          oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays29())));
          oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays30())));
          oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtDays31())));
          oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngHeaderBean.getTxtSiteID())));         
          oParameters.add(new DBObject(36,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(37,DBObject.OUT,ParameterTypes.INTEGER));
          
           oBean = new DBUtilitiesBean();
           oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getdisabllvcount(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
           Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
                if( ! errCode.equals(new Integer(0)))
                {
                    ArrayList oArguments = new ArrayList();
                    oList.add((String)(((DBObject)oOutArray.get(0)).getObject()));
                    throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oList); 
                }
         
      }
  }
  private void checkLWPCountBeforeSave(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;
    LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean=(LbrHndlngAttndHeaderBean) oBaseHeaderBean;
    int vLWPcount=0;
    oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        LbrHndlngAttndBean oLbrHndlngAttndBean = (LbrHndlngAttndBean)oIt.next();
        vLWPcount=0;
        if(oLbrHndlngAttndBean.getTxtDays1().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays2().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays3().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays4().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays5().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays6().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays7().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays8().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays9().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays10().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays11().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays12().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays13().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays14().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays15().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays16().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays17().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays18().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays19().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays20().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays21().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays22().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays23().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays24().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays25().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays26().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays27().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays28().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays29().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays30().equals("L"))
        {
            vLWPcount++ ;
        }
        if(oLbrHndlngAttndBean.getTxtDays31().equals("L"))
        {
            vLWPcount++ ;
        }
        if (vLWPcount > 0)
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrHndlngAttndHeaderBean.getTxtYYMM())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.INTEGER,new Integer(vLWPcount)));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));          
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_countLWPCheck(?,?,?,?,?)",true,true);
            
            DBObject oOutObject = (DBObject)oOutArray.get(1);
            Integer errcode = (Integer)oOutObject.getObject();
            if(errcode.intValue() == 1500)
            {
                oOutObject = (DBObject)oOutArray.get(0);
                String errMsg = (String)(oOutObject.getObject());
                ArrayList oArguments = new ArrayList();
                oArguments.add(errMsg);
                oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
            }
        }
      }
   }
 
  
  
}