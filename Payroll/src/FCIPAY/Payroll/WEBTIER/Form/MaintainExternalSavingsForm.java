package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintainExternalSavingsBean;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;



public class MaintainExternalSavingsForm extends PayrollBaseForm  
{
  private String txtSrlNo[];
  private String txtEmpNo[]=null;
  private String txtEmpName[]=null;
  private String txtSavCode[];
  private String txtDescription[];
  private String txtType[];
  private String txtSavingsNumber[];
  private String txtSavingsYear[];
  private String txtAmount[];
  private String hdnCheck[]=null;
  private String formMode;
  private String action="";
  private String optVal;
  private String optSavScaleType;
  private long txtTest=0;
  private int promptRow;
  private long promptCol;
  
  private ArrayList lstInstrDtls=new ArrayList();
  private String txtEmpName1="";
  private String txtEmpNo1="";
  private String txtSavCode1=null;
  private String txtSavCodeName=null;
  private String hdnSavCodeSrlNo[];
  private String screenExt;
  private String txtFinYYMM;
  private String hdnAction;
  private String hdnRowVal;
  private String hdnEmpNo;
  private String hdnEmpName;
  private String hdnPayCode;
  private String hdnPayCodeName;
  private String hdnFinYYMM;
  private String hdnLoginUserId;
  private String hdnPayrollUser;
  
   // added by varalika on 30-Sep-2011
  private String txtCreationDate[]=null;  
  private String txtCreatedBy[]=null;  
  private String txtCreatedSite[]=null; 
  private String txtUpdationDate[]=null; 
  private String txtUpdatedBy[]=null; 
  private String txtUpdatedSite[]=null; 
 // ended by varalika
  
  
  public MaintainExternalSavingsForm()
  {
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String[] getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String[] newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String[] getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String[] newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String[] getTxtSavCode()
  {
    return txtSavCode;
  }

  public void setTxtSavCode(String[] newTxtSavCode)
  {
    txtSavCode = newTxtSavCode;
  }

  public String[] getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String[] newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

  public String[] getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String[] newTxtType)
  {
    txtType = newTxtType;
  }

  public String[] getTxtSavingsNumber()
  {
    return txtSavingsNumber;
  }

  public void setTxtSavingsNumber(String[] newTxtSavingsNumber)
  {
    txtSavingsNumber = newTxtSavingsNumber;
  }

  public String[] getTxtSavingsYear()
  {
    return txtSavingsYear;
  }

  public void setTxtSavingsYear(String[] newTxtSavingsYear)
  {
    txtSavingsYear = newTxtSavingsYear;
  }

