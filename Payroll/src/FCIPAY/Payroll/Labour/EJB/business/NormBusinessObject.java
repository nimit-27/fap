package FCIPAY.Payroll.Labour.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator; 
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintNormBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintNormQueryVO;

import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NormComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintNormHeaderBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NormDetailInfo;
public class NormBusinessObject extends BaseBO 
{
  public NormBusinessObject()
  {
  }
  
    public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("NormScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
     return null;
  }
 

//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {  
      MaintNormHeaderBean oNormHeaderBean = (MaintNormHeaderBean)oBaseHeaderBean;
      String sNormTyp=oNormHeaderBean.getTxtNormTyp();
      
      if(sNormTyp.equals("ABOVE"))
      {
         saveAboveNormDetail(sHeaderPrimaryKey,oNormHeaderBean, oDetailBeanArray,"N");
      }else if(sNormTyp.equals("HEIGHT"))
      {
        saveHeightNormDetail(sHeaderPrimaryKey,oNormHeaderBean, oDetailBeanArray,"N");
      }else if(sNormTyp.equals("LEAD"))
      {
       saveLeadNormDetail(sHeaderPrimaryKey,oNormHeaderBean, oDetailBeanArray,"N");
      }else if(sNormTyp.equals("OT_ABOVE"))
      {
        saveAboveNormDetail(sHeaderPrimaryKey,oNormHeaderBean, oDetailBeanArray,"Y");
      }else if(sNormTyp.equals("OT_HEIGHT"))
      {
        saveHeightNormDetail(sHeaderPrimaryKey,oNormHeaderBean, oDetailBeanArray,"Y");
      }else if(sNormTyp.equals("OT_LEAD"))
      {
        saveLeadNormDetail(sHeaderPrimaryKey,oNormHeaderBean, oDetailBeanArray,"Y");
      }
  }
  
  private void saveAboveNormDetail(String sHeaderPrimaryKey, MaintNormHeaderBean oNormHeaderBean, ArrayList oDetailBeanArray,String sOTFlg) throws EnrgiseSystemException
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
        MaintNormBean oMaintNormBean = (MaintNormBean)oIt.next();
//        System.out.println(oMaintCCARatesBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintNormBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertAbvNormDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
       //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtRate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getStartField())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getEndField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtBagTyp()))); 
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtMou())));  
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNormHeaderBean.getTxtEffDate()))); 
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(sOTFlg))); 
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtSiteID())));
          
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintNormBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateAbvNormDetail(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtNormId())));  
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtRate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getEndField())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtBagTyp())));
      //    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate("")));                    
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintNormBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteAbvNormDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtNormId())));
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
        //  System.out.println(e.getMessage());
      }
  }
 private void saveHeightNormDetail(String sHeaderPrimaryKey, MaintNormHeaderBean oNormHeaderBean, ArrayList oDetailBeanArray,String sOTFlg) throws EnrgiseSystemException
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
        MaintNormBean oMaintNormBean = (MaintNormBean)oIt.next();
//        System.out.println(oMaintCCARatesBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintNormBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertHghtNormDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
       //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtRate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getStartField())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getEndField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtBagTyp()))); 
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtMou())));  
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNormHeaderBean.getTxtEffDate()))); 
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(sOTFlg))); 
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtSiteID())));
          
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintNormBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateHghtNormDetail(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtNormId())));                 
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtRate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getEndField())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtBagTyp())));
      //    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate("")));                    
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintNormBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteHghtNormDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtNormId())));
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
  private void saveLeadNormDetail(String sHeaderPrimaryKey, MaintNormHeaderBean oNormHeaderBean, ArrayList oDetailBeanArray,String sOTFlg) throws EnrgiseSystemException
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
        MaintNormBean oMaintNormBean = (MaintNormBean)oIt.next();
