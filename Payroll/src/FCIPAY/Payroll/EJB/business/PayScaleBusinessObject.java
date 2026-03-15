package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPayScaleQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleComboVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleDetailInfo;
import java.sql.SQLException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.PayScaleHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.UTILITY.MaintPayScaleDtlIDABean;
import FCIPAY.Payroll.WEBTIER.Form.MaintPayScaleForm;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleVO;//added by sakshi 26.12.08

public class PayScaleBusinessObject extends BaseBO
{
  public PayScaleBusinessObject()
  {
  }

  public RecordMetaInfo getPayScaleHeaderMetaInfo(MaintPayScaleQueryVO oMaintPayScaleQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();

    /*  String  sRevYear;
      String sPayScaleCode;
      String headPrimKey = oMaintPayScaleQueryVO.getHeaderPrimaryKey();
      sRevYear=headPrimKey.substring(0,6);
      sPayScaleCode=headPrimKey.substring(7,9);   */

 /*  if(oMaintPayScaleQueryVO.getTxtRevYYMM() == null)
    {
      String hPrimaryKey = oMaintPayScaleQueryVO.getHeaderPrimaryKey();
      int ind = hPrimaryKey.indexOf(",",0);
      oMaintPayScaleQueryVO.setTxtRevYYMM(hPrimaryKey.substring(0, ind));
      System.out.println(oMaintPayScaleQueryVO.getTxtRevYYMM());
      int ind1 = hPrimaryKey.indexOf(",",ind+1);
      oMaintPayScaleQueryVO.setLstPayScale(hPrimaryKey.substring(ind+1, ind1));
      System.out.println(oMaintPayScaleQueryVO.getLstPayScale());
      
    }*/

    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleQueryVO.getTxtRevYYMM())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleQueryVO.getLstPayScale())));
       oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleQueryVO.getTxtPayScaleType())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScaleCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }
  public ArrayList getPayScaleHeader(MaintPayScaleQueryVO oMaintPayScaleQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintPayScaleQueryVO == null)
    {
      oMaintPayScaleQueryVO = new MaintPayScaleQueryVO();
    }


   /*   String  sRevYear;
      String sPayScaleCode;
      String headPrimKey = oMaintPayScaleQueryVO.getHeaderPrimaryKey();
      sRevYear=headPrimKey.substring(0,6);
      sPayScaleCode=headPrimKey.substring(7,9); */


  /*    if(oMaintPayScaleQueryVO.getTxtRevYYMM() == null)
    {
      String hPrimaryKey = oMaintPayScaleQueryVO.getHeaderPrimaryKey();
      int ind = hPrimaryKey.indexOf(",",0);
      oMaintPayScaleQueryVO.setTxtRevYYMM(hPrimaryKey.substring(0, ind));
      System.out.println(oMaintPayScaleQueryVO.getTxtRevYYMM());
      int ind1 = hPrimaryKey.indexOf(",",ind+1);
      oMaintPayScaleQueryVO.setLstPayScale(hPrimaryKey.substring(ind+1, ind1));
      System.out.println(oMaintPayScaleQueryVO.getLstPayScale());
      
    }*/
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleQueryVO.getTxtRevYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleQueryVO.getLstPayScale())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleQueryVO.getTxtPayScaleType())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScale(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      PayScaleHeaderBean oPayScaleHeader;
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
          oPayScaleHeader = new PayScaleHeaderBean();
          oPayScaleHeader.setTxtRevYYMM(oRow.get("rev_year").getString());
          oPayScaleHeader.setLstPayScale(oRow.get("pay_scale_code").getString());
          oPayScaleHeader.setTxtPayScaleType(oRow.get("pay_scale_type").getString());
          oHeaderList.add(oPayScaleHeader);
      }              
    return oHeaderList;
  }
 /* public RecordMetaInfo getPayScaleDetailMetaInfo(String sRevyear, String sPayScaleCode, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sRevyear));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleCode));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));            
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScaleDtlCount(?,?,?,?,?, ?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;          
  }*/
