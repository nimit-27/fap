package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintainDirectPayrollForm extends PayrollBaseForm 
{

  private String txtSrNo[] = null;
  private String txtEmpNo[] = null;
  private String txtName[] = null;
  private String txtPayCode[] = null;
  private String txtDescription[]=null;
  private String txtPayMode[]=null;
  private String txtValidUpto[]=null;
  private String txtValidFrom[]=null;
  private String txtAmount[]=null;
  private long txtTest = 0;
  private String Action;
  private String action = "";  
  private String optPayScaleType;
  private String txtPayCode1 = null;
  private String txtPayCodeName = null;
  private String txtEmpNo1 = null;
  private String OptVal;  
  private String txtName1= null;
  private String sMaritalStatus;  
  private String txtCategory1 = null;// added by sonia on 3 feb
  private String txtCPF1=null;// added by sonia on 3 feb
   private String txtPattern1=null;// added by sonia on 3 feb
  private String txtEmpStatus1=null;// added by sonia on 8 July
   
  private String hdnCheck[] = null;
  private ArrayList lstInstrDtls = new ArrayList();
  //private String txtCPFCode[] = null;


  private String hdnPayCodeSrlNo[];
  private String formMode;
  private String txtSrlNo[] = null;
  private String actionName;
  private String txtInstAmount[]=null;
  private String txtNoInst[]=null;
  private String txtAgency[]=null;
  private String screenModeDir;
  private String txtPayrollFlag[];
  private String hdnCurYYMM;
  private String hdnPayStatus; 
  private String hdnAction;
  private String hdnRowVal;
  private String hdnEmpNo;
  private String hdnEmpName;
  private String hdnPayCode;
  private String hdnPayCodeName;
  private String txtAdvBalance[]=null;
  private String txtTxnCateg[]=null;
  private String txtAgencyName[]=null;
  private String  txtAgencyNo[]=null;
  private String txtAgencySite[]=null;
  private String txtAgencySiteCode[]=null;
  private String txtCreationDate[]=null; //added by neeraj
  private String txtCreatedBy[]=null; //added by neeraj
  private String txtCreatedSite[]=null; //added by neeraj
  private String txtUpdationDate[]=null; //added by neeraj
  private String txtUpdatedBy[]=null; //added by neeraj
  private String txtUpdatedSite[]=null; //added by neeraj
  private String txtCategory[] = null; // added by sonia on 02-02-2011
   private String txtPattern[] = null; // added by sonia on 02-02-2011
   private String txtCPF[] = null; // added by sonia on 02-02-2011
  private String txtEmpStatus[] = null; // added by sonia on 07-07-2011
  private String txtSavNo[]; //added by swapnendu Dt 04 Feb 2013

  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }


   public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
        this.txtTest = 0;
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

  

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
//added by neeraj starts here//

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

