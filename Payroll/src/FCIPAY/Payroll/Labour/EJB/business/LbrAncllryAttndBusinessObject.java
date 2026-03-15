package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.Labour.Utility.LbrAncllryAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.LbrAncllryAttndBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.lang.String;
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

public class LbrAncllryAttndBusinessObject extends BaseBO
{
  public LbrAncllryAttndBusinessObject()
  {
  }
 public RecordMetaInfo getAncllryAttndHeaderMetaInfo(LbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getLstLabourType())));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getTxtGangId())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getTxtLocId())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAncllryAttndCount(?,?,?,?,?,?)");      
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
  public ArrayList getAncllryAttndHeader(LbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oLbrAncllryAttndQueryVO == null)
    {
      oLbrAncllryAttndQueryVO = new LbrAncllryAttndQueryVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getLstLabourType())));
      //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getTxtGangId())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getTxtLocId())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndQueryVO.getTxtYYMM())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAncllryAttndHeader(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean;
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
          oLbrAncllryAttndHeaderBean = new LbrAncllryAttndHeaderBean();          
          oLbrAncllryAttndHeaderBean.setLstLabourType(oRow.get("lbr_typ").getString());
          oLbrAncllryAttndHeaderBean.setTxtLocId(oRow.get("site_id").getString());          
          oLbrAncllryAttndHeaderBean.setTxtLocation(oRow.get("site_name").getString());
          oLbrAncllryAttndHeaderBean.setTxtYYMM(oRow.get("yyyymm").getString());
          oHeaderList.add(oLbrAncllryAttndHeaderBean);
      }              
    return oHeaderList;
  }
 public RecordMetaInfo getAncllryAttndDetailMetaInfo(String sPrimaryKey,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  //public RecordMetaInfo getDARatesDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      System.out.println(oLbrAncllryAttndDetailInfo.getScreenModeFlag());
      
      if(oLbrAncllryAttndDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getLabourDetailMetaInfo(oLbrAncllryAttndDetailInfo);
      }
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getTxtLocId()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getLstLabourType()));  
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getTxtYYMM()));  
      //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));            
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));      
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAncllryAttndDtlCount(?,?,?,?,?,?)");    
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }

 public ArrayList getAncllryAttndDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LbrAncllryAttndBean oLbrAncllryAttndBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;    
      
      if(oLbrAncllryAttndDetailInfo.getScreenModeFlag().equals("true")) 
      {
          return getLabourDetail(sPrimaryKey,lDetailFirstPosition,lDetailLastPosition,oLbrAncllryAttndDetailInfo);
      }

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getTxtLocId()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getLstLabourType()));  
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getTxtYYMM()));      
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAncllryAttndDtl(?,?,?,?,?,?,?)");
      
      
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
          oLbrAncllryAttndBean = new LbrAncllryAttndBean();          
          oLbrAncllryAttndBean.setTxtEmpNo((oRow.get("emp_num").getString()));
          oLbrAncllryAttndBean.setTxtEmpName((oRow.get("emp_name").getString()));          
          oLbrAncllryAttndBean.setTxtLabourCode((oRow.get("kot_lbr_id").getString()));            
          oLbrAncllryAttndBean.setTxtDays1((oRow.get("day1").getString()));
          oLbrAncllryAttndBean.setTxtDays2((oRow.get("day2").getString()));
          oLbrAncllryAttndBean.setTxtDays3((oRow.get("day3").getString()));
          oLbrAncllryAttndBean.setTxtDays4((oRow.get("day4").getString()));
          oLbrAncllryAttndBean.setTxtDays5((oRow.get("day5").getString()));
          oLbrAncllryAttndBean.setTxtDays6((oRow.get("day6").getString()));
          oLbrAncllryAttndBean.setTxtDays7((oRow.get("day7").getString()));
          oLbrAncllryAttndBean.setTxtDays8((oRow.get("day8").getString()));
          oLbrAncllryAttndBean.setTxtDays9((oRow.get("day9").getString()));
          oLbrAncllryAttndBean.setTxtDays10((oRow.get("day10").getString()));
          oLbrAncllryAttndBean.setTxtDays11((oRow.get("day11").getString()));
          oLbrAncllryAttndBean.setTxtDays12((oRow.get("day12").getString()));
          oLbrAncllryAttndBean.setTxtDays13((oRow.get("day13").getString()));
          oLbrAncllryAttndBean.setTxtDays14((oRow.get("day14").getString()));
          oLbrAncllryAttndBean.setTxtDays15((oRow.get("day15").getString()));
          oLbrAncllryAttndBean.setTxtDays16((oRow.get("day16").getString()));
          oLbrAncllryAttndBean.setTxtDays17((oRow.get("day17").getString()));
          oLbrAncllryAttndBean.setTxtDays18((oRow.get("day18").getString()));
          oLbrAncllryAttndBean.setTxtDays19((oRow.get("day19").getString()));
          oLbrAncllryAttndBean.setTxtDays20((oRow.get("day20").getString()));
          oLbrAncllryAttndBean.setTxtDays21((oRow.get("day21").getString()));
          oLbrAncllryAttndBean.setTxtDays22((oRow.get("day22").getString()));
          oLbrAncllryAttndBean.setTxtDays23((oRow.get("day23").getString()));
          oLbrAncllryAttndBean.setTxtDays24((oRow.get("day24").getString()));
          oLbrAncllryAttndBean.setTxtDays25((oRow.get("day25").getString()));
          oLbrAncllryAttndBean.setTxtDays26((oRow.get("day26").getString()));
          oLbrAncllryAttndBean.setTxtDays27((oRow.get("day27").getString()));
          oLbrAncllryAttndBean.setTxtDays28((oRow.get("day28").getString()));
          oLbrAncllryAttndBean.setTxtDays29((oRow.get("day29").getString()));
          oLbrAncllryAttndBean.setTxtDays30((oRow.get("day30").getString()));
          oLbrAncllryAttndBean.setTxtDays31((oRow.get("day31").getString()));
          oLbrAncllryAttndBean.setStatus("Q");
          oDARateDetail.add(oLbrAncllryAttndBean);
        }             
        return oDARateDetail; 
  }  
  
  private RecordMetaInfo getLabourDetailMetaInfo(LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  //public RecordMetaInfo getDARatesDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      //System.out.println(oLbrAncllryAttndDetailInfo.getScreenMode());
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getTxtLocId()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getLstLabourType()));  
      //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));            
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAncllryLabourDtlCount(?,?,?,?,?)");      
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }
  
  private ArrayList getLabourDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    LbrAncllryAttndBean oLbrAncllryAttndBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDARateDetail = null;
      
      String sYear,sDAType;
      sYear = oLbrAncllryAttndDetailInfo.getTxtYYMM();
      sDAType = oLbrAncllryAttndDetailInfo.getTxtDAType();


      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getTxtLocId()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndDetailInfo.getLstLabourType()));      
      //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAncllryLabourDetail(?,?,?,?,?,?)");
      
      
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
          oLbrAncllryAttndBean = new LbrAncllryAttndBean();          
          oLbrAncllryAttndBean.setTxtEmpNo((oRow.get("emp_num").getString()));
          oLbrAncllryAttndBean.setTxtEmpName((oRow.get("emp_name").getString()));      
          oLbrAncllryAttndBean.setTxtLabourCode((oRow.get("kot_lbr_id").getString())); 
          oLbrAncllryAttndBean.setTxtDays1("W");
          oLbrAncllryAttndBean.setTxtDays2("W");
          oLbrAncllryAttndBean.setTxtDays3("W");
          oLbrAncllryAttndBean.setTxtDays4("W");
          oLbrAncllryAttndBean.setTxtDays5("W");
          oLbrAncllryAttndBean.setTxtDays6("W");
          oLbrAncllryAttndBean.setTxtDays7("W");
          oLbrAncllryAttndBean.setTxtDays8("W");
          oLbrAncllryAttndBean.setTxtDays9("W");
          oLbrAncllryAttndBean.setTxtDays10("W");
          oLbrAncllryAttndBean.setTxtDays11("W");
          oLbrAncllryAttndBean.setTxtDays12("W");
          oLbrAncllryAttndBean.setTxtDays13("W");
          oLbrAncllryAttndBean.setTxtDays14("W");
          oLbrAncllryAttndBean.setTxtDays15("W");
          oLbrAncllryAttndBean.setTxtDays16("W");
          oLbrAncllryAttndBean.setTxtDays17("W");
          oLbrAncllryAttndBean.setTxtDays18("W");
          oLbrAncllryAttndBean.setTxtDays19("W");
          oLbrAncllryAttndBean.setTxtDays20("W");
          oLbrAncllryAttndBean.setTxtDays21("W");
          oLbrAncllryAttndBean.setTxtDays22("W");
          oLbrAncllryAttndBean.setTxtDays23("W");
          oLbrAncllryAttndBean.setTxtDays24("W");
          oLbrAncllryAttndBean.setTxtDays25("W");
          oLbrAncllryAttndBean.setTxtDays26("W");
          oLbrAncllryAttndBean.setTxtDays27("W");
          oLbrAncllryAttndBean.setTxtDays28("W");
          oLbrAncllryAttndBean.setTxtDays29("W");
          oLbrAncllryAttndBean.setTxtDays30("W");
          oLbrAncllryAttndBean.setTxtDays31("W");
          oLbrAncllryAttndBean.setStatus("N");
          oLbrAncllryAttndDetailInfo.setScreenModeFlag("false");
          oDARateDetail.add(oLbrAncllryAttndBean);
        }             
        return oDARateDetail; 
  } 

  public boolean savePayScaleHeader(LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
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
    
  if(sScreenName.equals("AncllryAttndScreen"))
    {
      sPayScaleType = "IDA";    
      saveAncllryAttnd(sPayScaleType,oDetailBeanArray,(LbrAncllryAttndHeaderBean)oBaseHeaderBean);
    }
    else 
    {
      sPayScaleType = "CDA";    
      saveAncllryAttnd(sPayScaleType,oDetailBeanArray,(LbrAncllryAttndHeaderBean)oBaseHeaderBean);
    } 
  }   
  
 private void saveAncllryAttnd(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean) throws EnrgiseSystemException
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
        LbrAncllryAttndBean oLbrAncllryAttndBean = (LbrAncllryAttndBean)oIt.next();