//        System.out.println(oMaintCCARatesBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintNormBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PKG_PAY_LABOUR.proc_InsertLdNormDetail(?,?,?,?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
       //   oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sPayScaleType)));                    
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtRate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getStartField())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getEndField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtBagTyp()))); 
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtMou())));  
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNormHeaderBean.getTxtEffDate()))); 
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(sOTFlg))); 
          oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtSiteID())));
          
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintNormBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PKG_PAY_LABOUR.proc_UpdateLdNormDetail(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtNormId())));                 
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtRate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getStartField())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getEndField())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtBagTyp())));
      //    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate("")));                    
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oNormHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintNormBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PKG_PAY_LABOUR.proc_DeleteLdNormDetail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormBean.getTxtNormId())));
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
  
 public RecordMetaInfo getNormDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      String sProcName="";
      
      // Not Applicable for Oracle 9iAS
      //String arPrimaryKey[]=sPrimaryKey.split(":");
      
      NormDetailInfo oNormDetailInfo=(NormDetailInfo)oBaseDetailInfo;
      
      String sNormTyp=oNormDetailInfo.getTxtNormTyp();
      String sOTFlg="";
    
      if(sNormTyp.equals("ABOVE"))
      {
        sOTFlg="N";
        sProcName="PKG_PAY_LABOUR.proc_GetAbvNormDetailCount(?,?,?,?,?,?)";
      }
      else if(sNormTyp.equals("HEIGHT"))
      {
        sOTFlg="N";
        sProcName="PKG_PAY_LABOUR.proc_GetHghtNormDetailCount(?,?,?,?,?,?)";
      }
      else if(sNormTyp.equals("LEAD"))
      {
        sOTFlg="N";
        sProcName="PKG_PAY_LABOUR.proc_GetLdNormDetailCount(?,?,?,?,?,?)";
      }
      else if(sNormTyp.equals("OT_ABOVE"))
      {
        sOTFlg="Y";
        sProcName="PKG_PAY_LABOUR.proc_GetAbvNormDetailCount(?,?,?,?,?,?)";
      }
      else if(sNormTyp.equals("OT_HEIGHT"))
      {
        sOTFlg="Y";
        sProcName="PKG_PAY_LABOUR.proc_GetHghtNormDetailCount(?,?,?,?,?,?)";
      }
      else if(sNormTyp.equals("OT_LEAD"))
      {
        sOTFlg="Y";
        sProcName="PKG_PAY_LABOUR.proc_GetLdNormDetailCount(?,?,?,?,?,?)";
      }
      else
      {
        return null;
      }

      return  getNormDetailMetaInfo(sOTFlg,sProcName,oNormDetailInfo);
  }
  
 private RecordMetaInfo getNormDetailMetaInfo(String sOTFlg,String sProcName,NormDetailInfo oNormDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oNormDetailInfo.getTxtMou()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,sOTFlg));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNormDetailInfo.getTxtEffDate())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,sProcName);
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }

 public ArrayList getNormDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
      NormDetailInfo oNormDetailInfo=(NormDetailInfo)oBaseDetailInfo;
      String sNormTyp=oNormDetailInfo.getTxtNormTyp();
      
      if(sNormTyp.equals("ABOVE"))
      {
         return getAboveNormDetail("N",lDetailFirstPosition,lDetailLastPosition,oNormDetailInfo);
      }else if(sNormTyp.equals("HEIGHT"))
      {
        return  getHeightNormDetail("N",lDetailFirstPosition,lDetailLastPosition,oNormDetailInfo);
      }else if(sNormTyp.equals("LEAD"))
      {
        return  getLeadNormDetail("N",lDetailFirstPosition,lDetailLastPosition,oNormDetailInfo);
      }else if(sNormTyp.equals("OT_ABOVE"))
      {
        return  getAboveNormDetail("Y",lDetailFirstPosition,lDetailLastPosition,oNormDetailInfo);
      }else if(sNormTyp.equals("OT_HEIGHT"))
      {
        return  getHeightNormDetail("Y",lDetailFirstPosition,lDetailLastPosition,oNormDetailInfo);
      }else if(sNormTyp.equals("OT_LEAD"))
      {
        return  getLeadNormDetail("Y",lDetailFirstPosition,lDetailLastPosition,oNormDetailInfo);
      }else
      {
        return null;
      }
  }

  private ArrayList getAboveNormDetail(String sOTFlg, long lDetailFirstPosition,long lDetailLastPosition,NormDetailInfo oNormDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintNormBean oMaintNormBean;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oNormDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNormDetailInfo.getTxtMou()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sOTFlg));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNormDetailInfo.getTxtEffDate())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetAbvNormDetail(?,?,?,?,?,?,?)");
      
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
            oNormDetail = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintNormBean = new MaintNormBean();
          oMaintNormBean.setTxtNormId((oRow.get("ABOVE_NORM_ID").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oMaintNormBean.setStatus("Q");
          oMaintNormBean.setStartField(oRow.get("ABOVE_NORM_MIN_LIMIT").getString());
          oMaintNormBean.setEndField(oRow.get("ABOVE_NORM_MAX_LIMIT").getString());
          oMaintNormBean.setTxtRate(oRow.get("ABOVE_NORM_PERCENT").getString());
          oMaintNormBean.setTxtBagTyp(oRow.get("WT_FLG").getString());
          oNormDetail.add(oMaintNormBean);
        }
        
    return oNormDetail;
    
  }
  
  private ArrayList getHeightNormDetail(String sOTFlg, long lDetailFirstPosition,long lDetailLastPosition,NormDetailInfo oNormDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintNormBean oMaintNormBean;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oNormDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNormDetailInfo.getTxtMou()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sOTFlg));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNormDetailInfo.getTxtEffDate())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetHghtNormDetail(?,?,?,?,?,?,?)");
      
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
            oNormDetail = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintNormBean = new MaintNormBean();
          oMaintNormBean.setTxtNormId((oRow.get("HEIGHT_NORM_ID").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oMaintNormBean.setStatus("Q");
          oMaintNormBean.setStartField(oRow.get("HEIGHT_NORM_MIN_LIMIT").getString());
          oMaintNormBean.setEndField(oRow.get("HEIGHT_NORM_MAX_LIMIT").getString());
          oMaintNormBean.setTxtRate(oRow.get("HEIGHT_NORM_PERCENT").getString());
          oMaintNormBean.setTxtBagTyp(oRow.get("WT_FLG").getString());
          oNormDetail.add(oMaintNormBean);
        }
        
    return oNormDetail;
    
  }
  
  private ArrayList getLeadNormDetail(String sOTFlg, long lDetailFirstPosition,long lDetailLastPosition,NormDetailInfo oNormDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintNormBean oMaintNormBean;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oNormDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oNormDetailInfo.getTxtMou()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,sOTFlg));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oNormDetailInfo.getTxtEffDate())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_GetLdNormDetail(?,?,?,?,?,?,?)");
      
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
            oNormDetail = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintNormBean = new MaintNormBean();
          oMaintNormBean.setTxtNormId((oRow.get("LEAD_NORM_ID").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oMaintNormBean.setStatus("Q");
          oMaintNormBean.setStartField(oRow.get("LEAD_NORM_MIN_LIMIT").getString());
          oMaintNormBean.setEndField(oRow.get("LEAD_NORM_MAX_LIMIT").getString());
          oMaintNormBean.setTxtRate(oRow.get("LEAD_NORM_PERCENT").getString());
          oMaintNormBean.setTxtBagTyp(oRow.get("WT_FLG").getString());
          oNormDetail.add(oMaintNormBean);
        }
        
    return oNormDetail;
    
  }
  
  public NormComboVO getNormComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    NormComboVO oNormComboVO = new NormComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oMouList = null;
    ArrayList oNormTypList=null;
   
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getMOU(?,?)");
      
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
        oMouList = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      String mouLabel = oRow.get("code_desc").getString();
      String mouValue = oRow.get("code_desc").getString();
      oComboVO = new ComboVO(mouLabel,mouValue);
      oMouList.add(oComboVO);
    }
    oNormComboVO.setMouList(oMouList);
    
     //To get Norm Type Details
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNormTypeList(?,?)");
        
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
          oNormTypList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)oIt.next();
        String normTypLabel = oRow.get("code_desc").getString();
        String normTypValue = oRow.get("code_sdesc").getString();
        oComboVO = new ComboVO(normTypLabel,normTypValue);
        oNormTypList.add(oComboVO);
      }

      oNormComboVO.setNormTypList(oNormTypList);

    return oNormComboVO;
  }

 public RecordMetaInfo getNormHeaderMetaImpl(MaintNormQueryVO oMaintNormQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintNormQueryVO.getTxtNormTyp()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintNormQueryVO.getTxtMou()));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNormHeaderCount(?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }

  public ArrayList getNormHeaderRecord(MaintNormQueryVO oMaintNormQueryVO, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintNormHeaderBean oMaintNormBean;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oNormDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintNormQueryVO.getTxtNormTyp()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintNormQueryVO.getTxtMou()));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_getNormHeader(?,?,?,?)");
      
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
            oNormDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintNormBean = new MaintNormHeaderBean();
          oMaintNormBean.setTxtNormTyp(oMaintNormQueryVO.getTxtNormTyp());
          oMaintNormBean.setTxtEffDate(EnrgiseUtil.convertToString(oRow.get("effective_start_date").getDate()));
          oMaintNormBean.setTxtMou(oRow.get("mou_code").getString());
          oNormDetail.add(oMaintNormBean);
        }
        
    return oNormDetail;
    
  }


 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList=new ArrayList();
    if(sScreenMode.equals("N"))
    {
      chkEffDate(oBaseHeaderBean,sScreenMode,oList);
   }
    reportError(oList);
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
 private void chkEffDate(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      QueryRow oRow = null;
      QueryValue oValue = null;
      Integer chkFlag=new Integer(0);
      MaintNormHeaderBean oMaintNormHeaderBean = (MaintNormHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oMaintNormHeaderBean.getTxtNormTyp()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oMaintNormHeaderBean.getTxtMou()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintNormHeaderBean.getTxtEffDate())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_PAY_LABOUR.proc_NormDtlCheck(?,?,?,?,?)");
      chkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!chkFlag.equals(new Integer(0)))
      {        
        ArrayList oArguments = new ArrayList();
        oList.add(new EnrgiseApplicationException("wenrgise.common.dateCheck",oArguments));
      }
  }
  
}