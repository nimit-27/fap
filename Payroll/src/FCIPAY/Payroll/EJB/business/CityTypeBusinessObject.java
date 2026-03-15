package FCIPAY.Payroll.EJB.business;
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
import FCIPAY.Payroll.UTILITY.MaintCityTypeBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
//import IBA.Payroll.EJB.common.helper.SysadminSql;
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


public class CityTypeBusinessObject extends  BaseBO
{
  public CityTypeBusinessObject()
  {
  }
public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("CityMasterScreen"))
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
      oParameters = new ArrayList();
        return null;
      
  }
  
  public RecordMetaInfo getCityDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetCityCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getCityDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintCityTypeBean oCity;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oCityDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetCityDetail(?,?,?,?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oCityDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oCity = new MaintCityTypeBean();
          oCity.setTxtCityType((oRow.get("CITY_TYPE").getString()));
          oCity.setStatus("Q");
          oCity.setTxtDesc(oRow.get("CITY_TYPE_DESC").getString());
          oCity.setTxtCities((oRow.get("CITIES").getString()));
          //oCity.setTxtSrlNo((oRow.get("SRL_NO").getString()));
          oCityDetail.add(oCity);
        }
        
        
    return oCityDetail;
    
  }

//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("CityMasterScreen"))
    {
      saveCityDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveCityDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
     DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintCityTypeBean oMaintCityTypeBean = (MaintCityTypeBean)oIt.next();
//        System.out.println(oMaintCityTypeBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintCityTypeBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertCityDetail(?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtCityType())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtCities())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintCityTypeBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateCityDetail(?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
         
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtCityType())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtCities())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
        

          oBean.addToBatch(oParameters);
       
        }
        else if(oMaintCityTypeBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteCityDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtCityType())));
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
     checkCity(oDetailBeanArray,oList);
     reportError(oList);
    
    
  }
  

  private void checkCity(ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintCityTypeBean oMaintCityTypeBean = (MaintCityTypeBean)oIt.next();
//        System.out.println(oMaintCityTypeBean.getStatus());

        if(!(oMaintCityTypeBean.getStatus().equals("D")))
          count++;
         
        if(oMaintCityTypeBean.getStatus().equals("N"))    
        {
          String pcode = oMaintCityTypeBean.getTxtCityType();

          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintCityTypeBean.getTxtCityType())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CityCheck(?,?,?)");
      
            oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oRetList.size() > 0)
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("wenrgise.common.duplicatecheck",oArguments));
            }
        }
      }
  }

}