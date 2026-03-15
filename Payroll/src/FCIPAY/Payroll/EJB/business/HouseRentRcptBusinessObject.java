package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintHouseRentRcptVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleComboVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HouseRentRcptDetailInfo;
import java.sql.SQLException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.HouseRentRcptHdrBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.UTILITY.HouseRentRcptBean;
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


public class HouseRentRcptBusinessObject extends BaseBO
{
  public HouseRentRcptBusinessObject()
  {
  }


  public RecordMetaInfo getHouseRentHeaderMetaInfo(MaintHouseRentRcptVO oMaintHouseRentRcptVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String locCode = oMaintHouseRentRcptVO.getLoginLocCode()+"";
    ArrayList oOutArray; //Output 

      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintHouseRentRcptVO.getTxtEmpNo())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintHouseRentRcptVO.getTxtFinYYMM())));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintHouseRentRcptVO.getHdnEmpLbrFlag())));      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetHouseRentCount(?,?,?,?,?,?,?)");
      
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
      
      DBObject oTimeObject = (DBObject)oOutArray.get(1);
      oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
      DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
      return oRecordMetaInfo;
  }
  public ArrayList getHouseRentHeader(MaintHouseRentRcptVO oMaintHouseRentRcptVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(oMaintHouseRentRcptVO == null)
    {
      oMaintHouseRentRcptVO = new MaintHouseRentRcptVO();
    }
    
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    String locCode = oMaintHouseRentRcptVO.getLoginLocCode()+"";

      oParameters = new ArrayList();
      
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintHouseRentRcptVO.getTxtEmpNo())));
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintHouseRentRcptVO.getTxtFinYYMM()))); 
      oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oMaintHouseRentRcptVO.getHdnEmpLbrFlag())));  
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetHouseRentHdr(?,?,?,?,?,?,?,?)");
      
      DBObject oOutObject = (DBObject)oOutArray.get(0);
      oList = (ArrayList)(oOutObject.getObject());
    

      if(oList.size() == 0)
      {        
        throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
      }
      
      HouseRentRcptHdrBean oPayScaleHeader;
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
          oPayScaleHeader = new HouseRentRcptHdrBean();
          oPayScaleHeader.setTxtEmpNo(oRow.get("emp_num").getString());
          oPayScaleHeader.setTxtEmpName(oRow.get("name").getString());
          oPayScaleHeader.setTxtFinYYMM(oRow.get("fin_yymm").getString());
          oPayScaleHeader.setTxtRentAmt((oRow.get("month_rent").getString()));
          oHeaderList.add(oPayScaleHeader);
      }              
    return oHeaderList;
  }
 

 public RecordMetaInfo getHouseRentDetailMetaInfo(String sPrimaryKey,HouseRentRcptDetailInfo oHouseRentRcptDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 

       String RevYear,PayscaleCode;
      RevYear = oHouseRentRcptDetailInfo.getTxtEmpNo();
   
     /* oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,RevYear));          
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptDetailInfo.getTxtFinYYMM())));                
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.BIGINT));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.TIMESTAMP));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_HouseRentDtlCount(?,?,?,?,?)");
      */
      RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();

   //   DBObject oTotalRecord = (DBObject)oOutArray.get(0);
      oRecordMetaInfo.setRecordCount(12);
   //   DBObject oTimeObject = (DBObject)oOutArray.get(1);
   //   oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
      return oRecordMetaInfo;            
  }

 public ArrayList getHouseRentDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,HouseRentRcptDetailInfo oHouseRentRcptDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    HouseRentRcptBean oPayScaleDtl;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleDetail = null;

    /*  if(oHouseRentRcptDetailInfo.isScreenModeFlag())
      {
        ArrayList oErrList = new ArrayList();
        checkDuplicate(oHouseRentRcptDetailInfo,oErrList);
        reportError(oErrList);
        return getNewHouseRentDetails(oHouseRentRcptDetailInfo);
      }*/
      String empNo,PayscaleCode;
      empNo = oHouseRentRcptDetailInfo.getTxtEmpNo();
   
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,empNo));
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptDetailInfo.getTxtFinYYMM())));                      
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_HouseRentDetail(?,?,?,?,?,?)");
      
        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oList.size() == 0)
        {        
         // throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
         return getNewHouseRentDetails(oHouseRentRcptDetailInfo);
        } else if(oHouseRentRcptDetailInfo.isScreenModeFlag())
        {
          throw new EnrgiseApplicationException("wenrgise.common.dupliCheck");
        }
       
        count = 0;
        int mm=3;
        String strYYMM="";
        String strTempYYMM="";
        String [] arrMonth={"January","February","March","April","May","June","July","August","September","October","November","December"};
        boolean flag=false;
        while(count<12)
        {
          if(count == 0)
            {
              oPayScaleDetail = new ArrayList();
            }
            count++;
            flag=false;
            oPayScaleDtl = new HouseRentRcptBean();
            strYYMM=oHouseRentRcptDetailInfo.getTxtFinYYMM().substring(0,4);
            if(mm<3)
            {
              strYYMM=(Integer.parseInt(strYYMM)+1)+"";
            }
            if(mm<10)
              oPayScaleDtl.setTxtYYMM(strYYMM+"0"+mm);
            else
              oPayScaleDtl.setTxtYYMM(strYYMM+mm);
            oIt = oList.iterator();
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              strTempYYMM=oRow.get("yymm").getString();
              if(strTempYYMM.equals(oPayScaleDtl.getTxtYYMM()))
              {
                flag=true;
                break;
              }
            }  
            if(flag)
            {
              oPayScaleDtl.setTxtMonth(arrMonth[mm-1]);
              oPayScaleDtl.setTxtMnthRentAmt((oRow.get("month_rent").getString()));
              oPayScaleDtl.setTxtAmt((oRow.get("amount").getString()));
              oPayScaleDtl.setHdnSrlNo((oRow.get("srl_no").getString()));          
              oPayScaleDtl.setStatus("Q");   
            }else
            {
              oPayScaleDtl.setTxtMnthRentAmt("0");
              oPayScaleDtl.setTxtAmt("0");
              oPayScaleDtl.setTxtMonth(arrMonth[mm-1]);
              oPayScaleDtl.setHdnSrlNo("");          
              oPayScaleDtl.setStatus("N");
            }
              oPayScaleDetail.add(oPayScaleDtl);
            if(mm==12)
              mm=1;
            else
              mm++;
        }
        return oPayScaleDetail; 
  }    

 public ArrayList getNewHouseRentDetails(HouseRentRcptHdrBean oHouseRentRcptHdrBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    int count = 0;
    HouseRentRcptBean oPayScaleDtl;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleDetail = null;
    int mm=3;
    String strYYMM="";
    String [] arrMonth={"January","February","March","April","May","June","July","August","September","October","November","December"};
    while(count<12)
    {
      if(count == 0)
        {
          oPayScaleDetail = new ArrayList();
        }
        count++;
        oPayScaleDtl = new HouseRentRcptBean();
        strYYMM=oHouseRentRcptHdrBean.getTxtFinYYMM().substring(0,4);
        if(mm<3)
        {
          strYYMM=(Integer.parseInt(strYYMM)+1)+"";
        }
        if(mm<10)
          oPayScaleDtl.setTxtYYMM(strYYMM+"0"+mm);
        else
          oPayScaleDtl.setTxtYYMM(strYYMM+mm);
        oPayScaleDtl.setTxtAmt(oHouseRentRcptHdrBean.getTxtRentAmt());
        oPayScaleDtl.setTxtMonth(arrMonth[mm-1]);
        oPayScaleDtl.setHdnSrlNo("");          
        oPayScaleDtl.setStatus("N");           
        oPayScaleDetail.add(oPayScaleDtl);
        if(mm==12)
          mm=1;
        else
          mm++;
    }
    //oHouseRentRcptDetailInfo.setScreenModeFlag(false);
    return oPayScaleDetail; 
  } 

 public ArrayList getNewHouseRentDetails(HouseRentRcptDetailInfo oHouseRentRcptDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray;
    String strRentAmt="";
    String strAmt="";
    
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,oHouseRentRcptDetailInfo.getTxtEmpNo()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptDetailInfo.getTxtFinYYMM())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptDetailInfo.getTxtRentAmt())));                      
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_getHouseRentAutoPop(?,?,?,?,?,?,?)");
      strAmt = (String)((DBObject)oOutArray.get(0)).getObject();
      strRentAmt = (String)((DBObject)oOutArray.get(1)).getObject();
    
    String [] arAmt=strAmt.split(",") ;
    String [] arRentAmt=strRentAmt.split(",") ;
    if(arRentAmt.length!=12)
    {
      throw new EnrgiseSystemException();
    }
    int count = 0;
    HouseRentRcptBean oPayScaleDtl;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oPayScaleDetail = null;
    int mm=3;
    String strYYMM="";
    String [] arrMonth={"January","February","March","April","May","June","July","August","September","October","November","December"};
    while(count<12)
    {
      if(count == 0)
        {
          oPayScaleDetail = new ArrayList();
        }
        count++;
        oPayScaleDtl = new HouseRentRcptBean();
        strYYMM=oHouseRentRcptDetailInfo.getTxtFinYYMM().substring(0,4);
        if(mm<3)
        {
          strYYMM=(Integer.parseInt(strYYMM)+1)+"";
        }
        if(mm<10)
          oPayScaleDtl.setTxtYYMM(strYYMM+"0"+mm);
        else
          oPayScaleDtl.setTxtYYMM(strYYMM+mm);
        oPayScaleDtl.setTxtAmt(arAmt[count-1]);
        oPayScaleDtl.setTxtMnthRentAmt(arRentAmt[count-1]);
        oPayScaleDtl.setTxtMonth(arrMonth[mm-1]);
        oPayScaleDtl.setHdnSrlNo("");          
        oPayScaleDtl.setStatus("N");           
        oPayScaleDetail.add(oPayScaleDtl);
        if(mm==12)
          mm=1;
        else
          mm++;
    }
    oHouseRentRcptDetailInfo.setScreenModeFlag(false);
    return oPayScaleDetail; 
  }
  
  public boolean savePayScaleHeader(HouseRentRcptHdrBean oHouseRentRcptHdrBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       return true;
  }
  

  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    /*  ArrayList oDetailArray= getNewHouseRentDetails((HouseRentRcptHdrBean)oBaseHeaderBean); 
      saveHouseRent("",(HouseRentRcptHdrBean)oBaseHeaderBean,oDetailArray);
      return "";
      */
      return null;
  }  
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
 
  }  

  
