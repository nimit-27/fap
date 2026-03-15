package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintDaRatesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlWashBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlMHSDedBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlovrtimeBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlprojBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlUpgradeBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.SysadminSql;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class MiscParamBusinessObject extends BaseBO
{
  public MiscParamBusinessObject()
  {
  }


  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
        
    if(sScreenName.equals("MiscWashParamScreen"))
    {
      sDetailTable = "aaa_myadd";
    }
    initializeBO("aaa_myself",sDetailTable);
  }


  public void saveOther(String sPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
        MiscellaneousParamDtlOtherBean oMiscellaneousParamDtlOtherBean = (MiscellaneousParamDtlOtherBean)oIt.next();
//        System.out.println(oMiscellaneousParamDtlprojBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMiscellaneousParamDtlOtherBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayFixedMiscParam(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getHdnAllowTyp())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtAllow())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getHdnAllowDtl())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtPayCode())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMiscellaneousParamDtlOtherBean.getTxtStartDt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMiscellaneousParamDtlOtherBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdatePayFixedMiscParam(?,?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getHdnAllowTyp())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtAllow())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getHdnAllowDtl())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtPayCode())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMiscellaneousParamDtlOtherBean.getTxtStartDt())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMiscellaneousParamDtlOtherBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayFixedMiscParam(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getDetailId())));
          oBeanDelete.addToBatch(oParameters);          
        }
      }
      
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


  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
  
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    return "";
  }
  
  public MiscComboVO getMiscComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MiscComboVO oMiscComboVO = new MiscComboVO();


    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
      
  /*    oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_getCadreDetails(?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
          throw new EnrgiseApplicationException("wenrgise.common.norecordfound",EnrgiseConstants.MESSAGE);
        }
        
        count = 0;
        oIt = oList.iterator();
        ArrayList oCadreList = null;
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oCadreList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String cadreId = ((oRow.get("cadre_id").getString()));
          String cadreDesc= ((oRow.get("cadre_desc").getString()));
          ComboVO oComboVO = new ComboVO(cadreDesc,cadreId);
          oCadreList.add(oComboVO);
        }
*/

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
        ArrayList oCategList = null;
        while(oIt.hasNext())
        {
          if(count == 0)
          {
            oCategList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          String categId = ((oRow.get("gbl_code").getString()));
          String categDesc= ((oRow.get("code_sdesc").getString()));
          ComboVO oComboVO = new ComboVO(categDesc,categId);
          oCategList.add(oComboVO);
        }        

/*

     oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayScaleGrade(?,?)");
      
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
//          oEmpFin = new EmpFinanceComboVO();
          String payScaleCode = ((oRow.get("pay_scale_code").getString()));
          ComboVO oComboVO = new ComboVO(payScaleCode,payScaleCode);
          oPayScaleList.add(oComboVO);
        }        
 */
        
        oMiscComboVO.setCategList(oCategList);        
    //    oWash.setCadreList(oCadreList);
   //     oWash.setPayScaleList(oPayScaleList);       
        return oMiscComboVO;
  }


  public RecordMetaInfo getProjDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMiscProjCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getProjDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MiscellaneousParamDtlprojBean oProj;


    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oProjDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetProjDetail(?,?,?,?,?)");
      
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
            oProjDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oProj = new MiscellaneousParamDtlprojBean();
          oProj.setStartField((oRow.get("AMOUNT_FROM").getString()));
          oProj.setEndField((oRow.get("AMOUNT_TO").getString()));
          oProj.setStatus("Q");
          oProj.setTxtProjAllow(oRow.get("PROJ_ALLOW").getString());
          oProj.setTxtProjSrl(oRow.get("SRL_NO").getString());
          oProjDetail.add(oProj); 
        }
        
        
    return oProjDetail;
    
  }


  public RecordMetaInfo getOTimeDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMiscOTimeCount(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getOTimeDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MiscellaneousParamDtlovrtimeBean oTime;


    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oTimeDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetOTimeDetail(?,?,?,?,?)");
      
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
            oTimeDetail = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oTime = new MiscellaneousParamDtlovrtimeBean();
          oTime.setStartField((oRow.get("AMOUNT_FROM").getString()));
          oTime.setEndField((oRow.get("AMOUNT_TO").getString()));
          oTime.setStatus("Q");
          oTime.setTxtOvrTimeAllow(oRow.get("OVER_TIME_ALLOW").getString());
          oTime.setTxtOverSrl(oRow.get("SRL_NO").getString());
          oTimeDetail.add(oTime); 
        }
        
        
    return oTimeDetail;
    
  }


  public RecordMetaInfo getMHSDedDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPayFixedMhsDedMst(?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getMHSDedDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    MiscellaneousParamDtlMHSDedBean oMHSDedBean;


    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oMHSDedDtl = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayFixedMhsDedMst(?,?,?,?,?)");
      
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
            oMHSDedDtl = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oMHSDedBean = new MiscellaneousParamDtlMHSDedBean();
          oMHSDedBean.setTxtCtgry((oRow.get("CTGRY").getString()));
          oMHSDedBean.setStatus("Q");
          oMHSDedBean.setTxtStartDt(EnrgiseUtil.convertToString(oRow.get("START_DT").getDate()));
          oMHSDedBean.setTxtEndDt(oRow.get("END_DT").getString());
          oMHSDedBean.setTxtAllow(oRow.get("ALLOW").getString());
          oMHSDedBean.setDetailId(oRow.get("MHS_MST_ID").getString());
          oMHSDedDtl.add(oMHSDedBean); 
        }
        
        
    return oMHSDedDtl;
    
  }

  public RecordMetaInfo getOtherDetailMetaInfo(String sPrimarykey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
//      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_CountPayFixedMiscParam(?,?,?)");

      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getOtherDetail(String sPrimarykey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;
   
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;



      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
//      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintAnnIncQueryVO.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetPayFixedMiscParam(?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      MiscellaneousParamDtlOtherBean oMiscellaneousParamDtlOtherBean;
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
          oMiscellaneousParamDtlOtherBean = new MiscellaneousParamDtlOtherBean();
          oMiscellaneousParamDtlOtherBean.setDetailId(oRow.get("ALLOW_ID").getString());
          oMiscellaneousParamDtlOtherBean.setHdnAllowTyp(oRow.get("ALLOW_TYPE").getString());
          oMiscellaneousParamDtlOtherBean.setTxtPayCode(oRow.get("PAYCODE").getString());
          oMiscellaneousParamDtlOtherBean.setHdnAllowDtl(oRow.get("ALLOW_DTL").getString());
          oMiscellaneousParamDtlOtherBean.setTxtAllow(oRow.get("ALLOW").getString());
          oMiscellaneousParamDtlOtherBean.setTxtStartDt(EnrgiseUtil.convertToString(oRow.get("START_DT").getDate()));
          oMiscellaneousParamDtlOtherBean.setStatus("Q");
          oHeaderList.add(oMiscellaneousParamDtlOtherBean);
      }
      
        
    return oHeaderList;
  }

  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
      if(sScreenName.equals("MiscMHSDedScreen"))
      {
        saveMHSDed(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
      }
      if(sScreenName.equals("MiscOTAScreen"))
      {
        saveOTime(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
      }
      if(sScreenName.equals("MiscMedReimbScreen"))
      {
        saveProj(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
      }
       if(sScreenName.equals("MiscOtherParamScreen"))
      {
        saveOther(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
      }
  }

  private void saveProj(String sPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;

        DummyHeaderBean oMiscellaneousParamDtlOtherBean = (DummyHeaderBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MiscellaneousParamDtlprojBean oMiscellaneousParamDtlprojBean = (MiscellaneousParamDtlprojBean)oIt.next();
//        System.out.println(oMiscellaneousParamDtlprojBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMiscellaneousParamDtlprojBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertProjDetail(?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getStartField())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getEndField())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getTxtProjAllow())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMiscellaneousParamDtlprojBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateProjDetail(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getTxtProjSrl())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getStartField())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getEndField())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getTxtProjAllow())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMiscellaneousParamDtlprojBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteProjDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlprojBean.getTxtProjSrl())));
          oBeanDelete.addToBatch(oParameters);          
        }
      }
      
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

  private void saveOTime(String sPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;


        DummyHeaderBean oMiscellaneousParamDtlOtherBean = (DummyHeaderBean)oBaseHeaderBean;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MiscellaneousParamDtlovrtimeBean oMiscellaneousParamDtlovrtimeBean = (MiscellaneousParamDtlovrtimeBean)oIt.next();
//        System.out.println(oMiscellaneousParamDtlovrtimeBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMiscellaneousParamDtlovrtimeBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertOTimeDetail(?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getStartField())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getEndField())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getTxtOvrTimeAllow())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMiscellaneousParamDtlovrtimeBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdateOTimeDetail(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getTxtOverSrl())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getStartField())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getEndField())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getTxtOvrTimeAllow())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMiscellaneousParamDtlovrtimeBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteOTimeDetail(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlovrtimeBean.getTxtOverSrl())));
          oBeanDelete.addToBatch(oParameters);          
        }
      }
      
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

  private void saveMHSDed(String sPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;

    DummyHeaderBean oMiscellaneousParamDtlOtherBean = (DummyHeaderBean)oBaseHeaderBean;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        MiscellaneousParamDtlMHSDedBean oMHSDedBean = (MiscellaneousParamDtlMHSDedBean)oIt.next();
//        System.out.println(oMiscellaneousParamDtlNdutyBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oMHSDedBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertPayFixedMhsDedMst(?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMHSDedBean.getTxtCtgry())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMHSDedBean.getTxtAllow())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMHSDedBean.getTxtStartDt())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMHSDedBean.getTxtEndDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oMHSDedBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG.proc_UpdatePayFixedMhsDedMst(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMHSDedBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMHSDedBean.getTxtCtgry())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMHSDedBean.getTxtAllow())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMHSDedBean.getTxtStartDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oMHSDedBean.getTxtEndDt())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
        else if(oMHSDedBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG.proc_DeletePayFixedMhsDedMst(?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMHSDedBean.getDetailId())));
          oBeanDelete.addToBatch(oParameters);          
        }
      }
      
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
  
  public LovVO getDARateLOVData(String sSearchField1,String sSearchField2) throws EnrgiseSystemException
  {
    String sQuery = "SELECT DISTINCT YYYYMM FROM PAY_DA_RATE";
    if(!(sSearchField1.equals("")))
    {
      sQuery = sQuery + " WHERE YYYYMM LIKE '%" + sSearchField1 + "%' ";
    }
      sQuery = sQuery + " ORDER BY YYYYMM";
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);
    LovVO oLovVO= new LovVO();
    //Set the header fields
    ArrayList oHeaderList=new ArrayList();
    oHeaderList.add("    YearMonth");
    oLovVO.setHeaderList(oHeaderList);
    
    //Set the detail fields
      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailField1(oRow.get("YYYYMM").getString());
          oList.add(oLOVBean);
      }
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    if(sScreenName.equals("MiscOtherParamScreen"))
    {
      ArrayList oList=new ArrayList();
      checkEffDate(oDetailBeanArray,oList);
      reportError(oList);
    }
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }


  public LovVO getEmpGradeData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Grade_id");        
    arylstHeaderNames.add("Description");    
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
      oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEFUGradecodeLov(?,?)");
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

       oLOVBean.setDetailField1(oRow.get("Grade_id").getString());                  
       oLOVBean.setDetailField2(oRow.get("Grade_DESC").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  private void checkEffDate(ArrayList oDetailBeanArray, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Integer oErrCode = null;
    Iterator oIt = null;

      oIt = oDetailBeanArray.iterator();

      while(oIt.hasNext())
      {
        MiscellaneousParamDtlOtherBean  oMiscellaneousParamDtlOtherBean  = (MiscellaneousParamDtlOtherBean)oIt.next();
//        System.out.println(oMaintHraRateBean.getStatus());

        if(!(oMiscellaneousParamDtlOtherBean.getStatus().equals("D")))
          count++;


        if(oMiscellaneousParamDtlOtherBean.getStatus().equals("U"))    
        {
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getDetailId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMiscellaneousParamDtlOtherBean.getTxtStartDt())));
          oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
          oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
          oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_EffDtCheck(?,?,?,?)");
      
            oErrCode = (Integer)((DBObject)oOutArray.get(0)).getObject();
            if(!oErrCode.equals(new Integer(0)))
            {        
              ArrayList oArguments = new ArrayList();
              oArguments.add(new Integer(count));
              oList.add(new EnrgiseApplicationException("wenrgise.common.effdatecheck",oArguments));
            }
        }
      }
  
  }
  
}