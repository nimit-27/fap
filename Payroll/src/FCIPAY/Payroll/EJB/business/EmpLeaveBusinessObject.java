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
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLeaveComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLeaveDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintEmpLeaveBean;
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
public class EmpLeaveBusinessObject extends BaseBO 
{
  public EmpLeaveBusinessObject()
  {
  }
  
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("LeaveScreen"))
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
  
  public RecordMetaInfo getEmpLeaveDetailMetaInfo(String sPrimaryKey,EmpLeaveDetailInfo oEmpLeaveDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    
      oParameters = new ArrayList();
      String loginLoc=oEmpLeaveDetailInfo.getLoginLocCode()+"";
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,loginLoc));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getTxtYYMM()));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getTxtToYYMM()));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpLeaveCount(?,?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getEmpLeaveDetails(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,EmpLeaveDetailInfo oEmpLeaveDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean(); 
    int count = 0;
    ArrayList oOutArray; //Output 
    MaintEmpLeaveBean oMaintEmpLeaveBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oEmpLeaveDetail = null;

      String loginLoc=oEmpLeaveDetailInfo.getLoginLocCode()+"";
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,loginLoc));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getTxtYYMM()));
      oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getTxtToYYMM()));
      oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,oEmpLeaveDetailInfo.getHdnEmpLbrFlag()));
      oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpLeaveDetail(?,?,?,?,?,?,?,?,?,?)");
      
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
            oEmpLeaveDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMaintEmpLeaveBean = new MaintEmpLeaveBean();
          oMaintEmpLeaveBean.setTxtEmpCode(oRow.get("EMP_NO").getString()); 
          oMaintEmpLeaveBean.setTxtLeaveDesc((oRow.get("LEAVE_DESC").getString()));
          oMaintEmpLeaveBean.setStatus("Q");
          oMaintEmpLeaveBean.setTxtLeaveTyp(oRow.get("LEAVE_TYP").getString());
          oMaintEmpLeaveBean.setTxtFrom((EnrgiseUtil.convertToString(oRow.get("FROM_DT").getDate())));
          oMaintEmpLeaveBean.setTxtTo(EnrgiseUtil.convertToString(oRow.get("TO_DT").getDate()));          
          oMaintEmpLeaveBean.setTxtEmpLeaveId((oRow.get("EMP_LEAVE_ID").getString()));
          oMaintEmpLeaveBean.setTxtEmpName((oRow.get("EMP_NAME").getString()));
          oMaintEmpLeaveBean.setHdnProcYYMM("");
          oMaintEmpLeaveBean.setHdnSalProc("");
            //by shivani
            oMaintEmpLeaveBean.setTxtGender(oRow.get("GENDER").getString());
            
          String cancelStatus=oRow.get("cancel_flag").getString();
          String cancelDate=EnrgiseUtil.convertToString(oRow.get("cancel_date").getDate());
          String revLeave=oRow.get("REV_LEAVE_TYP").getString();
          if(cancelStatus.equals("C"))
            oMaintEmpLeaveBean.setCancelStatus("Cancelled on "+cancelDate);
          else if(cancelStatus.equals("R"))
            oMaintEmpLeaveBean.setCancelStatus("Revised to "+revLeave+" on "+cancelDate);
          else
            oMaintEmpLeaveBean.setCancelStatus("");
          oMaintEmpLeaveBean.setTxtRevLeaveTyp(revLeave);  
          
          //  added by varalika on 30-Sep-2011
          
          oMaintEmpLeaveBean.setTxtCreationDate(oRow.get("created_dt").getDate().toString());
          oMaintEmpLeaveBean.setTxtCreatedBy(oRow.get("created_user").getString());
          oMaintEmpLeaveBean.setTxtCreatedSite(oRow.get("created_site").getString());
          if(oRow.get("modified_dt").getDate() != null && !"".equals(oRow.get("modified_dt").getDate()))
          {
          oMaintEmpLeaveBean.setTxtUpdationDate(oRow.get("modified_dt").getDate().toString());
          }
          if(oRow.get("modified_user").getString() != null && !"".equals(oRow.get("modified_user").getString()))
          {
          oMaintEmpLeaveBean.setTxtUpdatedBy(oRow.get("modified_user").getString());
          }
           if(oRow.get("modified_site").getString() != null && !"".equals(oRow.get("modified_site").getString()))
          {
          oMaintEmpLeaveBean.setTxtUpdatedSite(oRow.get("modified_site").getString());
          }
          //  ended by varalika
          
          oEmpLeaveDetail.add(oMaintEmpLeaveBean);
        }
        
    return oEmpLeaveDetail;
    
  }

