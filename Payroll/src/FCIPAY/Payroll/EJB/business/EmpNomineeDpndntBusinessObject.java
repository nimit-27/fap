package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCAComboVO;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.EmpDepndntBean;
import FCIPAY.Payroll.UTILITY.EmpNomineeBean;
import FCIPAY.Payroll.UTILITY.EmpDpndntNomHeaderBean;
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

public class EmpNomineeDpndntBusinessObject extends BaseBO
{
  public EmpNomineeDpndntBusinessObject()
  {
  }

  public void initializeBOImpl(String sScreenName)
  {
      String sDetailTable = null;
      if(sScreenName.equals("EmpDependentScreen"))
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
      DummyQueryVO abc = new DummyQueryVO();      
      oParameters = new ArrayList();      
      return null;
    
  }

//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  {      
      if(sScreenName.equals("EmpDependentScreen"))
      {      
          saveEmpDependentDetail(sHeaderPrimaryKey,(EmpDpndntNomHeaderBean)oBaseHeaderBean, oDetailBeanArray);
      }
      
      if(sScreenName.equals("EmpNomineeScreen"))
      {       
          saveEmpNomineeDetail(sHeaderPrimaryKey,(EmpDpndntNomHeaderBean)oBaseHeaderBean,oDetailBeanArray);
      }  
      
      if(sScreenName.equals("EmpGratuityScreen"))
      {       
          saveGratuityDetail(sHeaderPrimaryKey,(EmpDpndntNomHeaderBean)oBaseHeaderBean,oDetailBeanArray);
      } 
  }
  
  private void saveEmpDependentDetail(String sHeaderPrimaryKey,EmpDpndntNomHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
          EmpDepndntBean oEmpDepndntBean= (EmpDepndntBean)oIt.next();          
          if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
          {
              if(!bInsert)
              {
                  oBeanInsert = new DBUtilitiesBean();
                  oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertEmpDependentDetail(?,?,?,?,?,?,?,?)");
                  bInsert = true;
              }      
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String(sHeaderPrimaryKey)));                                  
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntName())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntAge())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntRel())));   
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpDepndntBean.getTxtDepndntEffFrom())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpDepndntBean.getTxtDepndntEffTill())));            
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));             
              oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));                
              oBeanInsert.addToBatch(oParameters);
          }
          else if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
          {
              if(!bUpdate)
              {
                  oBean = new DBUtilitiesBean();
                  oBean.createBatch("PAYROLL_PKG.proc_UpdateEmpDependentDetail(?,?,?,?,?,?,?,?)");
                  bUpdate = true;
              }
              oParameters = new ArrayList();  
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));                                  
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntId())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntName())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntAge())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntRel())));        
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpDepndntBean.getTxtDepndntEffFrom())));          
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oEmpDepndntBean.getTxtDepndntEffTill())));              
              oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));                         
            //  oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));                    
              oBean.addToBatch(oParameters);          
          }
          else if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
          {
              if(!bDelete)
              {
                  oBeanDelete = new DBUtilitiesBean();
                  oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteEmpDependentDetail(?,?)");
                  bDelete = true;
              }
              oParameters = new ArrayList();                            
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntId())));
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
  
  private void saveEmpNomineeDetail(String sHeaderPrimaryKey,EmpDpndntNomHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
          EmpDepndntBean oEmpDepndntBean = (EmpDepndntBean)oIt.next();          
          if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
          {
              if(!bInsert)
              {
                  oBeanInsert = new DBUtilitiesBean();
                  oBeanInsert.createBatch("PAYROLL_PKG.proc_InsertEmpNomineeDetail(?,?,?,?,?,?,?)");
                  bInsert = true;
              }      
              oParameters = new ArrayList();
              
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntName())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntAge())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntRel())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtNomineeShare())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntGuard())));
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));              
              oBeanInsert.addToBatch(oParameters);
          }
          else if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
          {
              if(!bUpdate)
              {
                  oBean = new DBUtilitiesBean();
                  oBean.createBatch("PAYROLL_PKG.proc_UpdateEmpNomineeDetail(?,?,?,?,?,?,?,?)");
                  bUpdate = true;
              }
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtNomineeId())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntName())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntAge())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntRel())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtNomineeShare())));
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtDepndntGuard())));
              oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
              //  oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
              oBean.addToBatch(oParameters);          
          }
          else if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
          {
              if(!bDelete)
              {
                  oBeanDelete = new DBUtilitiesBean();
                  oBeanDelete.createBatch("PAYROLL_PKG.proc_DeleteEmpNomineeDetail(?,?)");
                  bDelete = true;
              }
              oParameters = new ArrayList();              
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtNomineeId())));
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
  
 // added by dushyant on 13-10-2010 for saving gratuity details
 
 private void saveGratuityDetail(String sHeaderPrimaryKey,EmpDpndntNomHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException
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
          EmpDepndntBean oEmpDepndntBean = (EmpDepndntBean)oIt.next();          
          if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
          {
              if(!bInsert)
              {
                  oBeanInsert = new DBUtilitiesBean();
                  oBeanInsert.createBatch("PAYROLL_PKG_EXT.proc_InsertEmpGratuityDetail(?,?,?,?,?,?,?)");
                  bInsert = true;
              }      
              oParameters = new ArrayList();
              
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityName())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityAge())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityRel())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityShare())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratGuardian())));
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));              
              oBeanInsert.addToBatch(oParameters);
          }
          else if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
          {
              if(!bUpdate)
              {
                  oBean = new DBUtilitiesBean();
                  oBean.createBatch("PAYROLL_PKG_EXT.proc_UpdateEmpGratuityDetail(?,?,?,?,?,?,?,?)");
                  bUpdate = true;
              }
              oParameters = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityId())));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityName())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityAge())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityRel())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityShare())));
              oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratGuardian())));
              oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtUserID())));
              //  oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oBaseHeaderBean.getTxtSiteID())));
              oBean.addToBatch(oParameters);          
          }
          else if(oEmpDepndntBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
          {
              if(!bDelete)
              {
                  oBeanDelete = new DBUtilitiesBean();
                  oBeanDelete.createBatch("PAYROLL_PKG_EXT.proc_DeleteEmpGratuityDetail(?,?)");
                  bDelete = true;
              }
              oParameters = new ArrayList();              
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(sHeaderPrimaryKey)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oEmpDepndntBean.getTxtGratuityId())));
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
 // end by dushyant
  
  public RecordMetaInfo getEmpDepndntDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));      
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpDepndntCount(?,?,?,?)");   // dependent count (*)
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
  public ArrayList getEmpDepndntDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      EmpDepndntBean oEmpDepndnt;
      
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oEmpDepndntDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpDepndntDetail(?,?,?,?,?)");
      
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
              oEmpDepndntDetail = new ArrayList();          
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oEmpDepndnt = new EmpDepndntBean();   
          oEmpDepndnt.setTxtDepndntName((oRow.get("dependent_name").getString()));   
          oEmpDepndnt.setTxtDepndntId((oRow.get("emp_dpndnt_id").getString()));   
          oEmpDepndnt.setStatus("Q");
          oEmpDepndnt.setTxtDepndntAge(oRow.get("dependent_age").getString());  
          oEmpDepndnt.setTxtDepndntRel(oRow.get("dependent_rel").getString());          
          oEmpDepndnt.setTxtDepndntEffFrom(EnrgiseUtil.convertToString(oRow.get("eff_from").getDate()));
          oEmpDepndnt.setTxtDepndntEffTill(EnrgiseUtil.convertToString(oRow.get("eff_till").getDate()));
          oEmpDepndntDetail.add(oEmpDepndnt);
      }        
      return oEmpDepndntDetail;    
  }

  public RecordMetaInfo getEmpNomineeDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpNomineeCount(?,?,?,?)");      // nominee count (*)
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  } 
  
  // added by dushyant on 13-10-2010 for gratuity header count
  
  public RecordMetaInfo getEmpGratuityDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,sPrimaryKey));
      oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpGratuityCount(?,?,?,?)");      // gratuity count (*)
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }
  
