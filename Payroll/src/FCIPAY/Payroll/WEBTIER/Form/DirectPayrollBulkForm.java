package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class DirectPayrollBulkForm extends PayrollBaseForm 
{

  private String txtSrNo [] = null;
  private String txtEmpNo[] = null;
  private String txtName[] = null;
  private String txtSrlNo[] = null;
  private String txtDsgn[];
  private String txtCateg[];
  private String txtPresentPOP[];
  
  private String txtPayCode = null;
  private String txtDescription = null;
  
  private String payTxnHdrId = null;
  
  private String txtPayCode1 = null;
  private String txtPayCodeName = null;
  
  private String txtPayMode = null;
  private String txtPayType = null;
  private String txtNoofDays = null;
  private String txtValidUpto = null;
  private String txtValidFrom = null;
  private String txtAmount = null;  
  private String hdnCheck = null;  
  private String txtInstAmount = null;
  private String txtNoInst = null;
  private String txtAgencyName = null;
  private String txtAdvBalance = null;
  private String txtTxnCateg = null;
  private String txtAgency = null;
  private String txtAgencySite = null;
  private String txtAgencySiteCode = null;
  private String hdnPayCodeSrlNo;
  private String txtPayrollFlag;
  private String txtDepoCode;  // Added by dushaynt on 20-Aug-2013
  private String txtGangId;    // Added by dushaynt on 20-Aug-2013
  private String txtDepoName;   // Added by dushaynt on 20-Aug-2013
  private String txtGangName;    // Added by dushaynt on 20-Aug-2013
  
  private ArrayList lstInstrDtls = new ArrayList();
  
  private long txtTest = 0;
  private String Action;
  private String action = "";  
  private String optPayScaleType;  
  private String OptVal;    
  private String sMaritalStatus;   
  private String formMode;  
  private String actionName;  
  private String screenModeDir;  
  
  
  private String txtEmpNo1 = null;
  private String txtName1= null;
  
  private String hdnCurYYMM;
  private String hdnPayStatus;
  private String hdnAction;
  private String hdnRowVal;  
  private String hdnEmpNo;
  private String hdnEmpName;
  private String hdnPayCode;
  private String hdnPayCodeName;
  
  

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

 public String [] getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String [] newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String [] getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String [] newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String [] getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String [] newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }
  
  public String getPayTxnHdrId()
  {
    return payTxnHdrId;
  }

  public void setPayTxnHdrId(String newPayTxnHdrId)
  {
    payTxnHdrId = newPayTxnHdrId;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }
  
   public String getTxtPayType()
  {
    return txtPayType;
  }

  public void setTxtPayType(String newTxtPayType)
  {
    txtPayType = newTxtPayType;
  }
  
   public String getTxtNoofDays()
  {
    return txtNoofDays;
  }

  public void setTxtNoofDays(String newTxtNoofDays)
  {
    txtNoofDays = newTxtNoofDays;
  }

  public String getTxtValidUpto()
  {
    return txtValidUpto;
  }

  public void setTxtValidUpto(String newTxtValidUpto)
  {
    txtValidUpto = newTxtValidUpto;
  }

  public String getTxtValidFrom()
  {
    return txtValidFrom;
  }

  public void setTxtValidFrom(String newTxtValidFrom)
  {
    txtValidFrom = newTxtValidFrom;
  }
  

  public String getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String newTxtAmount)
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

   public String getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String newHdnCheck)
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

  public String getHdnPayCodeSrlNo()
  {
    return hdnPayCodeSrlNo;
  }

  public void setHdnPayCodeSrlNo(String newHdnPayCodeSrlNo)
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

  public String getTxtInstAmount()
  {
    return txtInstAmount;
  }

  public void setTxtInstAmount(String newTxtInstAmount)
  {
    txtInstAmount = newTxtInstAmount;
  }

  public String getTxtNoInst()
  {
    return txtNoInst;
  }

  public void setTxtNoInst(String newTxtNoInst)
  {
    txtNoInst = newTxtNoInst;
  }

  public String getTxtAgencyName()
  {
    return txtAgencyName;
  }

  public void setTxtAgencyName(String newTxtAgencyName)
  {
    txtAgencyName = newTxtAgencyName;
  }

  public String getScreenModeDir()
  {
    return screenModeDir;
  }

  public void setScreenModeDir(String newScreenModeDir)
  {
    screenModeDir = newScreenModeDir;
  }

  public String getTxtPayrollFlag()
  {
    return txtPayrollFlag;
  }

  public void setTxtPayrollFlag(String newTxtPayrollFlag)
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

  public String getTxtAdvBalance()
  {
    return txtAdvBalance;
  }

  public void setTxtAdvBalance(String newTxtAdvBalance)
  {
    txtAdvBalance = newTxtAdvBalance;
  }

  public String getTxtTxnCateg()
  {
    return txtTxnCateg;
  }

  public void setTxtTxnCateg(String newTxtTxnCateg)
  {
    txtTxnCateg = newTxtTxnCateg;
  }

  public String getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }

  public String getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }

  public String getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }

  public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  }
// Added by dushaynt on 20-Aug-2013
   public String getTxtDepoCode()
  {
    return txtDepoCode;
  }

  public void setTxtDepoCode(String newTxtDepoCode)
  {
    txtDepoCode = newTxtDepoCode;
  }

 public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }

 public String getTxtDepoName()
  {
    return txtDepoName;
  }

  public void setTxtDepoName(String newTxtDepoName)
  {
    txtDepoName = newTxtDepoName;
  }
  
   public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
  }
// end by dushaynt
 
    
}