public EmpLeaveComboVO getEmpLeaveComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    EmpLeaveComboVO oEmpLeaveComboVO = new EmpLeaveComboVO();
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetLeaveTyp(?,?)");
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
          String ctgryValue = oRow.get("gbl_code").getString();
          oComboVO = new ComboVO(ctgryLabel,ctgryValue);
          oDsgnCtgry.add(oComboVO);
        }
    
    oEmpLeaveComboVO.setLvTypList(oDsgnCtgry);       
    ArrayList oPromTypeListDPS = new ArrayList();
    oPromTypeListDPS = getDEPLveComboRecords("PAYROLL_PKG.proc_GetLeaveTyp_dept(?,?)","promType_id","promType_desc");    
    oEmpLeaveComboVO.setLvDepTypList(oPromTypeListDPS);
    return oEmpLeaveComboVO;
       
  }
private ArrayList getDEPLveComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
{
          DBUtilitiesBean oBean = new DBUtilitiesBean();
          ArrayList oParameters = new ArrayList();
          ArrayList oOutArray;
          //EmpFinanceComboVO oEmpFin=null;
          QueryValue oValue = null;
          ArrayList oList = null;
          Iterator oIt = null;
          QueryRow oRow = null;    
          int count = 0;
          
          
          
          oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
          oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
          
          oOutArray = oBean.callProc(oParameters,sProc);
          
          oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
          if(oList.size() == 0)
          {        
          throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
          }
          
          count = 0;
          oIt = oList.iterator();
          ArrayList oValueList = null;
          while(oIt.hasNext())
          {
          if(count == 0)
          {
           oValueList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();        
          String fieldId = ((oRow.get(sField_id).getString()));
          String fieldDesc= ((oRow.get(sField_desc).getString()));
          ComboVO oComboVO = new ComboVO(fieldDesc,fieldId);
          oValueList.add(oComboVO);    
          }
          return oValueList;
          
  }     




//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    if(sScreenName.equals("LeaveScreen"))
    {
      saveEmpLeaveDetails(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
    }
    
  }
  
  private void saveEmpLeaveDetails(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    boolean bCancel = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    DBUtilitiesBean oBeanCancel = null;
    DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MaintEmpLeaveBean oMaintEmpLeaveBean = (MaintEmpLeaveBean)oIt.next();
        if(oMaintEmpLeaveBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertEmpLeaveDetail(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
           oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtEmpCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtLeaveDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtLeaveTyp())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtFrom())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtTo()))); 
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMaintEmpLeaveBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateEmpLeaveDetail(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtEmpLeaveId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtLeaveDesc())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtLeaveTyp())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtFrom())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtTo())));                    
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));

          oBean.addToBatch(oParameters);
       
        }
        else if(oMaintEmpLeaveBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteEmpLeaveDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtEmpLeaveId())));
      //    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtTypeofCity())));
          oBeanDelete.addToBatch(oParameters);          
        }
        else if(oMaintEmpLeaveBean.getStatus().equals("C"))
        {
          if(!bCancel)
          {
            oBeanCancel = new DBUtilitiesBean();
            oBeanCancel.createBatch("PAYROLL_PKG.proc_CancelLeave(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtEmpLeaveId())));
      //    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintDsgnBean.getTxtTypeofCity())));
          oBeanCancel.addToBatch(oParameters); 
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
      if(bCancel)
      {
        oBeanCancel.executeBatch();
      }

      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
  }


  public String cancelLeave(String sHeaderPrimaryKey,DummyHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
      ArrayList oList = new ArrayList();
      checkMaxPayYear(oDummyHeaderBean,oList);
      reportError(oList);
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBeanCancel = null;
      Iterator oIt = oDetailBeanArray.iterator();
      ArrayList oOutArray;
      while(oIt.hasNext())
      {
        MaintEmpLeaveBean oMaintEmpLeaveBean = (MaintEmpLeaveBean)oIt.next();
         if(oMaintEmpLeaveBean.getStatus().equals("C")|| oMaintEmpLeaveBean.getStatus().equals("R"))
        {
         
          oBeanCancel = new DBUtilitiesBean();
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtEmpLeaveId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getStatus())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtRevLeaveTyp())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBeanCancel.callProc(oParameters,"PAYROLL_PKG.proc_RevCancelLeave(?,?,?,?,?,?,?)",true,true);
          String oErrMsg = (String)((DBObject)oOutArray.get(0)).getObject();
          Integer oErrCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          if(!oErrCode.equals(new Integer(0)))
          {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oErrMsg));
            System.out.println("Error!!! while Updating Employee ::"+oErrMsg);
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
          }
        }
      }
      return "";
  }
  