// end for gratuity header
 
  public ArrayList getEmpNomineeDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      EmpDepndntBean oEmpDepndnt;
      
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oEmpNomineeDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetEmpNomineeDetail(?,?,?,?,?)");
      
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
              oEmpNomineeDetail = new ArrayList();          
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oEmpDepndnt = new EmpDepndntBean();          
          oEmpDepndnt.setTxtDepndntName((oRow.get("nominee_name").getString()));          
          oEmpDepndnt.setTxtNomineeId((oRow.get("emp_nominee_id").getString()));          
          oEmpDepndnt.setStatus("Q");
          oEmpDepndnt.setTxtDepndntAge(oRow.get("nominee_age").getString());  
          oEmpDepndnt.setTxtDepndntRel(oRow.get("nominee_rel").getString()); 
          oEmpDepndnt.setTxtDepndntGuard((oRow.get("GUARDIAN_DETAILS").getString()));
          oEmpDepndnt.setTxtNomineeShare(oRow.get("nominee_share").getString()); 
          oEmpNomineeDetail.add(oEmpDepndnt);
      }        
      return oEmpNomineeDetail;
    
  }

// added by dushaynt on 13-10-2010 for gratuity detail

 public ArrayList getEmpGratuityDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
      ArrayList oParameters = new ArrayList(); //Input Parameters
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      int count = 0;
      ArrayList oOutArray; //Output 
      EmpDepndntBean oEmpDepndnt;
      
      QueryRow oRow = null;
      QueryValue oValue = null;
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList oEmpNomineeDetail = null;
      
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, sPrimaryKey));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetEmpGratuityDetail(?,?,?,?,?)");
      
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
              oEmpNomineeDetail = new ArrayList();          
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oEmpDepndnt = new EmpDepndntBean();          
          oEmpDepndnt.setTxtGratuityName((oRow.get("nominee_name").getString()));          
          oEmpDepndnt.setTxtGratuityId((oRow.get("emp_nominee_id").getString()));          
          oEmpDepndnt.setStatus("Q");
          oEmpDepndnt.setTxtGratuityAge(oRow.get("nominee_age").getString());  
          oEmpDepndnt.setTxtGratuityRel(oRow.get("nominee_rel").getString()); 
          oEmpDepndnt.setTxtGratGuardian(oRow.get("GUARDIAN_DETAILS").getString()); 
          oEmpDepndnt.setTxtGratuityShare(oRow.get("nominee_share").getString()); 
          oEmpNomineeDetail.add(oEmpDepndnt);
      }        
      return oEmpNomineeDetail;
    
  } 
  
