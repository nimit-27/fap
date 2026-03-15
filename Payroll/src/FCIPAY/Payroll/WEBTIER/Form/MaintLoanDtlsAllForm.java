package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintLoanDtlsAllForm extends PayrollBaseForm
{
  private String loanType;
  private String loanDesc;
  private String loanAmnt;
  private String sanctionDate;
  private String sanctionNo;
  private String recStartDate;
  private String noofPrnInstall;
  private String noofIntInstall;
  private String installAmnt;
  private String firstInstallAmnt;
  private String intInstallAmnt;
  private String intAmnt;
  private String txtIntRate;
  
  private String loanFlag;
  private String hdnAction;
  
  private String txtEmpNo[];
  private String txtEmpName[];
  private String txtDsgn[];
  private String txtCateg[];
  private String txtPresentPOP[];
  private ArrayList lstInstrDtls= new ArrayList();
  private String screenModeloan;
  private String screenModeloan1;
  private String screenModeloan2;
  private String screenModeFlag;
  private String flag;
  private String txtEmpList;
  private String txtLocId;
  private String txtLoc;
  private String txtGangName;
  private String txtGangId;
  private String txtType;
  private String txtMou;
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
  /*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }*/

public String getLoanType()
  {
    return loanType;
  }

  public void setLoanType(String newLoanType)
  {
    loanType = newLoanType;
  }
  
  public String getLoanDesc()
  {
    return loanDesc;
  }

  public void setLoanDesc(String newLoanDesc)
  {
    loanDesc = newLoanDesc;
  }
  
  public String getLoanAmnt()
  {
    return loanAmnt;
  }

  public void setLoanAmnt(String newLoanAmnt)
  {
    loanAmnt = newLoanAmnt;
  }

  public String getSanctionDate()
  {
    return sanctionDate;
  }

  public void setSanctionDate(String newSanctionDate)
  {
    sanctionDate = newSanctionDate;
  }
  
  public String getSanctionNo()
  {
    return sanctionNo;
  }

  public void setSanctionNo(String newSanctionNo)
  {
    sanctionNo = newSanctionNo;
  }

  public String getRecStartDate()
  {
    return recStartDate;
  }

  public void setRecStartDate(String newRecStartDate)
  {
    recStartDate = newRecStartDate;
  }
  
  public String getNoofPrnInstall()
  {
    return noofPrnInstall;
  }

  public void setNoofPrnInstall(String newNoofPrnInstall)
  {
    noofPrnInstall = newNoofPrnInstall;
  }

  public String getNoofIntInstall()
  {
    return noofIntInstall;
  }

  public void setNoofIntInstall(String newNoofIntInstall)
  {
    noofIntInstall = newNoofIntInstall;
  }

  public String getInstallAmnt()
  {
    return installAmnt;
  }

  public void setInstallAmnt(String newInstallAmnt)
  {
    installAmnt = newInstallAmnt;
  }
  
  public String getFirstInstallAmnt()
  {
    return firstInstallAmnt;
  }

  public void setFirstInstallAmnt(String newFirstInstallAmnt)
  {
    firstInstallAmnt = newFirstInstallAmnt;
  }
  
   public String getIntInstallAmnt()
  {
    return intInstallAmnt;
  }

  public void setIntInstallAmnt(String newIntInstallAmnt)
  {
    intInstallAmnt = newIntInstallAmnt;
  }

  public String getTxtIntRate()
  {
    return txtIntRate;
  }

  public void setTxtIntRate(String newTxtIntRate)
  {
    txtIntRate = newTxtIntRate;
  }
  
  public String getLoanFlag()
  {
    return loanFlag;
  }

  public void setLoanFlag(String newLoanFlag)
  {
    loanFlag = newLoanFlag;
  }  


  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }  

  public String [] getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String [] newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  
  public String [] getTxtEmpName()
  {
    return txtEmpName;
  }
  
  public void setTxtEmpName(String [] newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
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
  
  

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
  public String getScreenModeloan()
  {
    return screenModeloan;
  }

  public void setScreenModeloan(String newScreenModeloan)
  {
    screenModeloan = newScreenModeloan;
  } 
  public String getScreenModeloan1()
  {
    return screenModeloan1;
  }

  public void setScreenModeloan1(String newScreenModeloan1)
  {
    screenModeloan1 = newScreenModeloan1;
  } 
  
  public String getScreenModeloan2()
  {
    return screenModeloan2;
  }

  public void setScreenModeloan2(String newScreenModeloan2)
  {
    screenModeloan2 = newScreenModeloan2;
  } 
  
  public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  } 
  
  public String getFlag()
  {
    return flag;
  }

  public void setFlag(String newFlag)
  {
    flag = newFlag;
  } 

  public String getIntAmnt()
  {
    return intAmnt;
  }

  public void setIntAmnt(String newIntAmnt)
  {
    intAmnt = newIntAmnt;
  } 
  
   public String getTxtEmpList()
    {
      return txtEmpList;
    }
    
    public void setTxtEmpList(String newTxtEmpList)
    {
      txtEmpList=newTxtEmpList;
    }
    
    public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }
  
  public String getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String newTxtLoc)
  {
    txtLoc = newTxtLoc;
  }
  
   public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
  }
  
  public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }
  
  public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  }

  public String getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String newTxtType)
  {
    txtType = newTxtType;
  }
}