//added by neeraj ends here//

  public String[] getTxtSrNo()
  {
    return txtSrNo;
  }

  public void setTxtSrNo(String[] newTxtSrNo)
  {
    txtSrNo = newTxtSrNo;
  }

  public String[] getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String[] newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String[] getTxtName()
  {
    return txtName;
  }

  public void setTxtName(String[] newTxtName)
  {
    txtName = newTxtName;
  }

 
  public String[] getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String[] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String[] getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String[] newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

  public String[] getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String[] newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String[] getTxtValidUpto()
  {
    return txtValidUpto;
  }

  public void setTxtValidUpto(String[] newTxtValidUpto)
  {
    txtValidUpto = newTxtValidUpto;
  }

  public String[] getTxtValidFrom()
  {
    return txtValidFrom;
  }

  public void setTxtValidFrom(String[] newTxtValidFrom)
  {
    txtValidFrom = newTxtValidFrom;
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
    return Action;
  }

  public void setAction(String newAction)
  {
    Action = newAction;
  }

  public String getOptPayScaleType()
  {
    return optPayScaleType;
  }

  public void setOptPayScaleType(String newOptPayScaleType)
  {
    optPayScaleType = newOptPayScaleType;
  }

  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String  newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }

  public String getTxtPayCodeName()
  {
    return txtPayCodeName;
  }

  public void setTxtPayCodeName(String newTxtPayCodeName)
  {
    txtPayCodeName = newTxtPayCodeName;
  }

  public String getTxtEmpNo1()
  {
    return txtEmpNo1;
  }

  public void setTxtEmpNo1(String newTxtEmpNo1)
  {
    txtEmpNo1 = newTxtEmpNo1;
  }

  public String getTxtName1()
  {
    return txtName1;
  }

  public void setTxtName1(String newTxtName1)
  {
    txtName1 = newTxtName1;
  }

  
    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

   public String[] getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }  

 /* public void setVO()
  {       
     fedoVO.setTxtEmpNo1(this.txtEmpNo1); 
     fedoVO.setTxtName1(this.txtName1);
     fedoVO.setTxtPayCode1(this.txtPayCode1);
     fedoVO.setTxtPayCodeName(this.txtPayCodeName);     
     fedoVO.setLstInstrDtls(this.lstInstrDtls);  
  }*/

  public String getOptVal()
  {
    return OptVal;
  }

  public void setOptVal(String newOptVal)
  {
    OptVal = newOptVal;
  }
    
    public String getsMaritalStatus()
    {
        return sMaritalStatus;
    }

    public void setsMaritalStatus(String newsMaritalStatus)
    {
        sMaritalStatus = newsMaritalStatus;
    }    

  public String[] getHdnPayCodeSrlNo()
  {
    return hdnPayCodeSrlNo;
  }

  public void setHdnPayCodeSrlNo(String[] newHdnPayCodeSrlNo)
  {
    hdnPayCodeSrlNo = newHdnPayCodeSrlNo;
  }

  public String getFormMode()
  {
    return formMode;
  }

  public void setFormMode(String newFormMode)
  {
    formMode = newFormMode;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getActionName()
  {
    return actionName;
  }

  public void setActionName(String newActionName)
  {
    actionName = newActionName;
  }

  public String[] getTxtInstAmount()
  {
    return txtInstAmount;
  }

  public void setTxtInstAmount(String[] newTxtInstAmount)
  {
    txtInstAmount = newTxtInstAmount;
  }

  public String[] getTxtNoInst()
  {
    return txtNoInst;
  }

  public void setTxtNoInst(String[] newTxtNoInst)
  {
    txtNoInst = newTxtNoInst;
  }

  public String[] getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String[] newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }

  public String getScreenModeDir()
  {
    return screenModeDir;
  }

  public void setScreenModeDir(String newScreenModeDir)
  {
    screenModeDir = newScreenModeDir;
  }

  public String[] getTxtPayrollFlag()
  {
    return txtPayrollFlag;
  }

  public void setTxtPayrollFlag(String[] newTxtPayrollFlag)
  {
    txtPayrollFlag = newTxtPayrollFlag;
  }

  public String getHdnCurYYMM()
  {
    return hdnCurYYMM;
  }

  public void setHdnCurYYMM(String newHdnCurYYMM)
  {
    hdnCurYYMM = newHdnCurYYMM;
  }

  public String getHdnPayStatus()
  {
    return hdnPayStatus;
  }

  public void setHdnPayStatus(String newHdnPayStatus)
  {
    hdnPayStatus = newHdnPayStatus;
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

  public String[] getTxtAdvBalance()
  {
    return txtAdvBalance;
  }

  public void setTxtAdvBalance(String[] newTxtAdvBalance)
  {
    txtAdvBalance = newTxtAdvBalance;
  }

  public String[] getTxtTxnCateg()
  {
    return txtTxnCateg;
  }

  public void setTxtTxnCateg(String[] newTxtTxnCateg)
  {
    txtTxnCateg = newTxtTxnCateg;
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
//////////////////added by sonia on 02-02-2011//////////////
  public void setTxtCategory(String[] newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }

  public String[] getTxtCategory()
  {
    return txtCategory;
  }

public void setTxtPattern(String[] newTxtPattern)
  {
    txtPattern = newTxtPattern;
  }

  public String[] getTxtPattern()
  {
    return txtPattern;
  }

  public String getTxtCategory1()
  {
    return txtCategory1;
  }

  public void setTxtCategory1(String newTxtCategory1)
  {
    txtCategory1 = newTxtCategory1;
  }

  public String getTxtCPF1()
  {
    return txtCPF1;
  }

  public void setTxtCPF1(String newTxtCPF1)
  {
    txtCPF1 = newTxtCPF1;
  }

    public String getTxtPattern1()
  {
    return txtPattern1;
  }

  public void setTxtPattern1(String newTxtPattern1)
  {
    txtPattern1 = newTxtPattern1;
  }
  
  public void setTxtEmpStatus1(String newTxtEmpStatus1)
  {
    txtEmpStatus1 = newTxtEmpStatus1;
  }
  
    public String getTxtEmpStatus1()
  {
    return txtEmpStatus1;
  }
  
  public void setTxtSavNo(String[] newTxtSavNo)
  {
    txtSavNo = newTxtSavNo;
  }
  
  public String[] getTxtSavNo()
  {
    return txtSavNo;
  }
  
  public void setTxtEmpStatus(String[] newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }

  public String[] getTxtEmpStatus()
  {
    return txtEmpStatus;
  }
  
  public void setTxtCPF(String[] newTxtCPF)
  {
    txtCPF = newTxtCPF;
  }

  public String[] getTxtCPF()
  {
    return txtCPF;
  }

  //////////////////end added by sonia on 02-02-2011//////////////

}