// end by dushaynt on 13-10-2010 for gratuity detail
  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  } 
  
  //  lov query for all
  public LovVO getQueryNomieeEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");  
    arylstHeaderNames.add("Designation");
    arylstHeaderNames.add("Category");
    arylstHeaderNames.add("Date of Retirement");
    arylstHeaderNames.add("Status");
    arylstHeaderNames.add("Employee Type");
    arylstHeaderNames.add("Staff Code");
    arylstHeaderNames.add("Date of Joining");
    arylstHeaderNames.add("CPF Code");
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("txtSiteID"))).trim()));   
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,(new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))).trim()));         
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    //oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_QueryEmpDtlLOV(?,?,?,?,?,?,?)");
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_QueryDpndEmpDtlLOV(?,?,?,?,?,?,?)");
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
      
        oLOVBean.setDetailField1(oRow.get("EMP_NO").getString());            
        oLOVBean.setDetailField2(oRow.get("Name").getString());  
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString()); 
        oLOVBean.setDetailField4(oRow.get("category").getString()); 
        oLOVBean.setDetailField5(EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
        oLOVBean.setDetailField6(oRow.get("status").getString()); 
        oLOVBean.setDetailField7(oRow.get("emptype").getString()); 
        oLOVBean.setDetailField8(oRow.get("staff_code").getString()); 
        oLOVBean.setDetailField9(EnrgiseUtil.convertToString(oRow.get("comp_joining_date").getDate())); 
        oLOVBean.setDetailField10(oRow.get("cpf_code").getString());        
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }
  
  public RecordMetaInfo getDpndntNomineeHeaderMetaInfo(DummyQueryVO oDummyQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String locCode = oDummyQueryVO.getLoginLocCode()+"";
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getDpndntNomHeaderCount(?,?,?,?,?,?)");
 
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
    
  }

  public ArrayList getDpndntNomineeHeader(DummyQueryVO oDummyQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oDummyQueryVO == null)
    {
      oDummyQueryVO = new DummyQueryVO();
    }
      String locCode = oDummyQueryVO.getLoginLocCode()+"";    
      ArrayList oOutArray; //Output 
      ArrayList oHeaderList = null;

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));      
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyQueryVO.getHeaderPrimaryKey())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oDummyQueryVO.getHdnEmpLbrFlag())));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getDpndntNomHeaderDtl(?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());      

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      EmpDpndntNomHeaderBean oEmpDpndntNomHeaderBean;
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
          oEmpDpndntNomHeaderBean = new EmpDpndntNomHeaderBean();
          oEmpDpndntNomHeaderBean.setHeaderPrimaryKey(oRow.get("EMP_NO").getString());          
          oEmpDpndntNomHeaderBean.setTxtEmpName(oRow.get("Name").getString());   
          oEmpDpndntNomHeaderBean.setTxtDsgnDesc(oRow.get("dsgn_desc").getString());
          oEmpDpndntNomHeaderBean.setTxtCategDesc(oRow.get("category").getString());
          oEmpDpndntNomHeaderBean.setTxtCpfCode(oRow.get("cpf_code").getString());
          oEmpDpndntNomHeaderBean.setTxtDOJSite(EnrgiseUtil.convertToString(oRow.get("comp_joining_date").getDate()));
          oEmpDpndntNomHeaderBean.setTxtEmpType(oRow.get("emptype").getString());
          oEmpDpndntNomHeaderBean.setTxtEmpStatus(oRow.get("status").getString());    
          oEmpDpndntNomHeaderBean.setTxtDOR(EnrgiseUtil.convertToString(oRow.get("retirement_date").getDate()));
          oHeaderList.add(oEmpDpndntNomHeaderBean);
      }              
    return oHeaderList;
  } 


}