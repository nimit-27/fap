package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;

import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DsgnComboVO;
import FCIPAY.Payroll.UTILITY.MaintDsgnBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;


import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;

public class MaintDsgnBusinessObject extends BaseBO 
{
  public MaintDsgnBusinessObject()
  {
  }
  
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("HraAllScreen"))
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
  
  public RecordMetaInfo getDsgnDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
    //  oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDsgnCount(?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getDsgnDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintDsgnBean oMaintDsgnBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oHraRateDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetDsgnDetail(?,?,?,?,?)");
      
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
            oHraRateDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintDsgnBean = new MaintDsgnBean();
          oMaintDsgnBean.setTxtDsgnDesc((oRow.get("DSGN_DESC").getString()));
          oMaintDsgnBean.setStatus("Q");
          oMaintDsgnBean.setTxtCtgry(oRow.get("CTGRY").getString());
          oMaintDsgnBean.setTxtPayScaleCode((oRow.get("PAY_SCALE_CODE").getString()));
          oMaintDsgnBean.setTxtPayScaleDesc((oRow.get("PAY_SCALE_DESC").getString()));
          oMaintDsgnBean.setTxtBoardFlg(oRow.get("BOARD_FLG").getString());          
          oMaintDsgnBean.setTxtDsgnId((oRow.get("DSGN_ID").getString()));
          
          oHraRateDetail.add(oMaintDsgnBean);
        }
        
        
    return oHraRateDetail;
    
  }

public DsgnComboVO getDsgnComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    DsgnComboVO oDsgnComboVO = new DsgnComboVO();
    int count = 0;
    ArrayList oOutArray; //Output 
    ComboVO oComboVO=null;
   
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oDsgnCtgry = null;
   
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
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oDsgnCtgry = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String ctgryLabel = oRow.get("code_sdesc").getString();
          String ctgryValue = oRow.get("gbl_code").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oDsgnCtgry.add(oComboVO);
        }

      
    /* Newly Added */
    oDsgnComboVO.setCtgryList(oDsgnCtgry);
    return oDsgnComboVO;
       
  }


//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("DsgnScreen"))
    {
      saveDsgnDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveDsgnDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        MaintDsgnBean oMaintDsgnBean = (MaintDsgnBean)oIt.next();
//        System.out.println(oMaintHraRateBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMaintDsgnBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertDsgnDetail(?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtDsgnDesc())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtCtgry())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtPayScaleCode())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtBoardFlg())));                    
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintDsgnBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateDsgnDetail(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtDsgnId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtDsgnDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtCtgry())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtPayScaleCode())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtBoardFlg())));                    
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
       
        }
        else if(oMaintDsgnBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteDsgnDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtDsgnId())));
      //    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtTypeofCity())));
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
    // checkDsgn(oDetailBeanArray,oList);
     reportError(oList);
    
    
  }
  

  private void checkDsgn(ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
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
        MaintDsgnBean  oMaintDsgnBean  = (MaintDsgnBean)oIt.next();
//        System.out.println(oMaintHraRateBean.getStatus());

        if(!(oMaintDsgnBean.getStatus().equals("D")))
          count++;


        if(oMaintDsgnBean.getStatus().equals("N"))    
        {
          String pcode = oMaintDsgnBean.getTxtDsgnDesc();
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtDsgnDesc())));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_DsgnCheck(?,?,?)");
      
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
  
  public LovVO getPayScaleCodeLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
          LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Pay Scale Code");   
    arylstHeaderNames.add("Pay Scale Description");   
    oLovVO.setHeaderList(arylstHeaderNames);
  
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,""));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetDsgnPayScaleCodelov(?,?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("PAY_SCALE_CODE").getString());            
       oLOVBean.setDetailField2(oRow.get("PAY_SCALE_DESC").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }  
}