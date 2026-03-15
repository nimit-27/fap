package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintainInternalSavingsBean;

public class MaintainInternalSavingsForm extends PayrollBaseForm 
{
  private String txtSrlNo[];
  private String txtEmpNo[];
  private String txtEmpName[];
  private String txtSavCode[];
  private String txtDescription[];
  private String txtSavingsNumber[];
  private String txtValUpto[];
  private String txtAmount[];
  private long txtTest;
  private String action;
  private String optSavScaleType;

  private ArrayList lstInstrDtls=new ArrayList();
  private String txtSavCode1=null;                             
  private String txtSavCodeName=null;
  private String formMode;
  private String optVal;
  private int promptRow;
  private long promptCol;
  private String hdnCodeSrlNo[];
  private String txtEmpName1;
  private String txtEmpNo1="";
  private String hdnSavCodeSrlNo[];
  private String hdnRecordPos;
  private String txtSavingsDate[];
  private String txtMisc;
  private String hdrGoto;
  private String screenInt;
  private String txtLastYYMM[];

  private String hdnAction;
  private String hdnRowVal;
  private String hdnEmpNo;
  private String hdnEmpName;
  private String hdnPayCode;
  private String hdnPayCodeName;
  
  ////////////////////added by sonia on 09-02-2011////////////
private String txtAgency[]=null;
private String txtAgencyName[]=null;
private String  txtAgencyNo[]=null;
private String txtAgencySite[]=null;
private String txtAgencySiteCode[]=null;
  
  ////////////////////end added by sonia on 09-02-2011////////////

// added by varalika on 30-Sep-2011
  private String txtCreationDate[]=null;  
  private String txtCreatedBy[]=null;  
  private String txtCreatedSite[]=null; 
  private String txtUpdationDate[]=null; 
  private String txtUpdatedBy[]=null; 
  private String txtUpdatedSite[]=null; 
 // ended by varalika
 
  public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
        this.txtTest = 0;
   }
  public MaintainInternalSavingsForm()
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

  public String[] getTxtSavingsNumber()
  {
    return txtSavingsNumber;
  }

  public void setTxtSavingsNumber(String[] newTxtSavingsNumber)
  {
    txtSavingsNumber = newTxtSavingsNumber;
  }

  public String[] getTxtValUpto()
  {
    return txtValUpto;
  }

  public void setTxtValUpto(String[] newTxtValUpto)
  {
    txtValUpto = newTxtValUpto;
  }

  public String[] getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String[] newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }

  public long getTxtTest()
  {
    return txtTest;
  }

  public void setTxtTest(long newTxtTest)
  {
    txtTest = newTxtTest;
  }

  public String getAction()
  {
    return action;
  }

  public void setAction(String newAction)
  {
    action = newAction;
  }

  public String getOptSavScaleType()
  {
    return optSavScaleType;
  }

  public void setOptSavScaleType(String newOptSavScaleType)
  {
    optSavScaleType = newOptSavScaleType;
  }

  /*public String[] getHdnCheck()
  {
    return hdnCheck;
  }

  public void setHdnCheck(String[] newHdnCheck)
  {
    hdnCheck = newHdnCheck;
  }*/

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
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

  public String getFormMode()
  {
    return formMode;
  }

  public void setFormMode(String newFormMode)
  {
    formMode = newFormMode;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
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

  public String[] getHdnCodeSrlNo()
  {
    return hdnCodeSrlNo;
  }

  public void setHdnCodeSrlNo(String[] newHdnCodeSrlNo)
  {
    hdnCodeSrlNo = newHdnCodeSrlNo;
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


  public String[] getHdnSavCodeSrlNo()
  {
    return hdnSavCodeSrlNo;
  }

  public void setHdnSavCodeSrlNo(String[] newHdnSavCodeSrlNo)
  {
    hdnSavCodeSrlNo = newHdnSavCodeSrlNo;
  }

  public String getHdnRecordPos()
  {
    return hdnRecordPos;
  }

  public void setHdnRecordPos(String newHdnRecordPos)
  {
    hdnRecordPos = newHdnRecordPos;
  }





  public String[] getTxtSavingsDate()
  {
    return txtSavingsDate;
  }

  public void setTxtSavingsDate(String[] newTxtSavingsDate)
  {
    txtSavingsDate = newTxtSavingsDate;
  }

  public String getTxtMisc()
  {
    return txtMisc;
  }

  public void setTxtMisc(String newTxtMisc)
  {
    txtMisc = newTxtMisc;
  }

  public String getHdrGoto()
  {
    return hdrGoto;
  }

  public void setHdrGoto(String newHdrGoto)
  {
    hdrGoto = newHdrGoto;
  }

  public String getScreenInt()
  {
    return screenInt;
  }

  public void setScreenInt(String newScreenInt)
  {
    screenInt = newScreenInt;
  }

  public String[] getTxtLastYYMM()
  {
    return txtLastYYMM;
  }

  public void setTxtLastYYMM(String[] newTxtLastYYMM)
  {
    txtLastYYMM = newTxtLastYYMM;
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
  
  
  ////////////////////added by sonia on 09-02-2011////////////
  
  public String[] getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String[] newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }

 public String[] getTxtAgencyName()
  {
    return txtAgencyName;
  }

  public void setTxtAgencyName(String[] newTxtAgencyName)
  {
    txtAgencyName = newTxtAgencyName;
  }
  public String[] getTxtAgencyNo()
  {
    return txtAgencyNo;
  }

  public void setTxtAgencyNo(String[] newTxtAgencyNo)
  {
    txtAgencyNo = newTxtAgencyNo;
  }
  public String[] getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String[] newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }

  public String[] getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }

  public void setTxtAgencySiteCode(String[] newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  }
  ///////////////////end added by sonia on 09-02-2011//////////////////////
  
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