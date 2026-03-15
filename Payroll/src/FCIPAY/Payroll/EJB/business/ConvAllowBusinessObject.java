package FCIPAY.Payroll.EJB.business;
import java.io.StringWriter;
import java.io.PrintWriter;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowDetailInfo;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.ConvAllowHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintConvAllowBean;

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

public class ConvAllowBusinessObject extends BaseBO
{
  public ConvAllowBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("ConvAllowAllScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  public RecordMetaInfo getConvAllowHeaderMetaInfo(ConvAllowQueryVO oConvAllowQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oConvAllowQueryVO.getTxtEffectDate())));      
//    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowQueryVO.getPayScaleType())));            
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowHeaderCount(?,?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getConvAllowHeader(ConvAllowQueryVO oConvAllowQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oConvAllowQueryVO == null)
    {
      oConvAllowQueryVO = new ConvAllowQueryVO();
    }
    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP, EnrgiseUtil.convertToSqlDate(oConvAllowQueryVO.getTxtEffectDate()))); 
//    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowQueryVO.getPayScaleType())));                  
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowHeader(?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
      //oList = oBean.executeQuery("SELECT * FROM aaa_myself");

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      ConvAllowHeaderBean oStdDednHeader;
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
          oStdDednHeader = new ConvAllowHeaderBean();
          oStdDednHeader.setHeaderPrimaryKey(oRow.get("city").getString());          
          oStdDednHeader.setTxtEffectDate(EnrgiseUtil.convertToString(oRow.get("effect_date").getDate()));                                                  
          oHeaderList.add(oStdDednHeader);
      }              
    return oHeaderList;
  } 


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
/*    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
    MaintPayCodesBean oMaintPayCodesBean = (MaintPayCodesBean)oBaseHeaderBean;

    ArrayList oOutArray; //Output  */



      oParameters = new ArrayList();
/*      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getStudentName())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oGlobalCodeHeaderBean.getSex())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); // Primary Key
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER)); */
//      oOutArray = oBean.callProc(oParameters,"BASU_AREA.proc_InsertGlobalCode(?,?,?,?)");

//      DBObject oOutObject = (DBObject)oOutArray.get(0);
//      return (String)oOutObject.getObject();
        return null;      
  } 


public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
{
  String sPayScaleType;    
  if(sScreenName.equals("ConvAllowAllScreen"))
  {
    sPayScaleType = "ALL";
    saveConvAllow(sHeaderPrimaryKey,sPayScaleType,(ConvAllowHeaderBean)oBaseHeaderBean, oDetailBeanArray);
  }
  else if(sScreenName.equals("ConvAllowCDAScreen"))
  {
    sPayScaleType = "CDA";    
    saveConvAllow(sHeaderPrimaryKey,sPayScaleType,(ConvAllowHeaderBean)oBaseHeaderBean, oDetailBeanArray);
  }
  else 
  {
    sPayScaleType = "IDA";    
    saveConvAllow(sHeaderPrimaryKey,sPayScaleType,(ConvAllowHeaderBean)oBaseHeaderBean, oDetailBeanArray);
  }        
    
}
  
 private void saveConvAllow(String sHeaderPrimaryKey,String sPayScaleType, ConvAllowHeaderBean oConvAllowHeaderBean,ArrayList oDetailBeanArray)  throws EnrgiseSystemException
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
        MaintConvAllowBean oMaintConvAllowBean = (MaintConvAllowBean)oIt.next();
//        System.out.println(oMaintConvAllowBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintConvAllowBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertConvAllowDetail(?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));                    
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oConvAllowHeaderBean.getTxtEffectDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtPayScale())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtAllow())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtCategory())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtHandicap())));          
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowHeaderBean.getTxtSiteID())));          
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintConvAllowBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateConvAllowDetail(?,?,?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtSrlNo())));          
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));                              
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oConvAllowHeaderBean.getTxtEffectDate())));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtPayScale())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtAllow())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtCategory())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtHandicap())));
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintConvAllowBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteConvAllowDetail(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintConvAllowBean.getTxtSrlNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oConvAllowHeaderBean.getTxtEffectDate())));                    
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

 public RecordMetaInfo getConvAllowAllDetailMetaInfo(String sPrimaryKey, ConvAllowDetailInfo oConvAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

      String sPayScaleType = sPrimaryKey.substring(0,3);
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oConvAllowDetailInfo.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oConvAllowDetailInfo.getTxtEffectDate())));     
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowAllCount(?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  } 

public ArrayList getConvAllowAllDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, ConvAllowDetailInfo oConvAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintConvAllowBean oConvAllowAll;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oConvAllowAllDetail = null;

    String sPayScaleType = sPrimaryKey.substring(0,3);

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oConvAllowDetailInfo.getHeaderPrimaryKey()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oConvAllowDetailInfo.getTxtEffectDate())));     
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowDetail(?,?,?,?,?,?,?)");
      
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
            oConvAllowAllDetail = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oConvAllowAll = new MaintConvAllowBean();
          oConvAllowAll.setTxtSrlNo((oRow.get("srl_no").getString()));          
