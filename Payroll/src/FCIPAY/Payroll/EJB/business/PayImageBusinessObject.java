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
import FCIPAY.Payroll.UTILITY.MaintElecMtrRdgHeaderBean;
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
import FCIPAY.Payroll.UTILITY.EnqPayImageHeaderBean;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class PayImageBusinessObject extends BaseBO
{
  public PayImageBusinessObject()
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
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    return;    
  }
  
  public RecordMetaInfo getEnqPayImageHeaderMetaInfo(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  { 
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    String lbrTyp ="";
    lbrTyp = oEnqPayImageQueryVO.getHdnEmpLbrFlag();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      if (lbrTyp.equals("E"))
      {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtUptoYYMM())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
        oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayImageCount(?,?,?,?,?,?,?,?,?,?,?,?,?)");
      }
      else
      {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtGangId())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtUptoYYMM())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
        oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.BIGINT));
        oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.TIMESTAMP));
        oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetPayImageGangCount(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      }
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      oParameters = null;
      oOutArray = null;
      oBean = null;
      oEnqPayImageQueryVO = null;
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
    String lbrTyp ="";
    lbrTyp = oEnqPayImageQueryVO.getHdnEmpLbrFlag();
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
      if (lbrTyp.equals("E"))
      {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtUptoYYMM())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
        oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayImageHeader(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      }
      else
      {       
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtGangId())));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtUptoYYMM())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
        oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetPayImageGangHeader(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");      
      }
      
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
          oEnqPayImageHeaderBean.setTxtUptoYYMM(oEnqPayImageQueryVO.getTxtUptoYYMM());
          oEnqPayImageHeaderBean.setTxtCurrBas(oRow.get("basic").getString());
          oEnqPayImageHeaderBean.setTxtPenDed(oRow.get("pencontr").getString());
          oEnqPayImageHeaderBean.setTxtEPSDed(oRow.get("epsded").getString());
          oEnqPayImageHeaderBean.setTxtPFContr(oRow.get("pfcontr").getString());
          oHeaderList.add(oEnqPayImageHeaderBean);
          oRow = null;
          oEnqPayImageHeaderBean = null;
      }
        oIt = null; 
        oList = null;
        lbrTyp = null;
        oBean = null;
        oOutArray = null;
        oParameters = null;
        oOutObject = null;
    return oHeaderList;
    }
    
  public RecordMetaInfo getHdrRcdPayImgInctMetaImpl(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  { 
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    String lbrTyp ="";
    lbrTyp = oEnqPayImageQueryVO.getHdnEmpLbrFlag();
    
    ArrayList oOutArray; //Output 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtGangId())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtUptoYYMM())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(12,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(13,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_image_labour.proc_getPayImgInctHdrCount(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      oParameters = null;
      oOutArray = null;
      oBean = null;
      oEnqPayImageQueryVO = null;
      return oRecordMetaInfo;   
  }

  public ArrayList getHdrRcdPayImgInctImpl(EnqPayImageQueryVO oEnqPayImageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
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

    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtEmpNo())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtGangId())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtYtm())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtUptoYYMM())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs1())));
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtrs2())));
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstCateg())));
    oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getLstGroup())));
    oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageQueryVO.getTxtDesig())));
    oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new Long(oEnqPayImageQueryVO.getLoginLocCode())));
    oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,oEnqPayImageQueryVO.getHdnEmpLbrFlag()));
    oParameters.add(new DBObject(14,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_pay_image_labour.proc_getPayImgInctHdr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");      
      
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
          oEnqPayImageHeaderBean.setTxtYtm(oRow.get("Run_Yymm").getString());
          oEnqPayImageHeaderBean.setTxtUptoYYMM(oEnqPayImageQueryVO.getTxtUptoYYMM());
          oEnqPayImageHeaderBean.setTxtCurrBas(oRow.get("basic").getString());
          oHeaderList.add(oEnqPayImageHeaderBean);
          oRow = null;
          oEnqPayImageHeaderBean = null;
      }
        oIt = null; 
        oList = null;
        oBean = null;
        oOutArray = null;
        oParameters = null;
        oOutObject = null;
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayImageDetailCount(?,?,?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      oTimeObject  = null;       
      oTotalRecord = null;
      oOutArray    = null;
      oParameters  = null;
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayImageDetail(?,?,?,?,?,?,?)");
      
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
          oEnqPayImgBean.setTxtPayCode(oRow.get("Pay_Code").getString());
          oEnqPayImgBean.setTxtDesc(oRow.get("Pay_Code_Desc").getString());
          oEnqPayImgBean.setTxtSrlNo(oRow.get("Pay_Code_Srl").getString());
          oEnqPayImgBean.setTxtPayMode(oRow.get("Pay_Mode").getString());
          oEnqPayImgBean.setTxtAmt(oRow.get("Txn_Amt").getString());
          oEnqPayImageDetail.add(oEnqPayImgBean);
          oRow = null;
          oEnqPayImgBean = null;
        }               
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oEnqPayImageDetailInfo = null;
    EmpNo = null;
    YearMon = null;
    empFlag = null;
    return oEnqPayImageDetail;    
  }

  public RecordMetaInfo getEnqPayImageInctDetailMetaInfo(String sPrimaryKey,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageDetailInfo.getTxtEmpNo())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageDetailInfo.getTxtYtm())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_image_labour.proc_getpayinctdetailcount(?,?,?,?,?,?)");
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      int val = Integer.parseInt(oTotalRecord.getObject().toString());
      if(val == 0)
      {        
        ArrayList oArguments = new ArrayList();
        oArguments.add(oEnqPayImageDetailInfo.getTxtYtm());
        ArrayList oList = new ArrayList();
        oList.add(new EnrgiseApplicationException("Payroll.GetDetails.NoRecords1",oArguments));
        reportError(oList);
      }
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      oTimeObject  = null;       
      oTotalRecord = null;
      oOutArray    = null;
      oParameters  = null;
      return oRecordMetaInfo;            
  }

  public ArrayList getEnqPayImageInctDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      EnqPayImgBean oEnqPayImgBean;
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oEnqPayImageDetail = null;
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageDetailInfo.getTxtEmpNo())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageDetailInfo.getTxtYtm())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEnqPayImageDetailInfo.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"pkg_pay_image_labour.proc_getpayinctdetail(?,?,?,?,?,?,?)");
      
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
          oEnqPayImgBean.setTxtPayCode1(oRow.get("Pay_Code").getString());
          oEnqPayImgBean.setTxtDesc1(oRow.get("Pay_Code_Desc").getString());
          oEnqPayImgBean.setTxtSrlNo1(oRow.get("Pay_Code_Srl").getString());
          oEnqPayImgBean.setTxtPayMode1(oRow.get("Pay_Mode").getString());
          oEnqPayImgBean.setTxtAmt1(oRow.get("Txn_Amt").getString());
          oEnqPayImageDetail.add(oEnqPayImgBean);
          oRow = null;
          oEnqPayImgBean = null;
        }               
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oEnqPayImageDetailInfo = null;
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
      oLOVBean = null;
      oRow = null;
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


  public LovVO getEnqEpmnoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name"); 
    arylstHeaderNames.add("CPF Code");                     // added by dushyant on 01-10-2010 for cpf code
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);        // added by dushyant on 01-10-2010 for cpf code
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    String EmpNo,Name,Cpfcode;
    EmpNo=oLovQueryVO.getSearchField1();
    Name=oLovQueryVO.getSearchField2();
    Cpfcode=oLovQueryVO.getSearchField3();                // added by dushyant on 01-10-2010 for cpf code
   
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,EmpNo));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Name));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,Cpfcode));                 // added by dushyant on 01-10-2010 for cpf code
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("txtSiteID")));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oLovQueryVO.getProperty("hdnEmpLbrFlag")));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PopupEmployeeNoData(?,?,?,?,?,?,?)");
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
     oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());       // added by dushyant on 01-10-2010 for cpf code
      
     oList.add(oLOVBean);
     oLOVBean = null; 
     oRow = null;
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
    oLovQueryVO = null;
    return oLovVO;
  }

  public LovVO getPayImgGangLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Gang Id");    
    arylstHeaderNames.add("Gang Name");    
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    oLovVO.setVisibilityList(arylstVisibility);
    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
          
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;
      String lbrType ="";
      if(oLovQueryVO.getProperty("hdnEmpLbrFlag").equals("L"))
        lbrType ="DEP";
      else if(oLovQueryVO.getProperty("hdnEmpLbrFlag").equals("D"))
        lbrType ="DPS";
      else if(oLovQueryVO.getProperty("hdnEmpLbrFlag").equals("K"))  
        lbrType ="KOT";
      else{}  
        
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,(new String(lbrType)).trim()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getSearchField1()))));      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_PayImageGangLOV(?,?,?,?,?)");
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
             
      oList.add(oLOVBean);
      oRow = null;
      oLOVBean = null;
    }
     
    oLovVO.setDetailList(oList);
    lbrType = null;
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

  public LovVO getEnqDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Designation");    
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
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PopupDsgnData(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("dsgn_desc").getString());            
      
      oList.add(oLOVBean);
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

  public EnqPayImageQueryVO getEnqPayImageComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EnqPayImageQueryVO oEnqPayImageQueryVO = new EnqPayImageQueryVO();
    ComboVO oComboVO = null;

    /* Newly Added */
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output

    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oCategValues = null;
    ArrayList oGroupValues = null;
      
      //oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetCategory(?,?)");
      
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
            oCategValues = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String CategLabel = oRow.get("Categ_Desc").getString();
          String CategValue = oRow.get("Categ_Desc").getString();
          oComboVO = new ComboVO(CategLabel,CategValue);
          oCategValues.add(oComboVO);
        }

      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpGroup(?,?)");
      
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
            oGroupValues = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String GroupLabel = oRow.get("code_desc").getString();
          String GroupValue = oRow.get("gbl_code").getString();
          oComboVO = new ComboVO(GroupLabel,GroupValue);
          oGroupValues.add(oComboVO);
          oComboVO = null;
          GroupLabel = null;
          GroupValue = null;
        }
      
    /* Newly Added */
    oEnqPayImageQueryVO.setValueCategArrayList(oCategValues);
    oEnqPayImageQueryVO.setValueGroupArrayList(oGroupValues);
    oGroupValues = null;
    oCategValues = null;
    oParameters = null;
    oOutArray = null;
    oList = null;
    return oEnqPayImageQueryVO;
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