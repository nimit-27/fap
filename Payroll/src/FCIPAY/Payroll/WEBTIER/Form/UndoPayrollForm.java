package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class UndoPayrollForm extends PayrollBaseForm 
{

  private boolean chkLeave= true;
  private boolean chkLoan= true;
  private boolean chkSavings= true;
  private boolean chkAdvance= true;
  private boolean chkElecConsmp= true;
  private boolean chkMonthPayroll = true;
  private boolean chkKotIncentive= true;
  private boolean optEmp;
  private String txtEmpName;
  private String txtEmpNum = "";
  private String optAll;
  private String deFlag;
  private boolean chkPFAdvance = true;

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

  public boolean isChkLeave()
  {
    return chkLeave;
  }

  public void setChkLeave(boolean newChkLeave)
  {
    chkLeave = newChkLeave;
  }

  public boolean isChkLoan()
  {
    return chkLoan;
  }

  public void setChkLoan(boolean newChkLoan)
  {
    chkLoan = newChkLoan;
  }

  public boolean isChkSavings()
  {
    return chkSavings;
  }

  public void setChkSavings(boolean newChkSavings)
  {
    chkSavings = newChkSavings;
  }

  public boolean isChkAdvance()
  {
    return chkAdvance;
  }

  public void setChkAdvance(boolean newChkAdvance)
  {
    chkAdvance = newChkAdvance;
  }

  public boolean isChkElecConsmp()
  {
    return chkElecConsmp;
  }

  public void setChkElecConsmp(boolean newChkElecConsmp)
  {
    chkElecConsmp = newChkElecConsmp;
  }

  public boolean isChkMonthPayroll()
  {
    return chkMonthPayroll;
  }

  public void setChkMonthPayroll(boolean newChkMonthPayroll)
  {
    chkMonthPayroll = newChkMonthPayroll;
  }



  public boolean isOptEmp()
  {
    return optEmp;
  }

  public void setOptEmp(boolean newOptEmp)
  {
    optEmp = newOptEmp;
  }



  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtEmpNum()
  {
    return txtEmpNum;
  }

  public void setTxtEmpNum(String newTxtEmpNum)
  {
    txtEmpNum = newTxtEmpNum;
  }

  public String getOptAll()
  {
    return optAll;
  }

  public void setOptAll(String newOptAll)
  {
    optAll = newOptAll;
  }

  public String getDeFlag()
  {
    return deFlag;
  }

  public void setDeFlag(String newDeFlag)
  {
    deFlag = newDeFlag;
  }

  public boolean isChkPFAdvance()
  {
    return chkPFAdvance;
  }

  public void setChkPFAdvance(boolean newChkPFAdvance)
  {
    chkPFAdvance = newChkPFAdvance;
  }
  public boolean isChkKotIncentive()
  {
    return chkKotIncentive;
  }

  public void setChkKotIncentive(boolean newChkKotIncentive)
  {
    chkKotIncentive = newChkKotIncentive;
  }


}
