package FCIPAY.Payroll.common.webtier.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
public class BaseForm extends ActionForm 
{

  
  
  private long totalHeaderRecord = 0; // Total number of header record queried 
  private long totalDetailRecord = 0; //The total number of detail record
  private ArrayList detailList = null; // The detail record collection
  private String headerPrimaryKey = null;
  private long pageRequested = 0;
  private long totalPageCount;  
  private String [] detailId = null;
  private String [] status = null;
  private String screenName = null;
  private boolean headerDataChanged = false;
  private boolean detailDataChanged = false;
  private int detailStartPage = 0;
  private String screenMode = "";
  private String forwardedPage = null;
  private boolean [] checked = null;
  private long positionRequested=0 ; // Header Position Requested
  private long totalCount=0 ; // Total Header Record
  private String newPositionRequested = null;
  private String [] itemChecked = null;
  private String newPageRequested = null;
  // LOV related fields
  private String lovKey;
  private String txtFields;
  private String txtIndex;
  private boolean headerFields = true;
  private String txtSearchFields;
  private String txtDisplayFields;
  private String txtInputField;
  private boolean getDetail = true;
  private int thisPageDetailCount = 0;
  private String UserPositionRequested = null;  // Header position requested subjected to validation
  private String UserPageRequested = null; // Detail page requested subjected to validation
  private String loginEmployeeName="";
  private String loginEmployeelocation="";
  private long loginEmployeeNo = 0;
  private long loginCPFCodeNo = 0; // added by yogesh

  private long loginLocCode = 0;
  private String locTyp;
  // added by Basu
  private String errorMessage2;
//  private String [] startField = null;    // For Incrementing Next Rows Value In Detail Section
//  private String [] endField = null;

  private String payYYMM; // Added to get the current payroll year month for given location
  
  private int recordsPerPage = 0;

