package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GISComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintGISRatesBean;
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


public class GISRatesBusinessObject  extends BaseBO
{
  public GISRatesBusinessObject () 
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("MaintGISRatesScreen"))
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
 



//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
     
    if(sScreenName.equals("MaintGISRatesScreen"))
    {
      saveGISRates(sHeaderPrimaryKey,(DummyHeaderBean)oBaseHeaderBean, oDetailBeanArray);
    }

         
  }
  
  private void saveGISRates(String sHeaderPrimaryKey,DummyHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
       MaintGISRatesBean oMaintGISRatesBean = (MaintGISRatesBean)oIt.next();
      //  PayCodesVsAcctCodesBean oPayCodesVsAcctCodesBean = (PayCodesVsAcctCodesBean)oIt.next();
//        System.out.println(oMaintGISRatesBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintGISRatesBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertGISRatesDetail(?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGISRatesBean.getTxtGroup())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGISRatesBean.getTxtRate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintGISRatesBean.getTxtEffDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));          
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintGISRatesBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateGISRatesDetail(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGISRatesBean.getTxtGroup())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGISRatesBean.getTxtRate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintGISRatesBean.getTxtEffDate())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));                    
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMaintGISRatesBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteGISRatesDetail(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGISRatesBean.getTxtGroup())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintGISRatesBean.getTxtEffDate())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));          
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
  
  public RecordMetaInfo getGISRatesDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey)));       
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetGISRatesCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getGISRatesDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintGISRatesBean oGISRates;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oGISRatesDetail = null;
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(sPrimaryKey))); 
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetGISRatesDetail(?,?,?,?,?)");
      
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
            oGISRatesDetail = new ArrayList();
           
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oGISRates = new MaintGISRatesBean();
          oGISRates.setTxtGroup((oRow.get("emp_group").getString()));          
          oGISRates.setTxtRate((oRow.get("rate").getString()));
//          oPayCode.settxtSrlNo((oRow.get("RN").getString()));
          oGISRates.setStatus("Q");
//          oGISRates.setTxtEffDate(oRow.get("effect_date_from").getString());          
          oGISRates.setTxtEffDate(EnrgiseUtil.convertToString(oRow.get("effect_date_from").getDate()));
          oGISRatesDetail.add(oGISRates);

        }
        
    return oGISRatesDetail;
    
  }


 
public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      checkMandatoryDetail(oDetailBeanArray);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();
    
//    checkFirst(oBaseHeaderBean,oList);
     checkGroup(oDetailBeanArray,oList);
     reportError(oList);
    
    
  }
  

  private void checkGroup(ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Integer checkFlag = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintGISRatesBean oMaintGISRatesBean = (MaintGISRatesBean)oIt.next();
//        System.out.println(oMaintGISRatesBean.getStatus());

        if(!(oMaintGISRatesBean.getStatus().equals("D")))
          count++;


        if(oMaintGISRatesBean.getStatus().equals("N"))    
        {
          String pcode = oMaintGISRatesBean.getTxtGroup();
          String EffDate = oMaintGISRatesBean.getTxtEffDate();
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintGISRatesBean.getTxtGroup())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMaintGISRatesBean.getTxtEffDate())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GroupCheck(?,?,?,?)");
      
            checkFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
            if(!checkFlag.equals(new Integer(0)))
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("wenrgise.common.effdatecheck",oArguments));
            }
        }
      }
  }





  public GISComboVO getDetailGISComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    GISComboVO oGIS=null;


    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpCtgry(?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        ArrayList oGroupList = null;
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oGroupList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oGIS = new GISComboVO();
          String GISLabel = ((oRow.get("code_sdesc").getString()));
          String GISValue= ((oRow.get("gbl_code").getString()));
          ComboVO oComboVO = new ComboVO(GISLabel,GISValue);
          oGroupList.add(oComboVO);
        }


             
        oGIS.setCtgryArr(oGroupList);        
        return oGIS;
  }








  
  
}