//          oConvAllowAll.setStartField((oRow.get("amount_from").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oConvAllowAll.setStatus("Q");
          oConvAllowAll.setTxtPayScale(oRow.get("pay_scale_grade").getString());  
          oConvAllowAll.setTxtCategory(oRow.get("emp_category").getString());   
          oConvAllowAll.setTxtHandicap(oRow.get("handicapped_flag").getString());
          oConvAllowAll.setTxtAllow(oRow.get("allowance").getString());          
          oConvAllowAllDetail.add(oConvAllowAll);
        }
        
    return oConvAllowAllDetail;    
  }

 public RecordMetaInfo getConvAllowCdaDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowAllCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }


 public ArrayList getConvAllowCdaDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintConvAllowBean oConvAllowAll;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oConvAllowAllDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowDetail(?,?,?,?,?)");
      
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
            oConvAllowAllDetail = new ArrayList();
           
          }
          count++;
           oConvAllowAll = new MaintConvAllowBean();
          oConvAllowAll.setTxtSrlNo((oRow.get("srl_no").getString()));          
         // oConvAllowAll.setTxtAmtFrom((oRow.get("amount_from").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oConvAllowAll.setStatus("Q");
     //     oConvAllowAll.setTxtAmtTo(oRow.get("amount_to").getString());          
          //oConvAllowAll.setTxtCity(oRow.get("city").getString());
          oConvAllowAll.setTxtPayScale(oRow.get("pay_scale_grade").getString());  
          oConvAllowAll.setTxtAllow(oRow.get("allowance").getString());          
        //  oConvAllowAll.setTxtCityB1(oRow.get("convey_b1").getString());
        //  oConvAllowAll.setTxtCityB2(oRow.get("convey_b").getString());
        //  oConvAllowAll.setTxtCityC(oRow.get("convey_c").getString());
          oConvAllowAllDetail.add(oConvAllowAll);
        }
        
    return oConvAllowAllDetail;    
  }

 public RecordMetaInfo getConvAllowIdaDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowAllCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
 
 public ArrayList getConvAllowIdaDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintConvAllowBean oConvAllowAll;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oConvAllowAllDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowDetail(?,?,?,?,?)");
      
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
            oConvAllowAllDetail = new ArrayList();
           
          }
            count++;
            oConvAllowAll = new MaintConvAllowBean();
            oConvAllowAll.setTxtSrlNo((oRow.get("srl_no").getString()));          
    //      oConvAllowAll.setTxtAmtFrom((oRow.get("amount_from").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
            oConvAllowAll.setStatus("Q");
    //      oConvAllowAll.setTxtAmtTo(oRow.get("amount_to").getString());          
      //    oConvAllowAll.setTxtCityA1(oRow.get("convey_a1").getString());
       //   oConvAllowAll.setTxtCityA(oRow.get("convey_a").getString());          
       //   oConvAllowAll.setTxtCityB1(oRow.get("convey_b1").getString());
          //oConvAllowAll.setTxtCityB2(oRow.get("convey_b").getString());
       //   oConvAllowAll.setTxtCityC(oRow.get("convey_c").getString());
            oConvAllowAllDetail.add(oConvAllowAll);
        }        
    return oConvAllowAllDetail;    
  }


  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oList = new ArrayList();
      String sPayScaleType="";
      if(sScreenName.equals("ConvAllowCDAScreen"))
      {
        sPayScaleType = "CDA";            
      }
      else 
      {
        sPayScaleType = "IDA";            
      }       

   //   if(sScreenMode.equals(EnrgiseConstants.NEW_MODE))
    //  {
        chkEffDate(oBaseHeaderBean,sScreenMode,sPayScaleType,oList);
        reportError(oList);
   //   }    
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }

  public ConvAllowComboVO getConvAllowComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ConvAllowComboVO oConvAllowComboVO = new ConvAllowComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oConvAllowCity = null;   
    
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetCityTypeLocLov(?,?)");    
    
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
        oConvAllowCity = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String cityLabel = oRow.get("code_desc").getString();
      String cityValue = oRow.get("code_sdesc").getString();
      oComboVO = new ComboVO(cityLabel,cityValue);
      oConvAllowCity.add(oComboVO);
    }

      oParameters = new ArrayList();
      //This combo is being used only for CDA Tab so sending CDA.
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,"CDA"));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDsgnPayScaleCodelov(?,?,?)");    
    
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
      
    count = 0;
    oIt = oList.iterator();
    ArrayList oPayScaleList = null;
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oPayScaleList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String payScaleCode = ((oRow.get("pay_scale_code").getString()));
      String payScaleCodeDesc =payScaleCode+":"+ ((oRow.get("PAY_SCALE_DESC").getString()));
      oComboVO = new ComboVO(payScaleCodeDesc,payScaleCode);
      oPayScaleList.add(oComboVO);
    }
        
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCtgry(?,?)");
    
    oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
      
    count = 0;
    oIt = oList.iterator();
    ArrayList oCategList = null;
    while(oIt.hasNext())
    {
      if(count == 0)
      {
        oCategList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String catgryId = oRow.get("gbl_code").getString();
      String catgryDesc = oRow.get("code_sdesc").getString();
      oComboVO = new ComboVO(catgryDesc,catgryId);
      oCategList.add(oComboVO);
    }
    /* Newly Added */
    oConvAllowComboVO.setCityList(oConvAllowCity);    
    oConvAllowComboVO.setPayScaleList(oPayScaleList);
    oConvAllowComboVO.setCategoryList(oCategList);
    return oConvAllowComboVO;
       
  }
  
  private void chkEffDate(BaseHeaderBean oBaseHeaderBean,String sScreenMode,String sPayScaleType,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      ConvAllowHeaderBean oConvAllowHeaderBean = (ConvAllowHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oConvAllowHeaderBean.getTxtEffectDate())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sPayScaleType));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oConvAllowHeaderBean.getHeaderPrimaryKey()));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_ConvAllowCheck(?,?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("wenrgise.common.dateCheck",oArguments));
      }
  }  
}