//added by sakshi starts 26.12.2008
public PayScaleVO getPayScaleComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    PayScaleVO oPayScaleVO = new PayScaleVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDsgnCtgry = null;
  //  ArrayList oPayScale = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPayScaletypes(?,?)");
      
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
            oDsgnCtgry = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_desc").getString();
          String ctgryValue = oRow.get("code_desc").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oDsgnCtgry.add(oComboVO);
        }

       oPayScaleVO.setPayScaleList(oDsgnCtgry);
       return oPayScaleVO;
  }

//added by sakshi ends 26.12.2008
 public RecordMetaInfo getPayScaleDetailMetaInfo(String sPrimaryKey,PayScaleDetailInfo oPayScaleDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

      String RevYear,PayscaleCode,PayScaletype;
      RevYear = oPayScaleDetailInfo.getTxtRevYYMM();
      PayscaleCode = oPayScaleDetailInfo.getLstPayScale();
      PayScaletype = oPayScaleDetailInfo.getTxtPayScaleType();

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,RevYear));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,PayscaleCode));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,PayScaletype));            
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScaleDtlCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
 

/*  public ArrayList getPayScaleDetail(String sRevYear, String sPayScaleCode, String sPayScaleType,  long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPayScaleDtlIDABean oPayScaleDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sRevYear));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleCode));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScaleDetail(?,?,?,?,?,?,?)");
      
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
            oPayScaleDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oPayScaleDtl = new MaintPayScaleDtlIDABean();
          oPayScaleDtl.setTxtSrlNo((oRow.get("srl_no").getString()));          
       //   oPayScaleDtl.setTxtRevYYMM1((oRow.get("rev_year").getString()));
        //  oPayScaleDtl.setTxtPayScaleCode((oRow.get("pay_scale_code").getString()));
          
          oPayScaleDtl.setStartField((oRow.get("start_basic").getString()));
          oPayScaleDtl.setTxtIncrement((oRow.get("increment_amt").getString()));
          oPayScaleDtl.setEndField((oRow.get("end_basic").getString()));
          oPayScaleDtl.setHdnEBCheck((oRow.get("eb_flag").getString()));                    
          String sEB_Flag =  oRow.get("eb_flag").getString();
          if (sEB_Flag.equals("1"))
          {
            oPayScaleDtl.setTxtEfficiencyBar(true); 
          }
          else
          {
            oPayScaleDtl.setTxtEfficiencyBar(false);             
          }
          oPayScaleDtl.setStatus("Q");
          oPayScaleDetail.add(oPayScaleDtl);
        }             
        return oPayScaleDetail; 
  }    

*/

 public ArrayList getPayScaleDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,PayScaleDetailInfo oPayScaleDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintPayScaleDtlIDABean oPayScaleDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleDetail = null;

      String RevYear,PayscaleCode,PayScaleType;
      RevYear = oPayScaleDetailInfo.getTxtRevYYMM();
      PayscaleCode = oPayScaleDetailInfo.getLstPayScale();
      PayScaleType = oPayScaleDetailInfo.getTxtPayScaleType();
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,RevYear));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,PayscaleCode));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,PayScaleType));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_pay_band_api.proc_GetPayScaleDetail(?,?,?,?,?)");
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
            oPayScaleDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oPayScaleDtl = new MaintPayScaleDtlIDABean();
          oPayScaleDtl.setTxtSrlNo((oRow.get("pay_band_seq").getString()));          
       //   oPayScaleDtl.setTxtRevYYMM1((oRow.get("rev_year").getString()));
        //  oPayScaleDtl.setTxtPayScaleCode((oRow.get("pay_scale_code").getString()));
          
          oPayScaleDtl.setStartField((oRow.get("start_basic").getString()));
          //oPayScaleDtl.setTxtIncrement((oRow.get("increment_amt").getString()));
          oPayScaleDtl.setTxtGradePay((oRow.get("grade_pay").getString()));
          oPayScaleDtl.setEndField((oRow.get("end_basic").getString()));
          oPayScaleDtl.setTxtStartDate((oRow.get("start_date").getString()));
          oPayScaleDtl.setTxtEndDate((oRow.get("end_date").getString()));
          oPayScaleDtl.setTxtEfficiencyBar(false);             
          oPayScaleDtl.setStatus("Q");
          oPayScaleDetail.add(oPayScaleDtl);
        }             
        return oPayScaleDetail; 
  }    



  public boolean savePayScaleHeader(PayScaleHeaderBean oPayScaleHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
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
    
  if(sScreenName.equals("PayScaleIDA"))
    {
      sPayScaleType = "IDA";    
      savePayScale(sPayScaleType,oDetailBeanArray,(PayScaleHeaderBean)oBaseHeaderBean);
    }
    else 
    {
      sPayScaleType = "CDA";    
       savePayScale(sPayScaleType,oDetailBeanArray,(PayScaleHeaderBean)oBaseHeaderBean);
    } 
  }   
  
 private void savePayScale(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,PayScaleHeaderBean oPayScaleHeaderBean) throws EnrgiseSystemException
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
        MaintPayScaleDtlIDABean oMaintPayScaleDtlIDABean = (MaintPayScaleDtlIDABean)oIt.next();