public String convertLeave(String sHeaderPrimaryKey,DummyHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
 {
      ArrayList oList = new ArrayList();
      checkMaxPayYear(oDummyHeaderBean,oList);
      reportError(oList);
      
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBeanCancel = null;
      Iterator oIt = oDetailBeanArray.iterator();
      ArrayList oOutArray;
      while(oIt.hasNext())
      {
        MaintEmpLeaveBean oMaintEmpLeaveBean = (MaintEmpLeaveBean)oIt.next();
        if(oMaintEmpLeaveBean.getStatus().equals("V"))
        {
          oBeanCancel = new DBUtilitiesBean();
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtEmpCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtEmpLeaveId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getStatus())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintEmpLeaveBean.getTxtLeaveTyp())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
          oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBeanCancel.callProc(oParameters,"PKG_PAYROLL_MISC.proc_convertLeave(?,?,?,?,?,?,?,?,?)",true,true);
          String oErrMsg = (String)((DBObject)oOutArray.get(0)).getObject();
          Integer oErrCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          if(!oErrCode.equals(new Integer(0)))
          {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(oErrMsg));
            System.out.println("Error!!! while Updating Employee ::"+oErrMsg);
            throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments);
          }
        }
      }
      return "";
  }
 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(bDetailDataChanged)
    {
      ArrayList oList = new ArrayList();
      checkDuplicateDetail(oDetailBeanArray,oList);
      reportError(oList);
      oList = new ArrayList();
      checkMaxPayYear(oBaseHeaderBean,oList);
      reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    //  ArrayList oList = new ArrayList();
    //  checkMaxPayYear(oBaseHeaderBean,oList);
  }
  
  private void checkDuplicateDetail(ArrayList oDetailBeanArray,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    String oFlag = null;
    Iterator oIt = null;
      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MaintEmpLeaveBean  oMaintEmpLeaveBean  = (MaintEmpLeaveBean)oIt.next();
//        System.out.println(oMaintHraRateBean.getStatus());
          count++;
          String pEmpNum = oMaintEmpLeaveBean.getTxtEmpCode();
          String pCode = oMaintEmpLeaveBean.getTxtEmpLeaveId();
          String pFromDt = oMaintEmpLeaveBean.getTxtFrom();
          String pToDt = oMaintEmpLeaveBean.getTxtTo();
          if(oMaintEmpLeaveBean.getStatus().equals("N") || oMaintEmpLeaveBean.getStatus().equals("U"))
          {
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(pCode)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(pEmpNum)));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(pFromDt)));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(pToDt)));
              oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
              oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
              oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_LeaveCheck(?,?,?,?,?,?)");
          
                oFlag = (String)((DBObject)oOutArray.get(0)).getObject();
                if(oFlag.equals("0"))
                {        
                  ArrayList oArguments = new ArrayList();
                  oArguments.add(new Integer(count));
                  oList.add(new EnrgiseApplicationException("Payroll.EmpLeave.duplicatecheck",oArguments));
                }
          }
        }
      }
  
  public LovVO getEmpLeaveLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
    arylstHeaderNames.add("CPF Code"); 
     arylstHeaderNames.add("Gender");// added by Avtar on 11-03-2013 
    
   // arylstHeaderNames.add("Middle Name");    
  //  arylstHeaderNames.add("Last Name");    
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);        // added by dushyant on 30-09-2010 for cpf code
    arylstVisibility.add(EnrgiseConstants.VISIBLE); // added by Avtar on 11-03-2013 
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
  //  arylstVisibility.add(EnrgiseConstants.VISIBLE);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      // added by dushyant on 30-09-2010 for cpf code
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));      
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    
    //same procedure as used in Employee Info Master-- dt 15 Oct 2007
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getempleavelov(?,?,?,?,?,?,?)");
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
      
        oLOVBean.setDetailField1(oRow.get("EMP_NUM").getString());            
        oLOVBean.setDetailField2(oRow.get("EMPNAME").getString());   
        oLOVBean.setDetailField3(oRow.get("CPF_CODE").getString());   // added by dushyant on 30-09-2010 for cpf code
        oLOVBean.setDetailField4(oRow.get("Gender").getString()); // added by Avtar on 11-03-2013 
    
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;

  }


  private void checkMaxPayYear(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    
     DummyHeaderBean oDummyHeaderBean = (DummyHeaderBean)oBaseHeaderBean;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getHdnEmpLbrFlag())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
      
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();


            oIt = oRetList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              String sRevYear = oRow.get("yymm").getString(); 
              String status = oRow.get("arc_flag").getString(); 

              if(status!=null && status.equals("Y"))
              {
                  ArrayList oArguments = new ArrayList();
                  oList.add(new EnrgiseApplicationException("Payroll.Status.Leave.Check"));                
              }
             }

            }    
  
}