  public String[] getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String[] newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }

  public String[] getHdnCheck()
  {
    return hdnCheck;
  }

  public void setHdnCheck(String[] newHdnCheck)
  {
    hdnCheck = newHdnCheck;
  }

  public String getFormMode()
  {
    return formMode;
  }

  public void setFormMode(String newFormMode)
  {
    formMode = newFormMode;
  }

  public String getAction()
  {
    return action;
  }

  public void setAction(String newAction)
  {
    action = newAction;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String getOptSavScaleType()
  {
    return optSavScaleType;
  }

  public void setOptSavScaleType(String newOptSavScaleType)
  {
    optSavScaleType = newOptSavScaleType;
  }

  public long getTxtTest()
  {
    return txtTest;
  }

  public void setTxtTest(long newTxtTest)
  {
    txtTest = newTxtTest;
  }

  public int getPromptRow()
  {
    return promptRow;
  }

  public void setPromptRow(int newPromptRow)
  {
    promptRow = newPromptRow;
  }

  public long getPromptCol()
  {
    return promptCol;
  }

  public void setPromptCol(long newPromptCol)
  {
    promptCol = newPromptCol;
  }


 

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String getTxtEmpName1()
  {
    return txtEmpName1;
  }

  public void setTxtEmpName1(String newTxtEmpName1)
  {
    txtEmpName1 = newTxtEmpName1;
  }

  public String getTxtEmpNo1()
  {
    return txtEmpNo1;
  }

  public void setTxtEmpNo1(String newTxtEmpNo1)
  {
    txtEmpNo1 = newTxtEmpNo1;
  }

  public String getTxtSavCode1()
  {
    return txtSavCode1;
  }

  public void setTxtSavCode1(String newTxtSavCode1)
  {
    txtSavCode1 = newTxtSavCode1;
  }

  public String getTxtSavCodeName()
  {
    return txtSavCodeName;
  }

  public void setTxtSavCodeName(String newTxtSavCodeName)
  {
    txtSavCodeName = newTxtSavCodeName;
  }

  public String[] getHdnSavCodeSrlNo()
  {
    return hdnSavCodeSrlNo;
  }

  public void setHdnSavCodeSrlNo(String[] newHdnSavCodeSrlNo)
  {
    hdnSavCodeSrlNo = newHdnSavCodeSrlNo;
  }

     

  public String getScreenExt()
  {
    return screenExt;
  }

  public void setScreenExt(String newScreenExt)
  {
    screenExt = newScreenExt;
  }

  public String getTxtFinYYMM()
  {
    return txtFinYYMM;
  }

  public void setTxtFinYYMM(String newTxtFinYYMM)
  {
    txtFinYYMM = newTxtFinYYMM;
  }

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

  public String getHdnRowVal()
  {
    return hdnRowVal;
  }

  public void setHdnRowVal(String newHdnRowVal)
  {
    hdnRowVal = newHdnRowVal;
  }

  public String getHdnEmpNo()
  {
    return hdnEmpNo;
  }

  public void setHdnEmpNo(String newHdnEmpNo)
  {
    hdnEmpNo = newHdnEmpNo;
  }

  public String getHdnEmpName()
  {
    return hdnEmpName;
  }

  public void setHdnEmpName(String newHdnEmpName)
  {
    hdnEmpName = newHdnEmpName;
  }

  public String getHdnPayCode()
  {
    return hdnPayCode;
  }

  public void setHdnPayCode(String newHdnPayCode)
  {
    hdnPayCode = newHdnPayCode;
  }

  public String getHdnPayCodeName()
  {
    return hdnPayCodeName;
  }

  public void setHdnPayCodeName(String newHdnPayCodeName)
  {
    hdnPayCodeName = newHdnPayCodeName;
  }

  public String getHdnFinYYMM()
  {
    return hdnFinYYMM;
  }

  public void setHdnFinYYMM(String newHdnFinYYMM)
  {
    hdnFinYYMM = newHdnFinYYMM;
  }

  public String getHdnLoginUserId()
  {
    return hdnLoginUserId;
  }

  public void setHdnLoginUserId(String newHdnLoginUserId)
  {
    hdnLoginUserId = newHdnLoginUserId;
  }

  public String getHdnPayrollUser()
  {
    return hdnPayrollUser;
  }

  public void setHdnPayrollUser(String newHdnPayrollUser)
  {
    hdnPayrollUser = newHdnPayrollUser;
  }

//added by varalika on 30-Sep-2011//

 public String[] getTxtCreationDate()
  {
 // System.out.println("Creation_Date::::>"+txtCreationDate[0]);
    return txtCreationDate;
  }

  public void setTxtCreationDate(String[] newtxtCreationDate)
  {
    txtCreationDate = newtxtCreationDate;
  }

  public String[] getTxtCreatedBy()
  {
    return txtCreatedBy;
  }

  public void setTxtCreatedBy(String[] newtxtCreatedBy)
  {
    txtCreatedBy = newtxtCreatedBy;
  }
  
  public String[] getTxtCreatedSite()
  {
    return txtCreatedSite;
  }

  public void setTxtCreatedSite(String[] newtxtCreatedSite)
  {
    txtCreatedSite = newtxtCreatedSite;
  }
//updation details
 public String[] getTxtUpdationDate()
  {
    return txtUpdationDate;
  }

  public void setTxtUpdationDate(String[] newtxtUpdationDate)
  {
    txtUpdationDate = newtxtUpdationDate;
  }

  public String[] getTxtUpdatedBy()
  {
    return txtUpdatedBy;
  }

  public void setTxtUpdatedBy(String[] newtxtUpdatedBy)
  {
    txtUpdatedBy = newtxtUpdatedBy;
  }
  
  public String[] getTxtUpdatedSite()
  {
    return txtUpdatedSite;
  }

  public void setTxtUpdatedSite(String[] newtxtUpdatedSite)
  {
    txtUpdatedSite = newtxtUpdatedSite;
  }
// ended by varalika


}