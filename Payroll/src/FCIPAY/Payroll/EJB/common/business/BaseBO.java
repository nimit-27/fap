package FCIPAY.Payroll.EJB.common.business;
import java.sql.Timestamp;
import java.util.Iterator;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.util.ArrayList;
public abstract class BaseBO
{
  private String headerTable = null;
  private String headerPKColumnName = null;
  private String detailTable = null;
  private String detailPKColumnName = null;
  
  public String saveData(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    String sHeaderPrimaryKey = oBaseHeaderBean.getHeaderPrimaryKey();
    
    if(sScreenMode.equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE))
    {      
      initializeBOImpl(sScreenName);
    }
    
    if(sScreenMode.equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE))
    {
      if(bHeaderDataChanged)
      {      
        if(!checkHeaderTimeStamp(oBaseHeaderBean.getHeaderPrimaryKey(),oWhenPicked))
        {
          throw new EnrgiseApplicationException("IBA.Payroll.common.changed",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
        }        
      }
    
      if(bDetailDataChanged)
      {      
        if(!checkDetailTimeStamp(oDetailBeanArray,oDetailPicked))
        {
          throw new EnrgiseApplicationException("IBA.Payroll.common.changed",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
        }
      }      
    }

    if(sScreenMode.equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.UPDATE_MODE))
    {          
      additionalFieldValidationImpl(oBaseHeaderBean, oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
      additionalTimestampValidationImpl(oBaseHeaderBean, oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
      additionalBusinessValidationImpl(oBaseHeaderBean, oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }

    if(sScreenMode.equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE))
    {          
      additionalFieldValidationImpl(oBaseHeaderBean, oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }
    
    // Save Header

    if(bHeaderDataChanged)
    {
      if(sScreenMode.equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.NEW_MODE))
      {
        sHeaderPrimaryKey = saveNewHeaderImpl(oBaseHeaderBean);
      }
      else
      {
        updateHeaderImpl(oBaseHeaderBean);
      }
    }
    
    if(bDetailDataChanged)
    {
      saveDetailImpl(sHeaderPrimaryKey,oBaseHeaderBean,sScreenName,oDetailBeanArray);
    }
    return sHeaderPrimaryKey;
  }
    
  public BaseBO()
  {
  }
  
  
  public void initializeBO(String sHeaderTable, String sDetailTable)
  {
    headerTable = sHeaderTable;
    detailTable = sDetailTable;
  }
  
  private boolean checkHeaderTimeStamp(String sPrimaryKey,Timestamp oWhenPicked)
  {
    return true;
  }
  private boolean checkDetailTimeStamp(ArrayList oDetailBeanArray,Timestamp oWhenDetailPicked)
  {
    return true;
  }

  protected void reportError(ArrayList oList) throws EnrgiseApplicationException
  {
    if(oList.size() > 0)
    {
      boolean bFirstTime = true;
      EnrgiseApplicationException oApp = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
        if(!bFirstTime)
        {
          oApp.addToList((EnrgiseApplicationException)oIt.next());
        }
        else
        {
          bFirstTime = false;
          oApp = (EnrgiseApplicationException)oIt.next();          
        }
      }
      
      
      throw oApp;
      
    }
  }
  public void deleteHeaderImpl(String sPrimaryKey) throws EnrgiseSystemException
  {
    
  }

  public abstract String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException;
  public abstract void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean)  throws EnrgiseSystemException, EnrgiseApplicationException;

  public abstract void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName,ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException;  
  public abstract void initializeBOImpl(String sScreenName); 
  public abstract void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException;
  public abstract void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException;
  public abstract void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException;
}