//        System.out.println(oLbrAncllryAttndBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oLbrAncllryAttndBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsAncllryAttndDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }          
          oParameters = new ArrayList();                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtYYMM())));          
          //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays1())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays2())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays3())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays4())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays5())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays6())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays7())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays8())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays9())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays10())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays11())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays12())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays13())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays14())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays15())));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays16())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays17())));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays18())));
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays19())));
          oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays20())));
          oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays21())));
          oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays22())));
          oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays23())));
          oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays24())));
          oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays25())));
          oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays26())));
          oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays27())));
          oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays28())));
          oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays29())));
          oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays30())));
          oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays31())));
          oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtSiteID())));         
          oLbrAncllryAttndHeaderBean.setScreenModeFlag("false");
          oBeanInsert.addToBatch(oParameters);
        }
       else if(oLbrAncllryAttndBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdAncllryAttndDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }        
         
          oParameters = new ArrayList();                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtYYMM())));          
          //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays1())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays2())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays3())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays4())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays5())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays6())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays7())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays8())));
          oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays9())));
          oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays10())));
          oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays11())));
          oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays12())));
          oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays13())));
          oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays14())));
          oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays15())));
          oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays16())));
          oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays17())));
          oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays18())));
          oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays19())));
          oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays20())));
          oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays21())));
          oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays22())));
          oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays23())));
          oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays24())));
          oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays25())));
          oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays26())));
          oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays27())));
          oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays28())));
          oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays29())));
          oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays30())));
          oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtDays31())));
          oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
          
        }
     else if(oLbrAncllryAttndBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
      {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteDARate(?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));
          //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtDAType())));

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




public LovVO getAncllryAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    
/*       DateUtility d=new DateUtility();
       String str=d.getSysDate();
       String monOfSysDate=str.substring(3,5);
       String yearOfSysDate=str.substring(6,10);
       String yyyymm=yearOfSysDate+monOfSysDate;
       System.out.println(yyyymm);  */
 
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
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
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public LovVO getAncllryLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
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
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    
/*     DateUtility d=new DateUtility();
       String str=d.getSysDate();
       String monOfSysDate=str.substring(3,5);
       String yearOfSysDate=str.substring(6,10);
       String yyyymm=yearOfSysDate+monOfSysDate;
       System.out.println(yyyymm);  */
 
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      //oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtLbrType").trim())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAncllryLocLOV(?,?,?,?,?)");
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
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
        ArrayList oList=new ArrayList();
        checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
        checkDuplicacy(oBaseHeaderBean,sScreenMode,oDetailBeanArray,oList);
        LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean=(LbrAncllryAttndHeaderBean)oBaseHeaderBean;
        if((oLbrAncllryAttndHeaderBean.getHdnEmpLbrFlag().equals("D")) && (sScreenMode.equals("N") || sScreenMode.equals("U")))
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
      LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean=(LbrAncllryAttndHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
           oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndHeaderBean.getTxtYYMM()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oLbrAncllryAttndHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
     // oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");                 
      oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetMaxPayYear(?,?,?,?,?)");
                
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
	 oParameters = null;
      oOutArray = null;
      oLbrAncllryAttndHeaderBean = null;
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

    if(arcFlag!=null && arcFlag.equals("Y"))
    {
if(status!=null && (Integer.parseInt(status) >=3))
      {
      // throw new EnrgiseApplicationException("payroll.Common.PayrollDone");
       oList = new ArrayList();
        ArrayList oArguments = new ArrayList();
        oArguments.add(new String(sRevYear));
        oList.add(new EnrgiseApplicationException("Payroll.Labour.AttndChk",oArguments));
        reportError(oList);
      }
      if(status!=null && (Integer.parseInt(status) == 2))
{
        throw new EnrgiseApplicationException("payroll.Common.PayrollDone");
     }
 else
        throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
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
    LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean=(LbrAncllryAttndHeaderBean) oBaseHeaderBean;
    oIt = oDetailBeanArray.iterator();
    Integer chkFlag;
    boolean flag=false;
    String strEmpList="";

      while(oIt.hasNext())
      {
        LbrAncllryAttndBean oLbrAncllryAttndBean = (LbrAncllryAttndBean)oIt.next();
//        System.out.println(oMaintCityTypeBean.getStatus());

        if(!(oLbrAncllryAttndBean.getStatus().equals("D")))
          count++;


        if(oLbrAncllryAttndBean.getStatus().equals("N"))    
        {
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtYYMM())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_lbrAttendCheck(?,?,?,?)");
      
            chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
            if(!chkFlag.equals(new Integer(0)))
            {        
              flag=true;
              strEmpList=oLbrAncllryAttndBean.getTxtEmpNo()+",";
              
            }
          }
        }
        if(flag==true)
        {
           ArrayList oArguments = new ArrayList();
           oArguments.add(strEmpList);
           oList.add(new EnrgiseApplicationException("payroll.lbr.attend.duplicate",oArguments));
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
    LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean=(LbrAncllryAttndHeaderBean) oBaseHeaderBean;
    int vLWPcount=0;
    oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        LbrAncllryAttndBean ooLbrAncllryAttndBean = (LbrAncllryAttndBean)oIt.next();
        vLWPcount=0;
        if(ooLbrAncllryAttndBean.getTxtDays1().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays2().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays3().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays4().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays5().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays6().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays7().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays8().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays9().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays10().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays11().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays12().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays13().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays14().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays15().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays16().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays17().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays18().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays19().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays20().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays21().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays22().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays23().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays24().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays25().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays26().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays27().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays28().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays29().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays30().equals("L"))
        {
            vLWPcount++ ;
        }
        if(ooLbrAncllryAttndBean.getTxtDays31().equals("L"))
        {
            vLWPcount++ ;
        }
        if (vLWPcount > 0)
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(ooLbrAncllryAttndBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLbrAncllryAttndHeaderBean.getTxtYYMM())));
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