package FCIPAY.Payroll.Labour.EJB.business;

import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndBean;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrHndlngAttndBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;

import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NWNPLbrHndlngBusinessObject  extends BaseBO {
    
    public NWNPLbrHndlngBusinessObject() {
      
    }

    @Override
    public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
        return null;
    }

    @Override
    public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) {
    }
    
    @Override
    public void initializeBOImpl(String sScreenName) {
    }
        
    
    public RecordMetaInfo getNWNPHndlngAttndHeaderMetaInfo(NWNPLbrHndlngAttndQueryVO oNWNPLbrHndlngAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       ArrayList oParameters = new ArrayList(); //Input Parameters
       DBUtilitiesBean oBean = new DBUtilitiesBean();
       ArrayList oList;
       Timestamp oWhenPicked = null;
       int count = 0;
       //BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
       
       ArrayList oOutArray; //Output 
         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getHdnEmpLbrFlag())));
    //         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getTxtGangId())));
         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getTxtLocId())));
         oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getTxtYYMM())));
         oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
         oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
         oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNwnpHndlngAttndCount(?,?,?,?,?,?)");      
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

    public ArrayList getNWNPHndlngAttndHeader(NWNPLbrHndlngAttndQueryVO oNWNPLbrHndlngAttndQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oList;
      int count = 0;

      if(oNWNPLbrHndlngAttndQueryVO == null)
      {
        oNWNPLbrHndlngAttndQueryVO = new NWNPLbrHndlngAttndQueryVO();
      }
      
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

        oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getHdnEmpLbrFlag())));
        //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getTxtGangId())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getTxtLocId())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndQueryVO.getTxtYYMM())));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNWNPHndlngAttndHeader(?,?,?,?,?,?,?)");
        
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean;
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
            oNWNPLbrHndlngAttndHeaderBean = new NWNPLbrHndlngAttndHeaderBean();          
            oNWNPLbrHndlngAttndHeaderBean.setLstLabourType(oRow.get("lbr_typ").getString());
            //oNWNPLbrHndlngAttndHeaderBean.setTxtGangId(oRow.get("gang_id").getString());
            //oNWNPLbrHndlngAttndHeaderBean.setTxtGangName(oRow.get("gang_name").getString());
            oNWNPLbrHndlngAttndHeaderBean.setTxtLocId(oNWNPLbrHndlngAttndQueryVO.getTxtLocId().toString());
            oNWNPLbrHndlngAttndHeaderBean.setTxtLocation(oRow.get("loc_desc").getString());
            oNWNPLbrHndlngAttndHeaderBean.setTxtYYMM(oRow.get("yyyymm").getString());
            oHeaderList.add(oNWNPLbrHndlngAttndHeaderBean);
            oRow = null;
            oNWNPLbrHndlngAttndHeaderBean = null;
        }              
      oList = null;
      oIt = null;
      oNWNPLbrHndlngAttndQueryVO = null;
      oOutArray = null;
      oParameters = null;
      oOutObject = null;
      oBean = null;
     return oHeaderList;
    }
    
    
    public RecordMetaInfo getNWNPHndlngAttndDetailMetaInfo(String sPrimaryKey,NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
     //public RecordMetaInfo getDARatesDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       ArrayList oParameters = new ArrayList(); //Input Parameters
       DBUtilitiesBean oBean = new DBUtilitiesBean();
       ArrayList oOutArray; //Output 
       
         oParameters = new ArrayList();
         System.out.println(oNWNPLbrHndlngAttndDetailInfo.getScreenModeFlag());
         
         if(oNWNPLbrHndlngAttndDetailInfo.getScreenModeFlag().equals("true")) 
         {
             return getNWNPLabourDetailMetaInfo(oNWNPLbrHndlngAttndDetailInfo);
         }
         
         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getLstLabourType()));  
         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtLocId()));            
         oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtYYMM()));
         oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
         oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));      
         oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNwnpHndlngAttndDtlCt(?,?,?,?,?,?)");    
         
         RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

         DBObject oTotalRecord = (DBObject)oOutArray.get(0);
         oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
         DBObject oTimeObject = (DBObject)oOutArray.get(1);
         oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
       oBean = null;
       oOutArray = null;
       oParameters = null;
       oNWNPLbrHndlngAttndDetailInfo = null;
       oTotalRecord = null;
       oTimeObject = null;
       return oRecordMetaInfo;          
     }
    
    
    private RecordMetaInfo getNWNPLabourDetailMetaInfo(NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    //public RecordMetaInfo getDARatesDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      
        oParameters = new ArrayList();
        //System.out.println(oLbrHndlngAttndDetailInfo.getScreenMode());
        //oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtGangId())); 
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getHdnEmpLbrFlag()));            
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtLocId()));  
        //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));            
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNwnpHndlngLabourDtlCt(?,?,?,?,?)");      
        
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
    
    
    public ArrayList getNWNPHndlngAttndDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
     {  
       ArrayList oParameters = new ArrayList(); //Input Parameters
       DBUtilitiesBean oBean = new DBUtilitiesBean();
       int count = 0;
       ArrayList oOutArray; //Output 
       NWNPLbrHndlngAttndBean oNWNPLbrHndlngAttndBean;
       QueryRow oRow = null;
       QueryValue oValue = null;
       ArrayList oList = null;
       Iterator oIt = null;
       ArrayList oDARateDetail = null;
         
         //String sYear,sDAType;
         //sYear = oLbrHndlngAttndDetailInfo.getTxtYYMM();
         //sDAType = oLbrHndlngAttndDetailInfo.getTxtDAType();
         
         if(oNWNPLbrHndlngAttndDetailInfo.getScreenModeFlag().equals("true")) 
         {
             return getLabourDetail(sPrimaryKey,lDetailFirstPosition,lDetailLastPosition,oNWNPLbrHndlngAttndDetailInfo);
         }

         oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
         oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
         oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getLstLabourType()));
         //oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtGangId())); 
         oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtLocId()));  
         oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtYYMM()));      
         //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
         oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
         oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
         oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNwnpHndlngAttndDetail(?,?,?,?,?,?,?)");      
         
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
             oNWNPLbrHndlngAttndBean = new NWNPLbrHndlngAttndBean();          
             oNWNPLbrHndlngAttndBean.setTxtEmpNo((oRow.get("emp_num").getString()));
             oNWNPLbrHndlngAttndBean.setTxtEmpName((oRow.get("emp_name").getString()));          
             oNWNPLbrHndlngAttndBean.setTxtLabourCode((oRow.get("kot_lbr_id").getString()));          
             oNWNPLbrHndlngAttndBean.setTxtDays1((oRow.get("day1").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays2((oRow.get("day2").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays3((oRow.get("day3").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays4((oRow.get("day4").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays5((oRow.get("day5").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays6((oRow.get("day6").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays7((oRow.get("day7").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays8((oRow.get("day8").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays9((oRow.get("day9").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays10((oRow.get("day10").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays11((oRow.get("day11").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays12((oRow.get("day12").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays13((oRow.get("day13").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays14((oRow.get("day14").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays15((oRow.get("day15").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays16((oRow.get("day16").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays17((oRow.get("day17").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays18((oRow.get("day18").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays19((oRow.get("day19").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays20((oRow.get("day20").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays21((oRow.get("day21").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays22((oRow.get("day22").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays23((oRow.get("day23").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays24((oRow.get("day24").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays25((oRow.get("day25").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays26((oRow.get("day26").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays27((oRow.get("day27").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays28((oRow.get("day28").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays29((oRow.get("day29").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays30((oRow.get("day30").getString()));
             oNWNPLbrHndlngAttndBean.setTxtDays31((oRow.get("day31").getString()));
             oNWNPLbrHndlngAttndBean.setStatus("Q");
             oDARateDetail.add(oNWNPLbrHndlngAttndBean);
             oRow = null;
             oNWNPLbrHndlngAttndBean = null;
           }             
       oList = null;
       oIt = null;
       oBean = null;
       oOutArray = null;
       oParameters = null;
       oNWNPLbrHndlngAttndDetailInfo = null;
       return oDARateDetail; 
     }
       
    private ArrayList getLabourDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
    {  
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      NWNPLbrHndlngAttndBean oNwnpLbrHndlngAttndBean;
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oDARateDetail = null;
        
        String sYearMnth,sDAType;
        sYearMnth = oNWNPLbrHndlngAttndDetailInfo.getTxtYYMM();
        //sDAType = oLbrHndlngAttndDetailInfo.getTxtDAType();
        
        String sYear=sYearMnth.substring(0,4);
            String sMonth=sYearMnth.substring(4,6);                              
          sYearMnth = null;
          sDAType = null;
        //oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
        //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtGangId()));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getHdnEmpLbrFlag())); 
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndDetailInfo.getTxtLocId()));        
        //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetNwnpHndlngLabourDetail(?,?,?,?,?,?)");      
        
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
            oNwnpLbrHndlngAttndBean = new NWNPLbrHndlngAttndBean();          
            oNwnpLbrHndlngAttndBean.setTxtEmpNo((oRow.get("emp_num").getString()));
            oNwnpLbrHndlngAttndBean.setTxtEmpName((oRow.get("emp_name").getString()));          
            oNwnpLbrHndlngAttndBean.setTxtLabourCode("");          
            oNwnpLbrHndlngAttndBean.setTxtDays1("W");
            oNwnpLbrHndlngAttndBean.setTxtDays2("W");
            oNwnpLbrHndlngAttndBean.setTxtDays3("W");
            oNwnpLbrHndlngAttndBean.setTxtDays4("W");
            oNwnpLbrHndlngAttndBean.setTxtDays5("W");
            oNwnpLbrHndlngAttndBean.setTxtDays6("W");
            oNwnpLbrHndlngAttndBean.setTxtDays7("W");
            oNwnpLbrHndlngAttndBean.setTxtDays8("W");
            oNwnpLbrHndlngAttndBean.setTxtDays9("W");
            oNwnpLbrHndlngAttndBean.setTxtDays10("W");
            oNwnpLbrHndlngAttndBean.setTxtDays11("W");
            oNwnpLbrHndlngAttndBean.setTxtDays12("W");
            oNwnpLbrHndlngAttndBean.setTxtDays13("W");
            oNwnpLbrHndlngAttndBean.setTxtDays14("W");
            oNwnpLbrHndlngAttndBean.setTxtDays15("W");
            oNwnpLbrHndlngAttndBean.setTxtDays16("W");
            oNwnpLbrHndlngAttndBean.setTxtDays17("W");
            oNwnpLbrHndlngAttndBean.setTxtDays18("W");
            oNwnpLbrHndlngAttndBean.setTxtDays19("W");
            oNwnpLbrHndlngAttndBean.setTxtDays20("W");
            oNwnpLbrHndlngAttndBean.setTxtDays21("W");
            oNwnpLbrHndlngAttndBean.setTxtDays22("W");
            oNwnpLbrHndlngAttndBean.setTxtDays23("W");
            oNwnpLbrHndlngAttndBean.setTxtDays24("W");
            oNwnpLbrHndlngAttndBean.setTxtDays25("W");
            oNwnpLbrHndlngAttndBean.setTxtDays26("W");
            oNwnpLbrHndlngAttndBean.setTxtDays27("W");
            oNwnpLbrHndlngAttndBean.setTxtDays28("W");
            oNwnpLbrHndlngAttndBean.setTxtDays29("W");
            oNwnpLbrHndlngAttndBean.setTxtDays30("W");
            oNwnpLbrHndlngAttndBean.setTxtDays31("W");
            oNwnpLbrHndlngAttndBean.setStatus("N");
            oNWNPLbrHndlngAttndDetailInfo.setScreenModeFlag("false");
            oDARateDetail.add(oNwnpLbrHndlngAttndBean);
            oRow = null;
            oNwnpLbrHndlngAttndBean = null;
          }             
      oList = null;
      oIt = null;
      oBean = null;
      oOutArray = null;
      oParameters = null;
      oNWNPLbrHndlngAttndDetailInfo = null;
      return oDARateDetail; 
    } 
    
    @Override
    public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       if(bDetailDataChanged)
       {
           ArrayList oList=new ArrayList();
           checkYYMM(oBaseHeaderBean,oDetailBeanArray,oList);
           checkDuplicacy(oBaseHeaderBean,sScreenMode,oDetailBeanArray,oList);
           NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean=(NWNPLbrHndlngAttndHeaderBean) oBaseHeaderBean;
           //if((oNWNPLbrHndlngAttndHeaderBean.getHdnEmpLbrFlag().equals("D")) && (sScreenMode.equals("N") || sScreenMode.equals("U")))
           if((oNWNPLbrHndlngAttndHeaderBean.getHdnEmpLbrFlag().equals("N")) && (sScreenMode.equals("N") || sScreenMode.equals("U")))
           {
             checkLWPCountBeforeSave(oBaseHeaderBean,sScreenMode,oDetailBeanArray,oList);
           }
           reportError(oList);
       }
     }
    @Override
     public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
     {

     }
    
    @Override
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
        NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean=(NWNPLbrHndlngAttndHeaderBean)oBaseHeaderBean;
        //oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndHeaderBean.getTxtYYMM())); //added by swapnendu Dt. 13 Sep 2012
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndHeaderBean.getTxtSiteID()));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndHeaderBean.getHdnEmpLbrFlag()));  
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
        oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetMaxPayYear(?,?,?,?,?)");                 
        oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        oParameters = null;
        oOutArray = null;
        oNWNPLbrHndlngAttndHeaderBean = null;
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
      NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean=(NWNPLbrHndlngAttndHeaderBean) oBaseHeaderBean;
      oIt = oDetailBeanArray.iterator();
      Integer chkFlag;
      boolean flag=false;
      String strEmpList="";
        while(oIt.hasNext())
        {
          NWNPLbrHndlngAttndBean oNWNPLbrHndlngAttndBean = (NWNPLbrHndlngAttndBean)oIt.next();

          if(!(oNWNPLbrHndlngAttndBean.getStatus().equals("D")))
            count++;

          if(oNWNPLbrHndlngAttndBean.getStatus().equals("N"))    
          {
            //oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtYYMM())));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_lbrAttendCheck(?,?,?,?)");
            chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
              if(!chkFlag.equals(new Integer(0)))
              {        
                flag=true;
                strEmpList=oNWNPLbrHndlngAttndBean.getTxtEmpNo()+",";              
              }
            }
            oNWNPLbrHndlngAttndBean = null;
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
          oNWNPLbrHndlngAttndHeaderBean = null;
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
      NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean=(NWNPLbrHndlngAttndHeaderBean) oBaseHeaderBean;
      int vLWPcount=0;
      oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
          NWNPLbrHndlngAttndBean oNWNPLbrHndlngAttndBean = (NWNPLbrHndlngAttndBean)oIt.next();
          vLWPcount=0;
          if(oNWNPLbrHndlngAttndBean.getTxtDays1().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays2().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays3().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays4().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays5().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays6().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays7().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays8().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays9().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays10().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays11().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays12().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays13().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays14().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays15().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays16().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays17().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays18().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays19().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays20().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays21().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays22().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays23().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays24().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays25().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays26().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays27().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays28().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays29().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays30().equals("L"))
          {
              vLWPcount++ ;
          }
          if(oNWNPLbrHndlngAttndBean.getTxtDays31().equals("L"))
          {
              vLWPcount++ ;
          }
          if (vLWPcount > 0)
          {
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtEmpNo())));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtYYMM())));
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
      NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean=(NWNPLbrHndlngAttndHeaderBean)oBaseHeaderBean;
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
          NWNPLbrHndlngAttndBean oNWNPLbrHndlngAttndBean = (NWNPLbrHndlngAttndBean)oIt.next();
          count++;
      }
      String[][] modfDays = new String[count][31];
      String[] empArr = new String[count];
      count=0;
      oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
          NWNPLbrHndlngAttndBean oNWNPLbrHndlngAttndBean = (NWNPLbrHndlngAttndBean)oIt.next();
          count++;
          if(oNWNPLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
          {
              if(oNWNPLbrHndlngAttndBean.getDayModified1().equals("Y"))
              {
                  modfDays[count-1][0] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified2().equals("Y"))
              {
                  modfDays[count-1][1] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified3().equals("Y"))
              {
                  modfDays[count-1][2] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified4().equals("Y"))
              {
                  modfDays[count-1][3] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified5().equals("Y"))
              {
                  modfDays[count-1][4] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified6().equals("Y"))
              {
                  modfDays[count-1][5] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified7().equals("Y"))
              {
                  modfDays[count-1][6] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified8().equals("Y"))
              {
                  modfDays[count-1][7] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified9().equals("Y"))
              {
                  modfDays[count-1][8] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified10().equals("Y"))
              {
                  modfDays[count-1][9] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified11().equals("Y"))
              {
                  modfDays[count-1][10] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified12().equals("Y"))
              {
                  modfDays[count-1][11] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified13().equals("Y"))
              {
                  modfDays[count-1][12] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified14().equals("Y"))
              {
                  modfDays[count-1][13] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified15().equals("Y"))
              {
                  modfDays[count-1][14] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified16().equals("Y"))
              {
                  modfDays[count-1][15] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified17().equals("Y"))
              {
                  modfDays[count-1][16] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified18().equals("Y"))
              {
                  modfDays[count-1][17] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified19().equals("Y"))
              {
                  modfDays[count-1][18] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified20().equals("Y"))
              {
                  modfDays[count-1][19] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified21().equals("Y"))
              {
                  modfDays[count-1][20] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified22().equals("Y"))
              {
                  modfDays[count-1][21] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified23().equals("Y"))
              {
                  modfDays[count-1][22] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified24().equals("Y"))
              {
                  modfDays[count-1][23] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified25().equals("Y"))
              {
                  modfDays[count-1][24] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified26().equals("Y"))
              {
                  modfDays[count-1][25] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified27().equals("Y"))
              {
                  modfDays[count-1][26] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified28().equals("Y"))
              {
                  modfDays[count-1][27] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified29().equals("Y"))
              {
                  modfDays[count-1][28] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified30().equals("Y"))
              {
                  modfDays[count-1][29] = "Y";
                  flag=true;
              }
              if(oNWNPLbrHndlngAttndBean.getDayModified31().equals("Y"))
              {
                  modfDays[count-1][30] = "Y";
                  flag=true;
              }
          }
          if(flag)
          {
              empArr[count-1] = (String)oNWNPLbrHndlngAttndBean.getTxtEmpNo();
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
                          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndHeaderBean.getTxtYYMM()));
                          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndHeaderBean.getTxtGangId()));
                          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndHeaderBean.getTxtSiteID()));
                          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oNWNPLbrHndlngAttndHeaderBean.getHdnEmpLbrFlag()));  
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
    
    public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
    {
      String sPayScaleType;    
      
    if(sScreenName.equals("NWNPHndlngAttndScreen"))
      {
        sPayScaleType = "IDA";    
        saveHndlngAttnd(sPayScaleType,oDetailBeanArray,(NWNPLbrHndlngAttndHeaderBean)oBaseHeaderBean);
      }
      else 
      {
        sPayScaleType = "CDA";    
        saveHndlngAttnd(sPayScaleType,oDetailBeanArray,(NWNPLbrHndlngAttndHeaderBean)oBaseHeaderBean);
      } 
    }   
    
    private void saveHndlngAttnd(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean) throws EnrgiseSystemException
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
          NWNPLbrHndlngAttndBean oNWNPLbrHndlngAttndBean = (NWNPLbrHndlngAttndBean)oIt.next();
          if(oNWNPLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
          {
            if(!bInsert)
            {
              oBeanInsert = new DBUtilitiesBean();
              oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsHndlngAttndDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
              bInsert = true;
            }          
            oParameters = new ArrayList();                    
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtYYMM())));                    
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays1())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays2())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays3())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays4())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays5())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays6())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays7())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays8())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays9())));
            oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays10())));
            oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays11())));
            oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays12())));
            oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays13())));
            oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays14())));
            oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays15())));
            oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays16())));
            oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays17())));
            oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays18())));
            oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays19())));
            oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays20())));
            oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays21())));
            oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays22())));
            oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays23())));
            oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays24())));
            oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays25())));
            oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays26())));
            oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays27())));
            oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays28())));
            oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays29())));
            oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays30())));
            oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays31())));
            oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtSiteID())));         
            //oLbrHndlngAttndHeaderBean.setScreenModeFlag("false");
            oBeanInsert.addToBatch(oParameters);
            oParameters = null;
          }
         else if(oNWNPLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
          {
            if(!bUpdate)
            {
              oBean = new DBUtilitiesBean();
              oBean.createBatch("PKG_PAY_LABOUR.proc_UpdHndlngAttndDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
              bUpdate = true;
            }        
           
            oParameters = new ArrayList();                    
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtYYMM())));                    
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays1())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays2())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays3())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays4())));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays5())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays6())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays7())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays8())));
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays9())));
            oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays10())));
            oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays11())));
            oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays12())));
            oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays13())));
            oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays14())));
            oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays15())));
            oParameters.add(new DBObject(18,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays16())));
            oParameters.add(new DBObject(19,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays17())));
            oParameters.add(new DBObject(20,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays18())));
            oParameters.add(new DBObject(21,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays19())));
            oParameters.add(new DBObject(22,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays20())));
            oParameters.add(new DBObject(23,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays21())));
            oParameters.add(new DBObject(24,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays22())));
            oParameters.add(new DBObject(25,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays23())));
            oParameters.add(new DBObject(26,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays24())));
            oParameters.add(new DBObject(27,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays25())));
            oParameters.add(new DBObject(28,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays26())));
            oParameters.add(new DBObject(29,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays27())));
            oParameters.add(new DBObject(30,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays28())));
            oParameters.add(new DBObject(31,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays29())));
            oParameters.add(new DBObject(32,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays30())));
            oParameters.add(new DBObject(33,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndBean.getTxtDays31())));
            oParameters.add(new DBObject(34,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(35,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtSiteID())));

            oBean.addToBatch(oParameters);
            oParameters = null; 
          }
       else if(oNWNPLbrHndlngAttndBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
            if(!bDelete)
            {
              oBeanDelete = new DBUtilitiesBean();
              oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteDARate(?,?,?,?)");
              bDelete = true;
            }
            oParameters = new ArrayList();          
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oNWNPLbrHndlngAttndHeaderBean.getTxtYYMM())));
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
       
}