//  public void saveDetailImpl(String sHeaderPrimaryKey,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    String sPayScaleType;    
    
    if(sScreenName.equals("HouseRentRcptScreen"))
    {      
      saveHouseRent(sHeaderPrimaryKey,(HouseRentRcptHdrBean)oBaseHeaderBean,oDetailBeanArray);
    }
  
  }   
  
 private void saveHouseRent(String sHeaderPrimaryKey,HouseRentRcptHdrBean oHouseRentRcptHdrBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
  /*  if(oHouseRentRcptHdrBean.isScreenModeFlag())
    {
      oDetailBeanArray=getNewHouseRentDetails(oHouseRentRcptHdrBean); 
      oHouseRentRcptHdrBean.setScreenModeFlag(false);
    }
    */
      Iterator oIt = oDetailBeanArray.iterator();
      while(oIt.hasNext())
      {
        HouseRentRcptBean oHouseRentRcptBean = (HouseRentRcptBean)oIt.next();
//        System.out.println(oHouseRentRcptBean.getStatus());
//        System.out.println(EnrgiseConstants.UPDATE_MODE + " " + EnrgiseConstants.NEW_MODE);
        if(oHouseRentRcptBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if(!oHouseRentRcptBean.getTxtAmt().equals("") && !(oHouseRentRcptBean.getTxtAmt().equals("0")))
          {
          if(!bInsert)
          {
            oBeanInsert = new DBUtilitiesBean();
            oBeanInsert.createBatch("PAYROLL_PKG_EXT.proc_InsertHouseRentDetail(?,?,?,?,?,?,?)");
            bInsert = true;
          }
          
          oParameters = new ArrayList();
            String sEbCheck;                        

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtFinYYMM())));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtYYMM())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtAmt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtMnthRentAmt())));

          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtSiteID())));

          oBeanInsert.addToBatch(oParameters);
          }
        }
       else if(oHouseRentRcptBean.getStatus().equals(EnrgiseConstants.UPDATE_MODE))
        {
          if(!bUpdate)
          {
            oBean = new DBUtilitiesBean();
            oBean.createBatch("PAYROLL_PKG_EXT.proc_UpdateHouseRentDetail(?,?,?,?,?,?,?)");
            bUpdate = true;
          }
          oParameters = new ArrayList();

          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtFinYYMM())));        
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtEmpNo())));    
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtYYMM())));                  
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtMnthRentAmt())));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getHdnSrlNo())));                    
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtUserID())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtSiteID())));
          oBean.addToBatch(oParameters);
          
        }
     else if(oHouseRentRcptBean.getStatus().equals(EnrgiseConstants.DELETE_MODE))
        {
          if(!bDelete)
          {
            oBeanDelete = new DBUtilitiesBean();
            oBeanDelete.createBatch("PAYROLL_PKG_EXT.proc_DeleteHouseRentDetail(?,?,?)");
            bDelete = true;
          }
          oParameters = new ArrayList();
         
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtEmpNo())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtFinYYMM())));                 
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getHdnSrlNo())));                          
     
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


 public LovVO getQueryHouseRentLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID"))));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));     
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_QueryHouseRentLOV(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("Name").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

public LovVO getNewHouseRentLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");    
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
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag"))));
      oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_NewHouseRentLOV(?,?,?,?,?,?)");
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
       oLOVBean.setDetailField2(oRow.get("Name").getString());            
      
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
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_GetPayScaleCodelov(?,?)");
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
      
       oLOVBean.setDetailField1(oRow.get("pay_scale_code").getString());            
      
      oList.add(oLOVBean);
    }
     
      oLovVO.setDetailList(oList);
    return oLovVO;
  }

 public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    HouseRentRcptHdrBean oHouseRentRcptHdrBean = (HouseRentRcptHdrBean)oBaseHeaderBean;
    checkMaxPayYear(oHouseRentRcptHdrBean.getTxtSiteID(),oHouseRentRcptHdrBean.getHdnEmpLbrFlag());
    reportError(oList);
    if(sScreenMode.equals("N"))
    {
      checkDuplicate(oBaseHeaderBean,oList);      
    }
    validateHRRDtls(oBaseHeaderBean,oDetailBeanArray,oList);
    reportError(oList);
  }
  
  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
 
  private void checkDuplicate(BaseHeaderBean oBaseHeaderBean,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Integer sFlag = new Integer(0);
    HouseRentRcptHdrBean oHouseRentRcptHdrBean=(HouseRentRcptHdrBean)oBaseHeaderBean;

    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtEmpNo())));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtFinYYMM())));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_HouseRentRcpt_Check(?,?,?,?)");

      sFlag = (Integer)((DBObject)oOutArray.get(0)).getObject();
      if(!sFlag.equals(new Integer(0)))
      {        
        oList.add(new EnrgiseApplicationException("wenrgise.common.dupliCheck"));
      }
  }

  private void validateHRRDtls(BaseHeaderBean oBaseHeaderBean,ArrayList oDetailBeanArray,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    Iterator oIt = null;
    HouseRentRcptHdrBean oHouseRentRcptHdrBean=(HouseRentRcptHdrBean)oBaseHeaderBean;
    Integer chkFlag=new Integer(0);
    String errMsg="";
    
    oIt = oDetailBeanArray.iterator();
    while(oIt.hasNext())
    {
        HouseRentRcptBean oHouseRentRcptBean = (HouseRentRcptBean)oIt.next();
        if(!oHouseRentRcptBean.getStatus().equals("D"))
          count++;
          if(!oHouseRentRcptBean.getTxtMnthRentAmt().equals("") && !(oHouseRentRcptBean.getTxtMnthRentAmt().equals("0")))
          {
            oParameters = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptHdrBean.getTxtEmpNo())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtYYMM())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtMnthRentAmt())));
         //   oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oHouseRentRcptBean.getTxtAmt())));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG_EXT.proc_ValidateHouseRentDtls(?,?,?,?,?,?,?)",true,true);
            String txtAmt=(String)((DBObject)oOutArray.get(0)).getObject();
            chkFlag = (Integer)((DBObject)oOutArray.get(1)).getObject();
            errMsg=(String)((DBObject)oOutArray.get(2)).getObject();
            if(!chkFlag.equals(new Integer(0)))
            {
              ArrayList oArguments=new ArrayList();
              oArguments.add(errMsg);
              oList.add(new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments));
            }else
            {
              oHouseRentRcptBean.setTxtAmt(txtAmt);
            }
          }
    }
  }
  
  private String checkMaxPayYear(String siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    int iRes=0;
    String sRevYear="";
    String status ="";

    oParameters = new ArrayList();
 
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(siteId)));
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,hdnEmpLbrFlag));
    oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");
    oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
    oIt = oRetList.iterator();
    while(oIt.hasNext())
    {
      oRow = (QueryRow)oIt.next();
      sRevYear = oRow.get("yymm").getString(); 
      status = oRow.get("arc_flag").getString(); 
    }    
    
   // int iStat=Integer.parseInt(status);
    if(status!=null && status.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }
    
    return "";
  }
}