 /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }


  public long getTotalDetailRecord()
  {
    return totalDetailRecord;
  }

  public void setTotalDetailRecord(long newTotalDetailRecord)
  {
    totalDetailRecord = newTotalDetailRecord;
  }

  public long getTotalHeaderRecord()
  {
    return totalHeaderRecord;
  }

  public void setTotalHeaderRecord(long newTotalHeaderRecord)
  {
    totalHeaderRecord = newTotalHeaderRecord;
  }

  public ArrayList getDetailList()
  {
    return detailList;
  }

  public void setDetailList(ArrayList newDetailList)
  {
    detailList = newDetailList;
  }

  public String getHeaderPrimaryKey()
  {
    return headerPrimaryKey;
  }

  public void setHeaderPrimaryKey(String newHeaderPrimaryKey)
  {
    headerPrimaryKey = newHeaderPrimaryKey;
  }

  public long getPageRequested()
  {
    return pageRequested;
  }

  public void setPageRequested(long newPageRequested)
  {
    pageRequested = newPageRequested;
  }

  public String[] getStatus()
  {
    return status;
  }

  public void setStatus(String[] newStatus)
  {
    status = newStatus;
  }

  public String[] getDetailId()
  {
    return detailId;
  }

  public void setDetailId(String[] newDetailId)
  {
    detailId = newDetailId;
  }

  public String getScreenName()
  {
    return screenName;
  }

  public void setScreenName(String newScreenName)
  {
    screenName = newScreenName;
  }

  public boolean isHeaderDataChanged()
  {
    return headerDataChanged;
  }

  public void setHeaderDataChanged(boolean newHeaderDataChanged)
  {
    headerDataChanged = newHeaderDataChanged;
  }

  public boolean isDetailDataChanged()
  {
    return detailDataChanged;
  }

  public void setDetailDataChanged(boolean newDetailDataChanged)
  {
    detailDataChanged = newDetailDataChanged;
  }

  public int getDetailStartPage()
  {
    return detailStartPage;
  }

  public void setDetailStartPage(int newDetailStartPage)
  {
    detailStartPage = newDetailStartPage;
  }

  public String getScreenMode()
  {
    return screenMode;
  }

  public void setScreenMode(String newScreenMode)
  {
    screenMode = newScreenMode;
  }

  public String getForwardedPage()
  {
    return forwardedPage;
  }

  public void setForwardedPage(String newForwardedPage)
  {
    forwardedPage = newForwardedPage;
  }

  public boolean[] getChecked()
  {
    return checked;
  }

  public void setChecked(boolean[] newChecked)
  {
    checked = newChecked;
  }

  public long getPositionRequested()
  {
    return positionRequested;
  }

  public void setPositionRequested(long newPositionRequested)
  {
    positionRequested = newPositionRequested;
  }

  public long getTotalCount()
  {
    return totalCount;
  }

  public void setTotalCount(long newTotalCount)
  {
    totalCount = newTotalCount;
  }

  public String getNewPositionRequested()
  {
    return newPositionRequested;
  }

  public void setNewPositionRequested(String newNewPositionRequested)
  {
    newPositionRequested = newNewPositionRequested;
  }

  public String[] getItemChecked()
  {
    return itemChecked;
  }

  public void setItemChecked(String[] newItemChecked)
  {
    itemChecked = newItemChecked;
  }

  public String getLovKey()
  {
    return lovKey;
  }

  public void setLovKey(String newLovKey)
  {
    lovKey = newLovKey;
  }

  public String getTxtFields()
  {
    return txtFields;
  }

  public void setTxtFields(String newTxtFields)
  {
    txtFields = newTxtFields;
  }

  public String getTxtIndex()
  {
    return txtIndex;
  }

  public void setTxtIndex(String newTxtIndex)
  {
    txtIndex = newTxtIndex;
  }

  public String getNewPageRequested()
  {
    return newPageRequested;
  }

  public void setNewPageRequested(String newNewPageRequested)
  {
    newPageRequested = newNewPageRequested;
  }

  public boolean isHeaderFields()
  {
    return headerFields;
  }

  public void setHeaderFields(boolean newHeaderFields)
  {
    headerFields = newHeaderFields;
  }

  public String getTxtSearchFields()
  {
    return txtSearchFields;
  }

  public void setTxtSearchFields(String newTxtSearchFields)
  {
    txtSearchFields = newTxtSearchFields;
  }

  public String getTxtDisplayFields()
  {
    return txtDisplayFields;
  }

  public void setTxtDisplayFields(String newTxtDisplayFields)
  {
    txtDisplayFields = newTxtDisplayFields;
  }

  public boolean isGetDetail()
  {
    return getDetail;
  }

  public void setGetDetail(boolean newGetDetail)
  {
    getDetail = newGetDetail;
  }

  public int getThisPageDetailCount()
  {
    return thisPageDetailCount;
  }

  public void setThisPageDetailCount(int newThisPageDetailCount)
  {
    thisPageDetailCount = newThisPageDetailCount;
  }

  public String getUserPositionRequested()
  {
    return UserPositionRequested;
  }

  public void setUserPositionRequested(String newUserPositionRequested)
  {
    UserPositionRequested = newUserPositionRequested;
  }

  public String getUserPageRequested()
  {
    return UserPageRequested;
  }

  public void setUserPageRequested(String newUserPageRequested)
  {
    UserPageRequested = newUserPageRequested;
  }

  public long getTotalPageCount()
  {
    return totalPageCount;
  }

  public void setTotalPageCount(long newTotalPageCount)
  {
    totalPageCount = newTotalPageCount;
  }





  public String getLoginEmployeeName()
  {
    return loginEmployeeName;
  }

  public void setLoginEmployeeName(String newLoginEmployeeName)
  {
    loginEmployeeName = newLoginEmployeeName;
  }

  public String getLoginEmployeelocation()
  {
    return loginEmployeelocation;
  }

  public void setLoginEmployeelocation(String newLoginEmployeelocation)
  {
    loginEmployeelocation = newLoginEmployeelocation;
  }

  public long getLoginEmployeeNo()
  {
    return loginEmployeeNo;
  }

  public void setLoginEmployeeNo(long newLoginEmployeeNo)
  {
    loginEmployeeNo = newLoginEmployeeNo;
  }

/*  public long getLoginEmployeeNo()
  {
    return loginEmployeeNo;
  }

  public long getLoginEmployeeNo()
  {
    return loginEmployeeNo;
  }
  */
   public long getLoginCPFCodeNo()
  {
    return loginCPFCodeNo;
  }
  public void setLoginCPFCodeNo(long newLoginCPFCodeNo)
  {
    loginCPFCodeNo = newLoginCPFCodeNo;
  }
 
  public long getLoginLocCode()
  {
    return loginLocCode;
  }

  public void setLoginLocCode(long newLoginLocCode)
  {
    loginLocCode = newLoginLocCode;
  }

  public String getErrorMessage2()
  {
    return errorMessage2;
  }

  public void setErrorMessage2(String newErrorMessage)
  {
    errorMessage2 = newErrorMessage;
  }


  public String getTxtInputField()
  {
    return txtInputField;
  }

  public void setTxtInputField(String newTxtInputField)
  {
    txtInputField = newTxtInputField;
  }

  

/*  public String[] getStartField()
  {
    return startField;
  }

  public void setStartField(String[] newStartField)
  {
    startField = newStartField;
  }

  public String[] getEndField()
  {
    return endField;
  }

  public void setEndField(String[] newEndField)
  {
    endField = newEndField;
  }

*/

  public String getPayYYMM()
  {
    return payYYMM;
  }

  public void setPayYYMM(String newPayYYMM)
  {
    payYYMM = newPayYYMM;
  }

  public String getLocTyp()
  {
    return locTyp;
  }

  public void setLocTyp(String newLocTyp)
  {
    locTyp = newLocTyp;
  }


    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }
}
