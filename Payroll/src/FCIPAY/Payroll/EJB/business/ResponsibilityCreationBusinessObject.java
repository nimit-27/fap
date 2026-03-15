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
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.UTILITY.ResponsCreaBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ScreenComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RespCreatUpdDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RespcreateQueryVO;
import FCIPAY.Payroll.UTILITY.ResponsibilityCreationHeaderBean;

public class ResponsibilityCreationBusinessObject extends BaseBO 
{
  public ResponsibilityCreationBusinessObject()
  {
  }
  
   public void initializeBOImpl(String sScreenName)
  {
    
  }
   
  public RecordMetaInfo getRespCreatUpdMetaInfo(RespcreateQueryVO oRespcreateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    
    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oRespcreateQueryVO.getTxtRespName())); 
    oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
 
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_RespCreatedHeaderCount(?,?,?,?)");

    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
	oTimeObject  = null;       
	oTotalRecord = null;
	oOutArray    = null;
	oParameters  = null;
    return oRecordMetaInfo;
  }

  public ArrayList getRespCreatHeader(RespcreateQueryVO oRespcreateQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); 
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    ArrayList oHeaderList = null;
    int count = 0;
    if(oRespcreateQueryVO == null)
    {
      oRespcreateQueryVO = new RespcreateQueryVO();
    }

    ArrayList oOutArray;
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oRespcreateQueryVO.getTxtRespName()));      
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_RespCreatedHeader(?,?,?,?,?)");
    
    DBObject oOutObject = (DBObject)oOutArray.get(0);
    oList = (ArrayList)(oOutObject.getObject());

    if(oList.size() == 0)
    {        
      throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
    }
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
        ResponsibilityCreationHeaderBean oResponsibilityCreationHeaderBean= new ResponsibilityCreationHeaderBean();
        oResponsibilityCreationHeaderBean.setHdnRespId(oRow.get("resp_id").getString());
        oResponsibilityCreationHeaderBean.setTxtRespName(oRow.get("resp_name").getString());
        oResponsibilityCreationHeaderBean.setTxtRespEndDt(EnrgiseUtil.convertToString(oRow.get("resp_end_dt").getDate()));
        //oResponsibilityCreationHeaderBean.setLstModule(oRow.get("module_name").getString());
        //oResponsibilityCreationHeaderBean.setLstHeader(oRow.get("header_name").getString());
        oHeaderList.add(oResponsibilityCreationHeaderBean);
        
        oRow = null;
        oResponsibilityCreationHeaderBean = null; 
    } 
    oList = null;
    oIt = null;
    oRespcreateQueryVO = null;
    oOutArray = null;
    oParameters = null;
    oOutObject = null;
    oBean = null;
    return oHeaderList;
  }

  public RecordMetaInfo getRespCreatUpdDtlMetaInfo(String sPrimaryKey, RespCreatUpdDetailInfo oRespCreatUpdDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
    ArrayList oParameters; //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oRespCreatUpdDetailInfo.getTxtRespName())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oRespCreatUpdDetailInfo.getLstModule())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oRespCreatUpdDetailInfo.getLstHeader())));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.BIGINT));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.TIMESTAMP));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_ScreenDetailCount(?,?,?,?,?,?)");
    DBObject oTotalRecord = (DBObject)oOutArray.get(0);
    oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    DBObject oTimeObject = (DBObject)oOutArray.get(1);
    oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
    oTotalRecord = null;
    oTimeObject = null;
    oOutArray = null;
    oParameters = null;
    return oRecordMetaInfo;
  }
   
  public ArrayList getRespCreatDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition, RespCreatUpdDetailInfo oRespCreatUpdDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oParameters; //Input Parameters
    ArrayList oOutArray;
    int count = 0;
    ResponsCreaBean oResponsCreaBean;
    QueryRow oRow = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oScreenDetail = null;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oRespCreatUpdDetailInfo.getLstModule())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oRespCreatUpdDetailInfo.getLstHeader())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oRespCreatUpdDetailInfo.getTxtRespName())));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_GetScreenDetail(?,?,?,?,?,?,?)");
  
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
        oScreenDetail = new ArrayList();
      }
      count++;
      oRow = (QueryRow)oIt.next();
      oResponsCreaBean = new ResponsCreaBean();
      oResponsCreaBean.setHdnScreenId(oRow.get("screen_id").getString());
      oResponsCreaBean.setTxtLevel1(oRow.get("level1").getString());
      oResponsCreaBean.setTxtLevel2(oRow.get("level2").getString());
      oResponsCreaBean.setTxtScrEndDt(EnrgiseUtil.convertToString(oRow.get("SCREEN_END_DT").getDate()));
      oResponsCreaBean.setStatus("Q");
      oScreenDetail.add(oResponsCreaBean);
      oRow = null;
      oResponsCreaBean = null; //added by swapnendu Dt 24 Oct 2011.
    }
    oList = null;
    oIt = null;
    oBean = null;
    oOutArray = null;
    oParameters = null;
    oRespCreatUpdDetailInfo = null;
    return oScreenDetail;
    
  }
  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      saveRespCreaUpdDetail(sHeaderPrimaryKey,oBaseHeaderBean,oDetailBeanArray);
  }

  private void saveRespCreaUpdDetail(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    ResponsibilityCreationHeaderBean oResponsibilityCreationHeaderBean = (ResponsibilityCreationHeaderBean)oBaseHeaderBean;
    
    oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    
    String respId="";
    if(oResponsibilityCreationHeaderBean.getHdnRespId().equals(""))
    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtRespName())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtRespEndDt())));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));            
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));            
        oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER)); 
        oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_insert_resp_master(?,?,?,?,?,?,?)",true,true);
        DBObject oOutObject=(DBObject)oOutArray.get(0);
        respId=(String)oOutObject.getObject();
        String errMsg = (String)((DBObject)oOutArray.get(1)).getObject();
        Integer errcode = (Integer)((DBObject)oOutArray.get(2)).getObject();
        if(errcode.intValue()!=0)
        {
            ArrayList oList = new ArrayList();
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
            reportError(oList);
        }
        oOutObject = null;
        oOutArray = null;
        oParameters = null;
    }
    else
    {
        respId=oResponsibilityCreationHeaderBean.getHdnRespId();
    }
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        ResponsCreaBean oResponsCreaBean = (ResponsCreaBean)oIt.next();
        if(oResponsCreaBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("pkg_user_resp.proc_insert_resp_detail(?,?,?,?,?)");
            bInsert = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(respId)));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsCreaBean.getHdnScreenId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsCreaBean.getTxtScrEndDt())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtSiteID())));
          oBeanInsert.addToBatch(oParameters);
        }
        else if(oResponsCreaBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("pkg_user_resp.proc_update_resp_detail(?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getHdnRespId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsCreaBean.getHdnScreenId())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtRespEndDt())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsCreaBean.getTxtScrEndDt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtUserID())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
        }
        
        else if(oResponsCreaBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("pkg_user_resp.proc_delete_resp_detail(?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getHdnRespId())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsCreaBean.getHdnScreenId())));
          oBeanDelete.addToBatch(oParameters);  
          oParameters = null;
        }
        oResponsCreaBean = null;
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
      finally
      {
          oResponsibilityCreationHeaderBean = null;
          oBean = null;
          oBeanInsert = null;
          oBeanDelete = null;
      }
  }
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ResponsibilityCreationHeaderBean oResponsibilityCreationHeaderBean = (ResponsibilityCreationHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getHdnRespId())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtRespEndDt())));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtUserID())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oResponsibilityCreationHeaderBean.getTxtSiteID())));
    oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_update_resp_hdr(?,?,?,?,?,?)",true,true);
    Integer errcode = (Integer)((DBObject)oOutArray.get(1)).getObject();
    if (errcode.intValue()!=0)
    {
      ArrayList oArguments = new ArrayList();
      oArguments.add(new String((String)(((DBObject)oOutArray.get(0)).getObject())));
      ArrayList oList = new ArrayList();
      oList.add(new EnrgiseApplicationException("pay.ComFinalSet.Payroll_MESSAGE",oArguments));
      reportError(oList);
    }
  }

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    //ArrayList oParameters = new ArrayList(); //Input Parameters
    //oParameters = new ArrayList();
    return null;
  }

  public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    if (sScreenMode.equals("N"))
    {
          checkDuplicate(oBaseHeaderBean,oList);
          reportError(oList);
    }
  }
  
    private void checkDuplicate(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        ResponsibilityCreationHeaderBean oResponsibilityCreationHeaderBean = (ResponsibilityCreationHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oResponsibilityCreationHeaderBean.getTxtRespName())));
        oParameters.add(new DBObject(2, DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(3, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_chk_duplicate_screen(?,?,?)",true,true);
        Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
        String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() == 2)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
        }
    }

  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  public ScreenComboVO getRespCreatComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    //ArrayList oConvAllowCity = null;    
    ScreenComboVO oScreenComboVO=null;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;       
            
    oScreenComboVO = new ScreenComboVO();  
    
    ArrayList oModuleList = new ArrayList();
    oModuleList = getEmpFinComboRecords("pkg_user_resp.proc_GetModuleList(?,?)","gbl_code","code_sdesc");
    oScreenComboVO.setModuleList(oModuleList);                
    return oScreenComboVO;
  }
  private ArrayList getEmpFinComboRecords(String sProc, String sField_id, String sField_desc)  throws EnrgiseSystemException, EnrgiseApplicationException 
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
      
      
  public LovVO getScreenListLOVDataN(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Screen id");
    arylstHeaderNames.add("Level1");
    arylstHeaderNames.add("Level2");
    oLovVO.setHeaderList(arylstHeaderNames);

    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.HIDDEN);
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
    ArrayList oOutArray;
    oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("lstModule"))));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("lstHeader"))));
    oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));
    oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));

    oOutArray = oBean.callProc(oParameters,"pkg_user_resp.proc_getScreenListLOVDataN(?,?,?,?,?,?,?)");
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
      oLOVBean.setDetailField1(oRow.get("screenaccess_id").getString());
      oLOVBean.setDetailField2(oRow.get("level1").getString());
      oLOVBean.setDetailField3(oRow.get("level2").getString());
      oList.add(oLOVBean);
      oLOVBean = null;
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

      
}