//        System.out.println(oMaintPayScaleDtlIDABean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintPayScaleDtlIDABean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_pay_band_api.proc_InsertPayScaleDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
            String sEbCheck;
          if (oMaintPayScaleDtlIDABean.isTxtEfficiencyBar() == true)
              sEbCheck = "1";
          else
              sEbCheck = "0";
                  

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oPayScaleHeaderBean.getTxtPayScaleType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getTxtGradePay())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getEndField())));
          //oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getHdnEBCheck())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getTxtStartDate())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getTxtEndDate())));

          oBeanInsert.addToBatch(oParameters);
        }
       else if(oMaintPayScaleDtlIDABean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_pay_band_api.proc_UpdatePayScale(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          String sEbCheck;
          if (oMaintPayScaleDtlIDABean.isTxtEfficiencyBar() == true)
              sEbCheck = "1";
          else
              sEbCheck = "0";
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oPayScaleHeaderBean.getTxtPayScaleType())));                              
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getTxtSrlNo())));
          //oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getStartField())));
         // oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getTxtGradePay())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getTxtEndDate())));
          //oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getHdnEBCheck())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
     else if(oMaintPayScaleDtlIDABean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayScaleDetail(?,?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintPayScaleDtlIDABean.getTxtSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oPayScaleHeaderBean.getTxtPayScaleType())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));

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
    if(sScreenName.equals("PayScaleCDA"))
    {
      sDetailTable = "lstPayScaleDtl";
    }
    initializeBO("PayScaleCDA",sDetailTable);
  }  


public LovVO getPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Rev Year");    
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScaleRevYear(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("rev_year").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }


public LovVO getPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("PayScale Code");    
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScaleCodelov(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_band_code").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }




 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    
//    checkFirst(oBaseHeaderBean,oList);
     //checkPayScaleHeader(oBaseHeaderBean,oList);
     checkPayBandValidation(oBaseHeaderBean,oDetailBeanArray,oList);
     if (oList.size() == 0)  
     {
      checkPayScaleGreaterRevYear(oBaseHeaderBean,oList);
     }
     if (oList.size() == 0)  
     {
      checkPayBandGradePayDup(oBaseHeaderBean,oDetailBeanArray,oList);
     }
     reportError(oList);
    
    
  }
  
 private void checkPayBandValidation(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    String errmsg;
    ArrayList oRetList = null;
    String   gradepay=null;
    String   startdate=null; 
   String   enddate=null; 
  String   startbasic=null; 
    String   endbasic=null;  
  //  Iterator oIt = null;

        PayScaleHeaderBean  oPayScaleHeaderBean  = (PayScaleHeaderBean)oBaseHeaderBean;
       // MaintPayScaleForm   oMaintPayScaleDtlIDABean        = new MaintPayScaleForm();
       // MaintPayScaleDtlIDABean  oMaintPayScaleDtlIDABean = new MaintPayScaleDtlIDABean();
//        System.out.println(oPayScaleHeaderBean.getScreenModePay1());       
       Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintPayScaleDtlIDABean oMaintPayScaleDtlIDABean = (MaintPayScaleDtlIDABean)oIt.next();
//        System.out.println(oMaintPayScaleDtlIDABean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintPayScaleDtlIDABean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
            gradepay=new String(oMaintPayScaleDtlIDABean.getTxtGradePay());
            startdate=new String(oMaintPayScaleDtlIDABean.getTxtStartDate());
            enddate=new String(oMaintPayScaleDtlIDABean.getTxtEndDate());
            startbasic=new String(oMaintPayScaleDtlIDABean.getStartField());
            endbasic=new String(oMaintPayScaleDtlIDABean.getEndField());

       
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(startdate)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(enddate)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oPayScaleHeaderBean.getTxtPayScaleType()))); 
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oPayScaleHeaderBean.getLstPayScale())));
         // oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(gradepay)));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(startbasic)));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(endbasic)));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"pkg_pay_band_api.pay_band_validation(?,?,?,?,?,?,?,?)",true,true);
      
          DBObject oOutObject = (DBObject)oOutArray.get(0);
        String error_msg = (String)oOutObject.getObject();   
              
         if(error_msg!=null)
    
    {        
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String(error_msg));
      oList.add(new EnrgiseApplicationException("payroll.Payband.Bandvalidation",oArguments));
        oMaintPayScaleDtlIDABean.setTxtStartDate(null); 
        // oPayScaleDtl.setTxtStartDate((oRow.get("start_date").getString()));
    }     
    }
        
      }  
        }
  

  private void checkPayScaleHeader(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        PayScaleHeaderBean  oPayScaleHeaderBean  = (PayScaleHeaderBean)oBaseHeaderBean;

//        System.out.println(oPayScaleHeaderBean.getScreenModePay1());       
        if(oPayScaleHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PayScaleDuplicateCheck(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.PayScale.DuplicateCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }



 private void checkPayScaleGreaterRevYear(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

        PayScaleHeaderBean  oPayScaleHeaderBean  = (PayScaleHeaderBean)oBaseHeaderBean;

//        System.out.println(oPayScaleHeaderBean.getScreenModePay1());       
        if(oPayScaleHeaderBean.getScreenModePay1().equals("N"))    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getTxtRevYYMM())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PayGreaterRevCheck(?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("rev_year").getString(); 
              if (!sRevYear.equals("0"))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(sRevYear);              
                oList.add(new EnrgiseApplicationException("Payroll.PayScale.RevYearCheck",oArguments));              
              }                
             }
           
/*            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.PayScale.RevYearCheck",oArguments));
            }

             oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
            } */
            
        }
  }



 /* public PayScaleComboVO getPayScaleComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    PayScaleComboVO oPayScaleComboVO = new PayScaleComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleCode = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayscaleCode(?,?)");
      
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
            oPayScaleCode = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String PayscaleLabel = oRow.get("pay_scale_code").getString();
          String PayscaleValue = oRow.get("pay_scale_desc").getString();
          oComboVO = new ComboVO(PayscaleLabel,PayscaleValue);
          oPayScaleCode.add(oComboVO);
        }



      
    /* Newly Added */
   // oPayScaleComboVO.setPayScaleArr(oPayScaleCode);
  //  return oPayScaleComboVO;
       
 // }

//added by geetika on 21-11-2014
private void checkPayBandGradePayDup(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    String gradepay=null;
    
    
    Iterator oIt = oDetailBeanArray.iterator();
    PayScaleHeaderBean  oPayScaleHeaderBean  = (PayScaleHeaderBean)oBaseHeaderBean;
      while(oIt.hasNext())
      {
        MaintPayScaleDtlIDABean oMaintPayScaleDtlIDABean = (MaintPayScaleDtlIDABean)oIt.next();
//        System.out.println(oMaintPayScaleDtlIDABean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintPayScaleDtlIDABean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {

        
           gradepay=new String(oMaintPayScaleDtlIDABean.getTxtGradePay());
        }
        
      }

//        System.out.println(oPayScaleHeaderBean.getScreenModePay1());       
        if(oPayScaleHeaderBean.getScreenModePay1().equals("N")  )    
        {

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(gradepay)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oPayScaleHeaderBean.getLstPayScale())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_PayBandGradePayDup(?,?,?,?)");
      
           oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oList.add(new EnrgiseApplicationException("Payroll.PayScale.DuplicatePGCheck",EnrgiseConstants.MESSAGE));
            }
        }
  }



  
}